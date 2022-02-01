package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public class GetMyChatroomResponse
  extends dyy
{
  public LinkedList<MyChatroomInfo> my_chatroom_info_list;
  public String next_version;
  
  public GetMyChatroomResponse()
  {
    AppMethodBeat.i(194827);
    this.my_chatroom_info_list = new LinkedList();
    AppMethodBeat.o(194827);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194843);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.next_version != null) {
        paramVarArgs.f(2, this.next_version);
      }
      paramVarArgs.e(3, 8, this.my_chatroom_info_list);
      AppMethodBeat.o(194843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.next_version != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.next_version);
      }
      paramInt = g.a.a.a.c(3, 8, this.my_chatroom_info_list);
      AppMethodBeat.o(194843);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.my_chatroom_info_list.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        GetMyChatroomResponse localGetMyChatroomResponse = (GetMyChatroomResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194843);
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
            localGetMyChatroomResponse.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194843);
          return 0;
        case 2: 
          localGetMyChatroomResponse.next_version = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194843);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new MyChatroomInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((MyChatroomInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localGetMyChatroomResponse.my_chatroom_info_list.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(194843);
        return 0;
      }
      AppMethodBeat.o(194843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomResponse
 * JD-Core Version:    0.7.0.1
 */