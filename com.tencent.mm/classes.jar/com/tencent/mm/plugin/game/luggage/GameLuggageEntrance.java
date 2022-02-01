package com.tencent.mm.plugin.game.luggage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;

public class GameLuggageEntrance
  extends MMActivity
{
  private static final String ItC;
  
  static
  {
    AppMethodBeat.i(276931);
    ItC = "https://" + WeChatHosts.domainString(j.f.host_game_weixin_qq_com) + "/cgi-bin/h5/static/centerbox/index_v6.html?wechat_pkgid=index_v6&abt=21";
    AppMethodBeat.o(276931);
  }
  
  public int getLayoutId()
  {
    return j.d.Iuq;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(82979);
    super.onCreate(paramBundle);
    paramBundle = (EditText)findViewById(j.c.Iui);
    ((Button)findViewById(j.c.Iuj)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82976);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        localObject = paramBundle.getText().toString();
        if (!Util.isNullOrNil((String)localObject))
        {
          new Bundle().putString("rawUrl", (String)localObject);
          paramAnonymousView = new Intent(GameLuggageEntrance.this, LuggageGameWebViewUI.class);
          paramAnonymousView.putExtra("rawUrl", (String)localObject);
          localObject = GameLuggageEntrance.this;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((GameLuggageEntrance)localObject).startActivity((Intent)paramAnonymousView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82976);
      }
    });
    ((Button)findViewById(j.c.Iuk)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82977);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        new Bundle().putString("rawUrl", GameLuggageEntrance.ItC);
        localObject = new Intent(GameLuggageEntrance.this, LuggageGameWebViewUI.class);
        ((Intent)localObject).putExtra("rawUrl", GameLuggageEntrance.ItC);
        paramAnonymousView = GameLuggageEntrance.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82977);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(82978);
        GameLuggageEntrance.this.finish();
        AppMethodBeat.o(82978);
        return false;
      }
    });
    AppMethodBeat.o(82979);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.GameLuggageEntrance
 * JD-Core Version:    0.7.0.1
 */