package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cx
  extends com.tencent.mm.bx.a
{
  public String Label;
  public String mAQ;
  public int sdA;
  public long sdB;
  public boolean sdC;
  public int sdD;
  public String sdE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41828);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(41828);
        throw paramVarArgs;
      }
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      paramVarArgs.aR(2, this.sdA);
      paramVarArgs.aG(3, this.sdB);
      if (this.Label != null) {
        paramVarArgs.d(4, this.Label);
      }
      paramVarArgs.bg(5, this.sdC);
      paramVarArgs.aR(6, this.sdD);
      if (this.sdE != null) {
        paramVarArgs.d(7, this.sdE);
      }
      AppMethodBeat.o(41828);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.sdA) + f.a.a.b.b.a.q(3, this.sdB);
      paramInt = i;
      if (this.Label != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Label);
      }
      i = paramInt + (f.a.a.b.b.a.fY(5) + 1) + f.a.a.b.b.a.bA(6, this.sdD);
      paramInt = i;
      if (this.sdE != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.sdE);
      }
      AppMethodBeat.o(41828);
      return paramInt;
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
          AppMethodBeat.o(41828);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41828);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cx localcx = (cx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41828);
          return -1;
        case 1: 
          localcx.mAQ = locala.KhF.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 2: 
          localcx.sdA = locala.KhF.xS();
          AppMethodBeat.o(41828);
          return 0;
        case 3: 
          localcx.sdB = locala.KhF.xT();
          AppMethodBeat.o(41828);
          return 0;
        case 4: 
          localcx.Label = locala.KhF.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 5: 
          localcx.sdC = locala.KhF.fHu();
          AppMethodBeat.o(41828);
          return 0;
        case 6: 
          localcx.sdD = locala.KhF.xS();
          AppMethodBeat.o(41828);
          return 0;
        }
        localcx.sdE = locala.KhF.readString();
        AppMethodBeat.o(41828);
        return 0;
      }
      AppMethodBeat.o(41828);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cx
 * JD-Core Version:    0.7.0.1
 */