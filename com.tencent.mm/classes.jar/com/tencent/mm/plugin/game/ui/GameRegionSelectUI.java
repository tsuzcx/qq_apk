package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.q.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class GameRegionSelectUI
  extends MMPreference
{
  private GameRegionPreference.a nCu;
  private Map<String, GameRegionPreference.a> nCy;
  private f screen;
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(112163);
    setMMTitle(2131300450);
    setBackBtn(new GameRegionSelectUI.1(this));
    addTextOptionMenu(0, getString(2131300449), new GameRegionSelectUI.2(this), null, q.b.zby);
    this.screen.removeAll();
    this.nCy = a.a.bHB().bHA();
    Object localObject = e.eb(this);
    if (localObject != null) {
      ((GameRegionPreference.a)localObject).gDG = true;
    }
    localObject = this.nCy.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      GameRegionPreference.a locala = (GameRegionPreference.a)((Iterator)localObject).next();
      if (locala != null)
      {
        GameRegionPreference localGameRegionPreference = new GameRegionPreference(this);
        if ((locala == null) || (bo.isNullOrNil(locala.dqQ))) {
          ab.e("MicroMsg.GameRegionPreference", "setData region error");
        }
        for (;;)
        {
          if (!locala.isDefault) {
            break label184;
          }
          this.screen.a(localGameRegionPreference, 0);
          break;
          localGameRegionPreference.nCu = locala;
          localGameRegionPreference.setKey(locala.dqQ);
        }
        label184:
        this.screen.b(localGameRegionPreference);
      }
    }
    localObject = new PreferenceCategory(this);
    this.screen.b((Preference)localObject);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(112163);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112161);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(112161);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112162);
    a.a.bHB().bHy();
    super.onDestroy();
    AppMethodBeat.o(112162);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(112165);
    if ((paramPreference instanceof GameRegionPreference))
    {
      paramPreference = ((GameRegionPreference)paramPreference).nCu;
      if (paramPreference == null)
      {
        AppMethodBeat.o(112165);
        return false;
      }
      this.nCu = paramPreference;
      Iterator localIterator = this.nCy.values().iterator();
      while (localIterator.hasNext()) {
        ((GameRegionPreference.a)localIterator.next()).gDG = false;
      }
      paramPreference.gDG = true;
      paramf.notifyDataSetChanged();
      AppMethodBeat.o(112165);
      return true;
    }
    AppMethodBeat.o(112165);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionSelectUI
 * JD-Core Version:    0.7.0.1
 */