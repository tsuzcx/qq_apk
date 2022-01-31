package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.choosemsgfile.b.c.e;
import com.tencent.mm.plugin.choosemsgfile.b.c.e.3;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.p;

public class ChooseMsgFileListUI
  extends MMActivity
  implements a
{
  private RecyclerView adt;
  private String eaX;
  private TextView ejt;
  private String kEW;
  private String kFT;
  private e kFU;
  private com.tencent.mm.plugin.choosemsgfile.b.d.a kFV;
  private RelativeLayout kFW;
  private Button kFX;
  private ProgressDialog kFY;
  private int mCount;
  
  public ChooseMsgFileListUI()
  {
    AppMethodBeat.i(54417);
    this.kFV = new com.tencent.mm.plugin.choosemsgfile.b.d.a();
    AppMethodBeat.o(54417);
  }
  
  public static void b(MMActivity paramMMActivity, String paramString1, int paramInt, String paramString2, a.a parama)
  {
    AppMethodBeat.i(54429);
    Intent localIntent = new Intent(paramMMActivity, ChooseMsgFileListUI.class);
    localIntent.putExtra("USERNAME", paramString1);
    localIntent.putExtra("COUNT", paramInt);
    localIntent.putExtra("EXTENSION", paramString2);
    paramMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(54416);
        ab.i("MicroMsg.ChooseMsgFileListUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        ab.d("MicroMsg.ChooseMsgFileListUI", "data:%s", new Object[] { paramAnonymousIntent });
        b.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, this.kEq);
        AppMethodBeat.o(54416);
      }
    });
    paramMMActivity.startActivityForResult(localIntent, 291);
    AppMethodBeat.o(54429);
  }
  
  private void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(54427);
    ab.i("MicroMsg.ChooseMsgFileListUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.kFY = p.b(this, getString(2131301086), true, null);
      AppMethodBeat.o(54427);
      return;
    }
    if ((this.kFY != null) && (this.kFY.isShowing()))
    {
      this.kFY.dismiss();
      this.kFY = null;
    }
    AppMethodBeat.o(54427);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(54428);
    al.d(new ChooseMsgFileListUI.4(this));
    AppMethodBeat.o(54428);
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.b.d.a bgl()
  {
    return this.kFV;
  }
  
  public void finish()
  {
    AppMethodBeat.i(54423);
    super.finish();
    overridePendingTransition(2131034230, 2131034228);
    AppMethodBeat.o(54423);
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(54426);
    View localView = this.adt.getChildAt(paramInt);
    AppMethodBeat.o(54426);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2130969154;
  }
  
  public final String getUserName()
  {
    return this.eaX;
  }
  
  public final void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(54424);
    fV(true);
    AppMethodBeat.o(54424);
  }
  
  public void initView()
  {
    AppMethodBeat.i(54419);
    this.ejt = ((TextView)findViewById(2131822816));
    this.adt = ((RecyclerView)findViewById(2131822817));
    this.kFW = ((RelativeLayout)findViewById(2131822818));
    this.kFX = ((Button)findViewById(2131822819));
    AppMethodBeat.o(54419);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(54418);
    f.m(this);
    super.onCreate(paramBundle);
    overridePendingTransition(2131034230, 2131034228);
    this.eaX = getIntent().getStringExtra("USERNAME");
    this.kEW = b.nD(this.eaX);
    this.mCount = getIntent().getIntExtra("COUNT", 9);
    this.kFT = getIntent().getStringExtra("EXTENSION");
    ab.i("MicroMsg.ChooseMsgFileListUI", "onCreate mCount:%d mExtension:%s", new Object[] { Integer.valueOf(this.mCount), this.kFT });
    this.kFU = new e(this);
    initView();
    findViewById(2131821514).setBackgroundColor(-1);
    this.adt.setBackgroundColor(-1);
    paramBundle = this.adt;
    e locale = this.kFU;
    if (locale.jvX == null) {
      locale.jvX = new LinearLayoutManager();
    }
    paramBundle.setLayoutManager(locale.jvX);
    this.adt.a(new e.3(this.kFU));
    this.adt.setAdapter(this.kFU.bgz());
    this.adt.setHasFixedSize(true);
    setMMTitle(this.kEW);
    setBackBtn(new ChooseMsgFileListUI.1(this));
    addTextOptionMenu(0, getString(2131296888), new ChooseMsgFileListUI.2(this));
    this.kFX.setOnClickListener(new ChooseMsgFileListUI.3(this));
    this.kFU.dA("file", this.kFT);
    f.n(this);
    this.kFV.init(this.mCount);
    AppMethodBeat.o(54418);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(54422);
    super.onDestroy();
    this.kFU.onDestroy();
    this.kFV.uninit();
    AppMethodBeat.o(54422);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(54421);
    super.onPause();
    this.kFU.onPause();
    AppMethodBeat.o(54421);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(54420);
    super.onResume();
    this.kFU.onResume();
    AppMethodBeat.o(54420);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void s(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(54425);
    fV(false);
    ab.i("MicroMsg.ChooseMsgFileListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      this.ejt.setVisibility(0);
      this.adt.setVisibility(8);
      this.ejt.setText(getString(2131298359));
      AppMethodBeat.o(54425);
      return;
    }
    this.ejt.setVisibility(8);
    this.adt.setVisibility(0);
    this.adt.getAdapter().ajb.notifyChanged();
    AppMethodBeat.o(54425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI
 * JD-Core Version:    0.7.0.1
 */