package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.c.a;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  implements g.b
{
  private RecyclerView acI;
  Activity bMV;
  public long dFe = 0L;
  public int dmY;
  private TextView drL;
  public long ekk = 0L;
  private yl khf;
  public g.a khh;
  TextView khi;
  private ProgressDialog khj;
  public boolean khk = false;
  public int khl = -1;
  boolean khm = true;
  public View khn;
  public a kho = new c.1(this);
  private int khp;
  private TextView khq;
  private TextView khr;
  private View.OnClickListener khs = new c.4(this);
  private View.OnClickListener kht = new c.5(this);
  private View.OnClickListener khu = new c.6(this);
  public List<d> khv = new ArrayList();
  
  public c(Activity paramActivity, View paramView)
  {
    this.bMV = paramActivity;
    this.khn = paramView;
    this.khk = true;
    g.c localc = g.c.kib;
    paramView = null;
    switch (c.7.khz[localc.ordinal()])
    {
    }
    for (paramActivity = paramView;; paramActivity = new h(paramActivity))
    {
      paramActivity.a(this);
      this.khf = new yl();
      this.khf.scene = 2;
      this.khf.jYS = 2;
      this.khf.index = 0;
      this.khf.bIB = "";
      this.khf.bVk = "";
      this.khf.jYU = "";
      this.khq = ((TextView)this.khn.findViewById(n.e.trans_btn));
      this.khq.setTag(Integer.valueOf(0));
      this.khq.setOnClickListener(this.khu);
      this.khr = ((TextView)this.khn.findViewById(n.e.select_btn));
      this.khr.setOnClickListener(this.khs);
      this.khi = ((TextView)this.khn.findViewById(n.e.album_tips_bar));
      this.drL = ((TextView)this.khn.findViewById(n.e.search_nothing_hint));
      this.acI = ((RecyclerView)this.khn.findViewById(n.e.history_recycler_view));
      this.acI.setLayoutManager(this.khh.aRV());
      this.acI.a(this.khh.df(this.bMV));
      this.acI.setAdapter(this.khh.aRW());
      ((f)this.khh.aRX()).khf = this.khf;
      this.acI.setHasFixedSize(true);
      this.acI.setOnScrollListener(new c.2(this));
      this.acI.a(new c.3(this));
      return;
    }
  }
  
  private void gb(boolean paramBoolean)
  {
    y.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.khj = p.b(this.bMV, this.bMV.getString(n.i.loading_tips), true, 0, null);
    }
    while ((this.khj == null) || (!this.khj.isShowing())) {
      return;
    }
    this.khj.dismiss();
    this.khj = null;
  }
  
  public final void aRO()
  {
    this.khh.aRO();
    this.khr.setText(n.i.fav_filter_img_video_cancel_select);
    this.khq.setText(this.bMV.getString(n.i.transmit_btn));
    this.khq.setVisibility(0);
    this.khr.setOnClickListener(this.kht);
  }
  
  public final void aRP()
  {
    this.khh.aRP();
    this.khr.setText(n.i.fav_filter_img_video_select);
    this.khq.setVisibility(8);
    this.khr.setOnClickListener(this.khs);
  }
  
  public final void bv(List<d> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    this.khv.clear();
    this.khv.addAll(paramList);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("mutil_select_is_ret", true);
    String str2;
    label123:
    int i;
    if (this.khv.size() == 1)
    {
      d locald = (d)paramList.get(0);
      String str1 = b.c(locald.bNH);
      str2 = b.b(locald.bNH);
      if (e.bK(str1))
      {
        localIntent.putExtra("image_path", str1);
        if ((!locald.aRR()) && (!locald.aRQ())) {
          break label223;
        }
        i = 1;
        label141:
        localIntent.putExtra("Retr_Msg_Type", i);
        localIntent.putExtra("select_is_ret", true);
      }
    }
    for (;;)
    {
      com.tencent.mm.br.d.c(this.bMV, ".ui.transmit.SelectConversationUI", localIntent, 1);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        com.tencent.mm.plugin.fav.a.h.f(((d)paramList.next()).khA.field_localId, 1, 0);
      }
      break;
      localIntent.putExtra("image_path", str2);
      break label123;
      label223:
      i = 0;
      break label141;
      localIntent.putExtra("scene_from", 1);
      localIntent.putExtra("Retr_Msg_Type", 17);
      localIntent.putExtra("select_fav_select_count", this.khv.size());
    }
  }
  
  public final void ga(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      gb(true);
      return;
    }
    this.khp = ((GridLayoutManager)this.acI.getLayoutManager()).ha();
  }
  
  public final void k(boolean paramBoolean, int paramInt)
  {
    y.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.khl) });
    if (paramBoolean)
    {
      gb(false);
      this.acI.getAdapter().agL.notifyChanged();
      if (this.khl > 0)
      {
        if (this.khl % 4 == 0) {
          this.khl += 1;
        }
        this.acI.bE(this.khl);
      }
      while (paramInt <= 0)
      {
        this.drL.setVisibility(0);
        this.acI.setVisibility(8);
        this.drL.setText(this.bMV.getString(n.i.fav_filter_img_video_noting_hint));
        return;
        int i = this.acI.getAdapter().getItemCount();
        this.acI.bE(i - 1);
      }
      this.drL.setVisibility(8);
      this.acI.setVisibility(0);
      return;
    }
    if (paramInt > 0)
    {
      this.acI.getAdapter().agL.notifyChanged();
      return;
    }
    this.acI.getAdapter().bL(0);
  }
  
  public final void re(int paramInt)
  {
    if (paramInt > 0)
    {
      this.khq.setText(this.bMV.getString(n.i.transmit_btn) + "(" + paramInt + ")");
      return;
    }
    this.khq.setText(this.bMV.getString(n.i.transmit_btn));
  }
  
  public final void setVisibility(int paramInt)
  {
    this.khn.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c
 * JD-Core Version:    0.7.0.1
 */