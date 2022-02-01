package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dw
  extends com.tencent.mm.bx.a
{
  public String IGL;
  public String IGT;
  public String ILI;
  public String ILJ;
  public String ILK;
  public boolean ILL;
  public boolean ILM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41833);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGT != null) {
        paramVarArgs.g(1, this.IGT);
      }
      if (this.ILI != null) {
        paramVarArgs.g(2, this.ILI);
      }
      if (this.ILJ != null) {
        paramVarArgs.g(3, this.ILJ);
      }
      if (this.ILK != null) {
        paramVarArgs.g(4, this.ILK);
      }
      if (this.IGL != null) {
        paramVarArgs.g(5, this.IGL);
      }
      paramVarArgs.di(6, this.ILL);
      paramVarArgs.di(7, this.ILM);
      AppMethodBeat.o(41833);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGT == null) {
        break label542;
      }
    }
    label542:
    for (int i = i.a.a.b.b.a.h(1, this.IGT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ILI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ILI);
      }
      i = paramInt;
      if (this.ILJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ILJ);
      }
      paramInt = i;
      if (this.ILK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ILK);
      }
      i = paramInt;
      if (this.IGL != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IGL);
      }
      paramInt = i.a.a.b.b.a.ko(6);
      int j = i.a.a.b.b.a.ko(7);
      AppMethodBeat.o(41833);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41833);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dw localdw = (dw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41833);
          return -1;
        case 1: 
          localdw.IGT = locala.ajGk.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 2: 
          localdw.ILI = locala.ajGk.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 3: 
          localdw.ILJ = locala.ajGk.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 4: 
          localdw.ILK = locala.ajGk.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 5: 
          localdw.IGL = locala.ajGk.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 6: 
          localdw.ILL = locala.ajGk.aai();
          AppMethodBeat.o(41833);
          return 0;
        }
        localdw.ILM = locala.ajGk.aai();
        AppMethodBeat.o(41833);
        return 0;
      }
      AppMethodBeat.o(41833);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dw
 * JD-Core Version:    0.7.0.1
 */