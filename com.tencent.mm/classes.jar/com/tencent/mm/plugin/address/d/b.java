package com.tencent.mm.plugin.address.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public int id;
  public String juS;
  public String juT;
  public String juU;
  public String juV;
  public String juW;
  public String juX;
  public String juY;
  public String juZ;
  public String jva;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(20827);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.id);
      if (this.juS != null) {
        paramVarArgs.d(2, this.juS);
      }
      if (this.juT != null) {
        paramVarArgs.d(3, this.juT);
      }
      if (this.juU != null) {
        paramVarArgs.d(4, this.juU);
      }
      if (this.juV != null) {
        paramVarArgs.d(5, this.juV);
      }
      if (this.juW != null) {
        paramVarArgs.d(6, this.juW);
      }
      if (this.juX != null) {
        paramVarArgs.d(7, this.juX);
      }
      if (this.juY != null) {
        paramVarArgs.d(8, this.juY);
      }
      if (this.juZ != null) {
        paramVarArgs.d(9, this.juZ);
      }
      if (this.jva != null) {
        paramVarArgs.d(10, this.jva);
      }
      AppMethodBeat.o(20827);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.id) + 0;
      paramInt = i;
      if (this.juS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.juS);
      }
      i = paramInt;
      if (this.juT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.juT);
      }
      paramInt = i;
      if (this.juU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.juU);
      }
      i = paramInt;
      if (this.juV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.juV);
      }
      paramInt = i;
      if (this.juW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.juW);
      }
      i = paramInt;
      if (this.juX != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.juX);
      }
      paramInt = i;
      if (this.juY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.juY);
      }
      i = paramInt;
      if (this.juZ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.juZ);
      }
      paramInt = i;
      if (this.jva != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.jva);
      }
      AppMethodBeat.o(20827);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        localb.id = locala.OmT.zc();
        AppMethodBeat.o(20827);
        return 0;
      case 2: 
        localb.juS = locala.OmT.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 3: 
        localb.juT = locala.OmT.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 4: 
        localb.juU = locala.OmT.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 5: 
        localb.juV = locala.OmT.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 6: 
        localb.juW = locala.OmT.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 7: 
        localb.juX = locala.OmT.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 8: 
        localb.juY = locala.OmT.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 9: 
        localb.juZ = locala.OmT.readString();
        AppMethodBeat.o(20827);
        return 0;
      }
      localb.jva = locala.OmT.readString();
      AppMethodBeat.o(20827);
      return 0;
    }
    AppMethodBeat.o(20827);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.d.b
 * JD-Core Version:    0.7.0.1
 */