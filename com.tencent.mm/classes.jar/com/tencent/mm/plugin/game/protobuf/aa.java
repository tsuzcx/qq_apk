package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String rBI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256631);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.rBI != null) {
        paramVarArgs.e(3, this.rBI);
      }
      AppMethodBeat.o(256631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.rBI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.rBI);
      }
      AppMethodBeat.o(256631);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256631);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(256631);
          return -1;
        case 1: 
          localaa.Title = locala.UbS.readString();
          AppMethodBeat.o(256631);
          return 0;
        case 2: 
          localaa.Desc = locala.UbS.readString();
          AppMethodBeat.o(256631);
          return 0;
        }
        localaa.rBI = locala.UbS.readString();
        AppMethodBeat.o(256631);
        return 0;
      }
      AppMethodBeat.o(256631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.aa
 * JD-Core Version:    0.7.0.1
 */