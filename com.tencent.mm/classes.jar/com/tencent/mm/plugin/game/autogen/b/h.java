package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class h
  extends esc
{
  public String Idc;
  public int Idd;
  public String Ide;
  public long Idr;
  public LinkedList<m> Ids;
  public boolean has_next;
  public int uYc;
  public int wsr;
  public String ytw;
  
  public h()
  {
    AppMethodBeat.i(40873);
    this.Ids = new LinkedList();
    AppMethodBeat.o(40873);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40874);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40874);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Idd);
      if (this.ytw != null) {
        paramVarArgs.g(3, this.ytw);
      }
      if (this.Ide != null) {
        paramVarArgs.g(4, this.Ide);
      }
      paramVarArgs.di(5, this.has_next);
      paramVarArgs.bv(6, this.Idr);
      paramVarArgs.e(7, 8, this.Ids);
      if (this.Idc != null) {
        paramVarArgs.g(8, this.Idc);
      }
      paramVarArgs.bS(9, this.uYc);
      paramVarArgs.bS(10, this.wsr);
      AppMethodBeat.o(40874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Idd);
      paramInt = i;
      if (this.ytw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ytw);
      }
      i = paramInt;
      if (this.Ide != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Ide);
      }
      i = i + (i.a.a.b.b.a.ko(5) + 1) + i.a.a.b.b.a.q(6, this.Idr) + i.a.a.a.c(7, 8, this.Ids);
      paramInt = i;
      if (this.Idc != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Idc);
      }
      i = i.a.a.b.b.a.cJ(9, this.uYc);
      int j = i.a.a.b.b.a.cJ(10, this.wsr);
      AppMethodBeat.o(40874);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ids.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(40874);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40874);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40874);
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
            localh.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 2: 
          localh.Idd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(40874);
          return 0;
        case 3: 
          localh.ytw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 4: 
          localh.Ide = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 5: 
          localh.has_next = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(40874);
          return 0;
        case 6: 
          localh.Idr = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(40874);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new m();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((m)localObject2).parseFrom((byte[])localObject1);
            }
            localh.Ids.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 8: 
          localh.Idc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 9: 
          localh.uYc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(40874);
          return 0;
        }
        localh.wsr = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(40874);
        return 0;
      }
      AppMethodBeat.o(40874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.h
 * JD-Core Version:    0.7.0.1
 */