package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bw.a
{
  public String Version;
  public String nIO;
  public String nJi;
  public String nJj;
  public String nJk;
  public String nJl;
  public long nJm;
  public long nJn;
  public String nJo;
  public com.tencent.mm.bw.b nJp;
  public com.tencent.mm.bw.b nJq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22121);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nJi == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatVersion");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.nJj == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatUserID");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.nJk == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatNickName");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.nJl == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatInstallDir");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.nJo == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Manufacturer");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.nIO == null)
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
      if (this.nJi != null) {
        paramVarArgs.d(1, this.nJi);
      }
      if (this.nJj != null) {
        paramVarArgs.d(2, this.nJj);
      }
      if (this.nJk != null) {
        paramVarArgs.d(3, this.nJk);
      }
      if (this.nJl != null) {
        paramVarArgs.d(4, this.nJl);
      }
      paramVarArgs.aZ(5, this.nJm);
      paramVarArgs.aZ(6, this.nJn);
      if (this.nJo != null) {
        paramVarArgs.d(7, this.nJo);
      }
      if (this.nIO != null) {
        paramVarArgs.d(8, this.nIO);
      }
      if (this.Version != null) {
        paramVarArgs.d(9, this.Version);
      }
      if (this.nJp != null) {
        paramVarArgs.c(10, this.nJp);
      }
      if (this.nJq != null) {
        paramVarArgs.c(11, this.nJq);
      }
      AppMethodBeat.o(22121);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nJi == null) {
        break label1159;
      }
    }
    label1159:
    for (int i = f.a.a.b.b.a.e(1, this.nJi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nJj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nJj);
      }
      i = paramInt;
      if (this.nJk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nJk);
      }
      paramInt = i;
      if (this.nJl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nJl);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.nJm) + f.a.a.b.b.a.p(6, this.nJn);
      paramInt = i;
      if (this.nJo != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nJo);
      }
      i = paramInt;
      if (this.nIO != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.nIO);
      }
      paramInt = i;
      if (this.Version != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Version);
      }
      i = paramInt;
      if (this.nJp != null) {
        i = paramInt + f.a.a.b.b.a.b(10, this.nJp);
      }
      paramInt = i;
      if (this.nJq != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.nJq);
      }
      AppMethodBeat.o(22121);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.nJi == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatVersion");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.nJj == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatUserID");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.nJk == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatNickName");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.nJl == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WeChatInstallDir");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.nJo == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Manufacturer");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.nIO == null)
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
          localq.nJi = locala.OmT.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 2: 
          localq.nJj = locala.OmT.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 3: 
          localq.nJk = locala.OmT.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 4: 
          localq.nJl = locala.OmT.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 5: 
          localq.nJm = locala.OmT.zd();
          AppMethodBeat.o(22121);
          return 0;
        case 6: 
          localq.nJn = locala.OmT.zd();
          AppMethodBeat.o(22121);
          return 0;
        case 7: 
          localq.nJo = locala.OmT.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 8: 
          localq.nIO = locala.OmT.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 9: 
          localq.Version = locala.OmT.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 10: 
          localq.nJp = locala.OmT.gCk();
          AppMethodBeat.o(22121);
          return 0;
        }
        localq.nJq = locala.OmT.gCk();
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