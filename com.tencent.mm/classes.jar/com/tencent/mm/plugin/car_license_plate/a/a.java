package com.tencent.mm.plugin.car_license_plate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.c;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.m;
import kotlinx.coroutines.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/cgi/CarLicensePlateCgiBase;", "REQUEST", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "RESPONSE", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "", "request", "response", "(Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;)V", "CMD_ID", "", "getCMD_ID", "()I", "LOG_TAG", "", "getLOG_TAG", "()Ljava/lang/String;", "URL", "getURL", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "logI", "", "msg", "onProvideMockResp", "send", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-car-license-plate_release"})
public abstract class a<REQUEST extends dyl, RESPONSE extends dyy>
{
  private final REQUEST sXv;
  private final RESPONSE sXw;
  
  public a(REQUEST paramREQUEST, RESPONSE paramRESPONSE)
  {
    this.sXv = paramREQUEST;
    this.sXw = paramRESPONSE;
  }
  
  protected final void aqH(String paramString)
  {
    p.k(paramString, "msg");
    Log.i(cFu() + "[CarLicensePlateCgiBase][" + hashCode() + ']', paramString);
  }
  
  public abstract String btD();
  
  public Object c(kotlin.d.d<? super RESPONSE> paramd)
  {
    Object localObject = new d.a();
    ((d.a)localObject).TW(btD());
    ((d.a)localObject).vD(cFv());
    ((d.a)localObject).c((com.tencent.mm.cd.a)this.sXv);
    ((d.a)localObject).d((com.tencent.mm.cd.a)this.sXw);
    localObject = ((d.a)localObject).bgN();
    final c localc = new c();
    n localn = new n(kotlin.d.a.b.k(paramd), 1);
    localn.iQM();
    m localm = (m)localn;
    IPCRunCgi.a((com.tencent.mm.an.d)localObject, (IPCRunCgi.a)new a(localm, this, (com.tencent.mm.an.d)localObject, localc), (com.tencent.mm.vending.e.b)localc);
    localm.am((kotlin.g.a.b)new b(this, (com.tencent.mm.an.d)localObject, localc));
    localObject = localn.getResult();
    if (localObject == kotlin.d.a.a.aaAA) {
      p.k(paramd, "frame");
    }
    return localObject;
  }
  
  public abstract String cFu();
  
  public abstract int cFv();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "REQUEST", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "RESPONSE", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback", "com/tencent/mm/plugin/car_license_plate/cgi/CarLicensePlateCgiBase$send$2$2"})
  static final class a
    implements IPCRunCgi.a
  {
    a(m paramm, a parama, com.tencent.mm.an.d paramd, c paramc) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(186633);
      jdField_this.aqH("runCgi onTerminate, errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = (kotlin.d.d)this.khs;
        p.j(paramd, "rr");
        paramd = paramd.bhY();
        if (paramd == null)
        {
          paramString = new t("null cannot be cast to non-null type RESPONSE");
          AppMethodBeat.o(186633);
          throw paramString;
        }
        paramd = (dyy)paramd;
        localCompanion = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(paramd));
        AppMethodBeat.o(186633);
        return;
      }
      paramd = (kotlin.d.d)this.khs;
      paramString = (Throwable)new d(paramInt2, paramInt1, paramString, jdField_this);
      Result.Companion localCompanion = Result.Companion;
      paramd.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramString)));
      AppMethodBeat.o(186633);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "REQUEST", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "RESPONSE", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "it", "", "invoke", "com/tencent/mm/plugin/car_license_plate/cgi/CarLicensePlateCgiBase$send$2$3"})
  static final class b
    extends q
    implements kotlin.g.a.b<Throwable, x>
  {
    b(a parama, com.tencent.mm.an.d paramd, c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.a.a
 * JD-Core Version:    0.7.0.1
 */