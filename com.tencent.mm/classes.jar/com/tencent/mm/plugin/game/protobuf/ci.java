package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ci
  extends com.tencent.mm.bx.a
{
  public String IKF;
  public String desc;
  public String nPr;
  public String title;
  public String xlO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41792);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.nPr != null) {
        paramVarArgs.g(2, this.nPr);
      }
      if (this.xlO != null) {
        paramVarArgs.g(3, this.xlO);
      }
      if (this.desc != null) {
        paramVarArgs.g(4, this.desc);
      }
      if (this.IKF != null) {
        paramVarArgs.g(5, this.IKF);
      }
      AppMethodBeat.o(41792);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nPr != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nPr);
      }
      i = paramInt;
      if (this.xlO != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.xlO);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.desc);
      }
      i = paramInt;
      if (this.IKF != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IKF);
      }
      AppMethodBeat.o(41792);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41792);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ci localci = (ci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41792);
          return -1;
        case 1: 
          localci.title = locala.ajGk.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 2: 
          localci.nPr = locala.ajGk.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 3: 
          localci.xlO = locala.ajGk.readString();
          AppMethodBeat.o(41792);
          return 0;
        case 4: 
          localci.desc = locala.ajGk.readString();
          AppMethodBeat.o(41792);
          return 0;
        }
        localci.IKF = locala.ajGk.readString();
        AppMethodBeat.o(41792);
        return 0;
      }
      AppMethodBeat.o(41792);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ci
 * JD-Core Version:    0.7.0.1
 */