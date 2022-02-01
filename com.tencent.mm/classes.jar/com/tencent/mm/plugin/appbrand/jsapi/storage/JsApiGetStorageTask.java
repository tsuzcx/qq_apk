package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.p.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ae;

class JsApiGetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetStorageTask> CREATOR;
  public String appId;
  public String key;
  public Runnable kuv;
  public int lmG;
  private boolean lmM;
  private int lmN;
  private int lmO;
  private int lmP;
  public String type;
  public String value;
  
  static
  {
    AppMethodBeat.i(147265);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147265);
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(147261);
    if ((a)e.K(a.class) == null)
    {
      biG();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject1 = ((a)e.K(a.class)).El();
    if (localObject1 == null)
    {
      biG();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject2 = ((d)localObject1).k(this.lmG, this.appId, this.key);
    if ((p.a)localObject2[0] == p.a.jQg)
    {
      localObject1 = (String)localObject2[1];
      localObject2 = (String)localObject2[2];
      if (p.n(new String[] { localObject1, localObject2 }) <= 102400) {
        break label197;
      }
      this.lmO = p.n(new String[] { localObject1 });
      this.lmP = p.n(new String[] { localObject2 });
    }
    for (;;)
    {
      try
      {
        p.g(this.iIu, new String[] { localObject1, localObject2 });
        this.lmM = true;
        biG();
        AppMethodBeat.o(147261);
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        continue;
      }
      label197:
      this.lmM = false;
      this.value = localException;
      this.type = ((String)localObject2);
    }
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(147262);
    if (this.lmM) {}
    try
    {
      String str = p.Rj(this.iIu);
      if (str.length() == this.lmO + this.lmP)
      {
        this.value = str.substring(0, this.lmO);
        this.type = str.substring(this.lmO, this.lmO + this.lmP);
      }
      p.Rk(this.iIu);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        p.Rk(this.iIu);
      }
    }
    finally
    {
      p.Rk(this.iIu);
      AppMethodBeat.o(147262);
    }
    if (this.kuv != null) {
      this.kuv.run();
    }
    AppMethodBeat.o(147262);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(147263);
    this.appId = paramParcel.readString();
    this.lmG = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.lmM = bool;
      this.lmN = paramParcel.readInt();
      this.lmO = paramParcel.readInt();
      this.lmP = paramParcel.readInt();
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
    paramParcel.writeInt(this.lmG);
    if (this.lmM) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.lmN);
      paramParcel.writeInt(this.lmO);
      paramParcel.writeInt(this.lmP);
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