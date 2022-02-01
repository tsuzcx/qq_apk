package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public String albumName;
  public String appId;
  public String appName;
  public int appType;
  public long createTime;
  public boolean dLQ;
  public long duration;
  public String psI;
  public long size;
  public String title;
  public String videoPath;
  public String videoUrl;
  public boolean xuJ;
  public boolean xuK;
  public String xuL;
  public String xuM;
  public String xuN;
  public LinkedList<l> xuO;
  public String xuP;
  
  public e()
  {
    AppMethodBeat.i(40868);
    this.xuO = new LinkedList();
    AppMethodBeat.o(40868);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40869);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.dLQ);
      paramVarArgs.cc(2, this.xuJ);
      paramVarArgs.cc(3, this.xuK);
      if (this.xuL != null) {
        paramVarArgs.e(4, this.xuL);
      }
      if (this.xuM != null) {
        paramVarArgs.e(5, this.xuM);
      }
      if (this.videoUrl != null) {
        paramVarArgs.e(6, this.videoUrl);
      }
      if (this.title != null) {
        paramVarArgs.e(7, this.title);
      }
      if (this.xuN != null) {
        paramVarArgs.e(8, this.xuN);
      }
      paramVarArgs.e(9, 8, this.xuO);
      paramVarArgs.bb(10, this.createTime);
      paramVarArgs.bb(11, this.duration);
      paramVarArgs.bb(12, this.size);
      if (this.appId != null) {
        paramVarArgs.e(13, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.e(14, this.appName);
      }
      paramVarArgs.aM(15, this.appType);
      if (this.videoPath != null) {
        paramVarArgs.e(16, this.videoPath);
      }
      if (this.albumName != null) {
        paramVarArgs.e(17, this.albumName);
      }
      if (this.psI != null) {
        paramVarArgs.e(18, this.psI);
      }
      if (this.xuP != null) {
        paramVarArgs.e(19, this.xuP);
      }
      AppMethodBeat.o(40869);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.fS(1) + 1 + 0 + (g.a.a.b.b.a.fS(2) + 1) + (g.a.a.b.b.a.fS(3) + 1);
      paramInt = i;
      if (this.xuL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xuL);
      }
      i = paramInt;
      if (this.xuM != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xuM);
      }
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.videoUrl);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.title);
      }
      paramInt = i;
      if (this.xuN != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.xuN);
      }
      i = paramInt + g.a.a.a.c(9, 8, this.xuO) + g.a.a.b.b.a.r(10, this.createTime) + g.a.a.b.b.a.r(11, this.duration) + g.a.a.b.b.a.r(12, this.size);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.appId);
      }
      i = paramInt;
      if (this.appName != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.appName);
      }
      i += g.a.a.b.b.a.bu(15, this.appType);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.videoPath);
      }
      i = paramInt;
      if (this.albumName != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.albumName);
      }
      paramInt = i;
      if (this.psI != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.psI);
      }
      i = paramInt;
      if (this.xuP != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.xuP);
      }
      AppMethodBeat.o(40869);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xuO.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(40869);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(40869);
        return -1;
      case 1: 
        locale.dLQ = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(40869);
        return 0;
      case 2: 
        locale.xuJ = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(40869);
        return 0;
      case 3: 
        locale.xuK = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(40869);
        return 0;
      case 4: 
        locale.xuL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 5: 
        locale.xuM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 6: 
        locale.videoUrl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 7: 
        locale.title = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 8: 
        locale.xuN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locale.xuO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(40869);
        return 0;
      case 10: 
        locale.createTime = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(40869);
        return 0;
      case 11: 
        locale.duration = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(40869);
        return 0;
      case 12: 
        locale.size = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(40869);
        return 0;
      case 13: 
        locale.appId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 14: 
        locale.appName = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 15: 
        locale.appType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(40869);
        return 0;
      case 16: 
        locale.videoPath = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 17: 
        locale.albumName = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 18: 
        locale.psI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(40869);
        return 0;
      }
      locale.xuP = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(40869);
      return 0;
    }
    AppMethodBeat.o(40869);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.e
 * JD-Core Version:    0.7.0.1
 */