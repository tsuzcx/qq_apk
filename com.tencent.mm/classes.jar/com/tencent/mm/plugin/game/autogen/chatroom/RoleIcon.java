package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class RoleIcon
  extends com.tencent.mm.bx.a
{
  public String icon_url;
  public JumpInfo jump_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275478);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.icon_url != null) {
        paramVarArgs.g(1, this.icon_url);
      }
      if (this.jump_info != null)
      {
        paramVarArgs.qD(2, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.icon_url == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.icon_url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jump_info != null) {
        i = paramInt + i.a.a.a.qC(2, this.jump_info.computeSize());
      }
      AppMethodBeat.o(275478);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        RoleIcon localRoleIcon = (RoleIcon)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275478);
          return -1;
        case 1: 
          localRoleIcon.icon_url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275478);
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
          localRoleIcon.jump_info = localJumpInfo;
          paramInt += 1;
        }
        AppMethodBeat.o(275478);
        return 0;
      }
      AppMethodBeat.o(275478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.RoleIcon
 * JD-Core Version:    0.7.0.1
 */