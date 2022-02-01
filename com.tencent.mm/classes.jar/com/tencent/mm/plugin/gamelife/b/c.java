package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class c
  extends com.tencent.mm.cd.a
{
  public long DgJ;
  public long DgK;
  public m DgL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203937);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.DgJ);
      paramVarArgs.bm(2, this.DgK);
      if (this.DgL != null)
      {
        paramVarArgs.oE(3, this.DgL.computeSize());
        this.DgL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(203937);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.DgJ) + 0 + g.a.a.b.b.a.p(2, this.DgK);
      paramInt = i;
      if (this.DgL != null) {
        paramInt = i + g.a.a.a.oD(3, this.DgL.computeSize());
      }
      AppMethodBeat.o(203937);
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
      AppMethodBeat.o(203937);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(203937);
        return -1;
      case 1: 
        localc.DgJ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(203937);
        return 0;
      case 2: 
        localc.DgK = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(203937);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        m localm = new m();
        if ((localObject != null) && (localObject.length > 0)) {
          localm.parseFrom((byte[])localObject);
        }
        localc.DgL = localm;
        paramInt += 1;
      }
      AppMethodBeat.o(203937);
      return 0;
    }
    AppMethodBeat.o(203937);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.c
 * JD-Core Version:    0.7.0.1
 */