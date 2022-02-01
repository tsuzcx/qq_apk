package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class LocalMyChatRoom
  extends com.tencent.mm.bx.a
{
  public LinkedList<MyChatroomInfo> my_chatroom_info_list;
  public MyChatroomNotice my_chatroom_notice;
  
  public LocalMyChatRoom()
  {
    AppMethodBeat.i(275536);
    this.my_chatroom_info_list = new LinkedList();
    AppMethodBeat.o(275536);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275544);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.my_chatroom_info_list);
      if (this.my_chatroom_notice != null)
      {
        paramVarArgs.qD(2, this.my_chatroom_notice.computeSize());
        this.my_chatroom_notice.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275544);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.my_chatroom_info_list) + 0;
      paramInt = i;
      if (this.my_chatroom_notice != null) {
        paramInt = i + i.a.a.a.qC(2, this.my_chatroom_notice.computeSize());
      }
      AppMethodBeat.o(275544);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.my_chatroom_info_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275544);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      LocalMyChatRoom localLocalMyChatRoom = (LocalMyChatRoom)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275544);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new MyChatroomInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((MyChatroomInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localLocalMyChatRoom.my_chatroom_info_list.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275544);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new MyChatroomNotice();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((MyChatroomNotice)localObject2).parseFrom((byte[])localObject1);
        }
        localLocalMyChatRoom.my_chatroom_notice = ((MyChatroomNotice)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(275544);
      return 0;
    }
    AppMethodBeat.o(275544);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.LocalMyChatRoom
 * JD-Core Version:    0.7.0.1
 */