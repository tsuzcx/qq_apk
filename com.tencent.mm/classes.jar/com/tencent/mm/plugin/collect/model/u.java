package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class u
  extends com.tencent.mm.bw.a
{
  public String dmx;
  public String dog;
  public String fXp;
  public int msgType;
  public int phB;
  public String phC;
  public double phz;
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
      if (this.dmx == null)
      {
        paramVarArgs = new b("Not all required fields were included: transactionId");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.dog == null)
      {
        paramVarArgs = new b("Not all required fields were included: feeType");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.dmx != null) {
        paramVarArgs.d(2, this.dmx);
      }
      paramVarArgs.e(3, this.phz);
      if (this.dog != null) {
        paramVarArgs.d(4, this.dog);
      }
      paramVarArgs.aS(5, this.phB);
      paramVarArgs.aS(6, this.scene);
      paramVarArgs.aS(7, this.status);
      if (this.fXp != null) {
        paramVarArgs.d(8, this.fXp);
      }
      if (this.phC != null) {
        paramVarArgs.d(9, this.phC);
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
      if (this.dmx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dmx);
      }
      i += f.a.a.b.b.a.amD(3);
      paramInt = i;
      if (this.dog != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dog);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.phB) + f.a.a.b.b.a.bz(6, this.scene) + f.a.a.b.b.a.bz(7, this.status);
      paramInt = i;
      if (this.fXp != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.fXp);
      }
      i = paramInt;
      if (this.phC != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.phC);
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
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.dmx == null)
        {
          paramVarArgs = new b("Not all required fields were included: transactionId");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.dog == null)
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
          localu.username = locala.OmT.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 2: 
          localu.dmx = locala.OmT.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 3: 
          localu.phz = Double.longBitsToDouble(locala.OmT.gwc());
          AppMethodBeat.o(91250);
          return 0;
        case 4: 
          localu.dog = locala.OmT.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 5: 
          localu.phB = locala.OmT.zc();
          AppMethodBeat.o(91250);
          return 0;
        case 6: 
          localu.scene = locala.OmT.zc();
          AppMethodBeat.o(91250);
          return 0;
        case 7: 
          localu.status = locala.OmT.zc();
          AppMethodBeat.o(91250);
          return 0;
        case 8: 
          localu.fXp = locala.OmT.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 9: 
          localu.phC = locala.OmT.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 10: 
          localu.msgType = locala.OmT.zc();
          AppMethodBeat.o(91250);
          return 0;
        }
        localu.type = locala.OmT.readString();
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