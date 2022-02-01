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
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.q.b;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class f
  extends RecyclerView.a
{
  private FavoriteImageServer Aga;
  arx Aia;
  private g.b Ans;
  c Ant;
  b Anu;
  public q Anv;
  boolean Anw;
  private Runnable hIW;
  private com.tencent.mm.modelimage.loader.a.c lMm;
  private Context mContext;
  private List<d> uQh;
  private boolean wQm;
  boolean wQp;
  
  public f(Context paramContext, List<d> paramList, g.b paramb, FavoriteImageServer paramFavoriteImageServer, Runnable paramRunnable)
  {
    AppMethodBeat.i(274506);
    this.uQh = null;
    this.lMm = null;
    this.wQm = true;
    this.Aia = new arx();
    this.Anv = new q()
    {
      public final void e(com.tencent.mm.plugin.fav.a.c paramAnonymousc)
      {
        AppMethodBeat.i(274473);
        final int i = 0;
        f.d locald;
        String str2;
        String str1;
        Object localObject;
        if (i < f.a(f.this).size())
        {
          locald = (f.d)f.a(f.this).get(i);
          str2 = locald.AnE.hIT.hIQ;
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
            Log.i("MicroMsg.MediaHistoryGalleryAdapter", "sameDataId, filedDataId:%s, truePath:%s", new Object[] { str1, y.n(locald.imagePath, false) });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(274471);
                Log.i("MicroMsg.MediaHistoryGalleryAdapter", "notifyIndex :%s", new Object[] { Integer.valueOf(i) });
                f.this.fV(i);
                AppMethodBeat.o(274471);
              }
            });
          }
          i += 1;
          break;
          localObject = "";
          continue;
          AppMethodBeat.o(274473);
          return;
          label181:
          localObject = str1;
        }
      }
    };
    this.Anw = false;
    this.uQh = paramList;
    this.wQm = com.tencent.mm.kernel.h.baE().isSDCardAvailable();
    this.mContext = paramContext;
    this.Ans = paramb;
    this.Aga = paramFavoriteImageServer;
    this.hIW = paramRunnable;
    paramList = new c.a();
    paramList.oKs = 1;
    paramList.oKJ = true;
    paramList.npV = (com.tencent.mm.cd.a.ms(paramContext) / 4);
    paramList.npU = (com.tencent.mm.cd.a.ms(paramContext) / 4);
    paramList.oKE = q.b.pic_thum_bg_color;
    this.lMm = paramList.bKx();
    AppMethodBeat.o(274506);
  }
  
  private static long kE(long paramLong)
  {
    AppMethodBeat.i(107416);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.jBw().b(localDate);
    AppMethodBeat.o(107416);
    return paramLong;
  }
  
  public final d MM(int paramInt)
  {
    AppMethodBeat.i(107418);
    if (paramInt < 0)
    {
      AppMethodBeat.o(107418);
      return null;
    }
    d locald = (d)this.uQh.get(paramInt);
    AppMethodBeat.o(107418);
    return locald;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(274527);
    if ((paramList != null) && (paramList.size() > 0) && ((paramv instanceof e)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((e)paramv).checkBox.setChecked(false);
        ((e)paramv).checkBox.setVisibility(0);
        ((e)paramv).AnN.setVisibility(0);
        AppMethodBeat.o(274527);
        return;
      }
      ((e)paramv).checkBox.setChecked(false);
      ((e)paramv).checkBox.setVisibility(8);
      ((e)paramv).AnN.setVisibility(8);
      AppMethodBeat.o(274527);
      return;
    }
    super.a(paramv, paramInt, paramList);
    AppMethodBeat.o(274527);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(274526);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(q.f.fav_gallery_date_item, paramViewGroup, false));
      AppMethodBeat.o(274526);
      return paramViewGroup;
    }
    paramViewGroup = new e(LayoutInflater.from(paramViewGroup.getContext()).inflate(q.f.fav_image_gallary_grid_item, paramViewGroup, false));
    AppMethodBeat.o(274526);
    return paramViewGroup;
  }
  
  public final void d(final RecyclerView.v paramv, final int paramInt)
  {
    AppMethodBeat.i(274528);
    if (!this.wQm)
    {
      Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.wQm) });
      AppMethodBeat.o(274528);
      return;
    }
    Object localObject2 = MM(paramInt);
    if (paramv.caO == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (kE(MM(paramInt + 1).timeStamp) != kE(((d)localObject2).timeStamp)))
      {
        ((a)paramv).pIJ.setVisibility(8);
        AppMethodBeat.o(274528);
        return;
      }
      ((a)paramv).pIJ.setVisibility(0);
      ((a)paramv).pIJ.setText(kD(((d)localObject2).timeStamp));
      if (this.wQp)
      {
        ((a)paramv).progressBar.setVisibility(0);
        AppMethodBeat.o(274528);
        return;
      }
      ((a)paramv).progressBar.setVisibility(8);
      AppMethodBeat.o(274528);
      return;
    }
    ((e)paramv).cqj.setTag(q.e.fav_filter_data_pos, Integer.valueOf(paramInt));
    ((e)paramv).AnN.setTag(Integer.valueOf(paramInt));
    Object localObject1;
    if (((d)localObject2).AnG)
    {
      localObject1 = r.bKe();
      String str = ((d)localObject2).imagePath;
      ImageView localImageView = ((e)paramv).cqj;
      c.a locala = new c.a();
      locala.oKJ = true;
      locala.oKE = q.b.pic_thum_bg_color;
      ((com.tencent.mm.modelimage.loader.a)localObject1).a(str, localImageView, locala.bKx(), new com.tencent.mm.modelimage.loader.b.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          AppMethodBeat.i(274479);
          if (paramAnonymousb.status != 0)
          {
            int i = ((Integer)paramAnonymousView.getTag(q.e.fav_filter_data_pos)).intValue();
            if (i != paramInt)
            {
              Log.i("MicroMsg.MediaHistoryGalleryAdapter", "view has reused, no need to download. curPos:%d, lastPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
              AppMethodBeat.o(274479);
              return;
            }
            Log.i("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] loadImage fail(ret:%s), positon:%d, use FavoriteImageServer.attachImg, item.isMpVideo:true, dataId:%s, dataPath:%s, imagePath:%s", new Object[] { Integer.valueOf(paramAnonymousb.status), Integer.valueOf(paramInt), this.AnB.AnE.hIT.hIQ, com.tencent.mm.plugin.fav.a.b.d(this.AnB.AnE.hIT), this.AnB.imagePath });
            if (f.b(f.this) != null) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(274490);
                  f.b(f.this).c(((f.e)f.2.this.bUU).cqj, f.2.this.AnB.AnE.hIT, f.2.this.AnB.AnE.xvD, q.b.pic_thum_bg_color, f.c(f.this).npU, f.c(f.this).npV);
                  AppMethodBeat.o(274490);
                }
              });
            }
          }
          AppMethodBeat.o(274479);
        }
        
        public final void c(String paramAnonymousString, View paramAnonymousView) {}
      });
      if (!((d)localObject2).AnF) {
        break label569;
      }
      ((e)paramv).AnK.setVisibility(0);
      ((e)paramv).wQe.setVisibility(0);
      ((e)paramv).wQe.setText(Util.nullAs(((d)localObject2).AnH.AnI, ""));
      label348:
      ((e)paramv).cqj.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(274474);
          ((f.e)paramv).cqj.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          ((f.e)paramv).AnL.setLayoutParams(new RelativeLayout.LayoutParams(((f.e)paramv).cqj.getWidth(), ((f.e)paramv).cqj.getHeight()));
          AppMethodBeat.o(274474);
        }
      });
      if (!this.Anw) {
        break label631;
      }
      ((e)paramv).AnN.setVisibility(0);
      ((e)paramv).checkBox.setVisibility(0);
      localObject1 = e.a.dSL();
      localObject2 = ((d)localObject2).AnE;
      if (localObject2 == null) {
        break label596;
      }
      localObject1 = ((e)localObject1).Ann.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!((d)((Iterator)localObject1).next()).hIT.hIQ.equals(((d)localObject2).hIT.hIQ));
    }
    label569:
    label596:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label601;
      }
      ((e)paramv).AnL.setVisibility(0);
      ((e)paramv).checkBox.setChecked(true);
      AppMethodBeat.o(274528);
      return;
      localObject1 = ((d)localObject2).AnE;
      if (localObject1 == null) {
        Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[getImagePath] msg is null !");
      }
      for (localObject1 = "";; localObject1 = ((d)localObject1).aJL())
      {
        ((d)localObject2).imagePath = ((String)localObject1);
        r.bKe().a(((d)localObject2).imagePath, ((e)paramv).cqj, this.lMm, new com.tencent.mm.modelimage.loader.b.h()
        {
          public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
          {
            return null;
          }
          
          public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
          {
            AppMethodBeat.i(274481);
            if (paramAnonymousb.status != 0)
            {
              int i = ((Integer)paramAnonymousView.getTag(q.e.fav_filter_data_pos)).intValue();
              if (i != paramInt)
              {
                Log.i("MicroMsg.MediaHistoryGalleryAdapter", "view has reused, no need to download. curPos:%d, lastPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
                AppMethodBeat.o(274481);
                return;
              }
              Log.i("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] loadImage loadImage fail(ret:%s), lastPos:%d, use FavoriteImageServer.attachImg, item.isVideo:%b, dataId:%s, dataPath:%s, imagePath:%s", new Object[] { Integer.valueOf(paramAnonymousb.status), Integer.valueOf(paramInt), Boolean.valueOf(this.AnB.AnF), this.AnB.AnE.hIT.hIQ, y.n(com.tencent.mm.plugin.fav.a.b.d(this.AnB.AnE.hIT), false), y.n(this.AnB.imagePath, false) });
              if (f.b(f.this) != null) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(274512);
                    if (f.3.this.AnB.AnF)
                    {
                      f.b(f.this).c(((f.e)f.3.this.bUU).cqj, f.3.this.AnB.AnE.hIT, f.3.this.AnB.AnE.xvD, q.b.pic_thum_bg_color, f.c(f.this).npU, f.c(f.this).npV);
                      AppMethodBeat.o(274512);
                      return;
                    }
                    f.b(f.this).d(((f.e)f.3.this.bUU).cqj, f.3.this.AnB.AnE.hIT, f.3.this.AnB.AnE.xvD, q.b.pic_thum_bg_color, f.c(f.this).npU, f.c(f.this).npV);
                    AppMethodBeat.o(274512);
                  }
                });
              }
            }
            AppMethodBeat.o(274481);
          }
          
          public final void c(String paramAnonymousString, View paramAnonymousView) {}
        });
        break;
      }
      ((e)paramv).wQe.setVisibility(8);
      ((e)paramv).AnK.setVisibility(8);
      break label348;
    }
    label601:
    ((e)paramv).AnL.setVisibility(8);
    ((e)paramv).checkBox.setChecked(false);
    AppMethodBeat.o(274528);
    return;
    label631:
    ((e)paramv).AnL.setVisibility(8);
    ((e)paramv).AnN.setVisibility(8);
    ((e)paramv).checkBox.setVisibility(8);
    AppMethodBeat.o(274528);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(107417);
    int i = this.uQh.size();
    AppMethodBeat.o(107417);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(107411);
    paramInt = MM(paramInt).type;
    AppMethodBeat.o(107411);
    return paramInt;
  }
  
  public final String kD(long paramLong)
  {
    AppMethodBeat.i(107415);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.jBw().a((Date)localObject, this.mContext);
    AppMethodBeat.o(107415);
    return localObject;
  }
  
  public final class a
    extends RecyclerView.v
  {
    TextView pIJ;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(107397);
      this.pIJ = ((TextView)paramView.findViewById(q.e.date_info));
      this.progressBar = ((ProgressBar)paramView.findViewById(q.e.load_progress));
      AppMethodBeat.o(107397);
    }
  }
  
  public static abstract interface b
  {
    public abstract void dRJ();
    
    public abstract void dRL();
    
    public abstract void dRM();
    
    public abstract void dRN();
    
    public abstract void dSC();
  }
  
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, f.d paramd, int paramInt);
  }
  
  public static final class d
  {
    public d AnE;
    boolean AnF;
    boolean AnG;
    public a AnH;
    public String imagePath;
    public long timeStamp;
    public int type;
    
    public d(d paramd)
    {
      AppMethodBeat.i(107399);
      this.type = 0;
      this.AnH = new a();
      this.AnE = paramd;
      this.imagePath = paramd.aJL();
      this.timeStamp = paramd.xvD.field_updateTime;
      if ((paramd.dSH()) || (paramd.dSJ()))
      {
        this.AnF = true;
        this.AnH.AnI = Util.formatSecToMin(paramd.hIT.duration);
      }
      if (paramd.dSI()) {
        this.AnG = true;
      }
      AppMethodBeat.o(107399);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(107398);
      if ((this.AnE != null) && ((paramObject instanceof d)) && (paramObject != null))
      {
        bool = this.AnE.hIT.hIQ.equals(((d)paramObject).hIT.hIQ);
        AppMethodBeat.o(107398);
        return bool;
      }
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(107398);
      return bool;
    }
    
    final class a
    {
      public String AnI;
      
      a() {}
    }
  }
  
  public final class e
    extends RecyclerView.v
  {
    View.OnLongClickListener AkV;
    View AnK;
    ImageView AnL;
    View AnM;
    View AnN;
    CheckBox checkBox;
    ImageView cqj;
    TextView wQe;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(107409);
      this.AkV = new View.OnLongClickListener()
      {
        private void u(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107408);
          final int i = ((Integer)paramAnonymousView.getTag(q.e.fav_filter_data_pos)).intValue();
          final f.d locald = f.this.MM(i);
          if (locald == null)
          {
            AppMethodBeat.o(107408);
            return;
          }
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(f.f(f.this));
          f.e.this.AnL.setVisibility(0);
          locala.afLp = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(107403);
              if ((f.e.this.AnL != null) && (!f.this.Anw)) {
                f.e.this.AnL.setVisibility(8);
              }
              AppMethodBeat.o(107403);
            }
          };
          locala.a(paramAnonymousView, new View.OnCreateContextMenuListener()new u.i
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(107404);
              paramAnonymous2View = com.tencent.mm.plugin.fav.a.b.d(locald.AnE.hIT);
              boolean bool1 = y.ZC(paramAnonymous2View);
              boolean bool2 = ImgUtil.isGif(paramAnonymous2View);
              if ((!locald.AnF) && (bool1) && (!bool2))
              {
                paramAnonymous2ContextMenu.add(0, 0, 0, f.f(f.this).getString(q.i.favorite_share_with_friend));
                paramAnonymous2ContextMenu.add(0, 1, 0, f.f(f.this).getString(q.i.favorite_post_to_sns));
                paramAnonymous2ContextMenu.add(0, 2, 0, f.f(f.this).getString(q.i.favorite_save_image));
              }
              for (;;)
              {
                if (bool1)
                {
                  paramAnonymous2View = locald.AnE.xvD;
                  if ((paramAnonymous2View != null) && ((paramAnonymous2View.field_type == 18) || (paramAnonymous2View.field_type == 14))) {
                    paramAnonymous2ContextMenu.add(0, 4, 0, f.f(f.this).getString(q.i.favorite_go_detail));
                  }
                  paramAnonymous2ContextMenu.add(0, 5, 0, q.i.favorite_delete);
                }
                AppMethodBeat.o(107404);
                return;
                if ((locald.AnF) && (bool1) && (!bool2))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, f.f(f.this).getString(q.i.favorite_share_with_friend));
                  paramAnonymous2ContextMenu.add(0, 2, 0, f.f(f.this).getString(q.i.save_video_to_local));
                }
                else
                {
                  Log.d("MicroMsg.MediaHistoryGalleryAdapter", "openPopupMenu, isVideo:%s, exist:%s, isGif:%s", new Object[] { Boolean.valueOf(locald.AnF), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                }
              }
            }
          }, new u.i()
          {
            public final void onMMMenuItemSelected(final MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(107406);
              String str = com.tencent.mm.plugin.fav.a.b.d(locald.AnE.hIT);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(107406);
                return;
                paramAnonymous2MenuItem = new ArrayList();
                paramAnonymous2MenuItem.add(locald.AnE);
                f.g(f.this).fN(paramAnonymous2MenuItem);
                AppMethodBeat.o(107406);
                return;
                com.tencent.mm.plugin.fav.a.h.I(locald.AnE.xvD.field_localId, 0);
                com.tencent.mm.plugin.fav.a.b.c(str, f.f(f.this));
                if (f.d(f.this) != null)
                {
                  f.d(f.this).dRN();
                  AppMethodBeat.o(107406);
                  return;
                  if (f.d(f.this) != null) {
                    f.d(f.this).dRL();
                  }
                  if (Util.isNullOrNil(str))
                  {
                    Log.w("MicroMsg.MediaHistoryGalleryAdapter", "save image fail, path is null");
                    AppMethodBeat.o(107406);
                    return;
                  }
                  if (!locald.AnF)
                  {
                    ExportFileUtil.a(f.f(f.this), str, new ExportFileUtil.a()
                    {
                      public final void cg(String paramAnonymous3String1, String paramAnonymous3String2)
                      {
                        AppMethodBeat.i(274483);
                        Toast.makeText(f.f(f.this), f.f(f.this).getString(q.i.cropimage_saved, new Object[] { AndroidMediaUtil.getToastSysCameraPath() }), 1).show();
                        AppMethodBeat.o(274483);
                      }
                      
                      public final void ch(String paramAnonymous3String1, String paramAnonymous3String2)
                      {
                        AppMethodBeat.i(274486);
                        Toast.makeText(f.f(f.this), f.f(f.this).getString(q.i.favorite_save_fail), 1).show();
                        AppMethodBeat.o(274486);
                      }
                    });
                    AppMethodBeat.o(107406);
                    return;
                  }
                  ExportFileUtil.b(f.f(f.this), str, new ExportFileUtil.a()
                  {
                    public final void cg(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(274475);
                      Log.i("MicroMsg.MediaHistoryGalleryAdapter", "save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                      Toast.makeText(f.f(f.this), f.f(f.this).getString(q.i.video_file_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous3String2) }), 1).show();
                      AppMethodBeat.o(274475);
                    }
                    
                    public final void ch(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(274477);
                      Log.e("MicroMsg.MediaHistoryGalleryAdapter", "FAILURE save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                      Toast.makeText(f.f(f.this), f.f(f.this).getString(q.i.video_file_save_failed), 1).show();
                      AppMethodBeat.o(274477);
                    }
                  });
                  AppMethodBeat.o(107406);
                  return;
                  f.a(f.this, i, locald);
                  AppMethodBeat.o(107406);
                  return;
                  paramAnonymous2MenuItem = locald.AnE.xvD;
                  if ((paramAnonymous2MenuItem != null) && ((paramAnonymous2MenuItem.field_type == 18) || (paramAnonymous2MenuItem.field_type == 14)))
                  {
                    paramAnonymous2MenuItem = new g.a(f.f(f.this));
                    paramAnonymous2MenuItem.bDE(f.f(f.this).getString(q.i.favorite_delete_select_from_record_note));
                    paramAnonymous2MenuItem.bDJ(f.f(f.this).getString(q.i.favorite_cancel));
                    paramAnonymous2MenuItem.bDI(f.f(f.this).getString(q.i.favorite_go_detail));
                    paramAnonymous2MenuItem.a(new g.c()new g.c
                    {
                      public final void onDialogClick(boolean paramAnonymous3Boolean, String paramAnonymous3String) {}
                    }, new g.c()
                    {
                      public final void onDialogClick(boolean paramAnonymous3Boolean, String paramAnonymous3String)
                      {
                        AppMethodBeat.i(274478);
                        f.a(f.this, f.e.4.3.this.pSH, f.e.4.3.this.AnB);
                        AppMethodBeat.o(274478);
                      }
                    });
                    paramAnonymous2MenuItem.show();
                    AppMethodBeat.o(107406);
                    return;
                  }
                  k.a(f.f(f.this), f.f(f.this).getString(q.i.favorite_delete_confirm_tips), "", f.f(f.this).getString(q.i.app_delete), f.f(f.this).getString(q.i.confirm_dialog_cancel), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(274480);
                      com.tencent.mm.plugin.fav.a.b.a(paramAnonymous2MenuItem, f.h(f.this));
                      if (f.d(f.this) != null) {
                        f.d(f.this).dSC();
                      }
                      AppMethodBeat.o(274480);
                    }
                  }, null, q.b.red_text_color);
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (f.this.Anw)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(107407);
            return false;
          }
          if ((paramAnonymousView.getTag(q.e.touch_loc) instanceof int[]))
          {
            localObject = (int[])paramAnonymousView.getTag(q.e.touch_loc);
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
      this.cqj = ((ImageView)paramView.findViewById(q.e.grid_header_item));
      this.AnK = paramView.findViewById(q.e.video_tips_root);
      this.AnM = paramView.findViewById(q.e.sight_tips_root);
      this.wQe = ((TextView)paramView.findViewById(q.e.video_time_tv));
      this.AnL = ((ImageView)paramView.findViewById(q.e.grid_selected_item_mask));
      this.checkBox = ((CheckBox)paramView.findViewById(q.e.media_cbx));
      this.AnN = paramView.findViewById(q.e.media_cbx_clickarea);
      this.AnN.setVisibility(8);
      this.checkBox.setVisibility(8);
      this.AnK.setVisibility(8);
      this.wQe.setVisibility(8);
      this.AnM.setVisibility(8);
      this.cqj.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(107400);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            int i = (int)paramAnonymousMotionEvent.getRawX();
            int j = (int)paramAnonymousMotionEvent.getRawY();
            paramAnonymousView.setTag(q.e.touch_loc, new int[] { i, j });
          }
          AppMethodBeat.o(107400);
          return false;
        }
      });
      this.cqj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107401);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = paramAnonymousView.getTag(q.e.fav_filter_data_pos);
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107401);
            return;
          }
          localObject = f.this.MM(((Integer)localObject).intValue());
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
            ((Integer)paramAnonymousView.getTag(q.e.fav_filter_data_pos)).intValue();
            ((f.b)localObject).dRJ();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107401);
        }
      });
      this.cqj.setOnLongClickListener(this.AkV);
      this.AnN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107402);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          boolean bool;
          if (!f.e.this.checkBox.isChecked())
          {
            bool = true;
            if (e.a.dSL().Ann.size() >= 9) {
              break label184;
            }
            f.e.this.checkBox.setChecked(bool);
            if (bool) {
              break label170;
            }
            f.e.this.AnL.setVisibility(8);
          }
          for (;;)
          {
            if (f.e(f.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = f.this.MM(i);
              f.e(f.this).a(bool, paramAnonymousView, i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107402);
            return;
            bool = false;
            break;
            label170:
            f.e.this.AnL.setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f
 * JD-Core Version:    0.7.0.1
 */