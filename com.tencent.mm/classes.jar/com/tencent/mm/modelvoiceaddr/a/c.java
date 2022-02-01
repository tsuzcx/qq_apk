package com.tencent.mm.modelvoiceaddr.a;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.qq.wx.voice.vad.EVadNative;
import com.qq.wx.voice.vad.MMVoipVadNative;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Map;

public class c
{
  private static final String TAG;
  public static SharedPreferences sp;
  private ao handler;
  private int ifA;
  private boolean ifB;
  private boolean ifC;
  private long ifD;
  private int ifE;
  private a ifF;
  private com.qq.wx.voice.vad.a ifG;
  public a ifH;
  private short[] ifI;
  private boolean ifz;
  private boolean isReleased;
  
  static
  {
    AppMethodBeat.i(148609);
    TAG = c.class.getSimpleName();
    sp = ai.eUY();
    AppMethodBeat.o(148609);
  }
  
  public c(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(148606);
    this.ifz = true;
    this.ifA = 3;
    this.ifB = false;
    this.ifC = false;
    this.ifD = 0L;
    this.ifE = 3500;
    this.isReleased = false;
    this.handler = new ao(Looper.getMainLooper())
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
          c.a(c.this).Mo();
        }
        AppMethodBeat.o(148603);
      }
    };
    this.ifF = null;
    this.ifG = null;
    this.ifE = paramInt1;
    this.ifG = new com.qq.wx.voice.vad.a();
    int j = 0;
    int i = j;
    Object localObject;
    if (ai.ciE())
    {
      localObject = com.tencent.mm.model.c.d.aAp().tJ("100235");
      i = j;
      if (((com.tencent.mm.storage.c)localObject).isValid()) {
        i = bs.getInt((String)((com.tencent.mm.storage.c)localObject).eYV().get("MMVoipVadOn"), 0);
      }
    }
    ac.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      com.qq.wx.voice.vad.a.bh(false);
      localObject = this.ifG;
      if (!com.qq.wx.voice.vad.a.bLC) {
        break label304;
      }
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).bLB.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
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
        localObject = this.ifG;
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
      com.qq.wx.voice.vad.a.bh(true);
      break;
      label304:
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).bLA.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
      break label206;
      label329:
      paramInt2 = 0;
      break label250;
      label334:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Reset handle = " + ((com.qq.wx.voice.vad.a)localObject).handle);
      }
      if (com.qq.wx.voice.vad.a.bLC) {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).bLB.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      } else {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).bLA.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      }
    }
    label406:
    this.ifF = new a(paramInt5 * 16);
    this.ifI = new short[4000];
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessageDelayed(0, paramInt1);
    this.ifB = paramBoolean1;
    this.ifC = paramBoolean2;
    AppMethodBeat.o(148606);
  }
  
  public c(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(3500, sp.getInt("sil_time", 1000), sp.getFloat("s_n_ration", 2.5F), sp.getInt("s_window", 500), sp.getInt("s_length", 350), sp.getInt("s_delay_time", 550), paramBoolean1, paramBoolean2);
    AppMethodBeat.i(148605);
    AppMethodBeat.o(148605);
  }
  
  public static String aKP()
  {
    AppMethodBeat.i(148604);
    String str = String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[] { "sil_time", Integer.valueOf(sp.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(sp.getFloat("s_n_ration", 2.5F)), "s_window", Integer.valueOf(sp.getInt("s_window", 500)), "s_length", Integer.valueOf(sp.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(sp.getInt("s_delay_time", 550)) });
    AppMethodBeat.o(148604);
    return str;
  }
  
  public final void e(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(148607);
    ac.d(TAG, "input() called with: voice = [%s], length = [%s]", new Object[] { paramArrayOfShort, Integer.valueOf(paramInt) });
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0) || (paramInt <= 0) || (paramInt > paramArrayOfShort.length))
    {
      AppMethodBeat.o(148607);
      return;
    }
    if (this.isReleased)
    {
      ac.i(TAG, "VoiceSilentDetectAPI is released.");
      AppMethodBeat.o(148607);
      return;
    }
    if (this.ifF == null)
    {
      ac.i(TAG, "input, circleBuffer is null.");
      AppMethodBeat.o(148607);
      return;
    }
    int n = this.ifG.a(paramArrayOfShort, paramInt);
    ac.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", new Object[] { Integer.valueOf(n), Integer.valueOf(this.ifA), Boolean.valueOf(this.ifB), Boolean.valueOf(this.ifC) });
    long l;
    int i;
    int k;
    if (this.ifB) {
      if (this.ifC)
      {
        l = System.currentTimeMillis();
        if (this.ifH != null) {
          this.ifH.aKK();
        }
        this.ifD = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.ifF.ifx;
        k = this.ifI.length;
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
      this.ifF.c(this.ifI, j);
      int m = i - j;
      i = m;
      if (this.ifH == null) {
        break;
      }
      this.ifH.b(this.ifI, j);
      i = m;
      break;
      this.ifC = false;
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessageDelayed(0, this.ifE);
      for (;;)
      {
        this.ifz = false;
        this.ifA = n;
        if (!this.isReleased) {
          break;
        }
        AppMethodBeat.o(148607);
        return;
        if ((this.ifA == 3) && (n == 2)) {
          this.ifB = false;
        }
        if ((this.ifA != 3) || (n != 3))
        {
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.ifE);
        }
      }
      if ((this.ifA == 3) && (n == 2))
      {
        this.ifA = n;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.ifE);
        l = System.currentTimeMillis();
        if (this.ifH != null) {
          this.ifH.aKK();
        }
        this.ifD = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.ifF.ifx;
        k = this.ifI.length;
        label506:
        if (i > 0) {
          if (k <= i) {
            break label804;
          }
        }
      }
      for (j = i;; j = k)
      {
        this.ifF.c(this.ifI, j);
        m = i - j;
        i = m;
        if (this.ifH == null) {
          break label506;
        }
        this.ifH.b(this.ifI, j);
        i = m;
        break label506;
        this.ifz = false;
        break;
        if ((this.ifA == 2) && (n == 3))
        {
          this.ifA = n;
          this.ifz = true;
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.ifE);
          l = System.currentTimeMillis();
          if (this.ifH != null) {
            this.ifH.aKJ();
          }
          this.ifD = l;
          if (!this.isReleased) {
            break;
          }
          AppMethodBeat.o(148607);
          return;
        }
        if ((this.ifA == 3) && (n == 3))
        {
          this.ifz = true;
          break;
        }
        if ((this.ifA != 2) || (n != 2)) {
          break;
        }
        this.ifz = false;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.ifE);
        break;
        this.ifF.d(paramArrayOfShort, paramInt);
        ac.d(TAG, "isSilent %s", new Object[] { Boolean.valueOf(this.ifz) });
        if (this.ifz)
        {
          AppMethodBeat.o(148607);
          return;
        }
        if (this.ifH != null) {
          this.ifH.b(paramArrayOfShort, paramInt);
        }
        AppMethodBeat.o(148607);
        return;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(148608);
    ac.d(TAG, "released");
    this.isReleased = true;
    this.ifB = false;
    this.ifC = false;
    if (this.ifG != null)
    {
      if (this.ifG.yu() == 1)
      {
        b localb = new b();
        AppMethodBeat.o(148608);
        throw localb;
      }
      this.ifG = null;
    }
    this.ifF = null;
    this.ifI = null;
    if (this.handler != null)
    {
      this.handler.removeMessages(0);
      this.handler = null;
    }
    this.ifH = null;
    AppMethodBeat.o(148608);
  }
  
  public static abstract interface a
  {
    public abstract void Mo();
    
    public abstract void aKJ();
    
    public abstract void aKK();
    
    public abstract void b(short[] paramArrayOfShort, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.c
 * JD-Core Version:    0.7.0.1
 */