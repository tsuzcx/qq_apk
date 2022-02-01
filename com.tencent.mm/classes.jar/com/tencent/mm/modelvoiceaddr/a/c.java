package com.tencent.mm.modelvoiceaddr.a;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.qq.wx.voice.vad.EVadNative;
import com.qq.wx.voice.vad.MMVoipVadNative;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Map;

public class c
{
  private static final String TAG;
  public static SharedPreferences sp;
  private aq handler;
  private boolean iBM;
  private int iBN;
  private boolean iBO;
  private boolean iBP;
  private long iBQ;
  private int iBR;
  private a iBS;
  private com.qq.wx.voice.vad.a iBT;
  public a iBU;
  private short[] iBV;
  private boolean isReleased;
  
  static
  {
    AppMethodBeat.i(148609);
    TAG = c.class.getSimpleName();
    sp = ak.fox();
    AppMethodBeat.o(148609);
  }
  
  public c(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(148606);
    this.iBM = true;
    this.iBN = 3;
    this.iBO = false;
    this.iBP = false;
    this.iBQ = 0L;
    this.iBR = 3500;
    this.isReleased = false;
    this.handler = new aq(Looper.getMainLooper())
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
          c.a(c.this).NV();
        }
        AppMethodBeat.o(148603);
      }
    };
    this.iBS = null;
    this.iBT = null;
    this.iBR = paramInt1;
    this.iBT = new com.qq.wx.voice.vad.a();
    int j = 0;
    int i = j;
    Object localObject;
    if (ak.cpe())
    {
      localObject = com.tencent.mm.model.c.d.aDI().xi("100235");
      i = j;
      if (((com.tencent.mm.storage.c)localObject).isValid()) {
        i = bu.getInt((String)((com.tencent.mm.storage.c)localObject).fsy().get("MMVoipVadOn"), 0);
      }
    }
    ae.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      com.qq.wx.voice.vad.a.bi(false);
      localObject = this.iBT;
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
        localObject = this.iBT;
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
    this.iBS = new a(paramInt5 * 16);
    this.iBV = new short[4000];
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessageDelayed(0, paramInt1);
    this.iBO = paramBoolean1;
    this.iBP = paramBoolean2;
    AppMethodBeat.o(148606);
  }
  
  public c(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(3500, sp.getInt("sil_time", 1000), sp.getFloat("s_n_ration", 2.5F), sp.getInt("s_window", 500), sp.getInt("s_length", 350), sp.getInt("s_delay_time", 550), paramBoolean1, paramBoolean2);
    AppMethodBeat.i(148605);
    AppMethodBeat.o(148605);
  }
  
  public static String aOw()
  {
    AppMethodBeat.i(148604);
    String str = String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[] { "sil_time", Integer.valueOf(sp.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(sp.getFloat("s_n_ration", 2.5F)), "s_window", Integer.valueOf(sp.getInt("s_window", 500)), "s_length", Integer.valueOf(sp.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(sp.getInt("s_delay_time", 550)) });
    AppMethodBeat.o(148604);
    return str;
  }
  
  public final void e(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(148607);
    ae.d(TAG, "input() called with: voice = [%s], length = [%s]", new Object[] { paramArrayOfShort, Integer.valueOf(paramInt) });
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0) || (paramInt <= 0) || (paramInt > paramArrayOfShort.length))
    {
      AppMethodBeat.o(148607);
      return;
    }
    if (this.isReleased)
    {
      ae.i(TAG, "VoiceSilentDetectAPI is released.");
      AppMethodBeat.o(148607);
      return;
    }
    if (this.iBS == null)
    {
      ae.i(TAG, "input, circleBuffer is null.");
      AppMethodBeat.o(148607);
      return;
    }
    int n = this.iBT.a(paramArrayOfShort, paramInt);
    ae.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", new Object[] { Integer.valueOf(n), Integer.valueOf(this.iBN), Boolean.valueOf(this.iBO), Boolean.valueOf(this.iBP) });
    long l;
    int i;
    int k;
    if (this.iBO) {
      if (this.iBP)
      {
        l = System.currentTimeMillis();
        if (this.iBU != null) {
          this.iBU.aOr();
        }
        this.iBQ = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.iBS.iBK;
        k = this.iBV.length;
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
      this.iBS.c(this.iBV, j);
      int m = i - j;
      i = m;
      if (this.iBU == null) {
        break;
      }
      this.iBU.b(this.iBV, j);
      i = m;
      break;
      this.iBP = false;
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessageDelayed(0, this.iBR);
      for (;;)
      {
        this.iBM = false;
        this.iBN = n;
        if (!this.isReleased) {
          break;
        }
        AppMethodBeat.o(148607);
        return;
        if ((this.iBN == 3) && (n == 2)) {
          this.iBO = false;
        }
        if ((this.iBN != 3) || (n != 3))
        {
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.iBR);
        }
      }
      if ((this.iBN == 3) && (n == 2))
      {
        this.iBN = n;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.iBR);
        l = System.currentTimeMillis();
        if (this.iBU != null) {
          this.iBU.aOr();
        }
        this.iBQ = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.iBS.iBK;
        k = this.iBV.length;
        label506:
        if (i > 0) {
          if (k <= i) {
            break label804;
          }
        }
      }
      for (j = i;; j = k)
      {
        this.iBS.c(this.iBV, j);
        m = i - j;
        i = m;
        if (this.iBU == null) {
          break label506;
        }
        this.iBU.b(this.iBV, j);
        i = m;
        break label506;
        this.iBM = false;
        break;
        if ((this.iBN == 2) && (n == 3))
        {
          this.iBN = n;
          this.iBM = true;
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.iBR);
          l = System.currentTimeMillis();
          if (this.iBU != null) {
            this.iBU.aOq();
          }
          this.iBQ = l;
          if (!this.isReleased) {
            break;
          }
          AppMethodBeat.o(148607);
          return;
        }
        if ((this.iBN == 3) && (n == 3))
        {
          this.iBM = true;
          break;
        }
        if ((this.iBN != 2) || (n != 2)) {
          break;
        }
        this.iBM = false;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.iBR);
        break;
        this.iBS.d(paramArrayOfShort, paramInt);
        ae.d(TAG, "isSilent %s", new Object[] { Boolean.valueOf(this.iBM) });
        if (this.iBM)
        {
          AppMethodBeat.o(148607);
          return;
        }
        if (this.iBU != null) {
          this.iBU.b(paramArrayOfShort, paramInt);
        }
        AppMethodBeat.o(148607);
        return;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(148608);
    ae.d(TAG, "released");
    this.isReleased = true;
    this.iBO = false;
    this.iBP = false;
    if (this.iBT != null)
    {
      if (this.iBT.zS() == 1)
      {
        b localb = new b();
        AppMethodBeat.o(148608);
        throw localb;
      }
      this.iBT = null;
    }
    this.iBS = null;
    this.iBV = null;
    if (this.handler != null)
    {
      this.handler.removeMessages(0);
      this.handler = null;
    }
    this.iBU = null;
    AppMethodBeat.o(148608);
  }
  
  public static abstract interface a
  {
    public abstract void NV();
    
    public abstract void aOq();
    
    public abstract void aOr();
    
    public abstract void b(short[] paramArrayOfShort, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.c
 * JD-Core Version:    0.7.0.1
 */