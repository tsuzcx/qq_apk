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
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;

public class WelcomeSelectView
  extends WelcomeView
{
  private Context context;
  protected View iSA;
  protected Button iYm;
  protected Button iYn;
  protected TextView iYo;
  
  public WelcomeSelectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(128823);
    aM(paramContext);
    AppMethodBeat.o(128823);
  }
  
  @TargetApi(11)
  public WelcomeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(128822);
    aM(paramContext);
    AppMethodBeat.o(128822);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(128826);
    this.context = paramContext;
    View localView = LayoutInflater.from(paramContext).inflate(2131496101, this);
    this.iSA = localView.findViewById(2131304522);
    this.iYm = ((Button)localView.findViewById(2131304521));
    this.iYn = ((Button)localView.findViewById(2131304531));
    this.iYo = ((TextView)localView.findViewById(2131306968));
    this.iSA.setVisibility(8);
    this.iYo.setVisibility(8);
    this.iYo.setText(ab.iD(paramContext));
    AppMethodBeat.o(128826);
  }
  
  public final void aRC()
  {
    AppMethodBeat.i(128827);
    cA(this.iSA);
    cA(this.iYo);
    this.iSA.setVisibility(0);
    this.iYo.setVisibility(0);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128821);
        g.agi().a(new bn(new bn.a()
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
    String str = ab.g(this.context.getSharedPreferences(ai.eUX(), 0));
    this.iYo.setText(ab.iD(this.context));
    if ((str != null) && (str.equals("language_default"))) {
      this.iYo.setText(this.context.getString(2131760773));
    }
    this.iYm.setText(2131760346);
    this.iYn.setText(2131760345);
    AppMethodBeat.o(128825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeSelectView
 * JD-Core Version:    0.7.0.1
 */