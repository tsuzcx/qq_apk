package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiIntroductionUI
  extends MMActivity
{
  private int dep;
  private Button rjz;
  private Button rkK;
  private Button rkL;
  private CheckBox rkM;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494171;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25063);
    this.rkK = ((Button)findViewById(2131298782));
    this.rkM = ((CheckBox)findViewById(2131296517));
    this.rjz = ((Button)findViewById(2131300737));
    this.rkL = ((Button)findViewById(2131306232));
    this.dep = getIntent().getIntExtra("free_wifi_source", 1);
    if (this.dep == 3)
    {
      setMMTitle(2131761233);
      ((TextView)findViewById(2131300263)).setText(2131761231);
      ((TextView)findViewById(2131300258)).setText(2131761230);
      this.rjz.setVisibility(8);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(25057);
          FreeWifiIntroductionUI.this.finish();
          AppMethodBeat.o(25057);
          return false;
        }
      });
      this.rkK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25058);
          az.arV();
          c.afk().set(303104, Integer.valueOf(1));
          Object localObject = FreeWifiIntroductionUI.this.getIntent();
          ((Intent)localObject).setClass(FreeWifiIntroductionUI.this, FreeWifiEntryUI.class);
          paramAnonymousView = FreeWifiIntroductionUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          FreeWifiIntroductionUI.this.finish();
          AppMethodBeat.o(25058);
        }
      });
      this.rkM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(25059);
          if (paramAnonymousBoolean)
          {
            FreeWifiIntroductionUI.a(FreeWifiIntroductionUI.this).setEnabled(true);
            AppMethodBeat.o(25059);
            return;
          }
          FreeWifiIntroductionUI.a(FreeWifiIntroductionUI.this).setEnabled(false);
          AppMethodBeat.o(25059);
        }
      });
      this.rkL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25060);
          if (FreeWifiIntroductionUI.b(FreeWifiIntroductionUI.this) == 3) {}
          for (paramAnonymousView = FreeWifiIntroductionUI.this.getString(2131761232);; paramAnonymousView = FreeWifiIntroductionUI.this.getString(2131759650))
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousView);
            localIntent.putExtra("showShare", false);
            localIntent.putExtra("show_bottom", false);
            d.b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(25060);
            return;
          }
        }
      });
      this.rjz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25061);
          paramAnonymousView = FreeWifiIntroductionUI.this.getString(2131759630);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramAnonymousView);
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("show_bottom", false);
          d.b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(25061);
        }
      });
      AppMethodBeat.o(25063);
      return;
      setMMTitle(2131759653);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25062);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(25062);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI
 * JD-Core Version:    0.7.0.1
 */