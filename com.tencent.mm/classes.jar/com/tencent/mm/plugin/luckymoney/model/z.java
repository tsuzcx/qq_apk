package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z
  extends com.tencent.mm.cd.a
{
  public String EAq;
  public long EAr;
  public String EAs;
  public String EAt;
  public String EAu;
  public long EAv;
  public int EAw;
  public String EAx;
  public String EAy;
  public String Ezb;
  public long Eze;
  public long Ezg;
  public String Ezh;
  public int Ezs;
  public int gbo;
  public int status;
  public String ybP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91257);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.EAq != null) {
        paramVarArgs.f(1, this.EAq);
      }
      if (this.Ezb != null) {
        paramVarArgs.f(2, this.Ezb);
      }
      paramVarArgs.bm(3, this.EAr);
      if (this.EAs != null) {
        paramVarArgs.f(4, this.EAs);
      }
      paramVarArgs.aY(5, this.gbo);
      if (this.EAt != null) {
        paramVarArgs.f(6, this.EAt);
      }
      if (this.EAu != null) {
        paramVarArgs.f(7, this.EAu);
      }
      paramVarArgs.bm(8, this.Ezg);
      paramVarArgs.bm(9, this.EAv);
      paramVarArgs.bm(10, this.Eze);
      paramVarArgs.aY(11, this.status);
      paramVarArgs.aY(12, this.EAw);
      if (this.Ezh != null) {
        paramVarArgs.f(13, this.Ezh);
      }
      if (this.ybP != null) {
        paramVarArgs.f(14, this.ybP);
      }
      paramVarArgs.aY(15, this.Ezs);
      if (this.EAx != null) {
        paramVarArgs.f(16, this.EAx);
      }
      if (this.EAy != null) {
        paramVarArgs.f(17, this.EAy);
      }
      AppMethodBeat.o(91257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EAq == null) {
        break label1062;
      }
    }
    label1062:
    for (paramInt = g.a.a.b.b.a.g(1, this.EAq) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ezb != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Ezb);
      }
      i += g.a.a.b.b.a.p(3, this.EAr);
      paramInt = i;
      if (this.EAs != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.EAs);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.gbo);
      paramInt = i;
      if (this.EAt != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.EAt);
      }
      i = paramInt;
      if (this.EAu != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.EAu);
      }
      i = i + g.a.a.b.b.a.p(8, this.Ezg) + g.a.a.b.b.a.p(9, this.EAv) + g.a.a.b.b.a.p(10, this.Eze) + g.a.a.b.b.a.bM(11, this.status) + g.a.a.b.b.a.bM(12, this.EAw);
      paramInt = i;
      if (this.Ezh != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Ezh);
      }
      i = paramInt;
      if (this.ybP != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.ybP);
      }
      i += g.a.a.b.b.a.bM(15, this.Ezs);
      paramInt = i;
      if (this.EAx != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.EAx);
      }
      i = paramInt;
      if (this.EAy != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.EAy);
      }
      AppMethodBeat.o(91257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91257);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91257);
          return -1;
        case 1: 
          localz.EAq = locala.abFh.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 2: 
          localz.Ezb = locala.abFh.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 3: 
          localz.EAr = locala.abFh.AN();
          AppMethodBeat.o(91257);
          return 0;
        case 4: 
          localz.EAs = locala.abFh.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 5: 
          localz.gbo = locala.abFh.AK();
          AppMethodBeat.o(91257);
          return 0;
        case 6: 
          localz.EAt = locala.abFh.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 7: 
          localz.EAu = locala.abFh.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 8: 
          localz.Ezg = locala.abFh.AN();
          AppMethodBeat.o(91257);
          return 0;
        case 9: 
          localz.EAv = locala.abFh.AN();
          AppMethodBeat.o(91257);
          return 0;
        case 10: 
          localz.Eze = locala.abFh.AN();
          AppMethodBeat.o(91257);
          return 0;
        case 11: 
          localz.status = locala.abFh.AK();
          AppMethodBeat.o(91257);
          return 0;
        case 12: 
          localz.EAw = locala.abFh.AK();
          AppMethodBeat.o(91257);
          return 0;
        case 13: 
          localz.Ezh = locala.abFh.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 14: 
          localz.ybP = locala.abFh.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 15: 
          localz.Ezs = locala.abFh.AK();
          AppMethodBeat.o(91257);
          return 0;
        case 16: 
          localz.EAx = locala.abFh.readString();
          AppMethodBeat.o(91257);
          return 0;
        }
        localz.EAy = locala.abFh.readString();
        AppMethodBeat.o(91257);
        return 0;
      }
      AppMethodBeat.o(91257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.z
 * JD-Core Version:    0.7.0.1
 */