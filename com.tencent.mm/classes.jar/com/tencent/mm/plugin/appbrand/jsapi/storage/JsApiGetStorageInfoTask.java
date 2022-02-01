package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;

public class JsApiGetStorageInfoTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetStorageInfoTask> CREATOR;
  public String appId;
  public int limit;
  public Runnable rxj;
  public int size;
  public int svX;
  public ArrayList<String> swe;
  
  static
  {
    AppMethodBeat.i(147258);
    CREATOR = new JsApiGetStorageInfoTask.1();
    AppMethodBeat.o(147258);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(147254);
    if (e.T(a.class) == null) {}
    for (Object localObject1 = null; localObject1 == null; localObject1 = ((a)e.T(a.class)).aqR())
    {
      cpA();
      AppMethodBeat.o(147254);
      return;
    }
    try
    {
      localObject1 = ((g)localObject1).aj(this.svX, this.appId);
      this.swe = ((ArrayList)localObject1[0]);
      this.size = ((int)Math.ceil(((Integer)localObject1[1]).doubleValue() / 1000.0D));
      this.limit = ((int)Math.ceil(((Integer)localObject1[2]).doubleValue() / 1000.0D));
      cpA();
      AppMethodBeat.o(147254);
      return;
    }
    finally
    {
      AppMethodBeat.o(147254);
    }
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(147255);
    if (this.rxj != null) {
      this.rxj.run();
    }
    AppMethodBeat.o(147255);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(147256);
    this.appId = paramParcel.readString();
    this.svX = paramParcel.readInt();
    this.swe = paramParcel.createStringArrayList();
    this.size = paramParcel.readInt();
    this.limit = paramParcel.readInt();
    AppMethodBeat.o(147256);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147257);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.svX);
    paramParcel.writeStringList(this.swe);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.limit);
    AppMethodBeat.o(147257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask
 * JD-Core Version:    0.7.0.1
 */