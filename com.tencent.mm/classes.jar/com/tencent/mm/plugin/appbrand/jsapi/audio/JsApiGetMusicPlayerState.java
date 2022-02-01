package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetMusicPlayerState
  extends d<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  public static final int CTRL_INDEX = 46;
  public static final String NAME = "getMusicPlayerState";
  private GetMusicPlayerState lDT;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145726);
    this.lDT = new GetMusicPlayerState(this, paramf, paramInt);
    this.lDT.mAppid = paramf.getAppId();
    AppBrandMainProcessService.a(this.lDT);
    AppMethodBeat.o(145726);
  }
  
  static class GetMusicPlayerState
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetMusicPlayerState> CREATOR;
    public int atU;
    public boolean error;
    public String jFn;
    private p lAw;
    private com.tencent.mm.plugin.appbrand.jsapi.f lAx;
    public int lDU;
    public String lDV;
    private int lqe;
    public String mAppid;
    public int mPosition;
    public int mStatus;
    
    static
    {
      AppMethodBeat.i(145725);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145725);
    }
    
    public GetMusicPlayerState(Parcel paramParcel)
    {
      AppMethodBeat.i(145720);
      this.error = false;
      f(paramParcel);
      AppMethodBeat.o(145720);
    }
    
    public GetMusicPlayerState(p paramp, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      this.error = false;
      this.lAw = paramp;
      this.lAx = paramf;
      this.lqe = paramInt;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(145721);
      Object localObject = a.a.bOR().ncY;
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.mAppid)))
      {
        Log.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
        this.error = true;
        this.jFn = "appid not match cannot operate";
        bDU();
        AppMethodBeat.o(145721);
        return;
      }
      localObject = com.tencent.mm.ay.a.bef();
      int j;
      int i;
      if (localObject != null)
      {
        c localc = com.tencent.mm.ay.a.beg();
        if (localc == null) {
          break label232;
        }
        j = localc.atU;
        i = localc.mPosition;
        this.mStatus = localc.mStatus;
        this.lDU = localc.jeP;
      }
      for (;;)
      {
        this.atU = (j / 1000);
        this.mPosition = (i / 1000);
        this.lDV = ((com.tencent.mm.ay.f)localObject).jfb;
        this.jFn = "";
        for (this.error = false;; this.error = false)
        {
          Log.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", new Object[] { Integer.valueOf(this.atU), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.lDU), this.lDV });
          bDU();
          AppMethodBeat.o(145721);
          return;
          this.mStatus = 2;
          this.jFn = "";
        }
        label232:
        i = -1;
        j = -1;
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(145722);
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", Integer.valueOf(this.atU));
      localHashMap.put("currentPosition", Integer.valueOf(this.mPosition));
      localHashMap.put("status", Integer.valueOf(this.mStatus));
      localHashMap.put("downloadPercent", Integer.valueOf(this.lDU));
      localHashMap.put("dataUrl", this.lDV);
      com.tencent.mm.plugin.appbrand.jsapi.f localf = this.lAx;
      int i = this.lqe;
      p localp = this.lAw;
      StringBuilder localStringBuilder;
      if (this.error)
      {
        localStringBuilder = new StringBuilder("fail");
        if (TextUtils.isEmpty(this.jFn)) {
          str = "";
        }
      }
      for (String str = str;; str = "ok")
      {
        localf.i(i, localp.n(str, localHashMap));
        AppMethodBeat.o(145722);
        return;
        str = ":" + this.jFn;
        break;
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(145723);
      this.mAppid = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.error = bool;
        this.atU = paramParcel.readInt();
        this.mPosition = paramParcel.readInt();
        this.mStatus = paramParcel.readInt();
        this.lDU = paramParcel.readInt();
        this.lDV = paramParcel.readString();
        this.jFn = paramParcel.readString();
        AppMethodBeat.o(145723);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145724);
      paramParcel.writeString(this.mAppid);
      if (this.error) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.atU);
        paramParcel.writeInt(this.mPosition);
        paramParcel.writeInt(this.mStatus);
        paramParcel.writeInt(this.lDU);
        paramParcel.writeString(this.lDV);
        paramParcel.writeString(this.jFn);
        AppMethodBeat.o(145724);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState
 * JD-Core Version:    0.7.0.1
 */