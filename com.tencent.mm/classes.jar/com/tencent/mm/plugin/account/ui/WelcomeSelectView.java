package com.tencent.mm.plugin.account.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.util.d;

public class WelcomeSelectView
  extends WelcomeView
{
  private Context context;
  protected View neE;
  protected Button nkm;
  protected Button nkn;
  protected TextView nko;
  
  public WelcomeSelectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(128823);
    bv(paramContext);
    AppMethodBeat.o(128823);
  }
  
  @TargetApi(11)
  public WelcomeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(128822);
    bv(paramContext);
    AppMethodBeat.o(128822);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(128826);
    this.context = paramContext;
    View localView = LayoutInflater.from(paramContext).inflate(r.g.welcome_select_ui, this);
    this.neE = localView.findViewById(r.f.select_lv);
    this.nkm = ((Button)localView.findViewById(r.f.select_login_btn));
    this.nkn = ((Button)localView.findViewById(r.f.select_register_btn));
    this.nko = ((TextView)localView.findViewById(r.f.welcome_language_tv));
    this.neE.setVisibility(8);
    this.nko.setVisibility(8);
    this.nko.setText(LocaleUtil.getLanguageName(paramContext, r.b.language_setting, r.j.app_lang_sys));
    this.nkm.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216010);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/WelcomeSelectView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
        paramAnonymousView = d.YyA;
        if (d.ien())
        {
          localObject = new Intent();
          ((Intent)localObject).setClassName(WelcomeSelectView.this.getContext(), "com.tencent.mm.plugin.repairer.ui.RepairerMainUI");
          paramAnonymousView = WelcomeSelectView.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/WelcomeSelectView$1", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/ui/WelcomeSelectView$1", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/WelcomeSelectView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(216010);
        return false;
      }
    });
    AppMethodBeat.o(128826);
  }
  
  public final void bAk()
  {
    AppMethodBeat.i(128827);
    cL(this.neE);
    cL(this.nko);
    this.neE.setVisibility(0);
    this.nko.setVisibility(0);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215983);
        h.aGY().a(new bv(new bv.a()
        {
          public final void a(g paramAnonymous2g) {}
        }, "launch normal"), 0);
        AppMethodBeat.o(215983);
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
    this.nko.setText(LocaleUtil.getLanguageName(this.context, r.b.language_setting, r.j.app_lang_sys));
    if ((str != null) && (str.equals("language_default"))) {
      this.nko.setText(this.context.getString(r.j.login_language));
    }
    this.nkm.setText(r.j.intro_existed_login);
    this.nkn.setText(r.j.intro_create_account_qq);
    AppMethodBeat.o(128825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeSelectView
 * JD-Core Version:    0.7.0.1
 */