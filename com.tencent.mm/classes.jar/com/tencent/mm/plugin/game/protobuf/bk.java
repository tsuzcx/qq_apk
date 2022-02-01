package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import java.util.LinkedList;

public final class bk
  extends dpc
{
  public g xIz;
  public cc xLA;
  public String xLr;
  public LinkedList<ae> xLs;
  public cs xLt;
  public ch xLu;
  public ce xLv;
  public dm xLw;
  public LinkedList<af> xLx;
  public dr xLy;
  public cg xLz;
  
  public bk()
  {
    AppMethodBeat.i(41760);
    this.xLs = new LinkedList();
    this.xLx = new LinkedList();
    AppMethodBeat.o(41760);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41761);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.xIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.xLr == null)
      {
        paramVarArgs = new b("Not all required fields were included: BackGroundURL");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xIz != null)
      {
        paramVarArgs.ni(2, this.xIz.computeSize());
        this.xIz.writeFields(paramVarArgs);
      }
      if (this.xLr != null) {
        paramVarArgs.e(3, this.xLr);
      }
      paramVarArgs.e(4, 8, this.xLs);
      if (this.xLt != null)
      {
        paramVarArgs.ni(5, this.xLt.computeSize());
        this.xLt.writeFields(paramVarArgs);
      }
      if (this.xLu != null)
      {
        paramVarArgs.ni(7, this.xLu.computeSize());
        this.xLu.writeFields(paramVarArgs);
      }
      if (this.xLv != null)
      {
        paramVarArgs.ni(8, this.xLv.computeSize());
        this.xLv.writeFields(paramVarArgs);
      }
      if (this.xLw != null)
      {
        paramVarArgs.ni(9, this.xLw.computeSize());
        this.xLw.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.xLx);
      if (this.xLy != null)
      {
        paramVarArgs.ni(11, this.xLy.computeSize());
        this.xLy.writeFields(paramVarArgs);
      }
      if (this.xLz != null)
      {
        paramVarArgs.ni(12, this.xLz.computeSize());
        this.xLz.writeFields(paramVarArgs);
      }
      if (this.xLA != null)
      {
        paramVarArgs.ni(13, this.xLA.computeSize());
        this.xLA.writeFields(paramVarArgs);
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
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xIz != null) {
        paramInt = i + g.a.a.a.nh(2, this.xIz.computeSize());
      }
      i = paramInt;
      if (this.xLr != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xLr);
      }
      i += g.a.a.a.c(4, 8, this.xLs);
      paramInt = i;
      if (this.xLt != null) {
        paramInt = i + g.a.a.a.nh(5, this.xLt.computeSize());
      }
      i = paramInt;
      if (this.xLu != null) {
        i = paramInt + g.a.a.a.nh(7, this.xLu.computeSize());
      }
      paramInt = i;
      if (this.xLv != null) {
        paramInt = i + g.a.a.a.nh(8, this.xLv.computeSize());
      }
      i = paramInt;
      if (this.xLw != null) {
        i = paramInt + g.a.a.a.nh(9, this.xLw.computeSize());
      }
      i += g.a.a.a.c(10, 8, this.xLx);
      paramInt = i;
      if (this.xLy != null) {
        paramInt = i + g.a.a.a.nh(11, this.xLy.computeSize());
      }
      i = paramInt;
      if (this.xLz != null) {
        i = paramInt + g.a.a.a.nh(12, this.xLz.computeSize());
      }
      paramInt = i;
      if (this.xLA != null) {
        paramInt = i + g.a.a.a.nh(13, this.xLA.computeSize());
      }
      AppMethodBeat.o(41761);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLs.clear();
        this.xLx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.xIz == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.xLr == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbk.xIz = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 3: 
          localbk.xLr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41761);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ae();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ae)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbk.xLs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cs();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbk.xLt = ((cs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ch();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ch)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbk.xLu = ((ch)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ce();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ce)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbk.xLv = ((ce)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbk.xLw = ((dm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new af();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((af)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbk.xLx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbk.xLy = ((dr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbk.xLz = ((cg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbk.xLA = ((cc)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bk
 * JD-Core Version:    0.7.0.1
 */