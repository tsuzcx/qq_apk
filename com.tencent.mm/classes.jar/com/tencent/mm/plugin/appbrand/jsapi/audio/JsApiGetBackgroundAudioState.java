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
    localHashMap.put("duration", Double.valueOf(paramJSONObject.kwf));
    localHashMap.put("currentTime", Double.valueOf(paramJSONObject.kwg));
    boolean bool;
    if (paramJSONObject.ipb == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Double.valueOf(paramJSONObject.kwh));
      localHashMap.put("src", paramJSONObject.dca);
      localHashMap.put("title", paramJSONObject.title);
      localHashMap.put("epname", paramJSONObject.kwi);
      localHashMap.put("singer", paramJSONObject.kwj);
      localHashMap.put("coverImgUrl", paramJSONObject.coverImgUrl);
      localHashMap.put("webUrl", paramJSONObject.kwk);
      if (paramJSONObject.protocol != null) {
        break label371;
      }
      paramc = "";
      label232:
      localHashMap.put("protocol", paramc);
      localHashMap.put("startTime", Integer.valueOf(paramJSONObject.ddx / 1000));
      localHashMap.put("songLyric", paramJSONObject.songLyric);
      localHashMap.put("playbackRate", Double.valueOf(paramJSONObject.hLI));
      localHashMap.put("referrerPolicy", paramJSONObject.hLQ);
      if (!TextUtils.isEmpty(paramJSONObject.iFQ)) {
        break label379;
      }
    }
    label371:
    label379:
    for (paramc = "";; paramc = paramJSONObject.iFQ)
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
    paramc = m("ok", localHashMap);
    AppMethodBeat.o(145718);
    return paramc;
  }
  
  static class GetBackgroundAudioStateTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetBackgroundAudioStateTask> CREATOR;
    public String appId;
    public String coverImgUrl;
    public String dca;
    public int ddx;
    public boolean error;
    public double hLI;
    public String hLQ;
    public String iFQ;
    public int ipb;
    public double kwf;
    public double kwg;
    public double kwh;
    public String kwi;
    public String kwj;
    public String kwk;
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
      this.kwf = 0.0D;
      this.hLQ = null;
      this.error = false;
    }
    
    public GetBackgroundAudioStateTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145713);
      this.appId = "";
      this.kwf = 0.0D;
      this.hLQ = null;
      this.error = false;
      e(paramParcel);
      AppMethodBeat.o(145713);
    }
    
    public final void aOA()
    {
      double d = 0.0D;
      AppMethodBeat.i(145714);
      Object localObject = a.a.bsD().lQW;
      if ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.appId)))
      {
        ad.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[] { localObject, this.appId });
        this.error = true;
        this.iFQ = "appid not match cannot get background audio state";
        bhX();
        AppMethodBeat.o(145714);
        return;
      }
      localObject = com.tencent.mm.az.a.aJJ();
      int i;
      if (localObject != null)
      {
        com.tencent.mm.az.c localc = com.tencent.mm.az.a.aJK();
        int j = -1;
        i = -1;
        if (localc != null)
        {
          j = localc.atW;
          i = localc.mPosition;
        }
        if ((localc == null) || (j < 0) || (i < 0))
        {
          ad.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          this.error = true;
          this.iFQ = "return parameter is invalid";
          bhX();
          AppMethodBeat.o(145714);
          return;
        }
        this.kwf = (j / 1000.0D);
        this.kwg = (i / 1000.0D);
        i = localc.mStatus;
        j = localc.iha;
        if (this.kwf > 0.0D) {
          d = j * this.kwf / 100.0D;
        }
        this.kwh = d;
        if (i == 1)
        {
          i = 0;
          this.ipb = i;
          this.dca = ((f)localObject).ihm;
          this.title = ((f)localObject).ihi;
          this.kwi = ((f)localObject).ihk;
          this.kwj = ((f)localObject).ihj;
          this.coverImgUrl = ((f)localObject).ihl;
          this.kwk = ((f)localObject).iho;
          this.protocol = ((f)localObject).protocol;
          this.ddx = ((f)localObject).ddx;
          this.songLyric = ((f)localObject).ihp;
          this.hLI = ((f)localObject).hLI;
          this.hLQ = ((f)localObject).hLQ;
          ad.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s, playbackRate:%f, referrerPolicy: %s", new Object[] { Double.valueOf(this.kwf), Double.valueOf(this.kwg), Integer.valueOf(this.ipb), Double.valueOf(this.kwh), this.dca, Integer.valueOf(this.ddx), this.title, this.kwj, this.kwk, this.coverImgUrl, this.protocol, Double.valueOf(this.hLI), this.hLQ });
        }
      }
      for (;;)
      {
        bhX();
        AppMethodBeat.o(145714);
        return;
        i = 1;
        break;
        ad.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
        this.error = true;
        this.iFQ = "currentWrapper is null";
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(145715);
      this.appId = paramParcel.readString();
      this.kwf = paramParcel.readDouble();
      this.kwg = paramParcel.readDouble();
      this.ipb = paramParcel.readInt();
      this.kwh = paramParcel.readDouble();
      this.dca = paramParcel.readString();
      this.title = paramParcel.readString();
      this.kwi = paramParcel.readString();
      this.kwj = paramParcel.readString();
      this.coverImgUrl = paramParcel.readString();
      this.kwk = paramParcel.readString();
      this.protocol = paramParcel.readString();
      this.songLyric = paramParcel.readString();
      this.ddx = paramParcel.readInt();
      this.hLI = paramParcel.readDouble();
      this.hLQ = paramParcel.readString();
      AppMethodBeat.o(145715);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145716);
      paramParcel.writeString(this.appId);
      paramParcel.writeDouble(this.kwf);
      paramParcel.writeDouble(this.kwg);
      paramParcel.writeInt(this.ipb);
      paramParcel.writeDouble(this.kwh);
      paramParcel.writeString(this.dca);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.kwi);
      paramParcel.writeString(this.kwj);
      paramParcel.writeString(this.coverImgUrl);
      paramParcel.writeString(this.kwk);
      paramParcel.writeString(this.protocol);
      paramParcel.writeString(this.songLyric);
      paramParcel.writeInt(this.ddx);
      paramParcel.writeDouble(this.hLI);
      paramParcel.writeString(this.hLQ);
      AppMethodBeat.o(145716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */