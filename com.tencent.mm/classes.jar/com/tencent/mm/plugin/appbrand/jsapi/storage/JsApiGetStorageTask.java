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
  public Runnable jwt;
  public String key;
  public int kkZ;
  private boolean klf;
  private int klg;
  private int klh;
  private int kli;
  public String type;
  public String value;
  
  static
  {
    AppMethodBeat.i(147265);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147265);
  }
  
  public final void aEA()
  {
    AppMethodBeat.i(147262);
    if (this.klf) {}
    try
    {
      String str = p.IZ(this.hLO);
      if (str.length() == this.klh + this.kli)
      {
        this.value = str.substring(0, this.klh);
        this.type = str.substring(this.klh, this.klh + this.kli);
      }
      p.Ja(this.hLO);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        p.Ja(this.hLO);
      }
    }
    finally
    {
      p.Ja(this.hLO);
      AppMethodBeat.o(147262);
    }
    if (this.jwt != null) {
      this.jwt.run();
    }
    AppMethodBeat.o(147262);
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(147261);
    if ((a)e.K(a.class) == null)
    {
      aXw();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject1 = ((a)e.K(a.class)).Dg();
    if (localObject1 == null)
    {
      aXw();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject2 = ((d)localObject1).l(this.kkZ, this.appId, this.key);
    if ((o.a)localObject2[0] == o.a.iSO)
    {
      localObject1 = (String)localObject2[1];
      localObject2 = (String)localObject2[2];
      if (p.p(new String[] { localObject1, localObject2 }) <= 102400) {
        break label197;
      }
      this.klh = p.p(new String[] { localObject1 });
      this.kli = p.p(new String[] { localObject2 });
    }
    for (;;)
    {
      try
      {
        p.g(this.hLO, new String[] { localObject1, localObject2 });
        this.klf = true;
        aXw();
        AppMethodBeat.o(147261);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        continue;
      }
      label197:
      this.klf = false;
      this.value = localException;
      this.type = ((String)localObject2);
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(147263);
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
      AppMethodBeat.o(147263);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147264);
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
      AppMethodBeat.o(147264);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageTask
 * JD-Core Version:    0.7.0.1
 */