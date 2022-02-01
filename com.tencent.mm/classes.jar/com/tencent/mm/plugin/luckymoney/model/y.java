package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class y
  extends com.tencent.mm.bw.a
{
  public int egY;
  public int status;
  public String yQE;
  public String yVe;
  public long yVh;
  public long yVj;
  public String yVk;
  public int yVv;
  public String yWn;
  public long yWo;
  public String yWp;
  public String yWq;
  public String yWr;
  public long yWs;
  public int yWt;
  public String yWu;
  public String yWv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91257);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.yWn != null) {
        paramVarArgs.e(1, this.yWn);
      }
      if (this.yVe != null) {
        paramVarArgs.e(2, this.yVe);
      }
      paramVarArgs.bb(3, this.yWo);
      if (this.yWp != null) {
        paramVarArgs.e(4, this.yWp);
      }
      paramVarArgs.aM(5, this.egY);
      if (this.yWq != null) {
        paramVarArgs.e(6, this.yWq);
      }
      if (this.yWr != null) {
        paramVarArgs.e(7, this.yWr);
      }
      paramVarArgs.bb(8, this.yVj);
      paramVarArgs.bb(9, this.yWs);
      paramVarArgs.bb(10, this.yVh);
      paramVarArgs.aM(11, this.status);
      paramVarArgs.aM(12, this.yWt);
      if (this.yVk != null) {
        paramVarArgs.e(13, this.yVk);
      }
      if (this.yQE != null) {
        paramVarArgs.e(14, this.yQE);
      }
      paramVarArgs.aM(15, this.yVv);
      if (this.yWu != null) {
        paramVarArgs.e(16, this.yWu);
      }
      if (this.yWv != null) {
        paramVarArgs.e(17, this.yWv);
      }
      AppMethodBeat.o(91257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yWn == null) {
        break label1062;
      }
    }
    label1062:
    for (paramInt = g.a.a.b.b.a.f(1, this.yWn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yVe != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.yVe);
      }
      i += g.a.a.b.b.a.r(3, this.yWo);
      paramInt = i;
      if (this.yWp != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.yWp);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.egY);
      paramInt = i;
      if (this.yWq != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.yWq);
      }
      i = paramInt;
      if (this.yWr != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.yWr);
      }
      i = i + g.a.a.b.b.a.r(8, this.yVj) + g.a.a.b.b.a.r(9, this.yWs) + g.a.a.b.b.a.r(10, this.yVh) + g.a.a.b.b.a.bu(11, this.status) + g.a.a.b.b.a.bu(12, this.yWt);
      paramInt = i;
      if (this.yVk != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.yVk);
      }
      i = paramInt;
      if (this.yQE != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.yQE);
      }
      i += g.a.a.b.b.a.bu(15, this.yVv);
      paramInt = i;
      if (this.yWu != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.yWu);
      }
      i = paramInt;
      if (this.yWv != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.yWv);
      }
      AppMethodBeat.o(91257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91257);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91257);
          return -1;
        case 1: 
          localy.yWn = locala.UbS.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 2: 
          localy.yVe = locala.UbS.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 3: 
          localy.yWo = locala.UbS.zl();
          AppMethodBeat.o(91257);
          return 0;
        case 4: 
          localy.yWp = locala.UbS.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 5: 
          localy.egY = locala.UbS.zi();
          AppMethodBeat.o(91257);
          return 0;
        case 6: 
          localy.yWq = locala.UbS.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 7: 
          localy.yWr = locala.UbS.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 8: 
          localy.yVj = locala.UbS.zl();
          AppMethodBeat.o(91257);
          return 0;
        case 9: 
          localy.yWs = locala.UbS.zl();
          AppMethodBeat.o(91257);
          return 0;
        case 10: 
          localy.yVh = locala.UbS.zl();
          AppMethodBeat.o(91257);
          return 0;
        case 11: 
          localy.status = locala.UbS.zi();
          AppMethodBeat.o(91257);
          return 0;
        case 12: 
          localy.yWt = locala.UbS.zi();
          AppMethodBeat.o(91257);
          return 0;
        case 13: 
          localy.yVk = locala.UbS.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 14: 
          localy.yQE = locala.UbS.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 15: 
          localy.yVv = locala.UbS.zi();
          AppMethodBeat.o(91257);
          return 0;
        case 16: 
          localy.yWu = locala.UbS.readString();
          AppMethodBeat.o(91257);
          return 0;
        }
        localy.yWv = locala.UbS.readString();
        AppMethodBeat.o(91257);
        return 0;
      }
      AppMethodBeat.o(91257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.y
 * JD-Core Version:    0.7.0.1
 */