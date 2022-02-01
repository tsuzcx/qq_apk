package com.tencent.mm.plugin.account.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;

public class WelcomeSelectView
  extends WelcomeView
{
  private Context context;
  protected View isv;
  protected Button iyj;
  protected Button iyk;
  protected TextView iyl;
  
  public WelcomeSelectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(128823);
    aL(paramContext);
    AppMethodBeat.o(128823);
  }
  
  @TargetApi(11)
  public WelcomeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(128822);
    aL(paramContext);
    AppMethodBeat.o(128822);
  }
  
  private void aL(Context paramContext)
  {
    AppMethodBeat.i(128826);
    this.context = paramContext;
    View localView = LayoutInflater.from(paramContext).inflate(2131496101, this);
    this.isv = localView.findViewById(2131304522);
    this.iyj = ((Button)localView.findViewById(2131304521));
    this.iyk = ((Button)localView.findViewById(2131304531));
    this.iyl = ((TextView)localView.findViewById(2131306968));
    this.isv.setVisibility(8);
    this.iyl.setVisibility(8);
    this.iyl.setText(ac.is(paramContext));
    AppMethodBeat.o(128826);
  }
  
  public final void aKL()
  {
    AppMethodBeat.i(128827);
    cy(this.isv);
    cy(this.iyl);
    this.isv.setVisibility(0);
    this.iyl.setVisibility(0);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128821);
        g.aeS().a(new bn(new bn.a()
        {
          public final void a(e paramAnonymous2e) {}
        }, "launch normal"), 0);
        AppMethodBeat.o(128821);
      }
    });
    AppMethodBeat.o(128827);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(128824);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(128824);
  }
  
  final void init()
  {
    AppMethodBeat.i(128825);
    String str = ac.g(this.context.getSharedPreferences(aj.eFD(), 0));
    this.iyl.setText(ac.is(this.context));
    if ((str != null) && (str.equals("language_default"))) {
      this.iyl.setText(this.context.getString(2131760773));
    }
    this.iyj.setText(2131760346);
    this.iyk.setText(2131760345);
    AppMethodBeat.o(128825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeSelectView
 * JD-Core Version:    0.7.0.1
 */