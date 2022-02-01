package com.tencent.mm.plugin.gamelive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appid", "", "versionType", "", "action", "param", "path", "reportInfo", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;)V", "getAction", "()I", "setAction", "(I)V", "getAppid", "()Ljava/lang/String;", "getParam", "setParam", "getPath", "setPath", "(Ljava/lang/String;)V", "getReportInfo", "setReportInfo", "getVersionType", "setVersionType", "describeContents", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandProcessService$EnterFinderLiveRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  int JcS;
  int action;
  final String appid;
  int euz;
  String mxQ;
  String path;
  
  static
  {
    AppMethodBeat.i(277241);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(277241);
  }
  
  public GameLiveAppbrandProcessService$EnterFinderLiveRequest(Parcel paramParcel)
  {
    this((String)localObject1, i, j, k, (String)localObject2, paramParcel);
    AppMethodBeat.i(277236);
    AppMethodBeat.o(277236);
  }
  
  private GameLiveAppbrandProcessService$EnterFinderLiveRequest(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(277226);
    this.appid = paramString1;
    this.euz = paramInt1;
    this.action = paramInt2;
    this.JcS = paramInt3;
    this.path = paramString2;
    this.mxQ = paramString3;
    AppMethodBeat.o(277226);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<GameLiveAppbrandProcessService.b> getTaskClass()
  {
    return GameLiveAppbrandProcessService.b.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277254);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.appid);
    paramParcel.writeInt(this.euz);
    paramParcel.writeInt(this.action);
    paramParcel.writeInt(this.JcS);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.mxQ);
    AppMethodBeat.o(277254);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveRequest;", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandProcessService.EnterFinderLiveRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.GameLiveAppbrandProcessService.EnterFinderLiveRequest
 * JD-Core Version:    0.7.0.1
 */