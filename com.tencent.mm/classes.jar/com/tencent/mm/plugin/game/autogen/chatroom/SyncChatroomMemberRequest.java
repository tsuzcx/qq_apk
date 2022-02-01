package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public class SyncChatroomMemberRequest
  extends erp
{
  public String chatroom_name;
  public String last_version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275495);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(275495);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.last_version != null) {
        paramVarArgs.g(2, this.last_version);
      }
      if (this.chatroom_name != null) {
        paramVarArgs.g(3, this.chatroom_name);
      }
      AppMethodBeat.o(275495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label452;
      }
    }
    label452:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.last_version != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.last_version);
      }
      i = paramInt;
      if (this.chatroom_name != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.chatroom_name);
      }
      AppMethodBeat.o(275495);
      return i;
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
          AppMethodBeat.o(275495);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275495);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        SyncChatroomMemberRequest localSyncChatroomMemberRequest = (SyncChatroomMemberRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275495);
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
            localSyncChatroomMemberRequest.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(275495);
          return 0;
        case 2: 
          localSyncChatroomMemberRequest.last_version = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275495);
          return 0;
        }
        localSyncChatroomMemberRequest.chatroom_name = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(275495);
        return 0;
      }
      AppMethodBeat.o(275495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.SyncChatroomMemberRequest
 * JD-Core Version:    0.7.0.1
 */