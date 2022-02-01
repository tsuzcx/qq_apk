package com.tencent.mm.plugin.address.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public int id;
  public String qic;
  public String qid;
  public String qie;
  public String qif;
  public String qig;
  public String qih;
  public String qii;
  public String qij;
  public String qik;
  public String qil;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(20827);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.id);
      if (this.qic != null) {
        paramVarArgs.g(2, this.qic);
      }
      if (this.qid != null) {
        paramVarArgs.g(3, this.qid);
      }
      if (this.qie != null) {
        paramVarArgs.g(4, this.qie);
      }
      if (this.qif != null) {
        paramVarArgs.g(5, this.qif);
      }
      if (this.qig != null) {
        paramVarArgs.g(6, this.qig);
      }
      if (this.qih != null) {
        paramVarArgs.g(7, this.qih);
      }
      if (this.qii != null) {
        paramVarArgs.g(8, this.qii);
      }
      if (this.qij != null) {
        paramVarArgs.g(9, this.qij);
      }
      if (this.qik != null) {
        paramVarArgs.g(10, this.qik);
      }
      if (this.qil != null) {
        paramVarArgs.g(11, this.qil);
      }
      AppMethodBeat.o(20827);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.id) + 0;
      paramInt = i;
      if (this.qic != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.qic);
      }
      i = paramInt;
      if (this.qid != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.qid);
      }
      paramInt = i;
      if (this.qie != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.qie);
      }
      i = paramInt;
      if (this.qif != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.qif);
      }
      paramInt = i;
      if (this.qig != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.qig);
      }
      i = paramInt;
      if (this.qih != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.qih);
      }
      paramInt = i;
      if (this.qii != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.qii);
      }
      i = paramInt;
      if (this.qij != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.qij);
      }
      paramInt = i;
      if (this.qik != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.qik);
      }
      i = paramInt;
      if (this.qil != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.qil);
      }
      AppMethodBeat.o(20827);
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
      AppMethodBeat.o(20827);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(20827);
        return -1;
      case 1: 
        localb.id = locala.ajGk.aar();
        AppMethodBeat.o(20827);
        return 0;
      case 2: 
        localb.qic = locala.ajGk.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 3: 
        localb.qid = locala.ajGk.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 4: 
        localb.qie = locala.ajGk.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 5: 
        localb.qif = locala.ajGk.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 6: 
        localb.qig = locala.ajGk.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 7: 
        localb.qih = locala.ajGk.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 8: 
        localb.qii = locala.ajGk.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 9: 
        localb.qij = locala.ajGk.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 10: 
        localb.qik = locala.ajGk.readString();
        AppMethodBeat.o(20827);
        return 0;
      }
      localb.qil = locala.ajGk.readString();
      AppMethodBeat.o(20827);
      return 0;
    }
    AppMethodBeat.o(20827);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.address.d.b
 * JD-Core Version:    0.7.0.1
 */