package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  extends com.tencent.mm.bx.a
{
  public int dDN;
  public String sZn;
  public int status;
  public int tdB;
  public String tdk;
  public long tdn;
  public long tdp;
  public String tdq;
  public String ter;
  public long tes;
  public String tet;
  public String teu;
  public String tev;
  public long tew;
  public int tex;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91257);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ter != null) {
        paramVarArgs.d(1, this.ter);
      }
      if (this.tdk != null) {
        paramVarArgs.d(2, this.tdk);
      }
      paramVarArgs.aG(3, this.tes);
      if (this.tet != null) {
        paramVarArgs.d(4, this.tet);
      }
      paramVarArgs.aR(5, this.dDN);
      if (this.teu != null) {
        paramVarArgs.d(6, this.teu);
      }
      if (this.tev != null) {
        paramVarArgs.d(7, this.tev);
      }
      paramVarArgs.aG(8, this.tdp);
      paramVarArgs.aG(9, this.tew);
      paramVarArgs.aG(10, this.tdn);
      paramVarArgs.aR(11, this.status);
      paramVarArgs.aR(12, this.tex);
      if (this.tdq != null) {
        paramVarArgs.d(13, this.tdq);
      }
      if (this.sZn != null) {
        paramVarArgs.d(14, this.sZn);
      }
      paramVarArgs.aR(15, this.tdB);
      AppMethodBeat.o(91257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ter == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = f.a.a.b.b.a.e(1, this.ter) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tdk != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.tdk);
      }
      i += f.a.a.b.b.a.q(3, this.tes);
      paramInt = i;
      if (this.tet != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tet);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.dDN);
      paramInt = i;
      if (this.teu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.teu);
      }
      i = paramInt;
      if (this.tev != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.tev);
      }
      i = i + f.a.a.b.b.a.q(8, this.tdp) + f.a.a.b.b.a.q(9, this.tew) + f.a.a.b.b.a.q(10, this.tdn) + f.a.a.b.b.a.bA(11, this.status) + f.a.a.b.b.a.bA(12, this.tex);
      paramInt = i;
      if (this.tdq != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.tdq);
      }
      i = paramInt;
      if (this.sZn != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.sZn);
      }
      paramInt = f.a.a.b.b.a.bA(15, this.tdB);
      AppMethodBeat.o(91257);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91257);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91257);
          return -1;
        case 1: 
          localt.ter = locala.KhF.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 2: 
          localt.tdk = locala.KhF.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 3: 
          localt.tes = locala.KhF.xT();
          AppMethodBeat.o(91257);
          return 0;
        case 4: 
          localt.tet = locala.KhF.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 5: 
          localt.dDN = locala.KhF.xS();
          AppMethodBeat.o(91257);
          return 0;
        case 6: 
          localt.teu = locala.KhF.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 7: 
          localt.tev = locala.KhF.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 8: 
          localt.tdp = locala.KhF.xT();
          AppMethodBeat.o(91257);
          return 0;
        case 9: 
          localt.tew = locala.KhF.xT();
          AppMethodBeat.o(91257);
          return 0;
        case 10: 
          localt.tdn = locala.KhF.xT();
          AppMethodBeat.o(91257);
          return 0;
        case 11: 
          localt.status = locala.KhF.xS();
          AppMethodBeat.o(91257);
          return 0;
        case 12: 
          localt.tex = locala.KhF.xS();
          AppMethodBeat.o(91257);
          return 0;
        case 13: 
          localt.tdq = locala.KhF.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 14: 
          localt.sZn = locala.KhF.readString();
          AppMethodBeat.o(91257);
          return 0;
        }
        localt.tdB = locala.KhF.xS();
        AppMethodBeat.o(91257);
        return 0;
      }
      AppMethodBeat.o(91257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.t
 * JD-Core Version:    0.7.0.1
 */