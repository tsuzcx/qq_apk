package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class MsgBaseInfo
  extends com.tencent.mm.bx.a
{
  public long chatroom_first_seq;
  public EnterLeadSpeakInfo enter_lead_speak_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275610);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.chatroom_first_seq);
      if (this.enter_lead_speak_info != null)
      {
        paramVarArgs.qD(2, this.enter_lead_speak_info.computeSize());
        this.enter_lead_speak_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275610);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.chatroom_first_seq) + 0;
      paramInt = i;
      if (this.enter_lead_speak_info != null) {
        paramInt = i + i.a.a.a.qC(2, this.enter_lead_speak_info.computeSize());
      }
      AppMethodBeat.o(275610);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275610);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      MsgBaseInfo localMsgBaseInfo = (MsgBaseInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275610);
        return -1;
      case 1: 
        localMsgBaseInfo.chatroom_first_seq = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(275610);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        EnterLeadSpeakInfo localEnterLeadSpeakInfo = new EnterLeadSpeakInfo();
        if ((localObject != null) && (localObject.length > 0)) {
          localEnterLeadSpeakInfo.parseFrom((byte[])localObject);
        }
        localMsgBaseInfo.enter_lead_speak_info = localEnterLeadSpeakInfo;
        paramInt += 1;
      }
      AppMethodBeat.o(275610);
      return 0;
    }
    AppMethodBeat.o(275610);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.MsgBaseInfo
 * JD-Core Version:    0.7.0.1
 */