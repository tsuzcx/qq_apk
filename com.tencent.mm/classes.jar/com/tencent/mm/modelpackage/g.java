package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class g
  extends com.tencent.mm.bx.a
{
  public double dFr;
  public LinkedList<e> oQz;
  
  public g()
  {
    AppMethodBeat.i(150797);
    this.oQz = new LinkedList();
    AppMethodBeat.o(150797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150798);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.oQz);
      paramVarArgs.d(2, this.dFr);
      AppMethodBeat.o(150798);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.oQz);
      i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(150798);
      return paramInt + 0 + (i + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.oQz.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(150798);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(150798);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          e locale = new e();
          if ((localObject != null) && (localObject.length > 0)) {
            locale.parseFrom((byte[])localObject);
          }
          localg.oQz.add(locale);
          paramInt += 1;
        }
        AppMethodBeat.o(150798);
        return 0;
      }
      localg.dFr = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
      AppMethodBeat.o(150798);
      return 0;
    }
    AppMethodBeat.o(150798);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelpackage.g
 * JD-Core Version:    0.7.0.1
 */