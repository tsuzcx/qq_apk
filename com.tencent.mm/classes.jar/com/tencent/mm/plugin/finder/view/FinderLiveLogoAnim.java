package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderLiveLogoAnim;", "Landroid/support/v7/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "type", "", "(Landroid/content/Context;I)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "init", "", "setAnimType", "setVisibility", "visibility", "startAnim", "stopAnim", "Companion", "plugin-finder_release"})
public final class FinderLiveLogoAnim
  extends AppCompatImageView
{
  private static final int wnq = 1;
  private static final int wnr = 2;
  private static final int wns = 3;
  public static final a wnt;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(254864);
    wnt = new a((byte)0);
    wnq = 1;
    wnr = 2;
    wns = 3;
    AppMethodBeat.o(254864);
  }
  
  public FinderLiveLogoAnim(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(254861);
    this.TAG = "Finder.LiveLogoAnim";
    setAnimType(paramInt);
    AppMethodBeat.o(254861);
  }
  
  public FinderLiveLogoAnim(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254862);
    this.TAG = "Finder.LiveLogoAnim";
    a(this);
    AppMethodBeat.o(254862);
  }
  
  public FinderLiveLogoAnim(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254863);
    this.TAG = "Finder.LiveLogoAnim";
    a(this);
    AppMethodBeat.o(254863);
  }
  
  private final void setAnimType(int paramInt)
  {
    AppMethodBeat.i(254857);
    cEA();
    if (paramInt == wnr)
    {
      setBackgroundResource(2131233366);
      AppMethodBeat.o(254857);
      return;
    }
    if (paramInt == wns)
    {
      setBackgroundResource(2131233364);
      AppMethodBeat.o(254857);
      return;
    }
    setBackgroundResource(2131233365);
    AppMethodBeat.o(254857);
  }
  
  public final void bWT()
  {
    AppMethodBeat.i(254859);
    Log.i(this.TAG, "startAnim");
    if ((getBackground() instanceof AnimationDrawable))
    {
      Object localObject = getBackground();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(254859);
        throw ((Throwable)localObject);
      }
      ((AnimationDrawable)localObject).start();
    }
    AppMethodBeat.o(254859);
  }
  
  public final void cEA()
  {
    AppMethodBeat.i(254860);
    Log.i(this.TAG, "stopAnim");
    if ((getBackground() instanceof AnimationDrawable))
    {
      Object localObject = getBackground();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(254860);
        throw ((Throwable)localObject);
      }
      localObject = (AnimationDrawable)localObject;
      if (((AnimationDrawable)localObject).isRunning()) {
        ((AnimationDrawable)localObject).stop();
      }
    }
    AppMethodBeat.o(254860);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(254858);
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      cEA();
    }
    AppMethodBeat.o(254858);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderLiveLogoAnim$Companion;", "", "()V", "ANIM_CARD", "", "getANIM_CARD", "()I", "ANIM_RED", "getANIM_RED", "ANIM_WHITE", "getANIM_WHITE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderLiveLogoAnim
 * JD-Core Version:    0.7.0.1
 */