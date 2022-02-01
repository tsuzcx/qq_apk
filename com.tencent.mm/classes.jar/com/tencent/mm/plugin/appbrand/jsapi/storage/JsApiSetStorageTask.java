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

class JsApiSetStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiSetStorageTask> CREATOR;
  public String appId;
  private String key;
  public Runnable kuv;
  public int lmG;
  private boolean lmM;
  private int lmN;
  private int lmO;
  private int lmP;
  public String result;
  private String type;
  private String value;
  
  static
  {
    AppMethodBeat.i(147296);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147296);
  }
  
  private void bnj()
  {
    this.key = null;
    this.value = null;
    this.type = null;
  }
  
  public final void C(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(147291);
    if (p.n(new String[] { paramString1, paramString2, paramString3 }) > 102400)
    {
      this.lmN = p.n(new String[] { paramString1 });
      this.lmO = p.n(new String[] { paramString2 });
      this.lmP = p.n(new String[] { paramString3 });
      try
      {
        p.g(this.iIu, new String[] { paramString1, paramString2, paramString3 });
        this.lmM = true;
        AppMethodBeat.o(147291);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ae.e("MicroMsg.JsApiSetStorageTask", paramString1.getMessage());
        }
      }
    }
    this.lmM = false;
    this.key = paramString1;
    this.value = paramString2;
    this.type = paramString3;
    AppMethodBeat.o(147291);
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(147293);
    if (this.lmM) {}
    try
    {
      str = p.Rj(this.iIu);
      if (str.length() == this.lmN + this.lmO + this.lmP)
      {
        this.key = str.substring(0, this.lmN);
        this.value = str.substring(this.lmN, this.lmN + this.lmO);
        this.type = str.substring(this.lmN + this.lmO, this.lmN + this.lmO + this.lmP);
      }
      p.Rk(this.iIu);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        ae.e("MicroMsg.JsApiSetStorageTask", localException.getMessage());
        p.Rk(this.iIu);
      }
    }
    finally
    {
      p.Rk(this.iIu);
      AppMethodBeat.o(147293);
    }
    if (e.K(a.class) == null) {}
    Object localObject2;
    for (str = null; str == null; localObject2 = ((a)e.K(a.class)).El())
    {
      this.result = "fail:internal error get DB fail";
      bnj();
      biG();
      AppMethodBeat.o(147293);
      return;
    }
    try
    {
      localObject2 = ((d)localObject2).c(this.lmG, this.appId, this.key, this.value, this.type);
      this.result = p.a((p.a)localObject2);
      bnj();
      biG();
      AppMethodBeat.o(147293);
      return;
    }
    finally
    {
      AppMethodBeat.o(147293);
    }
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(147292);
    if (this.kuv != null) {
      this.kuv.run();
    }
    AppMethodBeat.o(147292);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(147294);
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
      this.result = paramParcel.readString();
      AppMethodBeat.o(147294);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147295);
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
      paramParcel.writeString(this.result);
      AppMethodBeat.o(147295);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask
 * JD-Core Version:    0.7.0.1
 */