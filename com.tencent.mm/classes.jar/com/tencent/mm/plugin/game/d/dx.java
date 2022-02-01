package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwj;
import f.a.a.b;
import java.util.LinkedList;

public final class dx
  extends cwj
{
  public String Title;
  public boolean uqw;
  public String urg;
  public p uvo;
  
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
      if (this.urg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Message");
        AppMethodBeat.o(41837);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(2, this.uqw);
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.urg != null) {
        paramVarArgs.d(4, this.urg);
      }
      if (this.uvo != null)
      {
        paramVarArgs.lJ(5, this.uvo.computeSize());
        this.uvo.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amF(2);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Title);
      }
      i = paramInt;
      if (this.urg != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.urg);
      }
      paramInt = i;
      if (this.uvo != null) {
        paramInt = i + f.a.a.a.lI(5, this.uvo.computeSize());
      }
      AppMethodBeat.o(41837);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        if (this.urg == null)
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
        dx localdx = (dx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41837);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41837);
          return 0;
        case 2: 
          localdx.uqw = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(41837);
          return 0;
        case 3: 
          localdx.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41837);
          return 0;
        case 4: 
          localdx.urg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41837);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdx.uvo = ((p)localObject1);
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
 * Qualified Name:     com.tencent.mm.plugin.game.d.dx
 * JD-Core Version:    0.7.0.1
 */