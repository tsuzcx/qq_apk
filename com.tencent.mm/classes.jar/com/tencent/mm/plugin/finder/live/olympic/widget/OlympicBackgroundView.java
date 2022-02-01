package com.tencent.mm.plugin.finder.live.olympic.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.olympic.util.a;
import com.tencent.mm.plugin.finder.live.p.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/OlympicBackgroundView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OlympicBackgroundView
  extends AppCompatImageView
{
  public static final a CTh;
  
  static
  {
    AppMethodBeat.i(360731);
    CTh = new a((byte)0);
    AppMethodBeat.o(360731);
  }
  
  public OlympicBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(360727);
    setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramContext = a.CRW;
    a.a((ImageView)this, b.j.ahoX, p.d.Bzw);
    AppMethodBeat.o(360727);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/OlympicBackgroundView$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.widget.OlympicBackgroundView
 * JD-Core Version:    0.7.0.1
 */