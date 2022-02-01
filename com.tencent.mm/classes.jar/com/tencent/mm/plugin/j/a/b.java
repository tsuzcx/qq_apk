package com.tencent.mm.plugin.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public String evs;
  public int sze;
  public String szf;
  public String szg;
  public String szh;
  public String szi;
  public String szj;
  public String szk;
  public String szl;
  public String szm;
  public String szn;
  public String title;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(25280);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.sze);
      if (this.type != null) {
        paramVarArgs.d(2, this.type);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.szf != null) {
        paramVarArgs.d(4, this.szf);
      }
      if (this.szg != null) {
        paramVarArgs.d(5, this.szg);
      }
      if (this.szh != null) {
        paramVarArgs.d(6, this.szh);
      }
      if (this.szi != null) {
        paramVarArgs.d(7, this.szi);
      }
      if (this.szj != null) {
        paramVarArgs.d(8, this.szj);
      }
      if (this.szk != null) {
        paramVarArgs.d(9, this.szk);
      }
      if (this.szl != null) {
        paramVarArgs.d(10, this.szl);
      }
      if (this.evs != null) {
        paramVarArgs.d(11, this.evs);
      }
      if (this.szm != null) {
        paramVarArgs.d(12, this.szm);
      }
      if (this.szn != null) {
        paramVarArgs.d(13, this.szn);
      }
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.sze) + 0;
      paramInt = i;
      if (this.type != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.type);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      paramInt = i;
      if (this.szf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.szf);
      }
      i = paramInt;
      if (this.szg != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.szg);
      }
      paramInt = i;
      if (this.szh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.szh);
      }
      i = paramInt;
      if (this.szi != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.szi);
      }
      paramInt = i;
      if (this.szj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.szj);
      }
      i = paramInt;
      if (this.szk != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.szk);
      }
      paramInt = i;
      if (this.szl != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.szl);
      }
      i = paramInt;
      if (this.evs != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.evs);
      }
      paramInt = i;
      if (this.szm != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.szm);
      }
      i = paramInt;
      if (this.szn != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.szn);
      }
      AppMethodBeat.o(25280);
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
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(25280);
        return -1;
      case 1: 
        localb.sze = locala.KhF.xS();
        AppMethodBeat.o(25280);
        return 0;
      case 2: 
        localb.type = locala.KhF.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 3: 
        localb.title = locala.KhF.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 4: 
        localb.szf = locala.KhF.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 5: 
        localb.szg = locala.KhF.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 6: 
        localb.szh = locala.KhF.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 7: 
        localb.szi = locala.KhF.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 8: 
        localb.szj = locala.KhF.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 9: 
        localb.szk = locala.KhF.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 10: 
        localb.szl = locala.KhF.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 11: 
        localb.evs = locala.KhF.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 12: 
        localb.szm = locala.KhF.readString();
        AppMethodBeat.o(25280);
        return 0;
      }
      localb.szn = locala.KhF.readString();
      AppMethodBeat.o(25280);
      return 0;
    }
    AppMethodBeat.o(25280);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.j.a.b
 * JD-Core Version:    0.7.0.1
 */