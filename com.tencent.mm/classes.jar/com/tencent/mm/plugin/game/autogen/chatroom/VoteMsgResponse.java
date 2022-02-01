package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public class VoteMsgResponse
  extends esc
{
  public JumpInfo education_jump_info;
  public String report_ext_info;
  public VoteInfo vote_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275488);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.vote_info != null)
      {
        paramVarArgs.qD(2, this.vote_info.computeSize());
        this.vote_info.writeFields(paramVarArgs);
      }
      if (this.education_jump_info != null)
      {
        paramVarArgs.qD(3, this.education_jump_info.computeSize());
        this.education_jump_info.writeFields(paramVarArgs);
      }
      if (this.report_ext_info != null) {
        paramVarArgs.g(4, this.report_ext_info);
      }
      AppMethodBeat.o(275488);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label608;
      }
    }
    label608:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vote_info != null) {
        paramInt = i + i.a.a.a.qC(2, this.vote_info.computeSize());
      }
      i = paramInt;
      if (this.education_jump_info != null) {
        i = paramInt + i.a.a.a.qC(3, this.education_jump_info.computeSize());
      }
      paramInt = i;
      if (this.report_ext_info != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.report_ext_info);
      }
      AppMethodBeat.o(275488);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275488);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        VoteMsgResponse localVoteMsgResponse = (VoteMsgResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275488);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localVoteMsgResponse.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275488);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new VoteInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((VoteInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localVoteMsgResponse.vote_info = ((VoteInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275488);
          return 0;
        case 3: 
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
            localVoteMsgResponse.education_jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275488);
          return 0;
        }
        localVoteMsgResponse.report_ext_info = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275488);
        return 0;
      }
      AppMethodBeat.o(275488);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.VoteMsgResponse
 * JD-Core Version:    0.7.0.1
 */