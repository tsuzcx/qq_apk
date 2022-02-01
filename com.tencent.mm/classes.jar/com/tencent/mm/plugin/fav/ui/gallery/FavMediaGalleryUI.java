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
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.cv;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.r.a;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b;
import com.tencent.mm.plugin.scanner.n;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
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
  implements AdapterView.OnItemSelectedListener, q, r.a, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  private boolean fNQ;
  private MMGestureGallery mLL;
  private ArrayList<i> mXB;
  private q.g uMM;
  private int wKJ;
  private Map<String, rz> wKN;
  private boolean wKO;
  private boolean wKP;
  private com.tencent.mm.plugin.fav.ui.r wKQ;
  private long wKR;
  private IListener wKS;
  aoe wLC;
  private int wQi;
  private FavVideoView wQj;
  private a wQk;
  private e wQl;
  private List<FavVideoView> wQm;
  private HashMap<String, List<View>> wQn;
  
  public FavMediaGalleryUI()
  {
    AppMethodBeat.i(107341);
    this.wKJ = 0;
    this.wQi = -1;
    this.wQj = null;
    this.fNQ = true;
    this.wQm = new ArrayList();
    this.wQn = new HashMap();
    this.wLC = new aoe();
    this.wKP = n.fBR();
    this.wKN = new HashMap();
    this.uMM = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(107327);
        Object localObject1 = FavMediaGalleryUI.b(FavMediaGalleryUI.this).LL(FavMediaGalleryUI.a(FavMediaGalleryUI.this));
        if (localObject1 == null)
        {
          AppMethodBeat.o(107327);
          return;
        }
        Object localObject2 = com.tencent.mm.plugin.fav.a.b.d(((i)localObject1).fDI);
        if ((!com.tencent.mm.vfs.u.agG((String)localObject2)) && (paramAnonymousMenuItem.getItemId() != 4))
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
          com.tencent.mm.plugin.fav.a.h.y(FavMediaGalleryUI.h(FavMediaGalleryUI.this), 1);
          if (((i)localObject1).fDI.dataType == 2)
          {
            if (ImgUtil.isGif((String)localObject2))
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymousMenuItem.putExtra("select_is_ret", true);
              com.tencent.mm.by.c.d(FavMediaGalleryUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 1);
              AppMethodBeat.o(107327);
              return;
            }
            com.tencent.mm.plugin.fav.a.b.a((String)localObject2, FavMediaGalleryUI.this, ((i)localObject1).fDI.mic);
            AppMethodBeat.o(107327);
            return;
          }
          paramAnonymousMenuItem = com.tencent.mm.plugin.fav.a.b.a(((i)localObject1).fDI);
          localObject1 = com.tencent.mm.plugin.fav.a.b.d(((i)localObject1).fDI);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
          if (com.tencent.mm.vfs.u.agG(paramAnonymousMenuItem)) {
            ((Intent)localObject2).putExtra("image_path", paramAnonymousMenuItem);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("Retr_Msg_Type", 1);
            com.tencent.mm.by.c.d(FavMediaGalleryUI.this.getContext(), ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1);
            AppMethodBeat.o(107327);
            return;
            ((Intent)localObject2).putExtra("image_path", (String)localObject1);
          }
          com.tencent.mm.plugin.fav.a.b.c((String)localObject2, FavMediaGalleryUI.this);
          com.tencent.mm.plugin.fav.a.h.y(FavMediaGalleryUI.h(FavMediaGalleryUI.this), 0);
          AppMethodBeat.o(107327);
          return;
          if (((i)localObject1).fDI.dataType == 2)
          {
            FavMediaGalleryUI.a(FavMediaGalleryUI.this, (String)localObject2);
            AppMethodBeat.o(107327);
            return;
          }
          FavMediaGalleryUI.b(FavMediaGalleryUI.this, (String)localObject2);
          AppMethodBeat.o(107327);
          return;
          localObject2 = (rz)FavMediaGalleryUI.i(FavMediaGalleryUI.this).get(localObject2);
          if (localObject2 != null)
          {
            paramAnonymousMenuItem = new cv();
            Object localObject3 = p.RxG;
            localObject3 = p.d((rz)localObject2);
            p localp = p.RxG;
            paramAnonymousInt = p.e((rz)localObject2);
            localp = p.RxG;
            int i = p.f((rz)localObject2);
            paramAnonymousMenuItem.fyr.activity = FavMediaGalleryUI.this;
            paramAnonymousMenuItem.fyr.fwI = ((String)localObject3);
            paramAnonymousMenuItem.fyr.fys = paramAnonymousInt;
            paramAnonymousMenuItem.fyr.sourceType = 7;
            if ((localObject1 != null) && (((i)localObject1).fDI != null))
            {
              paramAnonymousMenuItem.fyr.imagePath = ((i)localObject1).fDI.Rwb;
              paramAnonymousMenuItem.fyr.fyv = ((i)localObject1).fDI.SxP;
            }
            paramAnonymousMenuItem.fyr.fyt = i;
            localObject1 = new Bundle(1);
            ((Bundle)localObject1).putInt("stat_scene", 5);
            paramAnonymousMenuItem.fyr.fyw = ((Bundle)localObject1);
            EventCenter.instance.publish(paramAnonymousMenuItem);
            AppMethodBeat.o(107327);
            return;
            FavMediaGalleryUI.this.wLC.index = (FavMediaGalleryUI.b(FavMediaGalleryUI.this).getCount() - FavMediaGalleryUI.a(FavMediaGalleryUI.this));
            ((z)com.tencent.mm.kernel.h.ae(z.class)).a(FavMediaGalleryUI.this.getContext(), ((i)localObject1).wKI, FavMediaGalleryUI.this.wLC);
            FavMediaGalleryUI.this.finish();
            AppMethodBeat.o(107327);
            return;
            if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FavMediaGalleryUI.this.getContext()))
            {
              FavMediaGalleryUI.e(FavMediaGalleryUI.this).dlm();
              AppMethodBeat.o(107327);
              return;
              FavMediaGalleryUI.j(FavMediaGalleryUI.this);
            }
          }
        }
      }
    };
    this.wKS = new IListener() {};
    AppMethodBeat.o(107341);
  }
  
  private void ate()
  {
    AppMethodBeat.i(107344);
    Object localObject1 = getIntent().getLongArrayExtra("KEY_MEDIA_FAVID_LIST");
    ArrayList localArrayList = new ArrayList();
    String str = getIntent().getStringExtra("key_detail_data_id");
    this.wKR = getIntent().getLongExtra("key_detail_info_id", -1L);
    Object localObject2;
    long l;
    boolean bool1;
    if (localObject1 == null)
    {
      boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
      localObject2 = getIntent().getStringExtra("fav_note_xml");
      localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(this.wKR);
      l = this.wKR;
      if (localObject1 != null)
      {
        bool1 = true;
        Log.i("MicroMsg.FavMediaGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
        if ((!bool2) || (Util.isNullOrNil((String)localObject2))) {
          break label594;
        }
        localObject1 = com.tencent.mm.plugin.fav.a.b.azP((String)localObject2);
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
      this.mXB.clear();
      final int i = -1;
      int m = localArrayList.size();
      int k = 0;
      int j;
      if (k < m)
      {
        localObject1 = (g)localArrayList.get(k);
        int n = ((g)localObject1).field_favProto.syG.size();
        j = 0;
        label234:
        if (j < n)
        {
          localObject2 = (anm)((g)localObject1).field_favProto.syG.get(j);
          if (((((anm)localObject2).dataType == 8) && (!ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d((anm)localObject2)))) || ((((anm)localObject2).dataType != 2) && (((anm)localObject2).dataType != 4) && (((anm)localObject2).dataType != 15) && (((anm)localObject2).dataType != 8))) {
            break label591;
          }
          i locali = new i((g)localObject1, (anm)localObject2);
          this.mXB.add(locali);
          if ((str == null) || (!str.equals(((anm)localObject2).fEa)) || (((g)localObject1).field_localId != this.wKR)) {
            break label591;
          }
          i = this.mXB.size() - 1;
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
          localObject2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(l);
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
          if (((g)localObject1).field_localId == this.wKR) {
            j = this.mXB.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label200;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.wQk.notifyDataSetChanged();
        if (i >= 0)
        {
          Log.i("MicroMsg.FavMediaGalleryUI", "pre match selection %d", new Object[] { Integer.valueOf(i) });
          this.mLL.setSelection(i);
          this.wKJ = i;
        }
        this.mLL.post(new Runnable()
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
  
  private void nR(boolean paramBoolean)
  {
    AppMethodBeat.i(107343);
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = this.wQk.LL(this.wKJ);
    if (localObject1 == null)
    {
      AppMethodBeat.o(107343);
      return;
    }
    if (((i)localObject1).fDI.SyU != 0) {
      Log.i("MicroMsg.FavMediaGalleryUI", "showMenu, illegalType");
    }
    for (;;)
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(s.i.favorite_go_detail));
      if (this.wQl == null) {
        this.wQl = new e(getContext(), 1, false);
      }
      this.wQl.ODT = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(107325);
          paramAnonymouso.clear();
          paramAnonymouso.setHeaderTitle("");
          int i = 0;
          while (i < localArrayList1.size())
          {
            paramAnonymouso.d(((Integer)localArrayList1.get(i)).intValue(), (CharSequence)localArrayList2.get(i));
            i += 1;
          }
          AppMethodBeat.o(107325);
        }
      };
      this.wQl.ODU = this.uMM;
      this.wQl.XbB = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(107326);
          FavMediaGalleryUI.g(FavMediaGalleryUI.this);
          AppMethodBeat.o(107326);
        }
      };
      this.wQl.eik();
      AppMethodBeat.o(107343);
      return;
      if (((i)localObject1).fDI.dataType == 2)
      {
        if ((((i)localObject1).wKI != null) && (((i)localObject1).wKI.djA()))
        {
          localArrayList1.add(Integer.valueOf(0));
          localArrayList2.add(getString(s.i.favorite_share_with_friend));
        }
        if ((((i)localObject1).wKI != null) && (((i)localObject1).wKI.djB()))
        {
          localArrayList1.add(Integer.valueOf(1));
          localArrayList2.add(getString(s.i.favorite_post_to_sns));
        }
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2.add(getString(s.i.favorite_save_image));
        localObject1 = com.tencent.mm.plugin.fav.a.b.d(((i)localObject1).fDI);
        Object localObject2 = (rz)this.wKN.get(localObject1);
        Object localObject3;
        int i;
        if (localObject2 != null)
        {
          localObject3 = p.RxG;
          localObject3 = p.d((rz)localObject2);
          if (!Util.isNullOrNil((String)localObject3))
          {
            localArrayList1.add(Integer.valueOf(3));
            p localp = p.RxG;
            i = p.e((rz)localObject2);
            if (!com.tencent.mm.plugin.scanner.k.bY(i, (String)localObject3)) {
              break label522;
            }
            localArrayList2.add(getString(s.i.favorite_reconize_image_wxcode));
          }
        }
        for (;;)
        {
          if (((this.wKP) || (this.wKO)) && (!Util.isNullOrNil((String)localObject1)))
          {
            localArrayList1.add(Integer.valueOf(5));
            localArrayList2.add(getString(s.i.chatting_image_long_click_photo_trans));
          }
          localArrayList1.add(Integer.valueOf(6));
          localArrayList2.add(getString(s.i.chatting_image_long_click_photo_edit));
          if (Util.isNullOrNil((String)localObject1)) {
            break;
          }
          com.tencent.mm.kernel.h.aHH();
          if ((com.tencent.mm.kernel.h.aHF().kcd.bih() == 0) || (!paramBoolean) || (this.wKP)) {
            break;
          }
          this.wKQ.scan((String)localObject1);
          break;
          label522:
          if (com.tencent.mm.plugin.scanner.k.bZ(i, (String)localObject3))
          {
            localArrayList2.add(getString(s.i.favorite_reconize_image_brand_code));
          }
          else
          {
            localArrayList2.add(getString(s.i.favorite_reconize_image_qrcode));
            continue;
            localObject2 = new rx();
            ((rx)localObject2).fRg.fwK = System.currentTimeMillis();
            ((rx)localObject2).fRg.filePath = ((String)localObject1);
            EventCenter.instance.publish((IEvent)localObject2);
          }
        }
      }
      if (com.tencent.mm.vfs.u.agG(com.tencent.mm.plugin.fav.a.b.d(((i)localObject1).fDI)))
      {
        if ((((i)localObject1).wKI != null) && (((i)localObject1).wKI.djA()))
        {
          localArrayList1.add(Integer.valueOf(0));
          localArrayList2.add(getString(s.i.favorite_share_with_friend));
        }
        localArrayList1.add(Integer.valueOf(2));
        localArrayList2.add(getString(s.i.save_video_to_local));
      }
    }
  }
  
  public final String dlb()
  {
    AppMethodBeat.i(107348);
    Object localObject = this.wQk.LL(this.wKJ);
    if (localObject == null)
    {
      AppMethodBeat.o(107348);
      return "";
    }
    if (((i)localObject).fDI.dataType == 2)
    {
      localObject = com.tencent.mm.plugin.fav.a.b.d(((i)localObject).fDI);
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
      i locali = this.wQk.LL(this.wKJ);
      if ((locali != null) && (Util.nullAs(paramc.field_dataId, "").equals(locali.fDI.fEa)) && (locali.fDI.dataType == 2)) {
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
              ((FavMediaGalleryUI.b)localObject).wLi.setText(i + "%");
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
    AppMethodBeat.i(228110);
    Object localObject = this.wQk.LL(this.wKJ);
    if ((localObject == null) || (((i)localObject).fDI == null))
    {
      AppMethodBeat.o(228110);
      return null;
    }
    localObject = ((i)localObject).fDI.SxP;
    AppMethodBeat.o(228110);
    return localObject;
  }
  
  public final String getFileId()
  {
    AppMethodBeat.i(228106);
    Object localObject = this.wQk.LL(this.wKJ);
    if ((localObject == null) || (((i)localObject).fDI == null))
    {
      AppMethodBeat.o(228106);
      return null;
    }
    localObject = ((i)localObject).fDI.Rwb;
    AppMethodBeat.o(228106);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return s.f.fav_img_gallery_ui;
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
      i locali = this.wQk.LL(this.wKJ);
      if (locali == null)
      {
        Log.i("MicroMsg.FavMediaGalleryUI", "dataItem is null.");
        AppMethodBeat.o(107351);
        return;
      }
      String str = com.tencent.mm.plugin.fav.a.b.d(locali.fDI);
      new com.tencent.mm.plugin.fav.a.k();
      if (com.tencent.mm.plugin.fav.a.k.v(locali.wKI))
      {
        com.tencent.mm.ui.base.h.cO(getContext(), getString(s.i.Fav_NotDownload_CannotForward));
        AppMethodBeat.o(107351);
        return;
      }
      Object localObject2 = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject1 = Util.stringsToList(((String)localObject2).split(","));
      Log.d("MicroMsg.FavMediaGalleryUI", "select %s for sending", new Object[] { localObject2 });
      localObject2 = com.tencent.mm.ui.base.h.a(getContext(), getString(s.i.favorite_forward_tips), false, null);
      if (ImgUtil.isGif(str))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          l.a(getContext(), str, locali.wKI, locali.fDI, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(231215);
              this.wJe.dismiss();
              AppMethodBeat.o(231215);
            }
          });
        }
      }
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(232161);
          this.wJe.dismiss();
          AppMethodBeat.o(232161);
        }
      };
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        l.a(this, (String)((Iterator)localObject1).next(), locali.fDI, (Runnable)localObject2);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107351);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107342);
    super.onCreate(paramBundle);
    aoe localaoe;
    if (com.tencent.mm.compatible.util.d.qV(19))
    {
      getWindow().setFlags(201327616, 201327616);
      this.wKQ = new com.tencent.mm.plugin.fav.ui.r(this, this, this);
      this.fNQ = getIntent().getBooleanExtra("show_share", true);
      this.mLL = ((MMGestureGallery)findViewById(s.e.gallery));
      this.mLL.setVerticalFadingEdgeEnabled(false);
      this.mLL.setHorizontalFadingEdgeEnabled(false);
      this.mLL.setOnItemSelectedListener(this);
      this.mLL.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void bwB()
        {
          AppMethodBeat.i(107320);
          Object localObject = FavMediaGalleryUI.b(FavMediaGalleryUI.this).LL(FavMediaGalleryUI.a(FavMediaGalleryUI.this));
          if ((localObject != null) && (((i)localObject).fDI.SyU == 0) && (((i)localObject).fDI.dataType != 2) && (com.tencent.mm.vfs.u.agG(com.tencent.mm.plugin.fav.a.b.d(((i)localObject).fDI))))
          {
            localObject = com.tencent.mm.plugin.fav.a.b.d(((i)localObject).fDI);
            localObject = (List)FavMediaGalleryUI.c(FavMediaGalleryUI.this).get(localObject);
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                View localView = (View)((Iterator)localObject).next();
                if ((localView instanceof FavVideoView)) {
                  ((FavVideoView)localView).dmc();
                }
              }
              AppMethodBeat.o(107320);
              return;
            }
          }
          if ((FavMediaGalleryUI.d(FavMediaGalleryUI.this)) && (FavMediaGalleryUI.e(FavMediaGalleryUI.this).wNd != 1)) {
            FavMediaGalleryUI.this.finish();
          }
          AppMethodBeat.o(107320);
        }
      });
      if (this.fNQ) {
        this.mLL.setLongClickOverListener(new MMGestureGallery.c()
        {
          public final void bwC()
          {
            AppMethodBeat.i(107323);
            if ((!FavMediaGalleryUI.this.isFinishing()) && (!FavMediaGalleryUI.this.activityHasDestroyed()))
            {
              if (FavMediaGalleryUI.d(FavMediaGalleryUI.this))
              {
                if (FavMediaGalleryUI.e(FavMediaGalleryUI.this).wNd == 1)
                {
                  AppMethodBeat.o(107323);
                  return;
                }
                if ((FavMediaGalleryUI.e(FavMediaGalleryUI.this).wNd == 0) || (FavMediaGalleryUI.e(FavMediaGalleryUI.this).wNd == 2))
                {
                  FavMediaGalleryUI.a(FavMediaGalleryUI.this, n.fBP());
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
      this.mXB = new ArrayList();
      this.wQk = new a((byte)0);
      this.mLL.setAdapter(this.wQk);
      ate();
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
      EventCenter.instance.addListener(this.wKS);
      setResult(0, getIntent());
      this.wLC.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
      this.wLC.wGA = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
      this.wLC.index = getIntent().getIntExtra("key_detail_fav_index", 0);
      this.wLC.query = getIntent().getStringExtra("key_detail_fav_query");
      this.wLC.sessionId = getIntent().getStringExtra("key_detail_fav_sessionid");
      this.wLC.wGC = getIntent().getStringExtra("key_detail_fav_tags");
      localaoe = this.wLC;
      if (this.wLC.query != null) {
        break label412;
      }
      paramBundle = "";
      label336:
      localaoe.query = paramBundle;
      localaoe = this.wLC;
      if (this.wLC.sessionId != null) {
        break label423;
      }
      paramBundle = "";
      label360:
      localaoe.sessionId = paramBundle;
      localaoe = this.wLC;
      if (this.wLC.wGC != null) {
        break label434;
      }
    }
    label412:
    label423:
    label434:
    for (paramBundle = "";; paramBundle = this.wLC.wGC)
    {
      localaoe.wGC = paramBundle;
      AppMethodBeat.o(107342);
      return;
      getWindow().setFlags(1024, 1024);
      break;
      paramBundle = this.wLC.query;
      break label336;
      paramBundle = this.wLC.sessionId;
      break label360;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107345);
    getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs());
    EventCenter.instance.removeListener(this.wKS);
    Iterator localIterator = this.wQm.iterator();
    while (localIterator.hasNext())
    {
      FavVideoView localFavVideoView = (FavVideoView)localIterator.next();
      if (localFavVideoView != null) {
        localFavVideoView.onDestroy();
      }
    }
    if (this.wKQ != null) {
      this.wKQ.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(107345);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107349);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/gallery/FavMediaGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    this.wKJ = paramInt;
    Log.d("MicroMsg.FavMediaGalleryUI", "pos:".concat(String.valueOf(paramInt)));
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).hJx();
    }
    if (this.wQj != null) {
      this.wQj.onDestroy();
    }
    if ((paramView instanceof FavVideoView))
    {
      paramAdapterView = (FavVideoView)paramView;
      if (((this.wQk.getItemViewType(paramInt) == 15) || (this.wQk.getItemViewType(paramInt) == 4)) && (paramAdapterView != null) && (!paramAdapterView.isPlaying()))
      {
        paramAdapterView.onResume();
        this.wQj = paramAdapterView;
        this.wQi = paramInt;
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
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b(this);
    f.d(false, true, true);
    AppMethodBeat.o(107347);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107346);
    super.onResume();
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(this);
    f.d(true, true, true);
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
    SparseBooleanArray wLd;
    
    private a()
    {
      AppMethodBeat.i(107332);
      this.wLd = new SparseBooleanArray();
      AppMethodBeat.o(107332);
    }
    
    private Bitmap a(i parami)
    {
      AppMethodBeat.i(107338);
      if (parami != null)
      {
        parami = com.tencent.mm.plugin.fav.ui.o.a(parami.fDI, parami.wKI);
        if (parami != null)
        {
          AppMethodBeat.o(107338);
          return parami;
        }
      }
      parami = com.tencent.mm.compatible.f.a.decodeResource(FavMediaGalleryUI.this.getResources(), s.h.download_image_icon);
      AppMethodBeat.o(107338);
      return parami;
    }
    
    private void a(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(107337);
      paramb.progressBar.setVisibility(8);
      paramb.wLi.setVisibility(8);
      paramb.pDJ.setVisibility(8);
      paramb.wLg.setVisibility(0);
      paramb.wLj.setVisibility(8);
      b(paramb, paramBitmap, paramString);
      AppMethodBeat.o(107337);
    }
    
    private void b(FavMediaGalleryUI.b paramb, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(107339);
      ForceGpuUtil.decideLayerType(paramb.wLh, paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = paramb.wLh.getWidth();
      int j = paramb.wLh.getHeight();
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
        paramb.wLh.setImageMatrix(localMatrix);
        paramb.wLh.di(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramb.wLh.setMaxZoomDoubleTab(true);
        if (!Util.isNullOrNil(paramString)) {
          break label524;
        }
        paramb.wLh.setImageBitmap(paramBitmap);
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
          paramb.wLh.setGifDrawable(paramString);
          paramb.wLh.mq(com.tencent.mm.ci.a.kr(FavMediaGalleryUI.this.getContext()), com.tencent.mm.ci.a.ks(FavMediaGalleryUI.this.getContext()));
          paramb.wLh.di(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          paramb.wLh.start();
          paramb.wLh.hJy();
          AppMethodBeat.o(107339);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.FavMediaGalleryUI", Util.stackTraceToString(paramString));
          paramb.wLh.setImageBitmap(paramBitmap);
          AppMethodBeat.o(107339);
          return;
        }
        label627:
        f1 = 1.0F;
      }
    }
    
    public final i LL(int paramInt)
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
      paramInt = ((i)FavMediaGalleryUI.l(FavMediaGalleryUI.this).get(paramInt)).fDI.dataType;
      AppMethodBeat.o(107333);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(107336);
      i locali = LL(paramInt);
      if ((FavMediaGalleryUI.a(FavMediaGalleryUI.this) != paramInt) && (Math.abs(FavMediaGalleryUI.a(FavMediaGalleryUI.this) - paramInt) > 1))
      {
        Log.i("MicroMsg.FavMediaGalleryUI", "getView not selected, " + FavMediaGalleryUI.a(FavMediaGalleryUI.this) + ", " + paramInt);
        paramViewGroup = paramView;
        if (paramView == null)
        {
          if ((locali.fDI.dataType != 15) && (locali.fDI.dataType != 4)) {
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
          paramViewGroup = View.inflate(FavMediaGalleryUI.this.getContext(), s.f.fav_img_detail_item, null);
          paramView.wLg = paramViewGroup.findViewById(s.e.image_gallery_download_success);
          paramView.wLh = ((MultiTouchImageView)paramViewGroup.findViewById(s.e.image));
          paramView.progressBar = ((ProgressBar)paramViewGroup.findViewById(s.e.downloading_pb));
          paramView.pDJ = ((ImageView)paramViewGroup.findViewById(s.e.thumb_iv));
          paramView.wLi = ((TextView)paramViewGroup.findViewById(s.e.downloading_percent_tv));
          paramView.wLj = ((LinearLayout)paramViewGroup.findViewById(s.e.fav_expired_btn));
          paramView.wLk = ((TextView)paramViewGroup.findViewById(s.e.fav_expired_btn_text));
          paramView.wLk.setText(s.i.favorite_detail_illegal_expired_image);
          paramViewGroup.setTag(paramView);
        }
      }
      if ((locali.fDI.dataType == 15) || (locali.fDI.dataType == 4))
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
        Object localObject1 = com.tencent.mm.plugin.fav.a.b.d(locali.fDI);
        paramViewGroup = (List)FavMediaGalleryUI.c(FavMediaGalleryUI.this).get(localObject1);
        if (paramViewGroup == null) {
          paramViewGroup = new ArrayList();
        }
        for (;;)
        {
          paramViewGroup.add((FavVideoView)paramView);
          FavMediaGalleryUI.c(FavMediaGalleryUI.this).put(localObject1, paramViewGroup);
          paramViewGroup = (FavVideoView)paramView;
          paramViewGroup.wPD.setVisibility(8);
          paramViewGroup.setCallback(new FavVideoView.b()
          {
            public final void finish()
            {
              AppMethodBeat.i(107331);
              FavMediaGalleryUI.this.finish();
              AppMethodBeat.o(107331);
            }
          });
          if (com.tencent.mm.vfs.u.agG((String)localObject1))
          {
            paramViewGroup.setVideoData((String)localObject1);
            localObject1 = com.tencent.mm.plugin.fav.a.b.a(locali.fDI);
            if (!com.tencent.mm.vfs.u.agG((String)localObject1)) {
              break label628;
            }
            paramViewGroup.setThumbView((String)localObject1);
            if (!ar.hIM()) {
              break label661;
            }
            paramViewGroup.setVideoScaleType(i.e.RcG);
          }
          Object localObject2;
          for (;;)
          {
            AppMethodBeat.o(107336);
            return paramView;
            localObject2 = locali.fDI.fEa;
            com.tencent.mm.plugin.fav.a.c localc = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb((String)localObject2);
            if ((localc != null) && (localc.field_status == 1)) {
              break;
            }
            if ((!Util.isNullOrNil(locali.fDI.Rwb)) && (!Util.isNullOrNil(locali.fDI.SxP)))
            {
              Log.d("MicroMsg.FavMediaGalleryUI", "getView, no video, start download, dataId:%s", new Object[] { localObject2 });
              com.tencent.mm.plugin.fav.a.b.a(locali.wKI, locali.fDI, true);
              paramViewGroup.b((String)localObject1, true, (String)localObject2);
              break;
            }
            Log.d("MicroMsg.FavMediaGalleryUI", "getView, no video, cdn data invalid");
            paramViewGroup.b((String)localObject1, false, (String)localObject2);
            paramViewGroup.wPD.setVisibility(0);
            break;
            label628:
            Log.i("MicroMsg.FavMediaGalleryUI", "getView, no thumb, start download, path:%s", new Object[] { localObject1 });
            com.tencent.mm.plugin.fav.a.b.a(locali.wKI, locali.fDI);
            break label461;
            paramViewGroup.setVideoScaleType(i.e.RcE);
          }
          if (paramView == null)
          {
            paramViewGroup = new FavMediaGalleryUI.b(FavMediaGalleryUI.this, (byte)0);
            paramView = View.inflate(FavMediaGalleryUI.this.getContext(), s.f.fav_img_detail_item, null);
            paramViewGroup.wLg = paramView.findViewById(s.e.image_gallery_download_success);
            paramViewGroup.wLh = ((MultiTouchImageView)paramView.findViewById(s.e.image));
            paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(s.e.downloading_pb));
            paramViewGroup.pDJ = ((ImageView)paramView.findViewById(s.e.thumb_iv));
            paramViewGroup.wLi = ((TextView)paramView.findViewById(s.e.downloading_percent_tv));
            paramViewGroup.wLj = ((LinearLayout)paramView.findViewById(s.e.fav_expired_btn));
            paramViewGroup.wLk = ((TextView)paramView.findViewById(s.e.fav_expired_btn_text));
            paramViewGroup.wLk.setText(s.i.favorite_detail_illegal_expired_image);
            paramView.setTag(paramViewGroup);
            paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            boolean bool = this.wLd.get(paramInt, true);
            this.wLd.put(paramInt, false);
            localObject1 = com.tencent.mm.plugin.fav.ui.o.a(locali.fDI, locali.wKI, bool);
            if (locali.wKI != null) {
              Log.i("MicroMsg.FavMediaGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locali.wKI.field_id), Long.valueOf(locali.wKI.field_localId), Integer.valueOf(locali.wKI.field_itemStatus) });
            }
            if (locali.fDI != null) {
              Log.i("MicroMsg.FavMediaGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { locali.fDI.fEa, locali.fDI.Rwb, locali.fDI.SxP, Long.valueOf(locali.fDI.Syi), locali.fDI.lmm, locali.fDI.SxK, Long.valueOf(locali.fDI.Sys) });
            }
            if (localObject1 != null) {
              break label1452;
            }
            FavMediaGalleryUI.this.enableOptionMenu(false);
            Log.w("MicroMsg.FavMediaGalleryUI", "get big image fail");
            localObject2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage();
            if (locali.fDI == null) {
              break label1219;
            }
            localObject1 = locali.fDI.fEa;
            localObject1 = ((com.tencent.mm.plugin.fav.a.r)localObject2).aAb((String)localObject1);
            if (localObject1 != null) {
              break label1298;
            }
            paramViewGroup.wLj.setVisibility(8);
            if ((locali.wKI == null) || (locali.wKI.field_id >= 0)) {
              break label1227;
            }
            paramViewGroup.progressBar.setVisibility(0);
            paramViewGroup.wLi.setVisibility(0);
            paramViewGroup.pDJ.setVisibility(0);
            paramViewGroup.wLg.setVisibility(8);
            paramViewGroup.pDJ.setImageBitmap(a(locali));
            paramViewGroup.progressBar.setProgress(0);
            paramViewGroup.wLi.setText("0%");
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
            paramViewGroup.wLi.setVisibility(8);
            paramViewGroup.pDJ.setVisibility(8);
            paramViewGroup.wLg.setVisibility(0);
            if (locali.fDI.SyU != 0) {
              paramViewGroup.wLj.setVisibility(0);
            }
            b(paramViewGroup, a(locali), "");
          }
          Log.i("MicroMsg.FavMediaGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject1).field_status) });
          paramViewGroup.progressBar.setVisibility(0);
          paramViewGroup.wLi.setVisibility(0);
          paramViewGroup.pDJ.setVisibility(0);
          paramViewGroup.wLg.setVisibility(8);
          paramViewGroup.pDJ.setImageBitmap(a(locali));
          if (((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen > 0) {}
          for (paramInt = ((com.tencent.mm.plugin.fav.a.c)localObject1).field_offset * 100 / ((com.tencent.mm.plugin.fav.a.c)localObject1).field_totalLen - 1;; paramInt = 0)
          {
            int i = paramInt;
            if (paramInt < 0) {
              i = 0;
            }
            paramViewGroup.progressBar.setProgress(i);
            paramViewGroup.wLi.setText(i + "%");
            AppMethodBeat.o(107336);
            return paramView;
          }
          FavMediaGalleryUI.this.enableOptionMenu(true);
          if (ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d(locali.fDI))) {
            a(paramViewGroup, (Bitmap)localObject1, com.tencent.mm.plugin.fav.a.b.d(locali.fDI));
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
    ImageView pDJ;
    ProgressBar progressBar;
    View wLg;
    MultiTouchImageView wLh;
    TextView wLi;
    LinearLayout wLj;
    TextView wLk;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI
 * JD-Core Version:    0.7.0.1
 */