package com.tencent.mm.msgsubscription.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "", "()V", "getType", "", "ConstantsNetwork", "ConstantsProtocal", "IDispatcher", "IOnSceneEnd", "IReqResp", "wxbiz-msgsubscription-sdk_release"})
public abstract class a
{
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface a
  {
    public abstract int a(a.c paramc, a.b paramb, a parama);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface b
  {
    public abstract void k(int paramInt1, int paramInt2, String paramString);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "", "requestProtoBuf", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getRequestProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "responseProtoBuf", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getResponseProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "getType", "()I", "uri", "", "getUri", "()Ljava/lang/String;", "Companion", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface c
  {
    public static final a iDX = a.iDY;
    
    public abstract cvc aOy();
    
    public abstract cvp aOz();
    
    public abstract int getType();
    
    public abstract String getUri();
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp$Companion;", "", "()V", "build", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "uri", "", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
    {
      static
      {
        AppMethodBeat.i(174574);
        iDY = new a();
        AppMethodBeat.o(174574);
      }
      
      public static a.c a(cvc paramcvc, final cvp paramcvp, final String paramString)
      {
        AppMethodBeat.i(174573);
        p.h(paramcvc, "request");
        p.h(paramcvp, "response");
        p.h(paramString, "uri");
        paramcvc = (a.c)new a(paramcvc, paramcvp, paramString);
        AppMethodBeat.o(174573);
        return paramcvc;
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp$Companion$build$1", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "requestProtoBuf", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getRequestProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "responseProtoBuf", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getResponseProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "getType", "()I", "uri", "", "getUri", "()Ljava/lang/String;", "wxbiz-msgsubscription-sdk_release"})
      public static final class a
        implements a.c
      {
        a(cvc paramcvc, cvp paramcvp, String paramString) {}
        
        public final cvc aOy()
        {
          return this.iDZ;
        }
        
        public final cvp aOz()
        {
          return paramcvp;
        }
        
        public final int getType()
        {
          return this.czG;
        }
        
        public final String getUri()
        {
          return paramString;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.a
 * JD-Core Version:    0.7.0.1
 */