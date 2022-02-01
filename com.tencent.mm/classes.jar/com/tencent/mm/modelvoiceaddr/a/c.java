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
  private boolean jxb;
  private int jxc;
  private boolean jxd;
  private boolean jxe;
  private long jxf;
  private int jxg;
  private a jxh;
  private com.qq.wx.voice.vad.a jxi;
  public a jxj;
  private short[] jxk;
  
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
    this.jxb = true;
    this.jxc = 3;
    this.jxd = false;
    this.jxe = false;
    this.jxf = 0L;
    this.jxg = 3500;
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
          c.a(c.this).Yh();
        }
        AppMethodBeat.o(148603);
      }
    };
    this.jxh = null;
    this.jxi = null;
    this.jxg = paramInt1;
    this.jxi = new com.qq.wx.voice.vad.a();
    int j = 0;
    int i = j;
    Object localObject;
    if (MMApplicationContext.isMMProcess())
    {
      localObject = com.tencent.mm.model.c.d.aXu().Fu("100235");
      i = j;
      if (((com.tencent.mm.storage.c)localObject).isValid()) {
        i = Util.getInt((String)((com.tencent.mm.storage.c)localObject).gzz().get("MMVoipVadOn"), 0);
      }
    }
    Log.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      com.qq.wx.voice.vad.a.bI(false);
      localObject = this.jxi;
      if (!com.qq.wx.voice.vad.a.cgx) {
        break label304;
      }
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).cgw.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
      label206:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Init handle = " + ((com.qq.wx.voice.vad.a)localObject).handle);
      }
      if (((com.qq.wx.voice.vad.a)localObject).handle != 0L) {
        break label329;
      }
      paramInt2 = 1;
      label250:
      if (paramInt2 != 1)
      {
        localObject = this.jxi;
        if (((com.qq.wx.voice.vad.a)localObject).handle != 0L) {
          break label334;
        }
        paramInt2 = 1;
      }
    }
    for (;;)
    {
      if (paramInt2 != 1) {
        break label406;
      }
      localObject = new b("Init ERROR");
      AppMethodBeat.o(148606);
      throw ((Throwable)localObject);
      com.qq.wx.voice.vad.a.bI(true);
      break;
      label304:
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).cgv.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
      break label206;
      label329:
      paramInt2 = 0;
      break label250;
      label334:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Reset handle = " + ((com.qq.wx.voice.vad.a)localObject).handle);
      }
      if (com.qq.wx.voice.vad.a.cgx) {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).cgw.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      } else {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).cgv.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      }
    }
    label406:
    this.jxh = new a(paramInt5 * 16);
    this.jxk = new short[4000];
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessageDelayed(0, paramInt1);
    this.jxd = paramBoolean1;
    this.jxe = paramBoolean2;
    AppMethodBeat.o(148606);
  }
  
  public c(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(3500, sp.getInt("sil_time", 1000), sp.getFloat("s_n_ration", 2.5F), sp.getInt("s_window", 500), sp.getInt("s_length", 350), sp.getInt("s_delay_time", 550), paramBoolean1, paramBoolean2);
    AppMethodBeat.i(148605);
    AppMethodBeat.o(148605);
  }
  
  public static String biD()
  {
    AppMethodBeat.i(148604);
    String str = String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[] { "sil_time", Integer.valueOf(sp.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(sp.getFloat("s_n_ration", 2.5F)), "s_window", Integer.valueOf(sp.getInt("s_window", 500)), "s_length", Integer.valueOf(sp.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(sp.getInt("s_delay_time", 550)) });
    AppMethodBeat.o(148604);
    return str;
  }
  
  public final void e(short[] paramArrayOfShort, int paramInt)
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
    if (this.jxh == null)
    {
      Log.i(TAG, "input, circleBuffer is null.");
      AppMethodBeat.o(148607);
      return;
    }
    int n = this.jxi.a(paramArrayOfShort, paramInt);
    Log.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", new Object[] { Integer.valueOf(n), Integer.valueOf(this.jxc), Boolean.valueOf(this.jxd), Boolean.valueOf(this.jxe) });
    long l;
    int i;
    int k;
    if (this.jxd) {
      if (this.jxe)
      {
        l = System.currentTimeMillis();
        if (this.jxj != null) {
          this.jxj.biy();
        }
        this.jxf = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.jxh.jwZ;
        k = this.jxk.length;
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
      this.jxh.c(this.jxk, j);
      int m = i - j;
      i = m;
      if (this.jxj == null) {
        break;
      }
      this.jxj.b(this.jxk, j);
      i = m;
      break;
      this.jxe = false;
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessageDelayed(0, this.jxg);
      for (;;)
      {
        this.jxb = false;
        this.jxc = n;
        if (!this.isReleased) {
          break;
        }
        AppMethodBeat.o(148607);
        return;
        if ((this.jxc == 3) && (n == 2)) {
          this.jxd = false;
        }
        if ((this.jxc != 3) || (n != 3))
        {
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.jxg);
        }
      }
      if ((this.jxc == 3) && (n == 2))
      {
        this.jxc = n;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.jxg);
        l = System.currentTimeMillis();
        if (this.jxj != null) {
          this.jxj.biy();
        }
        this.jxf = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.jxh.jwZ;
        k = this.jxk.length;
        label506:
        if (i > 0) {
          if (k <= i) {
            break label804;
          }
        }
      }
      for (j = i;; j = k)
      {
        this.jxh.c(this.jxk, j);
        m = i - j;
        i = m;
        if (this.jxj == null) {
          break label506;
        }
        this.jxj.b(this.jxk, j);
        i = m;
        break label506;
        this.jxb = false;
        break;
        if ((this.jxc == 2) && (n == 3))
        {
          this.jxc = n;
          this.jxb = true;
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.jxg);
          l = System.currentTimeMillis();
          if (this.jxj != null) {
            this.jxj.bix();
          }
          this.jxf = l;
          if (!this.isReleased) {
            break;
          }
          AppMethodBeat.o(148607);
          return;
        }
        if ((this.jxc == 3) && (n == 3))
        {
          this.jxb = true;
          break;
        }
        if ((this.jxc != 2) || (n != 2)) {
          break;
        }
        this.jxb = false;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.jxg);
        break;
        this.jxh.d(paramArrayOfShort, paramInt);
        Log.d(TAG, "isSilent %s", new Object[] { Boolean.valueOf(this.jxb) });
        if (this.jxb)
        {
          AppMethodBeat.o(148607);
          return;
        }
        if (this.jxj != null) {
          this.jxj.b(paramArrayOfShort, paramInt);
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
    this.jxd = false;
    this.jxe = false;
    if (this.jxi != null)
    {
      if (this.jxi.IL() == 1)
      {
        b localb = new b();
        AppMethodBeat.o(148608);
        throw localb;
      }
      this.jxi = null;
    }
    this.jxh = null;
    this.jxk = null;
    if (this.handler != null)
    {
      this.handler.removeMessages(0);
      this.handler = null;
    }
    this.jxj = null;
    AppMethodBeat.o(148608);
  }
  
  public static abstract interface a
  {
    public abstract void Yh();
    
    public abstract void b(short[] paramArrayOfShort, int paramInt);
    
    public abstract void bix();
    
    public abstract void biy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.c
 * JD-Core Version:    0.7.0.1
 */