package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bx.a
{
  public String fnK;
  public m odJ;
  public String odK;
  public long odd;
  public String odh;
  public String odk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153070);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fnK == null)
      {
        paramVarArgs = new b("Not all required fields were included: download_url");
        AppMethodBeat.o(153070);
        throw paramVarArgs;
      }
      if (this.fnK != null) {
        paramVarArgs.d(1, this.fnK);
      }
      paramVarArgs.aG(2, this.odd);
      if (this.odJ != null)
      {
        paramVarArgs.kX(3, this.odJ.computeSize());
        this.odJ.writeFields(paramVarArgs);
      }
      if (this.odK != null) {
        paramVarArgs.d(4, this.odK);
      }
      if (this.odk != null) {
        paramVarArgs.d(5, this.odk);
      }
      if (this.odh != null) {
        paramVarArgs.d(6, this.odh);
      }
      AppMethodBeat.o(153070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fnK == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = f.a.a.b.b.a.e(1, this.fnK) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.odd);
      paramInt = i;
      if (this.odJ != null) {
        paramInt = i + f.a.a.a.kW(3, this.odJ.computeSize());
      }
      i = paramInt;
      if (this.odK != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.odK);
      }
      paramInt = i;
      if (this.odk != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.odk);
      }
      i = paramInt;
      if (this.odh != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.odh);
      }
      AppMethodBeat.o(153070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.fnK == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153070);
          return -1;
        case 1: 
          localj.fnK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 2: 
          localj.odd = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(153070);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.odJ = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153070);
          return 0;
        case 4: 
          localj.odK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153070);
          return 0;
        case 5: 
          localj.odk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153070);
          return 0;
        }
        localj.odh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(153070);
        return 0;
      }
      AppMethodBeat.o(153070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.j
 * JD-Core Version:    0.7.0.1
 */