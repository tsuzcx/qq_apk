package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac.b;
import com.tencent.mm.autogen.mmdata.rpt.ql;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.b.a;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.plugin.gallery.b.c;
import com.tencent.mm.plugin.gallery.b.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.h;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.PrivateAlbumItem;
import com.tencent.mm.plugin.gallery.model.c.c;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.l.a;
import com.tencent.mm.plugin.gallery.model.l.b;
import com.tencent.mm.plugin.gallery.model.l.c;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.r;
import com.tencent.mm.plugin.gallery.model.r.a;
import com.tencent.mm.plugin.gallery.model.r.c;
import com.tencent.mm.plugin.gallery.model.t.a;
import com.tencent.mm.plugin.gallery.model.t.g;
import com.tencent.mm.plugin.gallery.model.t.h;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.AlbumChooserView.a;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(19)
public class AlbumPreviewUI
  extends MMActivity
  implements l.c
{
  static long start = 0L;
  protected int GzH;
  private LinearLayout HFR;
  protected String HLD;
  private a.f HLJ;
  private boolean HMA;
  private boolean HMB;
  boolean HMC;
  private int HMD;
  private int HME;
  private long HMF;
  private long HMG;
  private long HMH;
  protected int HMI;
  private String HMJ;
  private l.b HMK;
  private boolean HML;
  private boolean HMM;
  private String HMN;
  protected int HMO;
  private boolean HMP;
  private f HMQ;
  private volatile long HMR;
  protected MenuItem.OnMenuItemClickListener HMS;
  private GalleryItem.AlbumItem HMT;
  private a.d HMU;
  private volatile AlbumPreviewUI.b HMV;
  private HashMap<String, Long> HMW;
  boolean HMX;
  GalleryItem.MediaItem HMY;
  private r.c HMZ;
  protected RecyclerView HMd;
  public TextView HMe;
  private boolean HMf;
  private boolean HMg;
  protected a HMh;
  private TextView HMi;
  private TextView HMj;
  private TextView HMk;
  private ImageFolderMgrView HMl;
  private RelativeLayout HMm;
  private TextView HMn;
  private TextView HMo;
  private ImageButton HMp;
  private LinearLayout HMq;
  private String HMr;
  private String HMs;
  private String HMt;
  private boolean HMu;
  private boolean HMv;
  private boolean HMw;
  private boolean HMx;
  private boolean HMy;
  private boolean HMz;
  private String HNa;
  protected String hQQ;
  private List<Long> idList;
  private double latitude;
  private double longitude;
  private int lyw;
  private ProgressDialog lzP;
  protected int mpb;
  private boolean qgg;
  protected int qqa;
  private int selectType;
  protected String toUser;
  private int uRj;
  private int vBs;
  public boolean wQK;
  private boolean xCI;
  
  public AlbumPreviewUI()
  {
    AppMethodBeat.i(111463);
    this.HMv = false;
    this.wQK = false;
    this.HMA = false;
    this.HMB = false;
    this.HMC = false;
    this.HMD = 0;
    this.HME = 0;
    this.HMF = 0L;
    this.HMH = -1L;
    this.xCI = true;
    this.idList = new ArrayList();
    this.selectType = 3;
    this.HMR = -1L;
    this.HMS = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(164796);
        int i = paramAnonymousMenuItem.getItemId();
        Log.d("MicroMsg.AlbumPreviewUI", "mId: %d.", new Object[] { Integer.valueOf(i) });
        if (1 == i)
        {
          Log.i("MicroMsg.AlbumPreviewUI", "go smart gallery.");
          a.a.HFE.HFr = 1;
          com.tencent.mm.plugin.gallery.model.t.fAV().ic(AlbumPreviewUI.this.HMh.HLB);
          paramAnonymousMenuItem = new Intent(AlbumPreviewUI.this, SmartGalleryUI.class);
          paramAnonymousMenuItem.putExtra("select_type_tag", 2);
          paramAnonymousMenuItem.putExtras(AlbumPreviewUI.this.getIntent());
          paramAnonymousMenuItem.putExtra("send_raw_img", AlbumPreviewUI.this.wQK);
          AlbumPreviewUI.this.startActivityForResult(paramAnonymousMenuItem, 4382);
          AppMethodBeat.o(164796);
          return true;
        }
        boolean bool = AlbumPreviewUI.this.faD();
        AppMethodBeat.o(164796);
        return bool;
      }
    };
    this.HMW = new HashMap();
    this.HLJ = new a.f()
    {
      public final void a(int paramAnonymousInt1, View paramAnonymousView, int paramAnonymousInt2)
      {
        AppMethodBeat.i(289467);
        switch (paramAnonymousInt2)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(289467);
          return;
          AlbumPreviewUI.I(AlbumPreviewUI.this);
          AppMethodBeat.o(289467);
          return;
          AlbumPreviewUI.this.n(paramAnonymousInt1, paramAnonymousView);
        }
      }
    };
    this.HMY = null;
    this.HMZ = r.c.HIl;
    this.vBs = -1;
    this.uRj = -1;
    this.qgg = false;
    this.HNa = "";
    AppMethodBeat.o(111463);
  }
  
  private void a(int paramInt, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(289524);
    if (!j(paramMediaItem))
    {
      Log.i("MicroMsg.AlbumPreviewUI", "not support ratio");
      localObject = null;
      if ((paramMediaItem instanceof GalleryItem.ImageMediaItem)) {
        localObject = getResources().getString(b.i.gallery_select_pic_ratio_not_support);
      }
      if (localObject != null) {
        k.cZ(getContext(), (String)localObject);
      }
      AppMethodBeat.o(289524);
      return;
    }
    Object localObject = new Intent();
    if (paramMediaItem.getType() == 2)
    {
      ((Intent)localObject).putExtra("is_video", true);
      ((Intent)localObject).putExtra("video_full_path", paramMediaItem.Gcc);
    }
    if (this.mpb == 10) {
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramMediaItem.Gcc);
    }
    ((Intent)localObject).setData(Uri.parse(Uri.encode(paramMediaItem.Gcc)));
    Log.i("MicroMsg.AlbumPreviewUI", "getItem ok");
    setResult(-1, (Intent)localObject);
    a.a.HFE.au(paramMediaItem.Gcc, this.selectType, paramInt);
    finish();
    AppMethodBeat.o(289524);
  }
  
  private void a(GalleryItem.AlbumItem paramAlbumItem)
  {
    AppMethodBeat.i(111472);
    if (paramAlbumItem == null)
    {
      AppMethodBeat.o(111472);
      return;
    }
    if (paramAlbumItem.akiu) {}
    for (this.selectType = 3; Util.nullAs(this.HMs, "").equals(paramAlbumItem.albumName); this.selectType = 4)
    {
      Log.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
      AppMethodBeat.o(111472);
      return;
    }
    com.tencent.mm.plugin.gallery.model.e.fAs().addAll(this.HMh.HLB);
    Log.i("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[] { paramAlbumItem.albumName, paramAlbumItem.bud() });
    this.HMr = paramAlbumItem.bud();
    this.HMs = paramAlbumItem.albumName;
    if (Util.isNullOrNil(this.HMr))
    {
      Log.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
      this.HMr = this.HMs;
    }
    Object localObject1;
    Object localObject2;
    label225:
    int i;
    if (!Util.isNullOrNil(this.HMs))
    {
      localObject1 = this.HMh;
      localObject2 = this.HMU;
      if (localObject2 == null)
      {
        Log.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
        localObject2 = paramAlbumItem.nickName;
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          if (this.HMO != 3) {
            break label445;
          }
          localObject1 = getString(b.i.gallery_all_pic_and_video);
        }
        updateActionBarOperationAreaTxt((String)localObject1);
        WH(this.HMh.HLB.size());
        this.lzP.show();
        start = System.currentTimeMillis();
        localObject2 = this.HMs;
        i = this.HMO;
        localObject1 = localObject2;
        if (((String)localObject2).equals(getString(b.i.gallery_all_video)))
        {
          localObject1 = "";
          i = 2;
        }
        if (!(paramAlbumItem instanceof PrivateAlbumItem)) {
          break label504;
        }
        com.tencent.mm.plugin.gallery.model.e.fAn().fAS();
        this.HMR = System.currentTimeMillis();
        com.tencent.mm.plugin.gallery.model.t.fAV().HIt = true;
        localObject1 = ((PrivateAlbumItem)paramAlbumItem).HIp.HIx;
        if (!Util.isNullOrNil((String)localObject1)) {
          break label475;
        }
        Log.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
      }
    }
    for (;;)
    {
      localObject1 = "public";
      if ((paramAlbumItem instanceof PrivateAlbumItem)) {
        localObject1 = "private";
      }
      try
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(18269, new Object[] { URLEncoder.encode((String)localObject1, "utf-8"), URLEncoder.encode(paramAlbumItem.nickName, "utf-8") });
        AppMethodBeat.o(111472);
        return;
      }
      catch (Exception paramAlbumItem)
      {
        AppMethodBeat.o(111472);
      }
      ((a)localObject1).HLF.remove(localObject2);
      break;
      if (!getIntent().getBooleanExtra("show_header_view", true)) {
        break;
      }
      this.HMh.a(this.HMU);
      break;
      label445:
      if (this.HMO == 1)
      {
        localObject1 = getString(b.i.gallery_all_pic);
        break label225;
      }
      localObject1 = getString(b.i.gallery_all_video);
      break label225;
      label475:
      com.tencent.mm.plugin.gallery.model.e.fAo().aH(new e((String)localObject1, this.HMh, this.lzP, this.HMd));
      continue;
      label504:
      if (this.HMQ != null) {
        this.HMQ.HND = true;
      }
      com.tencent.mm.plugin.gallery.model.t.fAV().HIu = true;
      com.tencent.mm.plugin.gallery.model.t.fAV().HIt = true;
      this.HMR = System.currentTimeMillis();
      com.tencent.mm.plugin.gallery.model.e.fAn().F((String)localObject1, i, this.HMR);
    }
  }
  
  private void a(List<String> paramList1, List<String> paramList2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(289494);
    Iterator localIterator = this.HMh.HLB.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (localMediaItem.getType() == 1)
      {
        if ((localMediaItem.mMimeType.equals("edit")) && (!Util.isNullOrNil(localMediaItem.HHI))) {
          paramList1.add(localMediaItem.HHI);
        }
        for (;;)
        {
          paramArrayOfInt[i] = 1;
          i += 1;
          break;
          paramList1.add(localMediaItem.Gcc);
        }
      }
      if (localMediaItem.getType() != 2) {
        break label164;
      }
      paramList2.add(localMediaItem.Gcc);
      int j = i + 1;
      paramArrayOfInt[i] = 2;
      i = j;
    }
    label164:
    for (;;)
    {
      break;
      AppMethodBeat.o(289494);
      return;
    }
  }
  
  private void aEV(String paramString)
  {
    AppMethodBeat.i(289497);
    g.a locala = new g.a(this);
    locala.bf(paramString);
    locala.bDI(getString(b.i.gallery_i_know));
    locala.b(AlbumPreviewUI..ExternalSyntheticLambda0.INSTANCE);
    locala.show();
    AppMethodBeat.o(289497);
  }
  
  private void aEW(String paramString)
  {
    AppMethodBeat.i(173773);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
      AppMethodBeat.o(173773);
      return;
    }
    com.tencent.mm.plugin.gallery.model.e.fAo().aG(new e(paramString, this.HMh, this.lzP, this.HMd));
    AppMethodBeat.o(173773);
  }
  
  private boolean aEX(String paramString)
  {
    AppMethodBeat.i(289515);
    float f1 = getIntent().getFloatExtra("album_min_ratio_limit", -1.0F);
    float f2 = getIntent().getFloatExtra("album_max_ratio_limit", -1.0F);
    if ((f1 >= 0.0F) || (f2 >= 0.0F)) {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(paramString, localOptions);
        int i = localOptions.outWidth;
        int j = localOptions.outHeight;
        if ((i == 0) || (j == 0))
        {
          AppMethodBeat.o(289515);
          return false;
        }
        float f3 = i / j;
        if (((f1 >= 0.0F) && (f3 < f1)) || ((f2 >= 0.0F) && (f3 > f2)))
        {
          AppMethodBeat.o(289515);
          return false;
        }
      }
      finally
      {
        AppMethodBeat.o(289515);
        return true;
      }
    }
    AppMethodBeat.o(289515);
    return true;
  }
  
  private static int[] aL(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111471);
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = paramArrayList.size();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)paramArrayList.next();
      if (localMediaItem != null) {
        if ((!Util.isNullOrNil(localMediaItem.mMimeType)) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
          arrayOfInt[2] += 1;
        } else if (localMediaItem.getType() == 2) {
          arrayOfInt[3] += 1;
        } else if (localMediaItem.getType() == 1) {
          arrayOfInt[1] += 1;
        }
      }
    }
    AppMethodBeat.o(111471);
    return arrayOfInt;
  }
  
  private void bd(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(289522);
    com.tencent.mm.plugin.gallery.model.e.aJ(this.HMh.HLA);
    Intent localIntent = new Intent(this, ImagePreviewUI.class);
    localIntent.putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
    localIntent.putExtra("query_source_type", this.mpb);
    localIntent.putStringArrayListExtra("preview_image_list", this.HMh.fBk());
    localIntent.putParcelableArrayListExtra("preview_media_item_list", this.HMh.HLB);
    localIntent.putExtra("preview_all", paramBoolean);
    if (paramInt > 0)
    {
      paramInt -= this.HMh.HLF.size();
      localIntent.putExtra("preview_position", paramInt);
      bc(paramInt, true);
    }
    localIntent.putExtra("send_raw_img", this.wQK);
    com.tencent.mm.plugin.gallery.a.c localc = com.tencent.mm.plugin.gallery.a.c.HFY;
    if (com.tencent.mm.plugin.gallery.a.c.fzN())
    {
      localIntent.putExtra("key_force_hide_edit_image_button", true);
      localIntent.putExtra("key_force_hide_edit_video_button", true);
    }
    for (;;)
    {
      localIntent.putExtra("key_force_show_raw_image_button", this.HMy);
      localIntent.putExtra("key_is_raw_image_button_disable", this.HMz);
      localIntent.putExtra("max_select_count", this.GzH);
      localIntent.putExtra("GalleryUI_FromUser", this.hQQ);
      localIntent.putExtra("GalleryUI_ToUser", this.toUser);
      localIntent.putExtra("album_business_tag", this.HLD);
      localIntent.putExtra("album_video_max_duration", this.qqa);
      localIntent.putExtra("album_video_min_duration", this.HMI);
      localIntent.putExtra("select_type_tag", this.selectType);
      startActivityForResult(localIntent, 0);
      AppMethodBeat.o(289522);
      return;
      localIntent.putExtra("key_force_hide_edit_image_button", this.HMw);
    }
  }
  
  private void fBq()
  {
    AppMethodBeat.i(173771);
    Object localObject = com.tencent.mm.plugin.gallery.model.e.fAo();
    a locala = new a(this);
    localObject = ((g)localObject).fAI();
    if (localObject != null)
    {
      ((MMHandler)localObject).post(locala);
      AppMethodBeat.o(173771);
      return;
    }
    Log.w("MicroMsg.GalleryHandlerThread", "other handler is null.");
    AppMethodBeat.o(173771);
  }
  
  private void fBr()
  {
    AppMethodBeat.i(173772);
    if (this.HML)
    {
      this.HMh.id(com.tencent.mm.plugin.gallery.model.t.fAV().HIv);
      com.tencent.mm.plugin.gallery.model.e.fAs().addAll(this.HMh.HLB);
      WH(this.HMh.HLB.size());
      aEW(getIntent().getStringExtra("album_id_from_smart_gallery"));
      this.lzP.show();
      if ((this.mpb == 3) || (this.mpb == 19) || (this.mpb == 20) || (this.mpb == 21) || (this.mpb == 23) || (this.mpb == 26))
      {
        com.tencent.mm.plugin.report.service.l.kK(3, 11);
        AppMethodBeat.o(173772);
      }
    }
    else
    {
      com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.nNV).bwi();
      if (getIntent().hasExtra("gallery_report_tag")) {
        a.a.HFE.setScene(getIntent().getIntExtra("gallery_report_tag", 3));
      }
      for (;;)
      {
        Log.i("MicroMsg.AlbumPreviewUI", "start queryMediaInAlbums %s", new Object[] { this });
        com.tencent.mm.plugin.gallery.model.e.fAn().a(this);
        this.HMR = System.currentTimeMillis();
        com.tencent.mm.plugin.gallery.model.e.fAn().aI(this.HMs, this.HMR);
        getContentView().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(111422);
            Log.d("MicroMsg.AlbumPreviewUI", "onCreate, post delay, dialog show.");
            if (AlbumPreviewUI.b.HNl != AlbumPreviewUI.b(AlbumPreviewUI.this)) {
              AlbumPreviewUI.c(AlbumPreviewUI.this).show();
            }
            AppMethodBeat.o(111422);
          }
        }, 300L);
        r.a locala = r.HIe;
        r.fAT().a(new o());
        locala = r.HIe;
        r.fAT().a(new com.tencent.mm.plugin.gallery.model.s());
        break;
        a.a.HFE.setScene(this.mpb);
      }
    }
    if ((this.mpb == 4) || (this.mpb == 17) || (this.mpb == 31) || (this.mpb == 14) || (this.mpb == 22))
    {
      com.tencent.mm.plugin.report.service.l.kK(12, 11);
      AppMethodBeat.o(173772);
      return;
    }
    if ((this.mpb == 25) || (this.mpb == 28) || (this.mpb == 32) || (this.mpb == 30))
    {
      com.tencent.mm.plugin.report.service.l.kK(5, 11);
      AppMethodBeat.o(173772);
      return;
    }
    com.tencent.mm.plugin.report.service.l.kK(22, 11);
    AppMethodBeat.o(173772);
  }
  
  private boolean fBs()
  {
    AppMethodBeat.i(289492);
    if (!ab.bOG())
    {
      AppMethodBeat.o(289492);
      return false;
    }
    if (!this.wQK)
    {
      AppMethodBeat.o(289492);
      return false;
    }
    if (this.HMh == null)
    {
      AppMethodBeat.o(289492);
      return true;
    }
    Object localObject = this.HMh.HLB;
    if (((ArrayList)localObject).size() == 0)
    {
      AppMethodBeat.o(289492);
      return true;
    }
    if (this.mpb != 3)
    {
      AppMethodBeat.o(289492);
      return false;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
      if ((localMediaItem.getType() == 1) && (y.bEl(localMediaItem.Gcc) > 26214400L))
      {
        AppMethodBeat.o(289492);
        return true;
      }
      if ((localMediaItem.getType() == 2) && (y.bEl(localMediaItem.Gcc) > this.HMH))
      {
        AppMethodBeat.o(289492);
        return true;
      }
    }
    AppMethodBeat.o(289492);
    return false;
  }
  
  private void fBt()
  {
    AppMethodBeat.i(111476);
    if (!com.tencent.mm.pluginsdk.ui.tools.t.d(getContext(), com.tencent.mm.loader.i.b.bmL(), "microMsg." + System.currentTimeMillis() + ".jpg", 4369))
    {
      Toast.makeText(getContext(), getString(b.i.selectcameraapp_none), 1).show();
      AppMethodBeat.o(111476);
      return;
    }
    System.gc();
    AppMethodBeat.o(111476);
  }
  
  private String fBu()
  {
    AppMethodBeat.i(289501);
    Object localObject = this.HMh.fBk().iterator();
    long l1 = 0L;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!this.HMW.containsKey(str))
      {
        long l2 = y.bEl(str);
        this.HMW.put(str, Long.valueOf(l2));
        l1 += l2;
      }
      else
      {
        l1 = ((Long)this.HMW.get(str)).longValue() + l1;
      }
    }
    if (l1 > 1073741824L) {
      localObject = String.format("%.1fGB", new Object[] { Float.valueOf((float)l1 / 1024.0F / 1024.0F / 1024.0F) });
    }
    for (;;)
    {
      AppMethodBeat.o(289501);
      return localObject;
      if (l1 > 1048576L) {
        localObject = String.format("%dMB", new Object[] { Integer.valueOf((int)((float)l1 / 1024.0F / 1024.0F)) });
      } else if (l1 > 0L) {
        localObject = String.format("%dKB", new Object[] { Long.valueOf(l1 / 1024L) });
      } else {
        localObject = "";
      }
    }
  }
  
  private void fBv()
  {
    AppMethodBeat.i(111485);
    String str1 = getIntent().getStringExtra("to_user");
    String str2 = getIntent().getStringExtra("file_name");
    String str3 = getIntent().getStringExtra("video_path");
    String str4 = getIntent().getStringExtra("video_full_path");
    String str5 = getIntent().getStringExtra("video_thumb_path");
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(getContext().getPackageName(), "com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI");
      localIntent.putExtra("VideoRecorder_ToUser", str1);
      localIntent.putExtra("VideoRecorder_FileName", str2);
      localIntent.putExtra("VideoRecorder_VideoPath", str3);
      localIntent.putExtra("VideoRecorder_VideoFullPath", str4);
      localIntent.putExtra("VideoRecorder_VideoThumbPath", str5);
      Log.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", new Object[] { localIntent });
      startActivityForResult(localIntent, 4371);
      AppMethodBeat.o(111485);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AlbumPreviewUI", localException.toString());
      if ((!com.tencent.mm.n.a.p(getContext(), true)) && (!com.tencent.mm.n.a.dl(getContext())) && (!com.tencent.mm.n.a.dp(getContext()))) {
        com.tencent.mm.compatible.i.b.x(getContext());
      }
      AppMethodBeat.o(111485);
    }
  }
  
  private static void ie(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111480);
    long l = System.currentTimeMillis();
    Log.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (!y.ZC(localMediaItem.Gcc))
      {
        Log.w("MicroMsg.AlbumPreviewUI", "filter non exist media: %s.", new Object[] { localMediaItem.Gcc });
        ((LinkedList)localObject).add(localMediaItem);
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.remove((GalleryItem.MediaItem)((Iterator)localObject).next());
    }
    Log.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia cost: %s.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(111480);
  }
  
  private boolean j(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(289510);
    float f1 = getIntent().getFloatExtra("album_min_ratio_limit", -1.0F);
    float f2 = getIntent().getFloatExtra("album_max_ratio_limit", -1.0F);
    int j;
    int i;
    if ((f1 >= 0.0F) || (f2 >= 0.0F))
    {
      if (!(paramMediaItem instanceof GalleryItem.ImageMediaItem)) {
        break label169;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(paramMediaItem.Gcc, localOptions);
      j = localOptions.outWidth;
      i = localOptions.outHeight;
    }
    for (;;)
    {
      if ((j == 0) || (i == 0))
      {
        AppMethodBeat.o(289510);
        return false;
      }
      float f3 = j / i;
      if (((f1 >= 0.0F) && (f3 < f1)) || ((f2 >= 0.0F) && (f3 > f2)))
      {
        AppMethodBeat.o(289510);
        return false;
      }
      AppMethodBeat.o(289510);
      return true;
      AppMethodBeat.o(289510);
      return true;
      label169:
      i = 0;
      j = 0;
    }
  }
  
  protected final void WH(int paramInt)
  {
    AppMethodBeat.i(111479);
    label37:
    int i;
    int j;
    String str;
    if (paramInt == 0)
    {
      this.HMe.setEnabled(false);
      enableOptionMenu(false);
      if (paramInt != 0) {
        break label144;
      }
      this.HMe.setText(b.i.gallery_pic_preview);
      if (this.HMv)
      {
        localObject = com.tencent.mm.plugin.gallery.a.c.HFY;
        com.tencent.mm.plugin.gallery.a.c.aI(this.HMh.HLB);
      }
      i = this.mpb;
      j = this.GzH;
      str = this.HLD;
      if (this.HMh != null) {
        break label190;
      }
    }
    label144:
    label190:
    for (Object localObject = null;; localObject = this.HMh.HLB)
    {
      updateOptionMenuText(0, com.tencent.mm.plugin.gallery.b.h.a(this, i, paramInt, j, str, (ArrayList)localObject));
      AppMethodBeat.o(111479);
      return;
      this.HMe.setEnabled(true);
      enableOptionMenu(true);
      if (!fBs()) {
        break;
      }
      this.HMe.setEnabled(false);
      enableOptionMenu(false);
      break;
      this.HMe.setText(getString(b.i.gallery_pic_preview) + "(" + paramInt + ")");
      break label37;
    }
  }
  
  public final void WI(int paramInt)
  {
    AppMethodBeat.i(289661);
    int i;
    int j;
    String str;
    if (paramInt > 0)
    {
      this.GzH = paramInt;
      paramInt = this.mpb;
      i = this.HMh.HLB.size();
      j = this.GzH;
      str = this.HLD;
      if (this.HMh != null) {
        break label75;
      }
    }
    label75:
    for (ArrayList localArrayList = null;; localArrayList = this.HMh.HLB)
    {
      updateOptionMenuText(0, com.tencent.mm.plugin.gallery.b.h.a(this, paramInt, i, j, str, localArrayList));
      AppMethodBeat.o(289661);
      return;
    }
  }
  
  protected boolean a(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(289673);
    if (paramMediaItem == null)
    {
      Log.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
      AppMethodBeat.o(289673);
      return false;
    }
    if ((this.mpb == 3) && (this.wQK))
    {
      int i = (int)y.bEl(paramMediaItem.Gcc);
      if (26214400 < i)
      {
        Log.w("MicroMsg.AlbumPreviewUI", "[checkRawImageItem] item:%s file size:%s", new Object[] { paramMediaItem, Integer.valueOf(i) });
        if (ab.bOG()) {
          aEV(getString(b.i.gallery_album_can_not_send_too_large_pic, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(26214400L) }));
        }
        for (;;)
        {
          paramMediaItem = new ql();
          paramMediaItem.xF(this.toUser);
          paramMediaItem.jrX = 3L;
          paramMediaItem.jrY = i;
          paramMediaItem.bMH();
          AppMethodBeat.o(289673);
          return false;
          k.cY(this, getString(b.i.gallery_select_raw_image_to_big));
        }
      }
    }
    AppMethodBeat.o(289673);
    return true;
  }
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(111481);
    if ((ab.bOG()) && (this.HMH < 0L)) {
      this.HMH = com.tencent.mm.plugin.gallery.b.h.aRj();
    }
    if (paramLong != this.HMR)
    {
      Log.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.HMR) });
      Log.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(111481);
      return;
    }
    Log.d("MicroMsg.AlbumPreviewUI", "onQueryMediaFinished: %s %s %s.", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.HMh.HLA.size()), Integer.valueOf(paramLinkedList.size()) });
    boolean bool;
    label175:
    Object localObject;
    if ((paramBoolean) || (this.HMh.HLA.size() > paramLinkedList.size()))
    {
      ie(paramLinkedList);
      paramLinkedList = new LinkedList(paramLinkedList);
      if (this.HMh != null) {
        break label427;
      }
      bool = true;
      Log.i("MicroMsg.AlbumPreviewUI", "[onQueryMediaFinished] adapter is null?:%s %s", new Object[] { Boolean.valueOf(bool), Util.getStack().toString() });
      if (this.HMh != null)
      {
        localObject = new d((byte)0);
        ((d)localObject).HNp = new WeakReference(this.HMh);
        ((d)localObject).HNq = new WeakReference(this.lzP);
        ((d)localObject).HNr = new WeakReference(this.HMj);
        ((d)localObject).HNs = new WeakReference(this.HMd);
        ((d)localObject).HNt = paramLinkedList;
        ((d)localObject).HMJ = this.HMJ;
        ((d)localObject).HNu = paramBoolean;
        if (AlbumPreviewUI.b.HNk == this.HMV) {
          this.HMV = AlbumPreviewUI.b.HNl;
        }
        com.tencent.mm.plugin.gallery.model.e.fAo().postToMainThread((Runnable)localObject);
        localObject = new c((byte)0);
        ((c)localObject).count = paramLinkedList.size();
        if (paramLinkedList.size() <= 0) {
          break label433;
        }
        ((c)localObject).HNo = ((GalleryItem.MediaItem)paramLinkedList.get(0));
      }
    }
    for (;;)
    {
      ((c)localObject).HNn = new WeakReference(this.HMl);
      com.tencent.mm.plugin.gallery.model.e.fAo().postToMainThread((Runnable)localObject);
      AppMethodBeat.o(111481);
      return;
      ie(paramLinkedList.subList(this.HMh.HLA.size(), paramLinkedList.size()));
      break;
      label427:
      bool = false;
      break label175;
      label433:
      ((c)localObject).HNo = null;
      Log.d("MicroMsg.AlbumPreviewUI", "onQueryMediaFinished, newMediaItems size = 0.");
    }
  }
  
  protected boolean b(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(289678);
    if (paramMediaItem == null)
    {
      Log.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
      AppMethodBeat.o(289678);
      return false;
    }
    if (this.mpb == 3)
    {
      i = com.tencent.mm.plugin.gallery.b.b.HQZ.c(this.mpb, paramMediaItem);
      if (i != 0)
      {
        if (i == 202)
        {
          Log.i("MicroMsg.AlbumPreviewUI", "select video duration too long");
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 50L, 1L, false);
        }
        paramMediaItem = com.tencent.mm.plugin.gallery.b.c.HRd;
        com.tencent.mm.plugin.gallery.b.c.j(this, i, this.mpb);
        AppMethodBeat.o(289678);
        return false;
      }
    }
    if (!new u(paramMediaItem.Gcc).jKS())
    {
      k.cY(this, getString(b.i.gallery_select_video_not_exit));
      AppMethodBeat.o(289678);
      return false;
    }
    Object localObject;
    if (getIntent().getBooleanExtra("key_filter_hdr_video", false))
    {
      localObject = com.tencent.mm.plugin.gallery.b.e.HRe;
      if (!com.tencent.mm.plugin.gallery.b.e.aFe(paramMediaItem.Gcc))
      {
        k.cY(this, getString(b.i.gallery_select_video_not_support_hdr));
        AppMethodBeat.o(289678);
        return false;
      }
    }
    if (this.mpb == 3)
    {
      if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
      {
        i = Util.videoMsToSec(((GalleryItem.VideoMediaItem)paramMediaItem).oTN);
        localObject = com.tencent.mm.k.a.lZC;
        int j = com.tencent.mm.k.a.aQy();
        if (i <= j) {
          break label346;
        }
        Log.i("MicroMsg.AlbumPreviewUI", "select video duration too long");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 50L, 1L, false);
        if (!ab.bOG()) {
          break label332;
        }
        aEV(getString(b.i.gallery_album_can_not_send_too_long_video, new Object[] { com.tencent.mm.plugin.gallery.b.h.WW(j) }));
      }
      for (;;)
      {
        paramMediaItem = new ql();
        paramMediaItem.jrX = 2L;
        paramMediaItem.xF(this.toUser);
        paramMediaItem.jrY = i;
        paramMediaItem.bMH();
        AppMethodBeat.o(289678);
        return false;
        i = com.tencent.mm.plugin.gallery.b.h.aFh(paramMediaItem.Gcc);
        break;
        label332:
        k.cY(this, getString(b.i.gallery_select_video_to_long));
      }
      label346:
      long l2 = y.bEl(paramMediaItem.Gcc);
      if ((l2 > this.HMH) && (ab.bOG()) && (this.wQK))
      {
        Log.i("MicroMsg.AlbumPreviewUI", "select video file length to large");
        if (this.HMH <= 0L) {}
        for (long l1 = 1073741824L;; l1 = this.HMH)
        {
          aEV(getString(b.i.gallery_album_can_not_send_too_large_video, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(l1) }));
          paramMediaItem = new ql();
          paramMediaItem.jrX = 1L;
          paramMediaItem.xF(this.toUser);
          paramMediaItem.jrY = l2;
          paramMediaItem.bMH();
          AppMethodBeat.o(289678);
          return false;
        }
      }
    }
    else if (this.mpb == 4)
    {
      i = com.tencent.mm.plugin.gallery.b.h.aFh(paramMediaItem.Gcc);
      localObject = com.tencent.mm.k.a.lZC;
      if (i > com.tencent.mm.k.a.aQz() * 1000 / 1000)
      {
        k.cY(this, getString(b.i.gallery_select_video_to_long));
        AppMethodBeat.o(289678);
        return false;
      }
    }
    else if (((this.mpb == 14) || (this.mpb == 22)) && (com.tencent.mm.plugin.gallery.b.h.aFh(paramMediaItem.Gcc) > 300))
    {
      k.cY(this, getString(b.i.gallery_select_video_to_long));
      AppMethodBeat.o(289678);
      return false;
    }
    int i = getIntent().getIntExtra("key_max_video_duration", 0);
    if ((i > 0) && (com.tencent.mm.plugin.gallery.b.h.aFh(paramMediaItem.Gcc) > i))
    {
      k.cY(this, getString(b.i.gallery_select_video_to_long));
      AppMethodBeat.o(289678);
      return false;
    }
    AppMethodBeat.o(289678);
    return true;
  }
  
  public final void bc(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111473);
    switch (this.HMO)
    {
    }
    Object localObject;
    do
    {
      do
      {
        AppMethodBeat.o(111473);
        return;
      } while ((Util.isNullOrNil(this.hQQ)) || ("medianote".equals(this.toUser)));
      if (Util.currentTicks() - this.HMF < 1000L)
      {
        Log.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111473);
        return;
      }
      Log.i("MicroMsg.AlbumPreviewUI", "notifyMM switch to SendImgProxyUI");
      localObject = (GalleryItem.MediaItem)this.HMh.HLA.get(paramInt);
    } while (((GalleryItem.MediaItem)localObject).getType() == 2);
    for (;;)
    {
      try
      {
        localObject = ((GalleryItem.MediaItem)localObject).Gcc;
        String str = this.toUser;
        if (!this.HMv) {
          if (!this.wQK)
          {
            break label179;
            com.tencent.mm.plugin.gallery.b.h.b((String)localObject, str, bool, paramBoolean);
            AppMethodBeat.o(111473);
          }
          else
          {
            bool = false;
            continue;
          }
        }
      }
      catch (Exception localException) {}
      label179:
      boolean bool = true;
    }
  }
  
  protected boolean faD()
  {
    AppMethodBeat.i(111475);
    Log.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.fAu()), Boolean.valueOf(this.HMv) });
    if (this.HMv) {}
    for (int i = 3;; i = 2)
    {
      com.tencent.mm.plugin.gallery.b.h.bZ(11610, i + "," + com.tencent.mm.plugin.gallery.model.e.fAu());
      if (this.HMH < 0L) {
        this.HMH = com.tencent.mm.plugin.gallery.b.h.aRj();
      }
      com.tencent.mm.plugin.gallery.model.e.fAt();
      if (this.HMh.fBk().size() != 0) {
        break;
      }
      Log.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
      setResult(-2);
      finish();
      AppMethodBeat.o(111475);
      return true;
    }
    Object localObject1 = new Intent();
    i = this.HMO;
    Object localObject2;
    if (this.HMA)
    {
      if ((!this.HMA) || (this.mpb != 16)) {
        break label2268;
      }
      localObject2 = this.HMh.HLB.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label2268;
      }
      localObject2 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
      if (((GalleryItem.MediaItem)localObject2).getType() != 1) {
        break label443;
      }
      i = 1;
    }
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      label443:
      boolean bool;
      if (22 == com.tencent.mm.plugin.gallery.model.e.fAn().sfB)
      {
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        localObject4 = new int[this.GzH];
        a((List)localObject2, (List)localObject3, (int[])localObject4);
        if ((this.HMM) && (((ArrayList)localObject3).size() > 0))
        {
          localObject1 = RecordConfigProvider.aM((String)((ArrayList)localObject3).get(0), "", "");
          ((RecordConfigProvider)localObject1).NHZ = 15000;
          ((RecordConfigProvider)localObject1).scene = 2;
          localObject2 = new UICustomParam.a();
          ((UICustomParam.a)localObject2).aQw();
          ((UICustomParam.a)localObject2).aQv();
          ((UICustomParam.a)localObject2).eL(true);
          ((RecordConfigProvider)localObject1).NHR = ((UICustomParam.a)localObject2).lZB;
          ((RecordConfigProvider)localObject1).NIk = false;
          ((RecordConfigProvider)localObject1).NIl = false;
          ((RecordConfigProvider)localObject1).NIm = true;
          ((RecordConfigProvider)localObject1).NHU = Boolean.TRUE;
          ((RecordConfigProvider)localObject1).NHT = 4;
          if (!TextUtils.isEmpty(this.HMN)) {
            ((RecordConfigProvider)localObject1).cD(2, this.HMN);
          }
          localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4383, b.a.sight_slide_bottom_in, -1, (RecordConfigProvider)localObject1, 2, 0);
          AppMethodBeat.o(111475);
          return true;
          if (((GalleryItem.MediaItem)localObject2).getType() == 2) {
            i = 2;
          }
        }
        else
        {
          bool = com.tencent.mm.plugin.gallery.b.h.fBU();
          if ((com.tencent.mm.plugin.recordvideo.activity.a.b.I((List)localObject2, (List)localObject3) == 4) && (bool))
          {
            localObject1 = VLogPreloadUI.HQX;
            VLogPreloadUI.a.a(this, (ArrayList)localObject3, (ArrayList)localObject2, (int[])localObject4);
            AppMethodBeat.o(111475);
            return true;
          }
          ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject3);
          ((Intent)localObject1).putStringArrayListExtra("key_select_image_list", (ArrayList)localObject2);
          setResult(-1, (Intent)localObject1);
          finish();
          AppMethodBeat.o(111475);
          return true;
        }
      }
      else
      {
        if (this.mpb == 28)
        {
          localObject1 = this.HMh.HLB;
          if (((ArrayList)localObject1).size() > 0) {
            a(0, (GalleryItem.MediaItem)((ArrayList)localObject1).get(0));
          }
          AppMethodBeat.o(111475);
          return true;
        }
        localObject2 = com.tencent.mm.plugin.gallery.a.c.HFY;
        if (com.tencent.mm.plugin.gallery.a.c.a(this.HMh.HLB, new AlbumPreviewUI..ExternalSyntheticLambda1(this)))
        {
          AppMethodBeat.o(111475);
          return true;
        }
        if (i == 1)
        {
          if ((this.HMv) || (!this.wQK))
          {
            bool = true;
            ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
            localObject3 = this.HMh.HLB;
            localObject2 = new ArrayList();
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label758;
            }
            localObject4 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
            if ((((GalleryItem.MediaItem)localObject4).mMimeType.equals("edit")) && (!Util.isNullOrNil(((GalleryItem.MediaItem)localObject4).HHI)))
            {
              ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).HHI);
              continue;
              bool = false;
              break;
            }
            ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).Gcc);
          }
          label758:
          ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
          ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.HMG);
          this.HMG = 0L;
          setResult(-1, (Intent)localObject1);
          if ((!Util.isNullOrNil(this.HLD)) && (this.HLD.equals("album_business_bubble_media_by_coordinate"))) {
            ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
          }
          if (Util.currentTicks() - this.HMF < 1000L)
          {
            Log.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
            AppMethodBeat.o(111475);
            return true;
          }
          Log.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE switch to SendImgProxyUI");
          this.HMF = Util.currentTicks();
          if ((!Util.isNullOrNil(this.hQQ)) && (!"medianote".equals(this.toUser)))
          {
            ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.hQQ);
            ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
            startActivityForResult((Intent)localObject1, 4373);
          }
          for (;;)
          {
            AppMethodBeat.o(111475);
            return true;
            finish();
          }
        }
        if (i == 2)
        {
          Log.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
          if (getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false)) {}
          for (i = 0;; i = ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).cnU())
          {
            if (i != 0) {
              break label1101;
            }
            ((Intent)localObject1).setData(FileProviderHelper.getUriForFile(getContext(), new u((String)this.HMh.fBk().get(0))));
            ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", this.HMh.fBk());
            setResult(-1, (Intent)localObject1);
            finish();
            break;
            localObject2 = new com.tencent.mm.plugin.gallery.ui.a.a((String)this.HMh.fBk().get(0));
            ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).cEg = this.HMH;
          }
          label1101:
          if (i == 2)
          {
            k.s(this, b.i.video_export_file_error, b.i.gallery_send_video_over_size_title);
            Log.w("MicroMsg.AlbumPreviewUI", "video is import error");
            AppMethodBeat.o(111475);
            return true;
          }
          long l;
          if (ab.bOG()) {
            if (this.HMH <= 0L)
            {
              l = 1073741824L;
              k.cY(this, getString(b.i.gallery_album_can_not_send_too_large_video, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(l) }));
            }
          }
          for (;;)
          {
            Log.w("MicroMsg.AlbumPreviewUI", "video is over size");
            AppMethodBeat.o(111475);
            return true;
            l = this.HMH;
            break;
            k.s(this, b.i.gallery_send_video_over_size, b.i.gallery_send_video_over_size_title);
          }
        }
        if (i == 3)
        {
          if ((!Util.isNullOrNil(this.HLD)) && (this.HLD.equals("album_business_bubble_media_by_coordinate")))
          {
            localObject4 = this.HMh.HLB;
            localObject2 = new ArrayList();
            localObject3 = new ArrayList();
            localObject4 = ((ArrayList)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (GalleryItem.MediaItem)((Iterator)localObject4).next();
              if (((GalleryItem.MediaItem)localObject5).getType() == 1)
              {
                if ((((GalleryItem.MediaItem)localObject5).mMimeType.equals("edit")) && (!Util.isNullOrNil(((GalleryItem.MediaItem)localObject5).HHI))) {
                  ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).HHI);
                } else {
                  ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).Gcc);
                }
              }
              else if (((GalleryItem.MediaItem)localObject5).getType() == 2) {
                ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject5).Gcc);
              }
            }
            ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
            ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
            ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.HMG);
            ((Intent)localObject1).putExtra("longitude", this.longitude);
            ((Intent)localObject1).putExtra("latitude", this.latitude);
            this.HMG = 0L;
            setResult(-1, (Intent)localObject1);
            finish();
            AppMethodBeat.o(111475);
            return true;
          }
          if (Util.currentTicks() - this.HMF < 1000L)
          {
            Log.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
            AppMethodBeat.o(111475);
            return true;
          }
          this.HMF = Util.currentTicks();
          Object localObject5 = this.HMh.HLB;
          localObject2 = new ArrayList();
          localObject3 = new ArrayList();
          localObject4 = new int[this.GzH];
          localObject5 = ((ArrayList)localObject5).iterator();
          i = 0;
          label1568:
          if (((Iterator)localObject5).hasNext())
          {
            GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
            if (localMediaItem.getType() == 1)
            {
              if ((this.mpb == 3) && (ab.bOG()) && (this.wQK) && (y.bEl(localMediaItem.Gcc) > 26214400L))
              {
                aEV(getString(b.i.gallery_album_can_not_send_too_large_pic, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(26214400L) }));
                AppMethodBeat.o(111475);
                return false;
              }
              if ((localMediaItem.mMimeType.equals("edit")) && (!Util.isNullOrNil(localMediaItem.HHI))) {
                ((ArrayList)localObject3).add(localMediaItem.HHI);
              }
              for (;;)
              {
                localObject4[i] = 1;
                i += 1;
                break;
                ((ArrayList)localObject3).add(localMediaItem.Gcc);
              }
            }
            if (localMediaItem.getType() != 2) {
              break label2265;
            }
            if ((this.mpb == 3) && (ab.bOG()) && (this.wQK) && (y.bEl(localMediaItem.Gcc) > this.HMH))
            {
              aEV(getString(b.i.gallery_album_can_not_send_too_large_video, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(this.HMH) }));
              AppMethodBeat.o(111475);
              return false;
            }
            ((ArrayList)localObject2).add(localMediaItem.Gcc);
            int j = i + 1;
            localObject4[i] = 2;
            i = j;
          }
        }
        label2127:
        label2265:
        for (;;)
        {
          break label1568;
          if ((this.HMv) || (!this.wQK)) {}
          for (bool = true;; bool = false)
          {
            ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
            ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
            ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.HMG);
            if (!this.HMv) {
              break label2127;
            }
            if (((ArrayList)localObject2).size() != 0) {
              break;
            }
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
            ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.HMG);
            this.HMG = 0L;
            setResult(-1, (Intent)localObject1);
            finish();
            AppMethodBeat.o(111475);
            return true;
          }
          if (com.tencent.mm.plugin.recordvideo.activity.a.b.I((List)localObject3, (List)localObject2) == 4)
          {
            localObject1 = VLogPreloadUI.HQX;
            VLogPreloadUI.a.a(this, (ArrayList)localObject2, (ArrayList)localObject3, (int[])localObject4);
          }
          for (;;)
          {
            AppMethodBeat.o(111475);
            return true;
            localObject1 = RecordConfigProvider.aM((String)((ArrayList)localObject2).get(0), "", "");
            ((RecordConfigProvider)localObject1).NHZ = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
            ((RecordConfigProvider)localObject1).scene = 2;
            localObject2 = new VideoCaptureReportInfo();
            ((VideoCaptureReportInfo)localObject2).ybL = 1;
            ((RecordConfigProvider)localObject1).NIi = ((VideoCaptureReportInfo)localObject2);
            localObject2 = new UICustomParam.a();
            ((UICustomParam.a)localObject2).aQw();
            ((UICustomParam.a)localObject2).aQv();
            ((UICustomParam.a)localObject2).eL(true);
            ((RecordConfigProvider)localObject1).NHR = ((UICustomParam.a)localObject2).lZB;
            localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
            com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, b.a.sight_slide_bottom_in, -1, (RecordConfigProvider)localObject1, 2, 0);
          }
          this.HMG = 0L;
          if (((ArrayList)localObject3).size() > 0)
          {
            ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
            ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.hQQ);
            ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
            ((Intent)localObject1).putExtra("CropImage_limit_Img_Size", 26214400);
            Log.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE_AND_VIDEO switch to SendImgProxyUI");
            startActivityForResult((Intent)localObject1, 4373);
            break;
          }
          Log.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
          setResult(-1, (Intent)localObject1);
          finish();
          break;
          Log.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
          setResult(-2);
          finish();
          break;
        }
      }
      label2268:
      i = 1;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(111484);
    getIntent().putExtra("MMActivity.OverrideExitAnimation", b.a.push_down_out);
    getIntent().putExtra("MMActivity.OverrideEnterAnimation", b.a.anim_not_change);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    com.tencent.mm.plugin.comm.b.e.xfd.a("SnsPublishProcess", "selectionPageStaytime_", Long.valueOf(getActivityBrowseTimeMs()), com.tencent.mm.plugin.comm.b.c.xeT);
    AppMethodBeat.o(111484);
  }
  
  public int getCustomBounceId()
  {
    return b.e.media_in_folder_rv;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.f.sd_card_media_folder_preview;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111474);
    Object localObject1 = getIntent().getExtras();
    Object localObject2;
    String str;
    if (localObject1 != null)
    {
      localObject2 = ((Bundle)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        Log.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", new Object[] { str, ((Bundle)localObject1).get(str) });
      }
    }
    Log.e("MicroMsg.AlbumPreviewUI", "initView, oops! no extras data!");
    this.HLD = getIntent().getStringExtra("album_business_tag");
    this.qqa = getIntent().getIntExtra("album_video_max_duration", 10);
    this.HMI = getIntent().getIntExtra("album_video_min_duration", 0);
    this.hQQ = getIntent().getStringExtra("GalleryUI_FromUser");
    this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
    this.GzH = getIntent().getIntExtra("max_select_count", 9);
    boolean bool;
    label297:
    int i;
    if (this.mpb == 4)
    {
      bool = true;
      this.HMv = bool;
      this.HMr = getIntent().getStringExtra("folder_path");
      this.HMs = getIntent().getStringExtra("folder_name");
      if (Util.isNullOrNil(this.HMr))
      {
        Log.w("MicroMsg.AlbumPreviewUI", "folder path invalid, assign folderName: %s.", new Object[] { this.HMs });
        this.HMr = this.HMs;
      }
      if ((!getIntent().getBooleanExtra("key_send_raw_image", false)) && (!getIntent().getBooleanExtra("send_raw_img", false))) {
        break label2062;
      }
      bool = true;
      this.wQK = bool;
      this.HMw = getIntent().getBooleanExtra("key_force_hide_edit_image_button", false);
      this.HMx = getIntent().getBooleanExtra("key_force_hide_edit_image_button_after_album_take_image", false);
      this.HMy = getIntent().getBooleanExtra("key_force_show_raw_image_button", false);
      this.HMz = getIntent().getBooleanExtra("key_is_raw_image_button_disable", false);
      this.HMA = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
      this.HFR = ((LinearLayout)findViewById(b.e.original_ll));
      this.HMm = ((RelativeLayout)findViewById(b.e.original_rl));
      this.HMn = ((TextView)findViewById(b.e.original_image_tip));
      this.HMn.setTextSize(0, com.tencent.mm.cd.a.bs(this, b.c.NormalTextSize));
      this.HMo = ((TextView)findViewById(b.e.original_image_size));
      this.HMo.setTextSize(0, com.tencent.mm.cd.a.bs(this, b.c.Edge_1_5_A));
      i = getIntent().getIntExtra("KSnsFrom", -1);
      if ((SnsTimeLineUI.hpM()) && ((i == 1) || (i == 3)))
      {
        this.HMq = ((LinearLayout)findViewById(b.e.secondcut));
        this.HMq.setVisibility(0);
        this.HMq.setOnClickListener(new AlbumPreviewUI.16(this));
      }
      this.HMp = ((ImageButton)findViewById(b.e.original_image));
      this.HMn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111435);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          AlbumPreviewUI.d(AlbumPreviewUI.this).performClick();
          if (AlbumPreviewUI.this.wQK) {
            AlbumPreviewUI.e(AlbumPreviewUI.this).setContentDescription(AlbumPreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_select_desc));
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111435);
            return;
            AlbumPreviewUI.e(AlbumPreviewUI.this).setContentDescription(AlbumPreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
          }
        }
      });
      if ((this.mpb != 3) && (!this.HMy)) {
        break label2068;
      }
      this.HFR.setVisibility(0);
      this.HMm.setVisibility(0);
      label591:
      if (!this.wQK) {
        break label2089;
      }
      this.HMp.setImageResource(b.h.radio_on);
      this.HMp.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_select_desc));
      label625:
      if (this.HMz) {
        this.HMp.setImageResource(b.h.radio_default_on);
      }
      localObject1 = this.HMp;
      if (this.HMz) {
        break label2119;
      }
      bool = true;
      label658:
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.HMn;
      if (this.HMz) {
        break label2125;
      }
      bool = true;
      label681:
      ((TextView)localObject1).setEnabled(bool);
      this.HMp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164797);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = AlbumPreviewUI.this;
          boolean bool;
          label106:
          int i;
          if (!AlbumPreviewUI.this.wQK)
          {
            bool = true;
            paramAnonymousView.wQK = bool;
            if ((ab.bOG()) && (AlbumPreviewUI.this.mpb == 3)) {
              AlbumPreviewUI.this.HMh.vU(AlbumPreviewUI.this.wQK);
            }
            if (!ab.bOG()) {
              break label299;
            }
            AlbumPreviewUI.f(AlbumPreviewUI.this);
            AlbumPreviewUI.e(AlbumPreviewUI.this).setText(AlbumPreviewUI.this.getContext().getString(b.i.gallery_pic_original));
            if (!AlbumPreviewUI.this.wQK) {
              break label329;
            }
            AlbumPreviewUI.d(AlbumPreviewUI.this).setImageResource(b.h.radio_on);
            AlbumPreviewUI.d(AlbumPreviewUI.this).setContentDescription(AlbumPreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_select_desc));
            if ((!ab.bOG()) || (AlbumPreviewUI.this.mpb != 3) || (!AlbumPreviewUI.this.wQK)) {
              break label314;
            }
            paramAnonymousView = AlbumPreviewUI.h(AlbumPreviewUI.this);
            localObject = AlbumPreviewUI.i(AlbumPreviewUI.this);
            if (!Util.isNullOrNil(paramAnonymousView)) {
              break label309;
            }
            i = 8;
            label229:
            ((TextView)localObject).setVisibility(i);
            AlbumPreviewUI.i(AlbumPreviewUI.this).setText(AlbumPreviewUI.this.getString(b.i.gallery_album_summary_item_size_tips, new Object[] { paramAnonymousView }));
          }
          for (;;)
          {
            if (!ab.bOG()) {
              AlbumPreviewUI.j(AlbumPreviewUI.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164797);
            return;
            bool = false;
            break;
            label299:
            AlbumPreviewUI.g(AlbumPreviewUI.this);
            break label106;
            label309:
            i = 0;
            break label229;
            label314:
            AlbumPreviewUI.i(AlbumPreviewUI.this).setVisibility(8);
            continue;
            label329:
            AlbumPreviewUI.d(AlbumPreviewUI.this).setImageResource(b.h.radio_off);
            AlbumPreviewUI.d(AlbumPreviewUI.this).setContentDescription(AlbumPreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
            AlbumPreviewUI.i(AlbumPreviewUI.this).setVisibility(8);
            if (ab.bOG()) {
              AlbumPreviewUI.this.WH(AlbumPreviewUI.this.HMh.HLB.size());
            }
          }
        }
      });
      this.HMd = ((RecyclerView)findViewById(b.e.media_in_folder_rv));
      this.HMi = ((TextView)findViewById(b.e.album_tips_bar));
      this.HMj = ((TextView)findViewById(b.e.album_tips_bar2));
      this.HMk = ((TextView)findViewById(b.e.album_photo_edit_tips_bar));
      this.HMe = ((TextView)findViewById(b.e.media_preview));
      this.HMe.setTextSize(0, com.tencent.mm.cd.a.bs(this, b.c.NormalTextSize));
      if (1 != ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zkg, 0)) {
        break label2131;
      }
      bool = true;
      label814:
      Log.i("MicroMsg.AlbumPreviewUI", "pennqin, smartGallerySwitch: %s.", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label2137;
      }
      bool = false;
      label843:
      Log.i("MicroMsg.AlbumPreviewUI", "pennqin, isFromSmartGallery: %s showSmartGallery: %s.", new Object[] { Boolean.valueOf(this.HML), Boolean.valueOf(bool) });
      if ((!this.HML) && ((bool) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)))
      {
        addTextOptionMenu(1, null, this.HMS, null, y.b.adEW);
        if (this.HMP) {
          fBq();
        }
      }
      if ((this.mpb != 0) && (this.mpb != 5) && (this.mpb != 10) && (this.mpb != 11) && (this.mpb != 24) && (this.mpb != 27)) {
        break label2267;
      }
      findViewById(b.e.album_footer_bar).setVisibility(8);
      localObject1 = (FrameLayout.LayoutParams)this.HMd.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = 0;
      this.HMd.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (getBounceView() != null)
      {
        localObject1 = (FrameLayout.LayoutParams)getBounceView().getView().getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = 0;
        getBounceView().getView().setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      label1057:
      this.HMl = ((ImageFolderMgrView)findViewById(b.e.image_folder_mgr_view));
      this.HMl.setListener(new ImageFolderMgrView.a()
      {
        public final void b(GalleryItem.AlbumItem paramAnonymousAlbumItem)
        {
          AppMethodBeat.i(173761);
          AlbumPreviewUI.a(AlbumPreviewUI.this, paramAnonymousAlbumItem);
          AppMethodBeat.o(173761);
        }
      });
      this.HMl.setOnFolderStateChanged(new ImageFolderMgrView.c()
      {
        public final void vV(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(173762);
          if (paramAnonymousBoolean)
          {
            if (AlbumPreviewUI.q(AlbumPreviewUI.this))
            {
              AlbumPreviewUI.this.setSmartGalleryEntryVisibility(false);
              AppMethodBeat.o(173762);
            }
          }
          else
          {
            if ((AlbumPreviewUI.q(AlbumPreviewUI.this)) && (!AlbumPreviewUI.r(AlbumPreviewUI.this).getSelectedAlbumName().equalsIgnoreCase(AlbumPreviewUI.this.getString(b.i.gallery_fav_pic_and_video)))) {
              AlbumPreviewUI.this.setSmartGalleryEntryVisibility(true);
            }
            if (AlbumPreviewUI.s(AlbumPreviewUI.this) != null)
            {
              if (!Util.nullAs(AlbumPreviewUI.t(AlbumPreviewUI.this), "").equals(AlbumPreviewUI.s(AlbumPreviewUI.this).albumName))
              {
                AlbumPreviewUI.b(AlbumPreviewUI.this, AlbumPreviewUI.s(AlbumPreviewUI.this));
                AppMethodBeat.o(173762);
                return;
              }
              AlbumPreviewUI.this.playActionBarOperationAreaAnim();
            }
          }
          AppMethodBeat.o(173762);
        }
      });
      localObject2 = this.HMl;
      bool = this.HMP;
      Log.i("MicroMsg.ImageFolderMgrView", "attach, %s.", new Object[] { localObject2 });
      com.tencent.mm.plugin.gallery.model.e.fAn().b((l.a)localObject2);
      com.tencent.mm.plugin.gallery.model.e.fAn().a((l.a)localObject2);
      com.tencent.mm.plugin.gallery.model.e.fAn().c(((ImageFolderMgrView)localObject2).HOu);
      localObject1 = com.tencent.mm.plugin.gallery.model.e.fAn();
      localObject2 = ((ImageFolderMgrView)localObject2).HOu;
      ((com.tencent.mm.plugin.gallery.model.q)localObject1).HHW.add(localObject2);
      if (bool) {
        com.tencent.mm.plugin.gallery.model.e.fAn().fAR();
      }
      this.HMt = getIntent().getStringExtra("send_btn_string");
      localObject1 = getIntent().getStringExtra("album_footer_info_str");
      this.HMu = getIntent().getBooleanExtra("is_hide_album_footer", false);
      if ((this.HMu) || (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        findViewById(b.e.album_footer_bar).setVisibility(8);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          findViewById(b.e.album_footer_info_layout).setVisibility(0);
          ((TextView)findViewById(b.e.album_footer_info)).setText((CharSequence)localObject1);
        }
      }
      enableOptionMenu(false);
      getContext();
      localObject1 = new GridLayoutManager(4);
      this.HMd.setLayoutManager((RecyclerView.LayoutManager)localObject1);
      localObject2 = new c.a(getContext()).WM(b.c.gallery_item_padding).WL(b.c.gallery_item_padding).WK(b.b.gallery_dark_mode_color);
      ((c.a)localObject2).HNS = false;
      localObject2 = ((c.a)localObject2).fBB();
      this.HMd.a((RecyclerView.h)localObject2);
      this.HMd.a(new RecyclerView.l()
      {
        private Runnable wRo;
        
        private String fBz()
        {
          AppMethodBeat.i(173766);
          String str = AlbumPreviewUI.this.HMh.WG(this.HNg.Ju());
          if ((!Util.isNullOrNil(str)) && (str.equals("album_business_bubble_media_by_coordinate")))
          {
            str = AlbumPreviewUI.v(AlbumPreviewUI.this) + "附近的照片和视频";
            AppMethodBeat.o(173766);
            return str;
          }
          AppMethodBeat.o(173766);
          return str;
        }
        
        private void vW(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(173767);
          if (paramAnonymousBoolean)
          {
            AlbumPreviewUI.u(AlbumPreviewUI.this).removeCallbacks(this.wRo);
            if (AlbumPreviewUI.u(AlbumPreviewUI.this).getVisibility() != 0)
            {
              String str = fBz();
              AlbumPreviewUI.u(AlbumPreviewUI.this).setText(str);
              AlbumPreviewUI.u(AlbumPreviewUI.this).setVisibility(0);
              AlbumPreviewUI.u(AlbumPreviewUI.this).setAlpha(0.0F);
              AlbumPreviewUI.u(AlbumPreviewUI.this).animate().alpha(1.0F).setDuration(300L).start();
              AppMethodBeat.o(173767);
            }
          }
          else
          {
            AlbumPreviewUI.u(AlbumPreviewUI.this).removeCallbacks(this.wRo);
            AlbumPreviewUI.u(AlbumPreviewUI.this).postDelayed(this.wRo, 256L);
          }
          AppMethodBeat.o(173767);
        }
        
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(289457);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$9", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
          Log.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (1 == paramAnonymousInt)
          {
            vW(true);
            AlbumPreviewUI.w(AlbumPreviewUI.this).setVisibility(8);
            com.tencent.mm.plugin.gallery.model.e.fAm().fAh();
          }
          do
          {
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$9", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
              AppMethodBeat.o(289457);
              return;
              if (paramAnonymousInt != 0) {
                break;
              }
              vW(false);
              AlbumPreviewUI.a(AlbumPreviewUI.this, this.HNg.Ju());
              AlbumPreviewUI.b(AlbumPreviewUI.this, this.HNg.Jw());
              Log.d("MicroMsg.AlbumPreviewUI", "cancelTask logic, firstVisibleItem: %s lastVisibleItem: %s.", new Object[] { Integer.valueOf(AlbumPreviewUI.x(AlbumPreviewUI.this)), Integer.valueOf(AlbumPreviewUI.y(AlbumPreviewUI.this)) });
              paramAnonymousRecyclerView = r.HIe;
              r.fAT().a(r.c.HIl, AlbumPreviewUI.x(AlbumPreviewUI.this), AlbumPreviewUI.y(AlbumPreviewUI.this), AlbumPreviewUI.this.HMh.HLA.size());
            }
          } while (2 != paramAnonymousInt);
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, AlbumPreviewUI.z(AlbumPreviewUI.this));
          paramAnonymousRecyclerView = AlbumPreviewUI.this;
          boolean bool = WXHardCoderJNI.hcAlbumScrollEnable;
          int i = WXHardCoderJNI.hcAlbumScrollDelay;
          int j = WXHardCoderJNI.hcAlbumScrollCPU;
          int k = WXHardCoderJNI.hcAlbumScrollIO;
          if (WXHardCoderJNI.hcAlbumScrollThr) {}
          for (paramAnonymousInt = Process.myTid();; paramAnonymousInt = 0)
          {
            AlbumPreviewUI.c(paramAnonymousRecyclerView, WXHardCoderJNI.startPerformance(bool, i, j, k, paramAnonymousInt, WXHardCoderJNI.hcAlbumScrollTimeout, 702, WXHardCoderJNI.hcAlbumScrollAction, "MicroMsg.AlbumPreviewUI"));
            break;
          }
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(289462);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$9", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousRecyclerView = fBz();
          AlbumPreviewUI.u(AlbumPreviewUI.this).setText(paramAnonymousRecyclerView);
          paramAnonymousInt1 = this.HNg.Ju();
          int i = this.HNg.Jw();
          Log.d("MicroMsg.AlbumPreviewUI", "pennqin, onScrolled, %s %s %s %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(i), Integer.valueOf(AlbumPreviewUI.x(AlbumPreviewUI.this)), Integer.valueOf(AlbumPreviewUI.y(AlbumPreviewUI.this)) });
          if ((AlbumPreviewUI.x(AlbumPreviewUI.this) != paramAnonymousInt1) || (AlbumPreviewUI.y(AlbumPreviewUI.this) != i))
          {
            AlbumPreviewUI.a(AlbumPreviewUI.this, paramAnonymousInt1);
            AlbumPreviewUI.b(AlbumPreviewUI.this, i);
            paramAnonymousRecyclerView = new ArrayList();
            paramAnonymousInt1 = AlbumPreviewUI.x(AlbumPreviewUI.this);
            while (paramAnonymousInt1 <= AlbumPreviewUI.y(AlbumPreviewUI.this))
            {
              localObject = AlbumPreviewUI.this.HMh.WF(paramAnonymousInt1);
              if (localObject != null) {
                paramAnonymousRecyclerView.add(com.tencent.mm.plugin.gallery.b.h.a(((GalleryItem.MediaItem)localObject).bud(), null, -1));
              }
              paramAnonymousInt1 += 1;
            }
            Log.d("MicroMsg.AlbumPreviewUI", "cancelTask, legalPaths size: %s.", new Object[] { Integer.valueOf(paramAnonymousRecyclerView.size()) });
            com.tencent.mm.plugin.gallery.model.e.fAm().hZ(paramAnonymousRecyclerView);
            if (paramAnonymousInt2 != 0)
            {
              if (paramAnonymousInt2 >= 0) {
                break label389;
              }
              AlbumPreviewUI.a(AlbumPreviewUI.this, r.c.HIm);
            }
          }
          for (;;)
          {
            Log.d("MicroMsg.AlbumPreviewUI", "onScrolled, dy: %s state: %s.", new Object[] { Integer.valueOf(paramAnonymousInt2), AlbumPreviewUI.A(AlbumPreviewUI.this) });
            paramAnonymousRecyclerView = r.HIe;
            r.fAT().a(AlbumPreviewUI.A(AlbumPreviewUI.this), AlbumPreviewUI.x(AlbumPreviewUI.this), AlbumPreviewUI.y(AlbumPreviewUI.this), AlbumPreviewUI.this.HMh.HLA.size());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$9", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
            AppMethodBeat.o(289462);
            return;
            label389:
            AlbumPreviewUI.a(AlbumPreviewUI.this, r.c.HIn);
          }
        }
      });
      this.HMh = new a(getContext(), new a.e()
      {
        public final void aG(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          int i = 8;
          AppMethodBeat.i(173748);
          Object localObject = AlbumPreviewUI.this.HMh.WF(paramAnonymousInt2);
          if (localObject == null)
          {
            AppMethodBeat.o(173748);
            return;
          }
          if (paramAnonymousInt3 == 0) {
            if (((GalleryItem.MediaItem)localObject).getType() == 1) {
              if (!AlbumPreviewUI.this.a((GalleryItem.MediaItem)localObject))
              {
                AlbumPreviewUI.this.HMh.i((GalleryItem.MediaItem)localObject);
                if ((!ab.bOG()) || (AlbumPreviewUI.this.mpb != 3) || (!AlbumPreviewUI.this.wQK)) {
                  break label389;
                }
                localObject = AlbumPreviewUI.h(AlbumPreviewUI.this);
                TextView localTextView = AlbumPreviewUI.i(AlbumPreviewUI.this);
                if (!Util.isNullOrNil((String)localObject)) {
                  break label384;
                }
                paramAnonymousInt1 = i;
                label126:
                localTextView.setVisibility(paramAnonymousInt1);
                AlbumPreviewUI.i(AlbumPreviewUI.this).setText(AlbumPreviewUI.this.getString(b.i.gallery_album_summary_item_size_tips, new Object[] { localObject }));
              }
            }
          }
          for (;;)
          {
            if (!Util.isNullOrNil(AlbumPreviewUI.this.HMh.fBk())) {
              break label404;
            }
            AppMethodBeat.o(173748);
            return;
            a.a.HFE.au(((GalleryItem.MediaItem)localObject).Gcc, AlbumPreviewUI.p(AlbumPreviewUI.this), paramAnonymousInt2);
            AlbumPreviewUI.a(AlbumPreviewUI.this, (GalleryItem.MediaItem)localObject);
            AlbumPreviewUI.this.WH(paramAnonymousInt1);
            AlbumPreviewUI.this.bc(paramAnonymousInt2, true);
            break;
            if (((GalleryItem.MediaItem)localObject).getType() == 2)
            {
              if (!AlbumPreviewUI.this.b((GalleryItem.MediaItem)localObject))
              {
                AlbumPreviewUI.this.HMh.i((GalleryItem.MediaItem)localObject);
                break;
              }
              a.a.HFE.au(((GalleryItem.MediaItem)localObject).Gcc, AlbumPreviewUI.p(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.WH(paramAnonymousInt1);
              AlbumPreviewUI.this.bc(paramAnonymousInt2, true);
              break;
            }
            a.a.HFE.au(((GalleryItem.MediaItem)localObject).Gcc, AlbumPreviewUI.p(AlbumPreviewUI.this), paramAnonymousInt2);
            AlbumPreviewUI.this.WH(paramAnonymousInt1);
            AlbumPreviewUI.this.bc(paramAnonymousInt2, true);
            break;
            a.a.HFE.au(((GalleryItem.MediaItem)localObject).Gcc, AlbumPreviewUI.p(AlbumPreviewUI.this), paramAnonymousInt2);
            AlbumPreviewUI.this.WH(paramAnonymousInt1);
            AlbumPreviewUI.this.bc(paramAnonymousInt2, false);
            break;
            label384:
            paramAnonymousInt1 = 0;
            break label126;
            label389:
            AlbumPreviewUI.i(AlbumPreviewUI.this).setVisibility(8);
          }
          label404:
          AppMethodBeat.o(173748);
        }
      });
      this.HMh.toUser = this.toUser;
      this.HMh.HLJ = this.HLJ;
      if (!Util.isNullOrNil(this.HLD))
      {
        Log.d("MicroMsg.AlbumPreviewUI", "businessTag=%s", new Object[] { this.HLD });
        this.HMh.HLD = this.HLD;
        this.HMh.qqa = this.qqa;
        if (this.HLD.equals("album_business_bubble_media_by_coordinate"))
        {
          this.HMh.HLG = false;
          com.tencent.mm.plugin.gallery.model.e.fAn().HHZ.fzZ();
          this.HMJ = getIntent().getStringExtra("album_business_bubble_media_by_coordinate_posname");
          final double d = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_distance", -1.0D);
          this.longitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 181.0D);
          this.latitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 91.0D);
          if ((d >= 0.0D) && (com.tencent.mm.modelgeo.a.C(this.longitude)) && (com.tencent.mm.modelgeo.a.D(this.latitude)))
          {
            this.HMK = new l.b()
            {
              public final void c(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong)
              {
                AppMethodBeat.i(173749);
                Log.d("MicroMsg.AlbumPreviewUI", "onQueryMediaBusinessDoing");
                if (paramAnonymousLong != AlbumPreviewUI.B(AlbumPreviewUI.this))
                {
                  Log.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(AlbumPreviewUI.B(AlbumPreviewUI.this)) });
                  Log.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
                  AppMethodBeat.o(173749);
                  return;
                }
                if ((paramAnonymousLinkedList == null) || (paramAnonymousLinkedList.isEmpty()))
                {
                  Log.d("MicroMsg.AlbumPreviewUI", "mediaItems is invalid.");
                  AppMethodBeat.o(173749);
                  return;
                }
                ArrayList localArrayList = new ArrayList();
                Iterator localIterator = paramAnonymousLinkedList.iterator();
                while (localIterator.hasNext())
                {
                  GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
                  if (TencentLocationUtils.distanceBetween(AlbumPreviewUI.C(AlbumPreviewUI.this), AlbumPreviewUI.D(AlbumPreviewUI.this), localMediaItem.HHO, localMediaItem.HHN) <= d)
                  {
                    localMediaItem.HHP = "album_business_bubble_media_by_coordinate";
                    localArrayList.add(localMediaItem);
                  }
                }
                paramAnonymousLinkedList.removeAll(localArrayList);
                Log.d("MicroMsg.AlbumPreviewUI", "target media size=%d", new Object[] { Integer.valueOf(localArrayList.size()) });
                localIterator = localArrayList.iterator();
                while (localIterator.hasNext()) {
                  Log.d("MicroMsg.AlbumPreviewUI", "target media item=%s", new Object[] { ((GalleryItem.MediaItem)localIterator.next()).toString() });
                }
                if ((!paramAnonymousLinkedList.isEmpty()) && (!localArrayList.isEmpty())) {
                  paramAnonymousLinkedList.addAll(0, localArrayList);
                }
                AppMethodBeat.o(173749);
              }
            };
            localObject1 = com.tencent.mm.plugin.gallery.model.e.fAn();
            localObject2 = this.HMK;
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.gallery.model.q)localObject1).HHY.add(localObject2);
            }
          }
        }
      }
      if (this.HMA) {
        this.HMh.HLG = true;
      }
      this.HMU = new a.b();
      if (getIntent().getBooleanExtra("show_header_view", true)) {
        this.HMh.a(this.HMU);
      }
      this.HMh.HIa = this.HMO;
      this.HMh.HLz = this.GzH;
      Log.i("MicroMsg.AlbumPreviewUI", "limit count = " + this.GzH);
      this.HMd.setAdapter(this.HMh);
      if (!this.HML) {
        break label2486;
      }
      setActionbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
      setMMTitle(getIntent().getStringExtra("title_from_smart_gallery"));
      label1795:
      setNavigationbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
      setActionBarOperationAreaClickListener(new AlbumChooserView.a()
      {
        public final void onAlbumChooserViewClick()
        {
          AppMethodBeat.i(289465);
          Log.i("MicroMsg.AlbumPreviewUI", "onAlbumChooserViewClick.");
          AlbumPreviewUI.a(AlbumPreviewUI.this, null);
          a.a.HFE.HFs = 1;
          Log.d("MicroMsg.AlbumPreviewUI", "click folder times: [%d].", new Object[] { Integer.valueOf(AlbumPreviewUI.G(AlbumPreviewUI.this)) });
          AlbumPreviewUI.H(AlbumPreviewUI.this);
          AlbumPreviewUI.this.playActionBarOperationAreaAnim();
          AlbumPreviewUI.r(AlbumPreviewUI.this).fBC();
          AppMethodBeat.o(289465);
        }
      });
      this.HMl.setFolderAlbumDialogDismiss(new ImageFolderMgrView.b()
      {
        public final void fBy()
        {
          AppMethodBeat.i(289470);
          if ((AlbumPreviewUI.r(AlbumPreviewUI.this) != null) && (AlbumPreviewUI.r(AlbumPreviewUI.this).qv))
          {
            AlbumPreviewUI.r(AlbumPreviewUI.this).fBC();
            AlbumPreviewUI.this.playActionBarOperationAreaAnim();
          }
          AppMethodBeat.o(289470);
        }
      });
      if (!this.HML) {
        break label2562;
      }
      i = b.d.actionbar_dark_back_selector;
      label1847:
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(173750);
          Log.i("MicroMsg.AlbumPreviewUI", "backBtn");
          AlbumPreviewUI.this.onBackBtnClick();
          AlbumPreviewUI.this.setResult(-2, AlbumPreviewUI.this.getIntent().putExtra("send_raw_img", AlbumPreviewUI.this.wQK));
          if ((AlbumPreviewUI.r(AlbumPreviewUI.this) != null) && (AlbumPreviewUI.r(AlbumPreviewUI.this).qv))
          {
            AlbumPreviewUI.r(AlbumPreviewUI.this).fBC();
            AlbumPreviewUI.this.playActionBarOperationAreaAnim();
            AppMethodBeat.o(173750);
            return true;
          }
          AlbumPreviewUI.E(AlbumPreviewUI.this);
          AlbumPreviewUI.this.finish();
          AppMethodBeat.o(173750);
          return true;
        }
      }, i);
      localObject1 = (ViewGroup)findViewById(b.e.root);
      if ((localObject1 instanceof DrawedCallBackFrameLayout)) {
        ((DrawedCallBackFrameLayout)localObject1).setListener(new DrawedCallBackFrameLayout.a()
        {
          public final void fBx()
          {
            AppMethodBeat.i(173751);
            com.tencent.mm.plugin.gallery.b.h.fBx();
            if (AlbumPreviewUI.this.HMC) {
              AlbumPreviewUI.this.HMC = false;
            }
            AppMethodBeat.o(173751);
          }
        });
      }
      this.HMQ = new f((byte)0);
      this.HMQ.HNp = new WeakReference(this.HMh);
      this.HMQ.HNq = new WeakReference(this.lzP);
      this.HMQ.HNn = new WeakReference(this.HMl);
      this.HMQ.idList = this.idList;
      this.HMQ.type = this.HMO;
      localObject1 = (TextView)findViewById(b.e.album_chooser_txt);
      if (com.tencent.mm.ui.a.jhB()) {
        break label2569;
      }
      if ((localObject1 != null) && (com.tencent.mm.cd.a.mp(getContext()))) {
        ((TextView)localObject1).setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), b.c.BodyTextSize) * com.tencent.mm.cd.a.jO(getContext()));
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.gallery.a.c.HFY.a(this);
      AppMethodBeat.o(111474);
      return;
      bool = false;
      break;
      label2062:
      bool = false;
      break label297;
      label2068:
      this.HFR.setVisibility(8);
      this.HMm.setVisibility(8);
      break label591;
      label2089:
      this.HMp.setImageResource(b.h.radio_off);
      this.HMp.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
      break label625;
      label2119:
      bool = false;
      break label658;
      label2125:
      bool = false;
      break label681;
      label2131:
      bool = false;
      break label814;
      label2137:
      localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zkh, "");
      localObject2 = Build.MANUFACTURER.toLowerCase();
      str = com.tencent.mm.compatible.deviceinfo.q.aPo().toLowerCase();
      Log.i("MicroMsg.AlbumPreviewUI", "pennqin, manufacturer: %s, model: %s, smartGalleryBlackList: %s.", new Object[] { localObject2, str, localObject1 });
      if ((((String)localObject1).contains((CharSequence)localObject2)) || (((String)localObject1).contains(str)))
      {
        bool = false;
        break label843;
      }
      if (("album_business_bubble_media_by_jsapi_chooseimage".equals(this.HLD)) || ("album_business_bubble_media_by_jsapi_choosevideo".equals(this.HLD)))
      {
        bool = false;
        break label843;
      }
      bool = true;
      break label843;
      label2267:
      this.HMe.setVisibility(0);
      this.HMe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(173760);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          AlbumPreviewUI.k(AlbumPreviewUI.this);
          paramAnonymousView = com.tencent.mm.plugin.gallery.a.c.HFY;
          if (com.tencent.mm.plugin.gallery.a.c.fzN()) {
            AlbumPreviewUI.l(AlbumPreviewUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(173760);
            return;
            paramAnonymousView = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
            com.tencent.mm.plugin.gallery.model.e.aJ(AlbumPreviewUI.this.HMh.HLB);
            paramAnonymousView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.HMh.fBk());
            paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", AlbumPreviewUI.this.HMh.HLB);
            paramAnonymousView.putExtra("key_edit_video_max_time_length", AlbumPreviewUI.this.getIntent().getIntExtra("key_edit_video_max_time_length", 10));
            paramAnonymousView.putExtra("max_select_count", AlbumPreviewUI.this.GzH);
            paramAnonymousView.putExtra("send_raw_img", AlbumPreviewUI.this.wQK);
            paramAnonymousView.putExtra("key_force_hide_edit_image_button", AlbumPreviewUI.m(AlbumPreviewUI.this));
            paramAnonymousView.putExtra("key_force_show_raw_image_button", AlbumPreviewUI.n(AlbumPreviewUI.this));
            paramAnonymousView.putExtra("key_is_raw_image_button_disable", AlbumPreviewUI.o(AlbumPreviewUI.this));
            paramAnonymousView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.hQQ);
            paramAnonymousView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
            paramAnonymousView.putExtra("select_type_tag", AlbumPreviewUI.p(AlbumPreviewUI.this));
            paramAnonymousView.putExtra("album_business_tag", AlbumPreviewUI.this.HLD);
            paramAnonymousView.putExtra("album_video_max_duration", AlbumPreviewUI.this.qqa);
            paramAnonymousView.putExtra("album_video_min_duration", AlbumPreviewUI.this.HMI);
            AlbumPreviewUI.this.startActivityForResult(paramAnonymousView, 0);
          }
        }
      });
      if (((this.HMO != 1) && (this.HMO != 2) && (this.HMO != 3)) || (this.GzH <= 0)) {
        break label1057;
      }
      if (!Util.isNullOrNil(this.HMt))
      {
        addTextOptionMenu(0, this.HMt, this.HMS);
        break label1057;
      }
      i = this.mpb;
      int j = this.GzH;
      localObject2 = this.HLD;
      if (this.HMh == null) {}
      for (localObject1 = null;; localObject1 = this.HMh.HLB)
      {
        localObject1 = com.tencent.mm.plugin.gallery.b.h.a(this, i, 0, j, (String)localObject2, (ArrayList)localObject1);
        switch (this.mpb)
        {
        default: 
          addTextOptionMenu(0, (String)localObject1, this.HMS, null, y.b.adEV);
          break label1057;
        }
      }
      addTextOptionMenu(0, (String)localObject1, this.HMS, null, y.b.adET);
      break label1057;
      addTextOptionMenu(0, (String)localObject1, this.HMS, null, y.b.adEZ);
      break label1057;
      label2486:
      setActionbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
      initActionBarOperationArea();
      if (this.HMO == 3)
      {
        initActionBarOperationAreaTxt(getString(b.i.gallery_all_pic_and_video));
        break label1795;
      }
      if (this.HMO == 1)
      {
        initActionBarOperationAreaTxt(getString(b.i.gallery_all_pic));
        break label1795;
      }
      initActionBarOperationAreaTxt(getString(b.i.gallery_all_video));
      break label1795;
      label2562:
      i = b.h.actionbar_icon_close_black;
      break label1847;
      label2569:
      com.tencent.mm.ui.a.v((TextView)localObject1, b.c.BodyTextSize);
    }
  }
  
  public boolean isActionbarCenterLayoutMode()
  {
    return false;
  }
  
  protected void n(final int paramInt, View paramView)
  {
    AppMethodBeat.i(164801);
    Object localObject1 = this.HMh.WF(paramInt);
    boolean bool1;
    if ((localObject1 == null) || (Util.isNullOrNil(((GalleryItem.MediaItem)localObject1).Gcc)))
    {
      if (localObject1 == null) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.w("MicroMsg.AlbumPreviewUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(164801);
        return;
      }
    }
    this.HMY = ((GalleryItem.MediaItem)localObject1);
    if (((com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 5) || (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 31) || (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 33)) && (((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")))
    {
      k.cZ(getContext(), getString(b.i.gallery_select_media_type_not_gif));
      AppMethodBeat.o(164801);
      return;
    }
    if (1 == this.HMO)
    {
      if (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("video"))
      {
        k.cZ(getContext(), getString(b.i.gallery_select_media_type_not_video));
        AppMethodBeat.o(164801);
      }
    }
    else if ((2 == this.HMO) && (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("image")))
    {
      k.cZ(getContext(), getString(b.i.gallery_select_media_type_not_img));
      AppMethodBeat.o(164801);
      return;
    }
    int j = paramInt - this.HMh.HLF.size();
    Log.d("MicroMsg.AlbumPreviewUI", "onMediaClick, querySource %s item %s.", new Object[] { Integer.valueOf(this.mpb), localObject1 });
    if ((this.mpb == 0) || (this.mpb == 5) || (this.mpb == 10) || (this.mpb == 11) || (this.mpb == 27))
    {
      if (this.HMO == 2)
      {
        k.a(this, true, getString(b.i.gallery_send_video_to_chat), "", getString(b.i.app_send), getString(b.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(289461);
            Log.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.setData(Uri.parse("file://" + Uri.encode(this.HNf.Gcc)));
            AlbumPreviewUI.this.setResult(-1, paramAnonymousDialogInterface);
            a.a.HFE.au(this.HNf.Gcc, AlbumPreviewUI.p(AlbumPreviewUI.this), paramInt);
            AlbumPreviewUI.this.finish();
            AppMethodBeat.o(289461);
          }
        }, null);
        AppMethodBeat.o(164801);
        return;
      }
      a(paramInt, (GalleryItem.MediaItem)localObject1);
      AppMethodBeat.o(164801);
      return;
    }
    int i;
    if (this.mpb == 31)
    {
      if (((GalleryItem.MediaItem)localObject1).getType() == 2)
      {
        i = com.tencent.mm.plugin.gallery.b.b.HQZ.c(this.mpb, (GalleryItem.MediaItem)localObject1);
        if (i != 0)
        {
          paramView = com.tencent.mm.plugin.gallery.b.c.HRd;
          com.tencent.mm.plugin.gallery.b.c.j(this, i, this.mpb);
          AppMethodBeat.o(164801);
          return;
        }
      }
      a(paramInt, (GalleryItem.MediaItem)localObject1);
      AppMethodBeat.o(164801);
      return;
    }
    if (this.mpb == 4)
    {
      paramView = com.tencent.mm.plugin.gallery.a.c.HFY;
      if (com.tencent.mm.plugin.gallery.a.c.isEnable())
      {
        bd(paramInt, true);
        AppMethodBeat.o(164801);
        return;
      }
      boolean bool2 = com.tencent.mm.plugin.gallery.b.h.fBT();
      if ((!bool2) && (((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.HMh.HLB.size() != 0))
      {
        k.cZ(getContext(), com.tencent.mm.cd.a.bt(getContext(), b.i.gallery_pic_can_not_choose_video));
        AppMethodBeat.o(164801);
        return;
      }
      if ((bool2) && (com.tencent.mm.plugin.gallery.b.h.aN(this.HMh.HLB))) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.AlbumPreviewUI", "enableSnsVLog:%s skipEditVideo:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((((GalleryItem.MediaItem)localObject1).getType() != 2) || (bool1)) {
          break label870;
        }
        if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
          break;
        }
        i = com.tencent.mm.plugin.gallery.b.b.HQZ.c(this.mpb, (GalleryItem.MediaItem)localObject1);
        if (i == 0) {
          break;
        }
        paramView = com.tencent.mm.plugin.gallery.b.c.HRd;
        com.tencent.mm.plugin.gallery.b.c.j(this, i, this.mpb);
        AppMethodBeat.o(164801);
        return;
      }
      bool1 = getIntent().getBooleanExtra("key_check_third_party_video", false);
      paramView = com.tencent.mm.plugin.sns.statistics.d.QDv;
      paramView = ((GalleryItem.MediaItem)localObject1).Gcc;
      i = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
      kotlin.g.b.s.u(paramView, "inputPath");
      paramView = RecordConfigProvider.aM(paramView, "", "");
      paramView.NHZ = (i * 1000);
      kotlin.g.b.s.s(paramView, "provider");
      com.tencent.mm.plugin.sns.statistics.d.s(paramView);
      localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).ybL = 1;
      paramView.NIi = ((VideoCaptureReportInfo)localObject2);
      paramView.NIq = bool1;
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).aQw();
      ((UICustomParam.a)localObject2).aQv();
      ((UICustomParam.a)localObject2).eL(true);
      paramView.NHR = ((UICustomParam.a)localObject2).lZB;
      a.a.HFE.au(((GalleryItem.MediaItem)localObject1).Gcc, this.selectType, paramInt);
      this.HNa = ((GalleryItem.MediaItem)localObject1).Gcc;
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, b.a.sight_slide_bottom_in, -1, paramView, 2, 0);
      AppMethodBeat.o(164801);
      return;
      label870:
      Log.d("leextime", "jump from sns : " + Util.currentTicks());
      if (bool2) {}
      for (paramView = this.HMh.HLA;; paramView = this.HMh.WE(((GalleryItem.MediaItem)localObject1).getType()))
      {
        com.tencent.mm.plugin.gallery.model.e.aJ(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.HMh.fBk());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.HMh.HLB);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        bc(j, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.wQK);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.HMw);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.HMy);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.HMz);
        ((Intent)localObject2).putExtra("max_select_count", this.GzH);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.hQQ);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.selectType);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
        return;
      }
    }
    if (this.mpb == 14)
    {
      if ((((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.HMh.HLB.size() != 0))
      {
        k.cZ(getContext(), com.tencent.mm.cd.a.bt(getContext(), b.i.gallery_pic_can_not_choose_video));
        AppMethodBeat.o(164801);
        return;
      }
      if (((GalleryItem.MediaItem)localObject1).getType() == 1)
      {
        paramView = this.HMh.WE(((GalleryItem.MediaItem)localObject1).getType());
        com.tencent.mm.plugin.gallery.model.e.aJ(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.HMh.fBk());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.HMh.HLB);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        bc(j, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.wQK);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.HMw);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.HMy);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.HMz);
        ((Intent)localObject2).putExtra("max_select_count", this.GzH);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.hQQ);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.selectType);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
        return;
      }
      if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
        break label3104;
      }
      paramView = (GalleryItem.VideoMediaItem)localObject1;
      if (paramView.oTN <= 2000)
      {
        Log.i("MicroMsg.AlbumPreviewUI", "select story video, duration too long, duration:%s", new Object[] { Integer.valueOf(paramView.oTN) });
        com.tencent.mm.plugin.report.service.h.OAn.p(1005L, 53L, 1L);
        k.cZ(getContext(), com.tencent.mm.cd.a.bt(getContext(), b.i.gallery_pic_video_too_short_title));
        AppMethodBeat.o(164801);
        return;
      }
      if ((paramView.videoFrameRate <= 1) && (paramView.videoFrameRate >= 0))
      {
        Log.i("MicroMsg.AlbumPreviewUI", "select story video, videoFrameRate too small:%s, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.Gcc });
        if (paramView.videoFrameRate > 1) {}
      }
    }
    try
    {
      localObject2 = SightVideoJNI.getSimpleMp4InfoVFS(paramView.Gcc);
      if (!Util.isNullOrNil((String)localObject2))
      {
        double d = new JSONObject((String)localObject2).optDouble("videoFPS");
        Log.i("MicroMsg.AlbumPreviewUI", "update from getSimpleMp4Info videoFPS:%s", new Object[] { Double.valueOf(d) });
        if (d > 0.0D) {
          paramView.videoFrameRate = ((int)d);
        }
      }
    }
    catch (Exception localException)
    {
      label1683:
      break label1683;
    }
    if (paramView.videoFrameRate <= 0)
    {
      Log.i("MicroMsg.AlbumPreviewUI", "final videoFrameRate:%s, too small, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.Gcc });
      com.tencent.mm.plugin.report.service.h.OAn.p(1005L, 54L, 1L);
      k.cZ(getContext(), com.tencent.mm.cd.a.bt(getContext(), b.i.gallery_pic_video_not_support_desc));
      AppMethodBeat.o(164801);
      return;
    }
    Log.i("MicroMsg.AlbumPreviewUI", "maxDuration=%s", new Object[] { Long.valueOf(getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000 + 500) });
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("K_SEGMENTVIDEOPATH", paramView.Gcc);
    ((Intent)localObject2).putExtra("KSEGMENTVIDEOTHUMBPATH", paramView.zWJ);
    setResult(-1, (Intent)localObject2);
    a.a.HFE.au(((GalleryItem.MediaItem)localObject1).Gcc, this.selectType, paramInt);
    finish();
    AppMethodBeat.o(164801);
    return;
    if (this.mpb == 29)
    {
      if (((GalleryItem.MediaItem)localObject1).getType() == 1)
      {
        paramView = this.HMh.WE(((GalleryItem.MediaItem)localObject1).getType());
        com.tencent.mm.plugin.gallery.model.e.aJ(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.HMh.fBk());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.HMh.HLB);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        bc(j, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.wQK);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.HMw);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.HMy);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.HMz);
        ((Intent)localObject2).putExtra("max_select_count", this.GzH);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.hQQ);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.selectType);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
      }
    }
    else if (this.mpb == 30)
    {
      if (((GalleryItem.MediaItem)localObject1).getType() == 1)
      {
        paramView = this.HMh.WE(((GalleryItem.MediaItem)localObject1).getType());
        com.tencent.mm.plugin.gallery.model.e.aJ(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.HMh.fBk());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.HMh.HLB);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        bc(j, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.wQK);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.HMw);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.HMy);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.HMz);
        ((Intent)localObject2).putExtra("max_select_count", this.GzH);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.hQQ);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.selectType);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
      }
    }
    else
    {
      if (this.HMA)
      {
        if (((GalleryItem.MediaItem)localObject1).getType() == 2) {
          paramInt = 1;
        }
        while ((this.mpb == 16) && ((this.HMO == 2) || (this.HMO == 3))) {
          if ((this.HMh.HLB.size() > 0) && (((GalleryItem.MediaItem)this.HMh.HLB.get(0)).getType() != ((GalleryItem.MediaItem)localObject1).getType()))
          {
            k.cZ(getContext(), com.tencent.mm.cd.a.bt(getContext(), b.i.gallery_pic_can_not_choose_video));
            AppMethodBeat.o(164801);
            return;
            paramInt = this.GzH;
          }
          else
          {
            i = this.GzH;
          }
        }
        while ((this.mpb == 15) && (((GalleryItem.MediaItem)localObject1).getType() == 2))
        {
          AppMethodBeat.o(164801);
          return;
          i = paramInt;
          if (((GalleryItem.MediaItem)localObject1).getType() == 2)
          {
            i = paramInt;
            if (this.HMh.HLB.size() != 0)
            {
              k.cZ(getContext(), com.tencent.mm.cd.a.bt(getContext(), b.i.gallery_pic_can_not_choose_video));
              AppMethodBeat.o(164801);
              return;
            }
          }
        }
        paramView = this.HMh.WE(((GalleryItem.MediaItem)localObject1).getType());
        com.tencent.mm.plugin.gallery.model.e.aJ(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.HMh.fBk());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.HMh.HLB);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        bc(j, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.wQK);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.HMw);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.HMy);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.HMz);
        ((Intent)localObject2).putExtra("max_select_count", i);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.hQQ);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.selectType);
        ((Intent)localObject2).putExtra("album_business_tag", this.HLD);
        ((Intent)localObject2).putExtra("album_video_max_duration", this.qqa);
        ((Intent)localObject2).putExtra("album_video_min_duration", this.HMI);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
        return;
      }
      com.tencent.mm.plugin.gallery.model.e.aJ(this.HMh.HLA);
      paramView = new Intent(this, ImagePreviewUI.class);
      paramView.putExtra("query_source_type", this.mpb);
      paramView.putStringArrayListExtra("preview_image_list", this.HMh.fBk());
      paramView.putParcelableArrayListExtra("preview_media_item_list", this.HMh.HLB);
      paramView.putExtra("preview_all", true);
      paramView.putExtra("preview_position", j);
      bc(j, true);
      paramView.putExtra("send_raw_img", this.wQK);
      paramView.putExtra("key_force_hide_edit_image_button", this.HMw);
      paramView.putExtra("key_force_show_raw_image_button", this.HMy);
      paramView.putExtra("key_is_raw_image_button_disable", this.HMz);
      paramView.putExtra("max_select_count", this.GzH);
      paramView.putExtra("GalleryUI_FromUser", this.hQQ);
      paramView.putExtra("GalleryUI_ToUser", this.toUser);
      paramView.putExtra("album_business_tag", this.HLD);
      paramView.putExtra("album_video_max_duration", this.qqa);
      paramView.putExtra("album_video_min_duration", this.HMI);
      if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 14) {
        paramView.putExtra("key_edit_video_max_time_length", 300500);
      }
      paramView.putExtra("select_type_tag", this.selectType);
      startActivityForResult(paramView, 0);
    }
    label3104:
    AppMethodBeat.o(164801);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(111478);
    Log.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d] %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    Object localObject1;
    Object localObject2;
    if (4369 == paramInt1)
    {
      if (-1 != paramInt2)
      {
        AppMethodBeat.o(111478);
        return;
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.tools.t.g(getContext().getApplicationContext(), paramIntent, com.tencent.mm.loader.i.b.bmL());
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
        AppMethodBeat.o(111478);
        return;
      }
      Log.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[] { localObject1 });
      if ((this.mpb == 0) || (this.mpb == 5) || (this.mpb == 11) || (this.mpb == 24))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setData(Uri.parse("file://" + Uri.encode((String)localObject1)));
        Log.i("MicroMsg.AlbumPreviewUI", "take photo finish");
        setResult(-1, (Intent)localObject2);
        finish();
        localObject1 = paramIntent;
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((Intent)localObject1).getBooleanExtra("show_photo_edit_tip", false)))
      {
        paramIntent = getSharedPreferences("photo_edit_pref", 0);
        if (!paramIntent.getBoolean("has_show_tip", false))
        {
          this.HMk.setVisibility(0);
          this.HMk.setText(getString(b.i.photo_edit_tips));
          localObject1 = AnimationUtils.loadAnimation(getContext(), b.a.fast_faded_in);
          this.HMk.startAnimation((Animation)localObject1);
          ((Animation)localObject1).setAnimationListener(new Animation.AnimationListener()
          {
            private Runnable HNd;
            
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(289504);
              AlbumPreviewUI.F(AlbumPreviewUI.this).setVisibility(0);
              AlbumPreviewUI.F(AlbumPreviewUI.this).postDelayed(this.HNd, 4000L);
              AppMethodBeat.o(289504);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation) {}
          });
          paramIntent.edit().putBoolean("has_show_tip", true).apply();
        }
      }
      AppMethodBeat.o(111478);
      return;
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(localObject1);
      localObject1 = new Intent(this, ImagePreviewUI.class);
      ((Intent)localObject1).putExtra("isTakePhoto", true);
      ((Intent)localObject1).putExtra("max_select_count", 1);
      ((Intent)localObject1).putExtra("send_raw_img", this.wQK);
      if ((this.HMw) || (this.HMx)) {}
      for (boolean bool = true;; bool = false)
      {
        ((Intent)localObject1).putExtra("key_force_hide_edit_image_button", bool);
        ((Intent)localObject1).putExtra("key_force_show_raw_image_button", this.HMy);
        ((Intent)localObject1).putExtra("key_is_raw_image_button_disable", this.HMz);
        ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
        if (this.HMh != null) {
          ((Intent)localObject1).putParcelableArrayListExtra("preview_media_item_list", this.HMh.HLB);
        }
        ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.hQQ);
        ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject1).putExtra("select_type_tag", this.selectType);
        startActivityForResult((Intent)localObject1, 4370);
        localObject1 = paramIntent;
        break;
      }
      if (4370 == paramInt1)
      {
        if (-1 != paramInt2)
        {
          AppMethodBeat.o(111478);
          return;
        }
        if (paramIntent.getBooleanExtra("GalleryUI_IsSendImgBackground", false))
        {
          Log.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
          setResult(-1, paramIntent);
          finish();
          AppMethodBeat.o(111478);
          return;
        }
        localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
        {
          Log.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
          AppMethodBeat.o(111478);
          return;
        }
        Log.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", new Object[] { localObject1 });
        setResult(-1, paramIntent);
        finish();
        localObject1 = paramIntent;
        continue;
      }
      if (4371 == paramInt1)
      {
        if (-1 != paramInt2)
        {
          AppMethodBeat.o(111478);
          return;
        }
        if (paramIntent != null) {
          paramIntent.putExtra("from_record", true);
        }
        Log.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", new Object[] { paramIntent });
        setResult(-1, paramIntent);
        finish();
        localObject1 = paramIntent;
        continue;
      }
      if (4372 == paramInt1)
      {
        if (-1 != paramInt2)
        {
          AppMethodBeat.o(111478);
          return;
        }
        localObject1 = paramIntent;
        if (paramIntent == null) {
          localObject1 = new Intent();
        }
        Log.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", new Object[] { localObject1 });
        paramIntent = new ArrayList();
        localObject2 = getIntent().getStringExtra("video_full_path");
        if (!Util.isNullOrNil((String)localObject2))
        {
          paramIntent.add(localObject2);
          ((Intent)localObject1).putExtra("key_select_video_list", paramIntent);
          ((Intent)localObject1).putExtra("key_selected_video_is_from_sys_camera", true);
        }
        setResult(-1, (Intent)localObject1);
        finish();
        continue;
      }
      if (4373 == paramInt1)
      {
        if (paramIntent != null)
        {
          paramIntent.putExtra("GalleryUI_IsSendImgBackground", true);
          Log.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
        }
        Log.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
        setResult(-1, paramIntent);
        this.HMC = true;
        finish();
        localObject1 = paramIntent;
        continue;
      }
      Object localObject3;
      if (4378 == paramInt1)
      {
        if (-1 != paramInt2)
        {
          AppMethodBeat.o(111478);
          return;
        }
        localObject1 = paramIntent;
        if (paramIntent == null) {
          localObject1 = new Intent();
        }
        Log.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[] { localObject1 });
        paramIntent = (CaptureDataManager.CaptureVideoNormalModel)((Intent)localObject1).getParcelableExtra("KSEGMENTMEDIAINFO");
        if (paramIntent == null)
        {
          Log.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
          setResult(1);
          finish();
          AppMethodBeat.o(111478);
          return;
        }
        localObject2 = new ArrayList();
        localObject3 = paramIntent.videoPath;
        if (!Util.isNullOrNil((String)localObject3))
        {
          ((ArrayList)localObject2).add(localObject3);
          ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
        }
        if ((paramIntent.NHK.booleanValue()) && (!Util.isNullOrNil(paramIntent.thumbPath)))
        {
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(paramIntent.thumbPath);
          ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
        }
        setResult(-1, (Intent)localObject1);
        finish();
        continue;
      }
      if (4375 == paramInt1)
      {
        if (-1 != paramInt2)
        {
          AppMethodBeat.o(111478);
          return;
        }
        localObject1 = paramIntent;
        if (paramIntent == null) {
          localObject1 = new Intent();
        }
        Log.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[] { localObject1 });
        paramIntent = (SightCaptureResult)((Intent)localObject1).getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          Log.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
          setResult(1);
          finish();
          AppMethodBeat.o(111478);
          return;
        }
        localObject2 = new ArrayList();
        localObject3 = paramIntent.KTN;
        if (!Util.isNullOrNil((String)localObject3))
        {
          ((ArrayList)localObject2).add(localObject3);
          ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
        }
        if ((paramIntent.KTL) && (!Util.isNullOrNil(paramIntent.KTT)))
        {
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(paramIntent.KTT);
          ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
        }
        setResult(-1, (Intent)localObject1);
        finish();
        continue;
      }
      if (4376 == paramInt1)
      {
        if (-1 != paramInt2)
        {
          Log.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
          finish();
          localObject1 = paramIntent;
          continue;
        }
        localObject1 = paramIntent;
        if (paramIntent == null) {
          continue;
        }
        localObject1 = (GalleryItem.AlbumItem)paramIntent.getParcelableExtra("select_folder_name");
        a((GalleryItem.AlbumItem)localObject1);
        setMMTitle(Util.nullAs(((GalleryItem.AlbumItem)localObject1).albumName, getString(b.i.gallery_all_pic_and_video)));
        localObject1 = paramIntent;
        continue;
      }
      if (4377 == paramInt1)
      {
        localObject1 = paramIntent;
        if (paramInt2 != -1) {
          continue;
        }
        setResult(-1, paramIntent);
        finish();
        localObject1 = paramIntent;
        continue;
      }
      if (paramInt1 == 4379)
      {
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
          paramIntent.putExtra("key_extra_data", paramIntent.getBundleExtra("key_extra_data"));
          paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath);
          paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath);
          paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).gHE().J("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
          this.HMg = true;
          setResult(-1, paramIntent);
          finish();
        }
        for (;;)
        {
          if (paramInt2 != 0)
          {
            localObject1 = paramIntent;
            if (-2 != paramInt2) {
              break;
            }
          }
          localObject1 = paramIntent;
          if (Util.isNullOrNil(this.HNa)) {
            break;
          }
          a.a.HFE.aEO(this.HNa);
          localObject1 = paramIntent;
          break;
          if (paramInt2 == -2) {
            finish();
          }
        }
      }
      if (paramInt1 == 4383)
      {
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
          paramIntent.putExtra("key_extra_data", paramIntent.getBundleExtra("key_extra_data"));
          paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath);
          paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath);
          localObject1 = new ArrayList();
          localObject2 = new ArrayList();
          a((List)localObject1, (List)localObject2, new int[this.GzH]);
          paramIntent.putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
          paramIntent.putStringArrayListExtra("key_select_image_list", (ArrayList)localObject1);
          setResult(-1, paramIntent);
          finish();
        }
        for (;;)
        {
          if (paramInt2 != 0)
          {
            localObject1 = paramIntent;
            if (-2 != paramInt2) {
              break;
            }
          }
          localObject1 = paramIntent;
          if (Util.isNullOrNil(this.HNa)) {
            break;
          }
          a.a.HFE.aEO(this.HNa);
          localObject1 = paramIntent;
          break;
          if (paramInt2 == -2) {
            finish();
          }
        }
      }
      if (4382 == paramInt1)
      {
        Log.i("MicroMsg.AlbumPreviewUI", "back from smart gallery.");
        if (paramIntent != null)
        {
          localObject1 = paramIntent.getExtras();
          this.wQK = paramIntent.getBooleanExtra("send_raw_img", this.wQK);
          if (this.wQK)
          {
            this.HMp.setImageResource(b.h.radio_on);
            this.HMp.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_select_desc));
            if (this.HMz) {
              this.HMp.setImageResource(b.h.radio_default_on);
            }
            localObject2 = this.HMp;
            if (this.HMz) {
              break label2028;
            }
            bool = true;
            label1898:
            ((ImageButton)localObject2).setEnabled(bool);
            localObject2 = this.HMn;
            if (this.HMz) {
              break label2034;
            }
          }
          label2028:
          label2034:
          for (bool = true;; bool = false)
          {
            ((TextView)localObject2).setEnabled(bool);
            if (localObject1 == null) {
              break label2040;
            }
            localObject2 = ((Bundle)localObject1).keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              Log.i("MicroMsg.AlbumPreviewUI", "key: %s, value: %s.", new Object[] { localObject3, ((Bundle)localObject1).get((String)localObject3) });
            }
            this.HMp.setImageResource(b.h.radio_off);
            this.HMp.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
            break;
            bool = false;
            break label1898;
          }
        }
        label2040:
        if ((-2 == paramInt2) || (paramInt2 == 0) || (SmartGalleryUI.HQv == paramInt2))
        {
          Log.i("MicroMsg.AlbumPreviewUI", "just back from SmartGalleryUI.");
          paramIntent = new androidx.b.b();
          paramInt1 = i;
          while (paramInt1 < this.HMh.HLB.size())
          {
            localObject1 = (GalleryItem.MediaItem)this.HMh.HLB.get(paramInt1);
            i = this.HMh.HLA.indexOf(localObject1);
            if (i != -1) {
              paramIntent.add(Integer.valueOf(i));
            }
            paramInt1 += 1;
          }
          this.HMh.id(com.tencent.mm.plugin.gallery.model.t.fAV().HIv);
          if (SmartGalleryUI.HQv == paramInt2)
          {
            faD();
            AppMethodBeat.o(111478);
            return;
          }
          WH(this.HMh.HLB.size());
          this.HMh.a(paramIntent);
          AppMethodBeat.o(111478);
          return;
        }
        if (-1 == paramInt2) {
          this.HMg = true;
        }
        setResult(paramInt2, paramIntent);
        finish();
        localObject1 = paramIntent;
        continue;
      }
      if (paramInt1 == 4381)
      {
        if (paramInt2 == -1)
        {
          if (this.HMv)
          {
            paramIntent = RecordConfigProvider.lk("", "");
            paramIntent.NHZ = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
            paramIntent.scene = 2;
            localObject1 = new VideoCaptureReportInfo();
            ((VideoCaptureReportInfo)localObject1).ybL = 1;
            paramIntent.NIi = ((VideoCaptureReportInfo)localObject1);
            localObject1 = new UICustomParam.a();
            ((UICustomParam.a)localObject1).aQw();
            ((UICustomParam.a)localObject1).aQv();
            ((UICustomParam.a)localObject1).eL(true);
            paramIntent.NHR = ((UICustomParam.a)localObject1).lZB;
            localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
            com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, b.a.sight_slide_bottom_in, -1, paramIntent, 4, 0);
            AppMethodBeat.o(111478);
            return;
          }
          localObject1 = paramIntent;
          if (22 != com.tencent.mm.plugin.gallery.model.e.fAn().sfB) {
            continue;
          }
          setResult(-1, paramIntent);
          finish();
          AppMethodBeat.o(111478);
          return;
        }
        Toast.makeText(this, b.i.loading_failed, 1).show();
        localObject1 = paramIntent;
        continue;
      }
      if (paramInt1 == 17) {
        switch (paramInt2)
        {
        default: 
          localObject1 = paramIntent;
          break;
        case -1: 
          paramIntent.putExtra("query_source_type", this.mpb);
          paramIntent.putExtra("isSightCapture", true);
          localObject1 = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
          if (localObject1 != null)
          {
            if (!((SightCaptureResult)localObject1).KTL) {
              break label2564;
            }
            localObject2 = new GalleryItem.ImageMediaItem();
            ((GalleryItem.MediaItem)localObject2).Gcc = ((SightCaptureResult)localObject1).KTT;
            if (this.HMh.HLB.size() < 9) {
              this.HMh.HLB.add(localObject2);
            }
            faD();
          }
          for (;;)
          {
            overridePendingTransition(0, 0);
            localObject1 = paramIntent;
            break;
            label2564:
            setResult(-1, paramIntent);
            finish();
          }
        }
      }
      if (paramInt1 == 4384)
      {
        Log.i("MicroMsg.AlbumPreviewUI", "REQUEST_CODE_TEMPLATE_VIDEO callback ");
        localObject1 = paramIntent;
        if (paramIntent == null) {
          continue;
        }
        localObject1 = paramIntent.getStringExtra("key_export_video_path");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          Log.e("MicroMsg.AlbumPreviewUI", "template video path is null");
          finish();
          AppMethodBeat.o(111478);
          return;
        }
      }
      try
      {
        new Intent().putExtra("KSightPath", (String)localObject1);
        localObject2 = com.tencent.mm.plugin.s.a.KOy;
        localObject2 = com.tencent.mm.plugin.s.a.aLb(System.currentTimeMillis());
        BitmapUtil.saveBitmapToImage(com.tencent.mm.plugin.mmsight.d.Pf((String)localObject1), 60, Bitmap.CompressFormat.JPEG, (String)localObject2, true);
        paramIntent.putExtra("key_extra_data", paramIntent.getBundleExtra("key_extra_data"));
        paramIntent.putExtra("K_SEGMENTVIDEOPATH", (String)localObject1);
        paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", (String)localObject2);
        paramIntent.putExtra("KSEGMENTMEDIAEDITID", com.tencent.mm.plugin.sns.data.t.heT());
        localObject2 = com.tencent.mm.plugin.gallery.a.c.HFY;
        com.tencent.mm.plugin.gallery.a.c.report();
        setResult(-1, paramIntent);
        finish();
        label2760:
        Log.i("MicroMsg.AlbumPreviewUI", "REQUEST_CODE_TEMPLATE_VIDEO path:%s", new Object[] { localObject1 });
        localObject1 = paramIntent;
        continue;
        switch (paramInt2)
        {
        default: 
          localObject1 = paramIntent;
          break;
        case -2: 
          Log.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
          finish();
          localObject1 = paramIntent;
          break;
        case -1: 
          localObject2 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((this.mpb == 28) && (((ArrayList)localObject2).size() > 0))
          {
            localObject1 = (String)((ArrayList)localObject2).get(0);
            if (!aEX((String)localObject1))
            {
              Log.i("MicroMsg.AlbumPreviewUI", "not support ratio");
              localObject2 = getResources().getString(b.i.gallery_select_pic_ratio_not_support);
              localObject1 = paramIntent;
              if (localObject2 == null) {
                continue;
              }
              k.cZ(getContext(), (String)localObject2);
              localObject1 = paramIntent;
              continue;
            }
            localObject2 = new Intent();
            if (this.mpb == 10) {
              ((Intent)localObject2).putExtra("CropImage_OutputPath", (String)localObject1);
            }
            ((Intent)localObject2).setData(Uri.parse(Uri.encode((String)localObject1)));
            Log.i("MicroMsg.AlbumPreviewUI", "getItem ok");
            setResult(-1, (Intent)localObject2);
            finish();
            localObject1 = paramIntent;
            continue;
          }
          if ((this.mpb == 22) && (this.HMM))
          {
            localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0) || (this.HMY == null)) {
              break label3227;
            }
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(this.HMY);
            this.HMh.id((List)localObject1);
            paramInt1 = this.HMh.HLA.indexOf(this.HMY);
            if (paramInt1 == -1) {
              break label3227;
            }
            localObject1 = new androidx.b.b();
            ((androidx.b.b)localObject1).add(Integer.valueOf(paramInt1));
            this.HMh.a((androidx.b.b)localObject1);
            WH(this.HMh.HLB.size());
            faD();
          }
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            localObject1 = paramIntent;
            if (paramInt1 != 0) {
              break;
            }
            localObject1 = paramIntent;
            if (paramIntent == null)
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("CropImage_Compress_Img", true);
              ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", this.HMh.fBk());
            }
            ((Intent)localObject1).putStringArrayListExtra("key_select_image_list", (ArrayList)localObject2);
            Log.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
            this.HMg = true;
            setResult(-1, (Intent)localObject1);
            finish();
            break;
          }
        case 0: 
          label3227:
          localObject1 = paramIntent;
          if (paramIntent == null) {
            continue;
          }
          localObject2 = paramIntent.getStringArrayListExtra("preview_image_list");
          if (localObject2 == null) {}
          for (paramInt1 = 0;; paramInt1 = ((ArrayList)localObject2).size())
          {
            Log.i("MicroMsg.AlbumPreviewUI", "paths size: %d.", new Object[] { Integer.valueOf(paramInt1) });
            if ((localObject2 == null) || (this.HMh == null)) {
              break label3416;
            }
            localObject3 = new androidx.b.b();
            paramInt1 = 0;
            while (paramInt1 < this.HMh.HLB.size())
            {
              localObject1 = (GalleryItem.MediaItem)this.HMh.HLB.get(paramInt1);
              paramInt2 = this.HMh.HLA.indexOf(localObject1);
              if (paramInt2 != -1) {
                ((androidx.b.b)localObject3).add(Integer.valueOf(paramInt2));
              }
              paramInt1 += 1;
            }
          }
          a locala = this.HMh;
          if (com.tencent.mm.plugin.gallery.model.e.fAp() != null)
          {
            localObject1 = com.tencent.mm.plugin.gallery.model.e.fAp();
            label3389:
            locala.j((ArrayList)localObject2, (ArrayList)localObject1);
            this.HMh.a((androidx.b.b)localObject3);
            WH(((ArrayList)localObject2).size());
            label3416:
            if (paramIntent.getBooleanExtra("CropImage_Compress_Img", true)) {
              break label3649;
            }
            bool = true;
            label3430:
            this.wQK = bool;
            if ((ab.bOG()) && (this.mpb == 3)) {
              this.HMh.vU(this.wQK);
            }
            if (!this.wQK) {
              break label3672;
            }
            this.HMp.setImageResource(b.h.radio_on);
            this.HMp.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_select_desc));
            if ((!ab.bOG()) || (this.mpb != 3) || (!this.wQK)) {
              break label3660;
            }
            localObject1 = fBu();
            localObject2 = this.HMo;
            if (!Util.isNullOrNil((String)localObject1)) {
              break label3655;
            }
            paramInt1 = 8;
            label3539:
            ((TextView)localObject2).setVisibility(paramInt1);
            this.HMo.setText(getString(b.i.gallery_album_summary_item_size_tips, new Object[] { localObject1 }));
            label3568:
            if (this.HMz) {
              this.HMp.setImageResource(b.h.radio_default_on);
            }
            localObject1 = this.HMp;
            if (this.HMz) {
              break label3711;
            }
            bool = true;
            label3601:
            ((ImageButton)localObject1).setEnabled(bool);
            localObject1 = this.HMn;
            if (this.HMz) {
              break label3717;
            }
          }
          label3717:
          for (bool = true;; bool = false)
          {
            ((TextView)localObject1).setEnabled(bool);
            localObject1 = paramIntent;
            break;
            localObject1 = this.HMh.HLA;
            break label3389;
            label3649:
            bool = false;
            break label3430;
            label3655:
            paramInt1 = 0;
            break label3539;
            label3660:
            this.HMo.setVisibility(8);
            break label3568;
            label3672:
            this.HMp.setImageResource(b.h.radio_off);
            this.HMp.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
            this.HMo.setVisibility(8);
            break label3568;
            label3711:
            bool = false;
            break label3601;
          }
        }
      }
      catch (Exception localException)
      {
        break label2760;
      }
    }
  }
  
  protected void onBackBtnClick()
  {
    AppMethodBeat.i(289619);
    com.tencent.mm.kernel.h.baH().postToWorker(new AlbumPreviewUI.6(this));
    AppMethodBeat.o(289619);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(164799);
    super.onBackPressed();
    onBackBtnClick();
    AppMethodBeat.o(164799);
  }
  
  public void onBusinessPermissionDenied(String paramString)
  {
    AppMethodBeat.i(289713);
    if (d.c.actx.value == paramString)
    {
      this.HMB = false;
      AppMethodBeat.o(289713);
      return;
    }
    if (d.c.actw.value == paramString) {
      finish();
    }
    AppMethodBeat.o(289713);
  }
  
  public void onBusinessPermissionGranted(String paramString)
  {
    AppMethodBeat.i(289710);
    if (d.c.actx.value == paramString)
    {
      fBt();
      AppMethodBeat.o(289710);
      return;
    }
    if (d.c.actw.value == paramString) {
      fBr();
    }
    AppMethodBeat.o(289710);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111464);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.AlbumPreviewUI", "onCreate, %s.", new Object[] { this });
    setRequestedOrientation(1);
    getString(b.i.permission_tips_title);
    String str = getString(b.i.gallery_permission_msg);
    this.HMP = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 145, str);
    Log.d("MicroMsg.AlbumPreviewUI", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(this.HMP) });
    this.HMG = System.currentTimeMillis();
    start = System.currentTimeMillis();
    this.lzP = w.a(this, getString(b.i.app_waiting), false);
    this.HMV = AlbumPreviewUI.b.HNk;
    if (paramBundle != null)
    {
      Log.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
      this.mpb = paramBundle.getInt("constants_key_query_source");
    }
    for (this.HMO = paramBundle.getInt("constants_key_query_type");; this.HMO = getIntent().getIntExtra("query_media_type", 1))
    {
      com.tencent.mm.plugin.gallery.model.e.fAn().sfB = this.mpb;
      com.tencent.mm.plugin.gallery.model.e.fAn().setQueryType(this.HMO);
      Log.i("MicroMsg.AlbumPreviewUI", "query source: " + this.mpb + ", queryType: " + this.HMO);
      this.selectType = getIntent().getIntExtra("select_type_tag", 3);
      this.xCI = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVi, true);
      this.HML = getIntent().getBooleanExtra("is_from_smart_gallery", false);
      this.HMM = getIntent().getBooleanExtra("album_is_from_text_status", false);
      this.HMN = getIntent().getStringExtra("edt_video_layout_from_text_status");
      initView();
      if (this.HMP) {
        fBr();
      }
      com.tencent.mm.plugin.gallery.model.e.fAv();
      AppMethodBeat.o(111464);
      return;
      this.mpb = getIntent().getIntExtra("query_source_type", 3);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111469);
    super.onDestroy();
    Object localObject = com.tencent.mm.plugin.gallery.a.c.HFY;
    Log.i("MicroMsg.MJTemplateHandle", "unbind");
    com.tencent.mm.plugin.gallery.a.c.HGb = null;
    int i;
    if (!com.tencent.mm.plugin.gallery.a.c.nWh)
    {
      localObject = com.tencent.mm.plugin.gallery.a.c.HFZ;
      if ((localObject == null) || (((com.tencent.mm.plugin.gallery.a.a)localObject).fzK() != true)) {
        break label395;
      }
      i = 1;
      if (i != 0) {
        com.tencent.mm.plugin.gallery.a.c.report();
      }
    }
    localObject = com.tencent.mm.plugin.gallery.a.c.HFZ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.gallery.a.a)localObject).HFH = null;
    }
    com.tencent.mm.plugin.gallery.a.c.HFZ = null;
    ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).releaseMaas();
    com.tencent.mm.plugin.gallery.a.c.HGc = null;
    com.tencent.mm.plugin.gallery.a.c.HFI = null;
    Log.i("MicroMsg.AlbumPreviewUI", "onDestroy, %s.", new Object[] { this });
    if (com.tencent.mm.plugin.gallery.model.e.fAn() != null)
    {
      com.tencent.mm.plugin.gallery.model.e.fAn().b(this);
      localObject = com.tencent.mm.plugin.gallery.model.e.fAn();
      l.b localb = this.HMK;
      if (localb != null) {
        ((com.tencent.mm.plugin.gallery.model.q)localObject).HHY.remove(localb);
      }
    }
    label244:
    boolean bool2;
    if ((this.HMD > 0) || (this.HME > 0))
    {
      Log.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", new Object[] { Integer.valueOf(this.HMD), Integer.valueOf(this.HME) });
      com.tencent.mm.plugin.gallery.b.h.bZ(11187, this.HMD + "," + this.HME);
      if ((this.HMF > 0L) || (this.HMg)) {
        com.tencent.mm.plugin.gallery.model.e.a(this.HMt, aL(this.HMh.HLB), this.wQK, this.HMf);
      }
      i = this.HMh.HLB.size();
      bool2 = this.wQK;
      if ((this.HMF <= 0L) && (!this.HMg)) {
        break label412;
      }
    }
    label395:
    label412:
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.plugin.gallery.model.e.j(i, bool2, bool1);
      com.tencent.mm.api.ac.hdY.aAA().aAz();
      com.tencent.mm.plugin.gallery.model.e.fAq().clear();
      com.tencent.mm.plugin.gallery.model.e.fAr().clear();
      com.tencent.mm.plugin.gallery.model.e.fAs().clear();
      if (!this.HML) {
        break label417;
      }
      com.tencent.mm.plugin.gallery.model.t.fAV().HIt = true;
      if (com.tencent.mm.plugin.gallery.model.e.fAw())
      {
        com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.nNV).resetSize();
        a.g.fBn();
      }
      AppMethodBeat.o(111469);
      return;
      i = 0;
      break;
      Log.d("MicroMsg.AlbumPreviewUI", "not click camera or folder.");
      break label244;
    }
    label417:
    if (!this.qgg) {
      a.a.HFE.report();
    }
    for (;;)
    {
      com.tencent.mm.plugin.gallery.model.t.fAV().HIu = true;
      com.tencent.mm.plugin.gallery.model.e.fAn().fAS();
      break;
      a.a.HFE.reset();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111477);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      Log.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
      setResult(-2);
      if ((this.HMl != null) && (this.HMl.qv))
      {
        this.HMl.fBC();
        playActionBarOperationAreaAnim();
        AppMethodBeat.o(111477);
        return true;
      }
      this.qgg = true;
      finish();
      AppMethodBeat.o(111477);
      return true;
    }
    if (paramInt == 82)
    {
      this.HME += 1;
      if (this.HMl != null) {
        this.HMl.fBC();
      }
      AppMethodBeat.o(111477);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(111477);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(111467);
    super.onPause();
    Log.i("MicroMsg.AlbumPreviewUI", "on onPause, %s.", new Object[] { this });
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    this.HMB = true;
    ImageFolderMgrView localImageFolderMgrView;
    if ((!isFinishing()) && (!isDestroyed()) && (this.HMl != null) && (this.HMl.qv))
    {
      localImageFolderMgrView = this.HMl;
      if (localImageFolderMgrView.qv) {
        break label133;
      }
      Log.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
    }
    for (;;)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, this.lyw);
      this.lyw = 0;
      if (this.HML) {
        com.tencent.mm.plugin.gallery.model.t.fAV().ic(this.HMh.HLB);
      }
      AppMethodBeat.o(111467);
      return;
      label133:
      if (localImageFolderMgrView.HOt)
      {
        Log.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
      }
      else
      {
        localImageFolderMgrView.HOp.setVisibility(8);
        localImageFolderMgrView.qv = false;
        if (localImageFolderMgrView.HOx != null) {
          localImageFolderMgrView.HOx.vV(false);
        }
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(111483);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(111483);
      return;
    }
    Log.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111483);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        fBt();
        AppMethodBeat.o(111483);
        return;
      }
      k.a(this, getString(b.i.permission_camera_request_again_msg), getString(b.i.permission_tips_title), getString(b.i.jump_to_settings), getString(b.i.gallery_cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(173756);
          com.tencent.mm.pluginsdk.permission.b.lx(AlbumPreviewUI.this.getContext());
          AppMethodBeat.o(173756);
        }
      }, null);
      AppMethodBeat.o(111483);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        fBq();
        com.tencent.mm.plugin.gallery.model.e.fAn().fAR();
        fBr();
        AppMethodBeat.o(111483);
        return;
      }
      k.a(this, getString(b.i.permission_gallery_request_again_msg), getString(b.i.permission_tips_title), getString(b.i.jump_to_settings), getString(b.i.gallery_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(111432);
          com.tencent.mm.pluginsdk.permission.b.lx(AlbumPreviewUI.this.getContext());
          AlbumPreviewUI.this.finish();
          AppMethodBeat.o(111432);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(289468);
          AlbumPreviewUI.this.finish();
          AppMethodBeat.o(289468);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111465);
    super.onResume();
    Log.i("MicroMsg.AlbumPreviewUI", "onResume, %s.", new Object[] { this });
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    this.HMB = false;
    com.tencent.mm.plugin.comm.b.e.xfd.a("SnsPublishProcess", "selectPagetimes", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT);
    AppMethodBeat.o(111465);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(111470);
    super.onSaveInstanceState(paramBundle);
    Log.i("MicroMsg.AlbumPreviewUI", "onSaveInstanceState, %s.", new Object[] { this });
    paramBundle.putInt("constants_key_query_source", this.mpb);
    paramBundle.putInt("constants_key_query_type", this.HMO);
    AppMethodBeat.o(111470);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(111466);
    super.onStart();
    Log.i("MicroMsg.AlbumPreviewUI", "onStart, %s.", new Object[] { this });
    if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB != this.mpb) {
      com.tencent.mm.plugin.gallery.model.e.fAn().sfB = this.mpb;
    }
    if (com.tencent.mm.plugin.gallery.model.e.fAn().HIa != this.HMO) {
      com.tencent.mm.plugin.gallery.model.e.fAn().setQueryType(this.HMO);
    }
    AppMethodBeat.o(111466);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(111468);
    super.onStop();
    Log.i("MicroMsg.AlbumPreviewUI", "onStop, %s.", new Object[] { this });
    if (!this.HML)
    {
      com.tencent.mm.plugin.gallery.model.c localc = com.tencent.mm.plugin.gallery.model.e.fAm();
      if ((localc.HGy != null) && (!localc.HGy.isEmpty()))
      {
        Iterator localIterator = localc.HGy.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.c localc1 = (c.c)((Map.Entry)localIterator.next()).getValue();
          if (localc1 != null) {
            localc1.mCancel = true;
          }
        }
        if (localc.HGx != null) {
          localc.HGx.clear();
        }
        if ((localc.HGy != null) && (!localc.HGy.isEmpty())) {
          localc.HGy.clear();
        }
        localc.HGv.fAi();
      }
      com.tencent.mm.plugin.gallery.model.e.fAm().fAh();
    }
    AppMethodBeat.o(111468);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(289706);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.gallery.b.a.class);
    AppMethodBeat.o(289706);
  }
  
  static final class a
    implements Runnable
  {
    WeakReference<AlbumPreviewUI> tey;
    
    a(AlbumPreviewUI paramAlbumPreviewUI)
    {
      AppMethodBeat.i(111448);
      this.tey = new WeakReference(paramAlbumPreviewUI);
      AppMethodBeat.o(111448);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111449);
      long l = System.currentTimeMillis();
      boolean bool = com.tencent.mm.plugin.gallery.model.t.fAV().hF((Context)this.tey.get());
      l = System.currentTimeMillis() - l;
      Log.i("MicroMsg.AlbumPreviewUI", "smart gallery isValid: %s, dur: %s.", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.h.OAn.b(19165, new Object[] { Long.valueOf(l) });
      if (l <= 3000L) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1297, 0);
      }
      for (;;)
      {
        if (bool)
        {
          a.a.HFE.HFq = 1;
          com.tencent.mm.plugin.gallery.model.e.fAo().postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111447);
              if (AlbumPreviewUI.a.this.tey != null)
              {
                AlbumPreviewUI localAlbumPreviewUI = (AlbumPreviewUI)AlbumPreviewUI.a.this.tey.get();
                if (localAlbumPreviewUI != null)
                {
                  localAlbumPreviewUI.setSmartGalleryEntryVisibility(true);
                  localAlbumPreviewUI.HMX = true;
                }
              }
              AppMethodBeat.o(111447);
            }
          });
        }
        AppMethodBeat.o(111449);
        return;
        if (l <= 5000L) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1297, 1);
        } else if (l <= 10000L) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1297, 2);
        } else if (l <= 15000L) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1297, 3);
        } else {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1297, 4);
        }
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    WeakReference<ImageFolderMgrView> HNn;
    public GalleryItem.MediaItem HNo;
    public int count;
    
    public final void run()
    {
      AppMethodBeat.i(289479);
      if ((this.HNn != null) && (this.HNn.get() != null))
      {
        Object localObject = (ImageFolderMgrView)this.HNn.get();
        GalleryItem.MediaItem localMediaItem = this.HNo;
        int j = this.count;
        localObject = ((ImageFolderMgrView)localObject).HOs;
        if ((Util.isNullOrNil(((b)localObject).HNG)) || (((b)localObject).HNF == null) || (((b)localObject).HNF.size() == 0))
        {
          Log.d("MicroMsg.GalleryAdapter", "refresh album count: %s", new Object[] { ((b)localObject).HNG + ", mAlbumFolder = " + ((b)localObject).HNF });
          AppMethodBeat.o(289479);
          return;
        }
        int i = 0;
        while (i < ((b)localObject).HNF.size())
        {
          GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)((b)localObject).HNF.get(i);
          if ((localAlbumItem != null) && (!localAlbumItem.akiu) && (!localAlbumItem.akiv) && (((b)localObject).HNG.equals(localAlbumItem.albumName)))
          {
            if (j != localAlbumItem.hGP)
            {
              localAlbumItem.hGP = j;
              Log.d("MicroMsg.GalleryAdapter", "refresh album count: %s", new Object[] { Integer.valueOf(j) });
            }
            localAlbumItem.akiw = false;
            if ((localMediaItem != null) && (localAlbumItem.HHB != null) && (!Util.isNullOrNil(localMediaItem.bud())) && (!localAlbumItem.bud().equals(localMediaItem.bud())))
            {
              localAlbumItem.HHB.zWJ = localMediaItem.bud();
              Log.d("MicroMsg.GalleryAdapter", "refresh album image.");
            }
            ((b)localObject).notifyDataSetChanged();
            AppMethodBeat.o(289479);
            return;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(289479);
    }
  }
  
  static final class d
    implements Runnable
  {
    String HMJ;
    WeakReference<ImageFolderMgrView> HNn;
    WeakReference<a> HNp;
    WeakReference<ProgressDialog> HNq;
    WeakReference<TextView> HNr;
    WeakReference<RecyclerView> HNs;
    LinkedList<GalleryItem.MediaItem> HNt;
    boolean HNu = false;
    
    public final void run()
    {
      AppMethodBeat.i(111455);
      if (this.HNt == null) {}
      for (int i = -1;; i = this.HNt.size())
      {
        Log.d("MicroMsg.AlbumPreviewUI", "on NotifyMediaItemsChanged, size %d", new Object[] { Integer.valueOf(i) });
        AlbumPreviewUI.bp(this.HNt);
        if (this.HNp != null) {
          break;
        }
        Log.w("MicroMsg.AlbumPreviewUI", "null == adapterRef");
        AppMethodBeat.o(111455);
        return;
      }
      Object localObject1 = (a)this.HNp.get();
      if (localObject1 == null)
      {
        Log.w("MicroMsg.AlbumPreviewUI", "null == adapter");
        AppMethodBeat.o(111455);
        return;
      }
      if (this.HNs == null)
      {
        AppMethodBeat.o(111455);
        return;
      }
      RecyclerView localRecyclerView = (RecyclerView)this.HNs.get();
      if (localRecyclerView == null)
      {
        AppMethodBeat.o(111455);
        return;
      }
      Log.d("MicroMsg.AlbumPreviewUI", "isSwitchAlbum: %s.", new Object[] { Boolean.valueOf(this.HNu) });
      Object localObject2 = r.HIe;
      r.fAT().ia(this.HNt);
      if (this.HNu)
      {
        this.HNu = false;
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((a)localObject1).bn(this.HNt);
        localObject2 = r.HIe;
        localObject2 = r.fAT();
        r.c localc = r.c.HIl;
        if (this.HNt.size() > 32)
        {
          i = 32;
          ((r)localObject2).a(localc, 0, i, ((a)localObject1).HLA.size());
        }
      }
      for (;;)
      {
        if (this.HNq != null) {
          break label335;
        }
        AppMethodBeat.o(111455);
        return;
        i = this.HNt.size();
        break;
        ((a)localObject1).bo(this.HNt);
      }
      label335:
      localObject2 = (ProgressDialog)this.HNq.get();
      if ((localObject2 != null) && (((ProgressDialog)localObject2).isShowing()))
      {
        ((ProgressDialog)localObject2).dismiss();
        Log.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start) });
      }
      if (this.HNn != null)
      {
        localObject2 = (ImageFolderMgrView)this.HNn.get();
        if (localObject2 != null) {
          ((ImageFolderMgrView)localObject2).setFavItemCount(this.HNt.size());
        }
      }
      if ((this.HNr == null) || (Util.isNullOrNil(this.HMJ)))
      {
        AppMethodBeat.o(111455);
        return;
      }
      localObject2 = (TextView)this.HNr.get();
      if (localObject2 != null)
      {
        localObject1 = ((a)localObject1).WG(((GridLayoutManager)localRecyclerView.getLayoutManager()).Ju());
        if ((!Util.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("album_business_bubble_media_by_coordinate")))
        {
          ((TextView)localObject2).setVisibility(0);
          ((TextView)localObject2).setText(this.HMJ.concat("附近的照片和视频"));
          ((TextView)localObject2).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111454);
              if (8 == this.HNv.getVisibility())
              {
                AppMethodBeat.o(111454);
                return;
              }
              this.HNv.animate().alpha(0.0F).setDuration(300L).withEndAction(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111453);
                  AlbumPreviewUI.d.1.this.HNv.setVisibility(8);
                  AlbumPreviewUI.d.1.this.HNv.setAlpha(1.0F);
                  AppMethodBeat.o(111453);
                }
              });
              AppMethodBeat.o(111454);
            }
          }, 2000L);
        }
      }
      AppMethodBeat.o(111455);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(111456);
      String str = super.toString() + "|NotifyMediaItemsChanged";
      AppMethodBeat.o(111456);
      return str;
    }
  }
  
  static final class e
    implements Runnable
  {
    private WeakReference<ProgressDialog> HNA;
    private WeakReference<RecyclerView> HNB;
    private String HNy;
    private WeakReference<a> HNz;
    
    e(String paramString, a parama, ProgressDialog paramProgressDialog, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(289478);
      this.HNy = paramString;
      this.HNz = new WeakReference(parama);
      this.HNA = new WeakReference(paramProgressDialog);
      this.HNB = new WeakReference(paramRecyclerView);
      AppMethodBeat.o(289478);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111459);
      if (Util.isNullOrNil(this.HNy))
      {
        AppMethodBeat.o(111459);
        return;
      }
      Log.i("QuerySmartGalleryAlbumMediaTask", "start query.");
      com.tencent.mm.plugin.gallery.model.t localt = com.tencent.mm.plugin.gallery.model.t.fAV();
      Object localObject1 = this.HNy;
      t.h local1 = new t.h()
      {
        public final void s(List<t.g> paramAnonymousList, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(161161);
          if (AlbumPreviewUI.e.a(AlbumPreviewUI.e.this) != null)
          {
            localObject = (a)AlbumPreviewUI.e.a(AlbumPreviewUI.e.this).get();
            if (localObject != null)
            {
              if ((!paramAnonymousBoolean) && (((a)localObject).HLA.size() <= paramAnonymousList.size())) {
                break label148;
              }
              AlbumPreviewUI.e.jdMethod_if(paramAnonymousList);
            }
          }
          Object localObject = new LinkedList();
          paramAnonymousList = paramAnonymousList.iterator();
          for (;;)
          {
            if (!paramAnonymousList.hasNext()) {
              break label229;
            }
            t.g localg = (t.g)paramAnonymousList.next();
            GalleryItem.MediaItem localMediaItem;
            if (localg.type.contains("image"))
            {
              localMediaItem = GalleryItem.MediaItem.a(1, localg.HIN, localg.data, "", localg.type);
              localMediaItem.HHK = localg.HIO;
              ((LinkedList)localObject).add(localMediaItem);
              continue;
              label148:
              AlbumPreviewUI.e.jdMethod_if(paramAnonymousList.subList(((a)localObject).HLA.size(), paramAnonymousList.size()));
              break;
            }
            if (localg.type.contains("video"))
            {
              localMediaItem = GalleryItem.MediaItem.a(2, localg.HIN, localg.data, "", localg.type);
              localMediaItem.HHK = localg.HIO;
              ((LinkedList)localObject).add(localMediaItem);
            }
          }
          label229:
          paramAnonymousList = new AlbumPreviewUI.d((byte)0);
          paramAnonymousList.HNp = AlbumPreviewUI.e.a(AlbumPreviewUI.e.this);
          paramAnonymousList.HNq = AlbumPreviewUI.e.b(AlbumPreviewUI.e.this);
          paramAnonymousList.HNt = ((LinkedList)localObject);
          paramAnonymousList.HNs = AlbumPreviewUI.e.c(AlbumPreviewUI.e.this);
          paramAnonymousList.HNu = paramAnonymousBoolean;
          com.tencent.mm.plugin.gallery.model.e.fAo().postToMainThread(paramAnonymousList);
          Log.i("QuerySmartGalleryAlbumMediaTask", "finish page query.");
          AppMethodBeat.o(161161);
        }
      };
      if (!com.tencent.luggage.l.i.s(MMApplicationContext.getContext(), "android.permission.READ_EXTERNAL_STORAGE"))
      {
        Log.i("MicroMsg.SmartGalleryQueryUtil", "queryAlbum without READ_EXTERNAL_STORAGE.");
        AppMethodBeat.o(111459);
        return;
      }
      Log.i("MicroMsg.SmartGalleryQueryUtil", "has permiss.");
      localt.HIt = false;
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = com.tencent.mm.plugin.gallery.model.t.dYo.buildUpon().appendEncodedPath("albumInfo").build();
      localObject1 = localt.mJn.query((Uri)localObject2, new String[] { "_id", "_data", "mime_type", "date_modified", "datetaken", "latitude", "longitude" }, "albumID=?", new String[] { localObject1 }, null);
      boolean bool;
      if (localObject1 != null)
      {
        int i = ((Cursor)localObject1).getColumnIndex("_id");
        int j = ((Cursor)localObject1).getColumnIndex("_data");
        int k = ((Cursor)localObject1).getColumnIndex("mime_type");
        int m = ((Cursor)localObject1).getColumnIndex("datetaken");
        bool = true;
        while (((Cursor)localObject1).moveToNext())
        {
          if (localt.HIt) {
            break label416;
          }
          localObject2 = new t.g();
          ((t.g)localObject2).HIN = Util.safeParseLong(((Cursor)localObject1).getString(i));
          ((t.g)localObject2).data = ((Cursor)localObject1).getString(j);
          ((t.g)localObject2).type = ((Cursor)localObject1).getString(k);
          ((t.g)localObject2).HIO = Util.safeParseLong(((Cursor)localObject1).getString(m));
          Log.d("MicroMsg.SmartGalleryQueryUtil", "mediaID:%d data:%s type:%s.", new Object[] { Long.valueOf(((t.g)localObject2).HIN), ((t.g)localObject2).data, ((t.g)localObject2).type });
          localArrayList.add(localObject2);
          if (localArrayList.size() % localt.HIs == 0)
          {
            local1.s(localArrayList, bool);
            if (bool) {
              bool = false;
            }
          }
        }
        ((Cursor)localObject1).close();
      }
      for (;;)
      {
        local1.s(localArrayList, bool);
        label416:
        AppMethodBeat.o(111459);
        return;
        bool = true;
      }
    }
  }
  
  static final class f
    implements Runnable
  {
    boolean HND;
    WeakReference<ImageFolderMgrView> HNn;
    WeakReference<a> HNp;
    WeakReference<ProgressDialog> HNq;
    List<Long> idList;
    int type;
    
    public final void run()
    {
      AppMethodBeat.i(111462);
      com.tencent.mm.plugin.gallery.model.t localt = com.tencent.mm.plugin.gallery.model.t.fAV();
      l.c local1 = new l.c()
      {
        public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(111461);
          Log.i("MicroMsg.AlbumPreviewUI", "RetrieveFavMediaTask onQueryMediaFinished cancelUINotify: %s.", new Object[] { Boolean.valueOf(AlbumPreviewUI.f.this.HND) });
          if (AlbumPreviewUI.f.this.HND)
          {
            AppMethodBeat.o(111461);
            return;
          }
          LinkedList localLinkedList = new LinkedList();
          if (paramAnonymousLinkedList != null) {
            localLinkedList.addAll(paramAnonymousLinkedList);
          }
          paramAnonymousLinkedList = localLinkedList.iterator();
          while (paramAnonymousLinkedList.hasNext())
          {
            GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)paramAnonymousLinkedList.next();
            Log.d("MicroMsg.AlbumPreviewUI", "type: %s path: %s", new Object[] { localMediaItem.mMimeType, localMediaItem.Gcc });
          }
          paramAnonymousLinkedList = new AlbumPreviewUI.d((byte)0);
          paramAnonymousLinkedList.HNp = AlbumPreviewUI.f.this.HNp;
          paramAnonymousLinkedList.HNq = AlbumPreviewUI.f.this.HNq;
          paramAnonymousLinkedList.HNt = localLinkedList;
          paramAnonymousLinkedList.HNn = AlbumPreviewUI.f.this.HNn;
          com.tencent.mm.plugin.gallery.model.e.fAo().postToMainThread(paramAnonymousLinkedList);
          AppMethodBeat.o(111461);
        }
      };
      Object localObject2 = this.idList;
      int n = this.type;
      localt.HIu = false;
      LinkedList localLinkedList = new LinkedList();
      Object localObject1 = localObject2;
      if (Util.isNullOrNil((List)localObject2))
      {
        Log.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id list now.");
        Log.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id, type: %d.", new Object[] { Integer.valueOf(n) });
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        switch (n)
        {
        default: 
          ((List)localObject2).add(Integer.valueOf(2));
        }
        for (;;)
        {
          localObject2 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSearchStorage().b(null, null, (List)localObject2);
          if (!Util.isNullOrNil((List)localObject2))
          {
            Log.i("MicroMsg.SmartGalleryQueryUtil", "fav list contains img or video.");
            ((List)localObject1).addAll((Collection)localObject2);
          }
          if (!Util.isNullOrNil((List)localObject1)) {
            break;
          }
          Log.i("MicroMsg.SmartGalleryQueryUtil", "fav list do not contain img or video.");
          local1.b(localLinkedList, -1L, true);
          AppMethodBeat.o(111462);
          return;
          ((List)localObject2).add(Integer.valueOf(2));
          continue;
          ((List)localObject2).add(Integer.valueOf(4));
          continue;
          ((List)localObject2).add(Integer.valueOf(21));
        }
      }
      int i1 = ((List)localObject1).size();
      Log.i("MicroMsg.SmartGalleryQueryUtil", "fav count: %d.", new Object[] { Integer.valueOf(i1) });
      int j = 0;
      int k = Math.min(i1, 100);
      int i = k + 0;
      boolean bool1 = true;
      boolean bool2;
      if (!localt.HIu)
      {
        Log.i("MicroMsg.SmartGalleryQueryUtil", "get fav, count: %d.", new Object[] { Integer.valueOf(k) });
        localLinkedList.addAll(com.tencent.mm.plugin.gallery.model.t.O(((List)localObject1).subList(j, i), n));
        local1.b(localLinkedList, -1L, bool1);
        bool2 = bool1;
        if (bool1) {
          bool2 = false;
        }
        int m = i1 - localLinkedList.size();
        if (m <= 0) {
          break label442;
        }
        k = Math.min(m, 100);
        m = i + k;
        j = i;
        i = m;
      }
      label442:
      for (;;)
      {
        if (i >= i1)
        {
          AppMethodBeat.o(111462);
          return;
        }
        bool1 = bool2;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
 * JD-Core Version:    0.7.0.1
 */