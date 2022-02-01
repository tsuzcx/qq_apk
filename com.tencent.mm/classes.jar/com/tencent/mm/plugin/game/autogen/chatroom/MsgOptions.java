package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public class MsgOptions
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> at_list;
  public b cli_local_data;
  public String complaint_url;
  public int msg_biz_type;
  
  public MsgOptions()
  {
    AppMethodBeat.i(195290);
    this.at_list = new LinkedList();
    AppMethodBeat.o(195290);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195296);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.at_list);
      if (this.complaint_url != null) {
        paramVarArgs.f(2, this.complaint_url);
      }
      if (this.cli_local_data != null) {
        paramVarArgs.c(3, this.cli_local_data);
      }
      paramVarArgs.aY(4, this.msg_biz_type);
      AppMethodBeat.o(195296);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.a.c(1, 1, this.at_list) + 0;
      paramInt = i;
      if (this.complaint_url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.complaint_url);
      }
      i = paramInt;
      if (this.cli_local_data != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.cli_local_data);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.msg_biz_type);
      AppMethodBeat.o(195296);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.at_list.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(195296);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      MsgOptions localMsgOptions = (MsgOptions)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195296);
        return -1;
      case 1: 
        localMsgOptions.at_list.add(locala.abFh.readString());
        AppMethodBeat.o(195296);
        return 0;
      case 2: 
        localMsgOptions.complaint_url = locala.abFh.readString();
        AppMethodBeat.o(195296);
        return 0;
      case 3: 
        localMsgOptions.cli_local_data = locala.abFh.iUw();
        AppMethodBeat.o(195296);
        return 0;
      }
      localMsgOptions.msg_biz_type = locala.abFh.AK();
      AppMethodBeat.o(195296);
      return 0;
    }
    AppMethodBeat.o(195296);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.MsgOptions
 * JD-Core Version:    0.7.0.1
 */