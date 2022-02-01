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
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pu.a;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.r;
import com.tencent.mm.plugin.fav.ui.r.a;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavMediaGalleryUI
  extends MMActivity
  implements AdapterView.OnItemSelectedListener, com.tencent.mm.plugin.fav.a.p, r.a, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  private ArrayList<com.tencent.mm.plugin.fav.ui.i> dataList;
  private boolean dpG;
  private MMGestureGallery iBx;
  private n.d piv;
  private int qME;
  private Map<String, pu> qMI;
  private boolean qMJ;
  private r qMK;
  private long qML;
  private com.tencent.mm.sdk.b.c qMM;
  ahp qNv;
  private int qRV;
  private FavVideoView qRW;
  private a qRX;
  private e qRY;
  private List<FavVideoView> qRZ;
  private HashMap<String, List<View>> qSa;
  
  public FavMediaGalleryUI()
  {
    AppMethodBeat.i(107341);
    this.qME = 0;
    this.qRV = -1;
    this.qRW = null;
    this.dpG = true;
    this.qRZ = new ArrayList();
    this.qSa = new HashMap();
    this.qNv = new ahp();
    this.qMI = new HashMap();
    this.piv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(107327);
        Object localObject1 = FavMediaGalleryUI.b(FavMediaGalleryUI.this).Dk(FavMediaGalleryUI.a(FavMediaGalleryUI.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(107327);
          return;
        }
        Object localObject2 = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe);
        if ((!com.tencent.mm.vfs.i.eA((String)localObject2)) && (paramAnonymousMenuItem.getItemId() != 4))
        {
          ac.w("MicroMsg.FavMediaGalleryUI", "file not exists");
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
          if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe.dataType == 2)
          {
            if (s.aKD((String)localObject2))
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymousMenuItem.putExtra("select_is_ret", true);
              com.tencent.mm.br.d.c(FavMediaGalleryUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 1);
              AppMethodBeat.o(107327);
              return;
            }
            com.tencent.mm.plugin.fav.a.b.a((String)localObject2, FavMediaGalleryUI.this, ((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe.iaU);
            AppMethodBeat.o(107327);
            return;
          }
          paramAnonymousMenuItem = com.tencent.mm.plugin.fav.a.b.a(((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe);
          localObject1 = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
          if (com.tencent.mm.vfs.i.eA(paramAnonymousMenuItem)) {
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
          if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe.dataType == 2)
          {
            FavMediaGalleryUI.a(FavMediaGalleryUI.this, (String)localObject2);
            AppMethodBeat.o(107327);
            return;
          }
          FavMediaGalleryUI.b(FavMediaGalleryUI.this, (String)localObject2);
          AppMethodBeat.o(107327);
          return;
          localObject2 = (pu)FavMediaGalleryUI.i(FavMediaGalleryUI.this).get(localObject2);
          if (localObject2 != null)
          {
            paramAnonymousMenuItem = new cl();
            paramAnonymousMenuItem.dbW.activity = FavMediaGalleryUI.this;
            paramAnonymousMenuItem.dbW.dam = ((pu)localObject2).dsM.result;
            paramAnonymousMenuItem.dbW.dbX = ((pu)localObject2).dsM.dbX;
            paramAnonymousMenuItem.dbW.sourceType = 7;
            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe != null))
            {
              paramAnonymousMenuItem.dbW.imagePath = ((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe.Ezf;
              paramAnonymousMenuItem.dbW.dca = ((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe.Ezh;
            }
            paramAnonymousMenuItem.dbW.dbY = ((pu)localObject2).dsM.dbY;
            localObject1 = new Bundle(1);
            ((Bundle)localObject1).putInt("stat_scene", 5);
            paramAnonymousMenuItem.dbW.dcb = ((Bundle)localObject1);
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMenuItem);
            AppMethodBeat.o(107327);
            return;
            FavMediaGalleryUI.this.qNv.index = (FavMediaGalleryUI.b(FavMediaGalleryUI.this).getCount() - FavMediaGalleryUI.a(FavMediaGalleryUI.this));
            ((y)com.tencent.mm.kernel.g.ab(y.class)).a(FavMediaGalleryUI.this.getContext(), ((com.tencent.mm.plugin.fav.ui.i)localObject1).qMD, FavMediaGalleryUI.this.qNv);
            FavMediaGalleryUI.this.finish();
            AppMethodBeat.o(107327);
            return;
            FavMediaGalleryUI.e(FavMediaGalleryUI.this).cqQ();
            AppMethodBeat.o(107327);
            return;
            FavMediaGalleryUI.j(FavMediaGalleryUI.this);
          }
        }
      }
    };
    this.qMM = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(107341);
  }
  
  private void WN()
  {
    AppMethodBeat.i(107344);
    Object localObject1 = getIntent().getLongArrayExtra("KEY_MEDIA_FAVID_LIST");
    ArrayList localArrayList = new ArrayList();
    String str = getIntent().getStringExtra("key_detail_data_id");
    this.qML = getIntent().getLongExtra("key_detail_info_id", -1L);
    Object localObject2;
    long l;
    boolean bool1;
    if (localObject1 == null)
    {
      boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
      localObject2 = getIntent().getStringExtra("fav_note_xml");
      localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(this.qML);
      l = this.qML;
      if (localObject1 != null)
      {
        bool1 = true;
        ac.i("MicroMsg.FavMediaGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
        if ((!bool2) || (bs.isNullOrNil((String)localObject2))) {
          break label594;
        }
        localObject1 = com.tencent.mm.plugin.fav.a.b.acu((String)localObject2);
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
      this.dataList.clear();
      final int i = -1;
      int m = localArrayList.size();
      int k = 0;
      int j;
      if (k < m)
      {
        localObject1 = (com.tencent.mm.plugin.fav.a.g)localArrayList.get(k);
        int n = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nxC.size();
        j = 0;
        label234:
        if (j < n)
        {
          localObject2 = (agx)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nxC.get(j);
          if (((((agx)localObject2).dataType == 8) && (!s.aKD(com.tencent.mm.plugin.fav.a.b.d((agx)localObject2)))) || ((((agx)localObject2).dataType != 2) && (((agx)localObject2).dataType != 4) && (((agx)localObject2).dataType != 15) && (((agx)localObject2).dataType != 8))) {
            break label591;
          }
          com.tencent.mm.plugin.fav.ui.i locali = new com.tencent.mm.plugin.fav.ui.i((com.tencent.mm.plugin.fav.a.g)localObject1, (agx)localObject2);
          this.dataList.add(locali);
          if ((str == null) || (!str.equals(((agx)localObject2).dhw)) || (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId != this.qML)) {
            break label591;
          }
          i = this.dataList.size() - 1;
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
          localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(l);
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
          if (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId == this.qML) {
            j = this.dataList.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label200;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.qRX.notifyDataSetChanged();
        if (i >= 0)
        {
          ac.i("MicroMsg.FavMediaGalleryUI", "pre match selection %d", new Object[] { Integer.valueOf(i) });
          this.iBx.setSelection(i);
          this.qME = i;
        }
        this.iBx.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107329);
            if (i != -1)
            {
              ac.d("MicroMsg.FavMediaGalleryUI", "match selection %d", new Object[] { Integer.valueOf(i) });
              FavMediaGalleryUI.k(FavMediaGalleryUI.this).setSelection(i);
              FavMediaGalleryUI.a(FavMediaGalleryUI.this, i);
              AppMethodBeat.o(107329);
              return;
            }
            if ((FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1 >= 0) && (FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1 < FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()))
            {
              ac.d("MicroMsg.FavMediaGalleryUI", "adjust selection %d, list size %d", new Object[] { Integer.valueOf(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1), Integer.valueOf(FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()) });
              FavMediaGalleryUI.k(FavMediaGalleryUI.this).setSelection(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1);
              FavMediaGalleryUI.a(FavMediaGalleryUI.this, FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1);
              AppMethodBeat.o(107329);
              return;
            }
            if (FavMediaGalleryUI.l(FavMediaGalleryUI.this).size() > 0)
            {
              ac.d("MicroMsg.FavMediaGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[] { Integer.valueOf(FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()) });
              FavMediaGalleryUI.k(FavMediaGalleryUI.this).setSelection(0);
              FavMediaGalleryUI.a(FavMediaGalleryUI.this, 0);
              AppMethodBeat.o(107329);
              return;
            }
            ac.w("MicroMsg.FavMediaGalleryUI", "data list size %d, empty, finish", new Object[] { Integer.valueOf(FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()) });
            FavMediaGalleryUI.this.finish();
            AppMethodBeat.o(107329);
          }
        });
        AppMethodBeat.o(107344);
        return;
      }
    }
  }
  
  private void jg(boolean paramBoolean)
  {
    AppMethodBeat.i(107343);
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = this.qRX.Dk(this.qME);
    if (localObject1 == null)
    {
      AppMethodBeat.o(107343);
      return;
    }
    if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe.EAn != 0) {
      ac.i("MicroMsg.FavMediaGalleryUI", "showMenu, illegalType");
    }
    for (;;)
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(2131758910));
      if (this.qRY == null) {
        this.qRY = new e(getContext(), 1, false);
      }
      this.qRY.ISu = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(107325);
          paramAnonymousl.clear();
          paramAnonymousl.setHeaderTitle("");
          int i = 0;
          while (i < localArrayList1.size())
          {
            paramAnonymousl.c(((Integer)localArrayList1.get(i)).intValue(), (CharSequence)localArrayList2.get(i));
            i += 1;
          }
          AppMethodBeat.o(107325);
        }
      };
      this.qRY.ISv = this.piv;
      this.qRY.Ihj = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(107326);
          FavMediaGalleryUI.g(FavMediaGalleryUI.this);
          AppMethodBeat.o(107326);
        }
      };
      this.qRY.cED();
      AppMethodBeat.o(107343);
      return;
      if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe.dataType == 2)
      {
        if ((((com.tencent.mm.plugin.fav.ui.i)localObject1).qMD != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).qMD.cpl()))
        {
          localArrayList1.add(Integer.valueOf(0));
          localArrayList2.add(getString(2131759001));
        }
        if ((((com.tencent.mm.plugin.fav.ui.i)localObject1).qMD != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).qMD.cpm()))
        {
          localArrayList1.add(Integer.valueOf(1));
          localArrayList2.add(getString(2131758951));
        }
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2.add(getString(2131758994));
        localObject1 = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe);
        Object localObject2 = (pu)this.qMI.get(localObject1);
        if (localObject2 != null) {
          if (!bs.isNullOrNil(((pu)localObject2).dsM.result))
          {
            localArrayList1.add(Integer.valueOf(3));
            if (!com.tencent.mm.plugin.scanner.f.bG(((pu)localObject2).dsM.dbX, ((pu)localObject2).dsM.result)) {
              break label495;
            }
            localArrayList2.add(getString(2131758961));
          }
        }
        for (;;)
        {
          if ((this.qMJ) && (!bs.isNullOrNil((String)localObject1)))
          {
            localArrayList1.add(Integer.valueOf(5));
            localArrayList2.add(getString(2131757184));
          }
          localArrayList1.add(Integer.valueOf(6));
          localArrayList2.add(getString(2131757183));
          if (bs.isNullOrNil((String)localObject1)) {
            break;
          }
          com.tencent.mm.kernel.g.agS();
          if ((com.tencent.mm.kernel.g.agQ().ghe.aBK() == 0) || (!paramBoolean)) {
            break;
          }
          this.qMK.scan((String)localObject1);
          break;
          label495:
          if (com.tencent.mm.plugin.scanner.f.bH(((pu)localObject2).dsM.dbX, ((pu)localObject2).dsM.result))
          {
            localArrayList2.add(getString(2131758958));
          }
          else
          {
            localArrayList2.add(getString(2131758960));
            continue;
            localObject2 = new ps();
            ((ps)localObject2).dsJ.dao = System.currentTimeMillis();
            ((ps)localObject2).dsJ.filePath = ((String)localObject1);
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
      }
      if (com.tencent.mm.vfs.i.eA(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dhe)))
      {
        if ((((com.tencent.mm.plugin.fav.ui.i)localObject1).qMD != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).qMD.cpl()))
        {
          localArrayList1.add(Integer.valueOf(0));
          localArrayList2.add(getString(2131759001));
        }
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2.add(getString(2131762784));
      }
    }
  }
  
  public final String cqG()
  {
    AppMethodBeat.i(107348);
    Object localObject = this.qRX.Dk(this.qME);
    if (localObject == null)
    {
      AppMethodBeat.o(107348);
      return "";
    }
    if (((com.tencent.mm.plugin.fav.ui.i)localObject).dhe.dataType == 2)
    {
      localObject = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject).dhe);
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
      com.tencent.mm.plugin.fav.ui.i locali = this.qRX.Dk(this.qME);
      if ((locali != null) && (bs.bG(paramc.field_dataId, "").equals(locali.dhe.dhw)) && (locali.dhe.dataType == 2)) {
        ap.f(new Runnable()
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
              ((FavMediaGalleryUI.b)localObject).qNa.setText(i + "%");
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
      com.tencent.mm.plugin.fav.ui.i locali = this.qRX.Dk(this.qME);
      if (locali == null)
      {
        ac.i("MicroMsg.FavMediaGalleryUI", "dataItem is null.");
        AppMethodBeat.o(107351);
        return;
      }
      String str = com.tencent.mm.plugin.fav.a.b.d(locali.dhe);
      new k();
      if (k.v(locali.qMD))
      {
        com.tencent.mm.ui.base.h.cg(getContext(), getString(2131755010));
        AppMethodBeat.o(107351);
        return;
      }
      Object localObject2 = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject1 = bs.S(((String)localObject2).split(","));
      ac.d("MicroMsg.FavMediaGalleryUI", "select %s for sending", new Object[] { localObject2 });
      localObject2 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
      if (s.aKD(str))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          com.tencent.mm.plugin.fav.ui.l.a(getContext(), str, locali.qMD, locali.dhe, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107321);
              this.qLa.dismiss();
              AppMethodBeat.o(107321);
            }
          });
        }
      }
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209488);
          this.qLa.dismiss();
          AppMethodBeat.o(209488);
        }
      };
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        com.tencent.mm.plugin.fav.ui.l.a(this, (String)((Iterator)localObject1).next(), locali.dhe, (Runnable)localObject2);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107351);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107342);
    super.onCreate(paramBundle);
    ahp localahp;
    if (com.tencent.mm.compatible.util.d.kZ(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.qMK = new r(this, this, this);
      this.dpG = getIntent().getBooleanExtra("show_share", true);
      this.iBx = ((MMGestureGallery)findViewById(2131300335));
      this.iBx.setVerticalFadingEdgeEnabled(false);
      this.iBx.setHorizontalFadingEdgeEnabled(false);
      this.iBx.setOnItemSelectedListener(this);
      this.iBx.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void aOd()
        {
          AppMethodBeat.i(107320);
          Object localObject = FavMediaGalleryUI.b(FavMediaGalleryUI.this).Dk(FavMediaGalleryUI.a(FavMediaGalleryUI.this));
          if ((localObject != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject).dhe.EAn == 0) && (((com.tencent.mm.plugin.fav.ui.i)localObject).dhe.dataType != 2) && (com.tencent.mm.vfs.i.eA(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject).dhe))))
          {
            localObject = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject).dhe);
            localObject = (List)FavMediaGalleryUI.c(FavMediaGalleryUI.this).get(localObject);
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                View localView = (View)((Iterator)localObject).next();
                if ((localView instanceof FavVideoView)) {
                  ((FavVideoView)localView).crE();
                }
              }
              AppMethodBeat.o(107320);
              return;
            }
          }
          if ((FavMediaGalleryUI.d(FavMediaGalleryUI.this)) && (FavMediaGalleryUI.e(FavMediaGalleryUI.this).qOW != 1)) {
            FavMediaGalleryUI.this.finish();
          }
          AppMethodBeat.o(107320);
        }
      });
      if (this.dpG) {
        this.iBx.setLongClickOverListener(new MMGestureGallery.c()
        {
          public final void aOe()
          {
            AppMethodBeat.i(107323);
            if ((!FavMediaGalleryUI.this.isFinishing()) && (!FavMediaGalleryUI.this.activityHasDestroyed()))
            {
              if (FavMediaGalleryUI.d(FavMediaGalleryUI.this))
              {
                if (FavMediaGalleryUI.e(FavMediaGalleryUI.this).qOW == 1)
                {
                  AppMethodBeat.o(107323);
                  return;
                }
                if ((FavMediaGalleryUI.e(FavMediaGalleryUI.this).qOW == 0) || (FavMediaGalleryUI.e(FavMediaGalleryUI.this).qOW == 2))
                {
                  FavMediaGalleryUI.a(FavMediaGalleryUI.this, com.tencent.mm.plugin.scanner.h.dyZ());
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
      this.dataList = new ArrayList();
      this.qRX = new a((byte)0);
      this.iBx.setAdapter(this.qRX);
      WN();
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
      com.tencent.mm.sdk.b.a.GpY.c(this.qMM);
      setResult(0, getIntent());
      this.qNv.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
      this.qNv.nLC = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
      this.qNv.index = getIntent().getIntExtra("key_detail_fav_index", 0);
      this.qNv.query = getIntent().getStringExtra("key_detail_fav_query");
      this.qNv.sessionId = getIntent().getStringExtra("key_detail_fav_sessionid");
      this.qNv.qIF = getIntent().getStringExtra("key_detail_fav_tags");
      localahp = this.qNv;
      if (this.qNv.query != null) {
        break label412;
      }
      paramBundle = "";
      label336:
      localahp.query = paramBundle;
      localahp = this.qNv;
      if (this.qNv.sessionId != null) {
        break label423;
      }
      paramBundle = "";
      label360:
      localahp.sessionId = paramBundle;
      localahp = this.qNv;
      if (this.qNv.qIF != null) {
        break label434;
      }
    }
    label412:
    label423:
    label434:
    for (paramBundle = "";; paramBundle = this.qNv.qIF)
    {
      localahp.qIF = paramBundle;
      AppMethodBeat.o(107342);
      return;
      getWindow().setFlags(1024, 1024);
      break;
      paramBundle = this.qNv.query;
      break label336;
      paramBundle = this.qNv.sessionId;
      break label360;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107345);
    getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs());
    com.tencent.mm.sdk.b.a.GpY.d(this.qMM);
    Iterator localIterator = this.qRZ.iterator();
    while (localIterator.hasNext())
    {
      FavVideoView localFavVideoView = (FavVideoView)localIterator.next();
      if (localFavVideoView != null) {
        localFavVideoView.onDestroy();
      }
    }
    if (this.qMK != null) {
      this.qMK.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(107345);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107349);
    this.qME = paramInt;
    ac.d("MicroMsg.FavMediaGalleryUI", "pos:".concat(String.valueOf(paramInt)));
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).fij();
    }
    if (this.qRW != null) {
      this.qRW.onDestroy();
    }
    if ((paramView instanceof FavVideoView))
    {
      paramAdapterView = (FavVideoView)paramView;
      if (((this.qRX.getItemViewType(paramInt) == 15) || (this.qRX.getItemViewType(paramInt) == 4)) && (paramAdapterView != null) && (!paramAdapterView.isPlaying()))
      {
        paramAdapterView.onResume();
        this.qRW = paramAdapterView;
        this.qRV = paramInt;
      }
    }
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
    SparseBooleanArray qMV;
    
    private a()
    {
      AppMethodBeat.i(107332);
      this.qMV = new SparseBooleanArray();
      AppMethodBeat.o(107332);
    }
    
    private Bitmap a(com.tencent.mm.plugin.fav.ui.i parami)
    {
      AppMethodBeat.i(107338);
      if (parami != null)
      {
        parami = o.a(parami.dhe, parami.qMD);
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
      paramb.qNa.setVisibility(8);
      paramb.kWb.setVisibility(8);
      paramb.qMY.setVisibility(0);
      paramb.qNb.setVisibility(8);
      b(paramb, paramBitmap, paramString);
      AppMethodBeat.o(107337);
    }
    
    private void b(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(107339);
      com.tencent.mm.sdk.platformtools.p.z(paramb.qMZ, paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = paramb.qMZ.getWidth();
      int j = paramb.qMZ.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.reset();
      float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
      float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
      ac.v("MicroMsg.FavMediaGalleryUI", "whDiv is " + f1 + " hwDiv is " + f2);
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
        paramb.qMZ.setImageMatrix(localMatrix);
        paramb.qMZ.cF(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramb.qMZ.setMaxZoomDoubleTab(true);
        if (!bs.isNullOrNil(paramString)) {
          break label524;
        }
        paramb.qMZ.setImageBitmap(paramBitmap);
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
          ac.d("MicroMsg.FavMediaGalleryUI", " offsety ".concat(String.valueOf(f1)));
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
          paramb.qMZ.setGifDrawable(paramString);
          paramb.qMZ.jz(com.tencent.mm.cc.a.ig(FavMediaGalleryUI.this.getContext()), com.tencent.mm.cc.a.ih(FavMediaGalleryUI.this.getContext()));
          paramb.qMZ.cF(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          paramb.qMZ.start();
          paramb.qMZ.fik();
          AppMethodBeat.o(107339);
          return;
        }
        catch (Exception paramString)
        {
          ac.e("MicroMsg.FavMediaGalleryUI", bs.m(paramString));
          paramb.qMZ.setImageBitmap(paramBitmap);
          AppMethodBeat.o(107339);
          return;
        }
        label627:
        f1 = 1.0F;
      }
    }
    
    public final com.tencent.mm.plugin.fav.ui.i Dk(int paramInt)
    {
      AppMethodBeat.i(107335);
      if (paramInt >= FavMediaGalleryUI.l(FavMediaGalleryUI.this).size())
      {
        ac.w("MicroMsg.FavMediaGalleryUI", "get item fail, position %d error", new Object[] { Integer.valueOf(paramInt) });
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
      paramInt = ((com.tencent.mm.plugin.fav.ui.i)FavMediaGalleryUI.l(FavMediaGalleryUI.this).get(paramInt)).dhe.dataType;
      AppMethodBeat.o(107333);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(107336);
      com.tencent.mm.plugin.fav.ui.i locali = Dk(paramInt);
      if ((FavMediaGalleryUI.a(FavMediaGalleryUI.this) != paramInt) && (Math.abs(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - paramInt) > 1))
      {
        ac.i("MicroMsg.FavMediaGalleryUI", "getView not selected, " + FavMediaGalleryUI.a(FavMediaGalleryUI.this) + ", " + paramInt);
        paramViewGroup = paramView;
        if (paramView == null)
        {
          if ((locali.dhe.dataType != 15) && (locali.dhe.dataType != 4)) {
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
          paramView.qMY = paramViewGroup.findViewById(2131300933);
          paramView.qMZ = ((MultiTouchImageView)paramViewGroup.findViewById(2131300914));
          paramView.progressBar = ((ProgressBar)paramViewGroup.findViewById(2131299229));
          paramView.kWb = ((ImageView)paramViewGroup.findViewById(2131305798));
          paramView.qNa = ((TextView)paramViewGroup.findViewById(2131299230));
          paramView.qNb = ((LinearLayout)paramViewGroup.findViewById(2131299788));
          paramView.qNc = ((TextView)paramViewGroup.findViewById(2131299789));
          paramView.qNc.setText(2131758860);
          paramViewGroup.setTag(paramView);
        }
      }
      if ((locali.dhe.dataType == 15) || (locali.dhe.dataType == 4))
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
        Object localObject1 = com.tencent.mm.plugin.fav.a.b.d(locali.dhe);
        paramViewGroup = (List)FavMediaGalleryUI.c(FavMediaGalleryUI.this).get(localObject1);
        if (paramViewGroup == null) {
          paramViewGroup = new ArrayList();
        }
        for (;;)
        {
          paramViewGroup.add((FavVideoView)paramView);
          FavMediaGalleryUI.c(FavMediaGalleryUI.this).put(localObject1, paramViewGroup);
          paramViewGroup = (FavVideoView)paramView;
          paramViewGroup.qRq.setVisibility(8);
          paramViewGroup.setCallback(new FavVideoView.b()
          {
            public final void finish()
            {
              AppMethodBeat.i(107331);
              FavMediaGalleryUI.this.finish();
              AppMethodBeat.o(107331);
            }
          });
          if (com.tencent.mm.vfs.i.eA((String)localObject1))
          {
            paramViewGroup.setVideoData((String)localObject1);
            localObject1 = com.tencent.mm.plugin.fav.a.b.a(locali.dhe);
            if (!com.tencent.mm.vfs.i.eA((String)localObject1)) {
              break label615;
            }
            paramViewGroup.setThumbView((String)localObject1);
          }
          Object localObject2;
          for (;;)
          {
            AppMethodBeat.o(107336);
            return paramView;
            localObject2 = locali.dhe.dhw;
            com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG((String)localObject2);
            if ((localc != null) && (localc.field_status == 1)) {
              break;
            }
            if ((!bs.isNullOrNil(locali.dhe.Ezf)) && (!bs.isNullOrNil(locali.dhe.Ezh)))
            {
              ac.d("MicroMsg.FavMediaGalleryUI", "getView, no video, start download, dataId:%s", new Object[] { localObject2 });
              com.tencent.mm.plugin.fav.a.b.a(locali.qMD, locali.dhe, true);
              paramViewGroup.c((String)localObject1, true, (String)localObject2);
              break;
            }
            ac.d("MicroMsg.FavMediaGalleryUI", "getView, no video, cdn data invalid");
            paramViewGroup.c((String)localObject1, false, (String)localObject2);
            paramViewGroup.qRq.setVisibility(0);
            break;
            label615:
            ac.i("MicroMsg.FavMediaGalleryUI", "getView, no thumb, start download, path:%s", new Object[] { localObject1 });
            com.tencent.mm.plugin.fav.a.b.a(locali.qMD, locali.dhe);
          }
          if (paramView == null)
          {
            paramViewGroup = new FavMediaGalleryUI.b(FavMediaGalleryUI.this, (byte)0);
            paramView = View.inflate(FavMediaGalleryUI.this.getContext(), 2131493952, null);
            paramViewGroup.qMY = paramView.findViewById(2131300933);
            paramViewGroup.qMZ = ((MultiTouchImageView)paramView.findViewById(2131300914));
            paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(2131299229));
            paramViewGroup.kWb = ((ImageView)paramView.findViewById(2131305798));
            paramViewGroup.qNa = ((TextView)paramView.findViewById(2131299230));
            paramViewGroup.qNb = ((LinearLayout)paramView.findViewById(2131299788));
            paramViewGroup.qNc = ((TextView)paramView.findViewById(2131299789));
            paramViewGroup.qNc.setText(2131758860);
            paramView.setTag(paramViewGroup);
            paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            boolean bool = this.qMV.get(paramInt, true);
            this.qMV.put(paramInt, false);
            localObject1 = o.a(locali.dhe, locali.qMD, bool);
            if (locali.qMD != null) {
              ac.i("MicroMsg.FavMediaGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locali.qMD.field_id), Long.valueOf(locali.qMD.field_localId), Integer.valueOf(locali.qMD.field_itemStatus) });
            }
            if (locali.dhe != null) {
              ac.i("MicroMsg.FavMediaGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { locali.dhe.dhw, locali.dhe.Ezf, locali.dhe.Ezh, Long.valueOf(locali.dhe.EzA), locali.dhe.hhV, locali.dhe.Ezb, Long.valueOf(locali.dhe.EzL) });
            }
            if (localObject1 != null) {
              break label1429;
            }
            FavMediaGalleryUI.this.enableOptionMenu(false);
            ac.w("MicroMsg.FavMediaGalleryUI", "get big image fail");
            localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage();
            if (locali.dhe == null) {
              break label1196;
            }
            localObject1 = locali.dhe.dhw;
            localObject1 = ((com.tencent.mm.plugin.fav.a.q)localObject2).acG((String)localObject1);
            if (localObject1 != null) {
              break label1275;
            }
            paramViewGroup.qNb.setVisibility(8);
            if ((locali.qMD == null) || (locali.qMD.field_id >= 0)) {
              break label1204;
            }
            paramViewGroup.progressBar.setVisibility(0);
            paramViewGroup.qNa.setVisibility(0);
            paramViewGroup.kWb.setVisibility(0);
            paramViewGroup.qMY.setVisibility(8);
            paramViewGroup.kWb.setImageBitmap(a(locali));
            paramViewGroup.progressBar.setProgress(0);
            paramViewGroup.qNa.setText("0%");
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
            paramViewGroup.qNa.setVisibility(8);
            paramViewGroup.kWb.setVisibility(8);
            paramViewGroup.qMY.setVisibility(0);
            if (locali.dhe.EAn != 0) {
              paramViewGroup.qNb.setVisibility(0);
            }
            b(paramViewGroup, a(locali), "");
          }
          label1275:
          ac.i("MicroMsg.FavMediaGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_status) });
          paramViewGroup.progressBar.setVisibility(0);
          paramViewGroup.qNa.setVisibility(0);
          paramViewGroup.kWb.setVisibility(0);
          paramViewGroup.qMY.setVisibility(8);
          paramViewGroup.kWb.setImageBitmap(a(locali));
          if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen > 0) {}
          for (paramInt = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_offset * 100 / ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen - 1;; paramInt = 0)
          {
            int i = paramInt;
            if (paramInt < 0) {
              i = 0;
            }
            paramViewGroup.progressBar.setProgress(i);
            paramViewGroup.qNa.setText(i + "%");
            AppMethodBeat.o(107336);
            return paramView;
          }
          FavMediaGalleryUI.this.enableOptionMenu(true);
          if (s.aKD(com.tencent.mm.plugin.fav.a.b.d(locali.dhe))) {
            a(paramViewGroup, (Bitmap)localObject1, com.tencent.mm.plugin.fav.a.b.d(locali.dhe));
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
    ImageView kWb;
    ProgressBar progressBar;
    View qMY;
    MultiTouchImageView qMZ;
    TextView qNa;
    LinearLayout qNb;
    TextView qNc;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI
 * JD-Core Version:    0.7.0.1
 */