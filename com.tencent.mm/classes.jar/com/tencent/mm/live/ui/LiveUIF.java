package com.tencent.mm.live.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e.j;
import com.tencent.mm.live.view.LiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

@com.tencent.mm.ui.base.a(3)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/LiveUIF;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getResourceId", "", "handleMLVBClick", "", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-logic_release"})
public final class LiveUIF
  extends MMPreference
{
  public static final LiveUIF.a KyM;
  
  static
  {
    AppMethodBeat.i(203296);
    KyM = new LiveUIF.a((byte)0);
    AppMethodBeat.o(203296);
  }
  
  public final int getResourceId()
  {
    return 2131951770;
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(203295);
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
            AppMethodBeat.o(203295);
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(203295);
        return true;
      } while ((!paramf.equals("source_screen")) || (goto 18) || (!paramf.equals("mlvb_live_room")));
      ad.i("MicroMsg.LiveEntranceUI", "");
      paramf = new com.tencent.mm.ui.tools.l((Context)getContext());
      paramf.a((n.c)new LiveUIF.b(this));
      paramf.a((n.d)LiveUIF.c.KyO);
      AppMethodBeat.o(203295);
      return true;
    } while ((!paramf.equals("live_demo")) || (goto 18) || (!paramf.equals("live_view")));
    paramf = LiveConfig.z("", "", "19709589717@chatroom", "");
    paramPreference = e.j.rFK;
    paramf.bx(e.j.eNz(), LiveVisitorPluginLayout.class.getName());
    paramPreference = new Intent((Context)this, LiveUIA.class);
    paramPreference.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramf);
    paramPreference.addFlags(268435456);
    paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramf.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203295);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIF
 * JD-Core Version:    0.7.0.1
 */