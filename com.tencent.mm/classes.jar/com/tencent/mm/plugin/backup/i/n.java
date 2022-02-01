package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bw.a
{
  public String ID;
  public long oTO;
  public long oTP;
  public long oTQ;
  public m oTR;
  public long oTS;
  public int oTT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22118);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22118);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.e(1, this.ID);
      }
      paramVarArgs.bb(2, this.oTO);
      paramVarArgs.bb(3, this.oTP);
      paramVarArgs.bb(4, this.oTQ);
      if (this.oTR != null)
      {
        paramVarArgs.ni(5, this.oTR.computeSize());
        this.oTR.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.oTS);
      paramVarArgs.aM(7, this.oTT);
      AppMethodBeat.o(22118);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label655;
      }
    }
    label655:
    for (paramInt = g.a.a.b.b.a.f(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.oTO) + g.a.a.b.b.a.r(3, this.oTP) + g.a.a.b.b.a.r(4, this.oTQ);
      paramInt = i;
      if (this.oTR != null) {
        paramInt = i + g.a.a.a.nh(5, this.oTR.computeSize());
      }
      i = g.a.a.b.b.a.r(6, this.oTS);
      int j = g.a.a.b.b.a.bu(7, this.oTT);
      AppMethodBeat.o(22118);
      return paramInt + i + j;
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
          AppMethodBeat.o(22118);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22118);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22118);
          return -1;
        case 1: 
          localn.ID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(22118);
          return 0;
        case 2: 
          localn.oTO = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(22118);
          return 0;
        case 3: 
          localn.oTP = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(22118);
          return 0;
        case 4: 
          localn.oTQ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(22118);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localn.oTR = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22118);
          return 0;
        case 6: 
          localn.oTS = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(22118);
          return 0;
        }
        localn.oTT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(22118);
        return 0;
      }
      AppMethodBeat.o(22118);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.n
 * JD-Core Version:    0.7.0.1
 */