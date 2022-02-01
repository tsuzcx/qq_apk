package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.aq;

public class MPCommonVideoView
  extends CommonVideoView
{
  public MPCommonVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MPCommonVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void tO(long paramLong)
  {
    AppMethodBeat.i(6259);
    super.tO(paramLong);
    this.gKO.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6258);
        if (MPCommonVideoView.a(MPCommonVideoView.this) != null) {
          MPCommonVideoView.b(MPCommonVideoView.this).setOneTimeVideoTextureUpdateCallback(MPCommonVideoView.this);
        }
        AppMethodBeat.o(6258);
      }
    }, paramLong);
    AppMethodBeat.o(6259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPCommonVideoView
 * JD-Core Version:    0.7.0.1
 */