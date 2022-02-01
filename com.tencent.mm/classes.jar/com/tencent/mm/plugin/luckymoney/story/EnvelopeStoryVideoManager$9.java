package com.tencent.mm.plugin.luckymoney.story;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

final class EnvelopeStoryVideoManager$9
  implements View.OnTouchListener
{
  EnvelopeStoryVideoManager$9(EnvelopeStoryVideoManager paramEnvelopeStoryVideoManager) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(182467);
    paramView = (EnvelopeStoryVideoManager.c)EnvelopeStoryVideoManager.e(this.zaG).get(Integer.valueOf(EnvelopeStoryVideoManager.b(this.zaG)));
    if ((paramMotionEvent.getActionMasked() == 0) && (paramView != null))
    {
      Rect localRect = new Rect();
      paramView.zaV.getGlobalVisibleRect(localRect);
      if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
      {
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "the videoview are under actionbar ");
        paramView.zaW.callOnClick();
      }
      AppMethodBeat.o(182467);
      return true;
    }
    AppMethodBeat.o(182467);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.9
 * JD-Core Version:    0.7.0.1
 */