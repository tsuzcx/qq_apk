package com.tencent.mm.plugin.car_license_plate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiDeletePlateNo;", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CarLicensePlateCgiBase;", "Lcom/tencent/mm/protocal/protobuf/DeleteUserPlateInfoRequest;", "Lcom/tencent/mm/protocal/protobuf/DeleteUserPlateInfoResponse;", "plateNo", "", "(Ljava/lang/String;)V", "CMD_ID", "", "getCMD_ID", "()I", "LOG_TAG", "getLOG_TAG", "()Ljava/lang/String;", "URL", "getURL", "getPlateNo", "send", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a<ajv, ajw>
{
  private final String LOG_TAG;
  private final String URL;
  private final String wbV;
  private final int wbW;
  
  public c(String paramString)
  {
    super((erp)localajv, (esc)new ajw());
    this.wbV = paramString;
    this.LOG_TAG = "MicroMsg.CgiDeletePlateNo";
    this.URL = "/cgi-bin/mmbiz-bin/wxabusiness/deleteuserplateinfo";
    this.wbW = 5988;
    AppMethodBeat.o(277566);
  }
  
  public final Object U(d<? super ajw> paramd)
  {
    AppMethodBeat.i(277585);
    Np(s.X("send delete plateNo:", this.wbV));
    paramd = super.U(paramd);
    AppMethodBeat.o(277585);
    return paramd;
  }
  
  public final String cgR()
  {
    return this.URL;
  }
  
  public final String diO()
  {
    return this.LOG_TAG;
  }
  
  public final int diP()
  {
    return this.wbW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.a.c
 * JD-Core Version:    0.7.0.1
 */