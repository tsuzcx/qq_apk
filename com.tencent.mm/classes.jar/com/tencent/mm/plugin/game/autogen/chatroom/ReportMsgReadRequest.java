package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public class ReportMsgReadRequest
  extends erp
{
  public String chatroom_name;
  public LinkedList<Long> read_seq_list;
  
  public ReportMsgReadRequest()
  {
    AppMethodBeat.i(275537);
    this.read_seq_list = new LinkedList();
    AppMethodBeat.o(275537);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275546);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(275546);
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
      paramVarArgs.e(3, 3, this.read_seq_list);
      AppMethodBeat.o(275546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label455;
      }
    }
    label455:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.chatroom_name != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.chatroom_name);
      }
      paramInt = i.a.a.a.c(3, 3, this.read_seq_list);
      AppMethodBeat.o(275546);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.read_seq_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.chatroom_name == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroom_name");
          AppMethodBeat.o(275546);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275546);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ReportMsgReadRequest localReportMsgReadRequest = (ReportMsgReadRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275546);
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
            localReportMsgReadRequest.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(275546);
          return 0;
        case 2: 
          localReportMsgReadRequest.chatroom_name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275546);
          return 0;
        }
        localReportMsgReadRequest.read_seq_list.add(Long.valueOf(((i.a.a.a.a)localObject).ajGk.aaw()));
        AppMethodBeat.o(275546);
        return 0;
      }
      AppMethodBeat.o(275546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ReportMsgReadRequest
 * JD-Core Version:    0.7.0.1
 */