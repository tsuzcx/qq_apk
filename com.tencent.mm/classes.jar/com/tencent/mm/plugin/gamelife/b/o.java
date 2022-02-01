package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.cd.a
{
  public a DgM;
  public n DgU;
  public String DgV;
  public String sWA;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203958);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.session_id != null) {
        paramVarArgs.f(1, this.session_id);
      }
      if (this.DgU != null)
      {
        paramVarArgs.oE(2, this.DgU.computeSize());
        this.DgU.writeFields(paramVarArgs);
      }
      if (this.DgV != null) {
        paramVarArgs.f(3, this.DgV);
      }
      if (this.sWA != null) {
        paramVarArgs.f(4, this.sWA);
      }
      if (this.DgM != null)
      {
        paramVarArgs.oE(5, this.DgM.computeSize());
        this.DgM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(203958);
      return 0;
    }
    if (paramInt == 1) {
      if (this.session_id == null) {
        break label602;
      }
    }
    label602:
    for (int i = g.a.a.b.b.a.g(1, this.session_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DgU != null) {
        paramInt = i + g.a.a.a.oD(2, this.DgU.computeSize());
      }
      i = paramInt;
      if (this.DgV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.DgV);
      }
      paramInt = i;
      if (this.sWA != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.sWA);
      }
      i = paramInt;
      if (this.DgM != null) {
        i = paramInt + g.a.a.a.oD(5, this.DgM.computeSize());
      }
      AppMethodBeat.o(203958);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(203958);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203958);
          return -1;
        case 1: 
          localo.session_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(203958);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new n();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((n)localObject2).parseFrom((byte[])localObject1);
            }
            localo.DgU = ((n)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(203958);
          return 0;
        case 3: 
          localo.DgV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(203958);
          return 0;
        case 4: 
          localo.sWA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(203958);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new a();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((a)localObject2).parseFrom((byte[])localObject1);
          }
          localo.DgM = ((a)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(203958);
        return 0;
      }
      AppMethodBeat.o(203958);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.o
 * JD-Core Version:    0.7.0.1
 */