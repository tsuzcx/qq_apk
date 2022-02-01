package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class di
  extends com.tencent.mm.bx.a
{
  public String IconUrl;
  public String Title;
  public String rZW;
  public String rZo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41839);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IconUrl != null) {
        paramVarArgs.d(1, this.IconUrl);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.rZo != null) {
        paramVarArgs.d(3, this.rZo);
      }
      if (this.rZW != null) {
        paramVarArgs.d(4, this.rZW);
      }
      AppMethodBeat.o(41839);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IconUrl == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.IconUrl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.rZo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rZo);
      }
      paramInt = i;
      if (this.rZW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rZW);
      }
      AppMethodBeat.o(41839);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41839);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        di localdi = (di)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41839);
          return -1;
        case 1: 
          localdi.IconUrl = locala.KhF.readString();
          AppMethodBeat.o(41839);
          return 0;
        case 2: 
          localdi.Title = locala.KhF.readString();
          AppMethodBeat.o(41839);
          return 0;
        case 3: 
          localdi.rZo = locala.KhF.readString();
          AppMethodBeat.o(41839);
          return 0;
        }
        localdi.rZW = locala.KhF.readString();
        AppMethodBeat.o(41839);
        return 0;
      }
      AppMethodBeat.o(41839);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.di
 * JD-Core Version:    0.7.0.1
 */