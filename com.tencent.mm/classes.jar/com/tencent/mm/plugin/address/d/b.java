package com.tencent.mm.plugin.address.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public int id;
  public String iyN;
  public String iyO;
  public String iyP;
  public String iyQ;
  public String iyR;
  public String iyS;
  public String iyT;
  public String iyU;
  public String iyV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(20827);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.id);
      if (this.iyN != null) {
        paramVarArgs.d(2, this.iyN);
      }
      if (this.iyO != null) {
        paramVarArgs.d(3, this.iyO);
      }
      if (this.iyP != null) {
        paramVarArgs.d(4, this.iyP);
      }
      if (this.iyQ != null) {
        paramVarArgs.d(5, this.iyQ);
      }
      if (this.iyR != null) {
        paramVarArgs.d(6, this.iyR);
      }
      if (this.iyS != null) {
        paramVarArgs.d(7, this.iyS);
      }
      if (this.iyT != null) {
        paramVarArgs.d(8, this.iyT);
      }
      if (this.iyU != null) {
        paramVarArgs.d(9, this.iyU);
      }
      if (this.iyV != null) {
        paramVarArgs.d(10, this.iyV);
      }
      AppMethodBeat.o(20827);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.id) + 0;
      paramInt = i;
      if (this.iyN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iyN);
      }
      i = paramInt;
      if (this.iyO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iyO);
      }
      paramInt = i;
      if (this.iyP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iyP);
      }
      i = paramInt;
      if (this.iyQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iyQ);
      }
      paramInt = i;
      if (this.iyR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iyR);
      }
      i = paramInt;
      if (this.iyS != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iyS);
      }
      paramInt = i;
      if (this.iyT != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.iyT);
      }
      i = paramInt;
      if (this.iyU != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.iyU);
      }
      paramInt = i;
      if (this.iyV != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.iyV);
      }
      AppMethodBeat.o(20827);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(20827);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(20827);
        return -1;
      case 1: 
        localb.id = locala.KhF.xS();
        AppMethodBeat.o(20827);
        return 0;
      case 2: 
        localb.iyN = locala.KhF.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 3: 
        localb.iyO = locala.KhF.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 4: 
        localb.iyP = locala.KhF.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 5: 
        localb.iyQ = locala.KhF.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 6: 
        localb.iyR = locala.KhF.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 7: 
        localb.iyS = locala.KhF.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 8: 
        localb.iyT = locala.KhF.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 9: 
        localb.iyU = locala.KhF.readString();
        AppMethodBeat.o(20827);
        return 0;
      }
      localb.iyV = locala.KhF.readString();
      AppMethodBeat.o(20827);
      return 0;
    }
    AppMethodBeat.o(20827);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.d.b
 * JD-Core Version:    0.7.0.1
 */