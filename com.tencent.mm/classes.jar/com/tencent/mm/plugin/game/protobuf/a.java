package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class a
  extends com.tencent.mm.bx.a
{
  public LinkedList<dq> IGF;
  
  public a()
  {
    AppMethodBeat.i(182778);
    this.IGF = new LinkedList();
    AppMethodBeat.o(182778);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(182779);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).e(1, 8, this.IGF);
      AppMethodBeat.o(182779);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.IGF);
      AppMethodBeat.o(182779);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IGF.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(182779);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      a locala = (a)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(182779);
        return -1;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dq localdq = new dq();
        if ((localObject != null) && (localObject.length > 0)) {
          localdq.parseFrom((byte[])localObject);
        }
        locala.IGF.add(localdq);
        paramInt += 1;
      }
      AppMethodBeat.o(182779);
      return 0;
    }
    AppMethodBeat.o(182779);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.a
 * JD-Core Version:    0.7.0.1
 */