package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public String apkMd5;
  public int autoAddAccount;
  public int channelId;
  public String dji;
  public String djj;
  public boolean djk;
  public boolean djl;
  public String profileDeviceType;
  public int updateMode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(944);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.apkMd5 == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: apkMd5");
        AppMethodBeat.o(944);
        throw paramVarArgs;
      }
      if (this.apkMd5 != null) {
        paramVarArgs.e(1, this.apkMd5);
      }
      paramVarArgs.aM(2, this.channelId);
      if (this.profileDeviceType != null) {
        paramVarArgs.e(3, this.profileDeviceType);
      }
      paramVarArgs.aM(4, this.updateMode);
      if (this.dji != null) {
        paramVarArgs.e(5, this.dji);
      }
      if (this.djj != null) {
        paramVarArgs.e(6, this.djj);
      }
      paramVarArgs.cc(7, this.djk);
      paramVarArgs.aM(8, this.autoAddAccount);
      paramVarArgs.cc(9, this.djl);
      AppMethodBeat.o(944);
      return 0;
    }
    if (paramInt == 1) {
      if (this.apkMd5 == null) {
        break label685;
      }
    }
    label685:
    for (paramInt = g.a.a.b.b.a.f(1, this.apkMd5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.channelId);
      paramInt = i;
      if (this.profileDeviceType != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.profileDeviceType);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.updateMode);
      paramInt = i;
      if (this.dji != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.dji);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.djj);
      }
      paramInt = g.a.a.b.b.a.fS(7);
      int j = g.a.a.b.b.a.bu(8, this.autoAddAccount);
      int k = g.a.a.b.b.a.fS(9);
      AppMethodBeat.o(944);
      return i + (paramInt + 1) + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs);; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs))
        {
          if (paramInt <= 0)
          {
            if (this.apkMd5 != null) {
              break;
            }
            paramVarArgs = new g.a.a.b("Not all required fields were included: apkMd5");
            AppMethodBeat.o(944);
            throw paramVarArgs;
          }
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(944);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(944);
          return -1;
        case 1: 
          localb.apkMd5 = locala.UbS.readString();
          AppMethodBeat.o(944);
          return 0;
        case 2: 
          localb.channelId = locala.UbS.zi();
          AppMethodBeat.o(944);
          return 0;
        case 3: 
          localb.profileDeviceType = locala.UbS.readString();
          AppMethodBeat.o(944);
          return 0;
        case 4: 
          localb.updateMode = locala.UbS.zi();
          AppMethodBeat.o(944);
          return 0;
        case 5: 
          localb.dji = locala.UbS.readString();
          AppMethodBeat.o(944);
          return 0;
        case 6: 
          localb.djj = locala.UbS.readString();
          AppMethodBeat.o(944);
          return 0;
        case 7: 
          localb.djk = locala.UbS.yZ();
          AppMethodBeat.o(944);
          return 0;
        case 8: 
          localb.autoAddAccount = locala.UbS.zi();
          AppMethodBeat.o(944);
          return 0;
        }
        localb.djl = locala.UbS.yZ();
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