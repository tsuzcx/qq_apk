package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ce
  extends com.tencent.mm.bx.a
{
  public String desc;
  public String summary;
  public String title;
  public String url;
  public LinkedList<cp> wwD;
  
  public ce()
  {
    AppMethodBeat.i(41787);
    this.wwD = new LinkedList();
    AppMethodBeat.o(41787);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41788);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.summary != null) {
        paramVarArgs.g(1, this.summary);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.wwD);
      if (this.url != null) {
        paramVarArgs.g(4, this.url);
      }
      if (this.title != null) {
        paramVarArgs.g(5, this.title);
      }
      AppMethodBeat.o(41788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.summary == null) {
        break label512;
      }
    }
    label512:
    for (paramInt = i.a.a.b.b.a.h(1, this.summary) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.desc);
      }
      i += i.a.a.a.c(3, 8, this.wwD);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.title);
      }
      AppMethodBeat.o(41788);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wwD.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ce localce = (ce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41788);
          return -1;
        case 1: 
          localce.summary = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41788);
          return 0;
        case 2: 
          localce.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41788);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cp localcp = new cp();
            if ((localObject != null) && (localObject.length > 0)) {
              localcp.parseFrom((byte[])localObject);
            }
            localce.wwD.add(localcp);
            paramInt += 1;
          }
          AppMethodBeat.o(41788);
          return 0;
        case 4: 
          localce.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41788);
          return 0;
        }
        localce.title = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41788);
        return 0;
      }
      AppMethodBeat.o(41788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ce
 * JD-Core Version:    0.7.0.1
 */