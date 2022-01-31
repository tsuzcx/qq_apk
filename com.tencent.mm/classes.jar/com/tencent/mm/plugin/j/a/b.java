package com.tencent.mm.plugin.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bv.a
{
  public String dqF;
  public int nLm;
  public String nLn;
  public String nLo;
  public String nLp;
  public String nLq;
  public String nLr;
  public String nLs;
  public String nLt;
  public String nLu;
  public String nLv;
  public String title;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(21657);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.nLm);
      if (this.type != null) {
        paramVarArgs.e(2, this.type);
      }
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      if (this.nLn != null) {
        paramVarArgs.e(4, this.nLn);
      }
      if (this.nLo != null) {
        paramVarArgs.e(5, this.nLo);
      }
      if (this.nLp != null) {
        paramVarArgs.e(6, this.nLp);
      }
      if (this.nLq != null) {
        paramVarArgs.e(7, this.nLq);
      }
      if (this.nLr != null) {
        paramVarArgs.e(8, this.nLr);
      }
      if (this.nLs != null) {
        paramVarArgs.e(9, this.nLs);
      }
      if (this.nLt != null) {
        paramVarArgs.e(10, this.nLt);
      }
      if (this.dqF != null) {
        paramVarArgs.e(11, this.dqF);
      }
      if (this.nLu != null) {
        paramVarArgs.e(12, this.nLu);
      }
      if (this.nLv != null) {
        paramVarArgs.e(13, this.nLv);
      }
      AppMethodBeat.o(21657);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.nLm) + 0;
      paramInt = i;
      if (this.type != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.type);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.title);
      }
      paramInt = i;
      if (this.nLn != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nLn);
      }
      i = paramInt;
      if (this.nLo != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nLo);
      }
      paramInt = i;
      if (this.nLp != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.nLp);
      }
      i = paramInt;
      if (this.nLq != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.nLq);
      }
      paramInt = i;
      if (this.nLr != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.nLr);
      }
      i = paramInt;
      if (this.nLs != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.nLs);
      }
      paramInt = i;
      if (this.nLt != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.nLt);
      }
      i = paramInt;
      if (this.dqF != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.dqF);
      }
      paramInt = i;
      if (this.nLu != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.nLu);
      }
      i = paramInt;
      if (this.nLv != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.nLv);
      }
      AppMethodBeat.o(21657);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(21657);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(21657);
        return -1;
      case 1: 
        localb.nLm = locala.CLY.sl();
        AppMethodBeat.o(21657);
        return 0;
      case 2: 
        localb.type = locala.CLY.readString();
        AppMethodBeat.o(21657);
        return 0;
      case 3: 
        localb.title = locala.CLY.readString();
        AppMethodBeat.o(21657);
        return 0;
      case 4: 
        localb.nLn = locala.CLY.readString();
        AppMethodBeat.o(21657);
        return 0;
      case 5: 
        localb.nLo = locala.CLY.readString();
        AppMethodBeat.o(21657);
        return 0;
      case 6: 
        localb.nLp = locala.CLY.readString();
        AppMethodBeat.o(21657);
        return 0;
      case 7: 
        localb.nLq = locala.CLY.readString();
        AppMethodBeat.o(21657);
        return 0;
      case 8: 
        localb.nLr = locala.CLY.readString();
        AppMethodBeat.o(21657);
        return 0;
      case 9: 
        localb.nLs = locala.CLY.readString();
        AppMethodBeat.o(21657);
        return 0;
      case 10: 
        localb.nLt = locala.CLY.readString();
        AppMethodBeat.o(21657);
        return 0;
      case 11: 
        localb.dqF = locala.CLY.readString();
        AppMethodBeat.o(21657);
        return 0;
      case 12: 
        localb.nLu = locala.CLY.readString();
        AppMethodBeat.o(21657);
        return 0;
      }
      localb.nLv = locala.CLY.readString();
      AppMethodBeat.o(21657);
      return 0;
    }
    AppMethodBeat.o(21657);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.j.a.b
 * JD-Core Version:    0.7.0.1
 */