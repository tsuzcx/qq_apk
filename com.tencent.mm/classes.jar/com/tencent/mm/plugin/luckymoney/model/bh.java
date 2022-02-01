package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bh
  extends com.tencent.mm.cd.a
{
  public int EBY;
  public int EBZ;
  public String content;
  public String iconUrl;
  public int jqz;
  public String name;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91259);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.jqz);
      if (this.name != null) {
        paramVarArgs.f(2, this.name);
      }
      if (this.type != null) {
        paramVarArgs.f(3, this.type);
      }
      if (this.content != null) {
        paramVarArgs.f(4, this.content);
      }
      paramVarArgs.aY(5, this.EBY);
      if (this.iconUrl != null) {
        paramVarArgs.f(6, this.iconUrl);
      }
      paramVarArgs.aY(7, this.EBZ);
      AppMethodBeat.o(91259);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.jqz) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.name);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.type);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.content);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.EBY);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.iconUrl);
      }
      i = g.a.a.b.b.a.bM(7, this.EBZ);
      AppMethodBeat.o(91259);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91259);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bh localbh = (bh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91259);
        return -1;
      case 1: 
        localbh.jqz = locala.abFh.AK();
        AppMethodBeat.o(91259);
        return 0;
      case 2: 
        localbh.name = locala.abFh.readString();
        AppMethodBeat.o(91259);
        return 0;
      case 3: 
        localbh.type = locala.abFh.readString();
        AppMethodBeat.o(91259);
        return 0;
      case 4: 
        localbh.content = locala.abFh.readString();
        AppMethodBeat.o(91259);
        return 0;
      case 5: 
        localbh.EBY = locala.abFh.AK();
        AppMethodBeat.o(91259);
        return 0;
      case 6: 
        localbh.iconUrl = locala.abFh.readString();
        AppMethodBeat.o(91259);
        return 0;
      }
      localbh.EBZ = locala.abFh.AK();
      AppMethodBeat.o(91259);
      return 0;
    }
    AppMethodBeat.o(91259);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bh
 * JD-Core Version:    0.7.0.1
 */