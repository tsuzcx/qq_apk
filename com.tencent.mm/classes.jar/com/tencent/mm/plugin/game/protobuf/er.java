package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class er
  extends com.tencent.mm.bw.a
{
  public String xJL;
  public String xNS;
  public String xNT;
  public String xNU;
  public String xNV;
  public int xNW;
  public String xNX;
  public String xNY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41848);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xJL != null) {
        paramVarArgs.e(1, this.xJL);
      }
      if (this.xNS != null) {
        paramVarArgs.e(2, this.xNS);
      }
      if (this.xNT != null) {
        paramVarArgs.e(3, this.xNT);
      }
      if (this.xNU != null) {
        paramVarArgs.e(4, this.xNU);
      }
      if (this.xNV != null) {
        paramVarArgs.e(5, this.xNV);
      }
      paramVarArgs.aM(6, this.xNW);
      if (this.xNX != null) {
        paramVarArgs.e(7, this.xNX);
      }
      if (this.xNY != null) {
        paramVarArgs.e(8, this.xNY);
      }
      AppMethodBeat.o(41848);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJL == null) {
        break label626;
      }
    }
    label626:
    for (int i = g.a.a.b.b.a.f(1, this.xJL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xNS != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xNS);
      }
      i = paramInt;
      if (this.xNT != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNT);
      }
      paramInt = i;
      if (this.xNU != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xNU);
      }
      i = paramInt;
      if (this.xNV != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xNV);
      }
      i += g.a.a.b.b.a.bu(6, this.xNW);
      paramInt = i;
      if (this.xNX != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.xNX);
      }
      i = paramInt;
      if (this.xNY != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.xNY);
      }
      AppMethodBeat.o(41848);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41848);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        er localer = (er)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41848);
          return -1;
        case 1: 
          localer.xJL = locala.UbS.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 2: 
          localer.xNS = locala.UbS.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 3: 
          localer.xNT = locala.UbS.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 4: 
          localer.xNU = locala.UbS.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 5: 
          localer.xNV = locala.UbS.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 6: 
          localer.xNW = locala.UbS.zi();
          AppMethodBeat.o(41848);
          return 0;
        case 7: 
          localer.xNX = locala.UbS.readString();
          AppMethodBeat.o(41848);
          return 0;
        }
        localer.xNY = locala.UbS.readString();
        AppMethodBeat.o(41848);
        return 0;
      }
      AppMethodBeat.o(41848);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.er
 * JD-Core Version:    0.7.0.1
 */