package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.account.friend.a.ac;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private LinkedList<ams> fOc;
  private ProgressDialog fpP;
  private boolean imr;
  private b ink;
  private ListView inl;
  private TextView inm;
  private LinkedList<btd> inn;
  private boolean ino;
  private int recommendType;
  
  public RecommendFriendUI()
  {
    AppMethodBeat.i(131295);
    this.fpP = null;
    this.inn = new LinkedList();
    this.fOc = new LinkedList();
    this.recommendType = -1;
    this.ino = false;
    AppMethodBeat.o(131295);
  }
  
  private void aJv()
  {
    AppMethodBeat.i(131302);
    this.inm.setVisibility(0);
    this.inl.setVisibility(8);
    AppMethodBeat.o(131302);
  }
  
  private void aJw()
  {
    AppMethodBeat.i(131304);
    if (this.recommendType == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", bool);
      ad.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.fOc.size());
      this.ink.fOc = this.fOc;
      this.inl.setAdapter(this.ink);
      showOptionMenu(false);
      this.imr = true;
      setMMTitle(2131763248);
      this.ink.imr = this.imr;
      this.ink.notifyDataSetChanged();
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
    if ((this.imr) || (this.ino))
    {
      finish();
      AppMethodBeat.o(131298);
      return;
    }
    aJw();
    AppMethodBeat.o(131298);
  }
  
  private void qg(int paramInt)
  {
    AppMethodBeat.i(131303);
    ad.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.inn.size());
    this.ink.a(this.inn, paramInt);
    this.inl.setAdapter(this.ink);
    this.imr = false;
    String str;
    int i;
    if (this.recommendType == 0)
    {
      str = "";
      i = 0;
      if (i < this.fOc.size())
      {
        if (paramInt != ((ams)this.fOc.get(i)).Der) {
          break label153;
        }
        str = ((ams)this.fOc.get(i)).DnM;
      }
    }
    label153:
    for (;;)
    {
      i += 1;
      break;
      setMMTitle(str);
      this.ink.imr = this.imr;
      this.ink.notifyDataSetChanged();
      AppMethodBeat.o(131303);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494490;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131297);
    this.inm = ((TextView)findViewById(2131299475));
    if (this.recommendType == 1)
    {
      setMMTitle(2131763376);
      this.inm.setText(2131763380);
    }
    for (;;)
    {
      this.ink = new b(getLayoutInflater());
      this.inl = ((ListView)findViewById(2131301076));
      this.inl.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 0;
          AppMethodBeat.i(131288);
          if (!RecommendFriendUI.a(RecommendFriendUI.this))
          {
            RecommendFriendUI.b(RecommendFriendUI.this).qf(paramAnonymousInt);
            if (RecommendFriendUI.b(RecommendFriendUI.this).aJu().length > 0)
            {
              RecommendFriendUI.this.showOptionMenu(true);
              AppMethodBeat.o(131288);
              return;
            }
            RecommendFriendUI.this.showOptionMenu(false);
            AppMethodBeat.o(131288);
            return;
          }
          paramAnonymousAdapterView = RecommendFriendUI.this;
          paramAnonymousView = RecommendFriendUI.b(RecommendFriendUI.this);
          if (!paramAnonymousView.imr) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = ((ams)paramAnonymousView.fOc.get(paramAnonymousInt)).Der)
          {
            RecommendFriendUI.a(paramAnonymousAdapterView, paramAnonymousInt);
            AppMethodBeat.o(131288);
            return;
          }
        }
      });
      this.inl.setAdapter(this.ink);
      addTextOptionMenu(0, getString(2131760374), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(131290);
          int i = RecommendFriendUI.b(RecommendFriendUI.this).aJu().length;
          h.a(RecommendFriendUI.this.getContext(), RecommendFriendUI.this.getContext().getResources().getQuantityString(2131623954, i, new Object[] { Integer.valueOf(i) }), RecommendFriendUI.this.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      this.ino = true;
      final ac localac = new ac(this.recommendType);
      com.tencent.mm.kernel.g.aeS().a(localac, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.fpP = h.b(localAppCompatActivity, getString(2131760377), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131293);
          com.tencent.mm.kernel.g.aeS().a(localac);
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
          paramAnonymousView = RecommendFriendUI.e(RecommendFriendUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(131292);
        }
      });
      AppMethodBeat.o(131297);
      return;
      if (this.recommendType == 2)
      {
        setMMTitle(2131763375);
        this.inm.setText(2131763379);
      }
      else
      {
        setMMTitle(2131763248);
        this.inm.setText(2131763381);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131296);
    super.onCreate(paramBundle);
    this.recommendType = bt.getInt(getIntent().getStringExtra("recommend_type"), 0);
    this.imr = false;
    com.tencent.mm.kernel.g.aeS().a(135, this);
    initView();
    AppMethodBeat.o(131296);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131300);
    com.tencent.mm.kernel.g.aeS().b(135, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(131301);
    ad.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramn.getType() != 135))
    {
      aJv();
      AppMethodBeat.o(131301);
      return;
    }
    this.inn = ((bta)((ac)paramn).rr.gUT.gUX).sdt;
    this.fOc = ((bta)((ac)paramn).rr.gUT.gUX).GroupList;
    this.ino = false;
    if (this.inn.size() <= 0)
    {
      aJv();
      AppMethodBeat.o(131301);
      return;
    }
    if ((this.recommendType == 0) && (this.fOc.size() <= 0))
    {
      aJv();
      AppMethodBeat.o(131301);
      return;
    }
    if (this.recommendType != 0)
    {
      qg(-1);
      AppMethodBeat.o(131301);
      return;
    }
    aJw();
    AppMethodBeat.o(131301);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI
 * JD-Core Version:    0.7.0.1
 */