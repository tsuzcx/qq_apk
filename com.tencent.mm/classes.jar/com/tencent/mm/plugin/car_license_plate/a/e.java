package com.tencent.mm.plugin.car_license_plate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import kotlin.d.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiGetAllPlateNo;", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CarLicensePlateCgiBase;", "Lcom/tencent/mm/protocal/protobuf/GetUserPlateInfoRequest;", "Lcom/tencent/mm/protocal/protobuf/GetUserPlateInfoResponse;", "appId", "", "scene", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiGetAllPlateNo$ReqScene;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiGetAllPlateNo$ReqScene;)V", "CMD_ID", "", "getCMD_ID", "()I", "LOG_TAG", "getLOG_TAG", "()Ljava/lang/String;", "URL", "getURL", "getAppId", "send", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ReqScene", "plugin-car-license-plate_release"})
public final class e
  extends a<cet, ceu>
{
  private final String LOG_TAG;
  private final String URL;
  private final String appId;
  private final int sXA;
  private final a sXD;
  
  public e(String paramString, a parama)
  {
    super((dyl)localcet, (dyy)new ceu());
    this.appId = paramString;
    this.sXD = parama;
    this.LOG_TAG = "MicroMsg.CgiGetAllPlateNo";
    this.URL = "/cgi-bin/mmbiz-bin/wxabusiness/getuserplateinfo";
    this.sXA = 5976;
    AppMethodBeat.o(186919);
  }
  
  public final String btD()
  {
    return this.URL;
  }
  
  public final Object c(d<? super ceu> paramd)
  {
    AppMethodBeat.i(186916);
    aqH("send with appId:" + this.appId + ", scene:" + this.sXD);
    paramd = super.c(paramd);
    AppMethodBeat.o(186916);
    return paramd;
  }
  
  public final String cFu()
  {
    return this.LOG_TAG;
  }
  
  public final int cFv()
  {
    return this.sXA;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiGetAllPlateNo$ReqScene;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "ReqScene_HalfPage", "ReqScene_MyPlateInfo", "plugin-car-license-plate_release"})
  public static enum a
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(187449);
      a locala1 = new a("ReqScene_HalfPage", 0, 1);
      sXE = locala1;
      a locala2 = new a("ReqScene_MyPlateInfo", 1, 2);
      sXF = locala2;
      sXG = new a[] { locala1, locala2 };
      AppMethodBeat.o(187449);
    }
    
    private a(int paramInt)
    {
      this.intValue = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.a.e
 * JD-Core Version:    0.7.0.1
 */