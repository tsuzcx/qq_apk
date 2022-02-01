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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ac;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI
  extends MMActivity
  implements i
{
  private LinkedList<bfo> gYE;
  private ProgressDialog gtM;
  private boolean kgC;
  private b khu;
  private ListView khv;
  private TextView khw;
  private LinkedList<ctl> khx;
  private boolean khy;
  private int recommendType;
  
  public RecommendFriendUI()
  {
    AppMethodBeat.i(131295);
    this.gtM = null;
    this.khx = new LinkedList();
    this.gYE = new LinkedList();
    this.recommendType = -1;
    this.khy = false;
    AppMethodBeat.o(131295);
  }
  
  private void boJ()
  {
    AppMethodBeat.i(131302);
    this.khw.setVisibility(0);
    this.khv.setVisibility(8);
    AppMethodBeat.o(131302);
  }
  
  private void boK()
  {
    AppMethodBeat.i(131304);
    if (this.recommendType == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", bool);
      Log.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.gYE.size());
      this.khu.gYE = this.gYE;
      this.khv.setAdapter(this.khu);
      showOptionMenu(false);
      this.kgC = true;
      setMMTitle(2131765418);
      this.khu.kgC = this.kgC;
      this.khu.notifyDataSetChanged();
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
    if ((this.kgC) || (this.khy))
    {
      finish();
      AppMethodBeat.o(131298);
      return;
    }
    boK();
    AppMethodBeat.o(131298);
  }
  
  private void vm(int paramInt)
  {
    AppMethodBeat.i(131303);
    Log.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.khx.size());
    this.khu.a(this.khx, paramInt);
    this.khv.setAdapter(this.khu);
    this.kgC = false;
    String str;
    int i;
    if (this.recommendType == 0)
    {
      str = "";
      i = 0;
      if (i < this.gYE.size())
      {
        if (paramInt != ((bfo)this.gYE.get(i)).Ltr) {
          break label153;
        }
        str = ((bfo)this.gYE.get(i)).LPg;
      }
    }
    label153:
    for (;;)
    {
      i += 1;
      break;
      setMMTitle(str);
      this.khu.kgC = this.kgC;
      this.khu.notifyDataSetChanged();
      AppMethodBeat.o(131303);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495082;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131297);
    this.khw = ((TextView)findViewById(2131300105));
    if (this.recommendType == 1)
    {
      setMMTitle(2131765558);
      this.khw.setText(2131765562);
    }
    for (;;)
    {
      this.khu = new b(getLayoutInflater());
      this.khv = ((ListView)findViewById(2131302730));
      this.khv.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(131288);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          if (!RecommendFriendUI.a(RecommendFriendUI.this))
          {
            RecommendFriendUI.b(RecommendFriendUI.this).vl(paramAnonymousInt);
            if (RecommendFriendUI.b(RecommendFriendUI.this).boI().length > 0) {
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
          if (!paramAnonymousView.kgC) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = ((bfo)paramAnonymousView.gYE.get(paramAnonymousInt)).Ltr)
          {
            RecommendFriendUI.a(paramAnonymousAdapterView, paramAnonymousInt);
            break;
          }
        }
      });
      this.khv.setAdapter(this.khu);
      addTextOptionMenu(0, getString(2131761819), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(131290);
          int i = RecommendFriendUI.b(RecommendFriendUI.this).boI().length;
          h.a(RecommendFriendUI.this.getContext(), RecommendFriendUI.this.getContext().getResources().getQuantityString(2131623954, i, new Object[] { Integer.valueOf(i) }), RecommendFriendUI.this.getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      this.khy = true;
      final ac localac = new ac(this.recommendType);
      g.azz().a(localac, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755998);
      this.gtM = h.a(localAppCompatActivity, getString(2131761822), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131293);
          g.azz().a(localac);
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = RecommendFriendUI.e(RecommendFriendUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(131292);
        }
      });
      AppMethodBeat.o(131297);
      return;
      if (this.recommendType == 2)
      {
        setMMTitle(2131765557);
        this.khw.setText(2131765561);
      }
      else
      {
        setMMTitle(2131765418);
        this.khw.setText(2131765563);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131296);
    super.onCreate(paramBundle);
    this.recommendType = Util.getInt(getIntent().getStringExtra("recommend_type"), 0);
    this.kgC = false;
    g.azz().a(135, this);
    initView();
    AppMethodBeat.o(131296);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131300);
    g.azz().b(135, this);
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
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramq.getType() != 135))
    {
      boJ();
      AppMethodBeat.o(131301);
      return;
    }
    this.khx = ((cti)((ac)paramq).rr.iLL.iLR).xMV;
    this.gYE = ((cti)((ac)paramq).rr.iLL.iLR).GroupList;
    this.khy = false;
    if (this.khx.size() <= 0)
    {
      boJ();
      AppMethodBeat.o(131301);
      return;
    }
    if ((this.recommendType == 0) && (this.gYE.size() <= 0))
    {
      boJ();
      AppMethodBeat.o(131301);
      return;
    }
    if (this.recommendType != 0)
    {
      vm(-1);
      AppMethodBeat.o(131301);
      return;
    }
    boK();
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