package com.tencent.mm.plugin.car_license_plate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahg;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import kotlin.d.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiDeletePlateNo;", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CarLicensePlateCgiBase;", "Lcom/tencent/mm/protocal/protobuf/DeleteUserPlateInfoRequest;", "Lcom/tencent/mm/protocal/protobuf/DeleteUserPlateInfoResponse;", "plateNo", "", "(Ljava/lang/String;)V", "CMD_ID", "", "getCMD_ID", "()I", "LOG_TAG", "getLOG_TAG", "()Ljava/lang/String;", "URL", "getURL", "getPlateNo", "send", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-car-license-plate_release"})
public final class c
  extends a<ahg, ahh>
{
  private final String LOG_TAG;
  private final String URL;
  private final int sXA;
  private final String sXB;
  
  public c(String paramString)
  {
    super((dyl)localahg, (dyy)new ahh());
    this.sXB = paramString;
    this.LOG_TAG = "MicroMsg.CgiDeletePlateNo";
    this.URL = "/cgi-bin/mmbiz-bin/wxabusiness/deleteuserplateinfo";
    this.sXA = 5988;
    AppMethodBeat.o(186492);
  }
  
  public final String btD()
  {
    return this.URL;
  }
  
  public final Object c(d<? super ahh> paramd)
  {
    AppMethodBeat.i(186489);
    aqH("send delete plateNo:" + this.sXB);
    paramd = super.c(paramd);
    AppMethodBeat.o(186489);
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
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.a.c
 * JD-Core Version:    0.7.0.1
 */