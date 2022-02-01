package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bx.a
{
  public c odC;
  public j odD;
  public boolean odE;
  public int odF;
  public boolean odG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153067);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.odC != null)
      {
        paramVarArgs.kX(1, this.odC.computeSize());
        this.odC.writeFields(paramVarArgs);
      }
      if (this.odD != null)
      {
        paramVarArgs.kX(2, this.odD.computeSize());
        this.odD.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(3, this.odE);
      paramVarArgs.aR(4, this.odF);
      paramVarArgs.bg(5, this.odG);
      AppMethodBeat.o(153067);
      return 0;
    }
    if (paramInt == 1) {
      if (this.odC == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.kW(1, this.odC.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.odD != null) {
        i = paramInt + f.a.a.a.kW(2, this.odD.computeSize());
      }
      paramInt = f.a.a.b.b.a.fY(3);
      int j = f.a.a.b.b.a.bA(4, this.odF);
      int k = f.a.a.b.b.a.fY(5);
      AppMethodBeat.o(153067);
      return i + (paramInt + 1) + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.odC = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.odD = ((j)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 3: 
          localg.odE = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153067);
          return 0;
        case 4: 
          localg.odF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153067);
          return 0;
        }
        localg.odG = ((f.a.a.a.a)localObject1).KhF.fHu();
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