package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.cd.a
{
  public String ID;
  public h rVl;
  public int rVm;
  public int rVn;
  public int rVo;
  public int rVp;
  public int rVq;
  public int rVr;
  public int rVs;
  public int rVt;
  public int rVu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22104);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22104);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.f(1, this.ID);
      }
      if (this.rVl != null)
      {
        paramVarArgs.oE(2, this.rVl.computeSize());
        this.rVl.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.rVm);
      paramVarArgs.aY(4, this.rVn);
      paramVarArgs.aY(5, this.rVo);
      paramVarArgs.aY(6, this.rVp);
      paramVarArgs.aY(7, this.rVq);
      paramVarArgs.aY(8, this.rVr);
      paramVarArgs.aY(9, this.rVs);
      paramVarArgs.aY(10, this.rVt);
      paramVarArgs.aY(11, this.rVu);
      AppMethodBeat.o(22104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label841;
      }
    }
    label841:
    for (paramInt = g.a.a.b.b.a.g(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rVl != null) {
        i = paramInt + g.a.a.a.oD(2, this.rVl.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(3, this.rVm);
      int j = g.a.a.b.b.a.bM(4, this.rVn);
      int k = g.a.a.b.b.a.bM(5, this.rVo);
      int m = g.a.a.b.b.a.bM(6, this.rVp);
      int n = g.a.a.b.b.a.bM(7, this.rVq);
      int i1 = g.a.a.b.b.a.bM(8, this.rVr);
      int i2 = g.a.a.b.b.a.bM(9, this.rVs);
      int i3 = g.a.a.b.b.a.bM(10, this.rVt);
      int i4 = g.a.a.b.b.a.bM(11, this.rVu);
      AppMethodBeat.o(22104);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22104);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22104);
          return -1;
        case 1: 
          locald.ID = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(22104);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            h localh = new h();
            if ((localObject != null) && (localObject.length > 0)) {
              localh.parseFrom((byte[])localObject);
            }
            locald.rVl = localh;
            paramInt += 1;
          }
          AppMethodBeat.o(22104);
          return 0;
        case 3: 
          locald.rVm = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22104);
          return 0;
        case 4: 
          locald.rVn = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22104);
          return 0;
        case 5: 
          locald.rVo = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22104);
          return 0;
        case 6: 
          locald.rVp = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22104);
          return 0;
        case 7: 
          locald.rVq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22104);
          return 0;
        case 8: 
          locald.rVr = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22104);
          return 0;
        case 9: 
          locald.rVs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22104);
          return 0;
        case 10: 
          locald.rVt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22104);
          return 0;
        }
        locald.rVu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(22104);
        return 0;
      }
      AppMethodBeat.o(22104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.d
 * JD-Core Version:    0.7.0.1
 */