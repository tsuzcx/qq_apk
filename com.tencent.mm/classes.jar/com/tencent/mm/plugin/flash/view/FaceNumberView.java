package com.tencent.mm.plugin.flash.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceNumberView
  extends RelativeLayout
{
  View BCk;
  TextView BCl;
  Animation BCm;
  
  public FaceNumberView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private FaceNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(189907);
    this.BCm = new AlphaAnimation(0.0F, 1.0F);
    LayoutInflater.from(getContext()).inflate(a.g.face_flash_number_view, this, true);
    setGravity(17);
    this.BCk = findViewById(a.e.face_flash_white_dot);
    this.BCl = ((TextView)findViewById(a.e.face_flash_num_view));
    AppMethodBeat.o(189907);
  }
  
  public final void release()
  {
    AppMethodBeat.i(189911);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194515);
        Log.i("MicroMsg.FaceFlashManagerNumberView", "release");
        FaceNumberView.a(FaceNumberView.this).cancel();
        FaceNumberView.b(FaceNumberView.this).clearAnimation();
        AppMethodBeat.o(194515);
      }
    });
    AppMethodBeat.o(189911);
  }
  
  public void setNumber(String paramString)
  {
    AppMethodBeat.i(189909);
    Log.i("MicroMsg.FaceFlashManagerNumberView", "setNumber :%s", new Object[] { paramString });
    this.BCl.setText(paramString);
    AppMethodBeat.o(189909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.view.FaceNumberView
 * JD-Core Version:    0.7.0.1
 */