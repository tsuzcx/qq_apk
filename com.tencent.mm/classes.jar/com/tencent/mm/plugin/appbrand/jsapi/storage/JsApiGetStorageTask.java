package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.appstorage.b.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.y;

class JsApiGetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetStorageTask> CREATOR = new JsApiGetStorageTask.1();
  public String appId;
  private boolean gCc;
  private int gCd;
  private int gCe;
  private int gCf;
  public Runnable gfD;
  public String key;
  public String type;
  public String value;
  
  public final void Zu()
  {
    Object localObject1 = e.aaS();
    if (localObject1 == null)
    {
      ahI();
      return;
    }
    Object localObject2 = ((b)localObject1).aZ(this.appId, this.key);
    if ((b.a)localObject2[0] == b.a.fGp)
    {
      localObject1 = (String)localObject2[1];
      localObject2 = (String)localObject2[2];
      if (p.k(new String[] { localObject1, localObject2 }) <= 102400) {
        break label146;
      }
      this.gCe = p.k(new String[] { localObject1 });
      this.gCf = p.k(new String[] { localObject2 });
    }
    for (;;)
    {
      try
      {
        p.f(this.gep, new String[] { localObject1, localObject2 });
        this.gCc = true;
        ahI();
        return;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        continue;
      }
      label146:
      this.gCc = false;
      this.value = localException;
      this.type = ((String)localObject2);
    }
  }
  
  public final void Zv()
  {
    if (this.gCc) {}
    try
    {
      String str = p.uC(this.gep);
      if (str.length() == this.gCe + this.gCf)
      {
        this.value = str.substring(0, this.gCe);
        this.type = str.substring(this.gCe, this.gCe + this.gCf);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        p.uD(this.gep);
      }
    }
    finally
    {
      p.uD(this.gep);
    }
    if (this.gfD != null) {
      this.gfD.run();
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.gCc = bool;
      this.gCd = paramParcel.readInt();
      this.gCe = paramParcel.readInt();
      this.gCf = paramParcel.readInt();
      this.key = paramParcel.readString();
      this.value = paramParcel.readString();
      this.type = paramParcel.readString();
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    if (this.gCc) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.gCd);
      paramParcel.writeInt(this.gCe);
      paramParcel.writeInt(this.gCf);
      paramParcel.writeString(this.key);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.type);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageTask
 * JD-Core Version:    0.7.0.1
 */