package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class m
  extends com.tencent.mm.bv.a
{
  public String jJD;
  public String jJE;
  public String jJF;
  public String jJG;
  public String jJH;
  public int jJI;
  public long jJJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18060);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJD == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceID");
        AppMethodBeat.o(18060);
        throw paramVarArgs;
      }
      if (this.jJE == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceName");
        AppMethodBeat.o(18060);
        throw paramVarArgs;
      }
      if (this.jJF == null)
      {
        paramVarArgs = new b("Not all required fields were included: Model");
        AppMethodBeat.o(18060);
        throw paramVarArgs;
      }
      if (this.jJG == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemName");
        AppMethodBeat.o(18060);
        throw paramVarArgs;
      }
      if (this.jJH == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemVersion");
        AppMethodBeat.o(18060);
        throw paramVarArgs;
      }
      if (this.jJD != null) {
        paramVarArgs.e(1, this.jJD);
      }
      if (this.jJE != null) {
        paramVarArgs.e(2, this.jJE);
      }
      if (this.jJF != null) {
        paramVarArgs.e(3, this.jJF);
      }
      if (this.jJG != null) {
        paramVarArgs.e(4, this.jJG);
      }
      if (this.jJH != null) {
        paramVarArgs.e(5, this.jJH);
      }
      paramVarArgs.aO(6, this.jJI);
      paramVarArgs.am(7, this.jJJ);
      AppMethodBeat.o(18060);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJD == null) {
        break label811;
      }
    }
    label811:
    for (int i = e.a.a.b.b.a.f(1, this.jJD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jJE != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jJE);
      }
      i = paramInt;
      if (this.jJF != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.jJF);
      }
      paramInt = i;
      if (this.jJG != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.jJG);
      }
      i = paramInt;
      if (this.jJH != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.jJH);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.jJI);
      int j = e.a.a.b.b.a.p(7, this.jJJ);
      AppMethodBeat.o(18060);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.jJD == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceID");
          AppMethodBeat.o(18060);
          throw paramVarArgs;
        }
        if (this.jJE == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceName");
          AppMethodBeat.o(18060);
          throw paramVarArgs;
        }
        if (this.jJF == null)
        {
          paramVarArgs = new b("Not all required fields were included: Model");
          AppMethodBeat.o(18060);
          throw paramVarArgs;
        }
        if (this.jJG == null)
        {
          paramVarArgs = new b("Not all required fields were included: SystemName");
          AppMethodBeat.o(18060);
          throw paramVarArgs;
        }
        if (this.jJH == null)
        {
          paramVarArgs = new b("Not all required fields were included: SystemVersion");
          AppMethodBeat.o(18060);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18060);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(18060);
          return -1;
        case 1: 
          localm.jJD = locala.CLY.readString();
          AppMethodBeat.o(18060);
          return 0;
        case 2: 
          localm.jJE = locala.CLY.readString();
          AppMethodBeat.o(18060);
          return 0;
        case 3: 
          localm.jJF = locala.CLY.readString();
          AppMethodBeat.o(18060);
          return 0;
        case 4: 
          localm.jJG = locala.CLY.readString();
          AppMethodBeat.o(18060);
          return 0;
        case 5: 
          localm.jJH = locala.CLY.readString();
          AppMethodBeat.o(18060);
          return 0;
        case 6: 
          localm.jJI = locala.CLY.sl();
          AppMethodBeat.o(18060);
          return 0;
        }
        localm.jJJ = locala.CLY.sm();
        AppMethodBeat.o(18060);
        return 0;
      }
      AppMethodBeat.o(18060);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.m
 * JD-Core Version:    0.7.0.1
 */