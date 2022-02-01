package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.LinkedList;

public final class c
  extends cvc
{
  public String gsT;
  public int gsU;
  public int gsV;
  public int gsW;
  public String gsX;
  public String gsY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176000);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gsT != null) {
        paramVarArgs.d(2, this.gsT);
      }
      paramVarArgs.aS(3, this.gsU);
      paramVarArgs.aS(4, this.gsV);
      paramVarArgs.aS(5, this.gsW);
      if (this.gsX != null) {
        paramVarArgs.d(6, this.gsX);
      }
      if (this.gsY != null) {
        paramVarArgs.d(7, this.gsY);
      }
      AppMethodBeat.o(176000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gsT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.gsT);
      }
      i = i + f.a.a.b.b.a.bz(3, this.gsU) + f.a.a.b.b.a.bz(4, this.gsV) + f.a.a.b.b.a.bz(5, this.gsW);
      paramInt = i;
      if (this.gsX != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.gsX);
      }
      i = paramInt;
      if (this.gsY != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.gsY);
      }
      AppMethodBeat.o(176000);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(176000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(176000);
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
            localc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(176000);
          return 0;
        case 2: 
          localc.gsT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(176000);
          return 0;
        case 3: 
          localc.gsU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(176000);
          return 0;
        case 4: 
          localc.gsV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(176000);
          return 0;
        case 5: 
          localc.gsW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(176000);
          return 0;
        case 6: 
          localc.gsX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(176000);
          return 0;
        }
        localc.gsY = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(176000);
        return 0;
      }
      AppMethodBeat.o(176000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.game.report.c.c
 * JD-Core Version:    0.7.0.1
 */