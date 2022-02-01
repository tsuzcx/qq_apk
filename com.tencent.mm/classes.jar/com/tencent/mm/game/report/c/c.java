package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ip;
import java.util.LinkedList;

public final class c
  extends ckq
{
  public String fVC;
  public int fVD;
  public int fVE;
  public int fVF;
  public String fVG;
  public String fVH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176000);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fVC != null) {
        paramVarArgs.d(2, this.fVC);
      }
      paramVarArgs.aR(3, this.fVD);
      paramVarArgs.aR(4, this.fVE);
      paramVarArgs.aR(5, this.fVF);
      if (this.fVG != null) {
        paramVarArgs.d(6, this.fVG);
      }
      if (this.fVH != null) {
        paramVarArgs.d(7, this.fVH);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fVC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.fVC);
      }
      i = i + f.a.a.b.b.a.bA(3, this.fVD) + f.a.a.b.b.a.bA(4, this.fVE) + f.a.a.b.b.a.bA(5, this.fVF);
      paramInt = i;
      if (this.fVG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.fVG);
      }
      i = paramInt;
      if (this.fVH != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.fVH);
      }
      AppMethodBeat.o(176000);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(176000);
          return 0;
        case 2: 
          localc.fVC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(176000);
          return 0;
        case 3: 
          localc.fVD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(176000);
          return 0;
        case 4: 
          localc.fVE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(176000);
          return 0;
        case 5: 
          localc.fVF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(176000);
          return 0;
        case 6: 
          localc.fVG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(176000);
          return 0;
        }
        localc.fVH = ((f.a.a.a.a)localObject1).KhF.readString();
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