package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.cd.a
{
  public double bLJ;
  public LinkedList<e> lXv;
  
  public g()
  {
    AppMethodBeat.i(150797);
    this.lXv = new LinkedList();
    AppMethodBeat.o(150797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150798);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.lXv);
      paramVarArgs.e(2, this.bLJ);
      AppMethodBeat.o(150798);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.lXv);
      i = g.a.a.b.b.a.gL(2);
      AppMethodBeat.o(150798);
      return paramInt + 0 + (i + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.lXv.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(150798);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(150798);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          e locale = new e();
          if ((localObject != null) && (localObject.length > 0)) {
            locale.parseFrom((byte[])localObject);
          }
          localg.lXv.add(locale);
          paramInt += 1;
        }
        AppMethodBeat.o(150798);
        return 0;
      }
      localg.bLJ = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
      AppMethodBeat.o(150798);
      return 0;
    }
    AppMethodBeat.o(150798);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.g
 * JD-Core Version:    0.7.0.1
 */