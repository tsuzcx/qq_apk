package com.tencent.mm.plugin.fav.ui.gallery;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.ui.f;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.List;

final class FavMediaGalleryUI$a
  extends BaseAdapter
{
  SparseBooleanArray kbZ = new SparseBooleanArray();
  
  private FavMediaGalleryUI$a(FavMediaGalleryUI paramFavMediaGalleryUI) {}
  
  private Bitmap a(f paramf)
  {
    if (paramf != null)
    {
      paramf = l.a(paramf.bNt, paramf.kbR);
      if (paramf != null) {
        return paramf;
      }
    }
    return com.tencent.mm.compatible.g.a.decodeResource(this.khg.getResources(), n.h.download_image_icon);
  }
  
  private void a(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
  {
    paramb.frw.setVisibility(8);
    paramb.kcd.setVisibility(8);
    paramb.kcc.setVisibility(8);
    paramb.kca.setVisibility(0);
    paramb.kce.setVisibility(8);
    b(paramb, paramBitmap, paramString);
  }
  
  private void b(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
  {
    k.o(paramb.kcb, paramBitmap.getWidth(), paramBitmap.getHeight());
    int i = paramb.kcb.getWidth();
    int j = paramb.kcb.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
    float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
    y.v("MicroMsg.FavMediaGalleryUI", "whDiv is " + f1 + " hwDiv is " + f2);
    if ((f2 >= 2.0F) && (paramBitmap.getHeight() >= 480))
    {
      f1 = paramBitmap.getWidth() / i;
      f2 = i / paramBitmap.getWidth();
      if (f1 > 1.0D)
      {
        localMatrix.postScale(f2, f2);
        paramBitmap.getHeight();
        localMatrix.postTranslate((i - f2 * paramBitmap.getWidth()) / 2.0F, 0.0F);
      }
    }
    for (;;)
    {
      paramb.kcb.setImageMatrix(localMatrix);
      paramb.kcb.fs(paramBitmap.getWidth(), paramBitmap.getHeight());
      paramb.kcb.setMaxZoomDoubleTab(true);
      if (!bk.bl(paramString)) {
        break label521;
      }
      paramb.kcb.setImageBitmap(paramBitmap);
      return;
      localMatrix.postScale(1.0F, 1.0F);
      localMatrix.postTranslate((i - paramBitmap.getWidth()) / 2, 0.0F);
      continue;
      if ((f1 < 2.0F) || (paramBitmap.getWidth() < 480)) {
        break;
      }
      f1 = paramBitmap.getHeight() / 480.0F;
      f2 = 480.0F / paramBitmap.getHeight();
      if (f1 > 1.0D)
      {
        localMatrix.postScale(f1, f2);
        localMatrix.postTranslate(0.0F, (j - 480) / 2);
      }
      else
      {
        localMatrix.postScale(1.0F, 1.0F);
        f1 = (j - paramBitmap.getHeight()) / 2;
        y.d("MicroMsg.FavMediaGalleryUI", " offsety " + f1);
        localMatrix.postTranslate(0.0F, f1);
      }
    }
    f1 = i / paramBitmap.getWidth();
    f2 = j / paramBitmap.getHeight();
    label422:
    float f3;
    if (f1 < f2)
    {
      f2 = paramBitmap.getWidth() / i;
      f3 = paramBitmap.getHeight() / j;
      if (f2 <= f3) {
        break label514;
      }
      label452:
      if (f2 <= 1.0D) {
        break label620;
      }
      localMatrix.postScale(f1, f1);
    }
    for (;;)
    {
      localMatrix.postTranslate((i - paramBitmap.getWidth() * f1) / 2.0F, (j - f1 * paramBitmap.getHeight()) / 2.0F);
      break;
      f1 = f2;
      break label422;
      label514:
      f2 = f3;
      break label452;
      try
      {
        label521:
        paramString = new d(paramString);
        paramb.kcb.setGifDrawable(paramString);
        paramb.kcb.ft(com.tencent.mm.cb.a.fj(this.khg.mController.uMN), com.tencent.mm.cb.a.fk(this.khg.mController.uMN));
        paramb.kcb.fs(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
        paramb.kcb.start();
        paramb.kcb.cBl();
        return;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.FavMediaGalleryUI", bk.j(paramString));
        paramb.kcb.setImageBitmap(paramBitmap);
        return;
      }
      label620:
      f1 = 1.0F;
    }
  }
  
  public final int getCount()
  {
    return FavMediaGalleryUI.h(this.khg).size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt > FavMediaGalleryUI.h(this.khg).size()) {
      return 2;
    }
    return ((f)FavMediaGalleryUI.h(this.khg).get(paramInt)).bNt.aYU;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    f localf = rb(paramInt);
    if ((localf.bNt.aYU == 15) || (localf.bNt.aYU == 4))
    {
      if (paramView != null) {
        break label1136;
      }
      paramView = new FavVideoView(this.khg.mController.uMN);
      FavMediaGalleryUI.i(this.khg).add((FavVideoView)paramView);
    }
    label281:
    label859:
    label867:
    label1136:
    for (;;)
    {
      paramViewGroup = (FavVideoView)paramView;
      paramViewGroup.kgy.setVisibility(8);
      Object localObject1 = b.b(localf.bNt);
      if (e.bK((String)localObject1))
      {
        paramViewGroup.setVideoData((String)localObject1);
        localObject1 = b.c(localf.bNt);
        if (!e.bK((String)localObject1)) {
          break label281;
        }
        paramViewGroup.setThumbView((String)localObject1);
      }
      Object localObject2;
      for (;;)
      {
        return paramView;
        localObject2 = localf.bNt.kgC;
        c localc = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN((String)localObject2);
        if ((localc != null) && (localc.field_status == 1)) {
          break;
        }
        if ((!bk.bl(localf.bNt.sUG)) && (!bk.bl(localf.bNt.sUI)))
        {
          y.d("MicroMsg.FavMediaGalleryUI", "getView, no video, start download, dataId:%s", new Object[] { localObject2 });
          b.a(localf.kbR, localf.bNt, true);
          paramViewGroup.a((String)localObject1, true, (String)localObject2);
          break;
        }
        y.d("MicroMsg.FavMediaGalleryUI", "getView, no video, cdn data invalid");
        paramViewGroup.a((String)localObject1, false, (String)localObject2);
        paramViewGroup.kgy.setVisibility(0);
        break;
        y.i("MicroMsg.FavMediaGalleryUI", "getView, no thumb, start download, path:%s", new Object[] { localObject1 });
        b.a(localf.kbR, localf.bNt);
      }
      if (paramView == null)
      {
        paramViewGroup = new FavMediaGalleryUI.b(this.khg, (byte)0);
        paramView = View.inflate(this.khg.mController.uMN, n.f.fav_img_detail_item, null);
        paramViewGroup.kca = paramView.findViewById(n.e.image_gallery_download_success);
        paramViewGroup.kcb = ((MultiTouchImageView)paramView.findViewById(n.e.image));
        paramViewGroup.frw = ((ProgressBar)paramView.findViewById(n.e.downloading_pb));
        paramViewGroup.kcc = ((ImageView)paramView.findViewById(n.e.thumb_iv));
        paramViewGroup.kcd = ((TextView)paramView.findViewById(n.e.downloading_percent_tv));
        paramViewGroup.kce = ((LinearLayout)paramView.findViewById(n.e.fav_expired_btn));
        paramViewGroup.kcf = ((TextView)paramView.findViewById(n.e.fav_expired_btn_text));
        paramViewGroup.kcf.setText(n.i.favorite_detail_illegal_expired_image);
        paramView.setTag(paramViewGroup);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        boolean bool = this.kbZ.get(paramInt, true);
        this.kbZ.put(paramInt, false);
        localObject1 = l.a(localf.bNt, localf.kbR, bool);
        if (localf.kbR != null) {
          y.i("MicroMsg.FavMediaGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localf.kbR.field_id), Long.valueOf(localf.kbR.field_localId), Integer.valueOf(localf.kbR.field_itemStatus) });
        }
        if (localf.bNt != null) {
          y.i("MicroMsg.FavMediaGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { localf.bNt.kgC, localf.bNt.sUG, localf.bNt.sUI, Long.valueOf(localf.bNt.sVb), localf.bNt.dQL, localf.bNt.sUC, Long.valueOf(localf.bNt.sVm) });
        }
        if (localObject1 != null) {
          break label1085;
        }
        this.khg.enableOptionMenu(false);
        y.w("MicroMsg.FavMediaGalleryUI", "get big image fail");
        localObject2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage();
        if (localf.bNt == null) {
          break label859;
        }
      }
      for (localObject1 = localf.bNt.kgC;; localObject1 = "")
      {
        localObject1 = ((q)localObject2).CN((String)localObject1);
        if (localObject1 != null) {
          break label937;
        }
        paramViewGroup.kce.setVisibility(8);
        if ((localf.kbR == null) || (localf.kbR.field_id >= 0)) {
          break label867;
        }
        paramViewGroup.frw.setVisibility(0);
        paramViewGroup.kcd.setVisibility(0);
        paramViewGroup.kcc.setVisibility(0);
        paramViewGroup.kca.setVisibility(8);
        paramViewGroup.kcc.setImageBitmap(a(localf));
        paramViewGroup.frw.setProgress(0);
        paramViewGroup.kcd.setText("0%");
        return paramView;
        paramViewGroup = (FavMediaGalleryUI.b)paramView.getTag();
        break;
      }
      paramViewGroup.frw.setVisibility(8);
      paramViewGroup.kcd.setVisibility(8);
      paramViewGroup.kcc.setVisibility(8);
      paramViewGroup.kca.setVisibility(0);
      if (localf.bNt.sVO != 0) {
        paramViewGroup.kce.setVisibility(0);
      }
      b(paramViewGroup, a(localf), "");
      return paramView;
      y.i("MicroMsg.FavMediaGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((c)localObject1).field_status) });
      paramViewGroup.frw.setVisibility(0);
      paramViewGroup.kcd.setVisibility(0);
      paramViewGroup.kcc.setVisibility(0);
      paramViewGroup.kca.setVisibility(8);
      paramViewGroup.kcc.setImageBitmap(a(localf));
      if (((c)localObject1).field_totalLen > 0) {}
      for (paramInt = ((c)localObject1).field_offset * 100 / ((c)localObject1).field_totalLen - 1;; paramInt = 0)
      {
        int i = paramInt;
        if (paramInt < 0) {
          i = 0;
        }
        paramViewGroup.frw.setProgress(i);
        paramViewGroup.kcd.setText(i + "%");
        return paramView;
      }
      this.khg.enableOptionMenu(true);
      if (o.Za(b.b(localf.bNt)))
      {
        a(paramViewGroup, (Bitmap)localObject1, b.b(localf.bNt));
        return paramView;
      }
      a(paramViewGroup, (Bitmap)localObject1, "");
      return paramView;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final f rb(int paramInt)
  {
    if (paramInt >= FavMediaGalleryUI.h(this.khg).size())
    {
      y.w("MicroMsg.FavMediaGalleryUI", "get item fail, position %d error", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    return (f)FavMediaGalleryUI.h(this.khg).get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.a
 * JD-Core Version:    0.7.0.1
 */