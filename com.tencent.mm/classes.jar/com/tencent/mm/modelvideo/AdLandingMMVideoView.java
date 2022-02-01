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
  protected boolean mbG;
  private i.a oXY;
  
  public AdLandingMMVideoView(Context paramContext)
  {
    super(paramContext);
    this.XXD = "VideoView.AdLandingMMVideoView";
  }
  
  public AdLandingMMVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.XXD = "VideoView.AdLandingMMVideoView";
  }
  
  public AdLandingMMVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.XXD = "VideoView.AdLandingMMVideoView";
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(241236);
    try
    {
      if (this.mbG)
      {
        Log.i(this.TAG, "seekTo adjust needPause[%b]", new Object[] { Boolean.valueOf(this.mbG) });
        paramBoolean = false;
      }
      paramBoolean = super.b(paramDouble, paramBoolean);
      AppMethodBeat.o(241236);
      return paramBoolean;
    }
    finally
    {
      Log.e(this.TAG, localObject.toString());
      AppMethodBeat.o(241236);
    }
    return false;
  }
  
  public final String bNL()
  {
    AppMethodBeat.i(241237);
    String str = this.oYq + " ";
    AppMethodBeat.o(241237);
    return str;
  }
  
  public final void bb(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(241233);
    try
    {
      if (Util.isEqual(this.oYq, paramString))
      {
        int i = this.oYs;
        if (i != 3) {}
      }
      else
      {
        AppMethodBeat.o(241233);
        return;
      }
      Log.i(this.TAG, "%s download finish [%d] needPause[%b]", new Object[] { bNL(), Integer.valueOf(paramInt), Boolean.valueOf(this.mbG) });
      if (paramInt == 0) {
        this.oYs = 3;
      }
      String str;
      if (this.oXY != null)
      {
        paramString = this.oXY;
        str = this.oYr;
        if (this.oYt <= 0) {
          break label157;
        }
      }
      for (;;)
      {
        paramString.bd(str, bool);
        Log.i(this.XXD, "onFinish");
        if (!this.mbG)
        {
          Log.i(this.XXD, "onFinish, startTimer, needPause is false");
          ho(true);
        }
        this.oYC = false;
        AppMethodBeat.o(241233);
        return;
        label157:
        bool = false;
      }
      return;
    }
    finally
    {
      Log.e(this.TAG, paramString.toString());
      AppMethodBeat.o(241233);
    }
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(241232);
    try
    {
      this.oYC = false;
      if ((paramLong1 <= -1L) || (paramLong2 <= -1L))
      {
        Log.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[] { bNL(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
        AppMethodBeat.o(241232);
        return;
      }
      boolean bool = Util.isEqual(this.oYq, paramString);
      if (!bool)
      {
        AppMethodBeat.o(241232);
        return;
      }
      try
      {
        this.oYz = this.oYu.eX((int)paramLong1, (int)paramLong2);
        Log.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d] needPause[%b]", new Object[] { bNL(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.oYz), Boolean.valueOf(this.mbG) });
        Log.i(this.XXD, "onDataAvailable");
        if (!this.mbG)
        {
          Log.i(this.XXD, "onDataAvailable, startTimer, needPause is false");
          ho(true);
        }
        AppMethodBeat.o(241232);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[] { bNL(), paramString.toString() });
        }
      }
      return;
    }
    finally
    {
      Log.e(this.TAG, paramString.toString());
      AppMethodBeat.o(241232);
    }
  }
  
  public void setIMMDownloadFinish(i.a parama)
  {
    this.oXY = parama;
  }
  
  public void setNeedPause(boolean paramBoolean)
  {
    this.mbG = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvideo.AdLandingMMVideoView
 * JD-Core Version:    0.7.0.1
 */