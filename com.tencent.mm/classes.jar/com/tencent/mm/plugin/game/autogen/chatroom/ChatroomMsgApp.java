package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomMsgApp
  extends com.tencent.mm.cd.a
{
  public String bg_pic_url;
  public String button_des;
  public String des;
  public JumpInfo jump_info;
  public String second_des;
  public String title;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195484);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.des != null) {
        paramVarArgs.f(2, this.des);
      }
      if (this.button_des != null) {
        paramVarArgs.f(3, this.button_des);
      }
      if (this.bg_pic_url != null) {
        paramVarArgs.f(4, this.bg_pic_url);
      }
      paramVarArgs.aY(5, this.type);
      if (this.second_des != null) {
        paramVarArgs.f(6, this.second_des);
      }
      if (this.jump_info != null)
      {
        paramVarArgs.oE(7, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label636;
      }
    }
    label636:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.des != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.des);
      }
      i = paramInt;
      if (this.button_des != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.button_des);
      }
      paramInt = i;
      if (this.bg_pic_url != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.bg_pic_url);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.type);
      paramInt = i;
      if (this.second_des != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.second_des);
      }
      i = paramInt;
      if (this.jump_info != null) {
        i = paramInt + g.a.a.a.oD(7, this.jump_info.computeSize());
      }
      AppMethodBeat.o(195484);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195484);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ChatroomMsgApp localChatroomMsgApp = (ChatroomMsgApp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195484);
          return -1;
        case 1: 
          localChatroomMsgApp.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195484);
          return 0;
        case 2: 
          localChatroomMsgApp.des = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195484);
          return 0;
        case 3: 
          localChatroomMsgApp.button_des = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195484);
          return 0;
        case 4: 
          localChatroomMsgApp.bg_pic_url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195484);
          return 0;
        case 5: 
          localChatroomMsgApp.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(195484);
          return 0;
        case 6: 
          localChatroomMsgApp.second_des = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195484);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          JumpInfo localJumpInfo = new JumpInfo();
          if ((localObject != null) && (localObject.length > 0)) {
            localJumpInfo.parseFrom((byte[])localObject);
          }
          localChatroomMsgApp.jump_info = localJumpInfo;
          paramInt += 1;
        }
        AppMethodBeat.o(195484);
        return 0;
      }
      AppMethodBeat.o(195484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgApp
 * JD-Core Version:    0.7.0.1
 */