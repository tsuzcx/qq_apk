package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.tencent.mm.ay.q;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e.b.b;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.gallery.c;
import com.tencent.mm.plugin.fav.ui.gallery.c.a;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.f.c;
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
  private String fsX;
  private long lER;
  private int mlC;
  private String query;
  private ListView sxp;
  private o wJE;
  private com.tencent.mm.plugin.fav.ui.a.b wJF;
  private int wKc;
  private String wKd;
  private Set<Integer> wKe;
  private x wKf;
  private View wKg;
  private Animation wKh;
  private Animation wKi;
  private List<Integer> wKj;
  private List<String> wKk;
  private List<String> wKl;
  private Set<String> wKm;
  private List<Long> wKn;
  com.tencent.mm.plugin.fav.ui.g.a wKo;
  private c wKp;
  private int[] wKq;
  private com.tencent.mm.plugin.fav.a.g wKr;
  private com.tencent.mm.plugin.fav.a.g wKs;
  private com.tencent.mm.plugin.fav.ui.widget.b wKt;
  private AdapterView.OnItemLongClickListener wKu;
  
  public FavFilterUI()
  {
    AppMethodBeat.i(106713);
    this.wKc = -1;
    this.wKj = new LinkedList();
    this.wKk = new LinkedList();
    this.wKl = new LinkedList();
    this.wKm = new HashSet();
    this.wKn = new ArrayList();
    this.query = "";
    this.wKq = new int[2];
    this.wKu = new AdapterView.OnItemLongClickListener()
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
    AppMethodBeat.i(229634);
    int i;
    switch (this.mlC)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      String str1 = this.query;
      String str2 = this.wKo.jQi;
      int j = this.wKo.wSw;
      if (!paramBoolean) {
        j = (int)(this.wKo.wSD - this.wKo.wSC);
      }
      this.wKo.actionType = paramInt1;
      this.wKo.scene = i;
      this.wKo.wGA = paramInt4;
      this.wKo.fXY = paramInt3;
      this.wKo.wSv = ((int)(System.currentTimeMillis() - this.lER) / 1000);
      this.wKo.query = str1;
      this.wKo.jQi = str2;
      this.wKo.wSw = j;
      this.wKo.wSy = String.format("%d", new Object[] { Integer.valueOf(paramInt2) });
      this.wKo.wSA = paramInt5;
      this.wKo.report();
      AppMethodBeat.o(229634);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private boolean dkQ()
  {
    return this.wKc == 21;
  }
  
  private boolean dkR()
  {
    AppMethodBeat.i(106719);
    if (this.wJF.wNB)
    {
      dkS();
      AppMethodBeat.o(106719);
      return true;
    }
    if ((dkQ()) && (this.wKp.dlO()))
    {
      this.wKp.dlQ();
      AppMethodBeat.o(106719);
      return true;
    }
    AppMethodBeat.o(106719);
    return false;
  }
  
  private void dkS()
  {
    AppMethodBeat.i(106720);
    this.wJF.a(false, null);
    this.sxp.setOnItemLongClickListener(this.wKu);
    this.wKt.hide();
    if (dkQ()) {
      this.wKp.dlQ();
    }
    AppMethodBeat.o(106720);
  }
  
  private void gr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229638);
    if (this.wJF != null) {}
    for (int j = this.wJF.wGA;; j = 0)
    {
      int i;
      if (this.wKj != null) {
        if (this.wKj.size() > 0) {
          switch (((Integer)this.wKj.get(0)).intValue())
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
        b(paramInt1, paramInt2, i, j, this.wJF.getCount() - 1, false);
        AppMethodBeat.o(229638);
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
  
  public final void Kq(long paramLong)
  {
    AppMethodBeat.i(106724);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.wJF.wNB)
    {
      localb = this.wKt;
      if (this.wJF.dlw() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.gR(bool);
      AppMethodBeat.o(106724);
      return;
    }
  }
  
  public final void LK(int paramInt)
  {
    AppMethodBeat.i(229648);
    b(3, 0, 1, 2, paramInt, true);
    AppMethodBeat.o(229648);
  }
  
  public final void dkT()
  {
    AppMethodBeat.i(229651);
    b(2, 0, 1, 2, this.wKo.wSA, true);
    AppMethodBeat.o(229651);
  }
  
  public final void dkU()
  {
    AppMethodBeat.i(229653);
    b(6, 0, 1, 2, this.wKo.wSA, true);
    AppMethodBeat.o(229653);
  }
  
  public final void dkV()
  {
    AppMethodBeat.i(229654);
    b(5, 0, 1, 2, this.wKo.wSA, true);
    AppMethodBeat.o(229654);
  }
  
  public final void dkW()
  {
    AppMethodBeat.i(229656);
    b(8, 0, 1, 2, this.wKo.wSA, true);
    AppMethodBeat.o(229656);
  }
  
  public final void dkX()
  {
    AppMethodBeat.i(229658);
    b(4, 0, 1, 2, this.wKo.wSA, true);
    AppMethodBeat.o(229658);
  }
  
  public int getLayoutId()
  {
    return s.f.fav_filter_ui;
  }
  
  public final void gs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229645);
    this.wKo.wSw = paramInt1;
    this.wKo.wSA = paramInt2;
    b(9, 0, 1, 2, paramInt2, true);
    AppMethodBeat.o(229645);
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
        dkR();
        AppMethodBeat.o(106725);
        return;
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(106725);
          return;
        }
        Object localObject1 = this.wKp.wQE;
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
            if (com.tencent.mm.plugin.fav.a.k.v(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).upg))
            {
              com.tencent.mm.ui.base.h.cO(getContext(), getString(s.i.Fav_NotDownload_CannotForward));
              AppMethodBeat.o(106725);
              return;
            }
            Log.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
            Object localObject3;
            Object localObject4;
            if ((((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).dlR()) || (((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).dlT()))
            {
              localObject3 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106696);
                  this.wJe.dismiss();
                  AppMethodBeat.o(106696);
                }
              };
              localObject4 = paramIntent.iterator();
              while (((Iterator)localObject4).hasNext()) {
                l.a(this, (String)((Iterator)localObject4).next(), ((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).fEd, (Runnable)localObject3);
              }
            }
            else
            {
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).add(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.gallery.d)localObject2).fEd));
              localObject2 = paramIntent.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (String)((Iterator)localObject2).next();
                q.bmf().a(com.tencent.mm.model.z.bcZ(), (String)localObject4, (ArrayList)localObject3, s.d.chat_img_template);
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
            com.tencent.mm.plugin.messenger.a.g.eRW().ai(str2, str1, ab.QZ(str2));
          }
          Log.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          paramIntent = new ArrayList();
          paramIntent.add(this.wKs);
          p.a(getContext(), paramIntent, str1, str2, "MicroMsg.FavFilterUI");
          continue;
          Log.d("MicroMsg.FavFilterUI", "select %s for sending", new Object[] { str2 });
          p.a(getContext(), this.wJF.nS(false), str1, str2, "MicroMsg.FavFilterUI");
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
    paramInt1 = this.wJF.r(l, paramIntent);
    if (-1 == paramInt1)
    {
      AppMethodBeat.o(106725);
      return;
    }
    this.sxp.setSelection(paramInt1);
    AppMethodBeat.o(106725);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106714);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(s.e.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    this.wKc = getIntent().getIntExtra("key_preset_search_type", -1);
    setMMTitle(FavSearchActionView.ad(getContext(), this.wKc));
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
    setActionbarColor(getContext().getResources().getColor(s.b.normal_actionbar_color));
    this.mlC = getIntent().getIntExtra("key_search_type", 0);
    this.wKg = findViewById(s.e.search_empty_tv);
    if (1 == this.mlC)
    {
      this.fsX = getIntent().getStringExtra("key_to_user");
      this.wKd = getIntent().getStringExtra("key_fav_item_id");
    }
    this.wKh = AnimationUtils.loadAnimation(getContext(), s.a.panel_fade_in);
    this.wKi = AnimationUtils.loadAnimation(getContext(), s.a.panel_fade_out);
    this.sxp = ((ListView)findViewById(s.e.search_result_list));
    this.wJE = new o(getContext(), 16);
    getContext();
    this.wJF = new com.tencent.mm.plugin.fav.ui.a.b(this.wJE, false);
    this.wJF.wNI = this;
    this.wJF.scene = 2;
    this.wJF.wNL = this.sxp;
    if (1 == this.mlC)
    {
      this.wKe = new HashSet();
      this.wKf = new com.tencent.mm.plugin.fav.a.k();
      if (!Util.isNullOrNil(this.wKd))
      {
        paramBundle = this.wKd.split(",");
        int j = paramBundle.length;
        int i = 0;
        while (i < j)
        {
          int k = Util.getInt(paramBundle[i], 2147483647);
          if (2147483647 != k) {
            this.wKe.add(Integer.valueOf(k));
          }
          i += 1;
        }
      }
      this.wJF.k(this.wKe);
      this.wJF.a(this.wKf);
    }
    this.sxp.setAdapter(this.wJF);
    this.sxp.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106703);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = (b.b)paramAnonymousView.getTag();
        if ((localObject != null) && (((b.b)localObject).wHw != null)) {
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
          if (((b.b)localObject).wHw == null)
          {
            Log.w("MicroMsg.FavFilterUI", "on item click, info is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(106703);
            return;
          }
          ((ac)com.tencent.mm.kernel.h.ae(ac.class)).a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), ((b.b)localObject).wHw, s.i.app_send, false, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(106701);
              FavFilterUI.this.hideVKB();
              if (paramAnonymous2Boolean)
              {
                final s locals = com.tencent.mm.ui.base.h.a(FavFilterUI.this.getContext(), FavFilterUI.this.getString(s.i.favorite_forward_tips), false, null);
                l.a(FavFilterUI.this.getContext(), FavFilterUI.e(FavFilterUI.this), paramAnonymous2String, this.wKy.wHw, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(106700);
                    if (locals != null) {
                      locals.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.r(FavFilterUI.this, FavFilterUI.this.getString(s.i.fav_finish_sent));
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
            if (((b.b)localObject).wHw == null)
            {
              Log.w("MicroMsg.FavFilterUI", "on item click, info is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(106703);
              return;
            }
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("key_fav_result_local_id", ((b.b)localObject).wHw.field_localId);
            FavFilterUI.this.setResult(-1, paramAnonymousAdapterView);
            FavFilterUI.this.finish();
          }
          else
          {
            FavFilterUI.f(FavFilterUI.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if (((b.b)localObject).wHw != null) {
              com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106702);
                  Log.d("MicroMsg.FavFilterUI", "type %s", new Object[] { Integer.valueOf(this.wKy.wHw.field_type) });
                  long l = this.wKy.wHw.field_localId;
                  if (FavFilterUI.g(FavFilterUI.this).size() == 0) {
                    FavFilterUI.a(FavFilterUI.this, ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().dkf());
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
                  Object localObject = com.tencent.mm.plugin.report.service.h.IzE;
                  int j = this.wKy.wHw.field_type;
                  int k = FavFilterUI.h(FavFilterUI.this);
                  if (FavFilterUI.g(FavFilterUI.this).size() == 0) {
                    i = paramAnonymousInt;
                  }
                  ((com.tencent.mm.plugin.report.service.h)localObject).a(12746, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
                  AppMethodBeat.o(106702);
                }
              });
            }
          }
        }
      }
    });
    this.sxp.setOnItemLongClickListener(this.wKu);
    this.sxp.setOnTouchListener(new View.OnTouchListener()
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
    this.wKt = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.wKt.eo(findViewById(s.e.fav_edit_footer));
    this.wKt.wSW = new b.a()
    {
      public final void dkL()
      {
        AppMethodBeat.i(106710);
        List localList = FavFilterUI.f(FavFilterUI.this).nS(true);
        if (localList.size() == 0)
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
          if (localg.wGh)
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
        com.tencent.mm.ui.base.h.a(FavFilterUI.this.getContext(), FavFilterUI.this.getString(s.i.favorite_delete_items_confirm), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106708);
            p.a(FavFilterUI.this.getContext(), localArrayList, new p.a()
            {
              public final void dla()
              {
                AppMethodBeat.i(106707);
                if (FavFilterUI.f(FavFilterUI.this) != null)
                {
                  Log.v("MicroMsg.FavFilterUI", "do refresh job");
                  FavFilterUI.f(FavFilterUI.this).dlt();
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
      
      public final void dkY()
      {
        AppMethodBeat.i(106709);
        if (!FavoriteIndexUI.a(FavFilterUI.f(FavFilterUI.this).nS(false), FavFilterUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106705);
            p.b(FavFilterUI.this.getContext(), 4105, FavFilterUI.f(FavFilterUI.this), FavFilterUI.i(FavFilterUI.this));
            FavFilterUI.a(FavFilterUI.this, 3, 0);
            AppMethodBeat.o(106705);
          }
        }))
        {
          AppMethodBeat.o(106709);
          return;
        }
        p.b(FavFilterUI.this.getContext(), 4105, FavFilterUI.f(FavFilterUI.this), FavFilterUI.i(FavFilterUI.this));
        FavFilterUI.a(FavFilterUI.this, 3, 0);
        AppMethodBeat.o(106709);
      }
      
      public final void dkZ() {}
    };
    this.wKp = new c(this, findViewById(s.e.fav_media_history_gallery), this.wJE);
    this.wKp.wQz = this;
    com.tencent.mm.kernel.h.aHJ().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106698);
        FavFilterUI.a(FavFilterUI.this, ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().dkf());
        AppMethodBeat.o(106698);
      }
    }, 1000L);
    this.wKo = new com.tencent.mm.plugin.fav.ui.g.a();
    this.lER = System.currentTimeMillis();
    this.wKo.jQi = com.tencent.mm.plugin.fav.ui.g.a.getSearchId();
    this.wKo.wSC = this.lER;
    if (dkQ())
    {
      this.sxp.setVisibility(8);
      this.wKp.setVisibility(0);
      this.wKo.jQi = com.tencent.mm.plugin.fav.ui.g.a.getSearchId();
      this.wKp.dlN();
      AppMethodBeat.o(106714);
      return;
    }
    if (this.wKc > 0)
    {
      this.wKj.clear();
      this.wKj.add(Integer.valueOf(this.wKc));
      this.wJF.c(this.wKj, this.wKk, this.wKl);
      this.wJF.notifyDataSetChanged();
      if (8 != this.wKp.jac.getVisibility()) {
        this.wKp.setVisibility(8);
      }
      if (!this.wJF.isEmpty()) {
        break label845;
      }
      if (this.wKg.getVisibility() != 0)
      {
        this.wKg.setVisibility(0);
        this.wKg.startAnimation(this.wKh);
      }
      if (8 != this.sxp.getVisibility())
      {
        this.sxp.setVisibility(8);
        this.sxp.startAnimation(this.wKi);
      }
    }
    for (;;)
    {
      this.wKo.wSD = System.currentTimeMillis();
      gr(9, 0);
      hideVKB();
      this.wKp.setVisibility(8);
      this.sxp.setVisibility(0);
      AppMethodBeat.o(106714);
      return;
      label845:
      if (8 != this.wKg.getVisibility())
      {
        this.wKg.setVisibility(8);
        this.wKg.startAnimation(this.wKi);
      }
      if (this.sxp.getVisibility() != 0)
      {
        this.sxp.setVisibility(0);
        this.sxp.startAnimation(this.wKh);
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(106717);
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, s.i.top_item_desc_search);
    localMenuItem.setIcon(au.o(getContext(), s.h.actionbar_icon_dark_search, getContext().getResources().getColor(s.b.FG_0)));
    localMenuItem.setShowAsAction(2);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(106717);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106716);
    com.tencent.mm.plugin.fav.ui.g.a locala = this.wKo;
    if ((this.wKo.actionType != 1) && (this.wKo.actionType != 9)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.wSE = bool;
      if (!this.wKo.wSE) {
        gr(1, 0);
      }
      this.wKp.onDestroy();
      super.onDestroy();
      this.wJE.destory();
      this.wJE = null;
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavTagSetMgr().j(this.wKm);
      AppMethodBeat.o(106716);
      return;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106715);
    if ((4 == paramInt) && (this.wJF.wNB))
    {
      dkS();
      AppMethodBeat.o(106715);
      return true;
    }
    if ((4 == paramInt) && (dkQ()) && (this.wKp.dlO()))
    {
      this.wKp.dlQ();
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
      paramMenuItem.putExtra("key_preset_search_type", this.wKc);
      p.a(getContext(), this.wJF.wNB, paramMenuItem);
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
    i.azV(getClass().getSimpleName());
    if (dkQ()) {
      this.wKp.onPause();
    }
    super.onPause();
    AppMethodBeat.o(106723);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106722);
    this.wJF.dlt();
    this.wJF.notifyDataSetChanged();
    i.azU(getClass().getSimpleName());
    if (dkQ()) {
      this.wKp.onResume();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavFilterUI
 * JD-Core Version:    0.7.0.1
 */