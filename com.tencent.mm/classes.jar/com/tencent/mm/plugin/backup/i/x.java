package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b vgA;
  public String vhN;
  public int vhO;
  public int vhP;
  public int vhQ;
  public int vhR;
  public int vhS;
  public int vhT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22129);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vhN == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22129);
        throw paramVarArgs;
      }
      if (this.vhN != null) {
        paramVarArgs.g(1, this.vhN);
      }
      paramVarArgs.bS(2, this.vhO);
      paramVarArgs.bS(3, this.vhP);
      paramVarArgs.bS(4, this.vhQ);
      paramVarArgs.bS(5, this.vhR);
      paramVarArgs.bS(6, this.vhS);
      if (this.vgA != null) {
        paramVarArgs.d(7, this.vgA);
      }
      paramVarArgs.bS(8, this.vhT);
      AppMethodBeat.o(22129);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhN == null) {
        break label596;
      }
    }
    label596:
    for (paramInt = i.a.a.b.b.a.h(1, this.vhN) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhO) + i.a.a.b.b.a.cJ(3, this.vhP) + i.a.a.b.b.a.cJ(4, this.vhQ) + i.a.a.b.b.a.cJ(5, this.vhR) + i.a.a.b.b.a.cJ(6, this.vhS);
      paramInt = i;
      if (this.vgA != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.vgA);
      }
      i = i.a.a.b.b.a.cJ(8, this.vhT);
      AppMethodBeat.o(22129);
      return paramInt + i;
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
          AppMethodBeat.o(22129);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22129);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22129);
          return -1;
        case 1: 
          localx.vhN = locala.ajGk.readString();
          AppMethodBeat.o(22129);
          return 0;
        case 2: 
          localx.vhO = locala.ajGk.aar();
          AppMethodBeat.o(22129);
          return 0;
        case 3: 
          localx.vhP = locala.ajGk.aar();
          AppMethodBeat.o(22129);
          return 0;
        case 4: 
          localx.vhQ = locala.ajGk.aar();
          AppMethodBeat.o(22129);
          return 0;
        case 5: 
          localx.vhR = locala.ajGk.aar();
          AppMethodBeat.o(22129);
          return 0;
        case 6: 
          localx.vhS = locala.ajGk.aar();
          AppMethodBeat.o(22129);
          return 0;
        case 7: 
          localx.vgA = locala.ajGk.kFX();
          AppMethodBeat.o(22129);
          return 0;
        }
        localx.vhT = locala.ajGk.aar();
        AppMethodBeat.o(22129);
        return 0;
      }
      AppMethodBeat.o(22129);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.x
 * JD-Core Version:    0.7.0.1
 */