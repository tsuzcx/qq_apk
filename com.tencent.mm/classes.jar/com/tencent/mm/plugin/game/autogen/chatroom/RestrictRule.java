package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class RestrictRule
  extends com.tencent.mm.bx.a
{
  public boolean can_pass;
  public Color color;
  public String rule_desc;
  public ShowIcon show_icon;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275580);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.rule_desc != null) {
        paramVarArgs.g(1, this.rule_desc);
      }
      paramVarArgs.di(2, this.can_pass);
      if (this.color != null)
      {
        paramVarArgs.qD(3, this.color.computeSize());
        this.color.writeFields(paramVarArgs);
      }
      if (this.show_icon != null)
      {
        paramVarArgs.qD(4, this.show_icon.computeSize());
        this.show_icon.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rule_desc == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = i.a.a.b.b.a.h(1, this.rule_desc) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.color != null) {
        paramInt = i + i.a.a.a.qC(3, this.color.computeSize());
      }
      i = paramInt;
      if (this.show_icon != null) {
        i = paramInt + i.a.a.a.qC(4, this.show_icon.computeSize());
      }
      AppMethodBeat.o(275580);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275580);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        RestrictRule localRestrictRule = (RestrictRule)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275580);
          return -1;
        case 1: 
          localRestrictRule.rule_desc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275580);
          return 0;
        case 2: 
          localRestrictRule.can_pass = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275580);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new Color();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((Color)localObject2).parseFrom((byte[])localObject1);
            }
            localRestrictRule.color = ((Color)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275580);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ShowIcon();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ShowIcon)localObject2).parseFrom((byte[])localObject1);
          }
          localRestrictRule.show_icon = ((ShowIcon)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275580);
        return 0;
      }
      AppMethodBeat.o(275580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.RestrictRule
 * JD-Core Version:    0.7.0.1
 */