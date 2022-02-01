package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class au
  extends com.tencent.mm.bw.a
{
  public String content;
  public int fFp;
  public String iconUrl;
  public String name;
  public String type;
  public int uoi;
  public int uoj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91259);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.fFp);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.type != null) {
        paramVarArgs.d(3, this.type);
      }
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aR(5, this.uoi);
      if (this.iconUrl != null) {
        paramVarArgs.d(6, this.iconUrl);
      }
      paramVarArgs.aR(7, this.uoj);
      AppMethodBeat.o(91259);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.fFp) + 0;
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
      i = paramInt + f.a.a.b.b.a.bx(5, this.uoi);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iconUrl);
      }
      i = f.a.a.b.b.a.bx(7, this.uoj);
      AppMethodBeat.o(91259);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localau.fFp = locala.LVo.xF();
        AppMethodBeat.o(91259);
        return 0;
      case 2: 
        localau.name = locala.LVo.readString();
        AppMethodBeat.o(91259);
        return 0;
      case 3: 
        localau.type = locala.LVo.readString();
        AppMethodBeat.o(91259);
        return 0;
      case 4: 
        localau.content = locala.LVo.readString();
        AppMethodBeat.o(91259);
        return 0;
      case 5: 
        localau.uoi = locala.LVo.xF();
        AppMethodBeat.o(91259);
        return 0;
      case 6: 
        localau.iconUrl = locala.LVo.readString();
        AppMethodBeat.o(91259);
        return 0;
      }
      localau.uoj = locala.LVo.xF();
      AppMethodBeat.o(91259);
      return 0;
    }
    AppMethodBeat.o(91259);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.au
 * JD-Core Version:    0.7.0.1
 */