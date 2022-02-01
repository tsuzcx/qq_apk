package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.cd.a
{
  public d ufZ;
  public e uga;
  public g ugb;
  public l ugc;
  public b ugd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153071);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ufZ == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: base_info");
        AppMethodBeat.o(153071);
        throw paramVarArgs;
      }
      if (this.ufZ != null)
      {
        paramVarArgs.oE(1, this.ufZ.computeSize());
        this.ufZ.writeFields(paramVarArgs);
      }
      if (this.uga != null)
      {
        paramVarArgs.oE(2, this.uga.computeSize());
        this.uga.writeFields(paramVarArgs);
      }
      if (this.ugb != null)
      {
        paramVarArgs.oE(3, this.ugb.computeSize());
        this.ugb.writeFields(paramVarArgs);
      }
      if (this.ugc != null)
      {
        paramVarArgs.oE(4, this.ugc.computeSize());
        this.ugc.writeFields(paramVarArgs);
      }
      if (this.ugd != null)
      {
        paramVarArgs.oE(5, this.ugd.computeSize());
        this.ugd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153071);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufZ == null) {
        break label864;
      }
    }
    label864:
    for (int i = g.a.a.a.oD(1, this.ufZ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uga != null) {
        paramInt = i + g.a.a.a.oD(2, this.uga.computeSize());
      }
      i = paramInt;
      if (this.ugb != null) {
        i = paramInt + g.a.a.a.oD(3, this.ugb.computeSize());
      }
      paramInt = i;
      if (this.ugc != null) {
        paramInt = i + g.a.a.a.oD(4, this.ugc.computeSize());
      }
      i = paramInt;
      if (this.ugd != null) {
        i = paramInt + g.a.a.a.oD(5, this.ugd.computeSize());
      }
      AppMethodBeat.o(153071);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.ufZ == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: base_info");
          AppMethodBeat.o(153071);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153071);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153071);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            localk.ufZ = ((d)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new e();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((e)localObject2).parseFrom((byte[])localObject1);
            }
            localk.uga = ((e)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new g();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((g)localObject2).parseFrom((byte[])localObject1);
            }
            localk.ugb = ((g)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new l();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((l)localObject2).parseFrom((byte[])localObject1);
            }
            localk.ugc = ((l)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new b();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((b)localObject2).parseFrom((byte[])localObject1);
          }
          localk.ugd = ((b)localObject2);
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
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.k
 * JD-Core Version:    0.7.0.1
 */