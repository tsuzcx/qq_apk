package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bvk;
import e.a.a.b;
import java.util.LinkedList;

public final class ay
  extends bvk
{
  public boolean nsd;
  public ak nse;
  public String nsf;
  public ac nsg;
  public f nsh;
  public dd nsi;
  public m nsj;
  public dp nsk;
  public s nsl;
  public do nsm;
  public r nsn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117000);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(117000);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nsd);
      if (this.nse != null)
      {
        paramVarArgs.iQ(3, this.nse.computeSize());
        this.nse.writeFields(paramVarArgs);
      }
      if (this.nsf != null) {
        paramVarArgs.e(4, this.nsf);
      }
      if (this.nsg != null)
      {
        paramVarArgs.iQ(6, this.nsg.computeSize());
        this.nsg.writeFields(paramVarArgs);
      }
      if (this.nsh != null)
      {
        paramVarArgs.iQ(7, this.nsh.computeSize());
        this.nsh.writeFields(paramVarArgs);
      }
      if (this.nsi != null)
      {
        paramVarArgs.iQ(8, this.nsi.computeSize());
        this.nsi.writeFields(paramVarArgs);
      }
      if (this.nsj != null)
      {
        paramVarArgs.iQ(11, this.nsj.computeSize());
        this.nsj.writeFields(paramVarArgs);
      }
      if (this.nsk != null)
      {
        paramVarArgs.iQ(12, this.nsk.computeSize());
        this.nsk.writeFields(paramVarArgs);
      }
      if (this.nsl != null)
      {
        paramVarArgs.iQ(13, this.nsl.computeSize());
        this.nsl.writeFields(paramVarArgs);
      }
      if (this.nsm != null)
      {
        paramVarArgs.iQ(14, this.nsm.computeSize());
        this.nsm.writeFields(paramVarArgs);
      }
      if (this.nsn != null)
      {
        paramVarArgs.iQ(15, this.nsn.computeSize());
        this.nsn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1874;
      }
    }
    label1874:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 1);
      paramInt = i;
      if (this.nse != null) {
        paramInt = i + e.a.a.a.iP(3, this.nse.computeSize());
      }
      i = paramInt;
      if (this.nsf != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.nsf);
      }
      paramInt = i;
      if (this.nsg != null) {
        paramInt = i + e.a.a.a.iP(6, this.nsg.computeSize());
      }
      i = paramInt;
      if (this.nsh != null) {
        i = paramInt + e.a.a.a.iP(7, this.nsh.computeSize());
      }
      paramInt = i;
      if (this.nsi != null) {
        paramInt = i + e.a.a.a.iP(8, this.nsi.computeSize());
      }
      i = paramInt;
      if (this.nsj != null) {
        i = paramInt + e.a.a.a.iP(11, this.nsj.computeSize());
      }
      paramInt = i;
      if (this.nsk != null) {
        paramInt = i + e.a.a.a.iP(12, this.nsk.computeSize());
      }
      i = paramInt;
      if (this.nsl != null) {
        i = paramInt + e.a.a.a.iP(13, this.nsl.computeSize());
      }
      paramInt = i;
      if (this.nsm != null) {
        paramInt = i + e.a.a.a.iP(14, this.nsm.computeSize());
      }
      i = paramInt;
      if (this.nsn != null) {
        i = paramInt + e.a.a.a.iP(15, this.nsn.computeSize());
      }
      AppMethodBeat.o(117000);
      return i;
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
          AppMethodBeat.o(117000);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ay localay = (ay)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(117000);
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
            localay.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117000);
          return 0;
        case 2: 
          localay.nsd = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(117000);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ak();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localay.nse = ((ak)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117000);
          return 0;
        case 4: 
          localay.nsf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(117000);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ac();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ac)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localay.nsg = ((ac)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117000);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localay.nsh = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117000);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localay.nsi = ((dd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117000);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localay.nsj = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117000);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localay.nsk = ((dp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117000);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new s();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localay.nsl = ((s)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117000);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new do();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((do)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localay.nsm = ((do)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117000);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new r();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localay.nsn = ((r)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117000);
        return 0;
      }
      AppMethodBeat.o(117000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ay
 * JD-Core Version:    0.7.0.1
 */