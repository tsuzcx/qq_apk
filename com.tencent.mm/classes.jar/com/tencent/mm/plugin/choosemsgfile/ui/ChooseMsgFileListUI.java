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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public class ChooseMsgFileListUI
  extends MMActivity
  implements c
{
  private TextView gAp;
  private String goe;
  private int mCount;
  private RecyclerView mRecyclerView;
  private String qnT;
  private String qoP;
  private e qoQ;
  private com.tencent.mm.plugin.choosemsgfile.b.d.a qoR;
  private RelativeLayout qoS;
  private Button qoT;
  private ProgressDialog qoU;
  
  public ChooseMsgFileListUI()
  {
    AppMethodBeat.i(123388);
    this.qoR = new com.tencent.mm.plugin.choosemsgfile.b.d.a();
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
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(123387);
        Log.i("MicroMsg.ChooseMsgFileListUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Log.d("MicroMsg.ChooseMsgFileListUI", "data:%s", new Object[] { paramAnonymousIntent });
        com.tencent.mm.plugin.choosemsgfile.b.d.c.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, this.qnl);
        AppMethodBeat.o(123387);
      }
    });
    paramMMActivity.startActivityForResult(localIntent, com.tencent.mm.plugin.choosemsgfile.b.d.b.qoN);
    AppMethodBeat.o(123400);
  }
  
  private void ku(boolean paramBoolean)
  {
    AppMethodBeat.i(123398);
    Log.i("MicroMsg.ChooseMsgFileListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.qoU = q.a(this, getString(2131762446), true, 0, null);
      AppMethodBeat.o(123398);
      return;
    }
    if ((this.qoU != null) && (this.qoU.isShowing()))
    {
      this.qoU.dismiss();
      this.qoU = null;
    }
    AppMethodBeat.o(123398);
  }
  
  public final void D(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(123396);
    ku(false);
    Log.i("MicroMsg.ChooseMsgFileListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.gAp.setVisibility(0);
      this.mRecyclerView.setVisibility(8);
      this.gAp.setText(getString(2131757569));
      AppMethodBeat.o(123396);
      return;
    }
    this.gAp.setVisibility(8);
    this.mRecyclerView.setVisibility(0);
    this.mRecyclerView.getAdapter().atj.notifyChanged();
    AppMethodBeat.o(123396);
  }
  
  public final void cyJ()
  {
    AppMethodBeat.i(123399);
    MMHandlerThread.postToMainThread(new Runnable()
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
  
  public final com.tencent.mm.plugin.choosemsgfile.b.d.a cys()
  {
    return this.qoR;
  }
  
  public void finish()
  {
    AppMethodBeat.i(123394);
    super.finish();
    overridePendingTransition(2130772132, 2130772130);
    AppMethodBeat.o(123394);
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(123397);
    View localView = this.mRecyclerView.getChildAt(paramInt);
    AppMethodBeat.o(123397);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2131493648;
  }
  
  public final String getUserName()
  {
    return this.goe;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123390);
    this.gAp = ((TextView)findViewById(2131305538));
    this.mRecyclerView = ((RecyclerView)findViewById(2131300630));
    this.qoS = ((RelativeLayout)findViewById(2131301662));
    this.qoT = ((Button)findViewById(2131308778));
    AppMethodBeat.o(123390);
  }
  
  public final void kF(boolean paramBoolean)
  {
    AppMethodBeat.i(123395);
    ku(true);
    AppMethodBeat.o(123395);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123389);
    h.q(this);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772132, 2130772130);
    this.goe = getIntent().getStringExtra("USERNAME");
    this.qnT = com.tencent.mm.plugin.choosemsgfile.b.d.c.Ir(this.goe);
    this.mCount = getIntent().getIntExtra("COUNT", 9);
    this.qoP = getIntent().getStringExtra("EXTENSION");
    Log.i("MicroMsg.ChooseMsgFileListUI", "onCreate mCount:%d mExtension:%s", new Object[] { Integer.valueOf(this.mCount), this.qoP });
    this.qoQ = new e(this);
    initView();
    findViewById(2131299200).setBackgroundColor(getContext().getResources().getColor(2131100188));
    this.mRecyclerView.setBackgroundColor(getContext().getResources().getColor(2131100188));
    paramBundle = this.mRecyclerView;
    e locale = this.qoQ;
    if (locale.oDV == null) {
      locale.oDV = new LinearLayoutManager();
    }
    paramBundle.setLayoutManager(locale.oDV);
    this.mRecyclerView.a(new e.3(this.qoQ));
    this.mRecyclerView.setAdapter(this.qoQ.cyF());
    this.mRecyclerView.setHasFixedSize(true);
    setMMTitle(this.qnT);
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
    addTextOptionMenu(0, getString(2131755761), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123383);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("ERRMSG", "cancel");
        ChooseMsgFileListUI.this.setResult(1, paramAnonymousMenuItem);
        ChooseMsgFileListUI.this.finish();
        ChooseMsgFileListUI.this.overridePendingTransition(2130772132, 2130772130);
        AppMethodBeat.o(123383);
        return true;
      }
    });
    this.qoT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123385);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ChooseMsgFileListUI.a(ChooseMsgFileListUI.this).cyI())
        {
          paramAnonymousView = new f.a(ChooseMsgFileListUI.this);
          paramAnonymousView.bow(ChooseMsgFileListUI.this.getString(2131757565)).Dq(true);
          paramAnonymousView.c(new f.c()
          {
            public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(123384);
              Log.i("MicroMsg.ChooseMsgFileListUI", "bOk:%b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
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
    this.qoQ.fC("file", this.qoP);
    h.r(this);
    this.qoR.init(this.mCount);
    AppMethodBeat.o(123389);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123393);
    super.onDestroy();
    this.qoQ.onDestroy();
    this.qoR.uninit();
    AppMethodBeat.o(123393);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123392);
    super.onPause();
    this.qoQ.onPause();
    AppMethodBeat.o(123392);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123391);
    super.onResume();
    this.qoQ.onResume();
    AppMethodBeat.o(123391);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI
 * JD-Core Version:    0.7.0.1
 */