package com.tencent.mm.plugin.game.ui.message;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.protobuf.bj;
import com.tencent.mm.plugin.game.protobuf.cw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameMsgCenterUI
  extends MMActivity
{
  private int IWW = 0;
  private TextView IWX;
  private TabItemView IWY;
  private TabItemView IWZ;
  private a IXa;
  private b IXb;
  private int IXc;
  private int IXd;
  private int IXe = 0;
  private int fromScene;
  private CustomViewPager yak;
  
  public int getCustomBounceId()
  {
    return h.e.HWS;
  }
  
  public int getLayoutId()
  {
    return h.f.HZV;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(183878);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    boolean bool = bb.aAF(getResources().getColor(h.b.white));
    paramBundle = getContentView();
    int i = getResources().getColor(h.b.white);
    label104:
    GameMsgCenterFragment localGameMsgCenterFragment;
    if (!bool)
    {
      bool = true;
      com.tencent.mm.ui.statusbar.a.h(paramBundle, i, bool);
      this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
      paramBundle = getIntent().getStringExtra("game_msg_ui_from_msgid");
      i = getIntent().getIntExtra("game_msg_center_tab_type", 0);
      if (i != 1) {
        break label575;
      }
      this.IWW = 1;
      if (this.IWW == 0)
      {
        this.IXc = ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XD(1);
        this.IXd = ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XD(2);
        if ((this.IXc > 0) || (this.IXd <= 0)) {
          break label621;
        }
        this.IWW = 2;
      }
      label172:
      findViewById(h.e.actionbar_back).setOnClickListener(new GameMsgCenterUI.1(this));
      findViewById(h.e.actionbar_option_btn).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(276786);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new com.tencent.mm.ui.widget.a.f(GameMsgCenterUI.this.getContext(), 1, false);
          paramAnonymousView.Vtg = new u.g()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
            {
              AppMethodBeat.i(276778);
              if (GameMsgCenterUI.a(GameMsgCenterUI.this) == 0)
              {
                paramAnonymous2s.oh(0, h.i.IaE);
                AppMethodBeat.o(276778);
                return;
              }
              paramAnonymous2s.oh(1, h.i.IbG);
              paramAnonymous2s.oh(2, h.i.IaG);
              AppMethodBeat.o(276778);
            }
          };
          paramAnonymousView.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(276779);
              Log.i("MicroMsg.GameMsgCenterUI", "bottomSheet itemId:%d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
              Object localObject = new e.a(GameMsgCenterUI.this.getContext());
              ((e.a)localObject).NC(false);
              ((e.a)localObject).aES(h.i.app_cancel).d(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int) {}
              });
              final HashMap localHashMap = new HashMap();
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                AppMethodBeat.o(276779);
                return;
              case 0: 
                ((e.a)localObject).aEO(h.i.IaF);
                ((e.a)localObject).aER(h.i.app_clear).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(276796);
                    ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XE(1);
                    if (GameMsgCenterUI.c(GameMsgCenterUI.this) != null) {
                      GameMsgCenterUI.c(GameMsgCenterUI.this).refreshView();
                    }
                    localHashMap.put("tab", "1");
                    localHashMap.put("actionstatus", "2");
                    com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.s(localHashMap));
                    AppMethodBeat.o(276796);
                  }
                }).e(new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(276799);
                    localHashMap.put("tab", "1");
                    localHashMap.put("actionstatus", "1");
                    com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.s(localHashMap));
                    AppMethodBeat.o(276799);
                  }
                });
                ((e.a)localObject).jHH().show();
                localHashMap.put("tab", "1");
                localHashMap.put("actionstatus", "2");
                com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 1, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.s(localHashMap));
                AppMethodBeat.o(276779);
                return;
              case 1: 
                paramAnonymous2MenuItem = com.tencent.mm.plugin.game.commlib.a.fDZ();
                if ((paramAnonymous2MenuItem != null) && (!Util.isNullOrNil(paramAnonymous2MenuItem.IIU)))
                {
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.IIU.iterator();
                  do
                  {
                    if (!paramAnonymous2MenuItem.hasNext()) {
                      break;
                    }
                    localObject = (cw)paramAnonymous2MenuItem.next();
                  } while ((((cw)localObject).IKW != 1) || (Util.isNullOrNil(((cw)localObject).IGI)));
                }
                break;
              }
              for (paramAnonymous2MenuItem = ((cw)localObject).IGI;; paramAnonymous2MenuItem = "https://game.weixin.qq.com/cgi-bin/h5/static/gamecenter/subscription_list.html?wechat_pkgid=gamecenter_subscription_list&ssid=5")
              {
                c.ba(GameMsgCenterUI.this.getContext(), paramAnonymous2MenuItem);
                localHashMap.put("tab", "2");
                localHashMap.put("actionstatus", "1");
                com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 1, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.s(localHashMap));
                AppMethodBeat.o(276779);
                return;
                ((e.a)localObject).aEO(h.i.IaH);
                ((e.a)localObject).aER(h.i.app_clear).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(276795);
                    ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XE(2);
                    if (GameMsgCenterUI.d(GameMsgCenterUI.this) != null) {
                      GameMsgCenterUI.d(GameMsgCenterUI.this).refreshView();
                    }
                    localHashMap.put("tab", "2");
                    localHashMap.put("actionstatus", "2");
                    com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.s(localHashMap));
                    AppMethodBeat.o(276795);
                  }
                }).e(new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(276801);
                    localHashMap.put("tab", "2");
                    localHashMap.put("actionstatus", "1");
                    com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.s(localHashMap));
                    AppMethodBeat.o(276801);
                  }
                });
                ((e.a)localObject).jHH().show();
                localHashMap.put("tab", "2");
                localHashMap.put("actionstatus", "2");
                com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 1, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.s(localHashMap));
                break;
              }
            }
          };
          paramAnonymousView.dDn();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276786);
        }
      });
      this.IWX = ((TextView)findViewById(h.e.actionbar_title));
      com.tencent.mm.ui.a.v(this.IWX, h.c.BodyTextSize);
      paramBundle = findViewById(h.e.HTw);
      this.IWX.setVisibility(0);
      paramBundle.setVisibility(8);
      if (this.IWW != 2) {
        break label629;
      }
      this.IWX.setText(h.i.Ibr);
      label272:
      this.IWY = ((TabItemView)findViewById(h.e.HXU));
      this.IWY.setShowType(1);
      this.IWZ = ((TabItemView)findViewById(h.e.HXV));
      this.IWZ.setShowType(2);
      this.yak = ((CustomViewPager)findViewById(h.e.HWS));
      paramBundle = new a(getSupportFragmentManager());
      localGameMsgCenterFragment = new GameMsgCenterFragment();
      if (this.IWW != 1) {
        break label642;
      }
      bool = true;
      label361:
      this.IXa = new a(this, this.fromScene, bool);
      this.IXa.setNewMessageCount(this.IXc);
      localGameMsgCenterFragment.contentView = this.IXa;
      paramBundle.a(localGameMsgCenterFragment);
      localGameMsgCenterFragment = new GameMsgCenterFragment();
      if (this.IWW != 2) {
        break label647;
      }
    }
    label642:
    label647:
    for (bool = true;; bool = false)
    {
      this.IXb = new b(this, this.fromScene, bool);
      this.IXb.setNewMessageCount(this.IXd);
      localGameMsgCenterFragment.contentView = this.IXb;
      paramBundle.a(localGameMsgCenterFragment);
      this.yak.setCanSlide(false);
      this.yak.setAdapter(paramBundle);
      this.IWY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183871);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          GameMsgCenterUI.this.setCurrentItem(0);
          com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1303, 1, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183871);
        }
      });
      this.IWZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183872);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          GameMsgCenterUI.this.setCurrentItem(1);
          com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1303, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183872);
        }
      });
      this.yak.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
      if (this.IWW != 2) {
        break label652;
      }
      this.IWY.setUnreadCount(((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XD(1));
      setCurrentItem(1);
      AppMethodBeat.o(183878);
      return;
      bool = false;
      break;
      label575:
      if (i == 2)
      {
        this.IWW = 2;
        break label104;
      }
      paramBundle = ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().aGL(paramBundle);
      if (paramBundle == null) {
        break label104;
      }
      this.IWW = paramBundle.field_showType;
      break label104;
      label621:
      this.IWW = 1;
      break label172;
      label629:
      this.IWX.setText(h.i.Ibq);
      break label272;
      bool = false;
      break label361;
    }
    label652:
    this.IWZ.setUnreadCount(((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XD(2));
    setCurrentItem(0);
    AppMethodBeat.o(183878);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(183879);
    super.onDestroy();
    Object localObject;
    if (this.IXa != null)
    {
      localObject = this.IXa;
      if (((a)localObject).IWS != null)
      {
        localObject = ((a)localObject).IWS.IXl.gw;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    if (this.IXb != null)
    {
      localObject = this.IXb;
      if (((b)localObject).IXj != null)
      {
        localObject = ((b)localObject).IXj.IXz.gw;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().fGC();
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
    this.IXe = (paramInt % 2);
    if (this.IXe == 0)
    {
      this.IWY.setSelected(true);
      this.IWZ.setSelected(false);
      if (this.IXa != null) {
        this.IXa.resume();
      }
    }
    for (;;)
    {
      this.yak.setCurrentItem(this.IXe);
      AppMethodBeat.o(183880);
      return;
      this.IWY.setSelected(false);
      this.IWZ.setSelected(true);
      if (this.IXb != null) {
        this.IXb.resume();
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
  
  static final class a
    extends m
  {
    private List<GameMsgCenterUI.GameMsgCenterFragment> Ijz;
    
    public a(FragmentManager paramFragmentManager)
    {
      super();
      AppMethodBeat.i(276766);
      this.Ijz = new ArrayList();
      AppMethodBeat.o(276766);
    }
    
    public final void a(GameMsgCenterUI.GameMsgCenterFragment paramGameMsgCenterFragment)
    {
      AppMethodBeat.i(183875);
      this.Ijz.add(paramGameMsgCenterFragment);
      AppMethodBeat.o(183875);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(183877);
      int i = this.Ijz.size();
      AppMethodBeat.o(183877);
      return i;
    }
    
    public final Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(276772);
      Object localObject = this.Ijz;
      localObject = (Fragment)((List)localObject).get(paramInt % ((List)localObject).size());
      AppMethodBeat.o(276772);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI
 * JD-Core Version:    0.7.0.1
 */