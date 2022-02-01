package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bg
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String Title;
  public String jfi;
  public String xIx;
  public g xIz;
  public LinkedList<String> xLh;
  public String xLi;
  public String xLj;
  public String xLk;
  
  public bg()
  {
    AppMethodBeat.i(41757);
    this.xLh = new LinkedList();
    AppMethodBeat.o(41757);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41758);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(2, this.IconUrl);
      }
      paramVarArgs.e(3, 1, this.xLh);
      if (this.xLi != null) {
        paramVarArgs.e(4, this.xLi);
      }
      if (this.xIx != null) {
        paramVarArgs.e(5, this.xIx);
      }
      if (this.xLj != null) {
        paramVarArgs.e(6, this.xLj);
      }
      if (this.xLk != null) {
        paramVarArgs.e(8, this.xLk);
      }
      if (this.jfi != null) {
        paramVarArgs.e(9, this.jfi);
      }
      if (this.xIz != null)
      {
        paramVarArgs.ni(10, this.xIz.computeSize());
        this.xIz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.IconUrl);
      }
      i += g.a.a.a.c(3, 1, this.xLh);
      paramInt = i;
      if (this.xLi != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xLi);
      }
      i = paramInt;
      if (this.xIx != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xIx);
      }
      paramInt = i;
      if (this.xLj != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xLj);
      }
      i = paramInt;
      if (this.xLk != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.xLk);
      }
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.jfi);
      }
      i = paramInt;
      if (this.xIz != null) {
        i = paramInt + g.a.a.a.nh(10, this.xIz.computeSize());
      }
      AppMethodBeat.o(41758);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bg localbg = (bg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(41758);
          return -1;
        case 1: 
          localbg.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 2: 
          localbg.IconUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 3: 
          localbg.xLh.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(41758);
          return 0;
        case 4: 
          localbg.xLi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 5: 
          localbg.xIx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 6: 
          localbg.xLj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 8: 
          localbg.xLk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 9: 
          localbg.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41758);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbg.xIz = ((g)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41758);
        return 0;
      }
      AppMethodBeat.o(41758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bg
 * JD-Core Version:    0.7.0.1
 */