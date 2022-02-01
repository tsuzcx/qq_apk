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
  public int cIi;
  public int euz;
  public String icon;
  public String mzg;
  public String name;
  public String qSb;
  public String qSc;
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
    this.euz = paramParcel.readInt();
    this.cIi = paramParcel.readInt();
    this.icon = paramParcel.readString();
    this.name = paramParcel.readString();
    this.username = paramParcel.readString();
    this.qSb = paramParcel.readString();
    this.mzg = paramParcel.readString();
    this.qSc = paramParcel.readString();
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
    String str = "AppBrandBackgroundRunningApp{appId='" + this.appId + '\'' + ", versionType=" + this.euz + ", usage=" + this.cIi + ", icon='" + this.icon + '\'' + ", name='" + this.name + '\'' + ", username='" + this.username + '\'' + ", uiclass='" + this.qSb + '\'' + ", process='" + this.mzg + '\'' + ", customNotificationLogicClassName='" + this.qSc + '\'' + '}';
    AppMethodBeat.o(153203);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153207);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.euz);
    paramParcel.writeInt(this.cIi);
    paramParcel.writeString(this.icon);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.qSb);
    paramParcel.writeString(this.mzg);
    paramParcel.writeString(this.qSc);
    AppMethodBeat.o(153207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp
 * JD-Core Version:    0.7.0.1
 */