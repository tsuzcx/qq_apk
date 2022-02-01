package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.lan_cs.Client.Java2C;
import com.tencent.mm.lan_cs.Client.a;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.lan_cs.Server.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class a
  implements b.a
{
  public static final byte[] bTZ;
  private int mode = 0;
  private String peerIP;
  private int uWC;
  public MMHandler uWD = null;
  public a uWE;
  
  static
  {
    AppMethodBeat.i(21224);
    bTZ = "GSMW".getBytes();
    AppMethodBeat.o(21224);
  }
  
  private void a(final boolean paramBoolean, final int paramInt1, final int paramInt2, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21221);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21215);
        b.b(paramBoolean, paramInt1, paramInt2, paramArrayOfByte);
        AppMethodBeat.o(21215);
      }
    });
    AppMethodBeat.o(21221);
  }
  
  public final boolean a(PString paramPString, PInt paramPInt)
  {
    AppMethodBeat.i(21216);
    this.mode = 0;
    Log.i("MicroMsg.BackupCEngine", "listen, before server.stop");
    Server.Java2C.stop();
    Log.i("MicroMsg.BackupCEngine", "listen, before server.start listener");
    com.tencent.mm.lan_cs.Server.mHT = new Server.a()
    {
      public final void bbY()
      {
        AppMethodBeat.i(21209);
        a.a(a.this, 10011, "listen server onDisconnect".getBytes());
        AppMethodBeat.o(21209);
      }
      
      public final void onConnect(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(21210);
        a.a(a.this, paramAnonymousString);
        a.a(a.this, paramAnonymousInt);
        AppMethodBeat.o(21210);
      }
      
      public final void onRecv(String paramAnonymousString, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21208);
        a.a(a.this, paramAnonymousString);
        a.a(a.this, paramAnonymousInt);
        try
        {
          a.a(a.this, paramAnonymousArrayOfByte);
          AppMethodBeat.o(21208);
          return;
        }
        catch (IOException paramAnonymousString)
        {
          a.a(a.this, 10006, ("server readErr:" + paramAnonymousString.toString()).getBytes());
          AppMethodBeat.o(21208);
        }
      }
      
      public final void sJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(21207);
        if (a.a(a.this) == 1) {
          b.Fr(paramAnonymousInt);
        }
        AppMethodBeat.o(21207);
      }
    };
    Object[] arrayOfObject = Server.Java2C.access$000();
    if ((arrayOfObject == null) || (arrayOfObject.length != 3))
    {
      Log.e("MicroMsg.BackupCEngine", "listen error");
      AppMethodBeat.o(21216);
      return false;
    }
    Log.i("MicroMsg.BackupCEngine", "listen, result[%d, %s, %d]", new Object[] { arrayOfObject[0], arrayOfObject[1], arrayOfObject[2] });
    if (((Integer)arrayOfObject[0]).intValue() != 1)
    {
      AppMethodBeat.o(21216);
      return false;
    }
    paramPString.value = ((String)arrayOfObject[1]);
    paramPInt.value = ((Integer)arrayOfObject[2]).intValue();
    this.mode = 1;
    AppMethodBeat.o(21216);
    return true;
  }
  
  public final void ds(String paramString, int paramInt)
  {
    AppMethodBeat.i(21217);
    this.mode = 2;
    this.peerIP = paramString;
    this.uWC = paramInt;
    com.tencent.mm.lan_cs.Client.mHS = new Client.a()
    {
      public final void bbY()
      {
        AppMethodBeat.i(21212);
        a.a(a.this, 10011, "client onDisconnect".getBytes());
        AppMethodBeat.o(21212);
      }
      
      public final void onRecv(String paramAnonymousString, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(21211);
        a.a(a.this, paramAnonymousString);
        a.a(a.this, paramAnonymousInt);
        try
        {
          a.a(a.this, paramAnonymousArrayOfByte);
          AppMethodBeat.o(21211);
          return;
        }
        catch (IOException paramAnonymousString)
        {
          a.a(a.this, 10006, ("client readErr:" + paramAnonymousString.toString()).getBytes());
          AppMethodBeat.o(21211);
        }
      }
    };
    AppMethodBeat.o(21217);
  }
  
  public final void m(final int paramInt, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21219);
    final long l = Util.nowMilliSecond();
    Log.v("MicroMsg.BackupCEngine", "send seq:%d buff:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(Util.getLength(paramArrayOfByte)) });
    if ((this.uWD == null) || (this.uWD.isQuit()))
    {
      this.uWD = new MMHandler("BackupCEngine_sendHandler");
      Log.w("MicroMsg.BackupCEngine", "BackupCEngine send");
    }
    this.uWD.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21214);
        long l = Util.nowMilliSecond();
        Log.i("MicroMsg.BackupCEngine", "before send server mode:%d  seq:%d  buff:%d time:[%d]", new Object[] { Integer.valueOf(a.a(a.this)), Integer.valueOf(paramInt), Integer.valueOf(Util.getLength(paramArrayOfByte)), Long.valueOf(l - l) });
        if (a.a(a.this) == 0)
        {
          Log.i("MicroMsg.BackupCEngine", "sendImp err mode!!");
          AppMethodBeat.o(21214);
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
          b.Fr(Util.getLength(paramArrayOfByte));
          Log.i("MicroMsg.BackupCEngine", "send result[%d], seq[%d], buff[%d], time[%d,%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(Util.getLength(paramArrayOfByte)), Long.valueOf(Util.milliSecondsToNow(l)), Long.valueOf(Util.milliSecondsToNow(l)) });
          AppMethodBeat.o(21214);
          return;
          if (a.a(a.this) == 2) {
            i = Client.Java2C.send(a.b(a.this), a.c(a.this), paramArrayOfByte);
          } else {
            i = 0;
          }
        }
      }
    });
    AppMethodBeat.o(21219);
  }
  
  public final int n(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21220);
    long l = Util.nowMilliSecond();
    int i;
    if (this.mode == 1) {
      i = Server.Java2C.send(this.peerIP, this.uWC, paramArrayOfByte);
    }
    for (;;)
    {
      Log.i("MicroMsg.BackupCEngine", "sendSameThread, result[%d], seq[%d], buflen[%d], send time[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(Util.getLength(paramArrayOfByte)), Long.valueOf(Util.milliSecondsToNow(l)) });
      AppMethodBeat.o(21220);
      return i;
      if (this.mode == 2)
      {
        i = Client.Java2C.send(this.peerIP, this.uWC, paramArrayOfByte);
        b.Fr(Util.getLength(paramArrayOfByte));
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21218);
    Log.i("MicroMsg.BackupCEngine", "BackupCEngine stop.");
    if (this.mode == 1)
    {
      Server.Java2C.stop();
      b.cVF();
      this.mode = 0;
      AppMethodBeat.o(21218);
      return;
    }
    if (this.mode == 2)
    {
      Client.Java2C.disconnect();
      b.cVF();
      this.mode = 0;
      AppMethodBeat.o(21218);
      return;
    }
    AppMethodBeat.o(21218);
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.a
 * JD-Core Version:    0.7.0.1
 */