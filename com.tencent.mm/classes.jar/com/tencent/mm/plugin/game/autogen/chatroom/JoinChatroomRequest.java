package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public class JoinChatroomRequest
  extends dyl
{
  public String chatroom_name;
  public ExportExternInfo extern_info;
  public Lbs lbs_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194908);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(194908);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.chatroom_name != null) {
        paramVarArgs.f(2, this.chatroom_name);
      }
      if (this.lbs_info != null)
      {
        paramVarArgs.oE(3, this.lbs_info.computeSize());
        this.lbs_info.writeFields(paramVarArgs);
      }
      if (this.extern_info != null)
      {
        paramVarArgs.oE(4, this.extern_info.computeSize());
        this.extern_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194908);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label660;
      }
    }
    label660:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.chatroom_name != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.chatroom_name);
      }
      i = paramInt;
      if (this.lbs_info != null) {
        i = paramInt + g.a.a.a.oD(3, this.lbs_info.computeSize());
      }
      paramInt = i;
      if (this.extern_info != null) {
        paramInt = i + g.a.a.a.oD(4, this.extern_info.computeSize());
      }
      AppMethodBeat.o(194908);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.chatroom_name == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroom_name");
          AppMethodBeat.o(194908);
          throw paramVarArgs;
        }
        AppMethodBeat.o(194908);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        JoinChatroomRequest localJoinChatroomRequest = (JoinChatroomRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194908);
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
            localJoinChatroomRequest.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194908);
          return 0;
        case 2: 
          localJoinChatroomRequest.chatroom_name = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194908);
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
            localJoinChatroomRequest.lbs_info = ((Lbs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194908);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ExportExternInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ExportExternInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localJoinChatroomRequest.extern_info = ((ExportExternInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(194908);
        return 0;
      }
      AppMethodBeat.o(194908);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.JoinChatroomRequest
 * JD-Core Version:    0.7.0.1
 */