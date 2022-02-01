package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class df
  extends com.tencent.mm.bw.a
{
  public LinkedList<dg> uuS;
  public String uuT;
  public String uui;
  
  public df()
  {
    AppMethodBeat.i(41819);
    this.uuS = new LinkedList();
    AppMethodBeat.o(41819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41820);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.uuS);
      if (this.uui != null) {
        paramVarArgs.d(2, this.uui);
      }
      if (this.uuT != null) {
        paramVarArgs.d(3, this.uuT);
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.uuS) + 0;
      paramInt = i;
      if (this.uui != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uui);
      }
      i = paramInt;
      if (this.uuT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uuT);
      }
      AppMethodBeat.o(41820);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uuS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      df localdf = (df)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41820);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdf.uuS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41820);
        return 0;
      case 2: 
        localdf.uui = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41820);
        return 0;
      }
      localdf.uuT = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(41820);
      return 0;
    }
    AppMethodBeat.o(41820);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.df
 * JD-Core Version:    0.7.0.1
 */