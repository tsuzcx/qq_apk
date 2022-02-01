package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public class UserConfirmStatusRequest
  extends dyl
{
  public String chatroom_name;
  public int confirm_status;
  public long notification_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195156);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(195156);
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
      paramVarArgs.aY(3, this.confirm_status);
      paramVarArgs.bm(4, this.notification_id);
      AppMethodBeat.o(195156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label488;
      }
    }
    label488:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.chatroom_name != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.chatroom_name);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.confirm_status);
      int j = g.a.a.b.b.a.p(4, this.notification_id);
      AppMethodBeat.o(195156);
      return i + paramInt + j;
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
          AppMethodBeat.o(195156);
          throw paramVarArgs;
        }
        AppMethodBeat.o(195156);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        UserConfirmStatusRequest localUserConfirmStatusRequest = (UserConfirmStatusRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195156);
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
            localUserConfirmStatusRequest.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(195156);
          return 0;
        case 2: 
          localUserConfirmStatusRequest.chatroom_name = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195156);
          return 0;
        case 3: 
          localUserConfirmStatusRequest.confirm_status = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(195156);
          return 0;
        }
        localUserConfirmStatusRequest.notification_id = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(195156);
        return 0;
      }
      AppMethodBeat.o(195156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.UserConfirmStatusRequest
 * JD-Core Version:    0.7.0.1
 */