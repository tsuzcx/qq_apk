package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lw;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOperateMusicPlayer
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 47;
  public static final String NAME = "operateMusicPlayer";
  OperateMusicPlayer kbZ;
  
  static class OperateMusicPlayer
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateMusicPlayer> CREATOR;
    public int action;
    g.c cbu;
    public String djj;
    public boolean error;
    public String errorMsg;
    private int jOT;
    private m jXc;
    private q jiP;
    public String jsonString;
    y.b kcb;
    com.tencent.mm.plugin.appbrand.ui.banner.f kcc;
    public String kcd;
    private final com.tencent.mm.sdk.b.c kce;
    
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
      this.kce = new com.tencent.mm.sdk.b.c() {};
      e(paramParcel);
      AppMethodBeat.o(45918);
    }
    
    public OperateMusicPlayer(m paramm, q paramq, int paramInt)
    {
      AppMethodBeat.i(45917);
      this.error = false;
      this.kce = new com.tencent.mm.sdk.b.c() {};
      this.jXc = paramm;
      this.jiP = paramq;
      this.jOT = paramInt;
      AppMethodBeat.o(45917);
    }
    
    public final void aLq()
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
        if (bs.isNullOrNil(str1))
        {
          this.action = -1;
          this.error = true;
          this.errorMsg = "operationType is null or nil";
          bet();
          AppMethodBeat.o(45919);
          return;
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.JsApiOperateMusicPlayer", localException.toString());
        this.action = -1;
        this.error = true;
        this.errorMsg = "data is null";
        bet();
        AppMethodBeat.o(45919);
        return;
      }
      if (!a.a.boE().dQ(this.djj, str1))
      {
        ac.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
        this.action = -1;
        this.error = true;
        this.errorMsg = "appid not match cannot operate";
        bet();
        AppMethodBeat.o(45919);
        return;
      }
      Object localObject1 = str1;
      if (com.tencent.mm.ay.a.aGx())
      {
        localObject1 = str1;
        if (!com.tencent.mm.ay.a.aGv())
        {
          localObject1 = str1;
          if (str1.equalsIgnoreCase("play"))
          {
            localObject1 = com.tencent.mm.ay.a.aGy();
            if ((localObject1 == null) || ((!bs.isNullOrNil(str2)) && (!str2.equals(((com.tencent.mm.ay.f)localObject1).hNY)))) {
              break label331;
            }
            if (!a.a.boE().dQ(this.djj, "resume")) {
              break label319;
            }
            ac.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[] { this.djj });
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
        if (bs.isNullOrNil(str2))
        {
          this.action = -1;
          this.error = true;
          this.errorMsg = "dataUrl is null or nil";
          bet();
          AppMethodBeat.o(45919);
          return;
          label319:
          ac.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
          localObject1 = str1;
          continue;
          label331:
          ac.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
          localObject1 = str1;
        }
        else
        {
          ac.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", new Object[] { localObject1, str1, str3, localObject2, str2, str2, str2 });
          com.tencent.mm.ay.a.aGt();
          String str4 = a.a.boE().lrM;
          if (!bs.isNullOrNil(str4))
          {
            ac.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { str4, this.djj });
            a.a.boE().ON(str4);
          }
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45910);
              String str1 = new StringBuilder().append(JsApiOperateMusicPlayer.OperateMusicPlayer.this.djj).append(str2).append(this.kcg).toString().hashCode();
              String str2 = this.kcg;
              String str3 = this.kcg;
              String str4 = this.cNi;
              String str5 = str1;
              String str6 = str2;
              String str7 = str2;
              String str8 = str2;
              String str9 = com.tencent.mm.loader.j.b.aph();
              String str10 = com.tencent.mm.plugin.image.d.awL() + this.kcg.hashCode();
              String str11 = str3;
              com.tencent.mm.ay.f localf = new com.tencent.mm.ay.f();
              localf.hNQ = 7;
              localf.hNX = str2;
              localf.hOj = str3;
              localf.hNU = str4;
              localf.hNV = str5;
              localf.hOa = str6;
              localf.hNZ = str7;
              localf.hNY = str8;
              localf.hOd = str9;
              localf.hOf = "";
              localf.hOc = str10;
              localf.hNS = str1;
              localf.hNT = 0.0F;
              localf.hNW = str11;
              localf.hNR = 1;
              localf.hOb = null;
              localf.hOi = str1;
              localf.hOo = true;
              com.tencent.mm.ay.a.c(localf);
              a.a.boE().a(JsApiOperateMusicPlayer.OperateMusicPlayer.b(JsApiOperateMusicPlayer.OperateMusicPlayer.this), JsApiOperateMusicPlayer.OperateMusicPlayer.this.djj);
              a.a.boE().lrM = JsApiOperateMusicPlayer.OperateMusicPlayer.this.djj;
              a.a.boE().lrN = localf.hNS;
              ac.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
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
        localObject1 = a.a.boE().lrM;
        if (!bs.isNullOrNil((String)localObject1))
        {
          ac.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { localObject1, this.djj });
          a.a.boE().ON((String)localObject1);
        }
        a.a.boE().a(this.kce, this.djj);
        a.a.boE().lrM = this.djj;
        localObject1 = com.tencent.mm.ay.a.aGy();
        if (localObject1 != null) {
          a.a.boE().lrN = ((com.tencent.mm.ay.f)localObject1).hNS;
        }
        if (com.tencent.mm.ay.b.aGA())
        {
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45911);
              ac.i("MicroMsg.JsApiOperateMusicPlayer", "resume ok");
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
        ac.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
        this.action = -1;
        this.error = true;
        this.errorMsg = "resume play fail";
        bet();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("pause"))
      {
        if (com.tencent.mm.ay.b.aGB())
        {
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45912);
              ac.i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
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
        ac.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
        this.action = -1;
        this.error = true;
        this.errorMsg = "pause play fail";
        bet();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("seek"))
      {
        if (com.tencent.mm.ay.a.pl(bs.getInt(bs.dQ(((JSONObject)localObject2).optString("position")), -1) * 1000))
        {
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45913);
              ac.i("MicroMsg.JsApiOperateMusicPlayer", "seek ok");
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
        ac.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
        this.action = -1;
        this.error = true;
        this.errorMsg = "seek fail";
        bet();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("stop"))
      {
        if (com.tencent.mm.ay.b.aGC())
        {
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45914);
              ac.i("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
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
        ac.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
        this.action = -1;
        this.error = false;
        this.errorMsg = "stop play fail";
        bet();
        AppMethodBeat.o(45919);
        return;
      }
      this.action = -1;
      this.error = true;
      bet();
      AppMethodBeat.o(45919);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(45920);
      ac.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[] { Integer.valueOf(this.action) });
      q localq = this.jiP;
      int i = this.jOT;
      m localm = this.jXc;
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
        ac.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
        new JsApiOperateMusicPlayer.c((byte)0).g(this.jiP).LN(this.kcd).beN();
        this.kcb.l("Music#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.kcc);
        g.a(this.jiP.getAppId(), this.cbu);
        AppMethodBeat.o(45920);
        return;
        ac.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
        this.kcb.l("Music#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.kcc);
        g.a(this.jiP.getAppId(), this.cbu);
        AppMethodBeat.o(45920);
        return;
        ac.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
        new JsApiOperateMusicPlayer.a((byte)0).g(this.jiP).LN(this.kcd).beN();
        ac.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
        this.kcb.l("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.kcc);
        g.b(this.jiP.getAppId(), this.cbu);
        AppMethodBeat.o(45920);
        return;
        ac.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
        new JsApiOperateMusicPlayer.b((byte)0).g(this.jiP).LN(this.kcd).beN();
        this.kcb.l("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.kcc);
        g.b(this.jiP.getAppId(), this.cbu);
        AppMethodBeat.o(45920);
        return;
        ac.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
        this.jiP.c("onMusicError", this.kcd, 0);
        this.kcb.l("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.kcc);
        g.b(this.jiP.getAppId(), this.cbu);
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45921);
      this.jsonString = paramParcel.readString();
      this.djj = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.error = bool;
        this.kcd = paramParcel.readString();
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
      paramParcel.writeString(this.djj);
      if (this.error) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.kcd);
        paramParcel.writeInt(this.action);
        paramParcel.writeString(this.errorMsg);
        AppMethodBeat.o(45922);
        return;
      }
    }
  }
  
  static final class a
    extends p
  {
    private static final int CTRL_INDEX = 82;
    private static final String NAME = "onMusicEnd";
  }
  
  static final class b
    extends p
  {
    private static final int CTRL_INDEX = 81;
    private static final String NAME = "onMusicPause";
  }
  
  static final class c
    extends p
  {
    private static final int CTRL_INDEX = 80;
    private static final String NAME = "onMusicPlay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer
 * JD-Core Version:    0.7.0.1
 */