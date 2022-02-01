package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.bw.a
{
  public String ID;
  public long oTV;
  public int oTY;
  public int oTZ;
  public int oUa;
  public long oUb;
  public long oUc;
  public LinkedList<t> oUm;
  public LinkedList<t> oUn;
  
  public r()
  {
    AppMethodBeat.i(22122);
    this.oUm = new LinkedList();
    this.oUn = new LinkedList();
    AppMethodBeat.o(22122);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22123);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22123);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.e(1, this.ID);
      }
      paramVarArgs.aM(2, this.oTY);
      paramVarArgs.aM(3, this.oTZ);
      paramVarArgs.aM(4, this.oUa);
      paramVarArgs.bb(5, this.oTV);
      paramVarArgs.bb(6, this.oUb);
      paramVarArgs.bb(7, this.oUc);
      paramVarArgs.e(8, 8, this.oUm);
      paramVarArgs.e(9, 8, this.oUn);
      AppMethodBeat.o(22123);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label849;
      }
    }
    label849:
    for (paramInt = g.a.a.b.b.a.f(1, this.ID) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.oTY);
      int j = g.a.a.b.b.a.bu(3, this.oTZ);
      int k = g.a.a.b.b.a.bu(4, this.oUa);
      int m = g.a.a.b.b.a.r(5, this.oTV);
      int n = g.a.a.b.b.a.r(6, this.oUb);
      int i1 = g.a.a.b.b.a.r(7, this.oUc);
      int i2 = g.a.a.a.c(8, 8, this.oUm);
      int i3 = g.a.a.a.c(9, 8, this.oUn);
      AppMethodBeat.o(22123);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.oUm.clear();
        this.oUn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22123);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22123);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22123);
          return -1;
        case 1: 
          localr.ID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(22123);
          return 0;
        case 2: 
          localr.oTY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22123);
          return 0;
        case 3: 
          localr.oTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22123);
          return 0;
        case 4: 
          localr.oUa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22123);
          return 0;
        case 5: 
          localr.oTV = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(22123);
          return 0;
        case 6: 
          localr.oUb = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(22123);
          return 0;
        case 7: 
          localr.oUc = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(22123);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localr.oUm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22123);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localr.oUn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22123);
        return 0;
      }
      AppMethodBeat.o(22123);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.r
 * JD-Core Version:    0.7.0.1
 */