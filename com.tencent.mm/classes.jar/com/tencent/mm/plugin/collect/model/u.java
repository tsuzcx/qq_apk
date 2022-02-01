package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class u
  extends com.tencent.mm.bx.a
{
  public String dcF;
  public String dem;
  public String fyo;
  public int msgType;
  public double nUf;
  public int nUh;
  public String nUi;
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
      if (this.dcF == null)
      {
        paramVarArgs = new b("Not all required fields were included: transactionId");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.dem == null)
      {
        paramVarArgs = new b("Not all required fields were included: feeType");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.dcF != null) {
        paramVarArgs.d(2, this.dcF);
      }
      paramVarArgs.e(3, this.nUf);
      if (this.dem != null) {
        paramVarArgs.d(4, this.dem);
      }
      paramVarArgs.aR(5, this.nUh);
      paramVarArgs.aR(6, this.scene);
      paramVarArgs.aR(7, this.status);
      if (this.fyo != null) {
        paramVarArgs.d(8, this.fyo);
      }
      if (this.nUi != null) {
        paramVarArgs.d(9, this.nUi);
      }
      paramVarArgs.aR(10, this.msgType);
      if (this.type != null) {
        paramVarArgs.d(11, this.type);
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
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dcF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dcF);
      }
      i += f.a.a.b.b.a.fY(3) + 8;
      paramInt = i;
      if (this.dem != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dem);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.nUh) + f.a.a.b.b.a.bA(6, this.scene) + f.a.a.b.b.a.bA(7, this.status);
      paramInt = i;
      if (this.fyo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.fyo);
      }
      i = paramInt;
      if (this.nUi != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.nUi);
      }
      i += f.a.a.b.b.a.bA(10, this.msgType);
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
            paramVarArgs.fMq();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.dcF == null)
        {
          paramVarArgs = new b("Not all required fields were included: transactionId");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.dem == null)
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
          localu.username = locala.KhF.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 2: 
          localu.dcF = locala.KhF.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 3: 
          localu.nUf = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(91250);
          return 0;
        case 4: 
          localu.dem = locala.KhF.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 5: 
          localu.nUh = locala.KhF.xS();
          AppMethodBeat.o(91250);
          return 0;
        case 6: 
          localu.scene = locala.KhF.xS();
          AppMethodBeat.o(91250);
          return 0;
        case 7: 
          localu.status = locala.KhF.xS();
          AppMethodBeat.o(91250);
          return 0;
        case 8: 
          localu.fyo = locala.KhF.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 9: 
          localu.nUi = locala.KhF.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 10: 
          localu.msgType = locala.KhF.xS();
          AppMethodBeat.o(91250);
          return 0;
        }
        localu.type = locala.KhF.readString();
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