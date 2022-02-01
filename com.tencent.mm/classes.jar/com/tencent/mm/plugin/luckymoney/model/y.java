package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class y
  extends com.tencent.mm.cd.a
{
  public int EAl;
  public long EAm;
  public int EAn;
  public long EAo;
  public int EAp;
  public int Ezk;
  public LinkedList<z> Ezu;
  
  public y()
  {
    AppMethodBeat.i(91255);
    this.Ezu = new LinkedList();
    AppMethodBeat.o(91255);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91256);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.EAl);
      paramVarArgs.bm(2, this.EAm);
      paramVarArgs.aY(3, this.EAn);
      paramVarArgs.bm(4, this.EAo);
      paramVarArgs.aY(5, this.EAp);
      paramVarArgs.aY(6, this.Ezk);
      paramVarArgs.e(7, 8, this.Ezu);
      AppMethodBeat.o(91256);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.EAl);
      i = g.a.a.b.b.a.p(2, this.EAm);
      int j = g.a.a.b.b.a.bM(3, this.EAn);
      int k = g.a.a.b.b.a.p(4, this.EAo);
      int m = g.a.a.b.b.a.bM(5, this.EAp);
      int n = g.a.a.b.b.a.bM(6, this.Ezk);
      int i1 = g.a.a.a.c(7, 8, this.Ezu);
      AppMethodBeat.o(91256);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ezu.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91256);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      y localy = (y)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91256);
        return -1;
      case 1: 
        localy.EAl = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91256);
        return 0;
      case 2: 
        localy.EAm = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(91256);
        return 0;
      case 3: 
        localy.EAn = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91256);
        return 0;
      case 4: 
        localy.EAo = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(91256);
        return 0;
      case 5: 
        localy.EAp = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91256);
        return 0;
      case 6: 
        localy.Ezk = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91256);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        z localz = new z();
        if ((localObject != null) && (localObject.length > 0)) {
          localz.parseFrom((byte[])localObject);
        }
        localy.Ezu.add(localz);
        paramInt += 1;
      }
      AppMethodBeat.o(91256);
      return 0;
    }
    AppMethodBeat.o(91256);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.y
 * JD-Core Version:    0.7.0.1
 */