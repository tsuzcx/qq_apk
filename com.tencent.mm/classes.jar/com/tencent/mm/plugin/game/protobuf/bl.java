package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import g.a.a.b;
import java.util.LinkedList;

public final class bl
  extends dyy
{
  public g CME;
  public String CPA;
  public LinkedList<af> CPB;
  public ct CPC;
  public ci CPD;
  public cf CPE;
  public dn CPF;
  public LinkedList<ag> CPG;
  public ds CPH;
  public ch CPI;
  public cd CPJ;
  
  public bl()
  {
    AppMethodBeat.i(41760);
    this.CPB = new LinkedList();
    this.CPG = new LinkedList();
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
      if (this.CME == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.CPA == null)
      {
        paramVarArgs = new b("Not all required fields were included: BackGroundURL");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CME != null)
      {
        paramVarArgs.oE(2, this.CME.computeSize());
        this.CME.writeFields(paramVarArgs);
      }
      if (this.CPA != null) {
        paramVarArgs.f(3, this.CPA);
      }
      paramVarArgs.e(4, 8, this.CPB);
      if (this.CPC != null)
      {
        paramVarArgs.oE(5, this.CPC.computeSize());
        this.CPC.writeFields(paramVarArgs);
      }
      if (this.CPD != null)
      {
        paramVarArgs.oE(7, this.CPD.computeSize());
        this.CPD.writeFields(paramVarArgs);
      }
      if (this.CPE != null)
      {
        paramVarArgs.oE(8, this.CPE.computeSize());
        this.CPE.writeFields(paramVarArgs);
      }
      if (this.CPF != null)
      {
        paramVarArgs.oE(9, this.CPF.computeSize());
        this.CPF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.CPG);
      if (this.CPH != null)
      {
        paramVarArgs.oE(11, this.CPH.computeSize());
        this.CPH.writeFields(paramVarArgs);
      }
      if (this.CPI != null)
      {
        paramVarArgs.oE(12, this.CPI.computeSize());
        this.CPI.writeFields(paramVarArgs);
      }
      if (this.CPJ != null)
      {
        paramVarArgs.oE(13, this.CPJ.computeSize());
        this.CPJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1804;
      }
    }
    label1804:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CME != null) {
        paramInt = i + g.a.a.a.oD(2, this.CME.computeSize());
      }
      i = paramInt;
      if (this.CPA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CPA);
      }
      i += g.a.a.a.c(4, 8, this.CPB);
      paramInt = i;
      if (this.CPC != null) {
        paramInt = i + g.a.a.a.oD(5, this.CPC.computeSize());
      }
      i = paramInt;
      if (this.CPD != null) {
        i = paramInt + g.a.a.a.oD(7, this.CPD.computeSize());
      }
      paramInt = i;
      if (this.CPE != null) {
        paramInt = i + g.a.a.a.oD(8, this.CPE.computeSize());
      }
      i = paramInt;
      if (this.CPF != null) {
        i = paramInt + g.a.a.a.oD(9, this.CPF.computeSize());
      }
      i += g.a.a.a.c(10, 8, this.CPG);
      paramInt = i;
      if (this.CPH != null) {
        paramInt = i + g.a.a.a.oD(11, this.CPH.computeSize());
      }
      i = paramInt;
      if (this.CPI != null) {
        i = paramInt + g.a.a.a.oD(12, this.CPI.computeSize());
      }
      paramInt = i;
      if (this.CPJ != null) {
        paramInt = i + g.a.a.a.oD(13, this.CPJ.computeSize());
      }
      AppMethodBeat.o(41761);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CPB.clear();
        this.CPG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.CME == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.CPA == null)
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
        bl localbl = (bl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(41761);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbl.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new g();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((g)localObject2).parseFrom((byte[])localObject1);
            }
            localbl.CME = ((g)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 3: 
          localbl.CPA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41761);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new af();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((af)localObject2).parseFrom((byte[])localObject1);
            }
            localbl.CPB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ct();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ct)localObject2).parseFrom((byte[])localObject1);
            }
            localbl.CPC = ((ct)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ci();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ci)localObject2).parseFrom((byte[])localObject1);
            }
            localbl.CPD = ((ci)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cf)localObject2).parseFrom((byte[])localObject1);
            }
            localbl.CPE = ((cf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dn)localObject2).parseFrom((byte[])localObject1);
            }
            localbl.CPF = ((dn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ag();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ag)localObject2).parseFrom((byte[])localObject1);
            }
            localbl.CPG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ds();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ds)localObject2).parseFrom((byte[])localObject1);
            }
            localbl.CPH = ((ds)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ch();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ch)localObject2).parseFrom((byte[])localObject1);
            }
            localbl.CPI = ((ch)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cd)localObject2).parseFrom((byte[])localObject1);
          }
          localbl.CPJ = ((cd)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bl
 * JD-Core Version:    0.7.0.1
 */