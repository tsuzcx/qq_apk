package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class br
  extends com.tencent.mm.bx.a
{
  public String desc;
  public LinkedList<bz> nvu;
  public String summary;
  public String title;
  public String url;
  
  public br()
  {
    AppMethodBeat.i(41787);
    this.nvu = new LinkedList();
    AppMethodBeat.o(41787);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41788);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.summary != null) {
        paramVarArgs.d(1, this.summary);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.nvu);
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      AppMethodBeat.o(41788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.summary == null) {
        break label538;
      }
    }
    label538:
    for (paramInt = f.a.a.b.b.a.e(1, this.summary) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.desc);
      }
      i += f.a.a.a.c(3, 8, this.nvu);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      AppMethodBeat.o(41788);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nvu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        br localbr = (br)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41788);
          return -1;
        case 1: 
          localbr.summary = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41788);
          return 0;
        case 2: 
          localbr.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41788);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbr.nvu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41788);
          return 0;
        case 4: 
          localbr.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41788);
          return 0;
        }
        localbr.title = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41788);
        return 0;
      }
      AppMethodBeat.o(41788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.br
 * JD-Core Version:    0.7.0.1
 */