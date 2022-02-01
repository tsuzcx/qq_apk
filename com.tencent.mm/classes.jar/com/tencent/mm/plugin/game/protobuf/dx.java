package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public final class dx
  extends dyl
{
  public String CML;
  public boolean CMZ;
  public String CPt;
  public String jUi;
  public String mVH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41836);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CPt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41836);
        throw paramVarArgs;
      }
      if (this.jUi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41836);
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
      if (this.CML != null) {
        paramVarArgs.f(4, this.CML);
      }
      if (this.mVH != null) {
        paramVarArgs.f(5, this.mVH);
      }
      paramVarArgs.co(6, this.CMZ);
      AppMethodBeat.o(41836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label668;
      }
    }
    label668:
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
      paramInt = i;
      if (this.CML != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CML);
      }
      i = paramInt;
      if (this.mVH != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.mVH);
      }
      paramInt = g.a.a.b.b.a.gL(6);
      AppMethodBeat.o(41836);
      return i + (paramInt + 1);
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
          AppMethodBeat.o(41836);
          throw paramVarArgs;
        }
        if (this.jUi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41836);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41836);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dx localdx = (dx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41836);
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
            localdx.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(41836);
          return 0;
        case 2: 
          localdx.CPt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 3: 
          localdx.jUi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 4: 
          localdx.CML = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41836);
          return 0;
        case 5: 
          localdx.mVH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41836);
          return 0;
        }
        localdx.CMZ = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(41836);
        return 0;
      }
      AppMethodBeat.o(41836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dx
 * JD-Core Version:    0.7.0.1
 */