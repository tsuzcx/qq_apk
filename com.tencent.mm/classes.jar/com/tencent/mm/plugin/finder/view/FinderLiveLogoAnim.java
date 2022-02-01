package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderLiveLogoAnim;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "type", "", "(Landroid/content/Context;I)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "init", "", "setAnimType", "setVisibility", "visibility", "startAnim", "stopAnim", "Companion", "plugin-finder_release"})
public final class FinderLiveLogoAnim
  extends AppCompatImageView
{
  private static final int AYw = 1;
  private static final int AYx = 2;
  private static final int AYy = 3;
  public static final a AYz;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(285869);
    AYz = new a((byte)0);
    AYw = 1;
    AYx = 2;
    AYy = 3;
    AppMethodBeat.o(285869);
  }
  
  public FinderLiveLogoAnim(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(285866);
    this.TAG = "Finder.LiveLogoAnim";
    setAnimType(paramInt);
    AppMethodBeat.o(285866);
  }
  
  public FinderLiveLogoAnim(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(285867);
    this.TAG = "Finder.LiveLogoAnim";
    a(this);
    AppMethodBeat.o(285867);
  }
  
  public FinderLiveLogoAnim(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(285868);
    this.TAG = "Finder.LiveLogoAnim";
    a(this);
    AppMethodBeat.o(285868);
  }
  
  private final void setAnimType(int paramInt)
  {
    AppMethodBeat.i(285862);
    cTg();
    if (paramInt == AYx)
    {
      setBackgroundResource(b.e.live_logo_anim_white);
      AppMethodBeat.o(285862);
      return;
    }
    if (paramInt == AYy)
    {
      setBackgroundResource(b.e.live_logo_anim_card);
      AppMethodBeat.o(285862);
      return;
    }
    setBackgroundResource(b.e.live_logo_anim_red);
    AppMethodBeat.o(285862);
  }
  
  public final void cTg()
  {
    AppMethodBeat.i(285865);
    Log.i(this.TAG, "stopAnim");
    if ((getBackground() instanceof AnimationDrawable))
    {
      Object localObject = getBackground();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(285865);
        throw ((Throwable)localObject);
      }
      localObject = (AnimationDrawable)localObject;
      if (((AnimationDrawable)localObject).isRunning()) {
        ((AnimationDrawable)localObject).stop();
      }
    }
    AppMethodBeat.o(285865);
  }
  
  public final void cjx()
  {
    AppMethodBeat.i(285864);
    Log.i(this.TAG, "startAnim");
    if ((getBackground() instanceof AnimationDrawable))
    {
      Object localObject = getBackground();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(285864);
        throw ((Throwable)localObject);
      }
      ((AnimationDrawable)localObject).start();
    }
    AppMethodBeat.o(285864);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(285863);
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      cTg();
    }
    AppMethodBeat.o(285863);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderLiveLogoAnim$Companion;", "", "()V", "ANIM_CARD", "", "getANIM_CARD", "()I", "ANIM_RED", "getANIM_RED", "ANIM_WHITE", "getANIM_WHITE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderLiveLogoAnim
 * JD-Core Version:    0.7.0.1
 */