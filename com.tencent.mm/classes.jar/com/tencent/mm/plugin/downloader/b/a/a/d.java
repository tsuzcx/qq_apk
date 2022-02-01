package com.tencent.mm.plugin.downloader.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.b.k;
import i.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public k xkS;
  public e xkT;
  public c xkU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153044);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.xkS == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_info");
        AppMethodBeat.o(153044);
        throw paramVarArgs;
      }
      if (this.xkS != null)
      {
        paramVarArgs.qD(1, this.xkS.computeSize());
        this.xkS.writeFields(paramVarArgs);
      }
      if (this.xkT != null)
      {
        paramVarArgs.qD(2, this.xkT.computeSize());
        this.xkT.writeFields(paramVarArgs);
      }
      if (this.xkU != null)
      {
        paramVarArgs.qD(3, this.xkU.computeSize());
        this.xkU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xkS == null) {
        break label596;
      }
    }
    label596:
    for (int i = i.a.a.a.qC(1, this.xkS.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xkT != null) {
        paramInt = i + i.a.a.a.qC(2, this.xkT.computeSize());
      }
      i = paramInt;
      if (this.xkU != null) {
        i = paramInt + i.a.a.a.qC(3, this.xkU.computeSize());
      }
      AppMethodBeat.o(153044);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.xkS == null)
        {
          paramVarArgs = new b("Not all required fields were included: app_info");
          AppMethodBeat.o(153044);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153044);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153044);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new k();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((k)localObject2).parseFrom((byte[])localObject1);
            }
            locald.xkS = ((k)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153044);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new e();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((e)localObject2).parseFrom((byte[])localObject1);
            }
            locald.xkT = ((e)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153044);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new c();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((c)localObject2).parseFrom((byte[])localObject1);
          }
          locald.xkU = ((c)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153044);
        return 0;
      }
      AppMethodBeat.o(153044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */