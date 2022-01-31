package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bv.a
{
  public String jJF;
  public String jJZ;
  public String jKa;
  public String jKb;
  public String jKc;
  public long jKd;
  public long jKe;
  public String jKf;
  public String jKg;
  public com.tencent.mm.bv.b jKh;
  public com.tencent.mm.bv.b jKi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18064);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJZ == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: WeChatVersion");
        AppMethodBeat.o(18064);
        throw paramVarArgs;
      }
      if (this.jKa == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: WeChatUserID");
        AppMethodBeat.o(18064);
        throw paramVarArgs;
      }
      if (this.jKb == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: WeChatNickName");
        AppMethodBeat.o(18064);
        throw paramVarArgs;
      }
      if (this.jKc == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: WeChatInstallDir");
        AppMethodBeat.o(18064);
        throw paramVarArgs;
      }
      if (this.jKf == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Manufacturer");
        AppMethodBeat.o(18064);
        throw paramVarArgs;
      }
      if (this.jJF == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Model");
        AppMethodBeat.o(18064);
        throw paramVarArgs;
      }
      if (this.jKg == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Version");
        AppMethodBeat.o(18064);
        throw paramVarArgs;
      }
      if (this.jJZ != null) {
        paramVarArgs.e(1, this.jJZ);
      }
      if (this.jKa != null) {
        paramVarArgs.e(2, this.jKa);
      }
      if (this.jKb != null) {
        paramVarArgs.e(3, this.jKb);
      }
      if (this.jKc != null) {
        paramVarArgs.e(4, this.jKc);
      }
      paramVarArgs.am(5, this.jKd);
      paramVarArgs.am(6, this.jKe);
      if (this.jKf != null) {
        paramVarArgs.e(7, this.jKf);
      }
      if (this.jJF != null) {
        paramVarArgs.e(8, this.jJF);
      }
      if (this.jKg != null) {
        paramVarArgs.e(9, this.jKg);
      }
      if (this.jKh != null) {
        paramVarArgs.c(10, this.jKh);
      }
      if (this.jKi != null) {
        paramVarArgs.c(11, this.jKi);
      }
      AppMethodBeat.o(18064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJZ == null) {
        break label1159;
      }
    }
    label1159:
    for (int i = e.a.a.b.b.a.f(1, this.jJZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jKa != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jKa);
      }
      i = paramInt;
      if (this.jKb != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.jKb);
      }
      paramInt = i;
      if (this.jKc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.jKc);
      }
      i = paramInt + e.a.a.b.b.a.p(5, this.jKd) + e.a.a.b.b.a.p(6, this.jKe);
      paramInt = i;
      if (this.jKf != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.jKf);
      }
      i = paramInt;
      if (this.jJF != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.jJF);
      }
      paramInt = i;
      if (this.jKg != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.jKg);
      }
      i = paramInt;
      if (this.jKh != null) {
        i = paramInt + e.a.a.b.b.a.b(10, this.jKh);
      }
      paramInt = i;
      if (this.jKi != null) {
        paramInt = i + e.a.a.b.b.a.b(11, this.jKi);
      }
      AppMethodBeat.o(18064);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.jJZ == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: WeChatVersion");
          AppMethodBeat.o(18064);
          throw paramVarArgs;
        }
        if (this.jKa == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: WeChatUserID");
          AppMethodBeat.o(18064);
          throw paramVarArgs;
        }
        if (this.jKb == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: WeChatNickName");
          AppMethodBeat.o(18064);
          throw paramVarArgs;
        }
        if (this.jKc == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: WeChatInstallDir");
          AppMethodBeat.o(18064);
          throw paramVarArgs;
        }
        if (this.jKf == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: Manufacturer");
          AppMethodBeat.o(18064);
          throw paramVarArgs;
        }
        if (this.jJF == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: Model");
          AppMethodBeat.o(18064);
          throw paramVarArgs;
        }
        if (this.jKg == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: Version");
          AppMethodBeat.o(18064);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18064);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(18064);
          return -1;
        case 1: 
          localq.jJZ = locala.CLY.readString();
          AppMethodBeat.o(18064);
          return 0;
        case 2: 
          localq.jKa = locala.CLY.readString();
          AppMethodBeat.o(18064);
          return 0;
        case 3: 
          localq.jKb = locala.CLY.readString();
          AppMethodBeat.o(18064);
          return 0;
        case 4: 
          localq.jKc = locala.CLY.readString();
          AppMethodBeat.o(18064);
          return 0;
        case 5: 
          localq.jKd = locala.CLY.sm();
          AppMethodBeat.o(18064);
          return 0;
        case 6: 
          localq.jKe = locala.CLY.sm();
          AppMethodBeat.o(18064);
          return 0;
        case 7: 
          localq.jKf = locala.CLY.readString();
          AppMethodBeat.o(18064);
          return 0;
        case 8: 
          localq.jJF = locala.CLY.readString();
          AppMethodBeat.o(18064);
          return 0;
        case 9: 
          localq.jKg = locala.CLY.readString();
          AppMethodBeat.o(18064);
          return 0;
        case 10: 
          localq.jKh = locala.CLY.eqS();
          AppMethodBeat.o(18064);
          return 0;
        }
        localq.jKi = locala.CLY.eqS();
        AppMethodBeat.o(18064);
        return 0;
      }
      AppMethodBeat.o(18064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.q
 * JD-Core Version:    0.7.0.1
 */