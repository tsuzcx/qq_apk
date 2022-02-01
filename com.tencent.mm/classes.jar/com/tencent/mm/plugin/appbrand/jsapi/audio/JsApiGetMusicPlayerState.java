package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetMusicPlayerState
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  public static final int CTRL_INDEX = 46;
  public static final String NAME = "getMusicPlayerState";
  private GetMusicPlayerState ozu;
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145726);
    this.ozu = new GetMusicPlayerState(this, parame, paramInt);
    this.ozu.mAppid = parame.getAppId();
    this.ozu.bsM();
    AppMethodBeat.o(145726);
  }
  
  static class GetMusicPlayerState
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetMusicPlayerState> CREATOR;
    public int alM;
    public boolean error;
    public String mAppid;
    public int mPosition;
    public int mStatus;
    public String mvQ;
    private int okO;
    private o ovN;
    private e ovO;
    public int ozv;
    public String ozw;
    
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
    
    public GetMusicPlayerState(o paramo, e parame, int paramInt)
    {
      this.error = false;
      this.ovN = paramo;
      this.ovO = parame;
      this.okO = paramInt;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(145721);
      Object localObject = a.a.cbh().qdn;
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.mAppid)))
      {
        Log.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
        this.error = true;
        this.mvQ = "appid not match cannot operate";
        bPt();
        AppMethodBeat.o(145721);
        return;
      }
      localObject = com.tencent.mm.bb.a.bnA();
      int j;
      int i;
      if (localObject != null)
      {
        com.tencent.mm.bb.c localc = com.tencent.mm.bb.a.bnB();
        if (localc == null) {
          break label232;
        }
        j = localc.alM;
        i = localc.mPosition;
        this.mStatus = localc.mStatus;
        this.ozv = localc.lVo;
      }
      for (;;)
      {
        this.alM = (j / 1000);
        this.mPosition = (i / 1000);
        this.ozw = ((f)localObject).lVz;
        this.mvQ = "";
        for (this.error = false;; this.error = false)
        {
          Log.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", new Object[] { Integer.valueOf(this.alM), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.ozv), this.ozw });
          bPt();
          AppMethodBeat.o(145721);
          return;
          this.mStatus = 2;
          this.mvQ = "";
        }
        label232:
        i = -1;
        j = -1;
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(145722);
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", Integer.valueOf(this.alM));
      localHashMap.put("currentPosition", Integer.valueOf(this.mPosition));
      localHashMap.put("status", Integer.valueOf(this.mStatus));
      localHashMap.put("downloadPercent", Integer.valueOf(this.ozv));
      localHashMap.put("dataUrl", this.ozw);
      e locale = this.ovO;
      int i = this.okO;
      o localo = this.ovN;
      StringBuilder localStringBuilder;
      if (this.error)
      {
        localStringBuilder = new StringBuilder("fail");
        if (TextUtils.isEmpty(this.mvQ)) {
          str = "";
        }
      }
      for (String str = str;; str = "ok")
      {
        locale.j(i, localo.m(str, localHashMap));
        AppMethodBeat.o(145722);
        return;
        str = ":" + this.mvQ;
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
        this.alM = paramParcel.readInt();
        this.mPosition = paramParcel.readInt();
        this.mStatus = paramParcel.readInt();
        this.ozv = paramParcel.readInt();
        this.ozw = paramParcel.readString();
        this.mvQ = paramParcel.readString();
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
        paramParcel.writeInt(this.alM);
        paramParcel.writeInt(this.mPosition);
        paramParcel.writeInt(this.mStatus);
        paramParcel.writeInt(this.ozv);
        paramParcel.writeString(this.ozw);
        paramParcel.writeString(this.mvQ);
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