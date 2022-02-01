package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public class ReportMsgReadRequest
  extends dyl
{
  public String chatroom_name;
  public LinkedList<Long> read_seq_list;
  
  public ReportMsgReadRequest()
  {
    AppMethodBeat.i(195638);
    this.read_seq_list = new LinkedList();
    AppMethodBeat.o(195638);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195642);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(195642);
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
      paramVarArgs.e(3, 3, this.read_seq_list);
      AppMethodBeat.o(195642);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label459;
      }
    }
    label459:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.chatroom_name != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.chatroom_name);
      }
      paramInt = g.a.a.a.c(3, 3, this.read_seq_list);
      AppMethodBeat.o(195642);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.read_seq_list.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.chatroom_name == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroom_name");
          AppMethodBeat.o(195642);
          throw paramVarArgs;
        }
        AppMethodBeat.o(195642);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ReportMsgReadRequest localReportMsgReadRequest = (ReportMsgReadRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195642);
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
            localReportMsgReadRequest.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(195642);
          return 0;
        case 2: 
          localReportMsgReadRequest.chatroom_name = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195642);
          return 0;
        }
        localReportMsgReadRequest.read_seq_list.add(Long.valueOf(((g.a.a.a.a)localObject).abFh.AN()));
        AppMethodBeat.o(195642);
        return 0;
      }
      AppMethodBeat.o(195642);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ReportMsgReadRequest
 * JD-Core Version:    0.7.0.1
 */