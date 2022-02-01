package com.tencent.mm.plugin.game.chatroom.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/chatroom/piece/LinkBlock;", "", "start", "", "end", "jumpInfo", "Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;", "(IILcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "game-chatroom_release"})
public final class h
{
  public JumpInfo CvE = null;
  public int end = 0;
  public int start = 0;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(212143);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((this.start != paramObject.start) || (this.end != paramObject.end) || (!p.h(this.CvE, paramObject.CvE))) {}
      }
    }
    else
    {
      AppMethodBeat.o(212143);
      return true;
    }
    AppMethodBeat.o(212143);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(212142);
    int j = this.start;
    int k = this.end;
    JumpInfo localJumpInfo = this.CvE;
    if (localJumpInfo != null) {}
    for (int i = localJumpInfo.hashCode();; i = 0)
    {
      AppMethodBeat.o(212142);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212140);
    String str = "LinkBlock(start=" + this.start + ", end=" + this.end + ", jumpInfo=" + this.CvE + ")";
    AppMethodBeat.o(212140);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.h
 * JD-Core Version:    0.7.0.1
 */