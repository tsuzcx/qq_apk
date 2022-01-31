package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l.c;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.as;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class JsApiOperateWXData$OperateWXDataTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<OperateWXDataTask> CREATOR;
  private static final as hDS;
  public String appId;
  public int hDA;
  public String hDB;
  public String hDC;
  public String hDD;
  public String hDE;
  public String hDF;
  public String hDG;
  public int hDH;
  int hDJ;
  public String hDT;
  public String hDU;
  public String hDV;
  public String hDW;
  public Map<String, byte[]> hDX;
  f hDu;
  h hDv;
  d hDw;
  public String hDy;
  public String hDz;
  public int hcr;
  public int hry;
  int hzB;
  public String mAppName;
  
  static
  {
    AppMethodBeat.i(130894);
    hDS = as.eu("MicroMsg.AppBrand.JsApiOperateWXData", 2);
    CREATOR = new JsApiOperateWXData.OperateWXDataTask.3();
    AppMethodBeat.o(130894);
  }
  
  public JsApiOperateWXData$OperateWXDataTask()
  {
    this.hDG = "";
    this.hDF = "";
  }
  
  public JsApiOperateWXData$OperateWXDataTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130883);
    this.hDG = "";
    this.hDF = "";
    f(paramParcel);
    AppMethodBeat.o(130883);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, JsApiOperateWXData.OperateWXDataTask.a parama)
  {
    AppMethodBeat.i(130888);
    paramString1 = new c(paramString1, paramString2, paramString3, paramInt1, paramInt2, this.hzB, new JsApiOperateWXData.OperateWXDataTask.4(this, parama, paramInt2, paramString2));
    paramString1.oU(this.hDJ);
    g.Rc().a(paramString1, 0);
    AppMethodBeat.o(130888);
  }
  
  static void aBY() {}
  
  public final void ata()
  {
    AppMethodBeat.i(130884);
    JsApiOperateWXData.OperateWXDataTask.1 local1 = new JsApiOperateWXData.OperateWXDataTask.1(this);
    if (this.hDy.equals("operateWXData"))
    {
      a(this.appId, this.hDT, "", this.hcr, this.hDA, local1);
      AppMethodBeat.o(130884);
      return;
    }
    if (this.hDy.equals("operateWXDataConfirm")) {
      a(this.appId, this.hDT, this.hDW, this.hcr, this.hDA, local1);
    }
    AppMethodBeat.o(130884);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130885);
    aBk();
    if (!this.hDv.isRunning())
    {
      this.hDw.aBV();
      AppMethodBeat.o(130885);
      return;
    }
    Object localObject2;
    Object localObject1;
    if (this.hDz.equals("ok"))
    {
      localObject2 = new HashMap();
      String str = this.hDU;
      localObject1 = str;
      if (!TextUtils.isEmpty(this.hDV)) {
        localObject1 = str;
      }
      try
      {
        str = hDS.getString(this.hDV, "");
        localObject1 = str;
        hDS.remove(this.hDV);
        localObject1 = str;
        JsApiOperateWXData.hz(2L);
        localObject1 = str;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ab.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInClientProcess loginResult ok, get data from XProcessStore failed, appId[%s], callbackId[%d], e=%s", new Object[] { this.appId, Integer.valueOf(this.hry), localThrowable });
          JsApiOperateWXData.hz(3L);
        }
      }
      ((Map)localObject2).put("data", localObject1);
      this.hDv.h(this.hry, this.hDu.j("ok", (Map)localObject2));
      this.hDw.aBV();
      AppMethodBeat.o(130885);
      return;
    }
    if (this.hDz.contains("fail"))
    {
      this.hDu.b(this.hDv, this.hry, this.hDz);
      this.hDw.aBV();
      AppMethodBeat.o(130885);
      return;
    }
    if (this.hDz.equals("needConfirm"))
    {
      localObject1 = new LinkedList();
      int i = 0;
      while (i < this.hDH)
      {
        byte[] arrayOfByte = (byte[])this.hDX.get(String.valueOf(i));
        localObject2 = new bwv();
        try
        {
          ((bwv)localObject2).parseFrom(arrayOfByte);
          ((LinkedList)localObject1).add(localObject2);
          i += 1;
        }
        catch (IOException localIOException)
        {
          ab.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { localIOException.getMessage() });
          ab.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", localIOException, "", new Object[0]);
          this.hDu.b(this.hDv, this.hry, "fail");
          this.hDw.aBV();
          AppMethodBeat.o(130885);
          return;
        }
      }
      if (localIOException.size() > 0)
      {
        al.d(new JsApiOperateWXData.OperateWXDataTask.2(this, localIOException));
        AppMethodBeat.o(130885);
        return;
      }
      this.hDu.b(this.hDv, this.hry, "fail");
      this.hDw.aBV();
    }
    AppMethodBeat.o(130885);
  }
  
  public final void dY(boolean paramBoolean)
  {
    AppMethodBeat.i(143379);
    super.dY(paramBoolean);
    if (paramBoolean) {}
    for (long l = 4L;; l = 5L)
    {
      JsApiOperateWXData.hz(l);
      AppMethodBeat.o(143379);
      return;
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130886);
    this.appId = paramParcel.readString();
    this.hDz = paramParcel.readString();
    this.mAppName = paramParcel.readString();
    this.hDB = paramParcel.readString();
    this.hDT = paramParcel.readString();
    this.hDU = paramParcel.readString();
    this.hDV = paramParcel.readString();
    this.hry = paramParcel.readInt();
    this.hDy = paramParcel.readString();
    this.hDW = paramParcel.readString();
    this.hDH = paramParcel.readInt();
    this.hDX = paramParcel.readHashMap(HashMap.class.getClassLoader());
    this.hcr = paramParcel.readInt();
    this.hDA = paramParcel.readInt();
    this.hzB = paramParcel.readInt();
    this.hDJ = paramParcel.readInt();
    this.hDG = paramParcel.readString();
    this.hDF = paramParcel.readString();
    this.hDE = paramParcel.readString();
    this.hDD = paramParcel.readString();
    this.hDC = paramParcel.readString();
    AppMethodBeat.o(130886);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130887);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hDz);
    paramParcel.writeString(this.mAppName);
    paramParcel.writeString(this.hDB);
    paramParcel.writeString(this.hDT);
    paramParcel.writeString(this.hDU);
    paramParcel.writeString(this.hDV);
    paramParcel.writeInt(this.hry);
    paramParcel.writeString(this.hDy);
    paramParcel.writeString(this.hDW);
    paramParcel.writeInt(this.hDH);
    paramParcel.writeMap(this.hDX);
    paramParcel.writeInt(this.hcr);
    paramParcel.writeInt(this.hDA);
    paramParcel.writeInt(this.hzB);
    paramParcel.writeInt(this.hDJ);
    paramParcel.writeString(this.hDG);
    paramParcel.writeString(this.hDF);
    paramParcel.writeString(this.hDE);
    paramParcel.writeString(this.hDD);
    paramParcel.writeString(this.hDC);
    AppMethodBeat.o(130887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask
 * JD-Core Version:    0.7.0.1
 */