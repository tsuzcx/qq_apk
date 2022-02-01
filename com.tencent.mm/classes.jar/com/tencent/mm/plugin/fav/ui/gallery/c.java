package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavSearchUI;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.p;
import com.tencent.mm.plugin.fav.ui.p.a;
import com.tencent.mm.plugin.fav.ui.s.a;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
  implements f.b, g.b
{
  Activity fDf;
  int iWt;
  private long jXk;
  public View jac;
  private TextView jks;
  private long lJV;
  private RecyclerView mRecyclerView;
  private ProgressDialog tND;
  boolean tNV;
  private int tNW;
  private o wJr;
  aoe wLC;
  private long wQA;
  private View.OnClickListener wQB;
  private View.OnClickListener wQC;
  private View.OnClickListener wQD;
  public List<d> wQE;
  g.a wQq;
  private RelativeLayout wQr;
  private LinearLayout wQs;
  TextView wQt;
  private TextView wQu;
  private ImageButton wQv;
  private ImageButton wQw;
  private boolean wQx;
  private int wQy;
  public a wQz;
  
  public c(Activity paramActivity, View paramView, o paramo)
  {
    AppMethodBeat.i(227640);
    this.wQx = false;
    this.wQy = -1;
    this.tNV = true;
    this.jXk = 0L;
    this.lJV = 0L;
    this.wQB = new c.3(this);
    this.wQC = new c.4(this);
    this.wQD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107370);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (c.this.wQq != null) {
          c.this.wQq.LQ(((Integer)paramAnonymousView.getTag()).intValue());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107370);
      }
    };
    this.wQE = new ArrayList();
    this.fDf = paramActivity;
    this.jac = paramView;
    this.wJr = paramo;
    this.wQx = true;
    paramo = g.c.wRq;
    paramView = null;
    switch (9.wQJ[paramo.ordinal()])
    {
    }
    for (paramActivity = paramView;; paramActivity = new h(paramActivity))
    {
      paramActivity.a(this);
      this.wLC = new aoe();
      this.wLC.scene = 2;
      this.wLC.wGA = 2;
      this.wLC.index = 0;
      this.wLC.sessionId = "";
      this.wLC.query = "";
      this.wLC.wGC = "";
      this.wQr = ((RelativeLayout)this.jac.findViewById(s.e.history_option_bar));
      this.wQs = ((LinearLayout)this.jac.findViewById(s.e.history_edit_option_bar));
      this.wQt = ((TextView)this.jac.findViewById(s.e.album_tips_bar));
      this.jks = ((TextView)this.jac.findViewById(s.e.search_nothing_hint));
      this.mRecyclerView = ((RecyclerView)this.jac.findViewById(s.e.history_recycler_view));
      this.wQv = ((ImageButton)this.jac.findViewById(s.e.history_edit_forward));
      this.wQw = ((ImageButton)this.jac.findViewById(s.e.history_edit_delete));
      this.mRecyclerView.setLayoutManager(this.wQq.eW(this.fDf));
      this.mRecyclerView.a(this.wQq.fn(this.fDf));
      this.mRecyclerView.setAdapter(this.wQq.c(this.wJr));
      ((f)this.wQq.dlX()).wLC = this.wLC;
      this.mRecyclerView.setHasFixedSize(true);
      this.mRecyclerView.setOnScrollListener(new c.1(this));
      this.mRecyclerView.a(new RecyclerView.l()
      {
        private Runnable tNY;
        
        private void lU(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(232398);
          if (paramAnonymousBoolean)
          {
            c.this.wQt.removeCallbacks(this.tNY);
            if (c.this.wQt.getVisibility() != 0)
            {
              c.this.wQt.clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(c.this.fDf, s.a.fast_faded_in);
              c.this.wQt.setVisibility(0);
              c.this.wQt.startAnimation(localAnimation);
              AppMethodBeat.o(232398);
            }
          }
          else
          {
            c.this.wQt.removeCallbacks(this.tNY);
            c.this.wQt.postDelayed(this.tNY, 256L);
          }
          AppMethodBeat.o(232398);
        }
        
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(232403);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          int i;
          if (1 == paramAnonymousInt)
          {
            lU(true);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, c.this.iWt);
            localObject = c.this;
            boolean bool = WXHardCoderJNI.hcMediaGalleryScrollEnable;
            int j = WXHardCoderJNI.hcMediaGalleryScrollDelay;
            int k = WXHardCoderJNI.hcMediaGalleryScrollCPU;
            int m = WXHardCoderJNI.hcMediaGalleryScrollIO;
            if (WXHardCoderJNI.hcMediaGalleryScrollThr)
            {
              i = Process.myTid();
              ((c)localObject).iWt = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
            }
          }
          for (;;)
          {
            if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
            {
              if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).kJ() == 0) && (!c.this.tNV)) {
                c.this.wQq.K(false, -1);
              }
              c.this.tNV = false;
              q.bml().onScrollStateChanged(paramAnonymousInt);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
            AppMethodBeat.o(232403);
            return;
            i = 0;
            break;
            if (paramAnonymousInt == 0) {
              lU(false);
            }
          }
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(232401);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          localObject = (LinearLayoutManager)c.this.wQq.eW(c.this.fDf);
          paramAnonymousRecyclerView = (f)c.this.wQq.dlX();
          localObject = paramAnonymousRecyclerView.LP(((LinearLayoutManager)localObject).kJ());
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
            AppMethodBeat.o(232401);
            return;
          }
          paramAnonymousRecyclerView = paramAnonymousRecyclerView.Il(((f.d)localObject).timeStamp);
          c.this.wQt.setText(Util.nullAs(paramAnonymousRecyclerView, ""));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(232401);
        }
      });
      this.wQu = ((TextView)this.jac.findViewById(s.e.select_btn));
      this.wQu.setOnClickListener(this.wQB);
      this.wQv.setTag(Integer.valueOf(0));
      this.wQv.setOnClickListener(this.wQD);
      this.wQw.setTag(Integer.valueOf(1));
      this.wQw.setOnClickListener(this.wQD);
      AppMethodBeat.o(227640);
      return;
    }
  }
  
  private void lT(boolean paramBoolean)
  {
    AppMethodBeat.i(107390);
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.tND = s.a(this.fDf, this.fDf.getString(s.i.loading_tips), true, 0, null);
      AppMethodBeat.o(107390);
      return;
    }
    if ((this.tND != null) && (this.tND.isShowing()))
    {
      this.tND.dismiss();
      this.tND = null;
    }
    AppMethodBeat.o(107390);
  }
  
  private void nV(boolean paramBoolean)
  {
    AppMethodBeat.i(107387);
    this.wQv.setEnabled(paramBoolean);
    this.wQw.setEnabled(paramBoolean);
    AppMethodBeat.o(107387);
  }
  
  public final void H(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(107383);
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.wQy) });
    int i;
    if (this.wQz != null)
    {
      i = (int)(System.currentTimeMillis() - this.wQA);
      this.wQz.gs(i, paramInt);
    }
    if (paramBoolean)
    {
      lT(false);
      this.mRecyclerView.getAdapter().alc.notifyChanged();
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.wQy > 0)
      {
        if (this.wQy % 4 == 0) {
          this.wQy += 1;
        }
        localRecyclerView = this.mRecyclerView;
        locala = com.tencent.mm.hellhoundlib.b.c.a(this.wQy, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.jks.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        this.jks.setText(this.fDf.getString(s.i.fav_filter_img_video_noting_hint));
        AppMethodBeat.o(107383);
        return;
        i = this.mRecyclerView.getAdapter().getItemCount();
        localRecyclerView = this.mRecyclerView;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.jks.setVisibility(8);
      this.mRecyclerView.setVisibility(0);
      AppMethodBeat.o(107383);
      return;
    }
    if (paramInt > 0)
    {
      this.mRecyclerView.getAdapter().alc.notifyChanged();
      AppMethodBeat.o(107383);
      return;
    }
    this.mRecyclerView.getAdapter().cL(0);
    AppMethodBeat.o(107383);
  }
  
  public final void LO(int paramInt)
  {
    AppMethodBeat.i(107384);
    if (dlO()) {
      if (paramInt <= 0) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      nV(bool);
      AppMethodBeat.o(107384);
      return;
    }
  }
  
  public final void dS(List<d> paramList)
  {
    AppMethodBeat.i(107388);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(107388);
      return;
    }
    this.wQE.clear();
    this.wQE.addAll(paramList);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("mutil_select_is_ret", true);
    String str2;
    int i;
    if (this.wQE.size() == 1)
    {
      d locald = (d)paramList.get(0);
      String str1 = com.tencent.mm.plugin.fav.a.b.a(locald.fEd);
      str2 = com.tencent.mm.plugin.fav.a.b.d(locald.fEd);
      if (u.agG(str1))
      {
        localIntent.putExtra("image_path", str1);
        if ((!locald.dlT()) && (!locald.dlR())) {
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
      com.tencent.mm.by.c.d(this.fDf, ".ui.transmit.SelectConversationUI", localIntent, 1);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        com.tencent.mm.plugin.fav.a.h.y(((d)paramList.next()).upg.field_localId, 1);
      }
      localIntent.putExtra("image_path", str2);
      break;
      label234:
      i = 0;
      break label153;
      localIntent.putExtra("scene_from", 1);
      localIntent.putExtra("Retr_Msg_Type", 17);
      localIntent.putExtra("select_fav_select_count", this.wQE.size());
    }
    if (this.wQz != null) {
      this.wQz.LK(this.wQE.size());
    }
    AppMethodBeat.o(107388);
  }
  
  public final void dT(final List<d> paramList)
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
      paramList = ((d)localIterator.next()).upg;
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
        FavSearchUI.al(this.fDf);
        AppMethodBeat.o(107389);
        return;
      }
      localObject = new f.a(this.fDf);
      ((f.a)localObject).bBl(this.fDf.getString(s.i.favorite_delete_select_from_record_note));
      ((f.a)localObject).bBq(this.fDf.getString(s.i.favorite_cancel));
      ((f.a)localObject).bBp(this.fDf.getString(s.i.favorite_go_detail));
      ((f.a)localObject).a(new f.c()new f.c
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }, new f.c()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(232052);
          c.this.wLC.index = -1;
          ((z)com.tencent.mm.kernel.h.ae(z.class)).a(c.this.fDf, paramList, c.this.wLC);
          AppMethodBeat.o(232052);
        }
      });
      ((f.a)localObject).show();
      AppMethodBeat.o(107389);
      return;
    }
    com.tencent.mm.ui.base.h.a(this.fDf, this.fDf.getString(s.i.favorite_delete_items_confirm), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(232952);
        p.a(c.this.fDf, this.paq, new p.a()
        {
          public final void dla()
          {
            AppMethodBeat.i(227694);
            Log.v("MicroMsg.MediaHistoryGalleryUI", "do refresh job");
            c.this.wQq.K(true, -1);
            AppMethodBeat.o(227694);
          }
        });
        if (bool) {
          FavSearchUI.al(c.this.fDf);
        }
        if (c.this.wQz != null)
        {
          paramAnonymousDialogInterface = c.this.wQz;
          this.paq.size();
          paramAnonymousDialogInterface.dkU();
        }
        AppMethodBeat.o(232952);
      }
    }, null);
    AppMethodBeat.o(107389);
  }
  
  public final void dkT()
  {
    AppMethodBeat.i(227641);
    if (this.wQz != null) {
      this.wQz.dkT();
    }
    AppMethodBeat.o(227641);
  }
  
  public final void dkV()
  {
    AppMethodBeat.i(227644);
    if (this.wQz != null) {
      this.wQz.dkV();
    }
    AppMethodBeat.o(227644);
  }
  
  public final void dkW()
  {
    AppMethodBeat.i(227646);
    if (this.wQz != null) {
      this.wQz.dkW();
    }
    AppMethodBeat.o(227646);
  }
  
  public final void dkX()
  {
    AppMethodBeat.i(227649);
    if (this.wQz != null) {
      this.wQz.dkX();
    }
    AppMethodBeat.o(227649);
  }
  
  public final void dlM()
  {
    AppMethodBeat.i(227643);
    if (this.wQz != null) {
      this.wQz.dkU();
    }
    AppMethodBeat.o(227643);
  }
  
  public final void dlN()
  {
    AppMethodBeat.i(107376);
    if (this.wQq != null)
    {
      this.wQA = System.currentTimeMillis();
      this.wQq.K(true, this.wQy);
    }
    AppMethodBeat.o(107376);
  }
  
  public final boolean dlO()
  {
    AppMethodBeat.i(107381);
    if (this.wQq == null)
    {
      AppMethodBeat.o(107381);
      return false;
    }
    boolean bool = this.wQq.dlO();
    AppMethodBeat.o(107381);
    return bool;
  }
  
  public final void dlP()
  {
    AppMethodBeat.i(107385);
    if (this.wQq != null) {
      this.wQq.dlP();
    }
    this.wQr.setVisibility(8);
    this.wQs.setVisibility(0);
    nV(false);
    AppMethodBeat.o(107385);
  }
  
  public final void dlQ()
  {
    AppMethodBeat.i(107386);
    if (this.wQq != null) {
      this.wQq.dlQ();
    }
    this.wQr.setVisibility(0);
    this.wQs.setVisibility(8);
    AppMethodBeat.o(107386);
  }
  
  public final void lR(boolean paramBoolean)
  {
    AppMethodBeat.i(107382);
    if (paramBoolean)
    {
      lT(true);
      AppMethodBeat.o(107382);
      return;
    }
    this.tNW = ((GridLayoutManager)this.mRecyclerView.getLayoutManager()).kL();
    AppMethodBeat.o(107382);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107379);
    if (this.wQq != null) {
      this.wQq.onDetach();
    }
    AppMethodBeat.o(107379);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(107378);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.iWt);
    this.iWt = 0;
    if ((com.tencent.matrix.b.Vt()) && (com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class)).deH;
      if (localc != null) {
        this.jXk = Math.max(0L, localc.dgA - this.jXk);
      }
    }
    if (Util.nowSecond() > this.lJV) {}
    for (long l = Util.nowSecond() - this.lJV;; l = 1L)
    {
      this.lJV = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.jXk, this.lJV);
      this.jXk = 0L;
      this.lJV = 0L;
      AppMethodBeat.o(107378);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107377);
    this.lJV = Util.nowSecond();
    if ((com.tencent.matrix.b.Vt()) && (com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class)).deH;
      if (localc != null) {
        this.jXk = localc.dgA;
      }
    }
    if (this.wQq != null) {
      this.wQq.onResume();
    }
    if (this.wQx)
    {
      if ((this.wQq == null) || (!this.wQq.dlO())) {
        break label118;
      }
      dlP();
    }
    for (;;)
    {
      this.wQx = false;
      AppMethodBeat.o(107377);
      return;
      label118:
      dlQ();
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(107380);
    this.jac.setVisibility(paramInt);
    AppMethodBeat.o(107380);
  }
  
  public static abstract interface a
  {
    public abstract void LK(int paramInt);
    
    public abstract void dkT();
    
    public abstract void dkU();
    
    public abstract void dkV();
    
    public abstract void dkW();
    
    public abstract void dkX();
    
    public abstract void gs(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c
 * JD-Core Version:    0.7.0.1
 */