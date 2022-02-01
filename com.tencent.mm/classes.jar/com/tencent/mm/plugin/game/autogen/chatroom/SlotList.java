package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class SlotList
  extends com.tencent.mm.cd.a
{
  public String head_desc;
  public LinkedList<Slot> slot_list;
  public String version;
  
  public SlotList()
  {
    AppMethodBeat.i(194916);
    this.slot_list = new LinkedList();
    AppMethodBeat.o(194916);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194928);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.slot_list);
      if (this.version != null) {
        paramVarArgs.f(2, this.version);
      }
      if (this.head_desc != null) {
        paramVarArgs.f(3, this.head_desc);
      }
      AppMethodBeat.o(194928);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.slot_list) + 0;
      paramInt = i;
      if (this.version != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.version);
      }
      i = paramInt;
      if (this.head_desc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.head_desc);
      }
      AppMethodBeat.o(194928);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.slot_list.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(194928);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      SlotList localSlotList = (SlotList)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(194928);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
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
        AppMethodBeat.o(194928);
        return 0;
      case 2: 
        localSlotList.version = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(194928);
        return 0;
      }
      localSlotList.head_desc = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(194928);
      return 0;
    }
    AppMethodBeat.o(194928);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.SlotList
 * JD-Core Version:    0.7.0.1
 */