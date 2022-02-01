package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bx.a
{
  public c pkF;
  public j pkG;
  public boolean pkH;
  public int pkI;
  public boolean pkJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153067);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pkF != null)
      {
        paramVarArgs.lC(1, this.pkF.computeSize());
        this.pkF.writeFields(paramVarArgs);
      }
      if (this.pkG != null)
      {
        paramVarArgs.lC(2, this.pkG.computeSize());
        this.pkG.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(3, this.pkH);
      paramVarArgs.aS(4, this.pkI);
      paramVarArgs.bt(5, this.pkJ);
      AppMethodBeat.o(153067);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pkF == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = f.a.a.a.lB(1, this.pkF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pkG != null) {
        i = paramInt + f.a.a.a.lB(2, this.pkG.computeSize());
      }
      paramInt = f.a.a.b.b.a.alV(3);
      int j = f.a.a.b.b.a.bz(4, this.pkI);
      int k = f.a.a.b.b.a.alV(5);
      AppMethodBeat.o(153067);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.pkF = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.pkG = ((j)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 3: 
          localg.pkH = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153067);
          return 0;
        case 4: 
          localg.pkI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153067);
          return 0;
        }
        localg.pkJ = ((f.a.a.a.a)localObject1).NPN.grw();
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