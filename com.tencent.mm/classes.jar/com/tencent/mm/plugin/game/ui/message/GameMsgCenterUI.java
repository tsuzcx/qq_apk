package com.tencent.mm.plugin.game.ui.message;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.plugin.game.d.ct;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameMsgCenterUI
  extends MMActivity
{
  private int fromScene;
  private int uFP = 0;
  private TabItemView uFQ;
  private TabItemView uFR;
  private a uFS;
  private b uFT;
  private int uFU;
  private int uFV;
  private int uFW = 0;
  private ViewPager uH;
  
  public int getLayoutId()
  {
    return 2131494352;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(183878);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    boolean bool = ao.acF(getResources().getColor(2131101179));
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
      this.uFP = 1;
      label102:
      if (this.uFP == 0)
      {
        this.uFU = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().Io(1);
        this.uFV = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().Io(2);
        if ((this.uFU > 0) || (this.uFV <= 0)) {
          break label520;
        }
      }
    }
    label520:
    for (this.uFP = 2;; this.uFP = 1)
    {
      findViewById(2131296396).setOnClickListener(new GameMsgCenterUI.1(this));
      findViewById(2131296409).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(195779);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new e(GameMsgCenterUI.this.getContext(), 1, false);
          paramAnonymousView.LfS = new n.d()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(195775);
              if (GameMsgCenterUI.a(GameMsgCenterUI.this) == 0)
              {
                paramAnonymous2l.jM(0, 2131767088);
                AppMethodBeat.o(195775);
                return;
              }
              paramAnonymous2l.jM(1, 2131767094);
              paramAnonymous2l.jM(2, 2131767092);
              AppMethodBeat.o(195775);
            }
          };
          paramAnonymousView.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(195778);
              ae.i("MicroMsg.GameMsgCenterUI", "bottomSheet itemId:%d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
              Object localObject = new d.a(GameMsgCenterUI.this.getContext());
              ((d.a)localObject).zf(false);
              ((d.a)localObject).afV(2131755691).d(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int) {}
              });
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                AppMethodBeat.o(195778);
                return;
              case 0: 
                ((d.a)localObject).afR(2131767089);
                ((d.a)localObject).afU(2131755694).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(195776);
                    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().Ip(1);
                    if (GameMsgCenterUI.b(GameMsgCenterUI.this) != null)
                    {
                      paramAnonymous3DialogInterface = GameMsgCenterUI.b(GameMsgCenterUI.this);
                      if (((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().In(1) == 0)
                      {
                        if ((paramAnonymous3DialogInterface.uFN != null) && (paramAnonymous3DialogInterface.indexOfChild(paramAnonymous3DialogInterface.uFN) >= 0)) {
                          paramAnonymous3DialogInterface.removeView(paramAnonymous3DialogInterface.uFN);
                        }
                        if ((paramAnonymous3DialogInterface.GG != null) && (paramAnonymous3DialogInterface.indexOfChild(paramAnonymous3DialogInterface.GG) < 0)) {
                          paramAnonymous3DialogInterface.addView(paramAnonymous3DialogInterface.GG);
                        }
                      }
                    }
                    AppMethodBeat.o(195776);
                  }
                });
                ((d.a)localObject).fQv().show();
                AppMethodBeat.o(195778);
                return;
              case 1: 
                paramAnonymous2MenuItem = com.tencent.mm.plugin.game.commlib.a.cZA();
                if ((paramAnonymous2MenuItem != null) && (!bu.ht(paramAnonymous2MenuItem.usl)))
                {
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.usl.iterator();
                  do
                  {
                    if (!paramAnonymous2MenuItem.hasNext()) {
                      break;
                    }
                    localObject = (ct)paramAnonymous2MenuItem.next();
                  } while ((((ct)localObject).uuz != 1) || (bu.isNullOrNil(((ct)localObject).uqf)));
                }
                break;
              }
              for (paramAnonymous2MenuItem = ((ct)localObject).uqf;; paramAnonymous2MenuItem = "https://game.weixin.qq.com/cgi-bin/h5/static/gamecenter/subscription_list.html?wechat_pkgid=gamecenter_subscription_list&ssid=5")
              {
                com.tencent.mm.plugin.game.f.c.aD(GameMsgCenterUI.this.getContext(), paramAnonymous2MenuItem);
                AppMethodBeat.o(195778);
                return;
                ((d.a)localObject).afR(2131767093);
                ((d.a)localObject).afU(2131755694).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(195777);
                    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().Ip(2);
                    if (GameMsgCenterUI.c(GameMsgCenterUI.this) != null)
                    {
                      paramAnonymous3DialogInterface = GameMsgCenterUI.c(GameMsgCenterUI.this);
                      if (((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().In(2) == 0)
                      {
                        if ((paramAnonymous3DialogInterface.uGb != null) && (paramAnonymous3DialogInterface.indexOfChild(paramAnonymous3DialogInterface.uGb) >= 0)) {
                          paramAnonymous3DialogInterface.removeView(paramAnonymous3DialogInterface.uGb);
                        }
                        if ((paramAnonymous3DialogInterface.GG != null) && (paramAnonymous3DialogInterface.indexOfChild(paramAnonymous3DialogInterface.GG) < 0)) {
                          paramAnonymous3DialogInterface.addView(paramAnonymous3DialogInterface.GG);
                        }
                      }
                    }
                    AppMethodBeat.o(195777);
                  }
                });
                ((d.a)localObject).fQv().show();
                break;
              }
            }
          };
          paramAnonymousView.cPF();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195779);
        }
      });
      this.uFQ = ((TabItemView)findViewById(2131305607));
      this.uFQ.setShowType(1);
      this.uFR = ((TabItemView)findViewById(2131305608));
      this.uFR.setShowType(2);
      this.uH = ((ViewPager)findViewById(2131302255));
      paramBundle = new a(getSupportFragmentManager());
      GameMsgCenterFragment localGameMsgCenterFragment = new GameMsgCenterFragment();
      this.uFS = new a(this, this.fromScene);
      this.uFS.setNewMessageCount(this.uFU);
      localGameMsgCenterFragment.contentView = this.uFS;
      paramBundle.a(localGameMsgCenterFragment);
      localGameMsgCenterFragment = new GameMsgCenterFragment();
      this.uFT = new b(this, this.fromScene);
      this.uFT.setNewMessageCount(this.uFV);
      localGameMsgCenterFragment.contentView = this.uFT;
      paramBundle.a(localGameMsgCenterFragment);
      this.uH.setAdapter(paramBundle);
      this.uFQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183871);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          GameMsgCenterUI.this.setCurrentItem(0);
          com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1303, 1, 2, GameMsgCenterUI.d(GameMsgCenterUI.this), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183871);
        }
      });
      this.uFR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183872);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          GameMsgCenterUI.this.setCurrentItem(1);
          com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1303, 2, 2, GameMsgCenterUI.d(GameMsgCenterUI.this), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183872);
        }
      });
      this.uH.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(183873);
          ae.i("MicroMsg.GameMsgCenterUI", "onPageSelected:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          GameMsgCenterUI.this.setCurrentItem(paramAnonymousInt);
          AppMethodBeat.o(183873);
        }
      });
      if (this.uFP != 2) {
        break label528;
      }
      this.uFQ.setUnreadCount(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().Io(1));
      setCurrentItem(1);
      AppMethodBeat.o(183878);
      return;
      bool = false;
      break;
      label474:
      if (i == 2)
      {
        this.uFP = 2;
        break label102;
      }
      paramBundle = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().amU(paramBundle);
      if (paramBundle == null) {
        break label102;
      }
      this.uFP = paramBundle.field_showType;
      break label102;
    }
    label528:
    this.uFR.setUnreadCount(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().Io(2));
    setCurrentItem(0);
    AppMethodBeat.o(183878);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(183879);
    super.onDestroy();
    Object localObject;
    if (this.uFS != null)
    {
      localObject = this.uFS;
      if (((a)localObject).uFN != null)
      {
        localObject = ((a)localObject).uFN.uGc.Tc;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    if (this.uFT != null)
    {
      localObject = this.uFT;
      if (((b)localObject).uGb != null)
      {
        localObject = ((b)localObject).uGb.uGp.Tc;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().dbR();
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
    this.uFW = (paramInt % 2);
    if (this.uFW == 0)
    {
      this.uFQ.setSelected(true);
      this.uFR.setSelected(false);
      this.uFS.resume();
    }
    for (;;)
    {
      this.uH.setCurrentItem(this.uFW);
      AppMethodBeat.o(183880);
      return;
      this.uFQ.setSelected(false);
      this.uFR.setSelected(true);
      this.uFT.resume();
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
    private List<GameMsgCenterUI.GameMsgCenterFragment> uGa;
    
    public a(android.support.v4.app.g paramg)
    {
      super();
      AppMethodBeat.i(183874);
      this.uGa = new ArrayList();
      AppMethodBeat.o(183874);
    }
    
    public final void a(GameMsgCenterUI.GameMsgCenterFragment paramGameMsgCenterFragment)
    {
      AppMethodBeat.i(183875);
      this.uGa.add(paramGameMsgCenterFragment);
      AppMethodBeat.o(183875);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(183877);
      int i = this.uGa.size();
      AppMethodBeat.o(183877);
      return i;
    }
    
    public final Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(183876);
      Object localObject = this.uGa;
      localObject = (Fragment)((List)localObject).get(paramInt % ((List)localObject).size());
      AppMethodBeat.o(183876);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI
 * JD-Core Version:    0.7.0.1
 */