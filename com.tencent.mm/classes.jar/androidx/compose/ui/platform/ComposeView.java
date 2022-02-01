package androidx.compose.ui.platform;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ComposeView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "<set-?>", "", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow$annotations", "()V", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "Content", "(Landroidx/compose/runtime/Composer;I)V", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ComposeView
  extends AbstractComposeView
{
  public static final int Ue;
  public static final ComposeView.a aTs;
  private static boolean aTv;
  private final an<m<h, Integer, ah>> aTt;
  private boolean aTu;
  
  static
  {
    AppMethodBeat.i(206675);
    aTs = new ComposeView.a((byte)0);
    Ue = 8;
    aTv = true;
    AppMethodBeat.o(206675);
  }
  
  public ComposeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
    AppMethodBeat.i(206666);
    AppMethodBeat.o(206666);
  }
  
  public ComposeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206658);
    this.aTt = bj.T(null);
    AppMethodBeat.o(206658);
  }
  
  public final void b(h paramh, final int paramInt)
  {
    AppMethodBeat.i(206682);
    paramh = paramh.by(2083048607);
    m localm = (m)this.aTt.getValue();
    if (localm == null)
    {
      paramh.bx(149998587);
      paramh.od();
    }
    for (;;)
    {
      paramh = paramh.oh();
      if (paramh != null) {
        paramh.b((m)new b(this, paramInt));
      }
      AppMethodBeat.o(206682);
      return;
      paramh.bx(2083048646);
      localm.invoke(paramh, Integer.valueOf(0));
      paramh.od();
    }
  }
  
  protected final boolean getShouldCreateCompositionOnAttachedToWindow()
  {
    return this.aTu;
  }
  
  public final void setContent(m<? super h, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(206687);
    s.u(paramm, "content");
    this.aTu = true;
    this.aTt.setValue(paramm);
    if (isAttachedToWindow()) {
      yp();
    }
    AppMethodBeat.o(206687);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<h, Integer, ah>
  {
    b(ComposeView paramComposeView, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.ComposeView
 * JD-Core Version:    0.7.0.1
 */