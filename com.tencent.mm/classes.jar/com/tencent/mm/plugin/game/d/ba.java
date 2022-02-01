package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class ba
  extends cvc
{
  public String jdl;
  public String uhu;
  public int uhv;
  public e uhw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uhu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(149415);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uhu != null) {
        paramVarArgs.d(2, this.uhu);
      }
      if (this.jdl != null) {
        paramVarArgs.d(3, this.jdl);
      }
      paramVarArgs.aS(4, this.uhv);
      if (this.uhw != null)
      {
        paramVarArgs.lC(5, this.uhw.computeSize());
        this.uhw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(149415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label678;
      }
    }
    label678:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uhu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uhu);
      }
      i = paramInt;
      if (this.jdl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jdl);
      }
      i += f.a.a.b.b.a.bz(4, this.uhv);
      paramInt = i;
      if (this.uhw != null) {
        paramInt = i + f.a.a.a.lB(5, this.uhw.computeSize());
      }
      AppMethodBeat.o(149415);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.uhu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(149415);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ba localba = (ba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(149415);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149415);
          return 0;
        case 2: 
          localba.uhu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(149415);
          return 0;
        case 3: 
          localba.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(149415);
          return 0;
        case 4: 
          localba.uhv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(149415);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.uhw = ((e)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(149415);
        return 0;
      }
      AppMethodBeat.o(149415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ba
 * JD-Core Version:    0.7.0.1
 */