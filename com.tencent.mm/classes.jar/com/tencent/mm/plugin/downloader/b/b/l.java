package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bx.a
{
  public boolean xmk;
  public String xmm;
  public String xmn;
  public String xmo;
  public int xmp;
  public boolean xmq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153072);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.xmk);
      if (this.xmm != null) {
        paramVarArgs.g(2, this.xmm);
      }
      if (this.xmn != null) {
        paramVarArgs.g(3, this.xmn);
      }
      if (this.xmo != null) {
        paramVarArgs.g(4, this.xmo);
      }
      paramVarArgs.bS(5, this.xmp);
      paramVarArgs.di(6, this.xmq);
      AppMethodBeat.o(153072);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.xmm != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.xmm);
      }
      i = paramInt;
      if (this.xmn != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.xmn);
      }
      paramInt = i;
      if (this.xmo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.xmo);
      }
      i = i.a.a.b.b.a.cJ(5, this.xmp);
      int j = i.a.a.b.b.a.ko(6);
      AppMethodBeat.o(153072);
      return paramInt + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153072);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153072);
        return -1;
      case 1: 
        locall.xmk = locala.ajGk.aai();
        AppMethodBeat.o(153072);
        return 0;
      case 2: 
        locall.xmm = locala.ajGk.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 3: 
        locall.xmn = locala.ajGk.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 4: 
        locall.xmo = locala.ajGk.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 5: 
        locall.xmp = locala.ajGk.aar();
        AppMethodBeat.o(153072);
        return 0;
      }
      locall.xmq = locala.ajGk.aai();
      AppMethodBeat.o(153072);
      return 0;
    }
    AppMethodBeat.o(153072);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.l
 * JD-Core Version:    0.7.0.1
 */