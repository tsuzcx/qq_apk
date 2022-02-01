package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aa
  extends com.tencent.mm.bx.a
{
  public String mAI;
  public long mBS;
  public long mBT;
  public String mBU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22133);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAI == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22133);
        throw paramVarArgs;
      }
      if (this.mBU == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgDataID");
        AppMethodBeat.o(22133);
        throw paramVarArgs;
      }
      if (this.mAI != null) {
        paramVarArgs.d(1, this.mAI);
      }
      paramVarArgs.aG(2, this.mBS);
      paramVarArgs.aG(3, this.mBT);
      if (this.mBU != null) {
        paramVarArgs.d(4, this.mBU);
      }
      AppMethodBeat.o(22133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAI == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAI) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.mBS) + f.a.a.b.b.a.q(3, this.mBT);
      paramInt = i;
      if (this.mBU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mBU);
      }
      AppMethodBeat.o(22133);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.mAI == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(22133);
          throw paramVarArgs;
        }
        if (this.mBU == null)
        {
          paramVarArgs = new b("Not all required fields were included: MsgDataID");
          AppMethodBeat.o(22133);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22133);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22133);
          return -1;
        case 1: 
          localaa.mAI = locala.KhF.readString();
          AppMethodBeat.o(22133);
          return 0;
        case 2: 
          localaa.mBS = locala.KhF.xT();
          AppMethodBeat.o(22133);
          return 0;
        case 3: 
          localaa.mBT = locala.KhF.xT();
          AppMethodBeat.o(22133);
          return 0;
        }
        localaa.mBU = locala.KhF.readString();
        AppMethodBeat.o(22133);
        return 0;
      }
      AppMethodBeat.o(22133);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.aa
 * JD-Core Version:    0.7.0.1
 */