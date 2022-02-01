package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
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
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.y;
import com.tencent.mm.api.y.b;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.PrivateAlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c.c;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.i.b;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.p.a;
import com.tencent.mm.plugin.gallery.model.p.c;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.plugin.gallery.model.s.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout.a;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.AlbumChooserView.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
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
  implements i.c
{
  static long start = 0L;
  protected String dyU;
  private int fKU;
  private ProgressDialog fMu;
  private int iVz;
  private List<Long> idList;
  private boolean jpZ;
  protected int juP;
  private double latitude;
  private double longitude;
  private int npa;
  public boolean oTl;
  private boolean pyi;
  protected int sUI;
  protected RecyclerView tLL;
  private TextView tLM;
  private boolean tLN;
  private boolean tLO;
  protected a tLP;
  private TextView tLQ;
  private TextView tLR;
  private TextView tLS;
  private ImageFolderMgrView tLT;
  private TextView tLU;
  private ImageButton tLV;
  private String tLW;
  private String tLX;
  private String tLY;
  private boolean tLZ;
  protected String tLq;
  private a.f tLv;
  private HashMap<String, Integer> tMA;
  private HashSet<String> tMB;
  boolean tMC;
  private p.c tMD;
  private int tME;
  private String tMF;
  private boolean tMa;
  private boolean tMb;
  private boolean tMc;
  private boolean tMd;
  private boolean tMe;
  private boolean tMf;
  private boolean tMg;
  boolean tMh;
  private int tMi;
  private int tMj;
  private long tMk;
  private long tMl;
  private int tMm;
  protected int tMn;
  private String tMo;
  private i.b tMp;
  private boolean tMq;
  protected int tMr;
  protected int tMs;
  private boolean tMt;
  private e tMu;
  private volatile long tMv;
  protected MenuItem.OnMenuItemClickListener tMw;
  private GalleryItem.AlbumItem tMx;
  private a.d tMy;
  private volatile AlbumPreviewUI.b tMz;
  protected String toUser;
  
  public AlbumPreviewUI()
  {
    AppMethodBeat.i(111463);
    this.tMa = false;
    this.oTl = false;
    this.tMf = false;
    this.tMg = false;
    this.tMh = false;
    this.tMi = 0;
    this.tMj = 0;
    this.tMk = 0L;
    this.tMm = -1;
    this.pyi = true;
    this.idList = new ArrayList();
    this.iVz = 3;
    this.tMv = -1L;
    this.tMw = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(164796);
        int i = paramAnonymousMenuItem.getItemId();
        ad.d("MicroMsg.AlbumPreviewUI", "mId: %d.", new Object[] { Integer.valueOf(i) });
        if (1 == i)
        {
          ad.i("MicroMsg.AlbumPreviewUI", "go smart gallery.");
          a.a.tFA.tFn = 1;
          s.cVx().dZ(AlbumPreviewUI.this.tLP.tLo);
          paramAnonymousMenuItem = new Intent(AlbumPreviewUI.this, SmartGalleryUI.class);
          paramAnonymousMenuItem.putExtra("select_type_tag", 2);
          paramAnonymousMenuItem.putExtras(AlbumPreviewUI.this.getIntent());
          paramAnonymousMenuItem.putExtra("send_raw_img", AlbumPreviewUI.this.oTl);
          AlbumPreviewUI.this.startActivityForResult(paramAnonymousMenuItem, 4382);
          AppMethodBeat.o(164796);
          return true;
        }
        boolean bool = AlbumPreviewUI.this.cJu();
        AppMethodBeat.o(164796);
        return bool;
      }
    };
    this.tMA = new HashMap();
    this.tLv = new a.f()
    {
      public final void a(int paramAnonymousInt1, View paramAnonymousView, int paramAnonymousInt2)
      {
        AppMethodBeat.i(179458);
        switch (paramAnonymousInt2)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(179458);
          return;
          AlbumPreviewUI.D(AlbumPreviewUI.this);
          AppMethodBeat.o(179458);
          return;
          AlbumPreviewUI.this.f(paramAnonymousInt1, paramAnonymousView);
        }
      }
    };
    this.tMD = p.c.tHv;
    this.tME = -1;
    this.npa = -1;
    this.jpZ = false;
    this.tMF = "";
    AppMethodBeat.o(111463);
  }
  
  private static int[] ad(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111471);
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = paramArrayList.size();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)paramArrayList.next();
      if (localMediaItem != null) {
        if ((!bt.isNullOrNil(localMediaItem.mMimeType)) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
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
  
  private void akX(String paramString)
  {
    AppMethodBeat.i(173773);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
      AppMethodBeat.o(173773);
      return;
    }
    com.tencent.mm.plugin.gallery.model.e.cUN().al(new AlbumPreviewUI.d(paramString, this.tLP, this.fMu, this.tLL));
    AppMethodBeat.o(173773);
  }
  
  private void b(GalleryItem.AlbumItem paramAlbumItem)
  {
    AppMethodBeat.i(111472);
    if (paramAlbumItem == null)
    {
      AppMethodBeat.o(111472);
      return;
    }
    if (paramAlbumItem.Odo) {}
    for (this.iVz = 3; bt.bI(this.tLX, "").equals(paramAlbumItem.tGK); this.iVz = 4)
    {
      ad.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
      AppMethodBeat.o(111472);
      return;
    }
    com.tencent.mm.plugin.gallery.model.e.cUR().addAll(this.tLP.tLo);
    ad.i("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[] { paramAlbumItem.tGK, paramAlbumItem.axA() });
    this.tLW = paramAlbumItem.axA();
    this.tLX = paramAlbumItem.tGK;
    if (bt.isNullOrNil(this.tLW))
    {
      ad.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
      this.tLW = this.tLX;
    }
    Object localObject1;
    Object localObject2;
    label221:
    int i;
    if (!bt.isNullOrNil(this.tLX))
    {
      localObject1 = this.tLP;
      localObject2 = this.tMy;
      if (localObject2 == null)
      {
        ad.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
        localObject2 = paramAlbumItem.bVF;
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2))
        {
          if (this.tMs != 3) {
            break label428;
          }
          localObject1 = getString(2131759758);
        }
        updateActionBarOperationAreaTxt((String)localObject1);
        Ho(this.tLP.tLo.size());
        this.fMu.show();
        start = System.currentTimeMillis();
        localObject2 = this.tLX;
        i = this.tMs;
        localObject1 = localObject2;
        if (((String)localObject2).equals(getString(2131759759)))
        {
          localObject1 = "";
          i = 2;
        }
        if (!this.tLX.equalsIgnoreCase(getString(2131759764))) {
          break label458;
        }
        if (this.tMu != null) {
          this.tMu.tNh = false;
        }
        com.tencent.mm.plugin.gallery.model.e.cUN().am(this.tMu);
      }
    }
    for (;;)
    {
      localObject1 = "public";
      if ((paramAlbumItem instanceof GalleryItem.PrivateAlbumItem)) {
        localObject1 = "private";
      }
      try
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(18269, new Object[] { URLEncoder.encode((String)localObject1, "utf-8"), URLEncoder.encode(paramAlbumItem.bVF, "utf-8") });
        AppMethodBeat.o(111472);
        return;
      }
      catch (Exception paramAlbumItem)
      {
        AppMethodBeat.o(111472);
      }
      ((a)localObject1).tLr.remove(localObject2);
      break;
      if (!getIntent().getBooleanExtra("show_header_view", true)) {
        break;
      }
      this.tLP.a(this.tMy);
      break;
      label428:
      if (this.tMs == 1)
      {
        localObject1 = getString(2131759757);
        break label221;
      }
      localObject1 = getString(2131759759);
      break label221;
      label458:
      if ((paramAlbumItem instanceof GalleryItem.PrivateAlbumItem))
      {
        com.tencent.mm.plugin.gallery.model.e.cUM().cVu();
        this.tMv = System.currentTimeMillis();
        s.cVx().tHB = true;
        localObject1 = ((GalleryItem.PrivateAlbumItem)paramAlbumItem).tHb.tHF;
        if (bt.isNullOrNil((String)localObject1)) {
          ad.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
        } else {
          com.tencent.mm.plugin.gallery.model.e.cUN().am(new AlbumPreviewUI.d((String)localObject1, this.tLP, this.fMu, this.tLL));
        }
      }
      else
      {
        if (this.tMu != null) {
          this.tMu.tNh = true;
        }
        s.cVx().tHC = true;
        s.cVx().tHB = true;
        this.tMv = System.currentTimeMillis();
        com.tencent.mm.plugin.gallery.model.e.cUM().F((String)localObject1, i, this.tMv);
      }
    }
  }
  
  private void cVU()
  {
    AppMethodBeat.i(173771);
    Object localObject = com.tencent.mm.plugin.gallery.model.e.cUN();
    a locala = new a(this);
    localObject = ((com.tencent.mm.plugin.gallery.model.g)localObject).cVh();
    if (localObject != null)
    {
      ((ap)localObject).post(locala);
      AppMethodBeat.o(173771);
      return;
    }
    ad.w("MicroMsg.GalleryHandlerThread", "other handler is null.");
    AppMethodBeat.o(173771);
  }
  
  private void cVV()
  {
    AppMethodBeat.i(173772);
    if (this.tMq)
    {
      this.tLP.ea(s.cVx().tHD);
      com.tencent.mm.plugin.gallery.model.e.cUR().addAll(this.tLP.tLo);
      Ho(this.tLP.tLo.size());
      akX(getIntent().getStringExtra("album_id_from_smart_gallery"));
      this.fMu.show();
      AppMethodBeat.o(173772);
      return;
    }
    com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.hxg).ayV();
    if (getIntent().hasExtra("gallery_report_tag")) {
      a.a.tFA.setScene(getIntent().getIntExtra("gallery_report_tag", 3));
    }
    for (;;)
    {
      ad.i("MicroMsg.AlbumPreviewUI", "start queryMediaInAlbums %s", new Object[] { this });
      com.tencent.mm.plugin.gallery.model.e.cUM().a(this);
      this.tMv = System.currentTimeMillis();
      com.tencent.mm.plugin.gallery.model.e.cUM().ax(this.tLX, this.tMv);
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111422);
          ad.d("MicroMsg.AlbumPreviewUI", "onCreate, post delay, dialog show.");
          if (AlbumPreviewUI.b.tMQ != AlbumPreviewUI.a(AlbumPreviewUI.this)) {
            AlbumPreviewUI.b(AlbumPreviewUI.this).show();
          }
          AppMethodBeat.o(111422);
        }
      }, 300L);
      p.a locala = com.tencent.mm.plugin.gallery.model.p.tHs;
      com.tencent.mm.plugin.gallery.model.p.cVv().a(new l());
      locala = com.tencent.mm.plugin.gallery.model.p.tHs;
      com.tencent.mm.plugin.gallery.model.p.cVv().a(new com.tencent.mm.plugin.gallery.model.q());
      AppMethodBeat.o(173772);
      return;
      a.a.tFA.setScene(this.tMr);
    }
  }
  
  private void cVW()
  {
    AppMethodBeat.i(111476);
    if (!com.tencent.mm.pluginsdk.ui.tools.q.d(getContext(), com.tencent.mm.loader.j.b.asg(), "microMsg." + System.currentTimeMillis() + ".jpg", 4369))
    {
      Toast.makeText(getContext(), getString(2131763022), 1).show();
      AppMethodBeat.o(111476);
      return;
    }
    System.gc();
    AppMethodBeat.o(111476);
  }
  
  private void cVX()
  {
    AppMethodBeat.i(198776);
    if (this.tMB == null)
    {
      this.tMB = new HashSet();
      this.tMB.add(".h264");
      this.tMB.add(".h26l");
      this.tMB.add(".264");
      this.tMB.add(".avc");
      this.tMB.add(".mov");
      this.tMB.add(".mp4");
      this.tMB.add(".m4a");
      this.tMB.add(".3gp");
      this.tMB.add(".3g2");
      this.tMB.add(".mj2");
      this.tMB.add(".m4v");
    }
    AppMethodBeat.o(198776);
  }
  
  private void cVY()
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
      ad.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", new Object[] { localIntent });
      startActivityForResult(localIntent, 4371);
      AppMethodBeat.o(111485);
      return;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.AlbumPreviewUI", localException.toString());
      if ((!com.tencent.mm.s.a.n(getContext(), true)) && (!com.tencent.mm.s.a.cd(getContext())) && (!com.tencent.mm.s.a.ch(getContext()))) {
        com.tencent.mm.compatible.h.b.w(getContext());
      }
      AppMethodBeat.o(111485);
    }
  }
  
  private static void eb(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111480);
    long l = System.currentTimeMillis();
    ad.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (!com.tencent.mm.vfs.i.fv(localMediaItem.tGS))
      {
        ad.w("MicroMsg.AlbumPreviewUI", "filter non exist media: %s.", new Object[] { localMediaItem.tGS });
        ((LinkedList)localObject).add(localMediaItem);
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.remove((GalleryItem.MediaItem)((Iterator)localObject).next());
    }
    ad.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia cost: %s.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(111480);
  }
  
  protected final void Ho(int paramInt)
  {
    AppMethodBeat.i(111479);
    label37:
    int i;
    int j;
    String str;
    if (paramInt == 0)
    {
      this.tLM.setEnabled(false);
      enableOptionMenu(false);
      if (paramInt != 0) {
        break label102;
      }
      this.tLM.setText(2131759784);
      i = this.tMr;
      j = this.sUI;
      str = this.tLq;
      if (this.tLP != null) {
        break label148;
      }
    }
    label148:
    for (ArrayList localArrayList = null;; localArrayList = this.tLP.tLo)
    {
      updateOptionMenuText(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, paramInt, j, str, localArrayList));
      AppMethodBeat.o(111479);
      return;
      this.tLM.setEnabled(true);
      enableOptionMenu(true);
      break;
      label102:
      this.tLM.setText(getString(2131759784) + "(" + paramInt + ")");
      break label37;
    }
  }
  
  protected boolean a(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(198775);
    if (paramMediaItem == null)
    {
      ad.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
      AppMethodBeat.o(198775);
      return false;
    }
    int i;
    if (this.tMr == 3) {
      if ((paramMediaItem instanceof GalleryItem.VideoMediaItem)) {
        if (("video/hevc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).imP)) && (com.tencent.mm.plugin.o.f.dmo())) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if ((bp(paramMediaItem.tGS, true)) || (i == 0) || ((!bt.isNullOrNil(((GalleryItem.VideoMediaItem)paramMediaItem).imQ)) && (!"audio/mp4a-latm".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).imQ)))) {}
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label161;
        }
        com.tencent.mm.ui.base.h.ck(this, getString(2131759790));
        AppMethodBeat.o(198775);
        return false;
        if (!"video/avc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).imP)) {
          break label279;
        }
        i = 1;
        break;
      }
      label161:
      if ((this.tMr == 3) || (this.tMr == 4) || (this.tMr == 14) || (this.tMr == 22))
      {
        if (!new com.tencent.mm.vfs.e(paramMediaItem.tGS).exists())
        {
          com.tencent.mm.ui.base.h.ck(this, getString(2131759808));
          AppMethodBeat.o(198775);
          return false;
        }
        if (com.tencent.mm.plugin.gallery.a.d.alg(paramMediaItem.tGS) > 300)
        {
          com.tencent.mm.ui.base.h.ck(this, getString(2131759810));
          AppMethodBeat.o(198775);
          return false;
        }
        AppMethodBeat.o(198775);
        return true;
      }
      AppMethodBeat.o(198775);
      return true;
      label279:
      i = 0;
    }
  }
  
  protected void akW(String paramString) {}
  
  public final void an(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111473);
    switch (this.tMs)
    {
    }
    Object localObject;
    do
    {
      do
      {
        AppMethodBeat.o(111473);
        return;
      } while ((bt.isNullOrNil(this.dyU)) || ("medianote".equals(this.toUser)));
      if (bt.HI() - this.tMk < 1000L)
      {
        ad.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111473);
        return;
      }
      ad.i("MicroMsg.AlbumPreviewUI", "notifyMM switch to SendImgProxyUI");
      localObject = (GalleryItem.MediaItem)this.tLP.tLn.get(paramInt);
    } while (((GalleryItem.MediaItem)localObject).getType() == 2);
    for (;;)
    {
      try
      {
        localObject = ((GalleryItem.MediaItem)localObject).tGS;
        String str = this.toUser;
        if (!this.tMa) {
          if (!this.oTl)
          {
            break label177;
            com.tencent.mm.plugin.gallery.a.d.c((String)localObject, str, bool, paramBoolean);
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
      label177:
      boolean bool = true;
    }
  }
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(111481);
    if (paramLong != this.tMv)
    {
      ad.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.tMv) });
      ad.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(111481);
      return;
    }
    ad.d("MicroMsg.AlbumPreviewUI", "onQueryMediaFinished: %s %s %s.", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.tLP.tLn.size()), Integer.valueOf(paramLinkedList.size()) });
    if ((paramBoolean) || (this.tLP.tLn.size() > paramLinkedList.size()))
    {
      eb(paramLinkedList);
      paramLinkedList = new LinkedList(paramLinkedList);
      if (this.tLP != null) {
        break label338;
      }
    }
    label338:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AlbumPreviewUI", "[onQueryMediaFinished] adapter is null?:%s %s", new Object[] { Boolean.valueOf(bool), bt.flS().toString() });
      if (this.tLP != null)
      {
        c localc = new c((byte)0);
        localc.tMS = new WeakReference(this.tLP);
        localc.tMT = new WeakReference(this.fMu);
        localc.tMU = new WeakReference(this.tLR);
        localc.tMV = new WeakReference(this.tLL);
        localc.tMW = paramLinkedList;
        localc.tMo = this.tMo;
        localc.tMY = paramBoolean;
        if (AlbumPreviewUI.b.tMP == this.tMz) {
          this.tMz = AlbumPreviewUI.b.tMQ;
        }
        com.tencent.mm.plugin.gallery.model.e.cUN().f(localc);
      }
      AppMethodBeat.o(111481);
      return;
      eb(paramLinkedList.subList(this.tLP.tLn.size(), paramLinkedList.size()));
      break;
    }
  }
  
  public final boolean bp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(198777);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(198777);
      return true;
    }
    cVX();
    paramString = paramString.trim();
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length()))
    {
      AppMethodBeat.o(198777);
      return true;
    }
    if ((paramBoolean) && (r.GW(paramString)))
    {
      AppMethodBeat.o(198777);
      return true;
    }
    if (!this.tMB.contains(paramString.substring(i).toLowerCase()))
    {
      AppMethodBeat.o(198777);
      return true;
    }
    AppMethodBeat.o(198777);
    return false;
  }
  
  protected boolean cJu()
  {
    int j = 0;
    AppMethodBeat.i(111475);
    ad.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.cUT()), Boolean.valueOf(this.tMa) });
    if (this.tMa) {}
    for (int i = 3;; i = 2)
    {
      com.tencent.mm.plugin.gallery.a.d.bl(11610, i + "," + com.tencent.mm.plugin.gallery.model.e.cUT());
      if (this.tMm < 0) {
        this.tMm = com.tencent.mm.plugin.gallery.a.d.ach();
      }
      com.tencent.mm.plugin.gallery.model.e.cUS();
      if (this.tLP.cVN().size() != 0) {
        break;
      }
      ad.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
      setResult(-2);
      finish();
      AppMethodBeat.o(111475);
      return true;
    }
    Object localObject1 = new Intent();
    i = this.tMs;
    if (this.tMf) {
      i = 1;
    }
    Object localObject5;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    GalleryItem.MediaItem localMediaItem;
    boolean bool;
    if (22 == com.tencent.mm.plugin.gallery.model.e.cUM().kTx)
    {
      localObject5 = this.tLP.tLo;
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      localObject4 = new int[this.sUI];
      localObject5 = ((ArrayList)localObject5).iterator();
      i = j;
      while (((Iterator)localObject5).hasNext())
      {
        localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
        if (localMediaItem.getType() == 1)
        {
          if ((localMediaItem.mMimeType.equals("edit")) && (!bt.isNullOrNil(localMediaItem.tGU))) {
            ((ArrayList)localObject2).add(localMediaItem.tGU);
          }
          for (;;)
          {
            localObject4[i] = 1;
            i += 1;
            break;
            ((ArrayList)localObject2).add(localMediaItem.tGS);
          }
        }
        if (localMediaItem.getType() == 2)
        {
          ((ArrayList)localObject3).add(localMediaItem.tGS);
          localObject4[i] = 2;
          i += 1;
        }
      }
      bool = com.tencent.mm.plugin.gallery.a.d.cWv();
      if ((com.tencent.mm.plugin.recordvideo.activity.a.b.o((List)localObject2, (List)localObject3) == 4) && (bool))
      {
        localObject1 = VLogPreloadUI.tQs;
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
    if (i == 1)
    {
      if ((this.tMa) || (!this.oTl))
      {
        bool = true;
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
        localObject3 = this.tLP.tLo;
        localObject2 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label563;
        }
        localObject4 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
        if ((((GalleryItem.MediaItem)localObject4).mMimeType.equals("edit")) && (!bt.isNullOrNil(((GalleryItem.MediaItem)localObject4).tGU)))
        {
          ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).tGU);
          continue;
          bool = false;
          break;
        }
        ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).tGS);
      }
      label563:
      ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
      ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.tMl);
      this.tMl = 0L;
      setResult(-1, (Intent)localObject1);
      if ((!bt.isNullOrNil(this.tLq)) && (this.tLq.equals("album_business_bubble_media_by_coordinate"))) {
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
      }
      if (bt.HI() - this.tMk < 1000L)
      {
        ad.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111475);
        return true;
      }
      ad.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE switch to SendImgProxyUI");
      this.tMk = bt.HI();
      if ((!bt.isNullOrNil(this.dyU)) && (!"medianote".equals(this.toUser)))
      {
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
        ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dyU);
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
      ad.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
      if (getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false)) {}
      for (i = 0;; i = ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).bgi())
      {
        if (i != 0) {
          break label899;
        }
        ((Intent)localObject1).setData(n.a(getContext(), new com.tencent.mm.vfs.e((String)this.tLP.cVN().get(0))));
        ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", this.tLP.cVN());
        setResult(-1, (Intent)localObject1);
        finish();
        break;
        localObject2 = com.tencent.mm.plugin.gallery.ui.a.a.ale((String)this.tLP.cVN().get(0));
        ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).mSize = this.tMm;
      }
      label899:
      if (i == 2)
      {
        com.tencent.mm.ui.base.h.l(this, 2131764674, 2131759817);
        ad.w("MicroMsg.AlbumPreviewUI", "video is import error");
        AppMethodBeat.o(111475);
        return true;
      }
      com.tencent.mm.ui.base.h.l(this, 2131759816, 2131759817);
      ad.w("MicroMsg.AlbumPreviewUI", "video is over size");
      AppMethodBeat.o(111475);
      return true;
    }
    if (i == 3)
    {
      if ((!bt.isNullOrNil(this.tLq)) && (this.tLq.equals("album_business_bubble_media_by_coordinate")))
      {
        localObject4 = this.tLP.tLo;
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (GalleryItem.MediaItem)((Iterator)localObject4).next();
          if (((GalleryItem.MediaItem)localObject5).getType() == 1)
          {
            if ((((GalleryItem.MediaItem)localObject5).mMimeType.equals("edit")) && (!bt.isNullOrNil(((GalleryItem.MediaItem)localObject5).tGU))) {
              ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).tGU);
            } else {
              ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).tGS);
            }
          }
          else if (((GalleryItem.MediaItem)localObject5).getType() == 2) {
            ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject5).tGS);
          }
        }
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
        ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.tMl);
        ((Intent)localObject1).putExtra("longitude", this.longitude);
        ((Intent)localObject1).putExtra("latitude", this.latitude);
        this.tMl = 0L;
        setResult(-1, (Intent)localObject1);
        finish();
        AppMethodBeat.o(111475);
        return true;
      }
      if (bt.HI() - this.tMk < 1000L)
      {
        ad.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111475);
        return true;
      }
      this.tMk = bt.HI();
      localObject5 = this.tLP.tLo;
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      localObject4 = new int[this.sUI];
      localObject5 = ((ArrayList)localObject5).iterator();
      i = 0;
      label1308:
      if (((Iterator)localObject5).hasNext())
      {
        localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
        if (localMediaItem.getType() == 1)
        {
          if ((localMediaItem.mMimeType.equals("edit")) && (!bt.isNullOrNil(localMediaItem.tGU))) {
            ((ArrayList)localObject3).add(localMediaItem.tGU);
          }
          for (;;)
          {
            localObject4[i] = 1;
            i += 1;
            break;
            ((ArrayList)localObject3).add(localMediaItem.tGS);
          }
        }
        if (localMediaItem.getType() != 2) {
          break label1862;
        }
        ((ArrayList)localObject2).add(localMediaItem.tGS);
        j = i + 1;
        localObject4[i] = 2;
        i = j;
      }
    }
    label1727:
    label1862:
    for (;;)
    {
      break label1308;
      if ((this.tMa) || (!this.oTl)) {}
      for (bool = true;; bool = false)
      {
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
        ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.tMl);
        if (!this.tMa) {
          break label1727;
        }
        if (((ArrayList)localObject2).size() != 0) {
          break;
        }
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.tMl);
        this.tMl = 0L;
        setResult(-1, (Intent)localObject1);
        finish();
        AppMethodBeat.o(111475);
        return true;
      }
      if (com.tencent.mm.plugin.recordvideo.activity.a.b.o((List)localObject3, (List)localObject2) == 4)
      {
        localObject1 = VLogPreloadUI.tQs;
        VLogPreloadUI.a.a(this, (ArrayList)localObject2, (ArrayList)localObject3, (int[])localObject4);
      }
      for (;;)
      {
        AppMethodBeat.o(111475);
        return true;
        localObject1 = RecordConfigProvider.as((String)((ArrayList)localObject2).get(0), "", "");
        ((RecordConfigProvider)localObject1).xyt = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
        ((RecordConfigProvider)localObject1).scene = 2;
        localObject2 = new VideoCaptureReportInfo();
        ((VideoCaptureReportInfo)localObject2).rgD = 1;
        ((RecordConfigProvider)localObject1).xyB = ((VideoCaptureReportInfo)localObject2);
        localObject2 = new UICustomParam.a();
        ((UICustomParam.a)localObject2).aby();
        ((UICustomParam.a)localObject2).abx();
        ((UICustomParam.a)localObject2).cP(true);
        ((RecordConfigProvider)localObject1).xyk = ((UICustomParam.a)localObject2).gei;
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772137, -1, (RecordConfigProvider)localObject1, 2, 0);
      }
      this.tMl = 0L;
      if (((ArrayList)localObject3).size() > 0)
      {
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
        ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dyU);
        ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject1).putExtra("CropImage_limit_Img_Size", 26214400);
        ad.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE_AND_VIDEO switch to SendImgProxyUI");
        startActivityForResult((Intent)localObject1, 4373);
        break;
      }
      ad.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
      setResult(-1, (Intent)localObject1);
      finish();
      break;
      ad.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
      setResult(-2);
      finish();
      break;
    }
  }
  
  protected void f(final int paramInt, View paramView)
  {
    AppMethodBeat.i(164801);
    Object localObject1 = this.tLP.Hm(paramInt);
    boolean bool1;
    if ((localObject1 == null) || (bt.isNullOrNil(((GalleryItem.MediaItem)localObject1).tGS)))
    {
      if (localObject1 == null) {}
      for (bool1 = true;; bool1 = false)
      {
        ad.w("MicroMsg.AlbumPreviewUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(164801);
        return;
      }
    }
    if ((com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 5) && (((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")))
    {
      com.tencent.mm.ui.base.h.cl(getContext(), getString(2131759804));
      AppMethodBeat.o(164801);
      return;
    }
    if (1 == this.tMs)
    {
      if (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("video"))
      {
        com.tencent.mm.ui.base.h.cl(getContext(), getString(2131759806));
        AppMethodBeat.o(164801);
      }
    }
    else if ((2 == this.tMs) && (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("image")))
    {
      com.tencent.mm.ui.base.h.cl(getContext(), getString(2131759805));
      AppMethodBeat.o(164801);
      return;
    }
    int i = paramInt - this.tLP.tLr.size();
    ad.d("MicroMsg.AlbumPreviewUI", "onMediaClick, querySource %s item %s.", new Object[] { Integer.valueOf(this.tMr), localObject1 });
    if ((this.tMr == 0) || (this.tMr == 5) || (this.tMr == 10) || (this.tMr == 11))
    {
      if (this.tMs == 2)
      {
        com.tencent.mm.ui.base.h.a(this, true, getString(2131759818), "", getString(2131755884), getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(179459);
            ad.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.setData(Uri.parse("file://" + Uri.encode(this.tMK.tGS)));
            AlbumPreviewUI.this.setResult(-1, paramAnonymousDialogInterface);
            a.a.tFA.ai(this.tMK.tGS, AlbumPreviewUI.k(AlbumPreviewUI.this), paramInt);
            AlbumPreviewUI.this.finish();
            AppMethodBeat.o(179459);
          }
        }, null);
        AppMethodBeat.o(164801);
        return;
      }
      paramView = new Intent();
      if (((GalleryItem.MediaItem)localObject1).getType() == 2)
      {
        paramView.putExtra("is_video", true);
        paramView.putExtra("video_full_path", ((GalleryItem.MediaItem)localObject1).tGS);
      }
      if (this.tMr == 10) {
        paramView.putExtra("CropImage_OutputPath", ((GalleryItem.MediaItem)localObject1).tGS);
      }
      paramView.setData(Uri.parse(Uri.encode(((GalleryItem.MediaItem)localObject1).tGS)));
      ad.i("MicroMsg.AlbumPreviewUI", "getItem ok");
      setResult(-1, paramView);
      a.a.tFA.ai(((GalleryItem.MediaItem)localObject1).tGS, this.iVz, paramInt);
      finish();
      AppMethodBeat.o(164801);
      return;
    }
    boolean bool2;
    if (this.tMr == 4)
    {
      bool2 = com.tencent.mm.plugin.gallery.a.d.cWu();
      if ((!bool2) && (((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.tLP.tLo.size() != 0))
      {
        com.tencent.mm.ui.base.h.cl(getContext(), com.tencent.mm.cc.a.az(getContext(), 2131759774));
        AppMethodBeat.o(164801);
        return;
      }
      if ((bool2) && (com.tencent.mm.plugin.gallery.a.d.af(this.tLP.tLo)))
      {
        bool1 = true;
        ad.i("MicroMsg.AlbumPreviewUI", "enableSnsVLog:%s skipEditVideo:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((((GalleryItem.MediaItem)localObject1).getType() != 2) || (bool1)) {
          break label1004;
        }
        paramView = getString(2131759795);
        if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
          break label853;
        }
        if ((!"video/hevc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).imP)) || (!com.tencent.mm.plugin.o.f.dmo())) {
          break label752;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((bp(((GalleryItem.MediaItem)localObject1).tGS, true)) || (i == 0) || ((!bt.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).imQ)) && (!"audio/mp4a-latm".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).imQ))))
      {
        paramView = new f.a(getContext());
        paramView.av(com.tencent.mm.cc.a.az(getContext(), 2131759790));
        paramView.aXS(com.tencent.mm.cc.a.az(getContext(), 2131759769));
        paramView.b(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
        });
        paramView.show();
        AppMethodBeat.o(164801);
        return;
        bool1 = false;
        break;
        label752:
        if (!"video/avc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).imP)) {
          break label2601;
        }
        i = 1;
        continue;
      }
      if (((GalleryItem.VideoMediaItem)localObject1).imR >= 300000L)
      {
        localObject1 = new f.a(getContext());
        ((f.a)localObject1).av(paramView);
        ((f.a)localObject1).aXS(com.tencent.mm.cc.a.az(getContext(), 2131759769));
        ((f.a)localObject1).b(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
        });
        ((f.a)localObject1).show();
        AppMethodBeat.o(164801);
        return;
      }
      label853:
      paramView = RecordConfigProvider.as(((GalleryItem.MediaItem)localObject1).tGS, "", "");
      paramView.xyt = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
      paramView.scene = 2;
      Object localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).rgD = 1;
      paramView.xyB = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).aby();
      ((UICustomParam.a)localObject2).abx();
      ((UICustomParam.a)localObject2).cP(true);
      paramView.xyk = ((UICustomParam.a)localObject2).gei;
      a.a.tFA.ai(((GalleryItem.MediaItem)localObject1).tGS, this.iVz, paramInt);
      this.tMF = ((GalleryItem.MediaItem)localObject1).tGS;
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772137, -1, paramView, 2, 0);
      AppMethodBeat.o(164801);
      return;
      label1004:
      ad.d("leextime", "jump from sns : " + bt.HI());
      if (bool2) {}
      for (paramView = this.tLP.tLn;; paramView = this.tLP.Hl(((GalleryItem.MediaItem)localObject1).getType()))
      {
        com.tencent.mm.plugin.gallery.model.e.aa(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.tLP.cVN());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.tLP.tLo);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        an(i, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.oTl);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.tMb);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.tMd);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.tMe);
        ((Intent)localObject2).putExtra("max_select_count", this.sUI);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dyU);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.iVz);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
        return;
      }
      if (this.tMr == 14)
      {
        if ((((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.tLP.tLo.size() != 0))
        {
          com.tencent.mm.ui.base.h.cl(getContext(), com.tencent.mm.cc.a.az(getContext(), 2131759774));
          AppMethodBeat.o(164801);
          return;
        }
        if (((GalleryItem.MediaItem)localObject1).getType() == 1)
        {
          paramView = this.tLP.Hl(((GalleryItem.MediaItem)localObject1).getType());
          com.tencent.mm.plugin.gallery.model.e.aa(paramView);
          localObject2 = new Intent(this, ImagePreviewUI.class);
          ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
          ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
          ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.tLP.cVN());
          ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.tLP.tLo);
          ((Intent)localObject2).putExtra("preview_all", true);
          ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
          an(i, true);
          ((Intent)localObject2).putExtra("send_raw_img", this.oTl);
          ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.tMb);
          ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.tMd);
          ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.tMe);
          ((Intent)localObject2).putExtra("max_select_count", this.sUI);
          ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dyU);
          ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject2).putExtra("select_type_tag", this.iVz);
          startActivityForResult((Intent)localObject2, 0);
          AppMethodBeat.o(164801);
          return;
        }
        if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
          break label2589;
        }
        paramView = (GalleryItem.VideoMediaItem)localObject1;
        if (paramView.imR <= 2000)
        {
          ad.i("MicroMsg.AlbumPreviewUI", "select story video, duration too long, duration:%s", new Object[] { Integer.valueOf(paramView.imR) });
          com.tencent.mm.plugin.report.service.g.yhR.n(1005L, 53L, 1L);
          com.tencent.mm.ui.base.h.cl(getContext(), com.tencent.mm.cc.a.az(getContext(), 2131759798));
          AppMethodBeat.o(164801);
          return;
        }
        if ((paramView.videoFrameRate <= 1) && (paramView.videoFrameRate >= 0))
        {
          ad.i("MicroMsg.AlbumPreviewUI", "select story video, videoFrameRate too small:%s, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.tGS });
          if (paramView.videoFrameRate > 1) {}
        }
      }
      try
      {
        localObject2 = SightVideoJNI.getSimpleMp4InfoVFS(paramView.tGS);
        if (!bt.isNullOrNil((String)localObject2))
        {
          double d = new JSONObject((String)localObject2).optDouble("videoFPS");
          ad.i("MicroMsg.AlbumPreviewUI", "update from getSimpleMp4Info videoFPS:%s", new Object[] { Double.valueOf(d) });
          if (d > 0.0D) {
            paramView.videoFrameRate = ((int)d);
          }
        }
      }
      catch (Exception localException)
      {
        label1814:
        break label1814;
      }
      if (paramView.videoFrameRate <= 0)
      {
        ad.i("MicroMsg.AlbumPreviewUI", "final videoFrameRate:%s, too small, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.tGS });
        com.tencent.mm.plugin.report.service.g.yhR.n(1005L, 54L, 1L);
        com.tencent.mm.ui.base.h.cl(getContext(), com.tencent.mm.cc.a.az(getContext(), 2131759790));
        AppMethodBeat.o(164801);
        return;
      }
      ad.i("MicroMsg.AlbumPreviewUI", "maxDuration=%s", new Object[] { Long.valueOf(getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000 + 500) });
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("K_SEGMENTVIDEOPATH", paramView.tGS);
      ((Intent)localObject2).putExtra("KSEGMENTVIDEOTHUMBPATH", paramView.rmz);
      setResult(-1, (Intent)localObject2);
      a.a.tFA.ai(((GalleryItem.MediaItem)localObject1).tGS, this.iVz, paramInt);
      finish();
      AppMethodBeat.o(164801);
      return;
      if (this.tMf)
      {
        if ((((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.tLP.tLo.size() != 0))
        {
          com.tencent.mm.ui.base.h.cl(getContext(), com.tencent.mm.cc.a.az(getContext(), 2131759774));
          AppMethodBeat.o(164801);
          return;
        }
        if ((this.tMr == 15) && (((GalleryItem.MediaItem)localObject1).getType() == 2))
        {
          akW(((GalleryItem.MediaItem)localObject1).tGS);
          AppMethodBeat.o(164801);
          return;
        }
        paramView = this.tLP.Hl(((GalleryItem.MediaItem)localObject1).getType());
        com.tencent.mm.plugin.gallery.model.e.aa(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.tLP.cVN());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.tLP.tLo);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        an(i, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.oTl);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.tMb);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.tMd);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.tMe);
        if (((GalleryItem.MediaItem)localObject1).getType() == 2) {}
        for (paramInt = 1;; paramInt = this.sUI)
        {
          ((Intent)localObject2).putExtra("max_select_count", paramInt);
          ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dyU);
          ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject2).putExtra("select_type_tag", this.iVz);
          ((Intent)localObject2).putExtra("album_business_tag", this.tLq);
          ((Intent)localObject2).putExtra("album_video_max_duration", this.juP);
          ((Intent)localObject2).putExtra("album_video_min_duration", this.tMn);
          startActivityForResult((Intent)localObject2, 0);
          AppMethodBeat.o(164801);
          return;
        }
      }
      com.tencent.mm.plugin.gallery.model.e.aa(this.tLP.tLn);
      paramView = new Intent(this, ImagePreviewUI.class);
      paramView.putStringArrayListExtra("preview_image_list", this.tLP.cVN());
      paramView.putParcelableArrayListExtra("preview_media_item_list", this.tLP.tLo);
      paramView.putExtra("preview_all", true);
      paramView.putExtra("preview_position", i);
      an(i, true);
      paramView.putExtra("send_raw_img", this.oTl);
      paramView.putExtra("key_force_hide_edit_image_button", this.tMb);
      paramView.putExtra("key_force_show_raw_image_button", this.tMd);
      paramView.putExtra("key_is_raw_image_button_disable", this.tMe);
      paramView.putExtra("max_select_count", this.sUI);
      paramView.putExtra("GalleryUI_FromUser", this.dyU);
      paramView.putExtra("GalleryUI_ToUser", this.toUser);
      paramView.putExtra("album_business_tag", this.tLq);
      paramView.putExtra("album_video_max_duration", this.juP);
      paramView.putExtra("album_video_min_duration", this.tMn);
      if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 14) {
        paramView.putExtra("key_edit_video_max_time_length", 300500);
      }
      paramView.putExtra("select_type_tag", this.iVz);
      startActivityForResult(paramView, 0);
      label2589:
      AppMethodBeat.o(164801);
      return;
      label2601:
      i = 0;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(111484);
    getIntent().putExtra("MMActivity.OverrideExitAnimation", 2130772106);
    getIntent().putExtra("MMActivity.OverrideEnterAnimation", 2130771986);
    super.finish();
    overridePendingTransition(2130771986, 2130772106);
    AppMethodBeat.o(111484);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495309;
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
        ad.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", new Object[] { str, ((Bundle)localObject1).get(str) });
      }
    }
    ad.e("MicroMsg.AlbumPreviewUI", "initView, oops! no extras data!");
    this.tLq = getIntent().getStringExtra("album_business_tag");
    this.juP = getIntent().getIntExtra("album_video_max_duration", 10);
    this.tMn = getIntent().getIntExtra("album_video_min_duration", 0);
    this.dyU = getIntent().getStringExtra("GalleryUI_FromUser");
    this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
    this.sUI = getIntent().getIntExtra("max_select_count", 9);
    boolean bool;
    if (this.tMr == 4)
    {
      bool = true;
      this.tMa = bool;
      this.tLW = getIntent().getStringExtra("folder_path");
      this.tLX = getIntent().getStringExtra("folder_name");
      if (bt.isNullOrNil(this.tLW))
      {
        ad.w("MicroMsg.AlbumPreviewUI", "folder path invalid, assign folderName: %s.", new Object[] { this.tLX });
        this.tLW = this.tLX;
      }
      if ((!getIntent().getBooleanExtra("key_send_raw_image", false)) && (!getIntent().getBooleanExtra("send_raw_img", false))) {
        break label1738;
      }
      bool = true;
      label294:
      this.oTl = bool;
      this.tMb = getIntent().getBooleanExtra("key_force_hide_edit_image_button", false);
      this.tMc = getIntent().getBooleanExtra("key_force_hide_edit_image_button_after_album_take_image", false);
      this.tMd = getIntent().getBooleanExtra("key_force_show_raw_image_button", false);
      this.tMe = getIntent().getBooleanExtra("key_is_raw_image_button_disable", false);
      this.tMf = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
      this.tLU = ((TextView)findViewById(2131303091));
      this.tLV = ((ImageButton)findViewById(2131303090));
      this.tLU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111434);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          AlbumPreviewUI.c(AlbumPreviewUI.this).performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111434);
        }
      });
      if ((this.tMr != 3) && (!this.tMd)) {
        break label1744;
      }
      this.tLV.setVisibility(0);
      this.tLU.setVisibility(0);
      label449:
      if (!this.oTl) {
        break label1765;
      }
      this.tLV.setImageResource(2131691078);
      label466:
      if (this.tMe) {
        this.tLV.setImageResource(2131691075);
      }
      localObject1 = this.tLV;
      if (this.tMe) {
        break label1778;
      }
      bool = true;
      label499:
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.tLU;
      if (this.tMe) {
        break label1784;
      }
      bool = true;
      label522:
      ((TextView)localObject1).setEnabled(bool);
      this.tLV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111435);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = AlbumPreviewUI.this;
          boolean bool;
          if (!AlbumPreviewUI.this.oTl)
          {
            bool = true;
            paramAnonymousView.oTl = bool;
            AlbumPreviewUI.d(AlbumPreviewUI.this);
            AlbumPreviewUI.e(AlbumPreviewUI.this).setText(AlbumPreviewUI.this.getContext().getString(2131759782).concat(AlbumPreviewUI.cVZ()));
            if (!AlbumPreviewUI.this.oTl) {
              break label143;
            }
            AlbumPreviewUI.c(AlbumPreviewUI.this).setImageResource(2131691078);
          }
          for (;;)
          {
            AlbumPreviewUI.f(AlbumPreviewUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111435);
            return;
            bool = false;
            break;
            label143:
            AlbumPreviewUI.c(AlbumPreviewUI.this).setImageResource(2131691077);
          }
        }
      });
      this.tLL = ((RecyclerView)findViewById(2131302210));
      this.tLQ = ((TextView)findViewById(2131296624));
      this.tLR = ((TextView)findViewById(2131296625));
      this.tLS = ((TextView)findViewById(2131296597));
      this.tLM = ((TextView)findViewById(2131302218));
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDG, 0)) {
        break label1790;
      }
      bool = true;
      label639:
      ad.i("MicroMsg.AlbumPreviewUI", "pennqin, smartGallerySwitch: %s.", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label1796;
      }
      bool = false;
      label667:
      ad.i("MicroMsg.AlbumPreviewUI", "pennqin, isFromSmartGallery: %s showSmartGallery: %s.", new Object[] { Boolean.valueOf(this.tMq), Boolean.valueOf(bool) });
      if ((!this.tMq) && ((bool) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE)))
      {
        addTextOptionMenu(1, null, this.tMw, null, s.b.Jcf);
        if (this.tMt) {
          cVU();
        }
      }
      if ((this.tMr != 0) && (this.tMr != 5) && (this.tMr != 10) && (this.tMr != 11) && (this.tMr != 24)) {
        break label1892;
      }
      findViewById(2131296568).setVisibility(8);
      localObject1 = (FrameLayout.LayoutParams)this.tLL.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = 0;
      this.tLL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      label827:
      this.tLT = ((ImageFolderMgrView)findViewById(2131300928));
      this.tLT.setListener(new ImageFolderMgrView.a()
      {
        public final void c(GalleryItem.AlbumItem paramAnonymousAlbumItem)
        {
          AppMethodBeat.i(111437);
          AlbumPreviewUI.a(AlbumPreviewUI.this, paramAnonymousAlbumItem);
          AppMethodBeat.o(111437);
        }
      });
      this.tLT.setOnFolderStateChanged(new ImageFolderMgrView.b()
      {
        public final void mQ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(111438);
          if (paramAnonymousBoolean)
          {
            if (AlbumPreviewUI.l(AlbumPreviewUI.this))
            {
              AlbumPreviewUI.this.setSmartGalleryEntryVisibility(false);
              AppMethodBeat.o(111438);
            }
          }
          else
          {
            if ((AlbumPreviewUI.l(AlbumPreviewUI.this)) && (!AlbumPreviewUI.m(AlbumPreviewUI.this).getSelectedAlbumName().equalsIgnoreCase(AlbumPreviewUI.this.getString(2131759764)))) {
              AlbumPreviewUI.this.setSmartGalleryEntryVisibility(true);
            }
            if (AlbumPreviewUI.n(AlbumPreviewUI.this) != null)
            {
              if (!bt.bI(AlbumPreviewUI.o(AlbumPreviewUI.this), "").equals(AlbumPreviewUI.n(AlbumPreviewUI.this).tGK))
              {
                AlbumPreviewUI.b(AlbumPreviewUI.this, AlbumPreviewUI.n(AlbumPreviewUI.this));
                AppMethodBeat.o(111438);
                return;
              }
              AlbumPreviewUI.this.playActionBarOperationAreaAnim();
            }
          }
          AppMethodBeat.o(111438);
        }
      });
      localObject2 = this.tLT;
      bool = this.tMt;
      ad.i("MicroMsg.ImageFolderMgrView", "attach, %s.", new Object[] { localObject2 });
      com.tencent.mm.plugin.gallery.model.e.cUM().b((i.a)localObject2);
      com.tencent.mm.plugin.gallery.model.e.cUM().a((i.a)localObject2);
      com.tencent.mm.plugin.gallery.model.e.cUM().c(((ImageFolderMgrView)localObject2).tNT);
      localObject1 = com.tencent.mm.plugin.gallery.model.e.cUM();
      localObject2 = ((ImageFolderMgrView)localObject2).tNT;
      ((o)localObject1).tHg.add(localObject2);
      if (bool) {
        com.tencent.mm.plugin.gallery.model.e.cUM().cVt();
      }
      this.tLY = getIntent().getStringExtra("send_btn_string");
      this.tLZ = getIntent().getBooleanExtra("is_hide_album_footer", false);
      if (this.tLZ) {
        findViewById(2131296568).setVisibility(8);
      }
      enableOptionMenu(false);
      getContext();
      localObject1 = new GridLayoutManager(4);
      this.tLL.setLayoutManager((RecyclerView.i)localObject1);
      localObject2 = new c.a(getContext());
      ((c.a)localObject2).tNs = ((c.a)localObject2).mResources.getDimensionPixelSize(2131166400);
      ((c.a)localObject2).tNt = ((c.a)localObject2).mResources.getDimensionPixelSize(2131166400);
      ((c.a)localObject2).mColor = android.support.v4.content.b.n(((c.a)localObject2).mContext, 2131100399);
      ((c.a)localObject2).tNr = false;
      localObject2 = new c(((c.a)localObject2).tNs, ((c.a)localObject2).tNt, ((c.a)localObject2).mColor, ((c.a)localObject2).tNr, (byte)0);
      this.tLL.a((RecyclerView.h)localObject2);
      this.tLL.a(new RecyclerView.m()
      {
        private Runnable oTO;
        
        private String cWc()
        {
          AppMethodBeat.i(111442);
          String str = AlbumPreviewUI.this.tLP.Hn(this.tML.km());
          if ((!bt.isNullOrNil(str)) && (str.equals("album_business_bubble_media_by_coordinate")))
          {
            str = AlbumPreviewUI.q(AlbumPreviewUI.this) + "附近的照片和视频";
            AppMethodBeat.o(111442);
            return str;
          }
          AppMethodBeat.o(111442);
          return str;
        }
        
        private void mR(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(111443);
          if (paramAnonymousBoolean)
          {
            AlbumPreviewUI.p(AlbumPreviewUI.this).removeCallbacks(this.oTO);
            if (AlbumPreviewUI.p(AlbumPreviewUI.this).getVisibility() != 0)
            {
              String str = cWc();
              AlbumPreviewUI.p(AlbumPreviewUI.this).setText(str);
              AlbumPreviewUI.p(AlbumPreviewUI.this).setVisibility(0);
              AlbumPreviewUI.p(AlbumPreviewUI.this).setAlpha(0.0F);
              AlbumPreviewUI.p(AlbumPreviewUI.this).animate().alpha(1.0F).setDuration(300L).start();
              AppMethodBeat.o(111443);
            }
          }
          else
          {
            AlbumPreviewUI.p(AlbumPreviewUI.this).removeCallbacks(this.oTO);
            AlbumPreviewUI.p(AlbumPreviewUI.this).postDelayed(this.oTO, 256L);
          }
          AppMethodBeat.o(111443);
        }
        
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(111445);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousRecyclerView = cWc();
          AlbumPreviewUI.p(AlbumPreviewUI.this).setText(paramAnonymousRecyclerView);
          paramAnonymousInt1 = this.tML.km();
          int i = this.tML.ko();
          ad.d("MicroMsg.AlbumPreviewUI", "pennqin, onScrolled, %s %s %s %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(i), Integer.valueOf(AlbumPreviewUI.s(AlbumPreviewUI.this)), Integer.valueOf(AlbumPreviewUI.t(AlbumPreviewUI.this)) });
          if ((AlbumPreviewUI.s(AlbumPreviewUI.this) != paramAnonymousInt1) || (AlbumPreviewUI.t(AlbumPreviewUI.this) != i))
          {
            AlbumPreviewUI.a(AlbumPreviewUI.this, paramAnonymousInt1);
            AlbumPreviewUI.b(AlbumPreviewUI.this, i);
            paramAnonymousRecyclerView = new ArrayList();
            paramAnonymousInt1 = AlbumPreviewUI.s(AlbumPreviewUI.this);
            while (paramAnonymousInt1 <= AlbumPreviewUI.t(AlbumPreviewUI.this))
            {
              localObject = AlbumPreviewUI.this.tLP.Hm(paramAnonymousInt1);
              if (localObject != null) {
                paramAnonymousRecyclerView.add(com.tencent.mm.plugin.gallery.a.d.a(((GalleryItem.MediaItem)localObject).axA(), null, -1));
              }
              paramAnonymousInt1 += 1;
            }
            ad.d("MicroMsg.AlbumPreviewUI", "cancelTask, legalPaths size: %s.", new Object[] { Integer.valueOf(paramAnonymousRecyclerView.size()) });
            com.tencent.mm.plugin.gallery.model.e.cUL().dX(paramAnonymousRecyclerView);
            if (paramAnonymousInt2 != 0)
            {
              if (paramAnonymousInt2 >= 0) {
                break label381;
              }
              AlbumPreviewUI.a(AlbumPreviewUI.this, p.c.tHw);
            }
          }
          for (;;)
          {
            ad.d("MicroMsg.AlbumPreviewUI", "onScrolled, dy: %s state: %s.", new Object[] { Integer.valueOf(paramAnonymousInt2), AlbumPreviewUI.v(AlbumPreviewUI.this) });
            paramAnonymousRecyclerView = com.tencent.mm.plugin.gallery.model.p.tHs;
            com.tencent.mm.plugin.gallery.model.p.cVv().a(AlbumPreviewUI.v(AlbumPreviewUI.this), AlbumPreviewUI.s(AlbumPreviewUI.this), AlbumPreviewUI.t(AlbumPreviewUI.this), AlbumPreviewUI.this.tLP.tLn.size());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(111445);
            return;
            label381:
            AlbumPreviewUI.a(AlbumPreviewUI.this, p.c.tHx);
          }
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(111444);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mr(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
          ad.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (1 == paramAnonymousInt)
          {
            mR(true);
            AlbumPreviewUI.r(AlbumPreviewUI.this).setVisibility(8);
            com.tencent.mm.plugin.gallery.model.e.cUL().cUG();
          }
          do
          {
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
              AppMethodBeat.o(111444);
              return;
              if (paramAnonymousInt != 0) {
                break;
              }
              mR(false);
              AlbumPreviewUI.a(AlbumPreviewUI.this, this.tML.km());
              AlbumPreviewUI.b(AlbumPreviewUI.this, this.tML.ko());
              ad.d("MicroMsg.AlbumPreviewUI", "cancelTask logic, firstVisibleItem: %s lastVisibleItem: %s.", new Object[] { Integer.valueOf(AlbumPreviewUI.s(AlbumPreviewUI.this)), Integer.valueOf(AlbumPreviewUI.t(AlbumPreviewUI.this)) });
              paramAnonymousRecyclerView = com.tencent.mm.plugin.gallery.model.p.tHs;
              com.tencent.mm.plugin.gallery.model.p.cVv().a(p.c.tHv, AlbumPreviewUI.s(AlbumPreviewUI.this), AlbumPreviewUI.t(AlbumPreviewUI.this), AlbumPreviewUI.this.tLP.tLn.size());
            }
          } while (2 != paramAnonymousInt);
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, AlbumPreviewUI.u(AlbumPreviewUI.this));
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
      });
      this.tLP = new a(getContext(), new a.e()
      {
        public final void ac(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(111446);
          Object localObject = AlbumPreviewUI.this.tLP.Hm(paramAnonymousInt2);
          if (localObject == null)
          {
            AppMethodBeat.o(111446);
            return;
          }
          if (paramAnonymousInt3 == 0) {
            if (((GalleryItem.MediaItem)localObject).getType() == 1)
            {
              a.a.tFA.ai(((GalleryItem.MediaItem)localObject).tGS, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.a(AlbumPreviewUI.this, (GalleryItem.MediaItem)localObject);
              AlbumPreviewUI.this.Ho(paramAnonymousInt1);
              AlbumPreviewUI.this.an(paramAnonymousInt2, true);
            }
          }
          while (bt.hj(AlbumPreviewUI.this.tLP.cVN()))
          {
            AppMethodBeat.o(111446);
            return;
            if (((GalleryItem.MediaItem)localObject).getType() == 2)
            {
              if (!AlbumPreviewUI.this.a((GalleryItem.MediaItem)localObject))
              {
                AlbumPreviewUI.this.tLP.h((GalleryItem.MediaItem)localObject);
              }
              else
              {
                a.a.tFA.ai(((GalleryItem.MediaItem)localObject).tGS, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
                AlbumPreviewUI.this.Ho(paramAnonymousInt1);
                AlbumPreviewUI.this.an(paramAnonymousInt2, true);
              }
            }
            else
            {
              a.a.tFA.ai(((GalleryItem.MediaItem)localObject).tGS, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.Ho(paramAnonymousInt1);
              AlbumPreviewUI.this.an(paramAnonymousInt2, true);
              continue;
              a.a.tFA.ai(((GalleryItem.MediaItem)localObject).tGS, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.Ho(paramAnonymousInt1);
              AlbumPreviewUI.this.an(paramAnonymousInt2, false);
            }
          }
          localObject = AlbumPreviewUI.this.tLP.cVN().iterator();
          while (((Iterator)localObject).hasNext()) {
            if (!t.aQj((String)((Iterator)localObject).next()))
            {
              AppMethodBeat.o(111446);
              return;
            }
          }
          AlbumPreviewUI.this.oTl = true;
          AppMethodBeat.o(111446);
        }
      });
      this.tLP.tLv = this.tLv;
      if (!bt.isNullOrNil(this.tLq))
      {
        ad.d("MicroMsg.AlbumPreviewUI", "businessTag=%s", new Object[] { this.tLq });
        this.tLP.tLq = this.tLq;
        this.tLP.juP = this.juP;
        if (this.tLq.equals("album_business_bubble_media_by_coordinate"))
        {
          this.tLP.tLs = false;
          com.tencent.mm.plugin.gallery.model.e.cUM().tHj.cUy();
          this.tMo = getIntent().getStringExtra("album_business_bubble_media_by_coordinate_posname");
          final double d = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_distance", -1.0D);
          this.longitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 181.0D);
          this.latitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 91.0D);
          if ((d >= 0.0D) && (com.tencent.mm.modelgeo.a.l(this.longitude)) && (com.tencent.mm.modelgeo.a.m(this.latitude)))
          {
            this.tMp = new i.b()
            {
              public final void c(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong)
              {
                AppMethodBeat.i(111423);
                ad.d("MicroMsg.AlbumPreviewUI", "onQueryMediaBusinessDoing");
                if (paramAnonymousLong != AlbumPreviewUI.w(AlbumPreviewUI.this))
                {
                  ad.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(AlbumPreviewUI.w(AlbumPreviewUI.this)) });
                  ad.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
                  AppMethodBeat.o(111423);
                  return;
                }
                if ((paramAnonymousLinkedList == null) || (paramAnonymousLinkedList.isEmpty()))
                {
                  ad.d("MicroMsg.AlbumPreviewUI", "mediaItems is invalid.");
                  AppMethodBeat.o(111423);
                  return;
                }
                ArrayList localArrayList = new ArrayList();
                Iterator localIterator = paramAnonymousLinkedList.iterator();
                while (localIterator.hasNext())
                {
                  GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
                  if (TencentLocationUtils.distanceBetween(AlbumPreviewUI.x(AlbumPreviewUI.this), AlbumPreviewUI.y(AlbumPreviewUI.this), localMediaItem.bXD, localMediaItem.bXE) <= d)
                  {
                    localMediaItem.tGY = "album_business_bubble_media_by_coordinate";
                    localArrayList.add(localMediaItem);
                  }
                }
                paramAnonymousLinkedList.removeAll(localArrayList);
                ad.d("MicroMsg.AlbumPreviewUI", "target media size=%d", new Object[] { Integer.valueOf(localArrayList.size()) });
                localIterator = localArrayList.iterator();
                while (localIterator.hasNext()) {
                  ad.d("MicroMsg.AlbumPreviewUI", "target media item=%s", new Object[] { ((GalleryItem.MediaItem)localIterator.next()).toString() });
                }
                if ((!paramAnonymousLinkedList.isEmpty()) && (!localArrayList.isEmpty())) {
                  paramAnonymousLinkedList.addAll(0, localArrayList);
                }
                AppMethodBeat.o(111423);
              }
            };
            localObject1 = com.tencent.mm.plugin.gallery.model.e.cUM();
            localObject2 = this.tMp;
            if (localObject2 != null) {
              ((o)localObject1).tHi.add(localObject2);
            }
          }
        }
      }
      if (this.tMf) {
        this.tLP.tLs = true;
      }
      this.tMy = new a.b();
      if (getIntent().getBooleanExtra("show_header_view", true)) {
        this.tLP.a(this.tMy);
      }
      this.tLP.tHk = this.tMs;
      this.tLP.tLm = this.sUI;
      ad.i("MicroMsg.AlbumPreviewUI", "limit count = " + this.sUI);
      this.tLL.setAdapter(this.tLP);
      if (!this.tMq) {
        break label2115;
      }
      setActionbarColor(getResources().getColor(2131100399));
      setMMTitle(getIntent().getStringExtra("title_from_smart_gallery"));
      label1551:
      setNavigationbarColor(getResources().getColor(2131100399));
      setActionBarOperationAreaClickListener(new AlbumChooserView.a()
      {
        public final void cWb()
        {
          AppMethodBeat.i(179457);
          ad.i("MicroMsg.AlbumPreviewUI", "onAlbumChooserViewClick.");
          AlbumPreviewUI.a(AlbumPreviewUI.this, null);
          a.a.tFA.tFo = 1;
          ad.d("MicroMsg.AlbumPreviewUI", "click folder times: [%d].", new Object[] { Integer.valueOf(AlbumPreviewUI.B(AlbumPreviewUI.this)) });
          AlbumPreviewUI.C(AlbumPreviewUI.this);
          AlbumPreviewUI.this.playActionBarOperationAreaAnim();
          AlbumPreviewUI.m(AlbumPreviewUI.this).cWd();
          AppMethodBeat.o(179457);
        }
      });
      if (!this.tMq) {
        break label2191;
      }
    }
    label1796:
    label2191:
    for (int i = 2131230838;; i = 2131689488)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(111424);
          ad.i("MicroMsg.AlbumPreviewUI", "backBtn");
          AlbumPreviewUI.this.onBackBtnClick();
          AlbumPreviewUI.this.setResult(-2, AlbumPreviewUI.this.getIntent().putExtra("send_raw_img", AlbumPreviewUI.this.oTl));
          if ((AlbumPreviewUI.m(AlbumPreviewUI.this) != null) && (AlbumPreviewUI.m(AlbumPreviewUI.this).jR))
          {
            AlbumPreviewUI.m(AlbumPreviewUI.this).cWd();
            AlbumPreviewUI.this.playActionBarOperationAreaAnim();
            AppMethodBeat.o(111424);
            return true;
          }
          AlbumPreviewUI.z(AlbumPreviewUI.this);
          AlbumPreviewUI.this.finish();
          AppMethodBeat.o(111424);
          return true;
        }
      }, i);
      localObject1 = (ViewGroup)findViewById(2131304239);
      if ((localObject1 instanceof DrawedCallBackFrameLayout)) {
        ((DrawedCallBackFrameLayout)localObject1).setListener(new DrawedCallBackFrameLayout.a()
        {
          public final void cWa()
          {
            AppMethodBeat.i(111425);
            com.tencent.mm.plugin.gallery.a.d.cWa();
            if (AlbumPreviewUI.this.tMh) {
              AlbumPreviewUI.this.tMh = false;
            }
            AppMethodBeat.o(111425);
          }
        });
      }
      this.tMu = new e((byte)0);
      this.tMu.tMS = new WeakReference(this.tLP);
      this.tMu.tMT = new WeakReference(this.fMu);
      this.tMu.tMX = new WeakReference(this.tLT);
      this.tMu.idList = this.idList;
      this.tMu.type = this.tMs;
      AppMethodBeat.o(111474);
      return;
      bool = false;
      break;
      label1738:
      bool = false;
      break label294;
      label1744:
      this.tLV.setVisibility(8);
      this.tLU.setVisibility(8);
      break label449;
      label1765:
      this.tLV.setImageResource(2131691077);
      break label466;
      label1778:
      bool = false;
      break label499;
      label1784:
      bool = false;
      break label522;
      label1790:
      bool = false;
      break label639;
      localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDH, "");
      localObject2 = Build.MANUFACTURER.toLowerCase();
      str = Build.MODEL.toLowerCase();
      ad.i("MicroMsg.AlbumPreviewUI", "pennqin, manufacturer: %s, model: %s, smartGalleryBlackList: %s.", new Object[] { localObject2, str, localObject1 });
      if ((((String)localObject1).contains((CharSequence)localObject2)) || (((String)localObject1).contains(str)))
      {
        bool = false;
        break label667;
      }
      bool = true;
      break label667;
      label1892:
      this.tLM.setVisibility(0);
      this.tLM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164797);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          AlbumPreviewUI.g(AlbumPreviewUI.this);
          paramAnonymousView = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
          com.tencent.mm.plugin.gallery.model.e.aa(AlbumPreviewUI.this.tLP.tLn);
          paramAnonymousView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.tLP.cVN());
          paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", AlbumPreviewUI.this.tLP.tLo);
          paramAnonymousView.putExtra("max_select_count", AlbumPreviewUI.this.sUI);
          paramAnonymousView.putExtra("send_raw_img", AlbumPreviewUI.this.oTl);
          paramAnonymousView.putExtra("key_force_hide_edit_image_button", AlbumPreviewUI.h(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("key_force_show_raw_image_button", AlbumPreviewUI.i(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("key_is_raw_image_button_disable", AlbumPreviewUI.j(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.dyU);
          paramAnonymousView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
          paramAnonymousView.putExtra("select_type_tag", AlbumPreviewUI.k(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("album_business_tag", AlbumPreviewUI.this.tLq);
          paramAnonymousView.putExtra("album_video_max_duration", AlbumPreviewUI.this.juP);
          paramAnonymousView.putExtra("album_video_min_duration", AlbumPreviewUI.this.tMn);
          AlbumPreviewUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164797);
        }
      });
      if (((this.tMs != 1) && (this.tMs != 2) && (this.tMs != 3)) || (this.sUI <= 0)) {
        break label827;
      }
      if (!bt.isNullOrNil(this.tLY))
      {
        addTextOptionMenu(0, this.tLY, this.tMw);
        break label827;
      }
      if (this.tMr == 15)
      {
        i = this.tMr;
        j = this.sUI;
        localObject2 = this.tLq;
        if (this.tLP == null) {}
        for (localObject1 = null;; localObject1 = this.tLP.tLo)
        {
          addTextOptionMenu(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, 0, j, (String)localObject2, (ArrayList)localObject1), this.tMw, null, s.b.Jcc);
          break;
        }
      }
      i = this.tMr;
      int j = this.sUI;
      localObject2 = this.tLq;
      if (this.tLP == null) {}
      for (localObject1 = null;; localObject1 = this.tLP.tLo)
      {
        addTextOptionMenu(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, 0, j, (String)localObject2, (ArrayList)localObject1), this.tMw, null, s.b.Jce);
        break;
      }
      label2115:
      initActionBarOperationArea();
      setActionbarColor(getResources().getColor(2131100399));
      if (this.tMs == 3)
      {
        initActionBarOperationAreaTxt(getString(2131759758));
        break label1551;
      }
      if (this.tMs == 1)
      {
        initActionBarOperationAreaTxt(getString(2131759757));
        break label1551;
      }
      initActionBarOperationAreaTxt(getString(2131759759));
      break label1551;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(111478);
    ad.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d] %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    Object localObject2;
    if (4369 == paramInt1)
    {
      if (-1 != paramInt2)
      {
        AppMethodBeat.o(111478);
        return;
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.tools.q.i(getContext().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.asg());
      if (bt.isNullOrNil((String)localObject1))
      {
        ad.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
        AppMethodBeat.o(111478);
        return;
      }
      ad.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[] { localObject1 });
      if ((this.tMr == 0) || (this.tMr == 5) || (this.tMr == 11) || (this.tMr == 24))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setData(Uri.parse("file://" + Uri.encode((String)localObject1)));
        ad.i("MicroMsg.AlbumPreviewUI", "take photo finish");
        setResult(-1, (Intent)localObject2);
        finish();
        localObject1 = paramIntent;
      }
    }
    Object localObject3;
    label1784:
    do
    {
      for (;;)
      {
        if ((localObject1 != null) && (((Intent)localObject1).getBooleanExtra("show_photo_edit_tip", false)))
        {
          paramIntent = getSharedPreferences("photo_edit_pref", 0);
          if (!paramIntent.getBoolean("has_show_tip", false))
          {
            this.tLS.setVisibility(0);
            this.tLS.setText(getString(2131761897));
            localObject1 = AnimationUtils.loadAnimation(getContext(), 2130772047);
            this.tLS.startAnimation((Animation)localObject1);
            ((Animation)localObject1).setAnimationListener(new Animation.AnimationListener()
            {
              private Runnable tMI;
              
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                AppMethodBeat.i(111428);
                AlbumPreviewUI.A(AlbumPreviewUI.this).setVisibility(0);
                AlbumPreviewUI.A(AlbumPreviewUI.this).postDelayed(this.tMI, 4000L);
                AppMethodBeat.o(111428);
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
        ((Intent)localObject1).putExtra("send_raw_img", this.oTl);
        if ((this.tMb) || (this.tMc)) {}
        for (bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("key_force_hide_edit_image_button", bool);
          ((Intent)localObject1).putExtra("key_force_show_raw_image_button", this.tMd);
          ((Intent)localObject1).putExtra("key_is_raw_image_button_disable", this.tMe);
          ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
          if (this.tLP != null) {
            ((Intent)localObject1).putParcelableArrayListExtra("preview_media_item_list", this.tLP.tLo);
          }
          ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dyU);
          ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject1).putExtra("select_type_tag", this.iVz);
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
            ad.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
            setResult(-1, paramIntent);
            finish();
            AppMethodBeat.o(111478);
            return;
          }
          localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
          {
            ad.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
            AppMethodBeat.o(111478);
            return;
          }
          ad.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", new Object[] { localObject1 });
          setResult(-1, paramIntent);
          finish();
          localObject1 = paramIntent;
        }
        else if (4371 == paramInt1)
        {
          if (-1 != paramInt2)
          {
            AppMethodBeat.o(111478);
            return;
          }
          if (paramIntent != null) {
            paramIntent.putExtra("from_record", true);
          }
          ad.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", new Object[] { paramIntent });
          setResult(-1, paramIntent);
          finish();
          localObject1 = paramIntent;
        }
        else if (4372 == paramInt1)
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
          ad.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", new Object[] { localObject1 });
          paramIntent = new ArrayList();
          localObject2 = getIntent().getStringExtra("video_full_path");
          if (!bt.isNullOrNil((String)localObject2))
          {
            paramIntent.add(localObject2);
            ((Intent)localObject1).putExtra("key_select_video_list", paramIntent);
            ((Intent)localObject1).putExtra("key_selected_video_is_from_sys_camera", true);
          }
          setResult(-1, (Intent)localObject1);
          finish();
        }
        else if (4373 == paramInt1)
        {
          if (paramIntent != null)
          {
            paramIntent.putExtra("GalleryUI_IsSendImgBackground", true);
            ad.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
          }
          ad.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
          setResult(-1, paramIntent);
          this.tMh = true;
          finish();
          localObject1 = paramIntent;
        }
        else if (4378 == paramInt1)
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
          ad.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[] { localObject1 });
          paramIntent = (CaptureDataManager.CaptureVideoNormalModel)((Intent)localObject1).getParcelableExtra("KSEGMENTMEDIAINFO");
          if (paramIntent == null)
          {
            ad.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
            setResult(1);
            finish();
            AppMethodBeat.o(111478);
            return;
          }
          localObject2 = new ArrayList();
          localObject3 = paramIntent.videoPath;
          if (!bt.isNullOrNil((String)localObject3))
          {
            ((ArrayList)localObject2).add(localObject3);
            ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
          }
          if ((paramIntent.xyb.booleanValue()) && (!bt.isNullOrNil(paramIntent.thumbPath)))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramIntent.thumbPath);
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
          }
          setResult(-1, (Intent)localObject1);
          finish();
        }
        else if (4375 == paramInt1)
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
          ad.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[] { localObject1 });
          paramIntent = (SightCaptureResult)((Intent)localObject1).getParcelableExtra("key_req_result");
          if (paramIntent == null)
          {
            ad.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
            setResult(1);
            finish();
            AppMethodBeat.o(111478);
            return;
          }
          localObject2 = new ArrayList();
          localObject3 = paramIntent.vMu;
          if (!bt.isNullOrNil((String)localObject3))
          {
            ((ArrayList)localObject2).add(localObject3);
            ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
          }
          if ((paramIntent.vMs) && (!bt.isNullOrNil(paramIntent.vMA)))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramIntent.vMA);
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
          }
          setResult(-1, (Intent)localObject1);
          finish();
        }
        else if (4376 == paramInt1)
        {
          if (-1 != paramInt2)
          {
            ad.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
            finish();
            localObject1 = paramIntent;
          }
          else
          {
            localObject1 = paramIntent;
            if (paramIntent != null)
            {
              localObject1 = (GalleryItem.AlbumItem)paramIntent.getParcelableExtra("select_folder_name");
              b((GalleryItem.AlbumItem)localObject1);
              setMMTitle(bt.bI(((GalleryItem.AlbumItem)localObject1).tGK, getString(2131759758)));
              localObject1 = paramIntent;
            }
          }
        }
        else if (4377 == paramInt1)
        {
          localObject1 = paramIntent;
          if (paramInt2 == -1)
          {
            setResult(-1, paramIntent);
            finish();
            localObject1 = paramIntent;
          }
        }
        else
        {
          if (paramInt1 == 4379)
          {
            if ((paramInt2 == -1) && (paramIntent != null))
            {
              localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
              paramIntent.putExtra("key_extra_data", paramIntent.getBundleExtra("key_extra_data"));
              paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).videoPath);
              paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath);
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).dFF().v("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
              this.tLO = true;
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
              if (bt.isNullOrNil(this.tMF)) {
                break;
              }
              localObject2 = a.a.tFA;
              localObject3 = this.tMF;
              ad.i("MicroMsg.GalleryReporter", "path: %s.", new Object[] { localObject3 });
              localObject1 = paramIntent;
              if (bt.isNullOrNil((String)localObject3)) {
                break;
              }
              ((com.tencent.mm.plugin.gallery.a)localObject2).tFu.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).tFv.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).tFw.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).tFx.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).tFy.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).tFz.remove(localObject3);
              localObject1 = paramIntent;
              break;
              if (paramInt2 == -2) {
                finish();
              }
            }
          }
          if (4382 == paramInt1)
          {
            ad.i("MicroMsg.AlbumPreviewUI", "back from smart gallery.");
            if (paramIntent != null)
            {
              localObject1 = paramIntent.getExtras();
              this.oTl = paramIntent.getBooleanExtra("send_raw_img", this.oTl);
              if (this.oTl)
              {
                this.tLV.setImageResource(2131691078);
                if (this.tMe) {
                  this.tLV.setImageResource(2131691075);
                }
                localObject2 = this.tLV;
                if (this.tMe) {
                  break label1896;
                }
                bool = true;
                ((ImageButton)localObject2).setEnabled(bool);
                localObject2 = this.tLU;
                if (this.tMe) {
                  break label1902;
                }
              }
              for (bool = true;; bool = false)
              {
                ((TextView)localObject2).setEnabled(bool);
                if (localObject1 == null) {
                  break label1908;
                }
                localObject2 = ((Bundle)localObject1).keySet().iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  ad.i("MicroMsg.AlbumPreviewUI", "key: %s, value: %s.", new Object[] { localObject3, ((Bundle)localObject1).get((String)localObject3) });
                }
                this.tLV.setImageResource(2131691077);
                break;
                bool = false;
                break label1784;
              }
            }
            if ((-2 == paramInt2) || (paramInt2 == 0) || (SmartGalleryUI.tPR == paramInt2))
            {
              ad.i("MicroMsg.AlbumPreviewUI", "just back from SmartGalleryUI.");
              paramIntent = new android.support.v4.e.b();
              paramInt1 = i;
              while (paramInt1 < this.tLP.tLo.size())
              {
                localObject1 = (GalleryItem.MediaItem)this.tLP.tLo.get(paramInt1);
                i = this.tLP.tLn.indexOf(localObject1);
                if (i != -1) {
                  paramIntent.add(Integer.valueOf(i));
                }
                paramInt1 += 1;
              }
              this.tLP.ea(s.cVx().tHD);
              if (SmartGalleryUI.tPR == paramInt2)
              {
                cJu();
                AppMethodBeat.o(111478);
                return;
              }
              Ho(this.tLP.tLo.size());
              this.tLP.a(paramIntent);
              AppMethodBeat.o(111478);
              return;
            }
            if (-1 == paramInt2) {
              this.tLO = true;
            }
            setResult(paramInt2, paramIntent);
            finish();
            localObject1 = paramIntent;
          }
          else if (paramInt1 == 4381)
          {
            if (paramInt2 == -1)
            {
              if (this.tMa)
              {
                paramIntent = RecordConfigProvider.iJ("", "");
                paramIntent.xyt = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
                paramIntent.scene = 2;
                localObject1 = new VideoCaptureReportInfo();
                ((VideoCaptureReportInfo)localObject1).rgD = 1;
                paramIntent.xyB = ((VideoCaptureReportInfo)localObject1);
                localObject1 = new UICustomParam.a();
                ((UICustomParam.a)localObject1).aby();
                ((UICustomParam.a)localObject1).abx();
                ((UICustomParam.a)localObject1).cP(true);
                paramIntent.xyk = ((UICustomParam.a)localObject1).gei;
                localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772137, -1, paramIntent, 4, 0);
                AppMethodBeat.o(111478);
                return;
              }
              localObject1 = paramIntent;
              if (22 == com.tencent.mm.plugin.gallery.model.e.cUM().kTx)
              {
                setResult(-1, paramIntent);
                finish();
                AppMethodBeat.o(111478);
              }
            }
            else
            {
              Toast.makeText(this, 2131760707, 1).show();
              localObject1 = paramIntent;
            }
          }
          else
          {
            switch (paramInt2)
            {
            default: 
              localObject1 = paramIntent;
              break;
            case -2: 
              ad.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
              finish();
              localObject1 = paramIntent;
              break;
            case -1: 
              localObject1 = paramIntent;
              if (paramIntent == null)
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("CropImage_Compress_Img", true);
                ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", this.tLP.cVN());
              }
              ((Intent)localObject1).putStringArrayListExtra("key_select_image_list", ((Intent)localObject1).getStringArrayListExtra("CropImage_OutputPath_List"));
              ad.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
              this.tLO = true;
              setResult(-1, (Intent)localObject1);
              finish();
            }
          }
        }
      }
      localObject1 = paramIntent;
    } while (paramIntent == null);
    label1896:
    label1902:
    label1908:
    Object localObject1 = paramIntent.getStringArrayListExtra("preview_image_list");
    if (localObject1 == null) {}
    for (paramInt1 = 0;; paramInt1 = ((ArrayList)localObject1).size())
    {
      ad.i("MicroMsg.AlbumPreviewUI", "paths size: %d.", new Object[] { Integer.valueOf(paramInt1) });
      if ((localObject1 == null) || (this.tLP == null)) {
        break label2588;
      }
      localObject2 = new android.support.v4.e.b();
      paramInt1 = 0;
      while (paramInt1 < this.tLP.tLo.size())
      {
        localObject3 = (GalleryItem.MediaItem)this.tLP.tLo.get(paramInt1);
        paramInt2 = this.tLP.tLn.indexOf(localObject3);
        if (paramInt2 != -1) {
          ((android.support.v4.e.b)localObject2).add(Integer.valueOf(paramInt2));
        }
        paramInt1 += 1;
      }
    }
    this.tLP.ac((ArrayList)localObject1);
    this.tLP.a((android.support.v4.e.b)localObject2);
    Ho(((ArrayList)localObject1).size());
    label2588:
    if (!paramIntent.getBooleanExtra("CropImage_Compress_Img", true))
    {
      bool = true;
      label2602:
      this.oTl = bool;
      if (!this.oTl) {
        break label2700;
      }
      this.tLV.setImageResource(2131691078);
      label2625:
      if (this.tMe) {
        this.tLV.setImageResource(2131691075);
      }
      localObject1 = this.tLV;
      if (this.tMe) {
        break label2713;
      }
      bool = true;
      label2658:
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.tLU;
      if (this.tMe) {
        break label2719;
      }
    }
    label2700:
    label2713:
    label2719:
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject1).setEnabled(bool);
      localObject1 = paramIntent;
      break;
      bool = false;
      break label2602;
      this.tLV.setImageResource(2131691077);
      break label2625;
      bool = false;
      break label2658;
    }
  }
  
  protected void onBackBtnClick() {}
  
  public void onBackPressed()
  {
    AppMethodBeat.i(164799);
    super.onBackPressed();
    onBackBtnClick();
    AppMethodBeat.o(164799);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111464);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.AlbumPreviewUI", "onCreate, %s.", new Object[] { this });
    setRequestedOrientation(1);
    String str1 = getString(2131761885);
    String str2 = getString(2131759773);
    this.tMt = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, str1, str2);
    ad.d("MicroMsg.AlbumPreviewUI", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(this.tMt) });
    this.tMl = System.currentTimeMillis();
    start = System.currentTimeMillis();
    this.fMu = com.tencent.mm.ui.base.p.a(this, getString(2131755936), false);
    this.tMz = AlbumPreviewUI.b.tMP;
    if (paramBundle != null)
    {
      ad.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
      this.tMr = paramBundle.getInt("constants_key_query_source");
    }
    for (this.tMs = paramBundle.getInt("constants_key_query_type");; this.tMs = getIntent().getIntExtra("query_media_type", 1))
    {
      com.tencent.mm.plugin.gallery.model.e.cUM().kTx = this.tMr;
      com.tencent.mm.plugin.gallery.model.e.cUM().setQueryType(this.tMs);
      ad.i("MicroMsg.AlbumPreviewUI", "query source: " + this.tMr + ", queryType: " + this.tMs);
      this.iVz = getIntent().getIntExtra("select_type_tag", 3);
      this.pyi = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyu, true);
      this.tMq = getIntent().getBooleanExtra("is_from_smart_gallery", false);
      initView();
      if (this.tMt) {
        cVV();
      }
      com.tencent.mm.plugin.gallery.model.e.cUU();
      AppMethodBeat.o(111464);
      return;
      this.tMr = getIntent().getIntExtra("query_source_type", 3);
    }
  }
  
  public void onDestroy()
  {
    boolean bool1 = false;
    AppMethodBeat.i(111469);
    super.onDestroy();
    ad.i("MicroMsg.AlbumPreviewUI", "onDestroy, %s.", new Object[] { this });
    if (com.tencent.mm.plugin.gallery.model.e.cUM() != null)
    {
      com.tencent.mm.plugin.gallery.model.e.cUM().tHh.remove(this);
      o localo = com.tencent.mm.plugin.gallery.model.e.cUM();
      i.b localb = this.tMp;
      if (localb != null) {
        localo.tHi.remove(localb);
      }
    }
    if ((this.tMi > 0) || (this.tMj > 0))
    {
      ad.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", new Object[] { Integer.valueOf(this.tMi), Integer.valueOf(this.tMj) });
      com.tencent.mm.plugin.gallery.a.d.bl(11187, this.tMi + "," + this.tMj);
    }
    for (;;)
    {
      if ((this.tMk > 0L) || (this.tLO)) {
        com.tencent.mm.plugin.gallery.model.e.a(this.tLY, ad(this.tLP.tLo), this.oTl, this.tLN);
      }
      int i = this.tLP.tLo.size();
      boolean bool2 = this.oTl;
      if ((this.tMk > 0L) || (this.tLO)) {
        bool1 = true;
      }
      com.tencent.mm.plugin.gallery.model.e.f(i, bool2, bool1);
      y.cRM.JX().JW();
      com.tencent.mm.plugin.gallery.model.e.cUP().clear();
      com.tencent.mm.plugin.gallery.model.e.cUQ().clear();
      com.tencent.mm.plugin.gallery.model.e.cUR().clear();
      if (!this.tMq) {
        break;
      }
      s.cVx().tHB = true;
      if (com.tencent.mm.plugin.gallery.model.e.cUV())
      {
        com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.hxg).ahi();
        a.g.cVR();
      }
      AppMethodBeat.o(111469);
      return;
      ad.d("MicroMsg.AlbumPreviewUI", "not click camera or folder.");
    }
    if (!this.jpZ) {
      a.a.tFA.report();
    }
    for (;;)
    {
      s.cVx().tHC = true;
      com.tencent.mm.plugin.gallery.model.e.cUM().cVu();
      break;
      a.a.tFA.reset();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111477);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      ad.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
      setResult(-2);
      if ((this.tLT != null) && (this.tLT.jR))
      {
        this.tLT.cWd();
        playActionBarOperationAreaAnim();
        AppMethodBeat.o(111477);
        return true;
      }
      this.jpZ = true;
      finish();
      AppMethodBeat.o(111477);
      return true;
    }
    if (paramInt == 82)
    {
      this.tMj += 1;
      if (this.tLT != null) {
        this.tLT.cWd();
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
    ad.i("MicroMsg.AlbumPreviewUI", "on onPause, %s.", new Object[] { this });
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    this.tMg = true;
    ImageFolderMgrView localImageFolderMgrView;
    if ((!isFinishing()) && (!isDestroyed()) && (this.tLT != null) && (this.tLT.jR))
    {
      localImageFolderMgrView = this.tLT;
      if (localImageFolderMgrView.jR) {
        break label132;
      }
      ad.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
    }
    for (;;)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, this.fKU);
      this.fKU = 0;
      if (this.tMq) {
        s.cVx().dZ(this.tLP.tLo);
      }
      AppMethodBeat.o(111467);
      return;
      label132:
      if (localImageFolderMgrView.tNS)
      {
        ad.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
      }
      else
      {
        localImageFolderMgrView.tNO.setVisibility(8);
        localImageFolderMgrView.jR = false;
        if (localImageFolderMgrView.tNW != null) {
          localImageFolderMgrView.tNW.mQ(false);
        }
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(111483);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(111483);
      return;
    }
    ad.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111483);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cVW();
        AppMethodBeat.o(111483);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131759760), false, new AlbumPreviewUI.6(this), null);
      AppMethodBeat.o(111483);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cVU();
        com.tencent.mm.plugin.gallery.model.e.cUM().cVt();
        cVV();
        AppMethodBeat.o(111483);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761865), getString(2131761885), getString(2131760598), getString(2131759760), false, new AlbumPreviewUI.7(this), new AlbumPreviewUI.8(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111465);
    super.onResume();
    ad.i("MicroMsg.AlbumPreviewUI", "onResume, %s.", new Object[] { this });
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    this.tMg = false;
    AppMethodBeat.o(111465);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(111470);
    super.onSaveInstanceState(paramBundle);
    ad.i("MicroMsg.AlbumPreviewUI", "onSaveInstanceState, %s.", new Object[] { this });
    paramBundle.putInt("constants_key_query_source", this.tMr);
    paramBundle.putInt("constants_key_query_type", this.tMs);
    AppMethodBeat.o(111470);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(111466);
    super.onStart();
    ad.i("MicroMsg.AlbumPreviewUI", "onStart, %s.", new Object[] { this });
    if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx != this.tMr) {
      com.tencent.mm.plugin.gallery.model.e.cUM().kTx = this.tMr;
    }
    if (com.tencent.mm.plugin.gallery.model.e.cUM().tHk != this.tMs) {
      com.tencent.mm.plugin.gallery.model.e.cUM().setQueryType(this.tMs);
    }
    AppMethodBeat.o(111466);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(111468);
    super.onStop();
    ad.i("MicroMsg.AlbumPreviewUI", "onStop, %s.", new Object[] { this });
    if (!this.tMq)
    {
      com.tencent.mm.plugin.gallery.model.c localc = com.tencent.mm.plugin.gallery.model.e.cUL();
      if ((localc.tFM != null) && (!localc.tFM.isEmpty()))
      {
        Iterator localIterator = localc.tFM.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.c localc1 = (c.c)((Map.Entry)localIterator.next()).getValue();
          if (localc1 != null) {
            localc1.mCancel = true;
          }
        }
        if (localc.tFL != null) {
          localc.tFL.clear();
        }
        if ((localc.tFM != null) && (!localc.tFM.isEmpty())) {
          localc.tFM.clear();
        }
        localc.tFJ.cUH();
      }
      com.tencent.mm.plugin.gallery.model.e.cUL().cUG();
    }
    AppMethodBeat.o(111468);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    implements Runnable
  {
    WeakReference<AlbumPreviewUI> lNs;
    
    a(AlbumPreviewUI paramAlbumPreviewUI)
    {
      AppMethodBeat.i(111448);
      this.lNs = new WeakReference(paramAlbumPreviewUI);
      AppMethodBeat.o(111448);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111449);
      long l = System.currentTimeMillis();
      boolean bool = s.cVx().cVz();
      l = System.currentTimeMillis() - l;
      ad.i("MicroMsg.AlbumPreviewUI", "smart gallery isValid: %s, dur: %s.", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.g.yhR.f(19165, new Object[] { Long.valueOf(l) });
      if (l <= 3000L) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(1297, 0);
      }
      for (;;)
      {
        if (bool)
        {
          a.a.tFA.tFm = 1;
          com.tencent.mm.plugin.gallery.model.e.cUN().f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111447);
              if (AlbumPreviewUI.a.this.lNs != null)
              {
                AlbumPreviewUI localAlbumPreviewUI = (AlbumPreviewUI)AlbumPreviewUI.a.this.lNs.get();
                if (localAlbumPreviewUI != null)
                {
                  localAlbumPreviewUI.setSmartGalleryEntryVisibility(true);
                  localAlbumPreviewUI.tMC = true;
                }
              }
              AppMethodBeat.o(111447);
            }
          });
        }
        AppMethodBeat.o(111449);
        return;
        if (l <= 5000L) {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1297, 1);
        } else if (l <= 10000L) {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1297, 2);
        } else if (l <= 15000L) {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1297, 3);
        } else {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1297, 4);
        }
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    WeakReference<a> tMS;
    WeakReference<ProgressDialog> tMT;
    WeakReference<TextView> tMU;
    WeakReference<RecyclerView> tMV;
    LinkedList<GalleryItem.MediaItem> tMW;
    WeakReference<ImageFolderMgrView> tMX;
    boolean tMY = false;
    String tMo;
    
    public final void run()
    {
      AppMethodBeat.i(111455);
      if (this.tMW == null) {}
      for (int i = -1;; i = this.tMW.size())
      {
        ad.d("MicroMsg.AlbumPreviewUI", "on NotifyMediaItemsChanged, size %d", new Object[] { Integer.valueOf(i) });
        AlbumPreviewUI.at(this.tMW);
        if (this.tMS != null) {
          break;
        }
        ad.w("MicroMsg.AlbumPreviewUI", "null == adapterRef");
        AppMethodBeat.o(111455);
        return;
      }
      Object localObject1 = (a)this.tMS.get();
      if (localObject1 == null)
      {
        ad.w("MicroMsg.AlbumPreviewUI", "null == adapter");
        AppMethodBeat.o(111455);
        return;
      }
      if (this.tMV == null)
      {
        AppMethodBeat.o(111455);
        return;
      }
      RecyclerView localRecyclerView = (RecyclerView)this.tMV.get();
      if (localRecyclerView == null)
      {
        AppMethodBeat.o(111455);
        return;
      }
      ad.d("MicroMsg.AlbumPreviewUI", "isSwitchAlbum: %s.", new Object[] { Boolean.valueOf(this.tMY) });
      Object localObject2 = com.tencent.mm.plugin.gallery.model.p.tHs;
      localObject2 = com.tencent.mm.plugin.gallery.model.p.cVv();
      Object localObject3 = this.tMW;
      d.g.b.p.h(localObject3, "mediaItems");
      ad.d("MicroMsg.PreLoadManager", "syncMediaItems, size: %s.", new Object[] { Integer.valueOf(((List)localObject3).size()) });
      ((com.tencent.mm.plugin.gallery.model.p)localObject2).tHp.clear();
      ((com.tencent.mm.plugin.gallery.model.p)localObject2).tHp.addAll((Collection)localObject3);
      if (this.tMY)
      {
        this.tMY = false;
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((a)localObject1).ar(this.tMW);
        localObject2 = com.tencent.mm.plugin.gallery.model.p.tHs;
        localObject2 = com.tencent.mm.plugin.gallery.model.p.cVv();
        localObject3 = p.c.tHv;
        if (this.tMW.size() > 32)
        {
          i = 32;
          ((com.tencent.mm.plugin.gallery.model.p)localObject2).a((p.c)localObject3, 0, i, ((a)localObject1).tLn.size());
        }
      }
      for (;;)
      {
        if (this.tMT != null) {
          break label389;
        }
        AppMethodBeat.o(111455);
        return;
        i = this.tMW.size();
        break;
        ((a)localObject1).as(this.tMW);
      }
      label389:
      localObject2 = (ProgressDialog)this.tMT.get();
      if ((localObject2 != null) && (((ProgressDialog)localObject2).isShowing()))
      {
        ((ProgressDialog)localObject2).dismiss();
        ad.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start) });
      }
      if (this.tMX != null)
      {
        localObject2 = (ImageFolderMgrView)this.tMX.get();
        if (localObject2 != null) {
          ((ImageFolderMgrView)localObject2).setFavItemCount(this.tMW.size());
        }
      }
      if ((this.tMU == null) || (bt.isNullOrNil(this.tMo)))
      {
        AppMethodBeat.o(111455);
        return;
      }
      localObject2 = (TextView)this.tMU.get();
      if (localObject2 != null)
      {
        localObject1 = ((a)localObject1).Hn(((GridLayoutManager)localRecyclerView.getLayoutManager()).km());
        if ((!bt.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("album_business_bubble_media_by_coordinate")))
        {
          ((TextView)localObject2).setVisibility(0);
          ((TextView)localObject2).setText(this.tMo.concat("附近的照片和视频"));
          ((TextView)localObject2).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111454);
              if (8 == this.tMZ.getVisibility())
              {
                AppMethodBeat.o(111454);
                return;
              }
              this.tMZ.animate().alpha(0.0F).setDuration(300L).withEndAction(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111453);
                  AlbumPreviewUI.c.1.this.tMZ.setVisibility(8);
                  AlbumPreviewUI.c.1.this.tMZ.setAlpha(1.0F);
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
    List<Long> idList;
    WeakReference<a> tMS;
    WeakReference<ProgressDialog> tMT;
    WeakReference<ImageFolderMgrView> tMX;
    boolean tNh;
    int type;
    
    public final void run()
    {
      AppMethodBeat.i(111462);
      s locals = s.cVx();
      i.c local1 = new i.c()
      {
        public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(111461);
          ad.i("MicroMsg.AlbumPreviewUI", "RetrieveFavMediaTask onQueryMediaFinished cancelUINotify: %s.", new Object[] { Boolean.valueOf(AlbumPreviewUI.e.this.tNh) });
          if (AlbumPreviewUI.e.this.tNh)
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
            ad.d("MicroMsg.AlbumPreviewUI", "type: %s path: %s", new Object[] { localMediaItem.mMimeType, localMediaItem.tGS });
          }
          paramAnonymousLinkedList = new AlbumPreviewUI.c((byte)0);
          paramAnonymousLinkedList.tMS = AlbumPreviewUI.e.this.tMS;
          paramAnonymousLinkedList.tMT = AlbumPreviewUI.e.this.tMT;
          paramAnonymousLinkedList.tMW = localLinkedList;
          paramAnonymousLinkedList.tMX = AlbumPreviewUI.e.this.tMX;
          com.tencent.mm.plugin.gallery.model.e.cUN().f(paramAnonymousLinkedList);
          AppMethodBeat.o(111461);
        }
      };
      Object localObject2 = this.idList;
      int i1 = this.type;
      locals.tHC = false;
      LinkedList localLinkedList = new LinkedList();
      Object localObject1 = localObject2;
      if (bt.hj((List)localObject2))
      {
        ad.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id list now.");
        ad.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id, type: %d.", new Object[] { Integer.valueOf(i1) });
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        switch (i1)
        {
        default: 
          ((List)localObject2).add(Integer.valueOf(2));
        }
        for (;;)
        {
          localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSearchStorage().b(null, null, (List)localObject2);
          if (!bt.hj((List)localObject2))
          {
            ad.i("MicroMsg.SmartGalleryQueryUtil", "fav list contains img or video.");
            ((List)localObject1).addAll((Collection)localObject2);
          }
          if (!bt.hj((List)localObject1)) {
            break;
          }
          ad.i("MicroMsg.SmartGalleryQueryUtil", "fav list do not contain img or video.");
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
      int m = ((List)localObject1).size();
      ad.i("MicroMsg.SmartGalleryQueryUtil", "fav count: %d.", new Object[] { Integer.valueOf(m) });
      int i;
      int n;
      int j;
      int k;
      if (m < 100)
      {
        i = m;
        n = i + 0;
        boolean bool = true;
        j = 0;
        k = i;
        i = n;
        label326:
        if (!locals.tHC)
        {
          ad.i("MicroMsg.SmartGalleryQueryUtil", "get fav, count: %d.", new Object[] { Integer.valueOf(k) });
          localLinkedList.addAll(s.r(((List)localObject1).subList(j, i), i1));
          local1.b(localLinkedList, -1L, bool);
          if (!bool) {
            break label461;
          }
          bool = false;
        }
      }
      label419:
      label461:
      for (;;)
      {
        n = m - localLinkedList.size();
        if (n > 0) {
          if (n < 100)
          {
            j = n;
            n = i + j;
            k = j;
            j = i;
            i = n;
          }
        }
        for (;;)
        {
          if (i >= m)
          {
            AppMethodBeat.o(111462);
            return;
            i = 100;
            break;
            j = 100;
            break label419;
          }
          break label326;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
 * JD-Core Version:    0.7.0.1
 */