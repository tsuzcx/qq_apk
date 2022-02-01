package com.tencent.mm.plugin.gamelive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "(I)V", "getErrCode", "()I", "describeContents", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-gamelive_release"})
public final class GameLiveAppbrandProcessService$EnterFinderLiveResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  final int errCode;
  
  static
  {
    AppMethodBeat.i(208175);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(208175);
  }
  
  public GameLiveAppbrandProcessService$EnterFinderLiveResult(int paramInt)
  {
    this.errCode = paramInt;
  }
  
  public GameLiveAppbrandProcessService$EnterFinderLiveResult(Parcel paramParcel)
  {
    this(paramParcel.readInt());
    AppMethodBeat.i(208174);
    AppMethodBeat.o(208174);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void k(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208170);
    p.k(paramParcel, "parcel");
    paramParcel.writeInt(this.errCode);
    AppMethodBeat.o(208170);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveResult;", "plugin-gamelive_release"})
  public static final class a
    implements Parcelable.Creator<GameLiveAppbrandProcessService.EnterFinderLiveResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.GameLiveAppbrandProcessService.EnterFinderLiveResult
 * JD-Core Version:    0.7.0.1
 */