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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiIntroductionUI
  extends MMActivity
{
  private int source;
  private Button wQN;
  private Button wRX;
  private Button wRY;
  private CheckBox wRZ;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494725;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25063);
    this.wRX = ((Button)findViewById(2131299229));
    this.wRZ = ((CheckBox)findViewById(2131296591));
    this.wQN = ((Button)findViewById(2131302321));
    this.wRY = ((Button)findViewById(2131309631));
    this.source = getIntent().getIntExtra("free_wifi_source", 1);
    if (this.source == 3)
    {
      setMMTitle(2131763048);
      ((TextView)findViewById(2131301742)).setText(2131763046);
      ((TextView)findViewById(2131301737)).setText(2131763045);
      this.wQN.setVisibility(8);
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
      this.wRX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25058);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(303104, Integer.valueOf(1));
          localObject = FreeWifiIntroductionUI.this.getIntent();
          ((Intent)localObject).setClass(FreeWifiIntroductionUI.this, FreeWifiEntryUI.class);
          paramAnonymousView = FreeWifiIntroductionUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          FreeWifiIntroductionUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25058);
        }
      });
      this.wRZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.wRY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25060);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          if (FreeWifiIntroductionUI.b(FreeWifiIntroductionUI.this) == 3) {}
          for (paramAnonymousView = FreeWifiIntroductionUI.this.getString(2131763047);; paramAnonymousView = FreeWifiIntroductionUI.this.getString(2131760971))
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("show_bottom", false);
            com.tencent.mm.br.c.b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25060);
            return;
          }
        }
      });
      this.wQN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25061);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          paramAnonymousView = FreeWifiIntroductionUI.this.getString(2131760951);
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
          ((Intent)localObject).putExtra("showShare", false);
          ((Intent)localObject).putExtra("show_bottom", false);
          com.tencent.mm.br.c.b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiIntroductionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25061);
        }
      });
      AppMethodBeat.o(25063);
      return;
      setMMTitle(2131760974);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI
 * JD-Core Version:    0.7.0.1
 */