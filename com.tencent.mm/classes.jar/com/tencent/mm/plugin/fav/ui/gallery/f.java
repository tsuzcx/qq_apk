package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.b;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class f
  extends RecyclerView.a
{
  private Runnable fEg;
  private com.tencent.mm.ay.a.a.c jjH;
  private Context mContext;
  private List<d> rEV;
  private boolean tMW;
  boolean tMZ;
  private o wJE;
  aoe wLC;
  private g.b wQO;
  c wQP;
  b wQQ;
  public com.tencent.mm.plugin.fav.a.q wQR;
  boolean wQS;
  
  public f(Context paramContext, List<d> paramList, g.b paramb, o paramo, Runnable paramRunnable)
  {
    AppMethodBeat.i(228614);
    this.rEV = null;
    this.jjH = null;
    this.tMW = true;
    this.wLC = new aoe();
    this.wQR = new com.tencent.mm.plugin.fav.a.q()
    {
      public final void e(com.tencent.mm.plugin.fav.a.c paramAnonymousc)
      {
        AppMethodBeat.i(228583);
        final int i = 0;
        f.d locald;
        String str2;
        String str1;
        Object localObject;
        if (i < f.a(f.this).size())
        {
          locald = (f.d)f.a(f.this).get(i);
          str2 = locald.wRa.fEd.fEa;
          str1 = paramAnonymousc.field_dataId;
          if ((str1 == null) || (!str1.endsWith("_t"))) {
            break label181;
          }
          localObject = str1.split("_");
          if ((localObject != null) && (localObject.length == 2)) {
            localObject = localObject[0];
          }
        }
        for (;;)
        {
          if ((str2 != null) && (localObject != null) && (str2.equals(localObject)) && (paramAnonymousc.isFinished()))
          {
            Log.i("MicroMsg.MediaHistoryGalleryAdapter", "sameDataId, filedDataId:%s, truePath:%s", new Object[] { str1, u.n(locald.imagePath, false) });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(230874);
                Log.i("MicroMsg.MediaHistoryGalleryAdapter", "notifyIndex :%s", new Object[] { Integer.valueOf(i) });
                f.this.cL(i);
                AppMethodBeat.o(230874);
              }
            });
          }
          i += 1;
          break;
          localObject = "";
          continue;
          AppMethodBeat.o(228583);
          return;
          label181:
          localObject = str1;
        }
      }
    };
    this.wQS = false;
    this.rEV = paramList;
    this.tMW = com.tencent.mm.kernel.h.aHG().isSDCardAvailable();
    this.mContext = paramContext;
    this.wQO = paramb;
    this.wJE = paramo;
    this.fEg = paramRunnable;
    paramList = new c.a();
    paramList.lRG = 1;
    paramList.lRX = true;
    paramList.kOg = (com.tencent.mm.ci.a.kr(paramContext) / 4);
    paramList.kOf = (com.tencent.mm.ci.a.kr(paramContext) / 4);
    paramList.lRS = s.b.pic_thum_bg_color;
    this.jjH = paramList.bmL();
    AppMethodBeat.o(228614);
  }
  
  private static long Im(long paramLong)
  {
    AppMethodBeat.i(107416);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.hWZ().b(localDate);
    AppMethodBeat.o(107416);
    return paramLong;
  }
  
  public final String Il(long paramLong)
  {
    AppMethodBeat.i(107415);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.hWZ().a((Date)localObject, this.mContext);
    AppMethodBeat.o(107415);
    return localObject;
  }
  
  public final d LP(int paramInt)
  {
    AppMethodBeat.i(107418);
    if (paramInt < 0)
    {
      AppMethodBeat.o(107418);
      return null;
    }
    d locald = (d)this.rEV.get(paramInt);
    AppMethodBeat.o(107418);
    return locald;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(228627);
    if ((paramList != null) && (paramList.size() > 0) && ((paramv instanceof e)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((e)paramv).checkBox.setChecked(false);
        ((e)paramv).checkBox.setVisibility(0);
        ((e)paramv).wRk.setVisibility(0);
        AppMethodBeat.o(228627);
        return;
      }
      ((e)paramv).checkBox.setChecked(false);
      ((e)paramv).checkBox.setVisibility(8);
      ((e)paramv).wRk.setVisibility(8);
      AppMethodBeat.o(228627);
      return;
    }
    super.a(paramv, paramInt, paramList);
    AppMethodBeat.o(228627);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(228621);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(s.f.fav_gallery_date_item, paramViewGroup, false));
      AppMethodBeat.o(228621);
      return paramViewGroup;
    }
    paramViewGroup = new e(LayoutInflater.from(paramViewGroup.getContext()).inflate(s.f.fav_image_gallary_grid_item, paramViewGroup, false));
    AppMethodBeat.o(228621);
    return paramViewGroup;
  }
  
  public final void d(final RecyclerView.v paramv, final int paramInt)
  {
    AppMethodBeat.i(228639);
    if (!this.tMW)
    {
      Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.tMW) });
      AppMethodBeat.o(228639);
      return;
    }
    Object localObject2 = LP(paramInt);
    if (paramv.amo == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (Im(LP(paramInt + 1).timeStamp) != Im(((d)localObject2).timeStamp)))
      {
        ((a)paramv).mMb.setVisibility(8);
        AppMethodBeat.o(228639);
        return;
      }
      ((a)paramv).mMb.setVisibility(0);
      ((a)paramv).mMb.setText(Il(((d)localObject2).timeStamp));
      if (this.tMZ)
      {
        ((a)paramv).progressBar.setVisibility(0);
        AppMethodBeat.o(228639);
        return;
      }
      ((a)paramv).progressBar.setVisibility(8);
      AppMethodBeat.o(228639);
      return;
    }
    ((e)paramv).wRg.setTag(s.e.fav_filter_data_pos, Integer.valueOf(paramInt));
    ((e)paramv).wRk.setTag(Integer.valueOf(paramInt));
    Object localObject1;
    if (((d)localObject2).wRc)
    {
      localObject1 = com.tencent.mm.ay.q.bml();
      String str = ((d)localObject2).imagePath;
      ImageView localImageView = ((e)paramv).wRg;
      c.a locala = new c.a();
      locala.lRX = true;
      locala.lRS = s.b.pic_thum_bg_color;
      ((com.tencent.mm.ay.a.a)localObject1).a(str, localImageView, locala.bmL(), new com.tencent.mm.ay.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(231142);
          if (paramAnonymousb.status != 0)
          {
            int i = ((Integer)paramAnonymousView.getTag(s.e.fav_filter_data_pos)).intValue();
            if (i != paramInt)
            {
              Log.i("MicroMsg.MediaHistoryGalleryAdapter", "view has reused, no need to download. curPos:%d, lastPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
              AppMethodBeat.o(231142);
              return;
            }
            Log.i("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] loadImage fail(ret:%s), positon:%d, use FavoriteImageServer.attachImg, item.isMpVideo:true, dataId:%s, dataPath:%s, imagePath:%s", new Object[] { Integer.valueOf(paramAnonymousb.status), Integer.valueOf(paramInt), this.wQX.wRa.fEd.fEa, com.tencent.mm.plugin.fav.a.b.d(this.wQX.wRa.fEd), this.wQX.imagePath });
            if (f.b(f.this) != null) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(229126);
                  f.b(f.this).c(((f.e)f.2.this.ago).wRg, f.2.this.wQX.wRa.fEd, f.2.this.wQX.wRa.upg, s.b.pic_thum_bg_color, f.c(f.this).kOf, f.c(f.this).kOg);
                  AppMethodBeat.o(229126);
                }
              });
            }
          }
          AppMethodBeat.o(231142);
        }
      });
      if (!((d)localObject2).wRb) {
        break label569;
      }
      ((e)paramv).wRh.setVisibility(0);
      ((e)paramv).tMO.setVisibility(0);
      ((e)paramv).tMO.setText(Util.nullAs(((d)localObject2).wRd.wRe, ""));
      label348:
      ((e)paramv).wRg.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(229961);
          ((f.e)paramv).wRg.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          ((f.e)paramv).wRi.setLayoutParams(new RelativeLayout.LayoutParams(((f.e)paramv).wRg.getWidth(), ((f.e)paramv).wRg.getHeight()));
          AppMethodBeat.o(229961);
        }
      });
      if (!this.wQS) {
        break label631;
      }
      ((e)paramv).wRk.setVisibility(0);
      ((e)paramv).checkBox.setVisibility(0);
      localObject1 = e.a.dlV();
      localObject2 = ((d)localObject2).wRa;
      if (localObject2 == null) {
        break label596;
      }
      localObject1 = ((e)localObject1).wQK.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!((d)((Iterator)localObject1).next()).fEd.fEa.equals(((d)localObject2).fEd.fEa));
    }
    label569:
    label596:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label601;
      }
      ((e)paramv).wRi.setVisibility(0);
      ((e)paramv).checkBox.setChecked(true);
      AppMethodBeat.o(228639);
      return;
      localObject1 = ((d)localObject2).wRa;
      if (localObject1 == null) {
        Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[getImagePath] msg is null !");
      }
      for (localObject1 = "";; localObject1 = ((d)localObject1).apK())
      {
        ((d)localObject2).imagePath = ((String)localObject1);
        com.tencent.mm.ay.q.bml().a(((d)localObject2).imagePath, ((e)paramv).wRg, this.jjH, new com.tencent.mm.ay.a.c.h()
        {
          public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
          {
            return null;
          }
          
          public final void b(String paramAnonymousString, View paramAnonymousView) {}
          
          public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
          {
            AppMethodBeat.i(227745);
            if (paramAnonymousb.status != 0)
            {
              int i = ((Integer)paramAnonymousView.getTag(s.e.fav_filter_data_pos)).intValue();
              if (i != paramInt)
              {
                Log.i("MicroMsg.MediaHistoryGalleryAdapter", "view has reused, no need to download. curPos:%d, lastPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
                AppMethodBeat.o(227745);
                return;
              }
              Log.i("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] loadImage loadImage fail(ret:%s), lastPos:%d, use FavoriteImageServer.attachImg, item.isVideo:%b, dataId:%s, dataPath:%s, imagePath:%s", new Object[] { Integer.valueOf(paramAnonymousb.status), Integer.valueOf(paramInt), Boolean.valueOf(this.wQX.wRb), this.wQX.wRa.fEd.fEa, u.n(com.tencent.mm.plugin.fav.a.b.d(this.wQX.wRa.fEd), false), u.n(this.wQX.imagePath, false) });
              if (f.b(f.this) != null) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(230170);
                    if (f.3.this.wQX.wRb)
                    {
                      f.b(f.this).c(((f.e)f.3.this.ago).wRg, f.3.this.wQX.wRa.fEd, f.3.this.wQX.wRa.upg, s.b.pic_thum_bg_color, f.c(f.this).kOf, f.c(f.this).kOg);
                      AppMethodBeat.o(230170);
                      return;
                    }
                    f.b(f.this).d(((f.e)f.3.this.ago).wRg, f.3.this.wQX.wRa.fEd, f.3.this.wQX.wRa.upg, s.b.pic_thum_bg_color, f.c(f.this).kOf, f.c(f.this).kOg);
                    AppMethodBeat.o(230170);
                  }
                });
              }
            }
            AppMethodBeat.o(227745);
          }
        });
        break;
      }
      ((e)paramv).tMO.setVisibility(8);
      ((e)paramv).wRh.setVisibility(8);
      break label348;
    }
    label601:
    ((e)paramv).wRi.setVisibility(8);
    ((e)paramv).checkBox.setChecked(false);
    AppMethodBeat.o(228639);
    return;
    label631:
    ((e)paramv).wRi.setVisibility(8);
    ((e)paramv).wRk.setVisibility(8);
    ((e)paramv).checkBox.setVisibility(8);
    AppMethodBeat.o(228639);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(107417);
    int i = this.rEV.size();
    AppMethodBeat.o(107417);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(107411);
    paramInt = LP(paramInt).type;
    AppMethodBeat.o(107411);
    return paramInt;
  }
  
  public final class a
    extends RecyclerView.v
  {
    TextView mMb;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(107397);
      this.mMb = ((TextView)paramView.findViewById(s.e.date_info));
      this.progressBar = ((ProgressBar)paramView.findViewById(s.e.load_progress));
      AppMethodBeat.o(107397);
    }
  }
  
  public static abstract interface b
  {
    public abstract void dkT();
    
    public abstract void dkV();
    
    public abstract void dkW();
    
    public abstract void dkX();
    
    public abstract void dlM();
  }
  
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, f.d paramd, int paramInt);
  }
  
  public static final class d
  {
    public String imagePath;
    public long timeStamp;
    public int type;
    public d wRa;
    boolean wRb;
    boolean wRc;
    public a wRd;
    
    public d(d paramd)
    {
      AppMethodBeat.i(107399);
      this.type = 0;
      this.wRd = new a();
      this.wRa = paramd;
      this.imagePath = paramd.apK();
      this.timeStamp = paramd.upg.field_updateTime;
      if ((paramd.dlR()) || (paramd.dlT()))
      {
        this.wRb = true;
        this.wRd.wRe = Util.formatSecToMin(paramd.fEd.duration);
      }
      if (paramd.dlS()) {
        this.wRc = true;
      }
      AppMethodBeat.o(107399);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(107398);
      if ((this.wRa != null) && ((paramObject instanceof d)) && (paramObject != null))
      {
        bool = this.wRa.fEd.fEa.equals(((d)paramObject).fEd.fEa);
        AppMethodBeat.o(107398);
        return bool;
      }
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(107398);
      return bool;
    }
    
    final class a
    {
      public String wRe;
      
      a() {}
    }
  }
  
  public final class e
    extends RecyclerView.v
  {
    CheckBox checkBox;
    TextView tMO;
    View.OnLongClickListener wOt;
    ImageView wRg;
    View wRh;
    ImageView wRi;
    View wRj;
    View wRk;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(107409);
      this.wOt = new View.OnLongClickListener()
      {
        private void u(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107408);
          final int i = ((Integer)paramAnonymousView.getTag(s.e.fav_filter_data_pos)).intValue();
          final f.d locald = f.this.LP(i);
          if (locald == null)
          {
            AppMethodBeat.o(107408);
            return;
          }
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(f.f(f.this));
          f.e.this.wRi.setVisibility(0);
          locala.XVa = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(107403);
              if ((f.e.this.wRi != null) && (!f.this.wQS)) {
                f.e.this.wRi.setVisibility(8);
              }
              AppMethodBeat.o(107403);
            }
          };
          locala.a(paramAnonymousView, new View.OnCreateContextMenuListener()new q.g
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(107404);
              paramAnonymous2View = com.tencent.mm.plugin.fav.a.b.d(locald.wRa.fEd);
              boolean bool1 = u.agG(paramAnonymous2View);
              boolean bool2 = ImgUtil.isGif(paramAnonymous2View);
              if ((!locald.wRb) && (bool1) && (!bool2))
              {
                paramAnonymous2ContextMenu.add(0, 0, 0, f.f(f.this).getString(s.i.favorite_share_with_friend));
                paramAnonymous2ContextMenu.add(0, 1, 0, f.f(f.this).getString(s.i.favorite_post_to_sns));
                paramAnonymous2ContextMenu.add(0, 2, 0, f.f(f.this).getString(s.i.favorite_save_image));
              }
              for (;;)
              {
                if (bool1)
                {
                  paramAnonymous2View = locald.wRa.upg;
                  if ((paramAnonymous2View != null) && ((paramAnonymous2View.field_type == 18) || (paramAnonymous2View.field_type == 14))) {
                    paramAnonymous2ContextMenu.add(0, 4, 0, f.f(f.this).getString(s.i.favorite_go_detail));
                  }
                  paramAnonymous2ContextMenu.add(0, 5, 0, s.i.favorite_delete);
                }
                AppMethodBeat.o(107404);
                return;
                if ((locald.wRb) && (bool1) && (!bool2))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, f.f(f.this).getString(s.i.favorite_share_with_friend));
                  paramAnonymous2ContextMenu.add(0, 2, 0, f.f(f.this).getString(s.i.save_video_to_local));
                }
                else
                {
                  Log.d("MicroMsg.MediaHistoryGalleryAdapter", "openPopupMenu, isVideo:%s, exist:%s, isGif:%s", new Object[] { Boolean.valueOf(locald.wRb), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                }
              }
            }
          }, new q.g()
          {
            public final void onMMMenuItemSelected(final MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(107406);
              String str = com.tencent.mm.plugin.fav.a.b.d(locald.wRa.fEd);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(107406);
                return;
                paramAnonymous2MenuItem = new ArrayList();
                paramAnonymous2MenuItem.add(locald.wRa);
                f.g(f.this).dS(paramAnonymous2MenuItem);
                AppMethodBeat.o(107406);
                return;
                com.tencent.mm.plugin.fav.a.h.y(locald.wRa.upg.field_localId, 0);
                com.tencent.mm.plugin.fav.a.b.c(str, f.f(f.this));
                if (f.d(f.this) != null)
                {
                  f.d(f.this).dkX();
                  AppMethodBeat.o(107406);
                  return;
                  if (f.d(f.this) != null) {
                    f.d(f.this).dkV();
                  }
                  if (Util.isNullOrNil(str))
                  {
                    Log.w("MicroMsg.MediaHistoryGalleryAdapter", "save image fail, path is null");
                    AppMethodBeat.o(107406);
                    return;
                  }
                  if (!locald.wRb)
                  {
                    p.a(f.f(f.this), str, new p.a()
                    {
                      public final void bT(String paramAnonymous3String1, String paramAnonymous3String2)
                      {
                        AppMethodBeat.i(229592);
                        Toast.makeText(f.f(f.this), f.f(f.this).getString(s.i.cropimage_saved, new Object[] { AndroidMediaUtil.getToastSysCameraPath() }), 1).show();
                        AppMethodBeat.o(229592);
                      }
                      
                      public final void bU(String paramAnonymous3String1, String paramAnonymous3String2)
                      {
                        AppMethodBeat.i(229594);
                        Toast.makeText(f.f(f.this), f.f(f.this).getString(s.i.favorite_save_fail), 1).show();
                        AppMethodBeat.o(229594);
                      }
                    });
                    AppMethodBeat.o(107406);
                    return;
                  }
                  p.b(f.f(f.this), str, new p.a()
                  {
                    public final void bT(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(230505);
                      Log.i("MicroMsg.MediaHistoryGalleryAdapter", "save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                      Toast.makeText(f.f(f.this), f.f(f.this).getString(s.i.video_file_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous3String2) }), 1).show();
                      AppMethodBeat.o(230505);
                    }
                    
                    public final void bU(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(230508);
                      Log.e("MicroMsg.MediaHistoryGalleryAdapter", "FAILURE save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                      Toast.makeText(f.f(f.this), f.f(f.this).getString(s.i.video_file_save_failed), 1).show();
                      AppMethodBeat.o(230508);
                    }
                  });
                  AppMethodBeat.o(107406);
                  return;
                  f.a(f.this, i, locald);
                  AppMethodBeat.o(107406);
                  return;
                  paramAnonymous2MenuItem = locald.wRa.upg;
                  if ((paramAnonymous2MenuItem != null) && ((paramAnonymous2MenuItem.field_type == 18) || (paramAnonymous2MenuItem.field_type == 14)))
                  {
                    paramAnonymous2MenuItem = new com.tencent.mm.ui.widget.a.f.a(f.f(f.this));
                    paramAnonymous2MenuItem.bBl(f.f(f.this).getString(s.i.favorite_delete_select_from_record_note));
                    paramAnonymous2MenuItem.bBq(f.f(f.this).getString(s.i.favorite_cancel));
                    paramAnonymous2MenuItem.bBp(f.f(f.this).getString(s.i.favorite_go_detail));
                    paramAnonymous2MenuItem.a(new com.tencent.mm.ui.widget.a.f.c()new com.tencent.mm.ui.widget.a.f.c
                    {
                      public final void g(boolean paramAnonymous3Boolean, String paramAnonymous3String) {}
                    }, new com.tencent.mm.ui.widget.a.f.c()
                    {
                      public final void g(boolean paramAnonymous3Boolean, String paramAnonymous3String)
                      {
                        AppMethodBeat.i(230820);
                        f.a(f.this, f.e.4.3.this.mWa, f.e.4.3.this.wQX);
                        AppMethodBeat.o(230820);
                      }
                    });
                    paramAnonymous2MenuItem.show();
                    AppMethodBeat.o(107406);
                    return;
                  }
                  com.tencent.mm.ui.base.h.a(f.f(f.this), f.f(f.this).getString(s.i.favorite_delete_confirm_tips), "", f.f(f.this).getString(s.i.app_delete), f.f(f.this).getString(s.i.confirm_dialog_cancel), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(230077);
                      com.tencent.mm.plugin.fav.a.b.a(paramAnonymous2MenuItem, f.h(f.this));
                      if (f.d(f.this) != null) {
                        f.d(f.this).dlM();
                      }
                      AppMethodBeat.o(230077);
                    }
                  }, null, s.b.red_text_color);
                }
              }
            }
          }, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(107408);
        }
        
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107407);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (f.this.wQS)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(107407);
            return false;
          }
          if ((paramAnonymousView.getTag(s.e.touch_loc) instanceof int[]))
          {
            localObject = (int[])paramAnonymousView.getTag(s.e.touch_loc);
            u(paramAnonymousView, localObject[0], localObject[1]);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(107407);
            return true;
            u(paramAnonymousView, 0, 0);
          }
        }
      };
      this.wRg = ((ImageView)paramView.findViewById(s.e.grid_header_item));
      this.wRh = paramView.findViewById(s.e.video_tips_root);
      this.wRj = paramView.findViewById(s.e.sight_tips_root);
      this.tMO = ((TextView)paramView.findViewById(s.e.video_time_tv));
      this.wRi = ((ImageView)paramView.findViewById(s.e.grid_selected_item_mask));
      this.checkBox = ((CheckBox)paramView.findViewById(s.e.media_cbx));
      this.wRk = paramView.findViewById(s.e.media_cbx_clickarea);
      this.wRk.setVisibility(8);
      this.checkBox.setVisibility(8);
      this.wRh.setVisibility(8);
      this.tMO.setVisibility(8);
      this.wRj.setVisibility(8);
      this.wRg.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(107400);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            int i = (int)paramAnonymousMotionEvent.getRawX();
            int j = (int)paramAnonymousMotionEvent.getRawY();
            paramAnonymousView.setTag(s.e.touch_loc, new int[] { i, j });
          }
          AppMethodBeat.o(107400);
          return false;
        }
      });
      this.wRg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107401);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = paramAnonymousView.getTag(s.e.fav_filter_data_pos);
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107401);
            return;
          }
          localObject = f.this.LP(((Integer)localObject).intValue());
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107401);
            return;
          }
          f.a(f.this, (f.d)localObject);
          if (f.d(f.this) != null)
          {
            localObject = f.d(f.this);
            ((Integer)paramAnonymousView.getTag(s.e.fav_filter_data_pos)).intValue();
            ((f.b)localObject).dkT();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107401);
        }
      });
      this.wRg.setOnLongClickListener(this.wOt);
      this.wRk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107402);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          boolean bool;
          if (!f.e.this.checkBox.isChecked())
          {
            bool = true;
            if (e.a.dlV().wQK.size() >= 9) {
              break label184;
            }
            f.e.this.checkBox.setChecked(bool);
            if (bool) {
              break label170;
            }
            f.e.this.wRi.setVisibility(8);
          }
          for (;;)
          {
            if (f.e(f.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = f.this.LP(i);
              f.e(f.this).a(bool, paramAnonymousView, i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107402);
            return;
            bool = false;
            break;
            label170:
            f.e.this.wRi.setVisibility(0);
            continue;
            label184:
            if (!bool) {
              f.e.this.checkBox.setChecked(false);
            }
          }
        }
      });
      AppMethodBeat.o(107409);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f
 * JD-Core Version:    0.7.0.1
 */