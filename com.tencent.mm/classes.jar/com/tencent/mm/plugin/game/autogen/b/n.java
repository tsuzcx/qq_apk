package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public int duration;
  public int height;
  public String nUZ;
  public String pic_url;
  public String title;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40882);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nUZ != null) {
        paramVarArgs.g(1, this.nUZ);
      }
      if (this.pic_url != null) {
        paramVarArgs.g(2, this.pic_url);
      }
      paramVarArgs.bS(3, this.height);
      paramVarArgs.bS(4, this.width);
      if (this.title != null) {
        paramVarArgs.g(5, this.title);
      }
      paramVarArgs.bS(6, this.duration);
      AppMethodBeat.o(40882);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nUZ == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = i.a.a.b.b.a.h(1, this.nUZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pic_url != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.pic_url);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.height) + i.a.a.b.b.a.cJ(4, this.width);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.title);
      }
      i = i.a.a.b.b.a.cJ(6, this.duration);
      AppMethodBeat.o(40882);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(40882);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40882);
          return -1;
        case 1: 
          localn.nUZ = locala.ajGk.readString();
          AppMethodBeat.o(40882);
          return 0;
        case 2: 
          localn.pic_url = locala.ajGk.readString();
          AppMethodBeat.o(40882);
          return 0;
        case 3: 
          localn.height = locala.ajGk.aar();
          AppMethodBeat.o(40882);
          return 0;
        case 4: 
          localn.width = locala.ajGk.aar();
          AppMethodBeat.o(40882);
          return 0;
        case 5: 
          localn.title = locala.ajGk.readString();
          AppMethodBeat.o(40882);
          return 0;
        }
        localn.duration = locala.ajGk.aar();
        AppMethodBeat.o(40882);
        return 0;
      }
      AppMethodBeat.o(40882);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.n
 * JD-Core Version:    0.7.0.1
 */