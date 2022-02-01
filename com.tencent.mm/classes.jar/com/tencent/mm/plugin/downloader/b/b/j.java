package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bx.a
{
  public String lwO;
  public long xls;
  public String xlw;
  public String xlz;
  public m xmd;
  public String xme;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153070);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.lwO == null)
      {
        paramVarArgs = new b("Not all required fields were included: download_url");
        AppMethodBeat.o(153070);
        throw paramVarArgs;
      }
      if (this.lwO != null) {
        paramVarArgs.g(1, this.lwO);
      }
      paramVarArgs.bv(2, this.xls);
      if (this.xmd != null)
      {
        paramVarArgs.qD(3, this.xmd.computeSize());
        this.xmd.writeFields(paramVarArgs);
      }
      if (this.xme != null) {
        paramVarArgs.g(4, this.xme);
      }
      if (this.xlz != null) {
        paramVarArgs.g(5, this.xlz);
      }
      if (this.xlw != null) {
        paramVarArgs.g(6, this.xlw);
      }
      AppMethodBeat.o(153070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lwO == null) {
        break label620;
      }
    }
    label620:
    for (paramInt = i.a.a.b.b.a.h(1, this.lwO) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.xls);
      paramInt = i;
      if (this.xmd != null) {
        paramInt = i + i.a.a.a.qC(3, this.xmd.computeSize());
      }
      i = paramInt;
      if (this.xme != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.xme);
      }
      paramInt = i;
      if (this.xlz != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.xlz);
      }
      i = paramInt;
      if (this.xlw != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.xlw);
      }
      AppMethodBeat.o(153070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.lwO == null)
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153070);
          return -1;
        case 1: 
          localj.lwO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 2: 
          localj.xls = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(153070);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            m localm = new m();
            if ((localObject != null) && (localObject.length > 0)) {
              localm.parseFrom((byte[])localObject);
            }
            localj.xmd = localm;
            paramInt += 1;
          }
          AppMethodBeat.o(153070);
          return 0;
        case 4: 
          localj.xme = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 5: 
          localj.xlz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153070);
          return 0;
        }
        localj.xlw = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153070);
        return 0;
      }
      AppMethodBeat.o(153070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.j
 * JD-Core Version:    0.7.0.1
 */