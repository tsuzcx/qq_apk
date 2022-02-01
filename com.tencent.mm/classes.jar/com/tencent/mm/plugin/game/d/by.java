package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class by
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String ufb;
  public String ugo;
  public String uiM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41791);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uiM == null)
      {
        paramVarArgs = new b("Not all required fields were included: LogoURL");
        AppMethodBeat.o(41791);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41791);
        throw paramVarArgs;
      }
      if (this.ugo == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41791);
        throw paramVarArgs;
      }
      if (this.ufb == null)
      {
        paramVarArgs = new b("Not all required fields were included: WebURL");
        AppMethodBeat.o(41791);
        throw paramVarArgs;
      }
      if (this.uiM != null) {
        paramVarArgs.d(1, this.uiM);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.ugo != null) {
        paramVarArgs.d(3, this.ugo);
      }
      if (this.ufb != null) {
        paramVarArgs.d(4, this.ufb);
      }
      AppMethodBeat.o(41791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uiM == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.b.b.a.e(1, this.uiM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.ugo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ugo);
      }
      paramInt = i;
      if (this.ufb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ufb);
      }
      AppMethodBeat.o(41791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.uiM == null)
        {
          paramVarArgs = new b("Not all required fields were included: LogoURL");
          AppMethodBeat.o(41791);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41791);
          throw paramVarArgs;
        }
        if (this.ugo == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41791);
          throw paramVarArgs;
        }
        if (this.ufb == null)
        {
          paramVarArgs = new b("Not all required fields were included: WebURL");
          AppMethodBeat.o(41791);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41791);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        by localby = (by)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41791);
          return -1;
        case 1: 
          localby.uiM = locala.NPN.readString();
          AppMethodBeat.o(41791);
          return 0;
        case 2: 
          localby.Title = locala.NPN.readString();
          AppMethodBeat.o(41791);
          return 0;
        case 3: 
          localby.ugo = locala.NPN.readString();
          AppMethodBeat.o(41791);
          return 0;
        }
        localby.ufb = locala.NPN.readString();
        AppMethodBeat.o(41791);
        return 0;
      }
      AppMethodBeat.o(41791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.by
 * JD-Core Version:    0.7.0.1
 */