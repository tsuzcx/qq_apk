package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bx.a
{
  public String fnK;
  public int odZ;
  public String oea;
  public String oeb;
  public String oec;
  public String oed;
  public int oee;
  public String oef;
  public String oeg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153075);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.odZ);
      if (this.fnK != null) {
        paramVarArgs.d(2, this.fnK);
      }
      if (this.oea != null) {
        paramVarArgs.d(3, this.oea);
      }
      if (this.oeb != null) {
        paramVarArgs.d(4, this.oeb);
      }
      if (this.oec != null) {
        paramVarArgs.d(5, this.oec);
      }
      if (this.oed != null) {
        paramVarArgs.d(6, this.oed);
      }
      paramVarArgs.aR(7, this.oee);
      if (this.oef != null) {
        paramVarArgs.d(8, this.oef);
      }
      if (this.oeg != null) {
        paramVarArgs.d(9, this.oeg);
      }
      AppMethodBeat.o(153075);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.odZ) + 0;
      paramInt = i;
      if (this.fnK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fnK);
      }
      i = paramInt;
      if (this.oea != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oea);
      }
      paramInt = i;
      if (this.oeb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oeb);
      }
      i = paramInt;
      if (this.oec != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oec);
      }
      paramInt = i;
      if (this.oed != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.oed);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.oee);
      paramInt = i;
      if (this.oef != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.oef);
      }
      i = paramInt;
      if (this.oeg != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.oeg);
      }
      AppMethodBeat.o(153075);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localo.odZ = locala.KhF.xS();
        AppMethodBeat.o(153075);
        return 0;
      case 2: 
        localo.fnK = locala.KhF.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 3: 
        localo.oea = locala.KhF.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 4: 
        localo.oeb = locala.KhF.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 5: 
        localo.oec = locala.KhF.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 6: 
        localo.oed = locala.KhF.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 7: 
        localo.oee = locala.KhF.xS();
        AppMethodBeat.o(153075);
        return 0;
      case 8: 
        localo.oef = locala.KhF.readString();
        AppMethodBeat.o(153075);
        return 0;
      }
      localo.oeg = locala.KhF.readString();
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