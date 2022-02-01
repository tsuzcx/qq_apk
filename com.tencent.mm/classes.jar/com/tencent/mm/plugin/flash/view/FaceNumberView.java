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
import com.tencent.mm.sdk.platformtools.Log;

public class FaceNumberView
  extends RelativeLayout
{
  View wIS;
  TextView wIT;
  Animation wIU;
  
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
    AppMethodBeat.i(186715);
    this.wIU = new AlphaAnimation(0.0F, 1.0F);
    LayoutInflater.from(getContext()).inflate(2131494070, this, true);
    setGravity(17);
    this.wIS = findViewById(2131300345);
    this.wIT = ((TextView)findViewById(2131300343));
    AppMethodBeat.o(186715);
  }
  
  public final void release()
  {
    AppMethodBeat.i(186717);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186714);
        Log.i("MicroMsg.FaceFlashManagerNumberView", "release");
        FaceNumberView.a(FaceNumberView.this).cancel();
        FaceNumberView.b(FaceNumberView.this).clearAnimation();
        AppMethodBeat.o(186714);
      }
    });
    AppMethodBeat.o(186717);
  }
  
  public void setNumber(String paramString)
  {
    AppMethodBeat.i(186716);
    Log.i("MicroMsg.FaceFlashManagerNumberView", "setNumber :%s", new Object[] { paramString });
    this.wIT.setText(paramString);
    AppMethodBeat.o(186716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.view.FaceNumberView
 * JD-Core Version:    0.7.0.1
 */