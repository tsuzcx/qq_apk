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
import com.tencent.mm.av.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.FavSearchUI;
import com.tencent.mm.plugin.fav.ui.p.a;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
  implements f.b, g.b
{
  private RecyclerView anl;
  Activity dtg;
  int fMX;
  public View fQH;
  private TextView fVi;
  private long gyO;
  private long hYE;
  private ProgressDialog oZW;
  boolean pan;
  private int pao;
  akp rFI;
  private View.OnClickListener rKA;
  private View.OnClickListener rKB;
  public List<d> rKC;
  g.a rKo;
  private RelativeLayout rKp;
  private LinearLayout rKq;
  TextView rKr;
  private TextView rKs;
  private ImageButton rKt;
  private ImageButton rKu;
  private boolean rKv;
  private int rKw;
  public a rKx;
  private long rKy;
  private View.OnClickListener rKz;
  
  public c(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(107375);
    this.rKv = false;
    this.rKw = -1;
    this.pan = true;
    this.gyO = 0L;
    this.hYE = 0L;
    this.rKz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191085);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        c.this.cyE();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191085);
      }
    };
    this.rKA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107369);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        c.this.cyF();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107369);
      }
    };
    this.rKB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107370);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (c.this.rKo != null) {
          c.this.rKo.Ev(((Integer)paramAnonymousView.getTag()).intValue());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107370);
      }
    };
    this.rKC = new ArrayList();
    this.dtg = paramActivity;
    this.fQH = paramView;
    this.rKv = true;
    g.c localc = g.c.rLg;
    paramView = null;
    switch (9.rKH[localc.ordinal()])
    {
    }
    for (paramActivity = paramView;; paramActivity = new h(paramActivity))
    {
      paramActivity.a(this);
      this.rFI = new akp();
      this.rFI.scene = 2;
      this.rFI.otZ = 2;
      this.rFI.index = 0;
      this.rFI.sessionId = "";
      this.rFI.query = "";
      this.rFI.rAT = "";
      this.rKp = ((RelativeLayout)this.fQH.findViewById(2131300756));
      this.rKq = ((LinearLayout)this.fQH.findViewById(2131300752));
      this.rKr = ((TextView)this.fQH.findViewById(2131296624));
      this.fVi = ((TextView)this.fQH.findViewById(2131304436));
      this.anl = ((RecyclerView)this.fQH.findViewById(2131300757));
      this.rKt = ((ImageButton)this.fQH.findViewById(2131300751));
      this.rKu = ((ImageButton)this.fQH.findViewById(2131300750));
      this.anl.setLayoutManager(this.rKo.caQ());
      this.anl.a(this.rKo.eO(this.dtg));
      this.anl.setAdapter(this.rKo.caP());
      ((f)this.rKo.cyM()).rFI = this.rFI;
      this.anl.setHasFixedSize(true);
      this.anl.setOnScrollListener(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(191079);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt1);
          localb.mu(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(191079);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(191080);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(191080);
        }
      });
      this.anl.a(new RecyclerView.m()
      {
        private Runnable paq;
        
        private void jF(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(191083);
          if (paramAnonymousBoolean)
          {
            c.this.rKr.removeCallbacks(this.paq);
            if (c.this.rKr.getVisibility() != 0)
            {
              c.this.rKr.clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(c.this.dtg, 2130772047);
              c.this.rKr.setVisibility(0);
              c.this.rKr.startAnimation(localAnimation);
              AppMethodBeat.o(191083);
            }
          }
          else
          {
            c.this.rKr.removeCallbacks(this.paq);
            c.this.rKr.postDelayed(this.paq, 256L);
          }
          AppMethodBeat.o(191083);
        }
        
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107363);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          localObject = (LinearLayoutManager)c.this.rKo.caQ();
          paramAnonymousRecyclerView = (f)c.this.rKo.cyM();
          localObject = paramAnonymousRecyclerView.Eu(((LinearLayoutManager)localObject).km());
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(107363);
            return;
          }
          paramAnonymousRecyclerView = paramAnonymousRecyclerView.tX(((f.d)localObject).timeStamp);
          c.this.rKr.setText(bu.bI(paramAnonymousRecyclerView, ""));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(107363);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(191084);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          int i;
          if (1 == paramAnonymousInt)
          {
            jF(true);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, c.this.fMX);
            localObject = c.this;
            boolean bool = WXHardCoderJNI.hcMediaGalleryScrollEnable;
            int j = WXHardCoderJNI.hcMediaGalleryScrollDelay;
            int k = WXHardCoderJNI.hcMediaGalleryScrollCPU;
            int m = WXHardCoderJNI.hcMediaGalleryScrollIO;
            if (WXHardCoderJNI.hcMediaGalleryScrollThr)
            {
              i = Process.myTid();
              ((c)localObject).fMX = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
            }
          }
          for (;;)
          {
            if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
            {
              if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).km() == 0) && (!c.this.pan)) {
                c.this.rKo.F(false, -1);
              }
              c.this.pan = false;
              q.aJb().cp(paramAnonymousInt);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(191084);
            return;
            i = 0;
            break;
            if (paramAnonymousInt == 0) {
              jF(false);
            }
          }
        }
      });
      this.rKs = ((TextView)this.fQH.findViewById(2131304501));
      this.rKs.setOnClickListener(this.rKz);
      this.rKt.setTag(Integer.valueOf(0));
      this.rKt.setOnClickListener(this.rKB);
      this.rKu.setTag(Integer.valueOf(1));
      this.rKu.setOnClickListener(this.rKB);
      AppMethodBeat.o(107375);
      return;
    }
  }
  
  private void jE(boolean paramBoolean)
  {
    AppMethodBeat.i(107390);
    ae.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.oZW = com.tencent.mm.ui.base.p.a(this.dtg, this.dtg.getString(2131760709), true, 0, null);
      AppMethodBeat.o(107390);
      return;
    }
    if ((this.oZW != null) && (this.oZW.isShowing()))
    {
      this.oZW.dismiss();
      this.oZW = null;
    }
    AppMethodBeat.o(107390);
  }
  
  private void lE(boolean paramBoolean)
  {
    AppMethodBeat.i(107387);
    this.rKt.setEnabled(paramBoolean);
    this.rKu.setEnabled(paramBoolean);
    AppMethodBeat.o(107387);
  }
  
  public final void C(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(107383);
    ae.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.rKw) });
    int i;
    if (this.rKx != null)
    {
      i = (int)(System.currentTimeMillis() - this.rKy);
      this.rKx.fE(i, paramInt);
    }
    if (paramBoolean)
    {
      jE(false);
      this.anl.getAdapter().asY.notifyChanged();
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.rKw > 0)
      {
        if (this.rKw % 4 == 0) {
          this.rKw += 1;
        }
        localRecyclerView = this.anl;
        locala = com.tencent.mm.hellhoundlib.b.c.a(this.rKw, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahE(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.fVi.setVisibility(0);
        this.anl.setVisibility(8);
        this.fVi.setText(this.dtg.getString(2131758832));
        AppMethodBeat.o(107383);
        return;
        i = this.anl.getAdapter().getItemCount();
        localRecyclerView = this.anl;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahE(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.fVi.setVisibility(8);
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
  
  public final void Et(int paramInt)
  {
    AppMethodBeat.i(107384);
    if (cyD()) {
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
  
  public final void aVt()
  {
    AppMethodBeat.i(107376);
    if (this.rKo != null)
    {
      this.rKy = System.currentTimeMillis();
      this.rKo.F(true, this.rKw);
    }
    AppMethodBeat.o(107376);
  }
  
  public final void cxJ()
  {
    AppMethodBeat.i(191090);
    if (this.rKx != null) {
      this.rKx.cxJ();
    }
    AppMethodBeat.o(191090);
  }
  
  public final void cxL()
  {
    AppMethodBeat.i(191092);
    if (this.rKx != null) {
      this.rKx.cxL();
    }
    AppMethodBeat.o(191092);
  }
  
  public final void cxM()
  {
    AppMethodBeat.i(191093);
    if (this.rKx != null) {
      this.rKx.cxM();
    }
    AppMethodBeat.o(191093);
  }
  
  public final void cxN()
  {
    AppMethodBeat.i(191094);
    if (this.rKx != null) {
      this.rKx.cxN();
    }
    AppMethodBeat.o(191094);
  }
  
  public final void cyC()
  {
    AppMethodBeat.i(191091);
    if (this.rKx != null) {
      this.rKx.cxK();
    }
    AppMethodBeat.o(191091);
  }
  
  public final boolean cyD()
  {
    AppMethodBeat.i(107381);
    if (this.rKo == null)
    {
      AppMethodBeat.o(107381);
      return false;
    }
    boolean bool = this.rKo.cyD();
    AppMethodBeat.o(107381);
    return bool;
  }
  
  public final void cyE()
  {
    AppMethodBeat.i(107385);
    if (this.rKo != null) {
      this.rKo.cyE();
    }
    this.rKp.setVisibility(8);
    this.rKq.setVisibility(0);
    lE(false);
    AppMethodBeat.o(107385);
  }
  
  public final void cyF()
  {
    AppMethodBeat.i(107386);
    if (this.rKo != null) {
      this.rKo.cyF();
    }
    this.rKp.setVisibility(0);
    this.rKq.setVisibility(8);
    AppMethodBeat.o(107386);
  }
  
  public final void dy(List<d> paramList)
  {
    AppMethodBeat.i(107388);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(107388);
      return;
    }
    this.rKC.clear();
    this.rKC.addAll(paramList);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("mutil_select_is_ret", true);
    String str2;
    int i;
    if (this.rKC.size() == 1)
    {
      d locald = (d)paramList.get(0);
      String str1 = com.tencent.mm.plugin.fav.a.b.a(locald.dud);
      str2 = com.tencent.mm.plugin.fav.a.b.d(locald.dud);
      if (o.fB(str1))
      {
        localIntent.putExtra("image_path", str1);
        if ((!locald.cyI()) && (!locald.cyG())) {
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
      com.tencent.mm.br.d.c(this.dtg, ".ui.transmit.SelectConversationUI", localIntent, 1);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        com.tencent.mm.plugin.fav.a.h.i(((d)paramList.next()).pyC.field_localId, 1, 0);
      }
      localIntent.putExtra("image_path", str2);
      break;
      label235:
      i = 0;
      break label153;
      localIntent.putExtra("scene_from", 1);
      localIntent.putExtra("Retr_Msg_Type", 17);
      localIntent.putExtra("select_fav_select_count", this.rKC.size());
    }
    if (this.rKx != null) {
      this.rKx.Ep(this.rKC.size());
    }
    AppMethodBeat.o(107388);
  }
  
  public final void dz(final List<d> paramList)
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
      paramList = ((d)localIterator.next()).pyC;
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
        FavSearchUI.ao(this.dtg);
        AppMethodBeat.o(107389);
        return;
      }
      localObject = new f.a(this.dtg);
      ((f.a)localObject).aZq(this.dtg.getString(2131758853));
      ((f.a)localObject).aZv(this.dtg.getString(2131758848));
      ((f.a)localObject).aZu(this.dtg.getString(2131758910));
      ((f.a)localObject).a(new f.c()new f.c
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }, new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(191086);
          c.this.rFI.index = -1;
          ((y)com.tencent.mm.kernel.g.ab(y.class)).a(c.this.dtg, paramList, c.this.rFI);
          AppMethodBeat.o(191086);
        }
      });
      ((f.a)localObject).show();
      AppMethodBeat.o(107389);
      return;
    }
    com.tencent.mm.ui.base.h.a(this.dtg, this.dtg.getString(2131758852), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(191088);
        com.tencent.mm.plugin.fav.ui.p.a(c.this.dtg, this.kXq, new p.a()
        {
          public final void cxQ()
          {
            AppMethodBeat.i(191087);
            ae.v("MicroMsg.MediaHistoryGalleryUI", "do refresh job");
            c.this.rKo.F(true, -1);
            AppMethodBeat.o(191087);
          }
        });
        if (bool) {
          FavSearchUI.ao(c.this.dtg);
        }
        if (c.this.rKx != null)
        {
          paramAnonymousDialogInterface = c.this.rKx;
          this.kXq.size();
          paramAnonymousDialogInterface.cxK();
        }
        AppMethodBeat.o(191088);
      }
    }, null);
    AppMethodBeat.o(107389);
  }
  
  public final void jC(boolean paramBoolean)
  {
    AppMethodBeat.i(107382);
    if (paramBoolean)
    {
      jE(true);
      AppMethodBeat.o(107382);
      return;
    }
    this.pao = ((GridLayoutManager)this.anl.getLayoutManager()).ko();
    AppMethodBeat.o(107382);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107379);
    if (this.rKo != null) {
      this.rKo.onDetach();
    }
    AppMethodBeat.o(107379);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(107378);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.fMX);
    this.fMX = 0;
    if ((com.tencent.matrix.b.HS()) && (com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class)).cKh;
      if (localc != null) {
        this.gyO = Math.max(0L, localc.cLZ - this.gyO);
      }
    }
    if (bu.aRi() > this.hYE) {}
    for (long l = bu.aRi() - this.hYE;; l = 1L)
    {
      this.hYE = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.gyO, this.hYE);
      this.gyO = 0L;
      this.hYE = 0L;
      AppMethodBeat.o(107378);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107377);
    this.hYE = bu.aRi();
    if ((com.tencent.matrix.b.HS()) && (com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class)).cKh;
      if (localc != null) {
        this.gyO = localc.cLZ;
      }
    }
    if (this.rKo != null) {
      this.rKo.onResume();
    }
    if (this.rKv)
    {
      if ((this.rKo == null) || (!this.rKo.cyD())) {
        break label118;
      }
      cyE();
    }
    for (;;)
    {
      this.rKv = false;
      AppMethodBeat.o(107377);
      return;
      label118:
      cyF();
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(107380);
    this.fQH.setVisibility(paramInt);
    AppMethodBeat.o(107380);
  }
  
  public static abstract interface a
  {
    public abstract void Ep(int paramInt);
    
    public abstract void cxJ();
    
    public abstract void cxK();
    
    public abstract void cxL();
    
    public abstract void cxM();
    
    public abstract void cxN();
    
    public abstract void fE(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c
 * JD-Core Version:    0.7.0.1
 */