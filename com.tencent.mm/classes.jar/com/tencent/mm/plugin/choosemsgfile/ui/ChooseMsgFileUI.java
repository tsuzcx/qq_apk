package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.choosemsgfile.a.e;
import com.tencent.mm.plugin.choosemsgfile.a.f;
import com.tencent.mm.plugin.choosemsgfile.a.g;
import com.tencent.mm.plugin.choosemsgfile.a.h;
import com.tencent.mm.plugin.choosemsgfile.logic.ui.f;
import com.tencent.mm.plugin.choosemsgfile.logic.ui.f.3;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;

public class ChooseMsgFileUI
  extends MMActivity
  implements e
{
  private String bjg;
  private TextView lMW;
  private String luk;
  private int mCount;
  private String wPR;
  private String wQO;
  private com.tencent.mm.plugin.choosemsgfile.logic.c.a wQQ;
  private RelativeLayout wQR;
  private Button wQS;
  private ProgressDialog wQT;
  private f wRe;
  private TextView wRf;
  private RecyclerView wRg;
  private TextView wRh;
  private TextView wRi;
  private ImageButton wRj;
  private TextView wRk;
  private boolean wRl;
  private int wRm;
  
  public ChooseMsgFileUI()
  {
    AppMethodBeat.i(123435);
    this.wQQ = new com.tencent.mm.plugin.choosemsgfile.logic.c.a();
    this.wRl = true;
    AppMethodBeat.o(123435);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, String paramString2, int paramInt, String paramString3, com.tencent.mm.choosemsgfile.compat.a.a parama)
  {
    AppMethodBeat.i(123448);
    Intent localIntent = new Intent(paramMMActivity, ChooseMsgFileUI.class);
    localIntent.putExtra("USERNAME", paramString1);
    localIntent.putExtra("TYPE", paramString2);
    localIntent.putExtra("COUNT", paramInt);
    localIntent.putExtra("EXTENSION", paramString3);
    paramMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(123425);
        Log.i("MicroMsg.ChooseMsgFileUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Log.d("MicroMsg.ChooseMsgFileUI", "data:%s", new Object[] { paramAnonymousIntent });
        com.tencent.mm.plugin.choosemsgfile.logic.c.c.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, ChooseMsgFileUI.this);
        AppMethodBeat.o(123425);
      }
    });
    paramMMActivity.startActivityForResult(localIntent, com.tencent.mm.plugin.choosemsgfile.logic.c.b.wQM);
    AppMethodBeat.o(123448);
  }
  
  private void alW(String paramString)
  {
    AppMethodBeat.i(123441);
    if (("image".equals(paramString)) || ("all".equals(paramString)))
    {
      this.wRj.setVisibility(0);
      this.wRk.setVisibility(0);
    }
    while ("all".equals(this.bjg))
    {
      this.wRh.setVisibility(0);
      this.wRi.setVisibility(0);
      alX(paramString);
      AppMethodBeat.o(123441);
      return;
      this.wRj.setVisibility(4);
      this.wRk.setVisibility(4);
    }
    this.wRh.setVisibility(4);
    this.wRi.setVisibility(4);
    AppMethodBeat.o(123441);
  }
  
  private void alX(String paramString)
  {
    AppMethodBeat.i(123442);
    if ("all".equals(paramString))
    {
      this.wRi.setText("");
      AppMethodBeat.o(123442);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    if ("image".equals(paramString)) {
      localStringBuilder.append(getString(a.h.choose_msg_file_pic_filter_img));
    }
    for (;;)
    {
      localStringBuilder.append(")");
      this.wRi.setText(localStringBuilder.toString());
      AppMethodBeat.o(123442);
      return;
      if ("video".equals(paramString)) {
        localStringBuilder.append(getString(a.h.choose_msg_file_pic_filter_video));
      } else if ("file".equals(paramString)) {
        localStringBuilder.append(getString(a.h.choose_msg_file_pic_filter_file));
      }
    }
  }
  
  private void no(boolean paramBoolean)
  {
    AppMethodBeat.i(123444);
    Log.i("MicroMsg.ChooseMsgFileUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.wQT = w.a(this, getString(a.h.loading_tips), true, 0, null);
      AppMethodBeat.o(123444);
      return;
    }
    if ((this.wQT != null) && (this.wQT.isShowing()))
    {
      this.wQT.dismiss();
      this.wQT = null;
    }
    AppMethodBeat.o(123444);
  }
  
  public final void F(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(123445);
    Log.i("MicroMsg.ChooseMsgFileUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      no(false);
      this.wRg.getAdapter().bZE.notifyChanged();
      int i = this.wRg.getAdapter().getItemCount();
      RecyclerView localRecyclerView = this.wRg;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      localRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      if (paramInt <= 0)
      {
        this.lMW.setVisibility(0);
        this.wRg.setVisibility(8);
        this.lMW.setText(getString(a.h.choose_msg_file_no_content));
        AppMethodBeat.o(123445);
        return;
      }
      this.lMW.setVisibility(8);
      this.wRg.setVisibility(0);
      AppMethodBeat.o(123445);
      return;
    }
    if (paramInt > 0)
    {
      this.wRg.getAdapter().bA(0, paramInt);
      this.wRg.getAdapter().by(paramInt, this.wRm + paramInt);
      AppMethodBeat.o(123445);
      return;
    }
    this.wRg.getAdapter().fV(0);
    AppMethodBeat.o(123445);
  }
  
  public final void dqK()
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
  
  public final com.tencent.mm.plugin.choosemsgfile.logic.c.a dqs()
  {
    return this.wQQ;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(123447);
    View localView = this.wRg.getChildAt(paramInt);
    AppMethodBeat.o(123447);
    return localView;
  }
  
  public int getLayoutId()
  {
    return a.f.choose_msg_file_ui;
  }
  
  public final String getUserName()
  {
    return this.luk;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123440);
    this.lMW = ((TextView)findViewById(a.e.nothing));
    this.wRf = ((TextView)findViewById(a.e.date));
    this.wRg = ((RecyclerView)findViewById(a.e.file_recyclerview));
    this.wQR = ((RelativeLayout)findViewById(a.e.footer_bar));
    this.wRh = ((TextView)findViewById(a.e.filter));
    this.wRi = ((TextView)findViewById(a.e.filter_desc));
    this.wRj = ((ImageButton)findViewById(a.e.orignal_image));
    this.wRk = ((TextView)findViewById(a.e.orignal_image_tip));
    this.wQS = ((Button)findViewById(a.e.sure));
    AppMethodBeat.o(123440);
  }
  
  public final void nm(boolean paramBoolean)
  {
    AppMethodBeat.i(123443);
    if (paramBoolean)
    {
      no(true);
      AppMethodBeat.o(123443);
      return;
    }
    this.wRm = ((GridLayoutManager)this.wRg.getLayoutManager()).Jw();
    AppMethodBeat.o(123443);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123436);
    h.w(this);
    super.onCreate(paramBundle);
    this.luk = getIntent().getStringExtra("USERNAME");
    this.wPR = com.tencent.mm.plugin.choosemsgfile.logic.c.c.ID(this.luk);
    this.bjg = com.tencent.mm.plugin.choosemsgfile.logic.c.c.alT(getIntent().getStringExtra("TYPE"));
    this.mCount = getIntent().getIntExtra("COUNT", 9);
    this.wQO = getIntent().getStringExtra("EXTENSION");
    Log.i("MicroMsg.ChooseMsgFileUI", "select msg file from username:%s nickname:%s, type:%s, count:%d", new Object[] { this.luk, this.wPR, this.bjg, Integer.valueOf(this.mCount) });
    Log.i("MicroMsg.ChooseMsgFileUI", "select msg file from extension:%s", new Object[] { this.wQO });
    this.wQQ.sE(this.mCount);
    this.wRe = new f(this);
    initView();
    this.wRg.setLayoutManager(this.wRe.fT(this));
    this.wRg.a(new f.3(this.wRe, this));
    this.wRg.setAdapter(this.wRe.dqG());
    this.wRg.setHasFixedSize(true);
    this.wRg.a(new RecyclerView.l()
    {
      private Runnable wRo;
      
      private void np(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123421);
        if (paramAnonymousBoolean)
        {
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).removeCallbacks(this.wRo);
          if (ChooseMsgFileUI.h(ChooseMsgFileUI.this).getVisibility() != 0)
          {
            ChooseMsgFileUI.h(ChooseMsgFileUI.this).clearAnimation();
            Animation localAnimation = AnimationUtils.loadAnimation(ChooseMsgFileUI.this.getContext(), com.tencent.mm.plugin.choosemsgfile.a.a.fast_faded_in);
            ChooseMsgFileUI.h(ChooseMsgFileUI.this).setVisibility(0);
            ChooseMsgFileUI.h(ChooseMsgFileUI.this).startAnimation(localAnimation);
            AppMethodBeat.o(123421);
          }
        }
        else
        {
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).removeCallbacks(this.wRo);
          ChooseMsgFileUI.h(ChooseMsgFileUI.this).postDelayed(this.wRo, 256L);
        }
        AppMethodBeat.o(123421);
      }
      
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(262561);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        if (1 == paramAnonymousInt) {
          np(true);
        }
        for (;;)
        {
          if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
          {
            if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).Ju() == 0) && (!ChooseMsgFileUI.i(ChooseMsgFileUI.this))) {
              ChooseMsgFileUI.g(ChooseMsgFileUI.this).c(false, ChooseMsgFileUI.e(ChooseMsgFileUI.this), ChooseMsgFileUI.f(ChooseMsgFileUI.this));
            }
            ChooseMsgFileUI.j(ChooseMsgFileUI.this);
            r.bKe().onScrollStateChanged(paramAnonymousInt);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(262561);
          return;
          if (paramAnonymousInt == 0) {
            np(false);
          }
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(262557);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        paramAnonymousRecyclerView = (LinearLayoutManager)ChooseMsgFileUI.g(ChooseMsgFileUI.this).fT(ChooseMsgFileUI.this);
        paramAnonymousRecyclerView = ChooseMsgFileUI.g(ChooseMsgFileUI.this).wQA.IW(paramAnonymousRecyclerView.Ju());
        if (paramAnonymousRecyclerView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(262557);
          return;
        }
        paramAnonymousRecyclerView = com.tencent.mm.plugin.choosemsgfile.logic.c.c.kD(paramAnonymousRecyclerView.getTimeStamp());
        ChooseMsgFileUI.h(ChooseMsgFileUI.this).setText(Util.nullAs(paramAnonymousRecyclerView, ""));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$10", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(262557);
      }
    });
    setMMTitle(this.wPR);
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
    addTextOptionMenu(0, getString(a.h.app_cancel), new MenuItem.OnMenuItemClickListener()
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
    this.wRj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123427);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = ChooseMsgFileUI.a(ChooseMsgFileUI.this);
        boolean bool;
        if (!paramAnonymousView.wQK)
        {
          bool = true;
          paramAnonymousView.wQK = bool;
          if (!ChooseMsgFileUI.a(ChooseMsgFileUI.this).wQK) {
            break label105;
          }
          ChooseMsgFileUI.b(ChooseMsgFileUI.this).setImageResource(a.g.radio_on);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123427);
          return;
          bool = false;
          break;
          label105:
          ChooseMsgFileUI.b(ChooseMsgFileUI.this).setImageResource(a.g.radio_off);
        }
      }
    });
    this.wRk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123428);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ChooseMsgFileUI.b(ChooseMsgFileUI.this).performClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123428);
      }
    });
    this.wRh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123429);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ChooseMsgFileUI.c(ChooseMsgFileUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123429);
      }
    });
    this.wRi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123430);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ChooseMsgFileUI.c(ChooseMsgFileUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123430);
      }
    });
    this.wQS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123432);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ChooseMsgFileUI.a(ChooseMsgFileUI.this).dqJ())
        {
          paramAnonymousView = new g.a(ChooseMsgFileUI.this);
          paramAnonymousView.bDE(ChooseMsgFileUI.this.getString(a.h.choose_msg_file_downing_slogan)).NF(true);
          paramAnonymousView.c(new g.c()
          {
            public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
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
    this.wRe.gp(this.bjg, this.wQO);
    alW(this.bjg);
    h.x(this);
    AppMethodBeat.o(123436);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123439);
    super.onDestroy();
    this.wRe.onDestroy();
    this.wQQ.uninit();
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
    this.wRe.onResume();
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