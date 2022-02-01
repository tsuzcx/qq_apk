package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class ak
  extends com.tencent.mm.bx.a
{
  public ed IIx;
  public LinkedList<ei> IIy;
  
  public ak()
  {
    AppMethodBeat.i(276913);
    this.IIy = new LinkedList();
    AppMethodBeat.o(276913);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276919);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IIx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(276919);
        throw paramVarArgs;
      }
      if (this.IIx != null)
      {
        paramVarArgs.qD(1, this.IIx.computeSize());
        this.IIx.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.IIy);
      AppMethodBeat.o(276919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IIx == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = i.a.a.a.qC(1, this.IIx.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.IIy);
      AppMethodBeat.o(276919);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IIy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IIx == null)
        {
          paramVarArgs = new b("Not all required fields were included: Tab");
          AppMethodBeat.o(276919);
          throw paramVarArgs;
        }
        AppMethodBeat.o(276919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(276919);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ed();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ed)localObject2).parseFrom((byte[])localObject1);
            }
            localak.IIx = ((ed)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(276919);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ei();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ei)localObject2).parseFrom((byte[])localObject1);
          }
          localak.IIy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(276919);
        return 0;
      }
      AppMethodBeat.o(276919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ak
 * JD-Core Version:    0.7.0.1
 */