package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.LinkedList;

public final class a
  extends cvc
{
  public boolean pjA;
  public boolean pjB;
  public LinkedList<String> pjy;
  public boolean pjz;
  
  public a()
  {
    AppMethodBeat.i(153039);
    this.pjy = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.pjy);
      paramVarArgs.bt(3, this.pjz);
      paramVarArgs.bt(4, this.pjA);
      paramVarArgs.bt(5, this.pjB);
      AppMethodBeat.o(153040);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.pjy);
      int j = f.a.a.b.b.a.alV(3);
      int k = f.a.a.b.b.a.alV(4);
      int m = f.a.a.b.b.a.alV(5);
      AppMethodBeat.o(153040);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.pjy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153040);
          return 0;
        case 2: 
          locala.pjy.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(153040);
          return 0;
        case 3: 
          locala.pjz = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153040);
          return 0;
        case 4: 
          locala.pjA = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153040);
          return 0;
        }
        locala.pjB = ((f.a.a.a.a)localObject1).NPN.grw();
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