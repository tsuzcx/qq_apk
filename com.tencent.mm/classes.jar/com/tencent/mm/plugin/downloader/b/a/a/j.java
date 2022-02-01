package com.tencent.mm.plugin.downloader.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public final class j
  extends erp
{
  public String lwO;
  public String source;
  public String xlc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153052);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.lwO == null)
      {
        paramVarArgs = new b("Not all required fields were included: download_url");
        AppMethodBeat.o(153052);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lwO != null) {
        paramVarArgs.g(2, this.lwO);
      }
      if (this.xlc != null) {
        paramVarArgs.g(3, this.xlc);
      }
      if (this.source != null) {
        paramVarArgs.g(4, this.source);
      }
      AppMethodBeat.o(153052);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label512;
      }
    }
    label512:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lwO != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.lwO);
      }
      i = paramInt;
      if (this.xlc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.xlc);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.source);
      }
      AppMethodBeat.o(153052);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.lwO == null)
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153052);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localj.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(153052);
          return 0;
        case 2: 
          localj.lwO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153052);
          return 0;
        case 3: 
          localj.xlc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153052);
          return 0;
        }
        localj.source = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153052);
        return 0;
      }
      AppMethodBeat.o(153052);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a.a.j
 * JD-Core Version:    0.7.0.1
 */