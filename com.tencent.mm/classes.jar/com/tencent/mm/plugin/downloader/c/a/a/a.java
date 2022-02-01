package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.LinkedList;

public final class a
  extends cvw
{
  public LinkedList<String> pqd;
  public boolean pqe;
  public boolean pqf;
  public boolean pqg;
  
  public a()
  {
    AppMethodBeat.i(153039);
    this.pqd = new LinkedList();
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
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.pqd);
      paramVarArgs.bC(3, this.pqe);
      paramVarArgs.bC(4, this.pqf);
      paramVarArgs.bC(5, this.pqg);
      AppMethodBeat.o(153040);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.pqd);
      int j = f.a.a.b.b.a.amF(3);
      int k = f.a.a.b.b.a.amF(4);
      int m = f.a.a.b.b.a.amF(5);
      AppMethodBeat.o(153040);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.pqd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153040);
          return 0;
        case 2: 
          locala.pqd.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(153040);
          return 0;
        case 3: 
          locala.pqe = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153040);
          return 0;
        case 4: 
          locala.pqf = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153040);
          return 0;
        }
        locala.pqg = ((f.a.a.a.a)localObject1).OmT.gvY();
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