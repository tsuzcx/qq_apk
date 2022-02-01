package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cf
  extends com.tencent.mm.bx.a
{
  public String Title;
  public LinkedList<cl> rOa;
  public String saB;
  
  public cf()
  {
    AppMethodBeat.i(41806);
    this.rOa = new LinkedList();
    AppMethodBeat.o(41806);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41807);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41807);
        throw paramVarArgs;
      }
      if (this.saB == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41807);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.rOa);
      if (this.saB != null) {
        paramVarArgs.d(3, this.saB);
      }
      AppMethodBeat.o(41807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.rOa);
      paramInt = i;
      if (this.saB != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.saB);
      }
      AppMethodBeat.o(41807);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rOa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41807);
          throw paramVarArgs;
        }
        if (this.saB == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41807);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cf localcf = (cf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41807);
          return -1;
        case 1: 
          localcf.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41807);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcf.rOa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41807);
          return 0;
        }
        localcf.saB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41807);
        return 0;
      }
      AppMethodBeat.o(41807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cf
 * JD-Core Version:    0.7.0.1
 */