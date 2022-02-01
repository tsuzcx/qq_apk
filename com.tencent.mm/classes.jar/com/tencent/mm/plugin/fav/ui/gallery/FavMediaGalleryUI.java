package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qe.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.r;
import com.tencent.mm.plugin.fav.ui.r.a;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavMediaGalleryUI
  extends MMActivity
  implements AdapterView.OnItemSelectedListener, p, r.a, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  private boolean dBt;
  private MMGestureGallery iUH;
  private ArrayList<com.tencent.mm.plugin.fav.ui.i> jfg;
  private n.e pLV;
  private int rBV;
  private FavVideoView rBW;
  private a rBX;
  private e rBY;
  private List<FavVideoView> rBZ;
  private HashMap<String, List<View>> rCa;
  private int rwG;
  private Map<String, qe> rwK;
  private boolean rwL;
  private r rwM;
  private long rwN;
  private com.tencent.mm.sdk.b.c rwO;
  akf rxx;
  
  public FavMediaGalleryUI()
  {
    AppMethodBeat.i(107341);
    this.rwG = 0;
    this.rBV = -1;
    this.rBW = null;
    this.dBt = true;
    this.rBZ = new ArrayList();
    this.rCa = new HashMap();
    this.rxx = new akf();
    this.rwK = new HashMap();
    this.pLV = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(107327);
        Object localObject1 = FavMediaGalleryUI.b(FavMediaGalleryUI.this).Ed(FavMediaGalleryUI.a(FavMediaGalleryUI.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(107327);
          return;
        }
        Object localObject2 = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC);
        if ((!com.tencent.mm.vfs.i.fv((String)localObject2)) && (paramAnonymousMenuItem.getItemId() != 4))
        {
          ad.w("MicroMsg.FavMediaGalleryUI", "file not exists");
          AppMethodBeat.o(107327);
          return;
        }
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(107327);
          return;
          com.tencent.mm.plugin.fav.a.h.i(FavMediaGalleryUI.h(FavMediaGalleryUI.this), 1, 0);
          if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC.dataType == 2)
          {
            if (t.aQj((String)localObject2))
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymousMenuItem.putExtra("select_is_ret", true);
              com.tencent.mm.bs.d.c(FavMediaGalleryUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 1);
              AppMethodBeat.o(107327);
              return;
            }
            com.tencent.mm.plugin.fav.a.b.a((String)localObject2, FavMediaGalleryUI.this, ((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC.iuq);
            AppMethodBeat.o(107327);
            return;
          }
          paramAnonymousMenuItem = com.tencent.mm.plugin.fav.a.b.a(((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC);
          localObject1 = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
          if (com.tencent.mm.vfs.i.fv(paramAnonymousMenuItem)) {
            ((Intent)localObject2).putExtra("image_path", paramAnonymousMenuItem);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("Retr_Msg_Type", 1);
            com.tencent.mm.bs.d.c(FavMediaGalleryUI.this.getContext(), ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1);
            AppMethodBeat.o(107327);
            return;
            ((Intent)localObject2).putExtra("image_path", (String)localObject1);
          }
          com.tencent.mm.plugin.fav.a.b.b((String)localObject2, FavMediaGalleryUI.this);
          com.tencent.mm.plugin.fav.a.h.i(FavMediaGalleryUI.h(FavMediaGalleryUI.this), 0, 0);
          AppMethodBeat.o(107327);
          return;
          if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC.dataType == 2)
          {
            FavMediaGalleryUI.a(FavMediaGalleryUI.this, (String)localObject2);
            AppMethodBeat.o(107327);
            return;
          }
          FavMediaGalleryUI.b(FavMediaGalleryUI.this, (String)localObject2);
          AppMethodBeat.o(107327);
          return;
          localObject2 = (qe)FavMediaGalleryUI.i(FavMediaGalleryUI.this).get(localObject2);
          if (localObject2 != null)
          {
            paramAnonymousMenuItem = new co();
            paramAnonymousMenuItem.dns.activity = FavMediaGalleryUI.this;
            paramAnonymousMenuItem.dns.dlG = ((qe)localObject2).dEH.result;
            paramAnonymousMenuItem.dns.dnt = ((qe)localObject2).dEH.dnt;
            paramAnonymousMenuItem.dns.sourceType = 7;
            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC != null))
            {
              paramAnonymousMenuItem.dns.imagePath = ((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC.GgR;
              paramAnonymousMenuItem.dns.dnw = ((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC.GgT;
            }
            paramAnonymousMenuItem.dns.dnu = ((qe)localObject2).dEH.dnu;
            localObject1 = new Bundle(1);
            ((Bundle)localObject1).putInt("stat_scene", 5);
            paramAnonymousMenuItem.dns.dnx = ((Bundle)localObject1);
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
            AppMethodBeat.o(107327);
            return;
            FavMediaGalleryUI.this.rxx.index = (FavMediaGalleryUI.b(FavMediaGalleryUI.this).getCount() - FavMediaGalleryUI.a(FavMediaGalleryUI.this));
            ((y)com.tencent.mm.kernel.g.ab(y.class)).a(FavMediaGalleryUI.this.getContext(), ((com.tencent.mm.plugin.fav.ui.i)localObject1).rwF, FavMediaGalleryUI.this.rxx);
            FavMediaGalleryUI.this.finish();
            AppMethodBeat.o(107327);
            return;
            FavMediaGalleryUI.e(FavMediaGalleryUI.this).cwA();
            AppMethodBeat.o(107327);
            return;
            FavMediaGalleryUI.j(FavMediaGalleryUI.this);
          }
        }
      }
    };
    this.rwO = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(107341);
  }
  
  private void Zh()
  {
    AppMethodBeat.i(107344);
    Object localObject1 = getIntent().getLongArrayExtra("KEY_MEDIA_FAVID_LIST");
    ArrayList localArrayList = new ArrayList();
    String str = getIntent().getStringExtra("key_detail_data_id");
    this.rwN = getIntent().getLongExtra("key_detail_info_id", -1L);
    Object localObject2;
    long l;
    boolean bool1;
    if (localObject1 == null)
    {
      boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
      localObject2 = getIntent().getStringExtra("fav_note_xml");
      localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(this.rwN);
      l = this.rwN;
      if (localObject1 != null)
      {
        bool1 = true;
        ad.i("MicroMsg.FavMediaGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
        if ((!bool2) || (bt.isNullOrNil((String)localObject2))) {
          break label594;
        }
        localObject1 = com.tencent.mm.plugin.fav.a.b.agj((String)localObject2);
      }
    }
    label180:
    label200:
    label591:
    label594:
    for (;;)
    {
      if (localObject1 != null) {
        localArrayList.add(localObject1);
      }
      this.jfg.clear();
      final int i = -1;
      int m = localArrayList.size();
      int k = 0;
      int j;
      if (k < m)
      {
        localObject1 = (com.tencent.mm.plugin.fav.a.g)localArrayList.get(k);
        int n = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nZa.size();
        j = 0;
        label234:
        if (j < n)
        {
          localObject2 = (ajn)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nZa.get(j);
          if (((((ajn)localObject2).dataType == 8) && (!t.aQj(com.tencent.mm.plugin.fav.a.b.d((ajn)localObject2)))) || ((((ajn)localObject2).dataType != 2) && (((ajn)localObject2).dataType != 4) && (((ajn)localObject2).dataType != 15) && (((ajn)localObject2).dataType != 8))) {
            break label591;
          }
          com.tencent.mm.plugin.fav.ui.i locali = new com.tencent.mm.plugin.fav.ui.i((com.tencent.mm.plugin.fav.a.g)localObject1, (ajn)localObject2);
          this.jfg.add(locali);
          if ((str == null) || (!str.equals(((ajn)localObject2).dsU)) || (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId != this.rwN)) {
            break label591;
          }
          i = this.jfg.size() - 1;
        }
      }
      for (;;)
      {
        j += 1;
        break label234;
        bool1 = false;
        break;
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          l = localObject1[i];
          localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(l);
          if ((localObject2 != null) && (!localArrayList.contains(localObject2))) {
            localArrayList.add(localObject2);
          }
          i += 1;
        }
        break label180;
        j = i;
        if (str == null)
        {
          j = i;
          if (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId == this.rwN) {
            j = this.jfg.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label200;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.rBX.notifyDataSetChanged();
        if (i >= 0)
        {
          ad.i("MicroMsg.FavMediaGalleryUI", "pre match selection %d", new Object[] { Integer.valueOf(i) });
          this.iUH.setSelection(i);
          this.rwG = i;
        }
        this.iUH.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107329);
            if (i != -1)
            {
              ad.d("MicroMsg.FavMediaGalleryUI", "match selection %d", new Object[] { Integer.valueOf(i) });
              FavMediaGalleryUI.k(FavMediaGalleryUI.this).setSelection(i);
              FavMediaGalleryUI.a(FavMediaGalleryUI.this, i);
              AppMethodBeat.o(107329);
              return;
            }
            if ((FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1 >= 0) && (FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1 < FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()))
            {
              ad.d("MicroMsg.FavMediaGalleryUI", "adjust selection %d, list size %d", new Object[] { Integer.valueOf(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1), Integer.valueOf(FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()) });
              FavMediaGalleryUI.k(FavMediaGalleryUI.this).setSelection(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1);
              FavMediaGalleryUI.a(FavMediaGalleryUI.this, FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1);
              AppMethodBeat.o(107329);
              return;
            }
            if (FavMediaGalleryUI.l(FavMediaGalleryUI.this).size() > 0)
            {
              ad.d("MicroMsg.FavMediaGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[] { Integer.valueOf(FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()) });
              FavMediaGalleryUI.k(FavMediaGalleryUI.this).setSelection(0);
              FavMediaGalleryUI.a(FavMediaGalleryUI.this, 0);
              AppMethodBeat.o(107329);
              return;
            }
            ad.w("MicroMsg.FavMediaGalleryUI", "data list size %d, empty, finish", new Object[] { Integer.valueOf(FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()) });
            FavMediaGalleryUI.this.finish();
            AppMethodBeat.o(107329);
          }
        });
        AppMethodBeat.o(107344);
        return;
      }
    }
  }
  
  private void jr(boolean paramBoolean)
  {
    AppMethodBeat.i(107343);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = this.rBX.Ed(this.rwG);
    if (localObject1 == null)
    {
      AppMethodBeat.o(107343);
      return;
    }
    if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC.GhZ != 0) {
      ad.i("MicroMsg.FavMediaGalleryUI", "showMenu, illegalType");
    }
    for (;;)
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(2131758910));
      if (this.rBY == null) {
        this.rBY = new e(getContext(), 1, false);
      }
      this.rBY.KJy = new FavMediaGalleryUI.7(this, localArrayList1, localArrayList2);
      this.rBY.KJz = this.pLV;
      this.rBY.JXC = new FavMediaGalleryUI.8(this);
      this.rBY.cMW();
      AppMethodBeat.o(107343);
      return;
      if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC.dataType == 2)
      {
        if ((((com.tencent.mm.plugin.fav.ui.i)localObject1).rwF != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).rwF.cuQ()))
        {
          localArrayList1.add(Integer.valueOf(0));
          localArrayList2.add(getString(2131759001));
        }
        if ((((com.tencent.mm.plugin.fav.ui.i)localObject1).rwF != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).rwF.cuR()))
        {
          localArrayList1.add(Integer.valueOf(1));
          localArrayList2.add(getString(2131758951));
        }
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2.add(getString(2131758994));
        localObject1 = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC);
        Object localObject2 = (qe)this.rwK.get(localObject1);
        if (localObject2 != null) {
          if (!bt.isNullOrNil(((qe)localObject2).dEH.result))
          {
            localArrayList1.add(Integer.valueOf(3));
            if (!com.tencent.mm.plugin.scanner.f.bM(((qe)localObject2).dEH.dnt, ((qe)localObject2).dEH.result)) {
              break label495;
            }
            localArrayList2.add(getString(2131758961));
          }
        }
        for (;;)
        {
          if ((this.rwL) && (!bt.isNullOrNil((String)localObject1)))
          {
            localArrayList1.add(Integer.valueOf(5));
            localArrayList2.add(getString(2131757184));
          }
          localArrayList1.add(Integer.valueOf(6));
          localArrayList2.add(getString(2131757183));
          if (bt.isNullOrNil((String)localObject1)) {
            break;
          }
          com.tencent.mm.kernel.g.ajD();
          if ((com.tencent.mm.kernel.g.ajB().gAO.aEN() == 0) || (!paramBoolean)) {
            break;
          }
          this.rwM.scan((String)localObject1);
          break;
          label495:
          if (com.tencent.mm.plugin.scanner.f.bN(((qe)localObject2).dEH.dnt, ((qe)localObject2).dEH.result))
          {
            localArrayList2.add(getString(2131758958));
          }
          else
          {
            localArrayList2.add(getString(2131758960));
            continue;
            localObject2 = new qc();
            ((qc)localObject2).dEC.dlI = System.currentTimeMillis();
            ((qc)localObject2).dEC.filePath = ((String)localObject1);
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
      }
      if (com.tencent.mm.vfs.i.fv(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dsC)))
      {
        if ((((com.tencent.mm.plugin.fav.ui.i)localObject1).rwF != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).rwF.cuQ()))
        {
          localArrayList1.add(Integer.valueOf(0));
          localArrayList2.add(getString(2131759001));
        }
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2.add(getString(2131762784));
      }
    }
  }
  
  public final String cwq()
  {
    AppMethodBeat.i(107348);
    Object localObject = this.rBX.Ed(this.rwG);
    if (localObject == null)
    {
      AppMethodBeat.o(107348);
      return "";
    }
    if (((com.tencent.mm.plugin.fav.ui.i)localObject).dsC.dataType == 2)
    {
      localObject = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject).dsC);
      AppMethodBeat.o(107348);
      return localObject;
    }
    AppMethodBeat.o(107348);
    return "";
  }
  
  public final void e(final com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(107350);
    if (paramc != null)
    {
      com.tencent.mm.plugin.fav.ui.i locali = this.rBX.Ed(this.rwG);
      if ((locali != null) && (bt.bI(paramc.field_dataId, "").equals(locali.dsC.dsU)) && (locali.dsC.dataType == 2)) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            int j = 0;
            AppMethodBeat.i(107330);
            Object localObject = FavMediaGalleryUI.k(FavMediaGalleryUI.this).getSelectedView();
            if (localObject == null)
            {
              AppMethodBeat.o(107330);
              return;
            }
            if ((((View)localObject).getTag() == null) || (!(((View)localObject).getTag() instanceof FavMediaGalleryUI.b)))
            {
              AppMethodBeat.o(107330);
              return;
            }
            localObject = (FavMediaGalleryUI.b)((View)localObject).getTag();
            int i;
            if (paramc.field_totalLen > 0)
            {
              i = paramc.field_offset * 100 / paramc.field_totalLen - 1;
              if (i >= 0) {
                break label167;
              }
              i = j;
            }
            label167:
            for (;;)
            {
              ((FavMediaGalleryUI.b)localObject).progressBar.setProgress(i);
              ((FavMediaGalleryUI.b)localObject).rxc.setText(i + "%");
              if ((i >= 100) || (paramc.isFinished())) {
                FavMediaGalleryUI.b(FavMediaGalleryUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(107330);
              return;
              i = 0;
              break;
            }
          }
        });
      }
    }
    AppMethodBeat.o(107350);
  }
  
  public int getLayoutId()
  {
    return 2131493953;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(107351);
    if (1 == paramInt1)
    {
      if (-1 != paramInt2)
      {
        AppMethodBeat.o(107351);
        return;
      }
      com.tencent.mm.plugin.fav.ui.i locali = this.rBX.Ed(this.rwG);
      if (locali == null)
      {
        ad.i("MicroMsg.FavMediaGalleryUI", "dataItem is null.");
        AppMethodBeat.o(107351);
        return;
      }
      String str = com.tencent.mm.plugin.fav.a.b.d(locali.dsC);
      new k();
      if (k.v(locali.rwF))
      {
        com.tencent.mm.ui.base.h.cl(getContext(), getString(2131755010));
        AppMethodBeat.o(107351);
        return;
      }
      Object localObject2 = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject1 = bt.U(((String)localObject2).split(","));
      ad.d("MicroMsg.FavMediaGalleryUI", "select %s for sending", new Object[] { localObject2 });
      localObject2 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
      if (t.aQj(str))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          l.a(getContext(), str, locali.rwF, locali.dsC, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107321);
              this.rvc.dismiss();
              AppMethodBeat.o(107321);
            }
          });
        }
      }
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(218799);
          this.rvc.dismiss();
          AppMethodBeat.o(218799);
        }
      };
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        l.a(this, (String)((Iterator)localObject1).next(), locali.dsC, (Runnable)localObject2);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107351);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107342);
    super.onCreate(paramBundle);
    akf localakf;
    if (com.tencent.mm.compatible.util.d.ly(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.rwM = new r(this, this, this);
      this.dBt = getIntent().getBooleanExtra("show_share", true);
      this.iUH = ((MMGestureGallery)findViewById(2131300335));
      this.iUH.setVerticalFadingEdgeEnabled(false);
      this.iUH.setHorizontalFadingEdgeEnabled(false);
      this.iUH.setOnItemSelectedListener(this);
      this.iUH.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void aRp()
        {
          AppMethodBeat.i(107320);
          Object localObject = FavMediaGalleryUI.b(FavMediaGalleryUI.this).Ed(FavMediaGalleryUI.a(FavMediaGalleryUI.this));
          if ((localObject != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject).dsC.GhZ == 0) && (((com.tencent.mm.plugin.fav.ui.i)localObject).dsC.dataType != 2) && (com.tencent.mm.vfs.i.fv(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject).dsC))))
          {
            localObject = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject).dsC);
            localObject = (List)FavMediaGalleryUI.c(FavMediaGalleryUI.this).get(localObject);
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                View localView = (View)((Iterator)localObject).next();
                if ((localView instanceof FavVideoView)) {
                  ((FavVideoView)localView).cxq();
                }
              }
              AppMethodBeat.o(107320);
              return;
            }
          }
          if ((FavMediaGalleryUI.d(FavMediaGalleryUI.this)) && (FavMediaGalleryUI.e(FavMediaGalleryUI.this).ryV != 1)) {
            FavMediaGalleryUI.this.finish();
          }
          AppMethodBeat.o(107320);
        }
      });
      if (this.dBt) {
        this.iUH.setLongClickOverListener(new MMGestureGallery.c()
        {
          public final void aRq()
          {
            AppMethodBeat.i(107323);
            if ((!FavMediaGalleryUI.this.isFinishing()) && (!FavMediaGalleryUI.this.activityHasDestroyed()))
            {
              if (FavMediaGalleryUI.d(FavMediaGalleryUI.this))
              {
                if (FavMediaGalleryUI.e(FavMediaGalleryUI.this).ryV == 1)
                {
                  AppMethodBeat.o(107323);
                  return;
                }
                if ((FavMediaGalleryUI.e(FavMediaGalleryUI.this).ryV == 0) || (FavMediaGalleryUI.e(FavMediaGalleryUI.this).ryV == 2))
                {
                  FavMediaGalleryUI.a(FavMediaGalleryUI.this, com.tencent.mm.plugin.scanner.h.dKx());
                  AppMethodBeat.o(107323);
                  return;
                }
                FavMediaGalleryUI.f(FavMediaGalleryUI.this);
                AppMethodBeat.o(107323);
                return;
              }
              FavMediaGalleryUI.f(FavMediaGalleryUI.this);
            }
            AppMethodBeat.o(107323);
          }
        });
      }
      fullScreenNoTitleBar(true);
      this.jfg = new ArrayList();
      this.rBX = new a((byte)0);
      this.iUH.setAdapter(this.rBX);
      Zh();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(107324);
          FavMediaGalleryUI.this.finish();
          AppMethodBeat.o(107324);
          return true;
        }
      });
      com.tencent.mm.sdk.b.a.IbL.c(this.rwO);
      setResult(0, getIntent());
      this.rxx.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
      this.rxx.ooi = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
      this.rxx.index = getIntent().getIntExtra("key_detail_fav_index", 0);
      this.rxx.query = getIntent().getStringExtra("key_detail_fav_query");
      this.rxx.sessionId = getIntent().getStringExtra("key_detail_fav_sessionid");
      this.rxx.rsG = getIntent().getStringExtra("key_detail_fav_tags");
      localakf = this.rxx;
      if (this.rxx.query != null) {
        break label412;
      }
      paramBundle = "";
      label336:
      localakf.query = paramBundle;
      localakf = this.rxx;
      if (this.rxx.sessionId != null) {
        break label423;
      }
      paramBundle = "";
      label360:
      localakf.sessionId = paramBundle;
      localakf = this.rxx;
      if (this.rxx.rsG != null) {
        break label434;
      }
    }
    label412:
    label423:
    label434:
    for (paramBundle = "";; paramBundle = this.rxx.rsG)
    {
      localakf.rsG = paramBundle;
      AppMethodBeat.o(107342);
      return;
      getWindow().setFlags(1024, 1024);
      break;
      paramBundle = this.rxx.query;
      break label336;
      paramBundle = this.rxx.sessionId;
      break label360;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107345);
    getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs());
    com.tencent.mm.sdk.b.a.IbL.d(this.rwO);
    Iterator localIterator = this.rBZ.iterator();
    while (localIterator.hasNext())
    {
      FavVideoView localFavVideoView = (FavVideoView)localIterator.next();
      if (localFavVideoView != null) {
        localFavVideoView.onDestroy();
      }
    }
    if (this.rwM != null) {
      this.rwM.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(107345);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107349);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    this.rwG = paramInt;
    ad.d("MicroMsg.FavMediaGalleryUI", "pos:".concat(String.valueOf(paramInt)));
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).fyy();
    }
    if (this.rBW != null) {
      this.rBW.onDestroy();
    }
    if ((paramView instanceof FavVideoView))
    {
      paramAdapterView = (FavVideoView)paramView;
      if (((this.rBX.getItemViewType(paramInt) == 15) || (this.rBX.getItemViewType(paramInt) == 4)) && (paramAdapterView != null) && (!paramAdapterView.isPlaying()))
      {
        paramAdapterView.onResume();
        this.rBW = paramAdapterView;
        this.rBV = paramInt;
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(107349);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onPause()
  {
    AppMethodBeat.i(107347);
    super.onPause();
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b(this);
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    AppMethodBeat.o(107347);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107346);
    super.onResume();
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(this);
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    AppMethodBeat.o(107346);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    SparseBooleanArray rwX;
    
    private a()
    {
      AppMethodBeat.i(107332);
      this.rwX = new SparseBooleanArray();
      AppMethodBeat.o(107332);
    }
    
    private Bitmap a(com.tencent.mm.plugin.fav.ui.i parami)
    {
      AppMethodBeat.i(107338);
      if (parami != null)
      {
        parami = o.a(parami.dsC, parami.rwF);
        if (parami != null)
        {
          AppMethodBeat.o(107338);
          return parami;
        }
      }
      parami = com.tencent.mm.compatible.e.a.decodeResource(FavMediaGalleryUI.this.getResources(), 2131690066);
      AppMethodBeat.o(107338);
      return parami;
    }
    
    private void a(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(107337);
      paramb.progressBar.setVisibility(8);
      paramb.rxc.setVisibility(8);
      paramb.lta.setVisibility(8);
      paramb.rxa.setVisibility(0);
      paramb.rxd.setVisibility(8);
      b(paramb, paramBitmap, paramString);
      AppMethodBeat.o(107337);
    }
    
    private void b(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(107339);
      com.tencent.mm.sdk.platformtools.q.A(paramb.rxb, paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = paramb.rxb.getWidth();
      int j = paramb.rxb.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.reset();
      float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
      float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
      ad.v("MicroMsg.FavMediaGalleryUI", "whDiv is " + f1 + " hwDiv is " + f2);
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
        paramb.rxb.setImageMatrix(localMatrix);
        paramb.rxb.cH(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramb.rxb.setMaxZoomDoubleTab(true);
        if (!bt.isNullOrNil(paramString)) {
          break label524;
        }
        paramb.rxb.setImageBitmap(paramBitmap);
        AppMethodBeat.o(107339);
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
          ad.d("MicroMsg.FavMediaGalleryUI", " offsety ".concat(String.valueOf(f1)));
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
          paramb.rxb.setGifDrawable(paramString);
          paramb.rxb.jL(com.tencent.mm.cc.a.ip(FavMediaGalleryUI.this.getContext()), com.tencent.mm.cc.a.iq(FavMediaGalleryUI.this.getContext()));
          paramb.rxb.cH(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          paramb.rxb.start();
          paramb.rxb.fyz();
          AppMethodBeat.o(107339);
          return;
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.FavMediaGalleryUI", bt.n(paramString));
          paramb.rxb.setImageBitmap(paramBitmap);
          AppMethodBeat.o(107339);
          return;
        }
        label627:
        f1 = 1.0F;
      }
    }
    
    public final com.tencent.mm.plugin.fav.ui.i Ed(int paramInt)
    {
      AppMethodBeat.i(107335);
      if (paramInt >= FavMediaGalleryUI.l(FavMediaGalleryUI.this).size())
      {
        ad.w("MicroMsg.FavMediaGalleryUI", "get item fail, position %d error", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(107335);
        return null;
      }
      com.tencent.mm.plugin.fav.ui.i locali = (com.tencent.mm.plugin.fav.ui.i)FavMediaGalleryUI.l(FavMediaGalleryUI.this).get(paramInt);
      AppMethodBeat.o(107335);
      return locali;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(107334);
      int i = FavMediaGalleryUI.l(FavMediaGalleryUI.this).size();
      AppMethodBeat.o(107334);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(107333);
      if (paramInt > FavMediaGalleryUI.l(FavMediaGalleryUI.this).size())
      {
        AppMethodBeat.o(107333);
        return 2;
      }
      paramInt = ((com.tencent.mm.plugin.fav.ui.i)FavMediaGalleryUI.l(FavMediaGalleryUI.this).get(paramInt)).dsC.dataType;
      AppMethodBeat.o(107333);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(107336);
      com.tencent.mm.plugin.fav.ui.i locali = Ed(paramInt);
      if ((FavMediaGalleryUI.a(FavMediaGalleryUI.this) != paramInt) && (Math.abs(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - paramInt) > 1))
      {
        ad.i("MicroMsg.FavMediaGalleryUI", "getView not selected, " + FavMediaGalleryUI.a(FavMediaGalleryUI.this) + ", " + paramInt);
        paramViewGroup = paramView;
        if (paramView == null)
        {
          if ((locali.dsC.dataType != 15) && (locali.dsC.dataType != 4)) {
            break label132;
          }
          paramViewGroup = new FavVideoView(FavMediaGalleryUI.this.getContext());
        }
        for (;;)
        {
          AppMethodBeat.o(107336);
          return paramViewGroup;
          label132:
          paramView = new FavMediaGalleryUI.b(FavMediaGalleryUI.this, (byte)0);
          paramViewGroup = View.inflate(FavMediaGalleryUI.this.getContext(), 2131493952, null);
          paramView.rxa = paramViewGroup.findViewById(2131300933);
          paramView.rxb = ((MultiTouchImageView)paramViewGroup.findViewById(2131300914));
          paramView.progressBar = ((ProgressBar)paramViewGroup.findViewById(2131299229));
          paramView.lta = ((ImageView)paramViewGroup.findViewById(2131305798));
          paramView.rxc = ((TextView)paramViewGroup.findViewById(2131299230));
          paramView.rxd = ((LinearLayout)paramViewGroup.findViewById(2131299788));
          paramView.rxe = ((TextView)paramViewGroup.findViewById(2131299789));
          paramView.rxe.setText(2131758860);
          paramViewGroup.setTag(paramView);
        }
      }
      if ((locali.dsC.dataType == 15) || (locali.dsC.dataType == 4))
      {
        if (paramView != null) {
          break label1490;
        }
        paramView = new FavVideoView(FavMediaGalleryUI.this.getContext());
        FavMediaGalleryUI.m(FavMediaGalleryUI.this).add((FavVideoView)paramView);
      }
      label1069:
      label1204:
      label1490:
      for (;;)
      {
        Object localObject1 = com.tencent.mm.plugin.fav.a.b.d(locali.dsC);
        paramViewGroup = (List)FavMediaGalleryUI.c(FavMediaGalleryUI.this).get(localObject1);
        if (paramViewGroup == null) {
          paramViewGroup = new ArrayList();
        }
        for (;;)
        {
          paramViewGroup.add((FavVideoView)paramView);
          FavMediaGalleryUI.c(FavMediaGalleryUI.this).put(localObject1, paramViewGroup);
          paramViewGroup = (FavVideoView)paramView;
          paramViewGroup.rBq.setVisibility(8);
          paramViewGroup.setCallback(new FavVideoView.b()
          {
            public final void finish()
            {
              AppMethodBeat.i(107331);
              FavMediaGalleryUI.this.finish();
              AppMethodBeat.o(107331);
            }
          });
          if (com.tencent.mm.vfs.i.fv((String)localObject1))
          {
            paramViewGroup.setVideoData((String)localObject1);
            localObject1 = com.tencent.mm.plugin.fav.a.b.a(locali.dsC);
            if (!com.tencent.mm.vfs.i.fv((String)localObject1)) {
              break label615;
            }
            paramViewGroup.setThumbView((String)localObject1);
          }
          Object localObject2;
          for (;;)
          {
            AppMethodBeat.o(107336);
            return paramView;
            localObject2 = locali.dsC.dsU;
            com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv((String)localObject2);
            if ((localc != null) && (localc.field_status == 1)) {
              break;
            }
            if ((!bt.isNullOrNil(locali.dsC.GgR)) && (!bt.isNullOrNil(locali.dsC.GgT)))
            {
              ad.d("MicroMsg.FavMediaGalleryUI", "getView, no video, start download, dataId:%s", new Object[] { localObject2 });
              com.tencent.mm.plugin.fav.a.b.a(locali.rwF, locali.dsC, true);
              paramViewGroup.c((String)localObject1, true, (String)localObject2);
              break;
            }
            ad.d("MicroMsg.FavMediaGalleryUI", "getView, no video, cdn data invalid");
            paramViewGroup.c((String)localObject1, false, (String)localObject2);
            paramViewGroup.rBq.setVisibility(0);
            break;
            label615:
            ad.i("MicroMsg.FavMediaGalleryUI", "getView, no thumb, start download, path:%s", new Object[] { localObject1 });
            com.tencent.mm.plugin.fav.a.b.a(locali.rwF, locali.dsC);
          }
          if (paramView == null)
          {
            paramViewGroup = new FavMediaGalleryUI.b(FavMediaGalleryUI.this, (byte)0);
            paramView = View.inflate(FavMediaGalleryUI.this.getContext(), 2131493952, null);
            paramViewGroup.rxa = paramView.findViewById(2131300933);
            paramViewGroup.rxb = ((MultiTouchImageView)paramView.findViewById(2131300914));
            paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(2131299229));
            paramViewGroup.lta = ((ImageView)paramView.findViewById(2131305798));
            paramViewGroup.rxc = ((TextView)paramView.findViewById(2131299230));
            paramViewGroup.rxd = ((LinearLayout)paramView.findViewById(2131299788));
            paramViewGroup.rxe = ((TextView)paramView.findViewById(2131299789));
            paramViewGroup.rxe.setText(2131758860);
            paramView.setTag(paramViewGroup);
            paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            boolean bool = this.rwX.get(paramInt, true);
            this.rwX.put(paramInt, false);
            localObject1 = o.a(locali.dsC, locali.rwF, bool);
            if (locali.rwF != null) {
              ad.i("MicroMsg.FavMediaGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locali.rwF.field_id), Long.valueOf(locali.rwF.field_localId), Integer.valueOf(locali.rwF.field_itemStatus) });
            }
            if (locali.dsC != null) {
              ad.i("MicroMsg.FavMediaGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { locali.dsC.dsU, locali.dsC.GgR, locali.dsC.GgT, Long.valueOf(locali.dsC.Ghm), locali.dsC.hAe, locali.dsC.GgN, Long.valueOf(locali.dsC.Ghx) });
            }
            if (localObject1 != null) {
              break label1429;
            }
            FavMediaGalleryUI.this.enableOptionMenu(false);
            ad.w("MicroMsg.FavMediaGalleryUI", "get big image fail");
            localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage();
            if (locali.dsC == null) {
              break label1196;
            }
            localObject1 = locali.dsC.dsU;
            localObject1 = ((com.tencent.mm.plugin.fav.a.q)localObject2).agv((String)localObject1);
            if (localObject1 != null) {
              break label1275;
            }
            paramViewGroup.rxd.setVisibility(8);
            if ((locali.rwF == null) || (locali.rwF.field_id >= 0)) {
              break label1204;
            }
            paramViewGroup.progressBar.setVisibility(0);
            paramViewGroup.rxc.setVisibility(0);
            paramViewGroup.lta.setVisibility(0);
            paramViewGroup.rxa.setVisibility(8);
            paramViewGroup.lta.setImageBitmap(a(locali));
            paramViewGroup.progressBar.setProgress(0);
            paramViewGroup.rxc.setText("0%");
          }
          for (;;)
          {
            AppMethodBeat.o(107336);
            return paramView;
            paramViewGroup = (FavMediaGalleryUI.b)paramView.getTag();
            break;
            localObject1 = "";
            break label1069;
            paramViewGroup.progressBar.setVisibility(8);
            paramViewGroup.rxc.setVisibility(8);
            paramViewGroup.lta.setVisibility(8);
            paramViewGroup.rxa.setVisibility(0);
            if (locali.dsC.GhZ != 0) {
              paramViewGroup.rxd.setVisibility(0);
            }
            b(paramViewGroup, a(locali), "");
          }
          label1275:
          ad.i("MicroMsg.FavMediaGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_status) });
          paramViewGroup.progressBar.setVisibility(0);
          paramViewGroup.rxc.setVisibility(0);
          paramViewGroup.lta.setVisibility(0);
          paramViewGroup.rxa.setVisibility(8);
          paramViewGroup.lta.setImageBitmap(a(locali));
          if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen > 0) {}
          for (paramInt = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_offset * 100 / ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen - 1;; paramInt = 0)
          {
            int i = paramInt;
            if (paramInt < 0) {
              i = 0;
            }
            paramViewGroup.progressBar.setProgress(i);
            paramViewGroup.rxc.setText(i + "%");
            AppMethodBeat.o(107336);
            return paramView;
          }
          FavMediaGalleryUI.this.enableOptionMenu(true);
          if (t.aQj(com.tencent.mm.plugin.fav.a.b.d(locali.dsC))) {
            a(paramViewGroup, (Bitmap)localObject1, com.tencent.mm.plugin.fav.a.b.d(locali.dsC));
          }
          for (;;)
          {
            AppMethodBeat.o(107336);
            return paramView;
            a(paramViewGroup, (Bitmap)localObject1, "");
          }
        }
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
  }
  
  final class b
  {
    ImageView lta;
    ProgressBar progressBar;
    View rxa;
    MultiTouchImageView rxb;
    TextView rxc;
    LinearLayout rxd;
    TextView rxe;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI
 * JD-Core Version:    0.7.0.1
 */