package com.tencent.mobileqq.msf.core.net.a;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.k;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class e
  extends Thread
{
  private static final String a = "ReqAllFailSocket";
  private static final int b = 10000;
  private Socket c;
  private OutputStream d;
  private InputStream e;
  private AtomicBoolean f = new AtomicBoolean(false);
  private AtomicBoolean g = new AtomicBoolean(false);
  private d h;
  private k i = new k(1000);
  private boolean j = false;
  private boolean k = false;
  private String l = "";
  private MsfCore m;
  private int n;
  
  public e(MsfCore paramMsfCore, d paramd, int paramInt)
  {
    this.m = paramMsfCore;
    this.h = paramd;
    this.n = paramInt;
  }
  
  private int a(String paramString, MsfCommand paramMsfCommand, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramMsfCommand == MsfCommand.openConn) {}
    for (;;)
    {
      return paramArrayOfByte.length;
      try
      {
        this.d.write(paramArrayOfByte);
        this.d.flush();
        QLog.d("ReqAllFailSocket", 1, this.n + " send " + paramString);
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        d();
      }
    }
  }
  
  private boolean c()
  {
    InetSocketAddress localInetSocketAddress = new InetSocketAddress(this.h.c(), this.h.d());
    try
    {
      this.c = new Socket();
      this.c.setTcpNoDelay(true);
      this.c.setKeepAlive(true);
      this.c.connect(localInetSocketAddress, this.h.e());
      this.d = this.c.getOutputStream();
      this.e = this.c.getInputStream();
      this.f.set(true);
      QLog.d("ReqAllFailSocket", 1, this.n + " conn " + this.h.c() + ":" + this.h.d() + " succ");
      return true;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.l = "connFail";
      QLog.d("ReqAllFailSocket", 1, this.n + " conn " + this.h.c() + ":" + this.h.d() + " fail");
    }
    return false;
  }
  
  private void d()
  {
    QLog.d("ReqAllFailSocket", 1, this.n + " closeConn");
    if (this.c != null) {}
    try
    {
      this.c.close();
      this.c = null;
      localAtomicBoolean1 = this.f;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AtomicBoolean localAtomicBoolean1;
        localException.printStackTrace();
        this.c = null;
        AtomicBoolean localAtomicBoolean2 = this.f;
      }
    }
    finally
    {
      this.c = null;
      this.f.set(false);
    }
    localAtomicBoolean1.set(false);
  }
  
  private void e()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
    localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
    localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    localToServiceMsg.setAppId(this.m.getMsfAppid());
    localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
    a(localToServiceMsg);
  }
  
  private void f()
  {
    int i1 = "MSF".getBytes().length + 13 + 1 + 0 + 4;
    byte b1 = (byte)"MSF".getBytes().length;
    Object localObject = ByteBuffer.allocate(i1);
    ((ByteBuffer)localObject).putInt(i1).putInt(20140601).putInt(0).put(b1).put("MSF".getBytes()).put((byte)0).putInt(0);
    localObject = ((ByteBuffer)localObject).array();
    try
    {
      a("MSF", MsfCommand.msf_ssoping, (byte[])localObject);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void a()
  {
    d();
    this.g.set(true);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      this.i.add(paramToServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      QLog.d("ReqAllFailSocket", 1, "addSendQueu fail,", paramToServiceMsg);
    }
  }
  
  public String b()
  {
    return this.h.c() + "|" + this.h.d() + "|" + this.j + "|" + this.k + "|" + this.l;
  }
  
  public void run()
  {
    if (c())
    {
      new b(null).start();
      new a(null).start();
      f();
      e();
    }
  }
  
  private class a
    extends Thread
  {
    private a() {}
    
    public void run()
    {
      for (;;)
      {
        int j;
        try
        {
          DataInputStream localDataInputStream = new DataInputStream(e.e(e.this));
          i = 0;
          if ((e.c(e.this).get()) || (!e.a(e.this).get()))
          {
            if (i > 0) {
              break label181;
            }
            j = localDataInputStream.readInt() - 4;
            if (j <= 33)
            {
              e.a(e.this, true);
              QLog.d("ReqAllFailSocket", 1, e.f(e.this) + " recv sso ping");
              i = j;
            }
          }
          else
          {
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          e.a(e.this, "readError");
          e.d(e.this);
        }
        int i = j;
        if (j == 62)
        {
          e.b(e.this, true);
          QLog.d("ReqAllFailSocket", 1, e.f(e.this) + " recv heartbeat ping");
          i = j;
          continue;
          label181:
          localThrowable.readByte();
          i -= 1;
        }
      }
    }
  }
  
  private class b
    extends Thread
  {
    private b() {}
    
    public void run()
    {
      while (!e.a(e.this).get()) {
        try
        {
          ToServiceMsg localToServiceMsg = (ToServiceMsg)e.b(e.this).k();
          Object localObject = localToServiceMsg.getServiceCmd();
          localObject = CodecWarpper.encodeRequest(localToServiceMsg.getRequestSsoSeq(), l.d(), l.f(), l.g(), "", (String)localObject, null, localToServiceMsg.getAppId(), 0, localToServiceMsg.getUin(), (byte)0, (byte)0, localToServiceMsg.getWupBuffer(), true);
          if (e.c(e.this).get()) {
            e.a(e.this, localToServiceMsg.getServiceCmd(), localToServiceMsg.getMsfCommand(), (byte[])localObject);
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          e.d(e.this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.e
 * JD-Core Version:    0.7.0.1
 */