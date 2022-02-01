package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cx
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public int IHl;
  public er IKX;
  public cm IKY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276918);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IHl);
      if (this.IGI != null) {
        paramVarArgs.g(2, this.IGI);
      }
      if (this.IKX != null)
      {
        paramVarArgs.qD(3, this.IKX.computeSize());
        this.IKX.writeFields(paramVarArgs);
      }
      if (this.IKY != null)
      {
        paramVarArgs.qD(4, this.IKY.computeSize());
        this.IKY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(276918);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.IHl) + 0;
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGI);
      }
      i = paramInt;
      if (this.IKX != null) {
        i = paramInt + i.a.a.a.qC(3, this.IKX.computeSize());
      }
      paramInt = i;
      if (this.IKY != null) {
        paramInt = i + i.a.a.a.qC(4, this.IKY.computeSize());
      }
      AppMethodBeat.o(276918);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(276918);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      cx localcx = (cx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(276918);
        return -1;
      case 1: 
        localcx.IHl = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(276918);
        return 0;
      case 2: 
        localcx.IGI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(276918);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new er();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((er)localObject2).parseFrom((byte[])localObject1);
          }
          localcx.IKX = ((er)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(276918);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new cm();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((cm)localObject2).parseFrom((byte[])localObject1);
        }
        localcx.IKY = ((cm)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(276918);
      return 0;
    }
    AppMethodBeat.o(276918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cx
 * JD-Core Version:    0.7.0.1
 */