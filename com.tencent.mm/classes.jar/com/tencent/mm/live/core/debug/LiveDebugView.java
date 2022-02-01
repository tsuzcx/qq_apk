package com.tencent.mm.live.core.debug;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.core.a.a;
import com.tencent.mm.live.core.a.d;
import com.tencent.mm.live.core.a.e;
import com.tencent.mm.live.core.a.g;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/debug/LiveDebugView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentView", "Landroid/widget/TextView;", "liveInfoView", "printDebugInfo", "", "debugText", "", "printLiveInfo", "liveInfo", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveDebugView
  extends LinearLayout
{
  private final TextView contentView;
  final TextView mUx;
  
  public LiveDebugView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(247508);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(a.e.live_debug_view, (ViewGroup)this, true);
    View localView = paramAttributeSet.findViewById(a.d.live_debug_text);
    s.s(localView, "parent.findViewById(R.id.live_debug_text)");
    this.contentView = ((TextView)localView);
    localView = paramAttributeSet.findViewById(a.d.live_debug_info);
    s.s(localView, "parent.findViewById(R.id.live_debug_info)");
    this.mUx = ((TextView)localView);
    this.contentView.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.mUx.setMovementMethod(ScrollingMovementMethod.getInstance());
    ((Button)paramAttributeSet.findViewById(a.d.debug_copy)).setOnClickListener(new LiveDebugView..ExternalSyntheticLambda0(this));
    ((Button)paramAttributeSet.findViewById(a.d.debug_color)).setOnClickListener(new LiveDebugView..ExternalSyntheticLambda2(this, paramContext));
    ((Button)paramAttributeSet.findViewById(a.d.debug_control)).setOnClickListener(new LiveDebugView..ExternalSyntheticLambda1(this, paramContext));
    AppMethodBeat.o(247508);
  }
  
  private static final void a(LiveDebugView paramLiveDebugView, Context paramContext, View paramView)
  {
    AppMethodBeat.i(247525);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramLiveDebugView);
    localb.cH(paramContext);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/debug/LiveDebugView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramLiveDebugView, "this$0");
    s.u(paramContext, "$context");
    if (paramLiveDebugView.contentView.getCurrentTextColor() == com.tencent.mm.cd.a.w(paramContext, a.a.black))
    {
      paramLiveDebugView.contentView.setTextColor(com.tencent.mm.cd.a.w(paramContext, a.a.white));
      paramLiveDebugView.mUx.setTextColor(com.tencent.mm.cd.a.w(paramContext, a.a.white));
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/core/debug/LiveDebugView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247525);
      return;
      paramLiveDebugView.contentView.setTextColor(com.tencent.mm.cd.a.w(paramContext, a.a.black));
      paramLiveDebugView.mUx.setTextColor(com.tencent.mm.cd.a.w(paramContext, a.a.black));
    }
  }
  
  private static final void a(LiveDebugView paramLiveDebugView, View paramView)
  {
    AppMethodBeat.i(247516);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramLiveDebugView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/debug/LiveDebugView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramLiveDebugView, "this$0");
    ClipboardHelper.setText(paramLiveDebugView.contentView.getText());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/core/debug/LiveDebugView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247516);
  }
  
  private static final void b(LiveDebugView paramLiveDebugView, Context paramContext, View paramView)
  {
    AppMethodBeat.i(247535);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramLiveDebugView);
    localb.cH(paramContext);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/debug/LiveDebugView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramLiveDebugView, "this$0");
    s.u(paramContext, "$context");
    if (paramLiveDebugView.contentView.getVisibility() == 0)
    {
      if (paramView == null)
      {
        paramLiveDebugView = new NullPointerException("null cannot be cast to non-null type android.widget.Button");
        AppMethodBeat.o(247535);
        throw paramLiveDebugView;
      }
      ((Button)paramView).setText((CharSequence)com.tencent.mm.cd.a.bt(paramContext, a.g.live_debug_show));
      paramLiveDebugView.contentView.setVisibility(4);
      paramLiveDebugView.mUx.setVisibility(4);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/core/debug/LiveDebugView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247535);
      return;
      if (paramView == null)
      {
        paramLiveDebugView = new NullPointerException("null cannot be cast to non-null type android.widget.Button");
        AppMethodBeat.o(247535);
        throw paramLiveDebugView;
      }
      ((Button)paramView).setText((CharSequence)com.tencent.mm.cd.a.bt(paramContext, a.g.live_debug_hide));
      paramLiveDebugView.contentView.setVisibility(0);
      paramLiveDebugView.mUx.setVisibility(0);
    }
  }
  
  public final void Ga(String paramString)
  {
    AppMethodBeat.i(247573);
    s.u(paramString, "debugText");
    String str = new SimpleDateFormat("[HH:mm:ss.SSS]", Locale.US).format(new Date(System.currentTimeMillis()));
    TextView localTextView = this.contentView;
    am localam = am.aixg;
    paramString = String.format("%s:%s\n\n", Arrays.copyOf(new Object[] { str, paramString }, 2));
    s.s(paramString, "java.lang.String.format(format, *args)");
    localTextView.append((CharSequence)paramString);
    AppMethodBeat.o(247573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.LiveDebugView
 * JD-Core Version:    0.7.0.1
 */