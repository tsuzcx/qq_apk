package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class er
  extends com.tencent.mm.bw.a
{
  public String uru;
  public String uvR;
  public String uvS;
  public String uvT;
  public String uvU;
  public int uvV;
  public String uvW;
  public String uvX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41848);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uru != null) {
        paramVarArgs.d(1, this.uru);
      }
      if (this.uvR != null) {
        paramVarArgs.d(2, this.uvR);
      }
      if (this.uvS != null) {
        paramVarArgs.d(3, this.uvS);
      }
      if (this.uvT != null) {
        paramVarArgs.d(4, this.uvT);
      }
      if (this.uvU != null) {
        paramVarArgs.d(5, this.uvU);
      }
      paramVarArgs.aS(6, this.uvV);
      if (this.uvW != null) {
        paramVarArgs.d(7, this.uvW);
      }
      if (this.uvX != null) {
        paramVarArgs.d(8, this.uvX);
      }
      AppMethodBeat.o(41848);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uru == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.b.b.a.e(1, this.uru) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uvR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uvR);
      }
      i = paramInt;
      if (this.uvS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvS);
      }
      paramInt = i;
      if (this.uvT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uvT);
      }
      i = paramInt;
      if (this.uvU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uvU);
      }
      i += f.a.a.b.b.a.bz(6, this.uvV);
      paramInt = i;
      if (this.uvW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.uvW);
      }
      i = paramInt;
      if (this.uvX != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.uvX);
      }
      AppMethodBeat.o(41848);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41848);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        er localer = (er)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41848);
          return -1;
        case 1: 
          localer.uru = locala.OmT.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 2: 
          localer.uvR = locala.OmT.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 3: 
          localer.uvS = locala.OmT.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 4: 
          localer.uvT = locala.OmT.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 5: 
          localer.uvU = locala.OmT.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 6: 
          localer.uvV = locala.OmT.zc();
          AppMethodBeat.o(41848);
          return 0;
        case 7: 
          localer.uvW = locala.OmT.readString();
          AppMethodBeat.o(41848);
          return 0;
        }
        localer.uvX = locala.OmT.readString();
        AppMethodBeat.o(41848);
        return 0;
      }
      AppMethodBeat.o(41848);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.er
 * JD-Core Version:    0.7.0.1
 */