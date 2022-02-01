package com.tencent.mm.plugin.game.ui.message;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public class GameMsgCenterUI
  extends MMActivity
{
  private int fromScene;
  private ViewPager sO;
  private int tve = 0;
  private TabItemView tvf;
  private TabItemView tvg;
  private a tvh;
  private b tvi;
  private int tvj;
  private int tvk;
  
  public int getLayoutId()
  {
    return 2131494352;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(183878);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
    paramBundle = getIntent().getStringExtra("game_msg_ui_from_msgid");
    paramBundle = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().ahs(paramBundle);
    if (paramBundle != null) {
      this.tve = paramBundle.field_showType;
    }
    if (this.tve == 0)
    {
      this.tvj = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gx(1);
      this.tvk = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gx(2);
      if ((this.tvj > 0) || (this.tvk <= 0)) {
        break label432;
      }
    }
    label432:
    for (this.tve = 2;; this.tve = 1)
    {
      findViewById(2131296397).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183870);
          GameMsgCenterUI.this.finish();
          AppMethodBeat.o(183870);
        }
      });
      findViewById(2131296409).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView) {}
      });
      this.tvf = ((TabItemView)findViewById(2131305607));
      this.tvf.setShowType(1);
      this.tvg = ((TabItemView)findViewById(2131305608));
      this.tvg.setShowType(2);
      this.sO = ((ViewPager)findViewById(2131302255));
      paramBundle = new a(getSupportFragmentManager());
      GameMsgCenterFragment localGameMsgCenterFragment = new GameMsgCenterFragment();
      this.tvh = new a(this, this.fromScene);
      this.tvh.setNewMessageCount(this.tvj);
      localGameMsgCenterFragment.contentView = this.tvh;
      paramBundle.a(localGameMsgCenterFragment);
      localGameMsgCenterFragment = new GameMsgCenterFragment();
      this.tvi = new b(this, this.fromScene);
      this.tvi.setNewMessageCount(this.tvk);
      localGameMsgCenterFragment.contentView = this.tvi;
      paramBundle.a(localGameMsgCenterFragment);
      this.sO.setAdapter(paramBundle);
      this.tvf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183871);
          GameMsgCenterUI.this.setCurrentItem(0);
          com.tencent.mm.game.report.e.a(GameMsgCenterUI.this.getContext(), 13, 1303, 1, 2, GameMsgCenterUI.a(GameMsgCenterUI.this), null);
          AppMethodBeat.o(183871);
        }
      });
      this.tvg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183872);
          GameMsgCenterUI.this.setCurrentItem(1);
          com.tencent.mm.game.report.e.a(GameMsgCenterUI.this.getContext(), 13, 1303, 2, 2, GameMsgCenterUI.a(GameMsgCenterUI.this), null);
          AppMethodBeat.o(183872);
        }
      });
      this.sO.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(183873);
          ac.i("MicroMsg.GameMsgCenterUI", "onPageSelected:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          GameMsgCenterUI.this.setCurrentItem(paramAnonymousInt);
          AppMethodBeat.o(183873);
        }
      });
      if (this.tve != 2) {
        break;
      }
      this.tvf.setUnreadCount(((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gx(1));
      setCurrentItem(1);
      AppMethodBeat.o(183878);
      return;
    }
    this.tvg.setUnreadCount(((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().Gx(2));
    setCurrentItem(0);
    AppMethodBeat.o(183878);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(183879);
    super.onDestroy();
    Object localObject;
    if (this.tvh != null)
    {
      localObject = this.tvh;
      if (((a)localObject).tvc != null)
      {
        localObject = ((a)localObject).tvc.tvo.Rn;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    if (this.tvi != null)
    {
      localObject = this.tvi;
      if (((b)localObject).tvn != null)
      {
        localObject = ((b)localObject).tvn.tvB.Rn;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().cQC();
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
      this.tvf.setSelected(true);
      this.tvg.setSelected(false);
      this.tvh.resume();
    }
    for (;;)
    {
      this.sO.setCurrentItem(paramInt);
      AppMethodBeat.o(183880);
      return;
      this.tvf.setSelected(false);
      this.tvg.setSelected(true);
      this.tvi.resume();
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
    private List<GameMsgCenterUI.GameMsgCenterFragment> tvm;
    
    public a(android.support.v4.app.g paramg)
    {
      super();
      AppMethodBeat.i(183874);
      this.tvm = new ArrayList();
      AppMethodBeat.o(183874);
    }
    
    public final void a(GameMsgCenterUI.GameMsgCenterFragment paramGameMsgCenterFragment)
    {
      AppMethodBeat.i(183875);
      this.tvm.add(paramGameMsgCenterFragment);
      AppMethodBeat.o(183875);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(183877);
      int i = this.tvm.size();
      AppMethodBeat.o(183877);
      return i;
    }
    
    public final Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(183876);
      Object localObject = this.tvm;
      localObject = (Fragment)((List)localObject).get(paramInt % ((List)localObject).size());
      AppMethodBeat.o(183876);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI
 * JD-Core Version:    0.7.0.1
 */