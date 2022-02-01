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
  public int beL;
  public int iOo;
  public String icon;
  public String kYe;
  public String kYf;
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
    this.iOo = paramParcel.readInt();
    this.beL = paramParcel.readInt();
    this.icon = paramParcel.readString();
    this.name = paramParcel.readString();
    this.username = paramParcel.readString();
    this.kYe = paramParcel.readString();
    this.process = paramParcel.readString();
    this.kYf = paramParcel.readString();
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
    String str = "AppBrandBackgroundRunningApp{appId='" + this.appId + '\'' + ", versionType=" + this.iOo + ", usage=" + this.beL + ", icon='" + this.icon + '\'' + ", name='" + this.name + '\'' + ", username='" + this.username + '\'' + ", uiclass='" + this.kYe + '\'' + ", process='" + this.process + '\'' + ", customNotificationLogicClassName='" + this.kYf + '\'' + '}';
    AppMethodBeat.o(153203);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153207);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.iOo);
    paramParcel.writeInt(this.beL);
    paramParcel.writeString(this.icon);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.kYe);
    paramParcel.writeString(this.process);
    paramParcel.writeString(this.kYf);
    AppMethodBeat.o(153207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp
 * JD-Core Version:    0.7.0.1
 */