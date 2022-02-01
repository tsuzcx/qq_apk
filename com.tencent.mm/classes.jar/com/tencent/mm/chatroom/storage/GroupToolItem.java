package com.tencent.mm.chatroom.storage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public class GroupToolItem
  implements Parcelable
{
  public static final Parcelable.Creator<GroupToolItem> CREATOR;
  public long coZ;
  public String path;
  public String username;
  
  static
  {
    AppMethodBeat.i(182153);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(182153);
  }
  
  public GroupToolItem()
  {
    this.username = "";
    this.path = "";
    this.coZ = 0L;
  }
  
  protected GroupToolItem(Parcel paramParcel)
  {
    AppMethodBeat.i(182152);
    this.username = "";
    this.path = "";
    this.coZ = 0L;
    this.username = paramParcel.readString();
    this.path = paramParcel.readString();
    this.coZ = paramParcel.readLong();
    AppMethodBeat.o(182152);
  }
  
  public GroupToolItem(String paramString1, String paramString2)
  {
    this.username = "";
    this.path = "";
    this.coZ = 0L;
    this.username = paramString1;
    this.path = paramString2;
  }
  
  public GroupToolItem(String paramString1, String paramString2, long paramLong)
  {
    this.username = "";
    this.path = "";
    this.coZ = 0L;
    this.username = paramString1;
    this.path = paramString2;
    this.coZ = paramLong;
  }
  
  public final boolean asn()
  {
    AppMethodBeat.i(182150);
    boolean bool = Util.isEqual(this.username, "roomaa@app.origin");
    AppMethodBeat.o(182150);
    return bool;
  }
  
  public final boolean aso()
  {
    AppMethodBeat.i(191089);
    boolean bool = Util.isEqual(this.username, "roomlive@app.origin");
    AppMethodBeat.o(191089);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(182149);
    if (paramObject == null)
    {
      AppMethodBeat.o(182149);
      return false;
    }
    if (Util.isEqual(((GroupToolItem)paramObject).username, this.username))
    {
      AppMethodBeat.o(182149);
      return true;
    }
    AppMethodBeat.o(182149);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(182148);
    String str = "GroupToolItem{username='" + this.username + '\'' + ", path='" + this.path + '\'' + ", updateTime=" + this.coZ + '}';
    AppMethodBeat.o(182148);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(182151);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.path);
    paramParcel.writeLong(this.coZ);
    AppMethodBeat.o(182151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.GroupToolItem
 * JD-Core Version:    0.7.0.1
 */