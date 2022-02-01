package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.cd.a
{
  public String appid;
  public int status;
  public String ufB;
  public String ufC;
  public String ufD;
  public int ufE;
  public h ufF;
  public String ufG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153062);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.ufB == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_name");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.ufB != null) {
        paramVarArgs.f(2, this.ufB);
      }
      if (this.ufC != null) {
        paramVarArgs.f(3, this.ufC);
      }
      if (this.ufD != null) {
        paramVarArgs.f(4, this.ufD);
      }
      paramVarArgs.aY(5, this.ufE);
      paramVarArgs.aY(6, this.status);
      if (this.ufF != null)
      {
        paramVarArgs.oE(7, this.ufF.computeSize());
        this.ufF.writeFields(paramVarArgs);
      }
      if (this.ufG != null) {
        paramVarArgs.f(8, this.ufG);
      }
      AppMethodBeat.o(153062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label776;
      }
    }
    label776:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ufB);
      }
      i = paramInt;
      if (this.ufC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ufC);
      }
      paramInt = i;
      if (this.ufD != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ufD);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.ufE) + g.a.a.b.b.a.bM(6, this.status);
      paramInt = i;
      if (this.ufF != null) {
        paramInt = i + g.a.a.a.oD(7, this.ufF.computeSize());
      }
      i = paramInt;
      if (this.ufG != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.ufG);
      }
      AppMethodBeat.o(153062);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.appid == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(153062);
          throw paramVarArgs;
        }
        if (this.ufB == null)
        {
          paramVarArgs = new b("Not all required fields were included: app_name");
          AppMethodBeat.o(153062);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153062);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153062);
          return -1;
        case 1: 
          locald.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 2: 
          locald.ufB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 3: 
          locald.ufC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 4: 
          locald.ufD = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 5: 
          locald.ufE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(153062);
          return 0;
        case 6: 
          locald.status = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(153062);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            h localh = new h();
            if ((localObject != null) && (localObject.length > 0)) {
              localh.parseFrom((byte[])localObject);
            }
            locald.ufF = localh;
            paramInt += 1;
          }
          AppMethodBeat.o(153062);
          return 0;
        }
        locald.ufG = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153062);
        return 0;
      }
      AppMethodBeat.o(153062);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.d
 * JD-Core Version:    0.7.0.1
 */