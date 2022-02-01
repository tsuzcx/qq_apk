package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public class GetChatroomRealtimeInfoRequest
  extends dyl
{
  public String chatroom_name;
  public String version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195418);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(195418);
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
      if (this.version != null) {
        paramVarArgs.f(3, this.version);
      }
      AppMethodBeat.o(195418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label456;
      }
    }
    label456:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.chatroom_name != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.chatroom_name);
      }
      i = paramInt;
      if (this.version != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.version);
      }
      AppMethodBeat.o(195418);
      return i;
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
          AppMethodBeat.o(195418);
          throw paramVarArgs;
        }
        AppMethodBeat.o(195418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        GetChatroomRealtimeInfoRequest localGetChatroomRealtimeInfoRequest = (GetChatroomRealtimeInfoRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195418);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localGetChatroomRealtimeInfoRequest.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(195418);
          return 0;
        case 2: 
          localGetChatroomRealtimeInfoRequest.chatroom_name = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195418);
          return 0;
        }
        localGetChatroomRealtimeInfoRequest.version = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(195418);
        return 0;
      }
      AppMethodBeat.o(195418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomRealtimeInfoRequest
 * JD-Core Version:    0.7.0.1
 */