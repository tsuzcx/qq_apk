package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public class GetMoreChatroomRequest
  extends erp
{
  public String chatroom_filter;
  public Lbs lbs_info;
  public int limit;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275526);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.chatroom_filter != null) {
        paramVarArgs.g(2, this.chatroom_filter);
      }
      if (this.lbs_info != null)
      {
        paramVarArgs.qD(3, this.lbs_info.computeSize());
        this.lbs_info.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.limit);
      AppMethodBeat.o(275526);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.chatroom_filter != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.chatroom_filter);
      }
      i = paramInt;
      if (this.lbs_info != null) {
        i = paramInt + i.a.a.a.qC(3, this.lbs_info.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.limit);
      AppMethodBeat.o(275526);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275526);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        GetMoreChatroomRequest localGetMoreChatroomRequest = (GetMoreChatroomRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275526);
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
            localGetMoreChatroomRequest.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275526);
          return 0;
        case 2: 
          localGetMoreChatroomRequest.chatroom_filter = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275526);
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
            localGetMoreChatroomRequest.lbs_info = ((Lbs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275526);
          return 0;
        }
        localGetMoreChatroomRequest.limit = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(275526);
        return 0;
      }
      AppMethodBeat.o(275526);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetMoreChatroomRequest
 * JD-Core Version:    0.7.0.1
 */