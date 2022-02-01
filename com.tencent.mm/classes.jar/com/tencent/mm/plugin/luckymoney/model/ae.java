package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
  extends com.tencent.mm.cd.a
{
  public String EAG;
  public String EAH;
  public String EAI;
  public String EAJ;
  public String EAK;
  public String EAL;
  public boolean EAM;
  public long EAr;
  public String EAs;
  public String Ezh;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91258);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.EAG != null) {
        paramVarArgs.f(1, this.EAG);
      }
      if (this.EAH != null) {
        paramVarArgs.f(2, this.EAH);
      }
      paramVarArgs.bm(3, this.EAr);
      if (this.EAs != null) {
        paramVarArgs.f(4, this.EAs);
      }
      if (this.EAI != null) {
        paramVarArgs.f(5, this.EAI);
      }
      if (this.Ezh != null) {
        paramVarArgs.f(6, this.Ezh);
      }
      if (this.EAJ != null) {
        paramVarArgs.f(7, this.EAJ);
      }
      if (this.userName != null) {
        paramVarArgs.f(8, this.userName);
      }
      if (this.EAK != null) {
        paramVarArgs.f(9, this.EAK);
      }
      if (this.EAL != null) {
        paramVarArgs.f(10, this.EAL);
      }
      paramVarArgs.co(11, this.EAM);
      AppMethodBeat.o(91258);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EAG == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = g.a.a.b.b.a.g(1, this.EAG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EAH != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.EAH);
      }
      i += g.a.a.b.b.a.p(3, this.EAr);
      paramInt = i;
      if (this.EAs != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.EAs);
      }
      i = paramInt;
      if (this.EAI != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.EAI);
      }
      paramInt = i;
      if (this.Ezh != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Ezh);
      }
      i = paramInt;
      if (this.EAJ != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.EAJ);
      }
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.userName);
      }
      i = paramInt;
      if (this.EAK != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.EAK);
      }
      paramInt = i;
      if (this.EAL != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.EAL);
      }
      i = g.a.a.b.b.a.gL(11);
      AppMethodBeat.o(91258);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91258);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91258);
          return -1;
        case 1: 
          localae.EAG = locala.abFh.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 2: 
          localae.EAH = locala.abFh.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 3: 
          localae.EAr = locala.abFh.AN();
          AppMethodBeat.o(91258);
          return 0;
        case 4: 
          localae.EAs = locala.abFh.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 5: 
          localae.EAI = locala.abFh.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 6: 
          localae.Ezh = locala.abFh.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 7: 
          localae.EAJ = locala.abFh.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 8: 
          localae.userName = locala.abFh.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 9: 
          localae.EAK = locala.abFh.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 10: 
          localae.EAL = locala.abFh.readString();
          AppMethodBeat.o(91258);
          return 0;
        }
        localae.EAM = locala.abFh.AB();
        AppMethodBeat.o(91258);
        return 0;
      }
      AppMethodBeat.o(91258);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ae
 * JD-Core Version:    0.7.0.1
 */