package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bx.a
{
  public String Version;
  public String vgX;
  public String vhr;
  public String vhs;
  public String vht;
  public String vhu;
  public long vhv;
  public long vhw;
  public String vhx;
  public com.tencent.mm.bx.b vhy;
  public com.tencent.mm.bx.b vhz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22121);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vhr == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: WeChatVersion");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.vhs == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: WeChatUserID");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.vht == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: WeChatNickName");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.vhu == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: WeChatInstallDir");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.vhx == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Manufacturer");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.vgX == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Model");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.Version == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Version");
        AppMethodBeat.o(22121);
        throw paramVarArgs;
      }
      if (this.vhr != null) {
        paramVarArgs.g(1, this.vhr);
      }
      if (this.vhs != null) {
        paramVarArgs.g(2, this.vhs);
      }
      if (this.vht != null) {
        paramVarArgs.g(3, this.vht);
      }
      if (this.vhu != null) {
        paramVarArgs.g(4, this.vhu);
      }
      paramVarArgs.bv(5, this.vhv);
      paramVarArgs.bv(6, this.vhw);
      if (this.vhx != null) {
        paramVarArgs.g(7, this.vhx);
      }
      if (this.vgX != null) {
        paramVarArgs.g(8, this.vgX);
      }
      if (this.Version != null) {
        paramVarArgs.g(9, this.Version);
      }
      if (this.vhy != null) {
        paramVarArgs.d(10, this.vhy);
      }
      if (this.vhz != null) {
        paramVarArgs.d(11, this.vhz);
      }
      AppMethodBeat.o(22121);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhr == null) {
        break label1155;
      }
    }
    label1155:
    for (int i = i.a.a.b.b.a.h(1, this.vhr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhs != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhs);
      }
      i = paramInt;
      if (this.vht != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.vht);
      }
      paramInt = i;
      if (this.vhu != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.vhu);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.vhv) + i.a.a.b.b.a.q(6, this.vhw);
      paramInt = i;
      if (this.vhx != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.vhx);
      }
      i = paramInt;
      if (this.vgX != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.vgX);
      }
      paramInt = i;
      if (this.Version != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Version);
      }
      i = paramInt;
      if (this.vhy != null) {
        i = paramInt + i.a.a.b.b.a.c(10, this.vhy);
      }
      paramInt = i;
      if (this.vhz != null) {
        paramInt = i + i.a.a.b.b.a.c(11, this.vhz);
      }
      AppMethodBeat.o(22121);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.vhr == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: WeChatVersion");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.vhs == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: WeChatUserID");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.vht == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: WeChatNickName");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.vhu == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: WeChatInstallDir");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.vhx == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: Manufacturer");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.vgX == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: Model");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        if (this.Version == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: Version");
          AppMethodBeat.o(22121);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22121);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22121);
          return -1;
        case 1: 
          localq.vhr = locala.ajGk.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 2: 
          localq.vhs = locala.ajGk.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 3: 
          localq.vht = locala.ajGk.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 4: 
          localq.vhu = locala.ajGk.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 5: 
          localq.vhv = locala.ajGk.aaw();
          AppMethodBeat.o(22121);
          return 0;
        case 6: 
          localq.vhw = locala.ajGk.aaw();
          AppMethodBeat.o(22121);
          return 0;
        case 7: 
          localq.vhx = locala.ajGk.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 8: 
          localq.vgX = locala.ajGk.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 9: 
          localq.Version = locala.ajGk.readString();
          AppMethodBeat.o(22121);
          return 0;
        case 10: 
          localq.vhy = locala.ajGk.kFX();
          AppMethodBeat.o(22121);
          return 0;
        }
        localq.vhz = locala.ajGk.kFX();
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