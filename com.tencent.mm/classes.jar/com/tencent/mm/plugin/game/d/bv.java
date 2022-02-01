package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bv
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String tkE;
  public String tkF;
  public LinkedList<bw> tkI;
  
  public bv()
  {
    AppMethodBeat.i(41793);
    this.tkI = new LinkedList();
    AppMethodBeat.o(41793);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41794);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41794);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.tkI);
      if (this.tkE != null) {
        paramVarArgs.d(3, this.tkE);
      }
      if (this.tkF != null) {
        paramVarArgs.d(4, this.tkF);
      }
      AppMethodBeat.o(41794);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.tkI);
      paramInt = i;
      if (this.tkE != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.tkE);
      }
      i = paramInt;
      if (this.tkF != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tkF);
      }
      AppMethodBeat.o(41794);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tkI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41794);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41794);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bv localbv = (bv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41794);
          return -1;
        case 1: 
          localbv.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41794);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbv.tkI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41794);
          return 0;
        case 3: 
          localbv.tkE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41794);
          return 0;
        }
        localbv.tkF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41794);
        return 0;
      }
      AppMethodBeat.o(41794);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bv
 * JD-Core Version:    0.7.0.1
 */