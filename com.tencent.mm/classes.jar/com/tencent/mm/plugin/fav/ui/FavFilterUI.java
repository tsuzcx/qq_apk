package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b.b;
import com.tencent.mm.plugin.fav.ui.d.b.c;
import com.tencent.mm.plugin.fav.ui.gallery.c;
import com.tencent.mm.plugin.fav.ui.gallery.c.a;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.a.g.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FavFilterUI
  extends MMActivity
  implements b.c, c.a
{
  private String AgA;
  private Set<Integer> AgB;
  private x AgC;
  private View AgD;
  private Animation AgE;
  private Animation AgF;
  private List<Integer> AgG;
  private List<String> AgH;
  private List<String> AgI;
  private Set<String> AgJ;
  private List<Long> AgK;
  com.tencent.mm.plugin.fav.ui.f.a AgL;
  private c AgM;
  private int[] AgN;
  private com.tencent.mm.plugin.fav.a.g AgO;
  private com.tencent.mm.plugin.fav.a.g AgP;
  private com.tencent.mm.plugin.fav.ui.widget.b AgQ;
  private AdapterView.OnItemLongClickListener AgR;
  private FavoriteImageServer Aga;
  private com.tencent.mm.plugin.fav.ui.adapter.b Agb;
  private int Agz;
  private String hxm;
  private long owx;
  private int pfo;
  private String query;
  private ListView vCW;
  
  public FavFilterUI()
  {
    AppMethodBeat.i(106713);
    this.Agz = -1;
    this.AgG = new LinkedList();
    this.AgH = new LinkedList();
    this.AgI = new LinkedList();
    this.AgJ = new HashSet();
    this.AgK = new ArrayList();
    this.query = "";
    this.AgN = new int[2];
    this.AgR = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106691);
        if (FavFilterUI.a(FavFilterUI.this) == 2)
        {
          Log.w("MicroMsg.FavFilterUI", "on edit mode long click, ignore");
          AppMethodBeat.o(106691);
          return true;
        }
        if (paramAnonymousInt < FavFilterUI.b(FavFilterUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.FavFilterUI", "on header view long click, ignore");
          AppMethodBeat.o(106691);
          return true;
        }
        FavFilterUI.a(FavFilterUI.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLong, FavFilterUI.c(FavFilterUI.this));
        AppMethodBeat.o(106691);
        return true;
      }
    };
    AppMethodBeat.o(106713);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    AppMethodBeat.i(274413);
    int i;
    switch (this.pfo)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      String str1 = this.query;
      String str2 = this.AgL.mpa;
      int j = this.AgL.AoZ;
      if (!paramBoolean) {
        j = (int)(this.AgL.Apg - this.AgL.Apf);
      }
      this.AgL.actionType = paramInt1;
      this.AgL.scene = i;
      this.AgL.AcJ = paramInt4;
      this.AgL.idY = paramInt3;
      this.AgL.AoY = ((int)(System.currentTimeMillis() - this.owx) / 1000);
      this.AgL.query = str1;
      this.AgL.mpa = str2;
      this.AgL.AoZ = j;
      this.AgL.Apb = String.format("%d", new Object[] { Integer.valueOf(paramInt2) });
      this.AgL.Apd = paramInt5;
      this.AgL.report();
      AppMethodBeat.o(274413);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private boolean dRG()
  {
    return this.Agz == 21;
  }
  
  private boolean dRH()
  {
    AppMethodBeat.i(106719);
    if (this.Agb.Ake)
    {
      dRI();
      AppMethodBeat.o(106719);
      return true;
    }
    if ((dRG()) && (this.AgM.dSE()))
    {
      this.AgM.dSG();
      AppMethodBeat.o(106719);
      return true;
    }
    AppMethodBeat.o(106719);
    return false;
  }
  
  private void dRI()
  {
    AppMethodBeat.i(106720);
    this.Agb.a(false, null);
    this.vCW.setOnItemLongClickListener(this.AgR);
    this.AgQ.hide();
    if (dRG()) {
      this.AgM.dSG();
    }
    AppMethodBeat.o(106720);
  }
  
  private void hk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(274414);
    if (this.Agb != null) {}
    for (int j = this.Agb.AcJ;; j = 0)
    {
      int i;
      if (this.AgG != null) {
        if (this.AgG.size() > 0) {
          switch (((Integer)this.AgG.get(0)).intValue())
          {
          case 4: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 19: 
          case 20: 
          default: 
            i = 0;
          }
        }
      }
      for (;;)
      {
        b(paramInt1, paramInt2, i, j, this.Agb.getCount() - 1, false);
        AppMethodBeat.o(274414);
        return;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 4;
        continue;
        i = 5;
        continue;
        i = 6;
        continue;
        i = 7;
        continue;
        i = 8;
        continue;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  public final void MH(int paramInt)
  {
    AppMethodBeat.i(274442);
    b(3, 0, 1, 2, paramInt, true);
    AppMethodBeat.o(274442);
  }
  
  public final void dRJ()
  {
    AppMethodBeat.i(274444);
    b(2, 0, 1, 2, this.AgL.Apd, true);
    AppMethodBeat.o(274444);
  }
  
  public final void dRK()
  {
    AppMethodBeat.i(274446);
    b(6, 0, 1, 2, this.AgL.Apd, true);
    AppMethodBeat.o(274446);
  }
  
  public final void dRL()
  {
    AppMethodBeat.i(274447);
    b(5, 0, 1, 2, this.AgL.Apd, true);
    AppMethodBeat.o(274447);
  }
  
  public final void dRM()
  {
    AppMethodBeat.i(274448);
    b(8, 0, 1, 2, this.AgL.Apd, true);
    AppMethodBeat.o(274448);
  }
  
  public final void dRN()
  {
    AppMethodBeat.i(274449);
    b(4, 0, 1, 2, this.AgL.Apd, true);
    AppMethodBeat.o(274449);
  }
  
  public int getLayoutId()
  {
    return q.f.fav_filter_ui;
  }
  
  public final void hl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(274441);
    this.AgL.AoZ = paramInt1;
    this.AgL.Apd = paramInt2;
    b(9, 0, 1, 2, paramInt2, true);
    AppMethodBeat.o(274441);
  }
  
  public final void mO(long paramLong)
  {
    AppMethodBeat.i(106724);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.Agb.Ake)
    {
      localb = this.AgQ;
      if (this.Agb.dSm() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.hH(bool);
      AppMethodBeat.o(106724);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(106725);
    Log.i("MicroMsg.FavFilterUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(106725);
      return;
    }
    String str1 = paramIntent.getStringExtra("custom_send_text");
    String str2 = paramIntent.getStringExtra("Select_Conv_User");
    switch (paramInt1)
    {
    default: 
    case 1: 
    case 4106: 
    case 4105: 
      for (;;)
      {
        dRH();
        AppMethodBeat.o(106725);
        return;
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(106725);
          return;
        }
        Object localObject1 = this.AgM.Anh;
        if (Util.isNullOrNil(str2))
        {
          AppMethodBeat.o(106725);
          return;
        }
        paramIntent = Util.stringsToList(str2.split(","));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (com.tencent.mm.plugin.fav.ui.gallery.d)((Iterator)localObject1).next();
          if (localObject2 == null)
          {
            Log.d("MicroMsg.FavFilterUI", "select %s, send item null, continute", new Object[] { str2 });
          }
          else
          {
            new com.tencent.mm.plugin.fav.a.k();
            if (com.tencent.mm.plugin.fav.a.k.v(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).xvD))
            {
              com.tencent.mm.ui.base.k.cZ(getContext(), getString(q.i.Fav_NotDownload_CannotForward));
              AppMethodBeat.o(106725);
              return;
            }
            Log.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
            Object localObject3;
            Object localObject4;
            if ((((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).dSH()) || (((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).dSJ()))
            {
              localObject3 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106696);
                  this.Afz.dismiss();
                  AppMethodBeat.o(106696);
                }
              };
              localObject4 = paramIntent.iterator();
              while (((Iterator)localObject4).hasNext()) {
                l.a(this, (String)((Iterator)localObject4).next(), ((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).hIT, (Runnable)localObject3);
              }
            }
            else
            {
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).add(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).hIT));
              localObject2 = paramIntent.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (String)((Iterator)localObject2).next();
                r.bJY().a(com.tencent.mm.model.z.bAM(), (String)localObject4, (ArrayList)localObject3, q.d.chat_img_template);
              }
            }
          }
        }
        if (!Util.isNullOrNil(str1))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            str2 = (String)paramIntent.next();
            com.tencent.mm.plugin.messenger.a.g.gaI().ap(str2, str1, com.tencent.mm.model.ab.IX(str2));
          }
          Log.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          paramIntent = new ArrayList();
          paramIntent.add(this.AgP);
          o.a(getContext(), paramIntent, str1, str2, "MicroMsg.FavFilterUI");
          continue;
          Log.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          o.a(getContext(), this.Agb.ps(false), str1, str2, "MicroMsg.FavFilterUI");
        }
      }
    }
    long l = paramIntent.getLongExtra("key_fav_result_local_id", -1L);
    paramIntent = paramIntent.getStringExtra("key_fav_result_fake_local_id");
    if (-1L == l)
    {
      AppMethodBeat.o(106725);
      return;
    }
    paramInt1 = this.Agb.A(l, paramIntent);
    if (-1 == paramInt1)
    {
      AppMethodBeat.o(106725);
      return;
    }
    this.vCW.setSelection(paramInt1);
    AppMethodBeat.o(106725);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106714);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(q.e.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.Agz = getIntent().getIntExtra("key_preset_search_type", -1);
    setMMTitle(FavSearchActionView.al(getContext(), this.Agz));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(106697);
        if (FavFilterUI.d(FavFilterUI.this))
        {
          AppMethodBeat.o(106697);
          return true;
        }
        FavFilterUI.this.finish();
        AppMethodBeat.o(106697);
        return true;
      }
    });
    setActionbarColor(getContext().getResources().getColor(q.b.normal_actionbar_color));
    this.pfo = getIntent().getIntExtra("key_search_type", 0);
    this.AgD = findViewById(q.e.search_empty_tv);
    if (1 == this.pfo)
    {
      this.hxm = getIntent().getStringExtra("key_to_user");
      this.AgA = getIntent().getStringExtra("key_fav_item_id");
    }
    this.AgE = AnimationUtils.loadAnimation(getContext(), q.a.panel_fade_in);
    this.AgF = AnimationUtils.loadAnimation(getContext(), q.a.panel_fade_out);
    this.vCW = ((ListView)findViewById(q.e.search_result_list));
    this.Aga = new FavoriteImageServer(getContext(), 16);
    getContext();
    this.Agb = new com.tencent.mm.plugin.fav.ui.adapter.b(this.Aga, false);
    this.Agb.Akl = this;
    this.Agb.scene = 2;
    this.Agb.Ako = this.vCW;
    if (1 == this.pfo)
    {
      this.AgB = new HashSet();
      this.AgC = new com.tencent.mm.plugin.fav.a.k();
      if (!Util.isNullOrNil(this.AgA))
      {
        paramBundle = this.AgA.split(",");
        int j = paramBundle.length;
        int i = 0;
        while (i < j)
        {
          int k = Util.getInt(paramBundle[i], 2147483647);
          if (2147483647 != k) {
            this.AgB.add(Integer.valueOf(k));
          }
          i += 1;
        }
      }
      this.Agb.r(this.AgB);
      this.Agb.a(this.AgC);
    }
    this.vCW.setAdapter(this.Agb);
    this.vCW.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106703);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = (b.b)paramAnonymousView.getTag();
        if ((localObject != null) && (((b.b)localObject).AdF != null)) {
          FavFilterUI.a(FavFilterUI.this, 2, paramAnonymousInt);
        }
        if (1 == FavFilterUI.a(FavFilterUI.this))
        {
          if (localObject == null)
          {
            Log.w("MicroMsg.FavFilterUI", "on item click, holder is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106703);
            return;
          }
          if (((b.b)localObject).AdF == null)
          {
            Log.w("MicroMsg.FavFilterUI", "on item click, info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106703);
            return;
          }
          ((ad)com.tencent.mm.kernel.h.ax(ad.class)).a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), ((b.b)localObject).AdF, q.i.app_send, false, new y.a()
          {
            public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106701);
              FavFilterUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final w localw = com.tencent.mm.ui.base.k.a(FavFilterUI.this.getContext(), FavFilterUI.this.getString(q.i.favorite_forward_tips), false, null);
                l.a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), paramAnonymous2String, this.AgV.AdF, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106700);
                    if (localw != null) {
                      localw.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.u(FavFilterUI.this, FavFilterUI.this.getString(q.i.fav_finish_sent));
                    MMHandlerThread.postToMainThreadDelayed(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(106699);
                        FavFilterUI.this.finish();
                        AppMethodBeat.o(106699);
                      }
                    }, 1800L);
                    AppMethodBeat.o(106700);
                  }
                });
              }
              AppMethodBeat.o(106701);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(106703);
          return;
          if (2 == FavFilterUI.a(FavFilterUI.this))
          {
            if (localObject == null)
            {
              Log.w("MicroMsg.FavFilterUI", "on item click, holder is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106703);
              return;
            }
            if (((b.b)localObject).AdF == null)
            {
              Log.w("MicroMsg.FavFilterUI", "on item click, info is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106703);
              return;
            }
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("key_fav_result_local_id", ((b.b)localObject).AdF.field_localId);
            FavFilterUI.this.setResult(-1, paramAnonymousAdapterView);
            FavFilterUI.this.finish();
          }
          else
          {
            FavFilterUI.f(FavFilterUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (((b.b)localObject).AdF != null) {
              com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106702);
                  Log.d("MicroMsg.FavFilterUI", "type %s", new Object[] { Integer.valueOf(this.AgV.AdF.field_type) });
                  long l = this.AgV.AdF.field_localId;
                  if (FavFilterUI.g(FavFilterUI.this).size() == 0) {
                    FavFilterUI.a(FavFilterUI.this, ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQP());
                  }
                  if (FavFilterUI.g(FavFilterUI.this).size() != 0)
                  {
                    localObject = FavFilterUI.g(FavFilterUI.this).iterator();
                    j = 1;
                    for (;;)
                    {
                      i = j;
                      if (!((Iterator)localObject).hasNext()) {
                        break;
                      }
                      i = j;
                      if (((Long)((Iterator)localObject).next()).longValue() == l) {
                        break;
                      }
                      j += 1;
                    }
                  }
                  int i = 1;
                  Object localObject = com.tencent.mm.plugin.report.service.h.OAn;
                  int j = this.AgV.AdF.field_type;
                  int k = FavFilterUI.h(FavFilterUI.this);
                  if (FavFilterUI.g(FavFilterUI.this).size() == 0) {
                    i = paramAnonymousInt;
                  }
                  ((com.tencent.mm.plugin.report.service.h)localObject).b(12746, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
                  AppMethodBeat.o(106702);
                }
              });
            }
          }
        }
      }
    });
    this.vCW.setOnItemLongClickListener(this.AgR);
    this.vCW.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106704);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(106704);
          return false;
          FavFilterUI.this.hideVKB();
          FavFilterUI.c(FavFilterUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
          FavFilterUI.c(FavFilterUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    this.AgQ = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.AgQ.fj(findViewById(q.e.fav_edit_footer));
    this.AgQ.Apz = new b.a()
    {
      public final void dRB()
      {
        AppMethodBeat.i(106710);
        List localList = FavFilterUI.f(FavFilterUI.this).ps(true);
        if ((localList == null) || (localList.size() == 0))
        {
          Log.e("MicroMsg.FavFilterUI", "FavEditFooter onDelRequest list == null");
          AppMethodBeat.o(106710);
          return;
        }
        final ArrayList localArrayList = new ArrayList();
        HashSet localHashSet = new HashSet();
        Iterator localIterator = localList.iterator();
        final boolean bool = false;
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
          if (localg.Acq)
          {
            localHashSet.add(Long.valueOf(localg.field_localId));
            bool = true;
          }
          else
          {
            localArrayList.add(localg);
          }
        }
        if (localArrayList.size() == 0)
        {
          if (localHashSet.size() >= 2)
          {
            FavFilterUI.j(FavFilterUI.this);
            AppMethodBeat.o(106710);
            return;
          }
          FavFilterUI.a(FavFilterUI.this, null, 0, (com.tencent.mm.plugin.fav.a.g)localList.get(0));
          AppMethodBeat.o(106710);
          return;
        }
        com.tencent.mm.ui.base.k.a(FavFilterUI.this.getContext(), FavFilterUI.this.getString(q.i.favorite_delete_items_confirm), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106708);
            o.a(FavFilterUI.this.getContext(), localArrayList, new o.a()
            {
              public final void dRQ()
              {
                AppMethodBeat.i(106707);
                if (FavFilterUI.f(FavFilterUI.this) != null)
                {
                  Log.v("MicroMsg.FavFilterUI", "do refresh job");
                  FavFilterUI.f(FavFilterUI.this).dSj();
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(106706);
                      FavFilterUI.f(FavFilterUI.this).notifyDataSetChanged();
                      AppMethodBeat.o(106706);
                    }
                  });
                  FavFilterUI.a(FavFilterUI.this, 6, 0);
                }
                AppMethodBeat.o(106707);
              }
            });
            FavFilterUI.d(FavFilterUI.this);
            if (bool) {
              FavFilterUI.j(FavFilterUI.this);
            }
            AppMethodBeat.o(106708);
          }
        }, null);
        AppMethodBeat.o(106710);
      }
      
      public final void dRO()
      {
        AppMethodBeat.i(106709);
        if (!FavoriteIndexUI.a(FavFilterUI.f(FavFilterUI.this).ps(false), FavFilterUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106705);
            o.b(FavFilterUI.this.getContext(), 4105, FavFilterUI.f(FavFilterUI.this), FavFilterUI.i(FavFilterUI.this));
            FavFilterUI.a(FavFilterUI.this, 3, 0);
            AppMethodBeat.o(106705);
          }
        }))
        {
          AppMethodBeat.o(106709);
          return;
        }
        o.b(FavFilterUI.this.getContext(), 4105, FavFilterUI.f(FavFilterUI.this), FavFilterUI.i(FavFilterUI.this));
        FavFilterUI.a(FavFilterUI.this, 3, 0);
        AppMethodBeat.o(106709);
      }
      
      public final void dRP() {}
    };
    this.AgM = new c(this, findViewById(q.e.fav_media_history_gallery), this.Aga);
    this.AgM.Anb = this;
    com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106698);
        FavFilterUI.a(FavFilterUI.this, ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQP());
        AppMethodBeat.o(106698);
      }
    }, 1000L);
    this.AgL = new com.tencent.mm.plugin.fav.ui.f.a();
    this.owx = System.currentTimeMillis();
    this.AgL.mpa = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
    this.AgL.Apf = this.owx;
    if (dRG())
    {
      this.vCW.setVisibility(8);
      this.AgM.setVisibility(0);
      this.AgL.mpa = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
      this.AgM.dSD();
      AppMethodBeat.o(106714);
      return;
    }
    if (this.Agz > 0)
    {
      this.AgG.clear();
      this.AgG.add(Integer.valueOf(this.Agz));
      this.Agb.c(this.AgG, this.AgH, this.AgI);
      this.Agb.notifyDataSetChanged();
      if (8 != this.AgM.lBX.getVisibility()) {
        this.AgM.setVisibility(8);
      }
      if (!this.Agb.isEmpty()) {
        break label845;
      }
      if (this.AgD.getVisibility() != 0)
      {
        this.AgD.setVisibility(0);
        this.AgD.startAnimation(this.AgE);
      }
      if (8 != this.vCW.getVisibility())
      {
        this.vCW.setVisibility(8);
        this.vCW.startAnimation(this.AgF);
      }
    }
    for (;;)
    {
      this.AgL.Apg = System.currentTimeMillis();
      hk(9, 0);
      hideVKB();
      this.AgM.setVisibility(8);
      this.vCW.setVisibility(0);
      AppMethodBeat.o(106714);
      return;
      label845:
      if (8 != this.AgD.getVisibility())
      {
        this.AgD.setVisibility(8);
        this.AgD.startAnimation(this.AgF);
      }
      if (this.vCW.getVisibility() != 0)
      {
        this.vCW.setVisibility(0);
        this.vCW.startAnimation(this.AgE);
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106717);
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, q.i.top_item_desc_search);
    localMenuItem.setIcon(bb.m(getContext(), q.h.actionbar_icon_dark_search, getContext().getResources().getColor(q.b.FG_0)));
    localMenuItem.setShowAsAction(2);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(106717);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106716);
    com.tencent.mm.plugin.fav.ui.f.a locala = this.AgL;
    if ((this.AgL.actionType != 1) && (this.AgL.actionType != 9)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.Aph = bool;
      if (!this.AgL.Aph) {
        hk(1, 0);
      }
      this.AgM.onDestroy();
      super.onDestroy();
      this.Aga.destory();
      this.Aga = null;
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavTagSetMgr().q(this.AgJ);
      AppMethodBeat.o(106716);
      return;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106715);
    if ((4 == paramInt) && (this.Agb.Ake))
    {
      dRI();
      AppMethodBeat.o(106715);
      return true;
    }
    if ((4 == paramInt) && (dRG()) && (this.AgM.dSE()))
    {
      this.AgM.dSG();
      AppMethodBeat.o(106715);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(106715);
    return bool;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(106718);
    if (paramMenuItem.getItemId() == 10)
    {
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_enter_fav_search_from", 0);
      paramMenuItem.putExtra("key_preset_search_type", this.Agz);
      o.a(getContext(), this.Agb.Ake, paramMenuItem);
      AppMethodBeat.o(106718);
      return true;
    }
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(106718);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(106723);
    i.aub(getClass().getSimpleName());
    if (dRG()) {
      this.AgM.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106722);
    this.Agb.dSj();
    this.Agb.notifyDataSetChanged();
    i.aua(getClass().getSimpleName());
    if (dRG()) {
      this.AgM.onResume();
    }
    super.onResume();
    AppMethodBeat.o(106722);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavFilterUI
 * JD-Core Version:    0.7.0.1
 */