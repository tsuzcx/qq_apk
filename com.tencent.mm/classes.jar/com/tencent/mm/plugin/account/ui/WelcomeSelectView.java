package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class WelcomeSelectView
  extends WelcomeView
{
  private Context context;
  protected View qbs;
  protected Button qhv;
  protected Button qhw;
  protected TextView qhx;
  
  public WelcomeSelectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(128823);
    ci(paramContext);
    AppMethodBeat.o(128823);
  }
  
  public WelcomeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(128822);
    ci(paramContext);
    AppMethodBeat.o(128822);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(128826);
    this.context = paramContext;
    View localView = LayoutInflater.from(paramContext).inflate(r.g.welcome_select_ui, this);
    this.qbs = localView.findViewById(r.f.select_lv);
    this.qhv = ((Button)localView.findViewById(r.f.select_login_btn));
    this.qhw = ((Button)localView.findViewById(r.f.select_register_btn));
    this.qhx = ((TextView)localView.findViewById(r.f.welcome_language_tv));
    this.qbs.setVisibility(8);
    this.qhx.setVisibility(8);
    this.qhx.setText(LocaleUtil.getLanguageName(paramContext, r.b.language_setting, r.j.app_lang_sys));
    AppMethodBeat.o(128826);
  }
  
  public final void bZb()
  {
    AppMethodBeat.i(128827);
    ds(this.qbs);
    ds(this.qhx);
    this.qbs.setVisibility(0);
    this.qhx.setVisibility(0);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128821);
        h.aZW().a(new bw(new bw.a()
        {
          public final void b(g paramAnonymous2g) {}
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
    this.qhx.setText(LocaleUtil.getLanguageName(this.context, r.b.language_setting, r.j.app_lang_sys));
    if ((str != null) && (str.equals("language_default"))) {
      this.qhx.setText(this.context.getString(r.j.login_language));
    }
    this.qhv.setText(r.j.intro_existed_login);
    this.qhw.setText(r.j.intro_create_account_qq);
    AppMethodBeat.o(128825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeSelectView
 * JD-Core Version:    0.7.0.1
 */