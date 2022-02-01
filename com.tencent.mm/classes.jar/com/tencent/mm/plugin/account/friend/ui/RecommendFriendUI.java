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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ac;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import junit.framework.Assert;

public class RecommendFriendUI
  extends MMActivity
  implements f
{
  private ProgressDialog fOC;
  private LinkedList<auf> gnJ;
  private boolean jiA;
  private b jjs;
  private ListView jjt;
  private TextView jju;
  private LinkedList<cdf> jjv;
  private boolean jjw;
  private int recommendType;
  
  public RecommendFriendUI()
  {
    AppMethodBeat.i(131295);
    this.fOC = null;
    this.jjv = new LinkedList();
    this.gnJ = new LinkedList();
    this.recommendType = -1;
    this.jjw = false;
    AppMethodBeat.o(131295);
  }
  
  private void aTX()
  {
    AppMethodBeat.i(131302);
    this.jju.setVisibility(0);
    this.jjt.setVisibility(8);
    AppMethodBeat.o(131302);
  }
  
  private void aTY()
  {
    AppMethodBeat.i(131304);
    if (this.recommendType == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("dealGetInviteFriendGroupSuccess just only qq", bool);
      ae.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendGroupSuccess  respList.size:" + this.gnJ.size());
      this.jjs.gnJ = this.gnJ;
      this.jjt.setAdapter(this.jjs);
      showOptionMenu(false);
      this.jiA = true;
      setMMTitle(2131763248);
      this.jjs.jiA = this.jiA;
      this.jjs.notifyDataSetChanged();
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
    if ((this.jiA) || (this.jjw))
    {
      finish();
      AppMethodBeat.o(131298);
      return;
    }
    aTY();
    AppMethodBeat.o(131298);
  }
  
  private void rw(int paramInt)
  {
    AppMethodBeat.i(131303);
    ae.i("MicroMsg.RecommendFriendUI", "dealGetInviteFriendSuccess  respList.size:" + this.jjv.size());
    this.jjs.a(this.jjv, paramInt);
    this.jjt.setAdapter(this.jjs);
    this.jiA = false;
    String str;
    int i;
    if (this.recommendType == 0)
    {
      str = "";
      i = 0;
      if (i < this.gnJ.size())
      {
        if (paramInt != ((auf)this.gnJ.get(i)).GxI) {
          break label153;
        }
        str = ((auf)this.gnJ.get(i)).GLc;
      }
    }
    label153:
    for (;;)
    {
      i += 1;
      break;
      setMMTitle(str);
      this.jjs.jiA = this.jiA;
      this.jjs.notifyDataSetChanged();
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
    this.jju = ((TextView)findViewById(2131299475));
    if (this.recommendType == 1)
    {
      setMMTitle(2131763376);
      this.jju.setText(2131763380);
    }
    for (;;)
    {
      this.jjs = new b(getLayoutInflater());
      this.jjt = ((ListView)findViewById(2131301076));
      this.jjt.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(131288);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          if (!RecommendFriendUI.a(RecommendFriendUI.this))
          {
            RecommendFriendUI.b(RecommendFriendUI.this).rv(paramAnonymousInt);
            if (RecommendFriendUI.b(RecommendFriendUI.this).aTW().length > 0) {
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
          if (!paramAnonymousView.jiA) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = ((auf)paramAnonymousView.gnJ.get(paramAnonymousInt)).GxI)
          {
            RecommendFriendUI.a(paramAnonymousAdapterView, paramAnonymousInt);
            break;
          }
        }
      });
      this.jjt.setAdapter(this.jjs);
      addTextOptionMenu(0, getString(2131760374), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(131290);
          int i = RecommendFriendUI.b(RecommendFriendUI.this).aTW().length;
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
      this.jjw = true;
      final ac localac = new ac(this.recommendType);
      g.ajj().a(localac, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.fOC = h.b(localAppCompatActivity, getString(2131760377), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131293);
          g.ajj().a(localac);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = RecommendFriendUI.e(RecommendFriendUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/account/friend/ui/RecommendFriendUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
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
        this.jju.setText(2131763379);
      }
      else
      {
        setMMTitle(2131763248);
        this.jju.setText(2131763381);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131296);
    super.onCreate(paramBundle);
    this.recommendType = bu.getInt(getIntent().getStringExtra("recommend_type"), 0);
    this.jiA = false;
    g.ajj().a(135, this);
    initView();
    AppMethodBeat.o(131296);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131300);
    g.ajj().b(135, this);
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
    ae.i("MicroMsg.RecommendFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramn.getType() != 135))
    {
      aTX();
      AppMethodBeat.o(131301);
      return;
    }
    this.jjv = ((cdc)((ac)paramn).rr.hQE.hQJ).uuU;
    this.gnJ = ((cdc)((ac)paramn).rr.hQE.hQJ).GroupList;
    this.jjw = false;
    if (this.jjv.size() <= 0)
    {
      aTX();
      AppMethodBeat.o(131301);
      return;
    }
    if ((this.recommendType == 0) && (this.gnJ.size() <= 0))
    {
      aTX();
      AppMethodBeat.o(131301);
      return;
    }
    if (this.recommendType != 0)
    {
      rw(-1);
      AppMethodBeat.o(131301);
      return;
    }
    aTY();
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