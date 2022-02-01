package com.tencent.mm.live.core.debug;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.core.a.a;
import com.tencent.mm.live.core.a.d;
import com.tencent.mm.live.core.a.e;
import com.tencent.mm.live.core.a.f;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/debug/LiveDebugView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentView", "Landroid/widget/TextView;", "liveInfoView", "printDebugInfo", "", "debugText", "", "printLiveInfo", "liveInfo", "plugin-core_release"})
public final class LiveDebugView
  extends LinearLayout
{
  private final TextView contentView;
  final TextView kqy;
  
  public LiveDebugView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201227);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(a.e.live_debug_view, (ViewGroup)this, true);
    View localView = paramAttributeSet.findViewById(a.d.live_debug_text);
    p.j(localView, "parent.findViewById(R.id.live_debug_text)");
    this.contentView = ((TextView)localView);
    localView = paramAttributeSet.findViewById(a.d.live_debug_info);
    p.j(localView, "parent.findViewById(R.id.live_debug_info)");
    this.kqy = ((TextView)localView);
    this.contentView.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.kqy.setMovementMethod(ScrollingMovementMethod.getInstance());
    ((Button)paramAttributeSet.findViewById(a.d.debug_copy)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200382);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/debug/LiveDebugView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ClipboardHelper.setText(LiveDebugView.a(this.kqz).getText());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/debug/LiveDebugView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(200382);
      }
    });
    ((Button)paramAttributeSet.findViewById(a.d.debug_color)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200656);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/debug/LiveDebugView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (LiveDebugView.a(this.kqz).getCurrentTextColor() == com.tencent.mm.ci.a.w(paramContext, a.a.black))
        {
          LiveDebugView.a(this.kqz).setTextColor(com.tencent.mm.ci.a.w(paramContext, a.a.white));
          LiveDebugView.b(this.kqz).setTextColor(com.tencent.mm.ci.a.w(paramContext, a.a.white));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/debug/LiveDebugView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(200656);
          return;
          LiveDebugView.a(this.kqz).setTextColor(com.tencent.mm.ci.a.w(paramContext, a.a.black));
          LiveDebugView.b(this.kqz).setTextColor(com.tencent.mm.ci.a.w(paramContext, a.a.black));
        }
      }
    });
    ((Button)paramAttributeSet.findViewById(a.d.debug_control)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(201200);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/debug/LiveDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (LiveDebugView.a(this.kqz).getVisibility() == 0)
        {
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new t("null cannot be cast to non-null type android.widget.Button");
            AppMethodBeat.o(201200);
            throw paramAnonymousView;
          }
          ((Button)paramAnonymousView).setText((CharSequence)com.tencent.mm.ci.a.ba(paramContext, a.f.live_debug_show));
          LiveDebugView.a(this.kqz).setVisibility(4);
          LiveDebugView.b(this.kqz).setVisibility(4);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/debug/LiveDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(201200);
          return;
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new t("null cannot be cast to non-null type android.widget.Button");
            AppMethodBeat.o(201200);
            throw paramAnonymousView;
          }
          ((Button)paramAnonymousView).setText((CharSequence)com.tencent.mm.ci.a.ba(paramContext, a.f.live_debug_hide));
          LiveDebugView.a(this.kqz).setVisibility(0);
          LiveDebugView.b(this.kqz).setVisibility(0);
        }
      }
    });
    AppMethodBeat.o(201227);
  }
  
  public final void NN(String paramString)
  {
    AppMethodBeat.i(201225);
    p.k(paramString, "debugText");
    String str = new SimpleDateFormat("[HH:mm:ss.SSS]", Locale.US).format(new Date(System.currentTimeMillis()));
    TextView localTextView = this.contentView;
    af localaf = af.aaBG;
    paramString = String.format("%s:%s\n\n", Arrays.copyOf(new Object[] { str, paramString }, 2));
    p.j(paramString, "java.lang.String.format(format, *args)");
    localTextView.append((CharSequence)paramString);
    AppMethodBeat.o(201225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.LiveDebugView
 * JD-Core Version:    0.7.0.1
 */