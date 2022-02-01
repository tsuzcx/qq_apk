package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class e
  extends erp
{
  public String IcK;
  public String IcN;
  public String IcO;
  public String IcP;
  public String IcQ;
  public String IcR;
  public int IcS;
  public String oOI;
  public String vgX;
  public String vhx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275457);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vgX != null) {
        paramVarArgs.g(2, this.vgX);
      }
      if (this.vhx != null) {
        paramVarArgs.g(3, this.vhx);
      }
      if (this.IcN != null) {
        paramVarArgs.g(4, this.IcN);
      }
      if (this.IcO != null) {
        paramVarArgs.g(5, this.IcO);
      }
      if (this.IcP != null) {
        paramVarArgs.g(6, this.IcP);
      }
      if (this.IcK != null) {
        paramVarArgs.g(7, this.IcK);
      }
      if (this.oOI != null) {
        paramVarArgs.g(8, this.oOI);
      }
      if (this.IcQ != null) {
        paramVarArgs.g(9, this.IcQ);
      }
      if (this.IcR != null) {
        paramVarArgs.g(10, this.IcR);
      }
      paramVarArgs.bS(11, this.IcS);
      AppMethodBeat.o(275457);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label880;
      }
    }
    label880:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vgX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vgX);
      }
      i = paramInt;
      if (this.vhx != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.vhx);
      }
      paramInt = i;
      if (this.IcN != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IcN);
      }
      i = paramInt;
      if (this.IcO != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IcO);
      }
      paramInt = i;
      if (this.IcP != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IcP);
      }
      i = paramInt;
      if (this.IcK != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.IcK);
      }
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.oOI);
      }
      i = paramInt;
      if (this.IcQ != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.IcQ);
      }
      paramInt = i;
      if (this.IcR != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.IcR);
      }
      i = i.a.a.b.b.a.cJ(11, this.IcS);
      AppMethodBeat.o(275457);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275457);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275457);
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
            locale.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(275457);
          return 0;
        case 2: 
          locale.vgX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275457);
          return 0;
        case 3: 
          locale.vhx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275457);
          return 0;
        case 4: 
          locale.IcN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275457);
          return 0;
        case 5: 
          locale.IcO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275457);
          return 0;
        case 6: 
          locale.IcP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275457);
          return 0;
        case 7: 
          locale.IcK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275457);
          return 0;
        case 8: 
          locale.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275457);
          return 0;
        case 9: 
          locale.IcQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275457);
          return 0;
        case 10: 
          locale.IcR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275457);
          return 0;
        }
        locale.IcS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(275457);
        return 0;
      }
      AppMethodBeat.o(275457);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.e
 * JD-Core Version:    0.7.0.1
 */