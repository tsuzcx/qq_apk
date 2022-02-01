package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.p.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;

class JsApiSetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiSetStorageTask> CREATOR;
  public String appId;
  private String key;
  public Runnable lyv;
  public int mtl;
  private boolean mtr;
  private int mts;
  private int mtt;
  private int mtu;
  public String result;
  private String type;
  private String value;
  
  static
  {
    AppMethodBeat.i(147296);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147296);
  }
  
  private void bIN()
  {
    this.key = null;
    this.value = null;
    this.type = null;
  }
  
  public final void E(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(147291);
    if (p.p(new String[] { paramString1, paramString2, paramString3 }) > 102400)
    {
      this.mts = p.p(new String[] { paramString1 });
      this.mtt = p.p(new String[] { paramString2 });
      this.mtu = p.p(new String[] { paramString3 });
      try
      {
        p.g(this.jEY, new String[] { paramString1, paramString2, paramString3 });
        this.mtr = true;
        AppMethodBeat.o(147291);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          Log.e("MicroMsg.JsApiSetStorageTask", paramString1.getMessage());
        }
      }
    }
    this.mtr = false;
    this.key = paramString1;
    this.value = paramString2;
    this.type = paramString3;
    AppMethodBeat.o(147291);
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(147293);
    if (this.mtr) {}
    try
    {
      str = p.aaO(this.jEY);
      if (str.length() == this.mts + this.mtt + this.mtu)
      {
        this.key = str.substring(0, this.mts);
        this.value = str.substring(this.mts, this.mts + this.mtt);
        this.type = str.substring(this.mts + this.mtt, this.mts + this.mtt + this.mtu);
      }
      p.aaP(this.jEY);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        Log.e("MicroMsg.JsApiSetStorageTask", localException.getMessage());
        p.aaP(this.jEY);
      }
    }
    finally
    {
      p.aaP(this.jEY);
      AppMethodBeat.o(147293);
    }
    if (e.M(a.class) == null) {}
    Object localObject2;
    for (str = null; str == null; localObject2 = ((a)e.M(a.class)).NK())
    {
      this.result = "fail:internal error get DB fail";
      bIN();
      bDU();
      AppMethodBeat.o(147293);
      return;
    }
    try
    {
      localObject2 = ((d)localObject2).c(this.mtl, this.appId, this.key, this.value, this.type);
      this.result = p.a((p.a)localObject2);
      bIN();
      bDU();
      AppMethodBeat.o(147293);
      return;
    }
    finally
    {
      AppMethodBeat.o(147293);
    }
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(147292);
    if (this.lyv != null) {
      this.lyv.run();
    }
    AppMethodBeat.o(147292);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(147294);
    this.appId = paramParcel.readString();
    this.mtl = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mtr = bool;
      this.mts = paramParcel.readInt();
      this.mtt = paramParcel.readInt();
      this.mtu = paramParcel.readInt();
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
    paramParcel.writeInt(this.mtl);
    if (this.mtr) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.mts);
      paramParcel.writeInt(this.mtt);
      paramParcel.writeInt(this.mtu);
      paramParcel.writeString(this.key);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.result);
      AppMethodBeat.o(147295);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask
 * JD-Core Version:    0.7.0.1
 */