package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.v.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;

class JsApiGetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetStorageTask> CREATOR;
  public String appId;
  public String key;
  public Runnable rxj;
  public int svX;
  private boolean swf;
  private int swg;
  private int swh;
  private int swi;
  public String taskId;
  public String type;
  public String value;
  
  static
  {
    AppMethodBeat.i(147265);
    CREATOR = new JsApiGetStorageTask.1();
    AppMethodBeat.o(147265);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(147261);
    if ((a)e.T(a.class) == null)
    {
      cpA();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject1 = ((a)e.T(a.class)).aqR();
    if (localObject1 == null)
    {
      cpA();
      AppMethodBeat.o(147261);
      return;
    }
    Object localObject2 = ((g)localObject1).p(this.svX, this.appId, this.key);
    if ((v.a)localObject2[0] == v.a.qNg)
    {
      localObject1 = (String)localObject2[1];
      localObject2 = (String)localObject2[2];
      if (q.o(new String[] { localObject1, localObject2 }) <= 102400) {
        break label197;
      }
      this.swh = q.o(new String[] { localObject1 });
      this.swi = q.o(new String[] { localObject2 });
    }
    for (;;)
    {
      try
      {
        q.f(this.taskId, new String[] { localObject1, localObject2 });
        this.swf = true;
        cpA();
        AppMethodBeat.o(147261);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        continue;
      }
      label197:
      this.swf = false;
      this.value = localException;
      this.type = ((String)localObject2);
    }
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(147262);
    if (this.swf) {}
    try
    {
      String str = q.abG(this.taskId);
      if (str.length() == this.swh + this.swi)
      {
        this.value = str.substring(0, this.swh);
        this.type = str.substring(this.swh, this.swh + this.swi);
      }
      q.abH(this.taskId);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiGetStorageTask", localException.getMessage());
        q.abH(this.taskId);
      }
    }
    finally
    {
      q.abH(this.taskId);
      AppMethodBeat.o(147262);
    }
    if (this.rxj != null) {
      this.rxj.run();
    }
    AppMethodBeat.o(147262);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(147263);
    this.appId = paramParcel.readString();
    this.svX = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.swf = bool;
      this.swg = paramParcel.readInt();
      this.swh = paramParcel.readInt();
      this.swi = paramParcel.readInt();
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
    paramParcel.writeInt(this.svX);
    if (this.swf) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.swg);
      paramParcel.writeInt(this.swh);
      paramParcel.writeInt(this.swi);
      paramParcel.writeString(this.key);
      paramParcel.writeString(this.value);
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.taskId);
      AppMethodBeat.o(147264);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageTask
 * JD-Core Version:    0.7.0.1
 */