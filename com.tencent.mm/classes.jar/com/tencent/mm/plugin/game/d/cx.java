package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cx
  extends com.tencent.mm.bx.a
{
  public String uiL;
  public LinkedList<cy> uju;
  public String ujv;
  
  public cx()
  {
    AppMethodBeat.i(41819);
    this.uju = new LinkedList();
    AppMethodBeat.o(41819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41820);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.uju);
      if (this.uiL != null) {
        paramVarArgs.d(2, this.uiL);
      }
      if (this.ujv != null) {
        paramVarArgs.d(3, this.ujv);
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.uju) + 0;
      paramInt = i;
      if (this.uiL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uiL);
      }
      i = paramInt;
      if (this.ujv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ujv);
      }
      AppMethodBeat.o(41820);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uju.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cx localcx = (cx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41820);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcx.uju.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41820);
        return 0;
      case 2: 
        localcx.uiL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41820);
        return 0;
      }
      localcx.ujv = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(41820);
      return 0;
    }
    AppMethodBeat.o(41820);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cx
 * JD-Core Version:    0.7.0.1
 */