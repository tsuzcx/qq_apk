package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cb
  extends com.tencent.mm.bx.a
{
  public String IconUrl;
  public String Title;
  public String rZo;
  public String scX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41801);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      if (this.rZo != null) {
        paramVarArgs.d(3, this.rZo);
      }
      if (this.scX != null) {
        paramVarArgs.d(4, this.scX);
      }
      AppMethodBeat.o(41801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i = paramInt;
      if (this.rZo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rZo);
      }
      paramInt = i;
      if (this.scX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.scX);
      }
      AppMethodBeat.o(41801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41801);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cb localcb = (cb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41801);
          return -1;
        case 1: 
          localcb.Title = locala.KhF.readString();
          AppMethodBeat.o(41801);
          return 0;
        case 2: 
          localcb.IconUrl = locala.KhF.readString();
          AppMethodBeat.o(41801);
          return 0;
        case 3: 
          localcb.rZo = locala.KhF.readString();
          AppMethodBeat.o(41801);
          return 0;
        }
        localcb.scX = locala.KhF.readString();
        AppMethodBeat.o(41801);
        return 0;
      }
      AppMethodBeat.o(41801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cb
 * JD-Core Version:    0.7.0.1
 */