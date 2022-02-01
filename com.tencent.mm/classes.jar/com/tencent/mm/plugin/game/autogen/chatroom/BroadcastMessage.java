package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class BroadcastMessage
  extends com.tencent.mm.cd.a
{
  public int type;
  public LinkedList<String> username_list;
  public String wording;
  
  public BroadcastMessage()
  {
    AppMethodBeat.i(195597);
    this.username_list = new LinkedList();
    AppMethodBeat.o(195597);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195604);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      paramVarArgs.e(2, 1, this.username_list);
      paramVarArgs.aY(3, this.type);
      AppMethodBeat.o(195604);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.wording) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.username_list);
      int j = g.a.a.b.b.a.bM(3, this.type);
      AppMethodBeat.o(195604);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.username_list.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195604);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        BroadcastMessage localBroadcastMessage = (BroadcastMessage)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195604);
          return -1;
        case 1: 
          localBroadcastMessage.wording = locala.abFh.readString();
          AppMethodBeat.o(195604);
          return 0;
        case 2: 
          localBroadcastMessage.username_list.add(locala.abFh.readString());
          AppMethodBeat.o(195604);
          return 0;
        }
        localBroadcastMessage.type = locala.abFh.AK();
        AppMethodBeat.o(195604);
        return 0;
      }
      AppMethodBeat.o(195604);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.BroadcastMessage
 * JD-Core Version:    0.7.0.1
 */