package com.tencent.mm.plugin.game.ui.message;

import android.app.Activity;
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
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.protobuf.bi;
import com.tencent.mm.plugin.game.protobuf.cu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameMsgCenterUI
  extends MMActivity
{
  private int DcC = 0;
  private TextView DcD;
  private TabItemView DcE;
  private TabItemView DcF;
  private CustomViewPager DcG;
  private a DcH;
  private b DcI;
  private int DcJ;
  private int DcK;
  private int DcL = 0;
  private int fromScene;
  
  public int getCustomBounceId()
  {
    return g.e.CkK;
  }
  
  public int getLayoutId()
  {
    return g.f.CnN;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(183878);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    boolean bool = au.auk(getResources().getColor(g.b.white));
    paramBundle = getContentView();
    int i = getResources().getColor(g.b.white);
    label104:
    GameMsgCenterFragment localGameMsgCenterFragment;
    if (!bool)
    {
      bool = true;
      com.tencent.mm.ui.statusbar.a.f(paramBundle, i, bool);
      this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
      paramBundle = getIntent().getStringExtra("game_msg_ui_from_msgid");
      i = getIntent().getIntExtra("game_msg_center_tab_type", 0);
      if (i != 1) {
        break label565;
      }
      this.DcC = 1;
      if (this.DcC == 0)
      {
        this.DcJ = ((f)h.ae(f.class)).evo().TJ(1);
        this.DcK = ((f)h.ae(f.class)).evo().TJ(2);
        if ((this.DcJ > 0) || (this.DcK <= 0)) {
          break label611;
        }
        this.DcC = 2;
      }
      label172:
      findViewById(g.e.actionbar_back).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183870);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          GameMsgCenterUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183870);
        }
      });
      findViewById(g.e.actionbar_option_btn).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(204851);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new com.tencent.mm.ui.widget.a.e(GameMsgCenterUI.this.getContext(), 1, false);
          paramAnonymousView.ODT = new q.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
            {
              AppMethodBeat.i(191717);
              if (GameMsgCenterUI.a(GameMsgCenterUI.this) == 0)
              {
                paramAnonymous2o.mn(0, g.i.Cow);
                AppMethodBeat.o(191717);
                return;
              }
              paramAnonymous2o.mn(1, g.i.Cpy);
              paramAnonymous2o.mn(2, g.i.Coy);
              AppMethodBeat.o(191717);
            }
          };
          paramAnonymousView.ODU = new q.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(194254);
              Log.i("MicroMsg.GameMsgCenterUI", "bottomSheet itemId:%d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
              Object localObject = new d.a(GameMsgCenterUI.this.getContext());
              ((d.a)localObject).HG(false);
              ((d.a)localObject).ayk(g.i.app_cancel).d(new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int) {}
              });
              final HashMap localHashMap = new HashMap();
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                AppMethodBeat.o(194254);
                return;
              case 0: 
                ((d.a)localObject).ayg(g.i.Cox);
                ((d.a)localObject).ayj(g.i.app_clear).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(190946);
                    ((f)h.ae(f.class)).evo().TK(1);
                    if (GameMsgCenterUI.c(GameMsgCenterUI.this) != null) {
                      GameMsgCenterUI.c(GameMsgCenterUI.this).refreshView();
                    }
                    localHashMap.put("tab", "1");
                    localHashMap.put("actionstatus", "2");
                    com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.l(localHashMap));
                    AppMethodBeat.o(190946);
                  }
                }).f(new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(191935);
                    localHashMap.put("tab", "1");
                    localHashMap.put("actionstatus", "1");
                    com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.l(localHashMap));
                    AppMethodBeat.o(191935);
                  }
                });
                ((d.a)localObject).icu().show();
                localHashMap.put("tab", "1");
                localHashMap.put("actionstatus", "2");
                com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 1, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.l(localHashMap));
                AppMethodBeat.o(194254);
                return;
              case 1: 
                paramAnonymous2MenuItem = com.tencent.mm.plugin.game.commlib.a.ewk();
                if ((paramAnonymous2MenuItem != null) && (!Util.isNullOrNil(paramAnonymous2MenuItem.COK)))
                {
                  paramAnonymous2MenuItem = paramAnonymous2MenuItem.COK.iterator();
                  do
                  {
                    if (!paramAnonymous2MenuItem.hasNext()) {
                      break;
                    }
                    localObject = (cu)paramAnonymous2MenuItem.next();
                  } while ((((cu)localObject).CQK != 1) || (Util.isNullOrNil(((cu)localObject).CMD)));
                }
                break;
              }
              for (paramAnonymous2MenuItem = ((cu)localObject).CMD;; paramAnonymous2MenuItem = "https://game.weixin.qq.com/cgi-bin/h5/static/gamecenter/subscription_list.html?wechat_pkgid=gamecenter_subscription_list&ssid=5")
              {
                c.aY(GameMsgCenterUI.this.getContext(), paramAnonymous2MenuItem);
                localHashMap.put("tab", "2");
                localHashMap.put("actionstatus", "1");
                com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 1, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.l(localHashMap));
                AppMethodBeat.o(194254);
                return;
                ((d.a)localObject).ayg(g.i.Coz);
                ((d.a)localObject).ayj(g.i.app_clear).c(new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(199702);
                    ((f)h.ae(f.class)).evo().TK(2);
                    if (GameMsgCenterUI.d(GameMsgCenterUI.this) != null) {
                      GameMsgCenterUI.d(GameMsgCenterUI.this).refreshView();
                    }
                    localHashMap.put("tab", "2");
                    localHashMap.put("actionstatus", "2");
                    com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.l(localHashMap));
                    AppMethodBeat.o(199702);
                  }
                }).f(new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(206291);
                    localHashMap.put("tab", "2");
                    localHashMap.put("actionstatus", "1");
                    com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.l(localHashMap));
                    AppMethodBeat.o(206291);
                  }
                });
                ((d.a)localObject).icu().show();
                localHashMap.put("tab", "2");
                localHashMap.put("actionstatus", "2");
                com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1306, 1, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), com.tencent.mm.game.report.g.l(localHashMap));
                break;
              }
            }
          };
          paramAnonymousView.eik();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(204851);
        }
      });
      this.DcD = ((TextView)findViewById(g.e.actionbar_title));
      paramBundle = findViewById(g.e.Chn);
      this.DcD.setVisibility(0);
      paramBundle.setVisibility(8);
      if (this.DcC != 2) {
        break label619;
      }
      this.DcD.setText(g.i.Cpj);
      label262:
      this.DcE = ((TabItemView)findViewById(g.e.ClM));
      this.DcE.setShowType(1);
      this.DcF = ((TabItemView)findViewById(g.e.ClN));
      this.DcF.setShowType(2);
      this.DcG = ((CustomViewPager)findViewById(g.e.CkK));
      paramBundle = new a(getSupportFragmentManager());
      localGameMsgCenterFragment = new GameMsgCenterFragment();
      if (this.DcC != 1) {
        break label632;
      }
      bool = true;
      label351:
      this.DcH = new a(this, this.fromScene, bool);
      this.DcH.setNewMessageCount(this.DcJ);
      localGameMsgCenterFragment.contentView = this.DcH;
      paramBundle.a(localGameMsgCenterFragment);
      localGameMsgCenterFragment = new GameMsgCenterFragment();
      if (this.DcC != 2) {
        break label637;
      }
    }
    label565:
    label611:
    label619:
    label632:
    label637:
    for (bool = true;; bool = false)
    {
      this.DcI = new b(this, this.fromScene, bool);
      this.DcI.setNewMessageCount(this.DcK);
      localGameMsgCenterFragment.contentView = this.DcI;
      paramBundle.a(localGameMsgCenterFragment);
      this.DcG.setCanSlide(false);
      this.DcG.setAdapter(paramBundle);
      this.DcE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183871);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          GameMsgCenterUI.this.setCurrentItem(0);
          com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1303, 1, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183871);
        }
      });
      this.DcF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(183872);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          GameMsgCenterUI.this.setCurrentItem(1);
          com.tencent.mm.game.report.g.a(GameMsgCenterUI.this.getContext(), 13, 1303, 2, 2, GameMsgCenterUI.b(GameMsgCenterUI.this), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183872);
        }
      });
      this.DcG.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
      if (this.DcC != 2) {
        break label642;
      }
      this.DcE.setUnreadCount(((f)h.ae(f.class)).evo().TJ(1));
      setCurrentItem(1);
      AppMethodBeat.o(183878);
      return;
      bool = false;
      break;
      if (i == 2)
      {
        this.DcC = 2;
        break label104;
      }
      paramBundle = ((f)h.ae(f.class)).evo().aJW(paramBundle);
      if (paramBundle == null) {
        break label104;
      }
      this.DcC = paramBundle.field_showType;
      break label104;
      this.DcC = 1;
      break label172;
      this.DcD.setText(g.i.Cpi);
      break label262;
      bool = false;
      break label351;
    }
    label642:
    this.DcF.setUnreadCount(((f)h.ae(f.class)).evo().TJ(2));
    setCurrentItem(0);
    AppMethodBeat.o(183878);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(183879);
    super.onDestroy();
    Object localObject;
    if (this.DcH != null)
    {
      localObject = this.DcH;
      if (((a)localObject).Dcy != null)
      {
        localObject = ((a)localObject).Dcy.DcT.fB;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    if (this.DcI != null)
    {
      localObject = this.DcI;
      if (((b)localObject).DcR != null)
      {
        localObject = ((b)localObject).DcR.Ddh.fB;
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    ((f)h.ae(f.class)).evo().eyG();
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
    this.DcL = (paramInt % 2);
    if (this.DcL == 0)
    {
      this.DcE.setSelected(true);
      this.DcF.setSelected(false);
      if (this.DcH != null) {
        this.DcH.resume();
      }
    }
    for (;;)
    {
      this.DcG.setCurrentItem(this.DcL);
      AppMethodBeat.o(183880);
      return;
      this.DcE.setSelected(false);
      this.DcF.setSelected(true);
      if (this.DcI != null) {
        this.DcI.resume();
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
    extends androidx.fragment.app.g
  {
    private List<GameMsgCenterUI.GameMsgCenterFragment> DcQ;
    
    public a(androidx.fragment.app.e parame)
    {
      super();
      AppMethodBeat.i(201664);
      this.DcQ = new ArrayList();
      AppMethodBeat.o(201664);
    }
    
    public final void a(GameMsgCenterUI.GameMsgCenterFragment paramGameMsgCenterFragment)
    {
      AppMethodBeat.i(183875);
      this.DcQ.add(paramGameMsgCenterFragment);
      AppMethodBeat.o(183875);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(183877);
      int i = this.DcQ.size();
      AppMethodBeat.o(183877);
      return i;
    }
    
    public final Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(201668);
      Object localObject = this.DcQ;
      localObject = (Fragment)((List)localObject).get(paramInt % ((List)localObject).size());
      AppMethodBeat.o(201668);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI
 * JD-Core Version:    0.7.0.1
 */