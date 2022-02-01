package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class y
  extends com.tencent.mm.bx.a
{
  public String userName;
  public String vol;
  public String vpA;
  public String vpB;
  public String vpC;
  public String vpD;
  public long vpn;
  public String vpo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91258);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vpA != null) {
        paramVarArgs.d(1, this.vpA);
      }
      if (this.vpB != null) {
        paramVarArgs.d(2, this.vpB);
      }
      paramVarArgs.aY(3, this.vpn);
      if (this.vpo != null) {
        paramVarArgs.d(4, this.vpo);
      }
      if (this.vpC != null) {
        paramVarArgs.d(5, this.vpC);
      }
      if (this.vol != null) {
        paramVarArgs.d(6, this.vol);
      }
      if (this.vpD != null) {
        paramVarArgs.d(7, this.vpD);
      }
      if (this.userName != null) {
        paramVarArgs.d(8, this.userName);
      }
      AppMethodBeat.o(91258);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vpA == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.vpA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vpB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.vpB);
      }
      i += f.a.a.b.b.a.p(3, this.vpn);
      paramInt = i;
      if (this.vpo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vpo);
      }
      i = paramInt;
      if (this.vpC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.vpC);
      }
      paramInt = i;
      if (this.vol != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.vol);
      }
      i = paramInt;
      if (this.vpD != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.vpD);
      }
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.userName);
      }
      AppMethodBeat.o(91258);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91258);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91258);
          return -1;
        case 1: 
          localy.vpA = locala.NPN.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 2: 
          localy.vpB = locala.NPN.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 3: 
          localy.vpn = locala.NPN.zd();
          AppMethodBeat.o(91258);
          return 0;
        case 4: 
          localy.vpo = locala.NPN.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 5: 
          localy.vpC = locala.NPN.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 6: 
          localy.vol = locala.NPN.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 7: 
          localy.vpD = locala.NPN.readString();
          AppMethodBeat.o(91258);
          return 0;
        }
        localy.userName = locala.NPN.readString();
        AppMethodBeat.o(91258);
        return 0;
      }
      AppMethodBeat.o(91258);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.y
 * JD-Core Version:    0.7.0.1
 */