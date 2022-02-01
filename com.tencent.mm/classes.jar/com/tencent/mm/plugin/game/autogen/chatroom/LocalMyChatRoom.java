package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class LocalMyChatRoom
  extends com.tencent.mm.cd.a
{
  public LinkedList<MyChatroomInfo> my_chatroom_info_list;
  
  public LocalMyChatRoom()
  {
    AppMethodBeat.i(195201);
    this.my_chatroom_info_list = new LinkedList();
    AppMethodBeat.o(195201);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195203);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).e(1, 8, this.my_chatroom_info_list);
      AppMethodBeat.o(195203);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.my_chatroom_info_list);
      AppMethodBeat.o(195203);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.my_chatroom_info_list.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(195203);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      LocalMyChatRoom localLocalMyChatRoom = (LocalMyChatRoom)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195203);
        return -1;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        MyChatroomInfo localMyChatroomInfo = new MyChatroomInfo();
        if ((localObject != null) && (localObject.length > 0)) {
          localMyChatroomInfo.parseFrom((byte[])localObject);
        }
        localLocalMyChatRoom.my_chatroom_info_list.add(localMyChatroomInfo);
        paramInt += 1;
      }
      AppMethodBeat.o(195203);
      return 0;
    }
    AppMethodBeat.o(195203);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.LocalMyChatRoom
 * JD-Core Version:    0.7.0.1
 */