package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ef
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String Title;
  public String uqf;
  public String ura;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41839);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IconUrl != null) {
        paramVarArgs.d(1, this.IconUrl);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.uqf != null) {
        paramVarArgs.d(3, this.uqf);
      }
      if (this.ura != null) {
        paramVarArgs.d(4, this.ura);
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
    for (int i = f.a.a.b.b.a.e(1, this.IconUrl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.uqf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uqf);
      }
      paramInt = i;
      if (this.ura != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ura);
      }
      AppMethodBeat.o(41839);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41839);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ef localef = (ef)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41839);
          return -1;
        case 1: 
          localef.IconUrl = locala.OmT.readString();
          AppMethodBeat.o(41839);
          return 0;
        case 2: 
          localef.Title = locala.OmT.readString();
          AppMethodBeat.o(41839);
          return 0;
        case 3: 
          localef.uqf = locala.OmT.readString();
          AppMethodBeat.o(41839);
          return 0;
        }
        localef.ura = locala.OmT.readString();
        AppMethodBeat.o(41839);
        return 0;
      }
      AppMethodBeat.o(41839);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ef
 * JD-Core Version:    0.7.0.1
 */