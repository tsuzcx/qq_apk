package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.cd.a
{
  public String ID;
  public long rVT;
  public int rVW;
  public int rVX;
  public int rVY;
  public long rVZ;
  public long rWa;
  public LinkedList<t> rWk;
  public LinkedList<t> rWl;
  
  public r()
  {
    AppMethodBeat.i(22122);
    this.rWk = new LinkedList();
    this.rWl = new LinkedList();
    AppMethodBeat.o(22122);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22123);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22123);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.f(1, this.ID);
      }
      paramVarArgs.aY(2, this.rVW);
      paramVarArgs.aY(3, this.rVX);
      paramVarArgs.aY(4, this.rVY);
      paramVarArgs.bm(5, this.rVT);
      paramVarArgs.bm(6, this.rVZ);
      paramVarArgs.bm(7, this.rWa);
      paramVarArgs.e(8, 8, this.rWk);
      paramVarArgs.e(9, 8, this.rWl);
      AppMethodBeat.o(22123);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label805;
      }
    }
    label805:
    for (paramInt = g.a.a.b.b.a.g(1, this.ID) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.rVW);
      int j = g.a.a.b.b.a.bM(3, this.rVX);
      int k = g.a.a.b.b.a.bM(4, this.rVY);
      int m = g.a.a.b.b.a.p(5, this.rVT);
      int n = g.a.a.b.b.a.p(6, this.rVZ);
      int i1 = g.a.a.b.b.a.p(7, this.rWa);
      int i2 = g.a.a.a.c(8, 8, this.rWk);
      int i3 = g.a.a.a.c(9, 8, this.rWl);
      AppMethodBeat.o(22123);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rWk.clear();
        this.rWl.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22123);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22123);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        t localt;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22123);
          return -1;
        case 1: 
          localr.ID = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(22123);
          return 0;
        case 2: 
          localr.rVW = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22123);
          return 0;
        case 3: 
          localr.rVX = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22123);
          return 0;
        case 4: 
          localr.rVY = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22123);
          return 0;
        case 5: 
          localr.rVT = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(22123);
          return 0;
        case 6: 
          localr.rVZ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(22123);
          return 0;
        case 7: 
          localr.rWa = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(22123);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localt = new t();
            if ((localObject != null) && (localObject.length > 0)) {
              localt.parseFrom((byte[])localObject);
            }
            localr.rWk.add(localt);
            paramInt += 1;
          }
          AppMethodBeat.o(22123);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localt = new t();
          if ((localObject != null) && (localObject.length > 0)) {
            localt.parseFrom((byte[])localObject);
          }
          localr.rWl.add(localt);
          paramInt += 1;
        }
        AppMethodBeat.o(22123);
        return 0;
      }
      AppMethodBeat.o(22123);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.r
 * JD-Core Version:    0.7.0.1
 */