package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public String appId;
  public String appName;
  public int appType;
  public long createTime;
  public boolean dqZ;
  public long duration;
  public String sJZ;
  public boolean sVA;
  public String sVB;
  public String sVC;
  public String sVD;
  public LinkedList<l> sVE;
  public String sVF;
  public String sVG;
  public boolean sVz;
  public long size;
  public String title;
  public String videoPath;
  public String videoUrl;
  
  public e()
  {
    AppMethodBeat.i(40868);
    this.sVE = new LinkedList();
    AppMethodBeat.o(40868);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40869);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.dqZ);
      paramVarArgs.bl(2, this.sVz);
      paramVarArgs.bl(3, this.sVA);
      if (this.sVB != null) {
        paramVarArgs.d(4, this.sVB);
      }
      if (this.sVC != null) {
        paramVarArgs.d(5, this.sVC);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(6, this.videoUrl);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      if (this.sVD != null) {
        paramVarArgs.d(8, this.sVD);
      }
      paramVarArgs.e(9, 8, this.sVE);
      paramVarArgs.aO(10, this.createTime);
      paramVarArgs.aO(11, this.duration);
      paramVarArgs.aO(12, this.size);
      if (this.appId != null) {
        paramVarArgs.d(13, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.d(14, this.appName);
      }
      paramVarArgs.aR(15, this.appType);
      if (this.videoPath != null) {
        paramVarArgs.d(16, this.videoPath);
      }
      if (this.sJZ != null) {
        paramVarArgs.d(17, this.sJZ);
      }
      if (this.sVF != null) {
        paramVarArgs.d(18, this.sVF);
      }
      if (this.sVG != null) {
        paramVarArgs.d(19, this.sVG);
      }
      AppMethodBeat.o(40869);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.fK(1) + 1 + 0 + (f.a.a.b.b.a.fK(2) + 1) + (f.a.a.b.b.a.fK(3) + 1);
      paramInt = i;
      if (this.sVB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sVB);
      }
      i = paramInt;
      if (this.sVC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sVC);
      }
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.videoUrl);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.title);
      }
      paramInt = i;
      if (this.sVD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.sVD);
      }
      i = paramInt + f.a.a.a.c(9, 8, this.sVE) + f.a.a.b.b.a.p(10, this.createTime) + f.a.a.b.b.a.p(11, this.duration) + f.a.a.b.b.a.p(12, this.size);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.appId);
      }
      i = paramInt;
      if (this.appName != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.appName);
      }
      i += f.a.a.b.b.a.bx(15, this.appType);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.videoPath);
      }
      i = paramInt;
      if (this.sJZ != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.sJZ);
      }
      paramInt = i;
      if (this.sVF != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.sVF);
      }
      i = paramInt;
      if (this.sVG != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.sVG);
      }
      AppMethodBeat.o(40869);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sVE.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(40869);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(40869);
        return -1;
      case 1: 
        locale.dqZ = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(40869);
        return 0;
      case 2: 
        locale.sVz = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(40869);
        return 0;
      case 3: 
        locale.sVA = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(40869);
        return 0;
      case 4: 
        locale.sVB = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 5: 
        locale.sVC = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 6: 
        locale.videoUrl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 7: 
        locale.title = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 8: 
        locale.sVD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.sVE.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(40869);
        return 0;
      case 10: 
        locale.createTime = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(40869);
        return 0;
      case 11: 
        locale.duration = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(40869);
        return 0;
      case 12: 
        locale.size = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(40869);
        return 0;
      case 13: 
        locale.appId = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 14: 
        locale.appName = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 15: 
        locale.appType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(40869);
        return 0;
      case 16: 
        locale.videoPath = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 17: 
        locale.sJZ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 18: 
        locale.sVF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(40869);
        return 0;
      }
      locale.sVG = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(40869);
      return 0;
    }
    AppMethodBeat.o(40869);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.e
 * JD-Core Version:    0.7.0.1
 */