package com.tencent.mm.plugin.finder.live.olympic.certificate.widget;

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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateStateBackgroundView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CertificateStateBackgroundView
  extends AppCompatImageView
{
  public static final a CRo;
  
  static
  {
    AppMethodBeat.i(360940);
    CRo = new a((byte)0);
    AppMethodBeat.o(360940);
  }
  
  public CertificateStateBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(360935);
    setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramContext = a.CRW;
    a.a((ImageView)this, b.j.ahpc, p.d.BzF);
    AppMethodBeat.o(360935);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateStateBackgroundView$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.widget.CertificateStateBackgroundView
 * JD-Core Version:    0.7.0.1
 */