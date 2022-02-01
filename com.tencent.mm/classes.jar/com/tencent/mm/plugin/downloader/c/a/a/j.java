package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public final class j
  extends dyl
{
  public String iUJ;
  public String source;
  public String ufb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153052);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.iUJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: download_url");
        AppMethodBeat.o(153052);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iUJ != null) {
        paramVarArgs.f(2, this.iUJ);
      }
      if (this.ufb != null) {
        paramVarArgs.f(3, this.ufb);
      }
      if (this.source != null) {
        paramVarArgs.f(4, this.source);
      }
      AppMethodBeat.o(153052);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label516;
      }
    }
    label516:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iUJ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.iUJ);
      }
      i = paramInt;
      if (this.ufb != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ufb);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.source);
      }
      AppMethodBeat.o(153052);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.iUJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: download_url");
          AppMethodBeat.o(153052);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153052);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153052);
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
            localj.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(153052);
          return 0;
        case 2: 
          localj.iUJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153052);
          return 0;
        case 3: 
          localj.ufb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153052);
          return 0;
        }
        localj.source = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153052);
        return 0;
      }
      AppMethodBeat.o(153052);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.j
 * JD-Core Version:    0.7.0.1
 */