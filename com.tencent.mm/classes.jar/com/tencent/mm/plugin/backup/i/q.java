package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bw.a
{
  public String Version;
  public String oTJ;
  public String oUd;
  public String oUe;
  public String oUf;
  public String oUg;
  public long oUh;
  public long oUi;
  public String oUj;
  public com.tencent.mm.bw.b oUk;
  public com.tencent.mm.bw.b oUl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22121);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oUd == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatVersion");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.oUe == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatUserID");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.oUf == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatNickName");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.oUg == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatInstallDir");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.oUj == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Manufacturer");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.oTJ == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Model");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.Version == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Version");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.oUd != null) {
        paramVarArgs.e(1, this.oUd);
      }
      if (this.oUe != null) {
        paramVarArgs.e(2, this.oUe);
      }
      if (this.oUf != null) {
        paramVarArgs.e(3, this.oUf);
      }
      if (this.oUg != null) {
        paramVarArgs.e(4, this.oUg);
      }
      paramVarArgs.bb(5, this.oUh);
      paramVarArgs.bb(6, this.oUi);
      if (this.oUj != null) {
        paramVarArgs.e(7, this.oUj);
      }
      if (this.oTJ != null) {
        paramVarArgs.e(8, this.oTJ);
      }
      if (this.Version != null) {
        paramVarArgs.e(9, this.Version);
      }
      if (this.oUk != null) {
        paramVarArgs.c(10, this.oUk);
      }
      if (this.oUl != null) {
        paramVarArgs.c(11, this.oUl);
      }
      AppMethodBeat.o(22121);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oUd == null) {
        break label1159;
      }
    }
    label1159:
    for (int i = g.a.a.b.b.a.f(1, this.oUd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUe != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUe);
      }
      i = paramInt;
      if (this.oUf != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.oUf);
      }
      paramInt = i;
      if (this.oUg != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.oUg);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.oUh) + g.a.a.b.b.a.r(6, this.oUi);
      paramInt = i;
      if (this.oUj != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.oUj);
      }
      i = paramInt;
      if (this.oTJ != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.oTJ);
      }
      paramInt = i;
      if (this.Version != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Version);
      }
      i = paramInt;
      if (this.oUk != null) {
        i = paramInt + g.a.a.b.b.a.b(10, this.oUk);
      }
      paramInt = i;
      if (this.oUl != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.oUl);
      }
      AppMethodBeat.o(22121);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.oUd == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatVersion");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.oUe == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatUserID");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.oUf == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatNickName");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.oUg == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatInstallDir");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.oUj == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Manufacturer");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.oTJ == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Model");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.Version == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Version");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22121);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22121);
          return -1;
        case 1: 
          localq.oUd = locala.UbS.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 2: 
          localq.oUe = locala.UbS.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 3: 
          localq.oUf = locala.UbS.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 4: 
          localq.oUg = locala.UbS.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 5: 
          localq.oUh = locala.UbS.zl();
          AppMethodBeat.o(22121);
          return 0;
        case 6: 
          localq.oUi = locala.UbS.zl();
          AppMethodBeat.o(22121);
          return 0;
        case 7: 
          localq.oUj = locala.UbS.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 8: 
          localq.oTJ = locala.UbS.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 9: 
          localq.Version = locala.UbS.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 10: 
          localq.oUk = locala.UbS.hPo();
          AppMethodBeat.o(22121);
          return 0;
        }
        localq.oUl = locala.UbS.hPo();
        AppMethodBeat.o(22121);
        return 0;
      }
      AppMethodBeat.o(22121);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.q
 * JD-Core Version:    0.7.0.1
 */