package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.iv;
import java.util.LinkedList;

public final class a
  extends cpx
{
  public LinkedList<String> oFU;
  public boolean oFV;
  public boolean oFW;
  public boolean oFX;
  
  public a()
  {
    AppMethodBeat.i(153039);
    this.oFU = new LinkedList();
    AppMethodBeat.o(153039);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153040);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.oFU);
      paramVarArgs.bl(3, this.oFV);
      paramVarArgs.bl(4, this.oFW);
      paramVarArgs.bl(5, this.oFX);
      AppMethodBeat.o(153040);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.oFU);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.fK(5);
      AppMethodBeat.o(153040);
      return paramInt + i + (j + 1) + (k + 1) + (m + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.oFU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153040);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153040);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153040);
          return 0;
        case 2: 
          locala.oFU.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(153040);
          return 0;
        case 3: 
          locala.oFV = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153040);
          return 0;
        case 4: 
          locala.oFW = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(153040);
          return 0;
        }
        locala.oFX = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(153040);
        return 0;
      }
      AppMethodBeat.o(153040);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */