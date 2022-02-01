package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.cv;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.n;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
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
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class FavImgGalleryUI
  extends MMActivity
  implements AdapterView.OnItemSelectedListener, q, d.a, r.a, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  private boolean fNQ;
  private MMGestureGallery mLL;
  private ArrayList<i> mXB;
  private ScanCodeSheetItemLogic oxq;
  private q.g uMM;
  private int wKJ;
  private a wKK;
  private e wKL;
  private d wKM;
  private Map<String, b> wKN;
  private boolean wKO;
  private boolean wKP;
  private r wKQ;
  private long wKR;
  private IListener wKS;
  
  public FavImgGalleryUI()
  {
    AppMethodBeat.i(106757);
    this.wKJ = 0;
    this.fNQ = true;
    this.wKN = new HashMap();
    this.wKP = n.fBR();
    this.uMM = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(106746);
        i locali = FavImgGalleryUI.i(FavImgGalleryUI.this).LL(FavImgGalleryUI.h(FavImgGalleryUI.this));
        if (locali == null)
        {
          AppMethodBeat.o(106746);
          return;
        }
        String str = com.tencent.mm.plugin.fav.a.b.d(locali.fDI);
        if (!u.agG(str))
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
          com.tencent.mm.plugin.fav.a.h.y(FavImgGalleryUI.j(FavImgGalleryUI.this), 1);
          if (ImgUtil.isGif(str))
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
            paramAnonymousMenuItem.putExtra("select_is_ret", true);
            com.tencent.mm.by.c.d(FavImgGalleryUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 1);
            AppMethodBeat.o(106746);
            return;
          }
          com.tencent.mm.plugin.fav.a.b.a(str, FavImgGalleryUI.this, locali.fDI.mic);
          AppMethodBeat.o(106746);
          return;
          com.tencent.mm.plugin.fav.a.b.c(str, FavImgGalleryUI.this);
          com.tencent.mm.plugin.fav.a.h.y(FavImgGalleryUI.j(FavImgGalleryUI.this), 0);
          AppMethodBeat.o(106746);
          return;
          FavImgGalleryUI.a(str, FavImgGalleryUI.this.getString(s.i.favorite_save_fail), FavImgGalleryUI.this, locali.fDI.mic);
          AppMethodBeat.o(106746);
          return;
          if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FavImgGalleryUI.this.getContext()))
          {
            FavImgGalleryUI.a(FavImgGalleryUI.this).dlm();
            AppMethodBeat.o(106746);
            return;
            FavImgGalleryUI.k(FavImgGalleryUI.this);
          }
        }
      }
    };
    this.wKS = new IListener() {};
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
      public final void bT(String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(229081);
        Toast.makeText(this.val$context, this.val$context.getString(s.i.cropimage_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymousString2) }), 1).show();
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231130);
            String str = u.buc(paramAnonymousString2);
            v localv = v.mEG;
            v.bV(str, FavImgGalleryUI.13.this.wKZ);
            AppMethodBeat.o(231130);
          }
        });
        AppMethodBeat.o(229081);
      }
      
      public final void bU(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(229084);
        Toast.makeText(this.val$context, paramString2, 1).show();
        AppMethodBeat.o(229084);
      }
    });
    AppMethodBeat.o(164093);
  }
  
  private void ate()
  {
    AppMethodBeat.i(106761);
    this.wKR = getIntent().getLongExtra("key_detail_info_id", -1L);
    String str = getIntent().getStringExtra("key_detail_data_id");
    boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    Object localObject = getIntent().getStringExtra("fav_note_xml");
    ArrayList localArrayList = new ArrayList();
    g localg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(this.wKR);
    long l = this.wKR;
    boolean bool1;
    if (localg != null)
    {
      bool1 = true;
      Log.i("MicroMsg.FavImgGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
      if ((!bool2) || (Util.isNullOrNil((String)localObject))) {
        break label438;
      }
      localg = com.tencent.mm.plugin.fav.a.b.azP((String)localObject);
    }
    label435:
    label438:
    for (;;)
    {
      if (localg != null) {
        localArrayList.add(localg);
      }
      this.mXB.clear();
      final int i = -1;
      int m = localArrayList.size();
      int k = 0;
      label185:
      int j;
      if (k < m)
      {
        localg = (g)localArrayList.get(k);
        int n = localg.field_favProto.syG.size();
        j = 0;
        label219:
        if (j < n)
        {
          localObject = (anm)localg.field_favProto.syG.get(j);
          if (((((anm)localObject).dataType == 8) && (!ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d((anm)localObject)))) || ((((anm)localObject).dataType != 2) && (((anm)localObject).dataType != 8))) {
            break label435;
          }
          i locali = new i(localg, (anm)localObject);
          this.mXB.add(locali);
          if ((str == null) || (!str.equals(((anm)localObject).fEa))) {
            break label435;
          }
          i = this.mXB.size() - 1;
        }
      }
      for (;;)
      {
        j += 1;
        break label219;
        bool1 = false;
        break;
        j = i;
        if (str == null)
        {
          j = i;
          if (localg.field_localId == this.wKR) {
            j = this.mXB.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label185;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.wKK.notifyDataSetChanged();
        this.mLL.post(new Runnable()
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
  
  private void nR(boolean paramBoolean)
  {
    AppMethodBeat.i(106759);
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = this.wKK.LL(this.wKJ);
    if (localObject1 == null)
    {
      AppMethodBeat.o(106759);
      return;
    }
    if (((i)localObject1).fDI.SyU != 0)
    {
      AppMethodBeat.o(106759);
      return;
    }
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
    localArrayList2.add(getString(s.i.save_img_to_local));
    localObject1 = com.tencent.mm.plugin.fav.a.b.d(((i)localObject1).fDI);
    if (((this.wKP) || (this.wKO)) && (!Util.isNullOrNil((String)localObject1)))
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(s.i.chatting_image_long_click_photo_trans));
    }
    localArrayList1.add(Integer.valueOf(5));
    localArrayList2.add(getString(s.i.chatting_image_long_click_photo_edit));
    final b localb = (b)this.wKN.get(localObject1);
    Object localObject2;
    if ((localb != null) && (localb.wLe != null))
    {
      localObject2 = localb.wLe;
      Object localObject3 = com.tencent.mm.pluginsdk.ui.tools.p.RxG;
      localObject3 = com.tencent.mm.pluginsdk.ui.tools.p.d((rz)localObject2);
      com.tencent.mm.pluginsdk.ui.tools.p localp = com.tencent.mm.pluginsdk.ui.tools.p.RxG;
      int i = com.tencent.mm.pluginsdk.ui.tools.p.e((rz)localObject2);
      if (!Util.isNullOrNil((String)localObject3))
      {
        localArrayList1.add(Integer.valueOf(3));
        localArrayList2.add(this.oxq.adg(i));
      }
    }
    for (;;)
    {
      if (this.wKL == null) {
        this.wKL = new e(getContext(), 1, false);
      }
      this.wKL.ODT = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(106744);
          FavImgGalleryUI.e(FavImgGalleryUI.this).setFooterView(null);
          paramAnonymouso.clear();
          paramAnonymouso.setHeaderTitle("");
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
              paramAnonymouso.d(((Integer)localArrayList1.get(i)).intValue(), (CharSequence)localArrayList2.get(i));
            }
          }
          AppMethodBeat.o(106744);
        }
      };
      this.wKL.ODU = this.uMM;
      this.wKL.XbB = new e.b()
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
        this.wKL.eik();
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        com.tencent.mm.kernel.h.aHH();
        if ((com.tencent.mm.kernel.h.aHF().kcd.bih() != 0) && (paramBoolean) && (!this.wKP)) {
          this.wKQ.scan((String)localObject1);
        }
      }
      AppMethodBeat.o(106759);
      return;
      localObject2 = new rx();
      ((rx)localObject2).fRg.fwK = System.currentTimeMillis();
      ((rx)localObject2).fRg.filePath = ((String)localObject1);
      EventCenter.instance.publish((IEvent)localObject2);
    }
  }
  
  public final MultiTouchImageView dkM()
  {
    AppMethodBeat.i(106767);
    int i = this.mLL.getSelectedItemPosition();
    Object localObject = this.mLL;
    localObject = ((MMGestureGallery)localObject).getChildAt(i - ((MMGestureGallery)localObject).getFirstVisiblePosition());
    if (localObject == null)
    {
      Log.i("MicroMsg.FavImgGalleryUI", "getCurView() pos:%s firstPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mLL.getFirstVisiblePosition()) });
      AppMethodBeat.o(106767);
      return null;
    }
    if ((localObject instanceof MultiTouchImageView))
    {
      localObject = (MultiTouchImageView)localObject;
      AppMethodBeat.o(106767);
      return localObject;
    }
    localObject = (MultiTouchImageView)((View)localObject).findViewById(s.e.image);
    AppMethodBeat.o(106767);
    return localObject;
  }
  
  public final String dkN()
  {
    AppMethodBeat.i(106768);
    int i = this.mLL.getSelectedItemPosition();
    String str = this.wKK.LL(i).fDI.fEa;
    AppMethodBeat.o(106768);
    return str;
  }
  
  public final String dlb()
  {
    AppMethodBeat.i(106766);
    Object localObject = this.wKK.LL(this.wKJ);
    if (localObject == null)
    {
      AppMethodBeat.o(106766);
      return "";
    }
    localObject = com.tencent.mm.plugin.fav.a.b.d(((i)localObject).fDI);
    AppMethodBeat.o(106766);
    return localObject;
  }
  
  public final void e(final com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(106770);
    if (paramc != null)
    {
      Log.v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", new Object[] { Integer.valueOf(paramc.field_status) });
      i locali = this.wKK.LL(this.wKJ);
      if ((locali != null) && (Util.nullAs(paramc.field_dataId, "").equals(locali.fDI.fEa))) {
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
              ((FavImgGalleryUI.c)localObject).wLi.setText(i + "%");
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
    AppMethodBeat.i(233241);
    Object localObject = this.wKK.LL(this.wKJ);
    if ((localObject == null) || (((i)localObject).fDI == null))
    {
      AppMethodBeat.o(233241);
      return null;
    }
    localObject = ((i)localObject).fDI.SxP;
    AppMethodBeat.o(233241);
    return localObject;
  }
  
  public final String getFileId()
  {
    AppMethodBeat.i(233238);
    Object localObject = this.wKK.LL(this.wKJ);
    if ((localObject == null) || (((i)localObject).fDI == null))
    {
      AppMethodBeat.o(233238);
      return null;
    }
    localObject = ((i)localObject).fDI.Rwb;
    AppMethodBeat.o(233238);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return s.f.fav_img_gallery_ui;
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
      i locali = this.wKK.LL(this.wKJ);
      if (locali == null)
      {
        Log.i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
        AppMethodBeat.o(106771);
        return;
      }
      new k();
      if (k.v(locali.wKI))
      {
        com.tencent.mm.ui.base.h.cO(getContext(), getString(s.i.Fav_NotDownload_CannotForward));
        AppMethodBeat.o(106771);
        return;
      }
      String str = paramIntent.getStringExtra("Select_Conv_User");
      Log.d("MicroMsg.FavImgGalleryUI", "select %s for sending", new Object[] { str });
      final s locals = com.tencent.mm.ui.base.h.a(getContext(), getString(s.i.favorite_forward_tips), false, null);
      l.a(getContext(), str, locali.wKI, locali.fDI, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164090);
          locals.dismiss();
          com.tencent.mm.ui.widget.snackbar.b.r(FavImgGalleryUI.this, FavImgGalleryUI.this.getString(s.i.fav_finish_sent));
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
    if (com.tencent.mm.compatible.util.d.qV(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.wKQ = new r(this, this, this);
      this.fNQ = getIntent().getBooleanExtra("show_share", true);
      this.mLL = ((MMGestureGallery)findViewById(s.e.gallery));
      this.wKM = new d(this.mLL, this, this);
      this.mLL.setVerticalFadingEdgeEnabled(false);
      this.mLL.setHorizontalFadingEdgeEnabled(false);
      this.mLL.setOnItemSelectedListener(this);
      this.mLL.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void bwB()
        {
          AppMethodBeat.i(106737);
          if (FavImgGalleryUI.a(FavImgGalleryUI.this).wNd != 1) {
            FavImgGalleryUI.b(FavImgGalleryUI.this).nQ(true);
          }
          AppMethodBeat.o(106737);
        }
      });
      if (this.fNQ) {
        this.mLL.setLongClickOverListener(new MMGestureGallery.c()
        {
          public final void bwC()
          {
            AppMethodBeat.i(106741);
            if (FavImgGalleryUI.a(FavImgGalleryUI.this).wNd == 1)
            {
              AppMethodBeat.o(106741);
              return;
            }
            if ((!FavImgGalleryUI.this.isFinishing()) && (!FavImgGalleryUI.this.activityHasDestroyed()))
            {
              ad.b localb = ad.beh().I("basescanui@datacenter", true);
              localb.k("key_basescanui_screen_position", Boolean.TRUE);
              localb.k("key_basescanui_screen_x", Float.valueOf(FavImgGalleryUI.c(FavImgGalleryUI.this).getXDown()));
              localb.k("key_basescanui_screen_y", Float.valueOf(FavImgGalleryUI.c(FavImgGalleryUI.this).getYDown()));
              if ((FavImgGalleryUI.a(FavImgGalleryUI.this).wNd == 0) || (FavImgGalleryUI.a(FavImgGalleryUI.this).wNd == 2))
              {
                FavImgGalleryUI.a(FavImgGalleryUI.this, n.fBP());
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
      this.mXB = new ArrayList();
      this.wKK = new a((byte)0);
      this.mLL.setAdapter(this.wKK);
      ate();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(106742);
          FavImgGalleryUI.b(FavImgGalleryUI.this).nQ(true);
          AppMethodBeat.o(106742);
          return true;
        }
      });
      this.oxq = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
      {
        public final void bPS()
        {
          AppMethodBeat.i(106743);
          FavImgGalleryUI.d(FavImgGalleryUI.this);
          AppMethodBeat.o(106743);
        }
      });
      EventCenter.instance.addListener(this.wKS);
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
    EventCenter.instance.removeListener(this.wKS);
    if (this.wKM != null) {
      this.wKM.onDestroy();
    }
    if (this.wKQ != null) {
      this.wKQ.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(106762);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(106769);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavImgGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    this.wKJ = paramInt;
    Log.d("MicroMsg.FavImgGalleryUI", "pos:".concat(String.valueOf(paramInt)));
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).hJx();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavImgGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(106769);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106765);
    if (paramInt == 4)
    {
      this.wKM.nQ(true);
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
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b(this);
    f.d(false, true, true);
    AppMethodBeat.o(106764);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106763);
    super.onResume();
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(this);
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
    SparseBooleanArray wLd;
    
    private a()
    {
      AppMethodBeat.i(106749);
      this.wLd = new SparseBooleanArray();
      AppMethodBeat.o(106749);
    }
    
    private Bitmap a(i parami)
    {
      AppMethodBeat.i(106754);
      if (parami != null)
      {
        parami = o.a(parami.fDI, parami.wKI);
        if (parami != null)
        {
          AppMethodBeat.o(106754);
          return parami;
        }
      }
      parami = com.tencent.mm.compatible.f.a.decodeResource(FavImgGalleryUI.this.getResources(), s.h.download_image_icon);
      AppMethodBeat.o(106754);
      return parami;
    }
    
    private void a(FavImgGalleryUI.c paramc, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(106753);
      paramc.progressBar.setVisibility(8);
      paramc.wLi.setVisibility(8);
      paramc.pDJ.setVisibility(8);
      paramc.wLg.setVisibility(0);
      paramc.wLj.setVisibility(8);
      b(paramc, paramBitmap, paramString);
      AppMethodBeat.o(106753);
    }
    
    private void b(FavImgGalleryUI.c paramc, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(106755);
      ForceGpuUtil.decideLayerType(paramc.wLh, paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = paramc.wLh.getWidth();
      int j = paramc.wLh.getHeight();
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
        paramc.wLh.setImageMatrix(localMatrix);
        paramc.wLh.di(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramc.wLh.setMaxZoomDoubleTab(true);
        if (!Util.isNullOrNil(paramString)) {
          break label524;
        }
        paramc.wLh.setImageBitmap(paramBitmap);
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
          paramc.wLh.setGifDrawable(paramString);
          paramc.wLh.mq(com.tencent.mm.ci.a.kr(FavImgGalleryUI.this.getContext()), com.tencent.mm.ci.a.ks(FavImgGalleryUI.this.getContext()));
          paramc.wLh.di(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          paramc.wLh.start();
          paramc.wLh.hJy();
          AppMethodBeat.o(106755);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.FavImgGalleryUI", Util.stackTraceToString(paramString));
          paramc.wLh.setImageBitmap(paramBitmap);
          AppMethodBeat.o(106755);
          return;
        }
        label627:
        f1 = 1.0F;
      }
    }
    
    public final i LL(int paramInt)
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
        paramView = View.inflate(FavImgGalleryUI.this.getContext(), s.f.fav_img_detail_item, null);
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
        locali = LL(paramInt);
        boolean bool = this.wLd.get(paramInt, true);
        this.wLd.put(paramInt, false);
        localObject = o.a(locali.fDI, locali.wKI, bool);
        if (locali.wKI != null) {
          Log.i("MicroMsg.FavImgGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locali.wKI.field_id), Long.valueOf(locali.wKI.field_localId), Integer.valueOf(locali.wKI.field_itemStatus) });
        }
        if (locali.fDI != null) {
          Log.i("MicroMsg.FavImgGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { locali.fDI.fEa, locali.fDI.Rwb, locali.fDI.SxP, Long.valueOf(locali.fDI.Syi), locali.fDI.lmm, locali.fDI.SxK, Long.valueOf(locali.fDI.Sys) });
        }
        if (localObject != null) {
          break label794;
        }
        FavImgGalleryUI.this.enableOptionMenu(false);
        Log.w("MicroMsg.FavImgGalleryUI", "get big image fail");
        com.tencent.mm.plugin.fav.a.r localr = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage();
        if (locali.fDI == null) {
          break label561;
        }
        localObject = locali.fDI.fEa;
        label434:
        localObject = localr.aAb((String)localObject);
        if (localObject != null) {
          break label640;
        }
        paramViewGroup.wLj.setVisibility(8);
        if ((locali.wKI == null) || (locali.wKI.field_id >= 0)) {
          break label569;
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
        AppMethodBeat.o(106752);
        return paramView;
        paramViewGroup = (FavImgGalleryUI.c)paramView.getTag();
        break;
        label561:
        localObject = "";
        break label434;
        label569:
        paramViewGroup.progressBar.setVisibility(8);
        paramViewGroup.wLi.setVisibility(8);
        paramViewGroup.pDJ.setVisibility(8);
        paramViewGroup.wLg.setVisibility(0);
        if (locali.fDI.SyU != 0) {
          paramViewGroup.wLj.setVisibility(0);
        }
        b(paramViewGroup, a(locali), "");
      }
      label640:
      Log.i("MicroMsg.FavImgGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject).field_status) });
      paramViewGroup.progressBar.setVisibility(0);
      paramViewGroup.wLi.setVisibility(0);
      paramViewGroup.pDJ.setVisibility(0);
      paramViewGroup.wLg.setVisibility(8);
      paramViewGroup.pDJ.setImageBitmap(a(locali));
      if (((com.tencent.mm.plugin.fav.a.c)localObject).field_totalLen > 0) {}
      for (paramInt = ((com.tencent.mm.plugin.fav.a.c)localObject).field_offset * 100 / ((com.tencent.mm.plugin.fav.a.c)localObject).field_totalLen - 1;; paramInt = 0)
      {
        int i = paramInt;
        if (paramInt < 0) {
          i = 0;
        }
        paramViewGroup.progressBar.setProgress(i);
        paramViewGroup.wLi.setText(i + "%");
        AppMethodBeat.o(106752);
        return paramView;
      }
      label794:
      FavImgGalleryUI.this.enableOptionMenu(true);
      if (ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d(locali.fDI))) {
        a(paramViewGroup, (Bitmap)localObject, com.tencent.mm.plugin.fav.a.b.d(locali.fDI));
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
    rz wLe;
    boolean wLf;
  }
  
  final class c
  {
    ImageView pDJ;
    ProgressBar progressBar;
    View wLg;
    MultiTouchImageView wLh;
    TextView wLi;
    LinearLayout wLj;
    TextView wLk;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI
 * JD-Core Version:    0.7.0.1
 */