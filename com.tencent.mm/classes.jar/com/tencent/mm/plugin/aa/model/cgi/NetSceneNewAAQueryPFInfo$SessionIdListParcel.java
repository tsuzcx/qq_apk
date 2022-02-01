package com.tencent.mm.plugin.aa.model.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class NetSceneNewAAQueryPFInfo$SessionIdListParcel
  implements Parcelable
{
  public static final Parcelable.Creator<SessionIdListParcel> CREATOR;
  public ArrayList<String> iAG;
  public ArrayList<String> iAH;
  
  static
  {
    AppMethodBeat.i(63415);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(63415);
  }
  
  public NetSceneNewAAQueryPFInfo$SessionIdListParcel()
  {
    AppMethodBeat.i(63413);
    this.iAG = new ArrayList();
    this.iAH = new ArrayList();
    AppMethodBeat.o(63413);
  }
  
  protected NetSceneNewAAQueryPFInfo$SessionIdListParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(63414);
    this.iAG = new ArrayList();
    this.iAH = new ArrayList();
    this.iAG = paramParcel.createStringArrayList();
    this.iAH = paramParcel.createStringArrayList();
    AppMethodBeat.o(63414);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(63411);
    String str = "SessionIdListParcel{username=" + this.iAG + ", groupid=" + this.iAH + '}';
    AppMethodBeat.o(63411);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(63412);
    paramParcel.writeStringList(this.iAG);
    paramParcel.writeStringList(this.iAH);
    AppMethodBeat.o(63412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo.SessionIdListParcel
 * JD-Core Version:    0.7.0.1
 */