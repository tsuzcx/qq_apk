package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bv.a
{
  public String ID;
  public long jJK;
  public m jJN;
  public int jJP;
  public long jJQ;
  public long jJR;
  public int jJS;
  public int jJT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18062);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(18062);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.e(1, this.ID);
      }
      paramVarArgs.am(2, this.jJQ);
      paramVarArgs.am(3, this.jJR);
      paramVarArgs.aO(4, this.jJS);
      paramVarArgs.aO(5, this.jJT);
      paramVarArgs.am(6, this.jJK);
      if (this.jJN != null)
      {
        paramVarArgs.iQ(7, this.jJN.computeSize());
        this.jJN.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.jJP);
      AppMethodBeat.o(18062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label696;
      }
    }
    label696:
    for (paramInt = e.a.a.b.b.a.f(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.jJQ) + e.a.a.b.b.a.p(3, this.jJR) + e.a.a.b.b.a.bl(4, this.jJS) + e.a.a.b.b.a.bl(5, this.jJT) + e.a.a.b.b.a.p(6, this.jJK);
      paramInt = i;
      if (this.jJN != null) {
        paramInt = i + e.a.a.a.iP(7, this.jJN.computeSize());
      }
      i = e.a.a.b.b.a.bl(8, this.jJP);
      AppMethodBeat.o(18062);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(18062);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18062);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(18062);
          return -1;
        case 1: 
          localo.ID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(18062);
          return 0;
        case 2: 
          localo.jJQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(18062);
          return 0;
        case 3: 
          localo.jJR = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(18062);
          return 0;
        case 4: 
          localo.jJS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18062);
          return 0;
        case 5: 
          localo.jJT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18062);
          return 0;
        case 6: 
          localo.jJK = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(18062);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localo.jJN = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(18062);
          return 0;
        }
        localo.jJP = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(18062);
        return 0;
      }
      AppMethodBeat.o(18062);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.o
 * JD-Core Version:    0.7.0.1
 */