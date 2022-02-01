package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.lifecycle.q;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOperateMusicPlayer
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 47;
  public static final String NAME = "operateMusicPlayer";
  OperateMusicPlayer rDA;
  
  static class OperateMusicPlayer
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateMusicPlayer> CREATOR;
    public int action;
    public String appid;
    k.c eok;
    public boolean error;
    public String errorMsg;
    public String hTL;
    private y qqV;
    ad.b rDC;
    com.tencent.mm.plugin.appbrand.ui.banner.f rDD;
    public String rDE;
    private final IListener rDF;
    private int ror;
    private p rzh;
    
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
      this.rDF = new IListener(com.tencent.mm.app.f.hfK) {};
      h(paramParcel);
      AppMethodBeat.o(45918);
    }
    
    public OperateMusicPlayer(p paramp, y paramy, int paramInt)
    {
      AppMethodBeat.i(45917);
      this.error = false;
      this.rDF = new IListener(com.tencent.mm.app.f.hfK) {};
      this.rzh = paramp;
      this.qqV = paramy;
      this.ror = paramInt;
      AppMethodBeat.o(45917);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45919);
      Object localObject2;
      final String str1;
      final String str2;
      try
      {
        localObject2 = new JSONObject(this.hTL);
        str1 = ((JSONObject)localObject2).optString("operationType");
        str2 = ((JSONObject)localObject2).optString("dataUrl");
        if (Util.isNullOrNil(str1))
        {
          this.action = -1;
          this.error = true;
          this.errorMsg = "operationType is null or nil";
          cpA();
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
        cpA();
        AppMethodBeat.o(45919);
        return;
      }
      if (!a.a.cBB().eX(this.appid, str1))
      {
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
        this.action = -1;
        this.error = true;
        this.errorMsg = "appid not match cannot operate";
        cpA();
        AppMethodBeat.o(45919);
        return;
      }
      Object localObject1 = str1;
      if (com.tencent.mm.aw.a.bLm())
      {
        localObject1 = str1;
        if (!com.tencent.mm.aw.a.bLk())
        {
          localObject1 = str1;
          if (str1.equalsIgnoreCase("play"))
          {
            localObject1 = com.tencent.mm.aw.a.bLn();
            if ((localObject1 == null) || ((!Util.isNullOrNil(str2)) && (!str2.equals(((com.tencent.mm.aw.f)localObject1).oOB)))) {
              break label331;
            }
            if (!a.a.cBB().eX(this.appid, "resume")) {
              break label319;
            }
            Log.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[] { this.appid });
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
          cpA();
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
          com.tencent.mm.aw.a.bLi();
          String str4 = a.a.cBB().tib;
          if (!Util.isNullOrNil(str4))
          {
            Log.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { str4, this.appid });
            a.a.cBB().adD(str4);
          }
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45910);
              String str1 = new StringBuilder().append(JsApiOperateMusicPlayer.OperateMusicPlayer.this.appid).append(str2).append(this.rDH).toString().hashCode();
              String str2 = this.rDH;
              String str3 = this.rDH;
              String str4 = this.eSG;
              String str5 = str1;
              String str6 = str2;
              String str7 = str2;
              String str8 = str2;
              String str9 = com.tencent.mm.loader.i.b.bmz();
              String str10 = com.tencent.mm.plugin.image.d.bzL() + this.rDH.hashCode();
              String str11 = str3;
              com.tencent.mm.aw.f localf = new com.tencent.mm.aw.f();
              localf.oOt = 7;
              localf.oOA = str2;
              localf.oOM = str3;
              localf.oOx = str4;
              localf.oOy = str5;
              localf.oOD = str6;
              localf.oOC = str7;
              localf.oOB = str8;
              localf.oOG = str9;
              localf.oOI = "";
              localf.oOF = str10;
              localf.oOv = str1;
              localf.oOw = 0.0F;
              localf.oOz = str11;
              localf.oOu = 1;
              localf.oOE = null;
              localf.oOL = str1;
              localf.oOR = true;
              com.tencent.mm.aw.a.c(localf);
              a.a.cBB().a(JsApiOperateMusicPlayer.OperateMusicPlayer.b(JsApiOperateMusicPlayer.OperateMusicPlayer.this), JsApiOperateMusicPlayer.OperateMusicPlayer.this.appid);
              a.a.cBB().tib = JsApiOperateMusicPlayer.OperateMusicPlayer.this.appid;
              a.a.cBB().tic = localf.oOv;
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
        localObject1 = a.a.cBB().tib;
        if (!Util.isNullOrNil((String)localObject1))
        {
          Log.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { localObject1, this.appid });
          a.a.cBB().adD((String)localObject1);
        }
        a.a.cBB().a(this.rDF, this.appid);
        a.a.cBB().tib = this.appid;
        localObject1 = com.tencent.mm.aw.a.bLn();
        if (localObject1 != null) {
          a.a.cBB().tic = ((com.tencent.mm.aw.f)localObject1).oOv;
        }
        if (com.tencent.mm.aw.b.bLp())
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
        cpA();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("pause"))
      {
        if (com.tencent.mm.aw.b.bLq())
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
        cpA();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("seek"))
      {
        if (com.tencent.mm.aw.a.wH(Util.getInt(Util.notNullToString(((JSONObject)localObject2).optString("position")), -1) * 1000))
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
        cpA();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("stop"))
      {
        if (com.tencent.mm.aw.b.bLr())
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
        cpA();
        AppMethodBeat.o(45919);
        return;
      }
      this.action = -1;
      this.error = true;
      cpA();
      AppMethodBeat.o(45919);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45920);
      Log.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[] { Integer.valueOf(this.action) });
      y localy = this.qqV;
      int i = this.ror;
      p localp = this.rzh;
      String str;
      if (this.error)
      {
        StringBuilder localStringBuilder = new StringBuilder("fail");
        if (TextUtils.isEmpty(this.errorMsg))
        {
          str = "";
          str = str;
          label87:
          localy.callback(i, localp.ZP(str));
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
        new JsApiOperateMusicPlayer.c((byte)0).h(this.qqV).ZQ(this.rDE).cpV();
        this.rDC.q("Music#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.rDD);
        k.a(this.qqV.getAppId(), this.eok);
        AppMethodBeat.o(45920);
        return;
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
        this.rDC.q("Music#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.rDD);
        k.a(this.qqV.getAppId(), this.eok);
        AppMethodBeat.o(45920);
        return;
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
        new JsApiOperateMusicPlayer.a((byte)0).h(this.qqV).ZQ(this.rDE).cpV();
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
        this.rDC.q("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.rDD);
        k.b(this.qqV.getAppId(), this.eok);
        AppMethodBeat.o(45920);
        return;
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
        new JsApiOperateMusicPlayer.b((byte)0).h(this.qqV).ZQ(this.rDE).cpV();
        this.rDC.q("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.rDD);
        k.b(this.qqV.getAppId(), this.eok);
        AppMethodBeat.o(45920);
        return;
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
        this.qqV.cJ("onMusicError", this.rDE);
        this.rDC.q("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.rDD);
        k.b(this.qqV.getAppId(), this.eok);
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(45921);
      this.hTL = paramParcel.readString();
      this.appid = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.error = bool;
        this.rDE = paramParcel.readString();
        this.action = paramParcel.readInt();
        this.errorMsg = paramParcel.readString();
        AppMethodBeat.o(45921);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45922);
      paramParcel.writeString(this.hTL);
      paramParcel.writeString(this.appid);
      if (this.error) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.rDE);
        paramParcel.writeInt(this.action);
        paramParcel.writeString(this.errorMsg);
        AppMethodBeat.o(45922);
        return;
      }
    }
  }
  
  static final class a
    extends s
  {
    private static final int CTRL_INDEX = 82;
    private static final String NAME = "onMusicEnd";
  }
  
  static final class b
    extends s
  {
    private static final int CTRL_INDEX = 81;
    private static final String NAME = "onMusicPause";
  }
  
  static final class c
    extends s
  {
    private static final int CTRL_INDEX = 80;
    private static final String NAME = "onMusicPlay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer
 * JD-Core Version:    0.7.0.1
 */