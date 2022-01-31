package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.bv.a
{
  public String ID;
  public long jJR;
  public int jJU;
  public int jJV;
  public int jJW;
  public long jJX;
  public long jJY;
  public LinkedList<t> jKj;
  public LinkedList<t> jKk;
  
  public r()
  {
    AppMethodBeat.i(18065);
    this.jKj = new LinkedList();
    this.jKk = new LinkedList();
    AppMethodBeat.o(18065);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18066);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(18066);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.e(1, this.ID);
      }
      paramVarArgs.aO(2, this.jJU);
      paramVarArgs.aO(3, this.jJV);
      paramVarArgs.aO(4, this.jJW);
      paramVarArgs.am(5, this.jJR);
      paramVarArgs.am(6, this.jJX);
      paramVarArgs.am(7, this.jJY);
      paramVarArgs.e(8, 8, this.jKj);
      paramVarArgs.e(9, 8, this.jKk);
      AppMethodBeat.o(18066);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label849;
      }
    }
    label849:
    for (paramInt = e.a.a.b.b.a.f(1, this.ID) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.jJU);
      int j = e.a.a.b.b.a.bl(3, this.jJV);
      int k = e.a.a.b.b.a.bl(4, this.jJW);
      int m = e.a.a.b.b.a.p(5, this.jJR);
      int n = e.a.a.b.b.a.p(6, this.jJX);
      int i1 = e.a.a.b.b.a.p(7, this.jJY);
      int i2 = e.a.a.a.c(8, 8, this.jKj);
      int i3 = e.a.a.a.c(9, 8, this.jKk);
      AppMethodBeat.o(18066);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.jKj.clear();
        this.jKk.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(18066);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18066);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(18066);
          return -1;
        case 1: 
          localr.ID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(18066);
          return 0;
        case 2: 
          localr.jJU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18066);
          return 0;
        case 3: 
          localr.jJV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18066);
          return 0;
        case 4: 
          localr.jJW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(18066);
          return 0;
        case 5: 
          localr.jJR = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(18066);
          return 0;
        case 6: 
          localr.jJX = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(18066);
          return 0;
        case 7: 
          localr.jJY = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(18066);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localr.jKj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(18066);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localr.jKk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(18066);
        return 0;
      }
      AppMethodBeat.o(18066);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.r
 * JD-Core Version:    0.7.0.1
 */