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
import android.support.v7.widget.RecyclerView.l;
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
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.choosemsgfile.b.c.f;
import com.tencent.mm.plugin.choosemsgfile.b.c.f.4;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public class ChooseMsgFileUI
  extends MMActivity
  implements c
{
  private TextView gAp;
  private String goe;
  private int mCount;
  private String mType;
  private String qnT;
  private String qoP;
  private com.tencent.mm.plugin.choosemsgfile.b.d.a qoR;
  private RelativeLayout qoS;
  private Button qoT;
  private ProgressDialog qoU;
  private f qpe;
  private TextView qpf;
  private RecyclerView qpg;
  private TextView qph;
  private TextView qpi;
  private ImageButton qpj;
  private TextView qpk;
  private boolean qpl;
  private int qpm;
  
  public ChooseMsgFileUI()
  {
    AppMethodBeat.i(123435);
    this.qoR = new com.tencent.mm.plugin.choosemsgfile.b.d.a();
    this.qpl = true;
    AppMethodBeat.o(123435);
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
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(123425);
        Log.i("MicroMsg.ChooseMsgFileUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Log.d("MicroMsg.ChooseMsgFileUI", "data:%s", new Object[] { paramAnonymousIntent });
        com.tencent.mm.plugin.choosemsgfile.b.d.c.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, this.qnl);
        AppMethodBeat.o(123425);
      }
    });
    paramMMActivity.startActivityForResult(localIntent, com.tencent.mm.plugin.choosemsgfile.b.d.b.qoN);
    AppMethodBeat.o(123448);
  }
  
  private void akD(String paramString)
  {
    AppMethodBeat.i(123441);
    if (("image".equals(paramString)) || ("all".equals(paramString)))
    {
      this.qpj.setVisibility(0);
      this.qpk.setVisibility(0);
    }
    while ("all".equals(this.mType))
    {
      this.qph.setVisibility(0);
      this.qpi.setVisibility(0);
      akE(paramString);
      AppMethodBeat.o(123441);
      return;
      this.qpj.setVisibility(4);
      this.qpk.setVisibility(4);
    }
    this.qph.setVisibility(4);
    this.qpi.setVisibility(4);
    AppMethodBeat.o(123441);
  }
  
  private void akE(String paramString)
  {
    AppMethodBeat.i(123442);
    if ("all".equals(paramString))
    {
      this.qpi.setText("");
      AppMethodBeat.o(123442);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    if ("image".equals(paramString)) {
      localStringBuilder.append(getString(2131757573));
    }
    for (;;)
    {
      localStringBuilder.append(")");
      this.qpi.setText(localStringBuilder.toString());
      AppMethodBeat.o(123442);
      return;
      if ("video".equals(paramString)) {
        localStringBuilder.append(getString(2131757574));
      } else if ("file".equals(paramString)) {
        localStringBuilder.append(getString(2131757572));
      }
    }
  }
  
  private void kH(boolean paramBoolean)
  {
    AppMethodBeat.i(123444);
    Log.i("MicroMsg.ChooseMsgFileUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.qoU = com.tencent.mm.ui.base.q.a(this, getString(2131762446), true, 0, null);
      AppMethodBeat.o(123444);
      return;
    }
    if ((this.qoU != null) && (this.qoU.isShowing()))
    {
      this.qoU.dismiss();
      this.qoU = null;
    }
    AppMethodBeat.o(123444);
  }
  
  public final void D(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(123445);
    Log.i("MicroMsg.ChooseMsgFileUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      kH(false);
      this.qpg.getAdapter().atj.notifyChanged();
      int i = this.qpg.getAdapter().getItemCount();
      RecyclerView localRecyclerView = this.qpg;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      localRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      if (paramInt <= 0)
      {
        this.gAp.setVisibility(0);
        this.qpg.setVisibility(8);
        this.gAp.setText(getString(2131757569));
        AppMethodBeat.o(123445);
        return;
      }
      this.gAp.setVisibility(8);
      this.qpg.setVisibility(0);
      AppMethodBeat.o(123445);
      return;
    }
    if (paramInt > 0)
    {
      this.qpg.getAdapter().as(0, paramInt);
      this.qpg.getAdapter().aq(paramInt, this.qpm + paramInt);
      AppMethodBeat.o(123445);
      return;
    }
    this.qpg.getAdapter().ci(0);
    AppMethodBeat.o(123445);
  }
  
  public final void cyJ()
  {
    AppMethodBeat.i(123446);
    MMHandlerThread.postToMainThread(new Runnable()
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
  
  public final com.tencent.mm.plugin.choosemsgfile.b.d.a cys()
  {
    return this.qoR;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(123447);
    View localView = this.qpg.getChildAt(paramInt);
    AppMethodBeat.o(123447);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2131493649;
  }
  
  public final String getUserName()
  {
    return this.goe;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123440);
    this.gAp = ((TextView)findViewById(2131305538));
    this.qpf = ((TextView)findViewById(2131299412));
    this.qpg = ((RecyclerView)findViewById(2131300630));
    this.qoS = ((RelativeLayout)findViewById(2131301662));
    this.qph = ((TextView)findViewById(2131300700));
    this.qpi = ((TextView)findViewById(2131300701));
    this.qpj = ((ImageButton)findViewById(2131305723));
    this.qpk = ((TextView)findViewById(2131305725));
    this.qoT = ((Button)findViewById(2131308778));
    AppMethodBeat.o(123440);
  }
  
  public final void kF(boolean paramBoolean)
  {
    AppMethodBeat.i(123443);
    if (paramBoolean)
    {
      kH(true);
      AppMethodBeat.o(123443);
      return;
    }
    this.qpm = ((GridLayoutManager)this.qpg.getLayoutManager()).ku();
    AppMethodBeat.o(123443);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123436);
    h.q(this);
    super.onCreate(paramBundle);
    this.goe = getIntent().getStringExtra("USERNAME");
    this.qnT = com.tencent.mm.plugin.choosemsgfile.b.d.c.Ir(this.goe);
    this.mType = com.tencent.mm.plugin.choosemsgfile.b.d.c.akA(getIntent().getStringExtra("TYPE"));
    this.mCount = getIntent().getIntExtra("COUNT", 9);
    this.qoP = getIntent().getStringExtra("EXTENSION");
    Log.i("MicroMsg.ChooseMsgFileUI", "select msg file from username:%s nickname:%s, type:%s, count:%d", new Object[] { this.goe, this.qnT, this.mType, Integer.valueOf(this.mCount) });
    Log.i("MicroMsg.ChooseMsgFileUI", "select msg file from extension:%s", new Object[] { this.qoP });
    this.qoR.init(this.mCount);
    this.qpe = new f(this);
    initView();
    this.qpg.setLayoutManager(this.qpe.eS(this));
    this.qpg.a(new f.4(this.qpe, this));
    this.qpg.setAdapter(this.qpe.cyF());
    this.qpg.setHasFixedSize(true);
    this.qpg.a(new RecyclerView.l()
    {
      private Runnable qpo;
      
      private void kI(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123421);
        if (paramAnonymousBoolean)
        {
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).removeCallbacks(this.qpo);
          if (ChooseMsgFileUI.h(ChooseMsgFileUI.this).getVisibility() != 0)
          {
            ChooseMsgFileUI.h(ChooseMsgFileUI.this).clearAnimation();
            Animation localAnimation = AnimationUtils.loadAnimation(ChooseMsgFileUI.this.getContext(), 2130772059);
            ChooseMsgFileUI.h(ChooseMsgFileUI.this).setVisibility(0);
            ChooseMsgFileUI.h(ChooseMsgFileUI.this).startAnimation(localAnimation);
            AppMethodBeat.o(123421);
          }
        }
        else
        {
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).removeCallbacks(this.qpo);
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).postDelayed(this.qpo, 256L);
        }
        AppMethodBeat.o(123421);
      }
      
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(123423);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        if (1 == paramAnonymousInt) {
          kI(true);
        }
        for (;;)
        {
          if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
          {
            if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).ks() == 0) && (!ChooseMsgFileUI.i(ChooseMsgFileUI.this))) {
              ChooseMsgFileUI.g(ChooseMsgFileUI.this).c(false, ChooseMsgFileUI.e(ChooseMsgFileUI.this), ChooseMsgFileUI.f(ChooseMsgFileUI.this));
            }
            ChooseMsgFileUI.j(ChooseMsgFileUI.this);
            com.tencent.mm.av.q.bcV().onScrollStateChanged(paramAnonymousInt);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(123423);
          return;
          if (paramAnonymousInt == 0) {
            kI(false);
          }
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(123422);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        paramAnonymousRecyclerView = (LinearLayoutManager)ChooseMsgFileUI.g(ChooseMsgFileUI.this).eS(ChooseMsgFileUI.this);
        paramAnonymousRecyclerView = ChooseMsgFileUI.g(ChooseMsgFileUI.this).qoB.EM(paramAnonymousRecyclerView.ks());
        if (paramAnonymousRecyclerView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(123422);
          return;
        }
        paramAnonymousRecyclerView = com.tencent.mm.plugin.choosemsgfile.b.d.c.Cc(paramAnonymousRecyclerView.getTimeStamp());
        ChooseMsgFileUI.h(ChooseMsgFileUI.this).setText(Util.nullAs(paramAnonymousRecyclerView, ""));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(123422);
      }
    });
    setMMTitle(this.qnT);
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
    addTextOptionMenu(0, getString(2131755761), new MenuItem.OnMenuItemClickListener()
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
    this.qpj.setOnClickListener(new View.OnClickListener()
    {
      @SuppressLint({"ResourceType"})
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123427);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = ChooseMsgFileUI.a(ChooseMsgFileUI.this);
        boolean bool;
        if (!paramAnonymousView.qoL)
        {
          bool = true;
          paramAnonymousView.qoL = bool;
          if (!ChooseMsgFileUI.a(ChooseMsgFileUI.this).qoL) {
            break label104;
          }
          ChooseMsgFileUI.b(ChooseMsgFileUI.this).setImageResource(2131691380);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123427);
          return;
          bool = false;
          break;
          label104:
          ChooseMsgFileUI.b(ChooseMsgFileUI.this).setImageResource(2131691379);
        }
      }
    });
    this.qpk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123428);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ChooseMsgFileUI.b(ChooseMsgFileUI.this).performClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123428);
      }
    });
    this.qph.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123429);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ChooseMsgFileUI.c(ChooseMsgFileUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123429);
      }
    });
    this.qpi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123430);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ChooseMsgFileUI.c(ChooseMsgFileUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123430);
      }
    });
    this.qoT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123432);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ChooseMsgFileUI.a(ChooseMsgFileUI.this).cyI())
        {
          paramAnonymousView = new f.a(ChooseMsgFileUI.this);
          paramAnonymousView.bow(ChooseMsgFileUI.this.getString(2131757565)).Dq(true);
          paramAnonymousView.c(new f.c()
          {
            public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(123431);
              Log.i("MicroMsg.ChooseMsgFileUI", "bOk:%b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
              if (paramAnonymous2Boolean) {
                ChooseMsgFileUI.d(ChooseMsgFileUI.this);
              }
              AppMethodBeat.o(123431);
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123432);
          return;
        }
        ChooseMsgFileUI.d(ChooseMsgFileUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123432);
      }
    });
    this.qpe.fC(this.mType, this.qoP);
    akD(this.mType);
    h.r(this);
    AppMethodBeat.o(123436);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123439);
    super.onDestroy();
    this.qpe.onDestroy();
    this.qoR.uninit();
    AppMethodBeat.o(123439);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123438);
    super.onPause();
    Log.i("MicroMsg.ChooseMsgFileUIController", "onPause");
    AppMethodBeat.o(123438);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123437);
    super.onResume();
    this.qpe.onResume();
    AppMethodBeat.o(123437);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI
 * JD-Core Version:    0.7.0.1
 */