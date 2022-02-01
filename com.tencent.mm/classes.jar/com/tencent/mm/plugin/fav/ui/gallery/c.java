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
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.FavSearchUI;
import com.tencent.mm.plugin.fav.ui.p;
import com.tencent.mm.plugin.fav.ui.p.a;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
  implements f.b, g.b
{
  Activity dKq;
  private TextView gAp;
  int gsi;
  public View gvQ;
  private long hlB;
  private long iTC;
  private RecyclerView mRecyclerView;
  private ProgressDialog qoU;
  boolean qpl;
  private int qpm;
  and tfo;
  g.a tjZ;
  private RelativeLayout tka;
  private LinearLayout tkb;
  TextView tkc;
  private TextView tkd;
  private ImageButton tke;
  private ImageButton tkf;
  private boolean tkg;
  private int tkh;
  public a tki;
  private long tkj;
  private View.OnClickListener tkk;
  private View.OnClickListener tkl;
  private View.OnClickListener tkm;
  public List<d> tkn;
  
  public c(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(107375);
    this.tkg = false;
    this.tkh = -1;
    this.qpl = true;
    this.hlB = 0L;
    this.iTC = 0L;
    this.tkk = new c.3(this);
    this.tkl = new c.4(this);
    this.tkm = new c.5(this);
    this.tkn = new ArrayList();
    this.dKq = paramActivity;
    this.gvQ = paramView;
    this.tkg = true;
    g.c localc = g.c.tkS;
    paramView = null;
    switch (c.9.tks[localc.ordinal()])
    {
    }
    for (paramActivity = paramView;; paramActivity = new h(paramActivity))
    {
      paramActivity.a(this);
      this.tfo = new and();
      this.tfo.scene = 2;
      this.tfo.pHw = 2;
      this.tfo.index = 0;
      this.tfo.sessionId = "";
      this.tfo.query = "";
      this.tfo.tay = "";
      this.tka = ((RelativeLayout)this.gvQ.findViewById(2131302344));
      this.tkb = ((LinearLayout)this.gvQ.findViewById(2131302340));
      this.tkc = ((TextView)this.gvQ.findViewById(2131296701));
      this.gAp = ((TextView)this.gvQ.findViewById(2131307411));
      this.mRecyclerView = ((RecyclerView)this.gvQ.findViewById(2131302345));
      this.tke = ((ImageButton)this.gvQ.findViewById(2131302339));
      this.tkf = ((ImageButton)this.gvQ.findViewById(2131302338));
      this.mRecyclerView.setLayoutManager(this.tjZ.eS(this.dKq));
      this.mRecyclerView.a(this.tjZ.fi(this.dKq));
      this.mRecyclerView.setAdapter(this.tjZ.cyF());
      ((f)this.tjZ.cWP()).tfo = this.tfo;
      this.mRecyclerView.setHasFixedSize(true);
      this.mRecyclerView.setOnScrollListener(new c.1(this));
      this.mRecyclerView.a(new RecyclerView.l()
      {
        private Runnable qpo;
        
        private void kI(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(235355);
          if (paramAnonymousBoolean)
          {
            c.this.tkc.removeCallbacks(this.qpo);
            if (c.this.tkc.getVisibility() != 0)
            {
              c.this.tkc.clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(c.this.dKq, 2130772059);
              c.this.tkc.setVisibility(0);
              c.this.tkc.startAnimation(localAnimation);
              AppMethodBeat.o(235355);
            }
          }
          else
          {
            c.this.tkc.removeCallbacks(this.qpo);
            c.this.tkc.postDelayed(this.qpo, 256L);
          }
          AppMethodBeat.o(235355);
        }
        
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(235356);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          int i;
          if (1 == paramAnonymousInt)
          {
            kI(true);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, c.this.gsi);
            localObject = c.this;
            boolean bool = WXHardCoderJNI.hcMediaGalleryScrollEnable;
            int j = WXHardCoderJNI.hcMediaGalleryScrollDelay;
            int k = WXHardCoderJNI.hcMediaGalleryScrollCPU;
            int m = WXHardCoderJNI.hcMediaGalleryScrollIO;
            if (WXHardCoderJNI.hcMediaGalleryScrollThr)
            {
              i = Process.myTid();
              ((c)localObject).gsi = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
            }
          }
          for (;;)
          {
            if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
            {
              if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).ks() == 0) && (!c.this.qpl)) {
                c.this.tjZ.G(false, -1);
              }
              c.this.qpl = false;
              com.tencent.mm.av.q.bcV().onScrollStateChanged(paramAnonymousInt);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(235356);
            return;
            i = 0;
            break;
            if (paramAnonymousInt == 0) {
              kI(false);
            }
          }
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107363);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          localObject = (LinearLayoutManager)c.this.tjZ.eS(c.this.dKq);
          paramAnonymousRecyclerView = (f)c.this.tjZ.cWP();
          localObject = paramAnonymousRecyclerView.If(((LinearLayoutManager)localObject).ks());
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(107363);
            return;
          }
          paramAnonymousRecyclerView = paramAnonymousRecyclerView.Cc(((f.d)localObject).timeStamp);
          c.this.tkc.setText(Util.nullAs(paramAnonymousRecyclerView, ""));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(107363);
        }
      });
      this.tkd = ((TextView)this.gvQ.findViewById(2131307507));
      this.tkd.setOnClickListener(this.tkk);
      this.tke.setTag(Integer.valueOf(0));
      this.tke.setOnClickListener(this.tkm);
      this.tkf.setTag(Integer.valueOf(1));
      this.tkf.setOnClickListener(this.tkm);
      AppMethodBeat.o(107375);
      return;
    }
  }
  
  private void kH(boolean paramBoolean)
  {
    AppMethodBeat.i(107390);
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.qoU = com.tencent.mm.ui.base.q.a(this.dKq, this.dKq.getString(2131762446), true, 0, null);
      AppMethodBeat.o(107390);
      return;
    }
    if ((this.qoU != null) && (this.qoU.isShowing()))
    {
      this.qoU.dismiss();
      this.qoU = null;
    }
    AppMethodBeat.o(107390);
  }
  
  private void mH(boolean paramBoolean)
  {
    AppMethodBeat.i(107387);
    this.tke.setEnabled(paramBoolean);
    this.tkf.setEnabled(paramBoolean);
    AppMethodBeat.o(107387);
  }
  
  public final void D(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(107383);
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.tkh) });
    int i;
    if (this.tki != null)
    {
      i = (int)(System.currentTimeMillis() - this.tkj);
      this.tki.fV(i, paramInt);
    }
    if (paramBoolean)
    {
      kH(false);
      this.mRecyclerView.getAdapter().atj.notifyChanged();
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.tkh > 0)
      {
        if (this.tkh % 4 == 0) {
          this.tkh += 1;
        }
        localRecyclerView = this.mRecyclerView;
        locala = com.tencent.mm.hellhoundlib.b.c.a(this.tkh, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.gAp.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        this.gAp.setText(this.dKq.getString(2131759155));
        AppMethodBeat.o(107383);
        return;
        i = this.mRecyclerView.getAdapter().getItemCount();
        localRecyclerView = this.mRecyclerView;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.gAp.setVisibility(8);
      this.mRecyclerView.setVisibility(0);
      AppMethodBeat.o(107383);
      return;
    }
    if (paramInt > 0)
    {
      this.mRecyclerView.getAdapter().atj.notifyChanged();
      AppMethodBeat.o(107383);
      return;
    }
    this.mRecyclerView.getAdapter().ci(0);
    AppMethodBeat.o(107383);
  }
  
  public final void Ie(int paramInt)
  {
    AppMethodBeat.i(107384);
    if (cWG()) {
      if (paramInt <= 0) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      mH(bool);
      AppMethodBeat.o(107384);
      return;
    }
  }
  
  public final void bqe()
  {
    AppMethodBeat.i(107376);
    if (this.tjZ != null)
    {
      this.tkj = System.currentTimeMillis();
      this.tjZ.G(true, this.tkh);
    }
    AppMethodBeat.o(107376);
  }
  
  public final void cVN()
  {
    AppMethodBeat.i(235362);
    if (this.tki != null) {
      this.tki.cVN();
    }
    AppMethodBeat.o(235362);
  }
  
  public final void cVP()
  {
    AppMethodBeat.i(235364);
    if (this.tki != null) {
      this.tki.cVP();
    }
    AppMethodBeat.o(235364);
  }
  
  public final void cVQ()
  {
    AppMethodBeat.i(235365);
    if (this.tki != null) {
      this.tki.cVQ();
    }
    AppMethodBeat.o(235365);
  }
  
  public final void cVR()
  {
    AppMethodBeat.i(235366);
    if (this.tki != null) {
      this.tki.cVR();
    }
    AppMethodBeat.o(235366);
  }
  
  public final void cWF()
  {
    AppMethodBeat.i(235363);
    if (this.tki != null) {
      this.tki.cVO();
    }
    AppMethodBeat.o(235363);
  }
  
  public final boolean cWG()
  {
    AppMethodBeat.i(107381);
    if (this.tjZ == null)
    {
      AppMethodBeat.o(107381);
      return false;
    }
    boolean bool = this.tjZ.cWG();
    AppMethodBeat.o(107381);
    return bool;
  }
  
  public final void cWH()
  {
    AppMethodBeat.i(107385);
    if (this.tjZ != null) {
      this.tjZ.cWH();
    }
    this.tka.setVisibility(8);
    this.tkb.setVisibility(0);
    mH(false);
    AppMethodBeat.o(107385);
  }
  
  public final void cWI()
  {
    AppMethodBeat.i(107386);
    if (this.tjZ != null) {
      this.tjZ.cWI();
    }
    this.tka.setVisibility(0);
    this.tkb.setVisibility(8);
    AppMethodBeat.o(107386);
  }
  
  public final void dM(List<d> paramList)
  {
    AppMethodBeat.i(107388);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(107388);
      return;
    }
    this.tkn.clear();
    this.tkn.addAll(paramList);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("mutil_select_is_ret", true);
    String str2;
    int i;
    if (this.tkn.size() == 1)
    {
      d locald = (d)paramList.get(0);
      String str1 = com.tencent.mm.plugin.fav.a.b.a(locald.dLo);
      str2 = com.tencent.mm.plugin.fav.a.b.d(locald.dLo);
      if (s.YS(str1))
      {
        localIntent.putExtra("image_path", str1);
        if ((!locald.cWL()) && (!locald.cWJ())) {
          break label234;
        }
        i = 1;
        label153:
        localIntent.putExtra("Retr_Msg_Type", i);
        localIntent.putExtra("select_is_ret", true);
      }
    }
    for (;;)
    {
      com.tencent.mm.br.c.c(this.dKq, ".ui.transmit.SelectConversationUI", localIntent, 1);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        com.tencent.mm.plugin.fav.a.h.w(((d)paramList.next()).qNT.field_localId, 1);
      }
      localIntent.putExtra("image_path", str2);
      break;
      label234:
      i = 0;
      break label153;
      localIntent.putExtra("scene_from", 1);
      localIntent.putExtra("Retr_Msg_Type", 17);
      localIntent.putExtra("select_fav_select_count", this.tkn.size());
    }
    if (this.tki != null) {
      this.tki.Ia(this.tkn.size());
    }
    AppMethodBeat.o(107388);
  }
  
  public final void dN(final List<d> paramList)
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
      paramList = ((d)localIterator.next()).qNT;
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
        FavSearchUI.ak(this.dKq);
        AppMethodBeat.o(107389);
        return;
      }
      localObject = new f.a(this.dKq);
      ((f.a)localObject).bow(this.dKq.getString(2131759176));
      ((f.a)localObject).boB(this.dKq.getString(2131759171));
      ((f.a)localObject).boA(this.dKq.getString(2131759234));
      ((f.a)localObject).a(new f.c()new f.c
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }, new f.c()
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(235358);
          c.this.tfo.index = -1;
          ((y)com.tencent.mm.kernel.g.af(y.class)).a(c.this.dKq, paramList, c.this.tfo);
          AppMethodBeat.o(235358);
        }
      });
      ((f.a)localObject).show();
      AppMethodBeat.o(107389);
      return;
    }
    com.tencent.mm.ui.base.h.a(this.dKq, this.dKq.getString(2131759175), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(235360);
        p.a(c.this.dKq, this.mcA, new p.a()
        {
          public final void cVU()
          {
            AppMethodBeat.i(235359);
            Log.v("MicroMsg.MediaHistoryGalleryUI", "do refresh job");
            c.this.tjZ.G(true, -1);
            AppMethodBeat.o(235359);
          }
        });
        if (bool) {
          FavSearchUI.ak(c.this.dKq);
        }
        if (c.this.tki != null)
        {
          paramAnonymousDialogInterface = c.this.tki;
          this.mcA.size();
          paramAnonymousDialogInterface.cVO();
        }
        AppMethodBeat.o(235360);
      }
    }, null);
    AppMethodBeat.o(107389);
  }
  
  public final void kF(boolean paramBoolean)
  {
    AppMethodBeat.i(107382);
    if (paramBoolean)
    {
      kH(true);
      AppMethodBeat.o(107382);
      return;
    }
    this.qpm = ((GridLayoutManager)this.mRecyclerView.getLayoutManager()).ku();
    AppMethodBeat.o(107382);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107379);
    if (this.tjZ != null) {
      this.tjZ.onDetach();
    }
    AppMethodBeat.o(107379);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(107378);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.gsi);
    this.gsi = 0;
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF;
      if (localc != null) {
        this.hlB = Math.max(0L, localc.dcx - this.hlB);
      }
    }
    if (Util.nowSecond() > this.iTC) {}
    for (long l = Util.nowSecond() - this.iTC;; l = 1L)
    {
      this.iTC = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.hlB, this.iTC);
      this.hlB = 0L;
      this.iTC = 0L;
      AppMethodBeat.o(107378);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107377);
    this.iTC = Util.nowSecond();
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF;
      if (localc != null) {
        this.hlB = localc.dcx;
      }
    }
    if (this.tjZ != null) {
      this.tjZ.onResume();
    }
    if (this.tkg)
    {
      if ((this.tjZ == null) || (!this.tjZ.cWG())) {
        break label118;
      }
      cWH();
    }
    for (;;)
    {
      this.tkg = false;
      AppMethodBeat.o(107377);
      return;
      label118:
      cWI();
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(107380);
    this.gvQ.setVisibility(paramInt);
    AppMethodBeat.o(107380);
  }
  
  public static abstract interface a
  {
    public abstract void Ia(int paramInt);
    
    public abstract void cVN();
    
    public abstract void cVO();
    
    public abstract void cVP();
    
    public abstract void cVQ();
    
    public abstract void cVR();
    
    public abstract void fV(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c
 * JD-Core Version:    0.7.0.1
 */