package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetMusicPlayerState
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 46;
  public static final String NAME = "getMusicPlayerState";
  private GetMusicPlayerState kzA;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145726);
    this.kzA = new GetMusicPlayerState(this, paramc, paramInt);
    this.kzA.mAppid = paramc.getAppId();
    AppBrandMainProcessService.a(this.kzA);
    AppMethodBeat.o(145726);
  }
  
  static class GetMusicPlayerState
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetMusicPlayerState> CREATOR;
    public int atW;
    public boolean error;
    public String iIJ;
    private int kmu;
    private m kuO;
    private com.tencent.mm.plugin.appbrand.jsapi.c kws;
    public int kzB;
    public String kzC;
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
      e(paramParcel);
      AppMethodBeat.o(145720);
    }
    
    public GetMusicPlayerState(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      this.error = false;
      this.kuO = paramm;
      this.kws = paramc;
      this.kmu = paramInt;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(145721);
      Object localObject = a.a.bto().lVx;
      if ((!bu.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.mAppid)))
      {
        ae.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
        this.error = true;
        this.iIJ = "appid not match cannot operate";
        biG();
        AppMethodBeat.o(145721);
        return;
      }
      localObject = com.tencent.mm.ay.a.aKc();
      int j;
      int i;
      if (localObject != null)
      {
        com.tencent.mm.ay.c localc = com.tencent.mm.ay.a.aKd();
        if (localc == null) {
          break label232;
        }
        j = localc.atW;
        i = localc.mPosition;
        this.mStatus = localc.mStatus;
        this.kzB = localc.ijT;
      }
      for (;;)
      {
        this.atW = (j / 1000);
        this.mPosition = (i / 1000);
        this.kzC = ((f)localObject).ikf;
        this.iIJ = "";
        for (this.error = false;; this.error = false)
        {
          ae.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", new Object[] { Integer.valueOf(this.atW), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.kzB), this.kzC });
          biG();
          AppMethodBeat.o(145721);
          return;
          this.mStatus = 2;
          this.iIJ = "";
        }
        label232:
        i = -1;
        j = -1;
      }
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(145722);
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", Integer.valueOf(this.atW));
      localHashMap.put("currentPosition", Integer.valueOf(this.mPosition));
      localHashMap.put("status", Integer.valueOf(this.mStatus));
      localHashMap.put("downloadPercent", Integer.valueOf(this.kzB));
      localHashMap.put("dataUrl", this.kzC);
      com.tencent.mm.plugin.appbrand.jsapi.c localc = this.kws;
      int i = this.kmu;
      m localm = this.kuO;
      StringBuilder localStringBuilder;
      if (this.error)
      {
        localStringBuilder = new StringBuilder("fail");
        if (TextUtils.isEmpty(this.iIJ)) {
          str = "";
        }
      }
      for (String str = str;; str = "ok")
      {
        localc.h(i, localm.n(str, localHashMap));
        AppMethodBeat.o(145722);
        return;
        str = ":" + this.iIJ;
        break;
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(145723);
      this.mAppid = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.error = bool;
        this.atW = paramParcel.readInt();
        this.mPosition = paramParcel.readInt();
        this.mStatus = paramParcel.readInt();
        this.kzB = paramParcel.readInt();
        this.kzC = paramParcel.readString();
        this.iIJ = paramParcel.readString();
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
        paramParcel.writeInt(this.atW);
        paramParcel.writeInt(this.mPosition);
        paramParcel.writeInt(this.mStatus);
        paramParcel.writeInt(this.kzB);
        paramParcel.writeString(this.kzC);
        paramParcel.writeString(this.iIJ);
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