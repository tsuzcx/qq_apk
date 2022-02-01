package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.q.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;

class JsApiGetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetStorageTask> CREATOR;
  public String appId;
  public String key;
  public Runnable otv;
  private boolean prC;
  private int prD;
  private int prE;
  private int prF;
  public int prw;
  public String taskId;
  public String type;
  public String value;
  
  static
  {
    AppMethodBeat.i(147265);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147265);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(147261);
    if ((a)e.K(a.class) == null)
    {
      bPt();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject1 = ((a)e.K(a.class)).QF();
    if (localObject1 == null)
    {
      bPt();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject2 = ((d)localObject1).l(this.prw, this.appId, this.key);
    if ((q.a)localObject2[0] == q.a.nNn)
    {
      localObject1 = (String)localObject2[1];
      localObject2 = (String)localObject2[2];
      if (p.o(new String[] { localObject1, localObject2 }) <= 102400) {
        break label197;
      }
      this.prE = p.o(new String[] { localObject1 });
      this.prF = p.o(new String[] { localObject2 });
    }
    for (;;)
    {
      try
      {
        p.f(this.taskId, new String[] { localObject1, localObject2 });
        this.prC = true;
        bPt();
        AppMethodBeat.o(147261);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        continue;
      }
      label197:
      this.prC = false;
      this.value = localException;
      this.type = ((String)localObject2);
    }
  }
  
  public final void bsK()
  {
    AppMethodBeat.i(147262);
    if (this.prC) {}
    try
    {
      String str = p.aiG(this.taskId);
      if (str.length() == this.prE + this.prF)
      {
        this.value = str.substring(0, this.prE);
        this.type = str.substring(this.prE, this.prE + this.prF);
      }
      p.aiH(this.taskId);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        p.aiH(this.taskId);
      }
    }
    finally
    {
      p.aiH(this.taskId);
      AppMethodBeat.o(147262);
    }
    if (this.otv != null) {
      this.otv.run();
    }
    AppMethodBeat.o(147262);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(147263);
    this.appId = paramParcel.readString();
    this.prw = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.prC = bool;
      this.prD = paramParcel.readInt();
      this.prE = paramParcel.readInt();
      this.prF = paramParcel.readInt();
      this.key = paramParcel.readString();
      this.value = paramParcel.readString();
      this.type = paramParcel.readString();
      this.taskId = paramParcel.readString();
      AppMethodBeat.o(147263);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147264);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.prw);
    if (this.prC) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.prD);
      paramParcel.writeInt(this.prE);
      paramParcel.writeInt(this.prF);
      paramParcel.writeString(this.key);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.taskId);
      AppMethodBeat.o(147264);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageTask
 * JD-Core Version:    0.7.0.1
 */