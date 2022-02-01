package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.bx.a
{
  public String jump_url;
  public String pic_url;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153076);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.pic_url != null) {
        paramVarArgs.g(2, this.pic_url);
      }
      if (this.jump_url != null) {
        paramVarArgs.g(3, this.jump_url);
      }
      AppMethodBeat.o(153076);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.pic_url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.pic_url);
      }
      i = paramInt;
      if (this.jump_url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.jump_url);
      }
      AppMethodBeat.o(153076);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153076);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      p localp = (p)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153076);
        return -1;
      case 1: 
        localp.type = locala.ajGk.aar();
        AppMethodBeat.o(153076);
        return 0;
      case 2: 
        localp.pic_url = locala.ajGk.readString();
        AppMethodBeat.o(153076);
        return 0;
      }
      localp.jump_url = locala.ajGk.readString();
      AppMethodBeat.o(153076);
      return 0;
    }
    AppMethodBeat.o(153076);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.p
 * JD-Core Version:    0.7.0.1
 */