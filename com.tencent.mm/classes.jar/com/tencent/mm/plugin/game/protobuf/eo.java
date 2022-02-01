package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class eo
  extends com.tencent.mm.cd.a
{
  public boolean CRV;
  public LinkedList<dk> CRW;
  public LinkedList<dk> CRX;
  
  public eo()
  {
    AppMethodBeat.i(149421);
    this.CRW = new LinkedList();
    this.CRX = new LinkedList();
    AppMethodBeat.o(149421);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149422);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.CRV);
      paramVarArgs.e(3, 8, this.CRW);
      paramVarArgs.e(4, 8, this.CRX);
      AppMethodBeat.o(149422);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.gL(1);
      i = g.a.a.a.c(3, 8, this.CRW);
      int j = g.a.a.a.c(4, 8, this.CRX);
      AppMethodBeat.o(149422);
      return paramInt + 1 + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CRW.clear();
      this.CRX.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(149422);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      eo localeo = (eo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      dk localdk;
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(149422);
        return -1;
      case 1: 
        localeo.CRV = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(149422);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdk = new dk();
          if ((localObject != null) && (localObject.length > 0)) {
            localdk.parseFrom((byte[])localObject);
          }
          localeo.CRW.add(localdk);
          paramInt += 1;
        }
        AppMethodBeat.o(149422);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localdk = new dk();
        if ((localObject != null) && (localObject.length > 0)) {
          localdk.parseFrom((byte[])localObject);
        }
        localeo.CRX.add(localdk);
        paramInt += 1;
      }
      AppMethodBeat.o(149422);
      return 0;
    }
    AppMethodBeat.o(149422);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.eo
 * JD-Core Version:    0.7.0.1
 */