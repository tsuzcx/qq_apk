package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOperateMusicPlayer
  extends com.tencent.mm.plugin.appbrand.jsapi.d<c>
{
  public static final int CTRL_INDEX = 47;
  public static final String NAME = "operateMusicPlayer";
  OperateMusicPlayer lEg;
  
  static class OperateMusicPlayer
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateMusicPlayer> CREATOR;
    public int action;
    h.c cxI;
    public String dNI;
    public boolean error;
    public String errorMsg;
    public String jsonString;
    private com.tencent.mm.plugin.appbrand.s kGT;
    private p lAw;
    ad.b lEi;
    com.tencent.mm.plugin.appbrand.ui.banner.f lEj;
    public String lEk;
    private final IListener lEl;
    private int lqe;
    
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
      this.lEl = new IListener() {};
      f(paramParcel);
      AppMethodBeat.o(45918);
    }
    
    public OperateMusicPlayer(p paramp, com.tencent.mm.plugin.appbrand.s params, int paramInt)
    {
      AppMethodBeat.i(45917);
      this.error = false;
      this.lEl = new IListener() {};
      this.lAw = paramp;
      this.kGT = params;
      this.lqe = paramInt;
      AppMethodBeat.o(45917);
    }
    
    public final void bjj()
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
        if (Util.isNullOrNil(str1))
        {
          this.action = -1;
          this.error = true;
          this.errorMsg = "operationType is null or nil";
          bDU();
          AppMethodBeat.o(45919);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.JsApiOperateMusicPlayer", localException.toString());
        this.action = -1;
        this.error = true;
        this.errorMsg = "data is null";
        bDU();
        AppMethodBeat.o(45919);
        return;
      }
      if (!a.a.bOR().es(this.dNI, str1))
      {
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
        this.action = -1;
        this.error = true;
        this.errorMsg = "appid not match cannot operate";
        bDU();
        AppMethodBeat.o(45919);
        return;
      }
      Object localObject1 = str1;
      if (com.tencent.mm.ay.a.bee())
      {
        localObject1 = str1;
        if (!com.tencent.mm.ay.a.bec())
        {
          localObject1 = str1;
          if (str1.equalsIgnoreCase("play"))
          {
            localObject1 = com.tencent.mm.ay.a.bef();
            if ((localObject1 == null) || ((!Util.isNullOrNil(str2)) && (!str2.equals(((com.tencent.mm.ay.f)localObject1).jfb)))) {
              break label331;
            }
            if (!a.a.bOR().es(this.dNI, "resume")) {
              break label319;
            }
            Log.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[] { this.dNI });
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
        if (Util.isNullOrNil(str2))
        {
          this.action = -1;
          this.error = true;
          this.errorMsg = "dataUrl is null or nil";
          bDU();
          AppMethodBeat.o(45919);
          return;
          label319:
          Log.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
          localObject1 = str1;
          continue;
          label331:
          Log.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
          localObject1 = str1;
        }
        else
        {
          Log.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", new Object[] { localObject1, str1, str3, localObject2, str2, str2, str2 });
          com.tencent.mm.ay.a.bea();
          String str4 = a.a.bOR().ncY;
          if (!Util.isNullOrNil(str4))
          {
            Log.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { str4, this.dNI });
            a.a.bOR().acD(str4);
          }
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45910);
              String str1 = new StringBuilder().append(JsApiOperateMusicPlayer.OperateMusicPlayer.this.dNI).append(str2).append(this.lEn).toString().hashCode();
              String str2 = this.lEn;
              String str3 = this.lEn;
              String str4 = this.dqb;
              String str5 = str1;
              String str6 = str2;
              String str7 = str2;
              String str8 = str2;
              String str9 = com.tencent.mm.loader.j.b.aKJ();
              String str10 = com.tencent.mm.plugin.image.d.aSY() + this.lEn.hashCode();
              String str11 = str3;
              com.tencent.mm.ay.f localf = new com.tencent.mm.ay.f();
              localf.jeT = 7;
              localf.jfa = str2;
              localf.jfm = str3;
              localf.jeX = str4;
              localf.jeY = str5;
              localf.jfd = str6;
              localf.jfc = str7;
              localf.jfb = str8;
              localf.jfg = str9;
              localf.jfi = "";
              localf.jff = str10;
              localf.jeV = str1;
              localf.jeW = 0.0F;
              localf.jeZ = str11;
              localf.jeU = 1;
              localf.jfe = null;
              localf.jfl = str1;
              localf.jfr = true;
              com.tencent.mm.ay.a.c(localf);
              a.a.bOR().a(JsApiOperateMusicPlayer.OperateMusicPlayer.b(JsApiOperateMusicPlayer.OperateMusicPlayer.this), JsApiOperateMusicPlayer.OperateMusicPlayer.this.dNI);
              a.a.bOR().ncY = JsApiOperateMusicPlayer.OperateMusicPlayer.this.dNI;
              a.a.bOR().ncZ = localf.jeV;
              Log.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
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
        localObject1 = a.a.bOR().ncY;
        if (!Util.isNullOrNil((String)localObject1))
        {
          Log.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { localObject1, this.dNI });
          a.a.bOR().acD((String)localObject1);
        }
        a.a.bOR().a(this.lEl, this.dNI);
        a.a.bOR().ncY = this.dNI;
        localObject1 = com.tencent.mm.ay.a.bef();
        if (localObject1 != null) {
          a.a.bOR().ncZ = ((com.tencent.mm.ay.f)localObject1).jeV;
        }
        if (com.tencent.mm.ay.b.beh())
        {
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45911);
              Log.i("MicroMsg.JsApiOperateMusicPlayer", "resume ok");
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
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
        this.action = -1;
        this.error = true;
        this.errorMsg = "resume play fail";
        bDU();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("pause"))
      {
        if (com.tencent.mm.ay.b.bei())
        {
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45912);
              Log.i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
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
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
        this.action = -1;
        this.error = true;
        this.errorMsg = "pause play fail";
        bDU();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("seek"))
      {
        if (com.tencent.mm.ay.a.tG(Util.getInt(Util.notNullToString(((JSONObject)localObject2).optString("position")), -1) * 1000))
        {
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45913);
              Log.i("MicroMsg.JsApiOperateMusicPlayer", "seek ok");
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
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
        this.action = -1;
        this.error = true;
        this.errorMsg = "seek fail";
        bDU();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("stop"))
      {
        if (com.tencent.mm.ay.b.bej())
        {
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45914);
              Log.i("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
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
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
        this.action = -1;
        this.error = false;
        this.errorMsg = "stop play fail";
        bDU();
        AppMethodBeat.o(45919);
        return;
      }
      this.action = -1;
      this.error = true;
      bDU();
      AppMethodBeat.o(45919);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45920);
      Log.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[] { Integer.valueOf(this.action) });
      com.tencent.mm.plugin.appbrand.s locals = this.kGT;
      int i = this.lqe;
      p localp = this.lAw;
      String str;
      if (this.error)
      {
        StringBuilder localStringBuilder = new StringBuilder("fail");
        if (TextUtils.isEmpty(this.errorMsg))
        {
          str = "";
          str = str;
          label87:
          locals.i(i, localp.h(str, null));
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
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
        new JsApiOperateMusicPlayer.c((byte)0).g(this.kGT).Zg(this.lEk).bEo();
        this.lEi.l("Music#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.lEj);
        h.a(this.kGT.getAppId(), this.cxI);
        AppMethodBeat.o(45920);
        return;
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
        this.lEi.l("Music#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.lEj);
        h.a(this.kGT.getAppId(), this.cxI);
        AppMethodBeat.o(45920);
        return;
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
        new JsApiOperateMusicPlayer.a((byte)0).g(this.kGT).Zg(this.lEk).bEo();
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
        this.lEi.l("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.lEj);
        h.b(this.kGT.getAppId(), this.cxI);
        AppMethodBeat.o(45920);
        return;
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
        new JsApiOperateMusicPlayer.b((byte)0).g(this.kGT).Zg(this.lEk).bEo();
        this.lEi.l("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.lEj);
        h.b(this.kGT.getAppId(), this.cxI);
        AppMethodBeat.o(45920);
        return;
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
        this.kGT.c("onMusicError", this.lEk, 0);
        this.lEi.l("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.lEj);
        h.b(this.kGT.getAppId(), this.cxI);
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45921);
      this.jsonString = paramParcel.readString();
      this.dNI = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.error = bool;
        this.lEk = paramParcel.readString();
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
      paramParcel.writeString(this.dNI);
      if (this.error) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.lEk);
        paramParcel.writeInt(this.action);
        paramParcel.writeString(this.errorMsg);
        AppMethodBeat.o(45922);
        return;
      }
    }
  }
  
  static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.s
  {
    private static final int CTRL_INDEX = 82;
    private static final String NAME = "onMusicEnd";
  }
  
  static final class b
    extends com.tencent.mm.plugin.appbrand.jsapi.s
  {
    private static final int CTRL_INDEX = 81;
    private static final String NAME = "onMusicPause";
  }
  
  static final class c
    extends com.tencent.mm.plugin.appbrand.jsapi.s
  {
    private static final int CTRL_INDEX = 80;
    private static final String NAME = "onMusicPlay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer
 * JD-Core Version:    0.7.0.1
 */