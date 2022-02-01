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
import com.tencent.mm.av.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.FavSearchUI;
import com.tencent.mm.plugin.fav.ui.p.a;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private RecyclerView alu;
  Activity dgE;
  int fsu;
  public View fvu;
  private TextView fzM;
  private long gcx;
  private long hDh;
  private ProgressDialog opZ;
  boolean oqq;
  private int oqr;
  ahp qNv;
  g.a qSd;
  private RelativeLayout qSe;
  private LinearLayout qSf;
  TextView qSg;
  private TextView qSh;
  private ImageButton qSi;
  private ImageButton qSj;
  private boolean qSk;
  private int qSl;
  private View.OnClickListener qSm;
  private View.OnClickListener qSn;
  private View.OnClickListener qSo;
  public List<d> qSp;
  
  public c(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(107375);
    this.qSk = false;
    this.qSl = -1;
    this.oqq = true;
    this.gcx = 0L;
    this.hDh = 0L;
    this.qSm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(209499);
        c.this.crr();
        AppMethodBeat.o(209499);
      }
    };
    this.qSn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107369);
        c.this.crs();
        AppMethodBeat.o(107369);
      }
    };
    this.qSo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107370);
        if (c.this.qSd != null) {
          c.this.qSd.Dp(((Integer)paramAnonymousView.getTag()).intValue());
        }
        AppMethodBeat.o(107370);
      }
    };
    this.qSp = new ArrayList();
    this.dgE = paramActivity;
    this.fvu = paramView;
    this.qSk = true;
    g.c localc = g.c.qSS;
    paramView = null;
    switch (c.9.qSu[localc.ordinal()])
    {
    }
    for (paramActivity = paramView;; paramActivity = new h(paramActivity))
    {
      paramActivity.a(this);
      this.qNv = new ahp();
      this.qNv.scene = 2;
      this.qNv.nLC = 2;
      this.qNv.index = 0;
      this.qNv.sessionId = "";
      this.qNv.query = "";
      this.qNv.qIF = "";
      this.qSe = ((RelativeLayout)this.fvu.findViewById(2131300756));
      this.qSf = ((LinearLayout)this.fvu.findViewById(2131300752));
      this.qSg = ((TextView)this.fvu.findViewById(2131296624));
      this.fzM = ((TextView)this.fvu.findViewById(2131304436));
      this.alu = ((RecyclerView)this.fvu.findViewById(2131300757));
      this.qSi = ((ImageButton)this.fvu.findViewById(2131300751));
      this.qSj = ((ImageButton)this.fvu.findViewById(2131300750));
      this.alu.setLayoutManager(this.qSd.bUW());
      this.alu.a(this.qSd.eK(this.dgE));
      this.alu.setAdapter(this.qSd.bUV());
      ((f)this.qSd.crz()).qNv = this.qNv;
      this.alu.setHasFixedSize(true);
      this.alu.setOnScrollListener(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(209493);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bb(paramAnonymousRecyclerView);
          localb.lS(paramAnonymousInt1);
          localb.lS(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(209493);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(209494);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bb(paramAnonymousRecyclerView);
          localb.lS(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(209494);
        }
      });
      this.alu.a(new RecyclerView.m()
      {
        private Runnable oqt;
        
        private void jv(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(209497);
          if (paramAnonymousBoolean)
          {
            c.this.qSg.removeCallbacks(this.oqt);
            if (c.this.qSg.getVisibility() != 0)
            {
              c.this.qSg.clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(c.this.dgE, 2130772047);
              c.this.qSg.setVisibility(0);
              c.this.qSg.startAnimation(localAnimation);
              AppMethodBeat.o(209497);
            }
          }
          else
          {
            c.this.qSg.removeCallbacks(this.oqt);
            c.this.qSg.postDelayed(this.oqt, 256L);
          }
          AppMethodBeat.o(209497);
        }
        
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107363);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          localObject = (LinearLayoutManager)c.this.qSd.bUW();
          paramAnonymousRecyclerView = (f)c.this.qSd.crz();
          localObject = paramAnonymousRecyclerView.Do(((LinearLayoutManager)localObject).jW());
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(107363);
            return;
          }
          paramAnonymousRecyclerView = paramAnonymousRecyclerView.rH(((f.c)localObject).timeStamp);
          c.this.qSg.setText(bs.bG(paramAnonymousRecyclerView, ""));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(107363);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(209498);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
          int i;
          if (1 == paramAnonymousInt)
          {
            jv(true);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, c.this.fsu);
            localObject = c.this;
            boolean bool = WXHardCoderJNI.hcMediaGalleryScrollEnable;
            int j = WXHardCoderJNI.hcMediaGalleryScrollDelay;
            int k = WXHardCoderJNI.hcMediaGalleryScrollCPU;
            int m = WXHardCoderJNI.hcMediaGalleryScrollIO;
            if (WXHardCoderJNI.hcMediaGalleryScrollThr)
            {
              i = Process.myTid();
              ((c)localObject).fsu = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
            }
          }
          for (;;)
          {
            if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
            {
              if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).jW() == 0) && (!c.this.oqq)) {
                c.this.qSd.E(false, -1);
              }
              c.this.oqq = false;
              o.aFB().cp(paramAnonymousInt);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(209498);
            return;
            i = 0;
            break;
            if (paramAnonymousInt == 0) {
              jv(false);
            }
          }
        }
      });
      this.qSh = ((TextView)this.fvu.findViewById(2131304501));
      this.qSh.setOnClickListener(this.qSm);
      this.qSi.setTag(Integer.valueOf(0));
      this.qSi.setOnClickListener(this.qSo);
      this.qSj.setTag(Integer.valueOf(1));
      this.qSj.setOnClickListener(this.qSo);
      AppMethodBeat.o(107375);
      return;
    }
  }
  
  private void ju(boolean paramBoolean)
  {
    AppMethodBeat.i(107390);
    ac.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.opZ = com.tencent.mm.ui.base.p.a(this.dgE, this.dgE.getString(2131760709), true, 0, null);
      AppMethodBeat.o(107390);
      return;
    }
    if ((this.opZ != null) && (this.opZ.isShowing()))
    {
      this.opZ.dismiss();
      this.opZ = null;
    }
    AppMethodBeat.o(107390);
  }
  
  private void ll(boolean paramBoolean)
  {
    AppMethodBeat.i(107387);
    this.qSi.setEnabled(paramBoolean);
    this.qSj.setEnabled(paramBoolean);
    AppMethodBeat.o(107387);
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(107383);
    ac.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.qSl) });
    if (paramBoolean)
    {
      ju(false);
      this.alu.getAdapter().arg.notifyChanged();
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.qSl > 0)
      {
        if (this.qSl % 4 == 0) {
          this.qSl += 1;
        }
        localRecyclerView = this.alu;
        locala = com.tencent.mm.hellhoundlib.b.c.a(this.qSl, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.fzM.setVisibility(0);
        this.alu.setVisibility(8);
        this.fzM.setText(this.dgE.getString(2131758832));
        AppMethodBeat.o(107383);
        return;
        int i = this.alu.getAdapter().getItemCount();
        localRecyclerView = this.alu;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)locala.lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.fzM.setVisibility(8);
      this.alu.setVisibility(0);
      AppMethodBeat.o(107383);
      return;
    }
    if (paramInt > 0)
    {
      this.alu.getAdapter().arg.notifyChanged();
      AppMethodBeat.o(107383);
      return;
    }
    this.alu.getAdapter().cj(0);
    AppMethodBeat.o(107383);
  }
  
  public final void Dn(int paramInt)
  {
    AppMethodBeat.i(107384);
    if (crq()) {
      if (paramInt <= 0) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      ll(bool);
      AppMethodBeat.o(107384);
      return;
    }
  }
  
  public final void aRI()
  {
    AppMethodBeat.i(107376);
    if (this.qSd != null) {
      this.qSd.E(true, this.qSl);
    }
    AppMethodBeat.o(107376);
  }
  
  public final boolean crq()
  {
    AppMethodBeat.i(107381);
    if (this.qSd == null)
    {
      AppMethodBeat.o(107381);
      return false;
    }
    boolean bool = this.qSd.crq();
    AppMethodBeat.o(107381);
    return bool;
  }
  
  public final void crr()
  {
    AppMethodBeat.i(107385);
    if (this.qSd != null) {
      this.qSd.crr();
    }
    this.qSe.setVisibility(8);
    this.qSf.setVisibility(0);
    ll(false);
    AppMethodBeat.o(107385);
  }
  
  public final void crs()
  {
    AppMethodBeat.i(107386);
    if (this.qSd != null) {
      this.qSd.crs();
    }
    this.qSe.setVisibility(0);
    this.qSf.setVisibility(8);
    AppMethodBeat.o(107386);
  }
  
  public final void dt(List<d> paramList)
  {
    AppMethodBeat.i(107388);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(107388);
      return;
    }
    this.qSp.clear();
    this.qSp.addAll(paramList);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("mutil_select_is_ret", true);
    String str2;
    int i;
    if (this.qSp.size() == 1)
    {
      d locald = (d)paramList.get(0);
      String str1 = com.tencent.mm.plugin.fav.a.b.a(locald.dhz);
      str2 = com.tencent.mm.plugin.fav.a.b.d(locald.dhz);
      if (i.eA(str1))
      {
        localIntent.putExtra("image_path", str1);
        if ((!locald.crv()) && (!locald.crt())) {
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
      com.tencent.mm.br.d.c(this.dgE, ".ui.transmit.SelectConversationUI", localIntent, 1);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        com.tencent.mm.plugin.fav.a.h.i(((d)paramList.next()).oOo.field_localId, 1, 0);
      }
      localIntent.putExtra("image_path", str2);
      break;
      label235:
      i = 0;
      break label153;
      localIntent.putExtra("scene_from", 1);
      localIntent.putExtra("Retr_Msg_Type", 17);
      localIntent.putExtra("select_fav_select_count", this.qSp.size());
    }
    AppMethodBeat.o(107388);
  }
  
  public final void du(final List<d> paramList)
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
      paramList = ((d)localIterator.next()).oOo;
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
        FavSearchUI.an(this.dgE);
        AppMethodBeat.o(107389);
        return;
      }
      localObject = new f.a(this.dgE);
      ((f.a)localObject).aRQ(this.dgE.getString(2131758853));
      ((f.a)localObject).aRV(this.dgE.getString(2131758848));
      ((f.a)localObject).aRU(this.dgE.getString(2131758910));
      ((f.a)localObject).a(new com.tencent.mm.ui.widget.a.f.c()new com.tencent.mm.ui.widget.a.f.c
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }, new com.tencent.mm.ui.widget.a.f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(209500);
          c.this.qNv.index = -1;
          ((y)com.tencent.mm.kernel.g.ab(y.class)).a(c.this.dgE, paramList, c.this.qNv);
          AppMethodBeat.o(209500);
        }
      });
      ((f.a)localObject).show();
      AppMethodBeat.o(107389);
      return;
    }
    com.tencent.mm.ui.base.h.a(this.dgE, this.dgE.getString(2131758852), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(209502);
        com.tencent.mm.plugin.fav.ui.p.a(c.this.dgE, this.kxB, new p.a()
        {
          public final void cqF()
          {
            AppMethodBeat.i(209501);
            ac.v("MicroMsg.MediaHistoryGalleryUI", "do refresh job");
            c.this.qSd.E(true, -1);
            AppMethodBeat.o(209501);
          }
        });
        if (bool) {
          FavSearchUI.an(c.this.dgE);
        }
        AppMethodBeat.o(209502);
      }
    }, null);
    AppMethodBeat.o(107389);
  }
  
  public final void js(boolean paramBoolean)
  {
    AppMethodBeat.i(107382);
    if (paramBoolean)
    {
      ju(true);
      AppMethodBeat.o(107382);
      return;
    }
    this.oqr = ((GridLayoutManager)this.alu.getLayoutManager()).jY();
    AppMethodBeat.o(107382);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107379);
    if (this.qSd != null) {
      this.qSd.onDetach();
    }
    AppMethodBeat.o(107379);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(107378);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.fsu);
    this.fsu = 0;
    if ((com.tencent.matrix.b.Gp()) && (com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class)).cyD;
      if (localc != null) {
        this.gcx = Math.max(0L, localc.cAr - this.gcx);
      }
    }
    if (bs.aNx() > this.hDh) {}
    for (long l = bs.aNx() - this.hDh;; l = 1L)
    {
      this.hDh = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.gcx, this.hDh);
      this.gcx = 0L;
      this.hDh = 0L;
      AppMethodBeat.o(107378);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107377);
    this.hDh = bs.aNx();
    if ((com.tencent.matrix.b.Gp()) && (com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class)).cyD;
      if (localc != null) {
        this.gcx = localc.cAr;
      }
    }
    if (this.qSd != null) {
      this.qSd.onResume();
    }
    if (this.qSk)
    {
      if ((this.qSd == null) || (!this.qSd.crq())) {
        break label118;
      }
      crr();
    }
    for (;;)
    {
      this.qSk = false;
      AppMethodBeat.o(107377);
      return;
      label118:
      crs();
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(107380);
    this.fvu.setVisibility(paramInt);
    AppMethodBeat.o(107380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c
 * JD-Core Version:    0.7.0.1
 */