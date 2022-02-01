package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.cd.a
{
  public g CME;
  public c CMK;
  public String CML;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41709);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWu);
      if (this.CME != null)
      {
        paramVarArgs.oE(2, this.CME.computeSize());
        this.CME.writeFields(paramVarArgs);
      }
      if (this.CMK != null)
      {
        paramVarArgs.oE(3, this.CMK.computeSize());
        this.CMK.writeFields(paramVarArgs);
      }
      if (this.CML != null) {
        paramVarArgs.f(4, this.CML);
      }
      AppMethodBeat.o(41709);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.rWu) + 0;
      paramInt = i;
      if (this.CME != null) {
        paramInt = i + g.a.a.a.oD(2, this.CME.computeSize());
      }
      i = paramInt;
      if (this.CMK != null) {
        i = paramInt + g.a.a.a.oD(3, this.CMK.computeSize());
      }
      paramInt = i;
      if (this.CML != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CML);
      }
      AppMethodBeat.o(41709);
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
      AppMethodBeat.o(41709);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41709);
        return -1;
      case 1: 
        locale.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(41709);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new g();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((g)localObject2).parseFrom((byte[])localObject1);
          }
          locale.CME = ((g)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41709);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new c();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((c)localObject2).parseFrom((byte[])localObject1);
          }
          locale.CMK = ((c)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41709);
        return 0;
      }
      locale.CML = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(41709);
      return 0;
    }
    AppMethodBeat.o(41709);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.e
 * JD-Core Version:    0.7.0.1
 */