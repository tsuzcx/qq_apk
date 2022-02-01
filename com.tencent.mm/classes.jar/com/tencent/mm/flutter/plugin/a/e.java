package com.tencent.mm.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> msk;
  public LinkedList<g> msl;
  
  public e()
  {
    AppMethodBeat.i(233287);
    this.msk = new LinkedList();
    this.msl = new LinkedList();
    AppMethodBeat.o(233287);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(233297);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.msk);
      paramVarArgs.e(2, 8, this.msl);
      AppMethodBeat.o(233297);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 1, this.msk);
      i = i.a.a.a.c(2, 8, this.msl);
      AppMethodBeat.o(233297);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.msk.clear();
      this.msl.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(233297);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(233297);
        return -1;
      case 1: 
        locale.msk.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(233297);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        g localg = new g();
        if ((localObject != null) && (localObject.length > 0)) {
          localg.parseFrom((byte[])localObject);
        }
        locale.msl.add(localg);
        paramInt += 1;
      }
      AppMethodBeat.o(233297);
      return 0;
    }
    AppMethodBeat.o(233297);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.a.e
 * JD-Core Version:    0.7.0.1
 */