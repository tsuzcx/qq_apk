package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ed
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public String CNj;
  public String CNk;
  public String CRF;
  public String CRG;
  public String CRH;
  public String CRI;
  public String CRJ;
  public String CRK;
  public eb CRL;
  public ec CRM;
  public boolean CRN;
  public int CRO;
  public String CRg;
  public String fwr;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207298);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CRg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(207298);
        throw paramVarArgs;
      }
      if (this.CRg != null) {
        paramVarArgs.f(1, this.CRg);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.CRF != null) {
        paramVarArgs.f(11, this.CRF);
      }
      if (this.CRG != null) {
        paramVarArgs.f(12, this.CRG);
      }
      if (this.CRH != null) {
        paramVarArgs.f(13, this.CRH);
      }
      if (this.CRI != null) {
        paramVarArgs.f(14, this.CRI);
      }
      if (this.CNj != null) {
        paramVarArgs.f(3, this.CNj);
      }
      if (this.CRJ != null) {
        paramVarArgs.f(4, this.CRJ);
      }
      if (this.CNk != null) {
        paramVarArgs.f(9, this.CNk);
      }
      if (this.CRK != null) {
        paramVarArgs.f(10, this.CRK);
      }
      paramVarArgs.aY(5, this.rWu);
      if (this.CMD != null) {
        paramVarArgs.f(6, this.CMD);
      }
      if (this.CRL != null)
      {
        paramVarArgs.oE(7, this.CRL.computeSize());
        this.CRL.writeFields(paramVarArgs);
      }
      if (this.CRM != null)
      {
        paramVarArgs.oE(8, this.CRM.computeSize());
        this.CRM.writeFields(paramVarArgs);
      }
      paramVarArgs.co(15, this.CRN);
      paramVarArgs.aY(16, this.CRO);
      AppMethodBeat.o(207298);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRg == null) {
        break label1282;
      }
    }
    label1282:
    for (int i = g.a.a.b.b.a.g(1, this.CRg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.CRF != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.CRF);
      }
      paramInt = i;
      if (this.CRG != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.CRG);
      }
      i = paramInt;
      if (this.CRH != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.CRH);
      }
      paramInt = i;
      if (this.CRI != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.CRI);
      }
      i = paramInt;
      if (this.CNj != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CNj);
      }
      paramInt = i;
      if (this.CRJ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CRJ);
      }
      i = paramInt;
      if (this.CNk != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.CNk);
      }
      paramInt = i;
      if (this.CRK != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.CRK);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.rWu);
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CMD);
      }
      i = paramInt;
      if (this.CRL != null) {
        i = paramInt + g.a.a.a.oD(7, this.CRL.computeSize());
      }
      paramInt = i;
      if (this.CRM != null) {
        paramInt = i + g.a.a.a.oD(8, this.CRM.computeSize());
      }
      i = g.a.a.b.b.a.gL(15);
      int j = g.a.a.b.b.a.bM(16, this.CRO);
      AppMethodBeat.o(207298);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CRg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(207298);
          throw paramVarArgs;
        }
        AppMethodBeat.o(207298);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ed localed = (ed)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207298);
          return -1;
        case 1: 
          localed.CRg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207298);
          return 0;
        case 2: 
          localed.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207298);
          return 0;
        case 11: 
          localed.CRF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207298);
          return 0;
        case 12: 
          localed.CRG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207298);
          return 0;
        case 13: 
          localed.CRH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207298);
          return 0;
        case 14: 
          localed.CRI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207298);
          return 0;
        case 3: 
          localed.CNj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207298);
          return 0;
        case 4: 
          localed.CRJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207298);
          return 0;
        case 9: 
          localed.CNk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207298);
          return 0;
        case 10: 
          localed.CRK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207298);
          return 0;
        case 5: 
          localed.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(207298);
          return 0;
        case 6: 
          localed.CMD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207298);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eb)localObject2).parseFrom((byte[])localObject1);
            }
            localed.CRL = ((eb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207298);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ec();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ec)localObject2).parseFrom((byte[])localObject1);
            }
            localed.CRM = ((ec)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207298);
          return 0;
        case 15: 
          localed.CRN = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(207298);
          return 0;
        }
        localed.CRO = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(207298);
        return 0;
      }
      AppMethodBeat.o(207298);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ed
 * JD-Core Version:    0.7.0.1
 */