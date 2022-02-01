package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class av
  extends com.tencent.mm.cd.a
{
  public cp CON;
  public cp COO;
  public cp COP;
  public dr COQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41741);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CON != null)
      {
        paramVarArgs.oE(1, this.CON.computeSize());
        this.CON.writeFields(paramVarArgs);
      }
      if (this.COO != null)
      {
        paramVarArgs.oE(2, this.COO.computeSize());
        this.COO.writeFields(paramVarArgs);
      }
      if (this.COP != null)
      {
        paramVarArgs.oE(3, this.COP.computeSize());
        this.COP.writeFields(paramVarArgs);
      }
      if (this.COQ != null)
      {
        paramVarArgs.oE(4, this.COQ.computeSize());
        this.COQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41741);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CON == null) {
        break label686;
      }
    }
    label686:
    for (int i = g.a.a.a.oD(1, this.CON.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.COO != null) {
        paramInt = i + g.a.a.a.oD(2, this.COO.computeSize());
      }
      i = paramInt;
      if (this.COP != null) {
        i = paramInt + g.a.a.a.oD(3, this.COP.computeSize());
      }
      paramInt = i;
      if (this.COQ != null) {
        paramInt = i + g.a.a.a.oD(4, this.COQ.computeSize());
      }
      AppMethodBeat.o(41741);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41741);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        av localav = (av)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41741);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cp)localObject2).parseFrom((byte[])localObject1);
            }
            localav.CON = ((cp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cp)localObject2).parseFrom((byte[])localObject1);
            }
            localav.COO = ((cp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cp)localObject2).parseFrom((byte[])localObject1);
            }
            localav.COP = ((cp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dr)localObject2).parseFrom((byte[])localObject1);
          }
          localav.COQ = ((dr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41741);
        return 0;
      }
      AppMethodBeat.o(41741);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.av
 * JD-Core Version:    0.7.0.1
 */