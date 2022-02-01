package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public class JoinChatroomResponse
  extends dyy
{
  public JumpInfo create_account_jump_info;
  public String errmsg;
  public boolean need_jump_create_account;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195186);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.errmsg != null) {
        paramVarArgs.f(2, this.errmsg);
      }
      paramVarArgs.co(3, this.need_jump_create_account);
      if (this.create_account_jump_info != null)
      {
        paramVarArgs.oE(4, this.create_account_jump_info.computeSize());
        this.create_account_jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195186);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.errmsg != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.errmsg);
      }
      i += g.a.a.b.b.a.gL(3) + 1;
      paramInt = i;
      if (this.create_account_jump_info != null) {
        paramInt = i + g.a.a.a.oD(4, this.create_account_jump_info.computeSize());
      }
      AppMethodBeat.o(195186);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195186);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        JoinChatroomResponse localJoinChatroomResponse = (JoinChatroomResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195186);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localJoinChatroomResponse.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(195186);
          return 0;
        case 2: 
          localJoinChatroomResponse.errmsg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(195186);
          return 0;
        case 3: 
          localJoinChatroomResponse.need_jump_create_account = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(195186);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new JumpInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((JumpInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localJoinChatroomResponse.create_account_jump_info = ((JumpInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(195186);
        return 0;
      }
      AppMethodBeat.o(195186);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.JoinChatroomResponse
 * JD-Core Version:    0.7.0.1
 */