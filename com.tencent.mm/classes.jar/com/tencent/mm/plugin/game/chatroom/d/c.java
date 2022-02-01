package com.tencent.mm.plugin.game.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/data/MentionUserWrapper;", "", "topTip", "Lkotlin/Pair;", "", "", "user", "Lcom/tencent/mm/plugin/game/chatroom/data/SimpleUserInfo;", "showFooter", "reportPosition", "", "(Lkotlin/Pair;Lcom/tencent/mm/plugin/game/chatroom/data/SimpleUserInfo;ZI)V", "getReportPosition", "()I", "getShowFooter", "()Z", "getTopTip", "()Lkotlin/Pair;", "getUser", "()Lcom/tencent/mm/plugin/game/chatroom/data/SimpleUserInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public final boolean FYI;
  public final r<Boolean, String> Ikk;
  public final d Ikl;
  public final int mkb;
  
  public c(r<Boolean, String> paramr, d paramd, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(275661);
    this.Ikk = paramr;
    this.Ikl = paramd;
    this.FYI = paramBoolean;
    this.mkb = paramInt;
    AppMethodBeat.o(275661);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(275706);
    if (this == paramObject)
    {
      AppMethodBeat.o(275706);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(275706);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.Ikk, paramObject.Ikk))
    {
      AppMethodBeat.o(275706);
      return false;
    }
    if (!s.p(this.Ikl, paramObject.Ikl))
    {
      AppMethodBeat.o(275706);
      return false;
    }
    if (this.FYI != paramObject.FYI)
    {
      AppMethodBeat.o(275706);
      return false;
    }
    if (this.mkb != paramObject.mkb)
    {
      AppMethodBeat.o(275706);
      return false;
    }
    AppMethodBeat.o(275706);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(275685);
    String str = "MentionUserWrapper(topTip=" + this.Ikk + ", user=" + this.Ikl + ", showFooter=" + this.FYI + ", reportPosition=" + this.mkb + ')';
    AppMethodBeat.o(275685);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.d.c
 * JD-Core Version:    0.7.0.1
 */