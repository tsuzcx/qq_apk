package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends com.tencent.mm.cd.a
{
  public int rVU;
  public int rVj;
  public q rWM;
  public p rWN;
  public r rWO;
  public s rWP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22135);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rVj);
      paramVarArgs.aY(2, this.rVU);
      if (this.rWM != null)
      {
        paramVarArgs.oE(3, this.rWM.computeSize());
        this.rWM.writeFields(paramVarArgs);
      }
      if (this.rWN != null)
      {
        paramVarArgs.oE(4, this.rWN.computeSize());
        this.rWN.writeFields(paramVarArgs);
      }
      if (this.rWO != null)
      {
        paramVarArgs.oE(5, this.rWO.computeSize());
        this.rWO.writeFields(paramVarArgs);
      }
      if (this.rWP != null)
      {
        paramVarArgs.oE(6, this.rWP.computeSize());
        this.rWP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.rVj) + 0 + g.a.a.b.b.a.bM(2, this.rVU);
      paramInt = i;
      if (this.rWM != null) {
        paramInt = i + g.a.a.a.oD(3, this.rWM.computeSize());
      }
      i = paramInt;
      if (this.rWN != null) {
        i = paramInt + g.a.a.a.oD(4, this.rWN.computeSize());
      }
      paramInt = i;
      if (this.rWO != null) {
        paramInt = i + g.a.a.a.oD(5, this.rWO.computeSize());
      }
      i = paramInt;
      if (this.rWP != null) {
        i = paramInt + g.a.a.a.oD(6, this.rWP.computeSize());
      }
      AppMethodBeat.o(22135);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ac localac = (ac)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(22135);
        return -1;
      case 1: 
        localac.rVj = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(22135);
        return 0;
      case 2: 
        localac.rVU = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(22135);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new q();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((q)localObject2).parseFrom((byte[])localObject1);
          }
          localac.rWM = ((q)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new p();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((p)localObject2).parseFrom((byte[])localObject1);
          }
          localac.rWN = ((p)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new r();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((r)localObject2).parseFrom((byte[])localObject1);
          }
          localac.rWO = ((r)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new s();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((s)localObject2).parseFrom((byte[])localObject1);
        }
        localac.rWP = ((s)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    AppMethodBeat.o(22135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ac
 * JD-Core Version:    0.7.0.1
 */