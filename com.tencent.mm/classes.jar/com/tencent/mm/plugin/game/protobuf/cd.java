package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cd
  extends com.tencent.mm.cd.a
{
  public String desc;
  public String summary;
  public String title;
  public LinkedList<cn> tse;
  public String url;
  
  public cd()
  {
    AppMethodBeat.i(41787);
    this.tse = new LinkedList();
    AppMethodBeat.o(41787);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41788);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.summary != null) {
        paramVarArgs.f(1, this.summary);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.tse);
      if (this.url != null) {
        paramVarArgs.f(4, this.url);
      }
      if (this.title != null) {
        paramVarArgs.f(5, this.title);
      }
      AppMethodBeat.o(41788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.summary == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = g.a.a.b.b.a.g(1, this.summary) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.desc);
      }
      i += g.a.a.a.c(3, 8, this.tse);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.title);
      }
      AppMethodBeat.o(41788);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tse.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cd localcd = (cd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41788);
          return -1;
        case 1: 
          localcd.summary = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41788);
          return 0;
        case 2: 
          localcd.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41788);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cn localcn = new cn();
            if ((localObject != null) && (localObject.length > 0)) {
              localcn.parseFrom((byte[])localObject);
            }
            localcd.tse.add(localcn);
            paramInt += 1;
          }
          AppMethodBeat.o(41788);
          return 0;
        case 4: 
          localcd.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41788);
          return 0;
        }
        localcd.title = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41788);
        return 0;
      }
      AppMethodBeat.o(41788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cd
 * JD-Core Version:    0.7.0.1
 */