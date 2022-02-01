package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class de
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String uiK;
  public String uiL;
  public LinkedList<df> ujA;
  public String ujB;
  public String ujC;
  
  public de()
  {
    AppMethodBeat.i(41826);
    this.ujA = new LinkedList();
    AppMethodBeat.o(41826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41827);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41827);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.ujA);
      if (this.uiK != null) {
        paramVarArgs.d(3, this.uiK);
      }
      if (this.uiL != null) {
        paramVarArgs.d(4, this.uiL);
      }
      if (this.ujB != null) {
        paramVarArgs.d(5, this.ujB);
      }
      if (this.ujC != null) {
        paramVarArgs.d(6, this.ujC);
      }
      AppMethodBeat.o(41827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.ujA);
      paramInt = i;
      if (this.uiK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.uiK);
      }
      i = paramInt;
      if (this.uiL != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.uiL);
      }
      paramInt = i;
      if (this.ujB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ujB);
      }
      i = paramInt;
      if (this.ujC != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ujC);
      }
      AppMethodBeat.o(41827);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ujA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41827);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        de localde = (de)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41827);
          return -1;
        case 1: 
          localde.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41827);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new df();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((df)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localde.ujA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41827);
          return 0;
        case 3: 
          localde.uiK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41827);
          return 0;
        case 4: 
          localde.uiL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41827);
          return 0;
        case 5: 
          localde.ujB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41827);
          return 0;
        }
        localde.ujC = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41827);
        return 0;
      }
      AppMethodBeat.o(41827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.de
 * JD-Core Version:    0.7.0.1
 */