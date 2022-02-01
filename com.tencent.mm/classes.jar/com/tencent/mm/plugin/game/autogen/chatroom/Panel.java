package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class Panel
  extends com.tencent.mm.bx.a
{
  public String desc;
  public String icon;
  public JumpInfo jump_info;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275591);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.icon != null) {
        paramVarArgs.g(2, this.icon);
      }
      if (this.desc != null) {
        paramVarArgs.g(3, this.desc);
      }
      if (this.jump_info != null)
      {
        paramVarArgs.qD(4, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275591);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.icon);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.desc);
      }
      paramInt = i;
      if (this.jump_info != null) {
        paramInt = i + i.a.a.a.qC(4, this.jump_info.computeSize());
      }
      AppMethodBeat.o(275591);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275591);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      Panel localPanel = (Panel)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275591);
        return -1;
      case 1: 
        localPanel.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(275591);
        return 0;
      case 2: 
        localPanel.icon = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(275591);
        return 0;
      case 3: 
        localPanel.desc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(275591);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        JumpInfo localJumpInfo = new JumpInfo();
        if ((localObject != null) && (localObject.length > 0)) {
          localJumpInfo.parseFrom((byte[])localObject);
        }
        localPanel.jump_info = localJumpInfo;
        paramInt += 1;
      }
      AppMethodBeat.o(275591);
      return 0;
    }
    AppMethodBeat.o(275591);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.Panel
 * JD-Core Version:    0.7.0.1
 */