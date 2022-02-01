package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavImgGalleryUI
  extends MMActivity
  implements AdapterView.OnItemSelectedListener, com.tencent.mm.plugin.fav.a.p, d.a, r.a, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  private boolean dUo;
  private MMGestureGallery jUy;
  private ArrayList<i> kgc;
  private ScanCodeSheetItemLogic mHu;
  private o.g rjz;
  private d teA;
  private Map<String, b> teB;
  private boolean teC;
  private r teD;
  private long teE;
  private IListener teF;
  private int tex;
  private a tey;
  private e tez;
  
  public FavImgGalleryUI()
  {
    AppMethodBeat.i(106757);
    this.tex = 0;
    this.dUo = true;
    this.teB = new HashMap();
    this.rjz = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(106746);
        i locali = FavImgGalleryUI.i(FavImgGalleryUI.this).Ib(FavImgGalleryUI.h(FavImgGalleryUI.this));
        if (locali == null)
        {
          AppMethodBeat.o(106746);
          return;
        }
        String str = com.tencent.mm.plugin.fav.a.b.d(locali.dKT);
        if (!s.YS(str))
        {
          Log.w("MicroMsg.FavImgGalleryUI", "file not exists");
          AppMethodBeat.o(106746);
          return;
        }
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(106746);
          return;
          com.tencent.mm.plugin.fav.a.h.w(FavImgGalleryUI.j(FavImgGalleryUI.this), 1);
          if (ImgUtil.isGif(str))
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
            paramAnonymousMenuItem.putExtra("select_is_ret", true);
            com.tencent.mm.br.c.c(FavImgGalleryUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 1);
            AppMethodBeat.o(106746);
            return;
          }
          com.tencent.mm.plugin.fav.a.b.a(str, FavImgGalleryUI.this, locali.dKT.jsz);
          AppMethodBeat.o(106746);
          return;
          com.tencent.mm.plugin.fav.a.b.b(str, FavImgGalleryUI.this);
          com.tencent.mm.plugin.fav.a.h.w(FavImgGalleryUI.j(FavImgGalleryUI.this), 0);
          AppMethodBeat.o(106746);
          return;
          FavImgGalleryUI.a(str, FavImgGalleryUI.this.getString(2131759318), FavImgGalleryUI.this, locali.dKT.jsz);
          AppMethodBeat.o(106746);
          return;
          if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FavImgGalleryUI.this.getContext()))
          {
            FavImgGalleryUI.a(FavImgGalleryUI.this).cWf();
            AppMethodBeat.o(106746);
            return;
            FavImgGalleryUI.k(FavImgGalleryUI.this);
          }
        }
      }
    };
    this.teF = new IListener() {};
    AppMethodBeat.o(106757);
  }
  
  public static void a(String paramString1, final String paramString2, Context paramContext, final String paramString3)
  {
    AppMethodBeat.i(164093);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.FavImgGalleryUI", "save image fail, path is null");
      AppMethodBeat.o(164093);
      return;
    }
    com.tencent.mm.platformtools.p.a(paramContext, paramString1, new p.a()
    {
      public final void bP(String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(235314);
        Toast.makeText(this.val$context, this.val$context.getString(2131758218, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymousString2) }), 1).show();
        com.tencent.f.h.RTc.aX(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(235313);
            String str = s.bhK(paramAnonymousString2);
            v localv = v.jNy;
            v.bR(str, FavImgGalleryUI.13.this.teL);
            AppMethodBeat.o(235313);
          }
        });
        AppMethodBeat.o(235314);
      }
      
      public final void bQ(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(235315);
        Toast.makeText(this.val$context, paramString2, 1).show();
        AppMethodBeat.o(235315);
      }
    });
    AppMethodBeat.o(164093);
  }
  
  private void and()
  {
    AppMethodBeat.i(106761);
    this.teE = getIntent().getLongExtra("key_detail_info_id", -1L);
    String str = getIntent().getStringExtra("key_detail_data_id");
    boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    Object localObject = getIntent().getStringExtra("fav_note_xml");
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.teE);
    long l = this.teE;
    boolean bool1;
    if (localg != null)
    {
      bool1 = true;
      Log.i("MicroMsg.FavImgGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
      if ((!bool2) || (Util.isNullOrNil((String)localObject))) {
        break label437;
      }
      localg = com.tencent.mm.plugin.fav.a.b.arO((String)localObject);
    }
    label434:
    label437:
    for (;;)
    {
      if (localg != null) {
        localArrayList.add(localg);
      }
      this.kgc.clear();
      final int i = -1;
      int m = localArrayList.size();
      int k = 0;
      label184:
      int j;
      if (k < m)
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localArrayList.get(k);
        int n = localg.field_favProto.ppH.size();
        j = 0;
        label218:
        if (j < n)
        {
          localObject = (aml)localg.field_favProto.ppH.get(j);
          if (((((aml)localObject).dataType == 8) && (!ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d((aml)localObject)))) || ((((aml)localObject).dataType != 2) && (((aml)localObject).dataType != 8))) {
            break label434;
          }
          i locali = new i(localg, (aml)localObject);
          this.kgc.add(locali);
          if ((str == null) || (!str.equals(((aml)localObject).dLl))) {
            break label434;
          }
          i = this.kgc.size() - 1;
        }
      }
      for (;;)
      {
        j += 1;
        break label218;
        bool1 = false;
        break;
        j = i;
        if (str == null)
        {
          j = i;
          if (localg.field_localId == this.teE) {
            j = this.kgc.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label184;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.tey.notifyDataSetChanged();
        this.jUy.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106738);
            if (i != -1)
            {
              Log.d("MicroMsg.FavImgGalleryUI", "match selection %d", new Object[] { Integer.valueOf(i) });
              FavImgGalleryUI.c(FavImgGalleryUI.this).setSelection(i);
              FavImgGalleryUI.a(FavImgGalleryUI.this, i);
              AppMethodBeat.o(106738);
              return;
            }
            if ((FavImgGalleryUI.h(FavImgGalleryUI.this) - 1 >= 0) && (FavImgGalleryUI.h(FavImgGalleryUI.this) - 1 < FavImgGalleryUI.m(FavImgGalleryUI.this).size()))
            {
              Log.d("MicroMsg.FavImgGalleryUI", "adjust selection %d, list size %d", new Object[] { Integer.valueOf(FavImgGalleryUI.h(FavImgGalleryUI.this) - 1), Integer.valueOf(FavImgGalleryUI.m(FavImgGalleryUI.this).size()) });
              FavImgGalleryUI.c(FavImgGalleryUI.this).setSelection(FavImgGalleryUI.h(FavImgGalleryUI.this) - 1);
              FavImgGalleryUI.a(FavImgGalleryUI.this, FavImgGalleryUI.h(FavImgGalleryUI.this) - 1);
              AppMethodBeat.o(106738);
              return;
            }
            if (FavImgGalleryUI.m(FavImgGalleryUI.this).size() > 0)
            {
              Log.d("MicroMsg.FavImgGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[] { Integer.valueOf(FavImgGalleryUI.m(FavImgGalleryUI.this).size()) });
              FavImgGalleryUI.c(FavImgGalleryUI.this).setSelection(0);
              FavImgGalleryUI.a(FavImgGalleryUI.this, 0);
              AppMethodBeat.o(106738);
              return;
            }
            Log.w("MicroMsg.FavImgGalleryUI", "data list size %d, empty, finish", new Object[] { Integer.valueOf(FavImgGalleryUI.m(FavImgGalleryUI.this).size()) });
            FavImgGalleryUI.this.finish();
            AppMethodBeat.o(106738);
          }
        });
        AppMethodBeat.o(106761);
        return;
      }
    }
  }
  
  private void ks(boolean paramBoolean)
  {
    AppMethodBeat.i(106759);
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = this.tey.Ib(this.tex);
    if (localObject1 == null)
    {
      AppMethodBeat.o(106759);
      return;
    }
    if (((i)localObject1).dKT.Lwv != 0)
    {
      AppMethodBeat.o(106759);
      return;
    }
    if ((((i)localObject1).tew != null) && (((i)localObject1).tew.cUu()))
    {
      localArrayList1.add(Integer.valueOf(0));
      localArrayList2.add(getString(2131759326));
    }
    if ((((i)localObject1).tew != null) && (((i)localObject1).tew.cUv()))
    {
      localArrayList1.add(Integer.valueOf(1));
      localArrayList2.add(getString(2131759275));
    }
    localArrayList1.add(Integer.valueOf(2));
    localArrayList2.add(getString(2131764866));
    localObject1 = com.tencent.mm.plugin.fav.a.b.d(((i)localObject1).dKT);
    if ((this.teC) && (!Util.isNullOrNil((String)localObject1)))
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(2131757389));
    }
    localArrayList1.add(Integer.valueOf(5));
    localArrayList2.add(getString(2131757388));
    final b localb = (b)this.teB.get(localObject1);
    Object localObject2;
    if ((localb != null) && (localb.teQ != null))
    {
      localObject2 = localb.teQ;
      if (!Util.isNullOrNil(((qz)localObject2).dXz.result))
      {
        localArrayList1.add(Integer.valueOf(3));
        localArrayList2.add(this.mHu.Wp(((qz)localObject2).dXz.dFL));
      }
    }
    for (;;)
    {
      if (this.tez == null) {
        this.tez = new e(getContext(), 1, false);
      }
      this.tez.HLX = new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(106744);
          FavImgGalleryUI.e(FavImgGalleryUI.this).setFooterView(null);
          paramAnonymousm.clear();
          paramAnonymousm.setHeaderTitle("");
          int i = 0;
          if (i < localArrayList1.size())
          {
            if (((Integer)localArrayList1.get(i)).intValue() == 3) {
              FavImgGalleryUI.e(FavImgGalleryUI.this).setFooterView(FavImgGalleryUI.a(FavImgGalleryUI.this, localb));
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymousm.d(((Integer)localArrayList1.get(i)).intValue(), (CharSequence)localArrayList2.get(i));
            }
          }
          AppMethodBeat.o(106744);
        }
      };
      this.tez.HLY = this.rjz;
      this.tez.PGl = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(106745);
          FavImgGalleryUI.f(FavImgGalleryUI.this);
          FavImgGalleryUI.g(FavImgGalleryUI.this).onDismiss();
          AppMethodBeat.o(106745);
        }
      };
      if (!getContext().isFinishing()) {
        this.tez.dGm();
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        com.tencent.mm.kernel.g.aAi();
        if ((com.tencent.mm.kernel.g.aAg().hqi.aYS() != 0) && (paramBoolean)) {
          this.teD.scan((String)localObject1);
        }
      }
      AppMethodBeat.o(106759);
      return;
      localObject2 = new qx();
      ((qx)localObject2).dXu.dDZ = System.currentTimeMillis();
      ((qx)localObject2).dXu.filePath = ((String)localObject1);
      EventCenter.instance.publish((IEvent)localObject2);
    }
  }
  
  public final MultiTouchImageView cVG()
  {
    AppMethodBeat.i(106767);
    int i = this.jUy.getSelectedItemPosition();
    Object localObject = this.jUy;
    localObject = ((MMGestureGallery)localObject).getChildAt(i - ((MMGestureGallery)localObject).getFirstVisiblePosition());
    if (localObject == null)
    {
      Log.i("MicroMsg.FavImgGalleryUI", "getCurView() pos:%s firstPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jUy.getFirstVisiblePosition()) });
      AppMethodBeat.o(106767);
      return null;
    }
    if ((localObject instanceof MultiTouchImageView))
    {
      localObject = (MultiTouchImageView)localObject;
      AppMethodBeat.o(106767);
      return localObject;
    }
    localObject = (MultiTouchImageView)((View)localObject).findViewById(2131302526);
    AppMethodBeat.o(106767);
    return localObject;
  }
  
  public final String cVH()
  {
    AppMethodBeat.i(106768);
    int i = this.jUy.getSelectedItemPosition();
    String str = this.tey.Ib(i).dKT.dLl;
    AppMethodBeat.o(106768);
    return str;
  }
  
  public final String cVV()
  {
    AppMethodBeat.i(106766);
    Object localObject = this.tey.Ib(this.tex);
    if (localObject == null)
    {
      AppMethodBeat.o(106766);
      return "";
    }
    localObject = com.tencent.mm.plugin.fav.a.b.d(((i)localObject).dKT);
    AppMethodBeat.o(106766);
    return localObject;
  }
  
  public final void e(final com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(106770);
    if (paramc != null)
    {
      Log.v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", new Object[] { Integer.valueOf(paramc.field_status) });
      i locali = this.tey.Ib(this.tex);
      if ((locali != null) && (Util.nullAs(paramc.field_dataId, "").equals(locali.dKT.dLl))) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            int j = 0;
            AppMethodBeat.i(106739);
            Object localObject = FavImgGalleryUI.c(FavImgGalleryUI.this).getSelectedView();
            if (localObject == null)
            {
              AppMethodBeat.o(106739);
              return;
            }
            localObject = (FavImgGalleryUI.c)((View)localObject).getTag();
            int i;
            if (paramc.field_totalLen > 0)
            {
              i = paramc.field_offset * 100 / paramc.field_totalLen - 1;
              if (i >= 0) {
                break label144;
              }
              i = j;
            }
            label144:
            for (;;)
            {
              ((FavImgGalleryUI.c)localObject).progressBar.setProgress(i);
              ((FavImgGalleryUI.c)localObject).teU.setText(i + "%");
              if ((i >= 100) || (paramc.isFinished())) {
                FavImgGalleryUI.i(FavImgGalleryUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(106739);
              return;
              i = 0;
              break;
            }
          }
        });
      }
    }
    AppMethodBeat.o(106770);
  }
  
  public final String getAesKey()
  {
    AppMethodBeat.i(235317);
    Object localObject = this.tey.Ib(this.tex);
    if ((localObject == null) || (((i)localObject).dKT == null))
    {
      AppMethodBeat.o(235317);
      return null;
    }
    localObject = ((i)localObject).dKT.Lvp;
    AppMethodBeat.o(235317);
    return localObject;
  }
  
  public final String getFileId()
  {
    AppMethodBeat.i(235316);
    Object localObject = this.tey.Ib(this.tex);
    if ((localObject == null) || (((i)localObject).dKT == null))
    {
      AppMethodBeat.o(235316);
      return null;
    }
    localObject = ((i)localObject).dKT.KuR;
    AppMethodBeat.o(235316);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return 2131494121;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(106771);
    if (1 == paramInt1)
    {
      if (-1 != paramInt2)
      {
        AppMethodBeat.o(106771);
        return;
      }
      i locali = this.tey.Ib(this.tex);
      if (locali == null)
      {
        Log.i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
        AppMethodBeat.o(106771);
        return;
      }
      new k();
      if (k.v(locali.tew))
      {
        com.tencent.mm.ui.base.h.cD(getContext(), getString(2131755011));
        AppMethodBeat.o(106771);
        return;
      }
      String str = paramIntent.getStringExtra("Select_Conv_User");
      Log.d("MicroMsg.FavImgGalleryUI", "select %s for sending", new Object[] { str });
      final com.tencent.mm.ui.base.q localq = com.tencent.mm.ui.base.h.a(getContext(), getString(2131759230), false, null);
      l.a(getContext(), str, locali.tew, locali.dKT, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164090);
          localq.dismiss();
          com.tencent.mm.ui.widget.snackbar.b.r(FavImgGalleryUI.this, FavImgGalleryUI.this.getString(2131759157));
          AppMethodBeat.o(164090);
        }
      });
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(106771);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106758);
    super.onCreate(paramBundle);
    hideTitleView();
    if (com.tencent.mm.compatible.util.d.oD(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.teD = new r(this, this, this);
      this.dUo = getIntent().getBooleanExtra("show_share", true);
      this.jUy = ((MMGestureGallery)findViewById(2131301853));
      this.teA = new d(this.jUy, this, this);
      this.jUy.setVerticalFadingEdgeEnabled(false);
      this.jUy.setHorizontalFadingEdgeEnabled(false);
      this.jUy.setOnItemSelectedListener(this);
      this.jUy.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void bmt()
        {
          AppMethodBeat.i(106737);
          if (FavImgGalleryUI.a(FavImgGalleryUI.this).tgN != 1) {
            FavImgGalleryUI.b(FavImgGalleryUI.this).mD(true);
          }
          AppMethodBeat.o(106737);
        }
      });
      if (this.dUo) {
        this.jUy.setLongClickOverListener(new MMGestureGallery.c()
        {
          public final void bmu()
          {
            AppMethodBeat.i(106741);
            if (FavImgGalleryUI.a(FavImgGalleryUI.this).tgN == 1)
            {
              AppMethodBeat.o(106741);
              return;
            }
            if ((!FavImgGalleryUI.this.isFinishing()) && (!FavImgGalleryUI.this.activityHasDestroyed()))
            {
              ad.b localb = ad.aVe().G("basescanui@datacenter", true);
              localb.l("key_basescanui_screen_position", Boolean.TRUE);
              localb.l("key_basescanui_screen_x", Float.valueOf(FavImgGalleryUI.c(FavImgGalleryUI.this).getXDown()));
              localb.l("key_basescanui_screen_y", Float.valueOf(FavImgGalleryUI.c(FavImgGalleryUI.this).getYDown()));
              if ((FavImgGalleryUI.a(FavImgGalleryUI.this).tgN == 0) || (FavImgGalleryUI.a(FavImgGalleryUI.this).tgN == 2))
              {
                FavImgGalleryUI.a(FavImgGalleryUI.this, com.tencent.mm.plugin.scanner.i.eOQ());
                AppMethodBeat.o(106741);
                return;
              }
              FavImgGalleryUI.d(FavImgGalleryUI.this);
            }
            AppMethodBeat.o(106741);
          }
        });
      }
      fullScreenNoTitleBar(true);
      this.kgc = new ArrayList();
      this.tey = new a((byte)0);
      this.jUy.setAdapter(this.tey);
      and();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(106742);
          FavImgGalleryUI.b(FavImgGalleryUI.this).mD(true);
          AppMethodBeat.o(106742);
          return true;
        }
      });
      this.mHu = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
      {
        public final void bLz()
        {
          AppMethodBeat.i(106743);
          FavImgGalleryUI.d(FavImgGalleryUI.this);
          AppMethodBeat.o(106743);
        }
      });
      EventCenter.instance.addListener(this.teF);
      setResult(0, getIntent());
      AppMethodBeat.o(106758);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106762);
    getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs());
    EventCenter.instance.removeListener(this.teF);
    if (this.teA != null) {
      this.teA.onDestroy();
    }
    if (this.teD != null) {
      this.teD.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(106762);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(106769);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavImgGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    this.tex = paramInt;
    Log.d("MicroMsg.FavImgGalleryUI", "pos:".concat(String.valueOf(paramInt)));
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).gKy();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavImgGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(106769);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106765);
    if (paramInt == 4)
    {
      this.teA.mD(true);
      AppMethodBeat.o(106765);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(106765);
    return bool;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onPause()
  {
    AppMethodBeat.i(106764);
    super.onPause();
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(this);
    f.e(false, true, true);
    AppMethodBeat.o(106764);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106763);
    super.onResume();
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(this);
    f.e(true, true, true);
    AppMethodBeat.o(106763);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    SparseBooleanArray teP;
    
    private a()
    {
      AppMethodBeat.i(106749);
      this.teP = new SparseBooleanArray();
      AppMethodBeat.o(106749);
    }
    
    private Bitmap a(i parami)
    {
      AppMethodBeat.i(106754);
      if (parami != null)
      {
        parami = o.a(parami.dKT, parami.tew);
        if (parami != null)
        {
          AppMethodBeat.o(106754);
          return parami;
        }
      }
      parami = com.tencent.mm.compatible.f.a.decodeResource(FavImgGalleryUI.this.getResources(), 2131690098);
      AppMethodBeat.o(106754);
      return parami;
    }
    
    private void a(FavImgGalleryUI.c paramc, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(106753);
      paramc.progressBar.setVisibility(8);
      paramc.teU.setVisibility(8);
      paramc.mEx.setVisibility(8);
      paramc.teS.setVisibility(0);
      paramc.teV.setVisibility(8);
      b(paramc, paramBitmap, paramString);
      AppMethodBeat.o(106753);
    }
    
    private void b(FavImgGalleryUI.c paramc, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(106755);
      ForceGpuUtil.decideLayerType(paramc.teT, paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = paramc.teT.getWidth();
      int j = paramc.teT.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.reset();
      float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
      float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
      Log.v("MicroMsg.FavImgGalleryUI", "whDiv is " + f1 + " hwDiv is " + f2);
      if ((f2 >= 2.0F) && (paramBitmap.getHeight() >= 480))
      {
        f1 = paramBitmap.getWidth() / i;
        f2 = i / paramBitmap.getWidth();
        if (f1 > 1.0D)
        {
          localMatrix.postScale(f2, f2);
          paramBitmap.getHeight();
          localMatrix.postTranslate((i - f2 * paramBitmap.getWidth()) / 2.0F, 0.0F);
        }
      }
      for (;;)
      {
        paramc.teT.setImageMatrix(localMatrix);
        paramc.teT.cN(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramc.teT.setMaxZoomDoubleTab(true);
        if (!Util.isNullOrNil(paramString)) {
          break label524;
        }
        paramc.teT.setImageBitmap(paramBitmap);
        AppMethodBeat.o(106755);
        return;
        localMatrix.postScale(1.0F, 1.0F);
        localMatrix.postTranslate((i - paramBitmap.getWidth()) / 2, 0.0F);
        continue;
        if ((f1 < 2.0F) || (paramBitmap.getWidth() < 480)) {
          break;
        }
        f1 = paramBitmap.getHeight() / 480.0F;
        f2 = 480.0F / paramBitmap.getHeight();
        if (f1 > 1.0D)
        {
          localMatrix.postScale(f1, f2);
          localMatrix.postTranslate(0.0F, (j - 480) / 2);
        }
        else
        {
          localMatrix.postScale(1.0F, 1.0F);
          f1 = (j - paramBitmap.getHeight()) / 2;
          Log.d("MicroMsg.FavImgGalleryUI", " offsety ".concat(String.valueOf(f1)));
          localMatrix.postTranslate(0.0F, f1);
        }
      }
      f1 = i / paramBitmap.getWidth();
      f2 = j / paramBitmap.getHeight();
      label425:
      float f3;
      if (f1 < f2)
      {
        f2 = paramBitmap.getWidth() / i;
        f3 = paramBitmap.getHeight() / j;
        if (f2 <= f3) {
          break label517;
        }
        label455:
        if (f2 <= 1.0D) {
          break label627;
        }
        localMatrix.postScale(f1, f1);
      }
      for (;;)
      {
        localMatrix.postTranslate((i - paramBitmap.getWidth() * f1) / 2.0F, (j - f1 * paramBitmap.getHeight()) / 2.0F);
        break;
        f1 = f2;
        break label425;
        label517:
        f2 = f3;
        break label455;
        try
        {
          label524:
          paramString = new com.tencent.mm.plugin.gif.d(paramString);
          paramc.teT.setGifDrawable(paramString);
          paramc.teT.kY(com.tencent.mm.cb.a.jn(FavImgGalleryUI.this.getContext()), com.tencent.mm.cb.a.jo(FavImgGalleryUI.this.getContext()));
          paramc.teT.cN(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          paramc.teT.start();
          paramc.teT.gKz();
          AppMethodBeat.o(106755);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.FavImgGalleryUI", Util.stackTraceToString(paramString));
          paramc.teT.setImageBitmap(paramBitmap);
          AppMethodBeat.o(106755);
          return;
        }
        label627:
        f1 = 1.0F;
      }
    }
    
    public final i Ib(int paramInt)
    {
      AppMethodBeat.i(106751);
      if (paramInt >= FavImgGalleryUI.m(FavImgGalleryUI.this).size())
      {
        Log.w("MicroMsg.FavImgGalleryUI", "get item fail, position %d error", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(106751);
        return null;
      }
      i locali = (i)FavImgGalleryUI.m(FavImgGalleryUI.this).get(paramInt);
      AppMethodBeat.o(106751);
      return locali;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(106750);
      int i = FavImgGalleryUI.m(FavImgGalleryUI.this).size();
      AppMethodBeat.o(106750);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(106752);
      i locali;
      Object localObject;
      if (paramView == null)
      {
        paramViewGroup = new FavImgGalleryUI.c(FavImgGalleryUI.this, (byte)0);
        paramView = View.inflate(FavImgGalleryUI.this.getContext(), 2131494120, null);
        paramViewGroup.teS = paramView.findViewById(2131302563);
        paramViewGroup.teT = ((MultiTouchImageView)paramView.findViewById(2131302526));
        paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(2131299794));
        paramViewGroup.mEx = ((ImageView)paramView.findViewById(2131309073));
        paramViewGroup.teU = ((TextView)paramView.findViewById(2131299795));
        paramViewGroup.teV = ((LinearLayout)paramView.findViewById(2131300461));
        paramViewGroup.teW = ((TextView)paramView.findViewById(2131300462));
        paramViewGroup.teW.setText(2131759183);
        paramView.setTag(paramViewGroup);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        locali = Ib(paramInt);
        boolean bool = this.teP.get(paramInt, true);
        this.teP.put(paramInt, false);
        localObject = o.a(locali.dKT, locali.tew, bool);
        if (locali.tew != null) {
          Log.i("MicroMsg.FavImgGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locali.tew.field_id), Long.valueOf(locali.tew.field_localId), Integer.valueOf(locali.tew.field_itemStatus) });
        }
        if (locali.dKT != null) {
          Log.i("MicroMsg.FavImgGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { locali.dKT.dLl, locali.dKT.KuR, locali.dKT.Lvp, Long.valueOf(locali.dKT.LvI), locali.dKT.iwX, locali.dKT.Lvk, Long.valueOf(locali.dKT.LvT) });
        }
        if (localObject != null) {
          break label794;
        }
        FavImgGalleryUI.this.enableOptionMenu(false);
        Log.w("MicroMsg.FavImgGalleryUI", "get big image fail");
        com.tencent.mm.plugin.fav.a.q localq = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage();
        if (locali.dKT == null) {
          break label561;
        }
        localObject = locali.dKT.dLl;
        label434:
        localObject = localq.asa((String)localObject);
        if (localObject != null) {
          break label640;
        }
        paramViewGroup.teV.setVisibility(8);
        if ((locali.tew == null) || (locali.tew.field_id >= 0)) {
          break label569;
        }
        paramViewGroup.progressBar.setVisibility(0);
        paramViewGroup.teU.setVisibility(0);
        paramViewGroup.mEx.setVisibility(0);
        paramViewGroup.teS.setVisibility(8);
        paramViewGroup.mEx.setImageBitmap(a(locali));
        paramViewGroup.progressBar.setProgress(0);
        paramViewGroup.teU.setText("0%");
      }
      for (;;)
      {
        AppMethodBeat.o(106752);
        return paramView;
        paramViewGroup = (FavImgGalleryUI.c)paramView.getTag();
        break;
        label561:
        localObject = "";
        break label434;
        label569:
        paramViewGroup.progressBar.setVisibility(8);
        paramViewGroup.teU.setVisibility(8);
        paramViewGroup.mEx.setVisibility(8);
        paramViewGroup.teS.setVisibility(0);
        if (locali.dKT.Lwv != 0) {
          paramViewGroup.teV.setVisibility(0);
        }
        b(paramViewGroup, a(locali), "");
      }
      label640:
      Log.i("MicroMsg.FavImgGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject).field_status) });
      paramViewGroup.progressBar.setVisibility(0);
      paramViewGroup.teU.setVisibility(0);
      paramViewGroup.mEx.setVisibility(0);
      paramViewGroup.teS.setVisibility(8);
      paramViewGroup.mEx.setImageBitmap(a(locali));
      if (((com.tencent.mm.plugin.fav.a.c)localObject).field_totalLen > 0) {}
      for (paramInt = ((com.tencent.mm.plugin.fav.a.c)localObject).field_offset * 100 / ((com.tencent.mm.plugin.fav.a.c)localObject).field_totalLen - 1;; paramInt = 0)
      {
        int i = paramInt;
        if (paramInt < 0) {
          i = 0;
        }
        paramViewGroup.progressBar.setProgress(i);
        paramViewGroup.teU.setText(i + "%");
        AppMethodBeat.o(106752);
        return paramView;
      }
      label794:
      FavImgGalleryUI.this.enableOptionMenu(true);
      if (ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d(locali.dKT))) {
        a(paramViewGroup, (Bitmap)localObject, com.tencent.mm.plugin.fav.a.b.d(locali.dKT));
      }
      for (;;)
      {
        AppMethodBeat.o(106752);
        return paramView;
        a(paramViewGroup, (Bitmap)localObject, "");
      }
    }
  }
  
  static final class b
  {
    qz teQ;
    boolean teR;
  }
  
  final class c
  {
    ImageView mEx;
    ProgressBar progressBar;
    View teS;
    MultiTouchImageView teT;
    TextView teU;
    LinearLayout teV;
    TextView teW;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI
 * JD-Core Version:    0.7.0.1
 */