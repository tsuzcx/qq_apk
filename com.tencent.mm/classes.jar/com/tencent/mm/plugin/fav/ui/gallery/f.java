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
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class f
  extends RecyclerView.a
{
  private Runnable dkh;
  private c fvx;
  private List<c> lWb;
  private Context mContext;
  private boolean nMt;
  boolean nMw;
  agq qeT;
  private g.b qjX;
  b qjY;
  boolean qjZ;
  
  public f(Context paramContext, List<c> paramList, g.b paramb, Runnable paramRunnable)
  {
    AppMethodBeat.i(107410);
    this.lWb = null;
    this.fvx = null;
    this.nMt = true;
    this.qeT = new agq();
    this.qjZ = false;
    this.lWb = paramList;
    this.nMt = com.tencent.mm.kernel.g.afB().isSDCardAvailable();
    this.mContext = paramContext;
    this.qjX = paramb;
    this.dkh = paramRunnable;
    paramList = new c.a();
    paramList.hjX = 1;
    paramList.hkn = true;
    paramList.gjw = (com.tencent.mm.cd.a.hV(paramContext) / 4);
    paramList.gjv = (com.tencent.mm.cd.a.hV(paramContext) / 4);
    paramList.hki = 2131100734;
    this.fvx = paramList.azc();
    AppMethodBeat.o(107410);
  }
  
  private static long nW(long paramLong)
  {
    AppMethodBeat.i(107416);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.fcX().b(localDate);
    AppMethodBeat.o(107416);
    return paramLong;
  }
  
  public final c Ct(int paramInt)
  {
    AppMethodBeat.i(107418);
    if (paramInt < 0)
    {
      AppMethodBeat.o(107418);
      return null;
    }
    c localc = (c)this.lWb.get(paramInt);
    AppMethodBeat.o(107418);
    return localc;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(107412);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493950, paramViewGroup, false));
      AppMethodBeat.o(107412);
      return paramViewGroup;
    }
    paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493951, paramViewGroup, false));
    AppMethodBeat.o(107412);
    return paramViewGroup;
  }
  
  public final void a(final RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(107414);
    if (!this.nMt)
    {
      ad.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.nMt) });
      AppMethodBeat.o(107414);
      return;
    }
    Object localObject1 = Ct(paramInt);
    if (paramv.arM == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (nW(Ct(paramInt + 1).timeStamp) != nW(((c)localObject1).timeStamp)))
      {
        ((a)paramv).ibF.setVisibility(8);
        AppMethodBeat.o(107414);
        return;
      }
      ((a)paramv).ibF.setVisibility(0);
      ((a)paramv).ibF.setText(nV(((c)localObject1).timeStamp));
      if (this.nMw)
      {
        ((a)paramv).progressBar.setVisibility(0);
        AppMethodBeat.o(107414);
        return;
      }
      ((a)paramv).progressBar.setVisibility(8);
      AppMethodBeat.o(107414);
      return;
    }
    ((d)paramv).qkg.setTag(2131299792, Integer.valueOf(paramInt));
    ((d)paramv).qkk.setTag(Integer.valueOf(paramInt));
    if (((c)localObject1).qkc)
    {
      Object localObject2 = o.ayJ();
      String str = ((c)localObject1).imagePath;
      ImageView localImageView = ((d)paramv).qkg;
      c.a locala = new c.a();
      locala.hkn = true;
      locala.hki = 2131100734;
      ((com.tencent.mm.aw.a.a)localObject2).a(str, localImageView, locala.azc());
      if (!((c)localObject1).osM) {
        break label503;
      }
      ((d)paramv).qkh.setVisibility(0);
      ((d)paramv).nMl.setVisibility(0);
      ((d)paramv).nMl.setText(bt.by(((c)localObject1).qkd.qke, ""));
      label330:
      ((d)paramv).qkg.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(107396);
          ((f.d)paramv).qkg.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          ((f.d)paramv).qki.setLayoutParams(new RelativeLayout.LayoutParams(((f.d)paramv).qkg.getWidth(), ((f.d)paramv).qkg.getHeight()));
          AppMethodBeat.o(107396);
        }
      });
      if (!this.qjZ) {
        break label565;
      }
      ((d)paramv).qkk.setVisibility(0);
      ((d)paramv).hIS.setVisibility(0);
      localObject2 = e.a.cjQ();
      localObject1 = ((c)localObject1).qkb;
      if (localObject1 == null) {
        break label530;
      }
      localObject2 = ((e)localObject2).qjT.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (!((d)((Iterator)localObject2).next()).dke.dkb.equals(((d)localObject1).dke.dkb));
    }
    label530:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label535;
      }
      ((d)paramv).qki.setVisibility(0);
      ((d)paramv).hIS.setChecked(true);
      AppMethodBeat.o(107414);
      return;
      o.ayJ().a(((c)localObject1).imagePath, ((d)paramv).qkg, this.fvx);
      break;
      label503:
      ((d)paramv).nMl.setVisibility(8);
      ((d)paramv).qkh.setVisibility(8);
      break label330;
    }
    label535:
    ((d)paramv).qki.setVisibility(8);
    ((d)paramv).hIS.setChecked(false);
    AppMethodBeat.o(107414);
    return;
    label565:
    ((d)paramv).qki.setVisibility(8);
    ((d)paramv).qkk.setVisibility(8);
    ((d)paramv).hIS.setVisibility(8);
    AppMethodBeat.o(107414);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(107413);
    if ((paramList != null) && (paramList.size() > 0) && ((paramv instanceof d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((d)paramv).hIS.setChecked(false);
        ((d)paramv).hIS.setVisibility(0);
        ((d)paramv).qkk.setVisibility(0);
        AppMethodBeat.o(107413);
        return;
      }
      ((d)paramv).hIS.setChecked(false);
      ((d)paramv).hIS.setVisibility(8);
      ((d)paramv).qkk.setVisibility(8);
      AppMethodBeat.o(107413);
      return;
    }
    super.a(paramv, paramInt, paramList);
    AppMethodBeat.o(107413);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(107417);
    int i = this.lWb.size();
    AppMethodBeat.o(107417);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(107411);
    paramInt = Ct(paramInt).type;
    AppMethodBeat.o(107411);
    return paramInt;
  }
  
  public final String nV(long paramLong)
  {
    AppMethodBeat.i(107415);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.fcX().a((Date)localObject, this.mContext);
    AppMethodBeat.o(107415);
    return localObject;
  }
  
  public final class a
    extends RecyclerView.v
  {
    TextView ibF;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(107397);
      this.ibF = ((TextView)paramView.findViewById(2131298930));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131301489));
      AppMethodBeat.o(107397);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, f.c paramc, int paramInt);
  }
  
  public static final class c
  {
    public String imagePath;
    boolean osM;
    public d qkb;
    boolean qkc;
    public a qkd;
    public long timeStamp;
    public int type;
    
    public c(d paramd)
    {
      AppMethodBeat.i(107399);
      this.type = 0;
      this.qkd = new a();
      this.qkb = paramd;
      Object localObject;
      if (paramd.cjN()) {
        localObject = paramd.dke.deE;
      }
      for (;;)
      {
        this.imagePath = ((String)localObject);
        this.timeStamp = paramd.okO.field_updateTime;
        if ((paramd.cjM()) || (paramd.cjO()))
        {
          this.osM = true;
          this.qkd.qke = bt.pL(paramd.dke.duration);
        }
        if (paramd.cjN()) {
          this.qkc = true;
        }
        AppMethodBeat.o(107399);
        return;
        if ((paramd.cjM()) || (paramd.cjO()))
        {
          localObject = com.tencent.mm.plugin.fav.a.b.a(paramd.dke);
        }
        else
        {
          String str = com.tencent.mm.plugin.fav.a.b.d(paramd.dke);
          localObject = str;
          if (!new com.tencent.mm.vfs.e(str).exists()) {
            localObject = com.tencent.mm.plugin.fav.a.b.a(paramd.dke);
          }
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(107398);
      if ((this.qkb != null) && ((paramObject instanceof d)) && (paramObject != null))
      {
        bool = this.qkb.dke.dkb.equals(((d)paramObject).dke.dkb);
        AppMethodBeat.o(107398);
        return bool;
      }
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(107398);
      return bool;
    }
    
    final class a
    {
      public String qke;
      
      a() {}
    }
  }
  
  public final class d
    extends RecyclerView.v
  {
    CheckBox hIS;
    TextView nMl;
    View.OnLongClickListener qhH;
    ImageView qkg;
    View qkh;
    ImageView qki;
    View qkj;
    View qkk;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(107409);
      this.qhH = new View.OnLongClickListener()
      {
        private void u(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107408);
          final int i = ((Integer)paramAnonymousView.getTag(2131299792)).intValue();
          final f.c localc = f.this.Ct(i);
          if (localc == null)
          {
            AppMethodBeat.o(107408);
            return;
          }
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(f.b(f.this));
          f.d.this.qki.setVisibility(0);
          locala.Hua = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(107403);
              if ((f.d.this.qki != null) && (!f.this.qjZ)) {
                f.d.this.qki.setVisibility(8);
              }
              AppMethodBeat.o(107403);
            }
          };
          locala.a(paramAnonymousView, new View.OnCreateContextMenuListener()new n.d
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(107404);
              paramAnonymous2View = com.tencent.mm.plugin.fav.a.b.d(localc.qkb.dke);
              boolean bool1 = i.eK(paramAnonymous2View);
              boolean bool2 = t.aFm(paramAnonymous2View);
              if ((!localc.osM) && (bool1) && (!bool2))
              {
                paramAnonymous2ContextMenu.add(0, 0, 0, f.b(f.this).getString(2131759001));
                paramAnonymous2ContextMenu.add(0, 1, 0, f.b(f.this).getString(2131758951));
                paramAnonymous2ContextMenu.add(0, 2, 0, f.b(f.this).getString(2131758994));
              }
              for (;;)
              {
                if (bool1)
                {
                  paramAnonymous2View = localc.qkb.okO;
                  if ((paramAnonymous2View != null) && ((paramAnonymous2View.field_type == 18) || (paramAnonymous2View.field_type == 14))) {
                    paramAnonymous2ContextMenu.add(0, 4, 0, f.b(f.this).getString(2131758910));
                  }
                  paramAnonymous2ContextMenu.add(0, 5, 0, 2131758850);
                }
                AppMethodBeat.o(107404);
                return;
                if ((localc.osM) && (bool1) && (!bool2))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, f.b(f.this).getString(2131759001));
                  paramAnonymous2ContextMenu.add(0, 2, 0, f.b(f.this).getString(2131762784));
                }
                else
                {
                  ad.d("MicroMsg.MediaHistoryGalleryAdapter", "openPopupMenu, isVideo:%s, exist:%s, isGif:%s", new Object[] { Boolean.valueOf(localc.osM), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                }
              }
            }
          }, new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(107406);
              String str = com.tencent.mm.plugin.fav.a.b.d(localc.qkb.dke);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(107406);
                return;
                paramAnonymous2MenuItem = new ArrayList();
                paramAnonymous2MenuItem.add(localc.qkb);
                f.c(f.this).dr(paramAnonymous2MenuItem);
                AppMethodBeat.o(107406);
                return;
                h.i(localc.qkb.okO.field_localId, 0, 0);
                com.tencent.mm.plugin.fav.a.b.b(str, f.b(f.this));
                AppMethodBeat.o(107406);
                return;
                if (bt.isNullOrNil(str))
                {
                  ad.w("MicroMsg.MediaHistoryGalleryAdapter", "save image fail, path is null");
                  AppMethodBeat.o(107406);
                  return;
                }
                if (!localc.osM)
                {
                  p.a(f.b(f.this), str, new p.a()
                  {
                    public final void bv(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(186936);
                      Toast.makeText(f.b(f.this), f.b(f.this).getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.eAT() }), 1).show();
                      AppMethodBeat.o(186936);
                    }
                    
                    public final void bw(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(186937);
                      Toast.makeText(f.b(f.this), f.b(f.this).getString(2131758993), 1).show();
                      AppMethodBeat.o(186937);
                    }
                  });
                  AppMethodBeat.o(107406);
                  return;
                }
                p.b(f.b(f.this), str, new p.a()
                {
                  public final void bv(String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(186938);
                    ad.i("MicroMsg.MediaHistoryGalleryAdapter", "save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                    Toast.makeText(f.b(f.this), f.b(f.this).getString(2131764683, new Object[] { paramAnonymous3String2 }), 1).show();
                    AppMethodBeat.o(186938);
                  }
                  
                  public final void bw(String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(186939);
                    ad.e("MicroMsg.MediaHistoryGalleryAdapter", "FAILURE save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                    Toast.makeText(f.b(f.this), f.b(f.this).getString(2131764682), 1).show();
                    AppMethodBeat.o(186939);
                  }
                });
                AppMethodBeat.o(107406);
                return;
                f.a(f.this, i, localc);
                AppMethodBeat.o(107406);
                return;
                paramAnonymous2MenuItem = localc.qkb.okO;
                if ((paramAnonymous2MenuItem != null) && ((paramAnonymous2MenuItem.field_type == 18) || (paramAnonymous2MenuItem.field_type == 14)))
                {
                  paramAnonymous2MenuItem = new com.tencent.mm.ui.widget.a.f.a(f.b(f.this));
                  paramAnonymous2MenuItem.aMo(f.b(f.this).getString(2131758853));
                  paramAnonymous2MenuItem.aMt(f.b(f.this).getString(2131758848));
                  paramAnonymous2MenuItem.aMs(f.b(f.this).getString(2131758910));
                  paramAnonymous2MenuItem.a(new com.tencent.mm.ui.widget.a.f.c()new com.tencent.mm.ui.widget.a.f.c
                  {
                    public final void d(boolean paramAnonymous3Boolean, String paramAnonymous3String) {}
                  }, new com.tencent.mm.ui.widget.a.f.c()
                  {
                    public final void d(boolean paramAnonymous3Boolean, String paramAnonymous3String)
                    {
                      AppMethodBeat.i(186940);
                      f.a(f.this, f.d.4.3.this.iko, f.d.4.3.this.qko);
                      AppMethodBeat.o(186940);
                    }
                  });
                  paramAnonymous2MenuItem.show();
                  AppMethodBeat.o(107406);
                  return;
                }
                com.tencent.mm.plugin.fav.a.b.a(paramAnonymous2MenuItem, f.d(f.this));
              }
            }
          }, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(107408);
        }
        
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107407);
          if (f.this.qjZ)
          {
            AppMethodBeat.o(107407);
            return false;
          }
          if ((paramAnonymousView.getTag(2131306044) instanceof int[]))
          {
            int[] arrayOfInt = (int[])paramAnonymousView.getTag(2131306044);
            u(paramAnonymousView, arrayOfInt[0], arrayOfInt[1]);
          }
          for (;;)
          {
            AppMethodBeat.o(107407);
            return true;
            u(paramAnonymousView, 0, 0);
          }
        }
      };
      this.qkg = ((ImageView)paramView.findViewById(2131300612));
      this.qkh = paramView.findViewById(2131306404);
      this.qkj = paramView.findViewById(2131304817);
      this.nMl = ((TextView)paramView.findViewById(2131306401));
      this.qki = ((ImageView)paramView.findViewById(2131300615));
      this.hIS = ((CheckBox)paramView.findViewById(2131302204));
      this.qkk = paramView.findViewById(2131302205);
      this.qkk.setVisibility(8);
      this.hIS.setVisibility(8);
      this.qkh.setVisibility(8);
      this.nMl.setVisibility(8);
      this.qkj.setVisibility(8);
      this.qkg.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(107400);
          if (paramAnonymousMotionEvent.getAction() == 0) {
            paramAnonymousView.setTag(2131306044, new int[] { (int)paramAnonymousMotionEvent.getRawX(), (int)paramAnonymousMotionEvent.getRawY() });
          }
          AppMethodBeat.o(107400);
          return false;
        }
      });
      this.qkg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107401);
          paramAnonymousView = f.this.Ct(((Integer)paramAnonymousView.getTag(2131299792)).intValue());
          if (paramAnonymousView == null)
          {
            AppMethodBeat.o(107401);
            return;
          }
          f.a(f.this, paramAnonymousView);
          AppMethodBeat.o(107401);
        }
      });
      this.qkg.setOnLongClickListener(this.qhH);
      this.qkk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107402);
          boolean bool;
          if (!f.d.this.hIS.isChecked())
          {
            bool = true;
            if (e.a.cjQ().qjT.size() >= 9) {
              break label140;
            }
            f.d.this.hIS.setChecked(bool);
            if (bool) {
              break label126;
            }
            f.d.this.qki.setVisibility(8);
          }
          for (;;)
          {
            if (f.a(f.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = f.this.Ct(i);
              f.a(f.this).a(bool, paramAnonymousView, i);
            }
            AppMethodBeat.o(107402);
            return;
            bool = false;
            break;
            label126:
            f.d.this.qki.setVisibility(0);
            continue;
            label140:
            if (!bool) {
              f.d.this.hIS.setChecked(false);
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