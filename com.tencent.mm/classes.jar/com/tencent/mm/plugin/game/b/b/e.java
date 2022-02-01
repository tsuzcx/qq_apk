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
  public boolean dDV;
  public long duration;
  public long size;
  public String tRB;
  public String title;
  public boolean ucV;
  public boolean ucW;
  public String ucX;
  public String ucY;
  public String ucZ;
  public LinkedList<l> uda;
  public String udb;
  public String udc;
  public String videoPath;
  public String videoUrl;
  
  public e()
  {
    AppMethodBeat.i(40868);
    this.uda = new LinkedList();
    AppMethodBeat.o(40868);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40869);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.dDV);
      paramVarArgs.bC(2, this.ucV);
      paramVarArgs.bC(3, this.ucW);
      if (this.ucX != null) {
        paramVarArgs.d(4, this.ucX);
      }
      if (this.ucY != null) {
        paramVarArgs.d(5, this.ucY);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(6, this.videoUrl);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      if (this.ucZ != null) {
        paramVarArgs.d(8, this.ucZ);
      }
      paramVarArgs.e(9, 8, this.uda);
      paramVarArgs.aZ(10, this.createTime);
      paramVarArgs.aZ(11, this.duration);
      paramVarArgs.aZ(12, this.size);
      if (this.appId != null) {
        paramVarArgs.d(13, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.d(14, this.appName);
      }
      paramVarArgs.aS(15, this.appType);
      if (this.videoPath != null) {
        paramVarArgs.d(16, this.videoPath);
      }
      if (this.tRB != null) {
        paramVarArgs.d(17, this.tRB);
      }
      if (this.udb != null) {
        paramVarArgs.d(18, this.udb);
      }
      if (this.udc != null) {
        paramVarArgs.d(19, this.udc);
      }
      AppMethodBeat.o(40869);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.amF(1) + 0 + f.a.a.b.b.a.amF(2) + f.a.a.b.b.a.amF(3);
      paramInt = i;
      if (this.ucX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ucX);
      }
      i = paramInt;
      if (this.ucY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ucY);
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
      if (this.ucZ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ucZ);
      }
      i = paramInt + f.a.a.a.c(9, 8, this.uda) + f.a.a.b.b.a.p(10, this.createTime) + f.a.a.b.b.a.p(11, this.duration) + f.a.a.b.b.a.p(12, this.size);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.appId);
      }
      i = paramInt;
      if (this.appName != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.appName);
      }
      i += f.a.a.b.b.a.bz(15, this.appType);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.videoPath);
      }
      i = paramInt;
      if (this.tRB != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.tRB);
      }
      paramInt = i;
      if (this.udb != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.udb);
      }
      i = paramInt;
      if (this.udc != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.udc);
      }
      AppMethodBeat.o(40869);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.uda.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        locale.dDV = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(40869);
        return 0;
      case 2: 
        locale.ucV = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(40869);
        return 0;
      case 3: 
        locale.ucW = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(40869);
        return 0;
      case 4: 
        locale.ucX = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 5: 
        locale.ucY = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 6: 
        locale.videoUrl = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 7: 
        locale.title = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 8: 
        locale.ucZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.uda.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(40869);
        return 0;
      case 10: 
        locale.createTime = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(40869);
        return 0;
      case 11: 
        locale.duration = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(40869);
        return 0;
      case 12: 
        locale.size = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(40869);
        return 0;
      case 13: 
        locale.appId = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 14: 
        locale.appName = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 15: 
        locale.appType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(40869);
        return 0;
      case 16: 
        locale.videoPath = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 17: 
        locale.tRB = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 18: 
        locale.udb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(40869);
        return 0;
      }
      locale.udc = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(40869);
      return 0;
    }
    AppMethodBeat.o(40869);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.e
 * JD-Core Version:    0.7.0.1
 */