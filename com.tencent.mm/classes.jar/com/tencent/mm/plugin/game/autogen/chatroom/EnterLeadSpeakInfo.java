package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class EnterLeadSpeakInfo
  extends com.tencent.mm.bx.a
{
  public int disappear_second;
  public String jump_wording;
  public String lead_speak_wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275611);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.jump_wording != null) {
        paramVarArgs.g(1, this.jump_wording);
      }
      if (this.lead_speak_wording != null) {
        paramVarArgs.g(2, this.lead_speak_wording);
      }
      paramVarArgs.bS(3, this.disappear_second);
      AppMethodBeat.o(275611);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jump_wording == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.jump_wording) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lead_speak_wording != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.lead_speak_wording);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.disappear_second);
      AppMethodBeat.o(275611);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275611);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        EnterLeadSpeakInfo localEnterLeadSpeakInfo = (EnterLeadSpeakInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275611);
          return -1;
        case 1: 
          localEnterLeadSpeakInfo.jump_wording = locala.ajGk.readString();
          AppMethodBeat.o(275611);
          return 0;
        case 2: 
          localEnterLeadSpeakInfo.lead_speak_wording = locala.ajGk.readString();
          AppMethodBeat.o(275611);
          return 0;
        }
        localEnterLeadSpeakInfo.disappear_second = locala.ajGk.aar();
        AppMethodBeat.o(275611);
        return 0;
      }
      AppMethodBeat.o(275611);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.EnterLeadSpeakInfo
 * JD-Core Version:    0.7.0.1
 */