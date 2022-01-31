package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.av.c;
import com.tencent.mm.av.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

class JsApiGetMusicPlayerState$GetMusicPlayerState
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetMusicPlayerState> CREATOR = new JsApiGetMusicPlayerState.GetMusicPlayerState.1();
  public boolean error = false;
  private i gfG;
  private o gfd;
  private int gfg;
  public String gio;
  public String giu;
  public int giv;
  public String giw;
  public int mDuration;
  public int mPosition;
  public int mStatus;
  
  public JsApiGetMusicPlayerState$GetMusicPlayerState(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiGetMusicPlayerState$GetMusicPlayerState(i parami, o paramo, int paramInt)
  {
    this.gfG = parami;
    this.gfd = paramo;
    this.gfg = paramInt;
  }
  
  public final void Zu()
  {
    Object localObject = a.a.amd().gNh;
    if ((!bk.bl((String)localObject)) && (!((String)localObject).equals(this.giu)))
    {
      y.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
      this.error = true;
      this.gio = "appid not match cannot operate";
      ahI();
      return;
    }
    localObject = com.tencent.mm.av.a.Pw();
    int j;
    int i;
    if (localObject != null)
    {
      c localc = com.tencent.mm.av.a.Px();
      if (localc == null) {
        break label217;
      }
      j = localc.mDuration;
      i = localc.mPosition;
      this.mStatus = localc.mStatus;
      this.giv = localc.eut;
    }
    for (;;)
    {
      this.mDuration = (j / 1000);
      this.mPosition = (i / 1000);
      this.giw = ((e)localObject).euD;
      this.gio = "";
      for (this.error = false;; this.error = false)
      {
        y.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", new Object[] { Integer.valueOf(this.mDuration), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.giv), this.giw });
        ahI();
        return;
        this.mStatus = 2;
        this.gio = "";
      }
      label217:
      i = -1;
      j = -1;
    }
  }
  
  public final void Zv()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Integer.valueOf(this.mDuration));
    localHashMap.put("currentPosition", Integer.valueOf(this.mPosition));
    localHashMap.put("status", Integer.valueOf(this.mStatus));
    localHashMap.put("downloadPercent", Integer.valueOf(this.giv));
    localHashMap.put("dataUrl", this.giw);
    o localo = this.gfd;
    int i = this.gfg;
    i locali = this.gfG;
    StringBuilder localStringBuilder;
    if (this.error)
    {
      localStringBuilder = new StringBuilder("fail");
      if (TextUtils.isEmpty(this.gio)) {
        str = "";
      }
    }
    for (String str = str;; str = "ok")
    {
      localo.C(i, locali.h(str, localHashMap));
      return;
      str = ":" + this.gio;
      break;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.giu = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.error = bool;
      this.mDuration = paramParcel.readInt();
      this.mPosition = paramParcel.readInt();
      this.mStatus = paramParcel.readInt();
      this.giv = paramParcel.readInt();
      this.giw = paramParcel.readString();
      this.gio = paramParcel.readString();
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.giu);
    if (this.error) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.mDuration);
      paramParcel.writeInt(this.mPosition);
      paramParcel.writeInt(this.mStatus);
      paramParcel.writeInt(this.giv);
      paramParcel.writeString(this.giw);
      paramParcel.writeString(this.gio);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState.GetMusicPlayerState
 * JD-Core Version:    0.7.0.1
 */