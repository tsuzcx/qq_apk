package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiSetBackgroundAudioState
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 160;
  public static final String NAME = "setBackgroundAudioState";
  protected SetBackgroundAudioListenerTask jBx;
  
  protected SetBackgroundAudioListenerTask a(com.tencent.mm.plugin.appbrand.jsapi.a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    AppMethodBeat.i(145773);
    parama = new SetBackgroundAudioListenerTask(this, paramc, paramInt);
    AppMethodBeat.o(145773);
    return parama;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145770);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ad.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
      AppMethodBeat.o(145770);
      return;
    }
    Object localObject1 = paramc.getAppId();
    ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", new Object[] { localObject1, paramJSONObject.toString() });
    if (this.jBx == null) {
      this.jBx = a(this, paramc, paramInt);
    }
    this.jBx.joH = paramInt;
    this.jBx.appId = ((String)localObject1);
    SetBackgroundAudioListenerTask.a(this.jBx);
    ??? = y.tD("AppBrandService#" + paramc.hashCode());
    a((String)???, paramc);
    com.tencent.mm.plugin.appbrand.jsapi.q.a locala;
    for (;;)
    {
      synchronized (y.arz().E((String)???, true))
      {
        if ((g.c)((y.b)???).get("AppBrandLifeCycle.Listener", null) == null)
        {
          localObject3 = new g.c()
          {
            public final void onDestroy()
            {
              AppMethodBeat.i(145750);
              String str = this.jBB.getString("appId", "");
              ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", new Object[] { str });
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("operationType", "stop");
                label49:
                JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = new JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask(JsApiSetBackgroundAudioState.this, paramc, paramInt);
                localSetBackgroundAudioStateTask.jBA = localJSONObject.toString();
                localSetBackgroundAudioStateTask.appId = str;
                AppBrandMainProcessService.b(localSetBackgroundAudioStateTask);
                AppMethodBeat.o(145750);
                return;
              }
              catch (JSONException localJSONException)
              {
                break label49;
              }
            }
          };
          ((y.b)???).m("AppBrandLifeCycle.Listener", localObject3);
          ((y.b)???).m("appId", localObject1);
          this.jBx.cex = ((g.c)localObject3);
        }
        AppBrandMainProcessService.a(this.jBx);
        Object localObject3 = b(this, paramc, paramInt);
        ((SetBackgroundAudioStateTask)localObject3).joH = paramInt;
        ((SetBackgroundAudioStateTask)localObject3).appId = ((String)localObject1);
        ((SetBackgroundAudioStateTask)localObject3).jBA = paramJSONObject.toString();
        ??? = paramJSONObject.optString("src");
        if ((??? == null) || (((String)???).length() <= 0))
        {
          localObject1 = "";
          ((SetBackgroundAudioStateTask)localObject3).drZ = ((String)localObject1);
          locala = (com.tencent.mm.plugin.appbrand.jsapi.q.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.q.a.class);
          if (locala != null) {
            break;
          }
          ad.w("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerHelper is null");
          paramc = new Pair(null, "invalidReferrer");
          ((SetBackgroundAudioStateTask)localObject3).gSZ = ((String)paramc.first);
          ((SetBackgroundAudioStateTask)localObject3).gTa = ((String)paramc.second);
          AppBrandMainProcessService.a((MainProcessTask)localObject3);
          AppMethodBeat.o(145770);
          return;
        }
      }
      localObject1 = ???;
      if (!((String)???).startsWith("http://"))
      {
        localObject1 = ???;
        if (!((String)???).startsWith("https://"))
        {
          localObject1 = paramc.Ee().EP((String)???);
          if ((localObject1 != null) && (((com.tencent.mm.vfs.e)localObject1).exists()))
          {
            ??? = q.B(((com.tencent.mm.vfs.e)localObject1).fhU());
            localObject1 = ???;
            if (!((String)???).startsWith("file://")) {
              localObject1 = "file://".concat(String.valueOf(???));
            }
          }
          else
          {
            localObject1 = "";
          }
        }
      }
    }
    ??? = locala.U(paramJSONObject);
    if (??? != null)
    {
      localObject1 = locala.IU((String)???);
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null) {
        paramJSONObject = locala.x(paramc);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.q.c.khR == paramJSONObject) {
        paramc = null;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", new Object[] { ???, paramc });
      paramc = new Pair(???, paramc);
      break;
      if (com.tencent.mm.plugin.appbrand.jsapi.q.c.khQ == paramJSONObject) {
        paramc = locala.y(paramc);
      } else {
        paramc = "invalidReferrer";
      }
    }
  }
  
  protected void a(String paramString, com.tencent.mm.plugin.appbrand.jsapi.c paramc) {}
  
  protected SetBackgroundAudioStateTask b(com.tencent.mm.plugin.appbrand.jsapi.a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    AppMethodBeat.i(145772);
    parama = new SetBackgroundAudioStateTask(this, paramc, paramInt);
    AppMethodBeat.o(145772);
    return parama;
  }
  
  public static class SetBackgroundAudioListenerTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SetBackgroundAudioListenerTask> CREATOR;
    public int action;
    public String appId;
    g.c cex;
    public String dfM;
    public String dkB;
    public int dkC;
    public String jBH;
    private final com.tencent.mm.sdk.b.c jBI;
    private boolean jCi;
    public int joH;
    private m jwG;
    public com.tencent.mm.plugin.appbrand.jsapi.c jyl;
    
    static
    {
      AppMethodBeat.i(145761);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145761);
    }
    
    public SetBackgroundAudioListenerTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145754);
      this.jCi = false;
      this.jBI = new com.tencent.mm.sdk.b.c() {};
      e(paramParcel);
      AppMethodBeat.o(145754);
    }
    
    public SetBackgroundAudioListenerTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      AppMethodBeat.i(145753);
      this.jCi = false;
      this.jBI = new com.tencent.mm.sdk.b.c() {};
      this.jwG = parama;
      this.jyl = paramc;
      this.joH = paramInt;
      AppMethodBeat.o(145753);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(145756);
      if (this.jyl == null)
      {
        ad.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
        AppMethodBeat.o(145756);
        return;
      }
      rv(this.action);
      AppBrandMusicClientService localAppBrandMusicClientService;
      int i;
      Iterator localIterator;
      switch (this.action)
      {
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      default: 
        ad.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.jBH });
        new JsApiOperateBackgroundAudio.c().h(this.jyl).HK(this.jBH).aXQ();
        localAppBrandMusicClientService = AppBrandMusicClientService.kQj;
        i = this.action;
        ad.i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", new Object[] { Integer.valueOf(i) });
        localIterator = localAppBrandMusicClientService.kQi.entrySet().iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label393;
        }
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (AppBrandMusicClientService.a)((Map.Entry)localObject).getValue();
          if ((!TextUtils.isEmpty(localAppBrandMusicClientService.kQk)) && (localAppBrandMusicClientService.kQk.equalsIgnoreCase(str)))
          {
            ad.i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", new Object[] { localAppBrandMusicClientService.kQk });
            if (localObject != null)
            {
              if (i == 10)
              {
                ((AppBrandMusicClientService.a)localObject).aQU();
                continue;
                com.tencent.mm.plugin.appbrand.g.a(this.appId, this.cex);
                AppBrandMusicClientService.kQj.kQk = this.appId;
                break;
                com.tencent.mm.plugin.appbrand.g.b(this.appId, this.cex);
                break;
                JsApiOperateBackgroundAudio.b.m(this.jyl);
                AppMethodBeat.o(145756);
                return;
                JsApiOperateBackgroundAudio.a.m(this.jyl);
                AppMethodBeat.o(145756);
                return;
              }
              if (i == 2) {
                ((AppBrandMusicClientService.a)localObject).onStop();
              }
            }
          }
        }
      }
      label393:
      AppMethodBeat.o(145756);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(145755);
      ad.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
      if (this.jCi)
      {
        ad.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
        this.jCi = false;
        localObject = new ln();
        ((ln)localObject).dql.action = 10;
        ((ln)localObject).dql.state = "preempted";
        ((ln)localObject).dql.appId = this.appId;
        ((ln)localObject).dql.dqn = true;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      Object localObject = a.a.bhK().kQn;
      if (!bt.isNullOrNil((String)localObject))
      {
        ad.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", new Object[] { localObject, this.appId });
        a.a.bhK().KG((String)localObject);
      }
      a.a.bhK().a(this.jBI, this.appId);
      localObject = a.a.bhK();
      String str1 = this.appId;
      int i = this.dkC;
      String str2 = this.dfM;
      String str3 = this.dkB;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).kQn = str1;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).dkC = i;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).dfM = str2;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).dkB = str3;
      AppMethodBeat.o(145755);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145757);
      this.appId = paramParcel.readString();
      this.jBH = paramParcel.readString();
      this.action = paramParcel.readInt();
      this.dkC = paramParcel.readInt();
      this.dfM = paramParcel.readString();
      this.dkB = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jCi = bool;
        AppMethodBeat.o(145757);
        return;
        bool = false;
      }
    }
    
    protected void rv(int paramInt) {}
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145758);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.jBH);
      paramParcel.writeInt(this.action);
      paramParcel.writeInt(this.dkC);
      paramParcel.writeString(this.dfM);
      paramParcel.writeString(this.dkB);
      if (this.jCi) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(145758);
        return;
      }
    }
  }
  
  public static class SetBackgroundAudioStateTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SetBackgroundAudioStateTask> CREATOR;
    public String appId;
    public String drZ;
    public boolean error;
    public String gSZ;
    public String gTa;
    public String hMd;
    public String jBA;
    public int joH;
    private m jwG;
    public com.tencent.mm.plugin.appbrand.jsapi.c jyl;
    
    static
    {
      AppMethodBeat.i(145769);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145769);
    }
    
    public SetBackgroundAudioStateTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145763);
      this.error = false;
      this.hMd = "";
      this.gSZ = null;
      this.gTa = null;
      e(paramParcel);
      AppMethodBeat.o(145763);
    }
    
    public SetBackgroundAudioStateTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.error = false;
      this.hMd = "";
      this.gSZ = null;
      this.gTa = null;
      this.jwG = parama;
      this.jyl = paramc;
      this.joH = paramInt;
    }
    
    public String HM(String paramString)
    {
      AppMethodBeat.i(145764);
      paramString = com.tencent.mm.loader.j.b.aih() + "/image/" + paramString.hashCode();
      AppMethodBeat.o(145764);
      return paramString;
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(145766);
      if (this.jyl == null)
      {
        ad.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
        AppMethodBeat.o(145766);
        return;
      }
      if (!this.error)
      {
        ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
        this.jyl.h(this.joH, this.jwG.e("ok", null));
        AppMethodBeat.o(145766);
        return;
      }
      ad.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", new Object[] { this.hMd });
      this.jyl.h(this.joH, this.jwG.e("fail:" + this.hMd, null));
      AppMethodBeat.o(145766);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(145765);
      ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
      String str4;
      String str5;
      String str6;
      String str7;
      String str1;
      String str8;
      String str2;
      double d2;
      String str3;
      double d1;
      double d3;
      try
      {
        Object localObject1 = new JSONObject(this.jBA);
        str4 = ((JSONObject)localObject1).optString("src");
        str5 = ((JSONObject)localObject1).optString("title");
        str6 = ((JSONObject)localObject1).optString("epname");
        str7 = ((JSONObject)localObject1).optString("singer");
        str1 = ((JSONObject)localObject1).optString("coverImgUrl");
        str8 = ((JSONObject)localObject1).optString("webUrl");
        str2 = ((JSONObject)localObject1).optString("protocol");
        d2 = ((JSONObject)localObject1).optDouble("startTime", 0.0D);
        str3 = ((JSONObject)localObject1).optString("songLyric");
        d1 = ((JSONObject)localObject1).optDouble("playbackRate", 1.0D);
        d3 = ((JSONObject)localObject1).optDouble("volume", 1.0D);
        localObject1 = ((JSONObject)localObject1).optString("operationType");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label361;
        }
        ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
        str1 = a.a.bhK().kQn;
        if ((!bt.isNullOrNil(str1)) && (!str1.equals(this.appId)))
        {
          ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str1, this.appId });
          AppMethodBeat.o(145765);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        ad.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
        this.error = true;
        this.hMd = "parser data fail, data is invalid";
        ad.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + localJSONException.getMessage());
        aXw();
        AppMethodBeat.o(145765);
        return;
      }
      this.error = false;
      if (localJSONException.equalsIgnoreCase("pause"))
      {
        if (com.tencent.mm.az.b.azL())
        {
          ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
          AppMethodBeat.o(145765);
          return;
        }
        this.error = true;
        this.hMd = "pause music fail";
      }
      for (;;)
      {
        aXw();
        AppMethodBeat.o(145765);
        return;
        if (localJSONException.equalsIgnoreCase("stop"))
        {
          if (com.tencent.mm.az.b.azM())
          {
            ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
            AppMethodBeat.o(145765);
            return;
          }
          this.error = true;
          this.hMd = "stop music fail";
        }
      }
      label361:
      if (TextUtils.isEmpty(str4))
      {
        ad.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
        this.error = true;
        this.hMd = "src is null";
        aXw();
        AppMethodBeat.o(145765);
        return;
      }
      if ((str3 != null) && (str3.length() > 32768))
      {
        ad.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is large than 32KB");
        this.error = true;
        this.hMd = "songLyric is large than 32KB";
        aXw();
        AppMethodBeat.o(145765);
        return;
      }
      ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%f, localPath:%s, playbackRate:%f", new Object[] { str4, str5, str6, str7, str1, str2, str8, Double.valueOf(d2), this.drZ, Double.valueOf(d1) });
      if ((d1 < 0.5D) || (d1 > 2.0D)) {
        d1 = 1.0D;
      }
      for (;;)
      {
        Object localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        int i;
        if (TextUtils.isEmpty(str3))
        {
          ad.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is empty");
          localObject2 = com.tencent.mm.az.g.a(11, (String)localObject2, str5, str7, str8, str4, str4, new StringBuilder().append(this.appId).append(str4).append((String)localObject2).toString().hashCode(), com.tencent.mm.loader.j.b.aih(), HM((String)localObject2), str6, this.appId);
          ((f)localObject2).cUL = ((int)(1000.0D * d2));
          ((f)localObject2).protocol = str2;
          ((f)localObject2).hny = str3;
          ((f)localObject2).gSR = d1;
          if (this.drZ.startsWith("file://")) {
            ((f)localObject2).hnB = this.drZ;
          }
          ((f)localObject2).gSZ = this.gSZ;
          ((f)localObject2).gTa = this.gTa;
          ((f)localObject2).volume = ((float)d3);
          a.a.bhK().kQo = ((f)localObject2).hnp;
          a.a.bhK().kQp = ((f)localObject2);
          if ((!((f)localObject2).g(com.tencent.mm.az.a.azI())) || (!com.tencent.mm.az.a.azF())) {
            break label829;
          }
          i = 1;
          label760:
          if (i != 0) {
            break label835;
          }
          ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "play the music");
          com.tencent.mm.az.a.c((f)localObject2);
        }
        for (;;)
        {
          ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
          ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
          this.error = false;
          aXw();
          AppMethodBeat.o(145765);
          return;
          ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric:%s", new Object[] { str3 });
          break;
          label829:
          i = 0;
          break label760;
          label835:
          ad.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "The same music is playing");
          com.tencent.mm.az.a.b((f)localObject2);
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145767);
      this.appId = paramParcel.readString();
      this.jBA = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.error = bool;
        this.hMd = paramParcel.readString();
        this.drZ = paramParcel.readString();
        this.gSZ = paramParcel.readString();
        this.gTa = paramParcel.readString();
        AppMethodBeat.o(145767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145768);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.jBA);
      if (this.error) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.hMd);
        paramParcel.writeString(this.drZ);
        paramParcel.writeString(this.gSZ);
        paramParcel.writeString(this.gTa);
        AppMethodBeat.o(145768);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */