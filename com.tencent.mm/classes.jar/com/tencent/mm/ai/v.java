package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class v
  extends com.tencent.mm.bx.a
{
  public String hDA;
  public int hDB;
  public int hDC;
  public String hDD;
  public LinkedList<String> hDE;
  public int hDF;
  public ab hDG;
  public String hDk;
  public String hDl;
  public String hDm;
  public String hDn;
  public String hDo;
  public int hDp;
  public int hDq;
  public String hDr;
  public String hDs;
  public int hDt;
  public int hDu;
  public String hDv;
  public String hDw;
  public String hDx;
  public String hDy;
  public String hDz;
  public int hzk;
  public String hzm;
  public long time;
  public String title;
  public int type;
  public String url;
  public int videoHeight;
  public int videoWidth;
  
  public v()
  {
    AppMethodBeat.i(116417);
    this.hDE = new LinkedList();
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
      if (this.hDk != null) {
        paramVarArgs.d(3, this.hDk);
      }
      if (this.hDl != null) {
        paramVarArgs.d(4, this.hDl);
      }
      paramVarArgs.aY(5, this.time);
      if (this.hDm != null) {
        paramVarArgs.d(6, this.hDm);
      }
      if (this.hDn != null) {
        paramVarArgs.d(7, this.hDn);
      }
      if (this.hDo != null) {
        paramVarArgs.d(8, this.hDo);
      }
      paramVarArgs.aS(9, this.type);
      paramVarArgs.aS(10, this.hDp);
      paramVarArgs.aS(11, this.hDq);
      if (this.hDr != null) {
        paramVarArgs.d(12, this.hDr);
      }
      if (this.hDs != null) {
        paramVarArgs.d(13, this.hDs);
      }
      paramVarArgs.aS(14, this.hDt);
      paramVarArgs.aS(15, this.hDu);
      if (this.hDv != null) {
        paramVarArgs.d(16, this.hDv);
      }
      if (this.hDw != null) {
        paramVarArgs.d(17, this.hDw);
      }
      if (this.hDx != null) {
        paramVarArgs.d(18, this.hDx);
      }
      if (this.hDy != null) {
        paramVarArgs.d(19, this.hDy);
      }
      if (this.hDz != null) {
        paramVarArgs.d(20, this.hDz);
      }
      if (this.hDA != null) {
        paramVarArgs.d(21, this.hDA);
      }
      paramVarArgs.aS(22, this.hDB);
      paramVarArgs.aS(23, this.hDC);
      if (this.hDD != null) {
        paramVarArgs.d(24, this.hDD);
      }
      paramVarArgs.aS(25, this.videoWidth);
      paramVarArgs.aS(26, this.videoHeight);
      if (this.hzm != null) {
        paramVarArgs.d(27, this.hzm);
      }
      paramVarArgs.e(28, 1, this.hDE);
      paramVarArgs.aS(30, this.hzk);
      paramVarArgs.aS(31, this.hDF);
      if (this.hDG != null)
      {
        paramVarArgs.lC(32, this.hDG.computeSize());
        this.hDG.writeFields(paramVarArgs);
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
      if (this.hDk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hDk);
      }
      paramInt = i;
      if (this.hDl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hDl);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.time);
      paramInt = i;
      if (this.hDm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hDm);
      }
      i = paramInt;
      if (this.hDn != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hDn);
      }
      paramInt = i;
      if (this.hDo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hDo);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.type) + f.a.a.b.b.a.bz(10, this.hDp) + f.a.a.b.b.a.bz(11, this.hDq);
      paramInt = i;
      if (this.hDr != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.hDr);
      }
      i = paramInt;
      if (this.hDs != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hDs);
      }
      i = i + f.a.a.b.b.a.bz(14, this.hDt) + f.a.a.b.b.a.bz(15, this.hDu);
      paramInt = i;
      if (this.hDv != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.hDv);
      }
      i = paramInt;
      if (this.hDw != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.hDw);
      }
      paramInt = i;
      if (this.hDx != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.hDx);
      }
      i = paramInt;
      if (this.hDy != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.hDy);
      }
      paramInt = i;
      if (this.hDz != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.hDz);
      }
      i = paramInt;
      if (this.hDA != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.hDA);
      }
      i = i + f.a.a.b.b.a.bz(22, this.hDB) + f.a.a.b.b.a.bz(23, this.hDC);
      paramInt = i;
      if (this.hDD != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.hDD);
      }
      i = paramInt + f.a.a.b.b.a.bz(25, this.videoWidth) + f.a.a.b.b.a.bz(26, this.videoHeight);
      paramInt = i;
      if (this.hzm != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.hzm);
      }
      i = paramInt + f.a.a.a.c(28, 1, this.hDE) + f.a.a.b.b.a.bz(30, this.hzk) + f.a.a.b.b.a.bz(31, this.hDF);
      paramInt = i;
      if (this.hDG != null) {
        paramInt = i + f.a.a.a.lB(32, this.hDG.computeSize());
      }
      AppMethodBeat.o(116418);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hDE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          localv.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 2: 
          localv.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 3: 
          localv.hDk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 4: 
          localv.hDl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 5: 
          localv.time = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(116418);
          return 0;
        case 6: 
          localv.hDm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 7: 
          localv.hDn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 8: 
          localv.hDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 9: 
          localv.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 10: 
          localv.hDp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 11: 
          localv.hDq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 12: 
          localv.hDr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 13: 
          localv.hDs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 14: 
          localv.hDt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 15: 
          localv.hDu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 16: 
          localv.hDv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 17: 
          localv.hDw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 18: 
          localv.hDx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 19: 
          localv.hDy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 20: 
          localv.hDz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 21: 
          localv.hDA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 22: 
          localv.hDB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 23: 
          localv.hDC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 24: 
          localv.hDD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 25: 
          localv.videoWidth = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 26: 
          localv.videoHeight = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 27: 
          localv.hzm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 28: 
          localv.hDE.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(116418);
          return 0;
        case 30: 
          localv.hzk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116418);
          return 0;
        case 31: 
          localv.hDF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116418);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ab();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ab)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localv.hDG = ((ab)localObject1);
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
 * Qualified Name:     com.tencent.mm.ai.v
 * JD-Core Version:    0.7.0.1
 */