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

class JsApiGetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetStorageTask> CREATOR;
  public String appId;
  public Runnable jWP;
  private int kMA;
  public int kMr;
  private boolean kMx;
  private int kMy;
  private int kMz;
  public String key;
  public String type;
  public String value;
  
  static
  {
    AppMethodBeat.i(147265);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147265);
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(147261);
    if ((a)e.K(a.class) == null)
    {
      bet();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject1 = ((a)e.K(a.class)).CJ();
    if (localObject1 == null)
    {
      bet();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject2 = ((d)localObject1).k(this.kMr, this.appId, this.key);
    if ((o.a)localObject2[0] == o.a.jsZ)
    {
      localObject1 = (String)localObject2[1];
      localObject2 = (String)localObject2[2];
      if (p.n(new String[] { localObject1, localObject2 }) <= 102400) {
        break label197;
      }
      this.kMz = p.n(new String[] { localObject1 });
      this.kMA = p.n(new String[] { localObject2 });
    }
    for (;;)
    {
      try
      {
        p.g(this.imk, new String[] { localObject1, localObject2 });
        this.kMx = true;
        bet();
        AppMethodBeat.o(147261);
        return;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        continue;
      }
      label197:
      this.kMx = false;
      this.value = localException;
      this.type = ((String)localObject2);
    }
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(147262);
    if (this.kMx) {}
    try
    {
      String str = p.Nd(this.imk);
      if (str.length() == this.kMz + this.kMA)
      {
        this.value = str.substring(0, this.kMz);
        this.type = str.substring(this.kMz, this.kMz + this.kMA);
      }
      p.Ne(this.imk);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        p.Ne(this.imk);
      }
    }
    finally
    {
      p.Ne(this.imk);
      AppMethodBeat.o(147262);
    }
    if (this.jWP != null) {
      this.jWP.run();
    }
    AppMethodBeat.o(147262);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(147263);
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
      AppMethodBeat.o(147263);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147264);
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
      AppMethodBeat.o(147264);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageTask
 * JD-Core Version:    0.7.0.1
 */