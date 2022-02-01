package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bx.a
{
  public String fJm;
  public int plc;
  public String pld;
  public String ple;
  public String plf;
  public String plg;
  public int plh;
  public String pli;
  public String plj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153075);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.plc);
      if (this.fJm != null) {
        paramVarArgs.d(2, this.fJm);
      }
      if (this.pld != null) {
        paramVarArgs.d(3, this.pld);
      }
      if (this.ple != null) {
        paramVarArgs.d(4, this.ple);
      }
      if (this.plf != null) {
        paramVarArgs.d(5, this.plf);
      }
      if (this.plg != null) {
        paramVarArgs.d(6, this.plg);
      }
      paramVarArgs.aS(7, this.plh);
      if (this.pli != null) {
        paramVarArgs.d(8, this.pli);
      }
      if (this.plj != null) {
        paramVarArgs.d(9, this.plj);
      }
      AppMethodBeat.o(153075);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.plc) + 0;
      paramInt = i;
      if (this.fJm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fJm);
      }
      i = paramInt;
      if (this.pld != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pld);
      }
      paramInt = i;
      if (this.ple != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ple);
      }
      i = paramInt;
      if (this.plf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.plf);
      }
      paramInt = i;
      if (this.plg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.plg);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.plh);
      paramInt = i;
      if (this.pli != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.pli);
      }
      i = paramInt;
      if (this.plj != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.plj);
      }
      AppMethodBeat.o(153075);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(153075);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153075);
        return -1;
      case 1: 
        localo.plc = locala.NPN.zc();
        AppMethodBeat.o(153075);
        return 0;
      case 2: 
        localo.fJm = locala.NPN.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 3: 
        localo.pld = locala.NPN.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 4: 
        localo.ple = locala.NPN.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 5: 
        localo.plf = locala.NPN.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 6: 
        localo.plg = locala.NPN.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 7: 
        localo.plh = locala.NPN.zc();
        AppMethodBeat.o(153075);
        return 0;
      case 8: 
        localo.pli = locala.NPN.readString();
        AppMethodBeat.o(153075);
        return 0;
      }
      localo.plj = locala.NPN.readString();
      AppMethodBeat.o(153075);
      return 0;
    }
    AppMethodBeat.o(153075);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.o
 * JD-Core Version:    0.7.0.1
 */