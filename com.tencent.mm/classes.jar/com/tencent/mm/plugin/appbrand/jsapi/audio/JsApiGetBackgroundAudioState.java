package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.c;
import com.tencent.mm.bb.f;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetBackgroundAudioState
  extends aa
{
  public static final int CTRL_INDEX = 159;
  public static final String NAME = "getBackgroundAudioState";
  
  public final String a(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145718);
    parame = parame.getAppId();
    paramJSONObject = new GetBackgroundAudioStateTask();
    paramJSONObject.appId = parame;
    if (!paramJSONObject.bPu())
    {
      Log.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
      parame = h("fail", null);
      AppMethodBeat.o(145718);
      return parame;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Double.valueOf(paramJSONObject.ozo));
    localHashMap.put("currentTime", Double.valueOf(paramJSONObject.ozp));
    boolean bool;
    if (paramJSONObject.mdj == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Double.valueOf(paramJSONObject.ozq));
      localHashMap.put("src", paramJSONObject.fmB);
      localHashMap.put("title", paramJSONObject.title);
      localHashMap.put("epname", paramJSONObject.ozr);
      localHashMap.put("singer", paramJSONObject.ozs);
      localHashMap.put("coverImgUrl", paramJSONObject.coverImgUrl);
      localHashMap.put("webUrl", paramJSONObject.ozt);
      if (paramJSONObject.protocol != null) {
        break label371;
      }
      parame = "";
      label232:
      localHashMap.put("protocol", parame);
      localHashMap.put("startTime", Integer.valueOf(paramJSONObject.fod / 1000));
      localHashMap.put("songLyric", paramJSONObject.songLyric);
      localHashMap.put("playbackRate", Double.valueOf(paramJSONObject.lzL));
      localHashMap.put("referrerPolicy", paramJSONObject.lzT);
      if (!TextUtils.isEmpty(paramJSONObject.mvQ)) {
        break label379;
      }
    }
    label371:
    label379:
    for (parame = "";; parame = paramJSONObject.mvQ)
    {
      if (!paramJSONObject.error) {
        break label387;
      }
      Log.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", new Object[] { parame });
      parame = h("fail:".concat(String.valueOf(parame)), null);
      AppMethodBeat.o(145718);
      return parame;
      bool = false;
      break;
      parame = paramJSONObject.protocol;
      break label232;
    }
    label387:
    Log.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
    parame = m("ok", localHashMap);
    AppMethodBeat.o(145718);
    return parame;
  }
  
  static class GetBackgroundAudioStateTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetBackgroundAudioStateTask> CREATOR;
    public String appId;
    public String coverImgUrl;
    public boolean error;
    public String fmB;
    public int fod;
    public double lzL;
    public String lzT;
    public int mdj;
    public String mvQ;
    public double ozo;
    public double ozp;
    public double ozq;
    public String ozr;
    public String ozs;
    public String ozt;
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
      this.ozo = 0.0D;
      this.lzT = null;
      this.error = false;
    }
    
    public GetBackgroundAudioStateTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145713);
      this.appId = "";
      this.ozo = 0.0D;
      this.lzT = null;
      this.error = false;
      f(paramParcel);
      AppMethodBeat.o(145713);
    }
    
    public final void RW()
    {
      double d = 0.0D;
      AppMethodBeat.i(145714);
      Object localObject = a.a.cbh().qdn;
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.appId)))
      {
        Log.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[] { localObject, this.appId });
        this.error = true;
        this.mvQ = "appid not match cannot get background audio state";
        bPt();
        AppMethodBeat.o(145714);
        return;
      }
      localObject = com.tencent.mm.bb.a.bnA();
      int i;
      if (localObject != null)
      {
        c localc = com.tencent.mm.bb.a.bnB();
        int j = -1;
        i = -1;
        if (localc != null)
        {
          j = localc.alM;
          i = localc.mPosition;
        }
        if ((localc == null) || (j < 0) || (i < 0))
        {
          Log.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          this.error = true;
          this.mvQ = "return parameter is invalid";
          bPt();
          AppMethodBeat.o(145714);
          return;
        }
        this.ozo = (j / 1000.0D);
        this.ozp = (i / 1000.0D);
        i = localc.mStatus;
        j = localc.lVo;
        if (this.ozo > 0.0D) {
          d = j * this.ozo / 100.0D;
        }
        this.ozq = d;
        if (i == 1)
        {
          i = 0;
          this.mdj = i;
          this.fmB = ((f)localObject).lVz;
          this.title = ((f)localObject).lVv;
          this.ozr = ((f)localObject).lVx;
          this.ozs = ((f)localObject).lVw;
          this.coverImgUrl = ((f)localObject).lVy;
          this.ozt = ((f)localObject).lVB;
          this.protocol = ((f)localObject).protocol;
          this.fod = ((f)localObject).fod;
          this.songLyric = ((f)localObject).lVC;
          this.lzL = ((f)localObject).lzL;
          this.lzT = ((f)localObject).lzT;
          Log.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s, playbackRate:%f, referrerPolicy: %s", new Object[] { Double.valueOf(this.ozo), Double.valueOf(this.ozp), Integer.valueOf(this.mdj), Double.valueOf(this.ozq), this.fmB, Integer.valueOf(this.fod), this.title, this.ozs, this.ozt, this.coverImgUrl, this.protocol, Double.valueOf(this.lzL), this.lzT });
        }
      }
      for (;;)
      {
        bPt();
        AppMethodBeat.o(145714);
        return;
        i = 1;
        break;
        Log.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
        this.error = true;
        this.mvQ = "currentWrapper is null";
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(145715);
      this.appId = paramParcel.readString();
      this.ozo = paramParcel.readDouble();
      this.ozp = paramParcel.readDouble();
      this.mdj = paramParcel.readInt();
      this.ozq = paramParcel.readDouble();
      this.fmB = paramParcel.readString();
      this.title = paramParcel.readString();
      this.ozr = paramParcel.readString();
      this.ozs = paramParcel.readString();
      this.coverImgUrl = paramParcel.readString();
      this.ozt = paramParcel.readString();
      this.protocol = paramParcel.readString();
      this.songLyric = paramParcel.readString();
      this.fod = paramParcel.readInt();
      this.lzL = paramParcel.readDouble();
      this.lzT = paramParcel.readString();
      AppMethodBeat.o(145715);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145716);
      paramParcel.writeString(this.appId);
      paramParcel.writeDouble(this.ozo);
      paramParcel.writeDouble(this.ozp);
      paramParcel.writeInt(this.mdj);
      paramParcel.writeDouble(this.ozq);
      paramParcel.writeString(this.fmB);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.ozr);
      paramParcel.writeString(this.ozs);
      paramParcel.writeString(this.coverImgUrl);
      paramParcel.writeString(this.ozt);
      paramParcel.writeString(this.protocol);
      paramParcel.writeString(this.songLyric);
      paramParcel.writeInt(this.fod);
      paramParcel.writeDouble(this.lzL);
      paramParcel.writeString(this.lzT);
      AppMethodBeat.o(145716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */