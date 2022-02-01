package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class by
  extends esc
{
  public da IKs;
  public LinkedList<e> IKt;
  public boolean IKu;
  public int IKv;
  
  public by()
  {
    AppMethodBeat.i(41779);
    this.IKt = new LinkedList();
    AppMethodBeat.o(41779);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41780);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41780);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.IKs != null)
      {
        paramVarArgs.qD(2, this.IKs.computeSize());
        this.IKs.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.IKt);
      paramVarArgs.di(4, this.IKu);
      paramVarArgs.bS(5, this.IKv);
      AppMethodBeat.o(41780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label676;
      }
    }
    label676:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IKs != null) {
        i = paramInt + i.a.a.a.qC(2, this.IKs.computeSize());
      }
      paramInt = i.a.a.a.c(3, 8, this.IKt);
      int j = i.a.a.b.b.a.ko(4);
      int k = i.a.a.b.b.a.cJ(5, this.IKv);
      AppMethodBeat.o(41780);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IKt.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41780);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        by localby = (by)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41780);
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
            localby.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41780);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new da();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((da)localObject2).parseFrom((byte[])localObject1);
            }
            localby.IKs = ((da)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41780);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new e();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((e)localObject2).parseFrom((byte[])localObject1);
            }
            localby.IKt.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41780);
          return 0;
        case 4: 
          localby.IKu = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(41780);
          return 0;
        }
        localby.IKv = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(41780);
        return 0;
      }
      AppMethodBeat.o(41780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.by
 * JD-Core Version:    0.7.0.1
 */