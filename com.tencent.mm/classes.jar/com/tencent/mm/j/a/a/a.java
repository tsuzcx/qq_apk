package com.tencent.mm.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bv.a
{
  public int bsY;
  public int cAE;
  public int eeH;
  public LinkedList<b> elu;
  public String elv;
  public int elw;
  public int status;
  public int type;
  
  public a()
  {
    AppMethodBeat.i(59614);
    this.elu = new LinkedList();
    AppMethodBeat.o(59614);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(59615);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.elu);
      paramVarArgs.aO(2, this.bsY);
      paramVarArgs.aO(3, this.type);
      paramVarArgs.aO(4, this.status);
      paramVarArgs.aO(5, this.eeH);
      if (this.elv != null) {
        paramVarArgs.e(6, this.elv);
      }
      paramVarArgs.aO(7, this.cAE);
      paramVarArgs.aO(8, this.elw);
      AppMethodBeat.o(59615);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.elu) + 0 + e.a.a.b.b.a.bl(2, this.bsY) + e.a.a.b.b.a.bl(3, this.type) + e.a.a.b.b.a.bl(4, this.status) + e.a.a.b.b.a.bl(5, this.eeH);
      paramInt = i;
      if (this.elv != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.elv);
      }
      i = e.a.a.b.b.a.bl(7, this.cAE);
      int j = e.a.a.b.b.a.bl(8, this.elw);
      AppMethodBeat.o(59615);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.elu.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(59615);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      a locala = (a)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(59615);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locala.elu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(59615);
        return 0;
      case 2: 
        locala.bsY = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(59615);
        return 0;
      case 3: 
        locala.type = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(59615);
        return 0;
      case 4: 
        locala.status = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(59615);
        return 0;
      case 5: 
        locala.eeH = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(59615);
        return 0;
      case 6: 
        locala.elv = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(59615);
        return 0;
      case 7: 
        locala.cAE = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(59615);
        return 0;
      }
      locala.elw = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(59615);
      return 0;
    }
    AppMethodBeat.o(59615);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.j.a.a.a
 * JD-Core Version:    0.7.0.1
 */