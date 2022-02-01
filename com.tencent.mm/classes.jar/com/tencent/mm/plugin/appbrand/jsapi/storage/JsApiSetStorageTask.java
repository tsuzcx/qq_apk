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
  public Runnable jwt;
  private String key;
  public int kkZ;
  private boolean klf;
  private int klg;
  private int klh;
  private int kli;
  public String result;
  private String type;
  private String value;
  
  static
  {
    AppMethodBeat.i(147296);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147296);
  }
  
  private void bbT()
  {
    this.key = null;
    this.value = null;
    this.type = null;
  }
  
  public final void D(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(147291);
    if (p.p(new String[] { paramString1, paramString2, paramString3 }) > 102400)
    {
      this.klg = p.p(new String[] { paramString1 });
      this.klh = p.p(new String[] { paramString2 });
      this.kli = p.p(new String[] { paramString3 });
      try
      {
        p.g(this.hLO, new String[] { paramString1, paramString2, paramString3 });
        this.klf = true;
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
    this.klf = false;
    this.key = paramString1;
    this.value = paramString2;
    this.type = paramString3;
    AppMethodBeat.o(147291);
  }
  
  public final void aEA()
  {
    AppMethodBeat.i(147292);
    if (this.jwt != null) {
      this.jwt.run();
    }
    AppMethodBeat.o(147292);
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(147293);
    if (this.klf) {}
    try
    {
      str = p.IZ(this.hLO);
      if (str.length() == this.klg + this.klh + this.kli)
      {
        this.key = str.substring(0, this.klg);
        this.value = str.substring(this.klg, this.klg + this.klh);
        this.type = str.substring(this.klg + this.klh, this.klg + this.klh + this.kli);
      }
      p.Ja(this.hLO);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        ad.e("MicroMsg.JsApiSetStorageTask", localException.getMessage());
        p.Ja(this.hLO);
      }
    }
    finally
    {
      p.Ja(this.hLO);
      AppMethodBeat.o(147293);
    }
    if (e.K(a.class) == null) {}
    Object localObject2;
    for (str = null; str == null; localObject2 = ((a)e.K(a.class)).Dg())
    {
      this.result = "fail:internal error get DB fail";
      bbT();
      aXw();
      AppMethodBeat.o(147293);
      return;
    }
    try
    {
      localObject2 = ((d)localObject2).c(this.kkZ, this.appId, this.key, this.value, this.type);
      this.result = p.a((o.a)localObject2);
      bbT();
      aXw();
      AppMethodBeat.o(147293);
      return;
    }
    finally
    {
      AppMethodBeat.o(147293);
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(147294);
    this.appId = paramParcel.readString();
    this.kkZ = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.klf = bool;
      this.klg = paramParcel.readInt();
      this.klh = paramParcel.readInt();
      this.kli = paramParcel.readInt();
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
    paramParcel.writeInt(this.kkZ);
    if (this.klf) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.klg);
      paramParcel.writeInt(this.klh);
      paramParcel.writeInt(this.kli);
      paramParcel.writeString(this.key);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.result);
      AppMethodBeat.o(147295);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask
 * JD-Core Version:    0.7.0.1
 */