package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class BroadcastMessage
  extends com.tencent.mm.bx.a
{
  public Color color;
  public int disappear_second;
  public int type;
  public LinkedList<String> username_list;
  public String wording;
  
  public BroadcastMessage()
  {
    AppMethodBeat.i(275593);
    this.username_list = new LinkedList();
    AppMethodBeat.o(275593);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275601);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      paramVarArgs.e(2, 1, this.username_list);
      paramVarArgs.bS(3, this.type);
      if (this.color != null)
      {
        paramVarArgs.qD(4, this.color.computeSize());
        this.color.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.disappear_second);
      AppMethodBeat.o(275601);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = i.a.a.b.b.a.h(1, this.wording) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 1, this.username_list) + i.a.a.b.b.a.cJ(3, this.type);
      paramInt = i;
      if (this.color != null) {
        paramInt = i + i.a.a.a.qC(4, this.color.computeSize());
      }
      i = i.a.a.b.b.a.cJ(5, this.disappear_second);
      AppMethodBeat.o(275601);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.username_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275601);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        BroadcastMessage localBroadcastMessage = (BroadcastMessage)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275601);
          return -1;
        case 1: 
          localBroadcastMessage.wording = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275601);
          return 0;
        case 2: 
          localBroadcastMessage.username_list.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(275601);
          return 0;
        case 3: 
          localBroadcastMessage.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(275601);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            Color localColor = new Color();
            if ((localObject != null) && (localObject.length > 0)) {
              localColor.parseFrom((byte[])localObject);
            }
            localBroadcastMessage.color = localColor;
            paramInt += 1;
          }
          AppMethodBeat.o(275601);
          return 0;
        }
        localBroadcastMessage.disappear_second = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(275601);
        return 0;
      }
      AppMethodBeat.o(275601);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.BroadcastMessage
 * JD-Core Version:    0.7.0.1
 */