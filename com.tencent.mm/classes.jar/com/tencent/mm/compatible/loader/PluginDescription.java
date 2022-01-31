package com.tencent.mm.compatible.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.n;
import java.io.Serializable;

public class PluginDescription
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<PluginDescription> CREATOR;
  public final String cqq;
  public final int erO;
  public final String name;
  public final int size;
  public final String url;
  public final String version;
  
  static
  {
    AppMethodBeat.i(93027);
    CREATOR = new PluginDescription.1();
    AppMethodBeat.o(93027);
  }
  
  protected PluginDescription(Parcel paramParcel)
  {
    AppMethodBeat.i(93025);
    this.name = ((String)n.checkNotNull(paramParcel.readString()));
    this.url = ((String)n.checkNotNull(paramParcel.readString()));
    this.cqq = ((String)n.checkNotNull(paramParcel.readString()));
    this.version = ((String)n.checkNotNull(paramParcel.readString()));
    this.size = paramParcel.readInt();
    this.erO = paramParcel.readInt();
    AppMethodBeat.o(93025);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(93026);
    String str = String.format("PluginDescription = [name=%s, url=%s, md5=%s, version=%s, size=%d, downloadType=%d]", new Object[] { this.name, this.url, this.cqq, this.version, Integer.valueOf(this.size), Integer.valueOf(this.erO) });
    AppMethodBeat.o(93026);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(93024);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.cqq);
    paramParcel.writeString(this.version);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.erO);
    AppMethodBeat.o(93024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.PluginDescription
 * JD-Core Version:    0.7.0.1
 */