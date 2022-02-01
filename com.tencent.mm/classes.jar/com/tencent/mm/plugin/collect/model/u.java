package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class u
  extends com.tencent.mm.bx.a
{
  public String dlv;
  public String dne;
  public String fVj;
  public int msgType;
  public double paV;
  public int paX;
  public String paY;
  public int scene;
  public int status;
  public String type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91250);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.dlv == null)
      {
        paramVarArgs = new b("Not all required fields were included: transactionId");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.dne == null)
      {
        paramVarArgs = new b("Not all required fields were included: feeType");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.dlv != null) {
        paramVarArgs.d(2, this.dlv);
      }
      paramVarArgs.e(3, this.paV);
      if (this.dne != null) {
        paramVarArgs.d(4, this.dne);
      }
      paramVarArgs.aS(5, this.paX);
      paramVarArgs.aS(6, this.scene);
      paramVarArgs.aS(7, this.status);
      if (this.fVj != null) {
        paramVarArgs.d(8, this.fVj);
      }
      if (this.paY != null) {
        paramVarArgs.d(9, this.paY);
      }
      paramVarArgs.aS(10, this.msgType);
      if (this.type != null) {
        paramVarArgs.d(11, this.type);
      }
      AppMethodBeat.o(91250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label885;
      }
    }
    label885:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dlv != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dlv);
      }
      i += f.a.a.b.b.a.alT(3);
      paramInt = i;
      if (this.dne != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dne);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.paX) + f.a.a.b.b.a.bz(6, this.scene) + f.a.a.b.b.a.bz(7, this.status);
      paramInt = i;
      if (this.fVj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.fVj);
      }
      i = paramInt;
      if (this.paY != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.paY);
      }
      i += f.a.a.b.b.a.bz(10, this.msgType);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.type);
      }
      AppMethodBeat.o(91250);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.dlv == null)
        {
          paramVarArgs = new b("Not all required fields were included: transactionId");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.dne == null)
        {
          paramVarArgs = new b("Not all required fields were included: feeType");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91250);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        u localu = (u)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91250);
          return -1;
        case 1: 
          localu.username = locala.NPN.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 2: 
          localu.dlv = locala.NPN.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 3: 
          localu.paV = Double.longBitsToDouble(locala.NPN.grA());
          AppMethodBeat.o(91250);
          return 0;
        case 4: 
          localu.dne = locala.NPN.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 5: 
          localu.paX = locala.NPN.zc();
          AppMethodBeat.o(91250);
          return 0;
        case 6: 
          localu.scene = locala.NPN.zc();
          AppMethodBeat.o(91250);
          return 0;
        case 7: 
          localu.status = locala.NPN.zc();
          AppMethodBeat.o(91250);
          return 0;
        case 8: 
          localu.fVj = locala.NPN.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 9: 
          localu.paY = locala.NPN.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 10: 
          localu.msgType = locala.NPN.zc();
          AppMethodBeat.o(91250);
          return 0;
        }
        localu.type = locala.NPN.readString();
        AppMethodBeat.o(91250);
        return 0;
      }
      AppMethodBeat.o(91250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.u
 * JD-Core Version:    0.7.0.1
 */