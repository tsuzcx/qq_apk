package com.tencent.mm.mj_template.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.protocal.protobuf.ctm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lcom.tencent.mm.protocal.protobuf.cgc;>;
import kotlin.d.d<-Lcom.tencent.mm.protocal.protobuf.css;>;
import kotlin.d.d<-Lcom.tencent.mm.protocal.protobuf.ctm;>;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/svr_model/TemplateCgiHelper;", "", "()V", "CAMERA_CGI_URI", "", "CAMERA_FUNC_ID", "", "CAMERA_SCENE", "TAG", "getCameraTemplateList", "Lcom/tencent/mm/protocal/protobuf/GetCameraTemplateListResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTemplateList", "Lcom/tencent/mm/protocal/protobuf/GetTemplateSquareResponse;", "reqScene", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTemplateSpecific", "Lcom/tencent/mm/protocal/protobuf/GetSpecificTemplateResponse;", "templateId", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ofK;
  
  static
  {
    AppMethodBeat.i(239588);
    ofK = new a();
    AppMethodBeat.o(239588);
  }
  
  public final Object N(kotlin.d.d<? super cgc> paramd)
  {
    AppMethodBeat.i(239630);
    if ((paramd instanceof a))
    {
      localObject = (a)paramd;
      if ((((a)localObject).label & 0x80000000) != 0) {
        ((a)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super cgc>)localObject;; paramd = new a(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239630);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject);
    try
    {
      localObject = Result.Companion;
      localObject = new com.tencent.mm.am.b();
      c.a locala1 = new c.a();
      cgb localcgb = new cgb();
      localcgb.scene = 2;
      localcgb.aapn = 1001000;
      ah localah = ah.aiuX;
      locala1.otE = ((com.tencent.mm.bx.a)localcgb);
      locala1.otF = ((com.tencent.mm.bx.a)new cgc());
      locala1.funcId = 6940;
      locala1.uri = "/cgi-bin/micromsg-bin/findertemplategetcamera";
      locala1.otG = 0;
      locala1.respCmdId = 0;
      ((com.tencent.mm.am.b)localObject).c(locala1.bEF());
      paramd.label = 1;
      paramd = com.tencent.mm.af.b.a((com.tencent.mm.am.b)localObject, paramd);
      localObject = paramd;
      if (paramd == locala)
      {
        AppMethodBeat.o(239630);
        return locala;
        ResultKt.throwOnFailure(localObject);
      }
      paramd = Result.constructor-impl((cgc)localObject);
    }
    finally
    {
      for (;;)
      {
        localObject = Result.Companion;
        paramd = Result.constructor-impl(ResultKt.createFailure(paramd));
      }
      Log.printErrStackTrace("MicroMsg.Maas.TemplateCgiHelper", (Throwable)localObject, "getTemplateList cgi error", new Object[0]);
      AppMethodBeat.o(239630);
    }
    Object localObject = Result.exceptionOrNull-impl(paramd);
    if (localObject == null)
    {
      AppMethodBeat.o(239630);
      return paramd;
    }
    return null;
  }
  
  public final Object a(String paramString, int paramInt, kotlin.d.d<? super css> paramd)
  {
    AppMethodBeat.i(239603);
    Object localObject;
    if ((paramd instanceof c))
    {
      localObject = (c)paramd;
      if ((((c)localObject).label & 0x80000000) != 0) {
        ((c)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super css>)localObject;; paramd = new c(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239603);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject);
    try
    {
      localObject = Result.Companion;
      localObject = new com.tencent.mm.am.b();
      c.a locala1 = new c.a();
      csr localcsr = new csr();
      localcsr.id = paramString;
      localcsr.aahW = 1001000;
      localcsr.scene = paramInt;
      paramString = ah.aiuX;
      locala1.otE = ((com.tencent.mm.bx.a)localcsr);
      locala1.otF = ((com.tencent.mm.bx.a)new css());
      locala1.funcId = 6963;
      locala1.uri = "/cgi-bin/micromsg-bin/findertemplategetspecific";
      locala1.otG = 0;
      locala1.respCmdId = 0;
      paramString = ah.aiuX;
      ((com.tencent.mm.am.b)localObject).c(locala1.bEF());
      paramd.label = 1;
      paramString = com.tencent.mm.af.b.a((com.tencent.mm.am.b)localObject, paramd);
      paramd = paramString;
      if (paramString == locala)
      {
        AppMethodBeat.o(239603);
        return locala;
        ResultKt.throwOnFailure(localObject);
        paramd = (kotlin.d.d<? super css>)localObject;
      }
      paramString = Result.constructor-impl((css)paramd);
    }
    finally
    {
      for (;;)
      {
        paramd = Result.Companion;
        paramString = Result.constructor-impl(ResultKt.createFailure(paramString));
      }
      Log.printErrStackTrace("MicroMsg.Maas.TemplateCgiHelper", paramd, "getTemplateSpecific cgi error", new Object[0]);
      AppMethodBeat.o(239603);
    }
    paramd = Result.exceptionOrNull-impl(paramString);
    if (paramd == null)
    {
      AppMethodBeat.o(239603);
      return paramString;
    }
    return null;
  }
  
  public final Object b(int paramInt, kotlin.d.d<? super ctm> paramd)
  {
    AppMethodBeat.i(239620);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ctm>)localObject1;; paramd = new b(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239620);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    try
    {
      localObject1 = Result.Companion;
      localObject1 = new com.tencent.mm.am.b();
      c.a locala1 = new c.a();
      Object localObject2 = new ctl();
      ((ctl)localObject2).aazj = 1001000;
      Object localObject3 = com.tencent.mm.xeffect.d.agXC;
      ((ctl)localObject2).aapn = 140;
      ((ctl)localObject2).scene = paramInt;
      localObject3 = ah.aiuX;
      locala1.otE = ((com.tencent.mm.bx.a)localObject2);
      locala1.otF = ((com.tencent.mm.bx.a)new ctm());
      locala1.funcId = 6995;
      locala1.uri = "/cgi-bin/micromsg-bin/findertemplategetsquare";
      locala1.otG = 0;
      locala1.respCmdId = 0;
      localObject2 = ah.aiuX;
      ((com.tencent.mm.am.b)localObject1).c(locala1.bEF());
      paramd.label = 1;
      paramd = com.tencent.mm.af.b.a((com.tencent.mm.am.b)localObject1, paramd);
      localObject1 = paramd;
      if (paramd == locala)
      {
        AppMethodBeat.o(239620);
        return locala;
        ResultKt.throwOnFailure(localObject1);
      }
      paramd = Result.constructor-impl((ctm)localObject1);
    }
    finally
    {
      for (;;)
      {
        localObject1 = Result.Companion;
        paramd = Result.constructor-impl(ResultKt.createFailure(paramd));
      }
      Log.printErrStackTrace("MicroMsg.Maas.TemplateCgiHelper", (Throwable)localObject1, "getTemplateList cgi error", new Object[0]);
      AppMethodBeat.o(239620);
    }
    Object localObject1 = Result.exceptionOrNull-impl(paramd);
    if (localObject1 == null)
    {
      AppMethodBeat.o(239620);
      return paramd;
    }
    return null;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    int label;
    
    a(a parama, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239561);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ofL.N((kotlin.d.d)this);
      AppMethodBeat.o(239561);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    int label;
    
    b(a parama, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239556);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ofL.b(0, (kotlin.d.d)this);
      AppMethodBeat.o(239556);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    int label;
    
    c(a parama, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239584);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ofL.a(null, 0, (kotlin.d.d)this);
      AppMethodBeat.o(239584);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.mj_template.b.a
 * JD-Core Version:    0.7.0.1
 */