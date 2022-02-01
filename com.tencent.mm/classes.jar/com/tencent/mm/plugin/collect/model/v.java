package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class v
  extends com.tencent.mm.cd.a
{
  public int dXr;
  public String fww;
  public String fyc;
  public String jmB;
  public int msgType;
  public int scene;
  public int status;
  public double tVK;
  public String tVM;
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
      if (this.fww == null)
      {
        paramVarArgs = new b("Not all required fields were included: transactionId");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.fyc == null)
      {
        paramVarArgs = new b("Not all required fields were included: feeType");
        AppMethodBeat.o(91250);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.fww != null) {
        paramVarArgs.f(2, this.fww);
      }
      paramVarArgs.e(3, this.tVK);
      if (this.fyc != null) {
        paramVarArgs.f(4, this.fyc);
      }
      paramVarArgs.aY(5, this.dXr);
      paramVarArgs.aY(6, this.scene);
      paramVarArgs.aY(7, this.status);
      if (this.jmB != null) {
        paramVarArgs.f(8, this.jmB);
      }
      if (this.tVM != null) {
        paramVarArgs.f(9, this.tVM);
      }
      paramVarArgs.aY(10, this.msgType);
      if (this.type != null) {
        paramVarArgs.f(11, this.type);
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
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fww != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.fww);
      }
      i += g.a.a.b.b.a.gL(3) + 8;
      paramInt = i;
      if (this.fyc != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.fyc);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.dXr) + g.a.a.b.b.a.bM(6, this.scene) + g.a.a.b.b.a.bM(7, this.status);
      paramInt = i;
      if (this.jmB != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.jmB);
      }
      i = paramInt;
      if (this.tVM != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.tVM);
      }
      i += g.a.a.b.b.a.bM(10, this.msgType);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.type);
      }
      AppMethodBeat.o(91250);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.fww == null)
        {
          paramVarArgs = new b("Not all required fields were included: transactionId");
          AppMethodBeat.o(91250);
          throw paramVarArgs;
        }
        if (this.fyc == null)
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
        v localv = (v)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91250);
          return -1;
        case 1: 
          localv.username = locala.abFh.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 2: 
          localv.fww = locala.abFh.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 3: 
          localv.tVK = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(91250);
          return 0;
        case 4: 
          localv.fyc = locala.abFh.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 5: 
          localv.dXr = locala.abFh.AK();
          AppMethodBeat.o(91250);
          return 0;
        case 6: 
          localv.scene = locala.abFh.AK();
          AppMethodBeat.o(91250);
          return 0;
        case 7: 
          localv.status = locala.abFh.AK();
          AppMethodBeat.o(91250);
          return 0;
        case 8: 
          localv.jmB = locala.abFh.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 9: 
          localv.tVM = locala.abFh.readString();
          AppMethodBeat.o(91250);
          return 0;
        case 10: 
          localv.msgType = locala.abFh.AK();
          AppMethodBeat.o(91250);
          return 0;
        }
        localv.type = locala.abFh.readString();
        AppMethodBeat.o(91250);
        return 0;
      }
      AppMethodBeat.o(91250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.v
 * JD-Core Version:    0.7.0.1
 */