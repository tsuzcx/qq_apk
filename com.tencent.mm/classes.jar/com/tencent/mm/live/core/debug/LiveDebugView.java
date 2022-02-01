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
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/debug/LiveDebugView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentView", "Landroid/widget/TextView;", "liveInfoView", "printDebugInfo", "", "debugText", "", "printLiveInfo", "liveInfo", "plugin-core_release"})
public final class LiveDebugView
  extends LinearLayout
{
  private final TextView contentView;
  final TextView hCx;
  
  public LiveDebugView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(196563);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131495249, (ViewGroup)this, true);
    View localView = paramAttributeSet.findViewById(2131303381);
    p.g(localView, "parent.findViewById(R.id.live_debug_text)");
    this.contentView = ((TextView)localView);
    localView = paramAttributeSet.findViewById(2131303380);
    p.g(localView, "parent.findViewById(R.id.live_debug_info)");
    this.hCx = ((TextView)localView);
    this.contentView.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.hCx.setMovementMethod(ScrollingMovementMethod.getInstance());
    ((Button)paramAttributeSet.findViewById(2131299427)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196559);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/debug/LiveDebugView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ClipboardHelper.setText(LiveDebugView.a(this.hCy).getText());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/debug/LiveDebugView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196559);
      }
    });
    ((Button)paramAttributeSet.findViewById(2131299425)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196560);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/debug/LiveDebugView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (LiveDebugView.a(this.hCy).getCurrentTextColor() == com.tencent.mm.cb.a.n(paramContext, 2131100042))
        {
          LiveDebugView.a(this.hCy).setTextColor(com.tencent.mm.cb.a.n(paramContext, 2131101424));
          LiveDebugView.b(this.hCy).setTextColor(com.tencent.mm.cb.a.n(paramContext, 2131101424));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/debug/LiveDebugView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(196560);
          return;
          LiveDebugView.a(this.hCy).setTextColor(com.tencent.mm.cb.a.n(paramContext, 2131100042));
          LiveDebugView.b(this.hCy).setTextColor(com.tencent.mm.cb.a.n(paramContext, 2131100042));
        }
      }
    });
    ((Button)paramAttributeSet.findViewById(2131299426)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196561);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/core/debug/LiveDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (LiveDebugView.a(this.hCy).getVisibility() == 0)
        {
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new t("null cannot be cast to non-null type android.widget.Button");
            AppMethodBeat.o(196561);
            throw paramAnonymousView;
          }
          ((Button)paramAnonymousView).setText((CharSequence)com.tencent.mm.cb.a.aI(paramContext, 2131762278));
          LiveDebugView.a(this.hCy).setVisibility(4);
          LiveDebugView.b(this.hCy).setVisibility(4);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/debug/LiveDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(196561);
          return;
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new t("null cannot be cast to non-null type android.widget.Button");
            AppMethodBeat.o(196561);
            throw paramAnonymousView;
          }
          ((Button)paramAnonymousView).setText((CharSequence)com.tencent.mm.cb.a.aI(paramContext, 2131762277));
          LiveDebugView.a(this.hCy).setVisibility(0);
          LiveDebugView.b(this.hCy).setVisibility(0);
        }
      }
    });
    AppMethodBeat.o(196563);
  }
  
  public final void GA(String paramString)
  {
    AppMethodBeat.i(196562);
    p.h(paramString, "debugText");
    String str = new SimpleDateFormat("[HH:mm:ss.SSS]", Locale.US).format(new Date(System.currentTimeMillis()));
    TextView localTextView = this.contentView;
    ae localae = ae.SYK;
    paramString = String.format("%s:%s\n\n", Arrays.copyOf(new Object[] { str, paramString }, 2));
    p.g(paramString, "java.lang.String.format(format, *args)");
    localTextView.append((CharSequence)paramString);
    AppMethodBeat.o(196562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.LiveDebugView
 * JD-Core Version:    0.7.0.1
 */