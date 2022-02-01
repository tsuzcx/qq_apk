package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bx.a
{
  public String mAI;
  public LinkedList<Long> mCd;
  public LinkedList<String> mCe;
  public LinkedList<String> mCf;
  
  public ag()
  {
    AppMethodBeat.i(22140);
    this.mCd = new LinkedList();
    this.mCe = new LinkedList();
    this.mCf = new LinkedList();
    AppMethodBeat.o(22140);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22141);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAI == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22141);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 3, this.mCd);
      paramVarArgs.e(2, 1, this.mCe);
      paramVarArgs.e(3, 1, this.mCf);
      if (this.mAI != null) {
        paramVarArgs.d(4, this.mAI);
      }
      AppMethodBeat.o(22141);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.a.c(1, 3, this.mCd) + 0 + f.a.a.a.c(2, 1, this.mCe) + f.a.a.a.c(3, 1, this.mCf);
      paramInt = i;
      if (this.mAI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mAI);
      }
      AppMethodBeat.o(22141);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.mCd.clear();
      this.mCe.clear();
      this.mCf.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.mAI == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22141);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22141);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ag localag = (ag)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22141);
        return -1;
      case 1: 
        localag.mCd.add(Long.valueOf(locala.KhF.xT()));
        AppMethodBeat.o(22141);
        return 0;
      case 2: 
        localag.mCe.add(locala.KhF.readString());
        AppMethodBeat.o(22141);
        return 0;
      case 3: 
        localag.mCf.add(locala.KhF.readString());
        AppMethodBeat.o(22141);
        return 0;
      }
      localag.mAI = locala.KhF.readString();
      AppMethodBeat.o(22141);
      return 0;
    }
    AppMethodBeat.o(22141);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ag
 * JD-Core Version:    0.7.0.1
 */