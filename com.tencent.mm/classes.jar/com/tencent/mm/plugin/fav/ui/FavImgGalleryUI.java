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
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.pl.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavImgGalleryUI
  extends MMActivity
  implements AdapterView.OnItemSelectedListener, com.tencent.mm.plugin.fav.a.p, d.a, r.a, a.a<String, Integer>
{
  private ArrayList<i> dataList;
  private boolean drV;
  private MMGestureGallery ibu;
  private ScanCodeSheetItemLogic kxs;
  private n.d oEU;
  private int qeb;
  private a qec;
  private e qed;
  private d qee;
  private Map<String, b> qef;
  private boolean qeg;
  private r qeh;
  private long qei;
  private com.tencent.mm.sdk.b.c qej;
  
  public FavImgGalleryUI()
  {
    AppMethodBeat.i(106757);
    this.qeb = 0;
    this.drV = true;
    this.qef = new HashMap();
    this.oEU = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(106746);
        i locali = FavImgGalleryUI.i(FavImgGalleryUI.this).Cp(FavImgGalleryUI.h(FavImgGalleryUI.this));
        if (locali == null)
        {
          AppMethodBeat.o(106746);
          return;
        }
        String str = com.tencent.mm.plugin.fav.a.b.d(locali.djJ);
        if (!com.tencent.mm.vfs.i.eK(str))
        {
          ad.w("MicroMsg.FavImgGalleryUI", "file not exists");
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
          com.tencent.mm.plugin.fav.a.h.i(FavImgGalleryUI.j(FavImgGalleryUI.this), 1, 0);
          if (t.aFm(str))
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
            paramAnonymousMenuItem.putExtra("select_is_ret", true);
            com.tencent.mm.bs.d.c(FavImgGalleryUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 1);
            AppMethodBeat.o(106746);
            return;
          }
          com.tencent.mm.plugin.fav.a.b.a(str, FavImgGalleryUI.this, locali.djJ.hAt);
          AppMethodBeat.o(106746);
          return;
          com.tencent.mm.plugin.fav.a.b.b(str, FavImgGalleryUI.this);
          com.tencent.mm.plugin.fav.a.h.i(FavImgGalleryUI.j(FavImgGalleryUI.this), 0, 0);
          AppMethodBeat.o(106746);
          return;
          FavImgGalleryUI.a(str, FavImgGalleryUI.this.getString(2131758993), FavImgGalleryUI.this, locali.djJ.hAt);
          AppMethodBeat.o(106746);
          return;
          FavImgGalleryUI.a(FavImgGalleryUI.this).cjj();
          AppMethodBeat.o(106746);
          return;
          FavImgGalleryUI.k(FavImgGalleryUI.this);
        }
      }
    };
    this.qej = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(106757);
  }
  
  private void VP()
  {
    AppMethodBeat.i(106761);
    this.qei = getIntent().getLongExtra("key_detail_info_id", -1L);
    String str = getIntent().getStringExtra("key_detail_data_id");
    boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    Object localObject = getIntent().getStringExtra("fav_note_xml");
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(this.qei);
    long l = this.qei;
    boolean bool1;
    if (localg != null)
    {
      bool1 = true;
      ad.i("MicroMsg.FavImgGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
      if ((!bool2) || (bt.isNullOrNil((String)localObject))) {
        break label437;
      }
      localg = com.tencent.mm.plugin.fav.a.b.XY((String)localObject);
    }
    label434:
    label437:
    for (;;)
    {
      if (localg != null) {
        localArrayList.add(localg);
      }
      this.dataList.clear();
      final int i = -1;
      int m = localArrayList.size();
      int k = 0;
      label184:
      int j;
      if (k < m)
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localArrayList.get(k);
        int n = localg.field_favProto.mVb.size();
        j = 0;
        label218:
        if (j < n)
        {
          localObject = (afy)localg.field_favProto.mVb.get(j);
          if (((((afy)localObject).dataType == 8) && (!t.aFm(com.tencent.mm.plugin.fav.a.b.d((afy)localObject)))) || ((((afy)localObject).dataType != 2) && (((afy)localObject).dataType != 8))) {
            break label434;
          }
          i locali = new i(localg, (afy)localObject);
          this.dataList.add(locali);
          if ((str == null) || (!str.equals(((afy)localObject).dkb))) {
            break label434;
          }
          i = this.dataList.size() - 1;
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
          if (localg.field_localId == this.qei) {
            j = this.dataList.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label184;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.qec.notifyDataSetChanged();
        this.ibu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106738);
            if (i != -1)
            {
              ad.d("MicroMsg.FavImgGalleryUI", "match selection %d", new Object[] { Integer.valueOf(i) });
              FavImgGalleryUI.c(FavImgGalleryUI.this).setSelection(i);
              FavImgGalleryUI.a(FavImgGalleryUI.this, i);
              AppMethodBeat.o(106738);
              return;
            }
            if ((FavImgGalleryUI.h(FavImgGalleryUI.this) - 1 >= 0) && (FavImgGalleryUI.h(FavImgGalleryUI.this) - 1 < FavImgGalleryUI.m(FavImgGalleryUI.this).size()))
            {
              ad.d("MicroMsg.FavImgGalleryUI", "adjust selection %d, list size %d", new Object[] { Integer.valueOf(FavImgGalleryUI.h(FavImgGalleryUI.this) - 1), Integer.valueOf(FavImgGalleryUI.m(FavImgGalleryUI.this).size()) });
              FavImgGalleryUI.c(FavImgGalleryUI.this).setSelection(FavImgGalleryUI.h(FavImgGalleryUI.this) - 1);
              FavImgGalleryUI.a(FavImgGalleryUI.this, FavImgGalleryUI.h(FavImgGalleryUI.this) - 1);
              AppMethodBeat.o(106738);
              return;
            }
            if (FavImgGalleryUI.m(FavImgGalleryUI.this).size() > 0)
            {
              ad.d("MicroMsg.FavImgGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[] { Integer.valueOf(FavImgGalleryUI.m(FavImgGalleryUI.this).size()) });
              FavImgGalleryUI.c(FavImgGalleryUI.this).setSelection(0);
              FavImgGalleryUI.a(FavImgGalleryUI.this, 0);
              AppMethodBeat.o(106738);
              return;
            }
            ad.w("MicroMsg.FavImgGalleryUI", "data list size %d, empty, finish", new Object[] { Integer.valueOf(FavImgGalleryUI.m(FavImgGalleryUI.this).size()) });
            FavImgGalleryUI.this.finish();
            AppMethodBeat.o(106738);
          }
        });
        AppMethodBeat.o(106761);
        return;
      }
    }
  }
  
  public static void a(String paramString1, final String paramString2, Context paramContext, final String paramString3)
  {
    AppMethodBeat.i(164093);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.FavImgGalleryUI", "save image fail, path is null");
      AppMethodBeat.o(164093);
      return;
    }
    com.tencent.mm.platformtools.p.a(paramContext, paramString1, new p.a()
    {
      public final void bv(String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(186914);
        Toast.makeText(this.val$context, this.val$context.getString(2131757969, new Object[] { paramAnonymousString2 }), 1).show();
        com.tencent.e.h.Iye.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186913);
            String str = com.tencent.mm.vfs.i.aEN(paramAnonymousString2);
            v localv = v.hUC;
            v.bx(str, FavImgGalleryUI.13.this.qep);
            AppMethodBeat.o(186913);
          }
        });
        AppMethodBeat.o(186914);
      }
      
      public final void bw(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(186915);
        Toast.makeText(this.val$context, paramString2, 1).show();
        AppMethodBeat.o(186915);
      }
    });
    AppMethodBeat.o(164093);
  }
  
  private void iD(boolean paramBoolean)
  {
    AppMethodBeat.i(106759);
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    Object localObject = this.qec.Cp(this.qeb);
    if (localObject == null)
    {
      AppMethodBeat.o(106759);
      return;
    }
    if (((i)localObject).djJ.Dhh != 0)
    {
      AppMethodBeat.o(106759);
      return;
    }
    if ((((i)localObject).qea != null) && (((i)localObject).qea.chE()))
    {
      localArrayList1.add(Integer.valueOf(0));
      localArrayList2.add(getString(2131759001));
    }
    if ((((i)localObject).qea != null) && (((i)localObject).qea.chF()))
    {
      localArrayList1.add(Integer.valueOf(1));
      localArrayList2.add(getString(2131758951));
    }
    localArrayList1.add(Integer.valueOf(2));
    localArrayList2.add(getString(2131762781));
    localObject = com.tencent.mm.plugin.fav.a.b.d(((i)localObject).djJ);
    if ((this.qeg) && (!bt.isNullOrNil((String)localObject)))
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(2131757184));
    }
    localArrayList1.add(Integer.valueOf(5));
    localArrayList2.add(getString(2131757183));
    final b localb = (b)this.qef.get(localObject);
    if ((localb != null) && (localb.qet != null)) {
      if (!bt.isNullOrNil(localb.qet.dva.result))
      {
        localArrayList1.add(Integer.valueOf(3));
        localArrayList2.add(this.kxs.dkU());
      }
    }
    for (;;)
    {
      if (this.qed == null) {
        this.qed = new e(getContext(), 1, false);
      }
      this.qed.HrX = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(106744);
          FavImgGalleryUI.e(FavImgGalleryUI.this).setFooterView(null);
          paramAnonymousl.clear();
          paramAnonymousl.setHeaderTitle("");
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
              paramAnonymousl.c(((Integer)localArrayList1.get(i)).intValue(), (CharSequence)localArrayList2.get(i));
            }
          }
          AppMethodBeat.o(106744);
        }
      };
      this.qed.HrY = this.oEU;
      this.qed.GHn = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(106745);
          FavImgGalleryUI.f(FavImgGalleryUI.this);
          FavImgGalleryUI.g(FavImgGalleryUI.this).vLD = null;
          AppMethodBeat.o(106745);
        }
      };
      if (!getContext().isFinishing()) {
        this.qed.csG();
      }
      if (!bt.isNullOrNil((String)localObject))
      {
        com.tencent.mm.kernel.g.afC();
        if ((com.tencent.mm.kernel.g.afA().gcy.auR() != 0) && (paramBoolean)) {
          this.qeh.scan((String)localObject);
        }
      }
      AppMethodBeat.o(106759);
      return;
      pj localpj = new pj();
      localpj.duX.dcQ = System.currentTimeMillis();
      localpj.duX.filePath = ((String)localObject);
      com.tencent.mm.sdk.b.a.ESL.l(localpj);
    }
  }
  
  public final MultiTouchImageView ciP()
  {
    AppMethodBeat.i(106767);
    int i = this.ibu.getSelectedItemPosition();
    Object localObject = this.ibu;
    localObject = ((MMGestureGallery)localObject).getChildAt(i - ((MMGestureGallery)localObject).getFirstVisiblePosition());
    if (localObject == null)
    {
      ad.i("MicroMsg.FavImgGalleryUI", "getCurView() pos:%s firstPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ibu.getFirstVisiblePosition()) });
      AppMethodBeat.o(106767);
      return null;
    }
    if ((localObject instanceof MultiTouchImageView))
    {
      localObject = (MultiTouchImageView)localObject;
      AppMethodBeat.o(106767);
      return localObject;
    }
    localObject = (MultiTouchImageView)((View)localObject).findViewById(2131300914);
    AppMethodBeat.o(106767);
    return localObject;
  }
  
  public final String ciQ()
  {
    AppMethodBeat.i(106768);
    int i = this.ibu.getSelectedItemPosition();
    String str = this.qec.Cp(i).djJ.dkb;
    AppMethodBeat.o(106768);
    return str;
  }
  
  public final String ciZ()
  {
    AppMethodBeat.i(106766);
    Object localObject = this.qec.Cp(this.qeb);
    if (localObject == null)
    {
      AppMethodBeat.o(106766);
      return "";
    }
    localObject = com.tencent.mm.plugin.fav.a.b.d(((i)localObject).djJ);
    AppMethodBeat.o(106766);
    return localObject;
  }
  
  public final void e(final com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(106770);
    if (paramc != null)
    {
      ad.v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", new Object[] { Integer.valueOf(paramc.field_status) });
      i locali = this.qec.Cp(this.qeb);
      if ((locali != null) && (bt.by(paramc.field_dataId, "").equals(locali.djJ.dkb))) {
        aq.f(new Runnable()
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
              ((FavImgGalleryUI.c)localObject).qex.setText(i + "%");
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
  
  public int getLayoutId()
  {
    return 2131493953;
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
      i locali = this.qec.Cp(this.qeb);
      if (locali == null)
      {
        ad.i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
        AppMethodBeat.o(106771);
        return;
      }
      new k();
      if (k.v(locali.qea))
      {
        com.tencent.mm.ui.base.h.cf(getContext(), getString(2131755010));
        AppMethodBeat.o(106771);
        return;
      }
      String str = paramIntent.getStringExtra("Select_Conv_User");
      ad.d("MicroMsg.FavImgGalleryUI", "select %s for sending", new Object[] { str });
      final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
      l.a(getContext(), str, locali.qea, locali.djJ, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164090);
          localp.dismiss();
          com.tencent.mm.ui.widget.snackbar.b.n(FavImgGalleryUI.this, FavImgGalleryUI.this.getString(2131758834));
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
    if (com.tencent.mm.compatible.util.d.lf(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.qeh = new r(this, this, this);
      this.drV = getIntent().getBooleanExtra("show_share", true);
      this.ibu = ((MMGestureGallery)findViewById(2131300335));
      this.qee = new d(this.ibu, this, this);
      this.ibu.setVerticalFadingEdgeEnabled(false);
      this.ibu.setHorizontalFadingEdgeEnabled(false);
      this.ibu.setOnItemSelectedListener(this);
      this.ibu.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void aHo()
        {
          AppMethodBeat.i(106737);
          if (FavImgGalleryUI.a(FavImgGalleryUI.this).qgu != 1) {
            FavImgGalleryUI.b(FavImgGalleryUI.this).kD(true);
          }
          AppMethodBeat.o(106737);
        }
      });
      if (this.drV) {
        this.ibu.setLongClickOverListener(new MMGestureGallery.c()
        {
          public final void aHp()
          {
            AppMethodBeat.i(106741);
            if (FavImgGalleryUI.a(FavImgGalleryUI.this).qgu == 1)
            {
              AppMethodBeat.o(106741);
              return;
            }
            if ((!FavImgGalleryUI.this.isFinishing()) && (!FavImgGalleryUI.this.activityHasDestroyed()))
            {
              y.b localb = y.arz().E("basescanui@datacenter", true);
              localb.m("key_basescanui_screen_x", Integer.valueOf(FavImgGalleryUI.c(FavImgGalleryUI.this).getXDown()));
              localb.m("key_basescanui_screen_y", Integer.valueOf(FavImgGalleryUI.c(FavImgGalleryUI.this).getYDown()));
              if ((FavImgGalleryUI.a(FavImgGalleryUI.this).qgu == 0) || (FavImgGalleryUI.a(FavImgGalleryUI.this).qgu == 2))
              {
                FavImgGalleryUI.a(FavImgGalleryUI.this, com.tencent.mm.plugin.scanner.g.dkX());
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
      this.dataList = new ArrayList();
      this.qec = new a((byte)0);
      this.ibu.setAdapter(this.qec);
      VP();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(106742);
          FavImgGalleryUI.b(FavImgGalleryUI.this).kD(true);
          AppMethodBeat.o(106742);
          return true;
        }
      });
      this.kxs = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
      {
        public final void beE()
        {
          AppMethodBeat.i(106743);
          FavImgGalleryUI.d(FavImgGalleryUI.this);
          AppMethodBeat.o(106743);
        }
      });
      com.tencent.mm.sdk.b.a.ESL.c(this.qej);
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
    com.tencent.mm.sdk.b.a.ESL.d(this.qej);
    if (this.qee != null) {
      this.qee.onDestroy();
    }
    if (this.qeh != null) {
      this.qeh.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(106762);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(106769);
    this.qeb = paramInt;
    ad.d("MicroMsg.FavImgGalleryUI", "pos:".concat(String.valueOf(paramInt)));
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).eSz();
    }
    AppMethodBeat.o(106769);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106765);
    if (paramInt == 4)
    {
      this.qee.kD(true);
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
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b(this);
    f.d(false, true, true);
    AppMethodBeat.o(106764);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106763);
    super.onResume();
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(this);
    f.d(true, true, true);
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
    SparseBooleanArray qes;
    
    private a()
    {
      AppMethodBeat.i(106749);
      this.qes = new SparseBooleanArray();
      AppMethodBeat.o(106749);
    }
    
    private Bitmap a(i parami)
    {
      AppMethodBeat.i(106754);
      if (parami != null)
      {
        parami = o.a(parami.djJ, parami.qea);
        if (parami != null)
        {
          AppMethodBeat.o(106754);
          return parami;
        }
      }
      parami = com.tencent.mm.compatible.e.a.decodeResource(FavImgGalleryUI.this.getResources(), 2131690066);
      AppMethodBeat.o(106754);
      return parami;
    }
    
    private void a(FavImgGalleryUI.c paramc, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(106753);
      paramc.progressBar.setVisibility(8);
      paramc.qex.setVisibility(8);
      paramc.kuM.setVisibility(8);
      paramc.qev.setVisibility(0);
      paramc.qey.setVisibility(8);
      b(paramc, paramBitmap, paramString);
      AppMethodBeat.o(106753);
    }
    
    private void b(FavImgGalleryUI.c paramc, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(106755);
      com.tencent.mm.sdk.platformtools.p.z(paramc.qew, paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = paramc.qew.getWidth();
      int j = paramc.qew.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.reset();
      float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
      float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
      ad.v("MicroMsg.FavImgGalleryUI", "whDiv is " + f1 + " hwDiv is " + f2);
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
        paramc.qew.setImageMatrix(localMatrix);
        paramc.qew.cH(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramc.qew.setMaxZoomDoubleTab(true);
        if (!bt.isNullOrNil(paramString)) {
          break label524;
        }
        paramc.qew.setImageBitmap(paramBitmap);
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
          ad.d("MicroMsg.FavImgGalleryUI", " offsety ".concat(String.valueOf(f1)));
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
          paramc.qew.setGifDrawable(paramString);
          paramc.qew.jm(com.tencent.mm.cd.a.hV(FavImgGalleryUI.this.getContext()), com.tencent.mm.cd.a.hW(FavImgGalleryUI.this.getContext()));
          paramc.qew.cH(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          paramc.qew.start();
          paramc.qew.eSA();
          AppMethodBeat.o(106755);
          return;
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.FavImgGalleryUI", bt.m(paramString));
          paramc.qew.setImageBitmap(paramBitmap);
          AppMethodBeat.o(106755);
          return;
        }
        label627:
        f1 = 1.0F;
      }
    }
    
    public final i Cp(int paramInt)
    {
      AppMethodBeat.i(106751);
      if (paramInt >= FavImgGalleryUI.m(FavImgGalleryUI.this).size())
      {
        ad.w("MicroMsg.FavImgGalleryUI", "get item fail, position %d error", new Object[] { Integer.valueOf(paramInt) });
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
        paramView = View.inflate(FavImgGalleryUI.this.getContext(), 2131493952, null);
        paramViewGroup.qev = paramView.findViewById(2131300933);
        paramViewGroup.qew = ((MultiTouchImageView)paramView.findViewById(2131300914));
        paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(2131299229));
        paramViewGroup.kuM = ((ImageView)paramView.findViewById(2131305798));
        paramViewGroup.qex = ((TextView)paramView.findViewById(2131299230));
        paramViewGroup.qey = ((LinearLayout)paramView.findViewById(2131299788));
        paramViewGroup.qez = ((TextView)paramView.findViewById(2131299789));
        paramViewGroup.qez.setText(2131758860);
        paramView.setTag(paramViewGroup);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        locali = Cp(paramInt);
        boolean bool = this.qes.get(paramInt, true);
        this.qes.put(paramInt, false);
        localObject = o.a(locali.djJ, locali.qea, bool);
        if (locali.qea != null) {
          ad.i("MicroMsg.FavImgGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locali.qea.field_id), Long.valueOf(locali.qea.field_localId), Integer.valueOf(locali.qea.field_itemStatus) });
        }
        if (locali.djJ != null) {
          ad.i("MicroMsg.FavImgGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { locali.djJ.dkb, locali.djJ.DfZ, locali.djJ.Dgb, Long.valueOf(locali.djJ.Dgu), locali.djJ.gHu, locali.djJ.DfV, Long.valueOf(locali.djJ.DgF) });
        }
        if (localObject != null) {
          break label794;
        }
        FavImgGalleryUI.this.enableOptionMenu(false);
        ad.w("MicroMsg.FavImgGalleryUI", "get big image fail");
        com.tencent.mm.plugin.fav.a.q localq = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage();
        if (locali.djJ == null) {
          break label561;
        }
        localObject = locali.djJ.dkb;
        label434:
        localObject = localq.Yk((String)localObject);
        if (localObject != null) {
          break label640;
        }
        paramViewGroup.qey.setVisibility(8);
        if ((locali.qea == null) || (locali.qea.field_id >= 0)) {
          break label569;
        }
        paramViewGroup.progressBar.setVisibility(0);
        paramViewGroup.qex.setVisibility(0);
        paramViewGroup.kuM.setVisibility(0);
        paramViewGroup.qev.setVisibility(8);
        paramViewGroup.kuM.setImageBitmap(a(locali));
        paramViewGroup.progressBar.setProgress(0);
        paramViewGroup.qex.setText("0%");
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
        paramViewGroup.qex.setVisibility(8);
        paramViewGroup.kuM.setVisibility(8);
        paramViewGroup.qev.setVisibility(0);
        if (locali.djJ.Dhh != 0) {
          paramViewGroup.qey.setVisibility(0);
        }
        b(paramViewGroup, a(locali), "");
      }
      label640:
      ad.i("MicroMsg.FavImgGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject).field_status) });
      paramViewGroup.progressBar.setVisibility(0);
      paramViewGroup.qex.setVisibility(0);
      paramViewGroup.kuM.setVisibility(0);
      paramViewGroup.qev.setVisibility(8);
      paramViewGroup.kuM.setImageBitmap(a(locali));
      if (((com.tencent.mm.plugin.fav.a.c)localObject).field_totalLen > 0) {}
      for (paramInt = ((com.tencent.mm.plugin.fav.a.c)localObject).field_offset * 100 / ((com.tencent.mm.plugin.fav.a.c)localObject).field_totalLen - 1;; paramInt = 0)
      {
        int i = paramInt;
        if (paramInt < 0) {
          i = 0;
        }
        paramViewGroup.progressBar.setProgress(i);
        paramViewGroup.qex.setText(i + "%");
        AppMethodBeat.o(106752);
        return paramView;
      }
      label794:
      FavImgGalleryUI.this.enableOptionMenu(true);
      if (t.aFm(com.tencent.mm.plugin.fav.a.b.d(locali.djJ))) {
        a(paramViewGroup, (Bitmap)localObject, com.tencent.mm.plugin.fav.a.b.d(locali.djJ));
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
    pl qet;
    boolean qeu;
  }
  
  final class c
  {
    ImageView kuM;
    ProgressBar progressBar;
    View qev;
    MultiTouchImageView qew;
    TextView qex;
    LinearLayout qey;
    TextView qez;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI
 * JD-Core Version:    0.7.0.1
 */