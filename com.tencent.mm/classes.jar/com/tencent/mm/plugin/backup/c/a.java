package com.tencent.mm.plugin.backup.c;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.lan_cs.Client.Java2C;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.lan_cs.Server.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class a
  implements b.a
{
  public static final byte[] jzh;
  private String jzi;
  private int jzj;
  public ak jzk = null;
  public a.a jzl;
  private int mode = 0;
  
  static
  {
    AppMethodBeat.i(17166);
    jzh = "GSMW".getBytes();
    AppMethodBeat.o(17166);
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17163);
    al.d(new a.5(this, paramBoolean, paramInt1, paramInt2, paramArrayOfByte));
    AppMethodBeat.o(17163);
  }
  
  public final boolean a(PString paramPString, PInt paramPInt)
  {
    AppMethodBeat.i(17158);
    this.mode = 0;
    ab.i("MicroMsg.BackupCEngine", "listen, before server.stop");
    Server.Java2C.stop();
    ab.i("MicroMsg.BackupCEngine", "listen, before server.start listener");
    com.tencent.mm.lan_cs.Server.eMv = new Server.a()
    {
      public final void ST()
      {
        AppMethodBeat.i(17151);
        a.a(a.this, 10011, "listen server onDisconnect".getBytes());
        AppMethodBeat.o(17151);
      }
      
      public final void jT(int paramAnonymousInt)
      {
        AppMethodBeat.i(17149);
        if (a.a(a.this) == 1) {
          b.rw(paramAnonymousInt);
        }
        AppMethodBeat.o(17149);
      }
      
      public final void onConnect(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(17152);
        a.a(a.this, paramAnonymousString);
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(17152);
      }
      
      public final void onRecv(String paramAnonymousString, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(17150);
        a.a(a.this, paramAnonymousString);
        a.a(a.this, paramAnonymousInt);
        try
        {
          a.a(a.this, paramAnonymousArrayOfByte);
          AppMethodBeat.o(17150);
          return;
        }
        catch (IOException paramAnonymousString)
        {
          a.a(a.this, 10006, ("server readErr:" + paramAnonymousString.toString()).getBytes());
          AppMethodBeat.o(17150);
        }
      }
    };
    Object[] arrayOfObject = Server.Java2C.access$000();
    if ((arrayOfObject == null) || (arrayOfObject.length != 3))
    {
      ab.e("MicroMsg.BackupCEngine", "listen error");
      AppMethodBeat.o(17158);
      return false;
    }
    ab.i("MicroMsg.BackupCEngine", "listen, result[%d, %s, %d]", new Object[] { arrayOfObject[0], arrayOfObject[1], arrayOfObject[2] });
    if (((Integer)arrayOfObject[0]).intValue() != 1)
    {
      AppMethodBeat.o(17158);
      return false;
    }
    paramPString.value = ((String)arrayOfObject[1]);
    paramPInt.value = ((Integer)arrayOfObject[2]).intValue();
    this.mode = 1;
    AppMethodBeat.o(17158);
    return true;
  }
  
  public final void connect(String paramString, int paramInt)
  {
    AppMethodBeat.i(17159);
    this.mode = 2;
    this.jzi = paramString;
    this.jzj = paramInt;
    com.tencent.mm.lan_cs.Client.eMu = new a.2(this);
    AppMethodBeat.o(17159);
  }
  
  public final void j(final int paramInt, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17161);
    final long l = bo.aoy();
    ab.v("MicroMsg.BackupCEngine", "send seq:%d buff:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(bo.cf(paramArrayOfByte)) });
    if ((this.jzk == null) || (!this.jzk.getLooper().getThread().isAlive()))
    {
      HandlerThread localHandlerThread = d.aqu("BackupCEngine_sendHandler");
      localHandlerThread.setPriority(10);
      localHandlerThread.start();
      this.jzk = new ak(localHandlerThread.getLooper());
      ab.w("MicroMsg.BackupCEngine", "BackupCEngine send, new writerHandler:%d", new Object[] { Long.valueOf(localHandlerThread.getId()) });
    }
    this.jzk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17156);
        long l = bo.aoy();
        ab.i("MicroMsg.BackupCEngine", "before send server mode:%d  seq:%d  buff:%d time:[%d]", new Object[] { Integer.valueOf(a.a(a.this)), Integer.valueOf(paramInt), Integer.valueOf(bo.cf(paramArrayOfByte)), Long.valueOf(l - l) });
        if (a.a(a.this) == 0)
        {
          ab.i("MicroMsg.BackupCEngine", "sendImp err mode!!");
          AppMethodBeat.o(17156);
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
          b.rw(bo.cf(paramArrayOfByte));
          ab.i("MicroMsg.BackupCEngine", "send result[%d], seq[%d], buff[%d], time[%d,%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(bo.cf(paramArrayOfByte)), Long.valueOf(bo.hl(l)), Long.valueOf(bo.hl(l)) });
          AppMethodBeat.o(17156);
          return;
          if (a.a(a.this) == 2) {
            i = Client.Java2C.send(a.b(a.this), a.c(a.this), paramArrayOfByte);
          } else {
            i = 0;
          }
        }
      }
    });
    AppMethodBeat.o(17161);
  }
  
  public final int k(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17162);
    long l = bo.aoy();
    int i;
    if (this.mode == 1) {
      i = Server.Java2C.send(this.jzi, this.jzj, paramArrayOfByte);
    }
    for (;;)
    {
      ab.i("MicroMsg.BackupCEngine", "sendSameThread, result[%d], seq[%d], buflen[%d], send time[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(bo.cf(paramArrayOfByte)), Long.valueOf(bo.hl(l)) });
      AppMethodBeat.o(17162);
      return i;
      if (this.mode == 2)
      {
        i = Client.Java2C.send(this.jzi, this.jzj, paramArrayOfByte);
        b.rw(bo.cf(paramArrayOfByte));
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(17160);
    ab.i("MicroMsg.BackupCEngine", "BackupCEngine stop.");
    if (this.mode == 1)
    {
      Server.Java2C.stop();
      b.aTE();
      this.mode = 0;
      AppMethodBeat.o(17160);
      return;
    }
    if (this.mode == 2)
    {
      Client.Java2C.disconnect();
      b.aTE();
      this.mode = 0;
      AppMethodBeat.o(17160);
      return;
    }
    AppMethodBeat.o(17160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.a
 * JD-Core Version:    0.7.0.1
 */