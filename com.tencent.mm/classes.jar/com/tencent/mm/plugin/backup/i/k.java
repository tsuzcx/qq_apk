package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class k
  extends com.tencent.mm.bx.a
{
  public int mAO;
  public int mAP;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22114);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(22114);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.mAO);
      paramVarArgs.aR(2, this.mAP);
      if (this.mAQ != null) {
        paramVarArgs.d(3, this.mAQ);
      }
      AppMethodBeat.o(22114);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.mAO) + 0 + f.a.a.b.b.a.bA(2, this.mAP);
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.mAQ);
      }
      AppMethodBeat.o(22114);
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
      if (this.mAQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(22114);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22114);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22114);
        return -1;
      case 1: 
        localk.mAO = locala.KhF.xS();
        AppMethodBeat.o(22114);
        return 0;
      case 2: 
        localk.mAP = locala.KhF.xS();
        AppMethodBeat.o(22114);
        return 0;
      }
      localk.mAQ = locala.KhF.readString();
      AppMethodBeat.o(22114);
      return 0;
    }
    AppMethodBeat.o(22114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.k
 * JD-Core Version:    0.7.0.1
 */