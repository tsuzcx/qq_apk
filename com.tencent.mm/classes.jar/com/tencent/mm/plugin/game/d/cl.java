package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cl
  extends com.tencent.mm.bv.a
{
  public int niE;
  public String ntH;
  public String ntI;
  public boolean ntJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111649);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ntI == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaURL");
        AppMethodBeat.o(111649);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.niE);
      if (this.ntH != null) {
        paramVarArgs.e(2, this.ntH);
      }
      if (this.ntI != null) {
        paramVarArgs.e(3, this.ntI);
      }
      paramVarArgs.aS(4, this.ntJ);
      AppMethodBeat.o(111649);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.niE) + 0;
      paramInt = i;
      if (this.ntH != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ntH);
      }
      i = paramInt;
      if (this.ntI != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ntI);
      }
      paramInt = e.a.a.b.b.a.eW(4);
      AppMethodBeat.o(111649);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.ntI == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaURL");
        AppMethodBeat.o(111649);
        throw paramVarArgs;
      }
      AppMethodBeat.o(111649);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cl localcl = (cl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(111649);
        return -1;
      case 1: 
        localcl.niE = locala.CLY.sl();
        AppMethodBeat.o(111649);
        return 0;
      case 2: 
        localcl.ntH = locala.CLY.readString();
        AppMethodBeat.o(111649);
        return 0;
      case 3: 
        localcl.ntI = locala.CLY.readString();
        AppMethodBeat.o(111649);
        return 0;
      }
      localcl.ntJ = locala.CLY.emu();
      AppMethodBeat.o(111649);
      return 0;
    }
    AppMethodBeat.o(111649);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cl
 * JD-Core Version:    0.7.0.1
 */