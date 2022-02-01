package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.cd.a
{
  public String ID;
  public long rVM;
  public m rVP;
  public int rVR;
  public long rVS;
  public long rVT;
  public int rVU;
  public int rVV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22119);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22119);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.f(1, this.ID);
      }
      paramVarArgs.bm(2, this.rVS);
      paramVarArgs.bm(3, this.rVT);
      paramVarArgs.aY(4, this.rVU);
      paramVarArgs.aY(5, this.rVV);
      paramVarArgs.bm(6, this.rVM);
      if (this.rVP != null)
      {
        paramVarArgs.oE(7, this.rVP.computeSize());
        this.rVP.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.rVR);
      AppMethodBeat.o(22119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = g.a.a.b.b.a.g(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.rVS) + g.a.a.b.b.a.p(3, this.rVT) + g.a.a.b.b.a.bM(4, this.rVU) + g.a.a.b.b.a.bM(5, this.rVV) + g.a.a.b.b.a.p(6, this.rVM);
      paramInt = i;
      if (this.rVP != null) {
        paramInt = i + g.a.a.a.oD(7, this.rVP.computeSize());
      }
      i = g.a.a.b.b.a.bM(8, this.rVR);
      AppMethodBeat.o(22119);
      return paramInt + i;
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
          AppMethodBeat.o(22119);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22119);
          return -1;
        case 1: 
          localo.ID = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(22119);
          return 0;
        case 2: 
          localo.rVS = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(22119);
          return 0;
        case 3: 
          localo.rVT = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(22119);
          return 0;
        case 4: 
          localo.rVU = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22119);
          return 0;
        case 5: 
          localo.rVV = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(22119);
          return 0;
        case 6: 
          localo.rVM = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(22119);
          return 0;
        case 7: 
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
            localo.rVP = localm;
            paramInt += 1;
          }
          AppMethodBeat.o(22119);
          return 0;
        }
        localo.rVR = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(22119);
        return 0;
      }
      AppMethodBeat.o(22119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.o
 * JD-Core Version:    0.7.0.1
 */