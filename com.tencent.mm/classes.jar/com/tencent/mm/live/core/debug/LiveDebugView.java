package com.tencent.mm.live.core.debug;

import android.content.ClipboardManager;
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
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/debug/LiveDebugView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentView", "Landroid/widget/TextView;", "liveInfoView", "printDebugInfo", "", "debugText", "", "printLiveInfo", "liveInfo", "plugin-core_release"})
public final class LiveDebugView
  extends LinearLayout
{
  private final TextView contentView;
  final TextView gKm;
  
  public LiveDebugView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216896);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131496310, (ViewGroup)this, true);
    View localView = paramAttributeSet.findViewById(2131307619);
    p.g(localView, "parent.findViewById(R.id.live_debug_text)");
    this.contentView = ((TextView)localView);
    localView = paramAttributeSet.findViewById(2131307618);
    p.g(localView, "parent.findViewById(R.id.live_debug_info)");
    this.gKm = ((TextView)localView);
    this.contentView.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.gKm.setMovementMethod(ScrollingMovementMethod.getInstance());
    ((Button)paramAttributeSet.findViewById(2131307314)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216892);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/debug/LiveDebugView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = paramContext.getSystemService("clipboard");
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new v("null cannot be cast to non-null type android.content.ClipboardManager");
          AppMethodBeat.o(216892);
          throw paramAnonymousView;
        }
        ((ClipboardManager)paramAnonymousView).setText(LiveDebugView.a(this.gKn).getText());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/debug/LiveDebugView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216892);
      }
    });
    ((Button)paramAttributeSet.findViewById(2131307312)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216893);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/debug/LiveDebugView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (LiveDebugView.a(this.gKn).getCurrentTextColor() == com.tencent.mm.cc.a.n(paramContext, 2131100017))
        {
          LiveDebugView.a(this.gKn).setTextColor(com.tencent.mm.cc.a.n(paramContext, 2131101179));
          LiveDebugView.b(this.gKn).setTextColor(com.tencent.mm.cc.a.n(paramContext, 2131101179));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/debug/LiveDebugView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216893);
          return;
          LiveDebugView.a(this.gKn).setTextColor(com.tencent.mm.cc.a.n(paramContext, 2131100017));
          LiveDebugView.b(this.gKn).setTextColor(com.tencent.mm.cc.a.n(paramContext, 2131100017));
        }
      }
    });
    ((Button)paramAttributeSet.findViewById(2131307313)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216894);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/debug/LiveDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (LiveDebugView.a(this.gKn).getVisibility() == 0)
        {
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new v("null cannot be cast to non-null type android.widget.Button");
            AppMethodBeat.o(216894);
            throw paramAnonymousView;
          }
          ((Button)paramAnonymousView).setText((CharSequence)com.tencent.mm.cc.a.az(paramContext, 2131766588));
          LiveDebugView.a(this.gKn).setVisibility(4);
          LiveDebugView.b(this.gKn).setVisibility(4);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/debug/LiveDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216894);
          return;
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new v("null cannot be cast to non-null type android.widget.Button");
            AppMethodBeat.o(216894);
            throw paramAnonymousView;
          }
          ((Button)paramAnonymousView).setText((CharSequence)com.tencent.mm.cc.a.az(paramContext, 2131766587));
          LiveDebugView.a(this.gKn).setVisibility(0);
          LiveDebugView.b(this.gKn).setVisibility(0);
        }
      }
    });
    AppMethodBeat.o(216896);
  }
  
  public final void xx(String paramString)
  {
    AppMethodBeat.i(216895);
    p.h(paramString, "debugText");
    String str = new SimpleDateFormat("[HH:mm:ss.SSS]", Locale.US).format(new Date(System.currentTimeMillis()));
    TextView localTextView = this.contentView;
    ad localad = ad.MLZ;
    paramString = String.format("%s:%s\n\n", Arrays.copyOf(new Object[] { str, paramString }, 2));
    p.g(paramString, "java.lang.String.format(format, *args)");
    localTextView.append((CharSequence)paramString);
    AppMethodBeat.o(216895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.LiveDebugView
 * JD-Core Version:    0.7.0.1
 */