package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class m
  extends com.tencent.mm.bx.a
{
  public String vgV;
  public String vgW;
  public String vgX;
  public String vgY;
  public String vgZ;
  public int vha;
  public long vhb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22117);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgV == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceID");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.vgW == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.vgX == null)
      {
        paramVarArgs = new b("Not all required fields were included: Model");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.vgY == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.vgZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemVersion");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.vgV != null) {
        paramVarArgs.g(1, this.vgV);
      }
      if (this.vgW != null) {
        paramVarArgs.g(2, this.vgW);
      }
      if (this.vgX != null) {
        paramVarArgs.g(3, this.vgX);
      }
      if (this.vgY != null) {
        paramVarArgs.g(4, this.vgY);
      }
      if (this.vgZ != null) {
        paramVarArgs.g(5, this.vgZ);
      }
      paramVarArgs.bS(6, this.vha);
      paramVarArgs.bv(7, this.vhb);
      AppMethodBeat.o(22117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vgV == null) {
        break label807;
      }
    }
    label807:
    for (int i = i.a.a.b.b.a.h(1, this.vgV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vgW != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vgW);
      }
      i = paramInt;
      if (this.vgX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.vgX);
      }
      paramInt = i;
      if (this.vgY != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.vgY);
      }
      i = paramInt;
      if (this.vgZ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.vgZ);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.vha);
      int j = i.a.a.b.b.a.q(7, this.vhb);
      AppMethodBeat.o(22117);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.vgV == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceID");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.vgW == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.vgX == null)
        {
          paramVarArgs = new b("Not all required fields were included: Model");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.vgY == null)
        {
          paramVarArgs = new b("Not all required fields were included: SystemName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.vgZ == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22117);
          return -1;
        case 1: 
          localm.vgV = locala.ajGk.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 2: 
          localm.vgW = locala.ajGk.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 3: 
          localm.vgX = locala.ajGk.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 4: 
          localm.vgY = locala.ajGk.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 5: 
          localm.vgZ = locala.ajGk.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 6: 
          localm.vha = locala.ajGk.aar();
          AppMethodBeat.o(22117);
          return 0;
        }
        localm.vhb = locala.ajGk.aaw();
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