package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.LinkedList;

public final class e
  extends cvw
{
  public String gvA;
  public String gvv;
  public int gvw;
  public int gvx;
  public int gvy;
  public String gvz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176000);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gvv != null) {
        paramVarArgs.d(2, this.gvv);
      }
      paramVarArgs.aS(3, this.gvw);
      paramVarArgs.aS(4, this.gvx);
      paramVarArgs.aS(5, this.gvy);
      if (this.gvz != null) {
        paramVarArgs.d(6, this.gvz);
      }
      if (this.gvA != null) {
        paramVarArgs.d(7, this.gvA);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gvv != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.gvv);
      }
      i = i + f.a.a.b.b.a.bz(3, this.gvw) + f.a.a.b.b.a.bz(4, this.gvx) + f.a.a.b.b.a.bz(5, this.gvy);
      paramInt = i;
      if (this.gvz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.gvz);
      }
      i = paramInt;
      if (this.gvA != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.gvA);
      }
      AppMethodBeat.o(176000);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(176000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(176000);
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
            locale.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(176000);
          return 0;
        case 2: 
          locale.gvv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(176000);
          return 0;
        case 3: 
          locale.gvw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(176000);
          return 0;
        case 4: 
          locale.gvx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(176000);
          return 0;
        case 5: 
          locale.gvy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(176000);
          return 0;
        case 6: 
          locale.gvz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(176000);
          return 0;
        }
        locale.gvA = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(176000);
        return 0;
      }
      AppMethodBeat.o(176000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.game.report.c.e
 * JD-Core Version:    0.7.0.1
 */