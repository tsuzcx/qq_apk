package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetMusicPlayerState
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  public static final int CTRL_INDEX = 46;
  public static final String NAME = "getMusicPlayerState";
  private GetMusicPlayerState rDn;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145726);
    this.rDn = new GetMusicPlayerState(this, paramf, paramInt);
    this.rDn.mAppid = paramf.getAppId();
    this.rDn.bQt();
    AppMethodBeat.o(145726);
  }
  
  static class GetMusicPlayerState
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetMusicPlayerState> CREATOR;
    public int cam;
    public boolean error;
    public String mAppid;
    public int mPosition;
    public int mStatus;
    public String ppp;
    public int rDo;
    public String rDp;
    private int ror;
    private p rzh;
    private com.tencent.mm.plugin.appbrand.jsapi.f rzi;
    
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
      h(paramParcel);
      AppMethodBeat.o(145720);
    }
    
    public GetMusicPlayerState(p paramp, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      this.error = false;
      this.rzh = paramp;
      this.rzi = paramf;
      this.ror = paramInt;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(145721);
      Object localObject = a.a.cBB().tib;
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.mAppid)))
      {
        Log.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
        this.error = true;
        this.ppp = "appid not match cannot operate";
        cpA();
        AppMethodBeat.o(145721);
        return;
      }
      localObject = com.tencent.mm.aw.a.bLn();
      int j;
      int i;
      if (localObject != null)
      {
        com.tencent.mm.aw.c localc = com.tencent.mm.aw.a.bLo();
        if (localc == null) {
          break label232;
        }
        j = localc.cam;
        i = localc.mPosition;
        this.mStatus = localc.mStatus;
        this.rDo = localc.oOq;
      }
      for (;;)
      {
        this.cam = (j / 1000);
        this.mPosition = (i / 1000);
        this.rDp = ((com.tencent.mm.aw.f)localObject).oOB;
        this.ppp = "";
        for (this.error = false;; this.error = false)
        {
          Log.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", new Object[] { Integer.valueOf(this.cam), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.rDo), this.rDp });
          cpA();
          AppMethodBeat.o(145721);
          return;
          this.mStatus = 2;
          this.ppp = "";
        }
        label232:
        i = -1;
        j = -1;
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(145722);
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", Integer.valueOf(this.cam));
      localHashMap.put("currentPosition", Integer.valueOf(this.mPosition));
      localHashMap.put("status", Integer.valueOf(this.mStatus));
      localHashMap.put("downloadPercent", Integer.valueOf(this.rDo));
      localHashMap.put("dataUrl", this.rDp);
      com.tencent.mm.plugin.appbrand.jsapi.f localf = this.rzi;
      int i = this.ror;
      p localp = this.rzh;
      StringBuilder localStringBuilder;
      if (this.error)
      {
        localStringBuilder = new StringBuilder("fail");
        if (TextUtils.isEmpty(this.ppp)) {
          str = "";
        }
      }
      for (String str = str;; str = "ok")
      {
        localf.callback(i, localp.m(str, localHashMap));
        AppMethodBeat.o(145722);
        return;
        str = ":" + this.ppp;
        break;
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(145723);
      this.mAppid = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.error = bool;
        this.cam = paramParcel.readInt();
        this.mPosition = paramParcel.readInt();
        this.mStatus = paramParcel.readInt();
        this.rDo = paramParcel.readInt();
        this.rDp = paramParcel.readString();
        this.ppp = paramParcel.readString();
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
        paramParcel.writeInt(this.cam);
        paramParcel.writeInt(this.mPosition);
        paramParcel.writeInt(this.mStatus);
        paramParcel.writeInt(this.rDo);
        paramParcel.writeString(this.rDp);
        paramParcel.writeString(this.ppp);
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