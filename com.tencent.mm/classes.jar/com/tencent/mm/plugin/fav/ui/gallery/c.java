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
import com.tencent.mm.aw.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.FavSearchUI;
import com.tencent.mm.plugin.fav.ui.p.a;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
  implements g.b
{
  private RecyclerView akA;
  Activity djj;
  private long fXQ;
  int foV;
  public View frN;
  private TextView fwf;
  private long hcE;
  private ProgressDialog nMZ;
  boolean nNo;
  private int nNp;
  agq qeT;
  g.a qjB;
  private RelativeLayout qjC;
  private LinearLayout qjD;
  TextView qjE;
  private TextView qjF;
  private ImageButton qjG;
  private ImageButton qjH;
  private boolean qjI;
  private int qjJ;
  private View.OnClickListener qjK;
  private View.OnClickListener qjL;
  private View.OnClickListener qjM;
  public List<d> qjN;
  
  public c(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(107375);
    this.qjI = false;
    this.qjJ = -1;
    this.nNo = true;
    this.fXQ = 0L;
    this.hcE = 0L;
    this.qjK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186931);
        c.this.cjK();
        AppMethodBeat.o(186931);
      }
    };
    this.qjL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107369);
        c.this.cjL();
        AppMethodBeat.o(107369);
      }
    };
    this.qjM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107370);
        if (c.this.qjB != null) {
          c.this.qjB.Cu(((Integer)paramAnonymousView.getTag()).intValue());
        }
        AppMethodBeat.o(107370);
      }
    };
    this.qjN = new ArrayList();
    this.djj = paramActivity;
    this.frN = paramView;
    this.qjI = true;
    g.c localc = g.c.qkq;
    paramView = null;
    switch (c.9.qjS[localc.ordinal()])
    {
    }
    for (paramActivity = paramView;; paramActivity = new h(paramActivity))
    {
      paramActivity.a(this);
      this.qeT = new agq();
      this.qeT.scene = 2;
      this.qeT.niJ = 2;
      this.qeT.index = 0;
      this.qeT.sessionId = "";
      this.qeT.query = "";
      this.qeT.pZZ = "";
      this.qjC = ((RelativeLayout)this.frN.findViewById(2131300756));
      this.qjD = ((LinearLayout)this.frN.findViewById(2131300752));
      this.qjE = ((TextView)this.frN.findViewById(2131296624));
      this.fwf = ((TextView)this.frN.findViewById(2131304436));
      this.akA = ((RecyclerView)this.frN.findViewById(2131300757));
      this.qjG = ((ImageButton)this.frN.findViewById(2131300751));
      this.qjH = ((ImageButton)this.frN.findViewById(2131300750));
      this.akA.setLayoutManager(this.qjB.bNL());
      this.akA.a(this.qjB.eC(this.djj));
      this.akA.setAdapter(this.qjB.bNK());
      ((f)this.qjB.cjS()).qeT = this.qeT;
      this.akA.setHasFixedSize(true);
      this.akA.setOnScrollListener(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(186926);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt1);
          localb.lT(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(186926);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(202393);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(202393);
        }
      });
      this.akA.a(new RecyclerView.m()
      {
        private Runnable nNr;
        
        private void iS(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(186929);
          if (paramAnonymousBoolean)
          {
            c.this.qjE.removeCallbacks(this.nNr);
            if (c.this.qjE.getVisibility() != 0)
            {
              c.this.qjE.clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(c.this.djj, 2130772047);
              c.this.qjE.setVisibility(0);
              c.this.qjE.startAnimation(localAnimation);
              AppMethodBeat.o(186929);
            }
          }
          else
          {
            c.this.qjE.removeCallbacks(this.nNr);
            c.this.qjE.postDelayed(this.nNr, 256L);
          }
          AppMethodBeat.o(186929);
        }
        
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107363);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          localObject = (LinearLayoutManager)c.this.qjB.bNL();
          paramAnonymousRecyclerView = (f)c.this.qjB.cjS();
          localObject = paramAnonymousRecyclerView.Ct(((LinearLayoutManager)localObject).jO());
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(107363);
            return;
          }
          paramAnonymousRecyclerView = paramAnonymousRecyclerView.nV(((f.c)localObject).timeStamp);
          c.this.qjE.setText(bt.by(paramAnonymousRecyclerView, ""));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(107363);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(186930);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
          int i;
          if (1 == paramAnonymousInt)
          {
            iS(true);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, c.this.foV);
            localObject = c.this;
            boolean bool = WXHardCoderJNI.hcMediaGalleryScrollEnable;
            int j = WXHardCoderJNI.hcMediaGalleryScrollDelay;
            int k = WXHardCoderJNI.hcMediaGalleryScrollCPU;
            int m = WXHardCoderJNI.hcMediaGalleryScrollIO;
            if (WXHardCoderJNI.hcMediaGalleryScrollThr)
            {
              i = Process.myTid();
              ((c)localObject).foV = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
            }
          }
          for (;;)
          {
            if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
            {
              if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).jO() == 0) && (!c.this.nNo)) {
                c.this.qjB.D(false, -1);
              }
              c.this.nNo = false;
              o.ayJ().cq(paramAnonymousInt);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(186930);
            return;
            i = 0;
            break;
            if (paramAnonymousInt == 0) {
              iS(false);
            }
          }
        }
      });
      this.qjF = ((TextView)this.frN.findViewById(2131304501));
      this.qjF.setOnClickListener(this.qjK);
      this.qjG.setTag(Integer.valueOf(0));
      this.qjG.setOnClickListener(this.qjM);
      this.qjH.setTag(Integer.valueOf(1));
      this.qjH.setOnClickListener(this.qjM);
      AppMethodBeat.o(107375);
      return;
    }
  }
  
  private void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(107390);
    ad.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.nMZ = com.tencent.mm.ui.base.p.a(this.djj, this.djj.getString(2131760709), true, 0, null);
      AppMethodBeat.o(107390);
      return;
    }
    if ((this.nMZ != null) && (this.nMZ.isShowing()))
    {
      this.nMZ.dismiss();
      this.nMZ = null;
    }
    AppMethodBeat.o(107390);
  }
  
  private void kH(boolean paramBoolean)
  {
    AppMethodBeat.i(107387);
    this.qjG.setEnabled(paramBoolean);
    this.qjH.setEnabled(paramBoolean);
    AppMethodBeat.o(107387);
  }
  
  public final void A(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(107383);
    ad.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.qjJ) });
    if (paramBoolean)
    {
      iR(false);
      this.akA.getAdapter().aql.notifyChanged();
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.qjJ > 0)
      {
        if (this.qjJ % 4 == 0) {
          this.qjJ += 1;
        }
        localRecyclerView = this.akA;
        locala = com.tencent.mm.hellhoundlib.b.c.a(this.qjJ, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.fwf.setVisibility(0);
        this.akA.setVisibility(8);
        this.fwf.setText(this.djj.getString(2131758832));
        AppMethodBeat.o(107383);
        return;
        int i = this.akA.getAdapter().getItemCount();
        localRecyclerView = this.akA;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.fwf.setVisibility(8);
      this.akA.setVisibility(0);
      AppMethodBeat.o(107383);
      return;
    }
    if (paramInt > 0)
    {
      this.akA.getAdapter().aql.notifyChanged();
      AppMethodBeat.o(107383);
      return;
    }
    this.akA.getAdapter().ck(0);
    AppMethodBeat.o(107383);
  }
  
  public final void Cs(int paramInt)
  {
    AppMethodBeat.i(107384);
    if (cjJ()) {
      if (paramInt <= 0) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      kH(bool);
      AppMethodBeat.o(107384);
      return;
    }
  }
  
  public final void aKR()
  {
    AppMethodBeat.i(107376);
    if (this.qjB != null) {
      this.qjB.D(true, this.qjJ);
    }
    AppMethodBeat.o(107376);
  }
  
  public final boolean cjJ()
  {
    AppMethodBeat.i(107381);
    if (this.qjB == null)
    {
      AppMethodBeat.o(107381);
      return false;
    }
    boolean bool = this.qjB.cjJ();
    AppMethodBeat.o(107381);
    return bool;
  }
  
  public final void cjK()
  {
    AppMethodBeat.i(107385);
    if (this.qjB != null) {
      this.qjB.cjK();
    }
    this.qjC.setVisibility(8);
    this.qjD.setVisibility(0);
    kH(false);
    AppMethodBeat.o(107385);
  }
  
  public final void cjL()
  {
    AppMethodBeat.i(107386);
    if (this.qjB != null) {
      this.qjB.cjL();
    }
    this.qjC.setVisibility(0);
    this.qjD.setVisibility(8);
    AppMethodBeat.o(107386);
  }
  
  public final void dr(List<d> paramList)
  {
    AppMethodBeat.i(107388);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(107388);
      return;
    }
    this.qjN.clear();
    this.qjN.addAll(paramList);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("mutil_select_is_ret", true);
    String str2;
    int i;
    if (this.qjN.size() == 1)
    {
      d locald = (d)paramList.get(0);
      String str1 = com.tencent.mm.plugin.fav.a.b.a(locald.dke);
      str2 = com.tencent.mm.plugin.fav.a.b.d(locald.dke);
      if (i.eK(str1))
      {
        localIntent.putExtra("image_path", str1);
        if ((!locald.cjO()) && (!locald.cjM())) {
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
      com.tencent.mm.bs.d.c(this.djj, ".ui.transmit.SelectConversationUI", localIntent, 1);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        com.tencent.mm.plugin.fav.a.h.i(((d)paramList.next()).okO.field_localId, 1, 0);
      }
      localIntent.putExtra("image_path", str2);
      break;
      label235:
      i = 0;
      break label153;
      localIntent.putExtra("scene_from", 1);
      localIntent.putExtra("Retr_Msg_Type", 17);
      localIntent.putExtra("select_fav_select_count", this.qjN.size());
    }
    AppMethodBeat.o(107388);
  }
  
  public final void ds(final List<d> paramList)
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
      paramList = ((d)localIterator.next()).okO;
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
        FavSearchUI.aj(this.djj);
        AppMethodBeat.o(107389);
        return;
      }
      localObject = new f.a(this.djj);
      ((f.a)localObject).aMo(this.djj.getString(2131758853));
      ((f.a)localObject).aMt(this.djj.getString(2131758848));
      ((f.a)localObject).aMs(this.djj.getString(2131758910));
      ((f.a)localObject).a(new com.tencent.mm.ui.widget.a.f.c()new com.tencent.mm.ui.widget.a.f.c
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }, new com.tencent.mm.ui.widget.a.f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(186932);
          c.this.qeT.index = -1;
          ((y)com.tencent.mm.kernel.g.ab(y.class)).a(c.this.djj, paramList, c.this.qeT);
          AppMethodBeat.o(186932);
        }
      });
      ((f.a)localObject).show();
      AppMethodBeat.o(107389);
      return;
    }
    com.tencent.mm.ui.base.h.a(this.djj, this.djj.getString(2131758852), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(186934);
        com.tencent.mm.plugin.fav.ui.p.a(c.this.djj, this.jWP, new p.a()
        {
          public final void ciY()
          {
            AppMethodBeat.i(186933);
            ad.v("MicroMsg.MediaHistoryGalleryUI", "do refresh job");
            c.this.qjB.D(true, -1);
            AppMethodBeat.o(186933);
          }
        });
        if (bool) {
          FavSearchUI.aj(c.this.djj);
        }
        AppMethodBeat.o(186934);
      }
    }, null);
    AppMethodBeat.o(107389);
  }
  
  public final void iP(boolean paramBoolean)
  {
    AppMethodBeat.i(107382);
    if (paramBoolean)
    {
      iR(true);
      AppMethodBeat.o(107382);
      return;
    }
    this.nNp = ((GridLayoutManager)this.akA.getLayoutManager()).jQ();
    AppMethodBeat.o(107382);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107379);
    if (this.qjB != null) {
      this.qjB.onDetach();
    }
    AppMethodBeat.o(107379);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(107378);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.foV);
    this.foV = 0;
    if ((com.tencent.matrix.b.GE()) && (com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class)).cBu;
      if (localc != null) {
        this.fXQ = Math.max(0L, localc.cDj - this.fXQ);
      }
    }
    if (bt.aGK() > this.hcE) {}
    for (long l = bt.aGK() - this.hcE;; l = 1L)
    {
      this.hcE = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.fXQ, this.hcE);
      this.fXQ = 0L;
      this.hcE = 0L;
      AppMethodBeat.o(107378);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107377);
    this.hcE = bt.aGK();
    if ((com.tencent.matrix.b.GE()) && (com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class)).cBu;
      if (localc != null) {
        this.fXQ = localc.cDj;
      }
    }
    if (this.qjB != null) {
      this.qjB.onResume();
    }
    if (this.qjI)
    {
      if ((this.qjB == null) || (!this.qjB.cjJ())) {
        break label118;
      }
      cjK();
    }
    for (;;)
    {
      this.qjI = false;
      AppMethodBeat.o(107377);
      return;
      label118:
      cjL();
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(107380);
    this.frN.setVisibility(paramInt);
    AppMethodBeat.o(107380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c
 * JD-Core Version:    0.7.0.1
 */