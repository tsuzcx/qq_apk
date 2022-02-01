package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class p
  extends com.tencent.mm.bx.a
{
  public String vgy;
  public long vhj;
  public int vhm;
  public int vhn;
  public int vho;
  public long vhp;
  public long vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22120);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22120);
        throw paramVarArgs;
      }
      if (this.vgy != null) {
        paramVarArgs.g(1, this.vgy);
      }
      paramVarArgs.bS(2, this.vhm);
      paramVarArgs.bS(3, this.vhn);
      paramVarArgs.bS(4, this.vho);
      paramVarArgs.bv(5, this.vhj);
      paramVarArgs.bv(6, this.vhp);
      paramVarArgs.bv(7, this.vhq);
      AppMethodBeat.o(22120);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vgy == null) {
        break label551;
      }
    }
    label551:
    for (paramInt = i.a.a.b.b.a.h(1, this.vgy) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vhm);
      int j = i.a.a.b.b.a.cJ(3, this.vhn);
      int k = i.a.a.b.b.a.cJ(4, this.vho);
      int m = i.a.a.b.b.a.q(5, this.vhj);
      int n = i.a.a.b.b.a.q(6, this.vhp);
      int i1 = i.a.a.b.b.a.q(7, this.vhq);
      AppMethodBeat.o(22120);
      return paramInt + i + j + k + m + n + i1;
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
          AppMethodBeat.o(22120);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22120);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22120);
          return -1;
        case 1: 
          localp.vgy = locala.ajGk.readString();
          AppMethodBeat.o(22120);
          return 0;
        case 2: 
          localp.vhm = locala.ajGk.aar();
          AppMethodBeat.o(22120);
          return 0;
        case 3: 
          localp.vhn = locala.ajGk.aar();
          AppMethodBeat.o(22120);
          return 0;
        case 4: 
          localp.vho = locala.ajGk.aar();
          AppMethodBeat.o(22120);
          return 0;
        case 5: 
          localp.vhj = locala.ajGk.aaw();
          AppMethodBeat.o(22120);
          return 0;
        case 6: 
          localp.vhp = locala.ajGk.aaw();
          AppMethodBeat.o(22120);
          return 0;
        }
        localp.vhq = locala.ajGk.aaw();
        AppMethodBeat.o(22120);
        return 0;
      }
      AppMethodBeat.o(22120);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.p
 * JD-Core Version:    0.7.0.1
 */