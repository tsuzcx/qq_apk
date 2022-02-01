package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public final class bk
  extends dyl
{
  public String CPt;
  public boolean CPx;
  public boolean CPy;
  public boolean CPz;
  public String jUi;
  public String mVH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41759);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CPt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41759);
        throw paramVarArgs;
      }
      if (this.jUi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41759);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CPt != null) {
        paramVarArgs.f(2, this.CPt);
      }
      if (this.jUi != null) {
        paramVarArgs.f(3, this.jUi);
      }
      paramVarArgs.co(4, this.CPx);
      if (this.mVH != null) {
        paramVarArgs.f(5, this.mVH);
      }
      paramVarArgs.co(6, this.CPy);
      paramVarArgs.co(7, this.CPz);
      AppMethodBeat.o(41759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label696;
      }
    }
    label696:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CPt != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CPt);
      }
      i = paramInt;
      if (this.jUi != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jUi);
      }
      i += g.a.a.b.b.a.gL(4) + 1;
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.mVH);
      }
      i = g.a.a.b.b.a.gL(6);
      int j = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(41759);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CPt == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41759);
          throw paramVarArgs;
        }
        if (this.jUi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bk localbk = (bk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41759);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localbk.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(41759);
          return 0;
        case 2: 
          localbk.CPt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 3: 
          localbk.jUi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 4: 
          localbk.CPx = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(41759);
          return 0;
        case 5: 
          localbk.mVH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41759);
          return 0;
        case 6: 
          localbk.CPy = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(41759);
          return 0;
        }
        localbk.CPz = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(41759);
        return 0;
      }
      AppMethodBeat.o(41759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bk
 * JD-Core Version:    0.7.0.1
 */