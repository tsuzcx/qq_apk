package com.tencent.mm.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bx.a
{
  public int dAm;
  public int dDp;
  public LinkedList<b> fVg;
  public String fVh;
  public int fVi;
  public int maxCount;
  public int status;
  public int type;
  
  public a()
  {
    AppMethodBeat.i(42660);
    this.fVg = new LinkedList();
    AppMethodBeat.o(42660);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42661);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.fVg);
      paramVarArgs.aS(2, this.dDp);
      paramVarArgs.aS(3, this.type);
      paramVarArgs.aS(4, this.status);
      paramVarArgs.aS(5, this.maxCount);
      if (this.fVh != null) {
        paramVarArgs.d(6, this.fVh);
      }
      paramVarArgs.aS(7, this.dAm);
      paramVarArgs.aS(8, this.fVi);
      AppMethodBeat.o(42661);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.fVg) + 0 + f.a.a.b.b.a.bz(2, this.dDp) + f.a.a.b.b.a.bz(3, this.type) + f.a.a.b.b.a.bz(4, this.status) + f.a.a.b.b.a.bz(5, this.maxCount);
      paramInt = i;
      if (this.fVh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.fVh);
      }
      i = f.a.a.b.b.a.bz(7, this.dAm);
      int j = f.a.a.b.b.a.bz(8, this.fVi);
      AppMethodBeat.o(42661);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.fVg.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(42661);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      a locala = (a)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(42661);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locala.fVg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(42661);
        return 0;
      case 2: 
        locala.dDp = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(42661);
        return 0;
      case 3: 
        locala.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(42661);
        return 0;
      case 4: 
        locala.status = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(42661);
        return 0;
      case 5: 
        locala.maxCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(42661);
        return 0;
      case 6: 
        locala.fVh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(42661);
        return 0;
      case 7: 
        locala.dAm = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(42661);
        return 0;
      }
      locala.fVi = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(42661);
      return 0;
    }
    AppMethodBeat.o(42661);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.k.a.a.a
 * JD-Core Version:    0.7.0.1
 */