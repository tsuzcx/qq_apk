package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.np;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.v;
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
  OperateMusicPlayer ozH;
  
  static class OperateMusicPlayer
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateMusicPlayer> CREATOR;
    public int action;
    public String appid;
    k.c cwl;
    public boolean error;
    public String errorMsg;
    public String jsonString;
    private v nAz;
    private int okO;
    private o ovN;
    ad.b ozJ;
    com.tencent.mm.plugin.appbrand.ui.banner.f ozK;
    public String ozL;
    private final IListener ozM;
    
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
      this.ozM = new IListener() {};
      f(paramParcel);
      AppMethodBeat.o(45918);
    }
    
    public OperateMusicPlayer(o paramo, v paramv, int paramInt)
    {
      AppMethodBeat.i(45917);
      this.error = false;
      this.ozM = new IListener() {};
      this.ovN = paramo;
      this.nAz = paramv;
      this.okO = paramInt;
      AppMethodBeat.o(45917);
    }
    
    public final void RW()
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
          bPt();
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
        bPt();
        AppMethodBeat.o(45919);
        return;
      }
      if (!a.a.cbh().eG(this.appid, str1))
      {
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
        this.action = -1;
        this.error = true;
        this.errorMsg = "appid not match cannot operate";
        bPt();
        AppMethodBeat.o(45919);
        return;
      }
      Object localObject1 = str1;
      if (com.tencent.mm.bb.a.bnz())
      {
        localObject1 = str1;
        if (!com.tencent.mm.bb.a.bnx())
        {
          localObject1 = str1;
          if (str1.equalsIgnoreCase("play"))
          {
            localObject1 = com.tencent.mm.bb.a.bnA();
            if ((localObject1 == null) || ((!Util.isNullOrNil(str2)) && (!str2.equals(((com.tencent.mm.bb.f)localObject1).lVz)))) {
              break label331;
            }
            if (!a.a.cbh().eG(this.appid, "resume")) {
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
          bPt();
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
          com.tencent.mm.bb.a.bnv();
          String str4 = a.a.cbh().qdn;
          if (!Util.isNullOrNil(str4))
          {
            Log.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { str4, this.appid });
            a.a.cbh().akx(str4);
          }
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45910);
              String str1 = new StringBuilder().append(JsApiOperateMusicPlayer.OperateMusicPlayer.this.appid).append(str2).append(this.ozO).toString().hashCode();
              String str2 = this.ozO;
              String str3 = this.ozO;
              String str4 = this.cWz;
              String str5 = str1;
              String str6 = str2;
              String str7 = str2;
              String str8 = str2;
              String str9 = com.tencent.mm.loader.j.b.aSL();
              String str10 = com.tencent.mm.plugin.image.d.bbW() + this.ozO.hashCode();
              String str11 = str3;
              com.tencent.mm.bb.f localf = new com.tencent.mm.bb.f();
              localf.lVr = 7;
              localf.lVy = str2;
              localf.lVK = str3;
              localf.lVv = str4;
              localf.lVw = str5;
              localf.lVB = str6;
              localf.lVA = str7;
              localf.lVz = str8;
              localf.lVE = str9;
              localf.lVG = "";
              localf.lVD = str10;
              localf.lVt = str1;
              localf.lVu = 0.0F;
              localf.lVx = str11;
              localf.lVs = 1;
              localf.lVC = null;
              localf.lVJ = str1;
              localf.lVP = true;
              com.tencent.mm.bb.a.c(localf);
              a.a.cbh().a(JsApiOperateMusicPlayer.OperateMusicPlayer.b(JsApiOperateMusicPlayer.OperateMusicPlayer.this), JsApiOperateMusicPlayer.OperateMusicPlayer.this.appid);
              a.a.cbh().qdn = JsApiOperateMusicPlayer.OperateMusicPlayer.this.appid;
              a.a.cbh().qdo = localf.lVt;
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
        localObject1 = a.a.cbh().qdn;
        if (!Util.isNullOrNil((String)localObject1))
        {
          Log.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { localObject1, this.appid });
          a.a.cbh().akx((String)localObject1);
        }
        a.a.cbh().a(this.ozM, this.appid);
        a.a.cbh().qdn = this.appid;
        localObject1 = com.tencent.mm.bb.a.bnA();
        if (localObject1 != null) {
          a.a.cbh().qdo = ((com.tencent.mm.bb.f)localObject1).lVt;
        }
        if (com.tencent.mm.bb.b.bnC())
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
        bPt();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("pause"))
      {
        if (com.tencent.mm.bb.b.bnD())
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
        bPt();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("seek"))
      {
        if (com.tencent.mm.bb.a.wG(Util.getInt(Util.notNullToString(((JSONObject)localObject2).optString("position")), -1) * 1000))
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
        bPt();
        AppMethodBeat.o(45919);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("stop"))
      {
        if (com.tencent.mm.bb.b.bnE())
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
        bPt();
        AppMethodBeat.o(45919);
        return;
      }
      this.action = -1;
      this.error = true;
      bPt();
      AppMethodBeat.o(45919);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45920);
      Log.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[] { Integer.valueOf(this.action) });
      v localv = this.nAz;
      int i = this.okO;
      o localo = this.ovN;
      String str;
      if (this.error)
      {
        StringBuilder localStringBuilder = new StringBuilder("fail");
        if (TextUtils.isEmpty(this.errorMsg))
        {
          str = "";
          str = str;
          label87:
          localv.j(i, localo.h(str, null));
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
        new JsApiOperateMusicPlayer.c((byte)0).i(this.nAz).agT(this.ozL).bPO();
        this.ozJ.k("Music#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.ozK);
        k.a(this.nAz.getAppId(), this.cwl);
        AppMethodBeat.o(45920);
        return;
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
        this.ozJ.k("Music#isPlaying", Boolean.TRUE);
        AppBrandStickyBannerLogic.a.d(this.ozK);
        k.a(this.nAz.getAppId(), this.cwl);
        AppMethodBeat.o(45920);
        return;
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
        new JsApiOperateMusicPlayer.a((byte)0).i(this.nAz).agT(this.ozL).bPO();
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
        this.ozJ.k("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.ozK);
        k.b(this.nAz.getAppId(), this.cwl);
        AppMethodBeat.o(45920);
        return;
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
        new JsApiOperateMusicPlayer.b((byte)0).i(this.nAz).agT(this.ozL).bPO();
        this.ozJ.k("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.ozK);
        k.b(this.nAz.getAppId(), this.cwl);
        AppMethodBeat.o(45920);
        return;
        Log.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
        this.nAz.ct("onMusicError", this.ozL);
        this.ozJ.k("Music#isPlaying", Boolean.FALSE);
        AppBrandStickyBannerLogic.a.c(this.ozK);
        k.b(this.nAz.getAppId(), this.cwl);
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45921);
      this.jsonString = paramParcel.readString();
      this.appid = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.error = bool;
        this.ozL = paramParcel.readString();
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
      paramParcel.writeString(this.appid);
      if (this.error) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.ozL);
        paramParcel.writeInt(this.action);
        paramParcel.writeString(this.errorMsg);
        AppMethodBeat.o(45922);
        return;
      }
    }
  }
  
  static final class a
    extends r
  {
    private static final int CTRL_INDEX = 82;
    private static final String NAME = "onMusicEnd";
  }
  
  static final class b
    extends r
  {
    private static final int CTRL_INDEX = 81;
    private static final String NAME = "onMusicPause";
  }
  
  static final class c
    extends r
  {
    private static final int CTRL_INDEX = 80;
    private static final String NAME = "onMusicPlay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer
 * JD-Core Version:    0.7.0.1
 */