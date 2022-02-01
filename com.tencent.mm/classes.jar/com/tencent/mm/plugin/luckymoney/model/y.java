package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class y
  extends com.tencent.mm.bw.a
{
  public String ulF;
  public long umH;
  public String umI;
  public String umU;
  public String umV;
  public String umW;
  public String umX;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91258);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.umU != null) {
        paramVarArgs.d(1, this.umU);
      }
      if (this.umV != null) {
        paramVarArgs.d(2, this.umV);
      }
      paramVarArgs.aO(3, this.umH);
      if (this.umI != null) {
        paramVarArgs.d(4, this.umI);
      }
      if (this.umW != null) {
        paramVarArgs.d(5, this.umW);
      }
      if (this.ulF != null) {
        paramVarArgs.d(6, this.ulF);
      }
      if (this.umX != null) {
        paramVarArgs.d(7, this.umX);
      }
      if (this.userName != null) {
        paramVarArgs.d(8, this.userName);
      }
      AppMethodBeat.o(91258);
      return 0;
    }
    if (paramInt == 1) {
      if (this.umU == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.umU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.umV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.umV);
      }
      i += f.a.a.b.b.a.p(3, this.umH);
      paramInt = i;
      if (this.umI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.umI);
      }
      i = paramInt;
      if (this.umW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.umW);
      }
      paramInt = i;
      if (this.ulF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ulF);
      }
      i = paramInt;
      if (this.umX != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.umX);
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
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localy.umU = locala.LVo.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 2: 
          localy.umV = locala.LVo.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 3: 
          localy.umH = locala.LVo.xG();
          AppMethodBeat.o(91258);
          return 0;
        case 4: 
          localy.umI = locala.LVo.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 5: 
          localy.umW = locala.LVo.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 6: 
          localy.ulF = locala.LVo.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 7: 
          localy.umX = locala.LVo.readString();
          AppMethodBeat.o(91258);
          return 0;
        }
        localy.userName = locala.LVo.readString();
        AppMethodBeat.o(91258);
        return 0;
      }
      AppMethodBeat.o(91258);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.y
 * JD-Core Version:    0.7.0.1
 */