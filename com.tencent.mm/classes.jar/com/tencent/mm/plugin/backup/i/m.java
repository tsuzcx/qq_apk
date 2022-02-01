package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class m
  extends com.tencent.mm.bw.a
{
  public String oTH;
  public String oTI;
  public String oTJ;
  public String oTK;
  public String oTL;
  public int oTM;
  public long oTN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22117);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oTH == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceID");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.oTI == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.oTJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Model");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.oTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.oTL == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemVersion");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.oTH != null) {
        paramVarArgs.e(1, this.oTH);
      }
      if (this.oTI != null) {
        paramVarArgs.e(2, this.oTI);
      }
      if (this.oTJ != null) {
        paramVarArgs.e(3, this.oTJ);
      }
      if (this.oTK != null) {
        paramVarArgs.e(4, this.oTK);
      }
      if (this.oTL != null) {
        paramVarArgs.e(5, this.oTL);
      }
      paramVarArgs.aM(6, this.oTM);
      paramVarArgs.bb(7, this.oTN);
      AppMethodBeat.o(22117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oTH == null) {
        break label811;
      }
    }
    label811:
    for (int i = g.a.a.b.b.a.f(1, this.oTH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oTI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oTI);
      }
      i = paramInt;
      if (this.oTJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.oTJ);
      }
      paramInt = i;
      if (this.oTK != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.oTK);
      }
      i = paramInt;
      if (this.oTL != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.oTL);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.oTM);
      int j = g.a.a.b.b.a.r(7, this.oTN);
      AppMethodBeat.o(22117);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.oTH == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceID");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.oTI == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.oTJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Model");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.oTK == null)
        {
          paramVarArgs = new b("Not all required fields were included: SystemName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.oTL == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22117);
          return -1;
        case 1: 
          localm.oTH = locala.UbS.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 2: 
          localm.oTI = locala.UbS.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 3: 
          localm.oTJ = locala.UbS.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 4: 
          localm.oTK = locala.UbS.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 5: 
          localm.oTL = locala.UbS.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 6: 
          localm.oTM = locala.UbS.zi();
          AppMethodBeat.o(22117);
          return 0;
        }
        localm.oTN = locala.UbS.zl();
        AppMethodBeat.o(22117);
        return 0;
      }
      AppMethodBeat.o(22117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.m
 * JD-Core Version:    0.7.0.1
 */