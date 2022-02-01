package com.tencent.mm.compatible.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.m;
import java.io.Serializable;

public class PluginDescription
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<PluginDescription> CREATOR;
  public final int fFQ;
  public final String md5;
  public final String name;
  public final int size;
  public final String url;
  public final String version;
  
  static
  {
    AppMethodBeat.i(155833);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(155833);
  }
  
  protected PluginDescription(Parcel paramParcel)
  {
    AppMethodBeat.i(155831);
    this.name = ((String)m.checkNotNull(paramParcel.readString()));
    this.url = ((String)m.checkNotNull(paramParcel.readString()));
    this.md5 = ((String)m.checkNotNull(paramParcel.readString()));
    this.version = ((String)m.checkNotNull(paramParcel.readString()));
    this.size = paramParcel.readInt();
    this.fFQ = paramParcel.readInt();
    AppMethodBeat.o(155831);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(155832);
    String str = String.format("PluginDescription = [name=%s, url=%s, md5=%s, version=%s, size=%d, downloadType=%d]", new Object[] { this.name, this.url, this.md5, this.version, Integer.valueOf(this.size), Integer.valueOf(this.fFQ) });
    AppMethodBeat.o(155832);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(155830);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.version);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.fFQ);
    AppMethodBeat.o(155830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.PluginDescription
 * JD-Core Version:    0.7.0.1
 */