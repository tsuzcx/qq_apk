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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;

public class WelcomeSelectView
  extends WelcomeView
{
  private Context context;
  protected View joC;
  protected Button juo;
  protected Button jup;
  protected TextView juq;
  
  public WelcomeSelectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(128823);
    aN(paramContext);
    AppMethodBeat.o(128823);
  }
  
  @TargetApi(11)
  public WelcomeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(128822);
    aN(paramContext);
    AppMethodBeat.o(128822);
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(128826);
    this.context = paramContext;
    View localView = LayoutInflater.from(paramContext).inflate(2131496101, this);
    this.joC = localView.findViewById(2131304522);
    this.juo = ((Button)localView.findViewById(2131304521));
    this.jup = ((Button)localView.findViewById(2131304531));
    this.juq = ((TextView)localView.findViewById(2131306968));
    this.joC.setVisibility(8);
    this.juq.setVisibility(8);
    this.juq.setText(ad.iS(paramContext));
    AppMethodBeat.o(128826);
  }
  
  public final void aVn()
  {
    AppMethodBeat.i(128827);
    cB(this.joC);
    cB(this.juq);
    this.joC.setVisibility(0);
    this.juq.setVisibility(0);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128821);
        g.ajj().a(new bq(new bq.a()
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
    String str = ad.g(this.context.getSharedPreferences(ak.fow(), 0));
    this.juq.setText(ad.iS(this.context));
    if ((str != null) && (str.equals("language_default"))) {
      this.juq.setText(this.context.getString(2131760773));
    }
    this.juo.setText(2131760346);
    this.jup.setText(2131760345);
    AppMethodBeat.o(128825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeSelectView
 * JD-Core Version:    0.7.0.1
 */