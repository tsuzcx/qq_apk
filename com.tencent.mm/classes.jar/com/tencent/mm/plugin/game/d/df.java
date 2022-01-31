package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bvk;
import e.a.a.b;
import java.util.LinkedList;

public final class df
  extends bvk
{
  public String Title;
  public boolean nqg;
  public String nqz;
  public k nuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111672);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(111672);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(111672);
        throw paramVarArgs;
      }
      if (this.nqz == null)
      {
        paramVarArgs = new b("Not all required fields were included: Message");
        AppMethodBeat.o(111672);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nqg);
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      if (this.nqz != null) {
        paramVarArgs.e(4, this.nqz);
      }
      if (this.nuj != null)
      {
        paramVarArgs.iQ(5, this.nuj.computeSize());
        this.nuj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(111672);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 1);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.Title);
      }
      i = paramInt;
      if (this.nqz != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.nqz);
      }
      paramInt = i;
      if (this.nuj != null) {
        paramInt = i + e.a.a.a.iP(5, this.nuj.computeSize());
      }
      AppMethodBeat.o(111672);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(111672);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(111672);
          throw paramVarArgs;
        }
        if (this.nqz == null)
        {
          paramVarArgs = new b("Not all required fields were included: Message");
          AppMethodBeat.o(111672);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111672);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        df localdf = (df)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111672);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111672);
          return 0;
        case 2: 
          localdf.nqg = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(111672);
          return 0;
        case 3: 
          localdf.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111672);
          return 0;
        case 4: 
          localdf.nqz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111672);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localdf.nuj = ((k)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111672);
        return 0;
      }
      AppMethodBeat.o(111672);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.df
 * JD-Core Version:    0.7.0.1
 */