package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;

public class JsApiGetStorageInfoTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetStorageInfoTask> CREATOR;
  public String appId;
  public int limit;
  public Runnable lyv;
  public int mtl;
  public ArrayList<String> mtq;
  public int size;
  
  static
  {
    AppMethodBeat.i(147258);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147258);
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(147254);
    if (e.M(a.class) == null) {}
    for (Object localObject1 = null; localObject1 == null; localObject1 = ((a)e.M(a.class)).NK())
    {
      bDU();
      AppMethodBeat.o(147254);
      return;
    }
    try
    {
      localObject1 = ((d)localObject1).Z(this.mtl, this.appId);
      this.mtq = ((ArrayList)localObject1[0]);
      this.size = ((int)Math.ceil(((Integer)localObject1[1]).doubleValue() / 1000.0D));
      this.limit = ((int)Math.ceil(((Integer)localObject1[2]).doubleValue() / 1000.0D));
      bDU();
      AppMethodBeat.o(147254);
      return;
    }
    finally
    {
      AppMethodBeat.o(147254);
    }
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(147255);
    if (this.lyv != null) {
      this.lyv.run();
    }
    AppMethodBeat.o(147255);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(147256);
    this.appId = paramParcel.readString();
    this.mtl = paramParcel.readInt();
    this.mtq = paramParcel.createStringArrayList();
    this.size = paramParcel.readInt();
    this.limit = paramParcel.readInt();
    AppMethodBeat.o(147256);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147257);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.mtl);
    paramParcel.writeStringList(this.mtq);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.limit);
    AppMethodBeat.o(147257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask
 * JD-Core Version:    0.7.0.1
 */