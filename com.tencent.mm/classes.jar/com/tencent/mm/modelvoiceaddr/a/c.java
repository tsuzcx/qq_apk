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
  private boolean hEX;
  private int hEY;
  private boolean hEZ;
  private boolean hFa;
  private long hFb;
  private int hFc;
  private a hFd;
  private com.qq.wx.voice.vad.a hFe;
  public a hFf;
  private short[] hFg;
  private ap handler;
  private boolean isReleased;
  
  static
  {
    AppMethodBeat.i(148609);
    TAG = c.class.getSimpleName();
    sp = aj.eFE();
    AppMethodBeat.o(148609);
  }
  
  public c(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(148606);
    this.hEX = true;
    this.hEY = 3;
    this.hEZ = false;
    this.hFa = false;
    this.hFb = 0L;
    this.hFc = 3500;
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
          c.a(c.this).Mq();
        }
        AppMethodBeat.o(148603);
      }
    };
    this.hFd = null;
    this.hFe = null;
    this.hFc = paramInt1;
    this.hFe = new com.qq.wx.voice.vad.a();
    int j = 0;
    int i = j;
    Object localObject;
    if (aj.cbv())
    {
      localObject = com.tencent.mm.model.c.d.aty().qu("100235");
      i = j;
      if (((com.tencent.mm.storage.c)localObject).isValid()) {
        i = bt.getInt((String)((com.tencent.mm.storage.c)localObject).eJy().get("MMVoipVadOn"), 0);
      }
    }
    ad.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      com.qq.wx.voice.vad.a.bi(false);
      localObject = this.hFe;
      if (!com.qq.wx.voice.vad.a.bNU) {
        break label304;
      }
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).bNT.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
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
        localObject = this.hFe;
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
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).bNS.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
      break label206;
      label329:
      paramInt2 = 0;
      break label250;
      label334:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Reset handle = " + ((com.qq.wx.voice.vad.a)localObject).handle);
      }
      if (com.qq.wx.voice.vad.a.bNU) {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).bNT.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      } else {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).bNS.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      }
    }
    label406:
    this.hFd = new a(paramInt5 * 16);
    this.hFg = new short[4000];
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessageDelayed(0, paramInt1);
    this.hEZ = paramBoolean1;
    this.hFa = paramBoolean2;
    AppMethodBeat.o(148606);
  }
  
  public c(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(3500, sp.getInt("sil_time", 1000), sp.getFloat("s_n_ration", 2.5F), sp.getInt("s_window", 500), sp.getInt("s_length", 350), sp.getInt("s_delay_time", 550), paramBoolean1, paramBoolean2);
    AppMethodBeat.i(148605);
    AppMethodBeat.o(148605);
  }
  
  public static String aDY()
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
    if (this.hFd == null)
    {
      ad.i(TAG, "input, circleBuffer is null.");
      AppMethodBeat.o(148607);
      return;
    }
    int n = this.hFe.a(paramArrayOfShort, paramInt);
    ad.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", new Object[] { Integer.valueOf(n), Integer.valueOf(this.hEY), Boolean.valueOf(this.hEZ), Boolean.valueOf(this.hFa) });
    long l;
    int i;
    int k;
    if (this.hEZ) {
      if (this.hFa)
      {
        l = System.currentTimeMillis();
        if (this.hFf != null) {
          this.hFf.aDT();
        }
        this.hFb = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.hFd.hEV;
        k = this.hFg.length;
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
      this.hFd.c(this.hFg, j);
      int m = i - j;
      i = m;
      if (this.hFf == null) {
        break;
      }
      this.hFf.b(this.hFg, j);
      i = m;
      break;
      this.hFa = false;
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessageDelayed(0, this.hFc);
      for (;;)
      {
        this.hEX = false;
        this.hEY = n;
        if (!this.isReleased) {
          break;
        }
        AppMethodBeat.o(148607);
        return;
        if ((this.hEY == 3) && (n == 2)) {
          this.hEZ = false;
        }
        if ((this.hEY != 3) || (n != 3))
        {
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.hFc);
        }
      }
      if ((this.hEY == 3) && (n == 2))
      {
        this.hEY = n;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.hFc);
        l = System.currentTimeMillis();
        if (this.hFf != null) {
          this.hFf.aDT();
        }
        this.hFb = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.hFd.hEV;
        k = this.hFg.length;
        label506:
        if (i > 0) {
          if (k <= i) {
            break label804;
          }
        }
      }
      for (j = i;; j = k)
      {
        this.hFd.c(this.hFg, j);
        m = i - j;
        i = m;
        if (this.hFf == null) {
          break label506;
        }
        this.hFf.b(this.hFg, j);
        i = m;
        break label506;
        this.hEX = false;
        break;
        if ((this.hEY == 2) && (n == 3))
        {
          this.hEY = n;
          this.hEX = true;
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.hFc);
          l = System.currentTimeMillis();
          if (this.hFf != null) {
            this.hFf.aDS();
          }
          this.hFb = l;
          if (!this.isReleased) {
            break;
          }
          AppMethodBeat.o(148607);
          return;
        }
        if ((this.hEY == 3) && (n == 3))
        {
          this.hEX = true;
          break;
        }
        if ((this.hEY != 2) || (n != 2)) {
          break;
        }
        this.hEX = false;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.hFc);
        break;
        this.hFd.d(paramArrayOfShort, paramInt);
        ad.d(TAG, "isSilent %s", new Object[] { Boolean.valueOf(this.hEX) });
        if (this.hEX)
        {
          AppMethodBeat.o(148607);
          return;
        }
        if (this.hFf != null) {
          this.hFf.b(paramArrayOfShort, paramInt);
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
    this.hEZ = false;
    this.hFa = false;
    if (this.hFe != null)
    {
      if (this.hFe.yH() == 1)
      {
        b localb = new b();
        AppMethodBeat.o(148608);
        throw localb;
      }
      this.hFe = null;
    }
    this.hFd = null;
    this.hFg = null;
    if (this.handler != null)
    {
      this.handler.removeMessages(0);
      this.handler = null;
    }
    this.hFf = null;
    AppMethodBeat.o(148608);
  }
  
  public static abstract interface a
  {
    public abstract void Mq();
    
    public abstract void aDS();
    
    public abstract void aDT();
    
    public abstract void b(short[] paramArrayOfShort, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.c
 * JD-Core Version:    0.7.0.1
 */