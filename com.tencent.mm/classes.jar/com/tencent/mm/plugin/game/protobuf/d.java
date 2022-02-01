package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bw.a
{
  public String jfi;
  public String xIC;
  public String xID;
  public String xIE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256623);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jfi != null) {
        paramVarArgs.e(1, this.jfi);
      }
      if (this.xIC != null) {
        paramVarArgs.e(2, this.xIC);
      }
      if (this.xID != null) {
        paramVarArgs.e(3, this.xID);
      }
      if (this.xIE != null) {
        paramVarArgs.e(4, this.xIE);
      }
      AppMethodBeat.o(256623);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jfi == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.jfi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xIC != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xIC);
      }
      i = paramInt;
      if (this.xID != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xID);
      }
      paramInt = i;
      if (this.xIE != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xIE);
      }
      AppMethodBeat.o(256623);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256623);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(256623);
          return -1;
        case 1: 
          locald.jfi = locala.UbS.readString();
          AppMethodBeat.o(256623);
          return 0;
        case 2: 
          locald.xIC = locala.UbS.readString();
          AppMethodBeat.o(256623);
          return 0;
        case 3: 
          locald.xID = locala.UbS.readString();
          AppMethodBeat.o(256623);
          return 0;
        }
        locald.xIE = locala.UbS.readString();
        AppMethodBeat.o(256623);
        return 0;
      }
      AppMethodBeat.o(256623);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.d
 * JD-Core Version:    0.7.0.1
 */