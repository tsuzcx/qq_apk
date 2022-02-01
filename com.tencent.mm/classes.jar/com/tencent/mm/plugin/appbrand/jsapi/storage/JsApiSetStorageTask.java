package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.q.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;

class JsApiSetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiSetStorageTask> CREATOR;
  public String appId;
  private String key;
  public Runnable otv;
  private boolean prC;
  private int prD;
  private int prE;
  private int prF;
  public int prw;
  public String result;
  private String taskId;
  private String type;
  private String value;
  
  static
  {
    AppMethodBeat.i(147296);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147296);
  }
  
  JsApiSetStorageTask()
  {
    AppMethodBeat.i(237233);
    this.taskId = (Process.myPid() + String.valueOf(super.hashCode()));
    AppMethodBeat.o(237233);
  }
  
  private void bUw()
  {
    this.key = null;
    this.value = null;
    this.type = null;
  }
  
  public final void F(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(147291);
    if (p.o(new String[] { paramString1, paramString2, paramString3 }) > 102400)
    {
      this.prD = p.o(new String[] { paramString1 });
      this.prE = p.o(new String[] { paramString2 });
      this.prF = p.o(new String[] { paramString3 });
      try
      {
        p.f(this.taskId, new String[] { paramString1, paramString2, paramString3 });
        this.prC = true;
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
    this.prC = false;
    this.key = paramString1;
    this.value = paramString2;
    this.type = paramString3;
    AppMethodBeat.o(147291);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(147293);
    if (this.prC) {}
    try
    {
      str = p.aiG(this.taskId);
      if (str.length() == this.prD + this.prE + this.prF)
      {
        this.key = str.substring(0, this.prD);
        this.value = str.substring(this.prD, this.prD + this.prE);
        this.type = str.substring(this.prD + this.prE, this.prD + this.prE + this.prF);
      }
      p.aiH(this.taskId);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        Log.e("MicroMsg.JsApiSetStorageTask", localException.getMessage());
        p.aiH(this.taskId);
      }
    }
    finally
    {
      p.aiH(this.taskId);
      AppMethodBeat.o(147293);
    }
    if (e.K(a.class) == null) {}
    Object localObject2;
    for (str = null; str == null; localObject2 = ((a)e.K(a.class)).QF())
    {
      this.result = "fail:internal error get DB fail";
      bUw();
      bPt();
      AppMethodBeat.o(147293);
      return;
    }
    try
    {
      localObject2 = ((d)localObject2).d(this.prw, this.appId, this.key, this.value, this.type);
      this.result = p.a((q.a)localObject2);
      bUw();
      bPt();
      AppMethodBeat.o(147293);
      return;
    }
    finally
    {
      AppMethodBeat.o(147293);
    }
  }
  
  public final void bsK()
  {
    AppMethodBeat.i(147292);
    if (this.otv != null) {
      this.otv.run();
    }
    AppMethodBeat.o(147292);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(147294);
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
      paramParcel.writeString(this.result);
      paramParcel.writeString(this.taskId);
      AppMethodBeat.o(147295);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask
 * JD-Core Version:    0.7.0.1
 */