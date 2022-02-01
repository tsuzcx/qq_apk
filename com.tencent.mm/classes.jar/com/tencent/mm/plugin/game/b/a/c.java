package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bw.a
{
  public String Md5;
  public String jfi;
  public String xuc;
  public long xug;
  public boolean xuh;
  public long xui;
  public String xuj;
  public String xuk;
  public String xul;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204098);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.xug);
      paramVarArgs.cc(2, this.xuh);
      if (this.xuc != null) {
        paramVarArgs.e(3, this.xuc);
      }
      paramVarArgs.bb(4, this.xui);
      if (this.xuj != null) {
        paramVarArgs.e(5, this.xuj);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(6, this.Md5);
      }
      if (this.jfi != null) {
        paramVarArgs.e(7, this.jfi);
      }
      if (this.xuk != null) {
        paramVarArgs.e(8, this.xuk);
      }
      if (this.xul != null) {
        paramVarArgs.e(9, this.xul);
      }
      AppMethodBeat.o(204098);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.xug) + 0 + (g.a.a.b.b.a.fS(2) + 1);
      paramInt = i;
      if (this.xuc != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.xuc);
      }
      i = paramInt + g.a.a.b.b.a.r(4, this.xui);
      paramInt = i;
      if (this.xuj != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.xuj);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Md5);
      }
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.jfi);
      }
      i = paramInt;
      if (this.xuk != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.xuk);
      }
      paramInt = i;
      if (this.xul != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.xul);
      }
      AppMethodBeat.o(204098);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(204098);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(204098);
        return -1;
      case 1: 
        localc.xug = locala.UbS.zl();
        AppMethodBeat.o(204098);
        return 0;
      case 2: 
        localc.xuh = locala.UbS.yZ();
        AppMethodBeat.o(204098);
        return 0;
      case 3: 
        localc.xuc = locala.UbS.readString();
        AppMethodBeat.o(204098);
        return 0;
      case 4: 
        localc.xui = locala.UbS.zl();
        AppMethodBeat.o(204098);
        return 0;
      case 5: 
        localc.xuj = locala.UbS.readString();
        AppMethodBeat.o(204098);
        return 0;
      case 6: 
        localc.Md5 = locala.UbS.readString();
        AppMethodBeat.o(204098);
        return 0;
      case 7: 
        localc.jfi = locala.UbS.readString();
        AppMethodBeat.o(204098);
        return 0;
      case 8: 
        localc.xuk = locala.UbS.readString();
        AppMethodBeat.o(204098);
        return 0;
      }
      localc.xul = locala.UbS.readString();
      AppMethodBeat.o(204098);
      return 0;
    }
    AppMethodBeat.o(204098);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a.c
 * JD-Core Version:    0.7.0.1
 */