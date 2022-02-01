package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class x
  extends com.tencent.mm.cd.a
{
  public String CNT;
  public String CNU;
  public String CNV;
  public es CNW;
  public int CNX;
  public int CNY;
  public String CNZ;
  public int COa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41721);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNT == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadURL");
        AppMethodBeat.o(41721);
        throw paramVarArgs;
      }
      if (this.CNT != null) {
        paramVarArgs.f(1, this.CNT);
      }
      if (this.CNU != null) {
        paramVarArgs.f(2, this.CNU);
      }
      if (this.CNV != null) {
        paramVarArgs.f(4, this.CNV);
      }
      if (this.CNW != null)
      {
        paramVarArgs.oE(5, this.CNW.computeSize());
        this.CNW.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.CNX);
      paramVarArgs.aY(7, this.CNY);
      if (this.CNZ != null) {
        paramVarArgs.f(8, this.CNZ);
      }
      paramVarArgs.aY(9, this.COa);
      AppMethodBeat.o(41721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNT == null) {
        break label720;
      }
    }
    label720:
    for (int i = g.a.a.b.b.a.g(1, this.CNT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CNU != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CNU);
      }
      i = paramInt;
      if (this.CNV != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.CNV);
      }
      paramInt = i;
      if (this.CNW != null) {
        paramInt = i + g.a.a.a.oD(5, this.CNW.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.CNX) + g.a.a.b.b.a.bM(7, this.CNY);
      paramInt = i;
      if (this.CNZ != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.CNZ);
      }
      i = g.a.a.b.b.a.bM(9, this.COa);
      AppMethodBeat.o(41721);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CNT == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadURL");
          AppMethodBeat.o(41721);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41721);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(41721);
          return -1;
        case 1: 
          localx.CNT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 2: 
          localx.CNU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 4: 
          localx.CNV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            es locales = new es();
            if ((localObject != null) && (localObject.length > 0)) {
              locales.parseFrom((byte[])localObject);
            }
            localx.CNW = locales;
            paramInt += 1;
          }
          AppMethodBeat.o(41721);
          return 0;
        case 6: 
          localx.CNX = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(41721);
          return 0;
        case 7: 
          localx.CNY = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(41721);
          return 0;
        case 8: 
          localx.CNZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41721);
          return 0;
        }
        localx.COa = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(41721);
        return 0;
      }
      AppMethodBeat.o(41721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.x
 * JD-Core Version:    0.7.0.1
 */