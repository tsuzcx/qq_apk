package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.ac;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.protocal.protobuf.dck;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI
  extends MMActivity
  implements i
{
  private ProgressDialog iXX;
  private LinkedList<bmp> jJE;
  private b mYT;
  private ListView mYU;
  private TextView mYV;
  private LinkedList<dck> mYW;
  private boolean mYX;
  private boolean mYb;
  private int recommendType;
  
  public RecommendFriendUI()
  {
    AppMethodBeat.i(131295);
    this.iXX = null;
    this.mYW = new LinkedList();
    this.jJE = new LinkedList();
    this.recommendType = -1;
    this.mYX = false;
    AppMethodBeat.o(131295);
  }
  
  private void byS()
  {
    AppMethodBeat.i(131302);
    this.mYV.setVisibility(0);
    this.mYU.setVisibility(8);
    AppMethodBeat.o(131302);
  }
  
  private void byT()
  {
    AppMethodBeat.i(131304);
    if (this.recommendType == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", bool);
      Log.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.jJE.size());
      this.mYT.jJE = this.jJE;
      this.mYU.setAdapter(this.mYT);
      showOptionMenu(false);
      this.mYb = true;
      setMMTitle(a.g.settings_invite_qq_friends);
      this.mYT.mYb = this.mYb;
      this.mYT.notifyDataSetChanged();
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
    if ((this.mYb) || (this.mYX))
    {
      finish();
      AppMethodBeat.o(131298);
      return;
    }
    byT();
    AppMethodBeat.o(131298);
  }
  
  private void yq(int paramInt)
  {
    AppMethodBeat.i(131303);
    Log.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.mYW.size());
    this.mYT.a(this.mYW, paramInt);
    this.mYU.setAdapter(this.mYT);
    this.mYb = false;
    String str;
    int i;
    if (this.recommendType == 0)
    {
      str = "";
      i = 0;
      if (i < this.jJE.size())
      {
        if (paramInt != ((bmp)this.jJE.get(i)).SvP) {
          break label156;
        }
        str = ((bmp)this.jJE.get(i)).SXx;
      }
    }
    label156:
    for (;;)
    {
      i += 1;
      break;
      setMMTitle(str);
      this.mYT.mYb = this.mYb;
      this.mYT.notifyDataSetChanged();
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
    this.mYV = ((TextView)findViewById(a.c.empty_tip_tv));
    if (this.recommendType == 1)
    {
      setMMTitle(a.g.settings_recommend_by_mb);
      this.mYV.setText(a.g.settings_recommend_no_mb_contact);
    }
    for (;;)
    {
      this.mYT = new b(getLayoutInflater());
      this.mYU = ((ListView)findViewById(a.c.inviteqqfriends_friend_lv));
      this.mYU.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(131288);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          a.c("com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          if (!RecommendFriendUI.a(RecommendFriendUI.this))
          {
            RecommendFriendUI.b(RecommendFriendUI.this).yp(paramAnonymousInt);
            if (RecommendFriendUI.b(RecommendFriendUI.this).byR().length > 0) {
              RecommendFriendUI.this.showOptionMenu(true);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(131288);
              return;
              RecommendFriendUI.this.showOptionMenu(false);
            }
          }
          paramAnonymousAdapterView = RecommendFriendUI.this;
          paramAnonymousView = RecommendFriendUI.b(RecommendFriendUI.this);
          if (!paramAnonymousView.mYb) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = ((bmp)paramAnonymousView.jJE.get(paramAnonymousInt)).SvP)
          {
            RecommendFriendUI.a(paramAnonymousAdapterView, paramAnonymousInt);
            break;
          }
        }
      });
      this.mYU.setAdapter(this.mYT);
      addTextOptionMenu(0, getString(a.g.inviteqqfriends_invite), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(131290);
          int i = RecommendFriendUI.b(RecommendFriendUI.this).byR().length;
          com.tencent.mm.ui.base.h.a(RecommendFriendUI.this.getContext(), RecommendFriendUI.this.getContext().getResources().getQuantityString(a.e.inviteqqfriends_invite_tips, i, new Object[] { Integer.valueOf(i) }), RecommendFriendUI.this.getString(a.g.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      this.mYX = true;
      final ac localac = new ac(this.recommendType);
      com.tencent.mm.kernel.h.aGY().a(localac, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(a.g.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(a.g.inviteqqfriends_loading_friends_info), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131293);
          com.tencent.mm.kernel.h.aGY().a(localac);
          RecommendFriendUI.this.finish();
          AppMethodBeat.o(131293);
        }
      });
      setBackBtn(new RecommendFriendUI.3(this));
      setToTop(new RecommendFriendUI.4(this));
      AppMethodBeat.o(131297);
      return;
      if (this.recommendType == 2)
      {
        setMMTitle(a.g.settings_recommend_by_mail);
        this.mYV.setText(a.g.settings_recommend_no_mail_contact);
      }
      else
      {
        setMMTitle(a.g.settings_invite_qq_friends);
        this.mYV.setText(a.g.settings_recommend_no_qq_contact);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131296);
    super.onCreate(paramBundle);
    this.recommendType = Util.getInt(getIntent().getStringExtra("recommend_type"), 0);
    this.mYb = false;
    com.tencent.mm.kernel.h.aGY().a(135, this);
    initView();
    AppMethodBeat.o(131296);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131300);
    com.tencent.mm.kernel.h.aGY().b(135, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(131301);
    Log.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramq.getType() != 135))
    {
      byS();
      AppMethodBeat.o(131301);
      return;
    }
    this.mYW = ((dch)d.c.b(((ac)paramq).rr.lBS)).CRe;
    this.jJE = ((dch)d.c.b(((ac)paramq).rr.lBS)).GroupList;
    this.mYX = false;
    if (this.mYW.size() <= 0)
    {
      byS();
      AppMethodBeat.o(131301);
      return;
    }
    if ((this.recommendType == 0) && (this.jJE.size() <= 0))
    {
      byS();
      AppMethodBeat.o(131301);
      return;
    }
    if (this.recommendType != 0)
    {
      yq(-1);
      AppMethodBeat.o(131301);
      return;
    }
    byT();
    AppMethodBeat.o(131301);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI
 * JD-Core Version:    0.7.0.1
 */