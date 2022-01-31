package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class db
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String npQ;
  public String npR;
  public int nui;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111669);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.npR != null) {
        paramVarArgs.e(2, this.npR);
      }
      if (this.npQ != null) {
        paramVarArgs.e(3, this.npQ);
      }
      paramVarArgs.aO(4, this.nui);
      AppMethodBeat.o(111669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.npR != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.npR);
      }
      i = paramInt;
      if (this.npQ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npQ);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.nui);
      AppMethodBeat.o(111669);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111669);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        db localdb = (db)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111669);
          return -1;
        case 1: 
          localdb.Title = locala.CLY.readString();
          AppMethodBeat.o(111669);
          return 0;
        case 2: 
          localdb.npR = locala.CLY.readString();
          AppMethodBeat.o(111669);
          return 0;
        case 3: 
          localdb.npQ = locala.CLY.readString();
          AppMethodBeat.o(111669);
          return 0;
        }
        localdb.nui = locala.CLY.sl();
        AppMethodBeat.o(111669);
        return 0;
      }
      AppMethodBeat.o(111669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.db
 * JD-Core Version:    0.7.0.1
 */