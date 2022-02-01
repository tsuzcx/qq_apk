package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends com.tencent.mm.bw.a
{
  public String urr;
  public String urs;
  public String urt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41720);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.urr != null) {
        paramVarArgs.d(1, this.urr);
      }
      if (this.urs != null) {
        paramVarArgs.d(2, this.urs);
      }
      if (this.urt != null) {
        paramVarArgs.d(3, this.urt);
      }
      AppMethodBeat.o(41720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.urr == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.urr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.urs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.urs);
      }
      i = paramInt;
      if (this.urt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.urt);
      }
      AppMethodBeat.o(41720);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41720);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41720);
          return -1;
        case 1: 
          localv.urr = locala.OmT.readString();
          AppMethodBeat.o(41720);
          return 0;
        case 2: 
          localv.urs = locala.OmT.readString();
          AppMethodBeat.o(41720);
          return 0;
        }
        localv.urt = locala.OmT.readString();
        AppMethodBeat.o(41720);
        return 0;
      }
      AppMethodBeat.o(41720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.v
 * JD-Core Version:    0.7.0.1
 */