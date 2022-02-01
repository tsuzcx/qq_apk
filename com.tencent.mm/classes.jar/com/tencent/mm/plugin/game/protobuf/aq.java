package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aq
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public g CME;
  public as COI;
  public ar COJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41733);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CME == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41733);
        throw paramVarArgs;
      }
      if (this.CME != null)
      {
        paramVarArgs.oE(1, this.CME.computeSize());
        this.CME.writeFields(paramVarArgs);
      }
      if (this.COI != null)
      {
        paramVarArgs.oE(2, this.COI.computeSize());
        this.COI.writeFields(paramVarArgs);
      }
      if (this.COJ != null)
      {
        paramVarArgs.oE(3, this.COJ.computeSize());
        this.COJ.writeFields(paramVarArgs);
      }
      if (this.CMB != null) {
        paramVarArgs.f(4, this.CMB);
      }
      AppMethodBeat.o(41733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CME == null) {
        break label660;
      }
    }
    label660:
    for (int i = g.a.a.a.oD(1, this.CME.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.COI != null) {
        paramInt = i + g.a.a.a.oD(2, this.COI.computeSize());
      }
      i = paramInt;
      if (this.COJ != null) {
        i = paramInt + g.a.a.a.oD(3, this.COJ.computeSize());
      }
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMB);
      }
      AppMethodBeat.o(41733);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CME == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aq localaq = (aq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41733);
          return -1;
        case 1: 
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
            localaq.CME = ((g)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new as();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((as)localObject2).parseFrom((byte[])localObject1);
            }
            localaq.COI = ((as)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ar();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ar)localObject2).parseFrom((byte[])localObject1);
            }
            localaq.COJ = ((ar)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        }
        localaq.CMB = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(41733);
        return 0;
      }
      AppMethodBeat.o(41733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.aq
 * JD-Core Version:    0.7.0.1
 */