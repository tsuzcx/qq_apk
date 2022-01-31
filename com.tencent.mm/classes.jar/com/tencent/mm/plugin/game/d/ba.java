package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bvk;
import e.a.a.b;
import java.util.LinkedList;

public final class ba
  extends bvk
{
  public e npS;
  public br nsA;
  public String nsr;
  public LinkedList<v> nss;
  public cf nst;
  public bv nsu;
  public bs nsv;
  public cv nsw;
  public LinkedList<w> nsx;
  public da nsy;
  public bu nsz;
  
  public ba()
  {
    AppMethodBeat.i(111595);
    this.nss = new LinkedList();
    this.nsx = new LinkedList();
    AppMethodBeat.o(111595);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111596);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(111596);
        throw paramVarArgs;
      }
      if (this.npS == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(111596);
        throw paramVarArgs;
      }
      if (this.nsr == null)
      {
        paramVarArgs = new b("Not all required fields were included: BackGroundURL");
        AppMethodBeat.o(111596);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.npS != null)
      {
        paramVarArgs.iQ(2, this.npS.computeSize());
        this.npS.writeFields(paramVarArgs);
      }
      if (this.nsr != null) {
        paramVarArgs.e(3, this.nsr);
      }
      paramVarArgs.e(4, 8, this.nss);
      if (this.nst != null)
      {
        paramVarArgs.iQ(5, this.nst.computeSize());
        this.nst.writeFields(paramVarArgs);
      }
      if (this.nsu != null)
      {
        paramVarArgs.iQ(7, this.nsu.computeSize());
        this.nsu.writeFields(paramVarArgs);
      }
      if (this.nsv != null)
      {
        paramVarArgs.iQ(8, this.nsv.computeSize());
        this.nsv.writeFields(paramVarArgs);
      }
      if (this.nsw != null)
      {
        paramVarArgs.iQ(9, this.nsw.computeSize());
        this.nsw.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.nsx);
      if (this.nsy != null)
      {
        paramVarArgs.iQ(11, this.nsy.computeSize());
        this.nsy.writeFields(paramVarArgs);
      }
      if (this.nsz != null)
      {
        paramVarArgs.iQ(12, this.nsz.computeSize());
        this.nsz.writeFields(paramVarArgs);
      }
      if (this.nsA != null)
      {
        paramVarArgs.iQ(13, this.nsA.computeSize());
        this.nsA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(111596);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2046;
      }
    }
    label2046:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.npS != null) {
        paramInt = i + e.a.a.a.iP(2, this.npS.computeSize());
      }
      i = paramInt;
      if (this.nsr != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nsr);
      }
      i += e.a.a.a.c(4, 8, this.nss);
      paramInt = i;
      if (this.nst != null) {
        paramInt = i + e.a.a.a.iP(5, this.nst.computeSize());
      }
      i = paramInt;
      if (this.nsu != null) {
        i = paramInt + e.a.a.a.iP(7, this.nsu.computeSize());
      }
      paramInt = i;
      if (this.nsv != null) {
        paramInt = i + e.a.a.a.iP(8, this.nsv.computeSize());
      }
      i = paramInt;
      if (this.nsw != null) {
        i = paramInt + e.a.a.a.iP(9, this.nsw.computeSize());
      }
      i += e.a.a.a.c(10, 8, this.nsx);
      paramInt = i;
      if (this.nsy != null) {
        paramInt = i + e.a.a.a.iP(11, this.nsy.computeSize());
      }
      i = paramInt;
      if (this.nsz != null) {
        i = paramInt + e.a.a.a.iP(12, this.nsz.computeSize());
      }
      paramInt = i;
      if (this.nsA != null) {
        paramInt = i + e.a.a.a.iP(13, this.nsA.computeSize());
      }
      AppMethodBeat.o(111596);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nss.clear();
        this.nsx.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(111596);
          throw paramVarArgs;
        }
        if (this.npS == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(111596);
          throw paramVarArgs;
        }
        if (this.nsr == null)
        {
          paramVarArgs = new b("Not all required fields were included: BackGroundURL");
          AppMethodBeat.o(111596);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111596);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ba localba = (ba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(111596);
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
            localba.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111596);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localba.npS = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111596);
          return 0;
        case 3: 
          localba.nsr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111596);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new v();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localba.nss.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111596);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localba.nst = ((cf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111596);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localba.nsu = ((bv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111596);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bs();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localba.nsv = ((bs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111596);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localba.nsw = ((cv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111596);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new w();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((w)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localba.nsx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111596);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new da();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((da)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localba.nsy = ((da)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111596);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localba.nsz = ((bu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111596);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new br();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((br)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localba.nsA = ((br)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111596);
        return 0;
      }
      AppMethodBeat.o(111596);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ba
 * JD-Core Version:    0.7.0.1
 */