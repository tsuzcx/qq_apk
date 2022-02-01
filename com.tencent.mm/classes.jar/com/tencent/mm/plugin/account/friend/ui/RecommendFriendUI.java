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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ac;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.cci;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI
  extends MMActivity
  implements f
{
  private ProgressDialog fMu;
  private LinkedList<atp> glo;
  private boolean jfH;
  private ListView jgA;
  private TextView jgB;
  private LinkedList<ccl> jgC;
  private boolean jgD;
  private b jgz;
  private int recommendType;
  
  public RecommendFriendUI()
  {
    AppMethodBeat.i(131295);
    this.fMu = null;
    this.jgC = new LinkedList();
    this.glo = new LinkedList();
    this.recommendType = -1;
    this.jgD = false;
    AppMethodBeat.o(131295);
  }
  
  private void aTy()
  {
    AppMethodBeat.i(131302);
    this.jgB.setVisibility(0);
    this.jgA.setVisibility(8);
    AppMethodBeat.o(131302);
  }
  
  private void aTz()
  {
    AppMethodBeat.i(131304);
    if (this.recommendType == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", bool);
      ad.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.glo.size());
      this.jgz.glo = this.glo;
      this.jgA.setAdapter(this.jgz);
      showOptionMenu(false);
      this.jfH = true;
      setMMTitle(2131763248);
      this.jgz.jfH = this.jfH;
      this.jgz.notifyDataSetChanged();
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
    if ((this.jfH) || (this.jgD))
    {
      finish();
      AppMethodBeat.o(131298);
      return;
    }
    aTz();
    AppMethodBeat.o(131298);
  }
  
  private void rt(int paramInt)
  {
    AppMethodBeat.i(131303);
    ad.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.jgC.size());
    this.jgz.a(this.jgC, paramInt);
    this.jgA.setAdapter(this.jgz);
    this.jfH = false;
    String str;
    int i;
    if (this.recommendType == 0)
    {
      str = "";
      i = 0;
      if (i < this.glo.size())
      {
        if (paramInt != ((atp)this.glo.get(i)).Gfa) {
          break label153;
        }
        str = ((atp)this.glo.get(i)).GrE;
      }
    }
    label153:
    for (;;)
    {
      i += 1;
      break;
      setMMTitle(str);
      this.jgz.jfH = this.jfH;
      this.jgz.notifyDataSetChanged();
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
    this.jgB = ((TextView)findViewById(2131299475));
    if (this.recommendType == 1)
    {
      setMMTitle(2131763376);
      this.jgB.setText(2131763380);
    }
    for (;;)
    {
      this.jgz = new b(getLayoutInflater());
      this.jgA = ((ListView)findViewById(2131301076));
      this.jgA.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(131288);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          if (!RecommendFriendUI.a(RecommendFriendUI.this))
          {
            RecommendFriendUI.b(RecommendFriendUI.this).rs(paramAnonymousInt);
            if (RecommendFriendUI.b(RecommendFriendUI.this).aTx().length > 0) {
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
          if (!paramAnonymousView.jfH) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = ((atp)paramAnonymousView.glo.get(paramAnonymousInt)).Gfa)
          {
            RecommendFriendUI.a(paramAnonymousAdapterView, paramAnonymousInt);
            break;
          }
        }
      });
      this.jgA.setAdapter(this.jgz);
      addTextOptionMenu(0, getString(2131760374), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(131290);
          int i = RecommendFriendUI.b(RecommendFriendUI.this).aTx().length;
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
      this.jgD = true;
      final ac localac = new ac(this.recommendType);
      g.aiU().a(localac, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.fMu = h.b(localAppCompatActivity, getString(2131760377), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131293);
          g.aiU().a(localac);
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = RecommendFriendUI.e(RecommendFriendUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131292);
        }
      });
      AppMethodBeat.o(131297);
      return;
      if (this.recommendType == 2)
      {
        setMMTitle(2131763375);
        this.jgB.setText(2131763379);
      }
      else
      {
        setMMTitle(2131763248);
        this.jgB.setText(2131763381);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131296);
    super.onCreate(paramBundle);
    this.recommendType = bt.getInt(getIntent().getStringExtra("recommend_type"), 0);
    this.jfH = false;
    g.aiU().a(135, this);
    initView();
    AppMethodBeat.o(131296);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131300);
    g.aiU().b(135, this);
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
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramn.getType() != 135))
    {
      aTy();
      AppMethodBeat.o(131301);
      return;
    }
    this.jgC = ((cci)((ac)paramn).rr.hNL.hNQ).ujw;
    this.glo = ((cci)((ac)paramn).rr.hNL.hNQ).GroupList;
    this.jgD = false;
    if (this.jgC.size() <= 0)
    {
      aTy();
      AppMethodBeat.o(131301);
      return;
    }
    if ((this.recommendType == 0) && (this.glo.size() <= 0))
    {
      aTy();
      AppMethodBeat.o(131301);
      return;
    }
    if (this.recommendType != 0)
    {
      rt(-1);
      AppMethodBeat.o(131301);
      return;
    }
    aTz();
    AppMethodBeat.o(131301);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI
 * JD-Core Version:    0.7.0.1
 */