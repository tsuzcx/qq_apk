package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.bw.a
{
  public String ID;
  public long nJa;
  public int nJd;
  public int nJe;
  public int nJf;
  public long nJg;
  public long nJh;
  public LinkedList<t> nJr;
  public LinkedList<t> nJs;
  
  public r()
  {
    AppMethodBeat.i(22122);
    this.nJr = new LinkedList();
    this.nJs = new LinkedList();
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
      paramVarArgs.aS(2, this.nJd);
      paramVarArgs.aS(3, this.nJe);
      paramVarArgs.aS(4, this.nJf);
      paramVarArgs.aZ(5, this.nJa);
      paramVarArgs.aZ(6, this.nJg);
      paramVarArgs.aZ(7, this.nJh);
      paramVarArgs.e(8, 8, this.nJr);
      paramVarArgs.e(9, 8, this.nJs);
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
      int i = f.a.a.b.b.a.bz(2, this.nJd);
      int j = f.a.a.b.b.a.bz(3, this.nJe);
      int k = f.a.a.b.b.a.bz(4, this.nJf);
      int m = f.a.a.b.b.a.p(5, this.nJa);
      int n = f.a.a.b.b.a.p(6, this.nJg);
      int i1 = f.a.a.b.b.a.p(7, this.nJh);
      int i2 = f.a.a.a.c(8, 8, this.nJr);
      int i3 = f.a.a.a.c(9, 8, this.nJs);
      AppMethodBeat.o(22123);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nJr.clear();
        this.nJs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localr.ID = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(22123);
          return 0;
        case 2: 
          localr.nJd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22123);
          return 0;
        case 3: 
          localr.nJe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22123);
          return 0;
        case 4: 
          localr.nJf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(22123);
          return 0;
        case 5: 
          localr.nJa = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(22123);
          return 0;
        case 6: 
          localr.nJg = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(22123);
          return 0;
        case 7: 
          localr.nJh = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(22123);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localr.nJr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22123);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localr.nJs.add(localObject1);
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