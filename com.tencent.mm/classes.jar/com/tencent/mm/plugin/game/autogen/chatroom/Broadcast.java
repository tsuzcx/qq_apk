package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class Broadcast
  extends com.tencent.mm.bx.a
{
  public LinkedList<BroadcastMessage> message_list;
  public String version;
  
  public Broadcast()
  {
    AppMethodBeat.i(275521);
    this.message_list = new LinkedList();
    AppMethodBeat.o(275521);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275533);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.message_list);
      if (this.version != null) {
        paramVarArgs.g(2, this.version);
      }
      AppMethodBeat.o(275533);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.message_list) + 0;
      paramInt = i;
      if (this.version != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.version);
      }
      AppMethodBeat.o(275533);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.message_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275533);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      Broadcast localBroadcast = (Broadcast)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275533);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          BroadcastMessage localBroadcastMessage = new BroadcastMessage();
          if ((localObject != null) && (localObject.length > 0)) {
            localBroadcastMessage.parseFrom((byte[])localObject);
          }
          localBroadcast.message_list.add(localBroadcastMessage);
          paramInt += 1;
        }
        AppMethodBeat.o(275533);
        return 0;
      }
      localBroadcast.version = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(275533);
      return 0;
    }
    AppMethodBeat.o(275533);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.Broadcast
 * JD-Core Version:    0.7.0.1
 */