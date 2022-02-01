package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ca
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String gKr;
  public LinkedList<String> scW;
  
  public ca()
  {
    AppMethodBeat.i(41799);
    this.scW = new LinkedList();
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
      if (this.gKr != null) {
        paramVarArgs.d(2, this.gKr);
      }
      paramVarArgs.e(3, 1, this.scW);
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
      if (this.gKr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.gKr);
      }
      paramInt = f.a.a.a.c(3, 1, this.scW);
      AppMethodBeat.o(41800);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.scW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41800);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ca localca = (ca)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41800);
          return -1;
        case 1: 
          localca.Title = locala.KhF.readString();
          AppMethodBeat.o(41800);
          return 0;
        case 2: 
          localca.gKr = locala.KhF.readString();
          AppMethodBeat.o(41800);
          return 0;
        }
        localca.scW.add(locala.KhF.readString());
        AppMethodBeat.o(41800);
        return 0;
      }
      AppMethodBeat.o(41800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ca
 * JD-Core Version:    0.7.0.1
 */