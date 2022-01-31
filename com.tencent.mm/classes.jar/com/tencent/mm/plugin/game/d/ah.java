package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ah
  extends com.tencent.mm.bv.a
{
  public String nqt;
  public String nqu;
  public LinkedList<cx> nrw;
  public String nrx;
  public String nry;
  
  public ah()
  {
    AppMethodBeat.i(111573);
    this.nrw = new LinkedList();
    AppMethodBeat.o(111573);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111574);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqu != null) {
        paramVarArgs.e(1, this.nqu);
      }
      paramVarArgs.e(2, 8, this.nrw);
      if (this.nrx != null) {
        paramVarArgs.e(3, this.nrx);
      }
      if (this.nry != null) {
        paramVarArgs.e(4, this.nry);
      }
      if (this.nqt != null) {
        paramVarArgs.e(5, this.nqt);
      }
      AppMethodBeat.o(111574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqu == null) {
        break label538;
      }
    }
    label538:
    for (paramInt = e.a.a.b.b.a.f(1, this.nqu) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.nrw);
      paramInt = i;
      if (this.nrx != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nrx);
      }
      i = paramInt;
      if (this.nry != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.nry);
      }
      paramInt = i;
      if (this.nqt != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.nqt);
      }
      AppMethodBeat.o(111574);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nrw.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111574);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ah localah = (ah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111574);
          return -1;
        case 1: 
          localah.nqu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111574);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localah.nrw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111574);
          return 0;
        case 3: 
          localah.nrx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111574);
          return 0;
        case 4: 
          localah.nry = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111574);
          return 0;
        }
        localah.nqt = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111574);
        return 0;
      }
      AppMethodBeat.o(111574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ah
 * JD-Core Version:    0.7.0.1
 */