package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bx.a
{
  public String Kru;
  public String Krv;
  public String icon_url;
  public String wording;
  public boolean wtT;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(283953);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.wtT);
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(3, this.icon_url);
      }
      paramVarArgs.bS(4, this.wuj);
      if (this.Kru != null) {
        paramVarArgs.g(5, this.Kru);
      }
      if (this.Krv != null) {
        paramVarArgs.g(6, this.Krv);
      }
      AppMethodBeat.o(283953);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.icon_url);
      }
      i += i.a.a.b.b.a.cJ(4, this.wuj);
      paramInt = i;
      if (this.Kru != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Kru);
      }
      i = paramInt;
      if (this.Krv != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Krv);
      }
      AppMethodBeat.o(283953);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(283953);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(283953);
        return -1;
      case 1: 
        localm.wtT = locala.ajGk.aai();
        AppMethodBeat.o(283953);
        return 0;
      case 2: 
        localm.wording = locala.ajGk.readString();
        AppMethodBeat.o(283953);
        return 0;
      case 3: 
        localm.icon_url = locala.ajGk.readString();
        AppMethodBeat.o(283953);
        return 0;
      case 4: 
        localm.wuj = locala.ajGk.aar();
        AppMethodBeat.o(283953);
        return 0;
      case 5: 
        localm.Kru = locala.ajGk.readString();
        AppMethodBeat.o(283953);
        return 0;
      }
      localm.Krv = locala.ajGk.readString();
      AppMethodBeat.o(283953);
      return 0;
    }
    AppMethodBeat.o(283953);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.m
 * JD-Core Version:    0.7.0.1
 */