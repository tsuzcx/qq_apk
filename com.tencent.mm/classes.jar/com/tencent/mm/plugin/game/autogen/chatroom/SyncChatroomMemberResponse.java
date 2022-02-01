package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public class SyncChatroomMemberResponse
  extends esc
{
  public LinkedList<String> member_username_list;
  public String next_version;
  
  public SyncChatroomMemberResponse()
  {
    AppMethodBeat.i(275530);
    this.member_username_list = new LinkedList();
    AppMethodBeat.o(275530);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275535);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.next_version != null) {
        paramVarArgs.g(2, this.next_version);
      }
      paramVarArgs.e(3, 1, this.member_username_list);
      AppMethodBeat.o(275535);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label404;
      }
    }
    label404:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.next_version != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.next_version);
      }
      paramInt = i.a.a.a.c(3, 1, this.member_username_list);
      AppMethodBeat.o(275535);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.member_username_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275535);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        SyncChatroomMemberResponse localSyncChatroomMemberResponse = (SyncChatroomMemberResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275535);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localSyncChatroomMemberResponse.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(275535);
          return 0;
        case 2: 
          localSyncChatroomMemberResponse.next_version = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275535);
          return 0;
        }
        localSyncChatroomMemberResponse.member_username_list.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(275535);
        return 0;
      }
      AppMethodBeat.o(275535);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.SyncChatroomMemberResponse
 * JD-Core Version:    0.7.0.1
 */