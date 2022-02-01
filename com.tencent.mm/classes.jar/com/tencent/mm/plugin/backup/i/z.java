package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class z
  extends com.tencent.mm.bx.a
{
  public String mAI;
  public long mBS;
  public long mBT;
  public String mBU;
  public String mBV;
  public LinkedList<String> mBz;
  
  public z()
  {
    AppMethodBeat.i(22131);
    this.mBz = new LinkedList();
    AppMethodBeat.o(22131);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22132);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAI == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.mBU == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgDataID");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.mBV == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(22132);
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
      if (this.mBV != null) {
        paramVarArgs.d(5, this.mBV);
      }
      paramVarArgs.e(6, 1, this.mBz);
      AppMethodBeat.o(22132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAI == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAI) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.mBS) + f.a.a.b.b.a.q(3, this.mBT);
      paramInt = i;
      if (this.mBU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mBU);
      }
      i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mBV);
      }
      paramInt = f.a.a.a.c(6, 1, this.mBz);
      AppMethodBeat.o(22132);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mBz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.mAI == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.mBU == null)
        {
          paramVarArgs = new b("Not all required fields were included: MsgDataID");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.mBV == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22132);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22132);
          return -1;
        case 1: 
          localz.mAI = locala.KhF.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 2: 
          localz.mBS = locala.KhF.xT();
          AppMethodBeat.o(22132);
          return 0;
        case 3: 
          localz.mBT = locala.KhF.xT();
          AppMethodBeat.o(22132);
          return 0;
        case 4: 
          localz.mBU = locala.KhF.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 5: 
          localz.mBV = locala.KhF.readString();
          AppMethodBeat.o(22132);
          return 0;
        }
        localz.mBz.add(locala.KhF.readString());
        AppMethodBeat.o(22132);
        return 0;
      }
      AppMethodBeat.o(22132);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.z
 * JD-Core Version:    0.7.0.1
 */