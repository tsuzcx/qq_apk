package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class m
  extends com.tencent.mm.bx.a
{
  public boolean IHA;
  public boolean IHB;
  public boolean IHC;
  public boolean IHD;
  public boolean IHE;
  public boolean IHF;
  public boolean IHG;
  public boolean IHz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276895);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.IHz);
      paramVarArgs.di(2, this.IHA);
      paramVarArgs.di(3, this.IHB);
      paramVarArgs.di(4, this.IHC);
      paramVarArgs.di(5, this.IHD);
      paramVarArgs.di(6, this.IHE);
      paramVarArgs.di(7, this.IHF);
      paramVarArgs.di(8, this.IHG);
      AppMethodBeat.o(276895);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.ko(5);
      int n = i.a.a.b.b.a.ko(6);
      int i1 = i.a.a.b.b.a.ko(7);
      int i2 = i.a.a.b.b.a.ko(8);
      AppMethodBeat.o(276895);
      return paramInt + 1 + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(276895);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(276895);
        return -1;
      case 1: 
        localm.IHz = locala.ajGk.aai();
        AppMethodBeat.o(276895);
        return 0;
      case 2: 
        localm.IHA = locala.ajGk.aai();
        AppMethodBeat.o(276895);
        return 0;
      case 3: 
        localm.IHB = locala.ajGk.aai();
        AppMethodBeat.o(276895);
        return 0;
      case 4: 
        localm.IHC = locala.ajGk.aai();
        AppMethodBeat.o(276895);
        return 0;
      case 5: 
        localm.IHD = locala.ajGk.aai();
        AppMethodBeat.o(276895);
        return 0;
      case 6: 
        localm.IHE = locala.ajGk.aai();
        AppMethodBeat.o(276895);
        return 0;
      case 7: 
        localm.IHF = locala.ajGk.aai();
        AppMethodBeat.o(276895);
        return 0;
      }
      localm.IHG = locala.ajGk.aai();
      AppMethodBeat.o(276895);
      return 0;
    }
    AppMethodBeat.o(276895);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.m
 * JD-Core Version:    0.7.0.1
 */