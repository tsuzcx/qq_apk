package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eq
  extends com.tencent.mm.cd.a
{
  public String CNA;
  public er CRZ;
  public an CSa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41846);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CRZ != null)
      {
        paramVarArgs.oE(1, this.CRZ.computeSize());
        this.CRZ.writeFields(paramVarArgs);
      }
      if (this.CSa != null)
      {
        paramVarArgs.oE(2, this.CSa.computeSize());
        this.CSa.writeFields(paramVarArgs);
      }
      if (this.CNA != null) {
        paramVarArgs.f(3, this.CNA);
      }
      AppMethodBeat.o(41846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRZ == null) {
        break label482;
      }
    }
    label482:
    for (int i = g.a.a.a.oD(1, this.CRZ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CSa != null) {
        paramInt = i + g.a.a.a.oD(2, this.CSa.computeSize());
      }
      i = paramInt;
      if (this.CNA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CNA);
      }
      AppMethodBeat.o(41846);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41846);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eq localeq = (eq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41846);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new er();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((er)localObject2).parseFrom((byte[])localObject1);
            }
            localeq.CRZ = ((er)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41846);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new an();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((an)localObject2).parseFrom((byte[])localObject1);
            }
            localeq.CSa = ((an)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41846);
          return 0;
        }
        localeq.CNA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(41846);
        return 0;
      }
      AppMethodBeat.o(41846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.eq
 * JD-Core Version:    0.7.0.1
 */