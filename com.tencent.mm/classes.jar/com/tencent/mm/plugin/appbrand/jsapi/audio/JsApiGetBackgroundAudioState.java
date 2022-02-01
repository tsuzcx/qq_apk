package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetBackgroundAudioState
  extends y
{
  public static final int CTRL_INDEX = 159;
  public static final String NAME = "getBackgroundAudioState";
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145718);
    paramc = paramc.getAppId();
    paramJSONObject = new GetBackgroundAudioStateTask();
    paramJSONObject.appId = paramc;
    if (!AppBrandMainProcessService.b(paramJSONObject))
    {
      ac.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
      paramc = e("fail", null);
      AppMethodBeat.o(145718);
      return paramc;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Double.valueOf(paramJSONObject.kbG));
    localHashMap.put("currentTime", Double.valueOf(paramJSONObject.kbH));
    boolean bool;
    if (paramJSONObject.hVG == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Double.valueOf(paramJSONObject.kbI));
      localHashMap.put("src", paramJSONObject.cQK);
      localHashMap.put("title", paramJSONObject.title);
      localHashMap.put("epname", paramJSONObject.kbJ);
      localHashMap.put("singer", paramJSONObject.kbK);
      localHashMap.put("coverImgUrl", paramJSONObject.coverImgUrl);
      localHashMap.put("webUrl", paramJSONObject.kbL);
      if (paramJSONObject.protocol != null) {
        break label371;
      }
      paramc = "";
      label232:
      localHashMap.put("protocol", paramc);
      localHashMap.put("startTime", Integer.valueOf(paramJSONObject.cSh / 1000));
      localHashMap.put("songLyric", paramJSONObject.songLyric);
      localHashMap.put("playbackRate", Double.valueOf(paramJSONObject.htq));
      localHashMap.put("referrerPolicy", paramJSONObject.hty);
      if (!TextUtils.isEmpty(paramJSONObject.imz)) {
        break label379;
      }
    }
    label371:
    label379:
    for (paramc = "";; paramc = paramJSONObject.imz)
    {
      if (!paramJSONObject.error) {
        break label387;
      }
      ac.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", new Object[] { paramc });
      paramc = e("fail:".concat(String.valueOf(paramc)), null);
      AppMethodBeat.o(145718);
      return paramc;
      bool = false;
      break;
      paramc = paramJSONObject.protocol;
      break label232;
    }
    label387:
    ac.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
    paramc = k("ok", localHashMap);
    AppMethodBeat.o(145718);
    return paramc;
  }
  
  static class GetBackgroundAudioStateTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetBackgroundAudioStateTask> CREATOR;
    public String appId;
    public String cQK;
    public int cSh;
    public String coverImgUrl;
    public boolean error;
    public int hVG;
    public double htq;
    public String hty;
    public String imz;
    public double kbG;
    public double kbH;
    public double kbI;
    public String kbJ;
    public String kbK;
    public String kbL;
    public String protocol;
    public String songLyric;
    public String title;
    
    static
    {
      AppMethodBeat.i(145717);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145717);
    }
    
    public GetBackgroundAudioStateTask()
    {
      this.appId = "";
      this.kbG = 0.0D;
      this.hty = null;
      this.error = false;
    }
    
    public GetBackgroundAudioStateTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145713);
      this.appId = "";
      this.kbG = 0.0D;
      this.hty = null;
      this.error = false;
      e(paramParcel);
      AppMethodBeat.o(145713);
    }
    
    public final void aLq()
    {
      double d = 0.0D;
      AppMethodBeat.i(145714);
      Object localObject = a.a.boE().lrM;
      if ((!bs.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.appId)))
      {
        ac.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[] { localObject, this.appId });
        this.error = true;
        this.imz = "appid not match cannot get background audio state";
        bet();
        AppMethodBeat.o(145714);
        return;
      }
      localObject = com.tencent.mm.ay.a.aGy();
      int i;
      if (localObject != null)
      {
        com.tencent.mm.ay.c localc = com.tencent.mm.ay.a.aGz();
        int j = -1;
        i = -1;
        if (localc != null)
        {
          j = localc.asf;
          i = localc.mPosition;
        }
        if ((localc == null) || (j < 0) || (i < 0))
        {
          ac.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          this.error = true;
          this.imz = "return parameter is invalid";
          bet();
          AppMethodBeat.o(145714);
          return;
        }
        this.kbG = (j / 1000.0D);
        this.kbH = (i / 1000.0D);
        i = localc.mStatus;
        j = localc.hNM;
        if (this.kbG > 0.0D) {
          d = j * this.kbG / 100.0D;
        }
        this.kbI = d;
        if (i == 1)
        {
          i = 0;
          this.hVG = i;
          this.cQK = ((f)localObject).hNY;
          this.title = ((f)localObject).hNU;
          this.kbJ = ((f)localObject).hNW;
          this.kbK = ((f)localObject).hNV;
          this.coverImgUrl = ((f)localObject).hNX;
          this.kbL = ((f)localObject).hOa;
          this.protocol = ((f)localObject).protocol;
          this.cSh = ((f)localObject).cSh;
          this.songLyric = ((f)localObject).hOb;
          this.htq = ((f)localObject).htq;
          this.hty = ((f)localObject).hty;
          ac.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s, playbackRate:%f, referrerPolicy: %s", new Object[] { Double.valueOf(this.kbG), Double.valueOf(this.kbH), Integer.valueOf(this.hVG), Double.valueOf(this.kbI), this.cQK, Integer.valueOf(this.cSh), this.title, this.kbK, this.kbL, this.coverImgUrl, this.protocol, Double.valueOf(this.htq), this.hty });
        }
      }
      for (;;)
      {
        bet();
        AppMethodBeat.o(145714);
        return;
        i = 1;
        break;
        ac.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
        this.error = true;
        this.imz = "currentWrapper is null";
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(145715);
      this.appId = paramParcel.readString();
      this.kbG = paramParcel.readDouble();
      this.kbH = paramParcel.readDouble();
      this.hVG = paramParcel.readInt();
      this.kbI = paramParcel.readDouble();
      this.cQK = paramParcel.readString();
      this.title = paramParcel.readString();
      this.kbJ = paramParcel.readString();
      this.kbK = paramParcel.readString();
      this.coverImgUrl = paramParcel.readString();
      this.kbL = paramParcel.readString();
      this.protocol = paramParcel.readString();
      this.songLyric = paramParcel.readString();
      this.cSh = paramParcel.readInt();
      this.htq = paramParcel.readDouble();
      this.hty = paramParcel.readString();
      AppMethodBeat.o(145715);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145716);
      paramParcel.writeString(this.appId);
      paramParcel.writeDouble(this.kbG);
      paramParcel.writeDouble(this.kbH);
      paramParcel.writeInt(this.hVG);
      paramParcel.writeDouble(this.kbI);
      paramParcel.writeString(this.cQK);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.kbJ);
      paramParcel.writeString(this.kbK);
      paramParcel.writeString(this.coverImgUrl);
      paramParcel.writeString(this.kbL);
      paramParcel.writeString(this.protocol);
      paramParcel.writeString(this.songLyric);
      paramParcel.writeInt(this.cSh);
      paramParcel.writeDouble(this.htq);
      paramParcel.writeString(this.hty);
      AppMethodBeat.o(145716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */