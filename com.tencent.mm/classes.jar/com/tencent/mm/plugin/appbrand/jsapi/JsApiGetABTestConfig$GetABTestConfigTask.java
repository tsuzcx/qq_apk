package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.HashMap;
import java.util.Map;

public class JsApiGetABTestConfig$GetABTestConfigTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetABTestConfigTask> CREATOR = new JsApiGetABTestConfig.GetABTestConfigTask.1();
  private i gfG;
  private String gfU;
  private Map<String, String> gfV = new HashMap();
  private o gfd;
  private int gfg;
  
  JsApiGetABTestConfig$GetABTestConfigTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  JsApiGetABTestConfig$GetABTestConfigTask(i parami, o paramo, int paramInt, String paramString)
  {
    this.gfG = parami;
    this.gfd = paramo;
    this.gfg = paramInt;
    this.gfU = paramString;
  }
  
  public final void Zu()
  {
    y.i("MicroMsg.JsApiGetABTestConfig", "runInMainProcess");
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ(this.gfU);
    if (localc.isValid()) {
      this.gfV.putAll(localc.ctr());
    }
    ahI();
  }
  
  public final void Zv()
  {
    y.i("MicroMsg.JsApiGetABTestConfig", " configs = " + this.gfV);
    HashMap localHashMap = new HashMap();
    localHashMap.put("testConfig", this.gfV);
    this.gfd.C(this.gfg, this.gfG.h("ok", localHashMap));
  }
  
  public final void e(Parcel paramParcel)
  {
    this.gfV.clear();
    this.gfV.putAll(paramParcel.readHashMap(HashMap.class.getClassLoader()));
    this.gfU = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.gfV);
    paramParcel.writeString(this.gfU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig.GetABTestConfigTask
 * JD-Core Version:    0.7.0.1
 */