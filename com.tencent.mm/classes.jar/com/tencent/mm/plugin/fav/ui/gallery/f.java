package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.av.o;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class f
  extends RecyclerView.a
{
  private Runnable dhC;
  private c fze;
  private Context mContext;
  private List<c> myd;
  private boolean opt;
  boolean opw;
  ahp qNv;
  b qSA;
  boolean qSB;
  private g.b qSz;
  
  public f(Context paramContext, List<c> paramList, g.b paramb, Runnable paramRunnable)
  {
    AppMethodBeat.i(107410);
    this.myd = null;
    this.fze = null;
    this.opt = true;
    this.qNv = new ahp();
    this.qSB = false;
    this.myd = paramList;
    this.opt = com.tencent.mm.kernel.g.agR().isSDCardAvailable();
    this.mContext = paramContext;
    this.qSz = paramb;
    this.dhC = paramRunnable;
    paramList = new c.a();
    paramList.hKA = 1;
    paramList.hKQ = true;
    paramList.gKh = (com.tencent.mm.cc.a.ig(paramContext) / 4);
    paramList.gKg = (com.tencent.mm.cc.a.ig(paramContext) / 4);
    paramList.hKL = 2131100734;
    this.fze = paramList.aFT();
    AppMethodBeat.o(107410);
  }
  
  private static long rI(long paramLong)
  {
    AppMethodBeat.i(107416);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.fsS().b(localDate);
    AppMethodBeat.o(107416);
    return paramLong;
  }
  
  public final c Do(int paramInt)
  {
    AppMethodBeat.i(107418);
    if (paramInt < 0)
    {
      AppMethodBeat.o(107418);
      return null;
    }
    c localc = (c)this.myd.get(paramInt);
    AppMethodBeat.o(107418);
    return localc;
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
    paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493951, paramViewGroup, false));
    AppMethodBeat.o(107412);
    return paramViewGroup;
  }
  
  public final void a(final RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(107414);
    if (!this.opt)
    {
      ac.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.opt) });
      AppMethodBeat.o(107414);
      return;
    }
    Object localObject1 = Do(paramInt);
    if (paramw.asH == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (rI(Do(paramInt + 1).timeStamp) != rI(((c)localObject1).timeStamp)))
      {
        ((a)paramw).iBM.setVisibility(8);
        AppMethodBeat.o(107414);
        return;
      }
      ((a)paramw).iBM.setVisibility(0);
      ((a)paramw).iBM.setText(rH(((c)localObject1).timeStamp));
      if (this.opw)
      {
        ((a)paramw).progressBar.setVisibility(0);
        AppMethodBeat.o(107414);
        return;
      }
      ((a)paramw).progressBar.setVisibility(8);
      AppMethodBeat.o(107414);
      return;
    }
    ((d)paramw).qSI.setTag(2131299792, Integer.valueOf(paramInt));
    ((d)paramw).qSM.setTag(Integer.valueOf(paramInt));
    if (((c)localObject1).qSE)
    {
      Object localObject2 = o.aFB();
      String str = ((c)localObject1).imagePath;
      ImageView localImageView = ((d)paramw).qSI;
      c.a locala = new c.a();
      locala.hKQ = true;
      locala.hKL = 2131100734;
      ((com.tencent.mm.av.a.a)localObject2).a(str, localImageView, locala.aFT());
      if (!((c)localObject1).oWm) {
        break label503;
      }
      ((d)paramw).qSJ.setVisibility(0);
      ((d)paramw).opl.setVisibility(0);
      ((d)paramw).opl.setText(bs.bG(((c)localObject1).qSF.qSG, ""));
      label330:
      ((d)paramw).qSI.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(107396);
          ((f.d)paramw).qSI.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          ((f.d)paramw).qSK.setLayoutParams(new RelativeLayout.LayoutParams(((f.d)paramw).qSI.getWidth(), ((f.d)paramw).qSI.getHeight()));
          AppMethodBeat.o(107396);
        }
      });
      if (!this.qSB) {
        break label565;
      }
      ((d)paramw).qSM.setVisibility(0);
      ((d)paramw).ijt.setVisibility(0);
      localObject2 = e.a.crx();
      localObject1 = ((c)localObject1).qSD;
      if (localObject1 == null) {
        break label530;
      }
      localObject2 = ((e)localObject2).qSv.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (!((d)((Iterator)localObject2).next()).dhz.dhw.equals(((d)localObject1).dhz.dhw));
    }
    label530:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label535;
      }
      ((d)paramw).qSK.setVisibility(0);
      ((d)paramw).ijt.setChecked(true);
      AppMethodBeat.o(107414);
      return;
      o.aFB().a(((c)localObject1).imagePath, ((d)paramw).qSI, this.fze);
      break;
      label503:
      ((d)paramw).opl.setVisibility(8);
      ((d)paramw).qSJ.setVisibility(8);
      break label330;
    }
    label535:
    ((d)paramw).qSK.setVisibility(8);
    ((d)paramw).ijt.setChecked(false);
    AppMethodBeat.o(107414);
    return;
    label565:
    ((d)paramw).qSK.setVisibility(8);
    ((d)paramw).qSM.setVisibility(8);
    ((d)paramw).ijt.setVisibility(8);
    AppMethodBeat.o(107414);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt, List paramList)
  {
    AppMethodBeat.i(107413);
    if ((paramList != null) && (paramList.size() > 0) && ((paramw instanceof d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((d)paramw).ijt.setChecked(false);
        ((d)paramw).ijt.setVisibility(0);
        ((d)paramw).qSM.setVisibility(0);
        AppMethodBeat.o(107413);
        return;
      }
      ((d)paramw).ijt.setChecked(false);
      ((d)paramw).ijt.setVisibility(8);
      ((d)paramw).qSM.setVisibility(8);
      AppMethodBeat.o(107413);
      return;
    }
    super.a(paramw, paramInt, paramList);
    AppMethodBeat.o(107413);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(107417);
    int i = this.myd.size();
    AppMethodBeat.o(107417);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(107411);
    paramInt = Do(paramInt).type;
    AppMethodBeat.o(107411);
    return paramInt;
  }
  
  public final String rH(long paramLong)
  {
    AppMethodBeat.i(107415);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.fsS().a((Date)localObject, this.mContext);
    AppMethodBeat.o(107415);
    return localObject;
  }
  
  public final class a
    extends RecyclerView.w
  {
    TextView iBM;
    ProgressBar progressBar;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(107397);
      this.iBM = ((TextView)paramView.findViewById(2131298930));
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
    boolean oWm;
    public d qSD;
    boolean qSE;
    public a qSF;
    public long timeStamp;
    public int type;
    
    public c(d paramd)
    {
      AppMethodBeat.i(107399);
      this.type = 0;
      this.qSF = new a();
      this.qSD = paramd;
      Object localObject;
      if (paramd.cru()) {
        localObject = paramd.dhz.dbZ;
      }
      for (;;)
      {
        this.imagePath = ((String)localObject);
        this.timeStamp = paramd.oOo.field_updateTime;
        if ((paramd.crt()) || (paramd.crv()))
        {
          this.oWm = true;
          this.qSF.qSG = bs.qy(paramd.dhz.duration);
        }
        if (paramd.cru()) {
          this.qSE = true;
        }
        AppMethodBeat.o(107399);
        return;
        if ((paramd.crt()) || (paramd.crv()))
        {
          localObject = com.tencent.mm.plugin.fav.a.b.a(paramd.dhz);
        }
        else
        {
          String str = com.tencent.mm.plugin.fav.a.b.d(paramd.dhz);
          localObject = str;
          if (!new com.tencent.mm.vfs.e(str).exists()) {
            localObject = com.tencent.mm.plugin.fav.a.b.a(paramd.dhz);
          }
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(107398);
      if ((this.qSD != null) && ((paramObject instanceof d)) && (paramObject != null))
      {
        bool = this.qSD.dhz.dhw.equals(((d)paramObject).dhz.dhw);
        AppMethodBeat.o(107398);
        return bool;
      }
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(107398);
      return bool;
    }
    
    final class a
    {
      public String qSG;
      
      a() {}
    }
  }
  
  public final class d
    extends RecyclerView.w
  {
    CheckBox ijt;
    TextView opl;
    View.OnLongClickListener qQj;
    ImageView qSI;
    View qSJ;
    ImageView qSK;
    View qSL;
    View qSM;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(107409);
      this.qQj = new View.OnLongClickListener()
      {
        private void u(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107408);
          final int i = ((Integer)paramAnonymousView.getTag(2131299792)).intValue();
          final f.c localc = f.this.Do(i);
          if (localc == null)
          {
            AppMethodBeat.o(107408);
            return;
          }
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(f.b(f.this));
          f.d.this.qSK.setVisibility(0);
          locala.IUx = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(107403);
              if ((f.d.this.qSK != null) && (!f.this.qSB)) {
                f.d.this.qSK.setVisibility(8);
              }
              AppMethodBeat.o(107403);
            }
          };
          locala.a(paramAnonymousView, new View.OnCreateContextMenuListener()new n.d
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(107404);
              paramAnonymous2View = com.tencent.mm.plugin.fav.a.b.d(localc.qSD.dhz);
              boolean bool1 = i.eA(paramAnonymous2View);
              boolean bool2 = s.aKD(paramAnonymous2View);
              if ((!localc.oWm) && (bool1) && (!bool2))
              {
                paramAnonymous2ContextMenu.add(0, 0, 0, f.b(f.this).getString(2131759001));
                paramAnonymous2ContextMenu.add(0, 1, 0, f.b(f.this).getString(2131758951));
                paramAnonymous2ContextMenu.add(0, 2, 0, f.b(f.this).getString(2131758994));
              }
              for (;;)
              {
                if (bool1)
                {
                  paramAnonymous2View = localc.qSD.oOo;
                  if ((paramAnonymous2View != null) && ((paramAnonymous2View.field_type == 18) || (paramAnonymous2View.field_type == 14))) {
                    paramAnonymous2ContextMenu.add(0, 4, 0, f.b(f.this).getString(2131758910));
                  }
                  paramAnonymous2ContextMenu.add(0, 5, 0, 2131758850);
                }
                AppMethodBeat.o(107404);
                return;
                if ((localc.oWm) && (bool1) && (!bool2))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, f.b(f.this).getString(2131759001));
                  paramAnonymous2ContextMenu.add(0, 2, 0, f.b(f.this).getString(2131762784));
                }
                else
                {
                  ac.d("MicroMsg.MediaHistoryGalleryAdapter", "openPopupMenu, isVideo:%s, exist:%s, isGif:%s", new Object[] { Boolean.valueOf(localc.oWm), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                }
              }
            }
          }, new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(107406);
              String str = com.tencent.mm.plugin.fav.a.b.d(localc.qSD.dhz);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(107406);
                return;
                paramAnonymous2MenuItem = new ArrayList();
                paramAnonymous2MenuItem.add(localc.qSD);
                f.c(f.this).dt(paramAnonymous2MenuItem);
                AppMethodBeat.o(107406);
                return;
                h.i(localc.qSD.oOo.field_localId, 0, 0);
                com.tencent.mm.plugin.fav.a.b.b(str, f.b(f.this));
                AppMethodBeat.o(107406);
                return;
                if (bs.isNullOrNil(str))
                {
                  ac.w("MicroMsg.MediaHistoryGalleryAdapter", "save image fail, path is null");
                  AppMethodBeat.o(107406);
                  return;
                }
                if (!localc.oWm)
                {
                  p.a(f.b(f.this), str, new p.a()
                  {
                    public final void bD(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(209504);
                      Toast.makeText(f.b(f.this), f.b(f.this).getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.eQn() }), 1).show();
                      AppMethodBeat.o(209504);
                    }
                    
                    public final void bE(String paramAnonymous3String1, String paramAnonymous3String2)
                    {
                      AppMethodBeat.i(209505);
                      Toast.makeText(f.b(f.this), f.b(f.this).getString(2131758993), 1).show();
                      AppMethodBeat.o(209505);
                    }
                  });
                  AppMethodBeat.o(107406);
                  return;
                }
                p.b(f.b(f.this), str, new p.a()
                {
                  public final void bD(String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(209506);
                    ac.i("MicroMsg.MediaHistoryGalleryAdapter", "save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                    Toast.makeText(f.b(f.this), f.b(f.this).getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aLU(paramAnonymous3String2) }), 1).show();
                    AppMethodBeat.o(209506);
                  }
                  
                  public final void bE(String paramAnonymous3String1, String paramAnonymous3String2)
                  {
                    AppMethodBeat.i(209507);
                    ac.e("MicroMsg.MediaHistoryGalleryAdapter", "FAILURE save video now video path %s out path %s", new Object[] { paramAnonymous3String1, paramAnonymous3String2 });
                    Toast.makeText(f.b(f.this), f.b(f.this).getString(2131764682), 1).show();
                    AppMethodBeat.o(209507);
                  }
                });
                AppMethodBeat.o(107406);
                return;
                f.a(f.this, i, localc);
                AppMethodBeat.o(107406);
                return;
                paramAnonymous2MenuItem = localc.qSD.oOo;
                if ((paramAnonymous2MenuItem != null) && ((paramAnonymous2MenuItem.field_type == 18) || (paramAnonymous2MenuItem.field_type == 14)))
                {
                  paramAnonymous2MenuItem = new com.tencent.mm.ui.widget.a.f.a(f.b(f.this));
                  paramAnonymous2MenuItem.aRQ(f.b(f.this).getString(2131758853));
                  paramAnonymous2MenuItem.aRV(f.b(f.this).getString(2131758848));
                  paramAnonymous2MenuItem.aRU(f.b(f.this).getString(2131758910));
                  paramAnonymous2MenuItem.a(new com.tencent.mm.ui.widget.a.f.c()new com.tencent.mm.ui.widget.a.f.c
                  {
                    public final void d(boolean paramAnonymous3Boolean, String paramAnonymous3String) {}
                  }, new com.tencent.mm.ui.widget.a.f.c()
                  {
                    public final void d(boolean paramAnonymous3Boolean, String paramAnonymous3String)
                    {
                      AppMethodBeat.i(209508);
                      f.a(f.this, f.d.4.3.this.iKv, f.d.4.3.this.qSQ);
                      AppMethodBeat.o(209508);
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
          if (f.this.qSB)
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
      this.qSI = ((ImageView)paramView.findViewById(2131300612));
      this.qSJ = paramView.findViewById(2131306404);
      this.qSL = paramView.findViewById(2131304817);
      this.opl = ((TextView)paramView.findViewById(2131306401));
      this.qSK = ((ImageView)paramView.findViewById(2131300615));
      this.ijt = ((CheckBox)paramView.findViewById(2131302204));
      this.qSM = paramView.findViewById(2131302205);
      this.qSM.setVisibility(8);
      this.ijt.setVisibility(8);
      this.qSJ.setVisibility(8);
      this.opl.setVisibility(8);
      this.qSL.setVisibility(8);
      this.qSI.setOnTouchListener(new View.OnTouchListener()
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
      this.qSI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107401);
          paramAnonymousView = f.this.Do(((Integer)paramAnonymousView.getTag(2131299792)).intValue());
          if (paramAnonymousView == null)
          {
            AppMethodBeat.o(107401);
            return;
          }
          f.a(f.this, paramAnonymousView);
          AppMethodBeat.o(107401);
        }
      });
      this.qSI.setOnLongClickListener(this.qQj);
      this.qSM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107402);
          boolean bool;
          if (!f.d.this.ijt.isChecked())
          {
            bool = true;
            if (e.a.crx().qSv.size() >= 9) {
              break label140;
            }
            f.d.this.ijt.setChecked(bool);
            if (bool) {
              break label126;
            }
            f.d.this.qSK.setVisibility(8);
          }
          for (;;)
          {
            if (f.a(f.this) != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = f.this.Do(i);
              f.a(f.this).a(bool, paramAnonymousView, i);
            }
            AppMethodBeat.o(107402);
            return;
            bool = false;
            break;
            label126:
            f.d.this.qSK.setVisibility(0);
            continue;
            label140:
            if (!bool) {
              f.d.this.ijt.setChecked(false);
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