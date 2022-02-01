package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bw.a
{
  public int duration;
  public int height;
  public String iAz;
  public String jTB;
  public String title;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40882);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.iAz != null) {
        paramVarArgs.e(1, this.iAz);
      }
      if (this.jTB != null) {
        paramVarArgs.e(2, this.jTB);
      }
      paramVarArgs.aM(3, this.height);
      paramVarArgs.aM(4, this.width);
      if (this.title != null) {
        paramVarArgs.e(5, this.title);
      }
      paramVarArgs.aM(6, this.duration);
      AppMethodBeat.o(40882);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iAz == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.b.b.a.f(1, this.iAz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jTB != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.jTB);
      }
      i = i + g.a.a.b.b.a.bu(3, this.height) + g.a.a.b.b.a.bu(4, this.width);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.title);
      }
      i = g.a.a.b.b.a.bu(6, this.duration);
      AppMethodBeat.o(40882);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(40882);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40882);
          return -1;
        case 1: 
          localn.iAz = locala.UbS.readString();
          AppMethodBeat.o(40882);
          return 0;
        case 2: 
          localn.jTB = locala.UbS.readString();
          AppMethodBeat.o(40882);
          return 0;
        case 3: 
          localn.height = locala.UbS.zi();
          AppMethodBeat.o(40882);
          return 0;
        case 4: 
          localn.width = locala.UbS.zi();
          AppMethodBeat.o(40882);
          return 0;
        case 5: 
          localn.title = locala.UbS.readString();
          AppMethodBeat.o(40882);
          return 0;
        }
        localn.duration = locala.UbS.zi();
        AppMethodBeat.o(40882);
        return 0;
      }
      AppMethodBeat.o(40882);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.n
 * JD-Core Version:    0.7.0.1
 */