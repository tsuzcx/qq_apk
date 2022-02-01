package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ip;
import f.a.a.b;
import java.util.LinkedList;

public final class df
  extends ckq
{
  public String fVC;
  public String ijV;
  public boolean rZH;
  public String rZt;
  public String sbA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41836);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sbA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41836);
        throw paramVarArgs;
      }
      if (this.fVC == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41836);
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
      if (this.rZt != null) {
        paramVarArgs.d(4, this.rZt);
      }
      if (this.ijV != null) {
        paramVarArgs.d(5, this.ijV);
      }
      paramVarArgs.bg(6, this.rZH);
      AppMethodBeat.o(41836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
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
      paramInt = i;
      if (this.rZt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rZt);
      }
      i = paramInt;
      if (this.ijV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ijV);
      }
      paramInt = f.a.a.b.b.a.fY(6);
      AppMethodBeat.o(41836);
      return i + (paramInt + 1);
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
          AppMethodBeat.o(41836);
          throw paramVarArgs;
        }
        if (this.fVC == null)
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
        df localdf = (df)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41836);
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
            localdf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41836);
          return 0;
        case 2: 
          localdf.sbA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 3: 
          localdf.fVC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 4: 
          localdf.rZt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 5: 
          localdf.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41836);
          return 0;
        }
        localdf.rZH = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(41836);
        return 0;
      }
      AppMethodBeat.o(41836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.df
 * JD-Core Version:    0.7.0.1
 */