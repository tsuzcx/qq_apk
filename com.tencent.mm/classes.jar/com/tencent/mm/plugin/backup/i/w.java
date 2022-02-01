package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.bx.a
{
  public String ID;
  public int Version;
  public com.tencent.mm.bx.b mAx;
  public int mBG;
  public int mBH;
  public int mBI;
  public com.tencent.mm.bx.b mBK;
  public int mBi;
  
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
      paramVarArgs.aR(1, this.mBG);
      paramVarArgs.aR(2, this.mBi);
      if (this.ID != null) {
        paramVarArgs.d(3, this.ID);
      }
      if (this.mAx != null) {
        paramVarArgs.c(4, this.mAx);
      }
      paramVarArgs.aR(5, this.Version);
      paramVarArgs.aR(6, this.mBH);
      paramVarArgs.aR(7, this.mBI);
      if (this.mBK != null) {
        paramVarArgs.c(8, this.mBK);
      }
      AppMethodBeat.o(22128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.mBG) + 0 + f.a.a.b.b.a.bA(2, this.mBi);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ID);
      }
      i = paramInt;
      if (this.mAx != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.mAx);
      }
      i = i + f.a.a.b.b.a.bA(5, this.Version) + f.a.a.b.b.a.bA(6, this.mBH) + f.a.a.b.b.a.bA(7, this.mBI);
      paramInt = i;
      if (this.mBK != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.mBK);
      }
      AppMethodBeat.o(22128);
      return paramInt;
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
        localw.mBG = locala.KhF.xS();
        AppMethodBeat.o(22128);
        return 0;
      case 2: 
        localw.mBi = locala.KhF.xS();
        AppMethodBeat.o(22128);
        return 0;
      case 3: 
        localw.ID = locala.KhF.readString();
        AppMethodBeat.o(22128);
        return 0;
      case 4: 
        localw.mAx = locala.KhF.fMu();
        AppMethodBeat.o(22128);
        return 0;
      case 5: 
        localw.Version = locala.KhF.xS();
        AppMethodBeat.o(22128);
        return 0;
      case 6: 
        localw.mBH = locala.KhF.xS();
        AppMethodBeat.o(22128);
        return 0;
      case 7: 
        localw.mBI = locala.KhF.xS();
        AppMethodBeat.o(22128);
        return 0;
      }
      localw.mBK = locala.KhF.fMu();
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