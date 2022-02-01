package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class AdLandingMMVideoView
  extends MMVideoView
{
  protected boolean jBT;
  private i.a mfg;
  
  public AdLandingMMVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdLandingMMVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdLandingMMVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(216361);
    try
    {
      if (this.jBT)
      {
        Log.i(this.TAG, "seekTo adjust needPause[%b]", new Object[] { Boolean.valueOf(this.jBT) });
        paramBoolean = false;
      }
      paramBoolean = super.a(paramDouble, paramBoolean);
      AppMethodBeat.o(216361);
      return paramBoolean;
    }
    catch (Throwable localThrowable)
    {
      Log.e(this.TAG, localThrowable.toString());
      AppMethodBeat.o(216361);
    }
    return false;
  }
  
  public final void aP(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(216359);
    try
    {
      if (Util.isEqual(this.mfu, paramString))
      {
        int i = this.mfw;
        if (i != 3) {}
      }
      else
      {
        AppMethodBeat.o(216359);
        return;
      }
      Log.i(this.TAG, "%s download finish [%d] needPause[%b]", new Object[] { bqf(), Integer.valueOf(paramInt), Boolean.valueOf(this.jBT) });
      if (paramInt == 0) {
        this.mfw = 3;
      }
      String str;
      if (this.mfg != null)
      {
        paramString = this.mfg;
        str = this.mfv;
        if (this.mfx <= 0) {
          break label139;
        }
      }
      for (;;)
      {
        paramString.aR(str, bool);
        if (!this.jBT) {
          gA(true);
        }
        this.mfG = false;
        AppMethodBeat.o(216359);
        return;
        label139:
        bool = false;
      }
      return;
    }
    catch (Throwable paramString)
    {
      Log.e(this.TAG, paramString.toString());
      AppMethodBeat.o(216359);
    }
  }
  
  public final String bqf()
  {
    AppMethodBeat.i(216363);
    String str = this.mfu + " ";
    AppMethodBeat.o(216363);
    return str;
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(216357);
    try
    {
      this.mfG = false;
      if ((paramLong1 <= -1L) || (paramLong2 <= -1L))
      {
        Log.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[] { bqf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
        AppMethodBeat.o(216357);
        return;
      }
      boolean bool = Util.isEqual(this.mfu, paramString);
      if (!bool)
      {
        AppMethodBeat.o(216357);
        return;
      }
      try
      {
        this.mfD = this.mfy.ee((int)paramLong1, (int)paramLong2);
        Log.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d] needPause[%b]", new Object[] { bqf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.mfD), Boolean.valueOf(this.jBT) });
        if (!this.jBT) {
          gA(true);
        }
        AppMethodBeat.o(216357);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[] { bqf(), paramString.toString() });
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      Log.e(this.TAG, paramString.toString());
      AppMethodBeat.o(216357);
    }
  }
  
  public void setIMMDownloadFinish(i.a parama)
  {
    this.mfg = parama;
  }
  
  public void setNeedPause(boolean paramBoolean)
  {
    this.jBT = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.AdLandingMMVideoView
 * JD-Core Version:    0.7.0.1
 */