package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.g;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
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
  protected SetBackgroundAudioListenerTask kzH;
  
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
      ae.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
      AppMethodBeat.o(145770);
      return;
    }
    Object localObject1 = paramc.getAppId();
    ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", new Object[] { localObject1, paramJSONObject.toString() });
    if (this.kzH == null) {
      this.kzH = a(this, paramc, paramInt);
    }
    this.kzH.kmu = paramInt;
    this.kzH.appId = ((String)localObject1);
    SetBackgroundAudioListenerTask.a(this.kzH);
    ??? = z.Br("AppBrandService#" + paramc.hashCode());
    a((String)???, paramc);
    com.tencent.mm.plugin.appbrand.jsapi.s.a locala;
    for (;;)
    {
      synchronized (z.aBG().F((String)???, true))
      {
        if ((h.c)((z.b)???).get("AppBrandLifeCycle.Listener", null) == null)
        {
          localObject3 = new h.c()
          {
            public final void onDestroy()
            {
              AppMethodBeat.i(145750);
              String str = this.kzL.getString("appId", "");
              ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", new Object[] { str });
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("operationType", "stop");
                label49:
                JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = new JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask(JsApiSetBackgroundAudioState.this, paramc, paramInt);
                localSetBackgroundAudioStateTask.kzK = localJSONObject.toString();
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
          ((z.b)???).k("AppBrandLifeCycle.Listener", localObject3);
          ((z.b)???).k("appId", localObject1);
          this.kzH.clN = ((h.c)localObject3);
        }
        AppBrandMainProcessService.a(this.kzH);
        Object localObject3 = b(this, paramc, paramInt);
        ((SetBackgroundAudioStateTask)localObject3).kmu = paramInt;
        ((SetBackgroundAudioStateTask)localObject3).appId = ((String)localObject1);
        ((SetBackgroundAudioStateTask)localObject3).kzK = paramJSONObject.toString();
        ??? = paramJSONObject.optString("src");
        if ((??? == null) || (((String)???).length() <= 0))
        {
          localObject1 = "";
          ((SetBackgroundAudioStateTask)localObject3).dCC = ((String)localObject1);
          locala = (com.tencent.mm.plugin.appbrand.jsapi.s.a)e.K(com.tencent.mm.plugin.appbrand.jsapi.s.a.class);
          if (locala != null) {
            break;
          }
          ae.w("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerHelper is null");
          paramc = new Pair(null, "invalidReferrer");
          ((SetBackgroundAudioStateTask)localObject3).hOJ = ((String)paramc.first);
          ((SetBackgroundAudioStateTask)localObject3).hOK = ((String)paramc.second);
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
          localObject1 = paramc.Fl().MP((String)???);
          if ((localObject1 != null) && (((k)localObject1).exists()))
          {
            ??? = w.B(((k)localObject1).fTh());
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
    ??? = locala.W(paramJSONObject);
    if (??? != null)
    {
      localObject1 = locala.Rd((String)???);
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null) {
        paramJSONObject = locala.x(paramc);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.s.c.liO == paramJSONObject) {
        paramc = null;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", new Object[] { ???, paramc });
      paramc = new Pair(???, paramc);
      break;
      if (com.tencent.mm.plugin.appbrand.jsapi.s.c.liN == paramJSONObject) {
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
    h.c clN;
    public String dpI;
    public String duJ;
    public int duK;
    private boolean kAt;
    public int kmu;
    private m kuO;
    public com.tencent.mm.plugin.appbrand.jsapi.c kws;
    public String kzR;
    private final com.tencent.mm.sdk.b.c kzS;
    
    static
    {
      AppMethodBeat.i(145761);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145761);
    }
    
    public SetBackgroundAudioListenerTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145754);
      this.kAt = false;
      this.kzS = new com.tencent.mm.sdk.b.c() {};
      e(paramParcel);
      AppMethodBeat.o(145754);
    }
    
    public SetBackgroundAudioListenerTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      AppMethodBeat.i(145753);
      this.kAt = false;
      this.kzS = new com.tencent.mm.sdk.b.c() {};
      this.kuO = parama;
      this.kws = paramc;
      this.kmu = paramInt;
      AppMethodBeat.o(145753);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(145755);
      ae.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
      if (this.kAt)
      {
        ae.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
        this.kAt = false;
        localObject = new mg();
        ((mg)localObject).dAP.action = 10;
        ((mg)localObject).dAP.state = "preempted";
        ((mg)localObject).dAP.appId = this.appId;
        ((mg)localObject).dAP.dAR = true;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
      Object localObject = a.a.bto().lVx;
      if (!bu.isNullOrNil((String)localObject))
      {
        ae.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", new Object[] { localObject, this.appId });
        a.a.bto().SZ((String)localObject);
      }
      a.a.bto().a(this.kzS, this.appId);
      localObject = a.a.bto();
      String str1 = this.appId;
      int i = this.duK;
      String str2 = this.dpI;
      String str3 = this.duJ;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).lVx = str1;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).duK = i;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).dpI = str2;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).duJ = str3;
      AppMethodBeat.o(145755);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(145756);
      if (this.kws == null)
      {
        ae.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
        AppMethodBeat.o(145756);
        return;
      }
      sP(this.action);
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
        ae.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.kzR });
        new JsApiOperateBackgroundAudio.c().h(this.kws).PQ(this.kzR).bja();
        localAppBrandMusicClientService = AppBrandMusicClientService.lVt;
        i = this.action;
        ae.i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", new Object[] { Integer.valueOf(i) });
        localIterator = localAppBrandMusicClientService.lVs.entrySet().iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label394;
        }
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (AppBrandMusicClientService.a)((Map.Entry)localObject).getValue();
          if ((!TextUtils.isEmpty(localAppBrandMusicClientService.lVu)) && (localAppBrandMusicClientService.lVu.equalsIgnoreCase(str)))
          {
            ae.i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", new Object[] { localAppBrandMusicClientService.lVu });
            if (localObject != null)
            {
              if (i == 10)
              {
                ((AppBrandMusicClientService.a)localObject).bbP();
                continue;
                h.a(this.appId, this.clN);
                AppBrandMusicClientService.lVt.lVu = this.appId;
                break;
                h.b(this.appId, this.clN);
                break;
                JsApiOperateBackgroundAudio.b.m(this.kws);
                AppMethodBeat.o(145756);
                return;
                JsApiOperateBackgroundAudio.a.m(this.kws);
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
      label394:
      AppMethodBeat.o(145756);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145757);
      this.appId = paramParcel.readString();
      this.kzR = paramParcel.readString();
      this.action = paramParcel.readInt();
      this.duK = paramParcel.readInt();
      this.dpI = paramParcel.readString();
      this.duJ = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kAt = bool;
        AppMethodBeat.o(145757);
        return;
        bool = false;
      }
    }
    
    protected void sP(int paramInt) {}
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145758);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kzR);
      paramParcel.writeInt(this.action);
      paramParcel.writeInt(this.duK);
      paramParcel.writeString(this.dpI);
      paramParcel.writeString(this.duJ);
      if (this.kAt) {}
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
    public String dCC;
    public boolean error;
    public String hOJ;
    public String hOK;
    public String iIJ;
    public int kmu;
    private m kuO;
    public com.tencent.mm.plugin.appbrand.jsapi.c kws;
    public String kzK;
    
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
      this.iIJ = "";
      this.hOJ = null;
      this.hOK = null;
      e(paramParcel);
      AppMethodBeat.o(145763);
    }
    
    public SetBackgroundAudioStateTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.error = false;
      this.iIJ = "";
      this.hOJ = null;
      this.hOK = null;
      this.kuO = parama;
      this.kws = paramc;
      this.kmu = paramInt;
    }
    
    public String PT(String paramString)
    {
      AppMethodBeat.i(145764);
      paramString = com.tencent.mm.loader.j.b.asj() + "/image/" + paramString.hashCode();
      AppMethodBeat.o(145764);
      return paramString;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(145765);
      ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
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
        Object localObject1 = new JSONObject(this.kzK);
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
        ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
        str1 = a.a.bto().lVx;
        if ((!bu.isNullOrNil(str1)) && (!str1.equals(this.appId)))
        {
          ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str1, this.appId });
          AppMethodBeat.o(145765);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        ae.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
        this.error = true;
        this.iIJ = "parser data fail, data is invalid";
        ae.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + localJSONException.getMessage());
        biG();
        AppMethodBeat.o(145765);
        return;
      }
      this.error = false;
      if (localJSONException.equalsIgnoreCase("pause"))
      {
        if (com.tencent.mm.ay.b.aKf())
        {
          ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
          AppMethodBeat.o(145765);
          return;
        }
        this.error = true;
        this.iIJ = "pause music fail";
      }
      for (;;)
      {
        biG();
        AppMethodBeat.o(145765);
        return;
        if (localJSONException.equalsIgnoreCase("stop"))
        {
          if (com.tencent.mm.ay.b.aKg())
          {
            ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
            AppMethodBeat.o(145765);
            return;
          }
          this.error = true;
          this.iIJ = "stop music fail";
        }
      }
      label361:
      if (TextUtils.isEmpty(str4))
      {
        ae.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
        this.error = true;
        this.iIJ = "src is null";
        biG();
        AppMethodBeat.o(145765);
        return;
      }
      if ((str3 != null) && (str3.length() > 32768))
      {
        ae.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is large than 32KB");
        this.error = true;
        this.iIJ = "songLyric is large than 32KB";
        biG();
        AppMethodBeat.o(145765);
        return;
      }
      ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%f, localPath:%s, playbackRate:%f", new Object[] { str4, str5, str6, str7, str1, str2, str8, Double.valueOf(d2), this.dCC, Double.valueOf(d1) });
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
          ae.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is empty");
          localObject2 = g.a(11, (String)localObject2, str5, str7, str8, str4, str4, new StringBuilder().append(this.appId).append(str4).append((String)localObject2).toString().hashCode(), com.tencent.mm.loader.j.b.asj(), PT((String)localObject2), str6, this.appId);
          ((f)localObject2).dez = ((int)(1000.0D * d2));
          ((f)localObject2).protocol = str2;
          ((f)localObject2).iki = str3;
          ((f)localObject2).hOB = d1;
          if (this.dCC.startsWith("file://")) {
            ((f)localObject2).ikl = this.dCC;
          }
          ((f)localObject2).hOJ = this.hOJ;
          ((f)localObject2).hOK = this.hOK;
          ((f)localObject2).volume = ((float)d3);
          a.a.bto().lVy = ((f)localObject2).ijZ;
          a.a.bto().lVz = ((f)localObject2);
          if ((!((f)localObject2).g(com.tencent.mm.ay.a.aKc())) || (!com.tencent.mm.ay.a.aJZ())) {
            break label825;
          }
          i = 1;
          label755:
          if (i != 0) {
            break label831;
          }
          ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "play the music");
          com.tencent.mm.ay.a.c((f)localObject2);
        }
        for (;;)
        {
          ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
          ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
          this.error = false;
          biG();
          AppMethodBeat.o(145765);
          return;
          ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric:%s", new Object[] { str3 });
          break;
          label825:
          i = 0;
          break label755;
          label831:
          ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "The same music is playing");
          com.tencent.mm.ay.a.b((f)localObject2);
        }
      }
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(145766);
      if (this.kws == null)
      {
        ae.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
        AppMethodBeat.o(145766);
        return;
      }
      if (!this.error)
      {
        ae.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
        this.kws.h(this.kmu, this.kuO.e("ok", null));
        AppMethodBeat.o(145766);
        return;
      }
      ae.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", new Object[] { this.iIJ });
      this.kws.h(this.kmu, this.kuO.e("fail:" + this.iIJ, null));
      AppMethodBeat.o(145766);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145767);
      this.appId = paramParcel.readString();
      this.kzK = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.error = bool;
        this.iIJ = paramParcel.readString();
        this.dCC = paramParcel.readString();
        this.hOJ = paramParcel.readString();
        this.hOK = paramParcel.readString();
        AppMethodBeat.o(145767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145768);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kzK);
      if (this.error) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.iIJ);
        paramParcel.writeString(this.dCC);
        paramParcel.writeString(this.hOJ);
        paramParcel.writeString(this.hOK);
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