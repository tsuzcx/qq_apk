package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomTag
  extends com.tencent.mm.bx.a
{
  public Color background_color;
  public Color color;
  public String desc;
  public String icon;
  public JumpInfo tag_jump_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275550);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.desc != null) {
        paramVarArgs.g(1, this.desc);
      }
      if (this.icon != null) {
        paramVarArgs.g(2, this.icon);
      }
      if (this.background_color != null)
      {
        paramVarArgs.qD(3, this.background_color.computeSize());
        this.background_color.writeFields(paramVarArgs);
      }
      if (this.color != null)
      {
        paramVarArgs.qD(4, this.color.computeSize());
        this.color.writeFields(paramVarArgs);
      }
      if (this.tag_jump_info != null)
      {
        paramVarArgs.qD(5, this.tag_jump_info.computeSize());
        this.tag_jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.desc == null) {
        break label668;
      }
    }
    label668:
    for (int i = i.a.a.b.b.a.h(1, this.desc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.icon);
      }
      i = paramInt;
      if (this.background_color != null) {
        i = paramInt + i.a.a.a.qC(3, this.background_color.computeSize());
      }
      paramInt = i;
      if (this.color != null) {
        paramInt = i + i.a.a.a.qC(4, this.color.computeSize());
      }
      i = paramInt;
      if (this.tag_jump_info != null) {
        i = paramInt + i.a.a.a.qC(5, this.tag_jump_info.computeSize());
      }
      AppMethodBeat.o(275550);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ChatroomTag localChatroomTag = (ChatroomTag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275550);
          return -1;
        case 1: 
          localChatroomTag.desc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275550);
          return 0;
        case 2: 
          localChatroomTag.icon = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275550);
          return 0;
        case 3: 
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
            localChatroomTag.background_color = ((Color)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275550);
          return 0;
        case 4: 
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
            localChatroomTag.color = ((Color)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275550);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new JumpInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((JumpInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localChatroomTag.tag_jump_info = ((JumpInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275550);
        return 0;
      }
      AppMethodBeat.o(275550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomTag
 * JD-Core Version:    0.7.0.1
 */