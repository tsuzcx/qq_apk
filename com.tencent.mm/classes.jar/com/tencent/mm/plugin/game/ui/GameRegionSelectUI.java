package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.s.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class GameRegionSelectUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private Map<String, GameRegionPreference.a> leD;
  private GameRegionPreference.a lez;
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    if ((paramPreference instanceof GameRegionPreference))
    {
      paramPreference = ((GameRegionPreference)paramPreference).lez;
      if (paramPreference == null) {
        return false;
      }
      this.lez = paramPreference;
      Iterator localIterator = this.leD.values().iterator();
      while (localIterator.hasNext()) {
        ((GameRegionPreference.a)localIterator.next()).fmm = false;
      }
      paramPreference.fmm = true;
      paramf.notifyDataSetChanged();
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(g.i.game_region_setting_title);
    setBackBtn(new GameRegionSelectUI.1(this));
    a(0, getString(g.i.game_region_setting_save), new GameRegionSelectUI.2(this), s.b.uNx);
    this.dnn.removeAll();
    this.leD = a.a.bau().bat();
    Object localObject = com.tencent.mm.plugin.game.model.f.jdMethod_do(this);
    if (localObject != null) {
      ((GameRegionPreference.a)localObject).fmm = true;
    }
    localObject = this.leD.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      GameRegionPreference.a locala = (GameRegionPreference.a)((Iterator)localObject).next();
      if (locala != null)
      {
        GameRegionPreference localGameRegionPreference = new GameRegionPreference(this);
        if ((locala == null) || (bk.bl(locala.cCG))) {
          y.e("MicroMsg.GameRegionPreference", "setData region error");
        }
        for (;;)
        {
          if (!locala.isDefault) {
            break label180;
          }
          this.dnn.a(localGameRegionPreference, 0);
          break;
          localGameRegionPreference.lez = locala;
          localGameRegionPreference.setKey(locala.cCG);
        }
        label180:
        this.dnn.a(localGameRegionPreference);
      }
    }
    localObject = new PreferenceCategory(this);
    this.dnn.a((Preference)localObject);
    this.dnn.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    initView();
  }
  
  protected void onDestroy()
  {
    a.a.bau().bar();
    super.onDestroy();
  }
  
  public final int xj()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionSelectUI
 * JD-Core Version:    0.7.0.1
 */