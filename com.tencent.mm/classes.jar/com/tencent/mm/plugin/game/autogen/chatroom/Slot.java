package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class Slot
  extends com.tencent.mm.bx.a
{
  public JumpInfo jump_info;
  public OnlineUser online_user_status;
  public int slot_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275532);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.slot_type);
      if (this.online_user_status != null)
      {
        paramVarArgs.qD(2, this.online_user_status.computeSize());
        this.online_user_status.writeFields(paramVarArgs);
      }
      if (this.jump_info != null)
      {
        paramVarArgs.qD(3, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275532);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.slot_type) + 0;
      paramInt = i;
      if (this.online_user_status != null) {
        paramInt = i + i.a.a.a.qC(2, this.online_user_status.computeSize());
      }
      i = paramInt;
      if (this.jump_info != null) {
        i = paramInt + i.a.a.a.qC(3, this.jump_info.computeSize());
      }
      AppMethodBeat.o(275532);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275532);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      Slot localSlot = (Slot)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275532);
        return -1;
      case 1: 
        localSlot.slot_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(275532);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new OnlineUser();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((OnlineUser)localObject2).parseFrom((byte[])localObject1);
          }
          localSlot.online_user_status = ((OnlineUser)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275532);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new JumpInfo();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((JumpInfo)localObject2).parseFrom((byte[])localObject1);
        }
        localSlot.jump_info = ((JumpInfo)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(275532);
      return 0;
    }
    AppMethodBeat.o(275532);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.Slot
 * JD-Core Version:    0.7.0.1
 */