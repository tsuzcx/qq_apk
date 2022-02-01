package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class bm
  extends esc
{
  public g IGJ;
  public String IJK;
  public LinkedList<ag> IJL;
  public cv IJM;
  public cj IJN;
  public cg IJO;
  public dr IJP;
  public LinkedList<ah> IJQ;
  public dw IJR;
  public ci IJS;
  public ce IJT;
  
  public bm()
  {
    AppMethodBeat.i(41760);
    this.IJL = new LinkedList();
    this.IJQ = new LinkedList();
    AppMethodBeat.o(41760);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41761);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.IGJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.IJK == null)
      {
        paramVarArgs = new b("Not all required fields were included: BackGroundURL");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.IGJ != null)
      {
        paramVarArgs.qD(2, this.IGJ.computeSize());
        this.IGJ.writeFields(paramVarArgs);
      }
      if (this.IJK != null) {
        paramVarArgs.g(3, this.IJK);
      }
      paramVarArgs.e(4, 8, this.IJL);
      if (this.IJM != null)
      {
        paramVarArgs.qD(5, this.IJM.computeSize());
        this.IJM.writeFields(paramVarArgs);
      }
      if (this.IJN != null)
      {
        paramVarArgs.qD(7, this.IJN.computeSize());
        this.IJN.writeFields(paramVarArgs);
      }
      if (this.IJO != null)
      {
        paramVarArgs.qD(8, this.IJO.computeSize());
        this.IJO.writeFields(paramVarArgs);
      }
      if (this.IJP != null)
      {
        paramVarArgs.qD(9, this.IJP.computeSize());
        this.IJP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.IJQ);
      if (this.IJR != null)
      {
        paramVarArgs.qD(11, this.IJR.computeSize());
        this.IJR.writeFields(paramVarArgs);
      }
      if (this.IJS != null)
      {
        paramVarArgs.qD(12, this.IJS.computeSize());
        this.IJS.writeFields(paramVarArgs);
      }
      if (this.IJT != null)
      {
        paramVarArgs.qD(13, this.IJT.computeSize());
        this.IJT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1800;
      }
    }
    label1800:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGJ != null) {
        paramInt = i + i.a.a.a.qC(2, this.IGJ.computeSize());
      }
      i = paramInt;
      if (this.IJK != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IJK);
      }
      i += i.a.a.a.c(4, 8, this.IJL);
      paramInt = i;
      if (this.IJM != null) {
        paramInt = i + i.a.a.a.qC(5, this.IJM.computeSize());
      }
      i = paramInt;
      if (this.IJN != null) {
        i = paramInt + i.a.a.a.qC(7, this.IJN.computeSize());
      }
      paramInt = i;
      if (this.IJO != null) {
        paramInt = i + i.a.a.a.qC(8, this.IJO.computeSize());
      }
      i = paramInt;
      if (this.IJP != null) {
        i = paramInt + i.a.a.a.qC(9, this.IJP.computeSize());
      }
      i += i.a.a.a.c(10, 8, this.IJQ);
      paramInt = i;
      if (this.IJR != null) {
        paramInt = i + i.a.a.a.qC(11, this.IJR.computeSize());
      }
      i = paramInt;
      if (this.IJS != null) {
        i = paramInt + i.a.a.a.qC(12, this.IJS.computeSize());
      }
      paramInt = i;
      if (this.IJT != null) {
        paramInt = i + i.a.a.a.qC(13, this.IJT.computeSize());
      }
      AppMethodBeat.o(41761);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IJL.clear();
        this.IJQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.IGJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.IJK == null)
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bm localbm = (bm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(41761);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new g();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((g)localObject2).parseFrom((byte[])localObject1);
            }
            localbm.IGJ = ((g)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 3: 
          localbm.IJK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41761);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ag();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ag)localObject2).parseFrom((byte[])localObject1);
            }
            localbm.IJL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cv)localObject2).parseFrom((byte[])localObject1);
            }
            localbm.IJM = ((cv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cj)localObject2).parseFrom((byte[])localObject1);
            }
            localbm.IJN = ((cj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cg)localObject2).parseFrom((byte[])localObject1);
            }
            localbm.IJO = ((cg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dr)localObject2).parseFrom((byte[])localObject1);
            }
            localbm.IJP = ((dr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ah();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ah)localObject2).parseFrom((byte[])localObject1);
            }
            localbm.IJQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dw)localObject2).parseFrom((byte[])localObject1);
            }
            localbm.IJR = ((dw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ci();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ci)localObject2).parseFrom((byte[])localObject1);
            }
            localbm.IJS = ((ci)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ce();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ce)localObject2).parseFrom((byte[])localObject1);
          }
          localbm.IJT = ((ce)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bm
 * JD-Core Version:    0.7.0.1
 */