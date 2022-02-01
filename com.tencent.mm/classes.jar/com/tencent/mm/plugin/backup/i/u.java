package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bw.a
{
  public String eSi;
  public String mediaId;
  public int ndE;
  public int ndF;
  public long ndG;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22126);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ndE);
      if (this.eSi != null) {
        paramVarArgs.d(2, this.eSi);
      }
      if (this.mediaId != null) {
        paramVarArgs.d(3, this.mediaId);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      paramVarArgs.aR(5, this.type);
      paramVarArgs.aR(6, this.ndF);
      paramVarArgs.aO(7, this.ndG);
      AppMethodBeat.o(22126);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ndE) + 0;
      paramInt = i;
      if (this.eSi != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.eSi);
      }
      i = paramInt;
      if (this.mediaId != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mediaId);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      i = f.a.a.b.b.a.bx(5, this.type);
      int j = f.a.a.b.b.a.bx(6, this.ndF);
      int k = f.a.a.b.b.a.p(7, this.ndG);
      AppMethodBeat.o(22126);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(22126);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      u localu = (u)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22126);
        return -1;
      case 1: 
        localu.ndE = locala.LVo.xF();
        AppMethodBeat.o(22126);
        return 0;
      case 2: 
        localu.eSi = locala.LVo.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 3: 
        localu.mediaId = locala.LVo.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 4: 
        localu.path = locala.LVo.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 5: 
        localu.type = locala.LVo.xF();
        AppMethodBeat.o(22126);
        return 0;
      case 6: 
        localu.ndF = locala.LVo.xF();
        AppMethodBeat.o(22126);
        return 0;
      }
      localu.ndG = locala.LVo.xG();
      AppMethodBeat.o(22126);
      return 0;
    }
    AppMethodBeat.o(22126);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.u
 * JD-Core Version:    0.7.0.1
 */