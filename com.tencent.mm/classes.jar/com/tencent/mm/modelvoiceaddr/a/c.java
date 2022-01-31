package com.tencent.mm.modelvoiceaddr.a;

import android.content.SharedPreferences;
import android.os.Looper;
import com.qq.wx.voice.vad.EVadNative;
import com.qq.wx.voice.vad.MMVoipVadNative;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Map;

public class c
{
  private static final String TAG = c.class.getSimpleName();
  public static SharedPreferences dnD = ae.cqS();
  private int eMA = 3;
  private boolean eMB = false;
  private boolean eMC = false;
  private long eMD = 0L;
  private int eME = 3500;
  private boolean eMF = false;
  private a eMG = null;
  private com.qq.wx.voice.vad.a eMH = null;
  public c.a eMI;
  private short[] eMJ;
  private boolean eMz = true;
  private ah handler = new c.1(this, Looper.getMainLooper());
  
  public c()
  {
    this(3500, dnD.getInt("sil_time", 1000), dnD.getFloat("s_n_ration", 2.5F), dnD.getInt("s_window", 500), dnD.getInt("s_length", 350), dnD.getInt("s_delay_time", 550), true, true);
  }
  
  public c(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.eME = paramInt1;
    this.eMH = new com.qq.wx.voice.vad.a();
    int j = 0;
    int i = j;
    Object localObject;
    if (ae.cqV())
    {
      localObject = com.tencent.mm.model.c.c.IX().fJ("100235");
      i = j;
      if (((com.tencent.mm.storage.c)localObject).isValid()) {
        i = bk.getInt((String)((com.tencent.mm.storage.c)localObject).ctr().get("MMVoipVadOn"), 0);
      }
    }
    y.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      com.qq.wx.voice.vad.a.aF(false);
      localObject = this.eMH;
      if (!com.qq.wx.voice.vad.a.aVB) {
        break label290;
      }
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).aVA.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
      label201:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Init handle = " + ((com.qq.wx.voice.vad.a)localObject).handle);
      }
      if (((com.qq.wx.voice.vad.a)localObject).handle != 0L) {
        break label315;
      }
      paramInt2 = 1;
      label245:
      if (paramInt2 != 1)
      {
        localObject = this.eMH;
        if (((com.qq.wx.voice.vad.a)localObject).handle != 0L) {
          break label320;
        }
        paramInt2 = 1;
      }
    }
    for (;;)
    {
      if (paramInt2 != 1) {
        break label392;
      }
      throw new b("Init ERROR");
      com.qq.wx.voice.vad.a.aF(true);
      break;
      label290:
      ((com.qq.wx.voice.vad.a)localObject).handle = ((com.qq.wx.voice.vad.a)localObject).aVz.Init(16000, paramInt2, paramFloat, paramInt3, paramInt4);
      break label201;
      label315:
      paramInt2 = 0;
      break label245;
      label320:
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad Reset handle = " + ((com.qq.wx.voice.vad.a)localObject).handle);
      }
      if (com.qq.wx.voice.vad.a.aVB) {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).aVA.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      } else {
        paramInt2 = ((com.qq.wx.voice.vad.a)localObject).aVz.Reset(((com.qq.wx.voice.vad.a)localObject).handle);
      }
    }
    label392:
    this.eMG = new a(paramInt5 * 16);
    this.eMJ = new short[4000];
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessageDelayed(0, paramInt1);
    this.eMB = paramBoolean1;
    this.eMC = paramBoolean2;
  }
  
  public static String TF()
  {
    return String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[] { "sil_time", Integer.valueOf(dnD.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(dnD.getFloat("s_n_ration", 2.5F)), "s_window", Integer.valueOf(dnD.getInt("s_window", 500)), "s_length", Integer.valueOf(dnD.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(dnD.getInt("s_delay_time", 550)) });
  }
  
  public final void d(short[] paramArrayOfShort, int paramInt)
  {
    y.d(TAG, "input() called with: voice = [%s], length = [%s]", new Object[] { paramArrayOfShort, Integer.valueOf(paramInt) });
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0) || (paramInt <= 0) || (paramInt > paramArrayOfShort.length)) {}
    Object localObject;
    int i;
    label79:
    long l;
    do
    {
      return;
      if (this.eMF)
      {
        y.i(TAG, "VoiceSilentDetectAPI is released.");
        return;
      }
      localObject = this.eMH;
      if (((com.qq.wx.voice.vad.a)localObject).handle != 0L) {
        break;
      }
      i = 1;
      y.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.eMA), Boolean.valueOf(this.eMB), Boolean.valueOf(this.eMC) });
      if (!this.eMB) {
        break label735;
      }
      if (!this.eMC) {
        break label679;
      }
      l = System.currentTimeMillis();
      if (this.eMI != null) {
        this.eMI.TB();
      }
      this.eMD = l;
    } while (this.eMF);
    int j = this.eMG.eMx;
    int m = this.eMJ.length;
    label193:
    if (j > 0) {
      if (m <= j) {
        break label1156;
      }
    }
    label408:
    label553:
    label1073:
    for (int k = j;; k = m)
    {
      this.eMG.c(this.eMJ, k);
      int n = j - k;
      j = n;
      if (this.eMI == null) {
        break label193;
      }
      this.eMI.b(this.eMJ, k);
      j = n;
      break label193;
      if (com.qq.wx.voice.vad.a.DEBUG) {
        System.out.println("EVad AddData handle = " + ((com.qq.wx.voice.vad.a)localObject).handle);
      }
      if (com.qq.wx.voice.vad.a.aVB)
      {
        i = ((com.qq.wx.voice.vad.a)localObject).aVA.AddData(((com.qq.wx.voice.vad.a)localObject).handle, paramArrayOfShort, paramInt);
        break label79;
      }
      i = ((com.qq.wx.voice.vad.a)localObject).aVz.AddData(((com.qq.wx.voice.vad.a)localObject).handle, paramArrayOfShort, paramInt);
      break label79;
      this.eMC = false;
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessageDelayed(0, this.eME);
      for (;;)
      {
        this.eMz = false;
        this.eMA = i;
        label377:
        if (this.eMF) {
          break label1038;
        }
        localObject = this.eMG;
        if (paramArrayOfShort.length >= 0)
        {
          if (paramInt <= paramArrayOfShort.length + 0) {
            break label1144;
          }
          i = paramArrayOfShort.length + 0;
          if (i != 0)
          {
            j = ((a)localObject).eMy.length - ((a)localObject).eMx;
            if (i > j)
            {
              j = i - j;
              if (j != 0)
              {
                if (j >= ((a)localObject).eMx) {
                  break label1040;
                }
                label453:
                if (j > ((a)localObject).eMy.length - ((a)localObject).eMv) {
                  break label1050;
                }
                ((a)localObject).eMv += j;
                if (((a)localObject).eMv >= ((a)localObject).eMy.length) {
                  ((a)localObject).eMv = 0;
                }
                label503:
                ((a)localObject).eMx -= j;
              }
            }
            if (i <= ((a)localObject).eMy.length) {
              break label1138;
            }
            j = ((a)localObject).eMy.length;
            k = ((a)localObject).eMy.length;
            j = i - j + 0;
            i = k;
            if (i > ((a)localObject).eMy.length - ((a)localObject).eMw) {
              break label1073;
            }
            System.arraycopy(paramArrayOfShort, j, ((a)localObject).eMy, ((a)localObject).eMw, i);
            ((a)localObject).eMw += i;
            if (((a)localObject).eMw >= ((a)localObject).eMy.length) {
              ((a)localObject).eMw = 0;
            }
            label618:
            ((a)localObject).eMx = (i + ((a)localObject).eMx);
          }
        }
        y.d(TAG, "isSilent %s", new Object[] { Boolean.valueOf(this.eMz) });
        if ((this.eMz) || (this.eMI == null)) {
          break;
        }
        this.eMI.b(paramArrayOfShort, paramInt);
        return;
        if ((this.eMA == 3) && (i == 2)) {
          this.eMB = false;
        }
        if ((this.eMA != 3) || (i != 3))
        {
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.eME);
        }
      }
      label735:
      if ((this.eMA == 3) && (i == 2))
      {
        this.eMA = i;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.eME);
        l = System.currentTimeMillis();
        if (this.eMI != null) {
          this.eMI.TB();
        }
        this.eMD = l;
        if (this.eMF) {
          break;
        }
        i = this.eMG.eMx;
        k = this.eMJ.length;
        if (i > 0) {
          if (k <= i) {
            break label1149;
          }
        }
      }
      label824:
      label1138:
      label1144:
      label1149:
      for (j = i;; j = k)
      {
        this.eMG.c(this.eMJ, j);
        m = i - j;
        i = m;
        if (this.eMI == null) {
          break label824;
        }
        this.eMI.b(this.eMJ, j);
        i = m;
        break label824;
        this.eMz = false;
        break label377;
        if ((this.eMA == 2) && (i == 3))
        {
          this.eMA = i;
          this.eMz = true;
          this.handler.removeMessages(0);
          this.handler.sendEmptyMessageDelayed(0, this.eME);
          l = System.currentTimeMillis();
          if (this.eMI != null) {
            this.eMI.TA();
          }
          this.eMD = l;
          if (!this.eMF) {
            break label377;
          }
          return;
        }
        if ((this.eMA == 3) && (i == 3))
        {
          this.eMz = true;
          break label377;
        }
        if ((this.eMA != 2) || (i != 2)) {
          break label377;
        }
        this.eMz = false;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.eME);
        break label377;
        break;
        j = ((a)localObject).eMx;
        break label453;
        ((a)localObject).eMv = (j - (((a)localObject).eMy.length - ((a)localObject).eMv));
        break label503;
        k = ((a)localObject).eMy.length - ((a)localObject).eMw;
        System.arraycopy(paramArrayOfShort, j, ((a)localObject).eMy, ((a)localObject).eMw, k);
        m = i - k;
        System.arraycopy(paramArrayOfShort, k + j, ((a)localObject).eMy, 0, m);
        ((a)localObject).eMw = m;
        break label618;
        j = 0;
        break label553;
        i = paramInt;
        break label408;
      }
    }
  }
  
  public final void release()
  {
    y.d(TAG, "released");
    this.eMF = true;
    this.eMB = false;
    this.eMC = false;
    if (this.eMH != null)
    {
      com.qq.wx.voice.vad.a locala = this.eMH;
      int i;
      if (locala.handle == 0L) {
        i = 1;
      }
      while (i == 1)
      {
        throw new b();
        if (com.qq.wx.voice.vad.a.DEBUG) {
          System.out.println("EVad Release handle = " + locala.handle);
        }
        if (com.qq.wx.voice.vad.a.aVB) {
          i = locala.aVA.Release(locala.handle);
        } else {
          i = locala.aVz.Release(locala.handle);
        }
      }
      this.eMH = null;
    }
    this.eMG = null;
    this.eMJ = null;
    if (this.handler != null)
    {
      this.handler.removeMessages(0);
      this.handler = null;
    }
    this.eMI = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.c
 * JD-Core Version:    0.7.0.1
 */