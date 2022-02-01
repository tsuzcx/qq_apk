package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.o.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ac;

class JsApiSetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiSetStorageTask> CREATOR;
  public String appId;
  public Runnable jWP;
  private int kMA;
  public int kMr;
  private boolean kMx;
  private int kMy;
  private int kMz;
  private String key;
  public String result;
  private String type;
  private String value;
  
  static
  {
    AppMethodBeat.i(147296);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147296);
  }
  
  private void biO()
  {
    this.key = null;
    this.value = null;
    this.type = null;
  }
  
  public final void D(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(147291);
    if (p.n(new String[] { paramString1, paramString2, paramString3 }) > 102400)
    {
      this.kMy = p.n(new String[] { paramString1 });
      this.kMz = p.n(new String[] { paramString2 });
      this.kMA = p.n(new String[] { paramString3 });
      try
      {
        p.g(this.imk, new String[] { paramString1, paramString2, paramString3 });
        this.kMx = true;
        AppMethodBeat.o(147291);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ac.e("MicroMsg.JsApiSetStorageTask", paramString1.getMessage());
        }
      }
    }
    this.kMx = false;
    this.key = paramString1;
    this.value = paramString2;
    this.type = paramString3;
    AppMethodBeat.o(147291);
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(147293);
    if (this.kMx) {}
    try
    {
      str = p.Nd(this.imk);
      if (str.length() == this.kMy + this.kMz + this.kMA)
      {
        this.key = str.substring(0, this.kMy);
        this.value = str.substring(this.kMy, this.kMy + this.kMz);
        this.type = str.substring(this.kMy + this.kMz, this.kMy + this.kMz + this.kMA);
      }
      p.Ne(this.imk);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        ac.e("MicroMsg.JsApiSetStorageTask", localException.getMessage());
        p.Ne(this.imk);
      }
    }
    finally
    {
      p.Ne(this.imk);
      AppMethodBeat.o(147293);
    }
    if (e.K(a.class) == null) {}
    Object localObject2;
    for (str = null; str == null; localObject2 = ((a)e.K(a.class)).CJ())
    {
      this.result = "fail:internal error get DB fail";
      biO();
      bet();
      AppMethodBeat.o(147293);
      return;
    }
    try
    {
      localObject2 = ((d)localObject2).c(this.kMr, this.appId, this.key, this.value, this.type);
      this.result = p.a((o.a)localObject2);
      biO();
      bet();
      AppMethodBeat.o(147293);
      return;
    }
    finally
    {
      AppMethodBeat.o(147293);
    }
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(147292);
    if (this.jWP != null) {
      this.jWP.run();
    }
    AppMethodBeat.o(147292);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(147294);
    this.appId = paramParcel.readString();
    this.kMr = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.kMx = bool;
      this.kMy = paramParcel.readInt();
      this.kMz = paramParcel.readInt();
      this.kMA = paramParcel.readInt();
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
    paramParcel.writeInt(this.kMr);
    if (this.kMx) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.kMy);
      paramParcel.writeInt(this.kMz);
      paramParcel.writeInt(this.kMA);
      paramParcel.writeString(this.key);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.result);
      AppMethodBeat.o(147295);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask
 * JD-Core Version:    0.7.0.1
 */