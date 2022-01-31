package com.tencent.mm.plugin.facedetectlight.ui.a;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetectlight.ui.FaceReflectMask;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMTextureView;

public final class a$1
  implements Runnable
{
  public a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(823);
    Object localObject = (ViewGroup.MarginLayoutParams)this.mso.msl.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(this.mso.mrG.getWidth() * 0.8D));
    ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(this.mso.mrG.getWidth() * 0.8D));
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(this.mso.mrG.getHeight() * 0.4D - this.mso.mrG.getWidth() * 0.4D));
    this.mso.msl.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mso.msl.setVisibility(0);
    this.mso.mqV.setVisibility(0);
    this.mso.mqX.setVisibility(0);
    localObject = this.mso;
    ab.i(((a)localObject).TAG, "beginLoadAnimation()");
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1000L);
    ((a)localObject).msl.startAnimation(localRotateAnimation);
    AppMethodBeat.o(823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a.a.1
 * JD-Core Version:    0.7.0.1
 */