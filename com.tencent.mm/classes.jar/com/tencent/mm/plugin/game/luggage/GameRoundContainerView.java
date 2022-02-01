package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/luggage/GameRoundContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "path", "Landroid/graphics/Path;", "radius", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "luggage-game_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameRoundContainerView
  extends FrameLayout
{
  private Path path;
  private int radius;
  
  public GameRoundContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(277009);
    this.radius = bd.fromDPToPix(paramContext, 12);
    AppMethodBeat.o(277009);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(277014);
    s.u(paramCanvas, "canvas");
    Path localPath2 = this.path;
    Path localPath1 = localPath2;
    if (localPath2 == null)
    {
      s.bIx("path");
      localPath1 = null;
    }
    paramCanvas.clipPath(localPath1);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(277014);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(277012);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.path = new Path();
    Path localPath2 = this.path;
    Path localPath1 = localPath2;
    if (localPath2 == null)
    {
      s.bIx("path");
      localPath1 = null;
    }
    localPath1.addArc(0.0F, 0.0F, 2.0F * this.radius, 2.0F * this.radius, 180.0F, 90.0F);
    localPath2 = this.path;
    localPath1 = localPath2;
    if (localPath2 == null)
    {
      s.bIx("path");
      localPath1 = null;
    }
    localPath1.lineTo(paramInt1 - this.radius, 0.0F);
    localPath2 = this.path;
    localPath1 = localPath2;
    if (localPath2 == null)
    {
      s.bIx("path");
      localPath1 = null;
    }
    localPath1.addArc(paramInt1 - 2.0F * this.radius, 0.0F, paramInt1, 2.0F * this.radius, 270.0F, 90.0F);
    localPath2 = this.path;
    localPath1 = localPath2;
    if (localPath2 == null)
    {
      s.bIx("path");
      localPath1 = null;
    }
    localPath1.lineTo(paramInt1, paramInt2);
    localPath2 = this.path;
    localPath1 = localPath2;
    if (localPath2 == null)
    {
      s.bIx("path");
      localPath1 = null;
    }
    localPath1.lineTo(0.0F, paramInt2);
    localPath2 = this.path;
    localPath1 = localPath2;
    if (localPath2 == null)
    {
      s.bIx("path");
      localPath1 = null;
    }
    localPath1.lineTo(0.0F, this.radius);
    AppMethodBeat.o(277012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.GameRoundContainerView
 * JD-Core Version:    0.7.0.1
 */