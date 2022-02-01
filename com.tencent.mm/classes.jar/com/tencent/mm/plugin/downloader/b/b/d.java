package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public String appid;
  public String icon_url;
  public int status;
  public String xlJ;
  public String xlK;
  public int xlL;
  public h xlM;
  public String xlN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153062);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.xlJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_name");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.xlJ != null) {
        paramVarArgs.g(2, this.xlJ);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(3, this.icon_url);
      }
      if (this.xlK != null) {
        paramVarArgs.g(4, this.xlK);
      }
      paramVarArgs.bS(5, this.xlL);
      paramVarArgs.bS(6, this.status);
      if (this.xlM != null)
      {
        paramVarArgs.qD(7, this.xlM.computeSize());
        this.xlM.writeFields(paramVarArgs);
      }
      if (this.xlN != null) {
        paramVarArgs.g(8, this.xlN);
      }
      AppMethodBeat.o(153062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label772;
      }
    }
    label772:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xlJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.xlJ);
      }
      i = paramInt;
      if (this.icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.icon_url);
      }
      paramInt = i;
      if (this.xlK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.xlK);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.xlL) + i.a.a.b.b.a.cJ(6, this.status);
      paramInt = i;
      if (this.xlM != null) {
        paramInt = i + i.a.a.a.qC(7, this.xlM.computeSize());
      }
      i = paramInt;
      if (this.xlN != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.xlN);
      }
      AppMethodBeat.o(153062);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.appid == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(153062);
          throw paramVarArgs;
        }
        if (this.xlJ == null)
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153062);
          return -1;
        case 1: 
          locald.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 2: 
          locald.xlJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 3: 
          locald.icon_url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 4: 
          locald.xlK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 5: 
          locald.xlL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(153062);
          return 0;
        case 6: 
          locald.status = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(153062);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            h localh = new h();
            if ((localObject != null) && (localObject.length > 0)) {
              localh.parseFrom((byte[])localObject);
            }
            locald.xlM = localh;
            paramInt += 1;
          }
          AppMethodBeat.o(153062);
          return 0;
        }
        locald.xlN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153062);
        return 0;
      }
      AppMethodBeat.o(153062);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.d
 * JD-Core Version:    0.7.0.1
 */