package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ci
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String uqi;
  public String urL;
  public String uuj;
  public String uum;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41795);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41795);
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
      if (this.uum != null) {
        paramVarArgs.d(5, this.uum);
      }
      AppMethodBeat.o(41795);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuj == null) {
        break label502;
      }
    }
    label502:
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
      i = paramInt;
      if (this.uum != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uum);
      }
      AppMethodBeat.o(41795);
      return i;
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
          AppMethodBeat.o(41795);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41795);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ci localci = (ci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41795);
          return -1;
        case 1: 
          localci.uuj = locala.OmT.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 2: 
          localci.Title = locala.OmT.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 3: 
          localci.urL = locala.OmT.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 4: 
          localci.uqi = locala.OmT.readString();
          AppMethodBeat.o(41795);
          return 0;
        }
        localci.uum = locala.OmT.readString();
        AppMethodBeat.o(41795);
        return 0;
      }
      AppMethodBeat.o(41795);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ci
 * JD-Core Version:    0.7.0.1
 */