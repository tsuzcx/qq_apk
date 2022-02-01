package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public g IGJ;
  public c IGP;
  public String IGQ;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41709);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      if (this.IGJ != null)
      {
        paramVarArgs.qD(2, this.IGJ.computeSize());
        this.IGJ.writeFields(paramVarArgs);
      }
      if (this.IGP != null)
      {
        paramVarArgs.qD(3, this.IGP.computeSize());
        this.IGP.writeFields(paramVarArgs);
      }
      if (this.IGQ != null) {
        paramVarArgs.g(4, this.IGQ);
      }
      AppMethodBeat.o(41709);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0;
      paramInt = i;
      if (this.IGJ != null) {
        paramInt = i + i.a.a.a.qC(2, this.IGJ.computeSize());
      }
      i = paramInt;
      if (this.IGP != null) {
        i = paramInt + i.a.a.a.qC(3, this.IGP.computeSize());
      }
      paramInt = i;
      if (this.IGQ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGQ);
      }
      AppMethodBeat.o(41709);
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
      AppMethodBeat.o(41709);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41709);
        return -1;
      case 1: 
        locale.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(41709);
        return 0;
      case 2: 
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
          locale.IGJ = ((g)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41709);
        return 0;
      case 3: 
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
          locale.IGP = ((c)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41709);
        return 0;
      }
      locale.IGQ = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(41709);
      return 0;
    }
    AppMethodBeat.o(41709);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.e
 * JD-Core Version:    0.7.0.1
 */