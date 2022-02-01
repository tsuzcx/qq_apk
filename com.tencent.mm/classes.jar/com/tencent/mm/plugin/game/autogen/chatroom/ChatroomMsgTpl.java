package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomMsgTpl
  extends com.tencent.mm.bx.a
{
  public LinkedList<TplBlock> tpl_block_list;
  
  public ChatroomMsgTpl()
  {
    AppMethodBeat.i(275486);
    this.tpl_block_list = new LinkedList();
    AppMethodBeat.o(275486);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275491);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).e(1, 8, this.tpl_block_list);
      AppMethodBeat.o(275491);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.tpl_block_list);
      AppMethodBeat.o(275491);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tpl_block_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275491);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ChatroomMsgTpl localChatroomMsgTpl = (ChatroomMsgTpl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275491);
        return -1;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        TplBlock localTplBlock = new TplBlock();
        if ((localObject != null) && (localObject.length > 0)) {
          localTplBlock.parseFrom((byte[])localObject);
        }
        localChatroomMsgTpl.tpl_block_list.add(localTplBlock);
        paramInt += 1;
      }
      AppMethodBeat.o(275491);
      return 0;
    }
    AppMethodBeat.o(275491);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgTpl
 * JD-Core Version:    0.7.0.1
 */