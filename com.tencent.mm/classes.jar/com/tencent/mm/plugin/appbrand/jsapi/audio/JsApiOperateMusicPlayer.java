package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOperateMusicPlayer
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 47;
  public static final String NAME = "operateMusicPlayer";
  OperateMusicPlayer kwy;
  
  static class OperateMusicPlayer
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateMusicPlayer> CREATOR;
    public int action;
    g.c clL;
    public String duW;
    public boolean error;
    public String errorMsg;
    private q jCl;
    public String jsonString;
    private int kje;
    private m kry;
    y.b kwA;
    com.tencent.mm.plugin.appbrand.ui.banner.f kwB;
    public String kwC;
    private final com.tencent.mm.sdk.b.c kwD;
    
    static
    {
      AppMethodBeat.i(45929);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45929);
    }
    
    public OperateMusicPlayer(Parcel paramParcel)
    {
      AppMethodBeat.i(45918);
      this.error = false;
      this.kwD = new com.tencent.mm.sdk.b.c() {};
      e(paramParcel);
      AppMethodBeat.o(45918);
    }
    
    public OperateMusicPlayer(m paramm, q paramq, int paramInt)
    {
      AppMethodBeat.i(45917);
      this.error = false;
      this.kwD = new com.tencent.mm.sdk.b.c() {};
      this.kry = paramm;
      this.jCl = paramq;
      this.kje = paramInt;
      AppMethodBeat.o(45917);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45919);
      Object localObject2;
      final String str1;
      final String str2;
      try
      {
        localObject2 = new JSONObject(this.jsonString);
        str1 = ((JSONObject)localObject2).optString("operationType");
        str2 = ((JSONObject)localObject2).optString("dataUrl");
        if (bt.isNullOrNil(str1))
        {
          this.action = -1;
          this.error = true;
          this.errorMsg = "operationType is null or nil";
          bhX();
          AppMethodBeat.o(45919);
          return;
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.JsApiOperateMusicPlayer", localException.toString());
        this.action = -1;
        this.error = true;
        this.errorMsg = "data is null";
        bhX();
        AppMethodBeat.o(45919);
        return;
      }
      if (!a.a.bsD().dZ(this.duW, str1))
      {
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
        this.action = -1;
        this.error = true;
        this.errorMsg = "appid not match cannot operate";
        bhX();
        AppMethodBeat.o(45919);
        return;
      }
      Object localObject1 = str1;
      if (com.tencent.mm.az.a.aJI())
      {
        localObject1 = str1;
        if (!com.tencent.mm.az.a.aJG())
        {
          localObject1 = str1;
          if (str1.equalsIgnoreCase("play"))
          {
            localObject1 = com.tencent.mm.az.a.aJJ();
            if ((localObject1 == null) || ((!bt.isNullOrNil(str2)) && (!str2.equals(((com.tencent.mm.az.f)localObject1).ihm)))) {
              break label331;
            }
            if (!a.a.bsD().dZ(this.duW, "resume")) {
              break label319;
            }
            ad.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[] { this.duW });
            localObject1 = "resume";
          }
        }
      }
      while (((String)localObject1).equalsIgnoreCase("play"))
      {
        localObject1 = ((JSONObject)localObject2).optString("title");
        str1 = ((JSONObject)localObject2).optString("singer");
        final String str3 = ((JSONObject)localObject2).optString("epname");
        localObject2 = ((JSONObject)localObject2).optString("coverImgUrl");
        if (bt.isNullOrNil(str2))
        {
          this.action = -1;
          this.error = true;
          this.errorMsg = "dataUrl is null or nil";
          bhX();
          AppMethodBeat.o(45919);
          return;
          label319:
          ad.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
          localObject1 = str1;
          continue;
          label331:
          ad.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
          localObject1 = str1;
        }
        else
        {
          ad.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", new Object[] { localObject1, str1, str3, localObject2, str2, str2, str2 });
          com.tencent.mm.az.a.aJE();
          String str4 = a.a.bsD().lQW;
          if (!bt.isNullOrNil(str4))
          {
            ad.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { str4, this.duW });
            a.a.bsD().Sq(str4);
          }
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45910);
              String str1 = new StringBuilder().append(JsApiOperateMusicPlayer.OperateMusicPlayer.this.duW).append(str2).append(this.kwF).toString().hashCode();
              String str2 = this.kwF;
              String str3 = this.kwF;
              String str4 = this.cYy;
              String str5 = str1;
              String str6 = str2;
              String str7 = str2;
              String str8 = str2;
              String str9 = com.tencent.mm.loader.j.b.arU();
              String str10 = com.tencent.mm.plugin.image.d.azA() + this.kwF.hashCode();
              String str11 = str3;
              com.tencent.mm.az.f localf = new com.tencent.mm.az.f();
              localf.ihe = 7;
              localf.ihl = str2;
              localf.ihx = str3;
              localf.ihi = str4;
              localf.ihj = str5;
              localf.iho = str6;
              localf.ihn = str7;
              localf.ihm = str8;
              localf.ihr = str9;
              localf.iht = "";
              localf.ihq = str10;
              localf.ihg = str1;
              localf.ihh = 0.0F;
              localf.ihk = str11;
              localf.ihf = 1;
              localf.ihp = null;
              localf.ihw = str1;
              localf.ihC = true;
              com.tencent.mm.az.a.c(localf);
              a.a.bsD().a(JsApiOperateMusicPlayer.OperateMusicPlayer.b(JsApiOperateMusicPlayer.OperateMusicPlayer.this), JsApiOperateMusicPlayer.OperateMusicPlayer.this.duW);
              a.a.bsD().lQW = JsApiOperateMusicPlayer.OperateMusicPlayer.this.duW;
              a.a.bsD().lQX = localf.ihg;
              ad.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.action = -1;
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.errorMsg = "";
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.error = false;
              JsApiOperateMusicPlayer.OperateMusicPlayer.c(JsApiOperateMusicPlayer.OperateMusicPlayer.this);
              AppMethodBeat.o(45910);
            }
          }, 500L);
          AppMethodBeat.o(45919);
          return;
        }
      }
      if (((String)localObject1).equalsIgnoreCase("resume"))
      {
        localObject1 = a.a.bsD().lQW;
        if (!bt.isNullOrNil((String)localObject1))
        {
          ad.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { localObject1, this.duW });
          a.a.bsD().Sq((String)localObject1);
        }
        a.a.bsD().a(this.kwD, this.duW);
        a.a.bsD().lQW = this.duW;
        localObject1 = com.tencent.mm.az.a.aJJ();
        if (localObject1 != null) {
          a.a.bsD().lQX = ((com.tencent.mm.az.f)localObject1).ihg;
        }
        if (com.tencent.mm.az.b.aJL())
        {
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45911);
              ad.i("MicroMsg.JsApiOperateMusicPlayer", "resume ok");
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.action = -1;
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.errorMsg = "";
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.error = false;
              JsApiOperateMusicPlayer.OperateMusicPlayer.d(JsApiOperateMusicPlayer.OperateMusicPlayer.this);
              AppMethodBeat.o(45911);
            }
          }, 500L);
          AppMethodBeat.o(45919);
          return;
        }
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
        this.action = -1;
        this.error = true;
        this.errorMsg = "resume play fail";
        bhX();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("pause"))
      {
        if (com.tencent.mm.az.b.aJM())
        {
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45912);
              ad.i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.action = -1;
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.error = false;
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.errorMsg = "";
              JsApiOperateMusicPlayer.OperateMusicPlayer.e(JsApiOperateMusicPlayer.OperateMusicPlayer.this);
              AppMethodBeat.o(45912);
            }
          }, 500L);
          AppMethodBeat.o(45919);
          return;
        }
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
        this.action = -1;
        this.error = true;
        this.errorMsg = "pause play fail";
        bhX();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("seek"))
      {
        if (com.tencent.mm.az.a.pO(bt.getInt(bt.dT(((JSONObject)localObject2).optString("position")), -1) * 1000))
        {
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45913);
              ad.i("MicroMsg.JsApiOperateMusicPlayer", "seek ok");
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.action = -1;
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.error = false;
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.errorMsg = "";
              JsApiOperateMusicPlayer.OperateMusicPlayer.f(JsApiOperateMusicPlayer.OperateMusicPlayer.this);
              AppMethodBeat.o(45913);
            }
          }, 500L);
          AppMethodBeat.o(45919);
          return;
        }
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
        this.action = -1;
        this.error = true;
        this.errorMsg = "seek fail";
        bhX();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("stop"))
      {
        if (com.tencent.mm.az.b.aJN())
        {
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45914);
              ad.i("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.action = -1;
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.error = false;
              JsApiOperateMusicPlayer.OperateMusicPlayer.this.errorMsg = "";
              JsApiOperateMusicPlayer.OperateMusicPlayer.g(JsApiOperateMusicPlayer.OperateMusicPlayer.this);
              AppMethodBeat.o(45914);
            }
          }, 500L);
          AppMethodBeat.o(45919);
          return;
        }
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
        this.action = -1;
        this.error = false;
        this.errorMsg = "stop play fail";
        bhX();
        AppMethodBeat.o(45919);
        return;
      }
      this.action = -1;
      this.error = true;
      bhX();
      AppMethodBeat.o(45919);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45920);
      ad.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[] { Integer.valueOf(this.action) });
      q localq = this.jCl;
      int i = this.kje;
      m localm = this.kry;
      String str;
      if (this.error)
      {
        StringBuilder localStringBuilder = new StringBuilder("fail");
        if (TextUtils.isEmpty(this.errorMsg))
        {
          str = "";
          str = str;
          label87:
          localq.h(i, localm.e(str, null));
          switch (this.action)
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(45920);
        return;
        str = ":" + this.errorMsg;
        break;
        str = "ok";
        break label87;
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
        new JsApiOperateMusicPlayer.c((byte)0).g(this.jCl).Ph(this.kwC).bir();
        this.kwA.k("Music#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.kwB);
        g.a(this.jCl.getAppId(), this.clL);
        AppMethodBeat.o(45920);
        return;
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
        this.kwA.k("Music#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.kwB);
        g.a(this.jCl.getAppId(), this.clL);
        AppMethodBeat.o(45920);
        return;
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
        new JsApiOperateMusicPlayer.a((byte)0).g(this.jCl).Ph(this.kwC).bir();
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
        this.kwA.k("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.kwB);
        g.b(this.jCl.getAppId(), this.clL);
        AppMethodBeat.o(45920);
        return;
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
        new JsApiOperateMusicPlayer.b((byte)0).g(this.jCl).Ph(this.kwC).bir();
        this.kwA.k("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.kwB);
        g.b(this.jCl.getAppId(), this.clL);
        AppMethodBeat.o(45920);
        return;
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
        this.jCl.c("onMusicError", this.kwC, 0);
        this.kwA.k("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.kwB);
        g.b(this.jCl.getAppId(), this.clL);
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45921);
      this.jsonString = paramParcel.readString();
      this.duW = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.error = bool;
        this.kwC = paramParcel.readString();
        this.action = paramParcel.readInt();
        this.errorMsg = paramParcel.readString();
        AppMethodBeat.o(45921);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45922);
      paramParcel.writeString(this.jsonString);
      paramParcel.writeString(this.duW);
      if (this.error) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.kwC);
        paramParcel.writeInt(this.action);
        paramParcel.writeString(this.errorMsg);
        AppMethodBeat.o(45922);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer
 * JD-Core Version:    0.7.0.1
 */