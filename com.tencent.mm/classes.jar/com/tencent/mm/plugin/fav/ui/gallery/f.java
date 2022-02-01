package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class f
  extends RecyclerView.a
{
  private Runnable dLr;
  private c gzE;
  private Context mContext;
  private List<d> opg;
  private boolean qoo;
  boolean qor;
  and tfo;
  boolean tkA;
  private g.b tkx;
  c tky;
  b tkz;
  
  public f(Context paramContext, List<d> paramList, g.b paramb, Runnable paramRunnable)
  {
    AppMethodBeat.i(107410);
    this.opg = null;
    this.gzE = null;
    this.qoo = true;
    this.tfo = new and();
    this.tkA = false;
    this.opg = paramList;
    this.qoo = com.tencent.mm.kernel.g.aAh().isSDCardAvailable();
    this.mContext = paramContext;
    this.tkx = paramb;
    this.dLr = paramRunnable;
    paramList = new c.a();
    paramList.jbi = 1;
    paramList.jby = true;
    paramList.hZA = (com.tencent.mm.cb.a.jn(paramContext) / 4);
    paramList.hZz = (com.tencent.mm.cb.a.jn(paramContext) / 4);
    paramList.jbt = 2131100928;
    this.gzE = paramList.bdv();
    AppMethodBeat.o(107410);
  }
  
  private static long Cd(long paramLong)
  {
    AppMethodBeat.i(107416);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.gWr().b(localDate);
    AppMethodBeat.o(107416);
    return paramLong;
  }
  
  public final String Cc(long paramLong)
  {
    AppMethodBeat.i(107415);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.gWr().a((Date)localObject, this.mContext);
    AppMethodBeat.o(107415);
    return localObject;
  }
  
  public final d If(int paramInt)
  {
    AppMethodBeat.i(107418);
    if (paramInt < 0)
    {
      AppMethodBeat.o(107418);
      return null;
    }
    d locald = (d)this.opg.get(paramInt);
    AppMethodBeat.o(107418);
    return locald;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(107412);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494118, paramViewGroup, false));
      AppMethodBeat.o(107412);
      return paramViewGroup;
    }
    paramViewGroup = new e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494119, paramViewGroup, false));
    AppMethodBeat.o(107412);
    return paramViewGroup;
  }
  
  public final void a(final RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(107414);
    if (!this.qoo)
    {
      Log.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.qoo) });
      AppMethodBeat.o(107414);
      return;
    }
    Object localObject1 = If(paramInt);
    if (paramv.auw == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (Cd(If(paramInt + 1).timeStamp) != Cd(((d)localObject1).timeStamp)))
      {
        ((a)paramv).jUO.setVisibility(8);
        AppMethodBeat.o(107414);
        return;
      }
      ((a)paramv).jUO.setVisibility(0);
      ((a)paramv).jUO.setText(Cc(((d)localObject1).timeStamp));
      if (this.qor)
      {
        ((a)paramv).progressBar.setVisibility(0);
        AppMethodBeat.o(107414);
        return;
      }
      ((a)paramv).progressBar.setVisibility(8);
      AppMethodBeat.o(107414);
      return;
    }
    ((e)paramv).tkI.setTag(2131300466, Integer.valueOf(paramInt));
    ((e)paramv).tkM.setTag(Integer.valueOf(paramInt));
    if (((d)localObject1).tkE)
    {
      Object localObject2 = q.bcV();
      String str = ((d)localObject1).imagePath;
      ImageView localImageView = ((e)paramv).tkI;
      c.a locala = new c.a();
      locala.jby = true;
      locala.jbt = 2131100928;
      ((com.tencent.mm.av.a.a)localObject2).a(str, localImageView, locala.bdv());
      if (!((d)localObject1).tkD) {
        break label503;
      }
      ((e)paramv).tkJ.setVisibility(0);
      ((e)paramv).qog.setVisibility(0);
      ((e)paramv).qog.setText(Util.nullAs(((d)localObject1).tkF.tkG, ""));
      label330:
      ((e)paramv).tkI.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(107396);
          ((f.e)paramv).tkI.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          ((f.e)paramv).tkK.setLayoutParams(new RelativeLayout.LayoutParams(((f.e)paramv).tkI.getWidth(), ((f.e)paramv).tkI.getHeight()));
          AppMethodBeat.o(107396);
        }
      });
      if (!this.tkA) {
        break label565;
      }
      ((e)paramv).tkM.setVisibility(0);
      ((e)paramv).checkBox.setVisibility(0);
      localObject2 = e.a.cWN();
      localObject1 = ((d)localObject1).tkC;
      if (localObject1 == null) {
        break label530;
      }
      localObject2 = ((e)localObject2).tkt.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (!((d)((Iterator)localObject2).next()).dLo.dLl.equals(((d)localObject1).dLo.dLl));
    }
    label530:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label535;
      }
      ((e)paramv).tkK.setVisibility(0);
      ((e)paramv).checkBox.setChecked(true);
      AppMethodBeat.o(107414);
      return;
      q.bcV().a(((d)localObject1).imagePath, ((e)paramv).tkI, this.gzE);
      break;
      label503:
      ((e)paramv).qog.setVisibility(8);
      ((e)paramv).tkJ.setVisibility(8);
      break label330;
    }
    label535:
    ((e)paramv).tkK.setVisibility(8);
    ((e)paramv).checkBox.setChecked(false);
    AppMethodBeat.o(107414);
    return;
    label565:
    ((e)paramv).tkK.setVisibility(8);
    ((e)paramv).tkM.setVisibility(8);
    ((e)paramv).checkBox.setVisibility(8);
    AppMethodBeat.o(107414);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(107413);
    if ((paramList != null) && (paramList.size() > 0) && ((paramv instanceof e)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((e)paramv).checkBox.setChecked(false);
        ((e)paramv).checkBox.setVisibility(0);
        ((e)paramv).tkM.setVisibility(0);
        AppMethodBeat.o(107413);
        return;
      }
      ((e)paramv).checkBox.setChecked(false);
      ((e)paramv).checkBox.setVisibility(8);
      ((e)paramv).tkM.setVisibility(8);
      AppMethodBeat.o(107413);
      return;
    }
    super.a(paramv, paramInt, paramList);
    AppMethodBeat.o(107413);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(107417);
    int i = this.opg.size();
    AppMethodBeat.o(107417);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(107411);
    paramInt = If(paramInt).type;
    AppMethodBeat.o(107411);
    return paramInt;
  }
  
  public final class a
    extends RecyclerView.v
  {
    TextView jUO;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(107397);
      this.jUO = ((TextView)paramView.findViewById(2131299414));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131303688));
      AppMethodBeat.o(107397);
    }
  }
  
  public static abstract interface b
  {
    public abstract void cVN();
    
    public abstract void cVP();
    
    public abstract void cVQ();
    
    public abstract void cVR();
    
    public abstract void cWF();
  }
  
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, f.d paramd, int paramInt);
  }
  
  public static final class d
  {
    public String imagePath;
    public long timeStamp;
    public d tkC;
    boolean tkD;
    boolean tkE;
    public a tkF;
    public int type;
    
    public d(d paramd)
    {
      AppMethodBeat.i(107399);
      this.type = 0;
      this.tkF = new a();
      this.tkC = paramd;
      Object localObject;
      if (paramd.cWK()) {
        localObject = paramd.dLo.dFN;
      }
      for (;;)
      {
        this.imagePath = ((String)localObject);
        this.timeStamp = paramd.qNT.field_updateTime;
        if ((paramd.cWJ()) || (paramd.cWL()))
        {
          this.tkD = true;
          this.tkF.tkG = Util.formatSecToMin(paramd.dLo.duration);
        }
        if (paramd.cWK()) {
          this.tkE = true;
        }
        AppMethodBeat.o(107399);
        return;
        if ((paramd.cWJ()) || (paramd.cWL()))
        {
          localObject = com.tencent.mm.plugin.fav.a.b.a(paramd.dLo);
        }
        else
        {
          String str = com.tencent.mm.plugin.fav.a.b.d(paramd.dLo);
          localObject = str;
          if (!new o(str).exists()) {
            localObject = com.tencent.mm.plugin.fav.a.b.a(paramd.dLo);
          }
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(107398);
      if ((this.tkC != null) && ((paramObject instanceof d)) && (paramObject != null))
      {
        bool = this.tkC.dLo.dLl.equals(((d)paramObject).dLo.dLl);
        AppMethodBeat.o(107398);
        return bool;
      }
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(107398);
      return bool;
    }
    
    final class a
    {
      public String tkG;
      
      a() {}
    }
  }
  
  public final class e
    extends RecyclerView.v
  {
    CheckBox checkBox;
    TextView qog;
    View.OnLongClickListener tib;
    ImageView tkI;
    View tkJ;
    ImageView tkK;
    View tkL;
    View tkM;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(107409);
      this.tib = new View.OnLongClickListener()
      {
        private void t(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107408);
          final int i = ((Integer)paramAnonymousView.getTag(2131300466)).intValue();
          final f.d locald = f.this.If(i);
          if (locald == null)
          {
            AppMethodBeat.o(107408);
            return;
          }
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(f.c(f.this));
          f.e.this.tkK.setVisibility(0);
          locala.QwU = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(107403);
              if ((f.e.this.tkK != null) && (!f.this.tkA)) {
                f.e.this.tkK.setVisibility(8);
              }
              AppMethodBeat.o(107403);
            }
          };
          locala.a(paramAnonymousView, new View.OnCreateContextMenuListener()new o.g
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(107404);
              paramAnonymous2View = com.tencent.mm.plugin.fav.a.b.d(locald.tkC.dLo);
              boolean bool1 = s.YS(paramAnonymous2View);
              boolean bool2 = ImgUtil.isGif(paramAnonymous2View);
              if ((!locald.tkD) && (bool1) && (!bool2))
              {
                paramAnonymous2ContextMenu.add(0, 0, 0, f.c(f.this).getString(2131759326));
                paramAnonymous2ContextMenu.add(0, 1, 0, f.c(f.this).getString(2131759275));
                paramAnonymous2ContextMenu.add(0, 2, 0, f.c(f.this).getString(2131759319));
              }
              for (;;)
              {
                if (bool1)
                {
                  paramAnonymous2View = locald.tkC.qNT;
                  if ((paramAnonymous2View != null) && ((paramAnonymous2View.field_type == 18) || (paramAnonymous2View.field_type == 14))) {
                    paramAnonymous2ContextMenu.add(0, 4, 0, f.c(f.this).getString(2131759234));
                  }
                  paramAnonymous2ContextMenu.add(0, 5, 0, 2131759173);
                }
                AppMethodBeat.o(107404);
                return;
                if ((locald.tkD) && (bool1) && (!bool2))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, f.c(f.this).getString(2131759326));
                  paramAnonymous2ContextMenu.add(0, 2, 0, f.c(f.this).getString(2131764871));
                }
                else
                {
                  Log.d("MicroMsg.MediaHistoryGalleryAdapter", "openPopupMenu, isVideo:%s, exist:%s, isGif:%s", new Object[] { Boolean.valueOf(locald.tkD), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                }
              }
            }
          }, new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(107406);
              String str = com.tencent.mm.plugin.fav.a.b.d(locald.tkC.dLo);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(107406);
                return;
                paramAnonymous2MenuItem = new ArrayList();
                paramAnonymous2MenuItem.add(locald.tkC);
                f.d(f.this).dM(paramAnonymous2MenuItem);
                AppMethodBeat.o(107406);
                return;
                h.w(locald.tkC.qNT.field_localId, 0);
                com.tencent.mm.plugin.fav.a.b.b(str, f.c(f.this));
                if (f.a(f.this) != null)
                {
                  f.a(f.this).cVR();
                  AppMethodBeat.o(107406);
                  return;
                  if (f.a(f.this) != null) {
                    f.a(f.this).cVP();
                  }
                  if (Util.isNullOrNil(str))
                  {
                    Log.w("MicroMsg.MediaHistoryGalleryAdapter", "save image fail, path is null");
                    AppMethodBeat.o(107406);
                    return;
                  }
                  if (!locald.tkD)
                  {
                    p.a(f.c(f.this), str, new p.a()
                    {
                      public final void bP(String paramAnonymous3String1, String paramAnonymous3String2)
                      {
                        AppMethodBeat.i(235368);
                        Toast.makeText(f.c(f.this), f.c(f.this).getString(2131758218, new Object[] { AndroidMediaUtil.getToastSysCameraPath() }), 1).show();
                        AppMethodBeat.o(235368);
                      }
                      
                      public final void bQ(String paramAnonymous3String1, String paramAnonymous3String2)
                      {
                        AppMethodBeat.i(235369);
                        Toast.makeText(f.c(f.this), f.c(f.this).getString(2131759318), 1).show();
                        AppMethodBeat.o(235369);
                      }
                    });
                    AppMethodBeat.o(107406);
                    return;
                  }
                  p.b(f.c(f.this), str, new p.a()
                  {
                    public final void bP(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(235370);
                      Log.i("MicroMsg.MediaHistoryGalleryAdapter", "save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                      Toast.makeText(f.c(f.this), f.c(f.this).getString(2131767076, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymous3String2) }), 1).show();
                      AppMethodBeat.o(235370);
                    }
                    
                    public final void bQ(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(235371);
                      Log.e("MicroMsg.MediaHistoryGalleryAdapter", "FAILURE save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                      Toast.makeText(f.c(f.this), f.c(f.this).getString(2131767075), 1).show();
                      AppMethodBeat.o(235371);
                    }
                  });
                  AppMethodBeat.o(107406);
                  return;
                  f.a(f.this, i, locald);
                  AppMethodBeat.o(107406);
                  return;
                  paramAnonymous2MenuItem = locald.tkC.qNT;
                  if ((paramAnonymous2MenuItem != null) && ((paramAnonymous2MenuItem.field_type == 18) || (paramAnonymous2MenuItem.field_type == 14)))
                  {
                    paramAnonymous2MenuItem = new com.tencent.mm.ui.widget.a.f.a(f.c(f.this));
                    paramAnonymous2MenuItem.bow(f.c(f.this).getString(2131759176));
                    paramAnonymous2MenuItem.boB(f.c(f.this).getString(2131759171));
                    paramAnonymous2MenuItem.boA(f.c(f.this).getString(2131759234));
                    paramAnonymous2MenuItem.a(new com.tencent.mm.ui.widget.a.f.c()new com.tencent.mm.ui.widget.a.f.c
                    {
                      public final void e(boolean paramAnonymous3Boolean, String paramAnonymous3String) {}
                    }, new com.tencent.mm.ui.widget.a.f.c()
                    {
                      public final void e(boolean paramAnonymous3Boolean, String paramAnonymous3String)
                      {
                        AppMethodBeat.i(235372);
                        f.a(f.this, f.e.4.3.this.keB, f.e.4.3.this.tkQ);
                        AppMethodBeat.o(235372);
                      }
                    });
                    paramAnonymous2MenuItem.show();
                    AppMethodBeat.o(107406);
                    return;
                  }
                  com.tencent.mm.plugin.fav.a.b.a(paramAnonymous2MenuItem, f.e(f.this));
                  if (f.a(f.this) != null) {
                    f.a(f.this).cWF();
                  }
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if (f.this.tkA)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(107407);
            return false;
          }
          if ((paramAnonymousView.getTag(2131309367) instanceof int[]))
          {
            localObject = (int[])paramAnonymousView.getTag(2131309367);
            t(paramAnonymousView, localObject[0], localObject[1]);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(107407);
            return true;
            t(paramAnonymousView, 0, 0);
          }
        }
      };
      this.tkI = ((ImageView)paramView.findViewById(2131302167));
      this.tkJ = paramView.findViewById(2131309835);
      this.tkL = paramView.findViewById(2131307900);
      this.qog = ((TextView)paramView.findViewById(2131309832));
      this.tkK = ((ImageView)paramView.findViewById(2131302170));
      this.checkBox = ((CheckBox)paramView.findViewById(2131304550));
      this.tkM = paramView.findViewById(2131304551);
      this.tkM.setVisibility(8);
      this.checkBox.setVisibility(8);
      this.tkJ.setVisibility(8);
      this.qog.setVisibility(8);
      this.tkL.setVisibility(8);
      this.tkI.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(107400);
          if (paramAnonymousMotionEvent.getAction() == 0) {
            paramAnonymousView.setTag(2131309367, new int[] { (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY() });
          }
          AppMethodBeat.o(107400);
          return false;
        }
      });
      this.tkI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107401);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = paramAnonymousView.getTag(2131300466);
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107401);
            return;
          }
          localObject = f.this.If(((Integer)localObject).intValue());
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107401);
            return;
          }
          f.a(f.this, (f.d)localObject);
          if (f.a(f.this) != null)
          {
            localObject = f.a(f.this);
            ((Integer)paramAnonymousView.getTag(2131300466)).intValue();
            ((f.b)localObject).cVN();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107401);
        }
      });
      this.tkI.setOnLongClickListener(this.tib);
      this.tkM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107402);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          boolean bool;
          if (!f.e.this.checkBox.isChecked())
          {
            bool = true;
            if (e.a.cWN().tkt.size() >= 9) {
              break label184;
            }
            f.e.this.checkBox.setChecked(bool);
            if (bool) {
              break label170;
            }
            f.e.this.tkK.setVisibility(8);
          }
          for (;;)
          {
            if (f.b(f.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = f.this.If(i);
              f.b(f.this).a(bool, paramAnonymousView, i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107402);
            return;
            bool = false;
            break;
            label170:
            f.e.this.tkK.setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f
 * JD-Core Version:    0.7.0.1
 */