package com.tencent.mm.plugin.game.ui.message;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.List;

public class GameMsgCenterUI
  extends MMActivity
{
  private int fromScene;
  private ViewPager uH;
  private int uut = 0;
  private TabItemView uuu;
  private TabItemView uuv;
  private a uuw;
  private b uux;
  private int uuy;
  private int uuz;
  
  public int getLayoutId()
  {
    return 2131494352;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(183878);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    boolean bool = ao.abX(getResources().getColor(2131101179));
    paramBundle = getContentView();
    int i = getResources().getColor(2131101179);
    if (!bool)
    {
      bool = true;
      com.tencent.mm.ui.statusbar.a.e(paramBundle, i, bool);
      this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
      paramBundle = getIntent().getStringExtra("game_msg_ui_from_msgid");
      i = getIntent().getIntExtra("game_msg_center_tab_type", 0);
      if (i != 1) {
        break label474;
      }
      this.uut = 1;
      label102:
      if (this.uut == 0)
      {
        this.uuy = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().HR(1);
        this.uuz = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().HR(2);
        if ((this.uuy > 0) || (this.uuz <= 0)) {
          break label520;
        }
      }
    }
    label520:
    for (this.uut = 2;; this.uut = 1)
    {
      findViewById(2131296396).setOnClickListener(new GameMsgCenterUI.1(this));
      findViewById(2131296409).setOnClickListener(new GameMsgCenterUI.2(this));
      this.uuu = ((TabItemView)findViewById(2131305607));
      this.uuu.setShowType(1);
      this.uuv = ((TabItemView)findViewById(2131305608));
      this.uuv.setShowType(2);
      this.uH = ((ViewPager)findViewById(2131302255));
      paramBundle = new a(getSupportFragmentManager());
      GameMsgCenterFragment localGameMsgCenterFragment = new GameMsgCenterFragment();
      this.uuw = new a(this, this.fromScene);
      this.uuw.setNewMessageCount(this.uuy);
      localGameMsgCenterFragment.contentView = this.uuw;
      paramBundle.a(localGameMsgCenterFragment);
      localGameMsgCenterFragment = new GameMsgCenterFragment();
      this.uux = new b(this, this.fromScene);
      this.uux.setNewMessageCount(this.uuz);
      localGameMsgCenterFragment.contentView = this.uux;
      paramBundle.a(localGameMsgCenterFragment);
      this.uH.setAdapter(paramBundle);
      this.uuu.setOnClickListener(new GameMsgCenterUI.3(this));
      this.uuv.setOnClickListener(new GameMsgCenterUI.4(this));
      this.uH.addOnPageChangeListener(new GameMsgCenterUI.5(this));
      if (this.uut != 2) {
        break label528;
      }
      this.uuu.setUnreadCount(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().HR(1));
      setCurrentItem(1);
      AppMethodBeat.o(183878);
      return;
      bool = false;
      break;
      label474:
      if (i == 2)
      {
        this.uut = 2;
        break label102;
      }
      paramBundle = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().alU(paramBundle);
      if (paramBundle == null) {
        break label102;
      }
      this.uut = paramBundle.field_showType;
      break label102;
    }
    label528:
    this.uuv.setUnreadCount(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().HR(2));
    setCurrentItem(0);
    AppMethodBeat.o(183878);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(183879);
    super.onDestroy();
    Object localObject;
    if (this.uuw != null)
    {
      localObject = this.uuw;
      if (((a)localObject).uur != null)
      {
        localObject = ((a)localObject).uur.uuD.Tc;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    if (this.uux != null)
    {
      localObject = this.uux;
      if (((b)localObject).uuC != null)
      {
        localObject = ((b)localObject).uuC.uuQ.Tc;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().cZh();
    AppMethodBeat.o(183879);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(183880);
    if (paramInt % 2 == 0)
    {
      this.uuu.setSelected(true);
      this.uuv.setSelected(false);
      this.uuw.resume();
    }
    for (;;)
    {
      this.uH.setCurrentItem(paramInt);
      AppMethodBeat.o(183880);
      return;
      this.uuu.setSelected(false);
      this.uuv.setSelected(true);
      this.uux.resume();
    }
  }
  
  public static class GameMsgCenterFragment
    extends Fragment
  {
    View contentView;
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      return this.contentView;
    }
  }
  
  static final class a
    extends i
  {
    private List<GameMsgCenterUI.GameMsgCenterFragment> uuB;
    
    public a(android.support.v4.app.g paramg)
    {
      super();
      AppMethodBeat.i(183874);
      this.uuB = new ArrayList();
      AppMethodBeat.o(183874);
    }
    
    public final void a(GameMsgCenterUI.GameMsgCenterFragment paramGameMsgCenterFragment)
    {
      AppMethodBeat.i(183875);
      this.uuB.add(paramGameMsgCenterFragment);
      AppMethodBeat.o(183875);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(183877);
      int i = this.uuB.size();
      AppMethodBeat.o(183877);
      return i;
    }
    
    public final Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(183876);
      Object localObject = this.uuB;
      localObject = (Fragment)((List)localObject).get(paramInt % ((List)localObject).size());
      AppMethodBeat.o(183876);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI
 * JD-Core Version:    0.7.0.1
 */