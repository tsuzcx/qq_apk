package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class bo
  extends esc
{
  public String IHJ;
  public LinkedList<aq> IJV;
  public com.tencent.mm.bx.b IJW;
  public boolean IJX;
  
  public bo()
  {
    AppMethodBeat.i(41763);
    this.IJV = new LinkedList();
    AppMethodBeat.o(41763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41764);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41764);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.IJV);
      if (this.IJW != null) {
        paramVarArgs.d(3, this.IJW);
      }
      paramVarArgs.di(4, this.IJX);
      if (this.IHJ != null) {
        paramVarArgs.g(5, this.IHJ);
      }
      AppMethodBeat.o(41764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.IJV);
      paramInt = i;
      if (this.IJW != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.IJW);
      }
      i = paramInt + (i.a.a.b.b.a.ko(4) + 1);
      paramInt = i;
      if (this.IHJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.IHJ);
      }
      AppMethodBeat.o(41764);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IJV.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41764);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41764);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bo localbo = (bo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41764);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbo.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41764);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aq)localObject2).parseFrom((byte[])localObject1);
            }
            localbo.IJV.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41764);
          return 0;
        case 3: 
          localbo.IJW = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(41764);
          return 0;
        case 4: 
          localbo.IJX = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(41764);
          return 0;
        }
        localbo.IHJ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(41764);
        return 0;
      }
      AppMethodBeat.o(41764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bo
 * JD-Core Version:    0.7.0.1
 */