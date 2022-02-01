package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class g
  extends j
{
  public String nIO;
  public int qkU;
  public int qkV;
  public int qkW;
  public int qkX;
  public int qkY;
  public String qkZ;
  public int qla;
  public String qlb;
  public int qlc;
  public int qld;
  public String qle;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qlh == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23491);
        throw paramVarArgs;
      }
      if (this.qlh != null)
      {
        paramVarArgs.lJ(1, this.qlh.computeSize());
        this.qlh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.qkU);
      paramVarArgs.aS(3, this.qkV);
      paramVarArgs.aS(4, this.qkW);
      paramVarArgs.aS(5, this.qkX);
      paramVarArgs.aS(6, this.qkY);
      if (this.qkZ != null) {
        paramVarArgs.d(11, this.qkZ);
      }
      paramVarArgs.aS(12, this.qla);
      if (this.nIO != null) {
        paramVarArgs.d(13, this.nIO);
      }
      if (this.qlb != null) {
        paramVarArgs.d(14, this.qlb);
      }
      paramVarArgs.aS(15, this.qlc);
      paramVarArgs.aS(16, this.qld);
      if (this.qle != null) {
        paramVarArgs.d(17, this.qle);
      }
      AppMethodBeat.o(23491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qlh == null) {
        break label993;
      }
    }
    label993:
    for (paramInt = f.a.a.a.lI(1, this.qlh.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qkU) + f.a.a.b.b.a.bz(3, this.qkV) + f.a.a.b.b.a.bz(4, this.qkW) + f.a.a.b.b.a.bz(5, this.qkX) + f.a.a.b.b.a.bz(6, this.qkY);
      paramInt = i;
      if (this.qkZ != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.qkZ);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.qla);
      paramInt = i;
      if (this.nIO != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.nIO);
      }
      i = paramInt;
      if (this.qlb != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.qlb);
      }
      i = i + f.a.a.b.b.a.bz(15, this.qlc) + f.a.a.b.b.a.bz(16, this.qld);
      paramInt = i;
      if (this.qle != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.qle);
      }
      AppMethodBeat.o(23491);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.qlh == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, j.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.qlh = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23491);
          return 0;
        case 2: 
          localg.qkU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 3: 
          localg.qkV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 4: 
          localg.qkW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 5: 
          localg.qkX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 6: 
          localg.qkY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 11: 
          localg.qkZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 12: 
          localg.qla = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 13: 
          localg.nIO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 14: 
          localg.qlb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(23491);
          return 0;
        case 15: 
          localg.qlc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(23491);
          return 0;
        case 16: 
          localg.qld = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(23491);
          return 0;
        }
        localg.qle = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(23491);
        return 0;
      }
      AppMethodBeat.o(23491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.g
 * JD-Core Version:    0.7.0.1
 */