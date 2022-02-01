package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class SlotList
  extends com.tencent.mm.bx.a
{
  public String head_desc;
  public LinkedList<Slot> slot_list;
  public String version;
  
  public SlotList()
  {
    AppMethodBeat.i(275564);
    this.slot_list = new LinkedList();
    AppMethodBeat.o(275564);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275574);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.slot_list);
      if (this.version != null) {
        paramVarArgs.g(2, this.version);
      }
      if (this.head_desc != null) {
        paramVarArgs.g(3, this.head_desc);
      }
      AppMethodBeat.o(275574);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.slot_list) + 0;
      paramInt = i;
      if (this.version != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.version);
      }
      i = paramInt;
      if (this.head_desc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.head_desc);
      }
      AppMethodBeat.o(275574);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.slot_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275574);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      SlotList localSlotList = (SlotList)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275574);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          Slot localSlot = new Slot();
          if ((localObject != null) && (localObject.length > 0)) {
            localSlot.parseFrom((byte[])localObject);
          }
          localSlotList.slot_list.add(localSlot);
          paramInt += 1;
        }
        AppMethodBeat.o(275574);
        return 0;
      case 2: 
        localSlotList.version = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(275574);
        return 0;
      }
      localSlotList.head_desc = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(275574);
      return 0;
    }
    AppMethodBeat.o(275574);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.SlotList
 * JD-Core Version:    0.7.0.1
 */