package com.tencent.mm.plugin.car_license_plate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahg;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiCreatePlateNo;", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CarLicensePlateCgiBase;", "Lcom/tencent/mm/protocal/protobuf/CreateUserPlateInfoRequest;", "Lcom/tencent/mm/protocal/protobuf/CreateUserPlateInfoResponse;", "plateNo", "", "(Ljava/lang/String;)V", "CMD_ID", "", "getCMD_ID", "()I", "LOG_TAG", "getLOG_TAG", "()Ljava/lang/String;", "URL", "getURL", "send", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a<ahg, ahh>
{
  private final String LOG_TAG;
  private final String URL;
  private final String wbV;
  private final int wbW;
  
  public b(String paramString)
  {
    super((erp)localahg, (esc)new ahh());
    this.wbV = paramString;
    this.LOG_TAG = "MicroMsg.CgiCreatePlateNo";
    this.URL = "/cgi-bin/mmbiz-bin/wxabusiness/createuserplateinfo";
    this.wbW = 5876;
    AppMethodBeat.o(277562);
  }
  
  public final Object U(d<? super ahh> paramd)
  {
    AppMethodBeat.i(277580);
    Np(s.X("send create ", this.wbV));
    paramd = super.U(paramd);
    AppMethodBeat.o(277580);
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
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.a.b
 * JD-Core Version:    0.7.0.1
 */