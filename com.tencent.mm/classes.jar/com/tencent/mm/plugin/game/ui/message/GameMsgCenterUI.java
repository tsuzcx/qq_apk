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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public class GameMsgCenterUI
  extends MMActivity
{
  private int fromScene;
  private ViewPager rN;
  private int snl = 0;
  private TabItemView snm;
  private TabItemView snn;
  private a sno;
  private b snp;
  private int snq;
  private int snr;
  
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
    paramBundle = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().acA(paramBundle);
    if (paramBundle != null) {
      this.snl = paramBundle.field_showType;
    }
    if (this.snl == 0)
    {
      this.snq = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().EB(1);
      this.snr = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().EB(2);
      if ((this.snq > 0) || (this.snr <= 0)) {
        break label432;
      }
    }
    label432:
    for (this.snl = 2;; this.snl = 1)
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
      this.snm = ((TabItemView)findViewById(2131305607));
      this.snm.setShowType(1);
      this.snn = ((TabItemView)findViewById(2131305608));
      this.snn.setShowType(2);
      this.rN = ((ViewPager)findViewById(2131302255));
      paramBundle = new a(getSupportFragmentManager());
      GameMsgCenterFragment localGameMsgCenterFragment = new GameMsgCenterFragment();
      this.sno = new a(this, this.fromScene);
      this.sno.setNewMessageCount(this.snq);
      localGameMsgCenterFragment.contentView = this.sno;
      paramBundle.a(localGameMsgCenterFragment);
      localGameMsgCenterFragment = new GameMsgCenterFragment();
      this.snp = new b(this, this.fromScene);
      this.snp.setNewMessageCount(this.snr);
      localGameMsgCenterFragment.contentView = this.snp;
      paramBundle.a(localGameMsgCenterFragment);
      this.rN.setAdapter(paramBundle);
      this.snm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183871);
          GameMsgCenterUI.this.setCurrentItem(0);
          com.tencent.mm.game.report.e.a(GameMsgCenterUI.this.getContext(), 13, 1303, 1, 2, GameMsgCenterUI.a(GameMsgCenterUI.this), null);
          AppMethodBeat.o(183871);
        }
      });
      this.snn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183872);
          GameMsgCenterUI.this.setCurrentItem(1);
          com.tencent.mm.game.report.e.a(GameMsgCenterUI.this.getContext(), 13, 1303, 2, 2, GameMsgCenterUI.a(GameMsgCenterUI.this), null);
          AppMethodBeat.o(183872);
        }
      });
      this.rN.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(183873);
          ad.i("MicroMsg.GameMsgCenterUI", "onPageSelected:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          GameMsgCenterUI.this.setCurrentItem(paramAnonymousInt);
          AppMethodBeat.o(183873);
        }
      });
      if (this.snl != 2) {
        break;
      }
      this.snm.setUnreadCount(((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().EB(1));
      setCurrentItem(1);
      AppMethodBeat.o(183878);
      return;
    }
    this.snn.setUnreadCount(((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().EB(2));
    setCurrentItem(0);
    AppMethodBeat.o(183878);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(183879);
    super.onDestroy();
    Object localObject;
    if (this.sno != null)
    {
      localObject = this.sno;
      if (((a)localObject).snj != null)
      {
        localObject = ((a)localObject).snj.snv.Qs;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    if (this.snp != null)
    {
      localObject = this.snp;
      if (((b)localObject).snu != null)
      {
        localObject = ((b)localObject).snu.snI.Qs;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().cDs();
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
      this.snm.setSelected(true);
      this.snn.setSelected(false);
      this.sno.resume();
    }
    for (;;)
    {
      this.rN.setCurrentItem(paramInt);
      AppMethodBeat.o(183880);
      return;
      this.snm.setSelected(false);
      this.snn.setSelected(true);
      this.snp.resume();
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
    private List<GameMsgCenterUI.GameMsgCenterFragment> snt;
    
    public a(android.support.v4.app.g paramg)
    {
      super();
      AppMethodBeat.i(183874);
      this.snt = new ArrayList();
      AppMethodBeat.o(183874);
    }
    
    public final void a(GameMsgCenterUI.GameMsgCenterFragment paramGameMsgCenterFragment)
    {
      AppMethodBeat.i(183875);
      this.snt.add(paramGameMsgCenterFragment);
      AppMethodBeat.o(183875);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(183877);
      int i = this.snt.size();
      AppMethodBeat.o(183877);
      return i;
    }
    
    public final Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(183876);
      Object localObject = this.snt;
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