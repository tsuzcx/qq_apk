package com.tencent.mm.modelvoiceaddr.a;

import android.content.SharedPreferences;
import android.os.Looper;
import com.qq.wx.voice.vad.EVadNative;
import com.qq.wx.voice.vad.MMVoipVadNative;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Map;

public class c
{
  private static final String TAG;
  public static SharedPreferences sp;
  private boolean eVX;
  private boolean gcf;
  private int gcg;
  private boolean gch;
  private boolean gci;
  private long gcj;
  private int gck;
  private a gcl;
  private com.qq.wx.voice.vad.a gcm;
  public c.a gcn;
  private short[] gco;
  private ak handler;
  
  static
  {
    AppMethodBeat.i(116763);
    TAG = c.class.getSimpleName();
    sp = ah.dsQ();
    AppMethodBeat.o(116763);
  }
  
  public c(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(116760);
    this.gcf = true;
    this.gcg = 3;
    this.gch = false;
    this.gci = false;
    this.gcj = 0L;
    this.gck = 3500;
    this.eVX = false;
    this.handler = new c.1(this, Looper.getMainLooper());
    this.gcl = null;
    this.gcm = null;
    this.gck = paramInt1;
    this.gcm = new com.qq.wx.voice.vad.a();
    int j = 0;
    int i = j;
    Object localObject;
    if (ah.brt())
    {
      localObject = com.tencent.mm.model.c.c.abU().me("100235");
      i = j;
      if (((com.tencent.mm.storage.c)localObject).isValid()) {
        i = bo.getInt((String)((com.tencent.mm.storage.c)localObject).dvN().get("MMVoipVadOn"), 0);
      }
    }
    ab.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      com.qq.wx.voice.vad.a.aT(false);
      localObject = this.gcm;
      if (!com.qq.wx.voice.vad.a.bmj) {
        break label304;
      }
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).bmi.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
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
        localObject = this.gcm;
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
      AppMethodBeat.o(116760);
      throw ((Throwable)localObject);
      com.qq.wx.voice.vad.a.aT(true);
      break;
      label304:
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).bmh.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
      break label206;
      label329:
      paramInt2 = 0;
      break label250;
      label334:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Reset handle = " + ((com.qq.wx.voice.vad.a)localObject).handle);
      }
      if (com.qq.wx.voice.vad.a.bmj) {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).bmi.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      } else {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).bmh.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      }
    }
    label406:
    this.gcl = new a(paramInt5 * 16);
    this.gco = new short[4000];
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessageDelayed(0, paramInt1);
    this.gch = paramBoolean1;
    this.gci = paramBoolean2;
    AppMethodBeat.o(116760);
  }
  
  public c(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(3500, sp.getInt("sil_time", 1000), sp.getFloat("s_n_ration", 2.5F), sp.getInt("s_window", 500), sp.getInt("s_length", 350), sp.getInt("s_delay_time", 550), paramBoolean1, paramBoolean2);
    AppMethodBeat.i(155555);
    AppMethodBeat.o(155555);
  }
  
  public static String amS()
  {
    AppMethodBeat.i(116758);
    String str = String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[] { "sil_time", Integer.valueOf(sp.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(sp.getFloat("s_n_ration", 2.5F)), "s_window", Integer.valueOf(sp.getInt("s_window", 500)), "s_length", Integer.valueOf(sp.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(sp.getInt("s_delay_time", 550)) });
    AppMethodBeat.o(116758);
    return str;
  }
  
  public final void f(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(116761);
    ab.d(TAG, "input() called with: voice = [%s], length = [%s]", new Object[] { paramArrayOfShort, Integer.valueOf(paramInt) });
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0) || (paramInt <= 0) || (paramInt > paramArrayOfShort.length))
    {
      AppMethodBeat.o(116761);
      return;
    }
    if (this.eVX)
    {
      ab.i(TAG, "VoiceSilentDetectAPI is released.");
      AppMethodBeat.o(116761);
      return;
    }
    if (this.gcl == null)
    {
      ab.i(TAG, "input, circleBuffer is null.");
      AppMethodBeat.o(116761);
      return;
    }
    int n = this.gcm.b(paramArrayOfShort, paramInt);
    ab.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", new Object[] { Integer.valueOf(n), Integer.valueOf(this.gcg), Boolean.valueOf(this.gch), Boolean.valueOf(this.gci) });
    long l;
    int i;
    int k;
    if (this.gch) {
      if (this.gci)
      {
        l = System.currentTimeMillis();
        if (this.gcn != null) {
          this.gcn.amN();
        }
        this.gcj = l;
        if (this.eVX)
        {
          AppMethodBeat.o(116761);
          return;
        }
        i = this.gcl.gcd;
        k = this.gco.length;
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
      this.gcl.d(this.gco, j);
      int m = i - j;
      i = m;
      if (this.gcn == null) {
        break;
      }
      this.gcn.c(this.gco, j);
      i = m;
      break;
      this.gci = false;
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessageDelayed(0, this.gck);
      for (;;)
      {
        this.gcf = false;
        this.gcg = n;
        if (!this.eVX) {
          break;
        }
        AppMethodBeat.o(116761);
        return;
        if ((this.gcg == 3) && (n == 2)) {
          this.gch = false;
        }
        if ((this.gcg != 3) || (n != 3))
        {
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.gck);
        }
      }
      if ((this.gcg == 3) && (n == 2))
      {
        this.gcg = n;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.gck);
        l = System.currentTimeMillis();
        if (this.gcn != null) {
          this.gcn.amN();
        }
        this.gcj = l;
        if (this.eVX)
        {
          AppMethodBeat.o(116761);
          return;
        }
        i = this.gcl.gcd;
        k = this.gco.length;
        label506:
        if (i > 0) {
          if (k <= i) {
            break label804;
          }
        }
      }
      for (j = i;; j = k)
      {
        this.gcl.d(this.gco, j);
        m = i - j;
        i = m;
        if (this.gcn == null) {
          break label506;
        }
        this.gcn.c(this.gco, j);
        i = m;
        break label506;
        this.gcf = false;
        break;
        if ((this.gcg == 2) && (n == 3))
        {
          this.gcg = n;
          this.gcf = true;
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.gck);
          l = System.currentTimeMillis();
          if (this.gcn != null) {
            this.gcn.amM();
          }
          this.gcj = l;
          if (!this.eVX) {
            break;
          }
          AppMethodBeat.o(116761);
          return;
        }
        if ((this.gcg == 3) && (n == 3))
        {
          this.gcf = true;
          break;
        }
        if ((this.gcg != 2) || (n != 2)) {
          break;
        }
        this.gcf = false;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.gck);
        break;
        this.gcl.e(paramArrayOfShort, paramInt);
        ab.d(TAG, "isSilent %s", new Object[] { Boolean.valueOf(this.gcf) });
        if (this.gcf)
        {
          AppMethodBeat.o(116761);
          return;
        }
        if (this.gcn != null) {
          this.gcn.c(paramArrayOfShort, paramInt);
        }
        AppMethodBeat.o(116761);
        return;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(116762);
    ab.d(TAG, "released");
    this.eVX = true;
    this.gch = false;
    this.gci = false;
    if (this.gcm != null)
    {
      if (this.gcm.tc() == 1)
      {
        b localb = new b();
        AppMethodBeat.o(116762);
        throw localb;
      }
      this.gcm = null;
    }
    this.gcl = null;
    this.gco = null;
    if (this.handler != null)
    {
      this.handler.removeMessages(0);
      this.handler = null;
    }
    this.gcn = null;
    AppMethodBeat.o(116762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.c
 * JD-Core Version:    0.7.0.1
 */