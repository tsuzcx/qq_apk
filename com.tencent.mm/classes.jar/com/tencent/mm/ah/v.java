package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class v
  extends com.tencent.mm.bw.a
{
  public int hhb;
  public String hhd;
  public String hlb;
  public String hlc;
  public String hld;
  public String hle;
  public String hlf;
  public int hlg;
  public int hlh;
  public String hli;
  public String hlj;
  public int hlk;
  public int hll;
  public String hlm;
  public String hln;
  public String hlo;
  public String hlp;
  public String hlq;
  public String hlr;
  public int hls;
  public int hlt;
  public String hlu;
  public LinkedList<String> hlv;
  public int hlw;
  public long time;
  public String title;
  public int type;
  public String url;
  public int videoHeight;
  public int videoWidth;
  
  public v()
  {
    AppMethodBeat.i(116417);
    this.hlv = new LinkedList();
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
      if (this.hlb != null) {
        paramVarArgs.d(3, this.hlb);
      }
      if (this.hlc != null) {
        paramVarArgs.d(4, this.hlc);
      }
      paramVarArgs.aO(5, this.time);
      if (this.hld != null) {
        paramVarArgs.d(6, this.hld);
      }
      if (this.hle != null) {
        paramVarArgs.d(7, this.hle);
      }
      if (this.hlf != null) {
        paramVarArgs.d(8, this.hlf);
      }
      paramVarArgs.aR(9, this.type);
      paramVarArgs.aR(10, this.hlg);
      paramVarArgs.aR(11, this.hlh);
      if (this.hli != null) {
        paramVarArgs.d(12, this.hli);
      }
      if (this.hlj != null) {
        paramVarArgs.d(13, this.hlj);
      }
      paramVarArgs.aR(14, this.hlk);
      paramVarArgs.aR(15, this.hll);
      if (this.hlm != null) {
        paramVarArgs.d(16, this.hlm);
      }
      if (this.hln != null) {
        paramVarArgs.d(17, this.hln);
      }
      if (this.hlo != null) {
        paramVarArgs.d(18, this.hlo);
      }
      if (this.hlp != null) {
        paramVarArgs.d(19, this.hlp);
      }
      if (this.hlq != null) {
        paramVarArgs.d(20, this.hlq);
      }
      if (this.hlr != null) {
        paramVarArgs.d(21, this.hlr);
      }
      paramVarArgs.aR(22, this.hls);
      paramVarArgs.aR(23, this.hlt);
      if (this.hlu != null) {
        paramVarArgs.d(24, this.hlu);
      }
      paramVarArgs.aR(25, this.videoWidth);
      paramVarArgs.aR(26, this.videoHeight);
      if (this.hhd != null) {
        paramVarArgs.d(27, this.hhd);
      }
      paramVarArgs.e(28, 1, this.hlv);
      paramVarArgs.aR(30, this.hhb);
      paramVarArgs.aR(31, this.hlw);
      AppMethodBeat.o(116418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1810;
      }
    }
    label1810:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.hlb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hlb);
      }
      paramInt = i;
      if (this.hlc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hlc);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.time);
      paramInt = i;
      if (this.hld != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hld);
      }
      i = paramInt;
      if (this.hle != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hle);
      }
      paramInt = i;
      if (this.hlf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hlf);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.type) + f.a.a.b.b.a.bx(10, this.hlg) + f.a.a.b.b.a.bx(11, this.hlh);
      paramInt = i;
      if (this.hli != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.hli);
      }
      i = paramInt;
      if (this.hlj != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hlj);
      }
      i = i + f.a.a.b.b.a.bx(14, this.hlk) + f.a.a.b.b.a.bx(15, this.hll);
      paramInt = i;
      if (this.hlm != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.hlm);
      }
      i = paramInt;
      if (this.hln != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.hln);
      }
      paramInt = i;
      if (this.hlo != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.hlo);
      }
      i = paramInt;
      if (this.hlp != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.hlp);
      }
      paramInt = i;
      if (this.hlq != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.hlq);
      }
      i = paramInt;
      if (this.hlr != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.hlr);
      }
      i = i + f.a.a.b.b.a.bx(22, this.hls) + f.a.a.b.b.a.bx(23, this.hlt);
      paramInt = i;
      if (this.hlu != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.hlu);
      }
      i = paramInt + f.a.a.b.b.a.bx(25, this.videoWidth) + f.a.a.b.b.a.bx(26, this.videoHeight);
      paramInt = i;
      if (this.hhd != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.hhd);
      }
      i = f.a.a.a.c(28, 1, this.hlv);
      int j = f.a.a.b.b.a.bx(30, this.hhb);
      int k = f.a.a.b.b.a.bx(31, this.hlw);
      AppMethodBeat.o(116418);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hlv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116418);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 29: 
        default: 
          AppMethodBeat.o(116418);
          return -1;
        case 1: 
          localv.title = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 2: 
          localv.url = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 3: 
          localv.hlb = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 4: 
          localv.hlc = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 5: 
          localv.time = locala.LVo.xG();
          AppMethodBeat.o(116418);
          return 0;
        case 6: 
          localv.hld = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 7: 
          localv.hle = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 8: 
          localv.hlf = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 9: 
          localv.type = locala.LVo.xF();
          AppMethodBeat.o(116418);
          return 0;
        case 10: 
          localv.hlg = locala.LVo.xF();
          AppMethodBeat.o(116418);
          return 0;
        case 11: 
          localv.hlh = locala.LVo.xF();
          AppMethodBeat.o(116418);
          return 0;
        case 12: 
          localv.hli = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 13: 
          localv.hlj = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 14: 
          localv.hlk = locala.LVo.xF();
          AppMethodBeat.o(116418);
          return 0;
        case 15: 
          localv.hll = locala.LVo.xF();
          AppMethodBeat.o(116418);
          return 0;
        case 16: 
          localv.hlm = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 17: 
          localv.hln = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 18: 
          localv.hlo = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 19: 
          localv.hlp = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 20: 
          localv.hlq = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 21: 
          localv.hlr = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 22: 
          localv.hls = locala.LVo.xF();
          AppMethodBeat.o(116418);
          return 0;
        case 23: 
          localv.hlt = locala.LVo.xF();
          AppMethodBeat.o(116418);
          return 0;
        case 24: 
          localv.hlu = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 25: 
          localv.videoWidth = locala.LVo.xF();
          AppMethodBeat.o(116418);
          return 0;
        case 26: 
          localv.videoHeight = locala.LVo.xF();
          AppMethodBeat.o(116418);
          return 0;
        case 27: 
          localv.hhd = locala.LVo.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 28: 
          localv.hlv.add(locala.LVo.readString());
          AppMethodBeat.o(116418);
          return 0;
        case 30: 
          localv.hhb = locala.LVo.xF();
          AppMethodBeat.o(116418);
          return 0;
        }
        localv.hlw = locala.LVo.xF();
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