package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public class AppBrandBackgroundRunningApp
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandBackgroundRunningApp> CREATOR;
  public String appId;
  public int beO;
  public String dDH;
  public int hQh;
  public String jRQ;
  public String jRR;
  public String name;
  public String process;
  public String username;
  
  static
  {
    AppMethodBeat.i(153208);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(153208);
  }
  
  public AppBrandBackgroundRunningApp() {}
  
  protected AppBrandBackgroundRunningApp(Parcel paramParcel)
  {
    AppMethodBeat.i(153204);
    this.appId = paramParcel.readString();
    this.hQh = paramParcel.readInt();
    this.beO = paramParcel.readInt();
    this.dDH = paramParcel.readString();
    this.name = paramParcel.readString();
    this.username = paramParcel.readString();
    this.jRQ = paramParcel.readString();
    this.process = paramParcel.readString();
    this.jRR = paramParcel.readString();
    AppMethodBeat.o(153204);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(153205);
    if (this == paramObject)
    {
      AppMethodBeat.o(153205);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(153205);
      return false;
    }
    paramObject = (AppBrandBackgroundRunningApp)paramObject;
    boolean bool = Objects.equals(this.appId, paramObject.appId);
    AppMethodBeat.o(153205);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(153206);
    int i = Objects.hash(new Object[] { this.appId });
    AppMethodBeat.o(153206);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153203);
    String str = "AppBrandBackgroundRunningApp{appId='" + this.appId + '\'' + ", versionType=" + this.hQh + ", usage=" + this.beO + ", icon='" + this.dDH + '\'' + ", name='" + this.name + '\'' + ", username='" + this.username + '\'' + ", uiclass='" + this.jRQ + '\'' + ", process='" + this.process + '\'' + ", customNotificationLogicClassName='" + this.jRR + '\'' + '}';
    AppMethodBeat.o(153203);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153207);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hQh);
    paramParcel.writeInt(this.beO);
    paramParcel.writeString(this.dDH);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.jRQ);
    paramParcel.writeString(this.process);
    paramParcel.writeString(this.jRR);
    AppMethodBeat.o(153207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp
 * JD-Core Version:    0.7.0.1
 */