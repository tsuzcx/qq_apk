package com.tencent.mm.plugin.gamelive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appid", "", "versionType", "", "action", "param", "(Ljava/lang/String;III)V", "getAction", "()I", "setAction", "(I)V", "getAppid", "()Ljava/lang/String;", "getParam", "setParam", "getVersionType", "setVersionType", "describeContents", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-gamelive_release"})
public final class GameLiveAppbrandProcessService$EnterFinderLiveRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  int Djt;
  int action;
  final String appid;
  int cBU;
  
  static
  {
    AppMethodBeat.i(208525);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(208525);
  }
  
  public GameLiveAppbrandProcessService$EnterFinderLiveRequest(Parcel paramParcel)
  {
    this(str1, paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
    AppMethodBeat.i(208524);
    AppMethodBeat.o(208524);
  }
  
  private GameLiveAppbrandProcessService$EnterFinderLiveRequest(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(208521);
    this.appid = paramString;
    this.cBU = paramInt1;
    this.action = paramInt2;
    this.Djt = paramInt3;
    AppMethodBeat.o(208521);
  }
  
  public final Class<GameLiveAppbrandProcessService.b> bOe()
  {
    return GameLiveAppbrandProcessService.b.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208520);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.appid);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeInt(this.action);
    paramParcel.writeInt(this.Djt);
    AppMethodBeat.o(208520);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveRequest;", "plugin-gamelive_release"})
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandProcessService.EnterFinderLiveRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.GameLiveAppbrandProcessService.EnterFinderLiveRequest
 * JD-Core Version:    0.7.0.1
 */