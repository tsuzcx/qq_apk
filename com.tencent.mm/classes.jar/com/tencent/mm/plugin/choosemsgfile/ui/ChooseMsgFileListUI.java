package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.a.b;
import com.tencent.mm.plugin.choosemsgfile.a.e;
import com.tencent.mm.plugin.choosemsgfile.a.f;
import com.tencent.mm.plugin.choosemsgfile.a.h;
import com.tencent.mm.plugin.choosemsgfile.logic.c.c;
import com.tencent.mm.plugin.choosemsgfile.logic.ui.e.3;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;

public class ChooseMsgFileListUI
  extends MMActivity
  implements e
{
  private TextView lMW;
  private String luk;
  private int mCount;
  private RecyclerView mRecyclerView;
  private String wPR;
  private String wQO;
  private com.tencent.mm.plugin.choosemsgfile.logic.ui.e wQP;
  private com.tencent.mm.plugin.choosemsgfile.logic.c.a wQQ;
  private RelativeLayout wQR;
  private Button wQS;
  private ProgressDialog wQT;
  
  public ChooseMsgFileListUI()
  {
    AppMethodBeat.i(123388);
    this.wQQ = new com.tencent.mm.plugin.choosemsgfile.logic.c.a();
    AppMethodBeat.o(123388);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, int paramInt, String paramString2, com.tencent.mm.choosemsgfile.compat.a.a parama)
  {
    AppMethodBeat.i(123400);
    Intent localIntent = new Intent(paramMMActivity, ChooseMsgFileListUI.class);
    localIntent.putExtra("USERNAME", paramString1);
    localIntent.putExtra("COUNT", paramInt);
    localIntent.putExtra("EXTENSION", paramString2);
    paramMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(123387);
        Log.i("MicroMsg.ChooseMsgFileListUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Log.d("MicroMsg.ChooseMsgFileListUI", "data:%s", new Object[] { paramAnonymousIntent });
        c.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, ChooseMsgFileListUI.this);
        AppMethodBeat.o(123387);
      }
    });
    paramMMActivity.startActivityForResult(localIntent, com.tencent.mm.plugin.choosemsgfile.logic.c.b.wQM);
    AppMethodBeat.o(123400);
  }
  
  private void na(boolean paramBoolean)
  {
    AppMethodBeat.i(123398);
    Log.i("MicroMsg.ChooseMsgFileListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.wQT = w.a(this, getString(a.h.loading_tips), true, 0, null);
      AppMethodBeat.o(123398);
      return;
    }
    if ((this.wQT != null) && (this.wQT.isShowing()))
    {
      this.wQT.dismiss();
      this.wQT = null;
    }
    AppMethodBeat.o(123398);
  }
  
  public final void F(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(123396);
    na(false);
    Log.i("MicroMsg.ChooseMsgFileListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.lMW.setVisibility(0);
      this.mRecyclerView.setVisibility(8);
      this.lMW.setText(getString(a.h.choose_msg_file_no_content));
      AppMethodBeat.o(123396);
      return;
    }
    this.lMW.setVisibility(8);
    this.mRecyclerView.setVisibility(0);
    this.mRecyclerView.getAdapter().bZE.notifyChanged();
    AppMethodBeat.o(123396);
  }
  
  public final void dqK()
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
  
  public final com.tencent.mm.plugin.choosemsgfile.logic.c.a dqs()
  {
    return this.wQQ;
  }
  
  public void finish()
  {
    AppMethodBeat.i(123394);
    super.finish();
    overridePendingTransition(com.tencent.mm.plugin.choosemsgfile.a.a.push_up_in, com.tencent.mm.plugin.choosemsgfile.a.a.push_down_out);
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
    return a.f.choose_msg_file_list_ui;
  }
  
  public final String getUserName()
  {
    return this.luk;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123390);
    this.lMW = ((TextView)findViewById(a.e.nothing));
    this.mRecyclerView = ((RecyclerView)findViewById(a.e.file_recyclerview));
    this.wQR = ((RelativeLayout)findViewById(a.e.footer_bar));
    this.wQS = ((Button)findViewById(a.e.sure));
    AppMethodBeat.o(123390);
  }
  
  public final void nm(boolean paramBoolean)
  {
    AppMethodBeat.i(123395);
    na(true);
    AppMethodBeat.o(123395);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123389);
    h.w(this);
    super.onCreate(paramBundle);
    overridePendingTransition(com.tencent.mm.plugin.choosemsgfile.a.a.push_up_in, com.tencent.mm.plugin.choosemsgfile.a.a.push_down_out);
    this.luk = getIntent().getStringExtra("USERNAME");
    this.wPR = c.ID(this.luk);
    this.mCount = getIntent().getIntExtra("COUNT", 9);
    this.wQO = getIntent().getStringExtra("EXTENSION");
    Log.i("MicroMsg.ChooseMsgFileListUI", "onCreate mCount:%d mExtension:%s", new Object[] { Integer.valueOf(this.mCount), this.wQO });
    this.wQP = new com.tencent.mm.plugin.choosemsgfile.logic.ui.e(this);
    initView();
    findViewById(a.e.content_history).setBackgroundColor(getContext().getResources().getColor(a.b.choose_msg_file_list_ui_bg));
    this.mRecyclerView.setBackgroundColor(getContext().getResources().getColor(a.b.choose_msg_file_list_ui_bg));
    paramBundle = this.mRecyclerView;
    com.tencent.mm.plugin.choosemsgfile.logic.ui.e locale = this.wQP;
    if (locale.uQP == null) {
      locale.uQP = new LinearLayoutManager();
    }
    paramBundle.setLayoutManager(locale.uQP);
    this.mRecyclerView.a(new e.3(this.wQP));
    this.mRecyclerView.setAdapter(this.wQP.dqG());
    this.mRecyclerView.setHasFixedSize(true);
    setMMTitle(this.wPR);
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
    addTextOptionMenu(0, getString(a.h.app_cancel), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123383);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("ERRMSG", "cancel");
        ChooseMsgFileListUI.this.setResult(1, paramAnonymousMenuItem);
        ChooseMsgFileListUI.this.finish();
        ChooseMsgFileListUI.this.overridePendingTransition(com.tencent.mm.plugin.choosemsgfile.a.a.push_up_in, com.tencent.mm.plugin.choosemsgfile.a.a.push_down_out);
        AppMethodBeat.o(123383);
        return true;
      }
    });
    this.wQS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123385);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/ui/ChooseMsgFileListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ChooseMsgFileListUI.a(ChooseMsgFileListUI.this).dqJ())
        {
          paramAnonymousView = new g.a(ChooseMsgFileListUI.this);
          paramAnonymousView.bDE(ChooseMsgFileListUI.this.getString(a.h.choose_msg_file_downing_slogan)).NF(true);
          paramAnonymousView.c(new g.c()
          {
            public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
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
    this.wQP.gp("file", this.wQO);
    h.x(this);
    this.wQQ.sE(this.mCount);
    AppMethodBeat.o(123389);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123393);
    super.onDestroy();
    this.wQP.onDestroy();
    this.wQQ.uninit();
    AppMethodBeat.o(123393);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123392);
    super.onPause();
    this.wQP.onPause();
    AppMethodBeat.o(123392);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123391);
    super.onResume();
    this.wQP.onResume();
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