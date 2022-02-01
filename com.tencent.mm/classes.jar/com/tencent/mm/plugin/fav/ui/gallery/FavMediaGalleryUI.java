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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.qf.a;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.r.a;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
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
  private boolean dCy;
  private MMGestureGallery iXA;
  private ArrayList<com.tencent.mm.plugin.fav.ui.i> jhZ;
  private n.e pSA;
  private int rES;
  private Map<String, qf> rEW;
  private boolean rEX;
  private com.tencent.mm.plugin.fav.ui.r rEY;
  private long rEZ;
  akp rFI;
  private com.tencent.mm.sdk.b.c rFa;
  private int rKg;
  private FavVideoView rKh;
  private a rKi;
  private e rKj;
  private List<FavVideoView> rKk;
  private HashMap<String, List<View>> rKl;
  
  public FavMediaGalleryUI()
  {
    AppMethodBeat.i(107341);
    this.rES = 0;
    this.rKg = -1;
    this.rKh = null;
    this.dCy = true;
    this.rKk = new ArrayList();
    this.rKl = new HashMap();
    this.rFI = new akp();
    this.rEW = new HashMap();
    this.pSA = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(107327);
        Object localObject1 = FavMediaGalleryUI.b(FavMediaGalleryUI.this).Eq(FavMediaGalleryUI.a(FavMediaGalleryUI.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(107327);
          return;
        }
        Object localObject2 = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI);
        if ((!com.tencent.mm.vfs.o.fB((String)localObject2)) && (paramAnonymousMenuItem.getItemId() != 4))
        {
          ae.w("MicroMsg.FavMediaGalleryUI", "file not exists");
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
          if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI.dataType == 2)
          {
            if (u.aRG((String)localObject2))
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymousMenuItem.putExtra("select_is_ret", true);
              com.tencent.mm.br.d.c(FavMediaGalleryUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 1);
              AppMethodBeat.o(107327);
              return;
            }
            com.tencent.mm.plugin.fav.a.b.a((String)localObject2, FavMediaGalleryUI.this, ((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI.ixk);
            AppMethodBeat.o(107327);
            return;
          }
          paramAnonymousMenuItem = com.tencent.mm.plugin.fav.a.b.a(((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI);
          localObject1 = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
          if (com.tencent.mm.vfs.o.fB(paramAnonymousMenuItem)) {
            ((Intent)localObject2).putExtra("image_path", paramAnonymousMenuItem);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("Retr_Msg_Type", 1);
            com.tencent.mm.br.d.c(FavMediaGalleryUI.this.getContext(), ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1);
            AppMethodBeat.o(107327);
            return;
            ((Intent)localObject2).putExtra("image_path", (String)localObject1);
          }
          com.tencent.mm.plugin.fav.a.b.b((String)localObject2, FavMediaGalleryUI.this);
          com.tencent.mm.plugin.fav.a.h.i(FavMediaGalleryUI.h(FavMediaGalleryUI.this), 0, 0);
          AppMethodBeat.o(107327);
          return;
          if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI.dataType == 2)
          {
            FavMediaGalleryUI.a(FavMediaGalleryUI.this, (String)localObject2);
            AppMethodBeat.o(107327);
            return;
          }
          FavMediaGalleryUI.b(FavMediaGalleryUI.this, (String)localObject2);
          AppMethodBeat.o(107327);
          return;
          localObject2 = (qf)FavMediaGalleryUI.i(FavMediaGalleryUI.this).get(localObject2);
          if (localObject2 != null)
          {
            paramAnonymousMenuItem = new co();
            paramAnonymousMenuItem.dou.activity = FavMediaGalleryUI.this;
            paramAnonymousMenuItem.dou.dmI = ((qf)localObject2).dFM.result;
            paramAnonymousMenuItem.dou.dov = ((qf)localObject2).dFM.dov;
            paramAnonymousMenuItem.dou.sourceType = 7;
            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI != null))
            {
              paramAnonymousMenuItem.dou.imagePath = ((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI.GzA;
              paramAnonymousMenuItem.dou.doy = ((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI.GzC;
            }
            paramAnonymousMenuItem.dou.dow = ((qf)localObject2).dFM.dow;
            localObject1 = new Bundle(1);
            ((Bundle)localObject1).putInt("stat_scene", 5);
            paramAnonymousMenuItem.dou.doz = ((Bundle)localObject1);
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
            AppMethodBeat.o(107327);
            return;
            FavMediaGalleryUI.this.rFI.index = (FavMediaGalleryUI.b(FavMediaGalleryUI.this).getCount() - FavMediaGalleryUI.a(FavMediaGalleryUI.this));
            ((y)com.tencent.mm.kernel.g.ab(y.class)).a(FavMediaGalleryUI.this.getContext(), ((com.tencent.mm.plugin.fav.ui.i)localObject1).rER, FavMediaGalleryUI.this.rFI);
            FavMediaGalleryUI.this.finish();
            AppMethodBeat.o(107327);
            return;
            FavMediaGalleryUI.e(FavMediaGalleryUI.this).cyb();
            AppMethodBeat.o(107327);
            return;
            FavMediaGalleryUI.j(FavMediaGalleryUI.this);
          }
        }
      }
    };
    this.rFa = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(107341);
  }
  
  private void Zq()
  {
    AppMethodBeat.i(107344);
    Object localObject1 = getIntent().getLongArrayExtra("KEY_MEDIA_FAVID_LIST");
    ArrayList localArrayList = new ArrayList();
    String str = getIntent().getStringExtra("key_detail_data_id");
    this.rEZ = getIntent().getLongExtra("key_detail_info_id", -1L);
    Object localObject2;
    long l;
    boolean bool1;
    if (localObject1 == null)
    {
      boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
      localObject2 = getIntent().getStringExtra("fav_note_xml");
      localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(this.rEZ);
      l = this.rEZ;
      if (localObject1 != null)
      {
        bool1 = true;
        ae.i("MicroMsg.FavMediaGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
        if ((!bool2) || (bu.isNullOrNil((String)localObject2))) {
          break label594;
        }
        localObject1 = com.tencent.mm.plugin.fav.a.b.ahg((String)localObject2);
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
      this.jhZ.clear();
      final int i = -1;
      int m = localArrayList.size();
      int k = 0;
      int j;
      if (k < m)
      {
        localObject1 = (com.tencent.mm.plugin.fav.a.g)localArrayList.get(k);
        int n = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.oeJ.size();
        j = 0;
        label234:
        if (j < n)
        {
          localObject2 = (ajx)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.oeJ.get(j);
          if (((((ajx)localObject2).dataType == 8) && (!u.aRG(com.tencent.mm.plugin.fav.a.b.d((ajx)localObject2)))) || ((((ajx)localObject2).dataType != 2) && (((ajx)localObject2).dataType != 4) && (((ajx)localObject2).dataType != 15) && (((ajx)localObject2).dataType != 8))) {
            break label591;
          }
          com.tencent.mm.plugin.fav.ui.i locali = new com.tencent.mm.plugin.fav.ui.i((com.tencent.mm.plugin.fav.a.g)localObject1, (ajx)localObject2);
          this.jhZ.add(locali);
          if ((str == null) || (!str.equals(((ajx)localObject2).dua)) || (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId != this.rEZ)) {
            break label591;
          }
          i = this.jhZ.size() - 1;
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
          localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(l);
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
          if (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId == this.rEZ) {
            j = this.jhZ.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label200;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.rKi.notifyDataSetChanged();
        if (i >= 0)
        {
          ae.i("MicroMsg.FavMediaGalleryUI", "pre match selection %d", new Object[] { Integer.valueOf(i) });
          this.iXA.setSelection(i);
          this.rES = i;
        }
        this.iXA.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107329);
            if (i != -1)
            {
              ae.d("MicroMsg.FavMediaGalleryUI", "match selection %d", new Object[] { Integer.valueOf(i) });
              FavMediaGalleryUI.k(FavMediaGalleryUI.this).setSelection(i);
              FavMediaGalleryUI.a(FavMediaGalleryUI.this, i);
              AppMethodBeat.o(107329);
              return;
            }
            if ((FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1 >= 0) && (FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1 < FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()))
            {
              ae.d("MicroMsg.FavMediaGalleryUI", "adjust selection %d, list size %d", new Object[] { Integer.valueOf(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1), Integer.valueOf(FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()) });
              FavMediaGalleryUI.k(FavMediaGalleryUI.this).setSelection(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1);
              FavMediaGalleryUI.a(FavMediaGalleryUI.this, FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1);
              AppMethodBeat.o(107329);
              return;
            }
            if (FavMediaGalleryUI.l(FavMediaGalleryUI.this).size() > 0)
            {
              ae.d("MicroMsg.FavMediaGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[] { Integer.valueOf(FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()) });
              FavMediaGalleryUI.k(FavMediaGalleryUI.this).setSelection(0);
              FavMediaGalleryUI.a(FavMediaGalleryUI.this, 0);
              AppMethodBeat.o(107329);
              return;
            }
            ae.w("MicroMsg.FavMediaGalleryUI", "data list size %d, empty, finish", new Object[] { Integer.valueOf(FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()) });
            FavMediaGalleryUI.this.finish();
            AppMethodBeat.o(107329);
          }
        });
        AppMethodBeat.o(107344);
        return;
      }
    }
  }
  
  private void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(107343);
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = this.rKi.Eq(this.rES);
    if (localObject1 == null)
    {
      AppMethodBeat.o(107343);
      return;
    }
    if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI.GAI != 0) {
      ae.i("MicroMsg.FavMediaGalleryUI", "showMenu, illegalType");
    }
    for (;;)
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(2131758910));
      if (this.rKj == null) {
        this.rKj = new e(getContext(), 1, false);
      }
      this.rKj.LfS = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(107325);
          paramAnonymousl.clear();
          paramAnonymousl.setHeaderTitle("");
          int i = 0;
          while (i < localArrayList1.size())
          {
            paramAnonymousl.d(((Integer)localArrayList1.get(i)).intValue(), (CharSequence)localArrayList2.get(i));
            i += 1;
          }
          AppMethodBeat.o(107325);
        }
      };
      this.rKj.LfT = this.pSA;
      this.rKj.KtV = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(107326);
          FavMediaGalleryUI.g(FavMediaGalleryUI.this);
          AppMethodBeat.o(107326);
        }
      };
      this.rKj.cPF();
      AppMethodBeat.o(107343);
      return;
      if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI.dataType == 2)
      {
        if ((((com.tencent.mm.plugin.fav.ui.i)localObject1).rER != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).rER.cwr()))
        {
          localArrayList1.add(Integer.valueOf(0));
          localArrayList2.add(getString(2131759001));
        }
        if ((((com.tencent.mm.plugin.fav.ui.i)localObject1).rER != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).rER.cws()))
        {
          localArrayList1.add(Integer.valueOf(1));
          localArrayList2.add(getString(2131758951));
        }
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2.add(getString(2131758994));
        localObject1 = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI);
        Object localObject2 = (qf)this.rEW.get(localObject1);
        if (localObject2 != null) {
          if (!bu.isNullOrNil(((qf)localObject2).dFM.result))
          {
            localArrayList1.add(Integer.valueOf(3));
            if (!com.tencent.mm.plugin.scanner.g.bM(((qf)localObject2).dFM.dov, ((qf)localObject2).dFM.result)) {
              break label495;
            }
            localArrayList2.add(getString(2131758961));
          }
        }
        for (;;)
        {
          if ((this.rEX) && (!bu.isNullOrNil((String)localObject1)))
          {
            localArrayList1.add(Integer.valueOf(5));
            localArrayList2.add(getString(2131757184));
          }
          localArrayList1.add(Integer.valueOf(6));
          localArrayList2.add(getString(2131757183));
          if (bu.isNullOrNil((String)localObject1)) {
            break;
          }
          com.tencent.mm.kernel.g.ajS();
          if ((com.tencent.mm.kernel.g.ajQ().gDv.aFd() == 0) || (!paramBoolean)) {
            break;
          }
          this.rEY.scan((String)localObject1);
          break;
          label495:
          if (com.tencent.mm.plugin.scanner.g.bN(((qf)localObject2).dFM.dov, ((qf)localObject2).dFM.result))
          {
            localArrayList2.add(getString(2131758958));
          }
          else
          {
            localArrayList2.add(getString(2131758960));
            continue;
            localObject2 = new qd();
            ((qd)localObject2).dFH.dmK = System.currentTimeMillis();
            ((qd)localObject2).dFH.filePath = ((String)localObject1);
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
      }
      if (com.tencent.mm.vfs.o.fB(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dtI)))
      {
        if ((((com.tencent.mm.plugin.fav.ui.i)localObject1).rER != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).rER.cwr()))
        {
          localArrayList1.add(Integer.valueOf(0));
          localArrayList2.add(getString(2131759001));
        }
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2.add(getString(2131762784));
      }
    }
  }
  
  public final String cxR()
  {
    AppMethodBeat.i(107348);
    Object localObject = this.rKi.Eq(this.rES);
    if (localObject == null)
    {
      AppMethodBeat.o(107348);
      return "";
    }
    if (((com.tencent.mm.plugin.fav.ui.i)localObject).dtI.dataType == 2)
    {
      localObject = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject).dtI);
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
      com.tencent.mm.plugin.fav.ui.i locali = this.rKi.Eq(this.rES);
      if ((locali != null) && (bu.bI(paramc.field_dataId, "").equals(locali.dtI.dua)) && (locali.dtI.dataType == 2)) {
        ar.f(new Runnable()
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
              ((FavMediaGalleryUI.b)localObject).rFo.setText(i + "%");
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
      com.tencent.mm.plugin.fav.ui.i locali = this.rKi.Eq(this.rES);
      if (locali == null)
      {
        ae.i("MicroMsg.FavMediaGalleryUI", "dataItem is null.");
        AppMethodBeat.o(107351);
        return;
      }
      String str = com.tencent.mm.plugin.fav.a.b.d(locali.dtI);
      new k();
      if (k.v(locali.rER))
      {
        com.tencent.mm.ui.base.h.cm(getContext(), getString(2131755010));
        AppMethodBeat.o(107351);
        return;
      }
      Object localObject2 = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject1 = bu.U(((String)localObject2).split(","));
      ae.d("MicroMsg.FavMediaGalleryUI", "select %s for sending", new Object[] { localObject2 });
      localObject2 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
      if (u.aRG(str))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          com.tencent.mm.plugin.fav.ui.l.a(getContext(), str, locali.rER, locali.dtI, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107321);
              this.rDo.dismiss();
              AppMethodBeat.o(107321);
            }
          });
        }
      }
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191074);
          this.rDo.dismiss();
          AppMethodBeat.o(191074);
        }
      };
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        com.tencent.mm.plugin.fav.ui.l.a(this, (String)((Iterator)localObject1).next(), locali.dtI, (Runnable)localObject2);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107351);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107342);
    super.onCreate(paramBundle);
    akp localakp;
    if (com.tencent.mm.compatible.util.d.lA(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.rEY = new com.tencent.mm.plugin.fav.ui.r(this, this, this);
      this.dCy = getIntent().getBooleanExtra("show_share", true);
      this.iXA = ((MMGestureGallery)findViewById(2131300335));
      this.iXA.setVerticalFadingEdgeEnabled(false);
      this.iXA.setHorizontalFadingEdgeEnabled(false);
      this.iXA.setOnItemSelectedListener(this);
      this.iXA.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void aRO()
        {
          AppMethodBeat.i(107320);
          Object localObject = FavMediaGalleryUI.b(FavMediaGalleryUI.this).Eq(FavMediaGalleryUI.a(FavMediaGalleryUI.this));
          if ((localObject != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject).dtI.GAI == 0) && (((com.tencent.mm.plugin.fav.ui.i)localObject).dtI.dataType != 2) && (com.tencent.mm.vfs.o.fB(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject).dtI))))
          {
            localObject = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject).dtI);
            localObject = (List)FavMediaGalleryUI.c(FavMediaGalleryUI.this).get(localObject);
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                View localView = (View)((Iterator)localObject).next();
                if ((localView instanceof FavVideoView)) {
                  ((FavVideoView)localView).cyR();
                }
              }
              AppMethodBeat.o(107320);
              return;
            }
          }
          if ((FavMediaGalleryUI.d(FavMediaGalleryUI.this)) && (FavMediaGalleryUI.e(FavMediaGalleryUI.this).rHg != 1)) {
            FavMediaGalleryUI.this.finish();
          }
          AppMethodBeat.o(107320);
        }
      });
      if (this.dCy) {
        this.iXA.setLongClickOverListener(new MMGestureGallery.c()
        {
          public final void aRP()
          {
            AppMethodBeat.i(107323);
            if ((!FavMediaGalleryUI.this.isFinishing()) && (!FavMediaGalleryUI.this.activityHasDestroyed()))
            {
              if (FavMediaGalleryUI.d(FavMediaGalleryUI.this))
              {
                if (FavMediaGalleryUI.e(FavMediaGalleryUI.this).rHg == 1)
                {
                  AppMethodBeat.o(107323);
                  return;
                }
                if ((FavMediaGalleryUI.e(FavMediaGalleryUI.this).rHg == 0) || (FavMediaGalleryUI.e(FavMediaGalleryUI.this).rHg == 2))
                {
                  FavMediaGalleryUI.a(FavMediaGalleryUI.this, com.tencent.mm.plugin.scanner.i.dNP());
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
      this.jhZ = new ArrayList();
      this.rKi = new a((byte)0);
      this.iXA.setAdapter(this.rKi);
      Zq();
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
      com.tencent.mm.sdk.b.a.IvT.c(this.rFa);
      setResult(0, getIntent());
      this.rFI.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
      this.rFI.otZ = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
      this.rFI.index = getIntent().getIntExtra("key_detail_fav_index", 0);
      this.rFI.query = getIntent().getStringExtra("key_detail_fav_query");
      this.rFI.sessionId = getIntent().getStringExtra("key_detail_fav_sessionid");
      this.rFI.rAT = getIntent().getStringExtra("key_detail_fav_tags");
      localakp = this.rFI;
      if (this.rFI.query != null) {
        break label412;
      }
      paramBundle = "";
      label336:
      localakp.query = paramBundle;
      localakp = this.rFI;
      if (this.rFI.sessionId != null) {
        break label423;
      }
      paramBundle = "";
      label360:
      localakp.sessionId = paramBundle;
      localakp = this.rFI;
      if (this.rFI.rAT != null) {
        break label434;
      }
    }
    label412:
    label423:
    label434:
    for (paramBundle = "";; paramBundle = this.rFI.rAT)
    {
      localakp.rAT = paramBundle;
      AppMethodBeat.o(107342);
      return;
      getWindow().setFlags(1024, 1024);
      break;
      paramBundle = this.rFI.query;
      break label336;
      paramBundle = this.rFI.sessionId;
      break label360;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107345);
    getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs());
    com.tencent.mm.sdk.b.a.IvT.d(this.rFa);
    Iterator localIterator = this.rKk.iterator();
    while (localIterator.hasNext())
    {
      FavVideoView localFavVideoView = (FavVideoView)localIterator.next();
      if (localFavVideoView != null) {
        localFavVideoView.onDestroy();
      }
    }
    if (this.rEY != null) {
      this.rEY.onDestroy();
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
    localb.mu(paramInt);
    localb.rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    this.rES = paramInt;
    ae.d("MicroMsg.FavMediaGalleryUI", "pos:".concat(String.valueOf(paramInt)));
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).fCA();
    }
    if (this.rKh != null) {
      this.rKh.onDestroy();
    }
    if ((paramView instanceof FavVideoView))
    {
      paramAdapterView = (FavVideoView)paramView;
      if (((this.rKi.getItemViewType(paramInt) == 15) || (this.rKi.getItemViewType(paramInt) == 4)) && (paramAdapterView != null) && (!paramAdapterView.isPlaying()))
      {
        paramAdapterView.onResume();
        this.rKh = paramAdapterView;
        this.rKg = paramInt;
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
    f.e(false, true, true);
    AppMethodBeat.o(107347);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107346);
    super.onResume();
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(this);
    f.e(true, true, true);
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
    SparseBooleanArray rFj;
    
    private a()
    {
      AppMethodBeat.i(107332);
      this.rFj = new SparseBooleanArray();
      AppMethodBeat.o(107332);
    }
    
    private Bitmap a(com.tencent.mm.plugin.fav.ui.i parami)
    {
      AppMethodBeat.i(107338);
      if (parami != null)
      {
        parami = com.tencent.mm.plugin.fav.ui.o.a(parami.dtI, parami.rER);
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
      paramb.rFo.setVisibility(8);
      paramb.lxz.setVisibility(8);
      paramb.rFm.setVisibility(0);
      paramb.rFp.setVisibility(8);
      b(paramb, paramBitmap, paramString);
      AppMethodBeat.o(107337);
    }
    
    private void b(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(107339);
      com.tencent.mm.sdk.platformtools.r.z(paramb.rFn, paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = paramb.rFn.getWidth();
      int j = paramb.rFn.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.reset();
      float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
      float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
      ae.v("MicroMsg.FavMediaGalleryUI", "whDiv is " + f1 + " hwDiv is " + f2);
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
        paramb.rFn.setImageMatrix(localMatrix);
        paramb.rFn.cH(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramb.rFn.setMaxZoomDoubleTab(true);
        if (!bu.isNullOrNil(paramString)) {
          break label524;
        }
        paramb.rFn.setImageBitmap(paramBitmap);
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
          ae.d("MicroMsg.FavMediaGalleryUI", " offsety ".concat(String.valueOf(f1)));
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
          paramb.rFn.setGifDrawable(paramString);
          paramb.rFn.jP(com.tencent.mm.cb.a.iu(FavMediaGalleryUI.this.getContext()), com.tencent.mm.cb.a.iv(FavMediaGalleryUI.this.getContext()));
          paramb.rFn.cH(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          paramb.rFn.start();
          paramb.rFn.fCB();
          AppMethodBeat.o(107339);
          return;
        }
        catch (Exception paramString)
        {
          ae.e("MicroMsg.FavMediaGalleryUI", bu.o(paramString));
          paramb.rFn.setImageBitmap(paramBitmap);
          AppMethodBeat.o(107339);
          return;
        }
        label627:
        f1 = 1.0F;
      }
    }
    
    public final com.tencent.mm.plugin.fav.ui.i Eq(int paramInt)
    {
      AppMethodBeat.i(107335);
      if (paramInt >= FavMediaGalleryUI.l(FavMediaGalleryUI.this).size())
      {
        ae.w("MicroMsg.FavMediaGalleryUI", "get item fail, position %d error", new Object[] { Integer.valueOf(paramInt) });
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
      paramInt = ((com.tencent.mm.plugin.fav.ui.i)FavMediaGalleryUI.l(FavMediaGalleryUI.this).get(paramInt)).dtI.dataType;
      AppMethodBeat.o(107333);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(107336);
      com.tencent.mm.plugin.fav.ui.i locali = Eq(paramInt);
      if ((FavMediaGalleryUI.a(FavMediaGalleryUI.this) != paramInt) && (Math.abs(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - paramInt) > 1))
      {
        ae.i("MicroMsg.FavMediaGalleryUI", "getView not selected, " + FavMediaGalleryUI.a(FavMediaGalleryUI.this) + ", " + paramInt);
        paramViewGroup = paramView;
        if (paramView == null)
        {
          if ((locali.dtI.dataType != 15) && (locali.dtI.dataType != 4)) {
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
          paramView.rFm = paramViewGroup.findViewById(2131300933);
          paramView.rFn = ((MultiTouchImageView)paramViewGroup.findViewById(2131300914));
          paramView.progressBar = ((ProgressBar)paramViewGroup.findViewById(2131299229));
          paramView.lxz = ((ImageView)paramViewGroup.findViewById(2131305798));
          paramView.rFo = ((TextView)paramViewGroup.findViewById(2131299230));
          paramView.rFp = ((LinearLayout)paramViewGroup.findViewById(2131299788));
          paramView.rFq = ((TextView)paramViewGroup.findViewById(2131299789));
          paramView.rFq.setText(2131758860);
          paramViewGroup.setTag(paramView);
        }
      }
      if ((locali.dtI.dataType == 15) || (locali.dtI.dataType == 4))
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
        Object localObject1 = com.tencent.mm.plugin.fav.a.b.d(locali.dtI);
        paramViewGroup = (List)FavMediaGalleryUI.c(FavMediaGalleryUI.this).get(localObject1);
        if (paramViewGroup == null) {
          paramViewGroup = new ArrayList();
        }
        for (;;)
        {
          paramViewGroup.add((FavVideoView)paramView);
          FavMediaGalleryUI.c(FavMediaGalleryUI.this).put(localObject1, paramViewGroup);
          paramViewGroup = (FavVideoView)paramView;
          paramViewGroup.rJB.setVisibility(8);
          paramViewGroup.setCallback(new FavVideoView.b()
          {
            public final void finish()
            {
              AppMethodBeat.i(107331);
              FavMediaGalleryUI.this.finish();
              AppMethodBeat.o(107331);
            }
          });
          if (com.tencent.mm.vfs.o.fB((String)localObject1))
          {
            paramViewGroup.setVideoData((String)localObject1);
            localObject1 = com.tencent.mm.plugin.fav.a.b.a(locali.dtI);
            if (!com.tencent.mm.vfs.o.fB((String)localObject1)) {
              break label615;
            }
            paramViewGroup.setThumbView((String)localObject1);
          }
          Object localObject2;
          for (;;)
          {
            AppMethodBeat.o(107336);
            return paramView;
            localObject2 = locali.dtI.dua;
            com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs((String)localObject2);
            if ((localc != null) && (localc.field_status == 1)) {
              break;
            }
            if ((!bu.isNullOrNil(locali.dtI.GzA)) && (!bu.isNullOrNil(locali.dtI.GzC)))
            {
              ae.d("MicroMsg.FavMediaGalleryUI", "getView, no video, start download, dataId:%s", new Object[] { localObject2 });
              com.tencent.mm.plugin.fav.a.b.a(locali.rER, locali.dtI, true);
              paramViewGroup.c((String)localObject1, true, (String)localObject2);
              break;
            }
            ae.d("MicroMsg.FavMediaGalleryUI", "getView, no video, cdn data invalid");
            paramViewGroup.c((String)localObject1, false, (String)localObject2);
            paramViewGroup.rJB.setVisibility(0);
            break;
            label615:
            ae.i("MicroMsg.FavMediaGalleryUI", "getView, no thumb, start download, path:%s", new Object[] { localObject1 });
            com.tencent.mm.plugin.fav.a.b.a(locali.rER, locali.dtI);
          }
          if (paramView == null)
          {
            paramViewGroup = new FavMediaGalleryUI.b(FavMediaGalleryUI.this, (byte)0);
            paramView = View.inflate(FavMediaGalleryUI.this.getContext(), 2131493952, null);
            paramViewGroup.rFm = paramView.findViewById(2131300933);
            paramViewGroup.rFn = ((MultiTouchImageView)paramView.findViewById(2131300914));
            paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(2131299229));
            paramViewGroup.lxz = ((ImageView)paramView.findViewById(2131305798));
            paramViewGroup.rFo = ((TextView)paramView.findViewById(2131299230));
            paramViewGroup.rFp = ((LinearLayout)paramView.findViewById(2131299788));
            paramViewGroup.rFq = ((TextView)paramView.findViewById(2131299789));
            paramViewGroup.rFq.setText(2131758860);
            paramView.setTag(paramViewGroup);
            paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            boolean bool = this.rFj.get(paramInt, true);
            this.rFj.put(paramInt, false);
            localObject1 = com.tencent.mm.plugin.fav.ui.o.a(locali.dtI, locali.rER, bool);
            if (locali.rER != null) {
              ae.i("MicroMsg.FavMediaGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locali.rER.field_id), Long.valueOf(locali.rER.field_localId), Integer.valueOf(locali.rER.field_itemStatus) });
            }
            if (locali.dtI != null) {
              ae.i("MicroMsg.FavMediaGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { locali.dtI.dua, locali.dtI.GzA, locali.dtI.GzC, Long.valueOf(locali.dtI.GzV), locali.dtI.hCS, locali.dtI.Gzw, Long.valueOf(locali.dtI.GAg) });
            }
            if (localObject1 != null) {
              break label1429;
            }
            FavMediaGalleryUI.this.enableOptionMenu(false);
            ae.w("MicroMsg.FavMediaGalleryUI", "get big image fail");
            localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage();
            if (locali.dtI == null) {
              break label1196;
            }
            localObject1 = locali.dtI.dua;
            localObject1 = ((com.tencent.mm.plugin.fav.a.q)localObject2).ahs((String)localObject1);
            if (localObject1 != null) {
              break label1275;
            }
            paramViewGroup.rFp.setVisibility(8);
            if ((locali.rER == null) || (locali.rER.field_id >= 0)) {
              break label1204;
            }
            paramViewGroup.progressBar.setVisibility(0);
            paramViewGroup.rFo.setVisibility(0);
            paramViewGroup.lxz.setVisibility(0);
            paramViewGroup.rFm.setVisibility(8);
            paramViewGroup.lxz.setImageBitmap(a(locali));
            paramViewGroup.progressBar.setProgress(0);
            paramViewGroup.rFo.setText("0%");
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
            paramViewGroup.rFo.setVisibility(8);
            paramViewGroup.lxz.setVisibility(8);
            paramViewGroup.rFm.setVisibility(0);
            if (locali.dtI.GAI != 0) {
              paramViewGroup.rFp.setVisibility(0);
            }
            b(paramViewGroup, a(locali), "");
          }
          label1275:
          ae.i("MicroMsg.FavMediaGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_status) });
          paramViewGroup.progressBar.setVisibility(0);
          paramViewGroup.rFo.setVisibility(0);
          paramViewGroup.lxz.setVisibility(0);
          paramViewGroup.rFm.setVisibility(8);
          paramViewGroup.lxz.setImageBitmap(a(locali));
          if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen > 0) {}
          for (paramInt = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_offset * 100 / ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen - 1;; paramInt = 0)
          {
            int i = paramInt;
            if (paramInt < 0) {
              i = 0;
            }
            paramViewGroup.progressBar.setProgress(i);
            paramViewGroup.rFo.setText(i + "%");
            AppMethodBeat.o(107336);
            return paramView;
          }
          FavMediaGalleryUI.this.enableOptionMenu(true);
          if (u.aRG(com.tencent.mm.plugin.fav.a.b.d(locali.dtI))) {
            a(paramViewGroup, (Bitmap)localObject1, com.tencent.mm.plugin.fav.a.b.d(locali.dtI));
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
    ImageView lxz;
    ProgressBar progressBar;
    View rFm;
    MultiTouchImageView rFn;
    TextView rFo;
    LinearLayout rFp;
    TextView rFq;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI
 * JD-Core Version:    0.7.0.1
 */