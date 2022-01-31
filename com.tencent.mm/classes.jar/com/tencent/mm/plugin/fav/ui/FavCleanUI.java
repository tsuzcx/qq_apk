package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.d.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.d.a.c;
import com.tencent.mm.plugin.fav.ui.widget.a;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavCleanUI
  extends MMActivity
  implements a.c
{
  protected com.tencent.mm.sdk.platformtools.ak faV;
  private HandlerThread mqE;
  protected com.tencent.mm.sdk.platformtools.ak mqF;
  private Runnable mvG;
  protected Runnable mvH;
  private l mvR;
  private com.tencent.mm.plugin.fav.ui.a.b mvS;
  private ListView mvT;
  private TextView mvU;
  private a mvV;
  private boolean mvW;
  private int mvX;
  private d.a mvY;
  private f mvZ;
  private boolean mvs;
  protected boolean mvt;
  private long mvv;
  protected View mvy;
  private View mvz;
  
  public FavCleanUI()
  {
    AppMethodBeat.i(73961);
    this.mvs = false;
    this.faV = new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper());
    this.mvW = false;
    this.mvX = 0;
    this.mvY = new FavCleanUI.3(this);
    this.mvZ = new FavCleanUI.6(this);
    this.mvG = new FavCleanUI.7(this);
    this.mvv = 0L;
    this.mvt = false;
    this.mvH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(73960);
        if (FavCleanUI.e(FavCleanUI.this) == null)
        {
          AppMethodBeat.o(73960);
          return;
        }
        if ((!FavCleanUI.e(FavCleanUI.this).isEmpty()) && (SystemClock.elapsedRealtime() - FavCleanUI.h(FavCleanUI.this) < 1000L))
        {
          ab.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavCleanUI.h(FavCleanUI.this)), Integer.valueOf(1000) });
          FavCleanUI.this.faV.postDelayed(this, 500L);
          AppMethodBeat.o(73960);
          return;
        }
        FavCleanUI.i(FavCleanUI.this);
        FavCleanUI.a(FavCleanUI.this, SystemClock.elapsedRealtime());
        ab.v("MicroMsg.FavCleanUI", "do refresh job");
        FavCleanUI.d(FavCleanUI.this);
        if (FavCleanUI.this.mvt)
        {
          ab.v("MicroMsg.FavCleanUI", "do scroll to first");
          FavCleanUI.j(FavCleanUI.this).setSelection(0);
          FavCleanUI.this.mvt = false;
        }
        AppMethodBeat.o(73960);
      }
    };
    AppMethodBeat.o(73961);
  }
  
  private void fl(boolean paramBoolean)
  {
    AppMethodBeat.i(73969);
    if (paramBoolean)
    {
      this.mvz.setVisibility(8);
      this.mvU.setVisibility(0);
      this.mvT.removeFooterView(this.mvy);
      if (this.mvV != null)
      {
        this.mvV.hide();
        AppMethodBeat.o(73969);
      }
    }
    else
    {
      this.mvz.setVisibility(8);
      this.mvU.setVisibility(8);
      this.mvT.removeFooterView(this.mvy);
      if (this.mvV != null) {
        this.mvV.show();
      }
    }
    AppMethodBeat.o(73969);
  }
  
  private void hA(boolean paramBoolean)
  {
    AppMethodBeat.i(73970);
    if (paramBoolean)
    {
      if (this.mvT.getFooterViewsCount() == 0)
      {
        this.mvT.addFooterView(this.mvy);
        AppMethodBeat.o(73970);
      }
    }
    else {
      this.mvT.removeFooterView(this.mvy);
    }
    AppMethodBeat.o(73970);
  }
  
  protected final void bxq()
  {
    AppMethodBeat.i(73968);
    ab.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
    this.faV.removeCallbacks(this.mvH);
    this.faV.post(this.mvH);
    AppMethodBeat.o(73968);
  }
  
  public int getLayoutId()
  {
    return 2130969526;
  }
  
  public final void kf(long paramLong)
  {
    AppMethodBeat.i(73972);
    Object localObject = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramLong);
    if ((localObject != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.wVc.size() != 0))
    {
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.wVc.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
    if (this.mvS.mzx)
    {
      localObject = this.mvV;
      if (this.mvS.bxS() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (((a)localObject).mDP) {
          ((a)localObject).gBJ.setEnabled(bool);
        }
        localObject = this.mvV;
        List localList = this.mvS.hB(false);
        paramLong = this.mvS.bxT();
        if ((localList.size() == 0) || (paramLong <= 0L)) {
          break;
        }
        ((a)localObject).kIf.setText(((a)localObject).kIf.getContext().getString(2131299663, new Object[] { com.tencent.mm.plugin.fav.a.b.jS(paramLong) }));
        ((a)localObject).gBJ.setEnabled(true);
        AppMethodBeat.o(73972);
        return;
      }
      ((a)localObject).byq();
    }
    AppMethodBeat.o(73972);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(73967);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(73967);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(73971);
    finish();
    super.onBackPressed();
    AppMethodBeat.o(73971);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73962);
    super.onCreate(paramBundle);
    this.mvX = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
    this.mqE = com.tencent.mm.sdk.g.d.aqu(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.mqE.start();
    this.mqF = new com.tencent.mm.sdk.platformtools.ak(this.mqE.getLooper());
    this.mvT = ((ListView)findViewById(2131823998));
    setMMTitle(2131299668);
    this.mvW = true;
    paramBundle = new com.tencent.mm.plugin.fav.a.ak();
    com.tencent.mm.kernel.g.Rc().a(paramBundle, 0);
    com.tencent.mm.kernel.g.Rc().a(438, this.mvZ);
    setBackBtn(new FavCleanUI.1(this));
    paramBundle = (ViewStub)findViewById(2131823999);
    if (paramBundle != null) {}
    for (this.mvz = paramBundle.inflate();; this.mvz = findViewById(2131823726))
    {
      this.mvU = ((TextView)findViewById(2131823725));
      this.mvz.setVisibility(0);
      this.mvU.setVisibility(8);
      this.mvT.removeFooterView(this.mvy);
      if (this.mvV != null) {
        this.mvV.hide();
      }
      this.mvy = w.hM(this).inflate(2130969551, null);
      this.mvT.setOnScrollListener(new FavCleanUI.2(this));
      if (this.mvW)
      {
        this.mvV = new a();
        paramBundle = this.mvV;
        View localView = findViewById(2131823995);
        paramBundle.mDP = false;
        paramBundle.mDQ = localView;
        this.mvV.mDR = new FavCleanUI.5(this);
        this.mvW = false;
      }
      com.tencent.mm.plugin.fav.a.d.bwj().a(this.mvY);
      AppMethodBeat.o(73962);
      return;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(73964);
    ab.d("MicroMsg.FavCleanUI", "on create options menu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(73964);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73963);
    super.onDestroy();
    com.tencent.mm.plugin.fav.a.d locald = com.tencent.mm.plugin.fav.a.d.bwj();
    d.a locala = this.mvY;
    if (locald.msR.contains(locala)) {
      locald.msR.remove(locala);
    }
    if (this.mvR != null)
    {
      this.mvR.destory();
      this.mvR = null;
    }
    if (this.mvS != null) {
      this.mvS.finish();
    }
    this.mqE.quit();
    com.tencent.mm.kernel.g.Rc().b(438, this.mvZ);
    AppMethodBeat.o(73963);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(73965);
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(73965);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73966);
    super.onResume();
    AppMethodBeat.o(73966);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI
 * JD-Core Version:    0.7.0.1
 */