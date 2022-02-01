package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class de
  extends com.tencent.mm.bx.a
{
  public String ILh;
  public String ILi;
  public boolean ILj;
  public int Idt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41814);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ILi == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaURL");
        AppMethodBeat.o(41814);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.Idt);
      if (this.ILh != null) {
        paramVarArgs.g(2, this.ILh);
      }
      if (this.ILi != null) {
        paramVarArgs.g(3, this.ILi);
      }
      paramVarArgs.di(4, this.ILj);
      AppMethodBeat.o(41814);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Idt) + 0;
      paramInt = i;
      if (this.ILh != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ILh);
      }
      i = paramInt;
      if (this.ILi != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ILi);
      }
      paramInt = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(41814);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.ILi == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaURL");
        AppMethodBeat.o(41814);
        throw paramVarArgs;
      }
      AppMethodBeat.o(41814);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      de localde = (de)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41814);
        return -1;
      case 1: 
        localde.Idt = locala.ajGk.aar();
        AppMethodBeat.o(41814);
        return 0;
      case 2: 
        localde.ILh = locala.ajGk.readString();
        AppMethodBeat.o(41814);
        return 0;
      case 3: 
        localde.ILi = locala.ajGk.readString();
        AppMethodBeat.o(41814);
        return 0;
      }
      localde.ILj = locala.ajGk.aai();
      AppMethodBeat.o(41814);
      return 0;
    }
    AppMethodBeat.o(41814);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.de
 * JD-Core Version:    0.7.0.1
 */