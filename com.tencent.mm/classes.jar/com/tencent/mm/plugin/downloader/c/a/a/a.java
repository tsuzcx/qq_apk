package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ip;
import java.util.LinkedList;

public final class a
  extends ckq
{
  public LinkedList<String> ocv;
  public boolean ocw;
  public boolean ocx;
  public boolean ocy;
  
  public a()
  {
    AppMethodBeat.i(153039);
    this.ocv = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.ocv);
      paramVarArgs.bg(3, this.ocw);
      paramVarArgs.bg(4, this.ocx);
      paramVarArgs.bg(5, this.ocy);
      AppMethodBeat.o(153040);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.ocv);
      int j = f.a.a.b.b.a.fY(3);
      int k = f.a.a.b.b.a.fY(4);
      int m = f.a.a.b.b.a.fY(5);
      AppMethodBeat.o(153040);
      return paramInt + i + (j + 1) + (k + 1) + (m + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ocv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153040);
          return 0;
        case 2: 
          locala.ocv.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(153040);
          return 0;
        case 3: 
          locala.ocw = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153040);
          return 0;
        case 4: 
          locala.ocx = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153040);
          return 0;
        }
        locala.ocy = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(153040);
        return 0;
      }
      AppMethodBeat.o(153040);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */