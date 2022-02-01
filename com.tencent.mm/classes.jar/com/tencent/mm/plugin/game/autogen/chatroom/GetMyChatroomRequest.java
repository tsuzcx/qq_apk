package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public class GetMyChatroomRequest
  extends dyl
{
  public LinkedList<String> chatroom_name_list;
  public String first_chatroom_name;
  public String version;
  
  public GetMyChatroomRequest()
  {
    AppMethodBeat.i(194949);
    this.chatroom_name_list = new LinkedList();
    AppMethodBeat.o(194949);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194957);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.version != null) {
        paramVarArgs.f(2, this.version);
      }
      paramVarArgs.e(3, 1, this.chatroom_name_list);
      if (this.first_chatroom_name != null) {
        paramVarArgs.f(4, this.first_chatroom_name);
      }
      AppMethodBeat.o(194957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label468;
      }
    }
    label468:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.version != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.version);
      }
      i += g.a.a.a.c(3, 1, this.chatroom_name_list);
      paramInt = i;
      if (this.first_chatroom_name != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.first_chatroom_name);
      }
      AppMethodBeat.o(194957);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.chatroom_name_list.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194957);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        GetMyChatroomRequest localGetMyChatroomRequest = (GetMyChatroomRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194957);
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
            localGetMyChatroomRequest.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(194957);
          return 0;
        case 2: 
          localGetMyChatroomRequest.version = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(194957);
          return 0;
        case 3: 
          localGetMyChatroomRequest.chatroom_name_list.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(194957);
          return 0;
        }
        localGetMyChatroomRequest.first_chatroom_name = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(194957);
        return 0;
      }
      AppMethodBeat.o(194957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomRequest
 * JD-Core Version:    0.7.0.1
 */