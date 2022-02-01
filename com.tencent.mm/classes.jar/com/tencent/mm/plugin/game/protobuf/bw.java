package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public final class bw
  extends dyl
{
  public LinkedList<String> CPO;
  public String CPt;
  public int CQe;
  public int CQf;
  public int CQg;
  public boolean CQh;
  public String mVH;
  
  public bw()
  {
    AppMethodBeat.i(41777);
    this.CPO = new LinkedList();
    AppMethodBeat.o(41777);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41778);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CPt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41778);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.CQe);
      paramVarArgs.aY(3, this.CQf);
      if (this.CPt != null) {
        paramVarArgs.f(4, this.CPt);
      }
      paramVarArgs.e(5, 1, this.CPO);
      if (this.mVH != null) {
        paramVarArgs.f(6, this.mVH);
      }
      paramVarArgs.aY(7, this.CQg);
      paramVarArgs.co(8, this.CQh);
      AppMethodBeat.o(41778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label696;
      }
    }
    label696:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CQe) + g.a.a.b.b.a.bM(3, this.CQf);
      paramInt = i;
      if (this.CPt != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CPt);
      }
      i = paramInt + g.a.a.a.c(5, 1, this.CPO);
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.mVH);
      }
      i = g.a.a.b.b.a.bM(7, this.CQg);
      int j = g.a.a.b.b.a.gL(8);
      AppMethodBeat.o(41778);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CPO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CPt == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41778);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41778);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bw localbw = (bw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41778);
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
            localbw.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(41778);
          return 0;
        case 2: 
          localbw.CQe = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(41778);
          return 0;
        case 3: 
          localbw.CQf = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(41778);
          return 0;
        case 4: 
          localbw.CPt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41778);
          return 0;
        case 5: 
          localbw.CPO.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(41778);
          return 0;
        case 6: 
          localbw.mVH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41778);
          return 0;
        case 7: 
          localbw.CQg = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(41778);
          return 0;
        }
        localbw.CQh = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(41778);
        return 0;
      }
      AppMethodBeat.o(41778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bw
 * JD-Core Version:    0.7.0.1
 */