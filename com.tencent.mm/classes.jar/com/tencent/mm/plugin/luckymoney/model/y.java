package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class y
  extends com.tencent.mm.bx.a
{
  public String tdq;
  public String teF;
  public String teG;
  public String teH;
  public String teI;
  public long tes;
  public String tet;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91258);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.teF != null) {
        paramVarArgs.d(1, this.teF);
      }
      if (this.teG != null) {
        paramVarArgs.d(2, this.teG);
      }
      paramVarArgs.aG(3, this.tes);
      if (this.tet != null) {
        paramVarArgs.d(4, this.tet);
      }
      if (this.teH != null) {
        paramVarArgs.d(5, this.teH);
      }
      if (this.tdq != null) {
        paramVarArgs.d(6, this.tdq);
      }
      if (this.teI != null) {
        paramVarArgs.d(7, this.teI);
      }
      if (this.userName != null) {
        paramVarArgs.d(8, this.userName);
      }
      AppMethodBeat.o(91258);
      return 0;
    }
    if (paramInt == 1) {
      if (this.teF == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.teF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.teG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.teG);
      }
      i += f.a.a.b.b.a.q(3, this.tes);
      paramInt = i;
      if (this.tet != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tet);
      }
      i = paramInt;
      if (this.teH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.teH);
      }
      paramInt = i;
      if (this.tdq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.tdq);
      }
      i = paramInt;
      if (this.teI != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.teI);
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
            paramVarArgs.fMq();
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
          localy.teF = locala.KhF.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 2: 
          localy.teG = locala.KhF.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 3: 
          localy.tes = locala.KhF.xT();
          AppMethodBeat.o(91258);
          return 0;
        case 4: 
          localy.tet = locala.KhF.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 5: 
          localy.teH = locala.KhF.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 6: 
          localy.tdq = locala.KhF.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 7: 
          localy.teI = locala.KhF.readString();
          AppMethodBeat.o(91258);
          return 0;
        }
        localy.userName = locala.KhF.readString();
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