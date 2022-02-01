package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class MsgContent
  extends com.tencent.mm.cd.a
{
  public ChatroomMsgApp chatroom_app;
  public ChatroomMsgNotice chatroom_notice;
  public ChatroomMsgSys chatroom_sys;
  public ChatroomMsgText chatroom_text;
  public ChatroomMsgTpl chatroom_tpl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195244);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_app != null)
      {
        paramVarArgs.oE(1, this.chatroom_app.computeSize());
        this.chatroom_app.writeFields(paramVarArgs);
      }
      if (this.chatroom_tpl != null)
      {
        paramVarArgs.oE(2, this.chatroom_tpl.computeSize());
        this.chatroom_tpl.writeFields(paramVarArgs);
      }
      if (this.chatroom_text != null)
      {
        paramVarArgs.oE(7, this.chatroom_text.computeSize());
        this.chatroom_text.writeFields(paramVarArgs);
      }
      if (this.chatroom_sys != null)
      {
        paramVarArgs.oE(3, this.chatroom_sys.computeSize());
        this.chatroom_sys.writeFields(paramVarArgs);
      }
      if (this.chatroom_notice != null)
      {
        paramVarArgs.oE(4, this.chatroom_notice.computeSize());
        this.chatroom_notice.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.chatroom_app == null) {
        break label828;
      }
    }
    label828:
    for (int i = g.a.a.a.oD(1, this.chatroom_app.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.chatroom_tpl != null) {
        paramInt = i + g.a.a.a.oD(2, this.chatroom_tpl.computeSize());
      }
      i = paramInt;
      if (this.chatroom_text != null) {
        i = paramInt + g.a.a.a.oD(7, this.chatroom_text.computeSize());
      }
      paramInt = i;
      if (this.chatroom_sys != null) {
        paramInt = i + g.a.a.a.oD(3, this.chatroom_sys.computeSize());
      }
      i = paramInt;
      if (this.chatroom_notice != null) {
        i = paramInt + g.a.a.a.oD(4, this.chatroom_notice.computeSize());
      }
      AppMethodBeat.o(195244);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        MsgContent localMsgContent = (MsgContent)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(195244);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195244);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195244);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195244);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195244);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
        AppMethodBeat.o(195244);
        return 0;
      }
      AppMethodBeat.o(195244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.MsgContent
 * JD-Core Version:    0.7.0.1
 */