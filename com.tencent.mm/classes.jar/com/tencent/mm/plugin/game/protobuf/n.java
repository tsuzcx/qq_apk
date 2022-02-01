package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.cd.a
{
  public String CNA;
  public String CNB;
  public int CNC;
  public b CND;
  public dt CNE;
  public int CNF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41714);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNB != null) {
        paramVarArgs.f(1, this.CNB);
      }
      paramVarArgs.aY(2, this.CNC);
      if (this.CND != null)
      {
        paramVarArgs.oE(3, this.CND.computeSize());
        this.CND.writeFields(paramVarArgs);
      }
      if (this.CNE != null)
      {
        paramVarArgs.oE(4, this.CNE.computeSize());
        this.CNE.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.CNF);
      if (this.CNA != null) {
        paramVarArgs.f(6, this.CNA);
      }
      AppMethodBeat.o(41714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNB == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = g.a.a.b.b.a.g(1, this.CNB) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CNC);
      paramInt = i;
      if (this.CND != null) {
        paramInt = i + g.a.a.a.oD(3, this.CND.computeSize());
      }
      i = paramInt;
      if (this.CNE != null) {
        i = paramInt + g.a.a.a.oD(4, this.CNE.computeSize());
      }
      i += g.a.a.b.b.a.bM(5, this.CNF);
      paramInt = i;
      if (this.CNA != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CNA);
      }
      AppMethodBeat.o(41714);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41714);
          return -1;
        case 1: 
          localn.CNB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41714);
          return 0;
        case 2: 
          localn.CNC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(41714);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new b();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((b)localObject2).parseFrom((byte[])localObject1);
            }
            localn.CND = ((b)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dt)localObject2).parseFrom((byte[])localObject1);
            }
            localn.CNE = ((dt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 5: 
          localn.CNF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(41714);
          return 0;
        }
        localn.CNA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(41714);
        return 0;
      }
      AppMethodBeat.o(41714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.n
 * JD-Core Version:    0.7.0.1
 */