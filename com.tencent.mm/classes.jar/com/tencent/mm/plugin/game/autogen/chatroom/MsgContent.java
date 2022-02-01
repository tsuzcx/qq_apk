package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class MsgContent
  extends com.tencent.mm.bx.a
{
  public ChatroomMsgApp chatroom_app;
  public ChatroomMsgEmoji chatroom_emoji;
  public ChatroomMsgImgCard chatroom_img_card;
  public ChatroomMsgImgLink chatroom_img_link;
  public ChatroomMsgNotice chatroom_notice;
  public ChatroomMsgShareLink chatroom_share_link;
  public ChatroomMsgSys chatroom_sys;
  public ChatroomMsgText chatroom_text;
  public ChatroomMsgTpl chatroom_tpl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275510);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_app != null)
      {
        paramVarArgs.qD(1, this.chatroom_app.computeSize());
        this.chatroom_app.writeFields(paramVarArgs);
      }
      if (this.chatroom_tpl != null)
      {
        paramVarArgs.qD(2, this.chatroom_tpl.computeSize());
        this.chatroom_tpl.writeFields(paramVarArgs);
      }
      if (this.chatroom_text != null)
      {
        paramVarArgs.qD(7, this.chatroom_text.computeSize());
        this.chatroom_text.writeFields(paramVarArgs);
      }
      if (this.chatroom_sys != null)
      {
        paramVarArgs.qD(3, this.chatroom_sys.computeSize());
        this.chatroom_sys.writeFields(paramVarArgs);
      }
      if (this.chatroom_notice != null)
      {
        paramVarArgs.qD(4, this.chatroom_notice.computeSize());
        this.chatroom_notice.writeFields(paramVarArgs);
      }
      if (this.chatroom_emoji != null)
      {
        paramVarArgs.qD(5, this.chatroom_emoji.computeSize());
        this.chatroom_emoji.writeFields(paramVarArgs);
      }
      if (this.chatroom_img_link != null)
      {
        paramVarArgs.qD(6, this.chatroom_img_link.computeSize());
        this.chatroom_img_link.writeFields(paramVarArgs);
      }
      if (this.chatroom_share_link != null)
      {
        paramVarArgs.qD(8, this.chatroom_share_link.computeSize());
        this.chatroom_share_link.writeFields(paramVarArgs);
      }
      if (this.chatroom_img_card != null)
      {
        paramVarArgs.qD(9, this.chatroom_img_card.computeSize());
        this.chatroom_img_card.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.chatroom_app == null) {
        break label1348;
      }
    }
    label1348:
    for (int i = i.a.a.a.qC(1, this.chatroom_app.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.chatroom_tpl != null) {
        paramInt = i + i.a.a.a.qC(2, this.chatroom_tpl.computeSize());
      }
      i = paramInt;
      if (this.chatroom_text != null) {
        i = paramInt + i.a.a.a.qC(7, this.chatroom_text.computeSize());
      }
      paramInt = i;
      if (this.chatroom_sys != null) {
        paramInt = i + i.a.a.a.qC(3, this.chatroom_sys.computeSize());
      }
      i = paramInt;
      if (this.chatroom_notice != null) {
        i = paramInt + i.a.a.a.qC(4, this.chatroom_notice.computeSize());
      }
      paramInt = i;
      if (this.chatroom_emoji != null) {
        paramInt = i + i.a.a.a.qC(5, this.chatroom_emoji.computeSize());
      }
      i = paramInt;
      if (this.chatroom_img_link != null) {
        i = paramInt + i.a.a.a.qC(6, this.chatroom_img_link.computeSize());
      }
      paramInt = i;
      if (this.chatroom_share_link != null) {
        paramInt = i + i.a.a.a.qC(8, this.chatroom_share_link.computeSize());
      }
      i = paramInt;
      if (this.chatroom_img_card != null) {
        i = paramInt + i.a.a.a.qC(9, this.chatroom_img_card.computeSize());
      }
      AppMethodBeat.o(275510);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        MsgContent localMsgContent = (MsgContent)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275510);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomMsgApp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomMsgApp)localObject2).parseFrom((byte[])localObject1);
            }
            localMsgContent.chatroom_app = ((ChatroomMsgApp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275510);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomMsgTpl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomMsgTpl)localObject2).parseFrom((byte[])localObject1);
            }
            localMsgContent.chatroom_tpl = ((ChatroomMsgTpl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275510);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomMsgText();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomMsgText)localObject2).parseFrom((byte[])localObject1);
            }
            localMsgContent.chatroom_text = ((ChatroomMsgText)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275510);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomMsgSys();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomMsgSys)localObject2).parseFrom((byte[])localObject1);
            }
            localMsgContent.chatroom_sys = ((ChatroomMsgSys)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275510);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomMsgNotice();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomMsgNotice)localObject2).parseFrom((byte[])localObject1);
            }
            localMsgContent.chatroom_notice = ((ChatroomMsgNotice)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275510);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomMsgEmoji();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomMsgEmoji)localObject2).parseFrom((byte[])localObject1);
            }
            localMsgContent.chatroom_emoji = ((ChatroomMsgEmoji)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275510);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomMsgImgLink();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomMsgImgLink)localObject2).parseFrom((byte[])localObject1);
            }
            localMsgContent.chatroom_img_link = ((ChatroomMsgImgLink)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275510);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomMsgShareLink();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomMsgShareLink)localObject2).parseFrom((byte[])localObject1);
            }
            localMsgContent.chatroom_share_link = ((ChatroomMsgShareLink)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275510);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ChatroomMsgImgCard();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ChatroomMsgImgCard)localObject2).parseFrom((byte[])localObject1);
          }
          localMsgContent.chatroom_img_card = ((ChatroomMsgImgCard)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275510);
        return 0;
      }
      AppMethodBeat.o(275510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.MsgContent
 * JD-Core Version:    0.7.0.1
 */