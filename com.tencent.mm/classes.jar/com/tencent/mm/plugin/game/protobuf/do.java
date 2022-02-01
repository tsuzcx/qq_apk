package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class do
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String jfi;
  public String xIx;
  public String xIy;
  public String xJt;
  public String xMq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41829);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xMq == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppName");
        AppMethodBeat.o(41829);
        throw paramVarArgs;
      }
      if (this.xMq != null) {
        paramVarArgs.e(1, this.xMq);
      }
      if (this.xIx != null) {
        paramVarArgs.e(2, this.xIx);
      }
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      if (this.xJt != null) {
        paramVarArgs.e(5, this.xJt);
      }
      if (this.xIy != null) {
        paramVarArgs.e(6, this.xIy);
      }
      if (this.jfi != null) {
        paramVarArgs.e(7, this.jfi);
      }
      AppMethodBeat.o(41829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xMq == null) {
        break label626;
      }
    }
    label626:
    for (int i = g.a.a.b.b.a.f(1, this.xMq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xIx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xIx);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Title);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.xJt != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xJt);
      }
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xIy);
      }
      i = paramInt;
      if (this.jfi != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.jfi);
      }
      AppMethodBeat.o(41829);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xMq == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppName");
          AppMethodBeat.o(41829);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41829);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        do localdo = (do)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41829);
          return -1;
        case 1: 
          localdo.xMq = locala.UbS.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 2: 
          localdo.xIx = locala.UbS.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 3: 
          localdo.Title = locala.UbS.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 4: 
          localdo.Desc = locala.UbS.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 5: 
          localdo.xJt = locala.UbS.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 6: 
          localdo.xIy = locala.UbS.readString();
          AppMethodBeat.o(41829);
          return 0;
        }
        localdo.jfi = locala.UbS.readString();
        AppMethodBeat.o(41829);
        return 0;
      }
      AppMethodBeat.o(41829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.do
 * JD-Core Version:    0.7.0.1
 */