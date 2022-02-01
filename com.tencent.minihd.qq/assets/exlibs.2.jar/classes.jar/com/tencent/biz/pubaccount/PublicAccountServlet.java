package com.tencent.biz.pubaccount;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class PublicAccountServlet
  extends MSFServlet
{
  private static final String a = "PubAccountSvc.";
  private static final String c = "need_handler";
  private String b = "com.tencent.biz.pubaccount.PublicAccountServlet";
  
  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("need_handler", true);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length + 4);
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeInt(paramArrayOfByte.length + 4);
      localDataOutputStream.write(paramArrayOfByte);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      label76:
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramArrayOfByte.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException1)
      {
        break label76;
      }
    }
  }
  
  protected static byte[] b(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    DataInputStream localDataInputStream = new DataInputStream(localByteArrayInputStream);
    try
    {
      paramArrayOfByte = new byte[localDataInputStream.readInt() - 4];
      label72:
      return paramArrayOfByte;
    }
    catch (Exception localException1)
    {
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception localException5) {}
      localException1 = localException1;
      paramArrayOfByte = null;
      localException1.printStackTrace();
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception localException2)
      {
        return paramArrayOfByte;
      }
    }
    finally
    {
      try
      {
        localByteArrayInputStream.close();
        localDataInputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException3)
      {
        break label72;
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "onReceive");
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (byte[] arrayOfByte = b(paramFromServiceMsg.getWupBuffer());; arrayOfByte = null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putByteArray("data", arrayOfByte);
      if (paramIntent.getBooleanExtra("need_handler", false))
      {
        localObject = (PublicAccountHandler)((QQAppInterface)super.getAppRuntime()).a(10);
        if (localObject != null) {
          ((PublicAccountHandler)localObject).a(paramIntent, paramFromServiceMsg, arrayOfByte);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "onReceive exit");
        }
        return;
        super.notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject, null);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "onSend");
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramIntent = paramIntent.getStringExtra("cmd");
    if (paramIntent.equals("get_business_recommend")) {
      paramPacket.setSSOCommand("PubAccBusiRecSvc." + paramIntent);
    }
    for (;;)
    {
      paramPacket.putSendData(a(arrayOfByte));
      if (QLog.isColorLevel()) {
        QLog.d(this.b, 2, "onSend exit");
      }
      return;
      paramPacket.setSSOCommand("PubAccountSvc." + paramIntent);
      if ("get_follow_list".equals(paramIntent)) {
        paramPacket.autoResend = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountServlet
 * JD-Core Version:    0.7.0.1
 */