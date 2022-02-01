package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.g;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.u.c;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiSetBackgroundAudioState
  extends d
{
  public static final int CTRL_INDEX = 160;
  public static final String NAME = "setBackgroundAudioState";
  protected SetBackgroundAudioListenerTask lEa;
  
  protected SetBackgroundAudioListenerTask a(d paramd, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
  {
    AppMethodBeat.i(145773);
    paramd = new SetBackgroundAudioListenerTask(this, paramf, paramInt);
    AppMethodBeat.o(145773);
    return paramd;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145770);
    if (paramJSONObject == null)
    {
      paramf.i(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
      AppMethodBeat.o(145770);
      return;
    }
    Object localObject1 = paramf.getAppId();
    Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", new Object[] { localObject1, paramJSONObject.toString() });
    if (this.lEa == null) {
      this.lEa = a(this, paramf, paramInt);
    }
    this.lEa.lqe = paramInt;
    this.lEa.appId = ((String)localObject1);
    SetBackgroundAudioListenerTask.a(this.lEa);
    ??? = ad.JX("AppBrandService#" + paramf.hashCode());
    a((String)???, paramf);
    com.tencent.mm.plugin.appbrand.jsapi.u.a locala;
    for (;;)
    {
      synchronized (ad.aVe().G((String)???, true))
      {
        if ((h.c)((ad.b)???).get("AppBrandLifeCycle.Listener", null) == null)
        {
          localObject3 = new h.c()
          {
            public final void onDestroy()
            {
              AppMethodBeat.i(145750);
              String str = this.lEe.getString("appId", "");
              Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", new Object[] { str });
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("operationType", "stop");
                label49:
                JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = new JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask(JsApiSetBackgroundAudioState.this, paramf, paramInt);
                localSetBackgroundAudioStateTask.lEd = localJSONObject.toString();
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
          ((ad.b)???).l("AppBrandLifeCycle.Listener", localObject3);
          ((ad.b)???).l("appId", localObject1);
          this.lEa.cxI = ((h.c)localObject3);
        }
        AppBrandMainProcessService.a(this.lEa);
        Object localObject3 = b(this, paramf, paramInt);
        ((SetBackgroundAudioStateTask)localObject3).lqe = paramInt;
        ((SetBackgroundAudioStateTask)localObject3).appId = ((String)localObject1);
        ((SetBackgroundAudioStateTask)localObject3).lEd = paramJSONObject.toString();
        ??? = paramJSONObject.optString("src");
        if ((??? == null) || (((String)???).length() <= 0))
        {
          localObject1 = "";
          ((SetBackgroundAudioStateTask)localObject3).dUs = ((String)localObject1);
          locala = (com.tencent.mm.plugin.appbrand.jsapi.u.a)e.M(com.tencent.mm.plugin.appbrand.jsapi.u.a.class);
          if (locala != null) {
            break;
          }
          Log.w("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerHelper is null");
          paramf = new Pair(null, "invalidReferrer");
          ((SetBackgroundAudioStateTask)localObject3).iJP = ((String)paramf.first);
          ((SetBackgroundAudioStateTask)localObject3).iJQ = ((String)paramf.second);
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
          localObject1 = paramf.getFileSystem().VY((String)???);
          if ((localObject1 != null) && (((o)localObject1).exists()))
          {
            ??? = aa.z(((o)localObject1).her());
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
    ??? = locala.af(paramJSONObject);
    if (??? != null)
    {
      localObject1 = locala.aaF((String)???);
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null) {
        paramJSONObject = locala.x(paramf);
      }
      if (c.mou == paramJSONObject) {
        paramf = null;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", new Object[] { ???, paramf });
      paramf = new Pair(???, paramf);
      break;
      if (c.mot == paramJSONObject) {
        paramf = locala.y(paramf);
      } else {
        paramf = "invalidReferrer";
      }
    }
  }
  
  protected void a(String paramString, com.tencent.mm.plugin.appbrand.jsapi.f paramf) {}
  
  protected SetBackgroundAudioStateTask b(d paramd, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
  {
    AppMethodBeat.i(145772);
    paramd = new SetBackgroundAudioStateTask(this, paramf, paramInt);
    AppMethodBeat.o(145772);
    return paramd;
  }
  
  public static class SetBackgroundAudioListenerTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SetBackgroundAudioListenerTask> CREATOR;
    public int action;
    public String appId;
    public String appUserName;
    public String brandName;
    h.c cxI;
    public int dMe;
    private p lAw;
    public com.tencent.mm.plugin.appbrand.jsapi.f lAx;
    private boolean lEM;
    public String lEk;
    private final IListener lEl;
    public int lqe;
    
    static
    {
      AppMethodBeat.i(145761);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145761);
    }
    
    public SetBackgroundAudioListenerTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145754);
      this.lEM = false;
      this.lEl = new IListener() {};
      f(paramParcel);
      AppMethodBeat.o(145754);
    }
    
    public SetBackgroundAudioListenerTask(d paramd, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      AppMethodBeat.i(145753);
      this.lEM = false;
      this.lEl = new IListener() {};
      this.lAw = paramd;
      this.lAx = paramf;
      this.lqe = paramInt;
      AppMethodBeat.o(145753);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(145755);
      Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
      if (this.lEM)
      {
        Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
        this.lEM = false;
        localObject = new mx();
        ((mx)localObject).dSE.action = 10;
        ((mx)localObject).dSE.state = "preempted";
        ((mx)localObject).dSE.appId = this.appId;
        ((mx)localObject).dSE.dSG = true;
        EventCenter.instance.publish((IEvent)localObject);
      }
      Object localObject = a.a.bOR().ncY;
      if (!Util.isNullOrNil((String)localObject))
      {
        Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", new Object[] { localObject, this.appId });
        a.a.bOR().acD((String)localObject);
      }
      a.a.bOR().a(this.lEl, this.appId);
      localObject = a.a.bOR();
      String str1 = this.appId;
      int i = this.dMe;
      String str2 = this.brandName;
      String str3 = this.appUserName;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).ncY = str1;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).dMe = i;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).brandName = str2;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).appUserName = str3;
      AppMethodBeat.o(145755);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(145756);
      if (this.lAx == null)
      {
        Log.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
        AppMethodBeat.o(145756);
        return;
      }
      wL(this.action);
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
        Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.lEk });
        new JsApiOperateBackgroundAudio.c().h(this.lAx).Zh(this.lEk).bEo();
        localAppBrandMusicClientService = AppBrandMusicClientService.ncV;
        i = this.action;
        Log.i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", new Object[] { Integer.valueOf(i) });
        localIterator = localAppBrandMusicClientService.ncU.entrySet().iterator();
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
          if ((!TextUtils.isEmpty(localAppBrandMusicClientService.ncW)) && (localAppBrandMusicClientService.ncW.equalsIgnoreCase(str)))
          {
            Log.i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", new Object[] { localAppBrandMusicClientService.ncW });
            if (localObject != null)
            {
              if (i == 10)
              {
                ((AppBrandMusicClientService.a)localObject).bxf();
                continue;
                h.a(this.appId, this.cxI);
                AppBrandMusicClientService.ncV.ncW = this.appId;
                break;
                h.b(this.appId, this.cxI);
                break;
                JsApiOperateBackgroundAudio.b.m(this.lAx);
                AppMethodBeat.o(145756);
                return;
                JsApiOperateBackgroundAudio.a.m(this.lAx);
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
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145757);
      this.appId = paramParcel.readString();
      this.lEk = paramParcel.readString();
      this.action = paramParcel.readInt();
      this.dMe = paramParcel.readInt();
      this.brandName = paramParcel.readString();
      this.appUserName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.lEM = bool;
        AppMethodBeat.o(145757);
        return;
        bool = false;
      }
    }
    
    protected void wL(int paramInt) {}
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145758);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.lEk);
      paramParcel.writeInt(this.action);
      paramParcel.writeInt(this.dMe);
      paramParcel.writeString(this.brandName);
      paramParcel.writeString(this.appUserName);
      if (this.lEM) {}
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
    public String dUs;
    public boolean error;
    public String iJP;
    public String iJQ;
    public String jFn;
    private p lAw;
    public com.tencent.mm.plugin.appbrand.jsapi.f lAx;
    public String lEd;
    public int lqe;
    
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
      this.jFn = "";
      this.iJP = null;
      this.iJQ = null;
      f(paramParcel);
      AppMethodBeat.o(145763);
    }
    
    public SetBackgroundAudioStateTask(d paramd, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      this.error = false;
      this.jFn = "";
      this.iJP = null;
      this.iJQ = null;
      this.lAw = paramd;
      this.lAx = paramf;
      this.lqe = paramInt;
    }
    
    public String Zn(String paramString)
    {
      AppMethodBeat.i(145764);
      paramString = com.tencent.mm.loader.j.b.aKJ() + "/image/" + paramString.hashCode();
      AppMethodBeat.o(145764);
      return paramString;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(145765);
      Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
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
        Object localObject1 = new JSONObject(this.lEd);
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
        Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
        str1 = a.a.bOR().ncY;
        if ((!Util.isNullOrNil(str1)) && (!str1.equals(this.appId)))
        {
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str1, this.appId });
          AppMethodBeat.o(145765);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
        this.error = true;
        this.jFn = "parser data fail, data is invalid";
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + localJSONException.getMessage());
        bDU();
        AppMethodBeat.o(145765);
        return;
      }
      this.error = false;
      if (localJSONException.equalsIgnoreCase("pause"))
      {
        if (com.tencent.mm.ay.b.bei())
        {
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
          AppMethodBeat.o(145765);
          return;
        }
        this.error = true;
        this.jFn = "pause music fail";
      }
      for (;;)
      {
        bDU();
        AppMethodBeat.o(145765);
        return;
        if (localJSONException.equalsIgnoreCase("stop"))
        {
          if (com.tencent.mm.ay.b.bej())
          {
            Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
            AppMethodBeat.o(145765);
            return;
          }
          this.error = true;
          this.jFn = "stop music fail";
        }
      }
      label361:
      if (TextUtils.isEmpty(str4))
      {
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
        this.error = true;
        this.jFn = "src is null";
        bDU();
        AppMethodBeat.o(145765);
        return;
      }
      if ((str3 != null) && (str3.length() > 32768))
      {
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is large than 32KB");
        this.error = true;
        this.jFn = "songLyric is large than 32KB";
        bDU();
        AppMethodBeat.o(145765);
        return;
      }
      Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%f, localPath:%s, playbackRate:%f", new Object[] { str4, str5, str6, str7, str1, str2, str8, Double.valueOf(d2), this.dUs, Double.valueOf(d1) });
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
          Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is empty");
          localObject2 = g.a(11, (String)localObject2, str5, str7, str8, str4, str4, new StringBuilder().append(this.appId).append(str4).append((String)localObject2).toString().hashCode(), com.tencent.mm.loader.j.b.aKJ(), Zn((String)localObject2), str6, this.appId);
          ((com.tencent.mm.ay.f)localObject2).dvv = ((int)(1000.0D * d2));
          ((com.tencent.mm.ay.f)localObject2).protocol = str2;
          ((com.tencent.mm.ay.f)localObject2).jfe = str3;
          ((com.tencent.mm.ay.f)localObject2).iJH = d1;
          if (this.dUs.startsWith("file://")) {
            ((com.tencent.mm.ay.f)localObject2).jfh = this.dUs;
          }
          ((com.tencent.mm.ay.f)localObject2).iJP = this.iJP;
          ((com.tencent.mm.ay.f)localObject2).iJQ = this.iJQ;
          ((com.tencent.mm.ay.f)localObject2).volume = ((float)d3);
          a.a.bOR().ncZ = ((com.tencent.mm.ay.f)localObject2).jeV;
          a.a.bOR().nda = ((com.tencent.mm.ay.f)localObject2);
          if ((!((com.tencent.mm.ay.f)localObject2).g(com.tencent.mm.ay.a.bef())) || (!com.tencent.mm.ay.a.bec())) {
            break label825;
          }
          i = 1;
          label755:
          if (i != 0) {
            break label831;
          }
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "play the music");
          com.tencent.mm.ay.a.c((com.tencent.mm.ay.f)localObject2);
        }
        for (;;)
        {
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
          this.error = false;
          bDU();
          AppMethodBeat.o(145765);
          return;
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric:%s", new Object[] { str3 });
          break;
          label825:
          i = 0;
          break label755;
          label831:
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "The same music is playing");
          com.tencent.mm.ay.a.b((com.tencent.mm.ay.f)localObject2);
        }
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(145766);
      if (this.lAx == null)
      {
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
        AppMethodBeat.o(145766);
        return;
      }
      if (!this.error)
      {
        Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
        this.lAx.i(this.lqe, this.lAw.h("ok", null));
        AppMethodBeat.o(145766);
        return;
      }
      Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", new Object[] { this.jFn });
      this.lAx.i(this.lqe, this.lAw.h("fail:" + this.jFn, null));
      AppMethodBeat.o(145766);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145767);
      this.appId = paramParcel.readString();
      this.lEd = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.error = bool;
        this.jFn = paramParcel.readString();
        this.dUs = paramParcel.readString();
        this.iJP = paramParcel.readString();
        this.iJQ = paramParcel.readString();
        AppMethodBeat.o(145767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145768);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.lEd);
      if (this.error) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jFn);
        paramParcel.writeString(this.dUs);
        paramParcel.writeString(this.iJP);
        paramParcel.writeString(this.iJQ);
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