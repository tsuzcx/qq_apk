package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.v.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;

class JsApiSetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiSetStorageTask> CREATOR;
  public String appId;
  private String key;
  public String result;
  public Runnable rxj;
  public int svX;
  private boolean swf;
  private int swg;
  private int swh;
  private int swi;
  private String taskId;
  private String type;
  private String value;
  
  static
  {
    AppMethodBeat.i(147296);
    CREATOR = new JsApiSetStorageTask.1();
    AppMethodBeat.o(147296);
  }
  
  JsApiSetStorageTask()
  {
    AppMethodBeat.i(326611);
    this.taskId = (Process.myPid() + String.valueOf(super.hashCode()));
    AppMethodBeat.o(326611);
  }
  
  private void cuI()
  {
    this.key = null;
    this.value = null;
    this.type = null;
  }
  
  public final void J(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(147291);
    if (q.o(new String[] { paramString1, paramString2, paramString3 }) > 102400)
    {
      this.swg = q.o(new String[] { paramString1 });
      this.swh = q.o(new String[] { paramString2 });
      this.swi = q.o(new String[] { paramString3 });
      try
      {
        q.f(this.taskId, new String[] { paramString1, paramString2, paramString3 });
        this.swf = true;
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
    this.swf = false;
    this.key = paramString1;
    this.value = paramString2;
    this.type = paramString3;
    AppMethodBeat.o(147291);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(147293);
    if (this.swf) {}
    try
    {
      str = q.abG(this.taskId);
      if (str.length() == this.swg + this.swh + this.swi)
      {
        this.key = str.substring(0, this.swg);
        this.value = str.substring(this.swg, this.swg + this.swh);
        this.type = str.substring(this.swg + this.swh, this.swg + this.swh + this.swi);
      }
      q.abH(this.taskId);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        Log.e("MicroMsg.JsApiSetStorageTask", localException.getMessage());
        q.abH(this.taskId);
      }
    }
    finally
    {
      q.abH(this.taskId);
      AppMethodBeat.o(147293);
    }
    if (e.T(a.class) == null) {}
    Object localObject2;
    for (str = null; str == null; localObject2 = ((a)e.T(a.class)).aqR())
    {
      this.result = "fail:internal error get DB fail";
      cuI();
      cpA();
      AppMethodBeat.o(147293);
      return;
    }
    try
    {
      localObject2 = ((g)localObject2).d(this.svX, this.appId, this.key, this.value, this.type);
      this.result = q.a((v.a)localObject2);
      cuI();
      cpA();
      AppMethodBeat.o(147293);
      return;
    }
    finally
    {
      AppMethodBeat.o(147293);
    }
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(147292);
    if (this.rxj != null) {
      this.rxj.run();
    }
    AppMethodBeat.o(147292);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(147294);
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
      this.result = paramParcel.readString();
      this.taskId = paramParcel.readString();
      AppMethodBeat.o(147294);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147295);
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
      paramParcel.writeString(this.result);
      paramParcel.writeString(this.taskId);
      AppMethodBeat.o(147295);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask
 * JD-Core Version:    0.7.0.1
 */