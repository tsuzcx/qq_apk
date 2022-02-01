package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ev
  extends com.tencent.mm.bx.a
{
  public String IHI;
  public ew IMp;
  public ao IMq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41846);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IMp != null)
      {
        paramVarArgs.qD(1, this.IMp.computeSize());
        this.IMp.writeFields(paramVarArgs);
      }
      if (this.IMq != null)
      {
        paramVarArgs.qD(2, this.IMq.computeSize());
        this.IMq.writeFields(paramVarArgs);
      }
      if (this.IHI != null) {
        paramVarArgs.g(3, this.IHI);
      }
      AppMethodBeat.o(41846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IMp == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.a.qC(1, this.IMp.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IMq != null) {
        paramInt = i + i.a.a.a.qC(2, this.IMq.computeSize());
      }
      i = paramInt;
      if (this.IHI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IHI);
      }
      AppMethodBeat.o(41846);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41846);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ev localev = (ev)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41846);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ew();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ew)localObject2).parseFrom((byte[])localObject1);
            }
            localev.IMp = ((ew)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41846);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ao();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ao)localObject2).parseFrom((byte[])localObject1);
            }
            localev.IMq = ((ao)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41846);
          return 0;
        }
        localev.IHI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(41846);
        return 0;
      }
      AppMethodBeat.o(41846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ev
 * JD-Core Version:    0.7.0.1
 */