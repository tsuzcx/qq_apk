package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cr
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String xIB;
  public String xIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41805);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xIJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41805);
        throw paramVarArgs;
      }
      if (this.xIJ != null) {
        paramVarArgs.e(1, this.xIJ);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.xIB != null) {
        paramVarArgs.e(3, this.xIB);
      }
      AppMethodBeat.o(41805);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xIJ == null) {
        break label382;
      }
    }
    label382:
    for (int i = g.a.a.b.b.a.f(1, this.xIJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.xIB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xIB);
      }
      AppMethodBeat.o(41805);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xIJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconURL");
          AppMethodBeat.o(41805);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41805);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cr localcr = (cr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41805);
          return -1;
        case 1: 
          localcr.xIJ = locala.UbS.readString();
          AppMethodBeat.o(41805);
          return 0;
        case 2: 
          localcr.Title = locala.UbS.readString();
          AppMethodBeat.o(41805);
          return 0;
        }
        localcr.xIB = locala.UbS.readString();
        AppMethodBeat.o(41805);
        return 0;
      }
      AppMethodBeat.o(41805);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cr
 * JD-Core Version:    0.7.0.1
 */