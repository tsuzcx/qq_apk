package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class MyChatroomNotice
  extends com.tencent.mm.bx.a
{
  public Color bg_color;
  public LinkedList<ContentBlock> content_list;
  
  public MyChatroomNotice()
  {
    AppMethodBeat.i(275517);
    this.content_list = new LinkedList();
    AppMethodBeat.o(275517);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275527);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.content_list);
      if (this.bg_color != null)
      {
        paramVarArgs.qD(2, this.bg_color.computeSize());
        this.bg_color.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275527);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.content_list) + 0;
      paramInt = i;
      if (this.bg_color != null) {
        paramInt = i + i.a.a.a.qC(2, this.bg_color.computeSize());
      }
      AppMethodBeat.o(275527);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.content_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275527);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      MyChatroomNotice localMyChatroomNotice = (MyChatroomNotice)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275527);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ContentBlock();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ContentBlock)localObject2).parseFrom((byte[])localObject1);
          }
          localMyChatroomNotice.content_list.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275527);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new Color();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((Color)localObject2).parseFrom((byte[])localObject1);
        }
        localMyChatroomNotice.bg_color = ((Color)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(275527);
      return 0;
    }
    AppMethodBeat.o(275527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.MyChatroomNotice
 * JD-Core Version:    0.7.0.1
 */