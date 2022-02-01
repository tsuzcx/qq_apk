package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String xIx;
  public String xIy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41707);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(41707);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.xIx != null) {
        paramVarArgs.e(3, this.xIx);
      }
      if (this.xIy != null) {
        paramVarArgs.e(4, this.xIy);
      }
      AppMethodBeat.o(41707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label442;
      }
    }
    label442:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.xIx != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xIx);
      }
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xIy);
      }
      AppMethodBeat.o(41707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Title");
          AppMethodBeat.o(41707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41707);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41707);
          return -1;
        case 1: 
          localb.Title = locala.UbS.readString();
          AppMethodBeat.o(41707);
          return 0;
        case 2: 
          localb.Desc = locala.UbS.readString();
          AppMethodBeat.o(41707);
          return 0;
        case 3: 
          localb.xIx = locala.UbS.readString();
          AppMethodBeat.o(41707);
          return 0;
        }
        localb.xIy = locala.UbS.readString();
        AppMethodBeat.o(41707);
        return 0;
      }
      AppMethodBeat.o(41707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.b
 * JD-Core Version:    0.7.0.1
 */