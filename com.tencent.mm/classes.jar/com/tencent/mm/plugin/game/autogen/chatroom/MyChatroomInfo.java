package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class MyChatroomInfo
  extends com.tencent.mm.bx.a
{
  public AbstractInfo abstract_info;
  public AtInfo at_info;
  public ChatroomRecInfo chatroom_info;
  public String last_msg_desc;
  public long unread_msg_count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275563);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_info == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_info");
        AppMethodBeat.o(275563);
        throw paramVarArgs;
      }
      if (this.chatroom_info != null)
      {
        paramVarArgs.qD(1, this.chatroom_info.computeSize());
        this.chatroom_info.writeFields(paramVarArgs);
      }
      if (this.at_info != null)
      {
        paramVarArgs.qD(2, this.at_info.computeSize());
        this.at_info.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(3, this.unread_msg_count);
      if (this.abstract_info != null)
      {
        paramVarArgs.qD(4, this.abstract_info.computeSize());
        this.abstract_info.writeFields(paramVarArgs);
      }
      if (this.last_msg_desc != null) {
        paramVarArgs.g(5, this.last_msg_desc);
      }
      AppMethodBeat.o(275563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.chatroom_info == null) {
        break label700;
      }
    }
    label700:
    for (paramInt = i.a.a.a.qC(1, this.chatroom_info.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.at_info != null) {
        i = paramInt + i.a.a.a.qC(2, this.at_info.computeSize());
      }
      i += i.a.a.b.b.a.q(3, this.unread_msg_count);
      paramInt = i;
      if (this.abstract_info != null) {
        paramInt = i + i.a.a.a.qC(4, this.abstract_info.computeSize());
      }
      i = paramInt;
      if (this.last_msg_desc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.last_msg_desc);
      }
      AppMethodBeat.o(275563);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.chatroom_info == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroom_info");
          AppMethodBeat.o(275563);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275563);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        MyChatroomInfo localMyChatroomInfo = (MyChatroomInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275563);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomRecInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomRecInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localMyChatroomInfo.chatroom_info = ((ChatroomRecInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275563);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new AtInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((AtInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localMyChatroomInfo.at_info = ((AtInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275563);
          return 0;
        case 3: 
          localMyChatroomInfo.unread_msg_count = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(275563);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new AbstractInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((AbstractInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localMyChatroomInfo.abstract_info = ((AbstractInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275563);
          return 0;
        }
        localMyChatroomInfo.last_msg_desc = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275563);
        return 0;
      }
      AppMethodBeat.o(275563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.MyChatroomInfo
 * JD-Core Version:    0.7.0.1
 */