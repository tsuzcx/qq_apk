package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class bx
  extends cvw
{
  public String jge;
  public String usS;
  public int utT;
  public int utU;
  public int uub;
  public int uuc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41781);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.usS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41781);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.utT);
      paramVarArgs.aS(3, this.utU);
      if (this.usS != null) {
        paramVarArgs.d(4, this.usS);
      }
      paramVarArgs.aS(5, this.uub);
      paramVarArgs.aS(6, this.uuc);
      if (this.jge != null) {
        paramVarArgs.d(7, this.jge);
      }
      AppMethodBeat.o(41781);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.utT) + f.a.a.b.b.a.bz(3, this.utU);
      paramInt = i;
      if (this.usS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.usS);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.uub) + f.a.a.b.b.a.bz(6, this.uuc);
      paramInt = i;
      if (this.jge != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.jge);
      }
      AppMethodBeat.o(41781);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.usS == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41781);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41781);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bx localbx = (bx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41781);
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
            localbx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41781);
          return 0;
        case 2: 
          localbx.utT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41781);
          return 0;
        case 3: 
          localbx.utU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41781);
          return 0;
        case 4: 
          localbx.usS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41781);
          return 0;
        case 5: 
          localbx.uub = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41781);
          return 0;
        case 6: 
          localbx.uuc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(41781);
          return 0;
        }
        localbx.jge = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41781);
        return 0;
      }
      AppMethodBeat.o(41781);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bx
 * JD-Core Version:    0.7.0.1
 */