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
import com.tencent.mm.live.b.f.j;
import com.tencent.mm.live.view.LiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import d.g.b.p;

@com.tencent.mm.ui.base.a(3)
@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/LiveUIF;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getResourceId", "", "handleMLVBClick", "", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-logic_release"})
public final class LiveUIF
  extends MMPreference
{
  public static final a gYW;
  
  static
  {
    AppMethodBeat.i(212827);
    gYW = new a((byte)0);
    AppMethodBeat.o(212827);
  }
  
  public final int getResourceId()
  {
    return 2131951770;
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(212826);
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
            AppMethodBeat.o(212826);
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(212826);
        return true;
      } while ((!paramf.equals("source_screen")) || (goto 18) || (!paramf.equals("mlvb_live_room")));
      ad.i("MicroMsg.LiveEntranceUI", "");
      paramf = new com.tencent.mm.ui.tools.l((Context)getContext());
      paramf.a((n.d)new b(this));
      paramf.a((n.e)c.gYY);
      AppMethodBeat.o(212826);
      return true;
    } while ((!paramf.equals("live_demo")) || (goto 18) || (!paramf.equals("live_view")));
    paramf = LiveConfig.b("", "", "19709589717@chatroom", "");
    paramPreference = f.j.gNB;
    paramf.D(f.j.ank(), LiveVisitorPluginLayout.class.getName());
    paramPreference = new Intent((Context)this, LiveUIA.class);
    paramPreference.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramf);
    paramPreference.addFlags(268435456);
    paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramf.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(212826);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/LiveUIF$Companion;", "", "()V", "LIVE_DEMO", "", "LIVE_VIEW", "MLVB_LIVE_ROOM", "SOURCE_CAMERA", "SOURCE_SCREEN", "TAG", "plugin-logic_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements n.d
  {
    b(LiveUIF paramLiveUIF) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(212824);
      AppCompatActivity localAppCompatActivity = this.gYX.getContext();
      p.g(localAppCompatActivity, "context");
      paraml.c(0, (CharSequence)localAppCompatActivity.getResources().getString(2131766614));
      localAppCompatActivity = this.gYX.getContext();
      p.g(localAppCompatActivity, "context");
      paraml.c(1, (CharSequence)localAppCompatActivity.getResources().getString(2131766581));
      AppMethodBeat.o(212824);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class c
    implements n.e
  {
    public static final c gYY;
    
    static
    {
      AppMethodBeat.i(212825);
      gYY = new c();
      AppMethodBeat.o(212825);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIF
 * JD-Core Version:    0.7.0.1
 */