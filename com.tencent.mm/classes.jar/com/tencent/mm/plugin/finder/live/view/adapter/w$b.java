package com.tencent.mm.plugin.finder.live.view.adapter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.cxk;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$FinderLiveContactInfo;", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "type", "", "onlineCnt", "offlineCnt", "isMySelf", "", "giftItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/GiftItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;IIIZLjava/util/LinkedList;)V", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getGiftItems", "()Ljava/util/LinkedList;", "setGiftItems", "(Ljava/util/LinkedList;)V", "()Z", "setMySelf", "(Z)V", "getOfflineCnt", "()I", "getOnlineCnt", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w$b
{
  final int DSe;
  final int DSf;
  LinkedList<cxk> DSg;
  final bgh Ddj;
  final int type;
  boolean yAN;
  
  private w$b(bgh parambgh, int paramInt1, int paramInt2, LinkedList<cxk> paramLinkedList)
  {
    this.Ddj = parambgh;
    this.type = paramInt1;
    this.DSe = paramInt2;
    this.DSf = 0;
    this.yAN = false;
    this.DSg = paramLinkedList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(359027);
    if (this == paramObject)
    {
      AppMethodBeat.o(359027);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(359027);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.Ddj, paramObject.Ddj))
    {
      AppMethodBeat.o(359027);
      return false;
    }
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(359027);
      return false;
    }
    if (this.DSe != paramObject.DSe)
    {
      AppMethodBeat.o(359027);
      return false;
    }
    if (this.DSf != paramObject.DSf)
    {
      AppMethodBeat.o(359027);
      return false;
    }
    if (this.yAN != paramObject.yAN)
    {
      AppMethodBeat.o(359027);
      return false;
    }
    if (!s.p(this.DSg, paramObject.DSg))
    {
      AppMethodBeat.o(359027);
      return false;
    }
    AppMethodBeat.o(359027);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(359007);
    String str = "FinderLiveContactInfo(contact=" + this.Ddj + ", type=" + this.type + ", onlineCnt=" + this.DSe + ", offlineCnt=" + this.DSf + ", isMySelf=" + this.yAN + ", giftItems=" + this.DSg + ')';
    AppMethodBeat.o(359007);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.w.b
 * JD-Core Version:    0.7.0.1
 */