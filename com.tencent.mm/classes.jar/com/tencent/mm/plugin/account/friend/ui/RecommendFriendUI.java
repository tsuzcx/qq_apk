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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private LinkedList<apv> fRN;
  private ProgressDialog fts;
  private boolean iMx;
  private b iNq;
  private ListView iNr;
  private TextView iNs;
  private LinkedList<bxu> iNt;
  private boolean iNu;
  private int recommendType;
  
  public RecommendFriendUI()
  {
    AppMethodBeat.i(131295);
    this.fts = null;
    this.iNt = new LinkedList();
    this.fRN = new LinkedList();
    this.recommendType = -1;
    this.iNu = false;
    AppMethodBeat.o(131295);
  }
  
  private void aQm()
  {
    AppMethodBeat.i(131302);
    this.iNs.setVisibility(0);
    this.iNr.setVisibility(8);
    AppMethodBeat.o(131302);
  }
  
  private void aQn()
  {
    AppMethodBeat.i(131304);
    if (this.recommendType == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", bool);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.fRN.size());
      this.iNq.fRN = this.fRN;
      this.iNr.setAdapter(this.iNq);
      showOptionMenu(false);
      this.iMx = true;
      setMMTitle(2131763248);
      this.iNq.iMx = this.iMx;
      this.iNq.notifyDataSetChanged();
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
    if ((this.iMx) || (this.iNu))
    {
      finish();
      AppMethodBeat.o(131298);
      return;
    }
    aQn();
    AppMethodBeat.o(131298);
  }
  
  private void qT(int paramInt)
  {
    AppMethodBeat.i(131303);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.iNt.size());
    this.iNq.a(this.iNt, paramInt);
    this.iNr.setAdapter(this.iNq);
    this.iMx = false;
    String str;
    int i;
    if (this.recommendType == 0)
    {
      str = "";
      i = 0;
      if (i < this.fRN.size())
      {
        if (paramInt != ((apv)this.fRN.get(i)).Exx) {
          break label153;
        }
        str = ((apv)this.fRN.get(i)).EIM;
      }
    }
    label153:
    for (;;)
    {
      i += 1;
      break;
      setMMTitle(str);
      this.iNq.iMx = this.iMx;
      this.iNq.notifyDataSetChanged();
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
    this.iNs = ((TextView)findViewById(2131299475));
    if (this.recommendType == 1)
    {
      setMMTitle(2131763376);
      this.iNs.setText(2131763380);
    }
    for (;;)
    {
      this.iNq = new b(getLayoutInflater());
      this.iNr = ((ListView)findViewById(2131301076));
      this.iNr.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 0;
          AppMethodBeat.i(131288);
          if (!RecommendFriendUI.a(RecommendFriendUI.this))
          {
            RecommendFriendUI.b(RecommendFriendUI.this).qS(paramAnonymousInt);
            if (RecommendFriendUI.b(RecommendFriendUI.this).aQl().length > 0)
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
          if (!paramAnonymousView.iMx) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = ((apv)paramAnonymousView.fRN.get(paramAnonymousInt)).Exx)
          {
            RecommendFriendUI.a(paramAnonymousAdapterView, paramAnonymousInt);
            AppMethodBeat.o(131288);
            return;
          }
        }
      });
      this.iNr.setAdapter(this.iNq);
      addTextOptionMenu(0, getString(2131760374), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(131290);
          int i = RecommendFriendUI.b(RecommendFriendUI.this).aQl().length;
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
      this.iNu = true;
      final com.tencent.mm.plugin.account.friend.a.ac localac = new com.tencent.mm.plugin.account.friend.a.ac(this.recommendType);
      com.tencent.mm.kernel.g.agi().a(localac, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.fts = h.b(localAppCompatActivity, getString(2131760377), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131293);
          com.tencent.mm.kernel.g.agi().a(localac);
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
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(131292);
        }
      });
      AppMethodBeat.o(131297);
      return;
      if (this.recommendType == 2)
      {
        setMMTitle(2131763375);
        this.iNs.setText(2131763379);
      }
      else
      {
        setMMTitle(2131763248);
        this.iNs.setText(2131763381);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131296);
    super.onCreate(paramBundle);
    this.recommendType = bs.getInt(getIntent().getStringExtra("recommend_type"), 0);
    this.iMx = false;
    com.tencent.mm.kernel.g.agi().a(135, this);
    initView();
    AppMethodBeat.o(131296);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131300);
    com.tencent.mm.kernel.g.agi().b(135, this);
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramn.getType() != 135))
    {
      aQm();
      AppMethodBeat.o(131301);
      return;
    }
    this.iNt = ((bxr)((com.tencent.mm.plugin.account.friend.a.ac)paramn).rr.hvs.hvw).tln;
    this.fRN = ((bxr)((com.tencent.mm.plugin.account.friend.a.ac)paramn).rr.hvs.hvw).GroupList;
    this.iNu = false;
    if (this.iNt.size() <= 0)
    {
      aQm();
      AppMethodBeat.o(131301);
      return;
    }
    if ((this.recommendType == 0) && (this.fRN.size() <= 0))
    {
      aQm();
      AppMethodBeat.o(131301);
      return;
    }
    if (this.recommendType != 0)
    {
      qT(-1);
      AppMethodBeat.o(131301);
      return;
    }
    aQn();
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