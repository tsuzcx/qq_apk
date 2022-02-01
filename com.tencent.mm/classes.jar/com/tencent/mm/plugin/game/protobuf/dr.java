package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dr
  extends com.tencent.mm.bw.a
{
  public String xIB;
  public String xIJ;
  public String xNi;
  public String xNj;
  public String xNk;
  public boolean xNl;
  public boolean xNm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41833);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xIJ != null) {
        paramVarArgs.e(1, this.xIJ);
      }
      if (this.xNi != null) {
        paramVarArgs.e(2, this.xNi);
      }
      if (this.xNj != null) {
        paramVarArgs.e(3, this.xNj);
      }
      if (this.xNk != null) {
        paramVarArgs.e(4, this.xNk);
      }
      if (this.xIB != null) {
        paramVarArgs.e(5, this.xIB);
      }
      paramVarArgs.cc(6, this.xNl);
      paramVarArgs.cc(7, this.xNm);
      AppMethodBeat.o(41833);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xIJ == null) {
        break label546;
      }
    }
    label546:
    for (int i = g.a.a.b.b.a.f(1, this.xIJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xNi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xNi);
      }
      i = paramInt;
      if (this.xNj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNj);
      }
      paramInt = i;
      if (this.xNk != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xNk);
      }
      i = paramInt;
      if (this.xIB != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xIB);
      }
      paramInt = g.a.a.b.b.a.fS(6);
      int j = g.a.a.b.b.a.fS(7);
      AppMethodBeat.o(41833);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41833);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dr localdr = (dr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41833);
          return -1;
        case 1: 
          localdr.xIJ = locala.UbS.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 2: 
          localdr.xNi = locala.UbS.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 3: 
          localdr.xNj = locala.UbS.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 4: 
          localdr.xNk = locala.UbS.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 5: 
          localdr.xIB = locala.UbS.readString();
          AppMethodBeat.o(41833);
          return 0;
        case 6: 
          localdr.xNl = locala.UbS.yZ();
          AppMethodBeat.o(41833);
          return 0;
        }
        localdr.xNm = locala.UbS.yZ();
        AppMethodBeat.o(41833);
        return 0;
      }
      AppMethodBeat.o(41833);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dr
 * JD-Core Version:    0.7.0.1
 */