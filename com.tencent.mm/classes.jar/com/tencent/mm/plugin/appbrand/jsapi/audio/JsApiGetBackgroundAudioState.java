package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
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
    if (!paramJSONObject.cpB())
    {
      Log.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
      paramf = ZP("fail");
      AppMethodBeat.o(145718);
      return paramf;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Double.valueOf(paramJSONObject.rDh));
    localHashMap.put("currentTime", Double.valueOf(paramJSONObject.rDi));
    boolean bool;
    if (paramJSONObject.oWc == 1)
    {
      bool = true;
      localHashMap.put("paused", Boolean.valueOf(bool));
      localHashMap.put("buffered", Double.valueOf(paramJSONObject.rDj));
      localHashMap.put("src", paramJSONObject.hqM);
      localHashMap.put("title", paramJSONObject.title);
      localHashMap.put("epname", paramJSONObject.rDk);
      localHashMap.put("singer", paramJSONObject.rDl);
      localHashMap.put("coverImgUrl", paramJSONObject.coverImgUrl);
      localHashMap.put("webUrl", paramJSONObject.rDm);
      if (paramJSONObject.protocol != null) {
        break label369;
      }
      paramf = "";
      label231:
      localHashMap.put("protocol", paramf);
      localHashMap.put("startTime", Integer.valueOf(paramJSONObject.startTime / 1000));
      localHashMap.put("songLyric", paramJSONObject.songLyric);
      localHashMap.put("playbackRate", Double.valueOf(paramJSONObject.orm));
      localHashMap.put("referrerPolicy", paramJSONObject.oru);
      if (!TextUtils.isEmpty(paramJSONObject.ppp)) {
        break label377;
      }
    }
    label369:
    label377:
    for (paramf = "";; paramf = paramJSONObject.ppp)
    {
      if (!paramJSONObject.error) {
        break label385;
      }
      Log.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", new Object[] { paramf });
      paramf = ZP("fail:".concat(String.valueOf(paramf)));
      AppMethodBeat.o(145718);
      return paramf;
      bool = false;
      break;
      paramf = paramJSONObject.protocol;
      break label231;
    }
    label385:
    Log.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
    paramf = m("ok", localHashMap);
    AppMethodBeat.o(145718);
    return paramf;
  }
  
  static class GetBackgroundAudioStateTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetBackgroundAudioStateTask> CREATOR;
    public String appId;
    public String coverImgUrl;
    public boolean error;
    public String hqM;
    public int oWc;
    public double orm;
    public String oru;
    public String ppp;
    public String protocol;
    public double rDh;
    public double rDi;
    public double rDj;
    public String rDk;
    public String rDl;
    public String rDm;
    public String songLyric;
    public int startTime;
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
      this.rDh = 0.0D;
      this.oru = null;
      this.error = false;
    }
    
    public GetBackgroundAudioStateTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145713);
      this.appId = "";
      this.rDh = 0.0D;
      this.oru = null;
      this.error = false;
      h(paramParcel);
      AppMethodBeat.o(145713);
    }
    
    public final void asn()
    {
      double d = 0.0D;
      AppMethodBeat.i(145714);
      Object localObject = a.a.cBB().tib;
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.appId)))
      {
        Log.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[] { localObject, this.appId });
        this.error = true;
        this.ppp = "appid not match cannot get background audio state";
        cpA();
        AppMethodBeat.o(145714);
        return;
      }
      localObject = com.tencent.mm.aw.a.bLn();
      int i;
      if (localObject != null)
      {
        c localc = com.tencent.mm.aw.a.bLo();
        int j = -1;
        i = -1;
        if (localc != null)
        {
          j = localc.cam;
          i = localc.mPosition;
        }
        if ((localc == null) || (j < 0) || (i < 0))
        {
          Log.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          this.error = true;
          this.ppp = "return parameter is invalid";
          cpA();
          AppMethodBeat.o(145714);
          return;
        }
        this.rDh = (j / 1000.0D);
        this.rDi = (i / 1000.0D);
        i = localc.mStatus;
        j = localc.oOq;
        if (this.rDh > 0.0D) {
          d = j * this.rDh / 100.0D;
        }
        this.rDj = d;
        if (i == 1)
        {
          i = 0;
          this.oWc = i;
          this.hqM = ((com.tencent.mm.aw.f)localObject).oOB;
          this.title = ((com.tencent.mm.aw.f)localObject).oOx;
          this.rDk = ((com.tencent.mm.aw.f)localObject).oOz;
          this.rDl = ((com.tencent.mm.aw.f)localObject).oOy;
          this.coverImgUrl = ((com.tencent.mm.aw.f)localObject).oOA;
          this.rDm = ((com.tencent.mm.aw.f)localObject).oOD;
          this.protocol = ((com.tencent.mm.aw.f)localObject).protocol;
          this.startTime = ((com.tencent.mm.aw.f)localObject).startTime;
          this.songLyric = ((com.tencent.mm.aw.f)localObject).oOE;
          this.orm = ((com.tencent.mm.aw.f)localObject).orm;
          this.oru = ((com.tencent.mm.aw.f)localObject).oru;
          Log.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s, playbackRate:%f, referrerPolicy: %s", new Object[] { Double.valueOf(this.rDh), Double.valueOf(this.rDi), Integer.valueOf(this.oWc), Double.valueOf(this.rDj), this.hqM, Integer.valueOf(this.startTime), this.title, this.rDl, this.rDm, this.coverImgUrl, this.protocol, Double.valueOf(this.orm), this.oru });
        }
      }
      for (;;)
      {
        cpA();
        AppMethodBeat.o(145714);
        return;
        i = 1;
        break;
        Log.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
        this.error = true;
        this.ppp = "currentWrapper is null";
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(145715);
      this.appId = paramParcel.readString();
      this.rDh = paramParcel.readDouble();
      this.rDi = paramParcel.readDouble();
      this.oWc = paramParcel.readInt();
      this.rDj = paramParcel.readDouble();
      this.hqM = paramParcel.readString();
      this.title = paramParcel.readString();
      this.rDk = paramParcel.readString();
      this.rDl = paramParcel.readString();
      this.coverImgUrl = paramParcel.readString();
      this.rDm = paramParcel.readString();
      this.protocol = paramParcel.readString();
      this.songLyric = paramParcel.readString();
      this.startTime = paramParcel.readInt();
      this.orm = paramParcel.readDouble();
      this.oru = paramParcel.readString();
      AppMethodBeat.o(145715);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145716);
      paramParcel.writeString(this.appId);
      paramParcel.writeDouble(this.rDh);
      paramParcel.writeDouble(this.rDi);
      paramParcel.writeInt(this.oWc);
      paramParcel.writeDouble(this.rDj);
      paramParcel.writeString(this.hqM);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.rDk);
      paramParcel.writeString(this.rDl);
      paramParcel.writeString(this.coverImgUrl);
      paramParcel.writeString(this.rDm);
      paramParcel.writeString(this.protocol);
      paramParcel.writeString(this.songLyric);
      paramParcel.writeInt(this.startTime);
      paramParcel.writeDouble(this.orm);
      paramParcel.writeString(this.oru);
      AppMethodBeat.o(145716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */