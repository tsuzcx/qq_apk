package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ax
  extends com.tencent.mm.bx.a
{
  public String Title;
  public LinkedList<ab> ufF;
  public String ugP;
  public String uhp;
  
  public ax()
  {
    AppMethodBeat.i(41752);
    this.ufF = new LinkedList();
    AppMethodBeat.o(41752);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41753);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ufF);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.ugP != null) {
        paramVarArgs.d(3, this.ugP);
      }
      if (this.uhp != null) {
        paramVarArgs.d(4, this.uhp);
      }
      AppMethodBeat.o(41753);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.ufF) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.ugP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ugP);
      }
      paramInt = i;
      if (this.uhp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uhp);
      }
      AppMethodBeat.o(41753);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ufF.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(41753);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ax localax = (ax)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41753);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ab();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ab)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localax.ufF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41753);
        return 0;
      case 2: 
        localax.Title = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41753);
        return 0;
      case 3: 
        localax.ugP = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41753);
        return 0;
      }
      localax.uhp = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(41753);
      return 0;
    }
    AppMethodBeat.o(41753);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ax
 * JD-Core Version:    0.7.0.1
 */