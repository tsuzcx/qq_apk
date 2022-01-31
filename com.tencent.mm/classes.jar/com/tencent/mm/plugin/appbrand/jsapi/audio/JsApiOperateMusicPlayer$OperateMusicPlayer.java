package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

class JsApiOperateMusicPlayer$OperateMusicPlayer
  extends MainProcessTask
{
  public static final Parcelable.Creator<OperateMusicPlayer> CREATOR;
  public int action;
  e.c bCv;
  public String cwc;
  public boolean error;
  public String errorMsg;
  v.b hCb;
  f hCc;
  public String hCd;
  private final c hCe;
  private int hry;
  private r hxb;
  private m hxs;
  public String jsonString;
  
  static
  {
    AppMethodBeat.i(130739);
    CREATOR = new JsApiOperateMusicPlayer.OperateMusicPlayer.7();
    AppMethodBeat.o(130739);
  }
  
  public JsApiOperateMusicPlayer$OperateMusicPlayer(Parcel paramParcel)
  {
    AppMethodBeat.i(130728);
    this.error = false;
    this.hCe = new JsApiOperateMusicPlayer.OperateMusicPlayer.6(this);
    f(paramParcel);
    AppMethodBeat.o(130728);
  }
  
  public JsApiOperateMusicPlayer$OperateMusicPlayer(m paramm, r paramr, int paramInt)
  {
    AppMethodBeat.i(130727);
    this.error = false;
    this.hCe = new JsApiOperateMusicPlayer.OperateMusicPlayer.6(this);
    this.hxs = paramm;
    this.hxb = paramr;
    this.hry = paramInt;
    AppMethodBeat.o(130727);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130729);
    Object localObject2;
    String str1;
    String str2;
    try
    {
      localObject2 = new JSONObject(this.jsonString);
      str1 = ((JSONObject)localObject2).optString("operationType");
      str2 = ((JSONObject)localObject2).optString("dataUrl");
      if (bo.isNullOrNil(str1))
      {
        this.action = -1;
        this.error = true;
        this.errorMsg = "operationType is null or nil";
        aBp();
        AppMethodBeat.o(130729);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiOperateMusicPlayer", localException.toString());
      this.action = -1;
      this.error = true;
      this.errorMsg = "data is null";
      aBp();
      AppMethodBeat.o(130729);
      return;
    }
    if (!a.a.aHK().cH(this.cwc, str1))
    {
      ab.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
      this.action = -1;
      this.error = true;
      this.errorMsg = "appid not match cannot operate";
      aBp();
      AppMethodBeat.o(130729);
      return;
    }
    Object localObject1 = str1;
    if (com.tencent.mm.aw.a.aiy())
    {
      localObject1 = str1;
      if (!com.tencent.mm.aw.a.aiw())
      {
        localObject1 = str1;
        if (str1.equalsIgnoreCase("play"))
        {
          localObject1 = com.tencent.mm.aw.a.aiz();
          if ((localObject1 == null) || ((!bo.isNullOrNil(str2)) && (!str2.equals(((com.tencent.mm.aw.e)localObject1).fKp)))) {
            break label331;
          }
          if (!a.a.aHK().cH(this.cwc, "resume")) {
            break label319;
          }
          ab.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[] { this.cwc });
          localObject1 = "resume";
        }
      }
    }
    while (((String)localObject1).equalsIgnoreCase("play"))
    {
      localObject1 = ((JSONObject)localObject2).optString("title");
      str1 = ((JSONObject)localObject2).optString("singer");
      String str3 = ((JSONObject)localObject2).optString("epname");
      localObject2 = ((JSONObject)localObject2).optString("coverImgUrl");
      if (bo.isNullOrNil(str2))
      {
        this.action = -1;
        this.error = true;
        this.errorMsg = "dataUrl is null or nil";
        aBp();
        AppMethodBeat.o(130729);
        return;
        label319:
        ab.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
        localObject1 = str1;
        continue;
        label331:
        ab.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
        localObject1 = str1;
      }
      else
      {
        ab.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", new Object[] { localObject1, str1, str3, localObject2, str2, str2, str2 });
        com.tencent.mm.aw.a.aiu();
        String str4 = a.a.aHK().ipb;
        if (!bo.isNullOrNil(str4))
        {
          ab.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { str4, this.cwc });
          a.a.aHK().Dz(str4);
        }
        al.p(new JsApiOperateMusicPlayer.OperateMusicPlayer.1(this, str2, (String)localObject2, (String)localObject1, str1, str2, str2, str3), 500L);
        AppMethodBeat.o(130729);
        return;
      }
    }
    if (((String)localObject1).equalsIgnoreCase("resume"))
    {
      localObject1 = a.a.aHK().ipb;
      if (!bo.isNullOrNil((String)localObject1))
      {
        ab.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { localObject1, this.cwc });
        a.a.aHK().Dz((String)localObject1);
      }
      a.a.aHK().a(this.hCe, this.cwc);
      a.a.aHK().ipb = this.cwc;
      localObject1 = com.tencent.mm.aw.a.aiz();
      if (localObject1 != null) {
        a.a.aHK().ipc = ((com.tencent.mm.aw.e)localObject1).fKj;
      }
      if (b.aiB())
      {
        al.p(new JsApiOperateMusicPlayer.OperateMusicPlayer.2(this), 500L);
        AppMethodBeat.o(130729);
        return;
      }
      ab.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
      this.action = -1;
      this.error = true;
      this.errorMsg = "resume play fail";
      aBp();
      AppMethodBeat.o(130729);
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("pause"))
    {
      if (b.aiC())
      {
        al.p(new JsApiOperateMusicPlayer.OperateMusicPlayer.3(this), 500L);
        AppMethodBeat.o(130729);
        return;
      }
      ab.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
      this.action = -1;
      this.error = true;
      this.errorMsg = "pause play fail";
      aBp();
      AppMethodBeat.o(130729);
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("seek"))
    {
      if (com.tencent.mm.aw.a.lN(bo.getInt(bo.cw(((JSONObject)localObject2).optString("position")), -1) * 1000))
      {
        al.p(new JsApiOperateMusicPlayer.OperateMusicPlayer.4(this), 500L);
        AppMethodBeat.o(130729);
        return;
      }
      ab.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
      this.action = -1;
      this.error = true;
      this.errorMsg = "seek fail";
      aBp();
      AppMethodBeat.o(130729);
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("stop"))
    {
      if (b.aiD())
      {
        al.p(new JsApiOperateMusicPlayer.OperateMusicPlayer.5(this), 500L);
        AppMethodBeat.o(130729);
        return;
      }
      ab.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
      this.action = -1;
      this.error = false;
      this.errorMsg = "stop play fail";
      aBp();
      AppMethodBeat.o(130729);
      return;
    }
    this.action = -1;
    this.error = true;
    aBp();
    AppMethodBeat.o(130729);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130730);
    ab.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[] { Integer.valueOf(this.action) });
    r localr = this.hxb;
    int i = this.hry;
    m localm = this.hxs;
    String str;
    if (this.error)
    {
      StringBuilder localStringBuilder = new StringBuilder("fail");
      if (TextUtils.isEmpty(this.errorMsg))
      {
        str = "";
        str = str;
        label87:
        localr.h(i, localm.j(str, null));
        switch (this.action)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(130730);
      return;
      str = ":" + this.errorMsg;
      break;
      str = "ok";
      break label87;
      ab.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
      new JsApiOperateMusicPlayer.c((byte)0).i(this.hxb).BM(this.hCd).aBz();
      this.hCb.i("Music#isPlaying", Boolean.TRUE);
      AppBrandStickyBannerLogic.a.d(this.hCc);
      com.tencent.mm.plugin.appbrand.e.a(this.hxb.getAppId(), this.bCv);
      AppMethodBeat.o(130730);
      return;
      ab.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
      this.hCb.i("Music#isPlaying", Boolean.TRUE);
      AppBrandStickyBannerLogic.a.d(this.hCc);
      com.tencent.mm.plugin.appbrand.e.a(this.hxb.getAppId(), this.bCv);
      AppMethodBeat.o(130730);
      return;
      ab.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
      new JsApiOperateMusicPlayer.a((byte)0).i(this.hxb).BM(this.hCd).aBz();
      ab.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
      this.hCb.i("Music#isPlaying", Boolean.FALSE);
      AppBrandStickyBannerLogic.a.c(this.hCc);
      com.tencent.mm.plugin.appbrand.e.b(this.hxb.getAppId(), this.bCv);
      AppMethodBeat.o(130730);
      return;
      ab.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
      new JsApiOperateMusicPlayer.b((byte)0).i(this.hxb).BM(this.hCd).aBz();
      this.hCb.i("Music#isPlaying", Boolean.FALSE);
      AppBrandStickyBannerLogic.a.c(this.hCc);
      com.tencent.mm.plugin.appbrand.e.b(this.hxb.getAppId(), this.bCv);
      AppMethodBeat.o(130730);
      return;
      ab.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
      this.hxb.c("onMusicError", this.hCd, 0);
      this.hCb.i("Music#isPlaying", Boolean.FALSE);
      AppBrandStickyBannerLogic.a.c(this.hCc);
      com.tencent.mm.plugin.appbrand.e.b(this.hxb.getAppId(), this.bCv);
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130731);
    this.jsonString = paramParcel.readString();
    this.cwc = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.error = bool;
      this.hCd = paramParcel.readString();
      this.action = paramParcel.readInt();
      this.errorMsg = paramParcel.readString();
      AppMethodBeat.o(130731);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130732);
    paramParcel.writeString(this.jsonString);
    paramParcel.writeString(this.cwc);
    if (this.error) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.hCd);
      paramParcel.writeInt(this.action);
      paramParcel.writeString(this.errorMsg);
      AppMethodBeat.o(130732);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer
 * JD-Core Version:    0.7.0.1
 */