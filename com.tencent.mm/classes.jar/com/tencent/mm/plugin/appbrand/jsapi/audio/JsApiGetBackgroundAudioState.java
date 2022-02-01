package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
      ad.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
      paramc = e("fail", null);
      AppMethodBeat.o(145718);
      return paramc;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Double.valueOf(paramJSONObject.jBk));
    localHashMap.put("currentTime", Double.valueOf(paramJSONObject.jBl));
    boolean bool;
    if (paramJSONObject.hvf == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Double.valueOf(paramJSONObject.jBm));
      localHashMap.put("src", paramJSONObject.cTn);
      localHashMap.put("title", paramJSONObject.title);
      localHashMap.put("epname", paramJSONObject.jBn);
      localHashMap.put("singer", paramJSONObject.jBo);
      localHashMap.put("coverImgUrl", paramJSONObject.coverImgUrl);
      localHashMap.put("webUrl", paramJSONObject.jBp);
      if (paramJSONObject.protocol != null) {
        break label371;
      }
      paramc = "";
      label232:
      localHashMap.put("protocol", paramc);
      localHashMap.put("startTime", Integer.valueOf(paramJSONObject.cUL / 1000));
      localHashMap.put("songLyric", paramJSONObject.songLyric);
      localHashMap.put("playbackRate", Double.valueOf(paramJSONObject.gSR));
      localHashMap.put("referrerPolicy", paramJSONObject.gSZ);
      if (!TextUtils.isEmpty(paramJSONObject.hMd)) {
        break label379;
      }
    }
    label371:
    label379:
    for (paramc = "";; paramc = paramJSONObject.hMd)
    {
      if (!paramJSONObject.error) {
        break label387;
      }
      ad.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", new Object[] { paramc });
      paramc = e("fail:".concat(String.valueOf(paramc)), null);
      AppMethodBeat.o(145718);
      return paramc;
      bool = false;
      break;
      paramc = paramJSONObject.protocol;
      break label232;
    }
    label387:
    ad.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
    paramc = k("ok", localHashMap);
    AppMethodBeat.o(145718);
    return paramc;
  }
  
  static class GetBackgroundAudioStateTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetBackgroundAudioStateTask> CREATOR;
    public String appId;
    public String cTn;
    public int cUL;
    public String coverImgUrl;
    public boolean error;
    public double gSR;
    public String gSZ;
    public String hMd;
    public int hvf;
    public double jBk;
    public double jBl;
    public double jBm;
    public String jBn;
    public String jBo;
    public String jBp;
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
      this.jBk = 0.0D;
      this.gSZ = null;
      this.error = false;
    }
    
    public GetBackgroundAudioStateTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145713);
      this.appId = "";
      this.jBk = 0.0D;
      this.gSZ = null;
      this.error = false;
      e(paramParcel);
      AppMethodBeat.o(145713);
    }
    
    public final void aEz()
    {
      double d = 0.0D;
      AppMethodBeat.i(145714);
      Object localObject = a.a.bhK().kQn;
      if ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.appId)))
      {
        ad.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[] { localObject, this.appId });
        this.error = true;
        this.hMd = "appid not match cannot get background audio state";
        aXw();
        AppMethodBeat.o(145714);
        return;
      }
      localObject = com.tencent.mm.az.a.azI();
      int i;
      if (localObject != null)
      {
        com.tencent.mm.az.c localc = com.tencent.mm.az.a.azJ();
        int j = -1;
        i = -1;
        if (localc != null)
        {
          j = localc.ark;
          i = localc.mPosition;
        }
        if ((localc == null) || (j < 0) || (i < 0))
        {
          ad.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          this.error = true;
          this.hMd = "return parameter is invalid";
          aXw();
          AppMethodBeat.o(145714);
          return;
        }
        this.jBk = (j / 1000.0D);
        this.jBl = (i / 1000.0D);
        i = localc.mStatus;
        j = localc.hnj;
        if (this.jBk > 0.0D) {
          d = j * this.jBk / 100.0D;
        }
        this.jBm = d;
        if (i == 1)
        {
          i = 0;
          this.hvf = i;
          this.cTn = ((f)localObject).hnv;
          this.title = ((f)localObject).hnr;
          this.jBn = ((f)localObject).hnt;
          this.jBo = ((f)localObject).hns;
          this.coverImgUrl = ((f)localObject).hnu;
          this.jBp = ((f)localObject).hnx;
          this.protocol = ((f)localObject).protocol;
          this.cUL = ((f)localObject).cUL;
          this.songLyric = ((f)localObject).hny;
          this.gSR = ((f)localObject).gSR;
          this.gSZ = ((f)localObject).gSZ;
          ad.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s, playbackRate:%f, referrerPolicy: %s", new Object[] { Double.valueOf(this.jBk), Double.valueOf(this.jBl), Integer.valueOf(this.hvf), Double.valueOf(this.jBm), this.cTn, Integer.valueOf(this.cUL), this.title, this.jBo, this.jBp, this.coverImgUrl, this.protocol, Double.valueOf(this.gSR), this.gSZ });
        }
      }
      for (;;)
      {
        aXw();
        AppMethodBeat.o(145714);
        return;
        i = 1;
        break;
        ad.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
        this.error = true;
        this.hMd = "currentWrapper is null";
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(145715);
      this.appId = paramParcel.readString();
      this.jBk = paramParcel.readDouble();
      this.jBl = paramParcel.readDouble();
      this.hvf = paramParcel.readInt();
      this.jBm = paramParcel.readDouble();
      this.cTn = paramParcel.readString();
      this.title = paramParcel.readString();
      this.jBn = paramParcel.readString();
      this.jBo = paramParcel.readString();
      this.coverImgUrl = paramParcel.readString();
      this.jBp = paramParcel.readString();
      this.protocol = paramParcel.readString();
      this.songLyric = paramParcel.readString();
      this.cUL = paramParcel.readInt();
      this.gSR = paramParcel.readDouble();
      this.gSZ = paramParcel.readString();
      AppMethodBeat.o(145715);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145716);
      paramParcel.writeString(this.appId);
      paramParcel.writeDouble(this.jBk);
      paramParcel.writeDouble(this.jBl);
      paramParcel.writeInt(this.hvf);
      paramParcel.writeDouble(this.jBm);
      paramParcel.writeString(this.cTn);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.jBn);
      paramParcel.writeString(this.jBo);
      paramParcel.writeString(this.coverImgUrl);
      paramParcel.writeString(this.jBp);
      paramParcel.writeString(this.protocol);
      paramParcel.writeString(this.songLyric);
      paramParcel.writeInt(this.cUL);
      paramParcel.writeDouble(this.gSR);
      paramParcel.writeString(this.gSZ);
      AppMethodBeat.o(145716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */