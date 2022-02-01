package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.cd.a
{
  public String iUJ;
  public m ufX;
  public String ufY;
  public long ufr;
  public String ufv;
  public String ufy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153070);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.iUJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: download_url");
        AppMethodBeat.o(153070);
        throw paramVarArgs;
      }
      if (this.iUJ != null) {
        paramVarArgs.f(1, this.iUJ);
      }
      paramVarArgs.bm(2, this.ufr);
      if (this.ufX != null)
      {
        paramVarArgs.oE(3, this.ufX.computeSize());
        this.ufX.writeFields(paramVarArgs);
      }
      if (this.ufY != null) {
        paramVarArgs.f(4, this.ufY);
      }
      if (this.ufy != null) {
        paramVarArgs.f(5, this.ufy);
      }
      if (this.ufv != null) {
        paramVarArgs.f(6, this.ufv);
      }
      AppMethodBeat.o(153070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iUJ == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = g.a.a.b.b.a.g(1, this.iUJ) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.ufr);
      paramInt = i;
      if (this.ufX != null) {
        paramInt = i + g.a.a.a.oD(3, this.ufX.computeSize());
      }
      i = paramInt;
      if (this.ufY != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ufY);
      }
      paramInt = i;
      if (this.ufy != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ufy);
      }
      i = paramInt;
      if (this.ufv != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.ufv);
      }
      AppMethodBeat.o(153070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.iUJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: download_url");
          AppMethodBeat.o(153070);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153070);
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
          AppMethodBeat.o(153070);
          return -1;
        case 1: 
          localj.iUJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 2: 
          localj.ufr = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(153070);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            m localm = new m();
            if ((localObject != null) && (localObject.length > 0)) {
              localm.parseFrom((byte[])localObject);
            }
            localj.ufX = localm;
            paramInt += 1;
          }
          AppMethodBeat.o(153070);
          return 0;
        case 4: 
          localj.ufY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 5: 
          localj.ufy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153070);
          return 0;
        }
        localj.ufv = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153070);
        return 0;
      }
      AppMethodBeat.o(153070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.j
 * JD-Core Version:    0.7.0.1
 */