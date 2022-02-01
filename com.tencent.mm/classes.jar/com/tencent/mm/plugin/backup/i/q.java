package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.cd.a
{
  public String Version;
  public String rVH;
  public String rWb;
  public String rWc;
  public String rWd;
  public String rWe;
  public long rWf;
  public long rWg;
  public String rWh;
  public com.tencent.mm.cd.b rWi;
  public com.tencent.mm.cd.b rWj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22121);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rWb == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatVersion");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.rWc == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatUserID");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.rWd == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatNickName");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.rWe == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatInstallDir");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.rWh == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Manufacturer");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.rVH == null)
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
      if (this.rWb != null) {
        paramVarArgs.f(1, this.rWb);
      }
      if (this.rWc != null) {
        paramVarArgs.f(2, this.rWc);
      }
      if (this.rWd != null) {
        paramVarArgs.f(3, this.rWd);
      }
      if (this.rWe != null) {
        paramVarArgs.f(4, this.rWe);
      }
      paramVarArgs.bm(5, this.rWf);
      paramVarArgs.bm(6, this.rWg);
      if (this.rWh != null) {
        paramVarArgs.f(7, this.rWh);
      }
      if (this.rVH != null) {
        paramVarArgs.f(8, this.rVH);
      }
      if (this.Version != null) {
        paramVarArgs.f(9, this.Version);
      }
      if (this.rWi != null) {
        paramVarArgs.c(10, this.rWi);
      }
      if (this.rWj != null) {
        paramVarArgs.c(11, this.rWj);
      }
      AppMethodBeat.o(22121);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rWb == null) {
        break label1159;
      }
    }
    label1159:
    for (int i = g.a.a.b.b.a.g(1, this.rWb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rWc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rWc);
      }
      i = paramInt;
      if (this.rWd != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.rWd);
      }
      paramInt = i;
      if (this.rWe != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.rWe);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.rWf) + g.a.a.b.b.a.p(6, this.rWg);
      paramInt = i;
      if (this.rWh != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.rWh);
      }
      i = paramInt;
      if (this.rVH != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.rVH);
      }
      paramInt = i;
      if (this.Version != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Version);
      }
      i = paramInt;
      if (this.rWi != null) {
        i = paramInt + g.a.a.b.b.a.b(10, this.rWi);
      }
      paramInt = i;
      if (this.rWj != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.rWj);
      }
      AppMethodBeat.o(22121);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.rWb == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatVersion");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.rWc == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatUserID");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.rWd == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatNickName");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.rWe == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: WeChatInstallDir");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.rWh == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Manufacturer");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.rVH == null)
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
          localq.rWb = locala.abFh.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 2: 
          localq.rWc = locala.abFh.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 3: 
          localq.rWd = locala.abFh.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 4: 
          localq.rWe = locala.abFh.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 5: 
          localq.rWf = locala.abFh.AN();
          AppMethodBeat.o(22121);
          return 0;
        case 6: 
          localq.rWg = locala.abFh.AN();
          AppMethodBeat.o(22121);
          return 0;
        case 7: 
          localq.rWh = locala.abFh.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 8: 
          localq.rVH = locala.abFh.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 9: 
          localq.Version = locala.abFh.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 10: 
          localq.rWi = locala.abFh.iUw();
          AppMethodBeat.o(22121);
          return 0;
        }
        localq.rWj = locala.abFh.iUw();
        AppMethodBeat.o(22121);
        return 0;
      }
      AppMethodBeat.o(22121);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.q
 * JD-Core Version:    0.7.0.1
 */