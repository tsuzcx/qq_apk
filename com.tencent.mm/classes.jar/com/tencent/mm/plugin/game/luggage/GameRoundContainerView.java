package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.at;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/game/luggage/GameRoundContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "path", "Landroid/graphics/Path;", "radius", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "luggage-game_release"})
public final class GameRoundContainerView
  extends FrameLayout
{
  private Path lR;
  private int radius;
  
  public GameRoundContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(187025);
    this.radius = at.fromDPToPix(paramContext, 12);
    AppMethodBeat.o(187025);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(187024);
    p.h(paramCanvas, "canvas");
    Path localPath = this.lR;
    if (localPath == null) {
      p.btv("path");
    }
    paramCanvas.clipPath(localPath);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(187024);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(187023);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.lR = new Path();
    Path localPath = this.lR;
    if (localPath == null) {
      p.btv("path");
    }
    localPath.addArc(0.0F, 0.0F, 2.0F * this.radius, 2.0F * this.radius, 180.0F, 90.0F);
    localPath = this.lR;
    if (localPath == null) {
      p.btv("path");
    }
    localPath.lineTo(paramInt1 - this.radius, 0.0F);
    localPath = this.lR;
    if (localPath == null) {
      p.btv("path");
    }
    localPath.addArc(paramInt1 - 2.0F * this.radius, 0.0F, paramInt1, 2.0F * this.radius, 270.0F, 90.0F);
    localPath = this.lR;
    if (localPath == null) {
      p.btv("path");
    }
    localPath.lineTo(paramInt1, paramInt2);
    localPath = this.lR;
    if (localPath == null) {
      p.btv("path");
    }
    localPath.lineTo(0.0F, paramInt2);
    localPath = this.lR;
    if (localPath == null) {
      p.btv("path");
    }
    localPath.lineTo(0.0F, this.radius);
    AppMethodBeat.o(187023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.GameRoundContainerView
 * JD-Core Version:    0.7.0.1
 */