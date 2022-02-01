package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bt
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String thk;
  public String tiv;
  public String tkG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41791);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tkG == null)
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
      if (this.tiv == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41791);
        throw paramVarArgs;
      }
      if (this.thk == null)
      {
        paramVarArgs = new b("Not all required fields were included: WebURL");
        AppMethodBeat.o(41791);
        throw paramVarArgs;
      }
      if (this.tkG != null) {
        paramVarArgs.d(1, this.tkG);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.tiv != null) {
        paramVarArgs.d(3, this.tiv);
      }
      if (this.thk != null) {
        paramVarArgs.d(4, this.thk);
      }
      AppMethodBeat.o(41791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tkG == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.b.b.a.e(1, this.tkG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.tiv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tiv);
      }
      paramInt = i;
      if (this.thk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thk);
      }
      AppMethodBeat.o(41791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.tkG == null)
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
        if (this.tiv == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41791);
          throw paramVarArgs;
        }
        if (this.thk == null)
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
        bt localbt = (bt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41791);
          return -1;
        case 1: 
          localbt.tkG = locala.LVo.readString();
          AppMethodBeat.o(41791);
          return 0;
        case 2: 
          localbt.Title = locala.LVo.readString();
          AppMethodBeat.o(41791);
          return 0;
        case 3: 
          localbt.tiv = locala.LVo.readString();
          AppMethodBeat.o(41791);
          return 0;
        }
        localbt.thk = locala.LVo.readString();
        AppMethodBeat.o(41791);
        return 0;
      }
      AppMethodBeat.o(41791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bt
 * JD-Core Version:    0.7.0.1
 */