package com.tencent.mm.plugin.fav.ui.gallery;

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
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.df;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.p;
import com.tencent.mm.plugin.fav.ui.p.a;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b;
import com.tencent.mm.plugin.scanner.n;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavMediaGalleryUI
  extends MMActivity
  implements AdapterView.OnItemSelectedListener, com.tencent.mm.plugin.fav.a.q, p.a, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  private int Ahg;
  private Map<String, to> Ahk;
  private boolean Ahl;
  private boolean Ahm;
  private p Ahn;
  private long Aho;
  private IListener Ahp;
  arx Aia;
  private int AmK;
  private FavVideoView AmL;
  private a AmM;
  private com.tencent.mm.ui.widget.a.f AmN;
  private List<FavVideoView> AmO;
  private HashMap<String, List<View>> AmP;
  private boolean hTH;
  private MMGestureGallery pIt;
  private ArrayList<i> pUj;
  private u.i xVp;
  
  public FavMediaGalleryUI()
  {
    AppMethodBeat.i(107341);
    this.Ahg = 0;
    this.AmK = -1;
    this.AmL = null;
    this.hTH = true;
    this.AmO = new ArrayList();
    this.AmP = new HashMap();
    this.Aia = new arx();
    this.Ahm = n.gPv();
    this.Ahk = new HashMap();
    this.xVp = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(107327);
        Object localObject1 = FavMediaGalleryUI.b(FavMediaGalleryUI.this).MI(FavMediaGalleryUI.a(FavMediaGalleryUI.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(107327);
          return;
        }
        Object localObject2 = com.tencent.mm.plugin.fav.a.b.d(((i)localObject1).hIy);
        if ((!com.tencent.mm.vfs.y.ZC((String)localObject2)) && (paramAnonymousMenuItem.getItemId() != 4))
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
          com.tencent.mm.plugin.fav.a.h.I(FavMediaGalleryUI.h(FavMediaGalleryUI.this), 1);
          if (((i)localObject1).hIy.dataType == 2)
          {
            if (ImgUtil.isGif((String)localObject2))
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymousMenuItem.putExtra("select_is_ret", true);
              com.tencent.mm.br.c.d(FavMediaGalleryUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 1);
              AppMethodBeat.o(107327);
              return;
            }
            com.tencent.mm.plugin.fav.a.b.a((String)localObject2, FavMediaGalleryUI.this, ((i)localObject1).hIy.pbn);
            AppMethodBeat.o(107327);
            return;
          }
          paramAnonymousMenuItem = com.tencent.mm.plugin.fav.a.b.a(((i)localObject1).hIy);
          localObject1 = com.tencent.mm.plugin.fav.a.b.d(((i)localObject1).hIy);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
          if (com.tencent.mm.vfs.y.ZC(paramAnonymousMenuItem)) {
            ((Intent)localObject2).putExtra("image_path", paramAnonymousMenuItem);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("Retr_Msg_Type", 1);
            com.tencent.mm.br.c.d(FavMediaGalleryUI.this.getContext(), ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1);
            AppMethodBeat.o(107327);
            return;
            ((Intent)localObject2).putExtra("image_path", (String)localObject1);
          }
          com.tencent.mm.plugin.fav.a.b.c((String)localObject2, FavMediaGalleryUI.this);
          com.tencent.mm.plugin.fav.a.h.I(FavMediaGalleryUI.h(FavMediaGalleryUI.this), 0);
          AppMethodBeat.o(107327);
          return;
          if (((i)localObject1).hIy.dataType == 2)
          {
            FavMediaGalleryUI.a(FavMediaGalleryUI.this, (String)localObject2);
            AppMethodBeat.o(107327);
            return;
          }
          FavMediaGalleryUI.b(FavMediaGalleryUI.this, (String)localObject2);
          AppMethodBeat.o(107327);
          return;
          localObject2 = (to)FavMediaGalleryUI.i(FavMediaGalleryUI.this).get(localObject2);
          if (localObject2 != null)
          {
            paramAnonymousMenuItem = new df();
            Object localObject3 = o.YtW;
            localObject3 = o.d((to)localObject2);
            o localo = o.YtW;
            paramAnonymousInt = o.e((to)localObject2);
            localo = o.YtW;
            int i = o.f((to)localObject2);
            paramAnonymousMenuItem.hDa.activity = FavMediaGalleryUI.this;
            paramAnonymousMenuItem.hDa.hBi = ((String)localObject3);
            paramAnonymousMenuItem.hDa.hDb = paramAnonymousInt;
            paramAnonymousMenuItem.hDa.sourceType = 7;
            if ((localObject1 != null) && (((i)localObject1).hIy != null))
            {
              paramAnonymousMenuItem.hDa.imagePath = ((i)localObject1).hIy.Ysw;
              paramAnonymousMenuItem.hDa.hDe = ((i)localObject1).hIy.ZyH;
            }
            paramAnonymousMenuItem.hDa.hDc = i;
            localObject1 = new Bundle(1);
            ((Bundle)localObject1).putInt("stat_scene", 5);
            Log.i("MicroMsg.FavMediaGalleryUI", "addStatInfo4AppBrand, from fav");
            ((Bundle)localObject1).putInt("LaunchCodeScene_ScanScene", 4);
            paramAnonymousMenuItem.hDa.hDf = ((Bundle)localObject1);
            paramAnonymousMenuItem.publish();
            AppMethodBeat.o(107327);
            return;
            FavMediaGalleryUI.this.Aia.index = (FavMediaGalleryUI.b(FavMediaGalleryUI.this).getCount() - FavMediaGalleryUI.a(FavMediaGalleryUI.this));
            ((z)com.tencent.mm.kernel.h.ax(z.class)).a(FavMediaGalleryUI.this.getContext(), ((i)localObject1).Ahf, FavMediaGalleryUI.this.Aia);
            FavMediaGalleryUI.this.finish();
            AppMethodBeat.o(107327);
            return;
            if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FavMediaGalleryUI.this.getContext()))
            {
              FavMediaGalleryUI.e(FavMediaGalleryUI.this).dSc();
              AppMethodBeat.o(107327);
              return;
              FavMediaGalleryUI.j(FavMediaGalleryUI.this);
            }
          }
        }
      }
    };
    this.Ahp = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(107341);
  }
  
  private void aNm()
  {
    AppMethodBeat.i(107344);
    Object localObject1 = getIntent().getLongArrayExtra("KEY_MEDIA_FAVID_LIST");
    ArrayList localArrayList = new ArrayList();
    String str = getIntent().getStringExtra("key_detail_data_id");
    this.Aho = getIntent().getLongExtra("key_detail_info_id", -1L);
    Object localObject2;
    long l;
    boolean bool1;
    if (localObject1 == null)
    {
      boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
      localObject2 = getIntent().getStringExtra("fav_note_xml");
      localObject1 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(this.Aho);
      l = this.Aho;
      if (localObject1 != null)
      {
        bool1 = true;
        Log.i("MicroMsg.FavMediaGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
        if ((!bool2) || (Util.isNullOrNil((String)localObject2))) {
          break label594;
        }
        localObject1 = com.tencent.mm.plugin.fav.a.b.atV((String)localObject2);
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
      this.pUj.clear();
      final int i = -1;
      int m = localArrayList.size();
      int k = 0;
      int j;
      if (k < m)
      {
        localObject1 = (g)localArrayList.get(k);
        int n = ((g)localObject1).field_favProto.vEn.size();
        j = 0;
        label234:
        if (j < n)
        {
          localObject2 = (arf)((g)localObject1).field_favProto.vEn.get(j);
          if (((((arf)localObject2).dataType == 8) && (!ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d((arf)localObject2)))) || ((((arf)localObject2).dataType != 2) && (((arf)localObject2).dataType != 4) && (((arf)localObject2).dataType != 15) && (((arf)localObject2).dataType != 8))) {
            break label591;
          }
          i locali = new i((g)localObject1, (arf)localObject2);
          this.pUj.add(locali);
          if ((str == null) || (!str.equals(((arf)localObject2).hIQ)) || (((g)localObject1).field_localId != this.Aho)) {
            break label591;
          }
          i = this.pUj.size() - 1;
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
          localObject2 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(l);
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
          if (((g)localObject1).field_localId == this.Aho) {
            j = this.pUj.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label200;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.AmM.notifyDataSetChanged();
        if (i >= 0)
        {
          Log.i("MicroMsg.FavMediaGalleryUI", "pre match selection %d", new Object[] { Integer.valueOf(i) });
          this.pIt.setSelection(i);
          this.Ahg = i;
        }
        this.pIt.post(new Runnable()
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
  
  private void pr(boolean paramBoolean)
  {
    AppMethodBeat.i(107343);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = this.AmM.MI(this.Ahg);
    if (localObject1 == null)
    {
      AppMethodBeat.o(107343);
      return;
    }
    if (((i)localObject1).hIy.ZzM != 0) {
      Log.i("MicroMsg.FavMediaGalleryUI", "showMenu, illegalType");
    }
    for (;;)
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(q.i.favorite_go_detail));
      if (this.AmN == null) {
        this.AmN = new com.tencent.mm.ui.widget.a.f(getContext(), 1, false);
      }
      this.AmN.Vtg = new FavMediaGalleryUI.7(this, localArrayList1, localArrayList2);
      this.AmN.GAC = this.xVp;
      this.AmN.aeLi = new FavMediaGalleryUI.8(this);
      this.AmN.dDn();
      AppMethodBeat.o(107343);
      return;
      if (((i)localObject1).hIy.dataType == 2)
      {
        if ((((i)localObject1).Ahf != null) && (((i)localObject1).Ahf.dQl()))
        {
          localArrayList1.add(Integer.valueOf(0));
          localArrayList2.add(getString(q.i.favorite_share_with_friend));
        }
        if ((((i)localObject1).Ahf != null) && (((i)localObject1).Ahf.dQm()))
        {
          localArrayList1.add(Integer.valueOf(1));
          localArrayList2.add(getString(q.i.favorite_post_to_sns));
        }
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2.add(getString(q.i.favorite_save_image));
        localObject1 = com.tencent.mm.plugin.fav.a.b.d(((i)localObject1).hIy);
        Object localObject2 = (to)this.Ahk.get(localObject1);
        Object localObject3;
        int i;
        if (localObject2 != null)
        {
          localObject3 = o.YtW;
          localObject3 = o.d((to)localObject2);
          if (!Util.isNullOrNil((String)localObject3))
          {
            localArrayList1.add(Integer.valueOf(3));
            o localo = o.YtW;
            i = o.e((to)localObject2);
            if (!com.tencent.mm.plugin.scanner.k.cK(i, (String)localObject3)) {
              break label522;
            }
            localArrayList2.add(getString(q.i.favorite_reconize_image_wxcode));
          }
        }
        for (;;)
        {
          if (((this.Ahm) || (this.Ahl)) && (!Util.isNullOrNil((String)localObject1)))
          {
            localArrayList1.add(Integer.valueOf(5));
            localArrayList2.add(getString(q.i.chatting_image_long_click_photo_trans));
          }
          localArrayList1.add(Integer.valueOf(6));
          localArrayList2.add(getString(q.i.chatting_image_long_click_photo_edit));
          if (Util.isNullOrNil((String)localObject1)) {
            break;
          }
          com.tencent.mm.kernel.h.baF();
          if ((com.tencent.mm.kernel.h.baD().mCm.bFQ() == 0) || (!paramBoolean) || (this.Ahm)) {
            break;
          }
          this.Ahn.scan((String)localObject1);
          break;
          label522:
          if (com.tencent.mm.plugin.scanner.k.cL(i, (String)localObject3))
          {
            localArrayList2.add(getString(q.i.favorite_reconize_image_brand_code));
          }
          else
          {
            localArrayList2.add(getString(q.i.favorite_reconize_image_qrcode));
            continue;
            localObject2 = new tm();
            ((tm)localObject2).hXd.hBk = System.currentTimeMillis();
            ((tm)localObject2).hXd.filePath = ((String)localObject1);
            ((tm)localObject2).publish();
          }
        }
      }
      if (com.tencent.mm.vfs.y.ZC(com.tencent.mm.plugin.fav.a.b.d(((i)localObject1).hIy)))
      {
        if ((((i)localObject1).Ahf != null) && (((i)localObject1).Ahf.dQl()))
        {
          localArrayList1.add(Integer.valueOf(0));
          localArrayList2.add(getString(q.i.favorite_share_with_friend));
        }
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2.add(getString(q.i.save_video_to_local));
      }
    }
  }
  
  public final String dRR()
  {
    AppMethodBeat.i(107348);
    Object localObject = this.AmM.MI(this.Ahg);
    if (localObject == null)
    {
      AppMethodBeat.o(107348);
      return "";
    }
    if (((i)localObject).hIy.dataType == 2)
    {
      localObject = com.tencent.mm.plugin.fav.a.b.d(((i)localObject).hIy);
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
      i locali = this.AmM.MI(this.Ahg);
      if ((locali != null) && (Util.nullAs(paramc.field_dataId, "").equals(locali.hIy.hIQ)) && (locali.hIy.dataType == 2)) {
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
              ((FavMediaGalleryUI.b)localObject).AhF.setText(i + "%");
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
    AppMethodBeat.i(274556);
    Object localObject = this.AmM.MI(this.Ahg);
    if ((localObject == null) || (((i)localObject).hIy == null))
    {
      AppMethodBeat.o(274556);
      return null;
    }
    localObject = ((i)localObject).hIy.ZyH;
    AppMethodBeat.o(274556);
    return localObject;
  }
  
  public final String getFileId()
  {
    AppMethodBeat.i(274555);
    Object localObject = this.AmM.MI(this.Ahg);
    if ((localObject == null) || (((i)localObject).hIy == null))
    {
      AppMethodBeat.o(274555);
      return null;
    }
    localObject = ((i)localObject).hIy.Ysw;
    AppMethodBeat.o(274555);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return q.f.fav_img_gallery_ui;
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
      i locali = this.AmM.MI(this.Ahg);
      if (locali == null)
      {
        Log.i("MicroMsg.FavMediaGalleryUI", "dataItem is null.");
        AppMethodBeat.o(107351);
        return;
      }
      String str = com.tencent.mm.plugin.fav.a.b.d(locali.hIy);
      new com.tencent.mm.plugin.fav.a.k();
      if (com.tencent.mm.plugin.fav.a.k.v(locali.Ahf))
      {
        com.tencent.mm.ui.base.k.cZ(getContext(), getString(q.i.Fav_NotDownload_CannotForward));
        AppMethodBeat.o(107351);
        return;
      }
      Object localObject2 = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject1 = Util.stringsToList(((String)localObject2).split(","));
      Log.d("MicroMsg.FavMediaGalleryUI", "select %s for sending", new Object[] { localObject2 });
      localObject2 = com.tencent.mm.ui.base.k.a(getContext(), getString(q.i.favorite_forward_tips), false, null);
      if (ImgUtil.isGif(str))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          l.a(getContext(), str, locali.Ahf, locali.hIy, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(274488);
              this.Afz.dismiss();
              AppMethodBeat.o(274488);
            }
          });
        }
      }
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(274485);
          this.Afz.dismiss();
          AppMethodBeat.o(274485);
        }
      };
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        l.a(this, (String)((Iterator)localObject1).next(), locali.hIy, (Runnable)localObject2);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107351);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107342);
    super.onCreate(paramBundle);
    arx localarx;
    if (com.tencent.mm.compatible.util.d.rb(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.Ahn = new p(this, this, this);
      this.hTH = getIntent().getBooleanExtra("show_share", true);
      this.pIt = ((MMGestureGallery)findViewById(q.e.gallery));
      this.pIt.setVerticalFadingEdgeEnabled(false);
      this.pIt.setHorizontalFadingEdgeEnabled(false);
      this.pIt.setOnItemSelectedListener(this);
      this.pIt.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void singleClickOver()
        {
          AppMethodBeat.i(107320);
          Object localObject = FavMediaGalleryUI.b(FavMediaGalleryUI.this).MI(FavMediaGalleryUI.a(FavMediaGalleryUI.this));
          if ((localObject != null) && (((i)localObject).hIy.ZzM == 0) && (((i)localObject).hIy.dataType != 2) && (com.tencent.mm.vfs.y.ZC(com.tencent.mm.plugin.fav.a.b.d(((i)localObject).hIy))))
          {
            localObject = com.tencent.mm.plugin.fav.a.b.d(((i)localObject).hIy);
            localObject = (List)FavMediaGalleryUI.c(FavMediaGalleryUI.this).get(localObject);
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                View localView = (View)((Iterator)localObject).next();
                if ((localView instanceof FavVideoView)) {
                  ((FavVideoView)localView).dST();
                }
              }
              AppMethodBeat.o(107320);
              return;
            }
          }
          if ((FavMediaGalleryUI.d(FavMediaGalleryUI.this)) && (FavMediaGalleryUI.e(FavMediaGalleryUI.this).AjA != 1)) {
            FavMediaGalleryUI.this.finish();
          }
          AppMethodBeat.o(107320);
        }
      });
      if (this.hTH) {
        this.pIt.setLongClickOverListener(new MMGestureGallery.c()
        {
          public final void longClickOver()
          {
            AppMethodBeat.i(107323);
            if ((!FavMediaGalleryUI.this.isFinishing()) && (!FavMediaGalleryUI.this.activityHasDestroyed()))
            {
              if (FavMediaGalleryUI.d(FavMediaGalleryUI.this))
              {
                if (FavMediaGalleryUI.e(FavMediaGalleryUI.this).AjA == 1)
                {
                  AppMethodBeat.o(107323);
                  return;
                }
                if ((FavMediaGalleryUI.e(FavMediaGalleryUI.this).AjA == 0) || (FavMediaGalleryUI.e(FavMediaGalleryUI.this).AjA == 2))
                {
                  FavMediaGalleryUI.a(FavMediaGalleryUI.this, n.gPt());
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
      this.pUj = new ArrayList();
      this.AmM = new a((byte)0);
      this.pIt.setAdapter(this.AmM);
      aNm();
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
      this.Ahp.alive();
      setResult(0, getIntent());
      this.Aia.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
      this.Aia.AcJ = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
      this.Aia.index = getIntent().getIntExtra("key_detail_fav_index", 0);
      this.Aia.query = getIntent().getStringExtra("key_detail_fav_query");
      this.Aia.sessionId = getIntent().getStringExtra("key_detail_fav_sessionid");
      this.Aia.AcL = getIntent().getStringExtra("key_detail_fav_tags");
      localarx = this.Aia;
      if (this.Aia.query != null) {
        break label408;
      }
      paramBundle = "";
      label332:
      localarx.query = paramBundle;
      localarx = this.Aia;
      if (this.Aia.sessionId != null) {
        break label419;
      }
      paramBundle = "";
      label356:
      localarx.sessionId = paramBundle;
      localarx = this.Aia;
      if (this.Aia.AcL != null) {
        break label430;
      }
    }
    label408:
    label419:
    label430:
    for (paramBundle = "";; paramBundle = this.Aia.AcL)
    {
      localarx.AcL = paramBundle;
      AppMethodBeat.o(107342);
      return;
      getWindow().setFlags(1024, 1024);
      break;
      paramBundle = this.Aia.query;
      break label332;
      paramBundle = this.Aia.sessionId;
      break label356;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107345);
    getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs());
    this.Ahp.dead();
    Iterator localIterator = this.AmO.iterator();
    while (localIterator.hasNext())
    {
      FavVideoView localFavVideoView = (FavVideoView)localIterator.next();
      if (localFavVideoView != null) {
        localFavVideoView.onDestroy();
      }
    }
    if (this.Ahn != null) {
      this.Ahn.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(107345);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107349);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/FavMediaGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    this.Ahg = paramInt;
    Log.d("MicroMsg.FavMediaGalleryUI", "pos:".concat(String.valueOf(paramInt)));
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).jma();
    }
    if (this.AmL != null) {
      this.AmL.onDestroy();
    }
    if ((paramView instanceof FavVideoView))
    {
      paramAdapterView = (FavVideoView)paramView;
      if (((this.AmM.getItemViewType(paramInt) == 15) || (this.AmM.getItemViewType(paramInt) == 4)) && (paramAdapterView != null) && (!paramAdapterView.isPlaying()))
      {
        paramAdapterView.onResume();
        this.AmL = paramAdapterView;
        this.AmK = paramInt;
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
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().b(this);
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(107347);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107346);
    super.onResume();
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a(this);
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
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
    SparseBooleanArray AhA;
    
    private a()
    {
      AppMethodBeat.i(107332);
      this.AhA = new SparseBooleanArray();
      AppMethodBeat.o(107332);
    }
    
    private Bitmap a(i parami)
    {
      AppMethodBeat.i(107338);
      if (parami != null)
      {
        parami = FavoriteImageServer.a(parami.hIy, parami.Ahf);
        if (parami != null)
        {
          AppMethodBeat.o(107338);
          return parami;
        }
      }
      parami = com.tencent.mm.compatible.f.a.decodeResource(FavMediaGalleryUI.this.getResources(), q.h.download_image_icon);
      AppMethodBeat.o(107338);
      return parami;
    }
    
    private void a(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(107337);
      paramb.progressBar.setVisibility(8);
      paramb.AhF.setVisibility(8);
      paramb.sIV.setVisibility(8);
      paramb.AhD.setVisibility(0);
      paramb.AhG.setVisibility(8);
      b(paramb, paramBitmap, paramString);
      AppMethodBeat.o(107337);
    }
    
    private void b(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(107339);
      ForceGpuUtil.decideLayerType(paramb.AhE, paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = paramb.AhE.getWidth();
      int j = paramb.AhE.getHeight();
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
        paramb.AhE.setImageMatrix(localMatrix);
        paramb.AhE.dU(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramb.AhE.setMaxZoomDoubleTab(true);
        if (!Util.isNullOrNil(paramString)) {
          break label524;
        }
        paramb.AhE.setImageBitmap(paramBitmap);
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
          paramb.AhE.setGifDrawable(paramString);
          paramb.AhE.ok(com.tencent.mm.cd.a.ms(FavMediaGalleryUI.this.getContext()), com.tencent.mm.cd.a.mt(FavMediaGalleryUI.this.getContext()));
          paramb.AhE.dU(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          paramb.AhE.start();
          paramb.AhE.jmb();
          AppMethodBeat.o(107339);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.FavMediaGalleryUI", Util.stackTraceToString(paramString));
          paramb.AhE.setImageBitmap(paramBitmap);
          AppMethodBeat.o(107339);
          return;
        }
        label627:
        f1 = 1.0F;
      }
    }
    
    public final i MI(int paramInt)
    {
      AppMethodBeat.i(107335);
      if (paramInt >= FavMediaGalleryUI.l(FavMediaGalleryUI.this).size())
      {
        Log.w("MicroMsg.FavMediaGalleryUI", "get item fail, position %d error", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(107335);
        return null;
      }
      i locali = (i)FavMediaGalleryUI.l(FavMediaGalleryUI.this).get(paramInt);
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
      paramInt = ((i)FavMediaGalleryUI.l(FavMediaGalleryUI.this).get(paramInt)).hIy.dataType;
      AppMethodBeat.o(107333);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(107336);
      i locali = MI(paramInt);
      if ((FavMediaGalleryUI.a(FavMediaGalleryUI.this) != paramInt) && (Math.abs(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - paramInt) > 1))
      {
        Log.i("MicroMsg.FavMediaGalleryUI", "getView not selected, " + FavMediaGalleryUI.a(FavMediaGalleryUI.this) + ", " + paramInt);
        paramViewGroup = paramView;
        if (paramView == null)
        {
          if ((locali.hIy.dataType != 15) && (locali.hIy.dataType != 4)) {
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
          paramViewGroup = View.inflate(FavMediaGalleryUI.this.getContext(), q.f.fav_img_detail_item, null);
          paramView.AhD = paramViewGroup.findViewById(q.e.image_gallery_download_success);
          paramView.AhE = ((MultiTouchImageView)paramViewGroup.findViewById(q.e.image));
          paramView.progressBar = ((ProgressBar)paramViewGroup.findViewById(q.e.downloading_pb));
          paramView.sIV = ((ImageView)paramViewGroup.findViewById(q.e.thumb_iv));
          paramView.AhF = ((TextView)paramViewGroup.findViewById(q.e.downloading_percent_tv));
          paramView.AhG = ((LinearLayout)paramViewGroup.findViewById(q.e.fav_expired_btn));
          paramView.AhH = ((TextView)paramViewGroup.findViewById(q.e.fav_expired_btn_text));
          paramView.AhH.setText(q.i.favorite_detail_illegal_expired_image);
          paramViewGroup.setTag(paramView);
        }
      }
      if ((locali.hIy.dataType == 15) || (locali.hIy.dataType == 4))
      {
        if (paramView != null) {
          break label1513;
        }
        paramView = new FavVideoView(FavMediaGalleryUI.this.getContext());
        FavMediaGalleryUI.m(FavMediaGalleryUI.this).add((FavVideoView)paramView);
      }
      label461:
      label1513:
      for (;;)
      {
        Object localObject1 = com.tencent.mm.plugin.fav.a.b.d(locali.hIy);
        paramViewGroup = (List)FavMediaGalleryUI.c(FavMediaGalleryUI.this).get(localObject1);
        if (paramViewGroup == null) {
          paramViewGroup = new ArrayList();
        }
        for (;;)
        {
          paramViewGroup.add((FavVideoView)paramView);
          FavMediaGalleryUI.c(FavMediaGalleryUI.this).put(localObject1, paramViewGroup);
          paramViewGroup = (FavVideoView)paramView;
          paramViewGroup.Amf.setVisibility(8);
          paramViewGroup.setCallback(new FavVideoView.b()
          {
            public final void finish()
            {
              AppMethodBeat.i(107331);
              FavMediaGalleryUI.this.finish();
              AppMethodBeat.o(107331);
            }
          });
          if (com.tencent.mm.vfs.y.ZC((String)localObject1))
          {
            paramViewGroup.setVideoData((String)localObject1);
            localObject1 = com.tencent.mm.plugin.fav.a.b.a(locali.hIy);
            if (!com.tencent.mm.vfs.y.ZC((String)localObject1)) {
              break label628;
            }
            paramViewGroup.setThumbView((String)localObject1);
            if (!aw.ato()) {
              break label661;
            }
            paramViewGroup.setVideoScaleType(i.e.XYM);
          }
          Object localObject2;
          for (;;)
          {
            AppMethodBeat.o(107336);
            return paramView;
            localObject2 = locali.hIy.hIQ;
            com.tencent.mm.plugin.fav.a.c localc = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui((String)localObject2);
            if ((localc != null) && (localc.field_status == 1)) {
              break;
            }
            if ((!Util.isNullOrNil(locali.hIy.Ysw)) && (!Util.isNullOrNil(locali.hIy.ZyH)))
            {
              Log.d("MicroMsg.FavMediaGalleryUI", "getView, no video, start download, dataId:%s", new Object[] { localObject2 });
              com.tencent.mm.plugin.fav.a.b.a(locali.Ahf, locali.hIy, true);
              paramViewGroup.e((String)localObject1, true, (String)localObject2);
              break;
            }
            Log.d("MicroMsg.FavMediaGalleryUI", "getView, no video, cdn data invalid");
            paramViewGroup.e((String)localObject1, false, (String)localObject2);
            paramViewGroup.Amf.setVisibility(0);
            break;
            label628:
            Log.i("MicroMsg.FavMediaGalleryUI", "getView, no thumb, start download, path:%s", new Object[] { localObject1 });
            com.tencent.mm.plugin.fav.a.b.a(locali.Ahf, locali.hIy);
            break label461;
            paramViewGroup.setVideoScaleType(i.e.XYK);
          }
          if (paramView == null)
          {
            paramViewGroup = new FavMediaGalleryUI.b(FavMediaGalleryUI.this, (byte)0);
            paramView = View.inflate(FavMediaGalleryUI.this.getContext(), q.f.fav_img_detail_item, null);
            paramViewGroup.AhD = paramView.findViewById(q.e.image_gallery_download_success);
            paramViewGroup.AhE = ((MultiTouchImageView)paramView.findViewById(q.e.image));
            paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(q.e.downloading_pb));
            paramViewGroup.sIV = ((ImageView)paramView.findViewById(q.e.thumb_iv));
            paramViewGroup.AhF = ((TextView)paramView.findViewById(q.e.downloading_percent_tv));
            paramViewGroup.AhG = ((LinearLayout)paramView.findViewById(q.e.fav_expired_btn));
            paramViewGroup.AhH = ((TextView)paramView.findViewById(q.e.fav_expired_btn_text));
            paramViewGroup.AhH.setText(q.i.favorite_detail_illegal_expired_image);
            paramView.setTag(paramViewGroup);
            paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            boolean bool = this.AhA.get(paramInt, true);
            this.AhA.put(paramInt, false);
            localObject1 = FavoriteImageServer.a(locali.hIy, locali.Ahf, bool);
            if (locali.Ahf != null) {
              Log.i("MicroMsg.FavMediaGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locali.Ahf.field_id), Long.valueOf(locali.Ahf.field_localId), Integer.valueOf(locali.Ahf.field_itemStatus) });
            }
            if (locali.hIy != null) {
              Log.i("MicroMsg.FavMediaGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { locali.hIy.hIQ, locali.hIy.Ysw, locali.hIy.ZyH, Long.valueOf(locali.hIy.Zza), locali.hIy.nRr, locali.hIy.ZyC, Long.valueOf(locali.hIy.Zzk) });
            }
            if (localObject1 != null) {
              break label1452;
            }
            FavMediaGalleryUI.this.enableOptionMenu(false);
            Log.w("MicroMsg.FavMediaGalleryUI", "get big image fail");
            localObject2 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage();
            if (locali.hIy == null) {
              break label1219;
            }
            localObject1 = locali.hIy.hIQ;
            localObject1 = ((r)localObject2).aui((String)localObject1);
            if (localObject1 != null) {
              break label1298;
            }
            paramViewGroup.AhG.setVisibility(8);
            if ((locali.Ahf == null) || (locali.Ahf.field_id >= 0)) {
              break label1227;
            }
            paramViewGroup.progressBar.setVisibility(0);
            paramViewGroup.AhF.setVisibility(0);
            paramViewGroup.sIV.setVisibility(0);
            paramViewGroup.AhD.setVisibility(8);
            paramViewGroup.sIV.setImageBitmap(a(locali));
            paramViewGroup.progressBar.setProgress(0);
            paramViewGroup.AhF.setText("0%");
          }
          for (;;)
          {
            AppMethodBeat.o(107336);
            return paramView;
            paramViewGroup = (FavMediaGalleryUI.b)paramView.getTag();
            break;
            localObject1 = "";
            break label1092;
            paramViewGroup.progressBar.setVisibility(8);
            paramViewGroup.AhF.setVisibility(8);
            paramViewGroup.sIV.setVisibility(8);
            paramViewGroup.AhD.setVisibility(0);
            if (locali.hIy.ZzM != 0) {
              paramViewGroup.AhG.setVisibility(0);
            }
            b(paramViewGroup, a(locali), "");
          }
          Log.i("MicroMsg.FavMediaGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_status) });
          paramViewGroup.progressBar.setVisibility(0);
          paramViewGroup.AhF.setVisibility(0);
          paramViewGroup.sIV.setVisibility(0);
          paramViewGroup.AhD.setVisibility(8);
          paramViewGroup.sIV.setImageBitmap(a(locali));
          if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen > 0) {}
          for (paramInt = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_offset * 100 / ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen - 1;; paramInt = 0)
          {
            int i = paramInt;
            if (paramInt < 0) {
              i = 0;
            }
            paramViewGroup.progressBar.setProgress(i);
            paramViewGroup.AhF.setText(i + "%");
            AppMethodBeat.o(107336);
            return paramView;
          }
          FavMediaGalleryUI.this.enableOptionMenu(true);
          if (ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d(locali.hIy))) {
            a(paramViewGroup, (Bitmap)localObject1, com.tencent.mm.plugin.fav.a.b.d(locali.hIy));
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
    View AhD;
    MultiTouchImageView AhE;
    TextView AhF;
    LinearLayout AhG;
    TextView AhH;
    ProgressBar progressBar;
    ImageView sIV;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI
 * JD-Core Version:    0.7.0.1
 */