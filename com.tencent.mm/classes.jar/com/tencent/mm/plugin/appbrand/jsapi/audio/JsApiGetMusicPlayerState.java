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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetMusicPlayerState
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 46;
  public static final String NAME = "getMusicPlayerState";
  private GetMusicPlayerState kbM;
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145726);
    this.kbM = new GetMusicPlayerState(this, paramc, paramInt);
    this.kbM.mAppid = paramc.getAppId();
    AppBrandMainProcessService.a(this.kbM);
    AppMethodBeat.o(145726);
  }
  
  static class GetMusicPlayerState
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetMusicPlayerState> CREATOR;
    public int asf;
    public boolean error;
    public String imz;
    private int jOT;
    private m jXc;
    private com.tencent.mm.plugin.appbrand.jsapi.c jYG;
    public int kbN;
    public String kbO;
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
      this.jXc = paramm;
      this.jYG = paramc;
      this.jOT = paramInt;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(145721);
      Object localObject = a.a.boE().lrM;
      if ((!bs.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.mAppid)))
      {
        ac.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
        this.error = true;
        this.imz = "appid not match cannot operate";
        bet();
        AppMethodBeat.o(145721);
        return;
      }
      localObject = com.tencent.mm.ay.a.aGy();
      int j;
      int i;
      if (localObject != null)
      {
        com.tencent.mm.ay.c localc = com.tencent.mm.ay.a.aGz();
        if (localc == null) {
          break label232;
        }
        j = localc.asf;
        i = localc.mPosition;
        this.mStatus = localc.mStatus;
        this.kbN = localc.hNM;
      }
      for (;;)
      {
        this.asf = (j / 1000);
        this.mPosition = (i / 1000);
        this.kbO = ((f)localObject).hNY;
        this.imz = "";
        for (this.error = false;; this.error = false)
        {
          ac.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", new Object[] { Integer.valueOf(this.asf), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.kbN), this.kbO });
          bet();
          AppMethodBeat.o(145721);
          return;
          this.mStatus = 2;
          this.imz = "";
        }
        label232:
        i = -1;
        j = -1;
      }
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(145722);
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", Integer.valueOf(this.asf));
      localHashMap.put("currentPosition", Integer.valueOf(this.mPosition));
      localHashMap.put("status", Integer.valueOf(this.mStatus));
      localHashMap.put("downloadPercent", Integer.valueOf(this.kbN));
      localHashMap.put("dataUrl", this.kbO);
      com.tencent.mm.plugin.appbrand.jsapi.c localc = this.jYG;
      int i = this.jOT;
      m localm = this.jXc;
      StringBuilder localStringBuilder;
      if (this.error)
      {
        localStringBuilder = new StringBuilder("fail");
        if (TextUtils.isEmpty(this.imz)) {
          str = "";
        }
      }
      for (String str = str;; str = "ok")
      {
        localc.h(i, localm.k(str, localHashMap));
        AppMethodBeat.o(145722);
        return;
        str = ":" + this.imz;
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
        this.asf = paramParcel.readInt();
        this.mPosition = paramParcel.readInt();
        this.mStatus = paramParcel.readInt();
        this.kbN = paramParcel.readInt();
        this.kbO = paramParcel.readString();
        this.imz = paramParcel.readString();
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
        paramParcel.writeInt(this.asf);
        paramParcel.writeInt(this.mPosition);
        paramParcel.writeInt(this.mStatus);
        paramParcel.writeInt(this.kbN);
        paramParcel.writeString(this.kbO);
        paramParcel.writeString(this.imz);
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