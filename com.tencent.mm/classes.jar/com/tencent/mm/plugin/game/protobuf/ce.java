package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ce
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public cv CNh;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207048);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWu);
      if (this.CMD != null) {
        paramVarArgs.f(2, this.CMD);
      }
      if (this.CNh != null)
      {
        paramVarArgs.oE(3, this.CNh.computeSize());
        this.CNh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(207048);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.rWu) + 0;
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMD);
      }
      i = paramInt;
      if (this.CNh != null) {
        i = paramInt + g.a.a.a.oD(3, this.CNh.computeSize());
      }
      AppMethodBeat.o(207048);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207048);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ce localce = (ce)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207048);
        return -1;
      case 1: 
        localce.rWu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(207048);
        return 0;
      case 2: 
        localce.CMD = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(207048);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        cv localcv = new cv();
        if ((localObject != null) && (localObject.length > 0)) {
          localcv.parseFrom((byte[])localObject);
        }
        localce.CNh = localcv;
        paramInt += 1;
      }
      AppMethodBeat.o(207048);
      return 0;
    }
    AppMethodBeat.o(207048);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ce
 * JD-Core Version:    0.7.0.1
 */