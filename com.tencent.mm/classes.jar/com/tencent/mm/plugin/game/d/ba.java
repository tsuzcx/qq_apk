package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cld;
import f.a.a.b;
import java.util.LinkedList;

public final class ba
  extends cld
{
  public f rZp;
  public String sbT;
  public LinkedList<x> sbU;
  public cf sbV;
  public bv sbW;
  public bs sbX;
  public cw sbY;
  public LinkedList<y> sbZ;
  public db sca;
  public bu scb;
  public br scc;
  
  public ba()
  {
    AppMethodBeat.i(41760);
    this.sbU = new LinkedList();
    this.sbZ = new LinkedList();
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
      if (this.rZp == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.sbT == null)
      {
        paramVarArgs = new b("Not all required fields were included: BackGroundURL");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.rZp != null)
      {
        paramVarArgs.kX(2, this.rZp.computeSize());
        this.rZp.writeFields(paramVarArgs);
      }
      if (this.sbT != null) {
        paramVarArgs.d(3, this.sbT);
      }
      paramVarArgs.e(4, 8, this.sbU);
      if (this.sbV != null)
      {
        paramVarArgs.kX(5, this.sbV.computeSize());
        this.sbV.writeFields(paramVarArgs);
      }
      if (this.sbW != null)
      {
        paramVarArgs.kX(7, this.sbW.computeSize());
        this.sbW.writeFields(paramVarArgs);
      }
      if (this.sbX != null)
      {
        paramVarArgs.kX(8, this.sbX.computeSize());
        this.sbX.writeFields(paramVarArgs);
      }
      if (this.sbY != null)
      {
        paramVarArgs.kX(9, this.sbY.computeSize());
        this.sbY.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.sbZ);
      if (this.sca != null)
      {
        paramVarArgs.kX(11, this.sca.computeSize());
        this.sca.writeFields(paramVarArgs);
      }
      if (this.scb != null)
      {
        paramVarArgs.kX(12, this.scb.computeSize());
        this.scb.writeFields(paramVarArgs);
      }
      if (this.scc != null)
      {
        paramVarArgs.kX(13, this.scc.computeSize());
        this.scc.writeFields(paramVarArgs);
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
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rZp != null) {
        paramInt = i + f.a.a.a.kW(2, this.rZp.computeSize());
      }
      i = paramInt;
      if (this.sbT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sbT);
      }
      i += f.a.a.a.c(4, 8, this.sbU);
      paramInt = i;
      if (this.sbV != null) {
        paramInt = i + f.a.a.a.kW(5, this.sbV.computeSize());
      }
      i = paramInt;
      if (this.sbW != null) {
        i = paramInt + f.a.a.a.kW(7, this.sbW.computeSize());
      }
      paramInt = i;
      if (this.sbX != null) {
        paramInt = i + f.a.a.a.kW(8, this.sbX.computeSize());
      }
      i = paramInt;
      if (this.sbY != null) {
        i = paramInt + f.a.a.a.kW(9, this.sbY.computeSize());
      }
      i += f.a.a.a.c(10, 8, this.sbZ);
      paramInt = i;
      if (this.sca != null) {
        paramInt = i + f.a.a.a.kW(11, this.sca.computeSize());
      }
      i = paramInt;
      if (this.scb != null) {
        i = paramInt + f.a.a.a.kW(12, this.scb.computeSize());
      }
      paramInt = i;
      if (this.scc != null) {
        paramInt = i + f.a.a.a.kW(13, this.scc.computeSize());
      }
      AppMethodBeat.o(41761);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sbU.clear();
        this.sbZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.rZp == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.sbT == null)
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
        ba localba = (ba)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.rZp = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 3: 
          localba.sbT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41761);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new x();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((x)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.sbU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.sbV = ((cf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.sbW = ((bv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.sbX = ((bs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.sbY = ((cw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new y();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((y)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.sbZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new db();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((db)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.sca = ((db)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.scb = ((bu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new br();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((br)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.scc = ((br)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ba
 * JD-Core Version:    0.7.0.1
 */