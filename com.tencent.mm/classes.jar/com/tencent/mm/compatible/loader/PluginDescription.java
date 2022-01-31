package com.tencent.mm.compatible.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.n;
import java.io.Serializable;

public class PluginDescription
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<PluginDescription> CREATOR = new PluginDescription.1();
  public final String bIW;
  public final int dyZ;
  public final String name;
  public final int size;
  public final String url;
  public final String version;
  
  protected PluginDescription(Parcel paramParcel)
  {
    this.name = ((String)n.E(paramParcel.readString()));
    this.url = ((String)n.E(paramParcel.readString()));
    this.bIW = ((String)n.E(paramParcel.readString()));
    this.version = ((String)n.E(paramParcel.readString()));
    this.size = paramParcel.readInt();
    this.dyZ = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("PluginDescription = [name=%s, url=%s, md5=%s, version=%s, size=%d, downloadType=%d]", new Object[] { this.name, this.url, this.bIW, this.version, Integer.valueOf(this.size), Integer.valueOf(this.dyZ) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.bIW);
    paramParcel.writeString(this.version);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.dyZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.PluginDescription
 * JD-Core Version:    0.7.0.1
 */