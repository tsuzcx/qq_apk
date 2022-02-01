package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public class JoinChatroomRequest
  extends erp
{
  public String chatroom_name;
  public ExportExternInfo extern_info;
  public Lbs lbs_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275540);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(275540);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.chatroom_name != null) {
        paramVarArgs.g(2, this.chatroom_name);
      }
      if (this.lbs_info != null)
      {
        paramVarArgs.qD(3, this.lbs_info.computeSize());
        this.lbs_info.writeFields(paramVarArgs);
      }
      if (this.extern_info != null)
      {
        paramVarArgs.qD(4, this.extern_info.computeSize());
        this.extern_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label656;
      }
    }
    label656:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.chatroom_name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.chatroom_name);
      }
      i = paramInt;
      if (this.lbs_info != null) {
        i = paramInt + i.a.a.a.qC(3, this.lbs_info.computeSize());
      }
      paramInt = i;
      if (this.extern_info != null) {
        paramInt = i + i.a.a.a.qC(4, this.extern_info.computeSize());
      }
      AppMethodBeat.o(275540);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.chatroom_name == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroom_name");
          AppMethodBeat.o(275540);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275540);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        JoinChatroomRequest localJoinChatroomRequest = (JoinChatroomRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275540);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localJoinChatroomRequest.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275540);
          return 0;
        case 2: 
          localJoinChatroomRequest.chatroom_name = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275540);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new Lbs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((Lbs)localObject2).parseFrom((byte[])localObject1);
            }
            localJoinChatroomRequest.lbs_info = ((Lbs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275540);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ExportExternInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ExportExternInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localJoinChatroomRequest.extern_info = ((ExportExternInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275540);
        return 0;
      }
      AppMethodBeat.o(275540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.JoinChatroomRequest
 * JD-Core Version:    0.7.0.1
 */