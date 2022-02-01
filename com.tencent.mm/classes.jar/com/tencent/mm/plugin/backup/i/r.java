package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.bw.a
{
  public String ID;
  public LinkedList<t> ndA;
  public long ndi;
  public int ndl;
  public int ndm;
  public int ndn;
  public long ndo;
  public long ndp;
  public LinkedList<t> ndz;
  
  public r()
  {
    AppMethodBeat.i(22122);
    this.ndz = new LinkedList();
    this.ndA = new LinkedList();
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
      paramVarArgs.aR(2, this.ndl);
      paramVarArgs.aR(3, this.ndm);
      paramVarArgs.aR(4, this.ndn);
      paramVarArgs.aO(5, this.ndi);
      paramVarArgs.aO(6, this.ndo);
      paramVarArgs.aO(7, this.ndp);
      paramVarArgs.e(8, 8, this.ndz);
      paramVarArgs.e(9, 8, this.ndA);
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
      int i = f.a.a.b.b.a.bx(2, this.ndl);
      int j = f.a.a.b.b.a.bx(3, this.ndm);
      int k = f.a.a.b.b.a.bx(4, this.ndn);
      int m = f.a.a.b.b.a.p(5, this.ndi);
      int n = f.a.a.b.b.a.p(6, this.ndo);
      int i1 = f.a.a.b.b.a.p(7, this.ndp);
      int i2 = f.a.a.a.c(8, 8, this.ndz);
      int i3 = f.a.a.a.c(9, 8, this.ndA);
      AppMethodBeat.o(22123);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ndz.clear();
        this.ndA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localr.ID = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(22123);
          return 0;
        case 2: 
          localr.ndl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22123);
          return 0;
        case 3: 
          localr.ndm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22123);
          return 0;
        case 4: 
          localr.ndn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22123);
          return 0;
        case 5: 
          localr.ndi = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(22123);
          return 0;
        case 6: 
          localr.ndo = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(22123);
          return 0;
        case 7: 
          localr.ndp = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(22123);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localr.ndz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22123);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localr.ndA.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.r
 * JD-Core Version:    0.7.0.1
 */