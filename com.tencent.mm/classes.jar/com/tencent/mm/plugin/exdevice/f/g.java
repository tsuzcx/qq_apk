package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class g
  extends j
{
  public String rVH;
  public int vhA;
  public int vhB;
  public String vhC;
  public int vhD;
  public String vhE;
  public int vhF;
  public int vhG;
  public String vhH;
  public int vhx;
  public int vhy;
  public int vhz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23491);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.vhK == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23491);
        throw paramVarArgs;
      }
      if (this.vhK != null)
      {
        paramVarArgs.oE(1, this.vhK.computeSize());
        this.vhK.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.vhx);
      paramVarArgs.aY(3, this.vhy);
      paramVarArgs.aY(4, this.vhz);
      paramVarArgs.aY(5, this.vhA);
      paramVarArgs.aY(6, this.vhB);
      if (this.vhC != null) {
        paramVarArgs.f(11, this.vhC);
      }
      paramVarArgs.aY(12, this.vhD);
      if (this.rVH != null) {
        paramVarArgs.f(13, this.rVH);
      }
      if (this.vhE != null) {
        paramVarArgs.f(14, this.vhE);
      }
      paramVarArgs.aY(15, this.vhF);
      paramVarArgs.aY(16, this.vhG);
      if (this.vhH != null) {
        paramVarArgs.f(17, this.vhH);
      }
      AppMethodBeat.o(23491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhK == null) {
        break label971;
      }
    }
    label971:
    for (paramInt = g.a.a.a.oD(1, this.vhK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.vhx) + g.a.a.b.b.a.bM(3, this.vhy) + g.a.a.b.b.a.bM(4, this.vhz) + g.a.a.b.b.a.bM(5, this.vhA) + g.a.a.b.b.a.bM(6, this.vhB);
      paramInt = i;
      if (this.vhC != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.vhC);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.vhD);
      paramInt = i;
      if (this.rVH != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.rVH);
      }
      i = paramInt;
      if (this.vhE != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.vhE);
      }
      i = i + g.a.a.b.b.a.bM(15, this.vhF) + g.a.a.b.b.a.bM(16, this.vhG);
      paramInt = i;
      if (this.vhH != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.vhH);
      }
      AppMethodBeat.o(23491);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.vhK == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(23491);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23491);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(23491);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            e locale = new e();
            if ((localObject != null) && (localObject.length > 0)) {
              locale.parseFrom((byte[])localObject);
            }
            localg.vhK = locale;
            paramInt += 1;
          }
          AppMethodBeat.o(23491);
          return 0;
        case 2: 
          localg.vhx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(23491);
          return 0;
        case 3: 
          localg.vhy = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(23491);
          return 0;
        case 4: 
          localg.vhz = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(23491);
          return 0;
        case 5: 
          localg.vhA = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(23491);
          return 0;
        case 6: 
          localg.vhB = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(23491);
          return 0;
        case 11: 
          localg.vhC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 12: 
          localg.vhD = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(23491);
          return 0;
        case 13: 
          localg.rVH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 14: 
          localg.vhE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 15: 
          localg.vhF = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(23491);
          return 0;
        case 16: 
          localg.vhG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(23491);
          return 0;
        }
        localg.vhH = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(23491);
        return 0;
      }
      AppMethodBeat.o(23491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.g
 * JD-Core Version:    0.7.0.1
 */