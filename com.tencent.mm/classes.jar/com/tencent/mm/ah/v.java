package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class v
  extends com.tencent.mm.bw.a
{
  public int hBY;
  public String hCa;
  public String hGc;
  public String hGd;
  public String hGe;
  public String hGf;
  public String hGg;
  public int hGh;
  public int hGi;
  public String hGj;
  public String hGk;
  public int hGl;
  public int hGm;
  public String hGn;
  public String hGo;
  public String hGp;
  public String hGq;
  public String hGr;
  public String hGs;
  public int hGt;
  public int hGu;
  public String hGv;
  public LinkedList<String> hGw;
  public int hGx;
  public ab hGy;
  public long time;
  public String title;
  public int type;
  public String url;
  public int videoHeight;
  public int videoWidth;
  
  public v()
  {
    AppMethodBeat.i(116417);
    this.hGw = new LinkedList();
    AppMethodBeat.o(116417);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116418);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.hGc != null) {
        paramVarArgs.d(3, this.hGc);
      }
      if (this.hGd != null) {
        paramVarArgs.d(4, this.hGd);
      }
      paramVarArgs.aZ(5, this.time);
      if (this.hGe != null) {
        paramVarArgs.d(6, this.hGe);
      }
      if (this.hGf != null) {
        paramVarArgs.d(7, this.hGf);
      }
      if (this.hGg != null) {
        paramVarArgs.d(8, this.hGg);
      }
      paramVarArgs.aS(9, this.type);
      paramVarArgs.aS(10, this.hGh);
      paramVarArgs.aS(11, this.hGi);
      if (this.hGj != null) {
        paramVarArgs.d(12, this.hGj);
      }
      if (this.hGk != null) {
        paramVarArgs.d(13, this.hGk);
      }
      paramVarArgs.aS(14, this.hGl);
      paramVarArgs.aS(15, this.hGm);
      if (this.hGn != null) {
        paramVarArgs.d(16, this.hGn);
      }
      if (this.hGo != null) {
        paramVarArgs.d(17, this.hGo);
      }
      if (this.hGp != null) {
        paramVarArgs.d(18, this.hGp);
      }
      if (this.hGq != null) {
        paramVarArgs.d(19, this.hGq);
      }
      if (this.hGr != null) {
        paramVarArgs.d(20, this.hGr);
      }
      if (this.hGs != null) {
        paramVarArgs.d(21, this.hGs);
      }
      paramVarArgs.aS(22, this.hGt);
      paramVarArgs.aS(23, this.hGu);
      if (this.hGv != null) {
        paramVarArgs.d(24, this.hGv);
      }
      paramVarArgs.aS(25, this.videoWidth);
      paramVarArgs.aS(26, this.videoHeight);
      if (this.hCa != null) {
        paramVarArgs.d(27, this.hCa);
      }
      paramVarArgs.e(28, 1, this.hGw);
      paramVarArgs.aS(30, this.hBY);
      paramVarArgs.aS(31, this.hGx);
      if (this.hGy != null)
      {
        paramVarArgs.lJ(32, this.hGy.computeSize());
        this.hGy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(116418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1958;
      }
    }
    label1958:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.hGc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hGc);
      }
      paramInt = i;
      if (this.hGd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hGd);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.time);
      paramInt = i;
      if (this.hGe != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hGe);
      }
      i = paramInt;
      if (this.hGf != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hGf);
      }
      paramInt = i;
      if (this.hGg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hGg);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.type) + f.a.a.b.b.a.bz(10, this.hGh) + f.a.a.b.b.a.bz(11, this.hGi);
      paramInt = i;
      if (this.hGj != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.hGj);
      }
      i = paramInt;
      if (this.hGk != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hGk);
      }
      i = i + f.a.a.b.b.a.bz(14, this.hGl) + f.a.a.b.b.a.bz(15, this.hGm);
      paramInt = i;
      if (this.hGn != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.hGn);
      }
      i = paramInt;
      if (this.hGo != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.hGo);
      }
      paramInt = i;
      if (this.hGp != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.hGp);
      }
      i = paramInt;
      if (this.hGq != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.hGq);
      }
      paramInt = i;
      if (this.hGr != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.hGr);
      }
      i = paramInt;
      if (this.hGs != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.hGs);
      }
      i = i + f.a.a.b.b.a.bz(22, this.hGt) + f.a.a.b.b.a.bz(23, this.hGu);
      paramInt = i;
      if (this.hGv != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.hGv);
      }
      i = paramInt + f.a.a.b.b.a.bz(25, this.videoWidth) + f.a.a.b.b.a.bz(26, this.videoHeight);
      paramInt = i;
      if (this.hCa != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.hCa);
      }
      i = paramInt + f.a.a.a.c(28, 1, this.hGw) + f.a.a.b.b.a.bz(30, this.hBY) + f.a.a.b.b.a.bz(31, this.hGx);
      paramInt = i;
      if (this.hGy != null) {
        paramInt = i + f.a.a.a.lI(32, this.hGy.computeSize());
      }
      AppMethodBeat.o(116418);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hGw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 29: 
        default: 
          AppMethodBeat.o(116418);
          return -1;
        case 1: 
          localv.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 2: 
          localv.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 3: 
          localv.hGc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 4: 
          localv.hGd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 5: 
          localv.time = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(116418);
          return 0;
        case 6: 
          localv.hGe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 7: 
          localv.hGf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 8: 
          localv.hGg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 9: 
          localv.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 10: 
          localv.hGh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 11: 
          localv.hGi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 12: 
          localv.hGj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 13: 
          localv.hGk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 14: 
          localv.hGl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 15: 
          localv.hGm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 16: 
          localv.hGn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 17: 
          localv.hGo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 18: 
          localv.hGp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 19: 
          localv.hGq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 20: 
          localv.hGr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 21: 
          localv.hGs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 22: 
          localv.hGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 23: 
          localv.hGu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 24: 
          localv.hGv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 25: 
          localv.videoWidth = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 26: 
          localv.videoHeight = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 27: 
          localv.hCa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 28: 
          localv.hGw.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(116418);
          return 0;
        case 30: 
          localv.hBY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 31: 
          localv.hGx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116418);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ab();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ab)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localv.hGy = ((ab)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116418);
        return 0;
      }
      AppMethodBeat.o(116418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.v
 * JD-Core Version:    0.7.0.1
 */