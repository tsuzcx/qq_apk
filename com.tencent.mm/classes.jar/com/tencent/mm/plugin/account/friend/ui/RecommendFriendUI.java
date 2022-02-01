package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.model.z;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.dtz;
import com.tencent.mm.protocal.protobuf.duc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private ProgressDialog lzP;
  private LinkedList<caj> miW;
  private boolean pUJ;
  private b pVB;
  private ListView pVC;
  private TextView pVD;
  private LinkedList<duc> pVE;
  private boolean pVF;
  private int recommendType;
  
  public RecommendFriendUI()
  {
    AppMethodBeat.i(131295);
    this.lzP = null;
    this.pVE = new LinkedList();
    this.miW = new LinkedList();
    this.recommendType = -1;
    this.pVF = false;
    AppMethodBeat.o(131295);
  }
  
  private void bXG()
  {
    AppMethodBeat.i(131302);
    this.pVD.setVisibility(0);
    this.pVC.setVisibility(8);
    AppMethodBeat.o(131302);
  }
  
  private void bXH()
  {
    AppMethodBeat.i(131304);
    if (this.recommendType == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", bool);
      Log.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.miW.size());
      this.pVB.miW = this.miW;
      this.pVC.setAdapter(this.pVB);
      showOptionMenu(false);
      this.pUJ = true;
      setMMTitle(a.g.settings_invite_qq_friends);
      this.pVB.pUJ = this.pUJ;
      this.pVB.notifyDataSetChanged();
      AppMethodBeat.o(131304);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(131298);
    if (this.recommendType != 0)
    {
      finish();
      AppMethodBeat.o(131298);
      return;
    }
    if ((this.pUJ) || (this.pVF))
    {
      finish();
      AppMethodBeat.o(131298);
      return;
    }
    bXH();
    AppMethodBeat.o(131298);
  }
  
  private void yw(int paramInt)
  {
    AppMethodBeat.i(131303);
    Log.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.pVE.size());
    this.pVB.a(this.pVE, paramInt);
    this.pVC.setAdapter(this.pVB);
    this.pUJ = false;
    String str;
    int i;
    if (this.recommendType == 0)
    {
      str = "";
      i = 0;
      if (i < this.miW.size())
      {
        if (paramInt != ((caj)this.miW.get(i)).ZvY) {
          break label156;
        }
        str = ((caj)this.miW.get(i)).aajr;
      }
    }
    label156:
    for (;;)
    {
      i += 1;
      break;
      setMMTitle(str);
      this.pVB.pUJ = this.pUJ;
      this.pVB.notifyDataSetChanged();
      AppMethodBeat.o(131303);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return a.d.inviteqqfriends;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131297);
    this.pVD = ((TextView)findViewById(a.c.empty_tip_tv));
    if (this.recommendType == 1)
    {
      setMMTitle(a.g.settings_recommend_by_mb);
      this.pVD.setText(a.g.settings_recommend_no_mb_contact);
    }
    for (;;)
    {
      this.pVB = new b(getLayoutInflater());
      this.pVC = ((ListView)findViewById(a.c.inviteqqfriends_friend_lv));
      this.pVC.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(131288);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          if (!RecommendFriendUI.a(RecommendFriendUI.this))
          {
            RecommendFriendUI.b(RecommendFriendUI.this).yv(paramAnonymousInt);
            if (RecommendFriendUI.b(RecommendFriendUI.this).bXF().length > 0) {
              RecommendFriendUI.this.showOptionMenu(true);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(131288);
              return;
              RecommendFriendUI.this.showOptionMenu(false);
            }
          }
          paramAnonymousAdapterView = RecommendFriendUI.this;
          paramAnonymousView = RecommendFriendUI.b(RecommendFriendUI.this);
          if (!paramAnonymousView.pUJ) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = ((caj)paramAnonymousView.miW.get(paramAnonymousInt)).ZvY)
          {
            RecommendFriendUI.a(paramAnonymousAdapterView, paramAnonymousInt);
            break;
          }
        }
      });
      this.pVC.setAdapter(this.pVB);
      addTextOptionMenu(0, getString(a.g.inviteqqfriends_invite), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(131290);
          int i = RecommendFriendUI.b(RecommendFriendUI.this).bXF().length;
          k.a(RecommendFriendUI.this.getContext(), RecommendFriendUI.this.getContext().getResources().getQuantityString(a.e.inviteqqfriends_invite_tips, i, new Object[] { Integer.valueOf(i) }), RecommendFriendUI.this.getString(a.g.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(131289);
              RecommendFriendUI.c(RecommendFriendUI.this);
              AppMethodBeat.o(131289);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(131290);
          return true;
        }
      });
      showOptionMenu(false);
      this.pVF = true;
      final z localz = new z(this.recommendType);
      com.tencent.mm.kernel.h.aZW().a(localz, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(a.g.app_tip);
      this.lzP = k.a(localAppCompatActivity, getString(a.g.inviteqqfriends_loading_friends_info), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131293);
          com.tencent.mm.kernel.h.aZW().a(localz);
          RecommendFriendUI.this.finish();
          AppMethodBeat.o(131293);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(131291);
          RecommendFriendUI.d(RecommendFriendUI.this);
          AppMethodBeat.o(131291);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131292);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = RecommendFriendUI.e(RecommendFriendUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131292);
        }
      });
      AppMethodBeat.o(131297);
      return;
      if (this.recommendType == 2)
      {
        setMMTitle(a.g.settings_recommend_by_mail);
        this.pVD.setText(a.g.settings_recommend_no_mail_contact);
      }
      else
      {
        setMMTitle(a.g.settings_invite_qq_friends);
        this.pVD.setText(a.g.settings_recommend_no_qq_contact);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131296);
    super.onCreate(paramBundle);
    this.recommendType = Util.getInt(getIntent().getStringExtra("recommend_type"), 0);
    this.pUJ = false;
    com.tencent.mm.kernel.h.aZW().a(135, this);
    initView();
    AppMethodBeat.o(131296);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131300);
    com.tencent.mm.kernel.h.aZW().b(135, this);
    super.onDestroy();
    AppMethodBeat.o(131300);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(131299);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(131299);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(131299);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(131301);
    Log.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramp.getType() != 135))
    {
      bXG();
      AppMethodBeat.o(131301);
      return;
    }
    this.pVE = ((dtz)c.c.b(((z)paramp).rr.otC)).ILu;
    this.miW = ((dtz)c.c.b(((z)paramp).rr.otC)).GroupList;
    this.pVF = false;
    if (this.pVE.size() <= 0)
    {
      bXG();
      AppMethodBeat.o(131301);
      return;
    }
    if ((this.recommendType == 0) && (this.miW.size() <= 0))
    {
      bXG();
      AppMethodBeat.o(131301);
      return;
    }
    if (this.recommendType != 0)
    {
      yw(-1);
      AppMethodBeat.o(131301);
      return;
    }
    bXH();
    AppMethodBeat.o(131301);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI
 * JD-Core Version:    0.7.0.1
 */