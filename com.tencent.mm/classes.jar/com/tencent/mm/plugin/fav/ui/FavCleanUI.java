package com.tencent.mm.plugin.fav.ui;

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
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.a.d.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.d.a.c;
import com.tencent.mm.plugin.fav.ui.widget.a;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavCleanUI
  extends MMActivity
  implements a.c
{
  protected ah dPi = new ah(Looper.getMainLooper());
  private HandlerThread jWm;
  protected ah jWn;
  private boolean kaW = false;
  protected boolean kaX = false;
  private long kaZ = 0L;
  private boolean kbA = false;
  private int kbB = 0;
  private d.a kbC = new FavCleanUI.3(this);
  private f kbD = new FavCleanUI.6(this);
  protected View kbc;
  private View kbd;
  private Runnable kbk = new FavCleanUI.7(this);
  protected Runnable kbl = new Runnable()
  {
    public final void run()
    {
      if (FavCleanUI.e(FavCleanUI.this) == null) {}
      do
      {
        return;
        if ((!FavCleanUI.e(FavCleanUI.this).isEmpty()) && (SystemClock.elapsedRealtime() - FavCleanUI.h(FavCleanUI.this) < 1000L))
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavCleanUI.h(FavCleanUI.this)), Integer.valueOf(1000) });
          FavCleanUI.this.dPi.postDelayed(this, 500L);
          return;
        }
        FavCleanUI.i(FavCleanUI.this);
        FavCleanUI.a(FavCleanUI.this, SystemClock.elapsedRealtime());
        com.tencent.mm.sdk.platformtools.y.v("MicroMsg.FavCleanUI", "do refresh job");
        FavCleanUI.d(FavCleanUI.this);
      } while (!FavCleanUI.this.kaX);
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.FavCleanUI", "do scroll to first");
      FavCleanUI.j(FavCleanUI.this).setSelection(0);
      FavCleanUI.this.kaX = false;
    }
  };
  private l kbv;
  private com.tencent.mm.plugin.fav.ui.a.b kbw;
  private ListView kbx;
  private TextView kby;
  private a kbz;
  
  private void dR(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.kbd.setVisibility(8);
      this.kby.setVisibility(0);
      this.kbx.removeFooterView(this.kbc);
      if (this.kbz != null) {
        this.kbz.hide();
      }
    }
    do
    {
      return;
      this.kbd.setVisibility(8);
      this.kby.setVisibility(8);
      this.kbx.removeFooterView(this.kbc);
    } while (this.kbz == null);
    this.kbz.show();
  }
  
  private void fW(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.kbx.getFooterViewsCount() == 0) {
        this.kbx.addFooterView(this.kbc);
      }
      return;
    }
    this.kbx.removeFooterView(this.kbc);
  }
  
  protected final void aRc()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
    this.dPi.removeCallbacks(this.kbl);
    this.dPi.post(this.kbl);
  }
  
  public final void eI(long paramLong)
  {
    Object localObject = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramLong);
    if ((localObject != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.sXc.size() != 0))
    {
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.sXc.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramLong = ((xv)((Iterator)localObject).next()).sVb;
      }
    }
    if (this.kbw.keO)
    {
      localObject = this.kbz;
      if (this.kbw.aRC() <= 0) {
        break label217;
      }
    }
    label217:
    for (boolean bool = true;; bool = false)
    {
      if (((a)localObject).kjj) {
        ((a)localObject).fks.setEnabled(bool);
      }
      localObject = this.kbz;
      List localList = this.kbw.fX(false);
      paramLong = this.kbw.aRD();
      if ((localList.size() == 0) || (paramLong <= 0L)) {
        break;
      }
      ((a)localObject).iCY.setText(((a)localObject).iCY.getContext().getString(n.i.fav_clean_delete_info, new Object[] { com.tencent.mm.plugin.fav.a.b.ev(paramLong) }));
      ((a)localObject).fks.setEnabled(true);
      return;
    }
    ((a)localObject).aRZ();
  }
  
  protected final int getLayoutId()
  {
    return n.f.fav_clean_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    finish();
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.kbB = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
    this.jWm = e.aap(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.jWm.start();
    this.jWn = new ah(this.jWm.getLooper());
    this.kbx = ((ListView)findViewById(n.e.fav_clean_list));
    setMMTitle(n.i.fav_clean_title);
    this.kbA = true;
    paramBundle = new ak();
    com.tencent.mm.kernel.g.Dk().a(paramBundle, 0);
    com.tencent.mm.kernel.g.Dk().a(438, this.kbD);
    setBackBtn(new FavCleanUI.1(this));
    paramBundle = (ViewStub)findViewById(n.e.empty_load_view_stub);
    if (paramBundle != null) {}
    for (this.kbd = paramBundle.inflate();; this.kbd = findViewById(n.e.favorite_loading))
    {
      this.kby = ((TextView)findViewById(n.e.empty_fav_view));
      this.kbd.setVisibility(0);
      this.kby.setVisibility(8);
      this.kbx.removeFooterView(this.kbc);
      if (this.kbz != null) {
        this.kbz.hide();
      }
      this.kbc = com.tencent.mm.ui.y.gt(this).inflate(n.f.fav_loading_footer, null);
      this.kbx.setOnScrollListener(new FavCleanUI.2(this));
      if (this.kbA)
      {
        this.kbz = new a();
        paramBundle = this.kbz;
        View localView = findViewById(n.e.fav_clean_footer);
        paramBundle.kjj = false;
        paramBundle.kjk = localView;
        this.kbz.kjl = new FavCleanUI.5(this);
        this.kbA = false;
      }
      d.aPV().a(this.kbC);
      return;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.FavCleanUI", "on create options menu");
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    d locald = d.aPV();
    d.a locala = this.kbC;
    if (locald.jYx.contains(locala)) {
      locald.jYx.remove(locala);
    }
    if (this.kbv != null)
    {
      this.kbv.destory();
      this.kbv = null;
    }
    if (this.kbw != null) {
      this.kbw.finish();
    }
    this.jWm.quit();
    com.tencent.mm.kernel.g.Dk().b(438, this.kbD);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI
 * JD-Core Version:    0.7.0.1
 */