package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ds
  extends com.tencent.mm.bx.a
{
  public int ILB;
  public long ILC;
  public String ILD;
  public boolean ILE;
  public int ILF;
  public String ILG;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41828);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(41828);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      paramVarArgs.bS(2, this.ILB);
      paramVarArgs.bv(3, this.ILC);
      if (this.ILD != null) {
        paramVarArgs.g(4, this.ILD);
      }
      paramVarArgs.di(5, this.ILE);
      paramVarArgs.bS(6, this.ILF);
      if (this.ILG != null) {
        paramVarArgs.g(7, this.ILG);
      }
      AppMethodBeat.o(41828);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ILB) + i.a.a.b.b.a.q(3, this.ILC);
      paramInt = i;
      if (this.ILD != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ILD);
      }
      i = paramInt + (i.a.a.b.b.a.ko(5) + 1) + i.a.a.b.b.a.cJ(6, this.ILF);
      paramInt = i;
      if (this.ILG != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ILG);
      }
      AppMethodBeat.o(41828);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.UserName == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ds localds = (ds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41828);
          return -1;
        case 1: 
          localds.UserName = locala.ajGk.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 2: 
          localds.ILB = locala.ajGk.aar();
          AppMethodBeat.o(41828);
          return 0;
        case 3: 
          localds.ILC = locala.ajGk.aaw();
          AppMethodBeat.o(41828);
          return 0;
        case 4: 
          localds.ILD = locala.ajGk.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 5: 
          localds.ILE = locala.ajGk.aai();
          AppMethodBeat.o(41828);
          return 0;
        case 6: 
          localds.ILF = locala.ajGk.aar();
          AppMethodBeat.o(41828);
          return 0;
        }
        localds.ILG = locala.ajGk.readString();
        AppMethodBeat.o(41828);
        return 0;
      }
      AppMethodBeat.o(41828);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ds
 * JD-Core Version:    0.7.0.1
 */