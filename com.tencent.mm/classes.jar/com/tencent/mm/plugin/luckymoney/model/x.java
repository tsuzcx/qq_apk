package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class x
  extends com.tencent.mm.bx.a
{
  public int KrX;
  public LinkedList<y> Ksg;
  public int Ktb;
  public long Ktc;
  public int Ktd;
  public long Kte;
  public int Ktf;
  
  public x()
  {
    AppMethodBeat.i(91255);
    this.Ksg = new LinkedList();
    AppMethodBeat.o(91255);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91256);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Ktb);
      paramVarArgs.bv(2, this.Ktc);
      paramVarArgs.bS(3, this.Ktd);
      paramVarArgs.bv(4, this.Kte);
      paramVarArgs.bS(5, this.Ktf);
      paramVarArgs.bS(6, this.KrX);
      paramVarArgs.e(7, 8, this.Ksg);
      AppMethodBeat.o(91256);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.Ktb);
      i = i.a.a.b.b.a.q(2, this.Ktc);
      int j = i.a.a.b.b.a.cJ(3, this.Ktd);
      int k = i.a.a.b.b.a.q(4, this.Kte);
      int m = i.a.a.b.b.a.cJ(5, this.Ktf);
      int n = i.a.a.b.b.a.cJ(6, this.KrX);
      int i1 = i.a.a.a.c(7, 8, this.Ksg);
      AppMethodBeat.o(91256);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ksg.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91256);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      x localx = (x)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91256);
        return -1;
      case 1: 
        localx.Ktb = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91256);
        return 0;
      case 2: 
        localx.Ktc = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(91256);
        return 0;
      case 3: 
        localx.Ktd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91256);
        return 0;
      case 4: 
        localx.Kte = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(91256);
        return 0;
      case 5: 
        localx.Ktf = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91256);
        return 0;
      case 6: 
        localx.KrX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91256);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        y localy = new y();
        if ((localObject != null) && (localObject.length > 0)) {
          localy.parseFrom((byte[])localObject);
        }
        localx.Ksg.add(localy);
        paramInt += 1;
      }
      AppMethodBeat.o(91256);
      return 0;
    }
    AppMethodBeat.o(91256);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.x
 * JD-Core Version:    0.7.0.1
 */