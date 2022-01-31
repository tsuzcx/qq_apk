package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cy
  extends com.tencent.mm.bv.a
{
  public String Title;
  public LinkedList<an> nqs;
  public String nrQ;
  public String nrx;
  
  public cy()
  {
    AppMethodBeat.i(111665);
    this.nqs = new LinkedList();
    AppMethodBeat.o(111665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111666);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.nqs);
      if (this.nrx != null) {
        paramVarArgs.e(3, this.nrx);
      }
      if (this.nrQ != null) {
        paramVarArgs.e(4, this.nrQ);
      }
      AppMethodBeat.o(111666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = e.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.nqs);
      paramInt = i;
      if (this.nrx != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nrx);
      }
      i = paramInt;
      if (this.nrQ != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.nrQ);
      }
      AppMethodBeat.o(111666);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nqs.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cy localcy = (cy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111666);
          return -1;
        case 1: 
          localcy.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111666);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new an();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((an)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcy.nqs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111666);
          return 0;
        case 3: 
          localcy.nrx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111666);
          return 0;
        }
        localcy.nrQ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111666);
        return 0;
      }
      AppMethodBeat.o(111666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cy
 * JD-Core Version:    0.7.0.1
 */