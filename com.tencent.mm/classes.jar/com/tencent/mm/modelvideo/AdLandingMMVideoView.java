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
  protected boolean gRx;
  private i.a jpL;
  
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
  
  public final void ax(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(240840);
    try
    {
      if (Util.isEqual(this.jpT, paramString))
      {
        int i = this.jpV;
        if (i != 3) {}
      }
      else
      {
        AppMethodBeat.o(240840);
        return;
      }
      Log.i(this.TAG, "%s download finish [%d] needPause[%b]", new Object[] { bgQ(), Integer.valueOf(paramInt), Boolean.valueOf(this.gRx) });
      if (paramInt == 0) {
        this.jpV = 3;
      }
      String str;
      if (this.jpL != null)
      {
        paramString = this.jpL;
        str = this.jpU;
        if (this.jpW <= 0) {
          break label139;
        }
      }
      for (;;)
      {
        paramString.aO(str, bool);
        if (!this.gRx) {
          fO(true);
        }
        this.jqf = false;
        AppMethodBeat.o(240840);
        return;
        label139:
        bool = false;
      }
      return;
    }
    catch (Throwable paramString)
    {
      Log.e(this.TAG, paramString.toString());
      AppMethodBeat.o(240840);
    }
  }
  
  public final String bgQ()
  {
    AppMethodBeat.i(240842);
    String str = this.jpT + " ";
    AppMethodBeat.o(240842);
    return str;
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(240841);
    try
    {
      if (this.gRx)
      {
        Log.i(this.TAG, "seekTo adjust needPause[%b]", new Object[] { Boolean.valueOf(this.gRx) });
        paramBoolean = false;
      }
      paramBoolean = super.c(paramDouble, paramBoolean);
      AppMethodBeat.o(240841);
      return paramBoolean;
    }
    catch (Throwable localThrowable)
    {
      Log.e(this.TAG, localThrowable.toString());
      AppMethodBeat.o(240841);
    }
    return false;
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(240839);
    try
    {
      this.jqf = false;
      if ((paramLong1 <= -1L) || (paramLong2 <= -1L))
      {
        Log.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[] { bgQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
        AppMethodBeat.o(240839);
        return;
      }
      boolean bool = Util.isEqual(this.jpT, paramString);
      if (!bool)
      {
        AppMethodBeat.o(240839);
        return;
      }
      try
      {
        this.jqc = this.jpX.dG((int)paramLong1, (int)paramLong2);
        Log.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d] needPause[%b]", new Object[] { bgQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.jqc), Boolean.valueOf(this.gRx) });
        if (!this.gRx) {
          fO(true);
        }
        AppMethodBeat.o(240839);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[] { bgQ(), paramString.toString() });
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      Log.e(this.TAG, paramString.toString());
      AppMethodBeat.o(240839);
    }
  }
  
  public void setIMMDownloadFinish(i.a parama)
  {
    this.jpL = parama;
  }
  
  public void setNeedPause(boolean paramBoolean)
  {
    this.gRx = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvideo.AdLandingMMVideoView
 * JD-Core Version:    0.7.0.1
 */