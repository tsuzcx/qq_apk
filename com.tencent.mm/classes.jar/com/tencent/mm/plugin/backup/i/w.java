package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.bw.a
{
  public String ID;
  public int Version;
  public int oTW;
  public com.tencent.mm.bw.b oTm;
  public int oUu;
  public int oUv;
  public int oUw;
  public com.tencent.mm.bw.b oUy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22128);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22128);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.oUu);
      paramVarArgs.aM(2, this.oTW);
      if (this.ID != null) {
        paramVarArgs.e(3, this.ID);
      }
      if (this.oTm != null) {
        paramVarArgs.c(4, this.oTm);
      }
      paramVarArgs.aM(5, this.Version);
      paramVarArgs.aM(6, this.oUv);
      paramVarArgs.aM(7, this.oUw);
      if (this.oUy != null) {
        paramVarArgs.c(8, this.oUy);
      }
      AppMethodBeat.o(22128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.oUu) + 0 + g.a.a.b.b.a.bu(2, this.oTW);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.ID);
      }
      i = paramInt;
      if (this.oTm != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.oTm);
      }
      i = i + g.a.a.b.b.a.bu(5, this.Version) + g.a.a.b.b.a.bu(6, this.oUv) + g.a.a.b.b.a.bu(7, this.oUw);
      paramInt = i;
      if (this.oUy != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.oUy);
      }
      AppMethodBeat.o(22128);
      return paramInt;
    }
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
        paramVarArgs = new g.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22128);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22128);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22128);
        return -1;
      case 1: 
        localw.oUu = locala.UbS.zi();
        AppMethodBeat.o(22128);
        return 0;
      case 2: 
        localw.oTW = locala.UbS.zi();
        AppMethodBeat.o(22128);
        return 0;
      case 3: 
        localw.ID = locala.UbS.readString();
        AppMethodBeat.o(22128);
        return 0;
      case 4: 
        localw.oTm = locala.UbS.hPo();
        AppMethodBeat.o(22128);
        return 0;
      case 5: 
        localw.Version = locala.UbS.zi();
        AppMethodBeat.o(22128);
        return 0;
      case 6: 
        localw.oUv = locala.UbS.zi();
        AppMethodBeat.o(22128);
        return 0;
      case 7: 
        localw.oUw = locala.UbS.zi();
        AppMethodBeat.o(22128);
        return 0;
      }
      localw.oUy = locala.UbS.hPo();
      AppMethodBeat.o(22128);
      return 0;
    }
    AppMethodBeat.o(22128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.w
 * JD-Core Version:    0.7.0.1
 */