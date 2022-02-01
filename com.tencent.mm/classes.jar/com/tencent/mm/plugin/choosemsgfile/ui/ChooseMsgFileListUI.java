package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.choosemsgfile.b.c.e;
import com.tencent.mm.plugin.choosemsgfile.b.c.e.3;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public class ChooseMsgFileListUI
  extends MMActivity
  implements c
{
  private RecyclerView anl;
  private String fGM;
  private TextView fTc;
  private int mCount;
  private String oSs;
  private String oTp;
  private e oTq;
  private com.tencent.mm.plugin.choosemsgfile.b.d.a oTr;
  private RelativeLayout oTs;
  private Button oTt;
  private ProgressDialog oTu;
  
  public ChooseMsgFileListUI()
  {
    AppMethodBeat.i(123388);
    this.oTr = new com.tencent.mm.plugin.choosemsgfile.b.d.a();
    AppMethodBeat.o(123388);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, int paramInt, String paramString2, a.a parama)
  {
    AppMethodBeat.i(123400);
    Intent localIntent = new Intent(paramMMActivity, ChooseMsgFileListUI.class);
    localIntent.putExtra("USERNAME", paramString1);
    localIntent.putExtra("COUNT", paramInt);
    localIntent.putExtra("EXTENSION", paramString2);
    paramMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(123387);
        ad.i("MicroMsg.ChooseMsgFileListUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        ad.d("MicroMsg.ChooseMsgFileListUI", "data:%s", new Object[] { paramAnonymousIntent });
        com.tencent.mm.plugin.choosemsgfile.b.d.c.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, this.oRK);
        AppMethodBeat.o(123387);
      }
    });
    paramMMActivity.startActivityForResult(localIntent, com.tencent.mm.plugin.choosemsgfile.b.d.b.oTn);
    AppMethodBeat.o(123400);
  }
  
  private void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(123398);
    ad.i("MicroMsg.ChooseMsgFileListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.oTu = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(123398);
      return;
    }
    if ((this.oTu != null) && (this.oTu.isShowing()))
    {
      this.oTu.dismiss();
      this.oTu = null;
    }
    AppMethodBeat.o(123398);
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(123396);
    jt(false);
    ad.i("MicroMsg.ChooseMsgFileListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.fTc.setVisibility(0);
      this.anl.setVisibility(8);
      this.fTc.setText(getString(2131757352));
      AppMethodBeat.o(123396);
      return;
    }
    this.fTc.setVisibility(8);
    this.anl.setVisibility(0);
    this.anl.getAdapter().asY.notifyChanged();
    AppMethodBeat.o(123396);
  }
  
  public final void bZF()
  {
    AppMethodBeat.i(123399);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123386);
        Button localButton = ChooseMsgFileListUI.c(ChooseMsgFileListUI.this);
        if (ChooseMsgFileListUI.a(ChooseMsgFileListUI.this).getSelectCount() > 0) {}
        for (boolean bool = true;; bool = false)
        {
          localButton.setEnabled(bool);
          AppMethodBeat.o(123386);
          return;
        }
      }
    });
    AppMethodBeat.o(123399);
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.b.d.a bZm()
  {
    return this.oTr;
  }
  
  public void finish()
  {
    AppMethodBeat.i(123394);
    super.finish();
    overridePendingTransition(2130772108, 2130772106);
    AppMethodBeat.o(123394);
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(123397);
    View localView = this.anl.getChildAt(paramInt);
    AppMethodBeat.o(123397);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2131493536;
  }
  
  public final String getUserName()
  {
    return this.fGM;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123390);
    this.fTc = ((TextView)findViewById(2131302951));
    this.anl = ((RecyclerView)findViewById(2131299926));
    this.oTs = ((RelativeLayout)findViewById(2131300197));
    this.oTt = ((Button)findViewById(2131305557));
    AppMethodBeat.o(123390);
  }
  
  public final void jD(boolean paramBoolean)
  {
    AppMethodBeat.i(123395);
    jt(true);
    AppMethodBeat.o(123395);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123389);
    h.q(this);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772108, 2130772106);
    this.fGM = getIntent().getStringExtra("USERNAME");
    this.oSs = com.tencent.mm.plugin.choosemsgfile.b.d.c.ze(this.fGM);
    this.mCount = getIntent().getIntExtra("COUNT", 9);
    this.oTp = getIntent().getStringExtra("EXTENSION");
    ad.i("MicroMsg.ChooseMsgFileListUI", "onCreate mCount:%d mExtension:%s", new Object[] { Integer.valueOf(this.mCount), this.oTp });
    this.oTq = new e(this);
    initView();
    findViewById(2131298757).setBackgroundColor(getContext().getResources().getColor(2131100155));
    this.anl.setBackgroundColor(getContext().getResources().getColor(2131100155));
    paramBundle = this.anl;
    e locale = this.oTq;
    if (locale.noH == null) {
      locale.noH = new LinearLayoutManager();
    }
    paramBundle.setLayoutManager(locale.noH);
    this.anl.a(new e.3(this.oTq));
    this.anl.setAdapter(this.oTq.bZA());
    this.anl.setHasFixedSize(true);
    setMMTitle(this.oSs);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123382);
        ChooseMsgFileListUI.this.finish();
        AppMethodBeat.o(123382);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755691), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123383);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("ERRMSG", "cancel");
        ChooseMsgFileListUI.this.setResult(1, paramAnonymousMenuItem);
        ChooseMsgFileListUI.this.finish();
        ChooseMsgFileListUI.this.overridePendingTransition(2130772108, 2130772106);
        AppMethodBeat.o(123383);
        return true;
      }
    });
    this.oTt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123385);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ChooseMsgFileListUI.a(ChooseMsgFileListUI.this).bZE())
        {
          paramAnonymousView = new f.a(ChooseMsgFileListUI.this);
          paramAnonymousView.aXO(ChooseMsgFileListUI.this.getString(2131757348)).yU(true);
          paramAnonymousView.c(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(123384);
              ad.i("MicroMsg.ChooseMsgFileListUI", "bOk:%b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
              if (paramAnonymous2Boolean) {
                ChooseMsgFileListUI.b(ChooseMsgFileListUI.this);
              }
              AppMethodBeat.o(123384);
            }
          }).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123385);
          return;
        }
        ChooseMsgFileListUI.b(ChooseMsgFileListUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123385);
      }
    });
    this.oTq.fh("file", this.oTp);
    h.r(this);
    this.oTr.init(this.mCount);
    AppMethodBeat.o(123389);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123393);
    super.onDestroy();
    this.oTq.onDestroy();
    this.oTr.uninit();
    AppMethodBeat.o(123393);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123392);
    super.onPause();
    this.oTq.onPause();
    AppMethodBeat.o(123392);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123391);
    super.onResume();
    this.oTq.onResume();
    AppMethodBeat.o(123391);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI
 * JD-Core Version:    0.7.0.1
 */