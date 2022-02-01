package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public class t
  extends com.tencent.mm.bx.a
{
  public String displayName;
  public int fZW;
  public String hAU;
  public String hCH;
  public int msgType;
  public int scene;
  public int status;
  public String type;
  public String username;
  public double wZe;
  public String wZg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91250);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.hAU == null)
      {
        paramVarArgs = new b("Not all required fields were included: transactionId");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.hCH == null)
      {
        paramVarArgs = new b("Not all required fields were included: feeType");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.hAU != null) {
        paramVarArgs.g(2, this.hAU);
      }
      paramVarArgs.d(3, this.wZe);
      if (this.hCH != null) {
        paramVarArgs.g(4, this.hCH);
      }
      paramVarArgs.bS(5, this.fZW);
      paramVarArgs.bS(6, this.scene);
      paramVarArgs.bS(7, this.status);
      if (this.displayName != null) {
        paramVarArgs.g(8, this.displayName);
      }
      if (this.wZg != null) {
        paramVarArgs.g(9, this.wZg);
      }
      paramVarArgs.bS(10, this.msgType);
      if (this.type != null) {
        paramVarArgs.g(11, this.type);
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
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hAU != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.hAU);
      }
      i += i.a.a.b.b.a.ko(3) + 8;
      paramInt = i;
      if (this.hCH != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hCH);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.fZW) + i.a.a.b.b.a.cJ(6, this.scene) + i.a.a.b.b.a.cJ(7, this.status);
      paramInt = i;
      if (this.displayName != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.displayName);
      }
      i = paramInt;
      if (this.wZg != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.wZg);
      }
      i += i.a.a.b.b.a.cJ(10, this.msgType);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.type);
      }
      AppMethodBeat.o(91250);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.hAU == null)
        {
          paramVarArgs = new b("Not all required fields were included: transactionId");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.hCH == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91250);
          return -1;
        case 1: 
          localt.username = locala.ajGk.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 2: 
          localt.hAU = locala.ajGk.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 3: 
          localt.wZe = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(91250);
          return 0;
        case 4: 
          localt.hCH = locala.ajGk.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 5: 
          localt.fZW = locala.ajGk.aar();
          AppMethodBeat.o(91250);
          return 0;
        case 6: 
          localt.scene = locala.ajGk.aar();
          AppMethodBeat.o(91250);
          return 0;
        case 7: 
          localt.status = locala.ajGk.aar();
          AppMethodBeat.o(91250);
          return 0;
        case 8: 
          localt.displayName = locala.ajGk.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 9: 
          localt.wZg = locala.ajGk.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 10: 
          localt.msgType = locala.ajGk.aar();
          AppMethodBeat.o(91250);
          return 0;
        }
        localt.type = locala.ajGk.readString();
        AppMethodBeat.o(91250);
        return 0;
      }
      AppMethodBeat.o(91250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.t
 * JD-Core Version:    0.7.0.1
 */