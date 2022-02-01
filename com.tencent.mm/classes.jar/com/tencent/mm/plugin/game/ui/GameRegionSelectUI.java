package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class GameRegionSelectUI
  extends MMPreference
{
  private f screen;
  private GameRegionPreference.a uDF;
  private Map<String, GameRegionPreference.a> uDJ;
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42361);
    setMMTitle(2131759972);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42356);
        GameRegionSelectUI.this.setResult(0);
        GameRegionSelectUI.this.hideVKB();
        GameRegionSelectUI.this.finish();
        AppMethodBeat.o(42356);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131759971), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42358);
        if (e.fA(GameRegionSelectUI.this))
        {
          h.a(GameRegionSelectUI.this, true, GameRegionSelectUI.this.getString(2131759969), "", GameRegionSelectUI.this.getString(2131759970), GameRegionSelectUI.this.getString(2131759968), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(42357);
              e.fB(GameRegionSelectUI.this);
              GameRegionSelectUI.a(GameRegionSelectUI.this);
              paramAnonymous2DialogInterface = new Intent();
              GameRegionPreference.a locala = e.fr(GameRegionSelectUI.this);
              if (locala != null)
              {
                paramAnonymous2DialogInterface.putExtra("gameRegionName", e.a(locala));
                GameRegionSelectUI.this.setResult(-1, paramAnonymous2DialogInterface);
              }
              for (;;)
              {
                GameRegionSelectUI.this.finish();
                AppMethodBeat.o(42357);
                return;
                GameRegionSelectUI.this.setResult(1);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(42358);
          return true;
        }
        GameRegionSelectUI.a(GameRegionSelectUI.this);
        paramAnonymousMenuItem = new Intent();
        GameRegionPreference.a locala = e.fr(GameRegionSelectUI.this);
        if (locala != null)
        {
          paramAnonymousMenuItem.putExtra("gameRegionName", e.a(locala));
          GameRegionSelectUI.this.setResult(-1, paramAnonymousMenuItem);
        }
        for (;;)
        {
          GameRegionSelectUI.this.finish();
          break;
          GameRegionSelectUI.this.setResult(1);
        }
      }
    }, null, s.b.JwA);
    this.screen.removeAll();
    this.uDJ = a.a.dde().ddd();
    Object localObject = e.fr(this);
    if (localObject != null) {
      ((GameRegionPreference.a)localObject).isSelected = true;
    }
    localObject = this.uDJ.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      GameRegionPreference.a locala = (GameRegionPreference.a)((Iterator)localObject).next();
      if (locala != null)
      {
        GameRegionPreference localGameRegionPreference = new GameRegionPreference(this);
        if ((locala == null) || (bu.isNullOrNil(locala.eRl))) {
          ae.e("MicroMsg.GameRegionPreference", "setData region error");
        }
        for (;;)
        {
          if (!locala.isDefault) {
            break label184;
          }
          this.screen.a(localGameRegionPreference, 0);
          break;
          localGameRegionPreference.uDF = locala;
          localGameRegionPreference.setKey(locala.eRl);
        }
        label184:
        this.screen.b(localGameRegionPreference);
      }
    }
    localObject = new PreferenceCategory(this);
    this.screen.b((Preference)localObject);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(42361);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42359);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(42359);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42360);
    a.a.dde().ddb();
    super.onDestroy();
    AppMethodBeat.o(42360);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(42362);
    if ((paramPreference instanceof GameRegionPreference))
    {
      paramPreference = ((GameRegionPreference)paramPreference).uDF;
      if (paramPreference == null)
      {
        AppMethodBeat.o(42362);
        return false;
      }
      this.uDF = paramPreference;
      Iterator localIterator = this.uDJ.values().iterator();
      while (localIterator.hasNext()) {
        ((GameRegionPreference.a)localIterator.next()).isSelected = false;
      }
      paramPreference.isSelected = true;
      paramf.notifyDataSetChanged();
      AppMethodBeat.o(42362);
      return true;
    }
    AppMethodBeat.o(42362);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionSelectUI
 * JD-Core Version:    0.7.0.1
 */