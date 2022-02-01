package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bw.a
{
  public c oHb;
  public j oHc;
  public boolean oHd;
  public int oHe;
  public boolean oHf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153067);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oHb != null)
      {
        paramVarArgs.ln(1, this.oHb.computeSize());
        this.oHb.writeFields(paramVarArgs);
      }
      if (this.oHc != null)
      {
        paramVarArgs.ln(2, this.oHc.computeSize());
        this.oHc.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(3, this.oHd);
      paramVarArgs.aR(4, this.oHe);
      paramVarArgs.bl(5, this.oHf);
      AppMethodBeat.o(153067);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oHb == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lm(1, this.oHb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oHc != null) {
        i = paramInt + f.a.a.a.lm(2, this.oHc.computeSize());
      }
      paramInt = f.a.a.b.b.a.fK(3);
      int j = f.a.a.b.b.a.bx(4, this.oHe);
      int k = f.a.a.b.b.a.fK(5);
      AppMethodBeat.o(153067);
      return i + (paramInt + 1) + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.oHb = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.oHc = ((j)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 3: 
          localg.oHd = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153067);
          return 0;
        case 4: 
          localg.oHe = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153067);
          return 0;
        }
        localg.oHf = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(153067);
        return 0;
      }
      AppMethodBeat.o(153067);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.g
 * JD-Core Version:    0.7.0.1
 */