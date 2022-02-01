package com.tencent.mm.modelvoiceaddr.a;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.qq.wx.voice.vad.EVadNative;
import com.qq.wx.voice.vad.MMVoipVadNative;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Map;

public class c
{
  private static final String TAG;
  public static SharedPreferences sp;
  private MMHandler handler;
  private boolean isReleased;
  private short[] pgA;
  private boolean pgr;
  private int pgs;
  private boolean pgt;
  private boolean pgu;
  private long pgv;
  private int pgw;
  private a pgx;
  private com.qq.wx.voice.vad.a pgy;
  public a pgz;
  
  static
  {
    AppMethodBeat.i(148609);
    TAG = c.class.getSimpleName();
    sp = MMApplicationContext.getDefaultPreference();
    AppMethodBeat.o(148609);
  }
  
  public c(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(148606);
    this.pgr = true;
    this.pgs = 3;
    this.pgt = false;
    this.pgu = false;
    this.pgv = 0L;
    this.pgw = 3500;
    this.isReleased = false;
    this.handler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(148603);
        if (paramAnonymousMessage.what != 0)
        {
          AppMethodBeat.o(148603);
          return;
        }
        if (c.a(c.this) != null) {
          c.a(c.this).aEN();
        }
        AppMethodBeat.o(148603);
      }
    };
    this.pgx = null;
    this.pgy = null;
    this.pgw = paramInt1;
    this.pgy = new com.qq.wx.voice.vad.a();
    int j = 0;
    int i = j;
    Object localObject;
    if (MMApplicationContext.isMMProcess())
    {
      localObject = com.tencent.mm.model.newabtest.d.bEt().Fd("100235");
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((com.tencent.mm.storage.c)localObject).isValid()) {
          i = Util.getInt((String)((com.tencent.mm.storage.c)localObject).iWZ().get("MMVoipVadOn"), 0);
        }
      }
    }
    Log.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      com.qq.wx.voice.vad.a.cB(false);
      localObject = this.pgy;
      if (!com.qq.wx.voice.vad.a.dYX) {
        break label313;
      }
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).dYW.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
      label215:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Init handle = " + ((com.qq.wx.voice.vad.a)localObject).handle);
      }
      if (((com.qq.wx.voice.vad.a)localObject).handle != 0L) {
        break label338;
      }
      paramInt2 = 1;
      label259:
      if (paramInt2 != 1)
      {
        localObject = this.pgy;
        if (((com.qq.wx.voice.vad.a)localObject).handle != 0L) {
          break label343;
        }
        paramInt2 = 1;
      }
    }
    for (;;)
    {
      if (paramInt2 != 1) {
        break label415;
      }
      localObject = new b("Init ERROR");
      AppMethodBeat.o(148606);
      throw ((Throwable)localObject);
      com.qq.wx.voice.vad.a.cB(true);
      break;
      label313:
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).dYV.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
      break label215;
      label338:
      paramInt2 = 0;
      break label259;
      label343:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Reset handle = " + ((com.qq.wx.voice.vad.a)localObject).handle);
      }
      if (com.qq.wx.voice.vad.a.dYX) {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).dYW.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      } else {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).dYV.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      }
    }
    label415:
    this.pgx = new a(paramInt5 * 16);
    this.pgA = new short[4000];
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessageDelayed(0, paramInt1);
    this.pgt = paramBoolean1;
    this.pgu = paramBoolean2;
    AppMethodBeat.o(148606);
  }
  
  public c(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(3500, sp.getInt("sil_time", 1000), sp.getFloat("s_n_ration", 2.5F), sp.getInt("s_window", 500), sp.getInt("s_length", 350), sp.getInt("s_delay_time", 550), paramBoolean1, paramBoolean2);
    AppMethodBeat.i(148605);
    AppMethodBeat.o(148605);
  }
  
  public static String bPH()
  {
    AppMethodBeat.i(148604);
    String str = String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[] { "sil_time", Integer.valueOf(sp.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(sp.getFloat("s_n_ration", 2.5F)), "s_window", Integer.valueOf(sp.getInt("s_window", 500)), "s_length", Integer.valueOf(sp.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(sp.getInt("s_delay_time", 550)) });
    AppMethodBeat.o(148604);
    return str;
  }
  
  public final void f(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(148607);
    Log.d(TAG, "input() called with: voice = [%s], length = [%s]", new Object[] { paramArrayOfShort, Integer.valueOf(paramInt) });
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0) || (paramInt <= 0) || (paramInt > paramArrayOfShort.length))
    {
      AppMethodBeat.o(148607);
      return;
    }
    if (this.isReleased)
    {
      Log.i(TAG, "VoiceSilentDetectAPI is released.");
      AppMethodBeat.o(148607);
      return;
    }
    if (this.pgx == null)
    {
      Log.i(TAG, "input, circleBuffer is null.");
      AppMethodBeat.o(148607);
      return;
    }
    int n = this.pgy.b(paramArrayOfShort, paramInt);
    Log.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", new Object[] { Integer.valueOf(n), Integer.valueOf(this.pgs), Boolean.valueOf(this.pgt), Boolean.valueOf(this.pgu) });
    long l;
    int i;
    int k;
    if (this.pgt) {
      if (this.pgu)
      {
        l = System.currentTimeMillis();
        if (this.pgz != null) {
          this.pgz.bPC();
        }
        this.pgv = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.pgx.pgp;
        k = this.pgA.length;
        if (i > 0) {
          if (k <= i) {
            break label811;
          }
        }
      }
    }
    label804:
    label811:
    for (int j = i;; j = k)
    {
      this.pgx.d(this.pgA, j);
      int m = i - j;
      i = m;
      if (this.pgz == null) {
        break;
      }
      this.pgz.c(this.pgA, j);
      i = m;
      break;
      this.pgu = false;
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessageDelayed(0, this.pgw);
      for (;;)
      {
        this.pgr = false;
        this.pgs = n;
        if (!this.isReleased) {
          break;
        }
        AppMethodBeat.o(148607);
        return;
        if ((this.pgs == 3) && (n == 2)) {
          this.pgt = false;
        }
        if ((this.pgs != 3) || (n != 3))
        {
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.pgw);
        }
      }
      if ((this.pgs == 3) && (n == 2))
      {
        this.pgs = n;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.pgw);
        l = System.currentTimeMillis();
        if (this.pgz != null) {
          this.pgz.bPC();
        }
        this.pgv = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.pgx.pgp;
        k = this.pgA.length;
        label506:
        if (i > 0) {
          if (k <= i) {
            break label804;
          }
        }
      }
      for (j = i;; j = k)
      {
        this.pgx.d(this.pgA, j);
        m = i - j;
        i = m;
        if (this.pgz == null) {
          break label506;
        }
        this.pgz.c(this.pgA, j);
        i = m;
        break label506;
        this.pgr = false;
        break;
        if ((this.pgs == 2) && (n == 3))
        {
          this.pgs = n;
          this.pgr = true;
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.pgw);
          l = System.currentTimeMillis();
          if (this.pgz != null) {
            this.pgz.bPB();
          }
          this.pgv = l;
          if (!this.isReleased) {
            break;
          }
          AppMethodBeat.o(148607);
          return;
        }
        if ((this.pgs == 3) && (n == 3))
        {
          this.pgr = true;
          break;
        }
        if ((this.pgs != 2) || (n != 2)) {
          break;
        }
        this.pgr = false;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.pgw);
        break;
        this.pgx.e(paramArrayOfShort, paramInt);
        Log.d(TAG, "isSilent %s", new Object[] { Boolean.valueOf(this.pgr) });
        if (this.pgr)
        {
          AppMethodBeat.o(148607);
          return;
        }
        if (this.pgz != null) {
          this.pgz.c(paramArrayOfShort, paramInt);
        }
        AppMethodBeat.o(148607);
        return;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(148608);
    Log.d(TAG, "released");
    this.isReleased = true;
    this.pgt = false;
    this.pgu = false;
    if (this.pgy != null)
    {
      if (this.pgy.akp() == 1)
      {
        b localb = new b();
        AppMethodBeat.o(148608);
        throw localb;
      }
      this.pgy = null;
    }
    this.pgx = null;
    this.pgA = null;
    if (this.handler != null)
    {
      this.handler.removeMessages(0);
      this.handler = null;
    }
    this.pgz = null;
    AppMethodBeat.o(148608);
  }
  
  public static abstract interface a
  {
    public abstract void aEN();
    
    public abstract void bPB();
    
    public abstract void bPC();
    
    public abstract void c(short[] paramArrayOfShort, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.c
 * JD-Core Version:    0.7.0.1
 */