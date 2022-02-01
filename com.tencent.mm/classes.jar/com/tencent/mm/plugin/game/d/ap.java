package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ap
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String hOf;
  public String thh;
  public String tjl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41745);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tjl != null) {
        paramVarArgs.d(1, this.tjl);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.thh != null) {
        paramVarArgs.d(4, this.thh);
      }
      if (this.hOf != null) {
        paramVarArgs.d(5, this.hOf);
      }
      AppMethodBeat.o(41745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tjl == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.tjl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Desc);
      }
      paramInt = i;
      if (this.thh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thh);
      }
      i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hOf);
      }
      AppMethodBeat.o(41745);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41745);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41745);
          return -1;
        case 1: 
          localap.tjl = locala.LVo.readString();
          AppMethodBeat.o(41745);
          return 0;
        case 2: 
          localap.Title = locala.LVo.readString();
          AppMethodBeat.o(41745);
          return 0;
        case 3: 
          localap.Desc = locala.LVo.readString();
          AppMethodBeat.o(41745);
          return 0;
        case 4: 
          localap.thh = locala.LVo.readString();
          AppMethodBeat.o(41745);
          return 0;
        }
        localap.hOf = locala.LVo.readString();
        AppMethodBeat.o(41745);
        return 0;
      }
      AppMethodBeat.o(41745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ap
 * JD-Core Version:    0.7.0.1
 */