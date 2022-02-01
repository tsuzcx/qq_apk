package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.cd.a
{
  public boolean Crb;
  public boolean Crc;
  public String Crd;
  public String Cre;
  public String Crf;
  public LinkedList<l> Crg;
  public String Crh;
  public String Cri;
  public String albumName;
  public String appId;
  public String appName;
  public int appType;
  public long createTime;
  public long duration;
  public boolean fEF;
  public long size;
  public String title;
  public String videoPath;
  public String videoUrl;
  
  public e()
  {
    AppMethodBeat.i(40868);
    this.Crg = new LinkedList();
    AppMethodBeat.o(40868);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40869);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.fEF);
      paramVarArgs.co(2, this.Crb);
      paramVarArgs.co(3, this.Crc);
      if (this.Crd != null) {
        paramVarArgs.f(4, this.Crd);
      }
      if (this.Cre != null) {
        paramVarArgs.f(5, this.Cre);
      }
      if (this.videoUrl != null) {
        paramVarArgs.f(6, this.videoUrl);
      }
      if (this.title != null) {
        paramVarArgs.f(7, this.title);
      }
      if (this.Crf != null) {
        paramVarArgs.f(8, this.Crf);
      }
      paramVarArgs.e(9, 8, this.Crg);
      paramVarArgs.bm(10, this.createTime);
      paramVarArgs.bm(11, this.duration);
      paramVarArgs.bm(12, this.size);
      if (this.appId != null) {
        paramVarArgs.f(13, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.f(14, this.appName);
      }
      paramVarArgs.aY(15, this.appType);
      if (this.videoPath != null) {
        paramVarArgs.f(16, this.videoPath);
      }
      if (this.albumName != null) {
        paramVarArgs.f(17, this.albumName);
      }
      if (this.Crh != null) {
        paramVarArgs.f(18, this.Crh);
      }
      if (this.Cri != null) {
        paramVarArgs.f(19, this.Cri);
      }
      AppMethodBeat.o(40869);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.gL(1) + 1 + 0 + (g.a.a.b.b.a.gL(2) + 1) + (g.a.a.b.b.a.gL(3) + 1);
      paramInt = i;
      if (this.Crd != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Crd);
      }
      i = paramInt;
      if (this.Cre != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Cre);
      }
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.videoUrl);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.title);
      }
      paramInt = i;
      if (this.Crf != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Crf);
      }
      i = paramInt + g.a.a.a.c(9, 8, this.Crg) + g.a.a.b.b.a.p(10, this.createTime) + g.a.a.b.b.a.p(11, this.duration) + g.a.a.b.b.a.p(12, this.size);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.appId);
      }
      i = paramInt;
      if (this.appName != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.appName);
      }
      i += g.a.a.b.b.a.bM(15, this.appType);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.videoPath);
      }
      i = paramInt;
      if (this.albumName != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.albumName);
      }
      paramInt = i;
      if (this.Crh != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.Crh);
      }
      i = paramInt;
      if (this.Cri != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.Cri);
      }
      AppMethodBeat.o(40869);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Crg.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(40869);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(40869);
        return -1;
      case 1: 
        locale.fEF = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(40869);
        return 0;
      case 2: 
        locale.Crb = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(40869);
        return 0;
      case 3: 
        locale.Crc = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(40869);
        return 0;
      case 4: 
        locale.Crd = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 5: 
        locale.Cre = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 6: 
        locale.videoUrl = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 7: 
        locale.title = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 8: 
        locale.Crf = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          l locall = new l();
          if ((localObject != null) && (localObject.length > 0)) {
            locall.parseFrom((byte[])localObject);
          }
          locale.Crg.add(locall);
          paramInt += 1;
        }
        AppMethodBeat.o(40869);
        return 0;
      case 10: 
        locale.createTime = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(40869);
        return 0;
      case 11: 
        locale.duration = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(40869);
        return 0;
      case 12: 
        locale.size = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(40869);
        return 0;
      case 13: 
        locale.appId = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 14: 
        locale.appName = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 15: 
        locale.appType = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(40869);
        return 0;
      case 16: 
        locale.videoPath = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 17: 
        locale.albumName = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 18: 
        locale.Crh = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(40869);
        return 0;
      }
      locale.Cri = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(40869);
      return 0;
    }
    AppMethodBeat.o(40869);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.e
 * JD-Core Version:    0.7.0.1
 */