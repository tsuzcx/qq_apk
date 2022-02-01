package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public h vgB;
  public int vgC;
  public int vgD;
  public int vgE;
  public int vgF;
  public int vgG;
  public int vgH;
  public int vgI;
  public int vgJ;
  public int vgK;
  public String vgy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22104);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22104);
        throw paramVarArgs;
      }
      if (this.vgy != null) {
        paramVarArgs.g(1, this.vgy);
      }
      if (this.vgB != null)
      {
        paramVarArgs.qD(2, this.vgB.computeSize());
        this.vgB.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.vgC);
      paramVarArgs.bS(4, this.vgD);
      paramVarArgs.bS(5, this.vgE);
      paramVarArgs.bS(6, this.vgF);
      paramVarArgs.bS(7, this.vgG);
      paramVarArgs.bS(8, this.vgH);
      paramVarArgs.bS(9, this.vgI);
      paramVarArgs.bS(10, this.vgJ);
      paramVarArgs.bS(11, this.vgK);
      AppMethodBeat.o(22104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vgy == null) {
        break label837;
      }
    }
    label837:
    for (paramInt = i.a.a.b.b.a.h(1, this.vgy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vgB != null) {
        i = paramInt + i.a.a.a.qC(2, this.vgB.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.vgC);
      int j = i.a.a.b.b.a.cJ(4, this.vgD);
      int k = i.a.a.b.b.a.cJ(5, this.vgE);
      int m = i.a.a.b.b.a.cJ(6, this.vgF);
      int n = i.a.a.b.b.a.cJ(7, this.vgG);
      int i1 = i.a.a.b.b.a.cJ(8, this.vgH);
      int i2 = i.a.a.b.b.a.cJ(9, this.vgI);
      int i3 = i.a.a.b.b.a.cJ(10, this.vgJ);
      int i4 = i.a.a.b.b.a.cJ(11, this.vgK);
      AppMethodBeat.o(22104);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.vgy == null)
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22104);
          return -1;
        case 1: 
          locald.vgy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(22104);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            h localh = new h();
            if ((localObject != null) && (localObject.length > 0)) {
              localh.parseFrom((byte[])localObject);
            }
            locald.vgB = localh;
            paramInt += 1;
          }
          AppMethodBeat.o(22104);
          return 0;
        case 3: 
          locald.vgC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22104);
          return 0;
        case 4: 
          locald.vgD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22104);
          return 0;
        case 5: 
          locald.vgE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22104);
          return 0;
        case 6: 
          locald.vgF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22104);
          return 0;
        case 7: 
          locald.vgG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22104);
          return 0;
        case 8: 
          locald.vgH = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22104);
          return 0;
        case 9: 
          locald.vgI = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22104);
          return 0;
        case 10: 
          locald.vgJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22104);
          return 0;
        }
        locald.vgK = ((i.a.a.a.a)localObject).ajGk.aar();
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