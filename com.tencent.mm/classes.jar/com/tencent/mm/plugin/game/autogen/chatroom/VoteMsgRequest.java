package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public class VoteMsgRequest
  extends erp
{
  public String chatroom_name;
  public boolean is_vote;
  public boolean need_education;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275508);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(275508);
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
      paramVarArgs.bv(3, this.seq);
      paramVarArgs.di(4, this.is_vote);
      paramVarArgs.di(5, this.need_education);
      AppMethodBeat.o(275508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label524;
      }
    }
    label524:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.chatroom_name != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.chatroom_name);
      }
      paramInt = i.a.a.b.b.a.q(3, this.seq);
      int j = i.a.a.b.b.a.ko(4);
      int k = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(275508);
      return i + paramInt + (j + 1) + (k + 1);
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
          AppMethodBeat.o(275508);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275508);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        VoteMsgRequest localVoteMsgRequest = (VoteMsgRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275508);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localVoteMsgRequest.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(275508);
          return 0;
        case 2: 
          localVoteMsgRequest.chatroom_name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275508);
          return 0;
        case 3: 
          localVoteMsgRequest.seq = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(275508);
          return 0;
        case 4: 
          localVoteMsgRequest.is_vote = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(275508);
          return 0;
        }
        localVoteMsgRequest.need_education = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(275508);
        return 0;
      }
      AppMethodBeat.o(275508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.VoteMsgRequest
 * JD-Core Version:    0.7.0.1
 */