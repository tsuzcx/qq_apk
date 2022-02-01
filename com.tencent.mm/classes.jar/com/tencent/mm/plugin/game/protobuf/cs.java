package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cs
  extends com.tencent.mm.bx.a
{
  public LinkedList<ct> IKT;
  public cu IKU;
  public String hAP;
  
  public cs()
  {
    AppMethodBeat.i(41802);
    this.IKT = new LinkedList();
    AppMethodBeat.o(41802);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41803);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41803);
        throw paramVarArgs;
      }
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      paramVarArgs.e(2, 8, this.IKT);
      if (this.IKU != null)
      {
        paramVarArgs.qD(3, this.IKU.computeSize());
        this.IKU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41803);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.IKT);
      paramInt = i;
      if (this.IKU != null) {
        paramInt = i + i.a.a.a.qC(3, this.IKU.computeSize());
      }
      AppMethodBeat.o(41803);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IKT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.hAP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41803);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41803);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cs localcs = (cs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41803);
          return -1;
        case 1: 
          localcs.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41803);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ct();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ct)localObject2).parseFrom((byte[])localObject1);
            }
            localcs.IKT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41803);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cu)localObject2).parseFrom((byte[])localObject1);
          }
          localcs.IKU = ((cu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41803);
        return 0;
      }
      AppMethodBeat.o(41803);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cs
 * JD-Core Version:    0.7.0.1
 */