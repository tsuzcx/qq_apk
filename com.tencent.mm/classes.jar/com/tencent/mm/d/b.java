package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public String apkMd5;
  public int autoAddAccount;
  public int channelId;
  public String hep;
  public String heq;
  public boolean her;
  public boolean hes;
  public String profileDeviceType;
  public int updateMode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(944);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.apkMd5 == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: apkMd5");
        AppMethodBeat.o(944);
        throw paramVarArgs;
      }
      if (this.apkMd5 != null) {
        paramVarArgs.g(1, this.apkMd5);
      }
      paramVarArgs.bS(2, this.channelId);
      if (this.profileDeviceType != null) {
        paramVarArgs.g(3, this.profileDeviceType);
      }
      paramVarArgs.bS(4, this.updateMode);
      if (this.hep != null) {
        paramVarArgs.g(5, this.hep);
      }
      if (this.heq != null) {
        paramVarArgs.g(6, this.heq);
      }
      paramVarArgs.di(7, this.her);
      paramVarArgs.bS(8, this.autoAddAccount);
      paramVarArgs.di(9, this.hes);
      AppMethodBeat.o(944);
      return 0;
    }
    if (paramInt == 1) {
      if (this.apkMd5 == null) {
        break label685;
      }
    }
    label685:
    for (paramInt = i.a.a.b.b.a.h(1, this.apkMd5) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.channelId);
      paramInt = i;
      if (this.profileDeviceType != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.profileDeviceType);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.updateMode);
      paramInt = i;
      if (this.hep != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.hep);
      }
      i = paramInt;
      if (this.heq != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.heq);
      }
      paramInt = i.a.a.b.b.a.ko(7);
      int j = i.a.a.b.b.a.cJ(8, this.autoAddAccount);
      int k = i.a.a.b.b.a.ko(9);
      AppMethodBeat.o(944);
      return i + (paramInt + 1) + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.apkMd5 == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: apkMd5");
          AppMethodBeat.o(944);
          throw paramVarArgs;
        }
        AppMethodBeat.o(944);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(944);
          return -1;
        case 1: 
          localb.apkMd5 = locala.ajGk.readString();
          AppMethodBeat.o(944);
          return 0;
        case 2: 
          localb.channelId = locala.ajGk.aar();
          AppMethodBeat.o(944);
          return 0;
        case 3: 
          localb.profileDeviceType = locala.ajGk.readString();
          AppMethodBeat.o(944);
          return 0;
        case 4: 
          localb.updateMode = locala.ajGk.aar();
          AppMethodBeat.o(944);
          return 0;
        case 5: 
          localb.hep = locala.ajGk.readString();
          AppMethodBeat.o(944);
          return 0;
        case 6: 
          localb.heq = locala.ajGk.readString();
          AppMethodBeat.o(944);
          return 0;
        case 7: 
          localb.her = locala.ajGk.aai();
          AppMethodBeat.o(944);
          return 0;
        case 8: 
          localb.autoAddAccount = locala.ajGk.aar();
          AppMethodBeat.o(944);
          return 0;
        }
        localb.hes = locala.ajGk.aai();
        AppMethodBeat.o(944);
        return 0;
      }
      AppMethodBeat.o(944);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.b
 * JD-Core Version:    0.7.0.1
 */