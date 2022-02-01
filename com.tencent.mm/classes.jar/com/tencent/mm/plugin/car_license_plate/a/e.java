package com.tencent.mm.plugin.car_license_plate.a;

import com.tencent.luggage.l.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.fvl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lcom.tencent.mm.protocal.protobuf.cux;>;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiGetAllPlateNo;", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CarLicensePlateCgiBase;", "Lcom/tencent/mm/protocal/protobuf/GetUserPlateInfoRequest;", "Lcom/tencent/mm/protocal/protobuf/GetUserPlateInfoResponse;", "appId", "", "scene", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiGetAllPlateNo$ReqScene;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiGetAllPlateNo$ReqScene;)V", "CMD_ID", "", "getCMD_ID", "()I", "LOG_TAG", "getLOG_TAG", "()Ljava/lang/String;", "URL", "getURL", "getAppId", "send", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ReqScene", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a<cuw, cux>
{
  private final String LOG_TAG;
  private final String URL;
  private final String appId;
  private final int wbW;
  private final e.a wbY;
  
  public e(String paramString, e.a parama)
  {
    super((erp)localcuw, (esc)new cux());
    this.appId = paramString;
    this.wbY = parama;
    this.LOG_TAG = "MicroMsg.CgiGetAllPlateNo";
    this.URL = "/cgi-bin/mmbiz-bin/wxabusiness/getuserplateinfo";
    this.wbW = 5976;
    AppMethodBeat.o(277577);
  }
  
  public final Object U(kotlin.d.d<? super cux> paramd)
  {
    AppMethodBeat.i(277630);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    for (paramd = (kotlin.d.d<? super cux>)localObject1;; paramd = new b(this, paramd))
    {
      localObject1 = paramd.result;
      localObject2 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(277630);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Np("send with appId:" + this.appId + ", scene:" + this.wbY);
    paramd.label = 1;
    Object localObject1 = super.U(paramd);
    paramd = (kotlin.d.d<? super cux>)localObject1;
    if (localObject1 == localObject2)
    {
      AppMethodBeat.o(277630);
      return localObject2;
      ResultKt.throwOnFailure(localObject1);
      paramd = (kotlin.d.d<? super cux>)localObject1;
    }
    localObject1 = (cux)paramd;
    Object localObject2 = ((cux)localObject1).aaAp;
    com.tencent.mm.plugin.car_license_plate.api.entity.a locala;
    if (localObject2 != null)
    {
      if (((CharSequence)localObject2).length() <= 0) {
        break label360;
      }
      i = 1;
      if (i != 0)
      {
        locala = com.tencent.mm.plugin.car_license_plate.api.entity.a.wbN;
        s.u(localObject2, "<set-?>");
        com.tencent.mm.plugin.car_license_plate.api.entity.a.wbO.a(locala, com.tencent.mm.plugin.car_license_plate.api.entity.a.aYe[0], localObject2);
      }
    }
    localObject2 = ((cux)localObject1).aaAq;
    if (localObject2 != null) {
      if (((CharSequence)localObject2).length() <= 0) {
        break label365;
      }
    }
    label360:
    label365:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        locala = com.tencent.mm.plugin.car_license_plate.api.entity.a.wbN;
        s.u(localObject2, "<set-?>");
        com.tencent.mm.plugin.car_license_plate.api.entity.a.wbQ.a(locala, com.tencent.mm.plugin.car_license_plate.api.entity.a.aYe[2], localObject2);
      }
      localObject2 = ((cux)localObject1).aaAr;
      if (localObject2 != null)
      {
        locala = com.tencent.mm.plugin.car_license_plate.api.entity.a.wbN;
        s.u(localObject2, "<set-?>");
        com.tencent.mm.plugin.car_license_plate.api.entity.a.wbP.a(locala, com.tencent.mm.plugin.car_license_plate.api.entity.a.aYe[1], localObject2);
      }
      localObject1 = ((cux)localObject1).aaAs;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.car_license_plate.api.entity.a.wbN;
        com.tencent.mm.plugin.car_license_plate.api.entity.a.a((fvl)localObject1);
      }
      AppMethodBeat.o(277630);
      return paramd;
      i = 0;
      break;
    }
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
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    int label;
    
    b(e parame, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(277560);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.wcc.U((kotlin.d.d)this);
      AppMethodBeat.o(277560);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.a.e
 * JD-Core Version:    0.7.0.1
 */