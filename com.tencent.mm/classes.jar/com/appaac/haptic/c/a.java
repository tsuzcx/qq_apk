package com.appaac.haptic.c;

import com.appaac.haptic.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;

public final class a
{
  public int cqG;
  public int cqH;
  public int cqI;
  public String crF;
  public int crG;
  public com.appaac.haptic.b.a.c crH;
  public com.appaac.haptic.sync.a crI;
  public int crJ;
  public File crK;
  public long mStartTime;
  public int mStatus;
  
  public static boolean a(com.appaac.haptic.b.a.c paramc)
  {
    AppMethodBeat.i(208339);
    if (paramc == null)
    {
      AppMethodBeat.o(208339);
      return false;
    }
    if (1 == paramc.getVersion())
    {
      paramc = (com.appaac.haptic.b.b.a)paramc;
      if ((paramc == null) || (paramc.cry == null) || (paramc.cry.size() <= 0) || (((e)paramc.cry.get(0)).crw == null))
      {
        AppMethodBeat.o(208339);
        return false;
      }
      AppMethodBeat.o(208339);
      return true;
    }
    if (2 == paramc.getVersion())
    {
      paramc = (com.appaac.haptic.b.c.a)paramc;
      if ((paramc == null) || (paramc.crD == null) || (paramc.crD.size() <= 0) || (((com.appaac.haptic.b.c.c)paramc.crD.get(0)).cry == null) || (((com.appaac.haptic.b.c.c)paramc.crD.get(0)).cry.size() <= 0) || (((e)((com.appaac.haptic.b.c.c)paramc.crD.get(0)).cry.get(0)).crw == null))
      {
        AppMethodBeat.o(208339);
        return false;
      }
      AppMethodBeat.o(208339);
      return true;
    }
    AppMethodBeat.o(208339);
    return false;
  }
  
  public final void reset()
  {
    this.crF = null;
    this.mStartTime = 0L;
    this.crG = 0;
    this.cqH = 0;
    this.cqI = 0;
    this.cqG = 0;
    this.crH = null;
    this.crI = null;
    this.crJ = 0;
    this.mStatus = 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208355);
    String str = "CurrentPlayingHeInfo{mHeString='" + this.crF + '\'' + ", mStartTime=" + this.mStartTime + ", mLoop=" + this.crG + ", mAmplitude=" + this.cqH + ", mFreq=" + this.cqI + ", mHeRoot=" + this.crH + ", mSyncCallback=" + this.crI + ", mStartPosition=" + this.crJ + ", mStatus:" + this.mStatus + '}';
    AppMethodBeat.o(208355);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.c.a
 * JD-Core Version:    0.7.0.1
 */