package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.l;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.plugin.emojicapture.model.a.b;
import com.tencent.mm.ui.e.a;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class CaptureDecoration$c
  implements Runnable
{
  CaptureDecoration$c(CaptureDecoration paramCaptureDecoration) {}
  
  public final void run()
  {
    AppMethodBeat.i(2990);
    CaptureDecoration localCaptureDecoration = this.lyE;
    localCaptureDecoration.lyv.setVisibility(8);
    localCaptureDecoration.lyx.setVisibility(0);
    localCaptureDecoration.lyx.animate().cancel();
    localCaptureDecoration.lyx.setAlpha(1.0F);
    Object localObject = localCaptureDecoration.ltF;
    if (localObject != null)
    {
      localCaptureDecoration.lyz.setText((CharSequence)((b)localObject).kqb);
      a locala = new a();
      localObject = ((Iterable)((b)localObject).ltK).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        locala.addFrame((Drawable)new BitmapDrawable(localCaptureDecoration.getResources(), str), 300);
      }
      localCaptureDecoration.lyy.setImageDrawable((Drawable)locala);
      locala.start();
    }
    localCaptureDecoration.postDelayed(localCaptureDecoration.lyD, 2000L);
    AppMethodBeat.o(2990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration.c
 * JD-Core Version:    0.7.0.1
 */