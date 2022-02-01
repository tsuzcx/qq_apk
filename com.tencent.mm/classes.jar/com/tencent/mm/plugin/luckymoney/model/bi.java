package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bi
  extends com.tencent.mm.bx.a
{
  public int KuZ;
  public int Kva;
  public String content;
  public String iconUrl;
  public int lTH;
  public String name;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91259);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.lTH);
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      if (this.type != null) {
        paramVarArgs.g(3, this.type);
      }
      if (this.content != null) {
        paramVarArgs.g(4, this.content);
      }
      paramVarArgs.bS(5, this.KuZ);
      if (this.iconUrl != null) {
        paramVarArgs.g(6, this.iconUrl);
      }
      paramVarArgs.bS(7, this.Kva);
      AppMethodBeat.o(91259);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.lTH) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.name);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.type);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.content);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.KuZ);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.iconUrl);
      }
      i = i.a.a.b.b.a.cJ(7, this.Kva);
      AppMethodBeat.o(91259);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91259);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bi localbi = (bi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91259);
        return -1;
      case 1: 
        localbi.lTH = locala.ajGk.aar();
        AppMethodBeat.o(91259);
        return 0;
      case 2: 
        localbi.name = locala.ajGk.readString();
        AppMethodBeat.o(91259);
        return 0;
      case 3: 
        localbi.type = locala.ajGk.readString();
        AppMethodBeat.o(91259);
        return 0;
      case 4: 
        localbi.content = locala.ajGk.readString();
        AppMethodBeat.o(91259);
        return 0;
      case 5: 
        localbi.KuZ = locala.ajGk.aar();
        AppMethodBeat.o(91259);
        return 0;
      case 6: 
        localbi.iconUrl = locala.ajGk.readString();
        AppMethodBeat.o(91259);
        return 0;
      }
      localbi.Kva = locala.ajGk.aar();
      AppMethodBeat.o(91259);
      return 0;
    }
    AppMethodBeat.o(91259);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bi
 * JD-Core Version:    0.7.0.1
 */