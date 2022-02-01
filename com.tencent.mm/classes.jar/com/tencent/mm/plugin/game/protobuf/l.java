package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends com.tencent.mm.bx.a
{
  public LinkedList<h> IHx;
  public LinkedList<dz> IHy;
  
  public l()
  {
    AppMethodBeat.i(276887);
    this.IHx = new LinkedList();
    this.IHy = new LinkedList();
    AppMethodBeat.o(276887);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276893);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.IHx);
      paramVarArgs.e(2, 8, this.IHy);
      AppMethodBeat.o(276893);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.IHx);
      i = i.a.a.a.c(2, 8, this.IHy);
      AppMethodBeat.o(276893);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IHx.clear();
      this.IHy.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(276893);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(276893);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new h();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((h)localObject2).parseFrom((byte[])localObject1);
          }
          locall.IHx.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(276893);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dz();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dz)localObject2).parseFrom((byte[])localObject1);
        }
        locall.IHy.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(276893);
      return 0;
    }
    AppMethodBeat.o(276893);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.l
 * JD-Core Version:    0.7.0.1
 */