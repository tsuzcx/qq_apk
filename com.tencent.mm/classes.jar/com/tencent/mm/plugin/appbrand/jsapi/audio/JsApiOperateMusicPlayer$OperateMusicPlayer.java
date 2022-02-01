package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

class JsApiOperateMusicPlayer$OperateMusicPlayer
  extends MainProcessTask
{
  public static final Parcelable.Creator<OperateMusicPlayer> CREATOR;
  public int action;
  h.c clN;
  public String dwb;
  public boolean error;
  public String errorMsg;
  private r jFj;
  public String jsonString;
  private int kmu;
  private m kuO;
  z.b kzP;
  com.tencent.mm.plugin.appbrand.ui.banner.f kzQ;
  public String kzR;
  private final c kzS;
  
  static
  {
    AppMethodBeat.i(45929);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(45929);
  }
  
  public JsApiOperateMusicPlayer$OperateMusicPlayer(Parcel paramParcel)
  {
    AppMethodBeat.i(45918);
    this.error = false;
    this.kzS = new c() {};
    e(paramParcel);
    AppMethodBeat.o(45918);
  }
  
  public JsApiOperateMusicPlayer$OperateMusicPlayer(m paramm, r paramr, int paramInt)
  {
    AppMethodBeat.i(45917);
    this.error = false;
    this.kzS = new c() {};
    this.kuO = paramm;
    this.jFj = paramr;
    this.kmu = paramInt;
    AppMethodBeat.o(45917);
  }
  
  public final void aOX()
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
      if (bu.isNullOrNil(str1))
      {
        this.action = -1;
        this.error = true;
        this.errorMsg = "operationType is null or nil";
        biG();
        AppMethodBeat.o(45919);
        return;
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.JsApiOperateMusicPlayer", localException.toString());
      this.action = -1;
      this.error = true;
      this.errorMsg = "data is null";
      biG();
      AppMethodBeat.o(45919);
      return;
    }
    if (!a.a.bto().eb(this.dwb, str1))
    {
      ae.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
      this.action = -1;
      this.error = true;
      this.errorMsg = "appid not match cannot operate";
      biG();
      AppMethodBeat.o(45919);
      return;
    }
    Object localObject1 = str1;
    if (com.tencent.mm.ay.a.aKb())
    {
      localObject1 = str1;
      if (!com.tencent.mm.ay.a.aJZ())
      {
        localObject1 = str1;
        if (str1.equalsIgnoreCase("play"))
        {
          localObject1 = com.tencent.mm.ay.a.aKc();
          if ((localObject1 == null) || ((!bu.isNullOrNil(str2)) && (!str2.equals(((com.tencent.mm.ay.f)localObject1).ikf)))) {
            break label331;
          }
          if (!a.a.bto().eb(this.dwb, "resume")) {
            break label319;
          }
          ae.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[] { this.dwb });
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
      if (bu.isNullOrNil(str2))
      {
        this.action = -1;
        this.error = true;
        this.errorMsg = "dataUrl is null or nil";
        biG();
        AppMethodBeat.o(45919);
        return;
        label319:
        ae.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
        localObject1 = str1;
        continue;
        label331:
        ae.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
        localObject1 = str1;
      }
      else
      {
        ae.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", new Object[] { localObject1, str1, str3, localObject2, str2, str2, str2 });
        com.tencent.mm.ay.a.aJX();
        String str4 = a.a.bto().lVx;
        if (!bu.isNullOrNil(str4))
        {
          ae.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { str4, this.dwb });
          a.a.bto().SZ(str4);
        }
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(45910);
            String str1 = new StringBuilder().append(JsApiOperateMusicPlayer.OperateMusicPlayer.this.dwb).append(str2).append(this.kzU).toString().hashCode();
            String str2 = this.kzU;
            String str3 = this.kzU;
            String str4 = this.cZw;
            String str5 = str1;
            String str6 = str2;
            String str7 = str2;
            String str8 = str2;
            String str9 = com.tencent.mm.loader.j.b.asj();
            String str10 = com.tencent.mm.plugin.image.d.azQ() + this.kzU.hashCode();
            String str11 = str3;
            com.tencent.mm.ay.f localf = new com.tencent.mm.ay.f();
            localf.ijX = 7;
            localf.ike = str2;
            localf.ikq = str3;
            localf.ikb = str4;
            localf.ikc = str5;
            localf.ikh = str6;
            localf.ikg = str7;
            localf.ikf = str8;
            localf.ikk = str9;
            localf.ikm = "";
            localf.ikj = str10;
            localf.ijZ = str1;
            localf.ika = 0.0F;
            localf.ikd = str11;
            localf.ijY = 1;
            localf.iki = null;
            localf.ikp = str1;
            localf.ikv = true;
            com.tencent.mm.ay.a.c(localf);
            a.a.bto().a(JsApiOperateMusicPlayer.OperateMusicPlayer.b(JsApiOperateMusicPlayer.OperateMusicPlayer.this), JsApiOperateMusicPlayer.OperateMusicPlayer.this.dwb);
            a.a.bto().lVx = JsApiOperateMusicPlayer.OperateMusicPlayer.this.dwb;
            a.a.bto().lVy = localf.ijZ;
            ae.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
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
      localObject1 = a.a.bto().lVx;
      if (!bu.isNullOrNil((String)localObject1))
      {
        ae.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { localObject1, this.dwb });
        a.a.bto().SZ((String)localObject1);
      }
      a.a.bto().a(this.kzS, this.dwb);
      a.a.bto().lVx = this.dwb;
      localObject1 = com.tencent.mm.ay.a.aKc();
      if (localObject1 != null) {
        a.a.bto().lVy = ((com.tencent.mm.ay.f)localObject1).ijZ;
      }
      if (com.tencent.mm.ay.b.aKe())
      {
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(45911);
            ae.i("MicroMsg.JsApiOperateMusicPlayer", "resume ok");
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
      ae.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
      this.action = -1;
      this.error = true;
      this.errorMsg = "resume play fail";
      biG();
      AppMethodBeat.o(45919);
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("pause"))
    {
      if (com.tencent.mm.ay.b.aKf())
      {
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(45912);
            ae.i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
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
      ae.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
      this.action = -1;
      this.error = true;
      this.errorMsg = "pause play fail";
      biG();
      AppMethodBeat.o(45919);
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("seek"))
    {
      if (com.tencent.mm.ay.a.pR(bu.getInt(bu.dU(((JSONObject)localObject2).optString("position")), -1) * 1000))
      {
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(45913);
            ae.i("MicroMsg.JsApiOperateMusicPlayer", "seek ok");
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
      ae.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
      this.action = -1;
      this.error = true;
      this.errorMsg = "seek fail";
      biG();
      AppMethodBeat.o(45919);
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("stop"))
    {
      if (com.tencent.mm.ay.b.aKg())
      {
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(45914);
            ae.i("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
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
      ae.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
      this.action = -1;
      this.error = false;
      this.errorMsg = "stop play fail";
      biG();
      AppMethodBeat.o(45919);
      return;
    }
    this.action = -1;
    this.error = true;
    biG();
    AppMethodBeat.o(45919);
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(45920);
    ae.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[] { Integer.valueOf(this.action) });
    r localr = this.jFj;
    int i = this.kmu;
    m localm = this.kuO;
    String str;
    if (this.error)
    {
      StringBuilder localStringBuilder = new StringBuilder("fail");
      if (TextUtils.isEmpty(this.errorMsg))
      {
        str = "";
        str = str;
        label87:
        localr.h(i, localm.e(str, null));
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
      ae.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
      new JsApiOperateMusicPlayer.c((byte)0).g(this.jFj).PP(this.kzR).bja();
      this.kzP.k("Music#isPlaying", Boolean.TRUE);
      AppBrandStickyBannerLogic.a.d(this.kzQ);
      h.a(this.jFj.getAppId(), this.clN);
      AppMethodBeat.o(45920);
      return;
      ae.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
      this.kzP.k("Music#isPlaying", Boolean.TRUE);
      AppBrandStickyBannerLogic.a.d(this.kzQ);
      h.a(this.jFj.getAppId(), this.clN);
      AppMethodBeat.o(45920);
      return;
      ae.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
      new JsApiOperateMusicPlayer.a((byte)0).g(this.jFj).PP(this.kzR).bja();
      ae.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
      this.kzP.k("Music#isPlaying", Boolean.FALSE);
      AppBrandStickyBannerLogic.a.c(this.kzQ);
      h.b(this.jFj.getAppId(), this.clN);
      AppMethodBeat.o(45920);
      return;
      ae.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
      new JsApiOperateMusicPlayer.b((byte)0).g(this.jFj).PP(this.kzR).bja();
      this.kzP.k("Music#isPlaying", Boolean.FALSE);
      AppBrandStickyBannerLogic.a.c(this.kzQ);
      h.b(this.jFj.getAppId(), this.clN);
      AppMethodBeat.o(45920);
      return;
      ae.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
      this.jFj.c("onMusicError", this.kzR, 0);
      this.kzP.k("Music#isPlaying", Boolean.FALSE);
      AppBrandStickyBannerLogic.a.c(this.kzQ);
      h.b(this.jFj.getAppId(), this.clN);
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(45921);
    this.jsonString = paramParcel.readString();
    this.dwb = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.error = bool;
      this.kzR = paramParcel.readString();
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
    paramParcel.writeString(this.dwb);
    if (this.error) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.kzR);
      paramParcel.writeInt(this.action);
      paramParcel.writeString(this.errorMsg);
      AppMethodBeat.o(45922);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer
 * JD-Core Version:    0.7.0.1
 */