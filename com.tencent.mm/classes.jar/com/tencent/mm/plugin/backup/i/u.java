package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bx.a
{
  public String ePa;
  public int mBD;
  public int mBE;
  public long mBF;
  public String mediaId;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22126);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mBD);
      if (this.ePa != null) {
        paramVarArgs.d(2, this.ePa);
      }
      if (this.mediaId != null) {
        paramVarArgs.d(3, this.mediaId);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      paramVarArgs.aR(5, this.type);
      paramVarArgs.aR(6, this.mBE);
      paramVarArgs.aG(7, this.mBF);
      AppMethodBeat.o(22126);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.mBD) + 0;
      paramInt = i;
      if (this.ePa != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ePa);
      }
      i = paramInt;
      if (this.mediaId != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mediaId);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      i = f.a.a.b.b.a.bA(5, this.type);
      int j = f.a.a.b.b.a.bA(6, this.mBE);
      int k = f.a.a.b.b.a.q(7, this.mBF);
      AppMethodBeat.o(22126);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localu.mBD = locala.KhF.xS();
        AppMethodBeat.o(22126);
        return 0;
      case 2: 
        localu.ePa = locala.KhF.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 3: 
        localu.mediaId = locala.KhF.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 4: 
        localu.path = locala.KhF.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 5: 
        localu.type = locala.KhF.xS();
        AppMethodBeat.o(22126);
        return 0;
      case 6: 
        localu.mBE = locala.KhF.xS();
        AppMethodBeat.o(22126);
        return 0;
      }
      localu.mBF = locala.KhF.xT();
      AppMethodBeat.o(22126);
      return 0;
    }
    AppMethodBeat.o(22126);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.u
 * JD-Core Version:    0.7.0.1
 */