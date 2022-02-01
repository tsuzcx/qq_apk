package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ee
  extends com.tencent.mm.cd.a
{
  public dz COn;
  public long rWF;
  public long rWG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207213);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.COn == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(207213);
        throw paramVarArgs;
      }
      paramVarArgs.bm(1, this.rWF);
      paramVarArgs.bm(2, this.rWG);
      if (this.COn != null)
      {
        paramVarArgs.oE(3, this.COn.computeSize());
        this.COn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(207213);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.rWF) + 0 + g.a.a.b.b.a.p(2, this.rWG);
      paramInt = i;
      if (this.COn != null) {
        paramInt = i + g.a.a.a.oD(3, this.COn.computeSize());
      }
      AppMethodBeat.o(207213);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.COn == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(207213);
        throw paramVarArgs;
      }
      AppMethodBeat.o(207213);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ee localee = (ee)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207213);
        return -1;
      case 1: 
        localee.rWF = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(207213);
        return 0;
      case 2: 
        localee.rWG = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(207213);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dz localdz = new dz();
        if ((localObject != null) && (localObject.length > 0)) {
          localdz.parseFrom((byte[])localObject);
        }
        localee.COn = localdz;
        paramInt += 1;
      }
      AppMethodBeat.o(207213);
      return 0;
    }
    AppMethodBeat.o(207213);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ee
 * JD-Core Version:    0.7.0.1
 */