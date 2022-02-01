package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aw
  extends com.tencent.mm.bx.a
{
  public cr IIX;
  public cr IIY;
  public cr IIZ;
  public dv IJa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41741);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IIX != null)
      {
        paramVarArgs.qD(1, this.IIX.computeSize());
        this.IIX.writeFields(paramVarArgs);
      }
      if (this.IIY != null)
      {
        paramVarArgs.qD(2, this.IIY.computeSize());
        this.IIY.writeFields(paramVarArgs);
      }
      if (this.IIZ != null)
      {
        paramVarArgs.qD(3, this.IIZ.computeSize());
        this.IIZ.writeFields(paramVarArgs);
      }
      if (this.IJa != null)
      {
        paramVarArgs.qD(4, this.IJa.computeSize());
        this.IJa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41741);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IIX == null) {
        break label682;
      }
    }
    label682:
    for (int i = i.a.a.a.qC(1, this.IIX.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.IIY.computeSize());
      }
      i = paramInt;
      if (this.IIZ != null) {
        i = paramInt + i.a.a.a.qC(3, this.IIZ.computeSize());
      }
      paramInt = i;
      if (this.IJa != null) {
        paramInt = i + i.a.a.a.qC(4, this.IJa.computeSize());
      }
      AppMethodBeat.o(41741);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41741);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aw localaw = (aw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41741);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cr)localObject2).parseFrom((byte[])localObject1);
            }
            localaw.IIX = ((cr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cr)localObject2).parseFrom((byte[])localObject1);
            }
            localaw.IIY = ((cr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cr)localObject2).parseFrom((byte[])localObject1);
            }
            localaw.IIZ = ((cr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dv)localObject2).parseFrom((byte[])localObject1);
          }
          localaw.IJa = ((dv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41741);
        return 0;
      }
      AppMethodBeat.o(41741);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.aw
 * JD-Core Version:    0.7.0.1
 */