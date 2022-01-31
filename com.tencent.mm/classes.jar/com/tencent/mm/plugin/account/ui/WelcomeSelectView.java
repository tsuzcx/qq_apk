package com.tencent.mm.plugin.account.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public class WelcomeSelectView
  extends WelcomeView
{
  private Context context;
  protected View gEO;
  protected Button gKA;
  protected TextView gKB;
  protected Button gKz;
  private int mHeight;
  
  public WelcomeSelectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(125662);
    this.mHeight = 800;
    aA(paramContext);
    AppMethodBeat.o(125662);
  }
  
  @TargetApi(11)
  public WelcomeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(125661);
    this.mHeight = 800;
    aA(paramContext);
    AppMethodBeat.o(125661);
  }
  
  private void aA(Context paramContext)
  {
    AppMethodBeat.i(125665);
    this.context = paramContext;
    View localView = LayoutInflater.from(paramContext).inflate(2130971318, this);
    this.gEO = localView.findViewById(2131829584);
    this.gKz = ((Button)localView.findViewById(2131827535));
    this.gKA = ((Button)localView.findViewById(2131827534));
    this.gKB = ((TextView)localView.findViewById(2131829583));
    this.gEO.setVisibility(8);
    this.gKB.setVisibility(8);
    this.gKB.setText(aa.gQ(paramContext));
    this.mHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(125665);
  }
  
  public final void asi()
  {
    AppMethodBeat.i(125666);
    co(this.gEO);
    co(this.gKB);
    this.gEO.setVisibility(0);
    this.gKB.setVisibility(0);
    al.d(new WelcomeSelectView.1(this));
    AppMethodBeat.o(125666);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(125663);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(125663);
  }
  
  final void init()
  {
    AppMethodBeat.i(125664);
    String str = aa.g(this.context.getSharedPreferences(ah.dsP(), 0));
    this.gKB.setText(aa.gQ(this.context));
    if ((str != null) && (str.equals("language_default"))) {
      this.gKB.setText(this.context.getString(2131301141));
    }
    this.gKz.setText(2131300745);
    this.gKA.setText(2131300744);
    AppMethodBeat.o(125664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeSelectView
 * JD-Core Version:    0.7.0.1
 */