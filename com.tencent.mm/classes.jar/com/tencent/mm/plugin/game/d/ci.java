package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ci
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String thh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41811);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(41811);
        throw paramVarArgs;
      }
      if (this.Desc != null) {
        paramVarArgs.d(1, this.Desc);
      }
      if (this.thh != null) {
        paramVarArgs.d(2, this.thh);
      }
      AppMethodBeat.o(41811);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Desc == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.Desc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thh != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.thh);
      }
      AppMethodBeat.o(41811);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Desc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(41811);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41811);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ci localci = (ci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41811);
          return -1;
        case 1: 
          localci.Desc = locala.LVo.readString();
          AppMethodBeat.o(41811);
          return 0;
        }
        localci.thh = locala.LVo.readString();
        AppMethodBeat.o(41811);
        return 0;
      }
      AppMethodBeat.o(41811);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ci
 * JD-Core Version:    0.7.0.1
 */