package com.tencent.mm.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bx.a
{
  public int eQp;
  public int hSm;
  public LinkedList<b> lPK;
  public String lPL;
  public int lPM;
  public int lyL;
  public int status;
  public int type;
  
  public a()
  {
    AppMethodBeat.i(42660);
    this.lPK = new LinkedList();
    AppMethodBeat.o(42660);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42661);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.lPK);
      paramVarArgs.bS(2, this.eQp);
      paramVarArgs.bS(3, this.type);
      paramVarArgs.bS(4, this.status);
      paramVarArgs.bS(5, this.lyL);
      if (this.lPL != null) {
        paramVarArgs.g(6, this.lPL);
      }
      paramVarArgs.bS(7, this.hSm);
      paramVarArgs.bS(8, this.lPM);
      AppMethodBeat.o(42661);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.lPK) + 0 + i.a.a.b.b.a.cJ(2, this.eQp) + i.a.a.b.b.a.cJ(3, this.type) + i.a.a.b.b.a.cJ(4, this.status) + i.a.a.b.b.a.cJ(5, this.lyL);
      paramInt = i;
      if (this.lPL != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.lPL);
      }
      i = i.a.a.b.b.a.cJ(7, this.hSm);
      int j = i.a.a.b.b.a.cJ(8, this.lPM);
      AppMethodBeat.o(42661);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.lPK.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(42661);
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
        AppMethodBeat.o(42661);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          b localb = new b();
          if ((localObject != null) && (localObject.length > 0)) {
            localb.parseFrom((byte[])localObject);
          }
          locala.lPK.add(localb);
          paramInt += 1;
        }
        AppMethodBeat.o(42661);
        return 0;
      case 2: 
        locala.eQp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(42661);
        return 0;
      case 3: 
        locala.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(42661);
        return 0;
      case 4: 
        locala.status = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(42661);
        return 0;
      case 5: 
        locala.lyL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(42661);
        return 0;
      case 6: 
        locala.lPL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(42661);
        return 0;
      case 7: 
        locala.hSm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(42661);
        return 0;
      }
      locala.lPM = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(42661);
      return 0;
    }
    AppMethodBeat.o(42661);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.a.a.a
 * JD-Core Version:    0.7.0.1
 */