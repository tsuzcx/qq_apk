package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class af
  extends com.tencent.mm.bx.a
{
  public String vgL;
  public LinkedList<Long> vih;
  public LinkedList<String> vii;
  public LinkedList<String> vij;
  
  public af()
  {
    AppMethodBeat.i(22138);
    this.vih = new LinkedList();
    this.vii = new LinkedList();
    this.vij = new LinkedList();
    AppMethodBeat.o(22138);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22139);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgL == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22139);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 3, this.vih);
      paramVarArgs.e(2, 1, this.vii);
      paramVarArgs.e(3, 1, this.vij);
      if (this.vgL != null) {
        paramVarArgs.g(4, this.vgL);
      }
      AppMethodBeat.o(22139);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.a.c(1, 3, this.vih) + 0 + i.a.a.a.c(2, 1, this.vii) + i.a.a.a.c(3, 1, this.vij);
      paramInt = i;
      if (this.vgL != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.vgL);
      }
      AppMethodBeat.o(22139);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.vih.clear();
      this.vii.clear();
      this.vij.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.vgL == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22139);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22139);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      af localaf = (af)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22139);
        return -1;
      case 1: 
        localaf.vih.add(Long.valueOf(locala.ajGk.aaw()));
        AppMethodBeat.o(22139);
        return 0;
      case 2: 
        localaf.vii.add(locala.ajGk.readString());
        AppMethodBeat.o(22139);
        return 0;
      case 3: 
        localaf.vij.add(locala.ajGk.readString());
        AppMethodBeat.o(22139);
        return 0;
      }
      localaf.vgL = locala.ajGk.readString();
      AppMethodBeat.o(22139);
      return 0;
    }
    AppMethodBeat.o(22139);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.af
 * JD-Core Version:    0.7.0.1
 */