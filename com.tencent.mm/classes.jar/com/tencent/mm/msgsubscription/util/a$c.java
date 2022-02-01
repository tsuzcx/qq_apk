package com.tencent.mm.msgsubscription.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "", "requestProtoBuf", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getRequestProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "responseProtoBuf", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getResponseProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "getType", "()I", "uri", "", "getUri", "()Ljava/lang/String;", "Companion", "wxbiz-msgsubscription-sdk_release"})
public abstract interface a$c
{
  public static final a hKj = a.hKk;
  
  public abstract ckq aEx();
  
  public abstract cld aEy();
  
  public abstract int getType();
  
  public abstract String getUri();
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp$Companion;", "", "()V", "build", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "uri", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(174574);
      hKk = new a();
      AppMethodBeat.o(174574);
    }
    
    public static a.c a(ckq paramckq, final cld paramcld, final String paramString)
    {
      AppMethodBeat.i(174573);
      k.h(paramckq, "request");
      k.h(paramcld, "response");
      k.h(paramString, "uri");
      paramckq = (a.c)new a(paramckq, paramcld, paramString);
      AppMethodBeat.o(174573);
      return paramckq;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp$Companion$build$1", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "requestProtoBuf", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getRequestProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "responseProtoBuf", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getResponseProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "getType", "()I", "uri", "", "getUri", "()Ljava/lang/String;", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
      implements a.c
    {
      a(ckq paramckq, cld paramcld, String paramString) {}
      
      public final ckq aEx()
      {
        return this.hKl;
      }
      
      public final cld aEy()
      {
        return paramcld;
      }
      
      public final int getType()
      {
        return this.crJ;
      }
      
      public final String getUri()
      {
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.a.c
 * JD-Core Version:    0.7.0.1
 */