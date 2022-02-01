package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cb
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String Title;
  public String thh;
  public String tkR;
  
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
      if (this.thh != null) {
        paramVarArgs.d(3, this.thh);
      }
      if (this.tkR != null) {
        paramVarArgs.d(4, this.tkR);
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
      if (this.thh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thh);
      }
      paramInt = i;
      if (this.tkR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tkR);
      }
      AppMethodBeat.o(41801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localcb.Title = locala.LVo.readString();
          AppMethodBeat.o(41801);
          return 0;
        case 2: 
          localcb.IconUrl = locala.LVo.readString();
          AppMethodBeat.o(41801);
          return 0;
        case 3: 
          localcb.thh = locala.LVo.readString();
          AppMethodBeat.o(41801);
          return 0;
        }
        localcb.tkR = locala.LVo.readString();
        AppMethodBeat.o(41801);
        return 0;
      }
      AppMethodBeat.o(41801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cb
 * JD-Core Version:    0.7.0.1
 */