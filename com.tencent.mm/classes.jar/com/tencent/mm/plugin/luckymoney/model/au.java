package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class au
  extends com.tencent.mm.bx.a
{
  public String content;
  public int fYO;
  public String iconUrl;
  public String name;
  public String type;
  public int vqM;
  public int vqN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91259);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.fYO);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.type != null) {
        paramVarArgs.d(3, this.type);
      }
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aS(5, this.vqM);
      if (this.iconUrl != null) {
        paramVarArgs.d(6, this.iconUrl);
      }
      paramVarArgs.aS(7, this.vqN);
      AppMethodBeat.o(91259);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.fYO) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.type);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.vqM);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iconUrl);
      }
      i = f.a.a.b.b.a.bz(7, this.vqN);
      AppMethodBeat.o(91259);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91259);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      au localau = (au)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91259);
        return -1;
      case 1: 
        localau.fYO = locala.NPN.zc();
        AppMethodBeat.o(91259);
        return 0;
      case 2: 
        localau.name = locala.NPN.readString();
        AppMethodBeat.o(91259);
        return 0;
      case 3: 
        localau.type = locala.NPN.readString();
        AppMethodBeat.o(91259);
        return 0;
      case 4: 
        localau.content = locala.NPN.readString();
        AppMethodBeat.o(91259);
        return 0;
      case 5: 
        localau.vqM = locala.NPN.zc();
        AppMethodBeat.o(91259);
        return 0;
      case 6: 
        localau.iconUrl = locala.NPN.readString();
        AppMethodBeat.o(91259);
        return 0;
      }
      localau.vqN = locala.NPN.zc();
      AppMethodBeat.o(91259);
      return 0;
    }
    AppMethodBeat.o(91259);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.au
 * JD-Core Version:    0.7.0.1
 */