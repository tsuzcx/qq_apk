package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bx.a
{
  public String Version;
  public String nDN;
  public String nDO;
  public String nDP;
  public String nDQ;
  public long nDR;
  public long nDS;
  public String nDT;
  public com.tencent.mm.bx.b nDU;
  public com.tencent.mm.bx.b nDV;
  public String nDt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22121);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDN == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatVersion");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.nDO == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatUserID");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.nDP == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatNickName");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.nDQ == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatInstallDir");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.nDT == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Manufacturer");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.nDt == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Model");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.Version == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Version");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.nDN != null) {
        paramVarArgs.d(1, this.nDN);
      }
      if (this.nDO != null) {
        paramVarArgs.d(2, this.nDO);
      }
      if (this.nDP != null) {
        paramVarArgs.d(3, this.nDP);
      }
      if (this.nDQ != null) {
        paramVarArgs.d(4, this.nDQ);
      }
      paramVarArgs.aY(5, this.nDR);
      paramVarArgs.aY(6, this.nDS);
      if (this.nDT != null) {
        paramVarArgs.d(7, this.nDT);
      }
      if (this.nDt != null) {
        paramVarArgs.d(8, this.nDt);
      }
      if (this.Version != null) {
        paramVarArgs.d(9, this.Version);
      }
      if (this.nDU != null) {
        paramVarArgs.c(10, this.nDU);
      }
      if (this.nDV != null) {
        paramVarArgs.c(11, this.nDV);
      }
      AppMethodBeat.o(22121);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDN == null) {
        break label1159;
      }
    }
    label1159:
    for (int i = f.a.a.b.b.a.e(1, this.nDN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nDO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDO);
      }
      i = paramInt;
      if (this.nDP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nDP);
      }
      paramInt = i;
      if (this.nDQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nDQ);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.nDR) + f.a.a.b.b.a.p(6, this.nDS);
      paramInt = i;
      if (this.nDT != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nDT);
      }
      i = paramInt;
      if (this.nDt != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.nDt);
      }
      paramInt = i;
      if (this.Version != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Version);
      }
      i = paramInt;
      if (this.nDU != null) {
        i = paramInt + f.a.a.b.b.a.b(10, this.nDU);
      }
      paramInt = i;
      if (this.nDV != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.nDV);
      }
      AppMethodBeat.o(22121);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.nDN == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatVersion");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.nDO == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatUserID");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.nDP == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatNickName");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.nDQ == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatInstallDir");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.nDT == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Manufacturer");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.nDt == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Model");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.Version == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Version");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22121);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22121);
          return -1;
        case 1: 
          localq.nDN = locala.NPN.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 2: 
          localq.nDO = locala.NPN.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 3: 
          localq.nDP = locala.NPN.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 4: 
          localq.nDQ = locala.NPN.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 5: 
          localq.nDR = locala.NPN.zd();
          AppMethodBeat.o(22121);
          return 0;
        case 6: 
          localq.nDS = locala.NPN.zd();
          AppMethodBeat.o(22121);
          return 0;
        case 7: 
          localq.nDT = locala.NPN.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 8: 
          localq.nDt = locala.NPN.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 9: 
          localq.Version = locala.NPN.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 10: 
          localq.nDU = locala.NPN.gxI();
          AppMethodBeat.o(22121);
          return 0;
        }
        localq.nDV = locala.NPN.gxI();
        AppMethodBeat.o(22121);
        return 0;
      }
      AppMethodBeat.o(22121);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.q
 * JD-Core Version:    0.7.0.1
 */