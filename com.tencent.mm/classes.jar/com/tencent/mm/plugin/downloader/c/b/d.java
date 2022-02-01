package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public String djj;
  public String oGM;
  public String oGN;
  public String oGO;
  public int oGP;
  public h oGQ;
  public String oGR;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153062);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djj == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.oGM == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_name");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.djj != null) {
        paramVarArgs.d(1, this.djj);
      }
      if (this.oGM != null) {
        paramVarArgs.d(2, this.oGM);
      }
      if (this.oGN != null) {
        paramVarArgs.d(3, this.oGN);
      }
      if (this.oGO != null) {
        paramVarArgs.d(4, this.oGO);
      }
      paramVarArgs.aR(5, this.oGP);
      paramVarArgs.aR(6, this.status);
      if (this.oGQ != null)
      {
        paramVarArgs.ln(7, this.oGQ.computeSize());
        this.oGQ.writeFields(paramVarArgs);
      }
      if (this.oGR != null) {
        paramVarArgs.d(8, this.oGR);
      }
      AppMethodBeat.o(153062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djj == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.b.b.a.e(1, this.djj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oGM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oGM);
      }
      i = paramInt;
      if (this.oGN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oGN);
      }
      paramInt = i;
      if (this.oGO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oGO);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.oGP) + f.a.a.b.b.a.bx(6, this.status);
      paramInt = i;
      if (this.oGQ != null) {
        paramInt = i + f.a.a.a.lm(7, this.oGQ.computeSize());
      }
      i = paramInt;
      if (this.oGR != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.oGR);
      }
      AppMethodBeat.o(153062);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.djj == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(153062);
          throw paramVarArgs;
        }
        if (this.oGM == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153062);
          return -1;
        case 1: 
          locald.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 2: 
          locald.oGM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 3: 
          locald.oGN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 4: 
          locald.oGO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 5: 
          locald.oGP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153062);
          return 0;
        case 6: 
          locald.status = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153062);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locald.oGQ = ((h)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153062);
          return 0;
        }
        locald.oGR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(153062);
        return 0;
      }
      AppMethodBeat.o(153062);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.d
 * JD-Core Version:    0.7.0.1
 */