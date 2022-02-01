package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bx.a
{
  public String vgy;
  public long vhc;
  public m vhf;
  public int vhh;
  public long vhi;
  public long vhj;
  public int vhk;
  public int vhl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22119);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22119);
        throw paramVarArgs;
      }
      if (this.vgy != null) {
        paramVarArgs.g(1, this.vgy);
      }
      paramVarArgs.bv(2, this.vhi);
      paramVarArgs.bv(3, this.vhj);
      paramVarArgs.bS(4, this.vhk);
      paramVarArgs.bS(5, this.vhl);
      paramVarArgs.bv(6, this.vhc);
      if (this.vhf != null)
      {
        paramVarArgs.qD(7, this.vhf.computeSize());
        this.vhf.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.vhh);
      AppMethodBeat.o(22119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vgy == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = i.a.a.b.b.a.h(1, this.vgy) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.vhi) + i.a.a.b.b.a.q(3, this.vhj) + i.a.a.b.b.a.cJ(4, this.vhk) + i.a.a.b.b.a.cJ(5, this.vhl) + i.a.a.b.b.a.q(6, this.vhc);
      paramInt = i;
      if (this.vhf != null) {
        paramInt = i + i.a.a.a.qC(7, this.vhf.computeSize());
      }
      i = i.a.a.b.b.a.cJ(8, this.vhh);
      AppMethodBeat.o(22119);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.vgy == null)
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22119);
          return -1;
        case 1: 
          localo.vgy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(22119);
          return 0;
        case 2: 
          localo.vhi = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(22119);
          return 0;
        case 3: 
          localo.vhj = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(22119);
          return 0;
        case 4: 
          localo.vhk = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22119);
          return 0;
        case 5: 
          localo.vhl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22119);
          return 0;
        case 6: 
          localo.vhc = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(22119);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            m localm = new m();
            if ((localObject != null) && (localObject.length > 0)) {
              localm.parseFrom((byte[])localObject);
            }
            localo.vhf = localm;
            paramInt += 1;
          }
          AppMethodBeat.o(22119);
          return 0;
        }
        localo.vhh = ((i.a.a.a.a)localObject).ajGk.aar();
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