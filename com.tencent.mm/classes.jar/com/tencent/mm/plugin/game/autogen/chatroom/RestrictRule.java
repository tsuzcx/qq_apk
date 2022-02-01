package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class RestrictRule
  extends com.tencent.mm.cd.a
{
  public boolean can_pass;
  public Color color;
  public String rule_desc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194999);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rule_desc != null) {
        paramVarArgs.f(1, this.rule_desc);
      }
      paramVarArgs.co(2, this.can_pass);
      if (this.color != null)
      {
        paramVarArgs.oE(3, this.color.computeSize());
        this.color.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rule_desc == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = g.a.a.b.b.a.g(1, this.rule_desc) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.color != null) {
        paramInt = i + g.a.a.a.oD(3, this.color.computeSize());
      }
      AppMethodBeat.o(194999);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194999);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        RestrictRule localRestrictRule = (RestrictRule)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194999);
          return -1;
        case 1: 
          localRestrictRule.rule_desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(194999);
          return 0;
        case 2: 
          localRestrictRule.can_pass = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(194999);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          Color localColor = new Color();
          if ((localObject != null) && (localObject.length > 0)) {
            localColor.parseFrom((byte[])localObject);
          }
          localRestrictRule.color = localColor;
          paramInt += 1;
        }
        AppMethodBeat.o(194999);
        return 0;
      }
      AppMethodBeat.o(194999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.RestrictRule
 * JD-Core Version:    0.7.0.1
 */