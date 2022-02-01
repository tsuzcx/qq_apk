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

class JsApiGetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetStorageTask> CREATOR;
  public String appId;
  public String key;
  public Runnable lyv;
  public int mtl;
  private boolean mtr;
  private int mts;
  private int mtt;
  private int mtu;
  public String type;
  public String value;
  
  static
  {
    AppMethodBeat.i(147265);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147265);
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(147261);
    if ((a)e.M(a.class) == null)
    {
      bDU();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject1 = ((a)e.M(a.class)).NK();
    if (localObject1 == null)
    {
      bDU();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject2 = ((d)localObject1).l(this.mtl, this.appId, this.key);
    if ((p.a)localObject2[0] == p.a.kSP)
    {
      localObject1 = (String)localObject2[1];
      localObject2 = (String)localObject2[2];
      if (p.p(new String[] { localObject1, localObject2 }) <= 102400) {
        break label197;
      }
      this.mtt = p.p(new String[] { localObject1 });
      this.mtu = p.p(new String[] { localObject2 });
    }
    for (;;)
    {
      try
      {
        p.g(this.jEY, new String[] { localObject1, localObject2 });
        this.mtr = true;
        bDU();
        AppMethodBeat.o(147261);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        continue;
      }
      label197:
      this.mtr = false;
      this.value = localException;
      this.type = ((String)localObject2);
    }
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(147262);
    if (this.mtr) {}
    try
    {
      String str = p.aaO(this.jEY);
      if (str.length() == this.mtt + this.mtu)
      {
        this.value = str.substring(0, this.mtt);
        this.type = str.substring(this.mtt, this.mtt + this.mtu);
      }
      p.aaP(this.jEY);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        p.aaP(this.jEY);
      }
    }
    finally
    {
      p.aaP(this.jEY);
      AppMethodBeat.o(147262);
    }
    if (this.lyv != null) {
      this.lyv.run();
    }
    AppMethodBeat.o(147262);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(147263);
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
      AppMethodBeat.o(147263);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147264);
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
      AppMethodBeat.o(147264);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageTask
 * JD-Core Version:    0.7.0.1
 */