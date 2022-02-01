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
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavSearchUI;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.o.a;
import com.tencent.mm.plugin.fav.ui.q.a;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
  implements f.b, g.b
{
  private FavoriteImageServer AfM;
  arx Aia;
  g.a AmS;
  private RelativeLayout AmT;
  private LinearLayout AmU;
  TextView AmV;
  private TextView AmW;
  private ImageButton AmX;
  private ImageButton AmY;
  private boolean AmZ;
  private int Ana;
  public a Anb;
  private long Anc;
  private View.OnClickListener Ane;
  private View.OnClickListener Anf;
  private View.OnClickListener Ang;
  public List<d> Anh;
  Activity hHU;
  public View lBX;
  private TextView lMW;
  int lyw;
  private RecyclerView mRecyclerView;
  private long mxe;
  private long oCx;
  private ProgressDialog wQT;
  boolean wRl;
  private int wRm;
  
  public c(Activity paramActivity, View paramView, FavoriteImageServer paramFavoriteImageServer)
  {
    AppMethodBeat.i(274510);
    this.AmZ = false;
    this.Ana = -1;
    this.wRl = true;
    this.mxe = 0L;
    this.oCx = 0L;
    this.Ane = new c.3(this);
    this.Anf = new c.4(this);
    this.Ang = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107370);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (c.this.AmS != null) {
          c.this.AmS.MN(((Integer)paramAnonymousView.getTag()).intValue());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107370);
      }
    };
    this.Anh = new ArrayList();
    this.hHU = paramActivity;
    this.lBX = paramView;
    this.AfM = paramFavoriteImageServer;
    this.AmZ = true;
    paramFavoriteImageServer = g.c.AnT;
    paramView = null;
    switch (9.Anm[paramFavoriteImageServer.ordinal()])
    {
    }
    for (paramActivity = paramView;; paramActivity = new h(paramActivity))
    {
      paramActivity.a(this);
      this.Aia = new arx();
      this.Aia.scene = 2;
      this.Aia.AcJ = 2;
      this.Aia.index = 0;
      this.Aia.sessionId = "";
      this.Aia.query = "";
      this.Aia.AcL = "";
      this.AmT = ((RelativeLayout)this.lBX.findViewById(q.e.history_option_bar));
      this.AmU = ((LinearLayout)this.lBX.findViewById(q.e.history_edit_option_bar));
      this.AmV = ((TextView)this.lBX.findViewById(q.e.album_tips_bar));
      this.lMW = ((TextView)this.lBX.findViewById(q.e.search_nothing_hint));
      this.mRecyclerView = ((RecyclerView)this.lBX.findViewById(q.e.history_recycler_view));
      this.AmX = ((ImageButton)this.lBX.findViewById(q.e.history_edit_forward));
      this.AmY = ((ImageButton)this.lBX.findViewById(q.e.history_edit_delete));
      this.mRecyclerView.setLayoutManager(this.AmS.fT(this.hHU));
      this.mRecyclerView.a(this.AmS.gl(this.hHU));
      this.mRecyclerView.setAdapter(this.AmS.c(this.AfM));
      ((f)this.AmS.dSN()).Aia = this.Aia;
      this.mRecyclerView.setHasFixedSize(true);
      this.mRecyclerView.setOnScrollListener(new c.1(this));
      this.mRecyclerView.a(new RecyclerView.l()
      {
        private Runnable wRo;
        
        private void np(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(274496);
          if (paramAnonymousBoolean)
          {
            c.this.AmV.removeCallbacks(this.wRo);
            if (c.this.AmV.getVisibility() != 0)
            {
              c.this.AmV.clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(c.this.hHU, q.a.fast_faded_in);
              c.this.AmV.setVisibility(0);
              c.this.AmV.startAnimation(localAnimation);
              AppMethodBeat.o(274496);
            }
          }
          else
          {
            c.this.AmV.removeCallbacks(this.wRo);
            c.this.AmV.postDelayed(this.wRo, 256L);
          }
          AppMethodBeat.o(274496);
        }
        
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(274499);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          int i;
          if (1 == paramAnonymousInt)
          {
            np(true);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, c.this.lyw);
            localObject = c.this;
            boolean bool = WXHardCoderJNI.hcMediaGalleryScrollEnable;
            int j = WXHardCoderJNI.hcMediaGalleryScrollDelay;
            int k = WXHardCoderJNI.hcMediaGalleryScrollCPU;
            int m = WXHardCoderJNI.hcMediaGalleryScrollIO;
            if (WXHardCoderJNI.hcMediaGalleryScrollThr)
            {
              i = Process.myTid();
              ((c)localObject).lyw = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
            }
          }
          for (;;)
          {
            if ((paramAnonymousRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
            {
              if ((((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).Ju() == 0) && (!c.this.wRl)) {
                c.this.AmS.I(false, -1);
              }
              c.this.wRl = false;
              r.bKe().onScrollStateChanged(paramAnonymousInt);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
            AppMethodBeat.o(274499);
            return;
            i = 0;
            break;
            if (paramAnonymousInt == 0) {
              np(false);
            }
          }
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(274498);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          localObject = (LinearLayoutManager)c.this.AmS.fT(c.this.hHU);
          paramAnonymousRecyclerView = (f)c.this.AmS.dSN();
          localObject = paramAnonymousRecyclerView.MM(((LinearLayoutManager)localObject).Ju());
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
            AppMethodBeat.o(274498);
            return;
          }
          paramAnonymousRecyclerView = paramAnonymousRecyclerView.kD(((f.d)localObject).timeStamp);
          c.this.AmV.setText(Util.nullAs(paramAnonymousRecyclerView, ""));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(274498);
        }
      });
      this.AmW = ((TextView)this.lBX.findViewById(q.e.select_btn));
      this.AmW.setOnClickListener(this.Ane);
      this.AmX.setTag(Integer.valueOf(0));
      this.AmX.setOnClickListener(this.Ang);
      this.AmY.setTag(Integer.valueOf(1));
      this.AmY.setOnClickListener(this.Ang);
      AppMethodBeat.o(274510);
      return;
    }
  }
  
  private void no(boolean paramBoolean)
  {
    AppMethodBeat.i(107390);
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.wQT = w.a(this.hHU, this.hHU.getString(q.i.loading_tips), true, 0, null);
      AppMethodBeat.o(107390);
      return;
    }
    if ((this.wQT != null) && (this.wQT.isShowing()))
    {
      this.wQT.dismiss();
      this.wQT = null;
    }
    AppMethodBeat.o(107390);
  }
  
  private void pv(boolean paramBoolean)
  {
    AppMethodBeat.i(107387);
    this.AmX.setEnabled(paramBoolean);
    this.AmY.setEnabled(paramBoolean);
    AppMethodBeat.o(107387);
  }
  
  public final void F(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(107383);
    Log.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.Ana) });
    int i;
    if (this.Anb != null)
    {
      i = (int)(System.currentTimeMillis() - this.Anc);
      this.Anb.hl(i, paramInt);
    }
    if (paramBoolean)
    {
      no(false);
      this.mRecyclerView.getAdapter().bZE.notifyChanged();
      RecyclerView localRecyclerView;
      com.tencent.mm.hellhoundlib.b.a locala;
      if (this.Ana > 0)
      {
        if (this.Ana % 4 == 0) {
          this.Ana += 1;
        }
        localRecyclerView = this.mRecyclerView;
        locala = com.tencent.mm.hellhoundlib.b.c.a(this.Ana, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      while (paramInt <= 0)
      {
        this.lMW.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        this.lMW.setText(this.hHU.getString(q.i.fav_filter_img_video_noting_hint));
        AppMethodBeat.o(107383);
        return;
        i = this.mRecyclerView.getAdapter().getItemCount();
        localRecyclerView = this.mRecyclerView;
        locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
      }
      this.lMW.setVisibility(8);
      this.mRecyclerView.setVisibility(0);
      AppMethodBeat.o(107383);
      return;
    }
    if (paramInt > 0)
    {
      this.mRecyclerView.getAdapter().bZE.notifyChanged();
      AppMethodBeat.o(107383);
      return;
    }
    this.mRecyclerView.getAdapter().fV(0);
    AppMethodBeat.o(107383);
  }
  
  public final void ML(int paramInt)
  {
    AppMethodBeat.i(107384);
    if (dSE()) {
      if (paramInt <= 0) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      pv(bool);
      AppMethodBeat.o(107384);
      return;
    }
  }
  
  public final void dRJ()
  {
    AppMethodBeat.i(274513);
    if (this.Anb != null) {
      this.Anb.dRJ();
    }
    AppMethodBeat.o(274513);
  }
  
  public final void dRL()
  {
    AppMethodBeat.i(274515);
    if (this.Anb != null) {
      this.Anb.dRL();
    }
    AppMethodBeat.o(274515);
  }
  
  public final void dRM()
  {
    AppMethodBeat.i(274516);
    if (this.Anb != null) {
      this.Anb.dRM();
    }
    AppMethodBeat.o(274516);
  }
  
  public final void dRN()
  {
    AppMethodBeat.i(274518);
    if (this.Anb != null) {
      this.Anb.dRN();
    }
    AppMethodBeat.o(274518);
  }
  
  public final void dSC()
  {
    AppMethodBeat.i(274514);
    if (this.Anb != null) {
      this.Anb.dRK();
    }
    AppMethodBeat.o(274514);
  }
  
  public final void dSD()
  {
    AppMethodBeat.i(107376);
    if (this.AmS != null)
    {
      this.Anc = System.currentTimeMillis();
      this.AmS.I(true, this.Ana);
    }
    AppMethodBeat.o(107376);
  }
  
  public final boolean dSE()
  {
    AppMethodBeat.i(107381);
    if (this.AmS == null)
    {
      AppMethodBeat.o(107381);
      return false;
    }
    boolean bool = this.AmS.dSE();
    AppMethodBeat.o(107381);
    return bool;
  }
  
  public final void dSF()
  {
    AppMethodBeat.i(107385);
    if (this.AmS != null) {
      this.AmS.dSF();
    }
    this.AmT.setVisibility(8);
    this.AmU.setVisibility(0);
    pv(false);
    AppMethodBeat.o(107385);
  }
  
  public final void dSG()
  {
    AppMethodBeat.i(107386);
    if (this.AmS != null) {
      this.AmS.dSG();
    }
    this.AmT.setVisibility(0);
    this.AmU.setVisibility(8);
    AppMethodBeat.o(107386);
  }
  
  public final void fN(List<d> paramList)
  {
    int i = 0;
    AppMethodBeat.i(107388);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(107388);
      return;
    }
    this.Anh.clear();
    this.Anh.addAll(paramList);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("mutil_select_is_ret", true);
    Object localObject1;
    Object localObject2;
    String str;
    if (this.Anh.size() == 1)
    {
      localObject1 = (d)paramList.get(0);
      localObject2 = com.tencent.mm.plugin.fav.a.b.a(((d)localObject1).hIT);
      str = com.tencent.mm.plugin.fav.a.b.d(((d)localObject1).hIT);
      if (y.ZC((String)localObject2))
      {
        localIntent.putExtra("image_path", (String)localObject2);
        if ((((d)localObject1).dSJ()) || (((d)localObject1).dSH())) {
          i = 1;
        }
        localIntent.putExtra("Retr_Msg_Type", i);
        localIntent.putExtra("select_is_ret", true);
        if (((d)localObject1).xvD != null) {
          ((ab)com.tencent.mm.kernel.h.ax(ab.class)).c(Long.valueOf(((d)localObject1).xvD.field_localId));
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.br.c.d(this.hHU, ".ui.transmit.SelectConversationUI", localIntent, 1);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        com.tencent.mm.plugin.fav.a.h.I(((d)paramList.next()).xvD.field_localId, 1);
      }
      localIntent.putExtra("image_path", str);
      break;
      localIntent.putExtra("scene_from", 1);
      localIntent.putExtra("Retr_Msg_Type", 17);
      localIntent.putExtra("select_fav_select_count", this.Anh.size());
      localObject1 = this.Anh.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((d)localObject2).xvD != null)) {
          ((ab)com.tencent.mm.kernel.h.ax(ab.class)).c(Long.valueOf(((d)localObject2).xvD.field_localId));
        }
      }
    }
    if (this.Anb != null) {
      this.Anb.MH(this.Anh.size());
    }
    AppMethodBeat.o(107388);
  }
  
  public final void fO(final List<d> paramList)
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
      paramList = ((d)localIterator.next()).xvD;
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
        FavSearchUI.au(this.hHU);
        AppMethodBeat.o(107389);
        return;
      }
      localObject = new com.tencent.mm.ui.widget.a.g.a(this.hHU);
      ((com.tencent.mm.ui.widget.a.g.a)localObject).bDE(this.hHU.getString(q.i.favorite_delete_select_from_record_note));
      ((com.tencent.mm.ui.widget.a.g.a)localObject).bDJ(this.hHU.getString(q.i.favorite_cancel));
      ((com.tencent.mm.ui.widget.a.g.a)localObject).bDI(this.hHU.getString(q.i.favorite_go_detail));
      ((com.tencent.mm.ui.widget.a.g.a)localObject).a(new com.tencent.mm.ui.widget.a.g.c()new com.tencent.mm.ui.widget.a.g.c
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString) {}
      }, new com.tencent.mm.ui.widget.a.g.c()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(274494);
          c.this.Aia.index = -1;
          ((z)com.tencent.mm.kernel.h.ax(z.class)).a(c.this.hHU, paramList, c.this.Aia);
          AppMethodBeat.o(274494);
        }
      });
      ((com.tencent.mm.ui.widget.a.g.a)localObject).show();
      AppMethodBeat.o(107389);
      return;
    }
    k.a(this.hHU, this.hHU.getString(q.i.favorite_delete_items_confirm), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(274493);
        o.a(c.this.hHU, this.sfJ, new o.a()
        {
          public final void dRQ()
          {
            AppMethodBeat.i(274476);
            Log.v("MicroMsg.MediaHistoryGalleryUI", "do refresh job");
            c.this.AmS.I(true, -1);
            AppMethodBeat.o(274476);
          }
        });
        if (bool) {
          FavSearchUI.au(c.this.hHU);
        }
        if (c.this.Anb != null)
        {
          paramAnonymousDialogInterface = c.this.Anb;
          this.sfJ.size();
          paramAnonymousDialogInterface.dRK();
        }
        AppMethodBeat.o(274493);
      }
    }, null);
    AppMethodBeat.o(107389);
  }
  
  public final void nm(boolean paramBoolean)
  {
    AppMethodBeat.i(107382);
    if (paramBoolean)
    {
      no(true);
      AppMethodBeat.o(107382);
      return;
    }
    this.wRm = ((GridLayoutManager)this.mRecyclerView.getLayoutManager()).Jw();
    AppMethodBeat.o(107382);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107379);
    if (this.AmS != null) {
      this.AmS.onDetach();
    }
    AppMethodBeat.o(107379);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(107378);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.lyw);
    this.lyw = 0;
    if ((com.tencent.matrix.c.isInstalled()) && (com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.tracer.b localb = ((com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class)).fdr;
      if (localb != null) {
        this.mxe = Math.max(0L, localb.ffH - this.mxe);
      }
    }
    if (Util.nowSecond() > this.oCx) {}
    for (long l = Util.nowSecond() - this.oCx;; l = 1L)
    {
      this.oCx = l;
      WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.mxe, this.oCx);
      this.mxe = 0L;
      this.oCx = 0L;
      AppMethodBeat.o(107378);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(107377);
    this.oCx = Util.nowSecond();
    if ((com.tencent.matrix.c.isInstalled()) && (com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.tracer.b localb = ((com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class)).fdr;
      if (localb != null) {
        this.mxe = localb.ffH;
      }
    }
    if (this.AmS != null) {
      this.AmS.onResume();
    }
    if (this.AmZ)
    {
      if ((this.AmS == null) || (!this.AmS.dSE())) {
        break label118;
      }
      dSF();
    }
    for (;;)
    {
      this.AmZ = false;
      AppMethodBeat.o(107377);
      return;
      label118:
      dSG();
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(107380);
    this.lBX.setVisibility(paramInt);
    AppMethodBeat.o(107380);
  }
  
  public static abstract interface a
  {
    public abstract void MH(int paramInt);
    
    public abstract void dRJ();
    
    public abstract void dRK();
    
    public abstract void dRL();
    
    public abstract void dRM();
    
    public abstract void dRN();
    
    public abstract void hl(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c
 * JD-Core Version:    0.7.0.1
 */