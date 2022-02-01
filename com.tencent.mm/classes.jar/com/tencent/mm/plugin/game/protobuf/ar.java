package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ar
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public g IGJ;
  public at IIS;
  public as IIT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41733);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41733);
        throw paramVarArgs;
      }
      if (this.IGJ != null)
      {
        paramVarArgs.qD(1, this.IGJ.computeSize());
        this.IGJ.writeFields(paramVarArgs);
      }
      if (this.IIS != null)
      {
        paramVarArgs.qD(2, this.IIS.computeSize());
        this.IIS.writeFields(paramVarArgs);
      }
      if (this.IIT != null)
      {
        paramVarArgs.qD(3, this.IIT.computeSize());
        this.IIT.writeFields(paramVarArgs);
      }
      if (this.IGG != null) {
        paramVarArgs.g(4, this.IGG);
      }
      AppMethodBeat.o(41733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGJ == null) {
        break label656;
      }
    }
    label656:
    for (int i = i.a.a.a.qC(1, this.IGJ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IIS != null) {
        paramInt = i + i.a.a.a.qC(2, this.IIS.computeSize());
      }
      i = paramInt;
      if (this.IIT != null) {
        i = paramInt + i.a.a.a.qC(3, this.IIT.computeSize());
      }
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGG);
      }
      AppMethodBeat.o(41733);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IGJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41733);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41733);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ar localar = (ar)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41733);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new g();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((g)localObject2).parseFrom((byte[])localObject1);
            }
            localar.IGJ = ((g)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new at();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((at)localObject2).parseFrom((byte[])localObject1);
            }
            localar.IIS = ((at)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new as();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((as)localObject2).parseFrom((byte[])localObject1);
            }
            localar.IIT = ((as)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        }
        localar.IGG = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(41733);
        return 0;
      }
      AppMethodBeat.o(41733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ar
 * JD-Core Version:    0.7.0.1
 */