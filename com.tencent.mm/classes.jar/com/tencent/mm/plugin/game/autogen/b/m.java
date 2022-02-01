package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.cd.a
{
  public d CrA;
  public n CrB;
  public LinkedList<l> CrC;
  public c CrD;
  public String Cry;
  public long Crz;
  
  public m()
  {
    AppMethodBeat.i(40880);
    this.CrC = new LinkedList();
    AppMethodBeat.o(40880);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40881);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Cry != null) {
        paramVarArgs.f(1, this.Cry);
      }
      paramVarArgs.bm(2, this.Crz);
      if (this.CrA != null)
      {
        paramVarArgs.oE(3, this.CrA.computeSize());
        this.CrA.writeFields(paramVarArgs);
      }
      if (this.CrB != null)
      {
        paramVarArgs.oE(4, this.CrB.computeSize());
        this.CrB.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.CrC);
      if (this.CrD != null)
      {
        paramVarArgs.oE(6, this.CrD.computeSize());
        this.CrD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(40881);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cry == null) {
        break label778;
      }
    }
    label778:
    for (paramInt = g.a.a.b.b.a.g(1, this.Cry) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.Crz);
      paramInt = i;
      if (this.CrA != null) {
        paramInt = i + g.a.a.a.oD(3, this.CrA.computeSize());
      }
      i = paramInt;
      if (this.CrB != null) {
        i = paramInt + g.a.a.a.oD(4, this.CrB.computeSize());
      }
      i += g.a.a.a.c(5, 8, this.CrC);
      paramInt = i;
      if (this.CrD != null) {
        paramInt = i + g.a.a.a.oD(6, this.CrD.computeSize());
      }
      AppMethodBeat.o(40881);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CrC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(40881);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40881);
          return -1;
        case 1: 
          localm.Cry = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(40881);
          return 0;
        case 2: 
          localm.Crz = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(40881);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            localm.CrA = ((d)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 4: 
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
            localm.CrB = ((n)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new l();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((l)localObject2).parseFrom((byte[])localObject1);
            }
            localm.CrC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40881);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new c();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((c)localObject2).parseFrom((byte[])localObject1);
          }
          localm.CrD = ((c)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(40881);
        return 0;
      }
      AppMethodBeat.o(40881);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.m
 * JD-Core Version:    0.7.0.1
 */