package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public class t
  extends com.tencent.mm.bv.a
{
  public String cnJ;
  public String cpp;
  public String elx;
  public double kNS;
  public String kNU;
  public int msgType;
  public int scene;
  public int status;
  public int timestamp;
  public String type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56607);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(56607);
        throw paramVarArgs;
      }
      if (this.cnJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: transactionId");
        AppMethodBeat.o(56607);
        throw paramVarArgs;
      }
      if (this.cpp == null)
      {
        paramVarArgs = new b("Not all required fields were included: feeType");
        AppMethodBeat.o(56607);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.cnJ != null) {
        paramVarArgs.e(2, this.cnJ);
      }
      paramVarArgs.f(3, this.kNS);
      if (this.cpp != null) {
        paramVarArgs.e(4, this.cpp);
      }
      paramVarArgs.aO(5, this.timestamp);
      paramVarArgs.aO(6, this.scene);
      paramVarArgs.aO(7, this.status);
      if (this.elx != null) {
        paramVarArgs.e(8, this.elx);
      }
      if (this.kNU != null) {
        paramVarArgs.e(9, this.kNU);
      }
      paramVarArgs.aO(10, this.msgType);
      if (this.type != null) {
        paramVarArgs.e(11, this.type);
      }
      AppMethodBeat.o(56607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label889;
      }
    }
    label889:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cnJ != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.cnJ);
      }
      i += e.a.a.b.b.a.eW(3) + 8;
      paramInt = i;
      if (this.cpp != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.cpp);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.timestamp) + e.a.a.b.b.a.bl(6, this.scene) + e.a.a.b.b.a.bl(7, this.status);
      paramInt = i;
      if (this.elx != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.elx);
      }
      i = paramInt;
      if (this.kNU != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.kNU);
      }
      i += e.a.a.b.b.a.bl(10, this.msgType);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.type);
      }
      AppMethodBeat.o(56607);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(56607);
          throw paramVarArgs;
        }
        if (this.cnJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: transactionId");
          AppMethodBeat.o(56607);
          throw paramVarArgs;
        }
        if (this.cpp == null)
        {
          paramVarArgs = new b("Not all required fields were included: feeType");
          AppMethodBeat.o(56607);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56607);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56607);
          return -1;
        case 1: 
          localt.username = locala.CLY.readString();
          AppMethodBeat.o(56607);
          return 0;
        case 2: 
          localt.cnJ = locala.CLY.readString();
          AppMethodBeat.o(56607);
          return 0;
        case 3: 
          localt.kNS = Double.longBitsToDouble(locala.CLY.emy());
          AppMethodBeat.o(56607);
          return 0;
        case 4: 
          localt.cpp = locala.CLY.readString();
          AppMethodBeat.o(56607);
          return 0;
        case 5: 
          localt.timestamp = locala.CLY.sl();
          AppMethodBeat.o(56607);
          return 0;
        case 6: 
          localt.scene = locala.CLY.sl();
          AppMethodBeat.o(56607);
          return 0;
        case 7: 
          localt.status = locala.CLY.sl();
          AppMethodBeat.o(56607);
          return 0;
        case 8: 
          localt.elx = locala.CLY.readString();
          AppMethodBeat.o(56607);
          return 0;
        case 9: 
          localt.kNU = locala.CLY.readString();
          AppMethodBeat.o(56607);
          return 0;
        case 10: 
          localt.msgType = locala.CLY.sl();
          AppMethodBeat.o(56607);
          return 0;
        }
        localt.type = locala.CLY.readString();
        AppMethodBeat.o(56607);
        return 0;
      }
      AppMethodBeat.o(56607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.t
 * JD-Core Version:    0.7.0.1
 */