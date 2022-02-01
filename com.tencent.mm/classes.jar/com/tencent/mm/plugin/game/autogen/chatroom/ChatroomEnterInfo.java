package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomEnterInfo
  extends com.tencent.mm.bx.a
{
  public BackgroundInfo background_info;
  public String buttom_desc;
  public LinkedList<ContentBlock> content_list;
  public String report_str;
  public String title;
  public UserEnterOption user_enter_option;
  
  public ChatroomEnterInfo()
  {
    AppMethodBeat.i(275507);
    this.content_list = new LinkedList();
    AppMethodBeat.o(275507);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275523);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      paramVarArgs.e(2, 8, this.content_list);
      if (this.user_enter_option != null)
      {
        paramVarArgs.qD(3, this.user_enter_option.computeSize());
        this.user_enter_option.writeFields(paramVarArgs);
      }
      if (this.buttom_desc != null) {
        paramVarArgs.g(4, this.buttom_desc);
      }
      if (this.background_info != null)
      {
        paramVarArgs.qD(5, this.background_info.computeSize());
        this.background_info.writeFields(paramVarArgs);
      }
      if (this.report_str != null) {
        paramVarArgs.g(6, this.report_str);
      }
      AppMethodBeat.o(275523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label720;
      }
    }
    label720:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.content_list);
      paramInt = i;
      if (this.user_enter_option != null) {
        paramInt = i + i.a.a.a.qC(3, this.user_enter_option.computeSize());
      }
      i = paramInt;
      if (this.buttom_desc != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.buttom_desc);
      }
      paramInt = i;
      if (this.background_info != null) {
        paramInt = i + i.a.a.a.qC(5, this.background_info.computeSize());
      }
      i = paramInt;
      if (this.report_str != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.report_str);
      }
      AppMethodBeat.o(275523);
      return i;
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
        AppMethodBeat.o(275523);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ChatroomEnterInfo localChatroomEnterInfo = (ChatroomEnterInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275523);
          return -1;
        case 1: 
          localChatroomEnterInfo.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275523);
          return 0;
        case 2: 
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
            localChatroomEnterInfo.content_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275523);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new UserEnterOption();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((UserEnterOption)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomEnterInfo.user_enter_option = ((UserEnterOption)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275523);
          return 0;
        case 4: 
          localChatroomEnterInfo.buttom_desc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275523);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new BackgroundInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((BackgroundInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomEnterInfo.background_info = ((BackgroundInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275523);
          return 0;
        }
        localChatroomEnterInfo.report_str = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275523);
        return 0;
      }
      AppMethodBeat.o(275523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomEnterInfo
 * JD-Core Version:    0.7.0.1
 */