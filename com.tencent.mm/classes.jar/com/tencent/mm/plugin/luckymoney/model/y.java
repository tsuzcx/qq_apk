package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class y
  extends com.tencent.mm.bw.a
{
  public String userName;
  public String vAq;
  public String vBF;
  public String vBG;
  public String vBH;
  public String vBI;
  public long vBs;
  public String vBt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91258);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vBF != null) {
        paramVarArgs.d(1, this.vBF);
      }
      if (this.vBG != null) {
        paramVarArgs.d(2, this.vBG);
      }
      paramVarArgs.aZ(3, this.vBs);
      if (this.vBt != null) {
        paramVarArgs.d(4, this.vBt);
      }
      if (this.vBH != null) {
        paramVarArgs.d(5, this.vBH);
      }
      if (this.vAq != null) {
        paramVarArgs.d(6, this.vAq);
      }
      if (this.vBI != null) {
        paramVarArgs.d(7, this.vBI);
      }
      if (this.userName != null) {
        paramVarArgs.d(8, this.userName);
      }
      AppMethodBeat.o(91258);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vBF == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.vBF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vBG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.vBG);
      }
      i += f.a.a.b.b.a.p(3, this.vBs);
      paramInt = i;
      if (this.vBt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vBt);
      }
      i = paramInt;
      if (this.vBH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.vBH);
      }
      paramInt = i;
      if (this.vAq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.vAq);
      }
      i = paramInt;
      if (this.vBI != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.vBI);
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
            paramVarArgs.gCg();
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
          localy.vBF = locala.OmT.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 2: 
          localy.vBG = locala.OmT.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 3: 
          localy.vBs = locala.OmT.zd();
          AppMethodBeat.o(91258);
          return 0;
        case 4: 
          localy.vBt = locala.OmT.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 5: 
          localy.vBH = locala.OmT.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 6: 
          localy.vAq = locala.OmT.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 7: 
          localy.vBI = locala.OmT.readString();
          AppMethodBeat.o(91258);
          return 0;
        }
        localy.userName = locala.OmT.readString();
        AppMethodBeat.o(91258);
        return 0;
      }
      AppMethodBeat.o(91258);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.y
 * JD-Core Version:    0.7.0.1
 */