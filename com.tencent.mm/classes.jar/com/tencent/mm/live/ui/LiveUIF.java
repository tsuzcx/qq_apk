package com.tencent.mm.live.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.k;
import com.tencent.mm.live.model.l.j;
import com.tencent.mm.live.view.LiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.l;
import java.util.HashMap;
import kotlin.Metadata;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/LiveUIF;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getResourceId", "", "handleMLVBClick", "", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveUIF
  extends MMPreference
{
  public static final LiveUIF.a nlE;
  
  static
  {
    AppMethodBeat.i(246294);
    nlE = new LiveUIF.a((byte)0);
    AppMethodBeat.o(246294);
  }
  
  private static final void a(MenuItem paramMenuItem, int paramInt) {}
  
  private static final void a(LiveUIF paramLiveUIF, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(246281);
    kotlin.g.b.s.u(paramLiveUIF, "this$0");
    params.c(0, (CharSequence)paramLiveUIF.getContext().getResources().getString(b.h.live_join_room));
    params.c(1, (CharSequence)paramLiveUIF.getContext().getResources().getString(b.h.live_create_room));
    AppMethodBeat.o(246281);
  }
  
  public final int getResourceId()
  {
    return b.k.live_entrance_ui;
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(246331);
    if (paramPreference == null)
    {
      paramf = null;
      if (paramf != null) {
        switch (paramf.hashCode())
        {
        }
      }
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(246331);
          return false;
          paramf = paramPreference.mKey;
          break;
        } while ((paramf.equals("source_screen")) || (goto 68) || (!paramf.equals("mlvb_live_room")));
        Log.i("MicroMsg.LiveEntranceUI", "");
        paramf = new l((Context)getContext());
        paramf.Vtg = new LiveUIF..ExternalSyntheticLambda0(this);
        paramf.GAC = LiveUIF..ExternalSyntheticLambda1.INSTANCE;
        AppMethodBeat.o(246331);
        return true;
      } while ((paramf.equals("live_demo")) || (goto 68) || (!paramf.equals("live_view")));
      paramf = LiveConfig.b("", "", "19709589717@chatroom", "");
      paramPreference = l.j.mYK;
      int i = l.j.bhE();
      paramPreference = LiveVisitorPluginLayout.class.getName();
      paramf.mIB.put(Integer.valueOf(i), paramPreference);
      paramPreference = new Intent((Context)this, LiveUIA.class);
      paramPreference.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramf);
      paramPreference.addFlags(268435456);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(246331);
      return true;
    } while (!paramf.equals("source_camera"));
    paramf = new Intent((Context)this, LiveUIA.class);
    paramf.putExtra("KEY_PARAMS_CONFIG", (Parcelable)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG"));
    paramf.addFlags(268435456);
    paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramf.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/live/ui/LiveUIF", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(246331);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIF
 * JD-Core Version:    0.7.0.1
 */