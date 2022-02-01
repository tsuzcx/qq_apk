package com.tencent.mm.plugin.location.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public LinkedList<a> KbT;
  public String KbU;
  
  public b()
  {
    AppMethodBeat.i(55670);
    this.KbT = new LinkedList();
    AppMethodBeat.o(55670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55671);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.KbT);
      if (this.KbU != null) {
        paramVarArgs.g(2, this.KbU);
      }
      AppMethodBeat.o(55671);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.KbT) + 0;
      paramInt = i;
      if (this.KbU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.KbU);
      }
      AppMethodBeat.o(55671);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KbT.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(55671);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(55671);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          a locala = new a();
          if ((localObject != null) && (localObject.length > 0)) {
            locala.parseFrom((byte[])localObject);
          }
          localb.KbT.add(locala);
          paramInt += 1;
        }
        AppMethodBeat.o(55671);
        return 0;
      }
      localb.KbU = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(55671);
      return 0;
    }
    AppMethodBeat.o(55671);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.a.b
 * JD-Core Version:    0.7.0.1
 */