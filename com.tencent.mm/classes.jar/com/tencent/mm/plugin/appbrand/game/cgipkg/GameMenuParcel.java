package com.tencent.mm.plugin.appbrand.game.cgipkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvm;

public class GameMenuParcel
  implements Parcelable
{
  public static final Parcelable.Creator<GameMenuParcel> CREATOR;
  public String appId;
  public bvm omj;
  
  static
  {
    AppMethodBeat.i(45094);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(45094);
  }
  
  public GameMenuParcel() {}
  
  private GameMenuParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(45093);
    this.appId = paramParcel.readString();
    this.omj = ((bvm)com.tencent.mm.ipcinvoker.extension.c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), paramParcel));
    AppMethodBeat.o(45093);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(45092);
    paramParcel.writeString(this.appId);
    com.tencent.mm.ipcinvoker.extension.c.a(this.omj, paramParcel);
    AppMethodBeat.o(45092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.cgipkg.GameMenuParcel
 * JD-Core Version:    0.7.0.1
 */