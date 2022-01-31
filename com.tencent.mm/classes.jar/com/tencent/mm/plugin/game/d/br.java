package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class br
  extends com.tencent.mm.bv.a
{
  public String desc;
  public LinkedList<bz> kqa;
  public String summary;
  public String title;
  public String url;
  
  public br()
  {
    AppMethodBeat.i(111622);
    this.kqa = new LinkedList();
    AppMethodBeat.o(111622);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111623);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.summary != null) {
        paramVarArgs.e(1, this.summary);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.kqa);
      if (this.url != null) {
        paramVarArgs.e(4, this.url);
      }
      if (this.title != null) {
        paramVarArgs.e(5, this.title);
      }
      AppMethodBeat.o(111623);
      return 0;
    }
    if (paramInt == 1) {
      if (this.summary == null) {
        break label538;
      }
    }
    label538:
    for (paramInt = e.a.a.b.b.a.f(1, this.summary) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.desc);
      }
      i += e.a.a.a.c(3, 8, this.kqa);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.title);
      }
      AppMethodBeat.o(111623);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kqa.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111623);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        br localbr = (br)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111623);
          return -1;
        case 1: 
          localbr.summary = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111623);
          return 0;
        case 2: 
          localbr.desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111623);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbr.kqa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111623);
          return 0;
        case 4: 
          localbr.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111623);
          return 0;
        }
        localbr.title = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111623);
        return 0;
      }
      AppMethodBeat.o(111623);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.br
 * JD-Core Version:    0.7.0.1
 */