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
import com.tencent.mm.plugin.choosemsgfile.b.d.a;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public class ChooseMsgFileListUI
  extends MMActivity
  implements c
{
  private RecyclerView alu;
  private String foE;
  private TextView fzM;
  private int mCount;
  private String ooX;
  private String opU;
  private e opV;
  private a opW;
  private RelativeLayout opX;
  private Button opY;
  private ProgressDialog opZ;
  
  public ChooseMsgFileListUI()
  {
    AppMethodBeat.i(123388);
    this.opW = new a();
    AppMethodBeat.o(123388);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, int paramInt, String paramString2, a.a parama)
  {
    AppMethodBeat.i(123400);
    Intent localIntent = new Intent(paramMMActivity, ChooseMsgFileListUI.class);
    localIntent.putExtra("USERNAME", paramString1);
    localIntent.putExtra("COUNT", paramInt);
    localIntent.putExtra("EXTENSION", paramString2);
    paramMMActivity.mmSetOnActivityResultCallback(new ChooseMsgFileListUI.5(parama));
    paramMMActivity.startActivityForResult(localIntent, b.opS);
    AppMethodBeat.o(123400);
  }
  
  private void ji(boolean paramBoolean)
  {
    AppMethodBeat.i(123398);
    ac.i("MicroMsg.ChooseMsgFileListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.opZ = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(123398);
      return;
    }
    if ((this.opZ != null) && (this.opZ.isShowing()))
    {
      this.opZ.dismiss();
      this.opZ = null;
    }
    AppMethodBeat.o(123398);
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(123396);
    ji(false);
    ac.i("MicroMsg.ChooseMsgFileListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.fzM.setVisibility(0);
      this.alu.setVisibility(8);
      this.fzM.setText(getString(2131757352));
      AppMethodBeat.o(123396);
      return;
    }
    this.fzM.setVisibility(8);
    this.alu.setVisibility(0);
    this.alu.getAdapter().arg.notifyChanged();
    AppMethodBeat.o(123396);
  }
  
  public final a bUH()
  {
    return this.opW;
  }
  
  public final void bVa()
  {
    AppMethodBeat.i(123399);
    ap.f(new Runnable()
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
    View localView = this.alu.getChildAt(paramInt);
    AppMethodBeat.o(123397);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2131493536;
  }
  
  public final String getUserName()
  {
    return this.foE;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123390);
    this.fzM = ((TextView)findViewById(2131302951));
    this.alu = ((RecyclerView)findViewById(2131299926));
    this.opX = ((RelativeLayout)findViewById(2131300197));
    this.opY = ((Button)findViewById(2131305557));
    AppMethodBeat.o(123390);
  }
  
  public final void js(boolean paramBoolean)
  {
    AppMethodBeat.i(123395);
    ji(true);
    AppMethodBeat.o(123395);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123389);
    g.o(this);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772108, 2130772106);
    this.foE = getIntent().getStringExtra("USERNAME");
    this.ooX = com.tencent.mm.plugin.choosemsgfile.b.d.c.wj(this.foE);
    this.mCount = getIntent().getIntExtra("COUNT", 9);
    this.opU = getIntent().getStringExtra("EXTENSION");
    ac.i("MicroMsg.ChooseMsgFileListUI", "onCreate mCount:%d mExtension:%s", new Object[] { Integer.valueOf(this.mCount), this.opU });
    this.opV = new e(this);
    initView();
    findViewById(2131298757).setBackgroundColor(getContext().getResources().getColor(2131100155));
    this.alu.setBackgroundColor(getContext().getResources().getColor(2131100155));
    paramBundle = this.alu;
    e locale = this.opV;
    if (locale.mOk == null) {
      locale.mOk = new LinearLayoutManager();
    }
    paramBundle.setLayoutManager(locale.mOk);
    this.alu.a(new e.3(this.opV));
    this.alu.setAdapter(this.opV.bUV());
    this.alu.setHasFixedSize(true);
    setMMTitle(this.ooX);
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
    this.opY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123385);
        if (ChooseMsgFileListUI.a(ChooseMsgFileListUI.this).bUZ())
        {
          paramAnonymousView = new f.a(ChooseMsgFileListUI.this);
          paramAnonymousView.aRQ(ChooseMsgFileListUI.this.getString(2131757348)).yi(true);
          paramAnonymousView.c(new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(123384);
              ac.i("MicroMsg.ChooseMsgFileListUI", "bOk:%b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
              if (paramAnonymous2Boolean) {
                ChooseMsgFileListUI.b(ChooseMsgFileListUI.this);
              }
              AppMethodBeat.o(123384);
            }
          }).show();
          AppMethodBeat.o(123385);
          return;
        }
        ChooseMsgFileListUI.b(ChooseMsgFileListUI.this);
        AppMethodBeat.o(123385);
      }
    });
    this.opV.eX("file", this.opU);
    g.p(this);
    this.opW.init(this.mCount);
    AppMethodBeat.o(123389);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123393);
    super.onDestroy();
    this.opV.onDestroy();
    this.opW.uninit();
    AppMethodBeat.o(123393);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123392);
    super.onPause();
    this.opV.onPause();
    AppMethodBeat.o(123392);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123391);
    super.onResume();
    this.opV.onResume();
    AppMethodBeat.o(123391);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI
 * JD-Core Version:    0.7.0.1
 */