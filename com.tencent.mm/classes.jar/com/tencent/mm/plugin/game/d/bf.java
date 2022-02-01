package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import java.util.LinkedList;

public final class bf
  extends cvp
{
  public String ufH;
  public LinkedList<ah> uia;
  public com.tencent.mm.bx.b uib;
  public boolean uic;
  
  public bf()
  {
    AppMethodBeat.i(41763);
    this.uia = new LinkedList();
    AppMethodBeat.o(41763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41764);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41764);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.uia);
      if (this.uib != null) {
        paramVarArgs.c(3, this.uib);
      }
      paramVarArgs.bt(4, this.uic);
      if (this.ufH != null) {
        paramVarArgs.d(5, this.ufH);
      }
      AppMethodBeat.o(41764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.uia);
      paramInt = i;
      if (this.uib != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.uib);
      }
      i = paramInt + f.a.a.b.b.a.alV(4);
      paramInt = i;
      if (this.ufH != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ufH);
      }
      AppMethodBeat.o(41764);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uia.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41764);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41764);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bf localbf = (bf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41764);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41764);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ah();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ah)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbf.uia.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41764);
          return 0;
        case 3: 
          localbf.uib = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(41764);
          return 0;
        case 4: 
          localbf.uic = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(41764);
          return 0;
        }
        localbf.ufH = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41764);
        return 0;
      }
      AppMethodBeat.o(41764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bf
 * JD-Core Version:    0.7.0.1
 */