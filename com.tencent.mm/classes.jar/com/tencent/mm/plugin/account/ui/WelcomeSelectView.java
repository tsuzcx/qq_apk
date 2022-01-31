package com.tencent.mm.plugin.account.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;

public class WelcomeSelectView
  extends WelcomeView
{
  private Context context;
  private View fnv;
  private Button fsX;
  private Button fsY;
  private TextView fsZ;
  private int mHeight = 800;
  
  public WelcomeSelectView(Context paramContext)
  {
    super(paramContext);
    ca(paramContext);
  }
  
  @TargetApi(11)
  public WelcomeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ca(paramContext);
  }
  
  private void ca(final Context paramContext)
  {
    this.context = paramContext;
    View localView = LayoutInflater.from(paramContext).inflate(q.g.welcome_select_ui, this);
    this.fnv = localView.findViewById(q.f.select_lv);
    this.fsX = ((Button)localView.findViewById(q.f.select_login_btn));
    this.fsY = ((Button)localView.findViewById(q.f.select_register_btn));
    this.fsZ = ((TextView)localView.findViewById(q.f.welcome_language_tv));
    this.fnv.setVisibility(8);
    this.fsZ.setVisibility(8);
    this.fsZ.setText(x.g(paramContext, q.b.language_setting, q.j.app_lang_sys));
    this.mHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.fsZ.setOnClickListener(new WelcomeSelectView.1(this));
    this.fsX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(paramContext, MobileInputUI.class);
        paramAnonymousView.putExtra("mobile_input_purpose", 1);
        paramContext.startActivity(paramAnonymousView);
      }
    });
    this.fsY.setOnClickListener(new WelcomeSelectView.3(this, paramContext));
    paramContext = x.e(this.context.getSharedPreferences(ae.cqR(), 0));
    this.fsZ.setText(x.g(this.context, q.b.language_setting, q.j.app_lang_sys));
    if ((paramContext != null) && (paramContext.equals("language_default"))) {
      this.fsZ.setText(this.context.getString(q.j.login_language));
    }
    this.fsX.setText(q.j.intro_existed_login);
    this.fsY.setText(q.j.intro_create_account_qq);
  }
  
  public final void Yz()
  {
    bP(this.fnv);
    bP(this.fsZ);
    this.fnv.setVisibility(0);
    this.fsZ.setVisibility(0);
    ai.d(new Runnable()
    {
      public final void run()
      {
        g.Dk().a(new bi(new WelcomeSelectView.4.1(this), "launch normal"), 0);
      }
    });
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeSelectView
 * JD-Core Version:    0.7.0.1
 */