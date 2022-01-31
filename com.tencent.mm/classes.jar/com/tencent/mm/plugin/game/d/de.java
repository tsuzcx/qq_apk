package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.hq;
import e.a.a.b;
import java.util.LinkedList;

public final class de
  extends buy
{
  public String gwY;
  public String npW;
  public String npZ;
  public boolean nql;
  public String nsa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111671);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nsa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(111671);
        throw paramVarArgs;
      }
      if (this.npZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(111671);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nsa != null) {
        paramVarArgs.e(2, this.nsa);
      }
      if (this.npZ != null) {
        paramVarArgs.e(3, this.npZ);
      }
      if (this.npW != null) {
        paramVarArgs.e(4, this.npW);
      }
      if (this.gwY != null) {
        paramVarArgs.e(5, this.gwY);
      }
      paramVarArgs.aS(6, this.nql);
      AppMethodBeat.o(111671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nsa != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nsa);
      }
      i = paramInt;
      if (this.npZ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npZ);
      }
      paramInt = i;
      if (this.npW != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.npW);
      }
      i = paramInt;
      if (this.gwY != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.gwY);
      }
      paramInt = e.a.a.b.b.a.eW(6);
      AppMethodBeat.o(111671);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.nsa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(111671);
          throw paramVarArgs;
        }
        if (this.npZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(111671);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        de localde = (de)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111671);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localde.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111671);
          return 0;
        case 2: 
          localde.nsa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111671);
          return 0;
        case 3: 
          localde.npZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111671);
          return 0;
        case 4: 
          localde.npW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111671);
          return 0;
        case 5: 
          localde.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111671);
          return 0;
        }
        localde.nql = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(111671);
        return 0;
      }
      AppMethodBeat.o(111671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.de
 * JD-Core Version:    0.7.0.1
 */