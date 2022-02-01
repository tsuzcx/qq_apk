package com.tencent.mm.plugin.choosemsgfile.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.choosemsgfile.b.c.f;
import com.tencent.mm.plugin.choosemsgfile.b.c.f.4;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public class ChooseMsgFileUI
  extends MMActivity
  implements c
{
  private String foE;
  private TextView fzM;
  private int mCount;
  private String mType;
  private String ooX;
  private String opU;
  private com.tencent.mm.plugin.choosemsgfile.b.d.a opW;
  private RelativeLayout opX;
  private Button opY;
  private ProgressDialog opZ;
  private f oqj;
  private TextView oqk;
  private RecyclerView oql;
  private TextView oqm;
  private TextView oqn;
  private ImageButton oqo;
  private TextView oqp;
  private boolean oqq;
  private int oqr;
  
  public ChooseMsgFileUI()
  {
    AppMethodBeat.i(123435);
    this.opW = new com.tencent.mm.plugin.choosemsgfile.b.d.a();
    this.oqq = true;
    AppMethodBeat.o(123435);
  }
  
  private void VX(String paramString)
  {
    AppMethodBeat.i(123441);
    if (("image".equals(paramString)) || ("all".equals(paramString)))
    {
      this.oqo.setVisibility(0);
      this.oqp.setVisibility(0);
    }
    while ("all".equals(this.mType))
    {
      this.oqm.setVisibility(0);
      this.oqn.setVisibility(0);
      VY(paramString);
      AppMethodBeat.o(123441);
      return;
      this.oqo.setVisibility(4);
      this.oqp.setVisibility(4);
    }
    this.oqm.setVisibility(4);
    this.oqn.setVisibility(4);
    AppMethodBeat.o(123441);
  }
  
  private void VY(String paramString)
  {
    AppMethodBeat.i(123442);
    if ("all".equals(paramString))
    {
      this.oqn.setText("");
      AppMethodBeat.o(123442);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    if ("image".equals(paramString)) {
      localStringBuilder.append(getString(2131757356));
    }
    for (;;)
    {
      localStringBuilder.append(")");
      this.oqn.setText(localStringBuilder.toString());
      AppMethodBeat.o(123442);
      return;
      if ("video".equals(paramString)) {
        localStringBuilder.append(getString(2131757357));
      } else if ("file".equals(paramString)) {
        localStringBuilder.append(getString(2131757355));
      }
    }
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, String paramString2, int paramInt, String paramString3, a.a parama)
  {
    AppMethodBeat.i(123448);
    Intent localIntent = new Intent(paramMMActivity, ChooseMsgFileUI.class);
    localIntent.putExtra("USERNAME", paramString1);
    localIntent.putExtra("TYPE", paramString2);
    localIntent.putExtra("COUNT", paramInt);
    localIntent.putExtra("EXTENSION", paramString3);
    paramMMActivity.mmSetOnActivityResultCallback(new ChooseMsgFileUI.4(parama));
    paramMMActivity.startActivityForResult(localIntent, com.tencent.mm.plugin.choosemsgfile.b.d.b.opS);
    AppMethodBeat.o(123448);
  }
  
  private void ju(boolean paramBoolean)
  {
    AppMethodBeat.i(123444);
    ac.i("MicroMsg.ChooseMsgFileUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.opZ = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(123444);
      return;
    }
    if ((this.opZ != null) && (this.opZ.isShowing()))
    {
      this.opZ.dismiss();
      this.opZ = null;
    }
    AppMethodBeat.o(123444);
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(123445);
    ac.i("MicroMsg.ChooseMsgFileUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      ju(false);
      this.oql.getAdapter().arg.notifyChanged();
      int i = this.oql.getAdapter().getItemCount();
      RecyclerView localRecyclerView = this.oql;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      localRecyclerView.ca(((Integer)locala.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      if (paramInt <= 0)
      {
        this.fzM.setVisibility(0);
        this.oql.setVisibility(8);
        this.fzM.setText(getString(2131757352));
        AppMethodBeat.o(123445);
        return;
      }
      this.fzM.setVisibility(8);
      this.oql.setVisibility(0);
      AppMethodBeat.o(123445);
      return;
    }
    if (paramInt > 0)
    {
      this.oql.getAdapter().aq(0, paramInt);
      this.oql.getAdapter().ao(paramInt, this.oqr + paramInt);
      AppMethodBeat.o(123445);
      return;
    }
    this.oql.getAdapter().cj(0);
    AppMethodBeat.o(123445);
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.b.d.a bUH()
  {
    return this.opW;
  }
  
  public final void bVa()
  {
    AppMethodBeat.i(123446);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123424);
        Button localButton = ChooseMsgFileUI.k(ChooseMsgFileUI.this);
        if (ChooseMsgFileUI.a(ChooseMsgFileUI.this).getSelectCount() > 0) {}
        for (boolean bool = true;; bool = false)
        {
          localButton.setEnabled(bool);
          AppMethodBeat.o(123424);
          return;
        }
      }
    });
    AppMethodBeat.o(123446);
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(123447);
    View localView = this.oql.getChildAt(paramInt);
    AppMethodBeat.o(123447);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2131493537;
  }
  
  public final String getUserName()
  {
    return this.foE;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123440);
    this.fzM = ((TextView)findViewById(2131302951));
    this.oqk = ((TextView)findViewById(2131298928));
    this.oql = ((RecyclerView)findViewById(2131299926));
    this.opX = ((RelativeLayout)findViewById(2131300197));
    this.oqm = ((TextView)findViewById(2131299957));
    this.oqn = ((TextView)findViewById(2131299958));
    this.oqo = ((ImageButton)findViewById(2131303093));
    this.oqp = ((TextView)findViewById(2131303095));
    this.opY = ((Button)findViewById(2131305557));
    AppMethodBeat.o(123440);
  }
  
  public final void js(boolean paramBoolean)
  {
    AppMethodBeat.i(123443);
    if (paramBoolean)
    {
      ju(true);
      AppMethodBeat.o(123443);
      return;
    }
    this.oqr = ((GridLayoutManager)this.oql.getLayoutManager()).jY();
    AppMethodBeat.o(123443);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123436);
    g.o(this);
    super.onCreate(paramBundle);
    this.foE = getIntent().getStringExtra("USERNAME");
    this.ooX = com.tencent.mm.plugin.choosemsgfile.b.d.c.wj(this.foE);
    this.mType = com.tencent.mm.plugin.choosemsgfile.b.d.c.VU(getIntent().getStringExtra("TYPE"));
    this.mCount = getIntent().getIntExtra("COUNT", 9);
    this.opU = getIntent().getStringExtra("EXTENSION");
    ac.i("MicroMsg.ChooseMsgFileUI", "select msg file from username:%s nickname:%s, type:%s, count:%d", new Object[] { this.foE, this.ooX, this.mType, Integer.valueOf(this.mCount) });
    ac.i("MicroMsg.ChooseMsgFileUI", "select msg file from extension:%s", new Object[] { this.opU });
    this.opW.init(this.mCount);
    this.oqj = new f(this);
    initView();
    this.oql.setLayoutManager(this.oqj.bUW());
    this.oql.a(new f.4(this.oqj, this));
    this.oql.setAdapter(this.oqj.bUV());
    this.oql.setHasFixedSize(true);
    this.oql.a(new RecyclerView.m()
    {
      private Runnable oqt;
      
      private void jv(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123421);
        if (paramAnonymousBoolean)
        {
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).removeCallbacks(this.oqt);
          if (ChooseMsgFileUI.h(ChooseMsgFileUI.this).getVisibility() != 0)
          {
            ChooseMsgFileUI.h(ChooseMsgFileUI.this).clearAnimation();
            Animation localAnimation = AnimationUtils.loadAnimation(ChooseMsgFileUI.this.getContext(), 2130772047);
            ChooseMsgFileUI.h(ChooseMsgFileUI.this).setVisibility(0);
            ChooseMsgFileUI.h(ChooseMsgFileUI.this).startAnimation(localAnimation);
            AppMethodBeat.o(123421);
          }
        }
        else
        {
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).removeCallbacks(this.oqt);
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).postDelayed(this.oqt, 256L);
        }
        AppMethodBeat.o(123421);
      }
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(123422);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        paramAnonymousRecyclerView = (LinearLayoutManager)ChooseMsgFileUI.g(ChooseMsgFileUI.this).bUW();
        paramAnonymousRecyclerView = ChooseMsgFileUI.g(ChooseMsgFileUI.this).opG.Aj(paramAnonymousRecyclerView.jW());
        if (paramAnonymousRecyclerView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(123422);
          return;
        }
        paramAnonymousRecyclerView = com.tencent.mm.plugin.choosemsgfile.b.d.c.rH(paramAnonymousRecyclerView.getTimeStamp());
        ChooseMsgFileUI.h(ChooseMsgFileUI.this).setText(bs.bG(paramAnonymousRecyclerView, ""));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(123422);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(123423);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        if (1 == paramAnonymousInt) {
          jv(true);
        }
        for (;;)
        {
          if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
          {
            if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).jW() == 0) && (!ChooseMsgFileUI.i(ChooseMsgFileUI.this))) {
              ChooseMsgFileUI.g(ChooseMsgFileUI.this).b(false, ChooseMsgFileUI.e(ChooseMsgFileUI.this), ChooseMsgFileUI.f(ChooseMsgFileUI.this));
            }
            ChooseMsgFileUI.j(ChooseMsgFileUI.this);
            o.aFB().cp(paramAnonymousInt);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(123423);
          return;
          if (paramAnonymousInt == 0) {
            jv(false);
          }
        }
      }
    });
    setMMTitle(this.ooX);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123418);
        ChooseMsgFileUI.this.finish();
        AppMethodBeat.o(123418);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755691), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123426);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("ERRMSG", "cancel");
        ChooseMsgFileUI.this.setResult(1, paramAnonymousMenuItem);
        ChooseMsgFileUI.this.finish();
        AppMethodBeat.o(123426);
        return true;
      }
    });
    this.oqo.setOnClickListener(new View.OnClickListener()
    {
      @SuppressLint({"ResourceType"})
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123427);
        paramAnonymousView = ChooseMsgFileUI.a(ChooseMsgFileUI.this);
        if (!paramAnonymousView.opQ) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.opQ = bool;
          if (!ChooseMsgFileUI.a(ChooseMsgFileUI.this).opQ) {
            break;
          }
          ChooseMsgFileUI.b(ChooseMsgFileUI.this).setImageResource(2131691078);
          AppMethodBeat.o(123427);
          return;
        }
        ChooseMsgFileUI.b(ChooseMsgFileUI.this).setImageResource(2131691077);
        AppMethodBeat.o(123427);
      }
    });
    this.oqp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123428);
        ChooseMsgFileUI.b(ChooseMsgFileUI.this).performClick();
        AppMethodBeat.o(123428);
      }
    });
    this.oqm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123429);
        ChooseMsgFileUI.c(ChooseMsgFileUI.this);
        AppMethodBeat.o(123429);
      }
    });
    this.oqn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123430);
        ChooseMsgFileUI.c(ChooseMsgFileUI.this);
        AppMethodBeat.o(123430);
      }
    });
    this.opY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123432);
        if (ChooseMsgFileUI.a(ChooseMsgFileUI.this).bUZ())
        {
          paramAnonymousView = new f.a(ChooseMsgFileUI.this);
          paramAnonymousView.aRQ(ChooseMsgFileUI.this.getString(2131757348)).yi(true);
          paramAnonymousView.c(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(123431);
              ac.i("MicroMsg.ChooseMsgFileUI", "bOk:%b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
              if (paramAnonymous2Boolean) {
                ChooseMsgFileUI.d(ChooseMsgFileUI.this);
              }
              AppMethodBeat.o(123431);
            }
          }).show();
          AppMethodBeat.o(123432);
          return;
        }
        ChooseMsgFileUI.d(ChooseMsgFileUI.this);
        AppMethodBeat.o(123432);
      }
    });
    this.oqj.eX(this.mType, this.opU);
    VX(this.mType);
    g.p(this);
    AppMethodBeat.o(123436);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123439);
    super.onDestroy();
    this.oqj.onDestroy();
    this.opW.uninit();
    AppMethodBeat.o(123439);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123438);
    super.onPause();
    ac.i("MicroMsg.ChooseMsgFileUIController", "onPause");
    AppMethodBeat.o(123438);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123437);
    super.onResume();
    this.oqj.onResume();
    AppMethodBeat.o(123437);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI
 * JD-Core Version:    0.7.0.1
 */