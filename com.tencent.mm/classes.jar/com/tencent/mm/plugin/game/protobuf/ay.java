package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ay
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String jfi;
  public String xIy;
  public String xKV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41745);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xKV != null) {
        paramVarArgs.e(1, this.xKV);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(3, this.Desc);
      }
      if (this.xIy != null) {
        paramVarArgs.e(4, this.xIy);
      }
      if (this.jfi != null) {
        paramVarArgs.e(5, this.jfi);
      }
      AppMethodBeat.o(41745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xKV == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.f(1, this.xKV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Desc);
      }
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xIy);
      }
      i = paramInt;
      if (this.jfi != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.jfi);
      }
      AppMethodBeat.o(41745);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41745);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ay localay = (ay)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41745);
          return -1;
        case 1: 
          localay.xKV = locala.UbS.readString();
          AppMethodBeat.o(41745);
          return 0;
        case 2: 
          localay.Title = locala.UbS.readString();
          AppMethodBeat.o(41745);
          return 0;
        case 3: 
          localay.Desc = locala.UbS.readString();
          AppMethodBeat.o(41745);
          return 0;
        case 4: 
          localay.xIy = locala.UbS.readString();
          AppMethodBeat.o(41745);
          return 0;
        }
        localay.jfi = locala.UbS.readString();
        AppMethodBeat.o(41745);
        return 0;
      }
      AppMethodBeat.o(41745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ay
 * JD-Core Version:    0.7.0.1
 */