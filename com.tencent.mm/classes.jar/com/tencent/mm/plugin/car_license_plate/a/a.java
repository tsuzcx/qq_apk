package com.tencent.mm.plugin.car_license_plate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/cgi/CarLicensePlateCgiBase;", "REQUEST", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "RESPONSE", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "", "request", "response", "(Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;)V", "CMD_ID", "", "getCMD_ID", "()I", "LOG_TAG", "", "getLOG_TAG", "()Ljava/lang/String;", "URL", "getURL", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "logI", "", "msg", "onProvideMockResp", "send", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<REQUEST extends erp, RESPONSE extends esc>
{
  private final REQUEST wbS;
  private final RESPONSE wbT;
  
  public a(REQUEST paramREQUEST, RESPONSE paramRESPONSE)
  {
    this.wbS = paramREQUEST;
    this.wbT = paramRESPONSE;
  }
  
  protected final void Np(String paramString)
  {
    s.u(paramString, "msg");
    Log.i(diO() + "[CarLicensePlateCgiBase][" + hashCode() + ']', paramString);
  }
  
  public Object U(kotlin.d.d<? super RESPONSE> paramd)
  {
    Object localObject = new c.a();
    ((c.a)localObject).uri = cgR();
    ((c.a)localObject).funcId = diP();
    ((c.a)localObject).otE = ((com.tencent.mm.bx.a)this.wbS);
    ((c.a)localObject).otF = ((com.tencent.mm.bx.a)this.wbT);
    localObject = ((c.a)localObject).bEF();
    final com.tencent.mm.vending.e.c localc = new com.tencent.mm.vending.e.c();
    q localq = new q(kotlin.d.a.b.au(paramd), 1);
    localq.kBA();
    final p localp = (p)localq;
    IPCRunCgi.a((com.tencent.mm.am.c)localObject, (IPCRunCgi.a)new a(this, localp, localc), (com.tencent.mm.vending.e.b)localc);
    localp.bg((kotlin.g.a.b)new b(localc));
    localObject = localq.getResult();
    if (localObject == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    return localObject;
  }
  
  public abstract String cgR();
  
  public abstract String diO();
  
  public abstract int diP();
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "REQUEST", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "RESPONSE", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    implements IPCRunCgi.a
  {
    a(a<REQUEST, RESPONSE> parama, p<? super RESPONSE> paramp, com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> paramc) {}
    
    public final void callback(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
    {
      AppMethodBeat.i(277564);
      this.wbU.Np("runCgi onTerminate, errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
      Result.Companion localCompanion;
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = (kotlin.d.d)localp;
        paramc = c.c.b(paramc.otC);
        if (paramc == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type RESPONSE of com.tencent.mm.plugin.car_license_plate.cgi.CarLicensePlateCgiBase.send$lambda-2");
          AppMethodBeat.o(277564);
          throw paramString;
        }
        paramc = (esc)paramc;
        localCompanion = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(paramc));
      }
      for (;;)
      {
        localc.dead();
        AppMethodBeat.o(277564);
        return;
        paramc = (kotlin.d.d)localp;
        paramString = (Throwable)new d(paramInt1, paramInt2, paramString, this.wbU);
        localCompanion = Result.Companion;
        paramc.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramString)));
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "REQUEST", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "RESPONSE", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    b(com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.a.a
 * JD-Core Version:    0.7.0.1
 */