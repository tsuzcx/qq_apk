package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cn
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String iAc;
  public LinkedList<String> xMw;
  
  public cn()
  {
    AppMethodBeat.i(41799);
    this.xMw = new LinkedList();
    AppMethodBeat.o(41799);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41800);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.iAc != null) {
        paramVarArgs.e(2, this.iAc);
      }
      paramVarArgs.e(3, 1, this.xMw);
      AppMethodBeat.o(41800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iAc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.iAc);
      }
      paramInt = g.a.a.a.c(3, 1, this.xMw);
      AppMethodBeat.o(41800);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xMw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41800);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cn localcn = (cn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41800);
          return -1;
        case 1: 
          localcn.Title = locala.UbS.readString();
          AppMethodBeat.o(41800);
          return 0;
        case 2: 
          localcn.iAc = locala.UbS.readString();
          AppMethodBeat.o(41800);
          return 0;
        }
        localcn.xMw.add(locala.UbS.readString());
        AppMethodBeat.o(41800);
        return 0;
      }
      AppMethodBeat.o(41800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cn
 * JD-Core Version:    0.7.0.1
 */