package com.tencent.mm.plugin.car_license_plate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.protobuf.aev;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import kotlin.d.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiCreatePlateNo;", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CarLicensePlateCgiBase;", "Lcom/tencent/mm/protocal/protobuf/CreateUserPlateInfoRequest;", "Lcom/tencent/mm/protocal/protobuf/CreateUserPlateInfoResponse;", "plateNo", "", "(Ljava/lang/String;)V", "CMD_ID", "", "getCMD_ID", "()I", "LOG_TAG", "getLOG_TAG", "()Ljava/lang/String;", "URL", "getURL", "send", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-car-license-plate_release"})
public final class b
  extends a<aeu, aev>
{
  private final String LOG_TAG;
  private final String URL;
  private final int sXA;
  private final String sXB;
  
  public b(String paramString)
  {
    super((dyl)localaeu, (dyy)new aev());
    this.sXB = paramString;
    this.LOG_TAG = "MicroMsg.CgiCreatePlateNo";
    this.URL = "/cgi-bin/mmbiz-bin/wxabusiness/createuserplateinfo";
    this.sXA = 5876;
    AppMethodBeat.o(187098);
  }
  
  public final String btD()
  {
    return this.URL;
  }
  
  public final Object c(d<? super aev> paramd)
  {
    AppMethodBeat.i(187091);
    aqH("send create " + this.sXB);
    paramd = super.c(paramd);
    AppMethodBeat.o(187091);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.a.b
 * JD-Core Version:    0.7.0.1
 */