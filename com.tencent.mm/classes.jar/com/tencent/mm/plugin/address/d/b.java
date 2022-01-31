package com.tencent.mm.plugin.address.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bv.a
{
  public String gLd;
  public String gLe;
  public String gLf;
  public String gLg;
  public String gLh;
  public String gLi;
  public String gLj;
  public String gLk;
  public String gLl;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(16786);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.id);
      if (this.gLd != null) {
        paramVarArgs.e(2, this.gLd);
      }
      if (this.gLe != null) {
        paramVarArgs.e(3, this.gLe);
      }
      if (this.gLf != null) {
        paramVarArgs.e(4, this.gLf);
      }
      if (this.gLg != null) {
        paramVarArgs.e(5, this.gLg);
      }
      if (this.gLh != null) {
        paramVarArgs.e(6, this.gLh);
      }
      if (this.gLi != null) {
        paramVarArgs.e(7, this.gLi);
      }
      if (this.gLj != null) {
        paramVarArgs.e(8, this.gLj);
      }
      if (this.gLk != null) {
        paramVarArgs.e(9, this.gLk);
      }
      if (this.gLl != null) {
        paramVarArgs.e(10, this.gLl);
      }
      AppMethodBeat.o(16786);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.id) + 0;
      paramInt = i;
      if (this.gLd != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.gLd);
      }
      i = paramInt;
      if (this.gLe != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.gLe);
      }
      paramInt = i;
      if (this.gLf != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.gLf);
      }
      i = paramInt;
      if (this.gLg != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.gLg);
      }
      paramInt = i;
      if (this.gLh != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.gLh);
      }
      i = paramInt;
      if (this.gLi != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.gLi);
      }
      paramInt = i;
      if (this.gLj != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.gLj);
      }
      i = paramInt;
      if (this.gLk != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.gLk);
      }
      paramInt = i;
      if (this.gLl != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.gLl);
      }
      AppMethodBeat.o(16786);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(16786);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(16786);
        return -1;
      case 1: 
        localb.id = locala.CLY.sl();
        AppMethodBeat.o(16786);
        return 0;
      case 2: 
        localb.gLd = locala.CLY.readString();
        AppMethodBeat.o(16786);
        return 0;
      case 3: 
        localb.gLe = locala.CLY.readString();
        AppMethodBeat.o(16786);
        return 0;
      case 4: 
        localb.gLf = locala.CLY.readString();
        AppMethodBeat.o(16786);
        return 0;
      case 5: 
        localb.gLg = locala.CLY.readString();
        AppMethodBeat.o(16786);
        return 0;
      case 6: 
        localb.gLh = locala.CLY.readString();
        AppMethodBeat.o(16786);
        return 0;
      case 7: 
        localb.gLi = locala.CLY.readString();
        AppMethodBeat.o(16786);
        return 0;
      case 8: 
        localb.gLj = locala.CLY.readString();
        AppMethodBeat.o(16786);
        return 0;
      case 9: 
        localb.gLk = locala.CLY.readString();
        AppMethodBeat.o(16786);
        return 0;
      }
      localb.gLl = locala.CLY.readString();
      AppMethodBeat.o(16786);
      return 0;
    }
    AppMethodBeat.o(16786);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.d.b
 * JD-Core Version:    0.7.0.1
 */