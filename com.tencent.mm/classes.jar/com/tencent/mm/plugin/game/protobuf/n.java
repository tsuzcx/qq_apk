package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bx.a
{
  public LinkedList<be> IHH;
  public String IHI;
  
  public n()
  {
    AppMethodBeat.i(41712);
    this.IHH = new LinkedList();
    AppMethodBeat.o(41712);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41713);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.IHH);
      if (this.IHI != null) {
        paramVarArgs.g(2, this.IHI);
      }
      AppMethodBeat.o(41713);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.IHH) + 0;
      paramInt = i;
      if (this.IHI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IHI);
      }
      AppMethodBeat.o(41713);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IHH.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(41713);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41713);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          be localbe = new be();
          if ((localObject != null) && (localObject.length > 0)) {
            localbe.parseFrom((byte[])localObject);
          }
          localn.IHH.add(localbe);
          paramInt += 1;
        }
        AppMethodBeat.o(41713);
        return 0;
      }
      localn.IHI = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(41713);
      return 0;
    }
    AppMethodBeat.o(41713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.n
 * JD-Core Version:    0.7.0.1
 */