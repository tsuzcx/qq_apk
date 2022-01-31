package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.choosemsgfile.b.c.f.4;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;

public class ChooseMsgFileUI
  extends MMActivity
  implements a
{
  private String eaX;
  private TextView ejt;
  private String kEW;
  private String kFT;
  private com.tencent.mm.plugin.choosemsgfile.b.d.a kFV;
  private RelativeLayout kFW;
  private Button kFX;
  private ProgressDialog kFY;
  private com.tencent.mm.plugin.choosemsgfile.b.c.f kGd;
  private TextView kGe;
  private RecyclerView kGf;
  private TextView kGg;
  private TextView kGh;
  private ImageButton kGi;
  private TextView kGj;
  private boolean kGk;
  private int kGl;
  private int mCount;
  private String mType;
  
  public ChooseMsgFileUI()
  {
    AppMethodBeat.i(54457);
    this.kFV = new com.tencent.mm.plugin.choosemsgfile.b.d.a();
    this.kGk = true;
    AppMethodBeat.o(54457);
  }
  
  private void Ja(String paramString)
  {
    AppMethodBeat.i(54463);
    if (("image".equals(paramString)) || ("all".equals(paramString)))
    {
      this.kGi.setVisibility(0);
      this.kGj.setVisibility(0);
    }
    while ("all".equals(this.mType))
    {
      this.kGg.setVisibility(0);
      this.kGh.setVisibility(0);
      Jb(paramString);
      AppMethodBeat.o(54463);
      return;
      this.kGi.setVisibility(4);
      this.kGj.setVisibility(4);
    }
    this.kGg.setVisibility(4);
    this.kGh.setVisibility(4);
    AppMethodBeat.o(54463);
  }
  
  private void Jb(String paramString)
  {
    AppMethodBeat.i(54464);
    if ("all".equals(paramString))
    {
      this.kGh.setText("");
      AppMethodBeat.o(54464);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    if ("image".equals(paramString)) {
      localStringBuilder.append(getString(2131298363));
    }
    for (;;)
    {
      localStringBuilder.append(")");
      this.kGh.setText(localStringBuilder.toString());
      AppMethodBeat.o(54464);
      return;
      if ("video".equals(paramString)) {
        localStringBuilder.append(getString(2131298364));
      } else if ("file".equals(paramString)) {
        localStringBuilder.append(getString(2131298362));
      }
    }
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, String paramString2, int paramInt, String paramString3, a.a parama)
  {
    AppMethodBeat.i(54470);
    Intent localIntent = new Intent(paramMMActivity, ChooseMsgFileUI.class);
    localIntent.putExtra("USERNAME", paramString1);
    localIntent.putExtra("TYPE", paramString2);
    localIntent.putExtra("COUNT", paramInt);
    localIntent.putExtra("EXTENSION", paramString3);
    paramMMActivity.mmSetOnActivityResultCallback(new ChooseMsgFileUI.4(parama));
    paramMMActivity.startActivityForResult(localIntent, 291);
    AppMethodBeat.o(54470);
  }
  
  private void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(54466);
    ab.i("MicroMsg.ChooseMsgFileUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.kFY = p.b(this, getString(2131301086), true, null);
      AppMethodBeat.o(54466);
      return;
    }
    if ((this.kFY != null) && (this.kFY.isShowing()))
    {
      this.kFY.dismiss();
      this.kFY = null;
    }
    AppMethodBeat.o(54466);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(54468);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(54446);
        Button localButton = ChooseMsgFileUI.k(ChooseMsgFileUI.this);
        if (ChooseMsgFileUI.a(ChooseMsgFileUI.this).getSelectCount() > 0) {}
        for (boolean bool = true;; bool = false)
        {
          localButton.setEnabled(bool);
          AppMethodBeat.o(54446);
          return;
        }
      }
    });
    AppMethodBeat.o(54468);
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.b.d.a bgl()
  {
    return this.kFV;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(54469);
    View localView = this.kGf.getChildAt(paramInt);
    AppMethodBeat.o(54469);
    return localView;
  }
  
  public int getLayoutId()
  {
    return 2130969155;
  }
  
  public final String getUserName()
  {
    return this.eaX;
  }
  
  public final void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(54465);
    if (paramBoolean)
    {
      gg(true);
      AppMethodBeat.o(54465);
      return;
    }
    this.kGl = ((GridLayoutManager)this.kGf.getLayoutManager()).iv();
    AppMethodBeat.o(54465);
  }
  
  public void initView()
  {
    AppMethodBeat.i(54462);
    this.ejt = ((TextView)findViewById(2131822816));
    this.kGe = ((TextView)findViewById(2131820789));
    this.kGf = ((RecyclerView)findViewById(2131822817));
    this.kFW = ((RelativeLayout)findViewById(2131822818));
    this.kGg = ((TextView)findViewById(2131822821));
    this.kGh = ((TextView)findViewById(2131822822));
    this.kGi = ((ImageButton)findViewById(2131822823));
    this.kGj = ((TextView)findViewById(2131822824));
    this.kFX = ((Button)findViewById(2131822819));
    AppMethodBeat.o(54462);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(54458);
    com.tencent.mm.pluginsdk.f.m(this);
    super.onCreate(paramBundle);
    this.eaX = getIntent().getStringExtra("USERNAME");
    this.kEW = b.nD(this.eaX);
    this.mType = b.IY(getIntent().getStringExtra("TYPE"));
    this.mCount = getIntent().getIntExtra("COUNT", 9);
    this.kFT = getIntent().getStringExtra("EXTENSION");
    ab.i("MicroMsg.ChooseMsgFileUI", "select msg file from username:%s nickname:%s, type:%s, count:%d", new Object[] { this.eaX, this.kEW, this.mType, Integer.valueOf(this.mCount) });
    ab.i("MicroMsg.ChooseMsgFileUI", "select msg file from extension:%s", new Object[] { this.kFT });
    this.kFV.init(this.mCount);
    this.kGd = new com.tencent.mm.plugin.choosemsgfile.b.c.f(this);
    initView();
    this.kGf.setLayoutManager(this.kGd.bgA());
    this.kGf.a(new f.4(this.kGd, this));
    this.kGf.setAdapter(this.kGd.bgz());
    this.kGf.setHasFixedSize(true);
    this.kGf.a(new ChooseMsgFileUI.2(this));
    setMMTitle(this.kEW);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(54440);
        ChooseMsgFileUI.this.finish();
        AppMethodBeat.o(54440);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131296888), new ChooseMsgFileUI.5(this));
    this.kGi.setOnClickListener(new ChooseMsgFileUI.6(this));
    this.kGj.setOnClickListener(new ChooseMsgFileUI.7(this));
    this.kGg.setOnClickListener(new ChooseMsgFileUI.8(this));
    this.kGh.setOnClickListener(new ChooseMsgFileUI.9(this));
    this.kFX.setOnClickListener(new ChooseMsgFileUI.10(this));
    this.kGd.dA(this.mType, this.kFT);
    Ja(this.mType);
    com.tencent.mm.pluginsdk.f.n(this);
    AppMethodBeat.o(54458);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(54461);
    super.onDestroy();
    this.kGd.onDestroy();
    this.kFV.uninit();
    AppMethodBeat.o(54461);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(54460);
    super.onPause();
    ab.i("MicroMsg.ChooseMsgFileUIController", "onPause");
    AppMethodBeat.o(54460);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(54459);
    super.onResume();
    this.kGd.onResume();
    AppMethodBeat.o(54459);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void s(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(54467);
    ab.i("MicroMsg.ChooseMsgFileUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      gg(false);
      this.kGf.getAdapter().ajb.notifyChanged();
      int i = this.kGf.getAdapter().getItemCount();
      this.kGf.bJ(i - 1);
      if (paramInt <= 0)
      {
        this.ejt.setVisibility(0);
        this.kGf.setVisibility(8);
        this.ejt.setText(getString(2131298359));
        AppMethodBeat.o(54467);
        return;
      }
      this.ejt.setVisibility(8);
      this.kGf.setVisibility(0);
      AppMethodBeat.o(54467);
      return;
    }
    if (paramInt > 0)
    {
      this.kGf.getAdapter().ap(0, paramInt);
      this.kGf.getAdapter().an(paramInt, this.kGl + paramInt);
      AppMethodBeat.o(54467);
      return;
    }
    this.kGf.getAdapter().bR(0);
    AppMethodBeat.o(54467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI
 * JD-Core Version:    0.7.0.1
 */