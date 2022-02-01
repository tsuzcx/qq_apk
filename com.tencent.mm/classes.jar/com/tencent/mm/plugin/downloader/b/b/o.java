package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bx.a
{
  public String lwO;
  public String xmA;
  public String xmB;
  public int xmu;
  public String xmv;
  public String xmw;
  public String xmx;
  public String xmy;
  public int xmz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153075);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.xmu);
      if (this.lwO != null) {
        paramVarArgs.g(2, this.lwO);
      }
      if (this.xmv != null) {
        paramVarArgs.g(3, this.xmv);
      }
      if (this.xmw != null) {
        paramVarArgs.g(4, this.xmw);
      }
      if (this.xmx != null) {
        paramVarArgs.g(5, this.xmx);
      }
      if (this.xmy != null) {
        paramVarArgs.g(6, this.xmy);
      }
      paramVarArgs.bS(7, this.xmz);
      if (this.xmA != null) {
        paramVarArgs.g(8, this.xmA);
      }
      if (this.xmB != null) {
        paramVarArgs.g(9, this.xmB);
      }
      AppMethodBeat.o(153075);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.xmu) + 0;
      paramInt = i;
      if (this.lwO != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.lwO);
      }
      i = paramInt;
      if (this.xmv != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.xmv);
      }
      paramInt = i;
      if (this.xmw != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.xmw);
      }
      i = paramInt;
      if (this.xmx != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.xmx);
      }
      paramInt = i;
      if (this.xmy != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.xmy);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.xmz);
      paramInt = i;
      if (this.xmA != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.xmA);
      }
      i = paramInt;
      if (this.xmB != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.xmB);
      }
      AppMethodBeat.o(153075);
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
      AppMethodBeat.o(153075);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153075);
        return -1;
      case 1: 
        localo.xmu = locala.ajGk.aar();
        AppMethodBeat.o(153075);
        return 0;
      case 2: 
        localo.lwO = locala.ajGk.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 3: 
        localo.xmv = locala.ajGk.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 4: 
        localo.xmw = locala.ajGk.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 5: 
        localo.xmx = locala.ajGk.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 6: 
        localo.xmy = locala.ajGk.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 7: 
        localo.xmz = locala.ajGk.aar();
        AppMethodBeat.o(153075);
        return 0;
      case 8: 
        localo.xmA = locala.ajGk.readString();
        AppMethodBeat.o(153075);
        return 0;
      }
      localo.xmB = locala.ajGk.readString();
      AppMethodBeat.o(153075);
      return 0;
    }
    AppMethodBeat.o(153075);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.o
 * JD-Core Version:    0.7.0.1
 */