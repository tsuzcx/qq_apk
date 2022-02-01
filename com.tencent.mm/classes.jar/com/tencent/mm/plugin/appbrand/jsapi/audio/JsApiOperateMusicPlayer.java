package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ln;
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
  OperateMusicPlayer jBD;
  
  static class OperateMusicPlayer
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateMusicPlayer> CREATOR;
    public int action;
    g.c cex;
    public String dlB;
    public boolean error;
    public String errorMsg;
    private q iIL;
    y.b jBF;
    com.tencent.mm.plugin.appbrand.ui.banner.f jBG;
    public String jBH;
    private final com.tencent.mm.sdk.b.c jBI;
    private int joH;
    public String jsonString;
    private m jwG;
    
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
      this.jBI = new com.tencent.mm.sdk.b.c() {};
      e(paramParcel);
      AppMethodBeat.o(45918);
    }
    
    public OperateMusicPlayer(m paramm, q paramq, int paramInt)
    {
      AppMethodBeat.i(45917);
      this.error = false;
      this.jBI = new com.tencent.mm.sdk.b.c() {};
      this.jwG = paramm;
      this.iIL = paramq;
      this.joH = paramInt;
      AppMethodBeat.o(45917);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(45920);
      ad.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[] { Integer.valueOf(this.action) });
      q localq = this.iIL;
      int i = this.joH;
      m localm = this.jwG;
      String str;
      if (this.error)
      {
        StringBuilder localStringBuilder = new StringBuilder("fail");
        if (TextUtils.isEmpty(this.errorMsg))
        {
          str = "";
          str = str;
          label83:
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
        break label83;
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
        new JsApiOperateMusicPlayer.c((byte)0).g(this.iIL).HJ(this.jBH).aXQ();
        this.jBF.m("Music#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.jBG);
        g.a(this.iIL.getAppId(), this.cex);
        AppMethodBeat.o(45920);
        return;
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
        this.jBF.m("Music#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.jBG);
        g.a(this.iIL.getAppId(), this.cex);
        AppMethodBeat.o(45920);
        return;
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
        new JsApiOperateMusicPlayer.a((byte)0).g(this.iIL).HJ(this.jBH).aXQ();
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
        this.jBF.m("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.jBG);
        g.b(this.iIL.getAppId(), this.cex);
        AppMethodBeat.o(45920);
        return;
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
        new JsApiOperateMusicPlayer.b((byte)0).g(this.iIL).HJ(this.jBH).aXQ();
        this.jBF.m("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.jBG);
        g.b(this.iIL.getAppId(), this.cex);
        AppMethodBeat.o(45920);
        return;
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
        this.iIL.c("onMusicError", this.jBH, 0);
        this.jBF.m("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.jBG);
        g.b(this.iIL.getAppId(), this.cex);
      }
    }
    
    public final void aEz()
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
          aXw();
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
        aXw();
        AppMethodBeat.o(45919);
        return;
      }
      if (!a.a.bhK().dE(this.dlB, str1))
      {
        ad.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
        this.action = -1;
        this.error = true;
        this.errorMsg = "appid not match cannot operate";
        aXw();
        AppMethodBeat.o(45919);
        return;
      }
      Object localObject1 = str1;
      if (com.tencent.mm.az.a.azH())
      {
        localObject1 = str1;
        if (!com.tencent.mm.az.a.azF())
        {
          localObject1 = str1;
          if (str1.equalsIgnoreCase("play"))
          {
            localObject1 = com.tencent.mm.az.a.azI();
            if ((localObject1 == null) || ((!bt.isNullOrNil(str2)) && (!str2.equals(((com.tencent.mm.az.f)localObject1).hnv)))) {
              break label353;
            }
            if (!a.a.bhK().dE(this.dlB, "resume")) {
              break label340;
            }
            ad.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[] { this.dlB });
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
          aXw();
          AppMethodBeat.o(45919);
          return;
          label340:
          ad.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
          localObject1 = str1;
          continue;
          label353:
          ad.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
          localObject1 = str1;
        }
        else
        {
          ad.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", new Object[] { localObject1, str1, str3, localObject2, str2, str2, str2 });
          com.tencent.mm.az.a.azD();
          String str4 = a.a.bhK().kQn;
          if (!bt.isNullOrNil(str4))
          {
            ad.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { str4, this.dlB });
            a.a.bhK().KG(str4);
          }
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45910);
              String str1 = new StringBuilder().append(JsApiOperateMusicPlayer.OperateMusicPlayer.this.dlB).append(str2).append(this.jBK).toString().hashCode();
              String str2 = this.jBK;
              String str3 = this.jBK;
              String str4 = this.cPN;
              String str5 = str1;
              String str6 = str2;
              String str7 = str2;
              String str8 = str2;
              String str9 = com.tencent.mm.loader.j.b.aih();
              String str10 = com.tencent.mm.plugin.image.d.apW() + this.jBK.hashCode();
              String str11 = str3;
              com.tencent.mm.az.f localf = new com.tencent.mm.az.f();
              localf.hnn = 7;
              localf.hnu = str2;
              localf.hnG = str3;
              localf.hnr = str4;
              localf.hns = str5;
              localf.hnx = str6;
              localf.hnw = str7;
              localf.hnv = str8;
              localf.hnA = str9;
              localf.hnC = "";
              localf.hnz = str10;
              localf.hnp = str1;
              localf.hnq = 0.0F;
              localf.hnt = str11;
              localf.hno = 1;
              localf.hny = null;
              localf.hnF = str1;
              localf.hnL = true;
              com.tencent.mm.az.a.c(localf);
              a.a.bhK().a(JsApiOperateMusicPlayer.OperateMusicPlayer.b(JsApiOperateMusicPlayer.OperateMusicPlayer.this), JsApiOperateMusicPlayer.OperateMusicPlayer.this.dlB);
              a.a.bhK().kQn = JsApiOperateMusicPlayer.OperateMusicPlayer.this.dlB;
              a.a.bhK().kQo = localf.hnp;
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
        localObject1 = a.a.bhK().kQn;
        if (!bt.isNullOrNil((String)localObject1))
        {
          ad.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { localObject1, this.dlB });
          a.a.bhK().KG((String)localObject1);
        }
        a.a.bhK().a(this.jBI, this.dlB);
        a.a.bhK().kQn = this.dlB;
        localObject1 = com.tencent.mm.az.a.azI();
        if (localObject1 != null) {
          a.a.bhK().kQo = ((com.tencent.mm.az.f)localObject1).hnp;
        }
        if (com.tencent.mm.az.b.azK())
        {
          aq.n(new Runnable()
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
        aXw();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("pause"))
      {
        if (com.tencent.mm.az.b.azL())
        {
          aq.n(new Runnable()
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
        aXw();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("seek"))
      {
        if (com.tencent.mm.az.a.ox(bt.getInt(bt.dP(((JSONObject)localObject2).optString("position")), -1) * 1000))
        {
          aq.n(new Runnable()
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
        aXw();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("stop"))
      {
        if (com.tencent.mm.az.b.azM())
        {
          aq.n(new Runnable()
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
        aXw();
        AppMethodBeat.o(45919);
        return;
      }
      this.action = -1;
      this.error = true;
      aXw();
      AppMethodBeat.o(45919);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45921);
      this.jsonString = paramParcel.readString();
      this.dlB = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.error = bool;
        this.jBH = paramParcel.readString();
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
      paramParcel.writeString(this.dlB);
      if (this.error) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.jBH);
        paramParcel.writeInt(this.action);
        paramParcel.writeString(this.errorMsg);
        AppMethodBeat.o(45922);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer
 * JD-Core Version:    0.7.0.1
 */