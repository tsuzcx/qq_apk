package com.tencent.mm.plugin.fav.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.a.a;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public abstract class FavBaseUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  protected ah dPi = new ah(Looper.getMainLooper());
  private HandlerThread jWm;
  protected ah jWn;
  private boolean kaW = false;
  protected boolean kaX = false;
  private boolean kaY = false;
  private long kaZ = 0L;
  protected ListView kba;
  protected TextView kbb;
  protected View kbc;
  private View kbd;
  protected c kbe;
  protected View kbf;
  protected l kbg;
  protected c.a kbh = null;
  private f kbi = new FavBaseUI.8(this);
  private f kbj = new FavBaseUI.9(this);
  private Runnable kbk = new Runnable()
  {
    public final void run()
    {
      a locala = FavBaseUI.this.aQX();
      locala.aRz();
      locala.aRA();
      FavBaseUI.this.aRc();
    }
  };
  protected Runnable kbl = new Runnable()
  {
    public final void run()
    {
      a locala = FavBaseUI.this.aQX();
      if ((!locala.isEmpty()) && (SystemClock.elapsedRealtime() - FavBaseUI.e(FavBaseUI.this) < 400L))
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.e(FavBaseUI.this)), Integer.valueOf(400) });
        FavBaseUI.this.dPi.postDelayed(this, 200L);
      }
      do
      {
        return;
        FavBaseUI.f(FavBaseUI.this);
        FavBaseUI.a(FavBaseUI.this, SystemClock.elapsedRealtime());
        com.tencent.mm.sdk.platformtools.y.v("MicroMsg.FavoriteBaseUI", "do refresh job");
        locala.notifyDataSetChanged();
        FavBaseUI.this.a(locala);
      } while (!FavBaseUI.this.kaX);
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
      FavBaseUI.this.kba.setSelection(0);
      FavBaseUI.this.kaX = false;
    }
  };
  private Runnable kbm = new FavBaseUI.2(this);
  private j.a kbn = new FavBaseUI.3(this);
  private final Object lockObj = new Object();
  
  private void fV(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.kbb == null) {
        this.kbb = ((TextView)((ViewStub)findViewById(n.e.empty_view_stub)).inflate().findViewById(n.e.empty_fav_view));
      }
      this.kbb.setVisibility(0);
    }
    while (this.kbb == null) {
      return;
    }
    this.kbb.setVisibility(8);
  }
  
  protected final void a(a parama)
  {
    if (parama == null) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
    }
    do
    {
      return;
      if (parama.isEmpty()) {
        if (aQZ())
        {
          fU(true);
          fV(false);
        }
      }
      while ((parama.isEmpty()) || (((ae)g.t(ae.class)).getFavItemInfoStorage().q(parama.aRx(), parama.getType())))
      {
        this.kba.removeFooterView(this.kbc);
        return;
        fU(false);
        fV(true);
        aRa();
        continue;
        fU(false);
        fV(false);
      }
    } while (this.kba.getFooterViewsCount() != 0);
    this.kba.addFooterView(this.kbc);
  }
  
  public abstract a aQX();
  
  protected abstract void aQY();
  
  protected abstract boolean aQZ();
  
  protected abstract void aRa();
  
  protected abstract View.OnClickListener aRb();
  
  protected void aRc()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
    this.dPi.removeCallbacks(this.kbl);
    this.dPi.post(this.kbl);
  }
  
  protected final void fU(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.kbd == null) {
        this.kbd = ((ViewStub)findViewById(n.e.empty_load_view_stub)).inflate();
      }
      this.kbd.setVisibility(0);
    }
    while (this.kbd == null) {
      return;
    }
    this.kbd.setVisibility(8);
  }
  
  protected final int getLayoutId()
  {
    return n.f.favorite_base_ui;
  }
  
  protected void initHeaderView()
  {
    this.kbe = new c(this.mController.uMN);
    this.kbe.setCleanFavSpace(this.kbh);
    this.kbe.gd(false);
    this.kbe.kju.setVisibility(8);
    this.kbe.kjv.setVisibility(8);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", new Object[] { Integer.valueOf(this.kbe.getPaddingTop()), Integer.valueOf(this.kbe.getPaddingBottom()) });
    this.kba.addHeaderView(this.kbe);
    this.kbf = View.inflate(this.mController.uMN, n.f.fav_type_header, null);
    TextView localTextView1 = (TextView)this.kbf.findViewById(n.e.fav_sub_url_tv);
    final TextView localTextView2 = (TextView)this.kbf.findViewById(n.e.fav_sub_image_tv);
    TextView localTextView3 = (TextView)this.kbf.findViewById(n.e.fav_sub_voice_tv);
    TextView localTextView4 = (TextView)this.kbf.findViewById(n.e.fav_sub_music_tv);
    TextView localTextView5 = (TextView)this.kbf.findViewById(n.e.fav_sub_location_tv);
    TextView localTextView6 = (TextView)this.kbf.findViewById(n.e.fav_sub_file_tv);
    final TextView localTextView7 = (TextView)this.kbf.findViewById(n.e.fav_sub_record_tv);
    TextView localTextView8 = (TextView)this.kbf.findViewById(n.e.fav_sub_note_tv);
    View.OnClickListener localOnClickListener = aRb();
    localTextView1.setOnClickListener(localOnClickListener);
    localTextView1.setTag(Integer.valueOf(5));
    localTextView2.setOnClickListener(localOnClickListener);
    localTextView2.setTag(Integer.valueOf(21));
    localTextView3.setOnClickListener(localOnClickListener);
    localTextView3.setTag(Integer.valueOf(3));
    localTextView4.setOnClickListener(localOnClickListener);
    localTextView4.setTag(Integer.valueOf(7));
    localTextView5.setOnClickListener(localOnClickListener);
    localTextView5.setTag(Integer.valueOf(6));
    localTextView6.setOnClickListener(localOnClickListener);
    localTextView6.setTag(Integer.valueOf(8));
    localTextView7.setOnClickListener(localOnClickListener);
    localTextView7.setTag(Integer.valueOf(17));
    localTextView8.setOnClickListener(localOnClickListener);
    localTextView8.setTag(Integer.valueOf(18));
    this.kbf.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        FavBaseUI.this.kbf.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = FavBaseUI.this.kbf.findViewById(n.e.fav_type_wrapper_layout1).getWidth() / 4;
        if ((i > 0) && (localTextView2.getWidth() < i))
        {
          localTextView2.setWidth(i);
          localTextView7.setWidth(i);
        }
      }
    });
    this.kba.addHeaderView(this.kbf);
  }
  
  protected final void initView()
  {
    long l = System.currentTimeMillis();
    this.kba = ((ListView)findViewById(n.e.favorite_lv));
    this.kba.setDrawingCacheEnabled(false);
    new FavBaseUI.4(this);
    initHeaderView();
    this.kbc = com.tencent.mm.ui.y.gt(this).inflate(n.f.fav_loading_footer, null);
    this.kba.setOnScrollListener(new FavBaseUI.5(this));
    this.kba.setOnItemClickListener(this);
    this.kba.setOnTouchListener(new FavBaseUI.6(this));
    this.kba.setAdapter(aQX());
    a(aQX());
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(g.DK()) });
    paramBundle = new ak();
    g.Dk().a(paramBundle, 0);
    ((ae)g.t(ae.class)).getFavItemInfoStorage().c(this.kbn);
    g.Dk().a(400, this.kbi);
    g.Dk().a(402, this.kbj);
    this.jWm = com.tencent.mm.sdk.f.e.aap(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.jWm.start();
    this.jWn = new ah(this.jWm.getLooper());
    this.kbg = new l(this.mController.uMN, 64);
    initView();
    ta(this.mController.uMN.getResources().getColor(n.b.normal_actionbar_color));
    if (bk.g((Integer)g.DP().Dz().get(8217, null)) == 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
      this.kaY = true;
      paramBundle = new aj();
      g.Dk().a(paramBundle, 0);
      if (this.kaY)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
        if ((aQX() == null) || (aQX().isEmpty())) {
          fU(true);
        }
        fV(false);
      }
    }
    for (;;)
    {
      ((ae)g.t(ae.class)).getFavCdnService().run();
      ((ae)g.t(ae.class)).getCheckCdnService().run();
      ((ae)g.t(ae.class)).getSendService().run();
      ((ae)g.t(ae.class)).getModService().run();
      g.DS().O(new FavBaseUI.1(this));
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      b.startSync();
      if (aQX().isEmpty())
      {
        fU(true);
        fV(false);
        this.kbc.setVisibility(8);
      }
      else
      {
        fU(false);
        fV(false);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (((ae)g.t(ae.class)).getFavItemInfoStorage().aQt() == null) {
      return;
    }
    this.kbg.destory();
    this.kbg = null;
    this.jWm.quit();
    ((ae)g.t(ae.class)).getFavItemInfoStorage().d(this.kbn);
    g.Dk().b(400, this.kbi);
    g.Dk().b(402, this.kbj);
  }
  
  protected void onPause()
  {
    super.onPause();
    aQX();
  }
  
  protected void onResume()
  {
    super.onResume();
    i.Ez(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI
 * JD-Core Version:    0.7.0.1
 */