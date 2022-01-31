package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;

class JsApiGetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetStorageTask> CREATOR;
  public String appId;
  public Runnable hxp;
  private int iaA;
  private int iaB;
  public int ias;
  private boolean iay;
  private int iaz;
  public String key;
  public String type;
  public String value;
  
  static
  {
    AppMethodBeat.i(102059);
    CREATOR = new JsApiGetStorageTask.1();
    AppMethodBeat.o(102059);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(102055);
    if ((com.tencent.luggage.sdk.customize.b)e.q(com.tencent.luggage.sdk.customize.b.class) == null)
    {
      aBp();
      AppMethodBeat.o(102055);
      return;
    }
    Object localObject1 = ((com.tencent.luggage.sdk.customize.b)e.q(com.tencent.luggage.sdk.customize.b.class)).wf();
    if (localObject1 == null)
    {
      aBp();
      AppMethodBeat.o(102055);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.appbrand.appstorage.b)localObject1).k(this.ias, this.appId, this.key);
    if ((m.a)localObject2[0] == m.a.gZV)
    {
      localObject1 = (String)localObject2[1];
      localObject2 = (String)localObject2[2];
      if (p.k(new String[] { localObject1, localObject2 }) <= 102400) {
        break label197;
      }
      this.iaA = p.k(new String[] { localObject1 });
      this.iaB = p.k(new String[] { localObject2 });
    }
    for (;;)
    {
      try
      {
        p.g(this.hwp, new String[] { localObject1, localObject2 });
        this.iay = true;
        aBp();
        AppMethodBeat.o(102055);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        continue;
      }
      label197:
      this.iay = false;
      this.value = localException;
      this.type = ((String)localObject2);
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(102056);
    if (this.iay) {}
    try
    {
      String str = p.CN(this.hwp);
      if (str.length() == this.iaA + this.iaB)
      {
        this.value = str.substring(0, this.iaA);
        this.type = str.substring(this.iaA, this.iaA + this.iaB);
      }
      p.CO(this.hwp);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        p.CO(this.hwp);
      }
    }
    finally
    {
      p.CO(this.hwp);
      AppMethodBeat.o(102056);
    }
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(102056);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(102057);
    this.appId = paramParcel.readString();
    this.ias = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.iay = bool;
      this.iaz = paramParcel.readInt();
      this.iaA = paramParcel.readInt();
      this.iaB = paramParcel.readInt();
      this.key = paramParcel.readString();
      this.value = paramParcel.readString();
      this.type = paramParcel.readString();
      AppMethodBeat.o(102057);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(102058);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.ias);
    if (this.iay) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.iaz);
      paramParcel.writeInt(this.iaA);
      paramParcel.writeInt(this.iaB);
      paramParcel.writeString(this.key);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.type);
      AppMethodBeat.o(102058);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageTask
 * JD-Core Version:    0.7.0.1
 */