package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ce
  extends com.tencent.mm.bw.a
{
  public String Title;
  public LinkedList<cf> uug;
  public String uuh;
  public String uui;
  
  public ce()
  {
    AppMethodBeat.i(41789);
    this.uug = new LinkedList();
    AppMethodBeat.o(41789);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41790);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41790);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.uug);
      if (this.uuh != null) {
        paramVarArgs.d(3, this.uuh);
      }
      if (this.uui != null) {
        paramVarArgs.d(4, this.uui);
      }
      AppMethodBeat.o(41790);
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
      int i = paramInt + f.a.a.a.c(2, 8, this.uug);
      paramInt = i;
      if (this.uuh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.uuh);
      }
      i = paramInt;
      if (this.uui != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.uui);
      }
      AppMethodBeat.o(41790);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uug.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41790);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41790);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ce localce = (ce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41790);
          return -1;
        case 1: 
          localce.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41790);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localce.uug.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41790);
          return 0;
        case 3: 
          localce.uuh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41790);
          return 0;
        }
        localce.uui = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41790);
        return 0;
      }
      AppMethodBeat.o(41790);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ce
 * JD-Core Version:    0.7.0.1
 */