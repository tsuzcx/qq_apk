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
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class WelcomeSelectView
  extends WelcomeView
{
  private Context context;
  protected View kmM;
  protected Button ksD;
  protected Button ksE;
  protected TextView ksF;
  
  public WelcomeSelectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(128823);
    bh(paramContext);
    AppMethodBeat.o(128823);
  }
  
  @TargetApi(11)
  public WelcomeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(128822);
    bh(paramContext);
    AppMethodBeat.o(128822);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(128826);
    this.context = paramContext;
    View localView = LayoutInflater.from(paramContext).inflate(2131497089, this);
    this.kmM = localView.findViewById(2131307537);
    this.ksD = ((Button)localView.findViewById(2131307536));
    this.ksE = ((Button)localView.findViewById(2131307554));
    this.ksF = ((TextView)localView.findViewById(2131310468));
    this.kmM.setVisibility(8);
    this.ksF.setVisibility(8);
    this.ksF.setText(LocaleUtil.getLanguageName(paramContext, 2130903056, 2131755881));
    AppMethodBeat.o(128826);
  }
  
  public final void bpY()
  {
    AppMethodBeat.i(128827);
    cs(this.kmM);
    cs(this.ksF);
    this.kmM.setVisibility(0);
    this.ksF.setVisibility(0);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128821);
        com.tencent.mm.kernel.g.azz().a(new bu(new bu.a()
        {
          public final void a(com.tencent.mm.network.g paramAnonymous2g) {}
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
    String str = LocaleUtil.loadApplicationLanguageSettings(this.context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.context);
    this.ksF.setText(LocaleUtil.getLanguageName(this.context, 2130903056, 2131755881));
    if ((str != null) && (str.equals("language_default"))) {
      this.ksF.setText(this.context.getString(2131762524));
    }
    this.ksD.setText(2131761791);
    this.ksE.setText(2131761790);
    AppMethodBeat.o(128825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeSelectView
 * JD-Core Version:    0.7.0.1
 */