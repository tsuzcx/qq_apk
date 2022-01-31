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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.ui.f;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.util.ArrayList;
import java.util.List;

final class FavMediaGalleryUI$a
  extends BaseAdapter
{
  SparseBooleanArray mwz;
  
  private FavMediaGalleryUI$a(FavMediaGalleryUI paramFavMediaGalleryUI)
  {
    AppMethodBeat.i(74519);
    this.mwz = new SparseBooleanArray();
    AppMethodBeat.o(74519);
  }
  
  private Bitmap a(f paramf)
  {
    AppMethodBeat.i(74525);
    if (paramf != null)
    {
      paramf = l.a(paramf.cuL, paramf.mwn);
      if (paramf != null)
      {
        AppMethodBeat.o(74525);
        return paramf;
      }
    }
    paramf = com.tencent.mm.compatible.g.a.decodeResource(this.mBV.getResources(), 2131231253);
    AppMethodBeat.o(74525);
    return paramf;
  }
  
  private void a(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(74524);
    paramb.progressBar.setVisibility(8);
    paramb.mwG.setVisibility(8);
    paramb.mwF.setVisibility(8);
    paramb.mwD.setVisibility(0);
    paramb.mwH.setVisibility(8);
    b(paramb, paramBitmap, paramString);
    AppMethodBeat.o(74524);
  }
  
  private void b(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(74526);
    n.x(paramb.mwE, paramBitmap.getWidth(), paramBitmap.getHeight());
    int i = paramb.mwE.getWidth();
    int j = paramb.mwE.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
    float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
    ab.v("MicroMsg.FavMediaGalleryUI", "whDiv is " + f1 + " hwDiv is " + f2);
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
      paramb.mwE.setImageMatrix(localMatrix);
      paramb.mwE.cb(paramBitmap.getWidth(), paramBitmap.getHeight());
      paramb.mwE.setMaxZoomDoubleTab(true);
      if (!bo.isNullOrNil(paramString)) {
        break label524;
      }
      paramb.mwE.setImageBitmap(paramBitmap);
      AppMethodBeat.o(74526);
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
        ab.d("MicroMsg.FavMediaGalleryUI", " offsety ".concat(String.valueOf(f1)));
        localMatrix.postTranslate(0.0F, f1);
      }
    }
    f1 = i / paramBitmap.getWidth();
    f2 = j / paramBitmap.getHeight();
    label425:
    float f3;
    if (f1 < f2)
    {
      f2 = paramBitmap.getWidth() / i;
      f3 = paramBitmap.getHeight() / j;
      if (f2 <= f3) {
        break label517;
      }
      label455:
      if (f2 <= 1.0D) {
        break label627;
      }
      localMatrix.postScale(f1, f1);
    }
    for (;;)
    {
      localMatrix.postTranslate((i - paramBitmap.getWidth() * f1) / 2.0F, (j - f1 * paramBitmap.getHeight()) / 2.0F);
      break;
      f1 = f2;
      break label425;
      label517:
      f2 = f3;
      break label455;
      try
      {
        label524:
        paramString = new d(paramString);
        paramb.mwE.setGifDrawable(paramString);
        paramb.mwE.hz(com.tencent.mm.cb.a.gw(this.mBV.getContext()), com.tencent.mm.cb.a.gx(this.mBV.getContext()));
        paramb.mwE.cb(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
        paramb.mwE.start();
        paramb.mwE.dEA();
        AppMethodBeat.o(74526);
        return;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.FavMediaGalleryUI", bo.l(paramString));
        paramb.mwE.setImageBitmap(paramBitmap);
        AppMethodBeat.o(74526);
        return;
      }
      label627:
      f1 = 1.0F;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(74521);
    int i = FavMediaGalleryUI.h(this.mBV).size();
    AppMethodBeat.o(74521);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(74520);
    if (paramInt > FavMediaGalleryUI.h(this.mBV).size())
    {
      AppMethodBeat.o(74520);
      return 2;
    }
    paramInt = ((f)FavMediaGalleryUI.h(this.mBV).get(paramInt)).cuL.dataType;
    AppMethodBeat.o(74520);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(74523);
    f localf = vX(paramInt);
    if ((localf.cuL.dataType == 15) || (localf.cuL.dataType == 4))
    {
      if (paramView != null) {
        break label1162;
      }
      paramView = new FavVideoView(this.mBV.getContext());
      FavMediaGalleryUI.i(this.mBV).add((FavVideoView)paramView);
    }
    label1162:
    for (;;)
    {
      paramViewGroup = (FavVideoView)paramView;
      paramViewGroup.mBk.setVisibility(8);
      Object localObject1 = b.b(localf.cuL);
      if (e.cN((String)localObject1))
      {
        paramViewGroup.setVideoData((String)localObject1);
        localObject1 = b.c(localf.cuL);
        if (!e.cN((String)localObject1)) {
          break label290;
        }
        paramViewGroup.setThumbView((String)localObject1);
      }
      Object localObject2;
      for (;;)
      {
        AppMethodBeat.o(74523);
        return paramView;
        localObject2 = localf.cuL.mBq;
        c localc = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP((String)localObject2);
        if ((localc != null) && (localc.field_status == 1)) {
          break;
        }
        if ((!bo.isNullOrNil(localf.cuL.wSC)) && (!bo.isNullOrNil(localf.cuL.wSE)))
        {
          ab.d("MicroMsg.FavMediaGalleryUI", "getView, no video, start download, dataId:%s", new Object[] { localObject2 });
          b.a(localf.mwn, localf.cuL, true);
          paramViewGroup.a((String)localObject1, true, (String)localObject2);
          break;
        }
        ab.d("MicroMsg.FavMediaGalleryUI", "getView, no video, cdn data invalid");
        paramViewGroup.a((String)localObject1, false, (String)localObject2);
        paramViewGroup.mBk.setVisibility(0);
        break;
        label290:
        ab.i("MicroMsg.FavMediaGalleryUI", "getView, no thumb, start download, path:%s", new Object[] { localObject1 });
        b.a(localf.mwn, localf.cuL);
      }
      if (paramView == null)
      {
        paramViewGroup = new FavMediaGalleryUI.b(this.mBV, (byte)0);
        paramView = View.inflate(this.mBV.getContext(), 2130969536, null);
        paramViewGroup.mwD = paramView.findViewById(2131820630);
        paramViewGroup.mwE = ((MultiTouchImageView)paramView.findViewById(2131820629));
        paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(2131822683));
        paramViewGroup.mwF = ((ImageView)paramView.findViewById(2131821549));
        paramViewGroup.mwG = ((TextView)paramView.findViewById(2131824027));
        paramViewGroup.mwH = ((LinearLayout)paramView.findViewById(2131824000));
        paramViewGroup.mwI = ((TextView)paramView.findViewById(2131824001));
        paramViewGroup.mwI.setText(2131299691);
        paramView.setTag(paramViewGroup);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        boolean bool = this.mwz.get(paramInt, true);
        this.mwz.put(paramInt, false);
        localObject1 = l.a(localf.cuL, localf.mwn, bool);
        if (localf.mwn != null) {
          ab.i("MicroMsg.FavMediaGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localf.mwn.field_id), Long.valueOf(localf.mwn.field_localId), Integer.valueOf(localf.mwn.field_itemStatus) });
        }
        if (localf.cuL != null) {
          ab.i("MicroMsg.FavMediaGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { localf.cuL.mBq, localf.cuL.wSC, localf.cuL.wSE, Long.valueOf(localf.cuL.wSX), localf.cuL.fgM, localf.cuL.wSy, Long.valueOf(localf.cuL.wTi) });
        }
        if (localObject1 != null) {
          break label1104;
        }
        this.mBV.enableOptionMenu(false);
        ab.w("MicroMsg.FavMediaGalleryUI", "get big image fail");
        localObject2 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage();
        if (localf.cuL == null) {
          break label871;
        }
        localObject1 = localf.cuL.mBq;
        label744:
        localObject1 = ((q)localObject2).NP((String)localObject1);
        if (localObject1 != null) {
          break label950;
        }
        paramViewGroup.mwH.setVisibility(8);
        if ((localf.mwn == null) || (localf.mwn.field_id >= 0)) {
          break label879;
        }
        paramViewGroup.progressBar.setVisibility(0);
        paramViewGroup.mwG.setVisibility(0);
        paramViewGroup.mwF.setVisibility(0);
        paramViewGroup.mwD.setVisibility(8);
        paramViewGroup.mwF.setImageBitmap(a(localf));
        paramViewGroup.progressBar.setProgress(0);
        paramViewGroup.mwG.setText("0%");
      }
      for (;;)
      {
        AppMethodBeat.o(74523);
        return paramView;
        paramViewGroup = (FavMediaGalleryUI.b)paramView.getTag();
        break;
        label871:
        localObject1 = "";
        break label744;
        label879:
        paramViewGroup.progressBar.setVisibility(8);
        paramViewGroup.mwG.setVisibility(8);
        paramViewGroup.mwF.setVisibility(8);
        paramViewGroup.mwD.setVisibility(0);
        if (localf.cuL.wTK != 0) {
          paramViewGroup.mwH.setVisibility(0);
        }
        b(paramViewGroup, a(localf), "");
      }
      label950:
      ab.i("MicroMsg.FavMediaGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((c)localObject1).field_status) });
      paramViewGroup.progressBar.setVisibility(0);
      paramViewGroup.mwG.setVisibility(0);
      paramViewGroup.mwF.setVisibility(0);
      paramViewGroup.mwD.setVisibility(8);
      paramViewGroup.mwF.setImageBitmap(a(localf));
      if (((c)localObject1).field_totalLen > 0) {}
      for (paramInt = ((c)localObject1).field_offset * 100 / ((c)localObject1).field_totalLen - 1;; paramInt = 0)
      {
        int i = paramInt;
        if (paramInt < 0) {
          i = 0;
        }
        paramViewGroup.progressBar.setProgress(i);
        paramViewGroup.mwG.setText(i + "%");
        AppMethodBeat.o(74523);
        return paramView;
      }
      label1104:
      this.mBV.enableOptionMenu(true);
      if (r.aoY(b.b(localf.cuL))) {
        a(paramViewGroup, (Bitmap)localObject1, b.b(localf.cuL));
      }
      for (;;)
      {
        AppMethodBeat.o(74523);
        return paramView;
        a(paramViewGroup, (Bitmap)localObject1, "");
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final f vX(int paramInt)
  {
    AppMethodBeat.i(74522);
    if (paramInt >= FavMediaGalleryUI.h(this.mBV).size())
    {
      ab.w("MicroMsg.FavMediaGalleryUI", "get item fail, position %d error", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(74522);
      return null;
    }
    f localf = (f)FavMediaGalleryUI.h(this.mBV).get(paramInt);
    AppMethodBeat.o(74522);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.a
 * JD-Core Version:    0.7.0.1
 */