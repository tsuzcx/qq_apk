package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bx.a
{
  public String vgy;
  public long vhc;
  public long vhd;
  public long vhe;
  public m vhf;
  public long vhg;
  public int vhh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22118);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22118);
        throw paramVarArgs;
      }
      if (this.vgy != null) {
        paramVarArgs.g(1, this.vgy);
      }
      paramVarArgs.bv(2, this.vhc);
      paramVarArgs.bv(3, this.vhd);
      paramVarArgs.bv(4, this.vhe);
      if (this.vhf != null)
      {
        paramVarArgs.qD(5, this.vhf.computeSize());
        this.vhf.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.vhg);
      paramVarArgs.bS(7, this.vhh);
      AppMethodBeat.o(22118);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vgy == null) {
        break label629;
      }
    }
    label629:
    for (paramInt = i.a.a.b.b.a.h(1, this.vgy) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.vhc) + i.a.a.b.b.a.q(3, this.vhd) + i.a.a.b.b.a.q(4, this.vhe);
      paramInt = i;
      if (this.vhf != null) {
        paramInt = i + i.a.a.a.qC(5, this.vhf.computeSize());
      }
      i = i.a.a.b.b.a.q(6, this.vhg);
      int j = i.a.a.b.b.a.cJ(7, this.vhh);
      AppMethodBeat.o(22118);
      return paramInt + i + j;
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
          AppMethodBeat.o(22118);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22118);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22118);
          return -1;
        case 1: 
          localn.vgy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(22118);
          return 0;
        case 2: 
          localn.vhc = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(22118);
          return 0;
        case 3: 
          localn.vhd = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(22118);
          return 0;
        case 4: 
          localn.vhe = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(22118);
          return 0;
        case 5: 
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
            localn.vhf = localm;
            paramInt += 1;
          }
          AppMethodBeat.o(22118);
          return 0;
        case 6: 
          localn.vhg = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(22118);
          return 0;
        }
        localn.vhh = ((i.a.a.a.a)localObject).ajGk.aar();
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