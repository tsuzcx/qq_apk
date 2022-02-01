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
import com.tencent.mm.cc.a;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.v;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/debug/LiveDebugView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentView", "Landroid/widget/TextView;", "liveInfoView", "printDebugInfo", "", "debugText", "", "printLiveInfo", "liveInfo", "plugin-core_release"})
public final class LiveDebugView
  extends LinearLayout
{
  private final TextView contentView;
  final TextView gqC;
  
  public LiveDebugView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209238);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131496310, (ViewGroup)this, true);
    View localView = paramAttributeSet.findViewById(2131307619);
    k.g(localView, "parent.findViewById(R.id.live_debug_text)");
    this.contentView = ((TextView)localView);
    localView = paramAttributeSet.findViewById(2131307618);
    k.g(localView, "parent.findViewById(R.id.live_debug_info)");
    this.gqC = ((TextView)localView);
    this.contentView.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.gqC.setMovementMethod(ScrollingMovementMethod.getInstance());
    ((Button)paramAttributeSet.findViewById(2131307314)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(209234);
        paramAnonymousView = paramContext.getSystemService("clipboard");
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new v("null cannot be cast to non-null type android.content.ClipboardManager");
          AppMethodBeat.o(209234);
          throw paramAnonymousView;
        }
        ((ClipboardManager)paramAnonymousView).setText(LiveDebugView.a(this.gqD).getText());
        AppMethodBeat.o(209234);
      }
    });
    ((Button)paramAttributeSet.findViewById(2131307312)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(209235);
        if (LiveDebugView.a(this.gqD).getCurrentTextColor() == a.n(paramContext, 2131100017))
        {
          LiveDebugView.a(this.gqD).setTextColor(a.n(paramContext, 2131101179));
          LiveDebugView.b(this.gqD).setTextColor(a.n(paramContext, 2131101179));
          AppMethodBeat.o(209235);
          return;
        }
        LiveDebugView.a(this.gqD).setTextColor(a.n(paramContext, 2131100017));
        LiveDebugView.b(this.gqD).setTextColor(a.n(paramContext, 2131100017));
        AppMethodBeat.o(209235);
      }
    });
    ((Button)paramAttributeSet.findViewById(2131307313)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(209236);
        if (LiveDebugView.a(this.gqD).getVisibility() == 0)
        {
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new v("null cannot be cast to non-null type android.widget.Button");
            AppMethodBeat.o(209236);
            throw paramAnonymousView;
          }
          ((Button)paramAnonymousView).setText((CharSequence)a.aw(paramContext, 2131766588));
          LiveDebugView.a(this.gqD).setVisibility(4);
          LiveDebugView.b(this.gqD).setVisibility(4);
          AppMethodBeat.o(209236);
          return;
        }
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new v("null cannot be cast to non-null type android.widget.Button");
          AppMethodBeat.o(209236);
          throw paramAnonymousView;
        }
        ((Button)paramAnonymousView).setText((CharSequence)a.aw(paramContext, 2131766587));
        LiveDebugView.a(this.gqD).setVisibility(0);
        LiveDebugView.b(this.gqD).setVisibility(0);
        AppMethodBeat.o(209236);
      }
    });
    AppMethodBeat.o(209238);
  }
  
  public final void uG(String paramString)
  {
    AppMethodBeat.i(209237);
    k.h(paramString, "debugText");
    String str = new SimpleDateFormat("[HH:mm:ss.SSS]", Locale.US).format(new Date(System.currentTimeMillis()));
    TextView localTextView = this.contentView;
    z localz = z.KUT;
    paramString = String.format("%s:%s\n\n", Arrays.copyOf(new Object[] { str, paramString }, 2));
    k.g(paramString, "java.lang.String.format(format, *args)");
    localTextView.append((CharSequence)paramString);
    AppMethodBeat.o(209237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.LiveDebugView
 * JD-Core Version:    0.7.0.1
 */