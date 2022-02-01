package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
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
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class f
  extends RecyclerView.a
{
  private Runnable dug;
  private c fUx;
  private Context mContext;
  private List<d> ndS;
  private boolean oZq;
  boolean oZt;
  akp rFI;
  private g.b rKM;
  c rKN;
  b rKO;
  boolean rKP;
  
  public f(Context paramContext, List<d> paramList, g.b paramb, Runnable paramRunnable)
  {
    AppMethodBeat.i(107410);
    this.ndS = null;
    this.fUx = null;
    this.oZq = true;
    this.rFI = new akp();
    this.rKP = false;
    this.ndS = paramList;
    this.oZq = com.tencent.mm.kernel.g.ajR().isSDCardAvailable();
    this.mContext = paramContext;
    this.rKM = paramb;
    this.dug = paramRunnable;
    paramList = new c.a();
    paramList.ign = 1;
    paramList.igD = true;
    paramList.hgG = (com.tencent.mm.cb.a.iu(paramContext) / 4);
    paramList.hgF = (com.tencent.mm.cb.a.iu(paramContext) / 4);
    paramList.igy = 2131100734;
    this.fUx = paramList.aJu();
    AppMethodBeat.o(107410);
  }
  
  private static long tY(long paramLong)
  {
    AppMethodBeat.i(107416);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.fNX().b(localDate);
    AppMethodBeat.o(107416);
    return paramLong;
  }
  
  public final d Eu(int paramInt)
  {
    AppMethodBeat.i(107418);
    if (paramInt < 0)
    {
      AppMethodBeat.o(107418);
      return null;
    }
    d locald = (d)this.ndS.get(paramInt);
    AppMethodBeat.o(107418);
    return locald;
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(107412);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493950, paramViewGroup, false));
      AppMethodBeat.o(107412);
      return paramViewGroup;
    }
    paramViewGroup = new e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493951, paramViewGroup, false));
    AppMethodBeat.o(107412);
    return paramViewGroup;
  }
  
  public final void a(final RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(107414);
    if (!this.oZq)
    {
      ae.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.oZq) });
      AppMethodBeat.o(107414);
      return;
    }
    Object localObject1 = Eu(paramInt);
    if (paramw.auy == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (tY(Eu(paramInt + 1).timeStamp) != tY(((d)localObject1).timeStamp)))
      {
        ((a)paramw).iXP.setVisibility(8);
        AppMethodBeat.o(107414);
        return;
      }
      ((a)paramw).iXP.setVisibility(0);
      ((a)paramw).iXP.setText(tX(((d)localObject1).timeStamp));
      if (this.oZt)
      {
        ((a)paramw).progressBar.setVisibility(0);
        AppMethodBeat.o(107414);
        return;
      }
      ((a)paramw).progressBar.setVisibility(8);
      AppMethodBeat.o(107414);
      return;
    }
    ((e)paramw).rKW.setTag(2131299792, Integer.valueOf(paramInt));
    ((e)paramw).rLa.setTag(Integer.valueOf(paramInt));
    if (((d)localObject1).rKS)
    {
      Object localObject2 = q.aJb();
      String str = ((d)localObject1).imagePath;
      ImageView localImageView = ((e)paramw).rKW;
      c.a locala = new c.a();
      locala.igD = true;
      locala.igy = 2131100734;
      ((com.tencent.mm.av.a.a)localObject2).a(str, localImageView, locala.aJu());
      if (!((d)localObject1).pGA) {
        break label503;
      }
      ((e)paramw).rKX.setVisibility(0);
      ((e)paramw).oZi.setVisibility(0);
      ((e)paramw).oZi.setText(bu.bI(((d)localObject1).rKT.rKU, ""));
      label330:
      ((e)paramw).rKW.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(107396);
          ((f.e)paramw).rKW.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          ((f.e)paramw).rKY.setLayoutParams(new RelativeLayout.LayoutParams(((f.e)paramw).rKW.getWidth(), ((f.e)paramw).rKW.getHeight()));
          AppMethodBeat.o(107396);
        }
      });
      if (!this.rKP) {
        break label565;
      }
      ((e)paramw).rLa.setVisibility(0);
      ((e)paramw).iFD.setVisibility(0);
      localObject2 = e.a.cyK();
      localObject1 = ((d)localObject1).rKR;
      if (localObject1 == null) {
        break label530;
      }
      localObject2 = ((e)localObject2).rKI.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (!((d)((Iterator)localObject2).next()).dud.dua.equals(((d)localObject1).dud.dua));
    }
    label530:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label535;
      }
      ((e)paramw).rKY.setVisibility(0);
      ((e)paramw).iFD.setChecked(true);
      AppMethodBeat.o(107414);
      return;
      q.aJb().a(((d)localObject1).imagePath, ((e)paramw).rKW, this.fUx);
      break;
      label503:
      ((e)paramw).oZi.setVisibility(8);
      ((e)paramw).rKX.setVisibility(8);
      break label330;
    }
    label535:
    ((e)paramw).rKY.setVisibility(8);
    ((e)paramw).iFD.setChecked(false);
    AppMethodBeat.o(107414);
    return;
    label565:
    ((e)paramw).rKY.setVisibility(8);
    ((e)paramw).rLa.setVisibility(8);
    ((e)paramw).iFD.setVisibility(8);
    AppMethodBeat.o(107414);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt, List paramList)
  {
    AppMethodBeat.i(107413);
    if ((paramList != null) && (paramList.size() > 0) && ((paramw instanceof e)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((e)paramw).iFD.setChecked(false);
        ((e)paramw).iFD.setVisibility(0);
        ((e)paramw).rLa.setVisibility(0);
        AppMethodBeat.o(107413);
        return;
      }
      ((e)paramw).iFD.setChecked(false);
      ((e)paramw).iFD.setVisibility(8);
      ((e)paramw).rLa.setVisibility(8);
      AppMethodBeat.o(107413);
      return;
    }
    super.a(paramw, paramInt, paramList);
    AppMethodBeat.o(107413);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(107417);
    int i = this.ndS.size();
    AppMethodBeat.o(107417);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(107411);
    paramInt = Eu(paramInt).type;
    AppMethodBeat.o(107411);
    return paramInt;
  }
  
  public final String tX(long paramLong)
  {
    AppMethodBeat.i(107415);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.fNX().a((Date)localObject, this.mContext);
    AppMethodBeat.o(107415);
    return localObject;
  }
  
  public final class a
    extends RecyclerView.w
  {
    TextView iXP;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(107397);
      this.iXP = ((TextView)paramView.findViewById(2131298930));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131301489));
      AppMethodBeat.o(107397);
    }
  }
  
  public static abstract interface b
  {
    public abstract void cxJ();
    
    public abstract void cxL();
    
    public abstract void cxM();
    
    public abstract void cxN();
    
    public abstract void cyC();
  }
  
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, f.d paramd, int paramInt);
  }
  
  public static final class d
  {
    public String imagePath;
    boolean pGA;
    public d rKR;
    boolean rKS;
    public a rKT;
    public long timeStamp;
    public int type;
    
    public d(d paramd)
    {
      AppMethodBeat.i(107399);
      this.type = 0;
      this.rKT = new a();
      this.rKR = paramd;
      Object localObject;
      if (paramd.cyH()) {
        localObject = paramd.dud.dox;
      }
      for (;;)
      {
        this.imagePath = ((String)localObject);
        this.timeStamp = paramd.pyC.field_updateTime;
        if ((paramd.cyG()) || (paramd.cyI()))
        {
          this.pGA = true;
          this.rKT.rKU = bu.rb(paramd.dud.duration);
        }
        if (paramd.cyH()) {
          this.rKS = true;
        }
        AppMethodBeat.o(107399);
        return;
        if ((paramd.cyG()) || (paramd.cyI()))
        {
          localObject = com.tencent.mm.plugin.fav.a.b.a(paramd.dud);
        }
        else
        {
          String str = com.tencent.mm.plugin.fav.a.b.d(paramd.dud);
          localObject = str;
          if (!new k(str).exists()) {
            localObject = com.tencent.mm.plugin.fav.a.b.a(paramd.dud);
          }
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(107398);
      if ((this.rKR != null) && ((paramObject instanceof d)) && (paramObject != null))
      {
        bool = this.rKR.dud.dua.equals(((d)paramObject).dud.dua);
        AppMethodBeat.o(107398);
        return bool;
      }
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(107398);
      return bool;
    }
    
    final class a
    {
      public String rKU;
      
      a() {}
    }
  }
  
  public final class e
    extends RecyclerView.w
  {
    CheckBox iFD;
    TextView oZi;
    View.OnLongClickListener rIu;
    ImageView rKW;
    View rKX;
    ImageView rKY;
    View rKZ;
    View rLa;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(107409);
      this.rIu = new View.OnLongClickListener()
      {
        private void t(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107408);
          final int i = ((Integer)paramAnonymousView.getTag(2131299792)).intValue();
          final f.d locald = f.this.Eu(i);
          if (locald == null)
          {
            AppMethodBeat.o(107408);
            return;
          }
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(f.c(f.this));
          f.e.this.rKY.setVisibility(0);
          locala.LhV = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(107403);
              if ((f.e.this.rKY != null) && (!f.this.rKP)) {
                f.e.this.rKY.setVisibility(8);
              }
              AppMethodBeat.o(107403);
            }
          };
          locala.a(paramAnonymousView, new View.OnCreateContextMenuListener()new n.e
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(107404);
              paramAnonymous2View = com.tencent.mm.plugin.fav.a.b.d(locald.rKR.dud);
              boolean bool1 = o.fB(paramAnonymous2View);
              boolean bool2 = u.aRG(paramAnonymous2View);
              if ((!locald.pGA) && (bool1) && (!bool2))
              {
                paramAnonymous2ContextMenu.add(0, 0, 0, f.c(f.this).getString(2131759001));
                paramAnonymous2ContextMenu.add(0, 1, 0, f.c(f.this).getString(2131758951));
                paramAnonymous2ContextMenu.add(0, 2, 0, f.c(f.this).getString(2131758994));
              }
              for (;;)
              {
                if (bool1)
                {
                  paramAnonymous2View = locald.rKR.pyC;
                  if ((paramAnonymous2View != null) && ((paramAnonymous2View.field_type == 18) || (paramAnonymous2View.field_type == 14))) {
                    paramAnonymous2ContextMenu.add(0, 4, 0, f.c(f.this).getString(2131758910));
                  }
                  paramAnonymous2ContextMenu.add(0, 5, 0, 2131758850);
                }
                AppMethodBeat.o(107404);
                return;
                if ((locald.pGA) && (bool1) && (!bool2))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, f.c(f.this).getString(2131759001));
                  paramAnonymous2ContextMenu.add(0, 2, 0, f.c(f.this).getString(2131762784));
                }
                else
                {
                  ae.d("MicroMsg.MediaHistoryGalleryAdapter", "openPopupMenu, isVideo:%s, exist:%s, isGif:%s", new Object[] { Boolean.valueOf(locald.pGA), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                }
              }
            }
          }, new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(107406);
              String str = com.tencent.mm.plugin.fav.a.b.d(locald.rKR.dud);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(107406);
                return;
                paramAnonymous2MenuItem = new ArrayList();
                paramAnonymous2MenuItem.add(locald.rKR);
                f.d(f.this).dy(paramAnonymous2MenuItem);
                AppMethodBeat.o(107406);
                return;
                h.i(locald.rKR.pyC.field_localId, 0, 0);
                com.tencent.mm.plugin.fav.a.b.b(str, f.c(f.this));
                if (f.a(f.this) != null)
                {
                  f.a(f.this).cxN();
                  AppMethodBeat.o(107406);
                  return;
                  if (f.a(f.this) != null) {
                    f.a(f.this).cxL();
                  }
                  if (bu.isNullOrNil(str))
                  {
                    ae.w("MicroMsg.MediaHistoryGalleryAdapter", "save image fail, path is null");
                    AppMethodBeat.o(107406);
                    return;
                  }
                  if (!locald.pGA)
                  {
                    p.a(f.c(f.this), str, new p.a()
                    {
                      public final void bF(String paramAnonymous3String1, String paramAnonymous3String2)
                      {
                        AppMethodBeat.i(191096);
                        Toast.makeText(f.c(f.this), f.c(f.this).getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.fjf() }), 1).show();
                        AppMethodBeat.o(191096);
                      }
                      
                      public final void bG(String paramAnonymous3String1, String paramAnonymous3String2)
                      {
                        AppMethodBeat.i(191097);
                        Toast.makeText(f.c(f.this), f.c(f.this).getString(2131758993), 1).show();
                        AppMethodBeat.o(191097);
                      }
                    });
                    AppMethodBeat.o(107406);
                    return;
                  }
                  p.b(f.c(f.this), str, new p.a()
                  {
                    public final void bF(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(191098);
                      ae.i("MicroMsg.MediaHistoryGalleryAdapter", "save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                      Toast.makeText(f.c(f.this), f.c(f.this).getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aSY(paramAnonymous3String2) }), 1).show();
                      AppMethodBeat.o(191098);
                    }
                    
                    public final void bG(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(191099);
                      ae.e("MicroMsg.MediaHistoryGalleryAdapter", "FAILURE save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                      Toast.makeText(f.c(f.this), f.c(f.this).getString(2131764682), 1).show();
                      AppMethodBeat.o(191099);
                    }
                  });
                  AppMethodBeat.o(107406);
                  return;
                  f.a(f.this, i, locald);
                  AppMethodBeat.o(107406);
                  return;
                  paramAnonymous2MenuItem = locald.rKR.pyC;
                  if ((paramAnonymous2MenuItem != null) && ((paramAnonymous2MenuItem.field_type == 18) || (paramAnonymous2MenuItem.field_type == 14)))
                  {
                    paramAnonymous2MenuItem = new com.tencent.mm.ui.widget.a.f.a(f.c(f.this));
                    paramAnonymous2MenuItem.aZq(f.c(f.this).getString(2131758853));
                    paramAnonymous2MenuItem.aZv(f.c(f.this).getString(2131758848));
                    paramAnonymous2MenuItem.aZu(f.c(f.this).getString(2131758910));
                    paramAnonymous2MenuItem.a(new com.tencent.mm.ui.widget.a.f.c()new com.tencent.mm.ui.widget.a.f.c
                    {
                      public final void d(boolean paramAnonymous3Boolean, String paramAnonymous3String) {}
                    }, new com.tencent.mm.ui.widget.a.f.c()
                    {
                      public final void d(boolean paramAnonymous3Boolean, String paramAnonymous3String)
                      {
                        AppMethodBeat.i(191100);
                        f.a(f.this, f.e.4.3.this.jgx, f.e.4.3.this.rLe);
                        AppMethodBeat.o(191100);
                      }
                    });
                    paramAnonymous2MenuItem.show();
                    AppMethodBeat.o(107406);
                    return;
                  }
                  com.tencent.mm.plugin.fav.a.b.a(paramAnonymous2MenuItem, f.e(f.this));
                  if (f.a(f.this) != null) {
                    f.a(f.this).cyC();
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if (f.this.rKP)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(107407);
            return false;
          }
          if ((paramAnonymousView.getTag(2131306044) instanceof int[]))
          {
            localObject = (int[])paramAnonymousView.getTag(2131306044);
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
      this.rKW = ((ImageView)paramView.findViewById(2131300612));
      this.rKX = paramView.findViewById(2131306404);
      this.rKZ = paramView.findViewById(2131304817);
      this.oZi = ((TextView)paramView.findViewById(2131306401));
      this.rKY = ((ImageView)paramView.findViewById(2131300615));
      this.iFD = ((CheckBox)paramView.findViewById(2131302204));
      this.rLa = paramView.findViewById(2131302205);
      this.rLa.setVisibility(8);
      this.iFD.setVisibility(8);
      this.rKX.setVisibility(8);
      this.oZi.setVisibility(8);
      this.rKZ.setVisibility(8);
      this.rKW.setOnTouchListener(new f.e.1(this, f.this));
      this.rKW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107401);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = f.this.Eu(((Integer)paramAnonymousView.getTag(2131299792)).intValue());
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
            ((Integer)paramAnonymousView.getTag(2131299792)).intValue();
            ((f.b)localObject).cxJ();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107401);
        }
      });
      this.rKW.setOnLongClickListener(this.rIu);
      this.rLa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107402);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          boolean bool;
          if (!f.e.this.iFD.isChecked())
          {
            bool = true;
            if (e.a.cyK().rKI.size() >= 9) {
              break label184;
            }
            f.e.this.iFD.setChecked(bool);
            if (bool) {
              break label170;
            }
            f.e.this.rKY.setVisibility(8);
          }
          for (;;)
          {
            if (f.b(f.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = f.this.Eu(i);
              f.b(f.this).a(bool, paramAnonymousView, i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107402);
            return;
            bool = false;
            break;
            label170:
            f.e.this.rKY.setVisibility(0);
            continue;
            label184:
            if (!bool) {
              f.e.this.iFD.setChecked(false);
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