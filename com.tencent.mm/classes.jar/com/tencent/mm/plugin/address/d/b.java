package com.tencent.mm.plugin.address.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.cd.a
{
  public int id;
  public String nkT;
  public String nkU;
  public String nkV;
  public String nkW;
  public String nkX;
  public String nkY;
  public String nkZ;
  public String nla;
  public String nlb;
  public String nlc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(20827);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.id);
      if (this.nkT != null) {
        paramVarArgs.f(2, this.nkT);
      }
      if (this.nkU != null) {
        paramVarArgs.f(3, this.nkU);
      }
      if (this.nkV != null) {
        paramVarArgs.f(4, this.nkV);
      }
      if (this.nkW != null) {
        paramVarArgs.f(5, this.nkW);
      }
      if (this.nkX != null) {
        paramVarArgs.f(6, this.nkX);
      }
      if (this.nkY != null) {
        paramVarArgs.f(7, this.nkY);
      }
      if (this.nkZ != null) {
        paramVarArgs.f(8, this.nkZ);
      }
      if (this.nla != null) {
        paramVarArgs.f(9, this.nla);
      }
      if (this.nlb != null) {
        paramVarArgs.f(10, this.nlb);
      }
      if (this.nlc != null) {
        paramVarArgs.f(11, this.nlc);
      }
      AppMethodBeat.o(20827);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.id) + 0;
      paramInt = i;
      if (this.nkT != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nkT);
      }
      i = paramInt;
      if (this.nkU != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.nkU);
      }
      paramInt = i;
      if (this.nkV != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.nkV);
      }
      i = paramInt;
      if (this.nkW != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.nkW);
      }
      paramInt = i;
      if (this.nkX != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.nkX);
      }
      i = paramInt;
      if (this.nkY != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.nkY);
      }
      paramInt = i;
      if (this.nkZ != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.nkZ);
      }
      i = paramInt;
      if (this.nla != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.nla);
      }
      paramInt = i;
      if (this.nlb != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.nlb);
      }
      i = paramInt;
      if (this.nlc != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.nlc);
      }
      AppMethodBeat.o(20827);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(20827);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(20827);
        return -1;
      case 1: 
        localb.id = locala.abFh.AK();
        AppMethodBeat.o(20827);
        return 0;
      case 2: 
        localb.nkT = locala.abFh.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 3: 
        localb.nkU = locala.abFh.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 4: 
        localb.nkV = locala.abFh.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 5: 
        localb.nkW = locala.abFh.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 6: 
        localb.nkX = locala.abFh.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 7: 
        localb.nkY = locala.abFh.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 8: 
        localb.nkZ = locala.abFh.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 9: 
        localb.nla = locala.abFh.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 10: 
        localb.nlb = locala.abFh.readString();
        AppMethodBeat.o(20827);
        return 0;
      }
      localb.nlc = locala.abFh.readString();
      AppMethodBeat.o(20827);
      return 0;
    }
    AppMethodBeat.o(20827);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.d.b
 * JD-Core Version:    0.7.0.1
 */