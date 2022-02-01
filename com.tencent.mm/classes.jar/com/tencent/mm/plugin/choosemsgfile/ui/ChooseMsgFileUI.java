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
import com.tencent.mm.aw.o;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.choosemsgfile.b.c.f;
import com.tencent.mm.plugin.choosemsgfile.b.c.f.4;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
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
  private String flk;
  private TextView fwf;
  private int mCount;
  private String mType;
  private String nLX;
  private String nMU;
  private com.tencent.mm.plugin.choosemsgfile.b.d.a nMW;
  private RelativeLayout nMX;
  private Button nMY;
  private ProgressDialog nMZ;
  private f nNh;
  private TextView nNi;
  private RecyclerView nNj;
  private TextView nNk;
  private TextView nNl;
  private ImageButton nNm;
  private TextView nNn;
  private boolean nNo;
  private int nNp;
  
  public ChooseMsgFileUI()
  {
    AppMethodBeat.i(123435);
    this.nMW = new com.tencent.mm.plugin.choosemsgfile.b.d.a();
    this.nNo = true;
    AppMethodBeat.o(123435);
  }
  
  private void RL(String paramString)
  {
    AppMethodBeat.i(123441);
    if (("image".equals(paramString)) || ("all".equals(paramString)))
    {
      this.nNm.setVisibility(0);
      this.nNn.setVisibility(0);
    }
    while ("all".equals(this.mType))
    {
      this.nNk.setVisibility(0);
      this.nNl.setVisibility(0);
      RM(paramString);
      AppMethodBeat.o(123441);
      return;
      this.nNm.setVisibility(4);
      this.nNn.setVisibility(4);
    }
    this.nNk.setVisibility(4);
    this.nNl.setVisibility(4);
    AppMethodBeat.o(123441);
  }
  
  private void RM(String paramString)
  {
    AppMethodBeat.i(123442);
    if ("all".equals(paramString))
    {
      this.nNl.setText("");
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
      this.nNl.setText(localStringBuilder.toString());
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
    paramMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(123425);
        ad.i("MicroMsg.ChooseMsgFileUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        ad.d("MicroMsg.ChooseMsgFileUI", "data:%s", new Object[] { paramAnonymousIntent });
        com.tencent.mm.plugin.choosemsgfile.b.d.c.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, this.nLp);
        AppMethodBeat.o(123425);
      }
    });
    paramMMActivity.startActivityForResult(localIntent, com.tencent.mm.plugin.choosemsgfile.b.d.b.nMS);
    AppMethodBeat.o(123448);
  }
  
  private void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(123444);
    ad.i("MicroMsg.ChooseMsgFileUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.nMZ = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(123444);
      return;
    }
    if ((this.nMZ != null) && (this.nMZ.isShowing()))
    {
      this.nMZ.dismiss();
      this.nMZ = null;
    }
    AppMethodBeat.o(123444);
  }
  
  public final void A(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(123445);
    ad.i("MicroMsg.ChooseMsgFileUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      iR(false);
      this.nNj.getAdapter().aql.notifyChanged();
      int i = this.nNj.getAdapter().getItemCount();
      RecyclerView localRecyclerView = this.nNj;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      localRecyclerView.ca(((Integer)locala.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      if (paramInt <= 0)
      {
        this.fwf.setVisibility(0);
        this.nNj.setVisibility(8);
        this.fwf.setText(getString(2131757352));
        AppMethodBeat.o(123445);
        return;
      }
      this.fwf.setVisibility(8);
      this.nNj.setVisibility(0);
      AppMethodBeat.o(123445);
      return;
    }
    if (paramInt > 0)
    {
      this.nNj.getAdapter().aq(0, paramInt);
      this.nNj.getAdapter().ao(paramInt, this.nNp + paramInt);
      AppMethodBeat.o(123445);
      return;
    }
    this.nNj.getAdapter().ck(0);
    AppMethodBeat.o(123445);
  }
  
  public final void bNP()
  {
    AppMethodBeat.i(123446);
    aq.f(new Runnable()
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
  
  public final com.tencent.mm.plugin.choosemsgfile.b.d.a bNw()
  {
    return this.nMW;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(123447);
    View localView = this.nNj.getChildAt(paramInt);
    AppMethodBeat.o(123447);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2131493537;
  }
  
  public final String getUserName()
  {
    return this.flk;
  }
  
  public final void iP(boolean paramBoolean)
  {
    AppMethodBeat.i(123443);
    if (paramBoolean)
    {
      iR(true);
      AppMethodBeat.o(123443);
      return;
    }
    this.nNp = ((GridLayoutManager)this.nNj.getLayoutManager()).jQ();
    AppMethodBeat.o(123443);
  }
  
  public void initView()
  {
    AppMethodBeat.i(123440);
    this.fwf = ((TextView)findViewById(2131302951));
    this.nNi = ((TextView)findViewById(2131298928));
    this.nNj = ((RecyclerView)findViewById(2131299926));
    this.nMX = ((RelativeLayout)findViewById(2131300197));
    this.nNk = ((TextView)findViewById(2131299957));
    this.nNl = ((TextView)findViewById(2131299958));
    this.nNm = ((ImageButton)findViewById(2131303093));
    this.nNn = ((TextView)findViewById(2131303095));
    this.nMY = ((Button)findViewById(2131305557));
    AppMethodBeat.o(123440);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123436);
    g.o(this);
    super.onCreate(paramBundle);
    this.flk = getIntent().getStringExtra("USERNAME");
    this.nLX = com.tencent.mm.plugin.choosemsgfile.b.d.c.sg(this.flk);
    this.mType = com.tencent.mm.plugin.choosemsgfile.b.d.c.RI(getIntent().getStringExtra("TYPE"));
    this.mCount = getIntent().getIntExtra("COUNT", 9);
    this.nMU = getIntent().getStringExtra("EXTENSION");
    ad.i("MicroMsg.ChooseMsgFileUI", "select msg file from username:%s nickname:%s, type:%s, count:%d", new Object[] { this.flk, this.nLX, this.mType, Integer.valueOf(this.mCount) });
    ad.i("MicroMsg.ChooseMsgFileUI", "select msg file from extension:%s", new Object[] { this.nMU });
    this.nMW.init(this.mCount);
    this.nNh = new f(this);
    initView();
    this.nNj.setLayoutManager(this.nNh.bNL());
    this.nNj.a(new f.4(this.nNh, this));
    this.nNj.setAdapter(this.nNh.bNK());
    this.nNj.setHasFixedSize(true);
    this.nNj.a(new RecyclerView.m()
    {
      private Runnable nNr;
      
      private void iS(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123421);
        if (paramAnonymousBoolean)
        {
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).removeCallbacks(this.nNr);
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
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).removeCallbacks(this.nNr);
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).postDelayed(this.nNr, 256L);
        }
        AppMethodBeat.o(123421);
      }
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(123422);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        paramAnonymousRecyclerView = (LinearLayoutManager)ChooseMsgFileUI.g(ChooseMsgFileUI.this).bNL();
        paramAnonymousRecyclerView = ChooseMsgFileUI.g(ChooseMsgFileUI.this).nMG.zs(paramAnonymousRecyclerView.jO());
        if (paramAnonymousRecyclerView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(123422);
          return;
        }
        paramAnonymousRecyclerView = com.tencent.mm.plugin.choosemsgfile.b.d.c.nV(paramAnonymousRecyclerView.getTimeStamp());
        ChooseMsgFileUI.h(ChooseMsgFileUI.this).setText(bt.by(paramAnonymousRecyclerView, ""));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(123422);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(123423);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        if (1 == paramAnonymousInt) {
          iS(true);
        }
        for (;;)
        {
          if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
          {
            if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).jO() == 0) && (!ChooseMsgFileUI.i(ChooseMsgFileUI.this))) {
              ChooseMsgFileUI.g(ChooseMsgFileUI.this).b(false, ChooseMsgFileUI.e(ChooseMsgFileUI.this), ChooseMsgFileUI.f(ChooseMsgFileUI.this));
            }
            ChooseMsgFileUI.j(ChooseMsgFileUI.this);
            o.ayJ().cq(paramAnonymousInt);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(123423);
          return;
          if (paramAnonymousInt == 0) {
            iS(false);
          }
        }
      }
    });
    setMMTitle(this.nLX);
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
    this.nNm.setOnClickListener(new View.OnClickListener()
    {
      @SuppressLint({"ResourceType"})
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123427);
        paramAnonymousView = ChooseMsgFileUI.a(ChooseMsgFileUI.this);
        if (!paramAnonymousView.nMQ) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.nMQ = bool;
          if (!ChooseMsgFileUI.a(ChooseMsgFileUI.this).nMQ) {
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
    this.nNn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123428);
        ChooseMsgFileUI.b(ChooseMsgFileUI.this).performClick();
        AppMethodBeat.o(123428);
      }
    });
    this.nNk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123429);
        ChooseMsgFileUI.c(ChooseMsgFileUI.this);
        AppMethodBeat.o(123429);
      }
    });
    this.nNl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123430);
        ChooseMsgFileUI.c(ChooseMsgFileUI.this);
        AppMethodBeat.o(123430);
      }
    });
    this.nMY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123432);
        if (ChooseMsgFileUI.a(ChooseMsgFileUI.this).bNO())
        {
          paramAnonymousView = new f.a(ChooseMsgFileUI.this);
          paramAnonymousView.aMo(ChooseMsgFileUI.this.getString(2131757348)).wZ(true);
          paramAnonymousView.c(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(123431);
              ad.i("MicroMsg.ChooseMsgFileUI", "bOk:%b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
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
    this.nNh.eK(this.mType, this.nMU);
    RL(this.mType);
    g.p(this);
    AppMethodBeat.o(123436);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123439);
    super.onDestroy();
    this.nNh.onDestroy();
    this.nMW.uninit();
    AppMethodBeat.o(123439);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123438);
    super.onPause();
    ad.i("MicroMsg.ChooseMsgFileUIController", "onPause");
    AppMethodBeat.o(123438);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123437);
    super.onResume();
    this.nNh.onResume();
    AppMethodBeat.o(123437);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI
 * JD-Core Version:    0.7.0.1
 */