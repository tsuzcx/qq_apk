package com.tencent.mm.plugin.address.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public String iYQ;
  public String iYR;
  public String iYS;
  public String iYT;
  public String iYU;
  public String iYV;
  public String iYW;
  public String iYX;
  public String iYY;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(20827);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.id);
      if (this.iYQ != null) {
        paramVarArgs.d(2, this.iYQ);
      }
      if (this.iYR != null) {
        paramVarArgs.d(3, this.iYR);
      }
      if (this.iYS != null) {
        paramVarArgs.d(4, this.iYS);
      }
      if (this.iYT != null) {
        paramVarArgs.d(5, this.iYT);
      }
      if (this.iYU != null) {
        paramVarArgs.d(6, this.iYU);
      }
      if (this.iYV != null) {
        paramVarArgs.d(7, this.iYV);
      }
      if (this.iYW != null) {
        paramVarArgs.d(8, this.iYW);
      }
      if (this.iYX != null) {
        paramVarArgs.d(9, this.iYX);
      }
      if (this.iYY != null) {
        paramVarArgs.d(10, this.iYY);
      }
      AppMethodBeat.o(20827);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.id) + 0;
      paramInt = i;
      if (this.iYQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iYQ);
      }
      i = paramInt;
      if (this.iYR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iYR);
      }
      paramInt = i;
      if (this.iYS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iYS);
      }
      i = paramInt;
      if (this.iYT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iYT);
      }
      paramInt = i;
      if (this.iYU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iYU);
      }
      i = paramInt;
      if (this.iYV != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iYV);
      }
      paramInt = i;
      if (this.iYW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.iYW);
      }
      i = paramInt;
      if (this.iYX != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.iYX);
      }
      paramInt = i;
      if (this.iYY != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.iYY);
      }
      AppMethodBeat.o(20827);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localb.id = locala.LVo.xF();
        AppMethodBeat.o(20827);
        return 0;
      case 2: 
        localb.iYQ = locala.LVo.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 3: 
        localb.iYR = locala.LVo.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 4: 
        localb.iYS = locala.LVo.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 5: 
        localb.iYT = locala.LVo.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 6: 
        localb.iYU = locala.LVo.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 7: 
        localb.iYV = locala.LVo.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 8: 
        localb.iYW = locala.LVo.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 9: 
        localb.iYX = locala.LVo.readString();
        AppMethodBeat.o(20827);
        return 0;
      }
      localb.iYY = locala.LVo.readString();
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