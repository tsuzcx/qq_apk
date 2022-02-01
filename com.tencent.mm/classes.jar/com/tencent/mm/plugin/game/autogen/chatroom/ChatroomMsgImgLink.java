package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomMsgImgLink
  extends com.tencent.mm.bx.a
{
  public JumpInfo jump_info;
  public int pic_height;
  public String pic_url;
  public int pic_width;
  public int playtime;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275590);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.pic_url != null) {
        paramVarArgs.g(2, this.pic_url);
      }
      paramVarArgs.bS(3, this.playtime);
      if (this.jump_info != null)
      {
        paramVarArgs.qD(4, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.pic_width);
      paramVarArgs.bS(6, this.pic_height);
      AppMethodBeat.o(275590);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.pic_url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.pic_url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.playtime);
      paramInt = i;
      if (this.jump_info != null) {
        paramInt = i + i.a.a.a.qC(4, this.jump_info.computeSize());
      }
      i = i.a.a.b.b.a.cJ(5, this.pic_width);
      int j = i.a.a.b.b.a.cJ(6, this.pic_height);
      AppMethodBeat.o(275590);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275590);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ChatroomMsgImgLink localChatroomMsgImgLink = (ChatroomMsgImgLink)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275590);
        return -1;
      case 1: 
        localChatroomMsgImgLink.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(275590);
        return 0;
      case 2: 
        localChatroomMsgImgLink.pic_url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(275590);
        return 0;
      case 3: 
        localChatroomMsgImgLink.playtime = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(275590);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          JumpInfo localJumpInfo = new JumpInfo();
          if ((localObject != null) && (localObject.length > 0)) {
            localJumpInfo.parseFrom((byte[])localObject);
          }
          localChatroomMsgImgLink.jump_info = localJumpInfo;
          paramInt += 1;
        }
        AppMethodBeat.o(275590);
        return 0;
      case 5: 
        localChatroomMsgImgLink.pic_width = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(275590);
        return 0;
      }
      localChatroomMsgImgLink.pic_height = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(275590);
      return 0;
    }
    AppMethodBeat.o(275590);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgImgLink
 * JD-Core Version:    0.7.0.1
 */