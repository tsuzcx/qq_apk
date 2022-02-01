package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class j
  extends cvw
{
  public String fLp;
  public String pqu;
  public String source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153052);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fLp == null)
      {
        paramVarArgs = new b("Not all required fields were included: download_url");
        AppMethodBeat.o(153052);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fLp != null) {
        paramVarArgs.d(2, this.fLp);
      }
      if (this.pqu != null) {
        paramVarArgs.d(3, this.pqu);
      }
      if (this.source != null) {
        paramVarArgs.d(4, this.source);
      }
      AppMethodBeat.o(153052);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label538;
      }
    }
    label538:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fLp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fLp);
      }
      i = paramInt;
      if (this.pqu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pqu);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.source);
      }
      AppMethodBeat.o(153052);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.fLp == null)
        {
          paramVarArgs = new b("Not all required fields were included: download_url");
          AppMethodBeat.o(153052);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153052);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153052);
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
            localj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153052);
          return 0;
        case 2: 
          localj.fLp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153052);
          return 0;
        case 3: 
          localj.pqu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153052);
          return 0;
        }
        localj.source = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(153052);
        return 0;
      }
      AppMethodBeat.o(153052);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.j
 * JD-Core Version:    0.7.0.1
 */