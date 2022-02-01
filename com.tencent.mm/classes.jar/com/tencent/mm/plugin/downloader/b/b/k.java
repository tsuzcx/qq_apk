package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bx.a
{
  public d xmf;
  public e xmg;
  public g xmh;
  public l xmi;
  public b xmj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153071);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.xmf == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: base_info");
        AppMethodBeat.o(153071);
        throw paramVarArgs;
      }
      if (this.xmf != null)
      {
        paramVarArgs.qD(1, this.xmf.computeSize());
        this.xmf.writeFields(paramVarArgs);
      }
      if (this.xmg != null)
      {
        paramVarArgs.qD(2, this.xmg.computeSize());
        this.xmg.writeFields(paramVarArgs);
      }
      if (this.xmh != null)
      {
        paramVarArgs.qD(3, this.xmh.computeSize());
        this.xmh.writeFields(paramVarArgs);
      }
      if (this.xmi != null)
      {
        paramVarArgs.qD(4, this.xmi.computeSize());
        this.xmi.writeFields(paramVarArgs);
      }
      if (this.xmj != null)
      {
        paramVarArgs.qD(5, this.xmj.computeSize());
        this.xmj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153071);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xmf == null) {
        break label860;
      }
    }
    label860:
    for (int i = i.a.a.a.qC(1, this.xmf.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xmg != null) {
        paramInt = i + i.a.a.a.qC(2, this.xmg.computeSize());
      }
      i = paramInt;
      if (this.xmh != null) {
        i = paramInt + i.a.a.a.qC(3, this.xmh.computeSize());
      }
      paramInt = i;
      if (this.xmi != null) {
        paramInt = i + i.a.a.a.qC(4, this.xmi.computeSize());
      }
      i = paramInt;
      if (this.xmj != null) {
        i = paramInt + i.a.a.a.qC(5, this.xmj.computeSize());
      }
      AppMethodBeat.o(153071);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.xmf == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: base_info");
          AppMethodBeat.o(153071);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153071);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153071);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            localk.xmf = ((d)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
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
            localk.xmg = ((e)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 3: 
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
            localk.xmh = ((g)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new l();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((l)localObject2).parseFrom((byte[])localObject1);
            }
            localk.xmi = ((l)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new b();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((b)localObject2).parseFrom((byte[])localObject1);
          }
          localk.xmj = ((b)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153071);
        return 0;
      }
      AppMethodBeat.o(153071);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.k
 * JD-Core Version:    0.7.0.1
 */