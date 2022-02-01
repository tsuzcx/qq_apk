package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cf
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String uqi;
  public String urL;
  public String uuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41791);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuj == null)
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
      if (this.urL == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41791);
        throw paramVarArgs;
      }
      if (this.uqi == null)
      {
        paramVarArgs = new b("Not all required fields were included: WebURL");
        AppMethodBeat.o(41791);
        throw paramVarArgs;
      }
      if (this.uuj != null) {
        paramVarArgs.d(1, this.uuj);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.urL != null) {
        paramVarArgs.d(3, this.urL);
      }
      if (this.uqi != null) {
        paramVarArgs.d(4, this.uqi);
      }
      AppMethodBeat.o(41791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuj == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.b.b.a.e(1, this.uuj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.urL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.urL);
      }
      paramInt = i;
      if (this.uqi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uqi);
      }
      AppMethodBeat.o(41791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.uuj == null)
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
        if (this.urL == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41791);
          throw paramVarArgs;
        }
        if (this.uqi == null)
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
        cf localcf = (cf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41791);
          return -1;
        case 1: 
          localcf.uuj = locala.OmT.readString();
          AppMethodBeat.o(41791);
          return 0;
        case 2: 
          localcf.Title = locala.OmT.readString();
          AppMethodBeat.o(41791);
          return 0;
        case 3: 
          localcf.urL = locala.OmT.readString();
          AppMethodBeat.o(41791);
          return 0;
        }
        localcf.uqi = locala.OmT.readString();
        AppMethodBeat.o(41791);
        return 0;
      }
      AppMethodBeat.o(41791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cf
 * JD-Core Version:    0.7.0.1
 */