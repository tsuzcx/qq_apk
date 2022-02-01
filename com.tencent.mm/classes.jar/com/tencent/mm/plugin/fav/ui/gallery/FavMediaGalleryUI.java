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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.a;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.r;
import com.tencent.mm.plugin.fav.ui.r.a;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
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
import com.tencent.mm.ui.base.o.g;
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
  private boolean dUo;
  private MMGestureGallery jUy;
  private ArrayList<com.tencent.mm.plugin.fav.ui.i> kgc;
  private o.g rjz;
  private Map<String, qz> teB;
  private boolean teC;
  private r teD;
  private long teE;
  private IListener teF;
  private int tex;
  and tfo;
  private int tjR;
  private FavVideoView tjS;
  private a tjT;
  private e tjU;
  private List<FavVideoView> tjV;
  private HashMap<String, List<View>> tjW;
  
  public FavMediaGalleryUI()
  {
    AppMethodBeat.i(107341);
    this.tex = 0;
    this.tjR = -1;
    this.tjS = null;
    this.dUo = true;
    this.tjV = new ArrayList();
    this.tjW = new HashMap();
    this.tfo = new and();
    this.teB = new HashMap();
    this.rjz = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(107327);
        Object localObject1 = FavMediaGalleryUI.b(FavMediaGalleryUI.this).Ib(FavMediaGalleryUI.a(FavMediaGalleryUI.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(107327);
          return;
        }
        Object localObject2 = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT);
        if ((!com.tencent.mm.vfs.s.YS((String)localObject2)) && (paramAnonymousMenuItem.getItemId() != 4))
        {
          Log.w("MicroMsg.FavMediaGalleryUI", "file not exists");
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
          com.tencent.mm.plugin.fav.a.h.w(FavMediaGalleryUI.h(FavMediaGalleryUI.this), 1);
          if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT.dataType == 2)
          {
            if (ImgUtil.isGif((String)localObject2))
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymousMenuItem.putExtra("select_is_ret", true);
              com.tencent.mm.br.c.c(FavMediaGalleryUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 1);
              AppMethodBeat.o(107327);
              return;
            }
            com.tencent.mm.plugin.fav.a.b.a((String)localObject2, FavMediaGalleryUI.this, ((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT.jsz);
            AppMethodBeat.o(107327);
            return;
          }
          paramAnonymousMenuItem = com.tencent.mm.plugin.fav.a.b.a(((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT);
          localObject1 = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
          if (com.tencent.mm.vfs.s.YS(paramAnonymousMenuItem)) {
            ((Intent)localObject2).putExtra("image_path", paramAnonymousMenuItem);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("Retr_Msg_Type", 1);
            com.tencent.mm.br.c.c(FavMediaGalleryUI.this.getContext(), ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1);
            AppMethodBeat.o(107327);
            return;
            ((Intent)localObject2).putExtra("image_path", (String)localObject1);
          }
          com.tencent.mm.plugin.fav.a.b.b((String)localObject2, FavMediaGalleryUI.this);
          com.tencent.mm.plugin.fav.a.h.w(FavMediaGalleryUI.h(FavMediaGalleryUI.this), 0);
          AppMethodBeat.o(107327);
          return;
          if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT.dataType == 2)
          {
            FavMediaGalleryUI.a(FavMediaGalleryUI.this, (String)localObject2);
            AppMethodBeat.o(107327);
            return;
          }
          FavMediaGalleryUI.b(FavMediaGalleryUI.this, (String)localObject2);
          AppMethodBeat.o(107327);
          return;
          localObject2 = (qz)FavMediaGalleryUI.i(FavMediaGalleryUI.this).get(localObject2);
          if (localObject2 != null)
          {
            paramAnonymousMenuItem = new cr();
            paramAnonymousMenuItem.dFK.activity = FavMediaGalleryUI.this;
            paramAnonymousMenuItem.dFK.dDX = ((qz)localObject2).dXz.result;
            paramAnonymousMenuItem.dFK.dFL = ((qz)localObject2).dXz.dFL;
            paramAnonymousMenuItem.dFK.sourceType = 7;
            if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT != null))
            {
              paramAnonymousMenuItem.dFK.imagePath = ((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT.KuR;
              paramAnonymousMenuItem.dFK.dFO = ((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT.Lvp;
            }
            paramAnonymousMenuItem.dFK.dFM = ((qz)localObject2).dXz.dFM;
            localObject1 = new Bundle(1);
            ((Bundle)localObject1).putInt("stat_scene", 5);
            paramAnonymousMenuItem.dFK.dFP = ((Bundle)localObject1);
            EventCenter.instance.publish(paramAnonymousMenuItem);
            AppMethodBeat.o(107327);
            return;
            FavMediaGalleryUI.this.tfo.index = (FavMediaGalleryUI.b(FavMediaGalleryUI.this).getCount() - FavMediaGalleryUI.a(FavMediaGalleryUI.this));
            ((y)com.tencent.mm.kernel.g.af(y.class)).a(FavMediaGalleryUI.this.getContext(), ((com.tencent.mm.plugin.fav.ui.i)localObject1).tew, FavMediaGalleryUI.this.tfo);
            FavMediaGalleryUI.this.finish();
            AppMethodBeat.o(107327);
            return;
            if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FavMediaGalleryUI.this.getContext()))
            {
              FavMediaGalleryUI.e(FavMediaGalleryUI.this).cWf();
              AppMethodBeat.o(107327);
              return;
              FavMediaGalleryUI.j(FavMediaGalleryUI.this);
            }
          }
        }
      }
    };
    this.teF = new IListener() {};
    AppMethodBeat.o(107341);
  }
  
  private void and()
  {
    AppMethodBeat.i(107344);
    Object localObject1 = getIntent().getLongArrayExtra("KEY_MEDIA_FAVID_LIST");
    ArrayList localArrayList = new ArrayList();
    String str = getIntent().getStringExtra("key_detail_data_id");
    this.teE = getIntent().getLongExtra("key_detail_info_id", -1L);
    Object localObject2;
    long l;
    boolean bool1;
    if (localObject1 == null)
    {
      boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
      localObject2 = getIntent().getStringExtra("fav_note_xml");
      localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.teE);
      l = this.teE;
      if (localObject1 != null)
      {
        bool1 = true;
        Log.i("MicroMsg.FavMediaGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
        if ((!bool2) || (Util.isNullOrNil((String)localObject2))) {
          break label594;
        }
        localObject1 = com.tencent.mm.plugin.fav.a.b.arO((String)localObject2);
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
      this.kgc.clear();
      final int i = -1;
      int m = localArrayList.size();
      int k = 0;
      int j;
      if (k < m)
      {
        localObject1 = (com.tencent.mm.plugin.fav.a.g)localArrayList.get(k);
        int n = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.ppH.size();
        j = 0;
        label234:
        if (j < n)
        {
          localObject2 = (aml)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.ppH.get(j);
          if (((((aml)localObject2).dataType == 8) && (!ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d((aml)localObject2)))) || ((((aml)localObject2).dataType != 2) && (((aml)localObject2).dataType != 4) && (((aml)localObject2).dataType != 15) && (((aml)localObject2).dataType != 8))) {
            break label591;
          }
          com.tencent.mm.plugin.fav.ui.i locali = new com.tencent.mm.plugin.fav.ui.i((com.tencent.mm.plugin.fav.a.g)localObject1, (aml)localObject2);
          this.kgc.add(locali);
          if ((str == null) || (!str.equals(((aml)localObject2).dLl)) || (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId != this.teE)) {
            break label591;
          }
          i = this.kgc.size() - 1;
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
          localObject2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(l);
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
          if (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId == this.teE) {
            j = this.kgc.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label200;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.tjT.notifyDataSetChanged();
        if (i >= 0)
        {
          Log.i("MicroMsg.FavMediaGalleryUI", "pre match selection %d", new Object[] { Integer.valueOf(i) });
          this.jUy.setSelection(i);
          this.tex = i;
        }
        this.jUy.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107330);
            if (i != -1)
            {
              Log.d("MicroMsg.FavMediaGalleryUI", "match selection %d", new Object[] { Integer.valueOf(i) });
              FavMediaGalleryUI.k(FavMediaGalleryUI.this).setSelection(i);
              FavMediaGalleryUI.a(FavMediaGalleryUI.this, i);
              AppMethodBeat.o(107330);
              return;
            }
            if ((FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1 >= 0) && (FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1 < FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()))
            {
              Log.d("MicroMsg.FavMediaGalleryUI", "adjust selection %d, list size %d", new Object[] { Integer.valueOf(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1), Integer.valueOf(FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()) });
              FavMediaGalleryUI.k(FavMediaGalleryUI.this).setSelection(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1);
              FavMediaGalleryUI.a(FavMediaGalleryUI.this, FavMediaGalleryUI.a(FavMediaGalleryUI.this) - 1);
              AppMethodBeat.o(107330);
              return;
            }
            if (FavMediaGalleryUI.l(FavMediaGalleryUI.this).size() > 0)
            {
              Log.d("MicroMsg.FavMediaGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[] { Integer.valueOf(FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()) });
              FavMediaGalleryUI.k(FavMediaGalleryUI.this).setSelection(0);
              FavMediaGalleryUI.a(FavMediaGalleryUI.this, 0);
              AppMethodBeat.o(107330);
              return;
            }
            Log.w("MicroMsg.FavMediaGalleryUI", "data list size %d, empty, finish", new Object[] { Integer.valueOf(FavMediaGalleryUI.l(FavMediaGalleryUI.this).size()) });
            FavMediaGalleryUI.this.finish();
            AppMethodBeat.o(107330);
          }
        });
        AppMethodBeat.o(107344);
        return;
      }
    }
  }
  
  private void ks(boolean paramBoolean)
  {
    AppMethodBeat.i(107343);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = this.tjT.Ib(this.tex);
    if (localObject1 == null)
    {
      AppMethodBeat.o(107343);
      return;
    }
    if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT.Lwv != 0) {
      Log.i("MicroMsg.FavMediaGalleryUI", "showMenu, illegalType");
    }
    for (;;)
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(2131759234));
      if (this.tjU == null) {
        this.tjU = new e(getContext(), 1, false);
      }
      this.tjU.HLX = new FavMediaGalleryUI.8(this, localArrayList1, localArrayList2);
      this.tjU.HLY = this.rjz;
      this.tjU.PGl = new FavMediaGalleryUI.9(this);
      this.tjU.dGm();
      AppMethodBeat.o(107343);
      return;
      if (((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT.dataType == 2)
      {
        if ((((com.tencent.mm.plugin.fav.ui.i)localObject1).tew != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).tew.cUu()))
        {
          localArrayList1.add(Integer.valueOf(0));
          localArrayList2.add(getString(2131759326));
        }
        if ((((com.tencent.mm.plugin.fav.ui.i)localObject1).tew != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).tew.cUv()))
        {
          localArrayList1.add(Integer.valueOf(1));
          localArrayList2.add(getString(2131759275));
        }
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2.add(getString(2131759319));
        localObject1 = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT);
        Object localObject2 = (qz)this.teB.get(localObject1);
        if (localObject2 != null) {
          if (!Util.isNullOrNil(((qz)localObject2).dXz.result))
          {
            localArrayList1.add(Integer.valueOf(3));
            if (!com.tencent.mm.plugin.scanner.g.ca(((qz)localObject2).dXz.dFL, ((qz)localObject2).dXz.result)) {
              break label495;
            }
            localArrayList2.add(getString(2131759285));
          }
        }
        for (;;)
        {
          if ((this.teC) && (!Util.isNullOrNil((String)localObject1)))
          {
            localArrayList1.add(Integer.valueOf(5));
            localArrayList2.add(getString(2131757389));
          }
          localArrayList1.add(Integer.valueOf(6));
          localArrayList2.add(getString(2131757388));
          if (Util.isNullOrNil((String)localObject1)) {
            break;
          }
          com.tencent.mm.kernel.g.aAi();
          if ((com.tencent.mm.kernel.g.aAg().hqi.aYS() == 0) || (!paramBoolean)) {
            break;
          }
          this.teD.scan((String)localObject1);
          break;
          label495:
          if (com.tencent.mm.plugin.scanner.g.cb(((qz)localObject2).dXz.dFL, ((qz)localObject2).dXz.result))
          {
            localArrayList2.add(getString(2131759282));
          }
          else
          {
            localArrayList2.add(getString(2131759284));
            continue;
            localObject2 = new qx();
            ((qx)localObject2).dXu.dDZ = System.currentTimeMillis();
            ((qx)localObject2).dXu.filePath = ((String)localObject1);
            EventCenter.instance.publish((IEvent)localObject2);
          }
        }
      }
      if (com.tencent.mm.vfs.s.YS(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject1).dKT)))
      {
        if ((((com.tencent.mm.plugin.fav.ui.i)localObject1).tew != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject1).tew.cUu()))
        {
          localArrayList1.add(Integer.valueOf(0));
          localArrayList2.add(getString(2131759326));
        }
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2.add(getString(2131764871));
      }
    }
  }
  
  public final String cVV()
  {
    AppMethodBeat.i(107348);
    Object localObject = this.tjT.Ib(this.tex);
    if (localObject == null)
    {
      AppMethodBeat.o(107348);
      return "";
    }
    if (((com.tencent.mm.plugin.fav.ui.i)localObject).dKT.dataType == 2)
    {
      localObject = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject).dKT);
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
      com.tencent.mm.plugin.fav.ui.i locali = this.tjT.Ib(this.tex);
      if ((locali != null) && (Util.nullAs(paramc.field_dataId, "").equals(locali.dKT.dLl)) && (locali.dKT.dataType == 2)) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            int j = 0;
            AppMethodBeat.i(107321);
            Object localObject = FavMediaGalleryUI.k(FavMediaGalleryUI.this).getSelectedView();
            if (localObject == null)
            {
              AppMethodBeat.o(107321);
              return;
            }
            if ((((View)localObject).getTag() == null) || (!(((View)localObject).getTag() instanceof FavMediaGalleryUI.b)))
            {
              AppMethodBeat.o(107321);
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
              ((FavMediaGalleryUI.b)localObject).teU.setText(i + "%");
              if ((i >= 100) || (paramc.isFinished())) {
                FavMediaGalleryUI.b(FavMediaGalleryUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(107321);
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
  
  public final String getAesKey()
  {
    AppMethodBeat.i(235350);
    Object localObject = this.tjT.Ib(this.tex);
    if ((localObject == null) || (((com.tencent.mm.plugin.fav.ui.i)localObject).dKT == null))
    {
      AppMethodBeat.o(235350);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.fav.ui.i)localObject).dKT.Lvp;
    AppMethodBeat.o(235350);
    return localObject;
  }
  
  public final String getFileId()
  {
    AppMethodBeat.i(235349);
    Object localObject = this.tjT.Ib(this.tex);
    if ((localObject == null) || (((com.tencent.mm.plugin.fav.ui.i)localObject).dKT == null))
    {
      AppMethodBeat.o(235349);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.fav.ui.i)localObject).dKT.KuR;
    AppMethodBeat.o(235349);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return 2131494121;
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
      com.tencent.mm.plugin.fav.ui.i locali = this.tjT.Ib(this.tex);
      if (locali == null)
      {
        Log.i("MicroMsg.FavMediaGalleryUI", "dataItem is null.");
        AppMethodBeat.o(107351);
        return;
      }
      String str = com.tencent.mm.plugin.fav.a.b.d(locali.dKT);
      new k();
      if (k.v(locali.tew))
      {
        com.tencent.mm.ui.base.h.cD(getContext(), getString(2131755011));
        AppMethodBeat.o(107351);
        return;
      }
      Object localObject2 = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject1 = Util.stringsToList(((String)localObject2).split(","));
      Log.d("MicroMsg.FavMediaGalleryUI", "select %s for sending", new Object[] { localObject2 });
      localObject2 = com.tencent.mm.ui.base.h.a(getContext(), getString(2131759230), false, null);
      if (ImgUtil.isGif(str))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          l.a(getContext(), str, locali.tew, locali.dKT, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(235341);
              this.tcT.dismiss();
              AppMethodBeat.o(235341);
            }
          });
        }
      }
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235342);
          this.tcT.dismiss();
          AppMethodBeat.o(235342);
        }
      };
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        l.a(this, (String)((Iterator)localObject1).next(), locali.dKT, (Runnable)localObject2);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107351);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107342);
    super.onCreate(paramBundle);
    and localand;
    if (com.tencent.mm.compatible.util.d.oD(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.teD = new r(this, this, this);
      this.dUo = getIntent().getBooleanExtra("show_share", true);
      this.jUy = ((MMGestureGallery)findViewById(2131301853));
      this.jUy.setVerticalFadingEdgeEnabled(false);
      this.jUy.setHorizontalFadingEdgeEnabled(false);
      this.jUy.setOnItemSelectedListener(this);
      this.jUy.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void bmt()
        {
          AppMethodBeat.i(107320);
          Object localObject = FavMediaGalleryUI.b(FavMediaGalleryUI.this).Ib(FavMediaGalleryUI.a(FavMediaGalleryUI.this));
          if ((localObject != null) && (((com.tencent.mm.plugin.fav.ui.i)localObject).dKT.Lwv == 0) && (((com.tencent.mm.plugin.fav.ui.i)localObject).dKT.dataType != 2) && (com.tencent.mm.vfs.s.YS(com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject).dKT))))
          {
            localObject = com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.fav.ui.i)localObject).dKT);
            localObject = (List)FavMediaGalleryUI.c(FavMediaGalleryUI.this).get(localObject);
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                View localView = (View)((Iterator)localObject).next();
                if ((localView instanceof FavVideoView)) {
                  ((FavVideoView)localView).cWU();
                }
              }
              AppMethodBeat.o(107320);
              return;
            }
          }
          if ((FavMediaGalleryUI.d(FavMediaGalleryUI.this)) && (FavMediaGalleryUI.e(FavMediaGalleryUI.this).tgN != 1)) {
            FavMediaGalleryUI.this.finish();
          }
          AppMethodBeat.o(107320);
        }
      });
      if (this.dUo) {
        this.jUy.setLongClickOverListener(new MMGestureGallery.c()
        {
          public final void bmu()
          {
            AppMethodBeat.i(107323);
            if ((!FavMediaGalleryUI.this.isFinishing()) && (!FavMediaGalleryUI.this.activityHasDestroyed()))
            {
              if (FavMediaGalleryUI.d(FavMediaGalleryUI.this))
              {
                if (FavMediaGalleryUI.e(FavMediaGalleryUI.this).tgN == 1)
                {
                  AppMethodBeat.o(107323);
                  return;
                }
                if ((FavMediaGalleryUI.e(FavMediaGalleryUI.this).tgN == 0) || (FavMediaGalleryUI.e(FavMediaGalleryUI.this).tgN == 2))
                {
                  FavMediaGalleryUI.a(FavMediaGalleryUI.this, com.tencent.mm.plugin.scanner.i.eOQ());
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
      this.kgc = new ArrayList();
      this.tjT = new a((byte)0);
      this.jUy.setAdapter(this.tjT);
      and();
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
      EventCenter.instance.addListener(this.teF);
      setResult(0, getIntent());
      this.tfo.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
      this.tfo.pHw = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
      this.tfo.index = getIntent().getIntExtra("key_detail_fav_index", 0);
      this.tfo.query = getIntent().getStringExtra("key_detail_fav_query");
      this.tfo.sessionId = getIntent().getStringExtra("key_detail_fav_sessionid");
      this.tfo.tay = getIntent().getStringExtra("key_detail_fav_tags");
      localand = this.tfo;
      if (this.tfo.query != null) {
        break label412;
      }
      paramBundle = "";
      label336:
      localand.query = paramBundle;
      localand = this.tfo;
      if (this.tfo.sessionId != null) {
        break label423;
      }
      paramBundle = "";
      label360:
      localand.sessionId = paramBundle;
      localand = this.tfo;
      if (this.tfo.tay != null) {
        break label434;
      }
    }
    label412:
    label423:
    label434:
    for (paramBundle = "";; paramBundle = this.tfo.tay)
    {
      localand.tay = paramBundle;
      AppMethodBeat.o(107342);
      return;
      getWindow().setFlags(1024, 1024);
      break;
      paramBundle = this.tfo.query;
      break label336;
      paramBundle = this.tfo.sessionId;
      break label360;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107345);
    getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs());
    EventCenter.instance.removeListener(this.teF);
    Iterator localIterator = this.tjV.iterator();
    while (localIterator.hasNext())
    {
      FavVideoView localFavVideoView = (FavVideoView)localIterator.next();
      if (localFavVideoView != null) {
        localFavVideoView.onDestroy();
      }
    }
    if (this.teD != null) {
      this.teD.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(107345);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107349);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    this.tex = paramInt;
    Log.d("MicroMsg.FavMediaGalleryUI", "pos:".concat(String.valueOf(paramInt)));
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).gKy();
    }
    if (this.tjS != null) {
      this.tjS.onDestroy();
    }
    if ((paramView instanceof FavVideoView))
    {
      paramAdapterView = (FavVideoView)paramView;
      if (((this.tjT.getItemViewType(paramInt) == 15) || (this.tjT.getItemViewType(paramInt) == 4)) && (paramAdapterView != null) && (!paramAdapterView.isPlaying()))
      {
        paramAdapterView.onResume();
        this.tjS = paramAdapterView;
        this.tjR = paramInt;
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
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(this);
    f.e(false, true, true);
    AppMethodBeat.o(107347);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107346);
    super.onResume();
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(this);
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
    SparseBooleanArray teP;
    
    private a()
    {
      AppMethodBeat.i(107332);
      this.teP = new SparseBooleanArray();
      AppMethodBeat.o(107332);
    }
    
    private Bitmap a(com.tencent.mm.plugin.fav.ui.i parami)
    {
      AppMethodBeat.i(107338);
      if (parami != null)
      {
        parami = o.a(parami.dKT, parami.tew);
        if (parami != null)
        {
          AppMethodBeat.o(107338);
          return parami;
        }
      }
      parami = com.tencent.mm.compatible.f.a.decodeResource(FavMediaGalleryUI.this.getResources(), 2131690098);
      AppMethodBeat.o(107338);
      return parami;
    }
    
    private void a(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(107337);
      paramb.progressBar.setVisibility(8);
      paramb.teU.setVisibility(8);
      paramb.mEx.setVisibility(8);
      paramb.teS.setVisibility(0);
      paramb.teV.setVisibility(8);
      b(paramb, paramBitmap, paramString);
      AppMethodBeat.o(107337);
    }
    
    private void b(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(107339);
      ForceGpuUtil.decideLayerType(paramb.teT, paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = paramb.teT.getWidth();
      int j = paramb.teT.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.reset();
      float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
      float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
      Log.v("MicroMsg.FavMediaGalleryUI", "whDiv is " + f1 + " hwDiv is " + f2);
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
        paramb.teT.setImageMatrix(localMatrix);
        paramb.teT.cN(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramb.teT.setMaxZoomDoubleTab(true);
        if (!Util.isNullOrNil(paramString)) {
          break label524;
        }
        paramb.teT.setImageBitmap(paramBitmap);
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
          Log.d("MicroMsg.FavMediaGalleryUI", " offsety ".concat(String.valueOf(f1)));
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
          paramb.teT.setGifDrawable(paramString);
          paramb.teT.kY(com.tencent.mm.cb.a.jn(FavMediaGalleryUI.this.getContext()), com.tencent.mm.cb.a.jo(FavMediaGalleryUI.this.getContext()));
          paramb.teT.cN(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          paramb.teT.start();
          paramb.teT.gKz();
          AppMethodBeat.o(107339);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.FavMediaGalleryUI", Util.stackTraceToString(paramString));
          paramb.teT.setImageBitmap(paramBitmap);
          AppMethodBeat.o(107339);
          return;
        }
        label627:
        f1 = 1.0F;
      }
    }
    
    public final com.tencent.mm.plugin.fav.ui.i Ib(int paramInt)
    {
      AppMethodBeat.i(107335);
      if (paramInt >= FavMediaGalleryUI.l(FavMediaGalleryUI.this).size())
      {
        Log.w("MicroMsg.FavMediaGalleryUI", "get item fail, position %d error", new Object[] { Integer.valueOf(paramInt) });
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
      paramInt = ((com.tencent.mm.plugin.fav.ui.i)FavMediaGalleryUI.l(FavMediaGalleryUI.this).get(paramInt)).dKT.dataType;
      AppMethodBeat.o(107333);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(107336);
      com.tencent.mm.plugin.fav.ui.i locali = Ib(paramInt);
      if ((FavMediaGalleryUI.a(FavMediaGalleryUI.this) != paramInt) && (Math.abs(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - paramInt) > 1))
      {
        Log.i("MicroMsg.FavMediaGalleryUI", "getView not selected, " + FavMediaGalleryUI.a(FavMediaGalleryUI.this) + ", " + paramInt);
        paramViewGroup = paramView;
        if (paramView == null)
        {
          if ((locali.dKT.dataType != 15) && (locali.dKT.dataType != 4)) {
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
          paramViewGroup = View.inflate(FavMediaGalleryUI.this.getContext(), 2131494120, null);
          paramView.teS = paramViewGroup.findViewById(2131302563);
          paramView.teT = ((MultiTouchImageView)paramViewGroup.findViewById(2131302526));
          paramView.progressBar = ((ProgressBar)paramViewGroup.findViewById(2131299794));
          paramView.mEx = ((ImageView)paramViewGroup.findViewById(2131309073));
          paramView.teU = ((TextView)paramViewGroup.findViewById(2131299795));
          paramView.teV = ((LinearLayout)paramViewGroup.findViewById(2131300461));
          paramView.teW = ((TextView)paramViewGroup.findViewById(2131300462));
          paramView.teW.setText(2131759183);
          paramViewGroup.setTag(paramView);
        }
      }
      if ((locali.dKT.dataType == 15) || (locali.dKT.dataType == 4))
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
        Object localObject1 = com.tencent.mm.plugin.fav.a.b.d(locali.dKT);
        paramViewGroup = (List)FavMediaGalleryUI.c(FavMediaGalleryUI.this).get(localObject1);
        if (paramViewGroup == null) {
          paramViewGroup = new ArrayList();
        }
        for (;;)
        {
          paramViewGroup.add((FavVideoView)paramView);
          FavMediaGalleryUI.c(FavMediaGalleryUI.this).put(localObject1, paramViewGroup);
          paramViewGroup = (FavVideoView)paramView;
          paramViewGroup.tjm.setVisibility(8);
          paramViewGroup.setCallback(new FavVideoView.b()
          {
            public final void finish()
            {
              AppMethodBeat.i(107331);
              FavMediaGalleryUI.this.finish();
              AppMethodBeat.o(107331);
            }
          });
          if (com.tencent.mm.vfs.s.YS((String)localObject1))
          {
            paramViewGroup.setVideoData((String)localObject1);
            localObject1 = com.tencent.mm.plugin.fav.a.b.a(locali.dKT);
            if (!com.tencent.mm.vfs.s.YS((String)localObject1)) {
              break label615;
            }
            paramViewGroup.setThumbView((String)localObject1);
          }
          Object localObject2;
          for (;;)
          {
            AppMethodBeat.o(107336);
            return paramView;
            localObject2 = locali.dKT.dLl;
            com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa((String)localObject2);
            if ((localc != null) && (localc.field_status == 1)) {
              break;
            }
            if ((!Util.isNullOrNil(locali.dKT.KuR)) && (!Util.isNullOrNil(locali.dKT.Lvp)))
            {
              Log.d("MicroMsg.FavMediaGalleryUI", "getView, no video, start download, dataId:%s", new Object[] { localObject2 });
              com.tencent.mm.plugin.fav.a.b.a(locali.tew, locali.dKT, true);
              paramViewGroup.c((String)localObject1, true, (String)localObject2);
              break;
            }
            Log.d("MicroMsg.FavMediaGalleryUI", "getView, no video, cdn data invalid");
            paramViewGroup.c((String)localObject1, false, (String)localObject2);
            paramViewGroup.tjm.setVisibility(0);
            break;
            label615:
            Log.i("MicroMsg.FavMediaGalleryUI", "getView, no thumb, start download, path:%s", new Object[] { localObject1 });
            com.tencent.mm.plugin.fav.a.b.a(locali.tew, locali.dKT);
          }
          if (paramView == null)
          {
            paramViewGroup = new FavMediaGalleryUI.b(FavMediaGalleryUI.this, (byte)0);
            paramView = View.inflate(FavMediaGalleryUI.this.getContext(), 2131494120, null);
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
            boolean bool = this.teP.get(paramInt, true);
            this.teP.put(paramInt, false);
            localObject1 = o.a(locali.dKT, locali.tew, bool);
            if (locali.tew != null) {
              Log.i("MicroMsg.FavMediaGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locali.tew.field_id), Long.valueOf(locali.tew.field_localId), Integer.valueOf(locali.tew.field_itemStatus) });
            }
            if (locali.dKT != null) {
              Log.i("MicroMsg.FavMediaGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { locali.dKT.dLl, locali.dKT.KuR, locali.dKT.Lvp, Long.valueOf(locali.dKT.LvI), locali.dKT.iwX, locali.dKT.Lvk, Long.valueOf(locali.dKT.LvT) });
            }
            if (localObject1 != null) {
              break label1429;
            }
            FavMediaGalleryUI.this.enableOptionMenu(false);
            Log.w("MicroMsg.FavMediaGalleryUI", "get big image fail");
            localObject2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage();
            if (locali.dKT == null) {
              break label1196;
            }
            localObject1 = locali.dKT.dLl;
            localObject1 = ((q)localObject2).asa((String)localObject1);
            if (localObject1 != null) {
              break label1275;
            }
            paramViewGroup.teV.setVisibility(8);
            if ((locali.tew == null) || (locali.tew.field_id >= 0)) {
              break label1204;
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
            AppMethodBeat.o(107336);
            return paramView;
            paramViewGroup = (FavMediaGalleryUI.b)paramView.getTag();
            break;
            localObject1 = "";
            break label1069;
            paramViewGroup.progressBar.setVisibility(8);
            paramViewGroup.teU.setVisibility(8);
            paramViewGroup.mEx.setVisibility(8);
            paramViewGroup.teS.setVisibility(0);
            if (locali.dKT.Lwv != 0) {
              paramViewGroup.teV.setVisibility(0);
            }
            b(paramViewGroup, a(locali), "");
          }
          label1275:
          Log.i("MicroMsg.FavMediaGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_status) });
          paramViewGroup.progressBar.setVisibility(0);
          paramViewGroup.teU.setVisibility(0);
          paramViewGroup.mEx.setVisibility(0);
          paramViewGroup.teS.setVisibility(8);
          paramViewGroup.mEx.setImageBitmap(a(locali));
          if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen > 0) {}
          for (paramInt = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_offset * 100 / ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen - 1;; paramInt = 0)
          {
            int i = paramInt;
            if (paramInt < 0) {
              i = 0;
            }
            paramViewGroup.progressBar.setProgress(i);
            paramViewGroup.teU.setText(i + "%");
            AppMethodBeat.o(107336);
            return paramView;
          }
          FavMediaGalleryUI.this.enableOptionMenu(true);
          if (ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d(locali.dKT))) {
            a(paramViewGroup, (Bitmap)localObject1, com.tencent.mm.plugin.fav.a.b.d(locali.dKT));
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
    ImageView mEx;
    ProgressBar progressBar;
    View teS;
    MultiTouchImageView teT;
    TextView teU;
    LinearLayout teV;
    TextView teW;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI
 * JD-Core Version:    0.7.0.1
 */