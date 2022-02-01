package com.tencent.mm.plugin.game.chatroom.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/piece/LinkBlock;", "", "start", "", "end", "jumpInfo", "Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;", "userName", "", "canBeAt", "", "(IILcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;Ljava/lang/String;Z)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public JumpInfo Imo = null;
  public boolean Imp = false;
  public int end = 0;
  public int start = 0;
  public String userName = null;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(275957);
    if (this == paramObject)
    {
      AppMethodBeat.o(275957);
      return true;
    }
    if (!(paramObject instanceof l))
    {
      AppMethodBeat.o(275957);
      return false;
    }
    paramObject = (l)paramObject;
    if (this.start != paramObject.start)
    {
      AppMethodBeat.o(275957);
      return false;
    }
    if (this.end != paramObject.end)
    {
      AppMethodBeat.o(275957);
      return false;
    }
    if (!s.p(this.Imo, paramObject.Imo))
    {
      AppMethodBeat.o(275957);
      return false;
    }
    if (!s.p(this.userName, paramObject.userName))
    {
      AppMethodBeat.o(275957);
      return false;
    }
    if (this.Imp != paramObject.Imp)
    {
      AppMethodBeat.o(275957);
      return false;
    }
    AppMethodBeat.o(275957);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(275943);
    String str = "LinkBlock(start=" + this.start + ", end=" + this.end + ", jumpInfo=" + this.Imo + ", userName=" + this.userName + ", canBeAt=" + this.Imp + ')';
    AppMethodBeat.o(275943);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.l
 * JD-Core Version:    0.7.0.1
 */