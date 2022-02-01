package com.tencent.mm.plugin.fav.ui;

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
import com.tencent.mm.autogen.a.df;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.n;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
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
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class FavImgGalleryUI
  extends MMActivity
  implements AdapterView.OnItemSelectedListener, com.tencent.mm.plugin.fav.a.q, d.a, p.a, a.a<String, com.tencent.mm.plugin.scanner.word.b>
{
  private int Ahg;
  private a Ahh;
  private com.tencent.mm.ui.widget.a.f Ahi;
  private d Ahj;
  private Map<String, b> Ahk;
  private boolean Ahl;
  private boolean Ahm;
  private p Ahn;
  private long Aho;
  private IListener Ahp;
  private boolean hTH;
  private MMGestureGallery pIt;
  private ArrayList<i> pUj;
  private ScanCodeSheetItemLogic rAP;
  private u.i xVp;
  
  public FavImgGalleryUI()
  {
    AppMethodBeat.i(106757);
    this.Ahg = 0;
    this.hTH = true;
    this.Ahk = new HashMap();
    this.Ahm = n.gPv();
    this.xVp = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(106746);
        i locali = FavImgGalleryUI.i(FavImgGalleryUI.this).MI(FavImgGalleryUI.h(FavImgGalleryUI.this));
        if (locali == null)
        {
          AppMethodBeat.o(106746);
          return;
        }
        String str = com.tencent.mm.plugin.fav.a.b.d(locali.hIy);
        if (!com.tencent.mm.vfs.y.ZC(str))
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
          com.tencent.mm.plugin.fav.a.h.I(FavImgGalleryUI.j(FavImgGalleryUI.this), 1);
          if (ImgUtil.isGif(str))
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
            paramAnonymousMenuItem.putExtra("select_is_ret", true);
            com.tencent.mm.br.c.d(FavImgGalleryUI.this, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 1);
            AppMethodBeat.o(106746);
            return;
          }
          com.tencent.mm.plugin.fav.a.b.a(str, FavImgGalleryUI.this, locali.hIy.pbn);
          AppMethodBeat.o(106746);
          return;
          com.tencent.mm.plugin.fav.a.b.c(str, FavImgGalleryUI.this);
          com.tencent.mm.plugin.fav.a.h.I(FavImgGalleryUI.j(FavImgGalleryUI.this), 0);
          AppMethodBeat.o(106746);
          return;
          FavImgGalleryUI.a(str, FavImgGalleryUI.this.getString(q.i.favorite_save_fail), FavImgGalleryUI.this, locali.hIy.pbn);
          AppMethodBeat.o(106746);
          return;
          if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FavImgGalleryUI.this.getContext()))
          {
            FavImgGalleryUI.a(FavImgGalleryUI.this).dSc();
            AppMethodBeat.o(106746);
            return;
            FavImgGalleryUI.k(FavImgGalleryUI.this);
          }
        }
      }
    };
    this.Ahp = new IListener(com.tencent.mm.app.f.hfK) {};
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
    ExportFileUtil.a(paramContext, paramString1, new ExportFileUtil.a()
    {
      public final void cg(String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(274380);
        Toast.makeText(FavImgGalleryUI.this, FavImgGalleryUI.this.getString(q.i.cropimage_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymousString2) }), 1).show();
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(274384);
            String str = com.tencent.mm.vfs.y.bub(paramAnonymousString2);
            com.tencent.mm.platformtools.s locals = com.tencent.mm.platformtools.s.pBi;
            com.tencent.mm.platformtools.s.ci(str, FavImgGalleryUI.12.this.Ahw);
            AppMethodBeat.o(274384);
          }
        });
        AppMethodBeat.o(274380);
      }
      
      public final void ch(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(274382);
        Toast.makeText(FavImgGalleryUI.this, paramString2, 1).show();
        AppMethodBeat.o(274382);
      }
    });
    AppMethodBeat.o(164093);
  }
  
  private void aNm()
  {
    AppMethodBeat.i(106761);
    this.Aho = getIntent().getLongExtra("key_detail_info_id", -1L);
    String str = getIntent().getStringExtra("key_detail_data_id");
    boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    Object localObject = getIntent().getStringExtra("fav_note_xml");
    ArrayList localArrayList = new ArrayList();
    g localg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(this.Aho);
    long l = this.Aho;
    boolean bool1;
    if (localg != null)
    {
      bool1 = true;
      Log.i("MicroMsg.FavImgGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
      if ((!bool2) || (Util.isNullOrNil((String)localObject))) {
        break label439;
      }
      localg = com.tencent.mm.plugin.fav.a.b.atV((String)localObject);
    }
    label436:
    label439:
    for (;;)
    {
      if (localg != null) {
        localArrayList.add(localg);
      }
      this.pUj.clear();
      final int i = -1;
      int m = localArrayList.size();
      int k = 0;
      label186:
      int j;
      if (k < m)
      {
        localg = (g)localArrayList.get(k);
        int n = localg.field_favProto.vEn.size();
        j = 0;
        label220:
        if (j < n)
        {
          localObject = (arf)localg.field_favProto.vEn.get(j);
          if (((((arf)localObject).dataType == 8) && (!ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d((arf)localObject)))) || ((((arf)localObject).dataType != 2) && (((arf)localObject).dataType != 8))) {
            break label436;
          }
          i locali = new i(localg, (arf)localObject);
          this.pUj.add(locali);
          if ((str == null) || (!str.equals(((arf)localObject).hIQ))) {
            break label436;
          }
          i = this.pUj.size() - 1;
        }
      }
      for (;;)
      {
        j += 1;
        break label220;
        bool1 = false;
        break;
        j = i;
        if (str == null)
        {
          j = i;
          if (localg.field_localId == this.Aho) {
            j = this.pUj.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label186;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.Ahh.notifyDataSetChanged();
        this.pIt.post(new Runnable()
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
  
  private void pr(boolean paramBoolean)
  {
    AppMethodBeat.i(106759);
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = this.Ahh.MI(this.Ahg);
    if (localObject1 == null)
    {
      AppMethodBeat.o(106759);
      return;
    }
    if (((i)localObject1).hIy.ZzM != 0)
    {
      AppMethodBeat.o(106759);
      return;
    }
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
    localArrayList2.add(getString(q.i.save_img_to_local));
    localObject1 = com.tencent.mm.plugin.fav.a.b.d(((i)localObject1).hIy);
    if (((this.Ahm) || (this.Ahl)) && (!Util.isNullOrNil((String)localObject1)))
    {
      localArrayList1.add(Integer.valueOf(4));
      localArrayList2.add(getString(q.i.chatting_image_long_click_photo_trans));
    }
    localArrayList1.add(Integer.valueOf(5));
    localArrayList2.add(getString(q.i.chatting_image_long_click_photo_edit));
    final b localb = (b)this.Ahk.get(localObject1);
    Object localObject2;
    if ((localb != null) && (localb.AhB != null))
    {
      localObject2 = localb.AhB;
      Object localObject3 = o.YtW;
      localObject3 = o.d((to)localObject2);
      o localo = o.YtW;
      int i = o.e((to)localObject2);
      if (!Util.isNullOrNil((String)localObject3))
      {
        localArrayList1.add(Integer.valueOf(3));
        localArrayList2.add(this.rAP.ahD(i));
      }
    }
    for (;;)
    {
      if (this.Ahi == null) {
        this.Ahi = new com.tencent.mm.ui.widget.a.f(getContext(), 1, false);
      }
      this.Ahi.Vtg = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(106744);
          FavImgGalleryUI.e(FavImgGalleryUI.this).setFooterView(null);
          paramAnonymouss.clear();
          paramAnonymouss.setHeaderTitle("");
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
              paramAnonymouss.c(((Integer)localArrayList1.get(i)).intValue(), (CharSequence)localArrayList2.get(i));
            }
          }
          AppMethodBeat.o(106744);
        }
      };
      this.Ahi.GAC = this.xVp;
      this.Ahi.aeLi = new f.b()
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
        this.Ahi.dDn();
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        com.tencent.mm.kernel.h.baF();
        if ((com.tencent.mm.kernel.h.baD().mCm.bFQ() != 0) && (paramBoolean) && (!this.Ahm)) {
          this.Ahn.scan((String)localObject1);
        }
      }
      AppMethodBeat.o(106759);
      return;
      localObject2 = new tm();
      ((tm)localObject2).hXd.hBk = System.currentTimeMillis();
      ((tm)localObject2).hXd.filePath = ((String)localObject1);
      ((tm)localObject2).publish();
    }
  }
  
  public final MultiTouchImageView dRC()
  {
    AppMethodBeat.i(106767);
    int i = this.pIt.getSelectedItemPosition();
    Object localObject = this.pIt;
    localObject = ((MMGestureGallery)localObject).getChildAt(i - ((MMGestureGallery)localObject).getFirstVisiblePosition());
    if (localObject == null)
    {
      Log.i("MicroMsg.FavImgGalleryUI", "getCurView() pos:%s firstPos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.pIt.getFirstVisiblePosition()) });
      AppMethodBeat.o(106767);
      return null;
    }
    if ((localObject instanceof MultiTouchImageView))
    {
      localObject = (MultiTouchImageView)localObject;
      AppMethodBeat.o(106767);
      return localObject;
    }
    localObject = (MultiTouchImageView)((View)localObject).findViewById(q.e.image);
    AppMethodBeat.o(106767);
    return localObject;
  }
  
  public final String dRD()
  {
    AppMethodBeat.i(106768);
    int i = this.pIt.getSelectedItemPosition();
    String str = this.Ahh.MI(i).hIy.hIQ;
    AppMethodBeat.o(106768);
    return str;
  }
  
  public final String dRR()
  {
    AppMethodBeat.i(106766);
    Object localObject = this.Ahh.MI(this.Ahg);
    if (localObject == null)
    {
      AppMethodBeat.o(106766);
      return "";
    }
    localObject = com.tencent.mm.plugin.fav.a.b.d(((i)localObject).hIy);
    AppMethodBeat.o(106766);
    return localObject;
  }
  
  public final void e(final com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(106770);
    if (paramc != null)
    {
      Log.v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", new Object[] { Integer.valueOf(paramc.field_status) });
      i locali = this.Ahh.MI(this.Ahg);
      if ((locali != null) && (Util.nullAs(paramc.field_dataId, "").equals(locali.hIy.hIQ))) {
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
              ((FavImgGalleryUI.c)localObject).AhF.setText(i + "%");
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
    AppMethodBeat.i(274389);
    Object localObject = this.Ahh.MI(this.Ahg);
    if ((localObject == null) || (((i)localObject).hIy == null))
    {
      AppMethodBeat.o(274389);
      return null;
    }
    localObject = ((i)localObject).hIy.ZyH;
    AppMethodBeat.o(274389);
    return localObject;
  }
  
  public final String getFileId()
  {
    AppMethodBeat.i(274388);
    Object localObject = this.Ahh.MI(this.Ahg);
    if ((localObject == null) || (((i)localObject).hIy == null))
    {
      AppMethodBeat.o(274388);
      return null;
    }
    localObject = ((i)localObject).hIy.Ysw;
    AppMethodBeat.o(274388);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return q.f.fav_img_gallery_ui;
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
      i locali = this.Ahh.MI(this.Ahg);
      if (locali == null)
      {
        Log.i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
        AppMethodBeat.o(106771);
        return;
      }
      new com.tencent.mm.plugin.fav.a.k();
      if (com.tencent.mm.plugin.fav.a.k.v(locali.Ahf))
      {
        com.tencent.mm.ui.base.k.cZ(getContext(), getString(q.i.Fav_NotDownload_CannotForward));
        AppMethodBeat.o(106771);
        return;
      }
      String str = paramIntent.getStringExtra("Select_Conv_User");
      Log.d("MicroMsg.FavImgGalleryUI", "select %s for sending", new Object[] { str });
      final w localw = com.tencent.mm.ui.base.k.a(getContext(), getString(q.i.favorite_forward_tips), false, null);
      l.a(getContext(), str, locali.Ahf, locali.hIy, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164090);
          localw.dismiss();
          com.tencent.mm.ui.widget.snackbar.b.u(FavImgGalleryUI.this, FavImgGalleryUI.this.getString(q.i.fav_finish_sent));
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
    if (com.tencent.mm.compatible.util.d.rb(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.Ahn = new p(this, this, this);
      this.hTH = getIntent().getBooleanExtra("show_share", true);
      this.pIt = ((MMGestureGallery)findViewById(q.e.gallery));
      this.Ahj = new d(this.pIt, this, this);
      this.pIt.setVerticalFadingEdgeEnabled(false);
      this.pIt.setHorizontalFadingEdgeEnabled(false);
      this.pIt.setOnItemSelectedListener(this);
      this.pIt.setSingleClickOverListener(new MMGestureGallery.f()
      {
        public final void singleClickOver()
        {
          AppMethodBeat.i(106737);
          if (FavImgGalleryUI.a(FavImgGalleryUI.this).AjA != 1) {
            FavImgGalleryUI.b(FavImgGalleryUI.this).pq(true);
          }
          AppMethodBeat.o(106737);
        }
      });
      if (this.hTH) {
        this.pIt.setLongClickOverListener(new MMGestureGallery.c()
        {
          public final void longClickOver()
          {
            AppMethodBeat.i(106741);
            if (FavImgGalleryUI.a(FavImgGalleryUI.this).AjA == 1)
            {
              AppMethodBeat.o(106741);
              return;
            }
            if ((!FavImgGalleryUI.this.isFinishing()) && (!FavImgGalleryUI.this.activityHasDestroyed()))
            {
              ad.b localb = ad.bCb().M("basescanui@datacenter", true);
              localb.q("key_basescanui_screen_position", Boolean.TRUE);
              localb.q("key_basescanui_screen_x", Float.valueOf(FavImgGalleryUI.c(FavImgGalleryUI.this).getXDown()));
              localb.q("key_basescanui_screen_y", Float.valueOf(FavImgGalleryUI.c(FavImgGalleryUI.this).getYDown()));
              if ((FavImgGalleryUI.a(FavImgGalleryUI.this).AjA == 0) || (FavImgGalleryUI.a(FavImgGalleryUI.this).AjA == 2))
              {
                FavImgGalleryUI.a(FavImgGalleryUI.this, n.gPt());
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
      this.pUj = new ArrayList();
      this.Ahh = new a((byte)0);
      this.pIt.setAdapter(this.Ahh);
      aNm();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(106742);
          FavImgGalleryUI.b(FavImgGalleryUI.this).pq(true);
          AppMethodBeat.o(106742);
          return true;
        }
      });
      this.rAP = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
      {
        public final void onFetchedCodeInfo()
        {
          AppMethodBeat.i(106743);
          FavImgGalleryUI.d(FavImgGalleryUI.this);
          AppMethodBeat.o(106743);
        }
      });
      this.Ahp.alive();
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
    this.Ahp.dead();
    if (this.Ahj != null) {
      this.Ahj.onDestroy();
    }
    if (this.Ahn != null) {
      this.Ahn.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(106762);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(106769);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavImgGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    this.Ahg = paramInt;
    Log.d("MicroMsg.FavImgGalleryUI", "pos:".concat(String.valueOf(paramInt)));
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).jma();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavImgGalleryUI", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(106769);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106765);
    if (paramInt == 4)
    {
      this.Ahj.pq(true);
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
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().b(this);
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(106764);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106763);
    super.onResume();
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a(this);
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
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
    SparseBooleanArray AhA;
    
    private a()
    {
      AppMethodBeat.i(106749);
      this.AhA = new SparseBooleanArray();
      AppMethodBeat.o(106749);
    }
    
    private Bitmap a(i parami)
    {
      AppMethodBeat.i(106754);
      if (parami != null)
      {
        parami = FavoriteImageServer.a(parami.hIy, parami.Ahf);
        if (parami != null)
        {
          AppMethodBeat.o(106754);
          return parami;
        }
      }
      parami = com.tencent.mm.compatible.f.a.decodeResource(FavImgGalleryUI.this.getResources(), q.h.download_image_icon);
      AppMethodBeat.o(106754);
      return parami;
    }
    
    private void a(FavImgGalleryUI.c paramc, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(106753);
      paramc.progressBar.setVisibility(8);
      paramc.AhF.setVisibility(8);
      paramc.sIV.setVisibility(8);
      paramc.AhD.setVisibility(0);
      paramc.AhG.setVisibility(8);
      b(paramc, paramBitmap, paramString);
      AppMethodBeat.o(106753);
    }
    
    private void b(FavImgGalleryUI.c paramc, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(106755);
      ForceGpuUtil.decideLayerType(paramc.AhE, paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = paramc.AhE.getWidth();
      int j = paramc.AhE.getHeight();
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
        paramc.AhE.setImageMatrix(localMatrix);
        paramc.AhE.dU(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramc.AhE.setMaxZoomDoubleTab(true);
        if (!Util.isNullOrNil(paramString)) {
          break label524;
        }
        paramc.AhE.setImageBitmap(paramBitmap);
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
          paramc.AhE.setGifDrawable(paramString);
          paramc.AhE.ok(com.tencent.mm.cd.a.ms(FavImgGalleryUI.this.getContext()), com.tencent.mm.cd.a.mt(FavImgGalleryUI.this.getContext()));
          paramc.AhE.dU(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          paramc.AhE.start();
          paramc.AhE.jmb();
          AppMethodBeat.o(106755);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.FavImgGalleryUI", Util.stackTraceToString(paramString));
          paramc.AhE.setImageBitmap(paramBitmap);
          AppMethodBeat.o(106755);
          return;
        }
        label627:
        f1 = 1.0F;
      }
    }
    
    public final i MI(int paramInt)
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
        paramView = View.inflate(FavImgGalleryUI.this.getContext(), q.f.fav_img_detail_item, null);
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
        locali = MI(paramInt);
        boolean bool = this.AhA.get(paramInt, true);
        this.AhA.put(paramInt, false);
        localObject = FavoriteImageServer.a(locali.hIy, locali.Ahf, bool);
        if (locali.Ahf != null) {
          Log.i("MicroMsg.FavImgGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locali.Ahf.field_id), Long.valueOf(locali.Ahf.field_localId), Integer.valueOf(locali.Ahf.field_itemStatus) });
        }
        if (locali.hIy != null) {
          Log.i("MicroMsg.FavImgGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { locali.hIy.hIQ, locali.hIy.Ysw, locali.hIy.ZyH, Long.valueOf(locali.hIy.Zza), locali.hIy.nRr, locali.hIy.ZyC, Long.valueOf(locali.hIy.Zzk) });
        }
        if (localObject != null) {
          break label794;
        }
        FavImgGalleryUI.this.enableOptionMenu(false);
        Log.w("MicroMsg.FavImgGalleryUI", "get big image fail");
        r localr = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage();
        if (locali.hIy == null) {
          break label561;
        }
        localObject = locali.hIy.hIQ;
        label434:
        localObject = localr.aui((String)localObject);
        if (localObject != null) {
          break label640;
        }
        paramViewGroup.AhG.setVisibility(8);
        if ((locali.Ahf == null) || (locali.Ahf.field_id >= 0)) {
          break label569;
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
        AppMethodBeat.o(106752);
        return paramView;
        paramViewGroup = (FavImgGalleryUI.c)paramView.getTag();
        break;
        label561:
        localObject = "";
        break label434;
        label569:
        paramViewGroup.progressBar.setVisibility(8);
        paramViewGroup.AhF.setVisibility(8);
        paramViewGroup.sIV.setVisibility(8);
        paramViewGroup.AhD.setVisibility(0);
        if (locali.hIy.ZzM != 0) {
          paramViewGroup.AhG.setVisibility(0);
        }
        b(paramViewGroup, a(locali), "");
      }
      label640:
      Log.i("MicroMsg.FavImgGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject).field_status) });
      paramViewGroup.progressBar.setVisibility(0);
      paramViewGroup.AhF.setVisibility(0);
      paramViewGroup.sIV.setVisibility(0);
      paramViewGroup.AhD.setVisibility(8);
      paramViewGroup.sIV.setImageBitmap(a(locali));
      if (((com.tencent.mm.plugin.fav.a.c)localObject).field_totalLen > 0) {}
      for (paramInt = ((com.tencent.mm.plugin.fav.a.c)localObject).field_offset * 100 / ((com.tencent.mm.plugin.fav.a.c)localObject).field_totalLen - 1;; paramInt = 0)
      {
        int i = paramInt;
        if (paramInt < 0) {
          i = 0;
        }
        paramViewGroup.progressBar.setProgress(i);
        paramViewGroup.AhF.setText(i + "%");
        AppMethodBeat.o(106752);
        return paramView;
      }
      label794:
      FavImgGalleryUI.this.enableOptionMenu(true);
      if (ImgUtil.isGif(com.tencent.mm.plugin.fav.a.b.d(locali.hIy))) {
        a(paramViewGroup, (Bitmap)localObject, com.tencent.mm.plugin.fav.a.b.d(locali.hIy));
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
    to AhB;
    boolean AhC;
  }
  
  final class c
  {
    View AhD;
    MultiTouchImageView AhE;
    TextView AhF;
    LinearLayout AhG;
    TextView AhH;
    ProgressBar progressBar;
    ImageView sIV;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI
 * JD-Core Version:    0.7.0.1
 */