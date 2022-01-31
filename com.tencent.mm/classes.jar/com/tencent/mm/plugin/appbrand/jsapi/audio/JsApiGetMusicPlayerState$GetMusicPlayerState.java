package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

class JsApiGetMusicPlayerState$GetMusicPlayerState
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetMusicPlayerState> CREATOR;
  public boolean error;
  public String hBF;
  public int hBO;
  public String hBP;
  private int hry;
  private m hxs;
  private com.tencent.mm.plugin.appbrand.jsapi.c hyO;
  public String mAppid;
  public int mDuration;
  public int mPosition;
  public int mStatus;
  
  static
  {
    AppMethodBeat.i(137743);
    CREATOR = new JsApiGetMusicPlayerState.GetMusicPlayerState.1();
    AppMethodBeat.o(137743);
  }
  
  public JsApiGetMusicPlayerState$GetMusicPlayerState(Parcel paramParcel)
  {
    AppMethodBeat.i(137738);
    this.error = false;
    f(paramParcel);
    AppMethodBeat.o(137738);
  }
  
  public JsApiGetMusicPlayerState$GetMusicPlayerState(m paramm, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    this.error = false;
    this.hxs = paramm;
    this.hyO = paramc;
    this.hry = paramInt;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(137739);
    Object localObject = a.a.aHK().ipb;
    if ((!bo.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.mAppid)))
    {
      ab.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
      this.error = true;
      this.hBF = "appid not match cannot operate";
      aBp();
      AppMethodBeat.o(137739);
      return;
    }
    localObject = com.tencent.mm.aw.a.aiz();
    int j;
    int i;
    if (localObject != null)
    {
      com.tencent.mm.aw.c localc = com.tencent.mm.aw.a.aiA();
      if (localc == null) {
        break label232;
      }
      j = localc.mDuration;
      i = localc.mPosition;
      this.mStatus = localc.mStatus;
      this.hBO = localc.fKf;
    }
    for (;;)
    {
      this.mDuration = (j / 1000);
      this.mPosition = (i / 1000);
      this.hBP = ((e)localObject).fKp;
      this.hBF = "";
      for (this.error = false;; this.error = false)
      {
        ab.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", new Object[] { Integer.valueOf(this.mDuration), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.hBO), this.hBP });
        aBp();
        AppMethodBeat.o(137739);
        return;
        this.mStatus = 2;
        this.hBF = "";
      }
      label232:
      i = -1;
      j = -1;
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(137740);
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Integer.valueOf(this.mDuration));
    localHashMap.put("currentPosition", Integer.valueOf(this.mPosition));
    localHashMap.put("status", Integer.valueOf(this.mStatus));
    localHashMap.put("downloadPercent", Integer.valueOf(this.hBO));
    localHashMap.put("dataUrl", this.hBP);
    com.tencent.mm.plugin.appbrand.jsapi.c localc = this.hyO;
    int i = this.hry;
    m localm = this.hxs;
    StringBuilder localStringBuilder;
    if (this.error)
    {
      localStringBuilder = new StringBuilder("fail");
      if (TextUtils.isEmpty(this.hBF)) {
        str = "";
      }
    }
    for (String str = str;; str = "ok")
    {
      localc.h(i, localm.j(str, localHashMap));
      AppMethodBeat.o(137740);
      return;
      str = ":" + this.hBF;
      break;
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(137741);
    this.mAppid = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.error = bool;
      this.mDuration = paramParcel.readInt();
      this.mPosition = paramParcel.readInt();
      this.mStatus = paramParcel.readInt();
      this.hBO = paramParcel.readInt();
      this.hBP = paramParcel.readString();
      this.hBF = paramParcel.readString();
      AppMethodBeat.o(137741);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137742);
    paramParcel.writeString(this.mAppid);
    if (this.error) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.mDuration);
      paramParcel.writeInt(this.mPosition);
      paramParcel.writeInt(this.mStatus);
      paramParcel.writeInt(this.hBO);
      paramParcel.writeString(this.hBP);
      paramParcel.writeString(this.hBF);
      AppMethodBeat.o(137742);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState.GetMusicPlayerState
 * JD-Core Version:    0.7.0.1
 */