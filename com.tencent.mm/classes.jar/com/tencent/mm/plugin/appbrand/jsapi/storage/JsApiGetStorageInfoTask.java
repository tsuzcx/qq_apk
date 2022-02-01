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
  public Runnable kuv;
  public int limit;
  public int lmG;
  public ArrayList<String> lmL;
  public int size;
  
  static
  {
    AppMethodBeat.i(147258);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147258);
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(147254);
    if (e.K(a.class) == null) {}
    for (Object localObject1 = null; localObject1 == null; localObject1 = ((a)e.K(a.class)).El())
    {
      biG();
      AppMethodBeat.o(147254);
      return;
    }
    try
    {
      localObject1 = ((d)localObject1).V(this.lmG, this.appId);
      this.lmL = ((ArrayList)localObject1[0]);
      this.size = ((int)Math.ceil(((Integer)localObject1[1]).doubleValue() / 1000.0D));
      this.limit = ((int)Math.ceil(((Integer)localObject1[2]).doubleValue() / 1000.0D));
      biG();
      AppMethodBeat.o(147254);
      return;
    }
    finally
    {
      AppMethodBeat.o(147254);
    }
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(147255);
    if (this.kuv != null) {
      this.kuv.run();
    }
    AppMethodBeat.o(147255);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(147256);
    this.appId = paramParcel.readString();
    this.lmG = paramParcel.readInt();
    this.lmL = paramParcel.createStringArrayList();
    this.size = paramParcel.readInt();
    this.limit = paramParcel.readInt();
    AppMethodBeat.o(147256);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147257);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.lmG);
    paramParcel.writeStringList(this.lmL);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.limit);
    AppMethodBeat.o(147257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask
 * JD-Core Version:    0.7.0.1
 */