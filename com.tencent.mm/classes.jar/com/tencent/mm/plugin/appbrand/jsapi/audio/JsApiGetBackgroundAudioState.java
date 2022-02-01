package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetBackgroundAudioState
  extends ab
{
  public static final int CTRL_INDEX = 159;
  public static final String NAME = "getBackgroundAudioState";
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145718);
    paramf = paramf.getAppId();
    paramJSONObject = new GetBackgroundAudioStateTask();
    paramJSONObject.appId = paramf;
    if (!AppBrandMainProcessService.b(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
      paramf = h("fail", null);
      AppMethodBeat.o(145718);
      return paramf;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Double.valueOf(paramJSONObject.lDN));
    localHashMap.put("currentTime", Double.valueOf(paramJSONObject.lDO));
    boolean bool;
    if (paramJSONObject.jnj == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Double.valueOf(paramJSONObject.lDP));
      localHashMap.put("src", paramJSONObject.dtT);
      localHashMap.put("title", paramJSONObject.title);
      localHashMap.put("epname", paramJSONObject.lDQ);
      localHashMap.put("singer", paramJSONObject.lDR);
      localHashMap.put("coverImgUrl", paramJSONObject.coverImgUrl);
      localHashMap.put("webUrl", paramJSONObject.lDS);
      if (paramJSONObject.protocol != null) {
        break label371;
      }
      paramf = "";
      label232:
      localHashMap.put("protocol", paramf);
      localHashMap.put("startTime", Integer.valueOf(paramJSONObject.dvv / 1000));
      localHashMap.put("songLyric", paramJSONObject.songLyric);
      localHashMap.put("playbackRate", Double.valueOf(paramJSONObject.iJH));
      localHashMap.put("referrerPolicy", paramJSONObject.iJP);
      if (!TextUtils.isEmpty(paramJSONObject.jFn)) {
        break label379;
      }
    }
    label371:
    label379:
    for (paramf = "";; paramf = paramJSONObject.jFn)
    {
      if (!paramJSONObject.error) {
        break label387;
      }
      Log.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", new Object[] { paramf });
      paramf = h("fail:".concat(String.valueOf(paramf)), null);
      AppMethodBeat.o(145718);
      return paramf;
      bool = false;
      break;
      paramf = paramJSONObject.protocol;
      break label232;
    }
    label387:
    Log.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
    paramf = n("ok", localHashMap);
    AppMethodBeat.o(145718);
    return paramf;
  }
  
  static class GetBackgroundAudioStateTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetBackgroundAudioStateTask> CREATOR;
    public String appId;
    public String coverImgUrl;
    public String dtT;
    public int dvv;
    public boolean error;
    public double iJH;
    public String iJP;
    public String jFn;
    public int jnj;
    public double lDN;
    public double lDO;
    public double lDP;
    public String lDQ;
    public String lDR;
    public String lDS;
    public String protocol;
    public String songLyric;
    public String title;
    
    static
    {
      AppMethodBeat.i(145717);
      CREATOR = new JsApiGetBackgroundAudioState.GetBackgroundAudioStateTask.1();
      AppMethodBeat.o(145717);
    }
    
    public GetBackgroundAudioStateTask()
    {
      this.appId = "";
      this.lDN = 0.0D;
      this.iJP = null;
      this.error = false;
    }
    
    public GetBackgroundAudioStateTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145713);
      this.appId = "";
      this.lDN = 0.0D;
      this.iJP = null;
      this.error = false;
      f(paramParcel);
      AppMethodBeat.o(145713);
    }
    
    public final void bjj()
    {
      double d = 0.0D;
      AppMethodBeat.i(145714);
      Object localObject = a.a.bOR().ncY;
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.appId)))
      {
        Log.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[] { localObject, this.appId });
        this.error = true;
        this.jFn = "appid not match cannot get background audio state";
        bDU();
        AppMethodBeat.o(145714);
        return;
      }
      localObject = com.tencent.mm.ay.a.bef();
      int i;
      if (localObject != null)
      {
        c localc = com.tencent.mm.ay.a.beg();
        int j = -1;
        i = -1;
        if (localc != null)
        {
          j = localc.atU;
          i = localc.mPosition;
        }
        if ((localc == null) || (j < 0) || (i < 0))
        {
          Log.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          this.error = true;
          this.jFn = "return parameter is invalid";
          bDU();
          AppMethodBeat.o(145714);
          return;
        }
        this.lDN = (j / 1000.0D);
        this.lDO = (i / 1000.0D);
        i = localc.mStatus;
        j = localc.jeP;
        if (this.lDN > 0.0D) {
          d = j * this.lDN / 100.0D;
        }
        this.lDP = d;
        if (i == 1)
        {
          i = 0;
          this.jnj = i;
          this.dtT = ((com.tencent.mm.ay.f)localObject).jfb;
          this.title = ((com.tencent.mm.ay.f)localObject).jeX;
          this.lDQ = ((com.tencent.mm.ay.f)localObject).jeZ;
          this.lDR = ((com.tencent.mm.ay.f)localObject).jeY;
          this.coverImgUrl = ((com.tencent.mm.ay.f)localObject).jfa;
          this.lDS = ((com.tencent.mm.ay.f)localObject).jfd;
          this.protocol = ((com.tencent.mm.ay.f)localObject).protocol;
          this.dvv = ((com.tencent.mm.ay.f)localObject).dvv;
          this.songLyric = ((com.tencent.mm.ay.f)localObject).jfe;
          this.iJH = ((com.tencent.mm.ay.f)localObject).iJH;
          this.iJP = ((com.tencent.mm.ay.f)localObject).iJP;
          Log.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s, playbackRate:%f, referrerPolicy: %s", new Object[] { Double.valueOf(this.lDN), Double.valueOf(this.lDO), Integer.valueOf(this.jnj), Double.valueOf(this.lDP), this.dtT, Integer.valueOf(this.dvv), this.title, this.lDR, this.lDS, this.coverImgUrl, this.protocol, Double.valueOf(this.iJH), this.iJP });
        }
      }
      for (;;)
      {
        bDU();
        AppMethodBeat.o(145714);
        return;
        i = 1;
        break;
        Log.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
        this.error = true;
        this.jFn = "currentWrapper is null";
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(145715);
      this.appId = paramParcel.readString();
      this.lDN = paramParcel.readDouble();
      this.lDO = paramParcel.readDouble();
      this.jnj = paramParcel.readInt();
      this.lDP = paramParcel.readDouble();
      this.dtT = paramParcel.readString();
      this.title = paramParcel.readString();
      this.lDQ = paramParcel.readString();
      this.lDR = paramParcel.readString();
      this.coverImgUrl = paramParcel.readString();
      this.lDS = paramParcel.readString();
      this.protocol = paramParcel.readString();
      this.songLyric = paramParcel.readString();
      this.dvv = paramParcel.readInt();
      this.iJH = paramParcel.readDouble();
      this.iJP = paramParcel.readString();
      AppMethodBeat.o(145715);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145716);
      paramParcel.writeString(this.appId);
      paramParcel.writeDouble(this.lDN);
      paramParcel.writeDouble(this.lDO);
      paramParcel.writeInt(this.jnj);
      paramParcel.writeDouble(this.lDP);
      paramParcel.writeString(this.dtT);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.lDQ);
      paramParcel.writeString(this.lDR);
      paramParcel.writeString(this.coverImgUrl);
      paramParcel.writeString(this.lDS);
      paramParcel.writeString(this.protocol);
      paramParcel.writeString(this.songLyric);
      paramParcel.writeInt(this.dvv);
      paramParcel.writeDouble(this.iJH);
      paramParcel.writeString(this.iJP);
      AppMethodBeat.o(145716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */