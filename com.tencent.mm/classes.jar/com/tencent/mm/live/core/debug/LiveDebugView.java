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
import com.tencent.mm.cd.a;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.v;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/debug/LiveDebugView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentView", "Landroid/widget/TextView;", "liveInfoView", "printDebugInfo", "", "debugText", "", "printLiveInfo", "liveInfo", "plugin-core_release"})
public final class LiveDebugView
  extends LinearLayout
{
  private final TextView contentView;
  final TextView qOI;
  
  public LiveDebugView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205702);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131496300, (ViewGroup)this, true);
    View localView = paramAttributeSet.findViewById(2131307538);
    k.g(localView, "parent.findViewById(R.id.live_debug_text)");
    this.contentView = ((TextView)localView);
    localView = paramAttributeSet.findViewById(2131307537);
    k.g(localView, "parent.findViewById(R.id.live_debug_info)");
    this.qOI = ((TextView)localView);
    this.contentView.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.qOI.setMovementMethod(ScrollingMovementMethod.getInstance());
    ((Button)paramAttributeSet.findViewById(2131307284)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205698);
        paramAnonymousView = paramContext.getSystemService("clipboard");
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new v("null cannot be cast to non-null type android.content.ClipboardManager");
          AppMethodBeat.o(205698);
          throw paramAnonymousView;
        }
        ((ClipboardManager)paramAnonymousView).setText(LiveDebugView.a(this.qOJ).getText());
        AppMethodBeat.o(205698);
      }
    });
    ((Button)paramAttributeSet.findViewById(2131307282)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205699);
        if (LiveDebugView.a(this.qOJ).getCurrentTextColor() == a.n(paramContext, 2131100017))
        {
          LiveDebugView.a(this.qOJ).setTextColor(a.n(paramContext, 2131101179));
          LiveDebugView.b(this.qOJ).setTextColor(a.n(paramContext, 2131101179));
          AppMethodBeat.o(205699);
          return;
        }
        LiveDebugView.a(this.qOJ).setTextColor(a.n(paramContext, 2131100017));
        LiveDebugView.b(this.qOJ).setTextColor(a.n(paramContext, 2131100017));
        AppMethodBeat.o(205699);
      }
    });
    ((Button)paramAttributeSet.findViewById(2131307283)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205700);
        if (LiveDebugView.a(this.qOJ).getVisibility() == 0)
        {
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new v("null cannot be cast to non-null type android.widget.Button");
            AppMethodBeat.o(205700);
            throw paramAnonymousView;
          }
          ((Button)paramAnonymousView).setText((CharSequence)a.aq(paramContext, 2131766564));
          LiveDebugView.a(this.qOJ).setVisibility(4);
          LiveDebugView.b(this.qOJ).setVisibility(4);
          AppMethodBeat.o(205700);
          return;
        }
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new v("null cannot be cast to non-null type android.widget.Button");
          AppMethodBeat.o(205700);
          throw paramAnonymousView;
        }
        ((Button)paramAnonymousView).setText((CharSequence)a.aq(paramContext, 2131766563));
        LiveDebugView.a(this.qOJ).setVisibility(0);
        LiveDebugView.b(this.qOJ).setVisibility(0);
        AppMethodBeat.o(205700);
      }
    });
    AppMethodBeat.o(205702);
  }
  
  public final void aUc(String paramString)
  {
    AppMethodBeat.i(205701);
    k.h(paramString, "debugText");
    String str = new SimpleDateFormat("[HH:mm:ss.SSS]", Locale.US).format(new Date(System.currentTimeMillis()));
    TextView localTextView = this.contentView;
    z localz = z.Jhz;
    paramString = String.format("%s:%s\n\n", Arrays.copyOf(new Object[] { str, paramString }, 2));
    k.g(paramString, "java.lang.String.format(format, *args)");
    localTextView.append((CharSequence)paramString);
    AppMethodBeat.o(205701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.debug.LiveDebugView
 * JD-Core Version:    0.7.0.1
 */