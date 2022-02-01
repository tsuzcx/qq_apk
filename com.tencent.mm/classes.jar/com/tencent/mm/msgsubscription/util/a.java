package com.tencent.mm.msgsubscription.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "", "()V", "getType", "", "ConstantsNetwork", "ConstantsProtocal", "IDispatcher", "IOnSceneEnd", "IReqResp", "wxbiz-msgsubscription-sdk_release"})
public abstract class a
{
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface a
  {
    public abstract int a(a.c paramc, a.b paramb, a parama);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface b
  {
    public abstract void k(int paramInt1, int paramInt2, String paramString);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "", "requestProtoBuf", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getRequestProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "responseProtoBuf", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getResponseProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "getType", "()I", "uri", "", "getUri", "()Ljava/lang/String;", "Companion", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface c
  {
    public static final a jCZ = a.jDa;
    
    public abstract dop bjh();
    
    public abstract dpc bji();
    
    public abstract int getType();
    
    public abstract String getUri();
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp$Companion;", "", "()V", "build", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "uri", "", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
    {
      static
      {
        AppMethodBeat.i(174574);
        jDa = new a();
        AppMethodBeat.o(174574);
      }
      
      public static a.c a(dop paramdop, final dpc paramdpc, final String paramString)
      {
        AppMethodBeat.i(174573);
        p.h(paramdop, "request");
        p.h(paramdpc, "response");
        p.h(paramString, "uri");
        paramdop = (a.c)new a(paramdop, paramdpc, 2920, paramString);
        AppMethodBeat.o(174573);
        return paramdop;
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp$Companion$build$1", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "requestProtoBuf", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getRequestProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "responseProtoBuf", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getResponseProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "getType", "()I", "uri", "", "getUri", "()Ljava/lang/String;", "wxbiz-msgsubscription-sdk_release"})
      public static final class a
        implements a.c
      {
        a(dop paramdop, dpc paramdpc, int paramInt, String paramString) {}
        
        public final dop bjh()
        {
          return this.jDb;
        }
        
        public final dpc bji()
        {
          return paramdpc;
        }
        
        public final int getType()
        {
          return this.$type;
        }
        
        public final String getUri()
        {
          return paramString;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.a
 * JD-Core Version:    0.7.0.1
 */