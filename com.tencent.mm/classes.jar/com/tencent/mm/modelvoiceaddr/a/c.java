package com.tencent.mm.modelvoiceaddr.a;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.qq.wx.voice.vad.EVadNative;
import com.qq.wx.voice.vad.MMVoipVadNative;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Map;

public class c
{
  private static final String TAG;
  public static SharedPreferences sp;
  private ap handler;
  private boolean isReleased;
  private boolean iyT;
  private int iyU;
  private boolean iyV;
  private boolean iyW;
  private long iyX;
  private int iyY;
  private a iyZ;
  private com.qq.wx.voice.vad.a iza;
  public a izb;
  private short[] izc;
  
  static
  {
    AppMethodBeat.i(148609);
    TAG = c.class.getSimpleName();
    sp = aj.fkD();
    AppMethodBeat.o(148609);
  }
  
  public c(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(148606);
    this.iyT = true;
    this.iyU = 3;
    this.iyV = false;
    this.iyW = false;
    this.iyX = 0L;
    this.iyY = 3500;
    this.isReleased = false;
    this.handler = new ap(Looper.getMainLooper())
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
          c.a(c.this).NX();
        }
        AppMethodBeat.o(148603);
      }
    };
    this.iyZ = null;
    this.iza = null;
    this.iyY = paramInt1;
    this.iza = new com.qq.wx.voice.vad.a();
    int j = 0;
    int i = j;
    Object localObject;
    if (aj.cnC())
    {
      localObject = com.tencent.mm.model.c.d.aDs().wz("100235");
      i = j;
      if (((com.tencent.mm.storage.c)localObject).isValid()) {
        i = bt.getInt((String)((com.tencent.mm.storage.c)localObject).foF().get("MMVoipVadOn"), 0);
      }
    }
    ad.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      com.qq.wx.voice.vad.a.bi(false);
      localObject = this.iza;
      if (!com.qq.wx.voice.vad.a.bVP) {
        break label304;
      }
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).bVO.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
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
        localObject = this.iza;
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
      com.qq.wx.voice.vad.a.bi(true);
      break;
      label304:
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).bVN.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
      break label206;
      label329:
      paramInt2 = 0;
      break label250;
      label334:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Reset handle = " + ((com.qq.wx.voice.vad.a)localObject).handle);
      }
      if (com.qq.wx.voice.vad.a.bVP) {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).bVO.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      } else {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).bVN.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      }
    }
    label406:
    this.iyZ = new a(paramInt5 * 16);
    this.izc = new short[4000];
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessageDelayed(0, paramInt1);
    this.iyV = paramBoolean1;
    this.iyW = paramBoolean2;
    AppMethodBeat.o(148606);
  }
  
  public c(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(3500, sp.getInt("sil_time", 1000), sp.getFloat("s_n_ration", 2.5F), sp.getInt("s_window", 500), sp.getInt("s_length", 350), sp.getInt("s_delay_time", 550), paramBoolean1, paramBoolean2);
    AppMethodBeat.i(148605);
    AppMethodBeat.o(148605);
  }
  
  public static String aNY()
  {
    AppMethodBeat.i(148604);
    String str = String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[] { "sil_time", Integer.valueOf(sp.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(sp.getFloat("s_n_ration", 2.5F)), "s_window", Integer.valueOf(sp.getInt("s_window", 500)), "s_length", Integer.valueOf(sp.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(sp.getInt("s_delay_time", 550)) });
    AppMethodBeat.o(148604);
    return str;
  }
  
  public final void e(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(148607);
    ad.d(TAG, "input() called with: voice = [%s], length = [%s]", new Object[] { paramArrayOfShort, Integer.valueOf(paramInt) });
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0) || (paramInt <= 0) || (paramInt > paramArrayOfShort.length))
    {
      AppMethodBeat.o(148607);
      return;
    }
    if (this.isReleased)
    {
      ad.i(TAG, "VoiceSilentDetectAPI is released.");
      AppMethodBeat.o(148607);
      return;
    }
    if (this.iyZ == null)
    {
      ad.i(TAG, "input, circleBuffer is null.");
      AppMethodBeat.o(148607);
      return;
    }
    int n = this.iza.a(paramArrayOfShort, paramInt);
    ad.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", new Object[] { Integer.valueOf(n), Integer.valueOf(this.iyU), Boolean.valueOf(this.iyV), Boolean.valueOf(this.iyW) });
    long l;
    int i;
    int k;
    if (this.iyV) {
      if (this.iyW)
      {
        l = System.currentTimeMillis();
        if (this.izb != null) {
          this.izb.aNT();
        }
        this.iyX = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.iyZ.iyR;
        k = this.izc.length;
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
      this.iyZ.c(this.izc, j);
      int m = i - j;
      i = m;
      if (this.izb == null) {
        break;
      }
      this.izb.b(this.izc, j);
      i = m;
      break;
      this.iyW = false;
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessageDelayed(0, this.iyY);
      for (;;)
      {
        this.iyT = false;
        this.iyU = n;
        if (!this.isReleased) {
          break;
        }
        AppMethodBeat.o(148607);
        return;
        if ((this.iyU == 3) && (n == 2)) {
          this.iyV = false;
        }
        if ((this.iyU != 3) || (n != 3))
        {
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.iyY);
        }
      }
      if ((this.iyU == 3) && (n == 2))
      {
        this.iyU = n;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.iyY);
        l = System.currentTimeMillis();
        if (this.izb != null) {
          this.izb.aNT();
        }
        this.iyX = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.iyZ.iyR;
        k = this.izc.length;
        label506:
        if (i > 0) {
          if (k <= i) {
            break label804;
          }
        }
      }
      for (j = i;; j = k)
      {
        this.iyZ.c(this.izc, j);
        m = i - j;
        i = m;
        if (this.izb == null) {
          break label506;
        }
        this.izb.b(this.izc, j);
        i = m;
        break label506;
        this.iyT = false;
        break;
        if ((this.iyU == 2) && (n == 3))
        {
          this.iyU = n;
          this.iyT = true;
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.iyY);
          l = System.currentTimeMillis();
          if (this.izb != null) {
            this.izb.aNS();
          }
          this.iyX = l;
          if (!this.isReleased) {
            break;
          }
          AppMethodBeat.o(148607);
          return;
        }
        if ((this.iyU == 3) && (n == 3))
        {
          this.iyT = true;
          break;
        }
        if ((this.iyU != 2) || (n != 2)) {
          break;
        }
        this.iyT = false;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.iyY);
        break;
        this.iyZ.d(paramArrayOfShort, paramInt);
        ad.d(TAG, "isSilent %s", new Object[] { Boolean.valueOf(this.iyT) });
        if (this.iyT)
        {
          AppMethodBeat.o(148607);
          return;
        }
        if (this.izb != null) {
          this.izb.b(paramArrayOfShort, paramInt);
        }
        AppMethodBeat.o(148607);
        return;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(148608);
    ad.d(TAG, "released");
    this.isReleased = true;
    this.iyV = false;
    this.iyW = false;
    if (this.iza != null)
    {
      if (this.iza.zR() == 1)
      {
        b localb = new b();
        AppMethodBeat.o(148608);
        throw localb;
      }
      this.iza = null;
    }
    this.iyZ = null;
    this.izc = null;
    if (this.handler != null)
    {
      this.handler.removeMessages(0);
      this.handler = null;
    }
    this.izb = null;
    AppMethodBeat.o(148608);
  }
  
  public static abstract interface a
  {
    public abstract void NX();
    
    public abstract void aNS();
    
    public abstract void aNT();
    
    public abstract void b(short[] paramArrayOfShort, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.c
 * JD-Core Version:    0.7.0.1
 */