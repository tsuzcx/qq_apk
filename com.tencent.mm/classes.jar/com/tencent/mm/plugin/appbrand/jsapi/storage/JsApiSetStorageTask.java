package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.appstorage.b.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.y;

class JsApiSetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiSetStorageTask> CREATOR = new JsApiSetStorageTask.1();
  public String appId;
  private boolean gCc;
  private int gCd;
  private int gCe;
  private int gCf;
  public Runnable gfD;
  private String key;
  public String result;
  private String type;
  private String value;
  
  private void aka()
  {
    this.key = null;
    this.value = null;
    this.type = null;
  }
  
  public final void B(String paramString1, String paramString2, String paramString3)
  {
    if (p.k(new String[] { paramString1, paramString2, paramString3 }) > 102400)
    {
      this.gCd = p.k(new String[] { paramString1 });
      this.gCe = p.k(new String[] { paramString2 });
      this.gCf = p.k(new String[] { paramString3 });
      try
      {
        p.f(this.gep, new String[] { paramString1, paramString2, paramString3 });
        this.gCc = true;
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          y.e("MicroMsg.JsApiSetStorageTask", paramString1.getMessage());
        }
      }
    }
    this.gCc = false;
    this.key = paramString1;
    this.value = paramString2;
    this.type = paramString3;
  }
  
  public final void Zu()
  {
    if (this.gCc) {}
    try
    {
      localObject1 = p.uC(this.gep);
      if (((String)localObject1).length() == this.gCd + this.gCe + this.gCf)
      {
        this.key = ((String)localObject1).substring(0, this.gCd);
        this.value = ((String)localObject1).substring(this.gCd, this.gCd + this.gCe);
        this.type = ((String)localObject1).substring(this.gCd + this.gCe, this.gCd + this.gCe + this.gCf);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        y.e("MicroMsg.JsApiSetStorageTask", localException.getMessage());
        p.uD(this.gep);
      }
    }
    finally
    {
      p.uD(this.gep);
    }
    localObject1 = e.aaS();
    if (localObject1 == null)
    {
      this.result = "fail:internal error get DB fail";
      aka();
      ahI();
      return;
    }
    b.a locala = localObject2.f(this.appId, this.key, this.value, this.type);
    if (locala == b.a.fGp) {
      this.result = "ok";
    }
    for (;;)
    {
      aka();
      ahI();
      return;
      if (locala == b.a.fGt) {
        this.result = "fail:quota reached";
      } else {
        this.result = "fail:internal error set DB data fail";
      }
    }
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
      this.result = paramParcel.readString();
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
      paramParcel.writeString(this.result);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask
 * JD-Core Version:    0.7.0.1
 */