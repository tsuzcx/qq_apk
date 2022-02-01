package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String qkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221880);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      if (this.qkN != null) {
        paramVarArgs.d(3, this.qkN);
      }
      AppMethodBeat.o(221880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Desc);
      }
      i = paramInt;
      if (this.qkN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.qkN);
      }
      AppMethodBeat.o(221880);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(221880);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(221880);
          return -1;
        case 1: 
          localz.Title = locala.OmT.readString();
          AppMethodBeat.o(221880);
          return 0;
        case 2: 
          localz.Desc = locala.OmT.readString();
          AppMethodBeat.o(221880);
          return 0;
        }
        localz.qkN = locala.OmT.readString();
        AppMethodBeat.o(221880);
        return 0;
      }
      AppMethodBeat.o(221880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.z
 * JD-Core Version:    0.7.0.1
 */