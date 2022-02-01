package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class de
  extends com.tencent.mm.bx.a
{
  public String gHT;
  public String rYr;
  public String sdM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149418);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gHT != null) {
        paramVarArgs.d(1, this.gHT);
      }
      if (this.rYr != null) {
        paramVarArgs.d(2, this.rYr);
      }
      if (this.sdM != null) {
        paramVarArgs.d(3, this.sdM);
      }
      AppMethodBeat.o(149418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gHT == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.gHT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rYr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rYr);
      }
      i = paramInt;
      if (this.sdM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sdM);
      }
      AppMethodBeat.o(149418);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(149418);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        de localde = (de)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149418);
          return -1;
        case 1: 
          localde.gHT = locala.KhF.readString();
          AppMethodBeat.o(149418);
          return 0;
        case 2: 
          localde.rYr = locala.KhF.readString();
          AppMethodBeat.o(149418);
          return 0;
        }
        localde.sdM = locala.KhF.readString();
        AppMethodBeat.o(149418);
        return 0;
      }
      AppMethodBeat.o(149418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.de
 * JD-Core Version:    0.7.0.1
 */