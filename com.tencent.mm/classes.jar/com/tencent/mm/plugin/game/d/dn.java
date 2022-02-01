package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class dn
  extends cvc
{
  public String gsT;
  public String jdl;
  public String ufd;
  public boolean ufr;
  public String uhu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41836);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uhu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41836);
        throw paramVarArgs;
      }
      if (this.gsT == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41836);
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
      if (this.gsT != null) {
        paramVarArgs.d(3, this.gsT);
      }
      if (this.ufd != null) {
        paramVarArgs.d(4, this.ufd);
      }
      if (this.jdl != null) {
        paramVarArgs.d(5, this.jdl);
      }
      paramVarArgs.bt(6, this.ufr);
      AppMethodBeat.o(41836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uhu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uhu);
      }
      i = paramInt;
      if (this.gsT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gsT);
      }
      paramInt = i;
      if (this.ufd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ufd);
      }
      i = paramInt;
      if (this.jdl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jdl);
      }
      paramInt = f.a.a.b.b.a.alV(6);
      AppMethodBeat.o(41836);
      return i + paramInt;
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
          AppMethodBeat.o(41836);
          throw paramVarArgs;
        }
        if (this.gsT == null)
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
        dn localdn = (dn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41836);
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
            localdn.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41836);
          return 0;
        case 2: 
          localdn.uhu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 3: 
          localdn.gsT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 4: 
          localdn.ufd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 5: 
          localdn.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41836);
          return 0;
        }
        localdn.ufr = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(41836);
        return 0;
      }
      AppMethodBeat.o(41836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dn
 * JD-Core Version:    0.7.0.1
 */