package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderStreamRequestArgs;", "", "()V", "byPassInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getByPassInfo", "()Lcom/tencent/mm/protobuf/ByteString;", "setByPassInfo", "(Lcom/tencent/mm/protobuf/ByteString;)V", "byPassInfoType", "", "getByPassInfoType", "()Ljava/lang/Integer;", "setByPassInfoType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cardBuffer", "getCardBuffer", "setCardBuffer", "enterSourceType", "getEnterSourceType", "()I", "setEnterSourceType", "(I)V", "guideBarObjId", "", "getGuideBarObjId", "()Ljava/lang/Long;", "setGuideBarObjId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isFirstEnterFetch", "", "()Z", "setFirstEnterFetch", "(Z)V", "isFromFloatBall", "setFromFloatBall", "nonceId", "", "getNonceId", "()Ljava/lang/String;", "setNonceId", "(Ljava/lang/String;)V", "objectId", "getObjectId", "()J", "setObjectId", "(J)V", "requestScene", "getRequestScene", "setRequestScene", "sourceType", "getSourceType", "setSourceType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public int AAd;
  public int ACA;
  public b AEA;
  public b AEB;
  public Integer AEC;
  public boolean AED;
  public boolean AEE;
  public Long AEz;
  public long hKN;
  String nonceId = "";
  public int sourceType;
  
  public final void setNonceId(String paramString)
  {
    AppMethodBeat.i(336821);
    s.u(paramString, "<set-?>");
    this.nonceId = paramString;
    AppMethodBeat.o(336821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.d
 * JD-Core Version:    0.7.0.1
 */