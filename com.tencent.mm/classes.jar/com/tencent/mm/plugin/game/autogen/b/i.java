package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bx.a
{
  public int Height;
  public long IcI;
  public int Idt;
  public String Idu;
  public String Idv;
  public boolean Idw;
  public int Idx;
  public int Width;
  public int crr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40875);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Idt);
      if (this.Idu != null) {
        paramVarArgs.g(2, this.Idu);
      }
      if (this.Idv != null) {
        paramVarArgs.g(3, this.Idv);
      }
      paramVarArgs.bS(4, this.Width);
      paramVarArgs.bS(5, this.Height);
      paramVarArgs.di(6, this.Idw);
      paramVarArgs.bS(7, this.crr);
      paramVarArgs.bv(8, this.IcI);
      paramVarArgs.bS(9, this.Idx);
      AppMethodBeat.o(40875);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Idt) + 0;
      paramInt = i;
      if (this.Idu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Idu);
      }
      i = paramInt;
      if (this.Idv != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Idv);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.Width);
      int j = i.a.a.b.b.a.cJ(5, this.Height);
      int k = i.a.a.b.b.a.ko(6);
      int m = i.a.a.b.b.a.cJ(7, this.crr);
      int n = i.a.a.b.b.a.q(8, this.IcI);
      int i1 = i.a.a.b.b.a.cJ(9, this.Idx);
      AppMethodBeat.o(40875);
      return i + paramInt + j + (k + 1) + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(40875);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(40875);
        return -1;
      case 1: 
        locali.Idt = locala.ajGk.aar();
        AppMethodBeat.o(40875);
        return 0;
      case 2: 
        locali.Idu = locala.ajGk.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 3: 
        locali.Idv = locala.ajGk.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 4: 
        locali.Width = locala.ajGk.aar();
        AppMethodBeat.o(40875);
        return 0;
      case 5: 
        locali.Height = locala.ajGk.aar();
        AppMethodBeat.o(40875);
        return 0;
      case 6: 
        locali.Idw = locala.ajGk.aai();
        AppMethodBeat.o(40875);
        return 0;
      case 7: 
        locali.crr = locala.ajGk.aar();
        AppMethodBeat.o(40875);
        return 0;
      case 8: 
        locali.IcI = locala.ajGk.aaw();
        AppMethodBeat.o(40875);
        return 0;
      }
      locali.Idx = locala.ajGk.aar();
      AppMethodBeat.o(40875);
      return 0;
    }
    AppMethodBeat.o(40875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.i
 * JD-Core Version:    0.7.0.1
 */