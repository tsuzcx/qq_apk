package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bv.a
{
  public String ID;
  public h jJi;
  public int jJj;
  public int jJk;
  public int jJl;
  public int jJm;
  public int jJn;
  public int jJo;
  public int jJp;
  public int jJq;
  public int jJr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18047);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(18047);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.e(1, this.ID);
      }
      if (this.jJi != null)
      {
        paramVarArgs.iQ(2, this.jJi.computeSize());
        this.jJi.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.jJj);
      paramVarArgs.aO(4, this.jJk);
      paramVarArgs.aO(5, this.jJl);
      paramVarArgs.aO(6, this.jJm);
      paramVarArgs.aO(7, this.jJn);
      paramVarArgs.aO(8, this.jJo);
      paramVarArgs.aO(9, this.jJp);
      paramVarArgs.aO(10, this.jJq);
      paramVarArgs.aO(11, this.jJr);
      AppMethodBeat.o(18047);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label863;
      }
    }
    label863:
    for (paramInt = e.a.a.b.b.a.f(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jJi != null) {
        i = paramInt + e.a.a.a.iP(2, this.jJi.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(3, this.jJj);
      int j = e.a.a.b.b.a.bl(4, this.jJk);
      int k = e.a.a.b.b.a.bl(5, this.jJl);
      int m = e.a.a.b.b.a.bl(6, this.jJm);
      int n = e.a.a.b.b.a.bl(7, this.jJn);
      int i1 = e.a.a.b.b.a.bl(8, this.jJo);
      int i2 = e.a.a.b.b.a.bl(9, this.jJp);
      int i3 = e.a.a.b.b.a.bl(10, this.jJq);
      int i4 = e.a.a.b.b.a.bl(11, this.jJr);
      AppMethodBeat.o(18047);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
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
          AppMethodBeat.o(18047);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(18047);
          return -1;
        case 1: 
          locald.ID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(18047);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locald.jJi = ((h)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(18047);
          return 0;
        case 3: 
          locald.jJj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18047);
          return 0;
        case 4: 
          locald.jJk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18047);
          return 0;
        case 5: 
          locald.jJl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18047);
          return 0;
        case 6: 
          locald.jJm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18047);
          return 0;
        case 7: 
          locald.jJn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18047);
          return 0;
        case 8: 
          locald.jJo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18047);
          return 0;
        case 9: 
          locald.jJp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18047);
          return 0;
        case 10: 
          locald.jJq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18047);
          return 0;
        }
        locald.jJr = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(18047);
        return 0;
      }
      AppMethodBeat.o(18047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.d
 * JD-Core Version:    0.7.0.1
 */