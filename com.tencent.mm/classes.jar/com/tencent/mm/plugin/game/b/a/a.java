package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.LinkedList;

public final class a
  extends cvw
{
  public String ikm;
  public int ucK;
  public String ucL;
  public long ucM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40860);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ucK);
      if (this.ucL != null) {
        paramVarArgs.d(3, this.ucL);
      }
      if (this.ikm != null) {
        paramVarArgs.d(4, this.ikm);
      }
      paramVarArgs.aZ(5, this.ucM);
      AppMethodBeat.o(40860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ucK);
      paramInt = i;
      if (this.ucL != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ucL);
      }
      i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ikm);
      }
      paramInt = f.a.a.b.b.a.p(5, this.ucM);
      AppMethodBeat.o(40860);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(40860);
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
          AppMethodBeat.o(40860);
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
          AppMethodBeat.o(40860);
          return 0;
        case 2: 
          locala.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(40860);
          return 0;
        case 3: 
          locala.ucL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(40860);
          return 0;
        case 4: 
          locala.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(40860);
          return 0;
        }
        locala.ucM = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(40860);
        return 0;
      }
      AppMethodBeat.o(40860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a.a
 * JD-Core Version:    0.7.0.1
 */