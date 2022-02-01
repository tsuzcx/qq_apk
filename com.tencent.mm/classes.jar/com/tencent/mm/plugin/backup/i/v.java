package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends com.tencent.mm.bx.a
{
  public String ID;
  public int Version;
  public com.tencent.mm.bx.b mAx;
  public int mBG;
  public int mBH;
  public int mBI;
  public int mBJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22127);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22127);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.mBG);
      if (this.ID != null) {
        paramVarArgs.d(2, this.ID);
      }
      if (this.mAx != null) {
        paramVarArgs.c(3, this.mAx);
      }
      paramVarArgs.aR(4, this.Version);
      paramVarArgs.aR(5, this.mBH);
      paramVarArgs.aR(6, this.mBI);
      paramVarArgs.aR(7, this.mBJ);
      AppMethodBeat.o(22127);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.mBG) + 0;
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ID);
      }
      i = paramInt;
      if (this.mAx != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.mAx);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.Version);
      int j = f.a.a.b.b.a.bA(5, this.mBH);
      int k = f.a.a.b.b.a.bA(6, this.mBI);
      int m = f.a.a.b.b.a.bA(7, this.mBJ);
      AppMethodBeat.o(22127);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.ID == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22127);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22127);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      v localv = (v)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22127);
        return -1;
      case 1: 
        localv.mBG = locala.KhF.xS();
        AppMethodBeat.o(22127);
        return 0;
      case 2: 
        localv.ID = locala.KhF.readString();
        AppMethodBeat.o(22127);
        return 0;
      case 3: 
        localv.mAx = locala.KhF.fMu();
        AppMethodBeat.o(22127);
        return 0;
      case 4: 
        localv.Version = locala.KhF.xS();
        AppMethodBeat.o(22127);
        return 0;
      case 5: 
        localv.mBH = locala.KhF.xS();
        AppMethodBeat.o(22127);
        return 0;
      case 6: 
        localv.mBI = locala.KhF.xS();
        AppMethodBeat.o(22127);
        return 0;
      }
      localv.mBJ = locala.KhF.xS();
      AppMethodBeat.o(22127);
      return 0;
    }
    AppMethodBeat.o(22127);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.v
 * JD-Core Version:    0.7.0.1
 */