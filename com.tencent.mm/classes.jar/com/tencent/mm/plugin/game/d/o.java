package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class o
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String IconUrl;
  public String Title;
  public String uqf;
  public String ura;
  public int urc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41715);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IconUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.uqf == null)
      {
        paramVarArgs = new b("Not all required fields were included: JumpUrl");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(1, this.IconUrl);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.uqf != null) {
        paramVarArgs.d(4, this.uqf);
      }
      paramVarArgs.aS(5, this.urc);
      if (this.ura != null) {
        paramVarArgs.d(6, this.ura);
      }
      AppMethodBeat.o(41715);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IconUrl == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.b.b.a.e(1, this.IconUrl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Desc);
      }
      paramInt = i;
      if (this.uqf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uqf);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.urc);
      paramInt = i;
      if (this.ura != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ura);
      }
      AppMethodBeat.o(41715);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.IconUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(41715);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41715);
          throw paramVarArgs;
        }
        if (this.uqf == null)
        {
          paramVarArgs = new b("Not all required fields were included: JumpUrl");
          AppMethodBeat.o(41715);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41715);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41715);
          return -1;
        case 1: 
          localo.IconUrl = locala.OmT.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 2: 
          localo.Title = locala.OmT.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 3: 
          localo.Desc = locala.OmT.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 4: 
          localo.uqf = locala.OmT.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 5: 
          localo.urc = locala.OmT.zc();
          AppMethodBeat.o(41715);
          return 0;
        }
        localo.ura = locala.OmT.readString();
        AppMethodBeat.o(41715);
        return 0;
      }
      AppMethodBeat.o(41715);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.o
 * JD-Core Version:    0.7.0.1
 */