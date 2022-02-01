package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public class GetMyChatroomRequest
  extends erp
{
  public LinkedList<String> chatroom_name_list;
  public String first_chatroom_name;
  public int scene_type;
  public String version;
  
  public GetMyChatroomRequest()
  {
    AppMethodBeat.i(275479);
    this.chatroom_name_list = new LinkedList();
    AppMethodBeat.o(275479);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275490);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.version != null) {
        paramVarArgs.g(2, this.version);
      }
      paramVarArgs.e(3, 1, this.chatroom_name_list);
      if (this.first_chatroom_name != null) {
        paramVarArgs.g(4, this.first_chatroom_name);
      }
      paramVarArgs.bS(5, this.scene_type);
      AppMethodBeat.o(275490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label508;
      }
    }
    label508:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.version != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.version);
      }
      i += i.a.a.a.c(3, 1, this.chatroom_name_list);
      paramInt = i;
      if (this.first_chatroom_name != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.first_chatroom_name);
      }
      i = i.a.a.b.b.a.cJ(5, this.scene_type);
      AppMethodBeat.o(275490);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.chatroom_name_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        GetMyChatroomRequest localGetMyChatroomRequest = (GetMyChatroomRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275490);
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
            localGetMyChatroomRequest.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(275490);
          return 0;
        case 2: 
          localGetMyChatroomRequest.version = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275490);
          return 0;
        case 3: 
          localGetMyChatroomRequest.chatroom_name_list.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(275490);
          return 0;
        case 4: 
          localGetMyChatroomRequest.first_chatroom_name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275490);
          return 0;
        }
        localGetMyChatroomRequest.scene_type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(275490);
        return 0;
      }
      AppMethodBeat.o(275490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomRequest
 * JD-Core Version:    0.7.0.1
 */