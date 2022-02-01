package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bx.a
{
  public LinkedList<p> xlU;
  public int xlV;
  
  public f()
  {
    AppMethodBeat.i(153065);
    this.xlU = new LinkedList();
    AppMethodBeat.o(153065);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153066);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(4, 8, this.xlU);
      paramVarArgs.bS(5, this.xlV);
      AppMethodBeat.o(153066);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(4, 8, this.xlU);
      i = i.a.a.b.b.a.cJ(5, this.xlV);
      AppMethodBeat.o(153066);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xlU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153066);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153066);
        return -1;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          p localp = new p();
          if ((localObject != null) && (localObject.length > 0)) {
            localp.parseFrom((byte[])localObject);
          }
          localf.xlU.add(localp);
          paramInt += 1;
        }
        AppMethodBeat.o(153066);
        return 0;
      }
      localf.xlV = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(153066);
      return 0;
    }
    AppMethodBeat.o(153066);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.f
 * JD-Core Version:    0.7.0.1
 */