package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.lw;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  protected SetBackgroundAudioListenerTask kbT;
  
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
      ac.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
      AppMethodBeat.o(145770);
      return;
    }
    Object localObject1 = paramc.getAppId();
    ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", new Object[] { localObject1, paramJSONObject.toString() });
    if (this.kbT == null) {
      this.kbT = a(this, paramc, paramInt);
    }
    this.kbT.jOT = paramInt;
    this.kbT.appId = ((String)localObject1);
    SetBackgroundAudioListenerTask.a(this.kbT);
    ??? = y.xJ("AppBrandService#" + paramc.hashCode());
    a((String)???, paramc);
    com.tencent.mm.plugin.appbrand.jsapi.p.a locala;
    for (;;)
    {
      synchronized (y.ayq().F((String)???, true))
      {
        if ((g.c)((y.b)???).get("AppBrandLifeCycle.Listener", null) == null)
        {
          localObject3 = new g.c()
          {
            public final void onDestroy()
            {
              AppMethodBeat.i(145750);
              String str = this.kbX.getString("appId", "");
              ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", new Object[] { str });
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("operationType", "stop");
                label49:
                JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = new JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask(JsApiSetBackgroundAudioState.this, paramc, paramInt);
                localSetBackgroundAudioStateTask.kbW = localJSONObject.toString();
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
          ((y.b)???).l("AppBrandLifeCycle.Listener", localObject3);
          ((y.b)???).l("appId", localObject1);
          this.kbT.cbu = ((g.c)localObject3);
        }
        AppBrandMainProcessService.a(this.kbT);
        Object localObject3 = b(this, paramc, paramInt);
        ((SetBackgroundAudioStateTask)localObject3).jOT = paramInt;
        ((SetBackgroundAudioStateTask)localObject3).appId = ((String)localObject1);
        ((SetBackgroundAudioStateTask)localObject3).kbW = paramJSONObject.toString();
        ??? = paramJSONObject.optString("src");
        if ((??? == null) || (((String)???).length() <= 0))
        {
          localObject1 = "";
          ((SetBackgroundAudioStateTask)localObject3).dpK = ((String)localObject1);
          locala = (com.tencent.mm.plugin.appbrand.jsapi.p.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.p.a.class);
          if (locala != null) {
            break;
          }
          ac.w("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerHelper is null");
          paramc = new Pair(null, "invalidReferrer");
          ((SetBackgroundAudioStateTask)localObject3).hty = ((String)paramc.first);
          ((SetBackgroundAudioStateTask)localObject3).htz = ((String)paramc.second);
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
          localObject1 = paramc.DH().IS((String)???);
          if ((localObject1 != null) && (((com.tencent.mm.vfs.e)localObject1).exists()))
          {
            ??? = q.B(((com.tencent.mm.vfs.e)localObject1).fxV());
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
      localObject1 = locala.MX((String)???);
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null) {
        paramJSONObject = locala.x(paramc);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.p.c.kIJ == paramJSONObject) {
        paramc = null;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", new Object[] { ???, paramc });
      paramc = new Pair(???, paramc);
      break;
      if (com.tencent.mm.plugin.appbrand.jsapi.p.c.kII == paramJSONObject) {
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
    g.c cbu;
    public String ddh;
    public String dia;
    public int dib;
    public int jOT;
    private m jXc;
    public com.tencent.mm.plugin.appbrand.jsapi.c jYG;
    private boolean kcE;
    public String kcd;
    private final com.tencent.mm.sdk.b.c kce;
    
    static
    {
      AppMethodBeat.i(145761);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145761);
    }
    
    public SetBackgroundAudioListenerTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145754);
      this.kcE = false;
      this.kce = new com.tencent.mm.sdk.b.c() {};
      e(paramParcel);
      AppMethodBeat.o(145754);
    }
    
    public SetBackgroundAudioListenerTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      AppMethodBeat.i(145753);
      this.kcE = false;
      this.kce = new com.tencent.mm.sdk.b.c() {};
      this.jXc = parama;
      this.jYG = paramc;
      this.jOT = paramInt;
      AppMethodBeat.o(145753);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(145755);
      ac.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
      if (this.kcE)
      {
        ac.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
        this.kcE = false;
        localObject = new lw();
        ((lw)localObject).dnW.action = 10;
        ((lw)localObject).dnW.state = "preempted";
        ((lw)localObject).dnW.appId = this.appId;
        ((lw)localObject).dnW.dnY = true;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      }
      Object localObject = a.a.boE().lrM;
      if (!bs.isNullOrNil((String)localObject))
      {
        ac.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", new Object[] { localObject, this.appId });
        a.a.boE().ON((String)localObject);
      }
      a.a.boE().a(this.kce, this.appId);
      localObject = a.a.boE();
      String str1 = this.appId;
      int i = this.dib;
      String str2 = this.ddh;
      String str3 = this.dia;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).lrM = str1;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).dib = i;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).ddh = str2;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).dia = str3;
      AppMethodBeat.o(145755);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(145756);
      if (this.jYG == null)
      {
        ac.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
        AppMethodBeat.o(145756);
        return;
      }
      sk(this.action);
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
        ac.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.kcd });
        new JsApiOperateBackgroundAudio.c().h(this.jYG).LO(this.kcd).beN();
        localAppBrandMusicClientService = AppBrandMusicClientService.lrI;
        i = this.action;
        ac.i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", new Object[] { Integer.valueOf(i) });
        localIterator = localAppBrandMusicClientService.lrH.entrySet().iterator();
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
          if ((!TextUtils.isEmpty(localAppBrandMusicClientService.lrJ)) && (localAppBrandMusicClientService.lrJ.equalsIgnoreCase(str)))
          {
            ac.i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", new Object[] { localAppBrandMusicClientService.lrJ });
            if (localObject != null)
            {
              if (i == 10)
              {
                ((AppBrandMusicClientService.a)localObject).aXP();
                continue;
                com.tencent.mm.plugin.appbrand.g.a(this.appId, this.cbu);
                AppBrandMusicClientService.lrI.lrJ = this.appId;
                break;
                com.tencent.mm.plugin.appbrand.g.b(this.appId, this.cbu);
                break;
                JsApiOperateBackgroundAudio.b.m(this.jYG);
                AppMethodBeat.o(145756);
                return;
                JsApiOperateBackgroundAudio.a.m(this.jYG);
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
      this.kcd = paramParcel.readString();
      this.action = paramParcel.readInt();
      this.dib = paramParcel.readInt();
      this.ddh = paramParcel.readString();
      this.dia = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kcE = bool;
        AppMethodBeat.o(145757);
        return;
        bool = false;
      }
    }
    
    protected void sk(int paramInt) {}
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145758);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kcd);
      paramParcel.writeInt(this.action);
      paramParcel.writeInt(this.dib);
      paramParcel.writeString(this.ddh);
      paramParcel.writeString(this.dia);
      if (this.kcE) {}
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
    public String dpK;
    public boolean error;
    public String hty;
    public String htz;
    public String imz;
    public int jOT;
    private m jXc;
    public com.tencent.mm.plugin.appbrand.jsapi.c jYG;
    public String kbW;
    
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
      this.imz = "";
      this.hty = null;
      this.htz = null;
      e(paramParcel);
      AppMethodBeat.o(145763);
    }
    
    public SetBackgroundAudioStateTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.error = false;
      this.imz = "";
      this.hty = null;
      this.htz = null;
      this.jXc = parama;
      this.jYG = paramc;
      this.jOT = paramInt;
    }
    
    public String LQ(String paramString)
    {
      AppMethodBeat.i(145764);
      paramString = com.tencent.mm.loader.j.b.aph() + "/image/" + paramString.hashCode();
      AppMethodBeat.o(145764);
      return paramString;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(145765);
      ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
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
        Object localObject1 = new JSONObject(this.kbW);
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
        ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
        str1 = a.a.boE().lrM;
        if ((!bs.isNullOrNil(str1)) && (!str1.equals(this.appId)))
        {
          ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str1, this.appId });
          AppMethodBeat.o(145765);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        ac.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
        this.error = true;
        this.imz = "parser data fail, data is invalid";
        ac.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + localJSONException.getMessage());
        bet();
        AppMethodBeat.o(145765);
        return;
      }
      this.error = false;
      if (localJSONException.equalsIgnoreCase("pause"))
      {
        if (com.tencent.mm.ay.b.aGB())
        {
          ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
          AppMethodBeat.o(145765);
          return;
        }
        this.error = true;
        this.imz = "pause music fail";
      }
      for (;;)
      {
        bet();
        AppMethodBeat.o(145765);
        return;
        if (localJSONException.equalsIgnoreCase("stop"))
        {
          if (com.tencent.mm.ay.b.aGC())
          {
            ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
            AppMethodBeat.o(145765);
            return;
          }
          this.error = true;
          this.imz = "stop music fail";
        }
      }
      label361:
      if (TextUtils.isEmpty(str4))
      {
        ac.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
        this.error = true;
        this.imz = "src is null";
        bet();
        AppMethodBeat.o(145765);
        return;
      }
      if ((str3 != null) && (str3.length() > 32768))
      {
        ac.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is large than 32KB");
        this.error = true;
        this.imz = "songLyric is large than 32KB";
        bet();
        AppMethodBeat.o(145765);
        return;
      }
      ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%f, localPath:%s, playbackRate:%f", new Object[] { str4, str5, str6, str7, str1, str2, str8, Double.valueOf(d2), this.dpK, Double.valueOf(d1) });
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
          ac.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is empty");
          localObject2 = com.tencent.mm.ay.g.a(11, (String)localObject2, str5, str7, str8, str4, str4, new StringBuilder().append(this.appId).append(str4).append((String)localObject2).toString().hashCode(), com.tencent.mm.loader.j.b.aph(), LQ((String)localObject2), str6, this.appId);
          ((f)localObject2).cSh = ((int)(1000.0D * d2));
          ((f)localObject2).protocol = str2;
          ((f)localObject2).hOb = str3;
          ((f)localObject2).htq = d1;
          if (this.dpK.startsWith("file://")) {
            ((f)localObject2).hOe = this.dpK;
          }
          ((f)localObject2).hty = this.hty;
          ((f)localObject2).htz = this.htz;
          ((f)localObject2).volume = ((float)d3);
          a.a.boE().lrN = ((f)localObject2).hNS;
          a.a.boE().lrO = ((f)localObject2);
          if ((!((f)localObject2).g(com.tencent.mm.ay.a.aGy())) || (!com.tencent.mm.ay.a.aGv())) {
            break label825;
          }
          i = 1;
          label755:
          if (i != 0) {
            break label831;
          }
          ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "play the music");
          com.tencent.mm.ay.a.c((f)localObject2);
        }
        for (;;)
        {
          ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
          ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
          this.error = false;
          bet();
          AppMethodBeat.o(145765);
          return;
          ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric:%s", new Object[] { str3 });
          break;
          label825:
          i = 0;
          break label755;
          label831:
          ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "The same music is playing");
          com.tencent.mm.ay.a.b((f)localObject2);
        }
      }
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(145766);
      if (this.jYG == null)
      {
        ac.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
        AppMethodBeat.o(145766);
        return;
      }
      if (!this.error)
      {
        ac.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
        this.jYG.h(this.jOT, this.jXc.e("ok", null));
        AppMethodBeat.o(145766);
        return;
      }
      ac.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", new Object[] { this.imz });
      this.jYG.h(this.jOT, this.jXc.e("fail:" + this.imz, null));
      AppMethodBeat.o(145766);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145767);
      this.appId = paramParcel.readString();
      this.kbW = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.error = bool;
        this.imz = paramParcel.readString();
        this.dpK = paramParcel.readString();
        this.hty = paramParcel.readString();
        this.htz = paramParcel.readString();
        AppMethodBeat.o(145767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145768);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kbW);
      if (this.error) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.imz);
        paramParcel.writeString(this.dpK);
        paramParcel.writeString(this.hty);
        paramParcel.writeString(this.htz);
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