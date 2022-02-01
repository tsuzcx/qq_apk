package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwj;
import f.a.a.b;
import java.util.LinkedList;

public final class bk
  extends cwj
{
  public g uqg;
  public String utp;
  public LinkedList<ad> utq;
  public cs utr;
  public ch uts;
  public ce utt;
  public dm utu;
  public LinkedList<ae> utv;
  public dr utw;
  public cg utx;
  public cc uty;
  
  public bk()
  {
    AppMethodBeat.i(41760);
    this.utq = new LinkedList();
    this.utv = new LinkedList();
    AppMethodBeat.o(41760);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41761);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.uqg == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.utp == null)
      {
        paramVarArgs = new b("Not all required fields were included: BackGroundURL");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.uqg != null)
      {
        paramVarArgs.lJ(2, this.uqg.computeSize());
        this.uqg.writeFields(paramVarArgs);
      }
      if (this.utp != null) {
        paramVarArgs.d(3, this.utp);
      }
      paramVarArgs.e(4, 8, this.utq);
      if (this.utr != null)
      {
        paramVarArgs.lJ(5, this.utr.computeSize());
        this.utr.writeFields(paramVarArgs);
      }
      if (this.uts != null)
      {
        paramVarArgs.lJ(7, this.uts.computeSize());
        this.uts.writeFields(paramVarArgs);
      }
      if (this.utt != null)
      {
        paramVarArgs.lJ(8, this.utt.computeSize());
        this.utt.writeFields(paramVarArgs);
      }
      if (this.utu != null)
      {
        paramVarArgs.lJ(9, this.utu.computeSize());
        this.utu.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.utv);
      if (this.utw != null)
      {
        paramVarArgs.lJ(11, this.utw.computeSize());
        this.utw.writeFields(paramVarArgs);
      }
      if (this.utx != null)
      {
        paramVarArgs.lJ(12, this.utx.computeSize());
        this.utx.writeFields(paramVarArgs);
      }
      if (this.uty != null)
      {
        paramVarArgs.lJ(13, this.uty.computeSize());
        this.uty.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2046;
      }
    }
    label2046:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uqg != null) {
        paramInt = i + f.a.a.a.lI(2, this.uqg.computeSize());
      }
      i = paramInt;
      if (this.utp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.utp);
      }
      i += f.a.a.a.c(4, 8, this.utq);
      paramInt = i;
      if (this.utr != null) {
        paramInt = i + f.a.a.a.lI(5, this.utr.computeSize());
      }
      i = paramInt;
      if (this.uts != null) {
        i = paramInt + f.a.a.a.lI(7, this.uts.computeSize());
      }
      paramInt = i;
      if (this.utt != null) {
        paramInt = i + f.a.a.a.lI(8, this.utt.computeSize());
      }
      i = paramInt;
      if (this.utu != null) {
        i = paramInt + f.a.a.a.lI(9, this.utu.computeSize());
      }
      i += f.a.a.a.c(10, 8, this.utv);
      paramInt = i;
      if (this.utw != null) {
        paramInt = i + f.a.a.a.lI(11, this.utw.computeSize());
      }
      i = paramInt;
      if (this.utx != null) {
        i = paramInt + f.a.a.a.lI(12, this.utx.computeSize());
      }
      paramInt = i;
      if (this.uty != null) {
        paramInt = i + f.a.a.a.lI(13, this.uty.computeSize());
      }
      AppMethodBeat.o(41761);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.utq.clear();
        this.utv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.uqg == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.utp == null)
        {
          paramVarArgs = new b("Not all required fields were included: BackGroundURL");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41761);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bk localbk = (bk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(41761);
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
            localbk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbk.uqg = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 3: 
          localbk.utp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41761);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ad();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ad)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbk.utq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbk.utr = ((cs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ch();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ch)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbk.uts = ((ch)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ce();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ce)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbk.utt = ((ce)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbk.utu = ((dm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ae();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ae)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbk.utv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbk.utw = ((dr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbk.utx = ((cg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbk.uty = ((cc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41761);
        return 0;
      }
      AppMethodBeat.o(41761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bk
 * JD-Core Version:    0.7.0.1
 */