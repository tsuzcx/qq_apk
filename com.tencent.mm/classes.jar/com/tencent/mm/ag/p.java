package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class p
  extends com.tencent.mm.bw.a
{
  public String Url;
  public String iAa;
  public String izS;
  public String izX;
  public o izY;
  public n izZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116411);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.izX != null) {
        paramVarArgs.e(1, this.izX);
      }
      if (this.Url != null) {
        paramVarArgs.e(2, this.Url);
      }
      if (this.izS != null) {
        paramVarArgs.e(3, this.izS);
      }
      if (this.izY != null)
      {
        paramVarArgs.ni(4, this.izY.computeSize());
        this.izY.writeFields(paramVarArgs);
      }
      if (this.izZ != null)
      {
        paramVarArgs.ni(5, this.izZ.computeSize());
        this.izZ.writeFields(paramVarArgs);
      }
      if (this.iAa != null) {
        paramVarArgs.e(6, this.iAa);
      }
      AppMethodBeat.o(116411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.izX == null) {
        break label706;
      }
    }
    label706:
    for (int i = g.a.a.b.b.a.f(1, this.izX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Url);
      }
      i = paramInt;
      if (this.izS != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.izS);
      }
      paramInt = i;
      if (this.izY != null) {
        paramInt = i + g.a.a.a.nh(4, this.izY.computeSize());
      }
      i = paramInt;
      if (this.izZ != null) {
        i = paramInt + g.a.a.a.nh(5, this.izZ.computeSize());
      }
      paramInt = i;
      if (this.iAa != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.iAa);
      }
      AppMethodBeat.o(116411);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116411);
          return -1;
        case 1: 
          localp.izX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 2: 
          localp.Url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 3: 
          localp.izS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new o();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localp.izY = ((o)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116411);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localp.izZ = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116411);
          return 0;
        }
        localp.iAa = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(116411);
        return 0;
      }
      AppMethodBeat.o(116411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ag.p
 * JD-Core Version:    0.7.0.1
 */