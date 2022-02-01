package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class c
  extends com.tencent.mm.bx.a
{
  public long JaD;
  public long JaE;
  public m JaF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267810);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.JaD);
      paramVarArgs.bv(2, this.JaE);
      if (this.JaF != null)
      {
        paramVarArgs.qD(3, this.JaF.computeSize());
        this.JaF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(267810);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.JaD) + 0 + i.a.a.b.b.a.q(2, this.JaE);
      paramInt = i;
      if (this.JaF != null) {
        paramInt = i + i.a.a.a.qC(3, this.JaF.computeSize());
      }
      AppMethodBeat.o(267810);
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
      AppMethodBeat.o(267810);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(267810);
        return -1;
      case 1: 
        localc.JaD = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(267810);
        return 0;
      case 2: 
        localc.JaE = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(267810);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        m localm = new m();
        if ((localObject != null) && (localObject.length > 0)) {
          localm.parseFrom((byte[])localObject);
        }
        localc.JaF = localm;
        paramInt += 1;
      }
      AppMethodBeat.o(267810);
      return 0;
    }
    AppMethodBeat.o(267810);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.c
 * JD-Core Version:    0.7.0.1
 */