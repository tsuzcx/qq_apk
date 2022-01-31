package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavImgGalleryUI
  extends MMActivity
  implements AdapterView.OnItemSelectedListener, com.tencent.mm.plugin.fav.a.p
{
  private boolean bTT = true;
  private j gGp;
  private ArrayList<f> hgv;
  private int hkH = 0;
  private MMGestureGallery itv;
  private n.d jfN = new FavImgGalleryUI.7(this);
  private FavImgGalleryUI.a kbS;
  private Map<String, nb> kbT = new HashMap();
  private long kbU;
  private com.tencent.mm.sdk.b.c kbV = new FavImgGalleryUI.2(this);
  
  public static void a(String paramString1, String paramString2, Context paramContext)
  {
    if (bk.bl(paramString1)) {
      y.w("MicroMsg.FavImgGalleryUI", "save image fail, path is null");
    }
    while (com.tencent.mm.platformtools.q.a(paramString1, paramContext, n.i.cropimage_saved)) {
      return;
    }
    Toast.makeText(paramContext, paramString2, 1).show();
  }
  
  private void xO()
  {
    this.kbU = getIntent().getLongExtra("key_detail_info_id", -1L);
    String str = getIntent().getStringExtra("key_detail_data_id");
    boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    Object localObject = getIntent().getStringExtra("fav_note_xml");
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.fav.a.g localg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(this.kbU);
    long l = this.kbU;
    boolean bool1;
    if (localg != null)
    {
      bool1 = true;
      y.i("MicroMsg.FavImgGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
      if ((!bool2) || (bk.bl((String)localObject))) {
        break label435;
      }
      localg = b.CB((String)localObject);
    }
    label432:
    label435:
    for (;;)
    {
      if (localg != null) {
        localArrayList.add(localg);
      }
      this.hgv.clear();
      int i = -1;
      int m = localArrayList.size();
      int k = 0;
      label185:
      int j;
      if (k < m)
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localArrayList.get(k);
        int n = localg.field_favProto.sXc.size();
        j = 0;
        label219:
        if (j < n)
        {
          localObject = (xv)localg.field_favProto.sXc.get(j);
          if (((((xv)localObject).aYU == 8) && (!com.tencent.mm.sdk.platformtools.o.Za(b.b((xv)localObject)))) || ((((xv)localObject).aYU != 2) && (((xv)localObject).aYU != 8))) {
            break label432;
          }
          f localf = new f(localg, (xv)localObject);
          this.hgv.add(localf);
          if ((str == null) || (!str.equals(((xv)localObject).kgC))) {
            break label432;
          }
          i = this.hgv.size() - 1;
        }
      }
      for (;;)
      {
        j += 1;
        break label219;
        bool1 = false;
        break;
        j = i;
        if (str == null)
        {
          j = i;
          if (localg.field_localId == this.kbU) {
            j = this.hgv.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label185;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.kbS.notifyDataSetChanged();
        this.itv.post(new FavImgGalleryUI.8(this, i));
        return;
      }
    }
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    if (paramc != null)
    {
      y.v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", new Object[] { Integer.valueOf(paramc.field_status) });
      f localf = this.kbS.rb(this.hkH);
      if ((localf != null) && (bk.aM(paramc.field_dataId, "").equals(localf.bNt.kgC))) {
        ai.d(new FavImgGalleryUI.9(this, paramc));
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return n.f.fav_img_gallery_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (1 == paramInt1)
    {
      if (-1 != paramInt2) {
        return;
      }
      f localf = this.kbS.rb(this.hkH);
      if (localf == null)
      {
        y.i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
        return;
      }
      new k();
      if (k.u(localf.kbR))
      {
        h.bC(this.mController.uMN, getString(n.i.Fav_NotDownload_CannotForward));
        return;
      }
      String str = paramIntent.getStringExtra("Select_Conv_User");
      y.d("MicroMsg.FavImgGalleryUI", "select %s for sending", new Object[] { str });
      com.tencent.mm.ui.base.p localp = h.b(this.mController.uMN, getString(n.i.favorite_forward_tips), false, null);
      i.a(this.mController.uMN, str, localf.kbR, localf.bNt, new FavImgGalleryUI.10(this, localp));
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
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
    this.itv.setSingleClickOverListener(new FavImgGalleryUI.1(this));
    if (this.bTT) {
      this.itv.setLongClickOverListener(new FavImgGalleryUI.3(this));
    }
    fullScreenNoTitleBar(true);
    this.hgv = new ArrayList();
    this.kbS = new FavImgGalleryUI.a(this, (byte)0);
    this.itv.setAdapter(this.kbS);
    xO();
    setBackBtn(new FavImgGalleryUI.4(this));
    com.tencent.mm.sdk.b.a.udP.c(this.kbV);
    setResult(0, getIntent());
  }
  
  protected void onDestroy()
  {
    getIntent().putExtra("key_activity_browse_time", czu());
    com.tencent.mm.sdk.b.a.udP.d(this.kbV);
    super.onDestroy();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.hkH = paramInt;
    y.d("MicroMsg.FavImgGalleryUI", "pos:" + paramInt);
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).cAy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI
 * JD-Core Version:    0.7.0.1
 */