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

class JsApiGetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetStorageTask> CREATOR;
  public String appId;
  public String key;
  public Runnable krg;
  public int liU;
  private boolean lja;
  private int ljb;
  private int ljc;
  private int ljd;
  public String type;
  public String value;
  
  static
  {
    AppMethodBeat.i(147265);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147265);
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(147261);
    if ((a)e.K(a.class) == null)
    {
      bhX();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject1 = ((a)e.K(a.class)).Ei();
    if (localObject1 == null)
    {
      bhX();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject2 = ((d)localObject1).k(this.liU, this.appId, this.key);
    if ((o.a)localObject2[0] == o.a.jMT)
    {
      localObject1 = (String)localObject2[1];
      localObject2 = (String)localObject2[2];
      if (p.n(new String[] { localObject1, localObject2 }) <= 102400) {
        break label197;
      }
      this.ljc = p.n(new String[] { localObject1 });
      this.ljd = p.n(new String[] { localObject2 });
    }
    for (;;)
    {
      try
      {
        p.g(this.iFB, new String[] { localObject1, localObject2 });
        this.lja = true;
        bhX();
        AppMethodBeat.o(147261);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        continue;
      }
      label197:
      this.lja = false;
      this.value = localException;
      this.type = ((String)localObject2);
    }
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(147262);
    if (this.lja) {}
    try
    {
      String str = p.QA(this.iFB);
      if (str.length() == this.ljc + this.ljd)
      {
        this.value = str.substring(0, this.ljc);
        this.type = str.substring(this.ljc, this.ljc + this.ljd);
      }
      p.QB(this.iFB);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        p.QB(this.iFB);
      }
    }
    finally
    {
      p.QB(this.iFB);
      AppMethodBeat.o(147262);
    }
    if (this.krg != null) {
      this.krg.run();
    }
    AppMethodBeat.o(147262);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(147263);
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
      AppMethodBeat.o(147263);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147264);
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
      AppMethodBeat.o(147264);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageTask
 * JD-Core Version:    0.7.0.1
 */