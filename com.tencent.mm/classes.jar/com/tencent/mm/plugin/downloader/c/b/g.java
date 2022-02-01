package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.cd.a
{
  public c ufQ;
  public j ufR;
  public boolean ufS;
  public int ufT;
  public boolean ufU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153067);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ufQ != null)
      {
        paramVarArgs.oE(1, this.ufQ.computeSize());
        this.ufQ.writeFields(paramVarArgs);
      }
      if (this.ufR != null)
      {
        paramVarArgs.oE(2, this.ufR.computeSize());
        this.ufR.writeFields(paramVarArgs);
      }
      paramVarArgs.co(3, this.ufS);
      paramVarArgs.aY(4, this.ufT);
      paramVarArgs.co(5, this.ufU);
      AppMethodBeat.o(153067);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufQ == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = g.a.a.a.oD(1, this.ufQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ufR != null) {
        i = paramInt + g.a.a.a.oD(2, this.ufR.computeSize());
      }
      paramInt = g.a.a.b.b.a.gL(3);
      int j = g.a.a.b.b.a.bM(4, this.ufT);
      int k = g.a.a.b.b.a.gL(5);
      AppMethodBeat.o(153067);
      return i + (paramInt + 1) + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153067);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153067);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new c();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((c)localObject2).parseFrom((byte[])localObject1);
            }
            localg.ufQ = ((c)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new j();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((j)localObject2).parseFrom((byte[])localObject1);
            }
            localg.ufR = ((j)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 3: 
          localg.ufS = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(153067);
          return 0;
        case 4: 
          localg.ufT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153067);
          return 0;
        }
        localg.ufU = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(153067);
        return 0;
      }
      AppMethodBeat.o(153067);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.g
 * JD-Core Version:    0.7.0.1
 */