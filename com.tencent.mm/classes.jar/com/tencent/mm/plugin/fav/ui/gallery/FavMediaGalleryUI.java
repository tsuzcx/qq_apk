package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavMediaGalleryUI
  extends MMActivity
  implements AdapterView.OnItemSelectedListener, com.tencent.mm.plugin.fav.a.p
{
  private boolean bTT = true;
  private j gGp;
  private ArrayList<com.tencent.mm.plugin.fav.ui.f> hgv;
  private int hkH = 0;
  private MMGestureGallery itv;
  private n.d jfN = new FavMediaGalleryUI.8(this);
  private Map<String, nb> kbT = new HashMap();
  private long kbU;
  private com.tencent.mm.sdk.b.c kbV = new com.tencent.mm.sdk.b.c() {};
  private int khb = -1;
  private FavVideoView khc = null;
  private FavMediaGalleryUI.a khd;
  private List<FavVideoView> khe = new ArrayList();
  yl khf = new yl();
  
  private void xO()
  {
    Object localObject1 = getIntent().getLongArrayExtra("KEY_MEDIA_FAVID_LIST");
    ArrayList localArrayList = new ArrayList();
    String str = getIntent().getStringExtra("key_detail_data_id");
    this.kbU = getIntent().getLongExtra("key_detail_info_id", -1L);
    Object localObject2;
    long l;
    boolean bool1;
    if (localObject1 == null)
    {
      boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
      localObject2 = getIntent().getStringExtra("fav_note_xml");
      localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(this.kbU);
      l = this.kbU;
      if (localObject1 != null)
      {
        bool1 = true;
        y.i("MicroMsg.FavMediaGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
        if ((!bool2) || (bk.bl((String)localObject2))) {
          break label558;
        }
        localObject1 = b.CB((String)localObject2);
      }
    }
    label555:
    label558:
    for (;;)
    {
      if (localObject1 != null) {
        localArrayList.add(localObject1);
      }
      label182:
      this.hgv.clear();
      int i = -1;
      int m = localArrayList.size();
      int k = 0;
      label202:
      int j;
      if (k < m)
      {
        localObject1 = (com.tencent.mm.plugin.fav.a.g)localArrayList.get(k);
        int n = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.sXc.size();
        j = 0;
        label236:
        if (j < n)
        {
          localObject2 = (xv)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.sXc.get(j);
          if (((((xv)localObject2).aYU == 8) && (!com.tencent.mm.sdk.platformtools.o.Za(b.b((xv)localObject2)))) || ((((xv)localObject2).aYU != 2) && (((xv)localObject2).aYU != 4) && (((xv)localObject2).aYU != 15) && (((xv)localObject2).aYU != 8))) {
            break label555;
          }
          com.tencent.mm.plugin.fav.ui.f localf = new com.tencent.mm.plugin.fav.ui.f((com.tencent.mm.plugin.fav.a.g)localObject1, (xv)localObject2);
          this.hgv.add(localf);
          if ((str == null) || (!str.equals(((xv)localObject2).kgC)) || (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId != this.kbU)) {
            break label555;
          }
          i = this.hgv.size() - 1;
        }
      }
      for (;;)
      {
        j += 1;
        break label236;
        bool1 = false;
        break;
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          l = localObject1[i];
          localObject2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(l);
          if ((localObject2 != null) && (!localArrayList.contains(localObject2))) {
            localArrayList.add(localObject2);
          }
          i += 1;
        }
        break label182;
        j = i;
        if (str == null)
        {
          j = i;
          if (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId == this.kbU) {
            j = this.hgv.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label202;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.khd.notifyDataSetChanged();
        this.itv.post(new FavMediaGalleryUI.9(this, i));
        return;
      }
    }
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    if (paramc != null)
    {
      com.tencent.mm.plugin.fav.ui.f localf = this.khd.rb(this.hkH);
      if ((localf != null) && (bk.aM(paramc.field_dataId, "").equals(localf.bNt.kgC)) && (localf.bNt.aYU == 2)) {
        ai.d(new FavMediaGalleryUI.10(this, paramc));
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return n.f.fav_img_gallery_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.tencent.mm.plugin.fav.ui.f localf;
    Object localObject;
    String str;
    com.tencent.mm.ui.base.p localp;
    if (1 == paramInt1)
    {
      if (-1 != paramInt2) {
        return;
      }
      localf = this.khd.rb(this.hkH);
      if (localf == null)
      {
        y.i("MicroMsg.FavMediaGalleryUI", "dataItem is null.");
        return;
      }
      localObject = b.b(localf.bNt);
      new k();
      if (k.u(localf.kbR))
      {
        h.bC(this.mController.uMN, getString(n.i.Fav_NotDownload_CannotForward));
        return;
      }
      str = paramIntent.getStringExtra("Select_Conv_User");
      y.d("MicroMsg.FavMediaGalleryUI", "select %s for sending", new Object[] { str });
      localp = h.b(this.mController.uMN, getString(n.i.favorite_forward_tips), false, null);
      if (!com.tencent.mm.sdk.platformtools.o.Za((String)localObject)) {
        break label181;
      }
      i.a(this.mController.uMN, str, localf.kbR, localf.bNt, new FavMediaGalleryUI.11(this, localp));
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label181:
      localObject = new FavMediaGalleryUI.2(this, localp);
      i.a(this, str, localf.bNt, (Runnable)localObject);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    this.bTT = getIntent().getBooleanExtra("show_share", true);
    this.itv = ((MMGestureGallery)findViewById(n.e.gallery));
    this.itv.setVerticalFadingEdgeEnabled(false);
    this.itv.setHorizontalFadingEdgeEnabled(false);
    this.itv.setOnItemSelectedListener(this);
    this.itv.setSingleClickOverListener(new FavMediaGalleryUI.1(this));
    if (this.bTT) {
      this.itv.setLongClickOverListener(new MMGestureGallery.c()
      {
        public final void aRg()
        {
          if ((!FavMediaGalleryUI.this.isFinishing()) && (!FavMediaGalleryUI.this.uMr)) {
            FavMediaGalleryUI.a(FavMediaGalleryUI.this);
          }
        }
      });
    }
    fullScreenNoTitleBar(true);
    this.hgv = new ArrayList();
    this.khd = new FavMediaGalleryUI.a(this, (byte)0);
    this.itv.setAdapter(this.khd);
    xO();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        FavMediaGalleryUI.this.finish();
        return true;
      }
    });
    com.tencent.mm.sdk.b.a.udP.c(this.kbV);
    setResult(0, getIntent());
    this.khf.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
    this.khf.jYS = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
    this.khf.index = getIntent().getIntExtra("key_detail_fav_index", 0);
    this.khf.bVk = getIntent().getStringExtra("key_detail_fav_query");
    this.khf.bIB = getIntent().getStringExtra("key_detail_fav_sessionid");
    this.khf.jYU = getIntent().getStringExtra("key_detail_fav_tags");
    yl localyl = this.khf;
    if (this.khf.bVk == null)
    {
      paramBundle = "";
      localyl.bVk = paramBundle;
      localyl = this.khf;
      if (this.khf.bIB != null) {
        break label381;
      }
      paramBundle = "";
      label340:
      localyl.bIB = paramBundle;
      localyl = this.khf;
      if (this.khf.jYU != null) {
        break label392;
      }
    }
    label392:
    for (paramBundle = "";; paramBundle = this.khf.jYU)
    {
      localyl.jYU = paramBundle;
      return;
      paramBundle = this.khf.bVk;
      break;
      label381:
      paramBundle = this.khf.bIB;
      break label340;
    }
  }
  
  protected void onDestroy()
  {
    getIntent().putExtra("key_activity_browse_time", czu());
    com.tencent.mm.sdk.b.a.udP.d(this.kbV);
    Iterator localIterator = this.khe.iterator();
    while (localIterator.hasNext())
    {
      FavVideoView localFavVideoView = (FavVideoView)localIterator.next();
      if (localFavVideoView != null) {
        localFavVideoView.onDestroy();
      }
    }
    super.onDestroy();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.hkH = paramInt;
    y.d("MicroMsg.FavMediaGalleryUI", "pos:" + paramInt);
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).cAy();
    }
    if (this.khc != null) {
      this.khc.onDestroy();
    }
    if ((paramView instanceof FavVideoView))
    {
      paramAdapterView = (FavVideoView)paramView;
      if (((this.khd.getItemViewType(paramInt) == 15) || (this.khd.getItemViewType(paramInt) == 4)) && (paramAdapterView != null)) {
        if (paramAdapterView.iuC != null) {
          break label126;
        }
      }
    }
    label126:
    for (boolean bool = false;; bool = paramAdapterView.iuC.isPlaying())
    {
      if (!bool)
      {
        paramAdapterView.onResume();
        this.khc = paramAdapterView;
        this.khb = paramInt;
      }
      return;
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  protected void onPause()
  {
    super.onPause();
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().b(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(2);
  }
  
  protected void onResume()
  {
    super.onResume();
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI
 * JD-Core Version:    0.7.0.1
 */