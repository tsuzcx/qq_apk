package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwj;
import f.a.a.b;
import java.util.LinkedList;

public final class bi
  extends cwj
{
  public boolean usV;
  public au usW;
  public String usX;
  public am usY;
  public i usZ;
  public dv uta;
  public r utb;
  public en utc;
  public y utd;
  public em ute;
  public x utf;
  public a utg;
  public l uth;
  public ah uti;
  public ba utj;
  public bg utk;
  public ai utl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(149416);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(2, this.usV);
      if (this.usW != null)
      {
        paramVarArgs.lJ(3, this.usW.computeSize());
        this.usW.writeFields(paramVarArgs);
      }
      if (this.usX != null) {
        paramVarArgs.d(4, this.usX);
      }
      if (this.usY != null)
      {
        paramVarArgs.lJ(6, this.usY.computeSize());
        this.usY.writeFields(paramVarArgs);
      }
      if (this.usZ != null)
      {
        paramVarArgs.lJ(7, this.usZ.computeSize());
        this.usZ.writeFields(paramVarArgs);
      }
      if (this.uta != null)
      {
        paramVarArgs.lJ(8, this.uta.computeSize());
        this.uta.writeFields(paramVarArgs);
      }
      if (this.utb != null)
      {
        paramVarArgs.lJ(11, this.utb.computeSize());
        this.utb.writeFields(paramVarArgs);
      }
      if (this.utc != null)
      {
        paramVarArgs.lJ(12, this.utc.computeSize());
        this.utc.writeFields(paramVarArgs);
      }
      if (this.utd != null)
      {
        paramVarArgs.lJ(13, this.utd.computeSize());
        this.utd.writeFields(paramVarArgs);
      }
      if (this.ute != null)
      {
        paramVarArgs.lJ(14, this.ute.computeSize());
        this.ute.writeFields(paramVarArgs);
      }
      if (this.utf != null)
      {
        paramVarArgs.lJ(15, this.utf.computeSize());
        this.utf.writeFields(paramVarArgs);
      }
      if (this.utg != null)
      {
        paramVarArgs.lJ(16, this.utg.computeSize());
        this.utg.writeFields(paramVarArgs);
      }
      if (this.uth != null)
      {
        paramVarArgs.lJ(17, this.uth.computeSize());
        this.uth.writeFields(paramVarArgs);
      }
      if (this.uti != null)
      {
        paramVarArgs.lJ(18, this.uti.computeSize());
        this.uti.writeFields(paramVarArgs);
      }
      if (this.utj != null)
      {
        paramVarArgs.lJ(19, this.utj.computeSize());
        this.utj.writeFields(paramVarArgs);
      }
      if (this.utk != null)
      {
        paramVarArgs.lJ(20, this.utk.computeSize());
        this.utk.writeFields(paramVarArgs);
      }
      if (this.utl != null)
      {
        paramVarArgs.lJ(21, this.utl.computeSize());
        this.utl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(149416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2810;
      }
    }
    label2810:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amF(2);
      paramInt = i;
      if (this.usW != null) {
        paramInt = i + f.a.a.a.lI(3, this.usW.computeSize());
      }
      i = paramInt;
      if (this.usX != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.usX);
      }
      paramInt = i;
      if (this.usY != null) {
        paramInt = i + f.a.a.a.lI(6, this.usY.computeSize());
      }
      i = paramInt;
      if (this.usZ != null) {
        i = paramInt + f.a.a.a.lI(7, this.usZ.computeSize());
      }
      paramInt = i;
      if (this.uta != null) {
        paramInt = i + f.a.a.a.lI(8, this.uta.computeSize());
      }
      i = paramInt;
      if (this.utb != null) {
        i = paramInt + f.a.a.a.lI(11, this.utb.computeSize());
      }
      paramInt = i;
      if (this.utc != null) {
        paramInt = i + f.a.a.a.lI(12, this.utc.computeSize());
      }
      i = paramInt;
      if (this.utd != null) {
        i = paramInt + f.a.a.a.lI(13, this.utd.computeSize());
      }
      paramInt = i;
      if (this.ute != null) {
        paramInt = i + f.a.a.a.lI(14, this.ute.computeSize());
      }
      i = paramInt;
      if (this.utf != null) {
        i = paramInt + f.a.a.a.lI(15, this.utf.computeSize());
      }
      paramInt = i;
      if (this.utg != null) {
        paramInt = i + f.a.a.a.lI(16, this.utg.computeSize());
      }
      i = paramInt;
      if (this.uth != null) {
        i = paramInt + f.a.a.a.lI(17, this.uth.computeSize());
      }
      paramInt = i;
      if (this.uti != null) {
        paramInt = i + f.a.a.a.lI(18, this.uti.computeSize());
      }
      i = paramInt;
      if (this.utj != null) {
        i = paramInt + f.a.a.a.lI(19, this.utj.computeSize());
      }
      paramInt = i;
      if (this.utk != null) {
        paramInt = i + f.a.a.a.lI(20, this.utk.computeSize());
      }
      i = paramInt;
      if (this.utl != null) {
        i = paramInt + f.a.a.a.lI(21, this.utl.computeSize());
      }
      AppMethodBeat.o(149416);
      return i;
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
          AppMethodBeat.o(149416);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bi localbi = (bi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(149416);
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
            localbi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 2: 
          localbi.usV = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(149416);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new au();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.usW = ((au)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 4: 
          localbi.usX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(149416);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new am();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((am)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.usY = ((am)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.usZ = ((i)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.uta = ((dv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new r();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.utb = ((r)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new en();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((en)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.utc = ((en)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new y();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((y)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.utd = ((y)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new em();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((em)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.ute = ((em)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new x();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((x)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.utf = ((x)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.utg = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.uth = ((l)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ah();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ah)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.uti = ((ah)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ba();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.utj = ((ba)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.utk = ((bg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ai();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbi.utl = ((ai)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(149416);
        return 0;
      }
      AppMethodBeat.o(149416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bi
 * JD-Core Version:    0.7.0.1
 */