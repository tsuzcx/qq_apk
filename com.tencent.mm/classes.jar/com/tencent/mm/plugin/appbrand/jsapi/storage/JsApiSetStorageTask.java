package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.o.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ad;

class JsApiSetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiSetStorageTask> CREATOR;
  public String appId;
  private String key;
  public Runnable krg;
  public int liU;
  private boolean lja;
  private int ljb;
  private int ljc;
  private int ljd;
  public String result;
  private String type;
  private String value;
  
  static
  {
    AppMethodBeat.i(147296);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147296);
  }
  
  private void bmA()
  {
    this.key = null;
    this.value = null;
    this.type = null;
  }
  
  public final void C(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(147291);
    if (p.n(new String[] { paramString1, paramString2, paramString3 }) > 102400)
    {
      this.ljb = p.n(new String[] { paramString1 });
      this.ljc = p.n(new String[] { paramString2 });
      this.ljd = p.n(new String[] { paramString3 });
      try
      {
        p.g(this.iFB, new String[] { paramString1, paramString2, paramString3 });
        this.lja = true;
        AppMethodBeat.o(147291);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ad.e("MicroMsg.JsApiSetStorageTask", paramString1.getMessage());
        }
      }
    }
    this.lja = false;
    this.key = paramString1;
    this.value = paramString2;
    this.type = paramString3;
    AppMethodBeat.o(147291);
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(147293);
    if (this.lja) {}
    try
    {
      str = p.QA(this.iFB);
      if (str.length() == this.ljb + this.ljc + this.ljd)
      {
        this.key = str.substring(0, this.ljb);
        this.value = str.substring(this.ljb, this.ljb + this.ljc);
        this.type = str.substring(this.ljb + this.ljc, this.ljb + this.ljc + this.ljd);
      }
      p.QB(this.iFB);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        ad.e("MicroMsg.JsApiSetStorageTask", localException.getMessage());
        p.QB(this.iFB);
      }
    }
    finally
    {
      p.QB(this.iFB);
      AppMethodBeat.o(147293);
    }
    if (e.K(a.class) == null) {}
    Object localObject2;
    for (str = null; str == null; localObject2 = ((a)e.K(a.class)).Ei())
    {
      this.result = "fail:internal error get DB fail";
      bmA();
      bhX();
      AppMethodBeat.o(147293);
      return;
    }
    try
    {
      localObject2 = ((d)localObject2).c(this.liU, this.appId, this.key, this.value, this.type);
      this.result = p.a((o.a)localObject2);
      bmA();
      bhX();
      AppMethodBeat.o(147293);
      return;
    }
    finally
    {
      AppMethodBeat.o(147293);
    }
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(147292);
    if (this.krg != null) {
      this.krg.run();
    }
    AppMethodBeat.o(147292);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(147294);
    this.appId = paramParcel.readString();
    this.liU = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.lja = bool;
      this.ljb = paramParcel.readInt();
      this.ljc = paramParcel.readInt();
      this.ljd = paramParcel.readInt();
      this.key = paramParcel.readString();
      this.value = paramParcel.readString();
      this.type = paramParcel.readString();
      this.result = paramParcel.readString();
      AppMethodBeat.o(147294);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147295);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.liU);
    if (this.lja) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.ljb);
      paramParcel.writeInt(this.ljc);
      paramParcel.writeInt(this.ljd);
      paramParcel.writeString(this.key);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.result);
      AppMethodBeat.o(147295);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask
 * JD-Core Version:    0.7.0.1
 */