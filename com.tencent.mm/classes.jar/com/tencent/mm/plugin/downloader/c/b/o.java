package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bw.a
{
  public String fre;
  public String oHA;
  public String oHB;
  public String oHC;
  public int oHD;
  public String oHE;
  public String oHF;
  public int oHy;
  public String oHz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153075);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.oHy);
      if (this.fre != null) {
        paramVarArgs.d(2, this.fre);
      }
      if (this.oHz != null) {
        paramVarArgs.d(3, this.oHz);
      }
      if (this.oHA != null) {
        paramVarArgs.d(4, this.oHA);
      }
      if (this.oHB != null) {
        paramVarArgs.d(5, this.oHB);
      }
      if (this.oHC != null) {
        paramVarArgs.d(6, this.oHC);
      }
      paramVarArgs.aR(7, this.oHD);
      if (this.oHE != null) {
        paramVarArgs.d(8, this.oHE);
      }
      if (this.oHF != null) {
        paramVarArgs.d(9, this.oHF);
      }
      AppMethodBeat.o(153075);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.oHy) + 0;
      paramInt = i;
      if (this.fre != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fre);
      }
      i = paramInt;
      if (this.oHz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oHz);
      }
      paramInt = i;
      if (this.oHA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oHA);
      }
      i = paramInt;
      if (this.oHB != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oHB);
      }
      paramInt = i;
      if (this.oHC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.oHC);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.oHD);
      paramInt = i;
      if (this.oHE != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.oHE);
      }
      i = paramInt;
      if (this.oHF != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.oHF);
      }
      AppMethodBeat.o(153075);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localo.oHy = locala.LVo.xF();
        AppMethodBeat.o(153075);
        return 0;
      case 2: 
        localo.fre = locala.LVo.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 3: 
        localo.oHz = locala.LVo.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 4: 
        localo.oHA = locala.LVo.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 5: 
        localo.oHB = locala.LVo.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 6: 
        localo.oHC = locala.LVo.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 7: 
        localo.oHD = locala.LVo.xF();
        AppMethodBeat.o(153075);
        return 0;
      case 8: 
        localo.oHE = locala.LVo.readString();
        AppMethodBeat.o(153075);
        return 0;
      }
      localo.oHF = locala.LVo.readString();
      AppMethodBeat.o(153075);
      return 0;
    }
    AppMethodBeat.o(153075);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.o
 * JD-Core Version:    0.7.0.1
 */