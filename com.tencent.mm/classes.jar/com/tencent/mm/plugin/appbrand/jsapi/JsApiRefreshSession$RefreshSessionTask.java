package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.aya;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public class JsApiRefreshSession$RefreshSessionTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<RefreshSessionTask> CREATOR;
  String appId;
  private String errorMsg;
  private int hcr;
  int hry;
  m hrz;
  c hyO;
  private int hzA;
  int hzB;
  private int hzy;
  private int hzz;
  
  static
  {
    AppMethodBeat.i(130552);
    CREATOR = new JsApiRefreshSession.RefreshSessionTask.2();
    AppMethodBeat.o(130552);
  }
  
  public JsApiRefreshSession$RefreshSessionTask() {}
  
  public JsApiRefreshSession$RefreshSessionTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130543);
    f(paramParcel);
    AppMethodBeat.o(130543);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130544);
    aBj();
    b.a locala = new b.a();
    locala.fsX = new aya();
    locala.fsY = new ayb();
    locala.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
    locala.funcId = 1196;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    aya localaya = new aya();
    localaya.fKw = this.appId;
    localaya.xmQ = this.hcr;
    locala.fsX = localaya;
    if (this.hzB > 0)
    {
      localaya.xmR = new dam();
      localaya.xmR.scene = this.hzB;
    }
    ab.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", new Object[] { this.appId, Integer.valueOf(this.hcr), Integer.valueOf(this.hzB) });
    w.a(locala.ado(), new JsApiRefreshSession.RefreshSessionTask.1(this), true);
    AppMethodBeat.o(130544);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130545);
    HashMap localHashMap = new HashMap();
    switch (this.hzA)
    {
    default: 
      if (!bo.isNullOrNil(this.errorMsg)) {
        break;
      }
    }
    for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
    {
      localHashMap.put("errCode", "-1");
      this.hyO.h(this.hry, this.hrz.j(str, localHashMap));
      for (;;)
      {
        aBk();
        AppMethodBeat.o(130545);
        return;
        localHashMap.put("expireIn", this.hzy);
        localHashMap.put("errCode", this.hzz);
        this.hyO.h(this.hry, this.hrz.j("ok", localHashMap));
      }
      if (bo.isNullOrNil(this.errorMsg)) {}
      for (str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
      {
        localHashMap.put("errCode", this.hzz);
        this.hyO.h(this.hry, this.hrz.j(str, localHashMap));
        break;
      }
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130546);
    this.hzy = paramParcel.readInt();
    this.hzz = paramParcel.readInt();
    this.hzA = paramParcel.readInt();
    this.hry = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.hcr = paramParcel.readInt();
    this.hzB = paramParcel.readInt();
    this.errorMsg = paramParcel.readString();
    AppMethodBeat.o(130546);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130547);
    paramParcel.writeInt(this.hzy);
    paramParcel.writeInt(this.hzz);
    paramParcel.writeInt(this.hzA);
    paramParcel.writeInt(this.hry);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hcr);
    paramParcel.writeInt(this.hzB);
    paramParcel.writeString(this.errorMsg);
    AppMethodBeat.o(130547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession.RefreshSessionTask
 * JD-Core Version:    0.7.0.1
 */