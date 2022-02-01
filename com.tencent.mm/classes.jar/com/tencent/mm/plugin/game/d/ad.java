package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ad
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String nIJ;
  public String uqq;
  public String urL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41724);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41724);
        throw paramVarArgs;
      }
      if (this.urL == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41724);
        throw paramVarArgs;
      }
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.uqq != null) {
        paramVarArgs.d(2, this.uqq);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.urL != null) {
        paramVarArgs.d(4, this.urL);
      }
      AppMethodBeat.o(41724);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.b.b.a.e(1, this.nIJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uqq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uqq);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.urL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.urL);
      }
      AppMethodBeat.o(41724);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41724);
          throw paramVarArgs;
        }
        if (this.urL == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41724);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41724);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41724);
          return -1;
        case 1: 
          localad.nIJ = locala.OmT.readString();
          AppMethodBeat.o(41724);
          return 0;
        case 2: 
          localad.uqq = locala.OmT.readString();
          AppMethodBeat.o(41724);
          return 0;
        case 3: 
          localad.Title = locala.OmT.readString();
          AppMethodBeat.o(41724);
          return 0;
        }
        localad.urL = locala.OmT.readString();
        AppMethodBeat.o(41724);
        return 0;
      }
      AppMethodBeat.o(41724);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ad
 * JD-Core Version:    0.7.0.1
 */