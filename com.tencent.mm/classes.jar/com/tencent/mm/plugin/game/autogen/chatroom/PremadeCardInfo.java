package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class PremadeCardInfo
  extends com.tencent.mm.bx.a
{
  public String premade_info;
  public TeamIcon team_icon_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275539);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.premade_info != null) {
        paramVarArgs.g(1, this.premade_info);
      }
      if (this.team_icon_info != null)
      {
        paramVarArgs.qD(2, this.team_icon_info.computeSize());
        this.team_icon_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.premade_info == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.premade_info) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.team_icon_info != null) {
        i = paramInt + i.a.a.a.qC(2, this.team_icon_info.computeSize());
      }
      AppMethodBeat.o(275539);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        PremadeCardInfo localPremadeCardInfo = (PremadeCardInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275539);
          return -1;
        case 1: 
          localPremadeCardInfo.premade_info = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275539);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          TeamIcon localTeamIcon = new TeamIcon();
          if ((localObject != null) && (localObject.length > 0)) {
            localTeamIcon.parseFrom((byte[])localObject);
          }
          localPremadeCardInfo.team_icon_info = localTeamIcon;
          paramInt += 1;
        }
        AppMethodBeat.o(275539);
        return 0;
      }
      AppMethodBeat.o(275539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.PremadeCardInfo
 * JD-Core Version:    0.7.0.1
 */