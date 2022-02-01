package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class dw
  extends cvw
{
  public String gvv;
  public String jge;
  public boolean uqB;
  public String uqn;
  public String usS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41836);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.usS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41836);
        throw paramVarArgs;
      }
      if (this.gvv == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41836);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.usS != null) {
        paramVarArgs.d(2, this.usS);
      }
      if (this.gvv != null) {
        paramVarArgs.d(3, this.gvv);
      }
      if (this.uqn != null) {
        paramVarArgs.d(4, this.uqn);
      }
      if (this.jge != null) {
        paramVarArgs.d(5, this.jge);
      }
      paramVarArgs.bC(6, this.uqB);
      AppMethodBeat.o(41836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.usS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.usS);
      }
      i = paramInt;
      if (this.gvv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gvv);
      }
      paramInt = i;
      if (this.uqn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uqn);
      }
      i = paramInt;
      if (this.jge != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jge);
      }
      paramInt = f.a.a.b.b.a.amF(6);
      AppMethodBeat.o(41836);
      return i + paramInt;
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
          AppMethodBeat.o(41836);
          throw paramVarArgs;
        }
        if (this.gvv == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41836);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41836);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dw localdw = (dw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41836);
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
            localdw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41836);
          return 0;
        case 2: 
          localdw.usS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 3: 
          localdw.gvv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 4: 
          localdw.uqn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 5: 
          localdw.jge = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41836);
          return 0;
        }
        localdw.uqB = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(41836);
        return 0;
      }
      AppMethodBeat.o(41836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dw
 * JD-Core Version:    0.7.0.1
 */