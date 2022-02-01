package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class p
  extends com.tencent.mm.cd.a
{
  public String Url;
  public String lpn;
  public String lps;
  public o lpt;
  public n lpu;
  public String lpv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116411);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lps != null) {
        paramVarArgs.f(1, this.lps);
      }
      if (this.Url != null) {
        paramVarArgs.f(2, this.Url);
      }
      if (this.lpn != null) {
        paramVarArgs.f(3, this.lpn);
      }
      if (this.lpt != null)
      {
        paramVarArgs.oE(4, this.lpt.computeSize());
        this.lpt.writeFields(paramVarArgs);
      }
      if (this.lpu != null)
      {
        paramVarArgs.oE(5, this.lpu.computeSize());
        this.lpu.writeFields(paramVarArgs);
      }
      if (this.lpv != null) {
        paramVarArgs.f(6, this.lpv);
      }
      AppMethodBeat.o(116411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lps == null) {
        break label662;
      }
    }
    label662:
    for (int i = g.a.a.b.b.a.g(1, this.lps) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Url);
      }
      i = paramInt;
      if (this.lpn != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lpn);
      }
      paramInt = i;
      if (this.lpt != null) {
        paramInt = i + g.a.a.a.oD(4, this.lpt.computeSize());
      }
      i = paramInt;
      if (this.lpu != null) {
        i = paramInt + g.a.a.a.oD(5, this.lpu.computeSize());
      }
      paramInt = i;
      if (this.lpv != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.lpv);
      }
      AppMethodBeat.o(116411);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116411);
          return -1;
        case 1: 
          localp.lps = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 2: 
          localp.Url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 3: 
          localp.lpn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new o();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((o)localObject2).parseFrom((byte[])localObject1);
            }
            localp.lpt = ((o)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116411);
          return 0;
        case 5: 
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
            localp.lpu = ((n)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116411);
          return 0;
        }
        localp.lpv = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(116411);
        return 0;
      }
      AppMethodBeat.o(116411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aj.p
 * JD-Core Version:    0.7.0.1
 */