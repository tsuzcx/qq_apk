package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;

public class JsApiGetStorageInfoTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetStorageInfoTask> CREATOR = new JsApiGetStorageInfoTask.1();
  public String appId;
  public ArrayList<String> gCb;
  public Runnable gfD;
  public int limit;
  public int size;
  
  public final void Zu()
  {
    Object localObject = e.aaS();
    if (localObject == null)
    {
      ahI();
      return;
    }
    localObject = ((b)localObject).rq(this.appId);
    this.gCb = ((ArrayList)localObject[0]);
    this.size = ((int)Math.ceil(((Integer)localObject[1]).doubleValue() / 1000.0D));
    this.limit = ((int)Math.ceil(((Integer)localObject[2]).doubleValue() / 1000.0D));
    ahI();
  }
  
  public final void Zv()
  {
    if (this.gfD != null) {
      this.gfD.run();
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.gCb = paramParcel.createStringArrayList();
    this.size = paramParcel.readInt();
    this.limit = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeStringList(this.gCb);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.limit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask
 * JD-Core Version:    0.7.0.1
 */