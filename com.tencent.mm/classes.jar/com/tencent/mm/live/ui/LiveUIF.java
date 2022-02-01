package com.tencent.mm.live.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.k;
import com.tencent.mm.live.b.l.j;
import com.tencent.mm.live.view.LiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.m;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/LiveUIF;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getResourceId", "", "handleMLVBClick", "", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-logic_release"})
public final class LiveUIF
  extends MMPreference
{
  public static final a kJc;
  
  static
  {
    AppMethodBeat.i(198212);
    kJc = new a((byte)0);
    AppMethodBeat.o(198212);
  }
  
  public final int getResourceId()
  {
    return b.k.live_entrance_ui;
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(198211);
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
            AppMethodBeat.o(198211);
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(198211);
        return true;
      } while ((!paramf.equals("source_screen")) || (goto 18) || (!paramf.equals("mlvb_live_room")));
      Log.i("MicroMsg.LiveEntranceUI", "");
      paramf = new m((Context)getContext());
      paramf.a((q.f)new b(this));
      paramf.a((q.g)LiveUIF.c.kJe);
      AppMethodBeat.o(198211);
      return true;
    } while ((!paramf.equals("live_demo")) || (goto 18) || (!paramf.equals("live_view")));
    paramf = LiveConfig.c("", "", "19709589717@chatroom", "");
    paramPreference = l.j.kuS;
    paramf.G(l.j.aNT(), LiveVisitorPluginLayout.class.getName());
    paramPreference = new Intent((Context)this, LiveUIA.class);
    paramPreference.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramf);
    paramPreference.addFlags(268435456);
    paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramf.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(198211);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/LiveUIF$Companion;", "", "()V", "LIVE_DEMO", "", "LIVE_VIEW", "MLVB_LIVE_ROOM", "SOURCE_CAMERA", "SOURCE_SCREEN", "TAG", "plugin-logic_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements q.f
  {
    b(LiveUIF paramLiveUIF) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(199980);
      AppCompatActivity localAppCompatActivity = this.kJd.getContext();
      p.j(localAppCompatActivity, "context");
      paramo.d(0, (CharSequence)localAppCompatActivity.getResources().getString(b.h.live_join_room));
      localAppCompatActivity = this.kJd.getContext();
      p.j(localAppCompatActivity, "context");
      paramo.d(1, (CharSequence)localAppCompatActivity.getResources().getString(b.h.live_create_room));
      AppMethodBeat.o(199980);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIF
 * JD-Core Version:    0.7.0.1
 */