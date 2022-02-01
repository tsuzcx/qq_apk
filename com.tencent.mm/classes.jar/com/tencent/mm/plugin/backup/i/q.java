package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bw.a
{
  public String Version;
  public String ncW;
  public String ndq;
  public String ndr;
  public String nds;
  public String ndt;
  public long ndu;
  public long ndv;
  public String ndw;
  public com.tencent.mm.bw.b ndx;
  public com.tencent.mm.bw.b ndy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22121);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ndq == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatVersion");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.ndr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatUserID");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.nds == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatNickName");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.ndt == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatInstallDir");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.ndw == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Manufacturer");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.ncW == null)
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
      if (this.ndq != null) {
        paramVarArgs.d(1, this.ndq);
      }
      if (this.ndr != null) {
        paramVarArgs.d(2, this.ndr);
      }
      if (this.nds != null) {
        paramVarArgs.d(3, this.nds);
      }
      if (this.ndt != null) {
        paramVarArgs.d(4, this.ndt);
      }
      paramVarArgs.aO(5, this.ndu);
      paramVarArgs.aO(6, this.ndv);
      if (this.ndw != null) {
        paramVarArgs.d(7, this.ndw);
      }
      if (this.ncW != null) {
        paramVarArgs.d(8, this.ncW);
      }
      if (this.Version != null) {
        paramVarArgs.d(9, this.Version);
      }
      if (this.ndx != null) {
        paramVarArgs.c(10, this.ndx);
      }
      if (this.ndy != null) {
        paramVarArgs.c(11, this.ndy);
      }
      AppMethodBeat.o(22121);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ndq == null) {
        break label1159;
      }
    }
    label1159:
    for (int i = f.a.a.b.b.a.e(1, this.ndq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ndr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ndr);
      }
      i = paramInt;
      if (this.nds != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nds);
      }
      paramInt = i;
      if (this.ndt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ndt);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.ndu) + f.a.a.b.b.a.p(6, this.ndv);
      paramInt = i;
      if (this.ndw != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ndw);
      }
      i = paramInt;
      if (this.ncW != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.ncW);
      }
      paramInt = i;
      if (this.Version != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Version);
      }
      i = paramInt;
      if (this.ndx != null) {
        i = paramInt + f.a.a.b.b.a.b(10, this.ndx);
      }
      paramInt = i;
      if (this.ndy != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.ndy);
      }
      AppMethodBeat.o(22121);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ndq == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatVersion");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.ndr == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatUserID");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.nds == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatNickName");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.ndt == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatInstallDir");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.ndw == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Manufacturer");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.ncW == null)
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
          localq.ndq = locala.LVo.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 2: 
          localq.ndr = locala.LVo.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 3: 
          localq.nds = locala.LVo.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 4: 
          localq.ndt = locala.LVo.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 5: 
          localq.ndu = locala.LVo.xG();
          AppMethodBeat.o(22121);
          return 0;
        case 6: 
          localq.ndv = locala.LVo.xG();
          AppMethodBeat.o(22121);
          return 0;
        case 7: 
          localq.ndw = locala.LVo.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 8: 
          localq.ncW = locala.LVo.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 9: 
          localq.Version = locala.LVo.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 10: 
          localq.ndx = locala.LVo.gfk();
          AppMethodBeat.o(22121);
          return 0;
        }
        localq.ndy = locala.LVo.gfk();
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