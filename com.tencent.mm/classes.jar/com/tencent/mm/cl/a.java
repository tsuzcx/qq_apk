package com.tencent.mm.cl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.cd.a
{
  public LinkedList<d> UXS;
  public LinkedList<c> UXT;
  
  public a()
  {
    AppMethodBeat.i(104894);
    this.UXS = new LinkedList();
    this.UXT = new LinkedList();
    AppMethodBeat.o(104894);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104895);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(3, 8, this.UXS);
      paramVarArgs.e(4, 8, this.UXT);
      AppMethodBeat.o(104895);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(3, 8, this.UXS);
      i = g.a.a.a.c(4, 8, this.UXT);
      AppMethodBeat.o(104895);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UXS.clear();
      this.UXT.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(104895);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      a locala = (a)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104895);
        return -1;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new d();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((d)localObject2).parseFrom((byte[])localObject1);
          }
          locala.UXS.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104895);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new c();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((c)localObject2).parseFrom((byte[])localObject1);
        }
        locala.UXT.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(104895);
      return 0;
    }
    AppMethodBeat.o(104895);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cl.a
 * JD-Core Version:    0.7.0.1
 */