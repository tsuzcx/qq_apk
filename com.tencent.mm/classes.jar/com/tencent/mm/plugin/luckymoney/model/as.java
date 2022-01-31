package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
  extends com.tencent.mm.bv.a
{
  public String content;
  public int eoD;
  public String iconUrl;
  public String name;
  public int opO;
  public int opP;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56616);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.eoD);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      if (this.type != null) {
        paramVarArgs.e(3, this.type);
      }
      if (this.content != null) {
        paramVarArgs.e(4, this.content);
      }
      paramVarArgs.aO(5, this.opO);
      if (this.iconUrl != null) {
        paramVarArgs.e(6, this.iconUrl);
      }
      paramVarArgs.aO(7, this.opP);
      AppMethodBeat.o(56616);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.eoD) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.type);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.content);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.opO);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.iconUrl);
      }
      i = e.a.a.b.b.a.bl(7, this.opP);
      AppMethodBeat.o(56616);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56616);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      as localas = (as)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56616);
        return -1;
      case 1: 
        localas.eoD = locala.CLY.sl();
        AppMethodBeat.o(56616);
        return 0;
      case 2: 
        localas.name = locala.CLY.readString();
        AppMethodBeat.o(56616);
        return 0;
      case 3: 
        localas.type = locala.CLY.readString();
        AppMethodBeat.o(56616);
        return 0;
      case 4: 
        localas.content = locala.CLY.readString();
        AppMethodBeat.o(56616);
        return 0;
      case 5: 
        localas.opO = locala.CLY.sl();
        AppMethodBeat.o(56616);
        return 0;
      case 6: 
        localas.iconUrl = locala.CLY.readString();
        AppMethodBeat.o(56616);
        return 0;
      }
      localas.opP = locala.CLY.sl();
      AppMethodBeat.o(56616);
      return 0;
    }
    AppMethodBeat.o(56616);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.as
 * JD-Core Version:    0.7.0.1
 */