package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aw;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/luggage/GameRoundContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "path", "Landroid/graphics/Path;", "radius", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "luggage-game_release"})
public final class GameRoundContainerView
  extends FrameLayout
{
  private Path aBZ;
  private int radius;
  
  public GameRoundContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(231376);
    this.radius = aw.fromDPToPix(paramContext, 12);
    AppMethodBeat.o(231376);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(231374);
    p.k(paramCanvas, "canvas");
    Path localPath = this.aBZ;
    if (localPath == null) {
      p.bGy("path");
    }
    paramCanvas.clipPath(localPath);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(231374);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(231372);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.aBZ = new Path();
    Path localPath = this.aBZ;
    if (localPath == null) {
      p.bGy("path");
    }
    localPath.addArc(0.0F, 0.0F, 2.0F * this.radius, 2.0F * this.radius, 180.0F, 90.0F);
    localPath = this.aBZ;
    if (localPath == null) {
      p.bGy("path");
    }
    localPath.lineTo(paramInt1 - this.radius, 0.0F);
    localPath = this.aBZ;
    if (localPath == null) {
      p.bGy("path");
    }
    localPath.addArc(paramInt1 - 2.0F * this.radius, 0.0F, paramInt1, 2.0F * this.radius, 270.0F, 90.0F);
    localPath = this.aBZ;
    if (localPath == null) {
      p.bGy("path");
    }
    localPath.lineTo(paramInt1, paramInt2);
    localPath = this.aBZ;
    if (localPath == null) {
      p.bGy("path");
    }
    localPath.lineTo(0.0F, paramInt2);
    localPath = this.aBZ;
    if (localPath == null) {
      p.bGy("path");
    }
    localPath.lineTo(0.0F, this.radius);
    AppMethodBeat.o(231372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.GameRoundContainerView
 * JD-Core Version:    0.7.0.1
 */