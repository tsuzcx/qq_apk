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
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class f
  extends RecyclerView.a
{
  private Runnable dta;
  private c fSr;
  private Context mContext;
  private List<d> mYL;
  private boolean oSO;
  boolean oSR;
  private g.b rCB;
  c rCC;
  b rCD;
  boolean rCE;
  akf rxx;
  
  public f(Context paramContext, List<d> paramList, g.b paramb, Runnable paramRunnable)
  {
    AppMethodBeat.i(107410);
    this.mYL = null;
    this.fSr = null;
    this.oSO = true;
    this.rxx = new akf();
    this.rCE = false;
    this.mYL = paramList;
    this.oSO = com.tencent.mm.kernel.g.ajC().isSDCardAvailable();
    this.mContext = paramContext;
    this.rCB = paramb;
    this.dta = paramRunnable;
    paramList = new c.a();
    paramList.idu = 1;
    paramList.idL = true;
    paramList.hdS = (com.tencent.mm.cc.a.ip(paramContext) / 4);
    paramList.hdR = (com.tencent.mm.cc.a.ip(paramContext) / 4);
    paramList.idG = 2131100734;
    this.fSr = paramList.aJc();
    AppMethodBeat.o(107410);
  }
  
  private static long tH(long paramLong)
  {
    AppMethodBeat.i(107416);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.fJG().b(localDate);
    AppMethodBeat.o(107416);
    return paramLong;
  }
  
  public final d Eh(int paramInt)
  {
    AppMethodBeat.i(107418);
    if (paramInt < 0)
    {
      AppMethodBeat.o(107418);
      return null;
    }
    d locald = (d)this.mYL.get(paramInt);
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
    if (!this.oSO)
    {
      ad.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.oSO) });
      AppMethodBeat.o(107414);
      return;
    }
    Object localObject1 = Eh(paramInt);
    if (paramw.auy == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (tH(Eh(paramInt + 1).timeStamp) != tH(((d)localObject1).timeStamp)))
      {
        ((a)paramw).iUW.setVisibility(8);
        AppMethodBeat.o(107414);
        return;
      }
      ((a)paramw).iUW.setVisibility(0);
      ((a)paramw).iUW.setText(tG(((d)localObject1).timeStamp));
      if (this.oSR)
      {
        ((a)paramw).progressBar.setVisibility(0);
        AppMethodBeat.o(107414);
        return;
      }
      ((a)paramw).progressBar.setVisibility(8);
      AppMethodBeat.o(107414);
      return;
    }
    ((e)paramw).rCL.setTag(2131299792, Integer.valueOf(paramInt));
    ((e)paramw).rCP.setTag(Integer.valueOf(paramInt));
    if (((d)localObject1).rCH)
    {
      Object localObject2 = q.aIJ();
      String str = ((d)localObject1).imagePath;
      ImageView localImageView = ((e)paramw).rCL;
      c.a locala = new c.a();
      locala.idL = true;
      locala.idG = 2131100734;
      ((com.tencent.mm.aw.a.a)localObject2).a(str, localImageView, locala.aJc());
      if (!((d)localObject1).pzW) {
        break label503;
      }
      ((e)paramw).rCM.setVisibility(0);
      ((e)paramw).oSG.setVisibility(0);
      ((e)paramw).oSG.setText(bt.bI(((d)localObject1).rCI.rCJ, ""));
      label330:
      ((e)paramw).rCL.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(107396);
          ((f.e)paramw).rCL.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          ((f.e)paramw).rCN.setLayoutParams(new RelativeLayout.LayoutParams(((f.e)paramw).rCL.getWidth(), ((f.e)paramw).rCL.getHeight()));
          AppMethodBeat.o(107396);
        }
      });
      if (!this.rCE) {
        break label565;
      }
      ((e)paramw).rCP.setVisibility(0);
      ((e)paramw).iCK.setVisibility(0);
      localObject2 = e.a.cxj();
      localObject1 = ((d)localObject1).rCG;
      if (localObject1 == null) {
        break label530;
      }
      localObject2 = ((e)localObject2).rCx.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (!((d)((Iterator)localObject2).next()).dsX.dsU.equals(((d)localObject1).dsX.dsU));
    }
    label530:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label535;
      }
      ((e)paramw).rCN.setVisibility(0);
      ((e)paramw).iCK.setChecked(true);
      AppMethodBeat.o(107414);
      return;
      q.aIJ().a(((d)localObject1).imagePath, ((e)paramw).rCL, this.fSr);
      break;
      label503:
      ((e)paramw).oSG.setVisibility(8);
      ((e)paramw).rCM.setVisibility(8);
      break label330;
    }
    label535:
    ((e)paramw).rCN.setVisibility(8);
    ((e)paramw).iCK.setChecked(false);
    AppMethodBeat.o(107414);
    return;
    label565:
    ((e)paramw).rCN.setVisibility(8);
    ((e)paramw).rCP.setVisibility(8);
    ((e)paramw).iCK.setVisibility(8);
    AppMethodBeat.o(107414);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt, List paramList)
  {
    AppMethodBeat.i(107413);
    if ((paramList != null) && (paramList.size() > 0) && ((paramw instanceof e)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((e)paramw).iCK.setChecked(false);
        ((e)paramw).iCK.setVisibility(0);
        ((e)paramw).rCP.setVisibility(0);
        AppMethodBeat.o(107413);
        return;
      }
      ((e)paramw).iCK.setChecked(false);
      ((e)paramw).iCK.setVisibility(8);
      ((e)paramw).rCP.setVisibility(8);
      AppMethodBeat.o(107413);
      return;
    }
    super.a(paramw, paramInt, paramList);
    AppMethodBeat.o(107413);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(107417);
    int i = this.mYL.size();
    AppMethodBeat.o(107417);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(107411);
    paramInt = Eh(paramInt).type;
    AppMethodBeat.o(107411);
    return paramInt;
  }
  
  public final String tG(long paramLong)
  {
    AppMethodBeat.i(107415);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.fJG().a((Date)localObject, this.mContext);
    AppMethodBeat.o(107415);
    return localObject;
  }
  
  public final class a
    extends RecyclerView.w
  {
    TextView iUW;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(107397);
      this.iUW = ((TextView)paramView.findViewById(2131298930));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131301489));
      AppMethodBeat.o(107397);
    }
  }
  
  public static abstract interface b
  {
    public abstract void cwi();
    
    public abstract void cwk();
    
    public abstract void cwl();
    
    public abstract void cwm();
    
    public abstract void cxb();
  }
  
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, f.d paramd, int paramInt);
  }
  
  public static final class d
  {
    public String imagePath;
    boolean pzW;
    public d rCG;
    boolean rCH;
    public a rCI;
    public long timeStamp;
    public int type;
    
    public d(d paramd)
    {
      AppMethodBeat.i(107399);
      this.type = 0;
      this.rCI = new a();
      this.rCG = paramd;
      Object localObject;
      if (paramd.cxg()) {
        localObject = paramd.dsX.dnv;
      }
      for (;;)
      {
        this.imagePath = ((String)localObject);
        this.timeStamp = paramd.prW.field_updateTime;
        if ((paramd.cxf()) || (paramd.cxh()))
        {
          this.pzW = true;
          this.rCI.rCJ = bt.qY(paramd.dsX.duration);
        }
        if (paramd.cxg()) {
          this.rCH = true;
        }
        AppMethodBeat.o(107399);
        return;
        if ((paramd.cxf()) || (paramd.cxh()))
        {
          localObject = com.tencent.mm.plugin.fav.a.b.a(paramd.dsX);
        }
        else
        {
          String str = com.tencent.mm.plugin.fav.a.b.d(paramd.dsX);
          localObject = str;
          if (!new com.tencent.mm.vfs.e(str).exists()) {
            localObject = com.tencent.mm.plugin.fav.a.b.a(paramd.dsX);
          }
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(107398);
      if ((this.rCG != null) && ((paramObject instanceof d)) && (paramObject != null))
      {
        bool = this.rCG.dsX.dsU.equals(((d)paramObject).dsX.dsU);
        AppMethodBeat.o(107398);
        return bool;
      }
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(107398);
      return bool;
    }
    
    final class a
    {
      public String rCJ;
      
      a() {}
    }
  }
  
  public final class e
    extends RecyclerView.w
  {
    CheckBox iCK;
    TextView oSG;
    View.OnLongClickListener rAj;
    ImageView rCL;
    View rCM;
    ImageView rCN;
    View rCO;
    View rCP;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(107409);
      this.rAj = new View.OnLongClickListener()
      {
        private void u(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107408);
          final int i = ((Integer)paramAnonymousView.getTag(2131299792)).intValue();
          final f.d locald = f.this.Eh(i);
          if (locald == null)
          {
            AppMethodBeat.o(107408);
            return;
          }
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(f.c(f.this));
          f.e.this.rCN.setVisibility(0);
          locala.KLB = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(107403);
              if ((f.e.this.rCN != null) && (!f.this.rCE)) {
                f.e.this.rCN.setVisibility(8);
              }
              AppMethodBeat.o(107403);
            }
          };
          locala.a(paramAnonymousView, new View.OnCreateContextMenuListener()new n.e
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(107404);
              paramAnonymous2View = com.tencent.mm.plugin.fav.a.b.d(locald.rCG.dsX);
              boolean bool1 = i.fv(paramAnonymous2View);
              boolean bool2 = t.aQj(paramAnonymous2View);
              if ((!locald.pzW) && (bool1) && (!bool2))
              {
                paramAnonymous2ContextMenu.add(0, 0, 0, f.c(f.this).getString(2131759001));
                paramAnonymous2ContextMenu.add(0, 1, 0, f.c(f.this).getString(2131758951));
                paramAnonymous2ContextMenu.add(0, 2, 0, f.c(f.this).getString(2131758994));
              }
              for (;;)
              {
                if (bool1)
                {
                  paramAnonymous2View = locald.rCG.prW;
                  if ((paramAnonymous2View != null) && ((paramAnonymous2View.field_type == 18) || (paramAnonymous2View.field_type == 14))) {
                    paramAnonymous2ContextMenu.add(0, 4, 0, f.c(f.this).getString(2131758910));
                  }
                  paramAnonymous2ContextMenu.add(0, 5, 0, 2131758850);
                }
                AppMethodBeat.o(107404);
                return;
                if ((locald.pzW) && (bool1) && (!bool2))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, f.c(f.this).getString(2131759001));
                  paramAnonymous2ContextMenu.add(0, 2, 0, f.c(f.this).getString(2131762784));
                }
                else
                {
                  ad.d("MicroMsg.MediaHistoryGalleryAdapter", "openPopupMenu, isVideo:%s, exist:%s, isGif:%s", new Object[] { Boolean.valueOf(locald.pzW), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                }
              }
            }
          }, new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(107406);
              String str = com.tencent.mm.plugin.fav.a.b.d(locald.rCG.dsX);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(107406);
                return;
                paramAnonymous2MenuItem = new ArrayList();
                paramAnonymous2MenuItem.add(locald.rCG);
                f.d(f.this).dv(paramAnonymous2MenuItem);
                AppMethodBeat.o(107406);
                return;
                h.i(locald.rCG.prW.field_localId, 0, 0);
                com.tencent.mm.plugin.fav.a.b.b(str, f.c(f.this));
                if (f.a(f.this) != null)
                {
                  f.a(f.this).cwm();
                  AppMethodBeat.o(107406);
                  return;
                  if (f.a(f.this) != null) {
                    f.a(f.this).cwk();
                  }
                  if (bt.isNullOrNil(str))
                  {
                    ad.w("MicroMsg.MediaHistoryGalleryAdapter", "save image fail, path is null");
                    AppMethodBeat.o(107406);
                    return;
                  }
                  if (!locald.pzW)
                  {
                    p.a(f.c(f.this), str, new p.a()
                    {
                      public final void bF(String paramAnonymous3String1, String paramAnonymous3String2)
                      {
                        AppMethodBeat.i(218821);
                        Toast.makeText(f.c(f.this), f.c(f.this).getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.ffp() }), 1).show();
                        AppMethodBeat.o(218821);
                      }
                      
                      public final void bG(String paramAnonymous3String1, String paramAnonymous3String2)
                      {
                        AppMethodBeat.i(218822);
                        Toast.makeText(f.c(f.this), f.c(f.this).getString(2131758993), 1).show();
                        AppMethodBeat.o(218822);
                      }
                    });
                    AppMethodBeat.o(107406);
                    return;
                  }
                  p.b(f.c(f.this), str, new p.a()
                  {
                    public final void bF(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(218823);
                      ad.i("MicroMsg.MediaHistoryGalleryAdapter", "save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                      Toast.makeText(f.c(f.this), f.c(f.this).getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aRB(paramAnonymous3String2) }), 1).show();
                      AppMethodBeat.o(218823);
                    }
                    
                    public final void bG(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(218824);
                      ad.e("MicroMsg.MediaHistoryGalleryAdapter", "FAILURE save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                      Toast.makeText(f.c(f.this), f.c(f.this).getString(2131764682), 1).show();
                      AppMethodBeat.o(218824);
                    }
                  });
                  AppMethodBeat.o(107406);
                  return;
                  f.a(f.this, i, locald);
                  AppMethodBeat.o(107406);
                  return;
                  paramAnonymous2MenuItem = locald.rCG.prW;
                  if ((paramAnonymous2MenuItem != null) && ((paramAnonymous2MenuItem.field_type == 18) || (paramAnonymous2MenuItem.field_type == 14)))
                  {
                    paramAnonymous2MenuItem = new com.tencent.mm.ui.widget.a.f.a(f.c(f.this));
                    paramAnonymous2MenuItem.aXO(f.c(f.this).getString(2131758853));
                    paramAnonymous2MenuItem.aXT(f.c(f.this).getString(2131758848));
                    paramAnonymous2MenuItem.aXS(f.c(f.this).getString(2131758910));
                    paramAnonymous2MenuItem.a(new com.tencent.mm.ui.widget.a.f.c()new com.tencent.mm.ui.widget.a.f.c
                    {
                      public final void d(boolean paramAnonymous3Boolean, String paramAnonymous3String) {}
                    }, new com.tencent.mm.ui.widget.a.f.c()
                    {
                      public final void d(boolean paramAnonymous3Boolean, String paramAnonymous3String)
                      {
                        AppMethodBeat.i(218825);
                        f.a(f.this, f.e.4.3.this.jdE, f.e.4.3.this.rCT);
                        AppMethodBeat.o(218825);
                      }
                    });
                    paramAnonymous2MenuItem.show();
                    AppMethodBeat.o(107406);
                    return;
                  }
                  com.tencent.mm.plugin.fav.a.b.a(paramAnonymous2MenuItem, f.e(f.this));
                  if (f.a(f.this) != null) {
                    f.a(f.this).cxb();
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if (f.this.rCE)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(107407);
            return false;
          }
          if ((paramAnonymousView.getTag(2131306044) instanceof int[]))
          {
            localObject = (int[])paramAnonymousView.getTag(2131306044);
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
      this.rCL = ((ImageView)paramView.findViewById(2131300612));
      this.rCM = paramView.findViewById(2131306404);
      this.rCO = paramView.findViewById(2131304817);
      this.oSG = ((TextView)paramView.findViewById(2131306401));
      this.rCN = ((ImageView)paramView.findViewById(2131300615));
      this.iCK = ((CheckBox)paramView.findViewById(2131302204));
      this.rCP = paramView.findViewById(2131302205);
      this.rCP.setVisibility(8);
      this.iCK.setVisibility(8);
      this.rCM.setVisibility(8);
      this.oSG.setVisibility(8);
      this.rCO.setVisibility(8);
      this.rCL.setOnTouchListener(new f.e.1(this, f.this));
      this.rCL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107401);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = f.this.Eh(((Integer)paramAnonymousView.getTag(2131299792)).intValue());
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
            ((f.b)localObject).cwi();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107401);
        }
      });
      this.rCL.setOnLongClickListener(this.rAj);
      this.rCP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107402);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          boolean bool;
          if (!f.e.this.iCK.isChecked())
          {
            bool = true;
            if (e.a.cxj().rCx.size() >= 9) {
              break label184;
            }
            f.e.this.iCK.setChecked(bool);
            if (bool) {
              break label170;
            }
            f.e.this.rCN.setVisibility(8);
          }
          for (;;)
          {
            if (f.b(f.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = f.this.Eh(i);
              f.b(f.this).a(bool, paramAnonymousView, i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/MediaHistoryGalleryAdapter$ViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107402);
            return;
            bool = false;
            break;
            label170:
            f.e.this.rCN.setVisibility(0);
            continue;
            label184:
            if (!bool) {
              f.e.this.iCK.setChecked(false);
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