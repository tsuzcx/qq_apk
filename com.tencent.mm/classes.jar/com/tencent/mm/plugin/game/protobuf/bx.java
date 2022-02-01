package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public final class bx
  extends erp
{
  public String IJD;
  public LinkedList<String> IJY;
  public int IKo;
  public int IKp;
  public int IKq;
  public boolean IKr;
  public String pSo;
  
  public bx()
  {
    AppMethodBeat.i(41777);
    this.IJY = new LinkedList();
    AppMethodBeat.o(41777);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41778);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IJD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41778);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.IKo);
      paramVarArgs.bS(3, this.IKp);
      if (this.IJD != null) {
        paramVarArgs.g(4, this.IJD);
      }
      paramVarArgs.e(5, 1, this.IJY);
      if (this.pSo != null) {
        paramVarArgs.g(6, this.pSo);
      }
      paramVarArgs.bS(7, this.IKq);
      paramVarArgs.di(8, this.IKr);
      AppMethodBeat.o(41778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label692;
      }
    }
    label692:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.IKo) + i.a.a.b.b.a.cJ(3, this.IKp);
      paramInt = i;
      if (this.IJD != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IJD);
      }
      i = paramInt + i.a.a.a.c(5, 1, this.IJY);
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.pSo);
      }
      i = i.a.a.b.b.a.cJ(7, this.IKq);
      int j = i.a.a.b.b.a.ko(8);
      AppMethodBeat.o(41778);
      return paramInt + i + (j + 1);
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
          AppMethodBeat.o(41778);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41778);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bx localbx = (bx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41778);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localbx.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(41778);
          return 0;
        case 2: 
          localbx.IKo = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(41778);
          return 0;
        case 3: 
          localbx.IKp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(41778);
          return 0;
        case 4: 
          localbx.IJD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41778);
          return 0;
        case 5: 
          localbx.IJY.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(41778);
          return 0;
        case 6: 
          localbx.pSo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41778);
          return 0;
        case 7: 
          localbx.IKq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(41778);
          return 0;
        }
        localbx.IKr = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(41778);
        return 0;
      }
      AppMethodBeat.o(41778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bx
 * JD-Core Version:    0.7.0.1
 */