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
  private boolean mmE;
  private int mmF;
  private boolean mmG;
  private boolean mmH;
  private long mmI;
  private int mmJ;
  private a mmK;
  private com.qq.wx.voice.vad.a mmL;
  public a mmM;
  private short[] mmN;
  
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
    this.mmE = true;
    this.mmF = 3;
    this.mmG = false;
    this.mmH = false;
    this.mmI = 0L;
    this.mmJ = 3500;
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
          c.a(c.this).acN();
        }
        AppMethodBeat.o(148603);
      }
    };
    this.mmK = null;
    this.mmL = null;
    this.mmJ = paramInt1;
    this.mmL = new com.qq.wx.voice.vad.a();
    int j = 0;
    int i = j;
    Object localObject;
    if (MMApplicationContext.isMMProcess())
    {
      localObject = com.tencent.mm.model.c.d.bgB().Mu("100235");
      i = j;
      if (((com.tencent.mm.storage.c)localObject).isValid()) {
        i = Util.getInt((String)((com.tencent.mm.storage.c)localObject).hvz().get("MMVoipVadOn"), 0);
      }
    }
    Log.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      com.qq.wx.voice.vad.a.bW(false);
      localObject = this.mmL;
      if (!com.qq.wx.voice.vad.a.ciy) {
        break label304;
      }
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).cix.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
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
        localObject = this.mmL;
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
      com.qq.wx.voice.vad.a.bW(true);
      break;
      label304:
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).ciw.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
      break label206;
      label329:
      paramInt2 = 0;
      break label250;
      label334:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Reset handle = " + ((com.qq.wx.voice.vad.a)localObject).handle);
      }
      if (com.qq.wx.voice.vad.a.ciy) {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).cix.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      } else {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).ciw.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      }
    }
    label406:
    this.mmK = new a(paramInt5 * 16);
    this.mmN = new short[4000];
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessageDelayed(0, paramInt1);
    this.mmG = paramBoolean1;
    this.mmH = paramBoolean2;
    AppMethodBeat.o(148606);
  }
  
  public c(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(3500, sp.getInt("sil_time", 1000), sp.getFloat("s_n_ration", 2.5F), sp.getInt("s_window", 500), sp.getInt("s_length", 350), sp.getInt("s_delay_time", 550), paramBoolean1, paramBoolean2);
    AppMethodBeat.i(148605);
    AppMethodBeat.o(148605);
  }
  
  public static String bsb()
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
    if (this.mmK == null)
    {
      Log.i(TAG, "input, circleBuffer is null.");
      AppMethodBeat.o(148607);
      return;
    }
    int n = this.mmL.a(paramArrayOfShort, paramInt);
    Log.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", new Object[] { Integer.valueOf(n), Integer.valueOf(this.mmF), Boolean.valueOf(this.mmG), Boolean.valueOf(this.mmH) });
    long l;
    int i;
    int k;
    if (this.mmG) {
      if (this.mmH)
      {
        l = System.currentTimeMillis();
        if (this.mmM != null) {
          this.mmM.brW();
        }
        this.mmI = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.mmK.mmC;
        k = this.mmN.length;
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
      this.mmK.c(this.mmN, j);
      int m = i - j;
      i = m;
      if (this.mmM == null) {
        break;
      }
      this.mmM.b(this.mmN, j);
      i = m;
      break;
      this.mmH = false;
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessageDelayed(0, this.mmJ);
      for (;;)
      {
        this.mmE = false;
        this.mmF = n;
        if (!this.isReleased) {
          break;
        }
        AppMethodBeat.o(148607);
        return;
        if ((this.mmF == 3) && (n == 2)) {
          this.mmG = false;
        }
        if ((this.mmF != 3) || (n != 3))
        {
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.mmJ);
        }
      }
      if ((this.mmF == 3) && (n == 2))
      {
        this.mmF = n;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.mmJ);
        l = System.currentTimeMillis();
        if (this.mmM != null) {
          this.mmM.brW();
        }
        this.mmI = l;
        if (this.isReleased)
        {
          AppMethodBeat.o(148607);
          return;
        }
        i = this.mmK.mmC;
        k = this.mmN.length;
        label506:
        if (i > 0) {
          if (k <= i) {
            break label804;
          }
        }
      }
      for (j = i;; j = k)
      {
        this.mmK.c(this.mmN, j);
        m = i - j;
        i = m;
        if (this.mmM == null) {
          break label506;
        }
        this.mmM.b(this.mmN, j);
        i = m;
        break label506;
        this.mmE = false;
        break;
        if ((this.mmF == 2) && (n == 3))
        {
          this.mmF = n;
          this.mmE = true;
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.mmJ);
          l = System.currentTimeMillis();
          if (this.mmM != null) {
            this.mmM.brV();
          }
          this.mmI = l;
          if (!this.isReleased) {
            break;
          }
          AppMethodBeat.o(148607);
          return;
        }
        if ((this.mmF == 3) && (n == 3))
        {
          this.mmE = true;
          break;
        }
        if ((this.mmF != 2) || (n != 2)) {
          break;
        }
        this.mmE = false;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.mmJ);
        break;
        this.mmK.d(paramArrayOfShort, paramInt);
        Log.d(TAG, "isSilent %s", new Object[] { Boolean.valueOf(this.mmE) });
        if (this.mmE)
        {
          AppMethodBeat.o(148607);
          return;
        }
        if (this.mmM != null) {
          this.mmM.b(paramArrayOfShort, paramInt);
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
    this.mmG = false;
    this.mmH = false;
    if (this.mmL != null)
    {
      if (this.mmL.Ko() == 1)
      {
        b localb = new b();
        AppMethodBeat.o(148608);
        throw localb;
      }
      this.mmL = null;
    }
    this.mmK = null;
    this.mmN = null;
    if (this.handler != null)
    {
      this.handler.removeMessages(0);
      this.handler = null;
    }
    this.mmM = null;
    AppMethodBeat.o(148608);
  }
  
  public static abstract interface a
  {
    public abstract void acN();
    
    public abstract void b(short[] paramArrayOfShort, int paramInt);
    
    public abstract void brV();
    
    public abstract void brW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.c
 * JD-Core Version:    0.7.0.1
 */