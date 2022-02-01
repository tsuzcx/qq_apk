package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dz
  extends com.tencent.mm.bx.a
{
  public int IHj;
  public LinkedList<w> IHq;
  
  public dz()
  {
    AppMethodBeat.i(276886);
    this.IHq = new LinkedList();
    AppMethodBeat.o(276886);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276888);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IHj);
      paramVarArgs.e(2, 8, this.IHq);
      AppMethodBeat.o(276888);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.IHj);
      i = i.a.a.a.c(2, 8, this.IHq);
      AppMethodBeat.o(276888);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IHq.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(276888);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dz localdz = (dz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(276888);
        return -1;
      case 1: 
        localdz.IHj = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(276888);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        w localw = new w();
        if ((localObject != null) && (localObject.length > 0)) {
          localw.parseFrom((byte[])localObject);
        }
        localdz.IHq.add(localw);
        paramInt += 1;
      }
      AppMethodBeat.o(276888);
      return 0;
    }
    AppMethodBeat.o(276888);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dz
 * JD-Core Version:    0.7.0.1
 */