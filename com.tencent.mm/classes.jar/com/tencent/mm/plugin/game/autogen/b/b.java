package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class b
  extends esc
{
  public int Idd;
  public String Ide;
  public boolean Idf = false;
  public String desc;
  public int wsr;
  public String ytw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40865);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40865);
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
      paramVarArgs.di(5, this.Idf);
      paramVarArgs.bS(6, this.wsr);
      if (this.desc != null) {
        paramVarArgs.g(7, this.desc);
      }
      AppMethodBeat.o(40865);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label644;
      }
    }
    label644:
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
      i = i + (i.a.a.b.b.a.ko(5) + 1) + i.a.a.b.b.a.cJ(6, this.wsr);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.desc);
      }
      AppMethodBeat.o(40865);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(40865);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40865);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40865);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localb.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(40865);
          return 0;
        case 2: 
          localb.Idd = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(40865);
          return 0;
        case 3: 
          localb.ytw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(40865);
          return 0;
        case 4: 
          localb.Ide = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(40865);
          return 0;
        case 5: 
          localb.Idf = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(40865);
          return 0;
        case 6: 
          localb.wsr = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(40865);
          return 0;
        }
        localb.desc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(40865);
        return 0;
      }
      AppMethodBeat.o(40865);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.b
 * JD-Core Version:    0.7.0.1
 */