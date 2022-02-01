package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cg
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String hDa;
  public LinkedList<String> uiX;
  
  public cg()
  {
    AppMethodBeat.i(41799);
    this.uiX = new LinkedList();
    AppMethodBeat.o(41799);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41800);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.hDa != null) {
        paramVarArgs.d(2, this.hDa);
      }
      paramVarArgs.e(3, 1, this.uiX);
      AppMethodBeat.o(41800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hDa != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hDa);
      }
      paramInt = f.a.a.a.c(3, 1, this.uiX);
      AppMethodBeat.o(41800);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uiX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41800);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cg localcg = (cg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41800);
          return -1;
        case 1: 
          localcg.Title = locala.NPN.readString();
          AppMethodBeat.o(41800);
          return 0;
        case 2: 
          localcg.hDa = locala.NPN.readString();
          AppMethodBeat.o(41800);
          return 0;
        }
        localcg.uiX.add(locala.NPN.readString());
        AppMethodBeat.o(41800);
        return 0;
      }
      AppMethodBeat.o(41800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cg
 * JD-Core Version:    0.7.0.1
 */