package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.bx.a
{
  public boolean IHR;
  public dh IHS;
  public k IHT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276899);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.IHR);
      if (this.IHS != null)
      {
        paramVarArgs.qD(2, this.IHS.computeSize());
        this.IHS.writeFields(paramVarArgs);
      }
      if (this.IHT != null)
      {
        paramVarArgs.qD(3, this.IHT.computeSize());
        this.IHT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(276899);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.IHS != null) {
        paramInt = i + i.a.a.a.qC(2, this.IHS.computeSize());
      }
      i = paramInt;
      if (this.IHT != null) {
        i = paramInt + i.a.a.a.qC(3, this.IHT.computeSize());
      }
      AppMethodBeat.o(276899);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(276899);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      r localr = (r)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(276899);
        return -1;
      case 1: 
        localr.IHR = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(276899);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dh)localObject2).parseFrom((byte[])localObject1);
          }
          localr.IHS = ((dh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(276899);
        return 0;
      }
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
        localr.IHT = ((k)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(276899);
      return 0;
    }
    AppMethodBeat.o(276899);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.r
 * JD-Core Version:    0.7.0.1
 */