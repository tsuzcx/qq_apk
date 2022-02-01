package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.bx.a
{
  public String ID;
  public long nDF;
  public int nDI;
  public int nDJ;
  public int nDK;
  public long nDL;
  public long nDM;
  public LinkedList<t> nDW;
  public LinkedList<t> nDX;
  
  public r()
  {
    AppMethodBeat.i(22122);
    this.nDW = new LinkedList();
    this.nDX = new LinkedList();
    AppMethodBeat.o(22122);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22123);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22123);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      paramVarArgs.aS(2, this.nDI);
      paramVarArgs.aS(3, this.nDJ);
      paramVarArgs.aS(4, this.nDK);
      paramVarArgs.aY(5, this.nDF);
      paramVarArgs.aY(6, this.nDL);
      paramVarArgs.aY(7, this.nDM);
      paramVarArgs.e(8, 8, this.nDW);
      paramVarArgs.e(9, 8, this.nDX);
      AppMethodBeat.o(22123);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label849;
      }
    }
    label849:
    for (paramInt = f.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nDI);
      int j = f.a.a.b.b.a.bz(3, this.nDJ);
      int k = f.a.a.b.b.a.bz(4, this.nDK);
      int m = f.a.a.b.b.a.p(5, this.nDF);
      int n = f.a.a.b.b.a.p(6, this.nDL);
      int i1 = f.a.a.b.b.a.p(7, this.nDM);
      int i2 = f.a.a.a.c(8, 8, this.nDW);
      int i3 = f.a.a.a.c(9, 8, this.nDX);
      AppMethodBeat.o(22123);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nDW.clear();
        this.nDX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
          localr.ID = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(22123);
          return 0;
        case 2: 
          localr.nDI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22123);
          return 0;
        case 3: 
          localr.nDJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22123);
          return 0;
        case 4: 
          localr.nDK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(22123);
          return 0;
        case 5: 
          localr.nDF = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(22123);
          return 0;
        case 6: 
          localr.nDL = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(22123);
          return 0;
        case 7: 
          localr.nDM = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(22123);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localr.nDW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22123);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localr.nDX.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.r
 * JD-Core Version:    0.7.0.1
 */