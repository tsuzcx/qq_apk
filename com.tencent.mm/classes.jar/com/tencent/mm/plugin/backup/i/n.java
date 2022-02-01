package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.cd.a
{
  public String ID;
  public long rVM;
  public long rVN;
  public long rVO;
  public m rVP;
  public long rVQ;
  public int rVR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22118);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22118);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.f(1, this.ID);
      }
      paramVarArgs.bm(2, this.rVM);
      paramVarArgs.bm(3, this.rVN);
      paramVarArgs.bm(4, this.rVO);
      if (this.rVP != null)
      {
        paramVarArgs.oE(5, this.rVP.computeSize());
        this.rVP.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.rVQ);
      paramVarArgs.aY(7, this.rVR);
      AppMethodBeat.o(22118);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label633;
      }
    }
    label633:
    for (paramInt = g.a.a.b.b.a.g(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.rVM) + g.a.a.b.b.a.p(3, this.rVN) + g.a.a.b.b.a.p(4, this.rVO);
      paramInt = i;
      if (this.rVP != null) {
        paramInt = i + g.a.a.a.oD(5, this.rVP.computeSize());
      }
      i = g.a.a.b.b.a.p(6, this.rVQ);
      int j = g.a.a.b.b.a.bM(7, this.rVR);
      AppMethodBeat.o(22118);
      return paramInt + i + j;
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
          AppMethodBeat.o(22118);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22118);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22118);
          return -1;
        case 1: 
          localn.ID = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(22118);
          return 0;
        case 2: 
          localn.rVM = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(22118);
          return 0;
        case 3: 
          localn.rVN = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(22118);
          return 0;
        case 4: 
          localn.rVO = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(22118);
          return 0;
        case 5: 
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
            localn.rVP = localm;
            paramInt += 1;
          }
          AppMethodBeat.o(22118);
          return 0;
        case 6: 
          localn.rVQ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(22118);
          return 0;
        }
        localn.rVR = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(22118);
        return 0;
      }
      AppMethodBeat.o(22118);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.n
 * JD-Core Version:    0.7.0.1
 */