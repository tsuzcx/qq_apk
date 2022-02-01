package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public class GetChatroomBaseInfoRequest
  extends erp
{
  public String chatroom_name;
  public DebugOption debug_option;
  public ExportExternInfo export_extern_info;
  public Lbs lbs_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275551);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(275551);
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
      if (this.lbs_info != null)
      {
        paramVarArgs.qD(3, this.lbs_info.computeSize());
        this.lbs_info.writeFields(paramVarArgs);
      }
      if (this.export_extern_info != null)
      {
        paramVarArgs.qD(4, this.export_extern_info.computeSize());
        this.export_extern_info.writeFields(paramVarArgs);
      }
      if (this.debug_option != null)
      {
        paramVarArgs.qD(5, this.debug_option.computeSize());
        this.debug_option.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label790;
      }
    }
    label790:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.chatroom_name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.chatroom_name);
      }
      i = paramInt;
      if (this.lbs_info != null) {
        i = paramInt + i.a.a.a.qC(3, this.lbs_info.computeSize());
      }
      paramInt = i;
      if (this.export_extern_info != null) {
        paramInt = i + i.a.a.a.qC(4, this.export_extern_info.computeSize());
      }
      i = paramInt;
      if (this.debug_option != null) {
        i = paramInt + i.a.a.a.qC(5, this.debug_option.computeSize());
      }
      AppMethodBeat.o(275551);
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
          AppMethodBeat.o(275551);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        GetChatroomBaseInfoRequest localGetChatroomBaseInfoRequest = (GetChatroomBaseInfoRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275551);
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
            localGetChatroomBaseInfoRequest.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275551);
          return 0;
        case 2: 
          localGetChatroomBaseInfoRequest.chatroom_name = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275551);
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
            localGetChatroomBaseInfoRequest.lbs_info = ((Lbs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275551);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ExportExternInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ExportExternInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomBaseInfoRequest.export_extern_info = ((ExportExternInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275551);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new DebugOption();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((DebugOption)localObject2).parseFrom((byte[])localObject1);
          }
          localGetChatroomBaseInfoRequest.debug_option = ((DebugOption)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275551);
        return 0;
      }
      AppMethodBeat.o(275551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomBaseInfoRequest
 * JD-Core Version:    0.7.0.1
 */