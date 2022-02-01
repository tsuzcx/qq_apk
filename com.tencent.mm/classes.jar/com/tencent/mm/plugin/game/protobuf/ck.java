package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ck
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public cw CNa;
  public String CQA;
  public String CQy;
  public String CQz;
  public String jUi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41796);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jUi != null) {
        paramVarArgs.f(1, this.jUi);
      }
      if (this.CQy != null) {
        paramVarArgs.f(2, this.CQy);
      }
      if (this.CQz != null) {
        paramVarArgs.f(3, this.CQz);
      }
      if (this.CQA != null) {
        paramVarArgs.f(4, this.CQA);
      }
      if (this.CNa != null)
      {
        paramVarArgs.oE(5, this.CNa.computeSize());
        this.CNa.writeFields(paramVarArgs);
      }
      if (this.CMD != null) {
        paramVarArgs.f(6, this.CMD);
      }
      AppMethodBeat.o(41796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jUi == null) {
        break label592;
      }
    }
    label592:
    for (int i = g.a.a.b.b.a.g(1, this.jUi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CQy != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CQy);
      }
      i = paramInt;
      if (this.CQz != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CQz);
      }
      paramInt = i;
      if (this.CQA != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CQA);
      }
      i = paramInt;
      if (this.CNa != null) {
        i = paramInt + g.a.a.a.oD(5, this.CNa.computeSize());
      }
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CMD);
      }
      AppMethodBeat.o(41796);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41796);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ck localck = (ck)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41796);
          return -1;
        case 1: 
          localck.jUi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 2: 
          localck.CQy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 3: 
          localck.CQz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 4: 
          localck.CQA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cw localcw = new cw();
            if ((localObject != null) && (localObject.length > 0)) {
              localcw.parseFrom((byte[])localObject);
            }
            localck.CNa = localcw;
            paramInt += 1;
          }
          AppMethodBeat.o(41796);
          return 0;
        }
        localck.CMD = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41796);
        return 0;
      }
      AppMethodBeat.o(41796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ck
 * JD-Core Version:    0.7.0.1
 */