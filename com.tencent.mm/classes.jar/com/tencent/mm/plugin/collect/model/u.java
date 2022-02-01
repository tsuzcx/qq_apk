package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class u
  extends com.tencent.mm.bw.a
{
  public String dDM;
  public String dFv;
  public String gCv;
  public int msgType;
  public double qwJ;
  public int qwL;
  public String qwM;
  public int scene;
  public int status;
  public String type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91250);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.dDM == null)
      {
        paramVarArgs = new b("Not all required fields were included: transactionId");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.dFv == null)
      {
        paramVarArgs = new b("Not all required fields were included: feeType");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.dDM != null) {
        paramVarArgs.e(2, this.dDM);
      }
      paramVarArgs.e(3, this.qwJ);
      if (this.dFv != null) {
        paramVarArgs.e(4, this.dFv);
      }
      paramVarArgs.aM(5, this.qwL);
      paramVarArgs.aM(6, this.scene);
      paramVarArgs.aM(7, this.status);
      if (this.gCv != null) {
        paramVarArgs.e(8, this.gCv);
      }
      if (this.qwM != null) {
        paramVarArgs.e(9, this.qwM);
      }
      paramVarArgs.aM(10, this.msgType);
      if (this.type != null) {
        paramVarArgs.e(11, this.type);
      }
      AppMethodBeat.o(91250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label889;
      }
    }
    label889:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dDM != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dDM);
      }
      i += g.a.a.b.b.a.fS(3) + 8;
      paramInt = i;
      if (this.dFv != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dFv);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.qwL) + g.a.a.b.b.a.bu(6, this.scene) + g.a.a.b.b.a.bu(7, this.status);
      paramInt = i;
      if (this.gCv != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.gCv);
      }
      i = paramInt;
      if (this.qwM != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.qwM);
      }
      i += g.a.a.b.b.a.bu(10, this.msgType);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.type);
      }
      AppMethodBeat.o(91250);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.dDM == null)
        {
          paramVarArgs = new b("Not all required fields were included: transactionId");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.dFv == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        u localu = (u)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91250);
          return -1;
        case 1: 
          localu.username = locala.UbS.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 2: 
          localu.dDM = locala.UbS.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 3: 
          localu.qwJ = Double.longBitsToDouble(locala.UbS.zn());
          AppMethodBeat.o(91250);
          return 0;
        case 4: 
          localu.dFv = locala.UbS.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 5: 
          localu.qwL = locala.UbS.zi();
          AppMethodBeat.o(91250);
          return 0;
        case 6: 
          localu.scene = locala.UbS.zi();
          AppMethodBeat.o(91250);
          return 0;
        case 7: 
          localu.status = locala.UbS.zi();
          AppMethodBeat.o(91250);
          return 0;
        case 8: 
          localu.gCv = locala.UbS.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 9: 
          localu.qwM = locala.UbS.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 10: 
          localu.msgType = locala.UbS.zi();
          AppMethodBeat.o(91250);
          return 0;
        }
        localu.type = locala.UbS.readString();
        AppMethodBeat.o(91250);
        return 0;
      }
      AppMethodBeat.o(91250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.u
 * JD-Core Version:    0.7.0.1
 */