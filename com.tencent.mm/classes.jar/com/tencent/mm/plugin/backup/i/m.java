package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class m
  extends com.tencent.mm.bw.a
{
  public String nIM;
  public String nIN;
  public String nIO;
  public String nIP;
  public String nIQ;
  public int nIR;
  public long nIS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22117);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIM == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceID");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.nIN == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.nIO == null)
      {
        paramVarArgs = new b("Not all required fields were included: Model");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.nIP == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.nIQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemVersion");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.nIM != null) {
        paramVarArgs.d(1, this.nIM);
      }
      if (this.nIN != null) {
        paramVarArgs.d(2, this.nIN);
      }
      if (this.nIO != null) {
        paramVarArgs.d(3, this.nIO);
      }
      if (this.nIP != null) {
        paramVarArgs.d(4, this.nIP);
      }
      if (this.nIQ != null) {
        paramVarArgs.d(5, this.nIQ);
      }
      paramVarArgs.aS(6, this.nIR);
      paramVarArgs.aZ(7, this.nIS);
      AppMethodBeat.o(22117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIM == null) {
        break label811;
      }
    }
    label811:
    for (int i = f.a.a.b.b.a.e(1, this.nIM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nIN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIN);
      }
      i = paramInt;
      if (this.nIO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nIO);
      }
      paramInt = i;
      if (this.nIP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nIP);
      }
      i = paramInt;
      if (this.nIQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nIQ);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.nIR);
      int j = f.a.a.b.b.a.p(7, this.nIS);
      AppMethodBeat.o(22117);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.nIM == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceID");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.nIN == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.nIO == null)
        {
          paramVarArgs = new b("Not all required fields were included: Model");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.nIP == null)
        {
          paramVarArgs = new b("Not all required fields were included: SystemName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.nIQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: SystemVersion");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22117);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22117);
          return -1;
        case 1: 
          localm.nIM = locala.OmT.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 2: 
          localm.nIN = locala.OmT.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 3: 
          localm.nIO = locala.OmT.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 4: 
          localm.nIP = locala.OmT.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 5: 
          localm.nIQ = locala.OmT.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 6: 
          localm.nIR = locala.OmT.zc();
          AppMethodBeat.o(22117);
          return 0;
        }
        localm.nIS = locala.OmT.zd();
        AppMethodBeat.o(22117);
        return 0;
      }
      AppMethodBeat.o(22117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.m
 * JD-Core Version:    0.7.0.1
 */