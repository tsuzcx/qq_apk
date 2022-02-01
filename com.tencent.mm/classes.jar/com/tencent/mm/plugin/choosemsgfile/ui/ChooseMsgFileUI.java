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
import com.tencent.mm.aw.q;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.choosemsgfile.b.c.f;
import com.tencent.mm.plugin.choosemsgfile.b.c.f.4;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public class ChooseMsgFileUI
  extends MMActivity
  implements c
{
  private String fGM;
  private TextView fTc;
  private int mCount;
  private String mType;
  private String oSs;
  private f oTE;
  private TextView oTF;
  private RecyclerView oTG;
  private TextView oTH;
  private TextView oTI;
  private ImageButton oTJ;
  private TextView oTK;
  private boolean oTL;
  private int oTM;
  private String oTp;
  private com.tencent.mm.plugin.choosemsgfile.b.d.a oTr;
  private RelativeLayout oTs;
  private Button oTt;
  private ProgressDialog oTu;
  
  public ChooseMsgFileUI()
  {
    AppMethodBeat.i(123435);
    this.oTr = new com.tencent.mm.plugin.choosemsgfile.b.d.a();
    this.oTL = true;
    AppMethodBeat.o(123435);
  }
  
  private void ZG(String paramString)
  {
    AppMethodBeat.i(123441);
    if (("image".equals(paramString)) || ("all".equals(paramString)))
    {
      this.oTJ.setVisibility(0);
      this.oTK.setVisibility(0);
    }
    while ("all".equals(this.mType))
    {
      this.oTH.setVisibility(0);
      this.oTI.setVisibility(0);
      ZH(paramString);
      AppMethodBeat.o(123441);
      return;
      this.oTJ.setVisibility(4);
      this.oTK.setVisibility(4);
    }
    this.oTH.setVisibility(4);
    this.oTI.setVisibility(4);
    AppMethodBeat.o(123441);
  }
  
  private void ZH(String paramString)
  {
    AppMethodBeat.i(123442);
    if ("all".equals(paramString))
    {
      this.oTI.setText("");
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
      this.oTI.setText(localStringBuilder.toString());
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
        com.tencent.mm.plugin.choosemsgfile.b.d.c.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, this.oRK);
        AppMethodBeat.o(123425);
      }
    });
    paramMMActivity.startActivityForResult(localIntent, com.tencent.mm.plugin.choosemsgfile.b.d.b.oTn);
    AppMethodBeat.o(123448);
  }
  
  private void jF(boolean paramBoolean)
  {
    AppMethodBeat.i(123444);
    ad.i("MicroMsg.ChooseMsgFileUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.oTu = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(123444);
      return;
    }
    if ((this.oTu != null) && (this.oTu.isShowing()))
    {
      this.oTu.dismiss();
      this.oTu = null;
    }
    AppMethodBeat.o(123444);
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(123445);
    ad.i("MicroMsg.ChooseMsgFileUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      jF(false);
      this.oTG.getAdapter().asY.notifyChanged();
      int i = this.oTG.getAdapter().getItemCount();
      RecyclerView localRecyclerView = this.oTG;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      localRecyclerView.ca(((Integer)locala.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      if (paramInt <= 0)
      {
        this.fTc.setVisibility(0);
        this.oTG.setVisibility(8);
        this.fTc.setText(getString(2131757352));
        AppMethodBeat.o(123445);
        return;
      }
      this.fTc.setVisibility(8);
      this.oTG.setVisibility(0);
      AppMethodBeat.o(123445);
      return;
    }
    if (paramInt > 0)
    {
      this.oTG.getAdapter().ar(0, paramInt);
      this.oTG.getAdapter().ap(paramInt, this.oTM + paramInt);
      AppMethodBeat.o(123445);
      return;
    }
    this.oTG.getAdapter().cj(0);
    AppMethodBeat.o(123445);
  }
  
  public final void bZF()
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
  
  public final com.tencent.mm.plugin.choosemsgfile.b.d.a bZm()
  {
    return this.oTr;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(123447);
    View localView = this.oTG.getChildAt(paramInt);
    AppMethodBeat.o(123447);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2131493537;
  }
  
  public final String getUserName()
  {
    return this.fGM;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123440);
    this.fTc = ((TextView)findViewById(2131302951));
    this.oTF = ((TextView)findViewById(2131298928));
    this.oTG = ((RecyclerView)findViewById(2131299926));
    this.oTs = ((RelativeLayout)findViewById(2131300197));
    this.oTH = ((TextView)findViewById(2131299957));
    this.oTI = ((TextView)findViewById(2131299958));
    this.oTJ = ((ImageButton)findViewById(2131303093));
    this.oTK = ((TextView)findViewById(2131303095));
    this.oTt = ((Button)findViewById(2131305557));
    AppMethodBeat.o(123440);
  }
  
  public final void jD(boolean paramBoolean)
  {
    AppMethodBeat.i(123443);
    if (paramBoolean)
    {
      jF(true);
      AppMethodBeat.o(123443);
      return;
    }
    this.oTM = ((GridLayoutManager)this.oTG.getLayoutManager()).ko();
    AppMethodBeat.o(123443);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123436);
    h.q(this);
    super.onCreate(paramBundle);
    this.fGM = getIntent().getStringExtra("USERNAME");
    this.oSs = com.tencent.mm.plugin.choosemsgfile.b.d.c.ze(this.fGM);
    this.mType = com.tencent.mm.plugin.choosemsgfile.b.d.c.ZD(getIntent().getStringExtra("TYPE"));
    this.mCount = getIntent().getIntExtra("COUNT", 9);
    this.oTp = getIntent().getStringExtra("EXTENSION");
    ad.i("MicroMsg.ChooseMsgFileUI", "select msg file from username:%s nickname:%s, type:%s, count:%d", new Object[] { this.fGM, this.oSs, this.mType, Integer.valueOf(this.mCount) });
    ad.i("MicroMsg.ChooseMsgFileUI", "select msg file from extension:%s", new Object[] { this.oTp });
    this.oTr.init(this.mCount);
    this.oTE = new f(this);
    initView();
    this.oTG.setLayoutManager(this.oTE.bZB());
    this.oTG.a(new f.4(this.oTE, this));
    this.oTG.setAdapter(this.oTE.bZA());
    this.oTG.setHasFixedSize(true);
    this.oTG.a(new RecyclerView.m()
    {
      private Runnable oTO;
      
      private void jG(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123421);
        if (paramAnonymousBoolean)
        {
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).removeCallbacks(this.oTO);
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
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).removeCallbacks(this.oTO);
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).postDelayed(this.oTO, 256L);
        }
        AppMethodBeat.o(123421);
      }
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(123422);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        paramAnonymousRecyclerView = (LinearLayoutManager)ChooseMsgFileUI.g(ChooseMsgFileUI.this).bZB();
        paramAnonymousRecyclerView = ChooseMsgFileUI.g(ChooseMsgFileUI.this).oTb.AS(paramAnonymousRecyclerView.km());
        if (paramAnonymousRecyclerView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(123422);
          return;
        }
        paramAnonymousRecyclerView = com.tencent.mm.plugin.choosemsgfile.b.d.c.tG(paramAnonymousRecyclerView.getTimeStamp());
        ChooseMsgFileUI.h(ChooseMsgFileUI.this).setText(bt.bI(paramAnonymousRecyclerView, ""));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(123422);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(123423);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
        if (1 == paramAnonymousInt) {
          jG(true);
        }
        for (;;)
        {
          if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
          {
            if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).km() == 0) && (!ChooseMsgFileUI.i(ChooseMsgFileUI.this))) {
              ChooseMsgFileUI.g(ChooseMsgFileUI.this).c(false, ChooseMsgFileUI.e(ChooseMsgFileUI.this), ChooseMsgFileUI.f(ChooseMsgFileUI.this));
            }
            ChooseMsgFileUI.j(ChooseMsgFileUI.this);
            q.aIJ().cp(paramAnonymousInt);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(123423);
          return;
          if (paramAnonymousInt == 0) {
            jG(false);
          }
        }
      }
    });
    setMMTitle(this.oSs);
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
    this.oTJ.setOnClickListener(new View.OnClickListener()
    {
      @SuppressLint({"ResourceType"})
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123427);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = ChooseMsgFileUI.a(ChooseMsgFileUI.this);
        boolean bool;
        if (!paramAnonymousView.oTl)
        {
          bool = true;
          paramAnonymousView.oTl = bool;
          if (!ChooseMsgFileUI.a(ChooseMsgFileUI.this).oTl) {
            break label104;
          }
          ChooseMsgFileUI.b(ChooseMsgFileUI.this).setImageResource(2131691078);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123427);
          return;
          bool = false;
          break;
          label104:
          ChooseMsgFileUI.b(ChooseMsgFileUI.this).setImageResource(2131691077);
        }
      }
    });
    this.oTK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123428);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ChooseMsgFileUI.b(ChooseMsgFileUI.this).performClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123428);
      }
    });
    this.oTH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123429);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ChooseMsgFileUI.c(ChooseMsgFileUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123429);
      }
    });
    this.oTI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123430);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ChooseMsgFileUI.c(ChooseMsgFileUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123430);
      }
    });
    this.oTt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123432);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ChooseMsgFileUI.a(ChooseMsgFileUI.this).bZE())
        {
          paramAnonymousView = new f.a(ChooseMsgFileUI.this);
          paramAnonymousView.aXO(ChooseMsgFileUI.this.getString(2131757348)).yU(true);
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123432);
          return;
        }
        ChooseMsgFileUI.d(ChooseMsgFileUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123432);
      }
    });
    this.oTE.fh(this.mType, this.oTp);
    ZG(this.mType);
    h.r(this);
    AppMethodBeat.o(123436);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123439);
    super.onDestroy();
    this.oTE.onDestroy();
    this.oTr.uninit();
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
    this.oTE.onResume();
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