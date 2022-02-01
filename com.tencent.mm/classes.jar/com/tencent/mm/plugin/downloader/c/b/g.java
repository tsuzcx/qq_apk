package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bw.a
{
  public c prk;
  public j prl;
  public boolean prm;
  public int prn;
  public boolean pro;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153067);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.prk != null)
      {
        paramVarArgs.lJ(1, this.prk.computeSize());
        this.prk.writeFields(paramVarArgs);
      }
      if (this.prl != null)
      {
        paramVarArgs.lJ(2, this.prl.computeSize());
        this.prl.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(3, this.prm);
      paramVarArgs.aS(4, this.prn);
      paramVarArgs.bC(5, this.pro);
      AppMethodBeat.o(153067);
      return 0;
    }
    if (paramInt == 1) {
      if (this.prk == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = f.a.a.a.lI(1, this.prk.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.prl != null) {
        i = paramInt + f.a.a.a.lI(2, this.prl.computeSize());
      }
      paramInt = f.a.a.b.b.a.amF(3);
      int j = f.a.a.b.b.a.bz(4, this.prn);
      int k = f.a.a.b.b.a.amF(5);
      AppMethodBeat.o(153067);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153067);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153067);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.prk = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.prl = ((j)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 3: 
          localg.prm = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153067);
          return 0;
        case 4: 
          localg.prn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153067);
          return 0;
        }
        localg.pro = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(153067);
        return 0;
      }
      AppMethodBeat.o(153067);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.g
 * JD-Core Version:    0.7.0.1
 */