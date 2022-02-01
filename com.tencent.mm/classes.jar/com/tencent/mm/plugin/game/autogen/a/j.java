package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class j
  extends erp
{
  public String IcK;
  public String IcN;
  public String IcO;
  public String IcP;
  public String IcQ;
  public String IcR;
  public int IcS;
  public String IcZ;
  public String Ida;
  public String Idb;
  public int errorCode;
  public String vgX;
  public int vhk;
  public String vhx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275463);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.IcK != null) {
        paramVarArgs.g(2, this.IcK);
      }
      paramVarArgs.bS(3, this.IcS);
      paramVarArgs.bS(4, this.vhk);
      if (this.IcZ != null) {
        paramVarArgs.g(5, this.IcZ);
      }
      if (this.Ida != null) {
        paramVarArgs.g(6, this.Ida);
      }
      if (this.Idb != null) {
        paramVarArgs.g(7, this.Idb);
      }
      paramVarArgs.bS(8, this.errorCode);
      if (this.IcP != null) {
        paramVarArgs.g(9, this.IcP);
      }
      if (this.IcO != null) {
        paramVarArgs.g(10, this.IcO);
      }
      if (this.IcN != null) {
        paramVarArgs.g(11, this.IcN);
      }
      if (this.IcQ != null) {
        paramVarArgs.g(12, this.IcQ);
      }
      if (this.IcR != null) {
        paramVarArgs.g(13, this.IcR);
      }
      if (this.vgX != null) {
        paramVarArgs.g(14, this.vgX);
      }
      if (this.vhx != null) {
        paramVarArgs.g(15, this.vhx);
      }
      AppMethodBeat.o(275463);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1096;
      }
    }
    label1096:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IcK != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IcK);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.IcS) + i.a.a.b.b.a.cJ(4, this.vhk);
      paramInt = i;
      if (this.IcZ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.IcZ);
      }
      i = paramInt;
      if (this.Ida != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Ida);
      }
      paramInt = i;
      if (this.Idb != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Idb);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.errorCode);
      paramInt = i;
      if (this.IcP != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.IcP);
      }
      i = paramInt;
      if (this.IcO != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.IcO);
      }
      paramInt = i;
      if (this.IcN != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.IcN);
      }
      i = paramInt;
      if (this.IcQ != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.IcQ);
      }
      paramInt = i;
      if (this.IcR != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.IcR);
      }
      i = paramInt;
      if (this.vgX != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.vgX);
      }
      paramInt = i;
      if (this.vhx != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.vhx);
      }
      AppMethodBeat.o(275463);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275463);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275463);
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
            localj.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(275463);
          return 0;
        case 2: 
          localj.IcK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275463);
          return 0;
        case 3: 
          localj.IcS = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(275463);
          return 0;
        case 4: 
          localj.vhk = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(275463);
          return 0;
        case 5: 
          localj.IcZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275463);
          return 0;
        case 6: 
          localj.Ida = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275463);
          return 0;
        case 7: 
          localj.Idb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275463);
          return 0;
        case 8: 
          localj.errorCode = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(275463);
          return 0;
        case 9: 
          localj.IcP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275463);
          return 0;
        case 10: 
          localj.IcO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275463);
          return 0;
        case 11: 
          localj.IcN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275463);
          return 0;
        case 12: 
          localj.IcQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275463);
          return 0;
        case 13: 
          localj.IcR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275463);
          return 0;
        case 14: 
          localj.vgX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275463);
          return 0;
        }
        localj.vhx = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(275463);
        return 0;
      }
      AppMethodBeat.o(275463);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.j
 * JD-Core Version:    0.7.0.1
 */