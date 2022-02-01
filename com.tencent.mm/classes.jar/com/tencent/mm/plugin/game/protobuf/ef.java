package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ef
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String Title;
  public String xIy;
  public String xJt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41839);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.IconUrl != null) {
        paramVarArgs.e(1, this.IconUrl);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.xIy != null) {
        paramVarArgs.e(3, this.xIy);
      }
      if (this.xJt != null) {
        paramVarArgs.e(4, this.xJt);
      }
      AppMethodBeat.o(41839);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IconUrl == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.IconUrl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.xIy != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xIy);
      }
      paramInt = i;
      if (this.xJt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xJt);
      }
      AppMethodBeat.o(41839);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41839);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ef localef = (ef)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41839);
          return -1;
        case 1: 
          localef.IconUrl = locala.UbS.readString();
          AppMethodBeat.o(41839);
          return 0;
        case 2: 
          localef.Title = locala.UbS.readString();
          AppMethodBeat.o(41839);
          return 0;
        case 3: 
          localef.xIy = locala.UbS.readString();
          AppMethodBeat.o(41839);
          return 0;
        }
        localef.xJt = locala.UbS.readString();
        AppMethodBeat.o(41839);
        return 0;
      }
      AppMethodBeat.o(41839);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ef
 * JD-Core Version:    0.7.0.1
 */