package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import f.a.a.b;
import java.util.LinkedList;

public final class do
  extends cvp
{
  public String Title;
  public String ufM;
  public boolean ufm;
  public m ujQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41837);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41837);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41837);
        throw paramVarArgs;
      }
      if (this.ufM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Message");
        AppMethodBeat.o(41837);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(2, this.ufm);
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.ufM != null) {
        paramVarArgs.d(4, this.ufM);
      }
      if (this.ujQ != null)
      {
        paramVarArgs.lC(5, this.ujQ.computeSize());
        this.ujQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alV(2);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Title);
      }
      i = paramInt;
      if (this.ufM != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ufM);
      }
      paramInt = i;
      if (this.ujQ != null) {
        paramInt = i + f.a.a.a.lB(5, this.ujQ.computeSize());
      }
      AppMethodBeat.o(41837);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41837);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41837);
          throw paramVarArgs;
        }
        if (this.ufM == null)
        {
          paramVarArgs = new b("Not all required fields were included: Message");
          AppMethodBeat.o(41837);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41837);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        do localdo = (do)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41837);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41837);
          return 0;
        case 2: 
          localdo.ufm = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(41837);
          return 0;
        case 3: 
          localdo.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41837);
          return 0;
        case 4: 
          localdo.ufM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41837);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new m();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdo.ujQ = ((m)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41837);
        return 0;
      }
      AppMethodBeat.o(41837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.do
 * JD-Core Version:    0.7.0.1
 */