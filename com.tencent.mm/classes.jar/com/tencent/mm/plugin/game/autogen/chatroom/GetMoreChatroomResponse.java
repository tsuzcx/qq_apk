package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public class GetMoreChatroomResponse
  extends dyy
{
  public LinkedList<BanAction> ban_action_list;
  public String chatroom_filter;
  public LinkedList<ChatroomRecInfo> chatroom_info_list;
  public boolean has_next;
  
  public GetMoreChatroomResponse()
  {
    AppMethodBeat.i(194873);
    this.chatroom_info_list = new LinkedList();
    this.ban_action_list = new LinkedList();
    AppMethodBeat.o(194873);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194882);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.chatroom_info_list);
      paramVarArgs.co(3, this.has_next);
      if (this.chatroom_filter != null) {
        paramVarArgs.f(4, this.chatroom_filter);
      }
      paramVarArgs.e(5, 8, this.ban_action_list);
      AppMethodBeat.o(194882);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.chatroom_info_list) + (g.a.a.b.b.a.gL(3) + 1);
      paramInt = i;
      if (this.chatroom_filter != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.chatroom_filter);
      }
      i = g.a.a.a.c(5, 8, this.ban_action_list);
      AppMethodBeat.o(194882);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.chatroom_info_list.clear();
        this.ban_action_list.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194882);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        GetMoreChatroomResponse localGetMoreChatroomResponse = (GetMoreChatroomResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194882);
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
            localGetMoreChatroomResponse.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194882);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomRecInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomRecInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetMoreChatroomResponse.chatroom_info_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194882);
          return 0;
        case 3: 
          localGetMoreChatroomResponse.has_next = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(194882);
          return 0;
        case 4: 
          localGetMoreChatroomResponse.chatroom_filter = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194882);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new BanAction();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((BanAction)localObject2).parseFrom((byte[])localObject1);
          }
          localGetMoreChatroomResponse.ban_action_list.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(194882);
        return 0;
      }
      AppMethodBeat.o(194882);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetMoreChatroomResponse
 * JD-Core Version:    0.7.0.1
 */