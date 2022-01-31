package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;

class JsApiSetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiSetStorageTask> CREATOR;
  public String appId;
  public Runnable hxp;
  private int iaA;
  private int iaB;
  public int ias;
  private boolean iay;
  private int iaz;
  private String key;
  public String result;
  private String type;
  private String value;
  
  static
  {
    AppMethodBeat.i(102090);
    CREATOR = new JsApiSetStorageTask.1();
    AppMethodBeat.o(102090);
  }
  
  private void aEH()
  {
    this.key = null;
    this.value = null;
    this.type = null;
  }
  
  public final void E(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(102085);
    if (p.k(new String[] { paramString1, paramString2, paramString3 }) > 102400)
    {
      this.iaz = p.k(new String[] { paramString1 });
      this.iaA = p.k(new String[] { paramString2 });
      this.iaB = p.k(new String[] { paramString3 });
      try
      {
        p.g(this.hwp, new String[] { paramString1, paramString2, paramString3 });
        this.iay = true;
        AppMethodBeat.o(102085);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ab.e("MicroMsg.JsApiSetStorageTask", paramString1.getMessage());
        }
      }
    }
    this.iay = false;
    this.key = paramString1;
    this.value = paramString2;
    this.type = paramString3;
    AppMethodBeat.o(102085);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(102087);
    if (this.iay) {}
    try
    {
      str = p.CN(this.hwp);
      if (str.length() == this.iaz + this.iaA + this.iaB)
      {
        this.key = str.substring(0, this.iaz);
        this.value = str.substring(this.iaz, this.iaz + this.iaA);
        this.type = str.substring(this.iaz + this.iaA, this.iaz + this.iaA + this.iaB);
      }
      p.CO(this.hwp);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        ab.e("MicroMsg.JsApiSetStorageTask", localException.getMessage());
        p.CO(this.hwp);
      }
    }
    finally
    {
      p.CO(this.hwp);
      AppMethodBeat.o(102087);
    }
    if (e.q(com.tencent.luggage.sdk.customize.b.class) == null) {}
    com.tencent.mm.plugin.appbrand.appstorage.b localb;
    for (str = null; str == null; localb = ((com.tencent.luggage.sdk.customize.b)e.q(com.tencent.luggage.sdk.customize.b.class)).wf())
    {
      this.result = "fail:internal error get DB fail";
      aEH();
      aBp();
      AppMethodBeat.o(102087);
      return;
    }
    this.result = p.a(localb.b(this.ias, this.appId, this.key, this.value, this.type));
    aEH();
    aBp();
    AppMethodBeat.o(102087);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(102086);
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(102086);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(102088);
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
      this.result = paramParcel.readString();
      AppMethodBeat.o(102088);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(102089);
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
      paramParcel.writeString(this.result);
      AppMethodBeat.o(102089);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask
 * JD-Core Version:    0.7.0.1
 */