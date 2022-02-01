package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bw.a
{
  public c qGP;
  public j qGQ;
  public boolean qGR;
  public int qGS;
  public boolean qGT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153067);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.qGP != null)
      {
        paramVarArgs.ni(1, this.qGP.computeSize());
        this.qGP.writeFields(paramVarArgs);
      }
      if (this.qGQ != null)
      {
        paramVarArgs.ni(2, this.qGQ.computeSize());
        this.qGQ.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(3, this.qGR);
      paramVarArgs.aM(4, this.qGS);
      paramVarArgs.cc(5, this.qGT);
      AppMethodBeat.o(153067);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qGP == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.a.nh(1, this.qGP.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qGQ != null) {
        i = paramInt + g.a.a.a.nh(2, this.qGQ.computeSize());
      }
      paramInt = g.a.a.b.b.a.fS(3);
      int j = g.a.a.b.b.a.bu(4, this.qGS);
      int k = g.a.a.b.b.a.fS(5);
      AppMethodBeat.o(153067);
      return i + (paramInt + 1) + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153067);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localg.qGP = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localg.qGQ = ((j)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 3: 
          localg.qGR = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153067);
          return 0;
        case 4: 
          localg.qGS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153067);
          return 0;
        }
        localg.qGT = ((g.a.a.a.a)localObject1).UbS.yZ();
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