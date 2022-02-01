package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bx.a
{
  public String Version;
  public String mAV;
  public String mBp;
  public String mBq;
  public String mBr;
  public String mBs;
  public long mBt;
  public long mBu;
  public String mBv;
  public com.tencent.mm.bx.b mBw;
  public com.tencent.mm.bx.b mBx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22121);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mBp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatVersion");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.mBq == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatUserID");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.mBr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatNickName");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.mBs == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatInstallDir");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.mBv == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Manufacturer");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.mAV == null)
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
      if (this.mBp != null) {
        paramVarArgs.d(1, this.mBp);
      }
      if (this.mBq != null) {
        paramVarArgs.d(2, this.mBq);
      }
      if (this.mBr != null) {
        paramVarArgs.d(3, this.mBr);
      }
      if (this.mBs != null) {
        paramVarArgs.d(4, this.mBs);
      }
      paramVarArgs.aG(5, this.mBt);
      paramVarArgs.aG(6, this.mBu);
      if (this.mBv != null) {
        paramVarArgs.d(7, this.mBv);
      }
      if (this.mAV != null) {
        paramVarArgs.d(8, this.mAV);
      }
      if (this.Version != null) {
        paramVarArgs.d(9, this.Version);
      }
      if (this.mBw != null) {
        paramVarArgs.c(10, this.mBw);
      }
      if (this.mBx != null) {
        paramVarArgs.c(11, this.mBx);
      }
      AppMethodBeat.o(22121);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mBp == null) {
        break label1159;
      }
    }
    label1159:
    for (int i = f.a.a.b.b.a.e(1, this.mBp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mBq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mBq);
      }
      i = paramInt;
      if (this.mBr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mBr);
      }
      paramInt = i;
      if (this.mBs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mBs);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.mBt) + f.a.a.b.b.a.q(6, this.mBu);
      paramInt = i;
      if (this.mBv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.mBv);
      }
      i = paramInt;
      if (this.mAV != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.mAV);
      }
      paramInt = i;
      if (this.Version != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Version);
      }
      i = paramInt;
      if (this.mBw != null) {
        i = paramInt + f.a.a.b.b.a.b(10, this.mBw);
      }
      paramInt = i;
      if (this.mBx != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.mBx);
      }
      AppMethodBeat.o(22121);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.mBp == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatVersion");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.mBq == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatUserID");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.mBr == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatNickName");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.mBs == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatInstallDir");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.mBv == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Manufacturer");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.mAV == null)
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
          localq.mBp = locala.KhF.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 2: 
          localq.mBq = locala.KhF.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 3: 
          localq.mBr = locala.KhF.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 4: 
          localq.mBs = locala.KhF.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 5: 
          localq.mBt = locala.KhF.xT();
          AppMethodBeat.o(22121);
          return 0;
        case 6: 
          localq.mBu = locala.KhF.xT();
          AppMethodBeat.o(22121);
          return 0;
        case 7: 
          localq.mBv = locala.KhF.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 8: 
          localq.mAV = locala.KhF.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 9: 
          localq.Version = locala.KhF.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 10: 
          localq.mBw = locala.KhF.fMu();
          AppMethodBeat.o(22121);
          return 0;
        }
        localq.mBx = locala.KhF.fMu();
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