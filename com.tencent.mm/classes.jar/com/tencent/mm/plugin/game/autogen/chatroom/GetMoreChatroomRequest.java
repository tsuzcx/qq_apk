package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public class GetMoreChatroomRequest
  extends dyl
{
  public String chatroom_filter;
  public Lbs lbs_info;
  public int limit;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195612);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.chatroom_filter != null) {
        paramVarArgs.f(2, this.chatroom_filter);
      }
      if (this.lbs_info != null)
      {
        paramVarArgs.oE(3, this.lbs_info.computeSize());
        this.lbs_info.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.limit);
      AppMethodBeat.o(195612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.chatroom_filter != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.chatroom_filter);
      }
      i = paramInt;
      if (this.lbs_info != null) {
        i = paramInt + g.a.a.a.oD(3, this.lbs_info.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(4, this.limit);
      AppMethodBeat.o(195612);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195612);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        GetMoreChatroomRequest localGetMoreChatroomRequest = (GetMoreChatroomRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195612);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localGetMoreChatroomRequest.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(195612);
          return 0;
        case 2: 
          localGetMoreChatroomRequest.chatroom_filter = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(195612);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195612);
          return 0;
        }
        localGetMoreChatroomRequest.limit = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(195612);
        return 0;
      }
      AppMethodBeat.o(195612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetMoreChatroomRequest
 * JD-Core Version:    0.7.0.1
 */