package com.tencent.mm.msgsubscription.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "", "()V", "getType", "", "ConstantsNetwork", "ConstantsProtocal", "IDispatcher", "IOnSceneEnd", "IReqResp", "wxbiz-msgsubscription-sdk_release"})
public abstract class a
{
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface a
  {
    public abstract int a(a.c paramc, a.b paramb, a parama);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface b
  {
    public abstract void k(int paramInt1, int paramInt2, String paramString);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "", "requestProtoBuf", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getRequestProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "responseProtoBuf", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getResponseProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "getType", "()I", "uri", "", "getUri", "()Ljava/lang/String;", "Companion", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface c
  {
    public static final a iGQ = a.iGR;
    
    public abstract cvw aOV();
    
    public abstract cwj aOW();
    
    public abstract int getType();
    
    public abstract String getUri();
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp$Companion;", "", "()V", "build", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "uri", "", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
    {
      static
      {
        AppMethodBeat.i(174574);
        iGR = new a();
        AppMethodBeat.o(174574);
      }
      
      public static a.c a(cvw paramcvw, final cwj paramcwj, final String paramString)
      {
        AppMethodBeat.i(174573);
        p.h(paramcvw, "request");
        p.h(paramcwj, "response");
        p.h(paramString, "uri");
        paramcvw = (a.c)new a(paramcvw, paramcwj, paramString);
        AppMethodBeat.o(174573);
        return paramcvw;
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp$Companion$build$1", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "requestProtoBuf", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getRequestProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "responseProtoBuf", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getResponseProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "getType", "()I", "uri", "", "getUri", "()Ljava/lang/String;", "wxbiz-msgsubscription-sdk_release"})
      public static final class a
        implements a.c
      {
        a(cvw paramcvw, cwj paramcwj, String paramString) {}
        
        public final cvw aOV()
        {
          return this.iGS;
        }
        
        public final cwj aOW()
        {
          return paramcwj;
        }
        
        public final int getType()
        {
          return this.cAn;
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