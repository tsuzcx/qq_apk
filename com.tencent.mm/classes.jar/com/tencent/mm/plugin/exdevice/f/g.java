package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class g
  extends j
{
  public String nDt;
  public int qep;
  public int qeq;
  public int qer;
  public int qes;
  public int qet;
  public String qeu;
  public int qev;
  public String qew;
  public int qex;
  public int qey;
  public String qez;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qeC == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23491);
        throw paramVarArgs;
      }
      if (this.qeC != null)
      {
        paramVarArgs.lC(1, this.qeC.computeSize());
        this.qeC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.qep);
      paramVarArgs.aS(3, this.qeq);
      paramVarArgs.aS(4, this.qer);
      paramVarArgs.aS(5, this.qes);
      paramVarArgs.aS(6, this.qet);
      if (this.qeu != null) {
        paramVarArgs.d(11, this.qeu);
      }
      paramVarArgs.aS(12, this.qev);
      if (this.nDt != null) {
        paramVarArgs.d(13, this.nDt);
      }
      if (this.qew != null) {
        paramVarArgs.d(14, this.qew);
      }
      paramVarArgs.aS(15, this.qex);
      paramVarArgs.aS(16, this.qey);
      if (this.qez != null) {
        paramVarArgs.d(17, this.qez);
      }
      AppMethodBeat.o(23491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qeC == null) {
        break label993;
      }
    }
    label993:
    for (paramInt = f.a.a.a.lB(1, this.qeC.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qep) + f.a.a.b.b.a.bz(3, this.qeq) + f.a.a.b.b.a.bz(4, this.qer) + f.a.a.b.b.a.bz(5, this.qes) + f.a.a.b.b.a.bz(6, this.qet);
      paramInt = i;
      if (this.qeu != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.qeu);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.qev);
      paramInt = i;
      if (this.nDt != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.nDt);
      }
      i = paramInt;
      if (this.qew != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.qew);
      }
      i = i + f.a.a.b.b.a.bz(15, this.qex) + f.a.a.b.b.a.bz(16, this.qey);
      paramInt = i;
      if (this.qez != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.qez);
      }
      AppMethodBeat.o(23491);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.qeC == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, j.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.qeC = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23491);
          return 0;
        case 2: 
          localg.qep = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 3: 
          localg.qeq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 4: 
          localg.qer = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 5: 
          localg.qes = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 6: 
          localg.qet = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 11: 
          localg.qeu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 12: 
          localg.qev = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 13: 
          localg.nDt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 14: 
          localg.qew = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 15: 
          localg.qex = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 16: 
          localg.qey = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(23491);
          return 0;
        }
        localg.qez = ((f.a.a.a.a)localObject1).NPN.readString();
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