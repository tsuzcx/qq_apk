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
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.y;
import com.tencent.mm.api.y.b;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.expt.a.b.a;
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
import com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout.a;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.AlbumChooserView.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.k;
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
  protected String dpv;
  private int foV;
  private ProgressDialog fpP;
  protected int iBF;
  private int ici;
  private List<Long> idList;
  private boolean iwN;
  private double latitude;
  private double longitude;
  private int mmC;
  public boolean nMQ;
  private boolean oqY;
  protected int qXm;
  protected String rGX;
  private ImageFolderMgrView rHA;
  private TextView rHB;
  private ImageButton rHC;
  private String rHD;
  private String rHE;
  private String rHF;
  private boolean rHG;
  private boolean rHH;
  private boolean rHI;
  private boolean rHJ;
  private boolean rHK;
  private boolean rHL;
  private boolean rHM;
  private boolean rHN;
  boolean rHO;
  private int rHP;
  private int rHQ;
  private long rHR;
  private long rHS;
  private int rHT;
  protected int rHU;
  private String rHV;
  private i.b rHW;
  private boolean rHX;
  protected int rHY;
  protected int rHZ;
  private a.f rHc;
  protected RecyclerView rHs;
  private TextView rHt;
  private boolean rHu;
  private boolean rHv;
  protected a rHw;
  private TextView rHx;
  private TextView rHy;
  private TextView rHz;
  private boolean rIa;
  private e rIb;
  private volatile long rIc;
  protected MenuItem.OnMenuItemClickListener rId;
  private GalleryItem.AlbumItem rIe;
  private a.d rIf;
  private volatile AlbumPreviewUI.b rIg;
  private HashMap<String, Integer> rIh;
  private HashSet<String> rIi;
  boolean rIj;
  private p.c rIk;
  private int rIl;
  private String rIm;
  protected String toUser;
  
  public AlbumPreviewUI()
  {
    AppMethodBeat.i(111463);
    this.rHH = false;
    this.nMQ = false;
    this.rHM = false;
    this.rHN = false;
    this.rHO = false;
    this.rHP = 0;
    this.rHQ = 0;
    this.rHR = 0L;
    this.rHT = -1;
    this.oqY = true;
    this.idList = new ArrayList();
    this.ici = 3;
    this.rIc = -1L;
    this.rId = new AlbumPreviewUI.12(this);
    this.rIh = new HashMap();
    this.rHc = new a.f()
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
    this.rIk = p.c.rBR;
    this.rIl = -1;
    this.mmC = -1;
    this.iwN = false;
    this.rIm = "";
    AppMethodBeat.o(111463);
  }
  
  private static int[] T(ArrayList<GalleryItem.MediaItem> paramArrayList)
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
  
  private void abJ(String paramString)
  {
    AppMethodBeat.i(173773);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
      AppMethodBeat.o(173773);
      return;
    }
    com.tencent.mm.plugin.gallery.model.e.czi().ak(new AlbumPreviewUI.d(paramString, this.rHw, this.fpP, this.rHs));
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
    if (paramAlbumItem.Lmk) {}
    for (this.ici = 3; bt.by(this.rHE, "").equals(paramAlbumItem.rBh); this.ici = 4)
    {
      ad.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
      AppMethodBeat.o(111472);
      return;
    }
    com.tencent.mm.plugin.gallery.model.e.czm().addAll(this.rHw.rGV);
    ad.i("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[] { paramAlbumItem.rBh, paramAlbumItem.anX() });
    this.rHD = paramAlbumItem.anX();
    this.rHE = paramAlbumItem.rBh;
    if (bt.isNullOrNil(this.rHD))
    {
      ad.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
      this.rHD = this.rHE;
    }
    Object localObject1;
    Object localObject2;
    label221:
    int i;
    if (!bt.isNullOrNil(this.rHE))
    {
      localObject1 = this.rHw;
      localObject2 = this.rIf;
      if (localObject2 == null)
      {
        ad.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
        localObject2 = paramAlbumItem.bNK;
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2))
        {
          if (this.rHZ != 3) {
            break label428;
          }
          localObject1 = getString(2131759758);
        }
        updateActionBarOperationAreaTxt((String)localObject1);
        Ed(this.rHw.rGV.size());
        this.fpP.show();
        start = System.currentTimeMillis();
        localObject2 = this.rHE;
        i = this.rHZ;
        localObject1 = localObject2;
        if (((String)localObject2).equals(getString(2131759759)))
        {
          localObject1 = "";
          i = 2;
        }
        if (!this.rHE.equalsIgnoreCase(getString(2131759764))) {
          break label458;
        }
        if (this.rIb != null) {
          this.rIb.rIO = false;
        }
        com.tencent.mm.plugin.gallery.model.e.czi().al(this.rIb);
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
        com.tencent.mm.plugin.report.service.h.vKh.f(18269, new Object[] { URLEncoder.encode((String)localObject1, "utf-8"), URLEncoder.encode(paramAlbumItem.bNK, "utf-8") });
        AppMethodBeat.o(111472);
        return;
      }
      catch (Exception paramAlbumItem)
      {
        AppMethodBeat.o(111472);
      }
      ((a)localObject1).rGY.remove(localObject2);
      break;
      if (!getIntent().getBooleanExtra("show_header_view", true)) {
        break;
      }
      this.rHw.a(this.rIf);
      break;
      label428:
      if (this.rHZ == 1)
      {
        localObject1 = getString(2131759757);
        break label221;
      }
      localObject1 = getString(2131759759);
      break label221;
      label458:
      if ((paramAlbumItem instanceof GalleryItem.PrivateAlbumItem))
      {
        com.tencent.mm.plugin.gallery.model.e.czh().czQ();
        this.rIc = System.currentTimeMillis();
        s.czT().rBY = true;
        localObject1 = ((GalleryItem.PrivateAlbumItem)paramAlbumItem).rBx.rCc;
        if (bt.isNullOrNil((String)localObject1)) {
          ad.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
        } else {
          com.tencent.mm.plugin.gallery.model.e.czi().al(new AlbumPreviewUI.d((String)localObject1, this.rHw, this.fpP, this.rHs));
        }
      }
      else
      {
        if (this.rIb != null) {
          this.rIb.rIO = true;
        }
        s.czT().rBZ = true;
        s.czT().rBY = true;
        this.rIc = System.currentTimeMillis();
        com.tencent.mm.plugin.gallery.model.e.czh().j((String)localObject1, i, this.rIc);
      }
    }
  }
  
  private void cAt()
  {
    AppMethodBeat.i(173771);
    Object localObject = com.tencent.mm.plugin.gallery.model.e.czi();
    AlbumPreviewUI.a locala = new AlbumPreviewUI.a(this);
    localObject = ((com.tencent.mm.plugin.gallery.model.g)localObject).czC();
    if (localObject != null)
    {
      ((ap)localObject).post(locala);
      AppMethodBeat.o(173771);
      return;
    }
    ad.w("MicroMsg.GalleryHandlerThread", "other handler is null.");
    AppMethodBeat.o(173771);
  }
  
  private void cAu()
  {
    AppMethodBeat.i(173772);
    if (this.rHX)
    {
      this.rHw.dM(s.czT().rCa);
      com.tencent.mm.plugin.gallery.model.e.czm().addAll(this.rHw.rGV);
      Ed(this.rHw.rGV.size());
      abJ(getIntent().getStringExtra("album_id_from_smart_gallery"));
      this.fpP.show();
      AppMethodBeat.o(173772);
      return;
    }
    com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.gEx).apr();
    if (getIntent().hasExtra("gallery_report_tag")) {
      a.a.rzX.setScene(getIntent().getIntExtra("gallery_report_tag", 3));
    }
    for (;;)
    {
      ad.i("MicroMsg.AlbumPreviewUI", "start queryMediaInAlbums %s", new Object[] { this });
      com.tencent.mm.plugin.gallery.model.e.czh().a(this);
      this.rIc = System.currentTimeMillis();
      com.tencent.mm.plugin.gallery.model.e.czh().as(this.rHE, this.rIc);
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111422);
          ad.d("MicroMsg.AlbumPreviewUI", "onCreate, post delay, dialog show.");
          if (AlbumPreviewUI.b.rIx != AlbumPreviewUI.a(AlbumPreviewUI.this)) {
            AlbumPreviewUI.b(AlbumPreviewUI.this).show();
          }
          AppMethodBeat.o(111422);
        }
      }, 300L);
      p.a locala = com.tencent.mm.plugin.gallery.model.p.rBO;
      com.tencent.mm.plugin.gallery.model.p.czR().a(new l());
      locala = com.tencent.mm.plugin.gallery.model.p.rBO;
      com.tencent.mm.plugin.gallery.model.p.czR().a(new com.tencent.mm.plugin.gallery.model.q());
      AppMethodBeat.o(173772);
      return;
      a.a.rzX.setScene(this.rHY);
    }
  }
  
  private void cAv()
  {
    AppMethodBeat.i(111476);
    if (!com.tencent.mm.pluginsdk.ui.tools.q.d(getContext(), com.tencent.mm.loader.j.b.ais(), "microMsg." + System.currentTimeMillis() + ".jpg", 4369))
    {
      Toast.makeText(getContext(), getString(2131763022), 1).show();
      AppMethodBeat.o(111476);
      return;
    }
    System.gc();
    AppMethodBeat.o(111476);
  }
  
  private void cAw()
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
      if ((!com.tencent.mm.r.a.cd(getContext())) && (!com.tencent.mm.r.a.cc(getContext()))) {
        com.tencent.mm.compatible.h.b.w(getContext());
      }
      AppMethodBeat.o(111485);
    }
  }
  
  private static void dN(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111480);
    long l = System.currentTimeMillis();
    ad.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (!com.tencent.mm.vfs.i.eK(localMediaItem.rBp))
      {
        ad.w("MicroMsg.AlbumPreviewUI", "filter non exist media: %s.", new Object[] { localMediaItem.rBp });
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
  
  private void fXS()
  {
    AppMethodBeat.i(200776);
    if (this.rIi == null)
    {
      this.rIi = new HashSet();
      this.rIi.add(".h264");
      this.rIi.add(".h26l");
      this.rIi.add(".264");
      this.rIi.add(".avc");
      this.rIi.add(".mov");
      this.rIi.add(".mp4");
      this.rIi.add(".m4a");
      this.rIi.add(".3gp");
      this.rIi.add(".3g2");
      this.rIi.add(".mj2");
      this.rIi.add(".m4v");
    }
    AppMethodBeat.o(200776);
  }
  
  protected final void Ed(int paramInt)
  {
    AppMethodBeat.i(111479);
    label37:
    int i;
    int j;
    String str;
    if (paramInt == 0)
    {
      this.rHt.setEnabled(false);
      enableOptionMenu(false);
      if (paramInt != 0) {
        break label102;
      }
      this.rHt.setText(2131759784);
      i = this.rHY;
      j = this.qXm;
      str = this.rGX;
      if (this.rHw != null) {
        break label148;
      }
    }
    label148:
    for (ArrayList localArrayList = null;; localArrayList = this.rHw.rGV)
    {
      updateOptionMenuText(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, paramInt, j, str, localArrayList));
      AppMethodBeat.o(111479);
      return;
      this.rHt.setEnabled(true);
      enableOptionMenu(true);
      break;
      label102:
      this.rHt.setText(getString(2131759784) + "(" + paramInt + ")");
      break label37;
    }
  }
  
  protected boolean a(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(200775);
    if (paramMediaItem == null)
    {
      ad.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
      AppMethodBeat.o(200775);
      return false;
    }
    int i;
    if (this.rHY == 3) {
      if ((paramMediaItem instanceof GalleryItem.VideoMediaItem)) {
        if (("video/hevc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).hsS)) && (com.tencent.mm.plugin.o.f.cPl())) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if ((dp(paramMediaItem.rBp, true)) || (i == 0) || ((!bt.isNullOrNil(((GalleryItem.VideoMediaItem)paramMediaItem).hsT)) && (!"audio/mp4a-latm".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).hsT)))) {}
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label161;
        }
        com.tencent.mm.ui.base.h.ce(this, getString(2131759790));
        AppMethodBeat.o(200775);
        return false;
        if (!"video/avc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).hsS)) {
          break label279;
        }
        i = 1;
        break;
      }
      label161:
      if ((this.rHY == 3) || (this.rHY == 4) || (this.rHY == 14) || (this.rHY == 22))
      {
        if (!new com.tencent.mm.vfs.e(paramMediaItem.rBp).exists())
        {
          com.tencent.mm.ui.base.h.ce(this, getString(2131759808));
          AppMethodBeat.o(200775);
          return false;
        }
        if (com.tencent.mm.plugin.gallery.a.d.abR(paramMediaItem.rBp) > 300)
        {
          com.tencent.mm.ui.base.h.ce(this, getString(2131759810));
          AppMethodBeat.o(200775);
          return false;
        }
        AppMethodBeat.o(200775);
        return true;
      }
      AppMethodBeat.o(200775);
      return true;
      label279:
      i = 0;
    }
  }
  
  protected void abH(String paramString) {}
  
  public final void ag(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111473);
    switch (this.rHZ)
    {
    }
    Object localObject;
    do
    {
      do
      {
        AppMethodBeat.o(111473);
        return;
      } while ((bt.isNullOrNil(this.dpv)) || ("medianote".equals(this.toUser)));
      if (bt.GC() - this.rHR < 1000L)
      {
        ad.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111473);
        return;
      }
      ad.i("MicroMsg.AlbumPreviewUI", "notifyMM switch to SendImgProxyUI");
      localObject = (GalleryItem.MediaItem)this.rHw.rGU.get(paramInt);
    } while (((GalleryItem.MediaItem)localObject).getType() == 2);
    for (;;)
    {
      try
      {
        localObject = ((GalleryItem.MediaItem)localObject).rBp;
        String str = this.toUser;
        if (!this.rHH) {
          if (!this.nMQ)
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
    if (paramLong != this.rIc)
    {
      ad.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.rIc) });
      ad.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(111481);
      return;
    }
    ad.d("MicroMsg.AlbumPreviewUI", "onQueryMediaFinished: %s %s %s.", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.rHw.rGU.size()), Integer.valueOf(paramLinkedList.size()) });
    if ((paramBoolean) || (this.rHw.rGU.size() > paramLinkedList.size()))
    {
      dN(paramLinkedList);
      paramLinkedList = new LinkedList(paramLinkedList);
      if (this.rHw != null) {
        break label338;
      }
    }
    label338:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AlbumPreviewUI", "[onQueryMediaFinished] adapter is null?:%s %s", new Object[] { Boolean.valueOf(bool), bt.eGN().toString() });
      if (this.rHw != null)
      {
        c localc = new c((byte)0);
        localc.rIz = new WeakReference(this.rHw);
        localc.rIA = new WeakReference(this.fpP);
        localc.rIB = new WeakReference(this.rHy);
        localc.rIC = new WeakReference(this.rHs);
        localc.rID = paramLinkedList;
        localc.rHV = this.rHV;
        localc.rIF = paramBoolean;
        if (AlbumPreviewUI.b.rIw == this.rIg) {
          this.rIg = AlbumPreviewUI.b.rIx;
        }
        com.tencent.mm.plugin.gallery.model.e.czi().f(localc);
      }
      AppMethodBeat.o(111481);
      return;
      dN(paramLinkedList.subList(this.rHw.rGU.size(), paramLinkedList.size()));
      break;
    }
  }
  
  protected boolean cqQ()
  {
    int j = 0;
    AppMethodBeat.i(111475);
    ad.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.czo()), Boolean.valueOf(this.rHH) });
    if (this.rHH) {}
    for (int i = 3;; i = 2)
    {
      com.tencent.mm.plugin.gallery.a.d.bd(11610, i + "," + com.tencent.mm.plugin.gallery.model.e.czo());
      if (this.rHT < 0) {
        this.rHT = com.tencent.mm.plugin.gallery.a.d.YK();
      }
      com.tencent.mm.plugin.gallery.model.e.czn();
      if (this.rHw.cAm().size() != 0) {
        break;
      }
      ad.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
      setResult(-2);
      finish();
      AppMethodBeat.o(111475);
      return true;
    }
    Object localObject1 = new Intent();
    i = this.rHZ;
    if (this.rHM) {
      i = 1;
    }
    Object localObject5;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    GalleryItem.MediaItem localMediaItem;
    boolean bool;
    if (22 == com.tencent.mm.plugin.gallery.model.e.czh().jWF)
    {
      localObject5 = this.rHw.rGV;
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      localObject4 = new int[this.qXm];
      localObject5 = ((ArrayList)localObject5).iterator();
      i = j;
      while (((Iterator)localObject5).hasNext())
      {
        localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
        if (localMediaItem.getType() == 1)
        {
          if ((localMediaItem.mMimeType.equals("edit")) && (!bt.isNullOrNil(localMediaItem.rBr))) {
            ((ArrayList)localObject2).add(localMediaItem.rBr);
          }
          for (;;)
          {
            localObject4[i] = 1;
            i += 1;
            break;
            ((ArrayList)localObject2).add(localMediaItem.rBp);
          }
        }
        if (localMediaItem.getType() == 2)
        {
          ((ArrayList)localObject3).add(localMediaItem.rBp);
          localObject4[i] = 2;
          i += 1;
        }
      }
      bool = com.tencent.mm.plugin.gallery.a.d.cAT();
      if ((com.tencent.mm.plugin.recordvideo.activity.a.b.o((List)localObject2, (List)localObject3) == 4) && (bool))
      {
        localObject1 = VLogPreloadUI.rLZ;
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
      if ((this.rHH) || (!this.nMQ))
      {
        bool = true;
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
        localObject3 = this.rHw.rGV;
        localObject2 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label563;
        }
        localObject4 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
        if ((((GalleryItem.MediaItem)localObject4).mMimeType.equals("edit")) && (!bt.isNullOrNil(((GalleryItem.MediaItem)localObject4).rBr)))
        {
          ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).rBr);
          continue;
          bool = false;
          break;
        }
        ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).rBp);
      }
      label563:
      ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
      ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.rHS);
      this.rHS = 0L;
      setResult(-1, (Intent)localObject1);
      if ((!bt.isNullOrNil(this.rGX)) && (this.rGX.equals("album_business_bubble_media_by_coordinate"))) {
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
      }
      if (bt.GC() - this.rHR < 1000L)
      {
        ad.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111475);
        return true;
      }
      ad.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE switch to SendImgProxyUI");
      this.rHR = bt.GC();
      if ((!bt.isNullOrNil(this.dpv)) && (!"medianote".equals(this.toUser)))
      {
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
        ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dpv);
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
      for (i = 0;; i = ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).aVG())
      {
        if (i != 0) {
          break label899;
        }
        ((Intent)localObject1).setData(m.a(getContext(), new com.tencent.mm.vfs.e((String)this.rHw.cAm().get(0))));
        ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", this.rHw.cAm());
        setResult(-1, (Intent)localObject1);
        finish();
        break;
        localObject2 = com.tencent.mm.plugin.gallery.ui.a.a.abP((String)this.rHw.cAm().get(0));
        ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).mSize = this.rHT;
      }
      label899:
      if (i == 2)
      {
        com.tencent.mm.ui.base.h.j(this, 2131764674, 2131759817);
        ad.w("MicroMsg.AlbumPreviewUI", "video is import error");
        AppMethodBeat.o(111475);
        return true;
      }
      com.tencent.mm.ui.base.h.j(this, 2131759816, 2131759817);
      ad.w("MicroMsg.AlbumPreviewUI", "video is over size");
      AppMethodBeat.o(111475);
      return true;
    }
    if (i == 3)
    {
      if ((!bt.isNullOrNil(this.rGX)) && (this.rGX.equals("album_business_bubble_media_by_coordinate")))
      {
        localObject4 = this.rHw.rGV;
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (GalleryItem.MediaItem)((Iterator)localObject4).next();
          if (((GalleryItem.MediaItem)localObject5).getType() == 1)
          {
            if ((((GalleryItem.MediaItem)localObject5).mMimeType.equals("edit")) && (!bt.isNullOrNil(((GalleryItem.MediaItem)localObject5).rBr))) {
              ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).rBr);
            } else {
              ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).rBp);
            }
          }
          else if (((GalleryItem.MediaItem)localObject5).getType() == 2) {
            ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject5).rBp);
          }
        }
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
        ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.rHS);
        ((Intent)localObject1).putExtra("longitude", this.longitude);
        ((Intent)localObject1).putExtra("latitude", this.latitude);
        this.rHS = 0L;
        setResult(-1, (Intent)localObject1);
        finish();
        AppMethodBeat.o(111475);
        return true;
      }
      if (bt.GC() - this.rHR < 1000L)
      {
        ad.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111475);
        return true;
      }
      this.rHR = bt.GC();
      localObject5 = this.rHw.rGV;
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      localObject4 = new int[this.qXm];
      localObject5 = ((ArrayList)localObject5).iterator();
      i = 0;
      label1308:
      if (((Iterator)localObject5).hasNext())
      {
        localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
        if (localMediaItem.getType() == 1)
        {
          if ((localMediaItem.mMimeType.equals("edit")) && (!bt.isNullOrNil(localMediaItem.rBr))) {
            ((ArrayList)localObject3).add(localMediaItem.rBr);
          }
          for (;;)
          {
            localObject4[i] = 1;
            i += 1;
            break;
            ((ArrayList)localObject3).add(localMediaItem.rBp);
          }
        }
        if (localMediaItem.getType() != 2) {
          break label1862;
        }
        ((ArrayList)localObject2).add(localMediaItem.rBp);
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
      if ((this.rHH) || (!this.nMQ)) {}
      for (bool = true;; bool = false)
      {
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
        ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.rHS);
        if (!this.rHH) {
          break label1727;
        }
        if (((ArrayList)localObject2).size() != 0) {
          break;
        }
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.rHS);
        this.rHS = 0L;
        setResult(-1, (Intent)localObject1);
        finish();
        AppMethodBeat.o(111475);
        return true;
      }
      if (com.tencent.mm.plugin.recordvideo.activity.a.b.o((List)localObject3, (List)localObject2) == 4)
      {
        localObject1 = VLogPreloadUI.rLZ;
        VLogPreloadUI.a.a(this, (ArrayList)localObject2, (ArrayList)localObject3, (int[])localObject4);
      }
      for (;;)
      {
        AppMethodBeat.o(111475);
        return true;
        localObject1 = RecordConfigProvider.aj((String)((ArrayList)localObject2).get(0), "", "");
        ((RecordConfigProvider)localObject1).vhQ = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
        ((RecordConfigProvider)localObject1).scene = 2;
        localObject2 = new VideoCaptureReportInfo();
        ((VideoCaptureReportInfo)localObject2).pOf = 1;
        ((RecordConfigProvider)localObject1).vhY = ((VideoCaptureReportInfo)localObject2);
        localObject2 = new UICustomParam.a();
        ((UICustomParam.a)localObject2).Ya();
        ((UICustomParam.a)localObject2).XZ();
        ((UICustomParam.a)localObject2).cO(true);
        ((RecordConfigProvider)localObject1).vhI = ((UICustomParam.a)localObject2).fHa;
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772137, -1, (RecordConfigProvider)localObject1, 2, 0);
      }
      this.rHS = 0L;
      if (((ArrayList)localObject3).size() > 0)
      {
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
        ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dpv);
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
  
  public final boolean dp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(200777);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(200777);
      return true;
    }
    fXS();
    paramString = paramString.trim();
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length()))
    {
      AppMethodBeat.o(200777);
      return true;
    }
    if ((paramBoolean) && (r.zK(paramString)))
    {
      AppMethodBeat.o(200777);
      return true;
    }
    if (!this.rIi.contains(paramString.substring(i).toLowerCase()))
    {
      AppMethodBeat.o(200777);
      return true;
    }
    AppMethodBeat.o(200777);
    return false;
  }
  
  protected void f(final int paramInt, View paramView)
  {
    AppMethodBeat.i(164801);
    Object localObject1 = this.rHw.Eb(paramInt);
    boolean bool1;
    if ((localObject1 == null) || (bt.isNullOrNil(((GalleryItem.MediaItem)localObject1).rBp)))
    {
      if (localObject1 == null) {}
      for (bool1 = true;; bool1 = false)
      {
        ad.w("MicroMsg.AlbumPreviewUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(164801);
        return;
      }
    }
    if ((com.tencent.mm.plugin.gallery.model.e.czh().jWF == 5) && (((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")))
    {
      com.tencent.mm.ui.base.h.cf(getContext(), getString(2131759804));
      AppMethodBeat.o(164801);
      return;
    }
    if (1 == this.rHZ)
    {
      if (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("video"))
      {
        com.tencent.mm.ui.base.h.cf(getContext(), getString(2131759806));
        AppMethodBeat.o(164801);
      }
    }
    else if ((2 == this.rHZ) && (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("image")))
    {
      com.tencent.mm.ui.base.h.cf(getContext(), getString(2131759805));
      AppMethodBeat.o(164801);
      return;
    }
    int i = paramInt - this.rHw.rGY.size();
    ad.d("MicroMsg.AlbumPreviewUI", "onMediaClick, querySource %s item %s.", new Object[] { Integer.valueOf(this.rHY), localObject1 });
    if ((this.rHY == 0) || (this.rHY == 5) || (this.rHY == 10) || (this.rHY == 11))
    {
      if (this.rHZ == 2)
      {
        com.tencent.mm.ui.base.h.a(this, true, getString(2131759818), "", getString(2131755884), getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(179459);
            ad.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.setData(Uri.parse("file://" + Uri.encode(this.rIr.rBp)));
            AlbumPreviewUI.this.setResult(-1, paramAnonymousDialogInterface);
            a.a.rzX.af(this.rIr.rBp, AlbumPreviewUI.k(AlbumPreviewUI.this), paramInt);
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
        paramView.putExtra("video_full_path", ((GalleryItem.MediaItem)localObject1).rBp);
      }
      if (this.rHY == 10) {
        paramView.putExtra("CropImage_OutputPath", ((GalleryItem.MediaItem)localObject1).rBp);
      }
      paramView.setData(Uri.parse(Uri.encode(((GalleryItem.MediaItem)localObject1).rBp)));
      ad.i("MicroMsg.AlbumPreviewUI", "getItem ok");
      setResult(-1, paramView);
      a.a.rzX.af(((GalleryItem.MediaItem)localObject1).rBp, this.ici, paramInt);
      finish();
      AppMethodBeat.o(164801);
      return;
    }
    boolean bool2;
    if (this.rHY == 4)
    {
      bool2 = com.tencent.mm.plugin.gallery.a.d.cAS();
      if ((!bool2) && (((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.rHw.rGV.size() != 0))
      {
        com.tencent.mm.ui.base.h.cf(getContext(), com.tencent.mm.cd.a.aq(getContext(), 2131759774));
        AppMethodBeat.o(164801);
        return;
      }
      if ((bool2) && (com.tencent.mm.plugin.gallery.a.d.V(this.rHw.rGV)))
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
        if ((!"video/hevc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).hsS)) || (!com.tencent.mm.plugin.o.f.cPl())) {
          break label752;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((dp(((GalleryItem.MediaItem)localObject1).rBp, true)) || (i == 0) || ((!bt.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).hsT)) && (!"audio/mp4a-latm".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).hsT))))
      {
        paramView = new f.a(getContext());
        paramView.au(com.tencent.mm.cd.a.aq(getContext(), 2131759790));
        paramView.aMs(com.tencent.mm.cd.a.aq(getContext(), 2131759769));
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
        if (!"video/avc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).hsS)) {
          break label2562;
        }
        i = 1;
        continue;
      }
      if (((GalleryItem.VideoMediaItem)localObject1).hsU >= 300000L)
      {
        localObject1 = new f.a(getContext());
        ((f.a)localObject1).au(paramView);
        ((f.a)localObject1).aMs(com.tencent.mm.cd.a.aq(getContext(), 2131759769));
        ((f.a)localObject1).b(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
        });
        ((f.a)localObject1).show();
        AppMethodBeat.o(164801);
        return;
      }
      label853:
      paramView = RecordConfigProvider.aj(((GalleryItem.MediaItem)localObject1).rBp, "", "");
      paramView.vhQ = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
      paramView.scene = 2;
      Object localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).pOf = 1;
      paramView.vhY = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).Ya();
      ((UICustomParam.a)localObject2).XZ();
      ((UICustomParam.a)localObject2).cO(true);
      paramView.vhI = ((UICustomParam.a)localObject2).fHa;
      a.a.rzX.af(((GalleryItem.MediaItem)localObject1).rBp, this.ici, paramInt);
      this.rIm = ((GalleryItem.MediaItem)localObject1).rBp;
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772137, -1, paramView, 2, 0);
      AppMethodBeat.o(164801);
      return;
      label1004:
      ad.d("leextime", "jump from sns : " + bt.GC());
      if (bool2) {}
      for (paramView = this.rHw.rGU;; paramView = this.rHw.Ea(((GalleryItem.MediaItem)localObject1).getType()))
      {
        com.tencent.mm.plugin.gallery.model.e.Q(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.rHw.cAm());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.rHw.rGV);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        ag(i, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.nMQ);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.rHI);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.rHK);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.rHL);
        ((Intent)localObject2).putExtra("max_select_count", this.qXm);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dpv);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.ici);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
        return;
      }
      if (this.rHY == 14)
      {
        if ((((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.rHw.rGV.size() != 0))
        {
          com.tencent.mm.ui.base.h.cf(getContext(), com.tencent.mm.cd.a.aq(getContext(), 2131759774));
          AppMethodBeat.o(164801);
          return;
        }
        if (((GalleryItem.MediaItem)localObject1).getType() == 1)
        {
          paramView = this.rHw.Ea(((GalleryItem.MediaItem)localObject1).getType());
          com.tencent.mm.plugin.gallery.model.e.Q(paramView);
          localObject2 = new Intent(this, ImagePreviewUI.class);
          ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
          ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
          ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.rHw.cAm());
          ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.rHw.rGV);
          ((Intent)localObject2).putExtra("preview_all", true);
          ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
          ag(i, true);
          ((Intent)localObject2).putExtra("send_raw_img", this.nMQ);
          ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.rHI);
          ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.rHK);
          ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.rHL);
          ((Intent)localObject2).putExtra("max_select_count", this.qXm);
          ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dpv);
          ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject2).putExtra("select_type_tag", this.ici);
          startActivityForResult((Intent)localObject2, 0);
          AppMethodBeat.o(164801);
          return;
        }
        if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
          break label2550;
        }
        paramView = (GalleryItem.VideoMediaItem)localObject1;
        if (paramView.hsU <= 2000)
        {
          ad.i("MicroMsg.AlbumPreviewUI", "select story video, duration too long, duration:%s", new Object[] { Integer.valueOf(paramView.hsU) });
          com.tencent.mm.plugin.report.service.h.vKh.m(1005L, 53L, 1L);
          com.tencent.mm.ui.base.h.cf(getContext(), com.tencent.mm.cd.a.aq(getContext(), 2131759798));
          AppMethodBeat.o(164801);
          return;
        }
        if ((paramView.videoFrameRate <= 1) && (paramView.videoFrameRate >= 0))
        {
          ad.i("MicroMsg.AlbumPreviewUI", "select story video, videoFrameRate too small:%s, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.rBp });
          if (paramView.videoFrameRate > 1) {}
        }
      }
      try
      {
        localObject2 = SightVideoJNI.getSimpleMp4InfoVFS(paramView.rBp);
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
        ad.i("MicroMsg.AlbumPreviewUI", "final videoFrameRate:%s, too small, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.rBp });
        com.tencent.mm.plugin.report.service.h.vKh.m(1005L, 54L, 1L);
        com.tencent.mm.ui.base.h.cf(getContext(), com.tencent.mm.cd.a.aq(getContext(), 2131759790));
        AppMethodBeat.o(164801);
        return;
      }
      ad.i("MicroMsg.AlbumPreviewUI", "maxDuration=%s", new Object[] { Long.valueOf(getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000 + 500) });
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("K_SEGMENTVIDEOPATH", paramView.rBp);
      ((Intent)localObject2).putExtra("KSEGMENTVIDEOTHUMBPATH", paramView.pUe);
      setResult(-1, (Intent)localObject2);
      a.a.rzX.af(((GalleryItem.MediaItem)localObject1).rBp, this.ici, paramInt);
      finish();
      AppMethodBeat.o(164801);
      return;
      if (this.rHM)
      {
        if ((((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.rHw.rGV.size() != 0))
        {
          com.tencent.mm.ui.base.h.cf(getContext(), com.tencent.mm.cd.a.aq(getContext(), 2131759774));
          AppMethodBeat.o(164801);
          return;
        }
        if ((this.rHY == 15) && (((GalleryItem.MediaItem)localObject1).getType() == 2))
        {
          abH(((GalleryItem.MediaItem)localObject1).rBp);
          AppMethodBeat.o(164801);
          return;
        }
        paramView = this.rHw.Ea(((GalleryItem.MediaItem)localObject1).getType());
        com.tencent.mm.plugin.gallery.model.e.Q(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.rHw.cAm());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.rHw.rGV);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        ag(i, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.nMQ);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.rHI);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.rHK);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.rHL);
        if (((GalleryItem.MediaItem)localObject1).getType() == 2) {}
        for (paramInt = 1;; paramInt = this.qXm)
        {
          ((Intent)localObject2).putExtra("max_select_count", paramInt);
          ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dpv);
          ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject2).putExtra("select_type_tag", this.ici);
          startActivityForResult((Intent)localObject2, 0);
          AppMethodBeat.o(164801);
          return;
        }
      }
      com.tencent.mm.plugin.gallery.model.e.Q(this.rHw.rGU);
      paramView = new Intent(this, ImagePreviewUI.class);
      paramView.putStringArrayListExtra("preview_image_list", this.rHw.cAm());
      paramView.putParcelableArrayListExtra("preview_media_item_list", this.rHw.rGV);
      paramView.putExtra("preview_all", true);
      paramView.putExtra("preview_position", i);
      ag(i, true);
      paramView.putExtra("send_raw_img", this.nMQ);
      paramView.putExtra("key_force_hide_edit_image_button", this.rHI);
      paramView.putExtra("key_force_show_raw_image_button", this.rHK);
      paramView.putExtra("key_is_raw_image_button_disable", this.rHL);
      paramView.putExtra("max_select_count", this.qXm);
      paramView.putExtra("GalleryUI_FromUser", this.dpv);
      paramView.putExtra("GalleryUI_ToUser", this.toUser);
      paramView.putExtra("album_business_tag", this.rGX);
      paramView.putExtra("album_video_max_duration", this.iBF);
      paramView.putExtra("album_video_min_duration", this.rHU);
      if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 14) {
        paramView.putExtra("key_edit_video_max_time_length", 300500);
      }
      paramView.putExtra("select_type_tag", this.ici);
      startActivityForResult(paramView, 0);
      label2550:
      AppMethodBeat.o(164801);
      return;
      label2562:
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
    this.rGX = getIntent().getStringExtra("album_business_tag");
    this.iBF = getIntent().getIntExtra("album_video_max_duration", 10);
    this.rHU = getIntent().getIntExtra("album_video_min_duration", 0);
    this.dpv = getIntent().getStringExtra("GalleryUI_FromUser");
    this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
    this.qXm = getIntent().getIntExtra("max_select_count", 9);
    boolean bool;
    if (this.rHY == 4)
    {
      bool = true;
      this.rHH = bool;
      this.rHD = getIntent().getStringExtra("folder_path");
      this.rHE = getIntent().getStringExtra("folder_name");
      if (bt.isNullOrNil(this.rHD))
      {
        ad.w("MicroMsg.AlbumPreviewUI", "folder path invalid, assign folderName: %s.", new Object[] { this.rHE });
        this.rHD = this.rHE;
      }
      if ((!getIntent().getBooleanExtra("key_send_raw_image", false)) && (!getIntent().getBooleanExtra("send_raw_img", false))) {
        break label1738;
      }
      bool = true;
      label294:
      this.nMQ = bool;
      this.rHI = getIntent().getBooleanExtra("key_force_hide_edit_image_button", false);
      this.rHJ = getIntent().getBooleanExtra("key_force_hide_edit_image_button_after_album_take_image", false);
      this.rHK = getIntent().getBooleanExtra("key_force_show_raw_image_button", false);
      this.rHL = getIntent().getBooleanExtra("key_is_raw_image_button_disable", false);
      this.rHM = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
      this.rHB = ((TextView)findViewById(2131303091));
      this.rHC = ((ImageButton)findViewById(2131303090));
      this.rHB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111434);
          AlbumPreviewUI.c(AlbumPreviewUI.this).performClick();
          AppMethodBeat.o(111434);
        }
      });
      if ((this.rHY != 3) && (!this.rHK)) {
        break label1744;
      }
      this.rHC.setVisibility(0);
      this.rHB.setVisibility(0);
      label449:
      if (!this.nMQ) {
        break label1765;
      }
      this.rHC.setImageResource(2131691078);
      label466:
      if (this.rHL) {
        this.rHC.setImageResource(2131691075);
      }
      localObject1 = this.rHC;
      if (this.rHL) {
        break label1778;
      }
      bool = true;
      label499:
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.rHB;
      if (this.rHL) {
        break label1784;
      }
      bool = true;
      label522:
      ((TextView)localObject1).setEnabled(bool);
      this.rHC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111435);
          paramAnonymousView = AlbumPreviewUI.this;
          boolean bool;
          if (!AlbumPreviewUI.this.nMQ)
          {
            bool = true;
            paramAnonymousView.nMQ = bool;
            AlbumPreviewUI.d(AlbumPreviewUI.this);
            AlbumPreviewUI.e(AlbumPreviewUI.this).setText(AlbumPreviewUI.this.getContext().getString(2131759782).concat(AlbumPreviewUI.cAx()));
            if (!AlbumPreviewUI.this.nMQ) {
              break label102;
            }
            AlbumPreviewUI.c(AlbumPreviewUI.this).setImageResource(2131691078);
          }
          for (;;)
          {
            AlbumPreviewUI.f(AlbumPreviewUI.this);
            AppMethodBeat.o(111435);
            return;
            bool = false;
            break;
            label102:
            AlbumPreviewUI.c(AlbumPreviewUI.this).setImageResource(2131691077);
          }
        }
      });
      this.rHs = ((RecyclerView)findViewById(2131302210));
      this.rHx = ((TextView)findViewById(2131296624));
      this.rHy = ((TextView)findViewById(2131296625));
      this.rHz = ((TextView)findViewById(2131296597));
      this.rHt = ((TextView)findViewById(2131302218));
      if (1 != ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puh, 0)) {
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
      ad.i("MicroMsg.AlbumPreviewUI", "pennqin, isFromSmartGallery: %s showSmartGallery: %s.", new Object[] { Boolean.valueOf(this.rHX), Boolean.valueOf(bool) });
      if ((!this.rHX) && ((bool) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)))
      {
        addTextOptionMenu(1, null, this.rId, null, r.b.FOO);
        if (this.rIa) {
          cAt();
        }
      }
      if ((this.rHY != 0) && (this.rHY != 5) && (this.rHY != 10) && (this.rHY != 11) && (this.rHY != 24)) {
        break label1892;
      }
      findViewById(2131296568).setVisibility(8);
      localObject1 = (FrameLayout.LayoutParams)this.rHs.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = 0;
      this.rHs.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      label827:
      this.rHA = ((ImageFolderMgrView)findViewById(2131300928));
      this.rHA.setListener(new ImageFolderMgrView.a()
      {
        public final void c(GalleryItem.AlbumItem paramAnonymousAlbumItem)
        {
          AppMethodBeat.i(111437);
          AlbumPreviewUI.a(AlbumPreviewUI.this, paramAnonymousAlbumItem);
          AppMethodBeat.o(111437);
        }
      });
      this.rHA.setOnFolderStateChanged(new ImageFolderMgrView.b()
      {
        public final void lF(boolean paramAnonymousBoolean)
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
              if (!bt.by(AlbumPreviewUI.o(AlbumPreviewUI.this), "").equals(AlbumPreviewUI.n(AlbumPreviewUI.this).rBh))
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
      localObject2 = this.rHA;
      bool = this.rIa;
      ad.i("MicroMsg.ImageFolderMgrView", "attach, %s.", new Object[] { localObject2 });
      com.tencent.mm.plugin.gallery.model.e.czh().b((i.a)localObject2);
      com.tencent.mm.plugin.gallery.model.e.czh().a((i.a)localObject2);
      com.tencent.mm.plugin.gallery.model.e.czh().c(((ImageFolderMgrView)localObject2).rJA);
      localObject1 = com.tencent.mm.plugin.gallery.model.e.czh();
      localObject2 = ((ImageFolderMgrView)localObject2).rJA;
      ((o)localObject1).rBC.add(localObject2);
      if (bool) {
        com.tencent.mm.plugin.gallery.model.e.czh().czP();
      }
      this.rHF = getIntent().getStringExtra("send_btn_string");
      this.rHG = getIntent().getBooleanExtra("is_hide_album_footer", false);
      if (this.rHG) {
        findViewById(2131296568).setVisibility(8);
      }
      enableOptionMenu(false);
      getContext();
      localObject1 = new GridLayoutManager(4);
      this.rHs.setLayoutManager((RecyclerView.i)localObject1);
      localObject2 = new c.a(getContext());
      ((c.a)localObject2).rIZ = ((c.a)localObject2).mResources.getDimensionPixelSize(2131166400);
      ((c.a)localObject2).rJa = ((c.a)localObject2).mResources.getDimensionPixelSize(2131166400);
      ((c.a)localObject2).mColor = android.support.v4.content.b.n(((c.a)localObject2).mContext, 2131100399);
      ((c.a)localObject2).rIY = false;
      localObject2 = new c(((c.a)localObject2).rIZ, ((c.a)localObject2).rJa, ((c.a)localObject2).mColor, ((c.a)localObject2).rIY, (byte)0);
      this.rHs.a((RecyclerView.h)localObject2);
      this.rHs.a(new RecyclerView.m()
      {
        private Runnable nNr;
        
        private String cAA()
        {
          AppMethodBeat.i(111442);
          String str = AlbumPreviewUI.this.rHw.Ec(this.rIs.jO());
          if ((!bt.isNullOrNil(str)) && (str.equals("album_business_bubble_media_by_coordinate")))
          {
            str = AlbumPreviewUI.q(AlbumPreviewUI.this) + "附近的照片和视频";
            AppMethodBeat.o(111442);
            return str;
          }
          AppMethodBeat.o(111442);
          return str;
        }
        
        private void lG(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(111443);
          if (paramAnonymousBoolean)
          {
            AlbumPreviewUI.p(AlbumPreviewUI.this).removeCallbacks(this.nNr);
            if (AlbumPreviewUI.p(AlbumPreviewUI.this).getVisibility() != 0)
            {
              String str = cAA();
              AlbumPreviewUI.p(AlbumPreviewUI.this).setText(str);
              AlbumPreviewUI.p(AlbumPreviewUI.this).setVisibility(0);
              AlbumPreviewUI.p(AlbumPreviewUI.this).setAlpha(0.0F);
              AlbumPreviewUI.p(AlbumPreviewUI.this).animate().alpha(1.0F).setDuration(300L).start();
              AppMethodBeat.o(111443);
            }
          }
          else
          {
            AlbumPreviewUI.p(AlbumPreviewUI.this).removeCallbacks(this.nNr);
            AlbumPreviewUI.p(AlbumPreviewUI.this).postDelayed(this.nNr, 256L);
          }
          AppMethodBeat.o(111443);
        }
        
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(111445);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
          paramAnonymousRecyclerView = cAA();
          AlbumPreviewUI.p(AlbumPreviewUI.this).setText(paramAnonymousRecyclerView);
          paramAnonymousInt1 = this.rIs.jO();
          int i = this.rIs.jQ();
          ad.d("MicroMsg.AlbumPreviewUI", "pennqin, onScrolled, %s %s %s %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(i), Integer.valueOf(AlbumPreviewUI.s(AlbumPreviewUI.this)), Integer.valueOf(AlbumPreviewUI.t(AlbumPreviewUI.this)) });
          if ((AlbumPreviewUI.s(AlbumPreviewUI.this) != paramAnonymousInt1) || (AlbumPreviewUI.t(AlbumPreviewUI.this) != i))
          {
            AlbumPreviewUI.a(AlbumPreviewUI.this, paramAnonymousInt1);
            AlbumPreviewUI.b(AlbumPreviewUI.this, i);
            paramAnonymousRecyclerView = new ArrayList();
            paramAnonymousInt1 = AlbumPreviewUI.s(AlbumPreviewUI.this);
            while (paramAnonymousInt1 <= AlbumPreviewUI.t(AlbumPreviewUI.this))
            {
              localObject = AlbumPreviewUI.this.rHw.Eb(paramAnonymousInt1);
              if (localObject != null) {
                paramAnonymousRecyclerView.add(com.tencent.mm.plugin.gallery.a.d.a(((GalleryItem.MediaItem)localObject).anX(), null, -1));
              }
              paramAnonymousInt1 += 1;
            }
            ad.d("MicroMsg.AlbumPreviewUI", "cancelTask, legalPaths size: %s.", new Object[] { Integer.valueOf(paramAnonymousRecyclerView.size()) });
            com.tencent.mm.plugin.gallery.model.e.czg().dJ(paramAnonymousRecyclerView);
            if (paramAnonymousInt2 != 0)
            {
              if (paramAnonymousInt2 >= 0) {
                break label381;
              }
              AlbumPreviewUI.a(AlbumPreviewUI.this, p.c.rBS);
            }
          }
          for (;;)
          {
            ad.d("MicroMsg.AlbumPreviewUI", "onScrolled, dy: %s state: %s.", new Object[] { Integer.valueOf(paramAnonymousInt2), AlbumPreviewUI.v(AlbumPreviewUI.this) });
            paramAnonymousRecyclerView = com.tencent.mm.plugin.gallery.model.p.rBO;
            com.tencent.mm.plugin.gallery.model.p.czR().a(AlbumPreviewUI.v(AlbumPreviewUI.this), AlbumPreviewUI.s(AlbumPreviewUI.this), AlbumPreviewUI.t(AlbumPreviewUI.this), AlbumPreviewUI.this.rHw.rGU.size());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(111445);
            return;
            label381:
            AlbumPreviewUI.a(AlbumPreviewUI.this, p.c.rBT);
          }
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(111444);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
          ad.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (1 == paramAnonymousInt)
          {
            lG(true);
            AlbumPreviewUI.r(AlbumPreviewUI.this).setVisibility(8);
            com.tencent.mm.plugin.gallery.model.e.czg().czb();
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
              lG(false);
              AlbumPreviewUI.a(AlbumPreviewUI.this, this.rIs.jO());
              AlbumPreviewUI.b(AlbumPreviewUI.this, this.rIs.jQ());
              ad.d("MicroMsg.AlbumPreviewUI", "cancelTask logic, firstVisibleItem: %s lastVisibleItem: %s.", new Object[] { Integer.valueOf(AlbumPreviewUI.s(AlbumPreviewUI.this)), Integer.valueOf(AlbumPreviewUI.t(AlbumPreviewUI.this)) });
              paramAnonymousRecyclerView = com.tencent.mm.plugin.gallery.model.p.rBO;
              com.tencent.mm.plugin.gallery.model.p.czR().a(p.c.rBR, AlbumPreviewUI.s(AlbumPreviewUI.this), AlbumPreviewUI.t(AlbumPreviewUI.this), AlbumPreviewUI.this.rHw.rGU.size());
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
      this.rHw = new a(getContext(), new a.e()
      {
        public final void ab(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(111446);
          Object localObject = AlbumPreviewUI.this.rHw.Eb(paramAnonymousInt2);
          if (localObject == null)
          {
            AppMethodBeat.o(111446);
            return;
          }
          if (paramAnonymousInt3 == 0) {
            if (((GalleryItem.MediaItem)localObject).getType() == 1)
            {
              a.a.rzX.af(((GalleryItem.MediaItem)localObject).rBp, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.a(AlbumPreviewUI.this, (GalleryItem.MediaItem)localObject);
              AlbumPreviewUI.this.Ed(paramAnonymousInt1);
              AlbumPreviewUI.this.ag(paramAnonymousInt2, true);
            }
          }
          while (bt.gL(AlbumPreviewUI.this.rHw.cAm()))
          {
            AppMethodBeat.o(111446);
            return;
            if (((GalleryItem.MediaItem)localObject).getType() == 2)
            {
              if (!AlbumPreviewUI.this.a((GalleryItem.MediaItem)localObject))
              {
                AlbumPreviewUI.this.rHw.g((GalleryItem.MediaItem)localObject);
              }
              else
              {
                a.a.rzX.af(((GalleryItem.MediaItem)localObject).rBp, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
                AlbumPreviewUI.this.Ed(paramAnonymousInt1);
                AlbumPreviewUI.this.ag(paramAnonymousInt2, true);
              }
            }
            else
            {
              a.a.rzX.af(((GalleryItem.MediaItem)localObject).rBp, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.Ed(paramAnonymousInt1);
              AlbumPreviewUI.this.ag(paramAnonymousInt2, true);
              continue;
              a.a.rzX.af(((GalleryItem.MediaItem)localObject).rBp, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.Ed(paramAnonymousInt1);
              AlbumPreviewUI.this.ag(paramAnonymousInt2, false);
            }
          }
          localObject = AlbumPreviewUI.this.rHw.cAm().iterator();
          while (((Iterator)localObject).hasNext()) {
            if (!t.aFm((String)((Iterator)localObject).next()))
            {
              AppMethodBeat.o(111446);
              return;
            }
          }
          AlbumPreviewUI.this.nMQ = true;
          AppMethodBeat.o(111446);
        }
      });
      this.rHw.rHc = this.rHc;
      if (!bt.isNullOrNil(this.rGX))
      {
        ad.d("MicroMsg.AlbumPreviewUI", "businessTag=%s", new Object[] { this.rGX });
        this.rHw.rGX = this.rGX;
        this.rHw.iBF = this.iBF;
        if (this.rGX.equals("album_business_bubble_media_by_coordinate"))
        {
          this.rHw.rGZ = false;
          com.tencent.mm.plugin.gallery.model.e.czh().rBF.cyT();
          this.rHV = getIntent().getStringExtra("album_business_bubble_media_by_coordinate_posname");
          final double d = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_distance", -1.0D);
          this.longitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 181.0D);
          this.latitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 91.0D);
          if ((d >= 0.0D) && (com.tencent.mm.modelgeo.a.l(this.longitude)) && (com.tencent.mm.modelgeo.a.m(this.latitude)))
          {
            this.rHW = new i.b()
            {
              public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong)
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
                  if (TencentLocationUtils.distanceBetween(AlbumPreviewUI.y(AlbumPreviewUI.this), AlbumPreviewUI.x(AlbumPreviewUI.this), localMediaItem.bPI, localMediaItem.bPJ) <= d)
                  {
                    localMediaItem.rBv = "album_business_bubble_media_by_coordinate";
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
            localObject1 = com.tencent.mm.plugin.gallery.model.e.czh();
            localObject2 = this.rHW;
            if (localObject2 != null) {
              ((o)localObject1).rBE.add(localObject2);
            }
          }
        }
      }
      if (this.rHM) {
        this.rHw.rGZ = true;
      }
      this.rIf = new a.b();
      if (getIntent().getBooleanExtra("show_header_view", true)) {
        this.rHw.a(this.rIf);
      }
      this.rHw.rBG = this.rHZ;
      this.rHw.rGT = this.qXm;
      ad.i("MicroMsg.AlbumPreviewUI", "limit count = " + this.qXm);
      this.rHs.setAdapter(this.rHw);
      if (!this.rHX) {
        break label2115;
      }
      setActionbarColor(getResources().getColor(2131100399));
      setMMTitle(getIntent().getStringExtra("title_from_smart_gallery"));
      label1551:
      setNavigationbarColor(getResources().getColor(2131100399));
      setActionBarOperationAreaClickListener(new AlbumChooserView.a()
      {
        public final void cAz()
        {
          AppMethodBeat.i(179457);
          ad.i("MicroMsg.AlbumPreviewUI", "onAlbumChooserViewClick.");
          AlbumPreviewUI.a(AlbumPreviewUI.this, null);
          a.a.rzX.rzL = 1;
          ad.d("MicroMsg.AlbumPreviewUI", "click folder times: [%d].", new Object[] { Integer.valueOf(AlbumPreviewUI.B(AlbumPreviewUI.this)) });
          AlbumPreviewUI.C(AlbumPreviewUI.this);
          AlbumPreviewUI.this.playActionBarOperationAreaAnim();
          AlbumPreviewUI.m(AlbumPreviewUI.this).cAB();
          AppMethodBeat.o(179457);
        }
      });
      if (!this.rHX) {
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
          AlbumPreviewUI.this.setResult(-2, AlbumPreviewUI.this.getIntent().putExtra("send_raw_img", AlbumPreviewUI.this.nMQ));
          if ((AlbumPreviewUI.m(AlbumPreviewUI.this) != null) && (AlbumPreviewUI.m(AlbumPreviewUI.this).gX))
          {
            AlbumPreviewUI.m(AlbumPreviewUI.this).cAB();
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
          public final void cAy()
          {
            AppMethodBeat.i(111425);
            com.tencent.mm.plugin.gallery.a.d.cAy();
            if (AlbumPreviewUI.this.rHO) {
              AlbumPreviewUI.this.rHO = false;
            }
            AppMethodBeat.o(111425);
          }
        });
      }
      this.rIb = new e((byte)0);
      this.rIb.rIz = new WeakReference(this.rHw);
      this.rIb.rIA = new WeakReference(this.fpP);
      this.rIb.rIE = new WeakReference(this.rHA);
      this.rIb.idList = this.idList;
      this.rIb.type = this.rHZ;
      AppMethodBeat.o(111474);
      return;
      bool = false;
      break;
      label1738:
      bool = false;
      break label294;
      label1744:
      this.rHC.setVisibility(8);
      this.rHB.setVisibility(8);
      break label449;
      label1765:
      this.rHC.setImageResource(2131691077);
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
      localObject1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pui, "");
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
      this.rHt.setVisibility(0);
      this.rHt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164797);
          AlbumPreviewUI.g(AlbumPreviewUI.this);
          paramAnonymousView = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
          com.tencent.mm.plugin.gallery.model.e.Q(AlbumPreviewUI.this.rHw.rGU);
          paramAnonymousView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.rHw.cAm());
          paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", AlbumPreviewUI.this.rHw.rGV);
          paramAnonymousView.putExtra("max_select_count", AlbumPreviewUI.this.qXm);
          paramAnonymousView.putExtra("send_raw_img", AlbumPreviewUI.this.nMQ);
          paramAnonymousView.putExtra("key_force_hide_edit_image_button", AlbumPreviewUI.h(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("key_force_show_raw_image_button", AlbumPreviewUI.i(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("key_is_raw_image_button_disable", AlbumPreviewUI.j(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.dpv);
          paramAnonymousView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
          paramAnonymousView.putExtra("select_type_tag", AlbumPreviewUI.k(AlbumPreviewUI.this));
          AlbumPreviewUI.this.startActivityForResult(paramAnonymousView, 0);
          AppMethodBeat.o(164797);
        }
      });
      if (((this.rHZ != 1) && (this.rHZ != 2) && (this.rHZ != 3)) || (this.qXm <= 0)) {
        break label827;
      }
      if (!bt.isNullOrNil(this.rHF))
      {
        addTextOptionMenu(0, this.rHF, this.rId);
        break label827;
      }
      if (this.rHY == 15)
      {
        i = this.rHY;
        j = this.qXm;
        localObject2 = this.rGX;
        if (this.rHw == null) {}
        for (localObject1 = null;; localObject1 = this.rHw.rGV)
        {
          addTextOptionMenu(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, 0, j, (String)localObject2, (ArrayList)localObject1), this.rId, null, r.b.FOL);
          break;
        }
      }
      i = this.rHY;
      int j = this.qXm;
      localObject2 = this.rGX;
      if (this.rHw == null) {}
      for (localObject1 = null;; localObject1 = this.rHw.rGV)
      {
        addTextOptionMenu(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, 0, j, (String)localObject2, (ArrayList)localObject1), this.rId, null, r.b.FON);
        break;
      }
      label2115:
      initActionBarOperationArea();
      setActionbarColor(getResources().getColor(2131100399));
      if (this.rHZ == 3)
      {
        initActionBarOperationAreaTxt(getString(2131759758));
        break label1551;
      }
      if (this.rHZ == 1)
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
      localObject1 = com.tencent.mm.pluginsdk.ui.tools.q.h(getContext().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.ais());
      if (bt.isNullOrNil((String)localObject1))
      {
        ad.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
        AppMethodBeat.o(111478);
        return;
      }
      ad.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[] { localObject1 });
      if ((this.rHY == 0) || (this.rHY == 5) || (this.rHY == 11) || (this.rHY == 24))
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
            this.rHz.setVisibility(0);
            this.rHz.setText(getString(2131761897));
            localObject1 = AnimationUtils.loadAnimation(getContext(), 2130772047);
            this.rHz.startAnimation((Animation)localObject1);
            ((Animation)localObject1).setAnimationListener(new Animation.AnimationListener()
            {
              private Runnable rIp;
              
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                AppMethodBeat.i(111428);
                AlbumPreviewUI.A(AlbumPreviewUI.this).setVisibility(0);
                AlbumPreviewUI.A(AlbumPreviewUI.this).postDelayed(this.rIp, 4000L);
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
        ((Intent)localObject1).putExtra("send_raw_img", this.nMQ);
        if ((this.rHI) || (this.rHJ)) {}
        for (bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("key_force_hide_edit_image_button", bool);
          ((Intent)localObject1).putExtra("key_force_show_raw_image_button", this.rHK);
          ((Intent)localObject1).putExtra("key_is_raw_image_button_disable", this.rHL);
          ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
          if (this.rHw != null) {
            ((Intent)localObject1).putParcelableArrayListExtra("preview_media_item_list", this.rHw.rGV);
          }
          ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dpv);
          ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject1).putExtra("select_type_tag", this.ici);
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
          this.rHO = true;
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
          if ((paramIntent.vhz.booleanValue()) && (!bt.isNullOrNil(paramIntent.thumbPath)))
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
          localObject3 = paramIntent.tAR;
          if (!bt.isNullOrNil((String)localObject3))
          {
            ((ArrayList)localObject2).add(localObject3);
            ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
          }
          if ((paramIntent.tAP) && (!bt.isNullOrNil(paramIntent.tAX)))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramIntent.tAX);
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
              setMMTitle(bt.by(((GalleryItem.AlbumItem)localObject1).rBh, getString(2131759758)));
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
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).dhD().w("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
              this.rHv = true;
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
              if (bt.isNullOrNil(this.rIm)) {
                break;
              }
              localObject2 = a.a.rzX;
              localObject3 = this.rIm;
              ad.i("MicroMsg.GalleryReporter", "path: %s.", new Object[] { localObject3 });
              localObject1 = paramIntent;
              if (bt.isNullOrNil((String)localObject3)) {
                break;
              }
              ((com.tencent.mm.plugin.gallery.a)localObject2).rzR.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).rzS.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).rzT.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).rzU.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).rzV.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).rzW.remove(localObject3);
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
              this.nMQ = paramIntent.getBooleanExtra("send_raw_img", this.nMQ);
              if (this.nMQ)
              {
                this.rHC.setImageResource(2131691078);
                if (this.rHL) {
                  this.rHC.setImageResource(2131691075);
                }
                localObject2 = this.rHC;
                if (this.rHL) {
                  break label1896;
                }
                bool = true;
                ((ImageButton)localObject2).setEnabled(bool);
                localObject2 = this.rHB;
                if (this.rHL) {
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
                this.rHC.setImageResource(2131691077);
                break;
                bool = false;
                break label1784;
              }
            }
            if ((-2 == paramInt2) || (paramInt2 == 0) || (SmartGalleryUI.rLy == paramInt2))
            {
              ad.i("MicroMsg.AlbumPreviewUI", "just back from SmartGalleryUI.");
              paramIntent = new android.support.v4.e.b();
              paramInt1 = i;
              while (paramInt1 < this.rHw.rGV.size())
              {
                localObject1 = (GalleryItem.MediaItem)this.rHw.rGV.get(paramInt1);
                i = this.rHw.rGU.indexOf(localObject1);
                if (i != -1) {
                  paramIntent.add(Integer.valueOf(i));
                }
                paramInt1 += 1;
              }
              this.rHw.dM(s.czT().rCa);
              if (SmartGalleryUI.rLy == paramInt2)
              {
                cqQ();
                AppMethodBeat.o(111478);
                return;
              }
              Ed(this.rHw.rGV.size());
              this.rHw.a(paramIntent);
              AppMethodBeat.o(111478);
              return;
            }
            if (-1 == paramInt2) {
              this.rHv = true;
            }
            setResult(paramInt2, paramIntent);
            finish();
            localObject1 = paramIntent;
          }
          else if (paramInt1 == 4381)
          {
            if (paramInt2 == -1)
            {
              if (this.rHH)
              {
                paramIntent = RecordConfigProvider.id("", "");
                paramIntent.vhQ = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
                paramIntent.scene = 2;
                localObject1 = new VideoCaptureReportInfo();
                ((VideoCaptureReportInfo)localObject1).pOf = 1;
                paramIntent.vhY = ((VideoCaptureReportInfo)localObject1);
                localObject1 = new UICustomParam.a();
                ((UICustomParam.a)localObject1).Ya();
                ((UICustomParam.a)localObject1).XZ();
                ((UICustomParam.a)localObject1).cO(true);
                paramIntent.vhI = ((UICustomParam.a)localObject1).fHa;
                paramIntent.bx(3, VLogPreviewPluginLayout.class.getName());
                paramIntent.bx(4, VLogPreviewPluginLayout.class.getName());
                localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772137, -1, paramIntent, 4, 0);
                AppMethodBeat.o(111478);
                return;
              }
              localObject1 = paramIntent;
              if (22 == com.tencent.mm.plugin.gallery.model.e.czh().jWF)
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
                ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", this.rHw.cAm());
              }
              ((Intent)localObject1).putStringArrayListExtra("key_select_image_list", ((Intent)localObject1).getStringArrayListExtra("CropImage_OutputPath_List"));
              ad.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
              this.rHv = true;
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
      if ((localObject1 == null) || (this.rHw == null)) {
        break label2612;
      }
      localObject2 = new android.support.v4.e.b();
      paramInt1 = 0;
      while (paramInt1 < this.rHw.rGV.size())
      {
        localObject3 = (GalleryItem.MediaItem)this.rHw.rGV.get(paramInt1);
        paramInt2 = this.rHw.rGU.indexOf(localObject3);
        if (paramInt2 != -1) {
          ((android.support.v4.e.b)localObject2).add(Integer.valueOf(paramInt2));
        }
        paramInt1 += 1;
      }
    }
    this.rHw.S((ArrayList)localObject1);
    this.rHw.a((android.support.v4.e.b)localObject2);
    Ed(((ArrayList)localObject1).size());
    label2612:
    if (!paramIntent.getBooleanExtra("CropImage_Compress_Img", true))
    {
      bool = true;
      label2626:
      this.nMQ = bool;
      if (!this.nMQ) {
        break label2724;
      }
      this.rHC.setImageResource(2131691078);
      label2649:
      if (this.rHL) {
        this.rHC.setImageResource(2131691075);
      }
      localObject1 = this.rHC;
      if (this.rHL) {
        break label2737;
      }
      bool = true;
      label2682:
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.rHB;
      if (this.rHL) {
        break label2743;
      }
    }
    label2724:
    label2737:
    label2743:
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject1).setEnabled(bool);
      localObject1 = paramIntent;
      break;
      bool = false;
      break label2626;
      this.rHC.setImageResource(2131691077);
      break label2649;
      bool = false;
      break label2682;
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
    this.rIa = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, str1, str2);
    ad.d("MicroMsg.AlbumPreviewUI", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(this.rIa) });
    this.rHS = System.currentTimeMillis();
    start = System.currentTimeMillis();
    this.fpP = com.tencent.mm.ui.base.p.a(this, getString(2131755936), false);
    this.rIg = AlbumPreviewUI.b.rIw;
    if (paramBundle != null)
    {
      ad.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
      this.rHY = paramBundle.getInt("constants_key_query_source");
    }
    for (this.rHZ = paramBundle.getInt("constants_key_query_type");; this.rHZ = getIntent().getIntExtra("query_media_type", 1))
    {
      com.tencent.mm.plugin.gallery.model.e.czh().jWF = this.rHY;
      com.tencent.mm.plugin.gallery.model.e.czh().setQueryType(this.rHZ);
      ad.i("MicroMsg.AlbumPreviewUI", "query source: " + this.rHY + ", queryType: " + this.rHZ);
      this.ici = getIntent().getIntExtra("select_type_tag", 3);
      this.oqY = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqd, true);
      this.rHX = getIntent().getBooleanExtra("is_from_smart_gallery", false);
      initView();
      if (this.rIa) {
        cAu();
      }
      com.tencent.mm.plugin.gallery.model.e.czp();
      AppMethodBeat.o(111464);
      return;
      this.rHY = getIntent().getIntExtra("query_source_type", 3);
    }
  }
  
  public void onDestroy()
  {
    boolean bool1 = false;
    AppMethodBeat.i(111469);
    super.onDestroy();
    ad.i("MicroMsg.AlbumPreviewUI", "onDestroy, %s.", new Object[] { this });
    if (com.tencent.mm.plugin.gallery.model.e.czh() != null)
    {
      com.tencent.mm.plugin.gallery.model.e.czh().rBD.remove(this);
      o localo = com.tencent.mm.plugin.gallery.model.e.czh();
      i.b localb = this.rHW;
      if (localb != null) {
        localo.rBE.remove(localb);
      }
    }
    if ((this.rHP > 0) || (this.rHQ > 0))
    {
      ad.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", new Object[] { Integer.valueOf(this.rHP), Integer.valueOf(this.rHQ) });
      com.tencent.mm.plugin.gallery.a.d.bd(11187, this.rHP + "," + this.rHQ);
    }
    for (;;)
    {
      if ((this.rHR > 0L) || (this.rHv)) {
        com.tencent.mm.plugin.gallery.model.e.a(this.rHF, T(this.rHw.rGV), this.nMQ, this.rHu);
      }
      int i = this.rHw.rGV.size();
      boolean bool2 = this.nMQ;
      if ((this.rHR > 0L) || (this.rHv)) {
        bool1 = true;
      }
      com.tencent.mm.plugin.gallery.model.e.e(i, bool2, bool1);
      y.cJB.IO().IN();
      com.tencent.mm.plugin.gallery.model.e.czk().clear();
      com.tencent.mm.plugin.gallery.model.e.czl().clear();
      com.tencent.mm.plugin.gallery.model.e.czm().clear();
      if (!this.rHX) {
        break;
      }
      s.czT().rBY = true;
      if (com.tencent.mm.plugin.gallery.model.e.czq())
      {
        com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.gEx).adg();
        a.g.cAq();
      }
      AppMethodBeat.o(111469);
      return;
      ad.d("MicroMsg.AlbumPreviewUI", "not click camera or folder.");
    }
    if (!this.iwN) {
      a.a.rzX.report();
    }
    for (;;)
    {
      s.czT().rBZ = true;
      com.tencent.mm.plugin.gallery.model.e.czh().czQ();
      break;
      a.a.rzX.reset();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111477);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      ad.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
      setResult(-2);
      if ((this.rHA != null) && (this.rHA.gX))
      {
        this.rHA.cAB();
        playActionBarOperationAreaAnim();
        AppMethodBeat.o(111477);
        return true;
      }
      this.iwN = true;
      finish();
      AppMethodBeat.o(111477);
      return true;
    }
    if (paramInt == 82)
    {
      this.rHQ += 1;
      if (this.rHA != null) {
        this.rHA.cAB();
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
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    this.rHN = true;
    ImageFolderMgrView localImageFolderMgrView;
    if ((!isFinishing()) && (!isDestroyed()) && (this.rHA != null) && (this.rHA.gX))
    {
      localImageFolderMgrView = this.rHA;
      if (localImageFolderMgrView.gX) {
        break label132;
      }
      ad.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
    }
    for (;;)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, this.foV);
      this.foV = 0;
      if (this.rHX) {
        s.czT().dL(this.rHw.rGV);
      }
      AppMethodBeat.o(111467);
      return;
      label132:
      if (localImageFolderMgrView.rJz)
      {
        ad.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
      }
      else
      {
        localImageFolderMgrView.rJv.setVisibility(8);
        localImageFolderMgrView.gX = false;
        if (localImageFolderMgrView.rJD != null) {
          localImageFolderMgrView.rJD.lF(false);
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
        cAv();
        AppMethodBeat.o(111483);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131759760), false, new AlbumPreviewUI.6(this), null);
      AppMethodBeat.o(111483);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cAt();
        com.tencent.mm.plugin.gallery.model.e.czh().czP();
        cAu();
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
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    this.rHN = false;
    AppMethodBeat.o(111465);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(111470);
    super.onSaveInstanceState(paramBundle);
    ad.i("MicroMsg.AlbumPreviewUI", "onSaveInstanceState, %s.", new Object[] { this });
    paramBundle.putInt("constants_key_query_source", this.rHY);
    paramBundle.putInt("constants_key_query_type", this.rHZ);
    AppMethodBeat.o(111470);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(111466);
    super.onStart();
    ad.i("MicroMsg.AlbumPreviewUI", "onStart, %s.", new Object[] { this });
    if (com.tencent.mm.plugin.gallery.model.e.czh().jWF != this.rHY) {
      com.tencent.mm.plugin.gallery.model.e.czh().jWF = this.rHY;
    }
    if (com.tencent.mm.plugin.gallery.model.e.czh().rBG != this.rHZ) {
      com.tencent.mm.plugin.gallery.model.e.czh().setQueryType(this.rHZ);
    }
    AppMethodBeat.o(111466);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(111468);
    super.onStop();
    ad.i("MicroMsg.AlbumPreviewUI", "onStop, %s.", new Object[] { this });
    if (!this.rHX)
    {
      com.tencent.mm.plugin.gallery.model.c localc = com.tencent.mm.plugin.gallery.model.e.czg();
      if ((localc.rAj != null) && (!localc.rAj.isEmpty()))
      {
        Iterator localIterator = localc.rAj.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.c localc1 = (c.c)((Map.Entry)localIterator.next()).getValue();
          if (localc1 != null) {
            localc1.mCancel = true;
          }
        }
        if (localc.rAi != null) {
          localc.rAi.clear();
        }
        if ((localc.rAj != null) && (!localc.rAj.isEmpty())) {
          localc.rAj.clear();
        }
        localc.rAg.czc();
      }
      com.tencent.mm.plugin.gallery.model.e.czg().czb();
    }
    AppMethodBeat.o(111468);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class c
    implements Runnable
  {
    String rHV;
    WeakReference<ProgressDialog> rIA;
    WeakReference<TextView> rIB;
    WeakReference<RecyclerView> rIC;
    LinkedList<GalleryItem.MediaItem> rID;
    WeakReference<ImageFolderMgrView> rIE;
    boolean rIF = false;
    WeakReference<a> rIz;
    
    public final void run()
    {
      AppMethodBeat.i(111455);
      if (this.rID == null) {}
      for (int i = -1;; i = this.rID.size())
      {
        ad.d("MicroMsg.AlbumPreviewUI", "on NotifyMediaItemsChanged, size %d", new Object[] { Integer.valueOf(i) });
        AlbumPreviewUI.bs(this.rID);
        if (this.rIz != null) {
          break;
        }
        ad.w("MicroMsg.AlbumPreviewUI", "null == adapterRef");
        AppMethodBeat.o(111455);
        return;
      }
      Object localObject1 = (a)this.rIz.get();
      if (localObject1 == null)
      {
        ad.w("MicroMsg.AlbumPreviewUI", "null == adapter");
        AppMethodBeat.o(111455);
        return;
      }
      if (this.rIC == null)
      {
        AppMethodBeat.o(111455);
        return;
      }
      RecyclerView localRecyclerView = (RecyclerView)this.rIC.get();
      if (localRecyclerView == null)
      {
        AppMethodBeat.o(111455);
        return;
      }
      ad.d("MicroMsg.AlbumPreviewUI", "isSwitchAlbum: %s.", new Object[] { Boolean.valueOf(this.rIF) });
      Object localObject2 = com.tencent.mm.plugin.gallery.model.p.rBO;
      localObject2 = com.tencent.mm.plugin.gallery.model.p.czR();
      Object localObject3 = this.rID;
      k.h(localObject3, "mediaItems");
      ad.d("MicroMsg.PreLoadManager", "syncMediaItems, size: %s.", new Object[] { Integer.valueOf(((List)localObject3).size()) });
      ((com.tencent.mm.plugin.gallery.model.p)localObject2).rBL.clear();
      ((com.tencent.mm.plugin.gallery.model.p)localObject2).rBL.addAll((Collection)localObject3);
      if (this.rIF)
      {
        this.rIF = false;
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((a)localObject1).ai(this.rID);
        localObject2 = com.tencent.mm.plugin.gallery.model.p.rBO;
        localObject2 = com.tencent.mm.plugin.gallery.model.p.czR();
        localObject3 = p.c.rBR;
        if (this.rID.size() > 32)
        {
          i = 32;
          ((com.tencent.mm.plugin.gallery.model.p)localObject2).a((p.c)localObject3, 0, i, ((a)localObject1).rGU.size());
        }
      }
      for (;;)
      {
        if (this.rIA != null) {
          break label389;
        }
        AppMethodBeat.o(111455);
        return;
        i = this.rID.size();
        break;
        ((a)localObject1).aj(this.rID);
      }
      label389:
      localObject2 = (ProgressDialog)this.rIA.get();
      if ((localObject2 != null) && (((ProgressDialog)localObject2).isShowing()))
      {
        ((ProgressDialog)localObject2).dismiss();
        ad.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start) });
      }
      if (this.rIE != null)
      {
        localObject2 = (ImageFolderMgrView)this.rIE.get();
        if (localObject2 != null) {
          ((ImageFolderMgrView)localObject2).setFavItemCount(this.rID.size());
        }
      }
      if ((this.rIB == null) || (bt.isNullOrNil(this.rHV)))
      {
        AppMethodBeat.o(111455);
        return;
      }
      localObject2 = (TextView)this.rIB.get();
      if (localObject2 != null)
      {
        localObject1 = ((a)localObject1).Ec(((GridLayoutManager)localRecyclerView.getLayoutManager()).jO());
        if ((!bt.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("album_business_bubble_media_by_coordinate")))
        {
          ((TextView)localObject2).setVisibility(0);
          ((TextView)localObject2).setText(this.rHV.concat("附近的照片和视频"));
          ((TextView)localObject2).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111454);
              if (8 == this.rIG.getVisibility())
              {
                AppMethodBeat.o(111454);
                return;
              }
              this.rIG.animate().alpha(0.0F).setDuration(300L).withEndAction(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111453);
                  AlbumPreviewUI.c.1.this.rIG.setVisibility(8);
                  AlbumPreviewUI.c.1.this.rIG.setAlpha(1.0F);
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
    WeakReference<ProgressDialog> rIA;
    WeakReference<ImageFolderMgrView> rIE;
    boolean rIO;
    WeakReference<a> rIz;
    int type;
    
    public final void run()
    {
      AppMethodBeat.i(111462);
      s locals = s.czT();
      i.c local1 = new i.c()
      {
        public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(111461);
          ad.i("MicroMsg.AlbumPreviewUI", "RetrieveFavMediaTask onQueryMediaFinished cancelUINotify: %s.", new Object[] { Boolean.valueOf(AlbumPreviewUI.e.this.rIO) });
          if (AlbumPreviewUI.e.this.rIO)
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
            ad.d("MicroMsg.AlbumPreviewUI", "type: %s path: %s", new Object[] { localMediaItem.mMimeType, localMediaItem.rBp });
          }
          paramAnonymousLinkedList = new AlbumPreviewUI.c((byte)0);
          paramAnonymousLinkedList.rIz = AlbumPreviewUI.e.this.rIz;
          paramAnonymousLinkedList.rIA = AlbumPreviewUI.e.this.rIA;
          paramAnonymousLinkedList.rID = localLinkedList;
          paramAnonymousLinkedList.rIE = AlbumPreviewUI.e.this.rIE;
          com.tencent.mm.plugin.gallery.model.e.czi().f(paramAnonymousLinkedList);
          AppMethodBeat.o(111461);
        }
      };
      Object localObject2 = this.idList;
      int i1 = this.type;
      locals.rBZ = false;
      LinkedList localLinkedList = new LinkedList();
      Object localObject1 = localObject2;
      if (bt.gL((List)localObject2))
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
          if (!bt.gL((List)localObject2))
          {
            ad.i("MicroMsg.SmartGalleryQueryUtil", "fav list contains img or video.");
            ((List)localObject1).addAll((Collection)localObject2);
          }
          if (!bt.gL((List)localObject1)) {
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
        if (!locals.rBZ)
        {
          ad.i("MicroMsg.SmartGalleryQueryUtil", "get fav, count: %d.", new Object[] { Integer.valueOf(k) });
          localLinkedList.addAll(s.p(((List)localObject1).subList(j, i), i1));
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