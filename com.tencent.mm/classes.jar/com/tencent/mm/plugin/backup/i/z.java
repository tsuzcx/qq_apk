package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class z
  extends com.tencent.mm.bx.a
{
  public String vgL;
  public LinkedList<String> vhB;
  public long vhU;
  public long vhV;
  public String vhW;
  public String vhX;
  
  public z()
  {
    AppMethodBeat.i(22131);
    this.vhB = new LinkedList();
    AppMethodBeat.o(22131);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22132);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgL == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.vhW == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgDataID");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.vhX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.vgL != null) {
        paramVarArgs.g(1, this.vgL);
      }
      paramVarArgs.bv(2, this.vhU);
      paramVarArgs.bv(3, this.vhV);
      if (this.vhW != null) {
        paramVarArgs.g(4, this.vhW);
      }
      if (this.vhX != null) {
        paramVarArgs.g(5, this.vhX);
      }
      paramVarArgs.e(6, 1, this.vhB);
      AppMethodBeat.o(22132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vgL == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = i.a.a.b.b.a.h(1, this.vgL) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.vhU) + i.a.a.b.b.a.q(3, this.vhV);
      paramInt = i;
      if (this.vhW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.vhW);
      }
      i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.vhX);
      }
      paramInt = i.a.a.a.c(6, 1, this.vhB);
      AppMethodBeat.o(22132);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vhB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.vgL == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.vhW == null)
        {
          paramVarArgs = new b("Not all required fields were included: MsgDataID");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.vhX == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22132);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22132);
          return -1;
        case 1: 
          localz.vgL = locala.ajGk.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 2: 
          localz.vhU = locala.ajGk.aaw();
          AppMethodBeat.o(22132);
          return 0;
        case 3: 
          localz.vhV = locala.ajGk.aaw();
          AppMethodBeat.o(22132);
          return 0;
        case 4: 
          localz.vhW = locala.ajGk.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 5: 
          localz.vhX = locala.ajGk.readString();
          AppMethodBeat.o(22132);
          return 0;
        }
        localz.vhB.add(locala.ajGk.readString());
        AppMethodBeat.o(22132);
        return 0;
      }
      AppMethodBeat.o(22132);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.z
 * JD-Core Version:    0.7.0.1
 */