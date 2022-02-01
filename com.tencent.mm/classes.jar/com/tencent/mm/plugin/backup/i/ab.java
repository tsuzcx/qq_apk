package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ab
  extends com.tencent.mm.bx.a
{
  public b vgA;
  public int vgz;
  public int vhY;
  public int vhZ;
  public long vhj;
  public long vib;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22134);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vgz);
      if (this.vgA != null) {
        paramVarArgs.d(2, this.vgA);
      }
      paramVarArgs.bS(3, this.vhY);
      paramVarArgs.bS(4, this.vhZ);
      paramVarArgs.bv(5, this.vib);
      paramVarArgs.bv(6, this.vhj);
      AppMethodBeat.o(22134);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.vgz) + 0;
      paramInt = i;
      if (this.vgA != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.vgA);
      }
      i = i.a.a.b.b.a.cJ(3, this.vhY);
      int j = i.a.a.b.b.a.cJ(4, this.vhZ);
      int k = i.a.a.b.b.a.q(5, this.vib);
      int m = i.a.a.b.b.a.q(6, this.vhj);
      AppMethodBeat.o(22134);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(22134);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ab localab = (ab)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22134);
        return -1;
      case 1: 
        localab.vgz = locala.ajGk.aar();
        AppMethodBeat.o(22134);
        return 0;
      case 2: 
        localab.vgA = locala.ajGk.kFX();
        AppMethodBeat.o(22134);
        return 0;
      case 3: 
        localab.vhY = locala.ajGk.aar();
        AppMethodBeat.o(22134);
        return 0;
      case 4: 
        localab.vhZ = locala.ajGk.aar();
        AppMethodBeat.o(22134);
        return 0;
      case 5: 
        localab.vib = locala.ajGk.aaw();
        AppMethodBeat.o(22134);
        return 0;
      }
      localab.vhj = locala.ajGk.aaw();
      AppMethodBeat.o(22134);
      return 0;
    }
    AppMethodBeat.o(22134);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ab
 * JD-Core Version:    0.7.0.1
 */