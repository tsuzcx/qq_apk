package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends com.tencent.mm.cd.a
{
  public ep COd;
  public boolean COe;
  public boolean COf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207251);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.COd != null)
      {
        paramVarArgs.oE(1, this.COd.computeSize());
        this.COd.writeFields(paramVarArgs);
      }
      paramVarArgs.co(2, this.COe);
      paramVarArgs.co(4, this.COf);
      AppMethodBeat.o(207251);
      return 0;
    }
    if (paramInt == 1) {
      if (this.COd == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = g.a.a.a.oD(1, this.COd.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(207251);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207251);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ac localac = (ac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(207251);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ep localep = new ep();
            if ((localObject != null) && (localObject.length > 0)) {
              localep.parseFrom((byte[])localObject);
            }
            localac.COd = localep;
            paramInt += 1;
          }
          AppMethodBeat.o(207251);
          return 0;
        case 2: 
          localac.COe = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(207251);
          return 0;
        }
        localac.COf = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(207251);
        return 0;
      }
      AppMethodBeat.o(207251);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ac
 * JD-Core Version:    0.7.0.1
 */