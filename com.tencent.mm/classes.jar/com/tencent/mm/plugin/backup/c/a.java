package com.tencent.mm.plugin.backup.c;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.lan_cs.Client.Java2C;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  implements b.a
{
  public static final byte[] hFK = "GSMW".getBytes();
  private String hFL;
  private int hFM;
  public ah hFN = null;
  public a.a hFO;
  public int mode = 0;
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    ai.d(new a.5(this, paramBoolean, paramInt1, paramInt2, paramArrayOfByte));
  }
  
  public final void connect(String paramString, int paramInt)
  {
    this.mode = 2;
    this.hFL = paramString;
    this.hFM = paramInt;
    com.tencent.mm.lan_cs.Client.dOH = new a.2(this);
  }
  
  public final void j(final int paramInt, final byte[] paramArrayOfByte)
  {
    final long l = bk.UY();
    y.v("MicroMsg.BackupCEngine", "send seq:%d buff:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(bk.bF(paramArrayOfByte)) });
    if ((this.hFN == null) || (!this.hFN.getLooper().getThread().isAlive()))
    {
      HandlerThread localHandlerThread = e.aap("BackupCEngine_sendHandler");
      localHandlerThread.setPriority(10);
      localHandlerThread.start();
      this.hFN = new ah(localHandlerThread.getLooper());
      y.w("MicroMsg.BackupCEngine", "BackupCEngine send, new writerHandler:%d", new Object[] { Long.valueOf(localHandlerThread.getId()) });
    }
    this.hFN.post(new Runnable()
    {
      public final void run()
      {
        long l = bk.UY();
        y.i("MicroMsg.BackupCEngine", "before send server mode:%d  seq:%d  buff:%d time:[%d]", new Object[] { Integer.valueOf(a.a(a.this)), Integer.valueOf(paramInt), Integer.valueOf(bk.bF(paramArrayOfByte)), Long.valueOf(l - l) });
        if (a.a(a.this) == 0)
        {
          y.i("MicroMsg.BackupCEngine", "sendImp err mode!!");
          return;
        }
        int i;
        if (a.a(a.this) == 1)
        {
          int j = Server.Java2C.send(a.b(a.this), a.c(a.this), paramArrayOfByte);
          i = j;
          if (j == 0) {}
        }
        for (;;)
        {
          b.nI(bk.bF(paramArrayOfByte));
          y.i("MicroMsg.BackupCEngine", "send result[%d], seq[%d], buff[%d], time[%d,%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(bk.bF(paramArrayOfByte)), Long.valueOf(bk.co(l)), Long.valueOf(bk.co(l)) });
          return;
          if (a.a(a.this) == 2) {
            i = Client.Java2C.send(a.b(a.this), a.c(a.this), paramArrayOfByte);
          } else {
            i = 0;
          }
        }
      }
    });
  }
  
  public final int k(int paramInt, byte[] paramArrayOfByte)
  {
    long l = bk.UY();
    int i;
    if (this.mode == 1) {
      i = Server.Java2C.send(this.hFL, this.hFM, paramArrayOfByte);
    }
    for (;;)
    {
      y.i("MicroMsg.BackupCEngine", "sendSameThread, result[%d], seq[%d], buflen[%d], send time[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(bk.bF(paramArrayOfByte)), Long.valueOf(bk.co(l)) });
      return i;
      if (this.mode == 2)
      {
        i = Client.Java2C.send(this.hFL, this.hFM, paramArrayOfByte);
        b.nI(bk.bF(paramArrayOfByte));
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void stop()
  {
    y.i("MicroMsg.BackupCEngine", "BackupCEngine stop.");
    if (this.mode == 1)
    {
      Server.Java2C.stop();
      b.auf();
      this.mode = 0;
    }
    while (this.mode != 2) {
      return;
    }
    Client.Java2C.disconnect();
    b.auf();
    this.mode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.a
 * JD-Core Version:    0.7.0.1
 */