package com.tencent.mm.live.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o.k;
import com.tencent.mm.live.view.LiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import kotlin.g.b.p;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/LiveUIF;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getResourceId", "", "handleMLVBClick", "", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-logic_release"})
public final class LiveUIF
  extends MMPreference
{
  public static final a hUD;
  
  static
  {
    AppMethodBeat.i(208416);
    hUD = new a((byte)0);
    AppMethodBeat.o(208416);
  }
  
  public final int getResourceId()
  {
    return 2132017231;
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(208415);
    if (paramPreference != null)
    {
      paramf = paramPreference.getKey();
      if (paramf != null) {
        break label30;
      }
    }
    label30:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(208415);
            return false;
            paramf = null;
            break;
            switch (paramf.hashCode())
            {
            }
          }
        } while (!paramf.equals("source_camera"));
        paramf = new Intent((Context)this, LiveUIA.class);
        paramf.putExtra("KEY_PARAMS_CONFIG", (Parcelable)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG"));
        paramf.addFlags(268435456);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(208415);
        return true;
      } while ((!paramf.equals("source_screen")) || (goto 18) || (!paramf.equals("mlvb_live_room")));
      Log.i("MicroMsg.LiveEntranceUI", "");
      paramf = new com.tencent.mm.ui.tools.l((Context)getContext());
      paramf.a((o.f)new b(this));
      paramf.a((o.g)c.hUF);
      AppMethodBeat.o(208415);
      return true;
    } while ((!paramf.equals("live_demo")) || (goto 18) || (!paramf.equals("live_view")));
    paramf = LiveConfig.b("", "", "19709589717@chatroom", "");
    paramPreference = o.k.hHn;
    paramf.F(o.k.aFM(), LiveVisitorPluginLayout.class.getName());
    paramPreference = new Intent((Context)this, LiveUIA.class);
    paramPreference.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramf);
    paramPreference.addFlags(268435456);
    paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramf.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(208415);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/LiveUIF$Companion;", "", "()V", "LIVE_DEMO", "", "LIVE_VIEW", "MLVB_LIVE_ROOM", "SOURCE_CAMERA", "SOURCE_SCREEN", "TAG", "plugin-logic_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements o.f
  {
    b(LiveUIF paramLiveUIF) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(208413);
      AppCompatActivity localAppCompatActivity = this.hUE.getContext();
      p.g(localAppCompatActivity, "context");
      paramm.d(0, (CharSequence)localAppCompatActivity.getResources().getString(2131762304));
      localAppCompatActivity = this.hUE.getContext();
      p.g(localAppCompatActivity, "context");
      paramm.d(1, (CharSequence)localAppCompatActivity.getResources().getString(2131762271));
      AppMethodBeat.o(208413);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class c
    implements o.g
  {
    public static final c hUF;
    
    static
    {
      AppMethodBeat.i(208414);
      hUF = new c();
      AppMethodBeat.o(208414);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIF
 * JD-Core Version:    0.7.0.1
 */