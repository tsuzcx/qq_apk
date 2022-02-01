package com.tencent.mm.plugin.masssend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public LinkedList<d> KNo;
  public int count;
  
  public e()
  {
    AppMethodBeat.i(26358);
    this.KNo = new LinkedList();
    AppMethodBeat.o(26358);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(26359);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.count);
      paramVarArgs.e(2, 8, this.KNo);
      AppMethodBeat.o(26359);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.count);
      i = i.a.a.a.c(2, 8, this.KNo);
      AppMethodBeat.o(26359);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KNo.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(26359);
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
        AppMethodBeat.o(26359);
        return -1;
      case 1: 
        locale.count = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(26359);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        d locald = new d();
        if ((localObject != null) && (localObject.length > 0)) {
          locald.parseFrom((byte[])localObject);
        }
        locale.KNo.add(locald);
        paramInt += 1;
      }
      AppMethodBeat.o(26359);
      return 0;
    }
    AppMethodBeat.o(26359);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.model.e
 * JD-Core Version:    0.7.0.1
 */