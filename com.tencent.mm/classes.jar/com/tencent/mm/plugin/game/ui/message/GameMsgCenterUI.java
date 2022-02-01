package com.tencent.mm.plugin.game.ui.message;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.protobuf.bh;
import com.tencent.mm.plugin.game.protobuf.ct;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GameMsgCenterUI
  extends MMActivity
{
  private int fromScene;
  private int xXW = 0;
  private TextView xXX;
  private TabItemView xXY;
  private TabItemView xXZ;
  private CustomViewPager xYa;
  private a xYb;
  private b xYc;
  private int xYd;
  private int xYe;
  private int xYf = 0;
  
  public int getLayoutId()
  {
    return 2131494917;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(183878);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    boolean bool = ar.aln(getResources().getColor(2131101424));
    paramBundle = getContentView();
    int i = getResources().getColor(2131101424);
    label102:
    label255:
    GameMsgCenterFragment localGameMsgCenterFragment;
    if (!bool)
    {
      bool = true;
      com.tencent.mm.ui.statusbar.a.e(paramBundle, i, bool);
      this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
      paramBundle = getIntent().getStringExtra("game_msg_ui_from_msgid");
      i = getIntent().getIntExtra("game_msg_center_tab_type", 0);
      if (i != 1) {
        break label555;
      }
      this.xXW = 1;
      if (this.xXW == 0)
      {
        this.xYd = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Op(1);
        this.xYe = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Op(2);
        if ((this.xYd > 0) || (this.xYe <= 0)) {
          break label601;
        }
        this.xXW = 2;
      }
      label170:
      findViewById(2131296421).setOnClickListener(new GameMsgCenterUI.1(this));
      findViewById(2131296439).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(204315);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new com.tencent.mm.ui.widget.a.e(GameMsgCenterUI.this.getContext(), 1, false);
          paramAnonymousView.HLX = new o.f()
          {
            public final void onCreateMMMenu(m paramAnonymous2m)
            {
              AppMethodBeat.i(204309);
              if (GameMsgCenterUI.a(GameMsgCenterUI.this) == 0)
              {
                paramAnonymous2m.kV(0, 2131761170);
                AppMethodBeat.o(204309);
                return;
              }
              paramAnonymous2m.kV(1, 2131761318);
              paramAnonymous2m.kV(2, 2131761172);
              AppMethodBeat.o(204309);
            }
          };
          paramAnonymousView.HLY = new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(204314);
              Log.i("MicroMsg.GameMsgCenterUI", "bottomSheet itemId:%d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
              Object localObject = new d.a(GameMsgCenterUI.this.getContext());
              ((d.a)localObject).Dk(false);
              ((d.a)localObject).aoW(2131755761).d(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int) {}
              });
              final HashMap localHashMap = new HashMap();
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                AppMethodBeat.o(204314);
                return;
              case 0: 
                ((d.a)localObject).aoS(2131761171);
                ((d.a)localObject).aoV(2131755764).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(204311);
                    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Oq(1);
                    if (GameMsgCenterUI.c(GameMsgCenterUI.this) != null) {
                      GameMsgCenterUI.c(GameMsgCenterUI.this).refreshView();
                    }
                    localHashMap.put("tab", "1");
                    localHashMap.put("actionstatus", "2");
                    com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.f.t(localHashMap));
                    AppMethodBeat.o(204311);
                  }
                }).f(new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(204310);
                    localHashMap.put("tab", "1");
                    localHashMap.put("actionstatus", "1");
                    com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.f.t(localHashMap));
                    AppMethodBeat.o(204310);
                  }
                });
                ((d.a)localObject).hbn().show();
                localHashMap.put("tab", "1");
                localHashMap.put("actionstatus", "2");
                com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 1, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.f.t(localHashMap));
                AppMethodBeat.o(204314);
                return;
              case 1: 
                paramAnonymous2MenuItem = com.tencent.mm.plugin.game.commlib.a.dTb();
                if ((paramAnonymous2MenuItem != null) && (!Util.isNullOrNil(paramAnonymous2MenuItem.xKD)))
                {
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.xKD.iterator();
                  do
                  {
                    if (!paramAnonymous2MenuItem.hasNext()) {
                      break;
                    }
                    localObject = (ct)paramAnonymous2MenuItem.next();
                  } while ((((ct)localObject).xMB != 1) || (Util.isNullOrNil(((ct)localObject).xIy)));
                }
                break;
              }
              for (paramAnonymous2MenuItem = ((ct)localObject).xIy;; paramAnonymous2MenuItem = "https://game.weixin.qq.com/cgi-bin/h5/static/gamecenter/subscription_list.html?wechat_pkgid=gamecenter_subscription_list&ssid=5")
              {
                c.aQ(GameMsgCenterUI.this.getContext(), paramAnonymous2MenuItem);
                localHashMap.put("tab", "2");
                localHashMap.put("actionstatus", "1");
                com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 1, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.f.t(localHashMap));
                AppMethodBeat.o(204314);
                return;
                ((d.a)localObject).aoS(2131761173);
                ((d.a)localObject).aoV(2131755764).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(204313);
                    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Oq(2);
                    if (GameMsgCenterUI.d(GameMsgCenterUI.this) != null) {
                      GameMsgCenterUI.d(GameMsgCenterUI.this).refreshView();
                    }
                    localHashMap.put("tab", "2");
                    localHashMap.put("actionstatus", "2");
                    com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.f.t(localHashMap));
                    AppMethodBeat.o(204313);
                  }
                }).f(new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(204312);
                    localHashMap.put("tab", "2");
                    localHashMap.put("actionstatus", "1");
                    com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.f.t(localHashMap));
                    AppMethodBeat.o(204312);
                  }
                });
                ((d.a)localObject).hbn().show();
                localHashMap.put("tab", "2");
                localHashMap.put("actionstatus", "2");
                com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1306, 1, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.f.t(localHashMap));
                break;
              }
            }
          };
          paramAnonymousView.dGm();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(204315);
        }
      });
      this.xXX = ((TextView)findViewById(2131296443));
      paramBundle = findViewById(2131296442);
      this.xXX.setVisibility(0);
      paramBundle.setVisibility(8);
      if (this.xXW != 2) {
        break label609;
      }
      this.xXX.setText(2131761292);
      this.xXY = ((TabItemView)findViewById(2131308847));
      this.xXY.setShowType(1);
      this.xXZ = ((TabItemView)findViewById(2131308848));
      this.xXZ.setShowType(2);
      this.xYa = ((CustomViewPager)findViewById(2131304641));
      paramBundle = new GameMsgCenterUI.a(getSupportFragmentManager());
      localGameMsgCenterFragment = new GameMsgCenterFragment();
      if (this.xXW != 1) {
        break label622;
      }
      bool = true;
      label341:
      this.xYb = new a(this, this.fromScene, bool);
      this.xYb.setNewMessageCount(this.xYd);
      localGameMsgCenterFragment.contentView = this.xYb;
      paramBundle.a(localGameMsgCenterFragment);
      localGameMsgCenterFragment = new GameMsgCenterFragment();
      if (this.xXW != 2) {
        break label627;
      }
    }
    label555:
    label601:
    label609:
    label622:
    label627:
    for (bool = true;; bool = false)
    {
      this.xYc = new b(this, this.fromScene, bool);
      this.xYc.setNewMessageCount(this.xYe);
      localGameMsgCenterFragment.contentView = this.xYc;
      paramBundle.a(localGameMsgCenterFragment);
      this.xYa.setCanSlide(false);
      this.xYa.setAdapter(paramBundle);
      this.xXY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183871);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          GameMsgCenterUI.this.setCurrentItem(0);
          com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1303, 1, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183871);
        }
      });
      this.xXZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183872);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          GameMsgCenterUI.this.setCurrentItem(1);
          com.tencent.mm.game.report.f.a(GameMsgCenterUI.this.getContext(), 13, 1303, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183872);
        }
      });
      this.xYa.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(183873);
          Log.i("MicroMsg.GameMsgCenterUI", "onPageSelected:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          GameMsgCenterUI.this.setCurrentItem(paramAnonymousInt);
          AppMethodBeat.o(183873);
        }
      });
      if (this.xXW != 2) {
        break label632;
      }
      this.xXY.setUnreadCount(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Op(1));
      setCurrentItem(1);
      AppMethodBeat.o(183878);
      return;
      bool = false;
      break;
      if (i == 2)
      {
        this.xXW = 2;
        break label102;
      }
      paramBundle = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().aAk(paramBundle);
      if (paramBundle == null) {
        break label102;
      }
      this.xXW = paramBundle.field_showType;
      break label102;
      this.xXW = 1;
      break label170;
      this.xXX.setText(2131761291);
      break label255;
      bool = false;
      break label341;
    }
    label632:
    this.xXZ.setUnreadCount(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Op(2));
    setCurrentItem(0);
    AppMethodBeat.o(183878);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(183879);
    super.onDestroy();
    Object localObject;
    if (this.xYb != null)
    {
      localObject = this.xYb;
      if (((a)localObject).xXS != null)
      {
        localObject = ((a)localObject).xXS.xYn.To;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    if (this.xYc != null)
    {
      localObject = this.xYc;
      if (((b)localObject).xYl != null)
      {
        localObject = ((b)localObject).xYl.xYB.To;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().dVy();
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
    this.xYf = (paramInt % 2);
    if (this.xYf == 0)
    {
      this.xXY.setSelected(true);
      this.xXZ.setSelected(false);
      if (this.xYb != null) {
        this.xYb.resume();
      }
    }
    for (;;)
    {
      this.xYa.setCurrentItem(this.xYf);
      AppMethodBeat.o(183880);
      return;
      this.xXY.setSelected(false);
      this.xXZ.setSelected(true);
      if (this.xYc != null) {
        this.xYc.resume();
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI
 * JD-Core Version:    0.7.0.1
 */