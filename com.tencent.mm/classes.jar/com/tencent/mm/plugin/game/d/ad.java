package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.LinkedList;

public final class ad
  extends cvc
{
  public String gsT;
  public String ugt;
  public com.tencent.mm.bx.b ugu;
  public com.tencent.mm.bx.b ugv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41729);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gsT == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: AppID");
        AppMethodBeat.o(41729);
        throw paramVarArgs;
      }
      if (this.ugt == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: GroupID");
        AppMethodBeat.o(41729);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gsT != null) {
        paramVarArgs.d(2, this.gsT);
      }
      if (this.ugt != null) {
        paramVarArgs.d(3, this.ugt);
      }
      if (this.ugu != null) {
        paramVarArgs.c(4, this.ugu);
      }
      if (this.ugv != null) {
        paramVarArgs.c(5, this.ugv);
      }
      AppMethodBeat.o(41729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gsT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gsT);
      }
      i = paramInt;
      if (this.ugt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ugt);
      }
      paramInt = i;
      if (this.ugu != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.ugu);
      }
      i = paramInt;
      if (this.ugv != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.ugv);
      }
      AppMethodBeat.o(41729);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.gsT == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: AppID");
          AppMethodBeat.o(41729);
          throw paramVarArgs;
        }
        if (this.ugt == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: GroupID");
          AppMethodBeat.o(41729);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41729);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41729);
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
            localad.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41729);
          return 0;
        case 2: 
          localad.gsT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41729);
          return 0;
        case 3: 
          localad.ugt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41729);
          return 0;
        case 4: 
          localad.ugu = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(41729);
          return 0;
        }
        localad.ugv = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(41729);
        return 0;
      }
      AppMethodBeat.o(41729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ad
 * JD-Core Version:    0.7.0.1
 */