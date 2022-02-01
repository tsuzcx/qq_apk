package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public final class bp
  extends erp
{
  public String IJD;
  public int IJE;
  public LinkedList<String> IJY;
  public ae IJZ;
  public int IKa;
  public boolean IKb;
  public String pSo;
  
  public bp()
  {
    AppMethodBeat.i(41765);
    this.IJY = new LinkedList();
    AppMethodBeat.o(41765);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41766);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IJD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41766);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.IJD != null) {
        paramVarArgs.g(2, this.IJD);
      }
      paramVarArgs.e(3, 1, this.IJY);
      if (this.pSo != null) {
        paramVarArgs.g(4, this.pSo);
      }
      if (this.IJZ != null)
      {
        paramVarArgs.qD(5, this.IJZ.computeSize());
        this.IJZ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.IKa);
      paramVarArgs.di(7, this.IKb);
      paramVarArgs.bS(8, this.IJE);
      AppMethodBeat.o(41766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IJD != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IJD);
      }
      i += i.a.a.a.c(3, 1, this.IJY);
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.pSo);
      }
      i = paramInt;
      if (this.IJZ != null) {
        i = paramInt + i.a.a.a.qC(5, this.IJZ.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.IKa);
      int j = i.a.a.b.b.a.ko(7);
      int k = i.a.a.b.b.a.cJ(8, this.IJE);
      AppMethodBeat.o(41766);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IJY.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IJD == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41766);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bp localbp = (bp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41766);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbp.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41766);
          return 0;
        case 2: 
          localbp.IJD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41766);
          return 0;
        case 3: 
          localbp.IJY.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(41766);
          return 0;
        case 4: 
          localbp.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41766);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ae)localObject2).parseFrom((byte[])localObject1);
            }
            localbp.IJZ = ((ae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41766);
          return 0;
        case 6: 
          localbp.IKa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(41766);
          return 0;
        case 7: 
          localbp.IKb = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(41766);
          return 0;
        }
        localbp.IJE = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(41766);
        return 0;
      }
      AppMethodBeat.o(41766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bp
 * JD-Core Version:    0.7.0.1
 */