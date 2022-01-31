package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.av.b;
import com.tencent.mm.av.e;
import com.tencent.mm.h.a.jy;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

class JsApiOperateMusicPlayer$OperateMusicPlayer
  extends MainProcessTask
{
  public static final Parcelable.Creator<OperateMusicPlayer> CREATOR = new JsApiOperateMusicPlayer.OperateMusicPlayer.7();
  public int action;
  public String bOL;
  public String bTX;
  public boolean error = false;
  public String errorMsg;
  u.b fVQ;
  g.b gda;
  private i gfG;
  private o gfd;
  private int gfg;
  f giI;
  public String giJ;
  private final c giK = new c() {};
  
  public JsApiOperateMusicPlayer$OperateMusicPlayer(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiOperateMusicPlayer$OperateMusicPlayer(i parami, o paramo, int paramInt)
  {
    this.gfG = parami;
    this.gfd = paramo;
    this.gfg = paramInt;
  }
  
  public final void Zu()
  {
    Object localObject2;
    String str1;
    String str2;
    try
    {
      localObject2 = new JSONObject(this.bTX);
      str1 = ((JSONObject)localObject2).optString("operationType");
      str2 = ((JSONObject)localObject2).optString("dataUrl");
      if (bk.bl(str1))
      {
        this.action = -1;
        this.error = true;
        this.errorMsg = "operationType is null or nil";
        ahI();
        return;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.JsApiOperateMusicPlayer", localException.toString());
      this.action = -1;
      this.error = true;
      this.errorMsg = "data is null";
      ahI();
      return;
    }
    if (!a.a.amd().bS(this.bOL, str1))
    {
      y.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
      this.action = -1;
      this.error = true;
      this.errorMsg = "appid not match cannot operate";
      ahI();
      return;
    }
    Object localObject1 = str1;
    if (com.tencent.mm.av.a.Pv())
    {
      localObject1 = str1;
      if (!com.tencent.mm.av.a.Pu())
      {
        localObject1 = str1;
        if (str1.equalsIgnoreCase("play"))
        {
          localObject1 = com.tencent.mm.av.a.Pw();
          if ((localObject1 == null) || ((!bk.bl(str2)) && (!str2.equals(((e)localObject1).euD)))) {
            break label306;
          }
          if (!a.a.amd().bS(this.bOL, "resume")) {
            break label294;
          }
          y.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[] { this.bOL });
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
      if (bk.bl(str2))
      {
        this.action = -1;
        this.error = true;
        this.errorMsg = "dataUrl is null or nil";
        ahI();
        return;
        label294:
        y.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
        localObject1 = str1;
        continue;
        label306:
        y.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
        localObject1 = str1;
      }
      else
      {
        y.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", new Object[] { localObject1, str1, str3, localObject2, str2, str2, str2 });
        com.tencent.mm.av.a.Ps();
        String str4 = a.a.amd().gNh;
        if (!bk.bl(str4))
        {
          y.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { str4, this.bOL });
          a.a.amd().tO(str4);
        }
        ai.l(new JsApiOperateMusicPlayer.OperateMusicPlayer.1(this, str2, (String)localObject2, (String)localObject1, str1, str2, str2, str3), 500L);
        return;
      }
    }
    if (((String)localObject1).equalsIgnoreCase("resume"))
    {
      localObject1 = a.a.amd().gNh;
      if (!bk.bl((String)localObject1))
      {
        y.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { localObject1, this.bOL });
        a.a.amd().tO((String)localObject1);
      }
      a.a.amd().a(this.giK, this.bOL);
      a.a.amd().gNh = this.bOL;
      localObject1 = com.tencent.mm.av.a.Pw();
      if (localObject1 != null) {
        a.a.amd().gNi = ((e)localObject1).eux;
      }
      if (b.Py())
      {
        ai.l(new JsApiOperateMusicPlayer.OperateMusicPlayer.2(this), 500L);
        return;
      }
      y.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
      this.action = -1;
      this.error = true;
      this.errorMsg = "resume play fail";
      ahI();
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("pause"))
    {
      if (b.Pz())
      {
        ai.l(new JsApiOperateMusicPlayer.OperateMusicPlayer.3(this), 500L);
        return;
      }
      y.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
      this.action = -1;
      this.error = true;
      this.errorMsg = "pause play fail";
      ahI();
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("seek"))
    {
      if (com.tencent.mm.av.a.iV(bk.getInt(bk.bT(((JSONObject)localObject2).optString("position")), -1) * 1000))
      {
        ai.l(new JsApiOperateMusicPlayer.OperateMusicPlayer.4(this), 500L);
        return;
      }
      y.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
      this.action = -1;
      this.error = true;
      this.errorMsg = "seek fail";
      ahI();
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("stop"))
    {
      if (b.PA())
      {
        ai.l(new JsApiOperateMusicPlayer.OperateMusicPlayer.5(this), 500L);
        return;
      }
      y.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
      this.action = -1;
      this.error = false;
      this.errorMsg = "stop play fail";
      ahI();
      return;
    }
    this.action = -1;
    this.error = true;
    ahI();
  }
  
  public final void Zv()
  {
    y.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[] { Integer.valueOf(this.action) });
    o localo = this.gfd;
    int i = this.gfg;
    i locali = this.gfG;
    StringBuilder localStringBuilder;
    if (this.error)
    {
      localStringBuilder = new StringBuilder("fail");
      if (TextUtils.isEmpty(this.errorMsg)) {
        str = "";
      }
    }
    label71:
    for (String str = str;; str = "ok")
    {
      localo.C(i, locali.h(str, null));
      switch (this.action)
      {
      case 5: 
      case 6: 
      default: 
        return;
        str = ":" + this.errorMsg;
        break label71;
      }
    }
    y.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
    new JsApiOperateMusicPlayer.c((byte)0).d(this.gfd).tL(this.giJ).dispatch();
    this.fVQ.h("Music#isPlaying", Boolean.valueOf(true));
    AppBrandStickyBannerLogic.a.d(this.giI);
    g.a(this.gfd.mAppId, this.gda);
    return;
    y.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
    this.fVQ.h("Music#isPlaying", Boolean.valueOf(true));
    AppBrandStickyBannerLogic.a.d(this.giI);
    g.a(this.gfd.mAppId, this.gda);
    return;
    y.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
    new JsApiOperateMusicPlayer.a((byte)0).d(this.gfd).tL(this.giJ).dispatch();
    y.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
    this.fVQ.h("Music#isPlaying", Boolean.valueOf(false));
    AppBrandStickyBannerLogic.a.c(this.giI);
    g.b(this.gfd.mAppId, this.gda);
    return;
    y.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
    new JsApiOperateMusicPlayer.b((byte)0).d(this.gfd).tL(this.giJ).dispatch();
    this.fVQ.h("Music#isPlaying", Boolean.valueOf(false));
    AppBrandStickyBannerLogic.a.c(this.giI);
    g.b(this.gfd.mAppId, this.gda);
    return;
    y.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
    this.gfd.i("onMusicError", this.giJ, 0);
    this.fVQ.h("Music#isPlaying", Boolean.valueOf(false));
    AppBrandStickyBannerLogic.a.c(this.giI);
    g.b(this.gfd.mAppId, this.gda);
  }
  
  public final void e(Parcel paramParcel)
  {
    this.bTX = paramParcel.readString();
    this.bOL = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.error = bool;
      this.giJ = paramParcel.readString();
      this.action = paramParcel.readInt();
      this.errorMsg = paramParcel.readString();
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bTX);
    paramParcel.writeString(this.bOL);
    if (this.error) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.giJ);
      paramParcel.writeInt(this.action);
      paramParcel.writeString(this.errorMsg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer
 * JD-Core Version:    0.7.0.1
 */