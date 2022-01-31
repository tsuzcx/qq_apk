package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;

public class JsApiGetStorageInfoTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetStorageInfoTask> CREATOR;
  public String appId;
  public Runnable hxp;
  public int ias;
  public ArrayList<String> iax;
  public int limit;
  public int size;
  
  static
  {
    AppMethodBeat.i(102052);
    CREATOR = new JsApiGetStorageInfoTask.1();
    AppMethodBeat.o(102052);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(102048);
    if (e.q(com.tencent.luggage.sdk.customize.b.class) == null) {}
    for (Object localObject = null; localObject == null; localObject = ((com.tencent.luggage.sdk.customize.b)e.q(com.tencent.luggage.sdk.customize.b.class)).wf())
    {
      aBp();
      AppMethodBeat.o(102048);
      return;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.appstorage.b)localObject).J(this.ias, this.appId);
    this.iax = ((ArrayList)localObject[0]);
    this.size = ((int)Math.ceil(((Integer)localObject[1]).doubleValue() / 1000.0D));
    this.limit = ((int)Math.ceil(((Integer)localObject[2]).doubleValue() / 1000.0D));
    aBp();
    AppMethodBeat.o(102048);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(102049);
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(102049);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(102050);
    this.appId = paramParcel.readString();
    this.ias = paramParcel.readInt();
    this.iax = paramParcel.createStringArrayList();
    this.size = paramParcel.readInt();
    this.limit = paramParcel.readInt();
    AppMethodBeat.o(102050);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(102051);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.ias);
    paramParcel.writeStringList(this.iax);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.limit);
    AppMethodBeat.o(102051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask
 * JD-Core Version:    0.7.0.1
 */