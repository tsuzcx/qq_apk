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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
      ae.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
      paramc = e("fail", null);
      AppMethodBeat.o(145718);
      return paramc;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Double.valueOf(paramJSONObject.kzu));
    localHashMap.put("currentTime", Double.valueOf(paramJSONObject.kzv));
    boolean bool;
    if (paramJSONObject.irW == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Double.valueOf(paramJSONObject.kzw));
      localHashMap.put("src", paramJSONObject.ddc);
      localHashMap.put("title", paramJSONObject.title);
      localHashMap.put("epname", paramJSONObject.kzx);
      localHashMap.put("singer", paramJSONObject.kzy);
      localHashMap.put("coverImgUrl", paramJSONObject.coverImgUrl);
      localHashMap.put("webUrl", paramJSONObject.kzz);
      if (paramJSONObject.protocol != null) {
        break label371;
      }
      paramc = "";
      label232:
      localHashMap.put("protocol", paramc);
      localHashMap.put("startTime", Integer.valueOf(paramJSONObject.dez / 1000));
      localHashMap.put("songLyric", paramJSONObject.songLyric);
      localHashMap.put("playbackRate", Double.valueOf(paramJSONObject.hOB));
      localHashMap.put("referrerPolicy", paramJSONObject.hOJ);
      if (!TextUtils.isEmpty(paramJSONObject.iIJ)) {
        break label379;
      }
    }
    label371:
    label379:
    for (paramc = "";; paramc = paramJSONObject.iIJ)
    {
      if (!paramJSONObject.error) {
        break label387;
      }
      ae.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", new Object[] { paramc });
      paramc = e("fail:".concat(String.valueOf(paramc)), null);
      AppMethodBeat.o(145718);
      return paramc;
      bool = false;
      break;
      paramc = paramJSONObject.protocol;
      break label232;
    }
    label387:
    ae.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
    paramc = n("ok", localHashMap);
    AppMethodBeat.o(145718);
    return paramc;
  }
  
  static class GetBackgroundAudioStateTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetBackgroundAudioStateTask> CREATOR;
    public String appId;
    public String coverImgUrl;
    public String ddc;
    public int dez;
    public boolean error;
    public double hOB;
    public String hOJ;
    public String iIJ;
    public int irW;
    public double kzu;
    public double kzv;
    public double kzw;
    public String kzx;
    public String kzy;
    public String kzz;
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
      this.kzu = 0.0D;
      this.hOJ = null;
      this.error = false;
    }
    
    public GetBackgroundAudioStateTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145713);
      this.appId = "";
      this.kzu = 0.0D;
      this.hOJ = null;
      this.error = false;
      e(paramParcel);
      AppMethodBeat.o(145713);
    }
    
    public final void aOX()
    {
      double d = 0.0D;
      AppMethodBeat.i(145714);
      Object localObject = a.a.bto().lVx;
      if ((!bu.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.appId)))
      {
        ae.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[] { localObject, this.appId });
        this.error = true;
        this.iIJ = "appid not match cannot get background audio state";
        biG();
        AppMethodBeat.o(145714);
        return;
      }
      localObject = com.tencent.mm.ay.a.aKc();
      int i;
      if (localObject != null)
      {
        com.tencent.mm.ay.c localc = com.tencent.mm.ay.a.aKd();
        int j = -1;
        i = -1;
        if (localc != null)
        {
          j = localc.atW;
          i = localc.mPosition;
        }
        if ((localc == null) || (j < 0) || (i < 0))
        {
          ae.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          this.error = true;
          this.iIJ = "return parameter is invalid";
          biG();
          AppMethodBeat.o(145714);
          return;
        }
        this.kzu = (j / 1000.0D);
        this.kzv = (i / 1000.0D);
        i = localc.mStatus;
        j = localc.ijT;
        if (this.kzu > 0.0D) {
          d = j * this.kzu / 100.0D;
        }
        this.kzw = d;
        if (i == 1)
        {
          i = 0;
          this.irW = i;
          this.ddc = ((f)localObject).ikf;
          this.title = ((f)localObject).ikb;
          this.kzx = ((f)localObject).ikd;
          this.kzy = ((f)localObject).ikc;
          this.coverImgUrl = ((f)localObject).ike;
          this.kzz = ((f)localObject).ikh;
          this.protocol = ((f)localObject).protocol;
          this.dez = ((f)localObject).dez;
          this.songLyric = ((f)localObject).iki;
          this.hOB = ((f)localObject).hOB;
          this.hOJ = ((f)localObject).hOJ;
          ae.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s, playbackRate:%f, referrerPolicy: %s", new Object[] { Double.valueOf(this.kzu), Double.valueOf(this.kzv), Integer.valueOf(this.irW), Double.valueOf(this.kzw), this.ddc, Integer.valueOf(this.dez), this.title, this.kzy, this.kzz, this.coverImgUrl, this.protocol, Double.valueOf(this.hOB), this.hOJ });
        }
      }
      for (;;)
      {
        biG();
        AppMethodBeat.o(145714);
        return;
        i = 1;
        break;
        ae.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
        this.error = true;
        this.iIJ = "currentWrapper is null";
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(145715);
      this.appId = paramParcel.readString();
      this.kzu = paramParcel.readDouble();
      this.kzv = paramParcel.readDouble();
      this.irW = paramParcel.readInt();
      this.kzw = paramParcel.readDouble();
      this.ddc = paramParcel.readString();
      this.title = paramParcel.readString();
      this.kzx = paramParcel.readString();
      this.kzy = paramParcel.readString();
      this.coverImgUrl = paramParcel.readString();
      this.kzz = paramParcel.readString();
      this.protocol = paramParcel.readString();
      this.songLyric = paramParcel.readString();
      this.dez = paramParcel.readInt();
      this.hOB = paramParcel.readDouble();
      this.hOJ = paramParcel.readString();
      AppMethodBeat.o(145715);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145716);
      paramParcel.writeString(this.appId);
      paramParcel.writeDouble(this.kzu);
      paramParcel.writeDouble(this.kzv);
      paramParcel.writeInt(this.irW);
      paramParcel.writeDouble(this.kzw);
      paramParcel.writeString(this.ddc);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.kzx);
      paramParcel.writeString(this.kzy);
      paramParcel.writeString(this.coverImgUrl);
      paramParcel.writeString(this.kzz);
      paramParcel.writeString(this.protocol);
      paramParcel.writeString(this.songLyric);
      paramParcel.writeInt(this.dez);
      paramParcel.writeDouble(this.hOB);
      paramParcel.writeString(this.hOJ);
      AppMethodBeat.o(145716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */