package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class co
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String Title;
  public String uqf;
  public String uuv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41801);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      if (this.uqf != null) {
        paramVarArgs.d(3, this.uqf);
      }
      if (this.uuv != null) {
        paramVarArgs.d(4, this.uuv);
      }
      AppMethodBeat.o(41801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i = paramInt;
      if (this.uqf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uqf);
      }
      paramInt = i;
      if (this.uuv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uuv);
      }
      AppMethodBeat.o(41801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41801);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        co localco = (co)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41801);
          return -1;
        case 1: 
          localco.Title = locala.OmT.readString();
          AppMethodBeat.o(41801);
          return 0;
        case 2: 
          localco.IconUrl = locala.OmT.readString();
          AppMethodBeat.o(41801);
          return 0;
        case 3: 
          localco.uqf = locala.OmT.readString();
          AppMethodBeat.o(41801);
          return 0;
        }
        localco.uuv = locala.OmT.readString();
        AppMethodBeat.o(41801);
        return 0;
      }
      AppMethodBeat.o(41801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.co
 * JD-Core Version:    0.7.0.1
 */