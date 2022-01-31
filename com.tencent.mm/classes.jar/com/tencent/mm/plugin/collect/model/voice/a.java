package com.tencent.mm.plugin.collect.model.voice;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class a
  implements n.b
{
  public static final String hVk;
  public static boolean kOb;
  public static float kOc;
  public static float kOd;
  public static final String kOe;
  public static final String kOf;
  private static a kOl;
  public d kOg;
  public a.c kOh;
  public a.b kOi;
  private String kOj;
  private int kOk;
  public com.tencent.mm.sdk.b.c<bg> kOm;
  public com.tencent.mm.sdk.b.c<nl> kOn;
  private boolean kOo;
  private Object lock;
  
  static
  {
    AppMethodBeat.i(41024);
    kOb = false;
    kOc = 0.9F;
    kOd = 10.0F;
    hVk = com.tencent.mm.compatible.util.e.eQu + "files/wxofflinevoice/";
    kOe = hVk + "libreadMoney.so";
    kOf = hVk + "woman_putonghua.pos";
    AppMethodBeat.o(41024);
  }
  
  public a()
  {
    AppMethodBeat.i(41012);
    this.lock = new Object();
    this.kOk = 0;
    this.kOm = new a.1(this);
    this.kOn = new com.tencent.mm.sdk.b.c()
    {
      private boolean bhQ()
      {
        AppMethodBeat.i(41007);
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent");
        synchronized (a.a(a.this))
        {
          com.tencent.mm.plugin.collect.a.a.bhw();
          if (com.tencent.mm.plugin.collect.a.a.bhy())
          {
            a.b(a.this);
            AppMethodBeat.o(41007);
            return false;
          }
          ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent isF2fRingToneOpen() == false");
        }
      }
    };
    this.kOo = false;
    AppMethodBeat.o(41012);
  }
  
  private boolean Jr(String paramString)
  {
    AppMethodBeat.i(154256);
    ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() resMd5:%s", new Object[] { bo.bf(paramString, "null") });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(154256);
      return true;
    }
    ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "verifyDefaultRes() %s md5:%s", new Object[] { kOf, com.tencent.mm.a.g.getMD5(kOf) });
    if (paramString.equalsIgnoreCase(com.tencent.mm.a.g.getMD5(kOf)))
    {
      AppMethodBeat.o(154256);
      return true;
    }
    com.tencent.mm.vfs.e.deleteFile(kOf);
    dB("0", "");
    if (this.kOk < 5)
    {
      this.kOm.alive();
      b.c.dmg();
      com.tencent.mm.pluginsdk.g.a.a.b.LE(60);
      this.kOk += 1;
    }
    AppMethodBeat.o(154256);
    return false;
  }
  
  private static String Js(String paramString)
  {
    AppMethodBeat.i(154258);
    paramString = as.apq("voice_offline_res").getString(paramString + "_md5", "");
    AppMethodBeat.o(154258);
    return paramString;
  }
  
  public static a bhJ()
  {
    AppMethodBeat.i(41013);
    try
    {
      if (kOl == null) {
        kOl = new a();
      }
      a locala = kOl;
      AppMethodBeat.o(41013);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(41013);
    }
  }
  
  private void bhL()
  {
    AppMethodBeat.i(41016);
    if (bhM())
    {
      kOb = true;
      ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() success!!");
      AppMethodBeat.o(41016);
      return;
    }
    kOb = false;
    ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() fail!!");
    AppMethodBeat.o(41016);
  }
  
  private boolean bhM()
  {
    AppMethodBeat.i(41017);
    com.tencent.mm.vfs.e.um(hVk);
    Object localObject1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yLU, "0");
    int i;
    if (bo.isEqual((String)localObject1, "0")) {
      if (bhN())
      {
        this.kOj = "woman_putonghua";
        i = 1;
      }
    }
    Object localObject2;
    String str;
    while (i == 0)
    {
      AppMethodBeat.o(41017);
      return false;
      this.kOj = "";
      i = 0;
      continue;
      localObject2 = as.apq("voice_offline_res").getString((String)localObject1, "");
      if ((!bo.isNullOrNil((String)localObject2)) && (com.tencent.mm.vfs.e.cN((String)localObject2)))
      {
        str = Js((String)localObject1);
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() resMd5:%s", new Object[] { bo.bf(str, "null") });
        if (bo.isNullOrNil(str))
        {
          this.kOj = ((String)localObject1);
          i = 1;
        }
        else
        {
          ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkResEnviroment() %s md5:%s", new Object[] { localObject2, com.tencent.mm.a.g.getMD5((String)localObject2) });
          if (str.equalsIgnoreCase(com.tencent.mm.a.g.getMD5((String)localObject2)))
          {
            this.kOj = ((String)localObject1);
            i = 1;
          }
          else
          {
            com.tencent.mm.vfs.e.deleteFile((String)localObject2);
            dB((String)localObject1, "");
            if (bhN())
            {
              this.kOj = "woman_putonghua";
              i = 1;
            }
            else
            {
              this.kOj = "";
              i = 0;
            }
          }
        }
      }
      else
      {
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "resPath:%s %s", new Object[] { bo.bf((String)localObject2, "null"), Boolean.valueOf(com.tencent.mm.vfs.e.cN((String)localObject2)) });
        if (bhN())
        {
          this.kOj = "woman_putonghua";
          i = 1;
        }
        else
        {
          this.kOj = "";
          i = 0;
        }
      }
    }
    if (this.kOg != null) {}
    for (;;)
    {
      try
      {
        this.kOg.kOA.destroy();
        this.kOg = d.a.kOB;
        localObject1 = this.kOg;
        localObject2 = this.kOi;
        ((d)localObject1).kOA.kOs = ((c)localObject2);
        localObject1 = this.kOg;
        localObject2 = hVk;
        str = this.kOj;
        i = ((d)localObject1).kOA.dC((String)localObject2, str);
        if (i >= 0) {
          break;
        }
        ab.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "init failed by ret = ".concat(String.valueOf(i)));
        if (bo.hl(i, -201))
        {
          if (!bo.isEqual(this.kOj, "woman_putonghua"))
          {
            ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voiceResName:%s fail, setVoiceOfflineLanguageResId(VOICE_DEFAULT_RES_ID)", new Object[] { this.kOj });
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLU, "0");
            com.tencent.mm.sdk.b.a.ymk.l(new nl());
            bhL();
          }
          AppMethodBeat.o(41017);
          return false;
        }
      }
      catch (Exception localException)
      {
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "synthesizer.destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(41017);
        return false;
      }
      if (bo.hl(i, -207))
      {
        boolean bool = com.tencent.mm.vfs.e.deleteFile(kOe);
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ErrorCode.TTS_INIT_SO_ERROR delete %s : %s", new Object[] { kOe, Boolean.valueOf(bool) });
      }
      else if ((i <= -9) && (i >= -2))
      {
        com.tencent.mm.vfs.e.deleteFile(this.kOj);
        if ((bo.isEqual(this.kOj, "woman_putonghua")) && (this.kOk < 5))
        {
          this.kOm.alive();
          b.c.dmg();
          com.tencent.mm.pluginsdk.g.a.a.b.LE(60);
          this.kOk += 1;
        }
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ret:%s delete %s : %s", new Object[] { Integer.valueOf(i), this.kOj, Integer.valueOf(this.kOk) });
      }
    }
    this.kOk = 0;
    d locald = this.kOg;
    float f = kOd;
    locald.kOA.mVolume = f;
    locald = this.kOg;
    f = kOc;
    locald.kOA.Dq = f;
    AppMethodBeat.o(41017);
    return true;
  }
  
  private boolean bhN()
  {
    AppMethodBeat.i(41018);
    if (com.tencent.mm.vfs.e.cN(kOf))
    {
      bool = bhO();
      AppMethodBeat.o(41018);
      return bool;
    }
    b.c.dmg();
    String str = com.tencent.mm.pluginsdk.g.a.a.b.hc(60, 2);
    boolean bool = com.tencent.mm.vfs.e.cN(str);
    ab.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", new Object[] { str });
    ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResEnviroment() %s no exist, cacheExist: %s", new Object[] { kOf, Boolean.valueOf(bool) });
    if (bool)
    {
      long l = com.tencent.mm.vfs.e.C(str, kOf);
      dB("0", "");
      ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_DEFAULT_RES_PATH result == %s", new Object[] { Long.valueOf(l) });
      if (!bo.ah(l, -1L))
      {
        b.c.dmg();
        str = com.tencent.mm.pluginsdk.g.a.a.b.dmc();
        dB("0", str);
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResEnviroment() getOriginalMd5() resMd5:%s", new Object[] { str });
        bool = Jr(str);
        AppMethodBeat.o(41018);
        return bool;
      }
    }
    this.kOm.alive();
    b.c.dmg();
    com.tencent.mm.pluginsdk.g.a.a.b.LE(60);
    AppMethodBeat.o(41018);
    return false;
  }
  
  private boolean bhO()
  {
    AppMethodBeat.i(154257);
    boolean bool = Jr(Js("0"));
    AppMethodBeat.o(154257);
    return bool;
  }
  
  public static void dB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154259);
    as.apq("voice_offline_res").edit().putString(paramString1 + "_md5", bo.bf(paramString2, "")).commit();
    AppMethodBeat.o(154259);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(41014);
    ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()");
    if (this.kOo)
    {
      AppMethodBeat.o(41014);
      return;
    }
    if (bhK())
    {
      ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange() remove self");
      this.kOo = true;
      com.tencent.mm.kernel.g.RL().Ru().b(this);
    }
    AppMethodBeat.o(41014);
  }
  
  public final void a(by paramby)
  {
    AppMethodBeat.i(41019);
    paramby = new a.a(this, paramby);
    this.kOi.a(paramby);
    this.kOg.start(paramby.cpu);
    ab.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "produceVoice() %s", new Object[] { paramby.cpu });
    AppMethodBeat.o(41019);
  }
  
  public final boolean bhK()
  {
    AppMethodBeat.i(41015);
    synchronized (this.lock)
    {
      if (kOb)
      {
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() OFF_LINE == true");
        AppMethodBeat.o(41015);
        return true;
      }
      com.tencent.mm.plugin.collect.a.a.bhw();
      if (com.tencent.mm.plugin.collect.a.a.bhy())
      {
        this.kOn.alive();
        if (!bhM())
        {
          ab.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() fail!! ");
          kOb = false;
          AppMethodBeat.o(41015);
          return true;
        }
        ab.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() success!! ");
        kOb = true;
      }
    }
    ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "isF2fRingToneOpen() == false");
    AppMethodBeat.o(41015);
    return false;
  }
  
  public final String bhP()
  {
    AppMethodBeat.i(41022);
    if (bo.isEqual(this.kOj, "woman_putonghua")) {}
    for (String str = "0";; str = this.kOj)
    {
      AppMethodBeat.o(41022);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.a
 * JD-Core Version:    0.7.0.1
 */