package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomMsgTpl
  extends com.tencent.mm.cd.a
{
  public LinkedList<TplBlock> tpl_block_list;
  
  public ChatroomMsgTpl()
  {
    AppMethodBeat.i(195276);
    this.tpl_block_list = new LinkedList();
    AppMethodBeat.o(195276);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195281);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).e(1, 8, this.tpl_block_list);
      AppMethodBeat.o(195281);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.tpl_block_list);
      AppMethodBeat.o(195281);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tpl_block_list.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(195281);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ChatroomMsgTpl localChatroomMsgTpl = (ChatroomMsgTpl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195281);
        return -1;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
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
      AppMethodBeat.o(195281);
      return 0;
    }
    AppMethodBeat.o(195281);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgTpl
 * JD-Core Version:    0.7.0.1
 */