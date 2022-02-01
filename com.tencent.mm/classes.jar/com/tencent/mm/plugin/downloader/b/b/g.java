package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bx.a
{
  public c xlW;
  public j xlX;
  public boolean xlY;
  public int xlZ;
  public boolean xma;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153067);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.xlW != null)
      {
        paramVarArgs.qD(1, this.xlW.computeSize());
        this.xlW.writeFields(paramVarArgs);
      }
      if (this.xlX != null)
      {
        paramVarArgs.qD(2, this.xlX.computeSize());
        this.xlX.writeFields(paramVarArgs);
      }
      paramVarArgs.di(3, this.xlY);
      paramVarArgs.bS(4, this.xlZ);
      paramVarArgs.di(5, this.xma);
      AppMethodBeat.o(153067);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xlW == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = i.a.a.a.qC(1, this.xlW.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xlX != null) {
        i = paramInt + i.a.a.a.qC(2, this.xlX.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(3);
      int j = i.a.a.b.b.a.cJ(4, this.xlZ);
      int k = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(153067);
      return i + (paramInt + 1) + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153067);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153067);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new c();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((c)localObject2).parseFrom((byte[])localObject1);
            }
            localg.xlW = ((c)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new j();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((j)localObject2).parseFrom((byte[])localObject1);
            }
            localg.xlX = ((j)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153067);
          return 0;
        case 3: 
          localg.xlY = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(153067);
          return 0;
        case 4: 
          localg.xlZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153067);
          return 0;
        }
        localg.xma = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(153067);
        return 0;
      }
      AppMethodBeat.o(153067);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.g
 * JD-Core Version:    0.7.0.1
 */