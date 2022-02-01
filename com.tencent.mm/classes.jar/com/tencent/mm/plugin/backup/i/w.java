package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.bw.a
{
  public String ID;
  public int Version;
  public com.tencent.mm.bw.b ncy;
  public int ndH;
  public int ndI;
  public int ndJ;
  public com.tencent.mm.bw.b ndL;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22128);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22128);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.ndH);
      paramVarArgs.aR(2, this.ndj);
      if (this.ID != null) {
        paramVarArgs.d(3, this.ID);
      }
      if (this.ncy != null) {
        paramVarArgs.c(4, this.ncy);
      }
      paramVarArgs.aR(5, this.Version);
      paramVarArgs.aR(6, this.ndI);
      paramVarArgs.aR(7, this.ndJ);
      if (this.ndL != null) {
        paramVarArgs.c(8, this.ndL);
      }
      AppMethodBeat.o(22128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ndH) + 0 + f.a.a.b.b.a.bx(2, this.ndj);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ID);
      }
      i = paramInt;
      if (this.ncy != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.ncy);
      }
      i = i + f.a.a.b.b.a.bx(5, this.Version) + f.a.a.b.b.a.bx(6, this.ndI) + f.a.a.b.b.a.bx(7, this.ndJ);
      paramInt = i;
      if (this.ndL != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.ndL);
      }
      AppMethodBeat.o(22128);
      return paramInt;
    }
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
        paramVarArgs = new f.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22128);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22128);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22128);
        return -1;
      case 1: 
        localw.ndH = locala.LVo.xF();
        AppMethodBeat.o(22128);
        return 0;
      case 2: 
        localw.ndj = locala.LVo.xF();
        AppMethodBeat.o(22128);
        return 0;
      case 3: 
        localw.ID = locala.LVo.readString();
        AppMethodBeat.o(22128);
        return 0;
      case 4: 
        localw.ncy = locala.LVo.gfk();
        AppMethodBeat.o(22128);
        return 0;
      case 5: 
        localw.Version = locala.LVo.xF();
        AppMethodBeat.o(22128);
        return 0;
      case 6: 
        localw.ndI = locala.LVo.xF();
        AppMethodBeat.o(22128);
        return 0;
      case 7: 
        localw.ndJ = locala.LVo.xF();
        AppMethodBeat.o(22128);
        return 0;
      }
      localw.ndL = locala.LVo.gfk();
      AppMethodBeat.o(22128);
      return 0;
    }
    AppMethodBeat.o(22128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.w
 * JD-Core Version:    0.7.0.1
 */