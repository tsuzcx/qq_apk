package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class p
  extends com.tencent.mm.bw.a
{
  public String Url;
  public String urg;
  public String urh;
  public String urj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.urg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Message");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.urh == null)
      {
        paramVarArgs = new b("Not all required fields were included: GotoBtn");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.urj == null)
      {
        paramVarArgs = new b("Not all required fields were included: CancelBtn");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.urg != null) {
        paramVarArgs.d(1, this.urg);
      }
      if (this.urh != null) {
        paramVarArgs.d(2, this.urh);
      }
      if (this.urj != null) {
        paramVarArgs.d(3, this.urj);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      AppMethodBeat.o(41716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.urg == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.b.b.a.e(1, this.urg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.urh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.urh);
      }
      i = paramInt;
      if (this.urj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.urj);
      }
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Url);
      }
      AppMethodBeat.o(41716);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.urg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Message");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.urh == null)
        {
          paramVarArgs = new b("Not all required fields were included: GotoBtn");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.urj == null)
        {
          paramVarArgs = new b("Not all required fields were included: CancelBtn");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41716);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41716);
          return -1;
        case 1: 
          localp.urg = locala.OmT.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 2: 
          localp.urh = locala.OmT.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 3: 
          localp.urj = locala.OmT.readString();
          AppMethodBeat.o(41716);
          return 0;
        }
        localp.Url = locala.OmT.readString();
        AppMethodBeat.o(41716);
        return 0;
      }
      AppMethodBeat.o(41716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.p
 * JD-Core Version:    0.7.0.1
 */