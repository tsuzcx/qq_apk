package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

@i
public class AAEntranceUI
  extends MMActivity
{
  private Button iBs;
  private TextView iBt;
  
  public int getLayoutId()
  {
    return 2131492880;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63475);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(63475);
      return;
    }
    if (paramInt1 == 1)
    {
      String str = paramIntent.getStringExtra("Select_Conv_User");
      ac.i("MicroMsg.AAEntranceUI", "select chatroom：%s", new Object[] { str });
      if (!bs.isNullOrNil(str))
      {
        Intent localIntent = new Intent(getContext(), LaunchAAUI.class);
        localIntent.putExtra("enter_scene", 2);
        localIntent.putExtra("chatroom_name", str);
        if (getIntent().getExtras() != null) {
          localIntent.putExtras(getIntent().getExtras());
        }
        startActivityForResult(localIntent, 2);
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(63475);
      return;
      if (paramInt1 == 2) {
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63474);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle("");
    this.iBs = ((Button)findViewById(2131301332));
    this.iBt = ((TextView)findViewById(2131298215));
    this.iBs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(63471);
        AAEntranceUI.a(AAEntranceUI.this);
        AppMethodBeat.o(63471);
      }
    });
    this.iBt.setClickable(true);
    this.iBt.setOnTouchListener(new n(this));
    paramBundle = new SpannableStringBuilder(getString(2131757336));
    paramBundle.setSpan(new a(new a.a()
    {
      public final void aOb()
      {
        AppMethodBeat.i(63472);
        Object localObject = new Intent(AAEntranceUI.this.getContext(), AAQueryListUI.class);
        AAEntranceUI localAAEntranceUI = AAEntranceUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localAAEntranceUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/aa/ui/AAEntranceUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localAAEntranceUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localAAEntranceUI, "com/tencent/mm/plugin/aa/ui/AAEntranceUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(63472);
      }
    }), 0, paramBundle.length(), 18);
    this.iBt.setText(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63473);
        AAEntranceUI.this.finish();
        AppMethodBeat.o(63473);
        return false;
      }
    });
    AppMethodBeat.o(63474);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAEntranceUI
 * JD-Core Version:    0.7.0.1
 */