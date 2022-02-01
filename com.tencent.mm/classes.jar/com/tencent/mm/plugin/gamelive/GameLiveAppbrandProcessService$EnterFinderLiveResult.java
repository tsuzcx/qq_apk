package com.tencent.mm.plugin.gamelive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "(I)V", "getErrCode", "()I", "describeContents", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandProcessService$EnterFinderLiveResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  final int errCode;
  
  static
  {
    AppMethodBeat.i(277214);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(277214);
  }
  
  public GameLiveAppbrandProcessService$EnterFinderLiveResult(int paramInt)
  {
    this.errCode = paramInt;
  }
  
  public GameLiveAppbrandProcessService$EnterFinderLiveResult(Parcel paramParcel)
  {
    this(paramParcel.readInt());
    AppMethodBeat.i(277207);
    AppMethodBeat.o(277207);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void readParcel(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277222);
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.errCode);
    AppMethodBeat.o(277222);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveResult;", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandProcessService.EnterFinderLiveResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.GameLiveAppbrandProcessService.EnterFinderLiveResult
 * JD-Core Version:    0.7.0.1
 */