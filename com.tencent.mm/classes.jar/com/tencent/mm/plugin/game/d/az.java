package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ip;
import f.a.a.b;
import java.util.LinkedList;

public final class az
  extends ckq
{
  public String fVC;
  public String ijV;
  public String sbA;
  public boolean sbQ;
  public boolean sbR;
  public boolean sbS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41759);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sbA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41759);
        throw paramVarArgs;
      }
      if (this.fVC == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41759);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.sbA != null) {
        paramVarArgs.d(2, this.sbA);
      }
      if (this.fVC != null) {
        paramVarArgs.d(3, this.fVC);
      }
      paramVarArgs.bg(4, this.sbQ);
      if (this.ijV != null) {
        paramVarArgs.d(5, this.ijV);
      }
      paramVarArgs.bg(6, this.sbR);
      paramVarArgs.bg(7, this.sbS);
      AppMethodBeat.o(41759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sbA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sbA);
      }
      i = paramInt;
      if (this.fVC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fVC);
      }
      i += f.a.a.b.b.a.fY(4) + 1;
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ijV);
      }
      i = f.a.a.b.b.a.fY(6);
      int j = f.a.a.b.b.a.fY(7);
      AppMethodBeat.o(41759);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.sbA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41759);
          throw paramVarArgs;
        }
        if (this.fVC == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        az localaz = (az)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41759);
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
            localaz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41759);
          return 0;
        case 2: 
          localaz.sbA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 3: 
          localaz.fVC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 4: 
          localaz.sbQ = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(41759);
          return 0;
        case 5: 
          localaz.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 6: 
          localaz.sbR = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(41759);
          return 0;
        }
        localaz.sbS = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(41759);
        return 0;
      }
      AppMethodBeat.o(41759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.az
 * JD-Core Version:    0.7.0.1
 */