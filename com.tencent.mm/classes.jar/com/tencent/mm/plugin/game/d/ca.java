package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ca
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String ntu;
  public LinkedList<String> ntv;
  
  public ca()
  {
    AppMethodBeat.i(111634);
    this.ntv = new LinkedList();
    AppMethodBeat.o(111634);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111635);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.ntu != null) {
        paramVarArgs.e(2, this.ntu);
      }
      paramVarArgs.e(3, 1, this.ntv);
      AppMethodBeat.o(111635);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = e.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ntu != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.ntu);
      }
      paramInt = e.a.a.a.c(3, 1, this.ntv);
      AppMethodBeat.o(111635);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ntv.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111635);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ca localca = (ca)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111635);
          return -1;
        case 1: 
          localca.Title = locala.CLY.readString();
          AppMethodBeat.o(111635);
          return 0;
        case 2: 
          localca.ntu = locala.CLY.readString();
          AppMethodBeat.o(111635);
          return 0;
        }
        localca.ntv.add(locala.CLY.readString());
        AppMethodBeat.o(111635);
        return 0;
      }
      AppMethodBeat.o(111635);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ca
 * JD-Core Version:    0.7.0.1
 */