package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bw.a
{
  public String ID;
  public long ndb;
  public long ndc;
  public long ndd;
  public m nde;
  public long ndf;
  public int ndg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22118);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22118);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      paramVarArgs.aO(2, this.ndb);
      paramVarArgs.aO(3, this.ndc);
      paramVarArgs.aO(4, this.ndd);
      if (this.nde != null)
      {
        paramVarArgs.ln(5, this.nde.computeSize());
        this.nde.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.ndf);
      paramVarArgs.aR(7, this.ndg);
      AppMethodBeat.o(22118);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label655;
      }
    }
    label655:
    for (paramInt = f.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.ndb) + f.a.a.b.b.a.p(3, this.ndc) + f.a.a.b.b.a.p(4, this.ndd);
      paramInt = i;
      if (this.nde != null) {
        paramInt = i + f.a.a.a.lm(5, this.nde.computeSize());
      }
      i = f.a.a.b.b.a.p(6, this.ndf);
      int j = f.a.a.b.b.a.bx(7, this.ndg);
      AppMethodBeat.o(22118);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22118);
          return -1;
        case 1: 
          localn.ID = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(22118);
          return 0;
        case 2: 
          localn.ndb = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(22118);
          return 0;
        case 3: 
          localn.ndc = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(22118);
          return 0;
        case 4: 
          localn.ndd = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(22118);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localn.nde = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22118);
          return 0;
        case 6: 
          localn.ndf = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(22118);
          return 0;
        }
        localn.ndg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(22118);
        return 0;
      }
      AppMethodBeat.o(22118);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.n
 * JD-Core Version:    0.7.0.1
 */