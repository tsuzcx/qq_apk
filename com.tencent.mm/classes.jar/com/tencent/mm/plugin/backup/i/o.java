package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bw.a
{
  public String ID;
  public long oTO;
  public m oTR;
  public int oTT;
  public long oTU;
  public long oTV;
  public int oTW;
  public int oTX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22119);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22119);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.e(1, this.ID);
      }
      paramVarArgs.bb(2, this.oTU);
      paramVarArgs.bb(3, this.oTV);
      paramVarArgs.aM(4, this.oTW);
      paramVarArgs.aM(5, this.oTX);
      paramVarArgs.bb(6, this.oTO);
      if (this.oTR != null)
      {
        paramVarArgs.ni(7, this.oTR.computeSize());
        this.oTR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.oTT);
      AppMethodBeat.o(22119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label696;
      }
    }
    label696:
    for (paramInt = g.a.a.b.b.a.f(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.oTU) + g.a.a.b.b.a.r(3, this.oTV) + g.a.a.b.b.a.bu(4, this.oTW) + g.a.a.b.b.a.bu(5, this.oTX) + g.a.a.b.b.a.r(6, this.oTO);
      paramInt = i;
      if (this.oTR != null) {
        paramInt = i + g.a.a.a.nh(7, this.oTR.computeSize());
      }
      i = g.a.a.b.b.a.bu(8, this.oTT);
      AppMethodBeat.o(22119);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22119);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22119);
          return -1;
        case 1: 
          localo.ID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(22119);
          return 0;
        case 2: 
          localo.oTU = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(22119);
          return 0;
        case 3: 
          localo.oTV = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(22119);
          return 0;
        case 4: 
          localo.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22119);
          return 0;
        case 5: 
          localo.oTX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22119);
          return 0;
        case 6: 
          localo.oTO = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(22119);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localo.oTR = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22119);
          return 0;
        }
        localo.oTT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(22119);
        return 0;
      }
      AppMethodBeat.o(22119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.o
 * JD-Core Version:    0.7.0.1
 */