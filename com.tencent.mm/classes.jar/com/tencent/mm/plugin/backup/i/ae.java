package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b vgA;
  public String vhN;
  public int vhO;
  public int vhQ;
  public int vhR;
  public int vhS;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22137);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vhN == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22137);
        throw paramVarArgs;
      }
      if (this.vhN != null) {
        paramVarArgs.g(1, this.vhN);
      }
      paramVarArgs.bS(2, this.vhO);
      paramVarArgs.bS(3, this.vhQ);
      paramVarArgs.bS(4, this.vhR);
      paramVarArgs.bS(5, this.vhk);
      paramVarArgs.bS(6, this.vhS);
      if (this.vgA != null) {
        paramVarArgs.d(7, this.vgA);
      }
      AppMethodBeat.o(22137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhN == null) {
        break label551;
      }
    }
    label551:
    for (paramInt = i.a.a.b.b.a.h(1, this.vhN) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhO) + i.a.a.b.b.a.cJ(3, this.vhQ) + i.a.a.b.b.a.cJ(4, this.vhR) + i.a.a.b.b.a.cJ(5, this.vhk) + i.a.a.b.b.a.cJ(6, this.vhS);
      paramInt = i;
      if (this.vgA != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.vgA);
      }
      AppMethodBeat.o(22137);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.vhN == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: DataID");
          AppMethodBeat.o(22137);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22137);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22137);
          return -1;
        case 1: 
          localae.vhN = locala.ajGk.readString();
          AppMethodBeat.o(22137);
          return 0;
        case 2: 
          localae.vhO = locala.ajGk.aar();
          AppMethodBeat.o(22137);
          return 0;
        case 3: 
          localae.vhQ = locala.ajGk.aar();
          AppMethodBeat.o(22137);
          return 0;
        case 4: 
          localae.vhR = locala.ajGk.aar();
          AppMethodBeat.o(22137);
          return 0;
        case 5: 
          localae.vhk = locala.ajGk.aar();
          AppMethodBeat.o(22137);
          return 0;
        case 6: 
          localae.vhS = locala.ajGk.aar();
          AppMethodBeat.o(22137);
          return 0;
        }
        localae.vgA = locala.ajGk.kFX();
        AppMethodBeat.o(22137);
        return 0;
      }
      AppMethodBeat.o(22137);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ae
 * JD-Core Version:    0.7.0.1
 */