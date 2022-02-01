package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Process;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.FavSearchUI;
import com.tencent.mm.plugin.fav.ui.p.a;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
  implements f.b, g.b
{
  private RecyclerView anl;
  Activity dsa;
  int fKU;
  public View fOB;
  private TextView fTc;
  private long gwh;
  private long hVM;
  boolean oTL;
  private int oTM;
  private ProgressDialog oTu;
  g.a rCd;
  private RelativeLayout rCe;
  private LinearLayout rCf;
  TextView rCg;
  private TextView rCh;
  private ImageButton rCi;
  private ImageButton rCj;
  private boolean rCk;
  private int rCl;
  public a rCm;
  private long rCn;
  private View.OnClickListener rCo;
  private View.OnClickListener rCp;
  private View.OnClickListener rCq;
  public List<d> rCr;
  akf rxx;
  
  public c(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(107375);
    this.rCk = false;
    this.rCl = -1;
    this.oTL = true;
    this.gwh = 0L;
    this.hVM = 0L;
    this.rCo = new c.3(this);
    this.rCp = new c.4(this);
    this.rCq = new c.5(this);
    this.rCr = new ArrayList();
    this.dsa = paramActivity;
    this.fOB = paramView;
    this.rCk = true;
    g.c localc = g.c.rCV;
    paramView = null;
    switch (c.9.rCw[localc.ordinal()])
    {
    }
    for (paramActivity = paramView;; paramActivity = new h(paramActivity))
    {
      paramActivity.a(this);
      this.rxx = new akf();
      this.rxx.scene = 2;
      this.rxx.ooi = 2;
      this.rxx.index = 0;
      this.rxx.sessionId = "";
      this.rxx.query = "";
      this.rxx.rsG = "";
      this.rCe = ((RelativeLayout)this.fOB.findViewById(2131300756));
      this.rCf = ((LinearLayout)this.fOB.findViewById(2131300752));
      this.rCg = ((TextView)this.fOB.findViewById(2131296624));
      this.fTc = ((TextView)this.fOB.findViewById(2131304436));
      this.anl = ((RecyclerView)this.fOB.findViewById(2131300757));
      this.rCi = ((ImageButton)this.fOB.findViewById(2131300751));
      this.rCj = ((ImageButton)this.fOB.findViewById(2131300750));
      this.anl.setLayoutManager(this.rCd.bZB());
      this.anl.a(this.rCd.eK(this.dsa));
      this.anl.setAdapter(this.rCd.bZA());
      ((f)this.rCd.cxl()).rxx = this.rxx;
      this.anl.setHasFixedSize(true);
      this.anl.setOnScrollListener(new c.1(this));
      this.anl.a(new RecyclerView.m()
      {
        private Runnable oTO;
        
        private void jG(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(218808);
          if (paramAnonymousBoolean)
          {
            c.this.rCg.removeCallbacks(this.oTO);
            if (c.this.rCg.getVisibility() != 0)
            {
              c.this.rCg.clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(c.this.dsa, 2130772047);
              c.this.rCg.setVisibility(0);
              c.this.rCg.startAnimation(localAnimation);
              AppMethodBeat.o(218808);
            }
          }
          else
          {
            c.this.rCg.removeCallbacks(this.oTO);
            c.this.rCg.postDelayed(this.oTO, 256L);
          }
          AppMethodBeat.o(218808);
        }
        
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107363);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          localObject = (LinearLayoutManager)c.this.rCd.bZB();
          paramAnonymousRecyclerView = (f)c.this.rCd.cxl();
          localObject = paramAnonymousRecyclerView.Eh(((LinearLayoutManager)localObject).km());
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(107363);
            return;
          }
          paramAnonymousRecyclerView = paramAnonymousRecyclerView.tG(((f.d)localObject).timeStamp);
          c.this.rCg.setText(bt.bI(paramAnonymousRecyclerView, ""));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(107363);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(218809);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          int i;
          if (1 == paramAnonymousInt)
          {
            jG(true);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, c.this.fKU);
            localObject = c.this;
            boolean bool = WXHardCoderJNI.hcMediaGalleryScrollEnable;
            int j = WXHardCoderJNI.hcMediaGalleryScrollDelay;
            int k = WXHardCoderJNI.hcMediaGalleryScrollCPU;
            int m = WXHardCoderJNI.hcMediaGalleryScrollIO;
            if (WXHardCoderJNI.hcMediaGalleryScrollThr)
            {
              i = Process.myTid();
              ((c)localObject).fKU = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
            }
          }
          for (;;)
          {
            if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
            {
              if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).km() == 0) && (!c.this.oTL)) {
                c.this.rCd.E(false, -1);
              }
              c.this.oTL = false;
              q.aIJ().cp(paramAnonymousInt);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(218809);
            return;
            i = 0;
            break;
            if (paramAnonymousInt == 0) {
              jG(false);
            }
          }
        }
      });
      this.rCh = ((TextView)this.fOB.findViewById(2131304501));
      this.rCh.setOnClickListener(this.rCo);
      this.rCi.setTag(Integer.valueOf(0));
      this.rCi.setOnClickListener(this.rCq);
      this.rCj.setTag(Integer.valueOf(1));
      this.rCj.setOnClickListener(this.rCq);
      AppMethodBeat.o(107375);
      return;
    }
  }
  
  private void jF(boolean paramBoolean)
  {
    AppMethodBeat.i(107390);
    ad.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.oTu = com.tencent.mm.ui.base.p.a(this.dsa, this.dsa.getString(2131760709), true, 0, null);
      AppMethodBeat.o(107390);
      return;
    }
    if ((this.oTu != null) && (this.oTu.isShowing()))
    {
      this.oTu.dismiss();
      this.oTu = null;
    }
    AppMethodBeat.o(107390);
  }
  
  private void lE(boolean paramBoolean)
  {
    AppMethodBeat.i(107387);
    this.rCi.setEnabled(paramBoolean);
    this.rCj.setEnabled(paramBoolean);
    AppMethodBeat.o(107387);
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(107383);
    ad.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.rCl) });
    int i;
    if (this.rCm != null)
    {
      i = (int)(System.currentTimeMillis() - this.rCn);
      this.rCm.fG(i, paramInt);
    }
    if (paramBoolean)
    {
      jF(false);
      this.anl.getAdapter().asY.notifyChanged();
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.rCl > 0)
      {
        if (this.rCl % 4 == 0) {
          this.rCl += 1;
        }
        localRecyclerView = this.anl;
        locala = com.tencent.mm.hellhoundlib.b.c.a(this.rCl, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.fTc.setVisibility(0);
        this.anl.setVisibility(8);
        this.fTc.setText(this.dsa.getString(2131758832));
        AppMethodBeat.o(107383);
        return;
        i = this.anl.getAdapter().getItemCount();
        localRecyclerView = this.anl;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.fTc.setVisibility(8);
      this.anl.setVisibility(0);
      AppMethodBeat.o(107383);
      return;
    }
    if (paramInt > 0)
    {
      this.anl.getAdapter().asY.notifyChanged();
      AppMethodBeat.o(107383);
      return;
    }
    this.anl.getAdapter().cj(0);
    AppMethodBeat.o(107383);
  }
  
  public final void Eg(int paramInt)
  {
    AppMethodBeat.i(107384);
    if (cxc()) {
      if (paramInt <= 0) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      lE(bool);
      AppMethodBeat.o(107384);
      return;
    }
  }
  
  public final void aUU()
  {
    AppMethodBeat.i(107376);
    if (this.rCd != null)
    {
      this.rCn = System.currentTimeMillis();
      this.rCd.E(true, this.rCl);
    }
    AppMethodBeat.o(107376);
  }
  
  public final void cwi()
  {
    AppMethodBeat.i(218815);
    if (this.rCm != null) {
      this.rCm.cwi();
    }
    AppMethodBeat.o(218815);
  }
  
  public final void cwk()
  {
    AppMethodBeat.i(218817);
    if (this.rCm != null) {
      this.rCm.cwk();
    }
    AppMethodBeat.o(218817);
  }
  
  public final void cwl()
  {
    AppMethodBeat.i(218818);
    if (this.rCm != null) {
      this.rCm.cwl();
    }
    AppMethodBeat.o(218818);
  }
  
  public final void cwm()
  {
    AppMethodBeat.i(218819);
    if (this.rCm != null) {
      this.rCm.cwm();
    }
    AppMethodBeat.o(218819);
  }
  
  public final void cxb()
  {
    AppMethodBeat.i(218816);
    if (this.rCm != null) {
      this.rCm.cwj();
    }
    AppMethodBeat.o(218816);
  }
  
  public final boolean cxc()
  {
    AppMethodBeat.i(107381);
    if (this.rCd == null)
    {
      AppMethodBeat.o(107381);
      return false;
    }
    boolean bool = this.rCd.cxc();
    AppMethodBeat.o(107381);
    return bool;
  }
  
  public final void cxd()
  {
    AppMethodBeat.i(107385);
    if (this.rCd != null) {
      this.rCd.cxd();
    }
    this.rCe.setVisibility(8);
    this.rCf.setVisibility(0);
    lE(false);
    AppMethodBeat.o(107385);
  }
  
  public final void cxe()
  {
    AppMethodBeat.i(107386);
    if (this.rCd != null) {
      this.rCd.cxe();
    }
    this.rCe.setVisibility(0);
    this.rCf.setVisibility(8);
    AppMethodBeat.o(107386);
  }
  
  public final void dv(List<d> paramList)
  {
    AppMethodBeat.i(107388);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(107388);
      return;
    }
    this.rCr.clear();
    this.rCr.addAll(paramList);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("mutil_select_is_ret", true);
    String str2;
    int i;
    if (this.rCr.size() == 1)
    {
      d locald = (d)paramList.get(0);
      String str1 = com.tencent.mm.plugin.fav.a.b.a(locald.dsX);
      str2 = com.tencent.mm.plugin.fav.a.b.d(locald.dsX);
      if (i.fv(str1))
      {
        localIntent.putExtra("image_path", str1);
        if ((!locald.cxh()) && (!locald.cxf())) {
          break label235;
        }
        i = 1;
        label153:
        localIntent.putExtra("Retr_Msg_Type", i);
        localIntent.putExtra("select_is_ret", true);
      }
    }
    for (;;)
    {
      com.tencent.mm.bs.d.c(this.dsa, ".ui.transmit.SelectConversationUI", localIntent, 1);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        com.tencent.mm.plugin.fav.a.h.i(((d)paramList.next()).prW.field_localId, 1, 0);
      }
      localIntent.putExtra("image_path", str2);
      break;
      label235:
      i = 0;
      break label153;
      localIntent.putExtra("scene_from", 1);
      localIntent.putExtra("Retr_Msg_Type", 17);
      localIntent.putExtra("select_fav_select_count", this.rCr.size());
    }
    if (this.rCm != null) {
      this.rCm.Ec(this.rCr.size());
    }
    AppMethodBeat.o(107388);
  }
  
  public final void dw(final List<d> paramList)
  {
    AppMethodBeat.i(107389);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(107389);
      return;
    }
    Object localObject = new ArrayList();
    final boolean bool = false;
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      paramList = ((d)localIterator.next()).prW;
      if ((paramList != null) && ((paramList.field_type == 18) || (paramList.field_type == 14)))
      {
        bool = true;
        localHashSet.add(Long.valueOf(paramList.field_localId));
      }
      else
      {
        ((ArrayList)localObject).add(paramList);
      }
    }
    if (((ArrayList)localObject).size() == 0)
    {
      if (localHashSet.size() >= 2)
      {
        FavSearchUI.an(this.dsa);
        AppMethodBeat.o(107389);
        return;
      }
      localObject = new f.a(this.dsa);
      ((f.a)localObject).aXO(this.dsa.getString(2131758853));
      ((f.a)localObject).aXT(this.dsa.getString(2131758848));
      ((f.a)localObject).aXS(this.dsa.getString(2131758910));
      ((f.a)localObject).a(new f.c()new f.c
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }, new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(218811);
          c.this.rxx.index = -1;
          ((y)com.tencent.mm.kernel.g.ab(y.class)).a(c.this.dsa, paramList, c.this.rxx);
          AppMethodBeat.o(218811);
        }
      });
      ((f.a)localObject).show();
      AppMethodBeat.o(107389);
      return;
    }
    com.tencent.mm.ui.base.h.a(this.dsa, this.dsa.getString(2131758852), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(218813);
        com.tencent.mm.plugin.fav.ui.p.a(c.this.dsa, this.kTH, new p.a()
        {
          public final void cwp()
          {
            AppMethodBeat.i(218812);
            ad.v("MicroMsg.MediaHistoryGalleryUI", "do refresh job");
            c.this.rCd.E(true, -1);
            AppMethodBeat.o(218812);
          }
        });
        if (bool) {
          FavSearchUI.an(c.this.dsa);
        }
        if (c.this.rCm != null)
        {
          paramAnonymousDialogInterface = c.this.rCm;
          this.kTH.size();
          paramAnonymousDialogInterface.cwj();
        }
        AppMethodBeat.o(218813);
      }
    }, null);
    AppMethodBeat.o(107389);
  }
  
  public final void jD(boolean paramBoolean)
  {
    AppMethodBeat.i(107382);
    if (paramBoolean)
    {
      jF(true);
      AppMethodBeat.o(107382);
      return;
    }
    this.oTM = ((GridLayoutManager)this.anl.getLayoutManager()).ko();
    AppMethodBeat.o(107382);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107379);
    if (this.rCd != null) {
      this.rCd.onDetach();
    }
    AppMethodBeat.o(107379);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(107378);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.fKU);
    this.fKU = 0;
    if ((com.tencent.matrix.b.HK()) && (com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class)).cJy;
      if (localc != null) {
        this.gwh = Math.max(0L, localc.cLq - this.gwh);
      }
    }
    if (bt.aQJ() > this.hVM) {}
    for (long l = bt.aQJ() - this.hVM;; l = 1L)
    {
      this.hVM = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.gwh, this.hVM);
      this.gwh = 0L;
      this.hVM = 0L;
      AppMethodBeat.o(107378);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107377);
    this.hVM = bt.aQJ();
    if ((com.tencent.matrix.b.HK()) && (com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class)).cJy;
      if (localc != null) {
        this.gwh = localc.cLq;
      }
    }
    if (this.rCd != null) {
      this.rCd.onResume();
    }
    if (this.rCk)
    {
      if ((this.rCd == null) || (!this.rCd.cxc())) {
        break label118;
      }
      cxd();
    }
    for (;;)
    {
      this.rCk = false;
      AppMethodBeat.o(107377);
      return;
      label118:
      cxe();
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(107380);
    this.fOB.setVisibility(paramInt);
    AppMethodBeat.o(107380);
  }
  
  public static abstract interface a
  {
    public abstract void Ec(int paramInt);
    
    public abstract void cwi();
    
    public abstract void cwj();
    
    public abstract void cwk();
    
    public abstract void cwl();
    
    public abstract void cwm();
    
    public abstract void fG(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c
 * JD-Core Version:    0.7.0.1
 */