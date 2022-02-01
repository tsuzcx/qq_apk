package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class u
  extends com.tencent.mm.bw.a
{
  public String dad;
  public String dbI;
  public String fBV;
  public int msgType;
  public double oxA;
  public int oxC;
  public String oxD;
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
      if (this.dad == null)
      {
        paramVarArgs = new b("Not all required fields were included: transactionId");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.dbI == null)
      {
        paramVarArgs = new b("Not all required fields were included: feeType");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.dad != null) {
        paramVarArgs.d(2, this.dad);
      }
      paramVarArgs.e(3, this.oxA);
      if (this.dbI != null) {
        paramVarArgs.d(4, this.dbI);
      }
      paramVarArgs.aR(5, this.oxC);
      paramVarArgs.aR(6, this.scene);
      paramVarArgs.aR(7, this.status);
      if (this.fBV != null) {
        paramVarArgs.d(8, this.fBV);
      }
      if (this.oxD != null) {
        paramVarArgs.d(9, this.oxD);
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
      if (this.dad != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dad);
      }
      i += f.a.a.b.b.a.fK(3) + 8;
      paramInt = i;
      if (this.dbI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dbI);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.oxC) + f.a.a.b.b.a.bx(6, this.scene) + f.a.a.b.b.a.bx(7, this.status);
      paramInt = i;
      if (this.fBV != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.fBV);
      }
      i = paramInt;
      if (this.oxD != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.oxD);
      }
      i += f.a.a.b.b.a.bx(10, this.msgType);
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
            paramVarArgs.gfg();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.dad == null)
        {
          paramVarArgs = new b("Not all required fields were included: transactionId");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.dbI == null)
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
          localu.username = locala.LVo.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 2: 
          localu.dad = locala.LVo.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 3: 
          localu.oxA = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(91250);
          return 0;
        case 4: 
          localu.dbI = locala.LVo.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 5: 
          localu.oxC = locala.LVo.xF();
          AppMethodBeat.o(91250);
          return 0;
        case 6: 
          localu.scene = locala.LVo.xF();
          AppMethodBeat.o(91250);
          return 0;
        case 7: 
          localu.status = locala.LVo.xF();
          AppMethodBeat.o(91250);
          return 0;
        case 8: 
          localu.fBV = locala.LVo.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 9: 
          localu.oxD = locala.LVo.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 10: 
          localu.msgType = locala.LVo.xF();
          AppMethodBeat.o(91250);
          return 0;
        }
        localu.type = locala.LVo.readString();
        AppMethodBeat.o(91250);
        return 0;
      }
      AppMethodBeat.o(91250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.u
 * JD-Core Version:    0.7.0.1
 */