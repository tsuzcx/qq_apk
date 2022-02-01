package com.tencent.mm.msgsubscription.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "", "()V", "getType", "", "ConstantsNetwork", "ConstantsProtocal", "IDispatcher", "IOnSceneEnd", "IReqResp", "wxbiz-msgsubscription-sdk_release"})
public abstract class a
{
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface a
  {
    public abstract int a(a.c paramc, a.b paramb, a parama);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface b
  {
    public abstract void k(int paramInt1, int paramInt2, String paramString);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "", "requestProtoBuf", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getRequestProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "responseProtoBuf", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getResponseProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "getType", "()I", "uri", "", "getUri", "()Ljava/lang/String;", "Companion", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface c
  {
    public static final a ikG = a.ikH;
    
    public abstract cpx aLo();
    
    public abstract cqk aLp();
    
    public abstract int getType();
    
    public abstract String getUri();
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp$Companion;", "", "()V", "build", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "uri", "", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
    {
      static
      {
        AppMethodBeat.i(174574);
        ikH = new a();
        AppMethodBeat.o(174574);
      }
      
      public static a.c a(cpx paramcpx, final cqk paramcqk, final String paramString)
      {
        AppMethodBeat.i(174573);
        k.h(paramcpx, "request");
        k.h(paramcqk, "response");
        k.h(paramString, "uri");
        paramcpx = (a.c)new a(paramcpx, paramcqk, paramString);
        AppMethodBeat.o(174573);
        return paramcpx;
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp$Companion$build$1", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "requestProtoBuf", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getRequestProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "responseProtoBuf", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getResponseProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "getType", "()I", "uri", "", "getUri", "()Ljava/lang/String;", "wxbiz-msgsubscription-sdk_release"})
      public static final class a
        implements a.c
      {
        a(cpx paramcpx, cqk paramcqk, String paramString) {}
        
        public final cpx aLo()
        {
          return this.ikI;
        }
        
        public final cqk aLp()
        {
          return paramcqk;
        }
        
        public final int getType()
        {
          return this.coP;
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