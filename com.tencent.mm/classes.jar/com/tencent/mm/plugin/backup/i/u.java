package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bw.a
{
  public String fQY;
  public String mediaId;
  public int oUr;
  public int oUs;
  public long oUt;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22126);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oUr);
      if (this.fQY != null) {
        paramVarArgs.e(2, this.fQY);
      }
      if (this.mediaId != null) {
        paramVarArgs.e(3, this.mediaId);
      }
      if (this.path != null) {
        paramVarArgs.e(4, this.path);
      }
      paramVarArgs.aM(5, this.type);
      paramVarArgs.aM(6, this.oUs);
      paramVarArgs.bb(7, this.oUt);
      AppMethodBeat.o(22126);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.oUr) + 0;
      paramInt = i;
      if (this.fQY != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.fQY);
      }
      i = paramInt;
      if (this.mediaId != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.mediaId);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.path);
      }
      i = g.a.a.b.b.a.bu(5, this.type);
      int j = g.a.a.b.b.a.bu(6, this.oUs);
      int k = g.a.a.b.b.a.r(7, this.oUt);
      AppMethodBeat.o(22126);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(22126);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      u localu = (u)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22126);
        return -1;
      case 1: 
        localu.oUr = locala.UbS.zi();
        AppMethodBeat.o(22126);
        return 0;
      case 2: 
        localu.fQY = locala.UbS.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 3: 
        localu.mediaId = locala.UbS.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 4: 
        localu.path = locala.UbS.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 5: 
        localu.type = locala.UbS.zi();
        AppMethodBeat.o(22126);
        return 0;
      case 6: 
        localu.oUs = locala.UbS.zi();
        AppMethodBeat.o(22126);
        return 0;
      }
      localu.oUt = locala.UbS.zl();
      AppMethodBeat.o(22126);
      return 0;
    }
    AppMethodBeat.o(22126);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.u
 * JD-Core Version:    0.7.0.1
 */