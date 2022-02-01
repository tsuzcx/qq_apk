package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
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
import com.tencent.mm.plugin.gallery.model.s.a;
import com.tencent.mm.plugin.gallery.model.s.g;
import com.tencent.mm.plugin.gallery.model.s.h;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.AlbumChooserView.a;
import com.tencent.mm.ui.widget.a.f.a;
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
  protected String dng;
  private int fsu;
  private ProgressDialog fts;
  private int iCp;
  private boolean iWQ;
  private List<Long> idList;
  protected int jbG;
  private double latitude;
  private double longitude;
  private int mOD;
  private boolean oUy;
  public boolean opQ;
  protected int rXO;
  protected String sOM;
  private a.f sOR;
  private boolean sPA;
  private boolean sPB;
  private boolean sPC;
  boolean sPD;
  private int sPE;
  private int sPF;
  private long sPG;
  private long sPH;
  private int sPI;
  protected int sPJ;
  private String sPK;
  private i.b sPL;
  private boolean sPM;
  protected int sPN;
  protected int sPO;
  private boolean sPP;
  private e sPQ;
  private volatile long sPR;
  protected MenuItem.OnMenuItemClickListener sPS;
  private GalleryItem.AlbumItem sPT;
  private a.d sPU;
  private volatile AlbumPreviewUI.b sPV;
  private HashMap<String, Integer> sPW;
  private HashSet<String> sPX;
  boolean sPY;
  private p.c sPZ;
  protected RecyclerView sPh;
  private TextView sPi;
  private boolean sPj;
  private boolean sPk;
  protected a sPl;
  private TextView sPm;
  private TextView sPn;
  private TextView sPo;
  private ImageFolderMgrView sPp;
  private TextView sPq;
  private ImageButton sPr;
  private String sPs;
  private String sPt;
  private String sPu;
  private boolean sPv;
  private boolean sPw;
  private boolean sPx;
  private boolean sPy;
  private boolean sPz;
  private int sQa;
  private String sQb;
  protected String toUser;
  
  public AlbumPreviewUI()
  {
    AppMethodBeat.i(111463);
    this.sPw = false;
    this.opQ = false;
    this.sPB = false;
    this.sPC = false;
    this.sPD = false;
    this.sPE = 0;
    this.sPF = 0;
    this.sPG = 0L;
    this.sPI = -1;
    this.oUy = true;
    this.idList = new ArrayList();
    this.iCp = 3;
    this.sPR = -1L;
    this.sPS = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(164796);
        int i = paramAnonymousMenuItem.getItemId();
        ac.d("MicroMsg.AlbumPreviewUI", "mId: %d.", new Object[] { Integer.valueOf(i) });
        if (1 == i)
        {
          ac.i("MicroMsg.AlbumPreviewUI", "go smart gallery.");
          a.a.sIP.sIC = 1;
          com.tencent.mm.plugin.gallery.model.s.cNf().dP(AlbumPreviewUI.this.sPl.sOK);
          paramAnonymousMenuItem = new Intent(AlbumPreviewUI.this, SmartGalleryUI.class);
          paramAnonymousMenuItem.putExtra("select_type_tag", 2);
          paramAnonymousMenuItem.putExtras(AlbumPreviewUI.this.getIntent());
          paramAnonymousMenuItem.putExtra("send_raw_img", AlbumPreviewUI.this.opQ);
          AlbumPreviewUI.this.startActivityForResult(paramAnonymousMenuItem, 4382);
          AppMethodBeat.o(164796);
          return true;
        }
        boolean bool = AlbumPreviewUI.this.cBu();
        AppMethodBeat.o(164796);
        return bool;
      }
    };
    this.sPW = new HashMap();
    this.sOR = new AlbumPreviewUI.10(this);
    this.sPZ = p.c.sKK;
    this.sQa = -1;
    this.mOD = -1;
    this.iWQ = false;
    this.sQb = "";
    AppMethodBeat.o(111463);
  }
  
  private static int[] ae(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111471);
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = paramArrayList.size();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)paramArrayList.next();
      if (localMediaItem != null) {
        if ((!bs.isNullOrNil(localMediaItem.mMimeType)) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
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
  
  private void agA(String paramString)
  {
    AppMethodBeat.i(173773);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
      AppMethodBeat.o(173773);
      return;
    }
    com.tencent.mm.plugin.gallery.model.e.cMu().am(new d(paramString, this.sPl, this.fts, this.sPh));
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
    if (paramAlbumItem.xIc) {}
    for (this.iCp = 3; bs.bG(this.sPt, "").equals(paramAlbumItem.sJZ); this.iCp = 4)
    {
      ac.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
      AppMethodBeat.o(111472);
      return;
    }
    com.tencent.mm.plugin.gallery.model.e.cMy().addAll(this.sPl.sOK);
    ac.i("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[] { paramAlbumItem.sJZ, paramAlbumItem.auN() });
    this.sPs = paramAlbumItem.auN();
    this.sPt = paramAlbumItem.sJZ;
    if (bs.isNullOrNil(this.sPs))
    {
      ac.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
      this.sPs = this.sPt;
    }
    Object localObject1;
    Object localObject2;
    label221:
    int i;
    if (!bs.isNullOrNil(this.sPt))
    {
      localObject1 = this.sPl;
      localObject2 = this.sPU;
      if (localObject2 == null)
      {
        ac.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
        localObject2 = paramAlbumItem.bLs;
        localObject1 = localObject2;
        if (bs.isNullOrNil((String)localObject2))
        {
          if (this.sPO != 3) {
            break label428;
          }
          localObject1 = getString(2131759758);
        }
        updateActionBarOperationAreaTxt((String)localObject1);
        FZ(this.sPl.sOK.size());
        this.fts.show();
        start = System.currentTimeMillis();
        localObject2 = this.sPt;
        i = this.sPO;
        localObject1 = localObject2;
        if (((String)localObject2).equals(getString(2131759759)))
        {
          localObject1 = "";
          i = 2;
        }
        if (!this.sPt.equalsIgnoreCase(getString(2131759764))) {
          break label458;
        }
        if (this.sPQ != null) {
          this.sPQ.sQD = false;
        }
        com.tencent.mm.plugin.gallery.model.e.cMu().an(this.sPQ);
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
        com.tencent.mm.plugin.report.service.h.wUl.f(18269, new Object[] { URLEncoder.encode((String)localObject1, "utf-8"), URLEncoder.encode(paramAlbumItem.bLs, "utf-8") });
        AppMethodBeat.o(111472);
        return;
      }
      catch (Exception paramAlbumItem)
      {
        AppMethodBeat.o(111472);
      }
      ((a)localObject1).sON.remove(localObject2);
      break;
      if (!getIntent().getBooleanExtra("show_header_view", true)) {
        break;
      }
      this.sPl.a(this.sPU);
      break;
      label428:
      if (this.sPO == 1)
      {
        localObject1 = getString(2131759757);
        break label221;
      }
      localObject1 = getString(2131759759);
      break label221;
      label458:
      if ((paramAlbumItem instanceof GalleryItem.PrivateAlbumItem))
      {
        com.tencent.mm.plugin.gallery.model.e.cMt().cNc();
        this.sPR = System.currentTimeMillis();
        com.tencent.mm.plugin.gallery.model.s.cNf().sKR = true;
        localObject1 = ((GalleryItem.PrivateAlbumItem)paramAlbumItem).sKq.sKV;
        if (bs.isNullOrNil((String)localObject1)) {
          ac.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
        } else {
          com.tencent.mm.plugin.gallery.model.e.cMu().an(new d((String)localObject1, this.sPl, this.fts, this.sPh));
        }
      }
      else
      {
        if (this.sPQ != null) {
          this.sPQ.sQD = true;
        }
        com.tencent.mm.plugin.gallery.model.s.cNf().sKS = true;
        com.tencent.mm.plugin.gallery.model.s.cNf().sKR = true;
        this.sPR = System.currentTimeMillis();
        com.tencent.mm.plugin.gallery.model.e.cMt().j((String)localObject1, i, this.sPR);
      }
    }
  }
  
  private void cNC()
  {
    AppMethodBeat.i(173771);
    Object localObject = com.tencent.mm.plugin.gallery.model.e.cMu();
    a locala = new a(this);
    localObject = ((com.tencent.mm.plugin.gallery.model.g)localObject).cMO();
    if (localObject != null)
    {
      ((ao)localObject).post(locala);
      AppMethodBeat.o(173771);
      return;
    }
    ac.w("MicroMsg.GalleryHandlerThread", "other handler is null.");
    AppMethodBeat.o(173771);
  }
  
  private void cND()
  {
    AppMethodBeat.i(173772);
    if (this.sPM)
    {
      this.sPl.dQ(com.tencent.mm.plugin.gallery.model.s.cNf().sKT);
      com.tencent.mm.plugin.gallery.model.e.cMy().addAll(this.sPl.sOK);
      FZ(this.sPl.sOK.size());
      agA(getIntent().getStringExtra("album_id_from_smart_gallery"));
      this.fts.show();
      AppMethodBeat.o(173772);
      return;
    }
    com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.heY).awi();
    if (getIntent().hasExtra("gallery_report_tag")) {
      a.a.sIP.setScene(getIntent().getIntExtra("gallery_report_tag", 3));
    }
    for (;;)
    {
      ac.i("MicroMsg.AlbumPreviewUI", "start queryMediaInAlbums %s", new Object[] { this });
      com.tencent.mm.plugin.gallery.model.e.cMt().a(this);
      this.sPR = System.currentTimeMillis();
      com.tencent.mm.plugin.gallery.model.e.cMt().au(this.sPt, this.sPR);
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111422);
          ac.d("MicroMsg.AlbumPreviewUI", "onCreate, post delay, dialog show.");
          if (AlbumPreviewUI.b.sQm != AlbumPreviewUI.a(AlbumPreviewUI.this)) {
            AlbumPreviewUI.b(AlbumPreviewUI.this).show();
          }
          AppMethodBeat.o(111422);
        }
      }, 300L);
      p.a locala = com.tencent.mm.plugin.gallery.model.p.sKH;
      com.tencent.mm.plugin.gallery.model.p.cNd().a(new l());
      locala = com.tencent.mm.plugin.gallery.model.p.sKH;
      com.tencent.mm.plugin.gallery.model.p.cNd().a(new com.tencent.mm.plugin.gallery.model.q());
      AppMethodBeat.o(173772);
      return;
      a.a.sIP.setScene(this.sPN);
    }
  }
  
  private void cNE()
  {
    AppMethodBeat.i(111476);
    if (!com.tencent.mm.pluginsdk.ui.tools.q.d(getContext(), com.tencent.mm.loader.j.b.aps(), "microMsg." + System.currentTimeMillis() + ".jpg", 4369))
    {
      Toast.makeText(getContext(), getString(2131763022), 1).show();
      AppMethodBeat.o(111476);
      return;
    }
    System.gc();
    AppMethodBeat.o(111476);
  }
  
  private void cNF()
  {
    AppMethodBeat.i(198418);
    if (this.sPX == null)
    {
      this.sPX = new HashSet();
      this.sPX.add(".h264");
      this.sPX.add(".h26l");
      this.sPX.add(".264");
      this.sPX.add(".avc");
      this.sPX.add(".mov");
      this.sPX.add(".mp4");
      this.sPX.add(".m4a");
      this.sPX.add(".3gp");
      this.sPX.add(".3g2");
      this.sPX.add(".mj2");
      this.sPX.add(".m4v");
    }
    AppMethodBeat.o(198418);
  }
  
  private void cNG()
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
      ac.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", new Object[] { localIntent });
      startActivityForResult(localIntent, 4371);
      AppMethodBeat.o(111485);
      return;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.AlbumPreviewUI", localException.toString());
      if ((!com.tencent.mm.r.a.cg(getContext())) && (!com.tencent.mm.r.a.cf(getContext())) && (!com.tencent.mm.r.a.ck(getContext()))) {
        com.tencent.mm.compatible.h.b.w(getContext());
      }
      AppMethodBeat.o(111485);
    }
  }
  
  private static void dR(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111480);
    long l = System.currentTimeMillis();
    ac.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (!com.tencent.mm.vfs.i.eA(localMediaItem.sKh))
      {
        ac.w("MicroMsg.AlbumPreviewUI", "filter non exist media: %s.", new Object[] { localMediaItem.sKh });
        ((LinkedList)localObject).add(localMediaItem);
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.remove((GalleryItem.MediaItem)((Iterator)localObject).next());
    }
    ac.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia cost: %s.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(111480);
  }
  
  protected final void FZ(int paramInt)
  {
    AppMethodBeat.i(111479);
    label37:
    int i;
    int j;
    String str;
    if (paramInt == 0)
    {
      this.sPi.setEnabled(false);
      enableOptionMenu(false);
      if (paramInt != 0) {
        break label102;
      }
      this.sPi.setText(2131759784);
      i = this.sPN;
      j = this.rXO;
      str = this.sOM;
      if (this.sPl != null) {
        break label148;
      }
    }
    label148:
    for (ArrayList localArrayList = null;; localArrayList = this.sPl.sOK)
    {
      updateOptionMenuText(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, paramInt, j, str, localArrayList));
      AppMethodBeat.o(111479);
      return;
      this.sPi.setEnabled(true);
      enableOptionMenu(true);
      break;
      label102:
      this.sPi.setText(getString(2131759784) + "(" + paramInt + ")");
      break label37;
    }
  }
  
  protected boolean a(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(198417);
    if (paramMediaItem == null)
    {
      ac.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
      AppMethodBeat.o(198417);
      return false;
    }
    int i;
    if (this.sPN == 3) {
      if ((paramMediaItem instanceof GalleryItem.VideoMediaItem)) {
        if (("video/hevc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).hTu)) && (com.tencent.mm.plugin.o.f.dcU())) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if ((bk(paramMediaItem.sKh, true)) || (i == 0) || ((!bs.isNullOrNil(((GalleryItem.VideoMediaItem)paramMediaItem).hTv)) && (!"audio/mp4a-latm".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).hTv)))) {}
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label161;
        }
        com.tencent.mm.ui.base.h.cf(this, getString(2131759790));
        AppMethodBeat.o(198417);
        return false;
        if (!"video/avc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).hTu)) {
          break label279;
        }
        i = 1;
        break;
      }
      label161:
      if ((this.sPN == 3) || (this.sPN == 4) || (this.sPN == 14) || (this.sPN == 22))
      {
        if (!new com.tencent.mm.vfs.e(paramMediaItem.sKh).exists())
        {
          com.tencent.mm.ui.base.h.cf(this, getString(2131759808));
          AppMethodBeat.o(198417);
          return false;
        }
        if (com.tencent.mm.plugin.gallery.a.d.agJ(paramMediaItem.sKh) > 300)
        {
          com.tencent.mm.ui.base.h.cf(this, getString(2131759810));
          AppMethodBeat.o(198417);
          return false;
        }
        AppMethodBeat.o(198417);
        return true;
      }
      AppMethodBeat.o(198417);
      return true;
      label279:
      i = 0;
    }
  }
  
  protected void agz(String paramString) {}
  
  public final void aj(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111473);
    switch (this.sPO)
    {
    }
    Object localObject;
    do
    {
      do
      {
        AppMethodBeat.o(111473);
        return;
      } while ((bs.isNullOrNil(this.dng)) || ("medianote".equals(this.toUser)));
      if (bs.Gn() - this.sPG < 1000L)
      {
        ac.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111473);
        return;
      }
      ac.i("MicroMsg.AlbumPreviewUI", "notifyMM switch to SendImgProxyUI");
      localObject = (GalleryItem.MediaItem)this.sPl.sOJ.get(paramInt);
    } while (((GalleryItem.MediaItem)localObject).getType() == 2);
    for (;;)
    {
      try
      {
        localObject = ((GalleryItem.MediaItem)localObject).sKh;
        String str = this.toUser;
        if (!this.sPw) {
          if (!this.opQ)
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
    if (paramLong != this.sPR)
    {
      ac.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.sPR) });
      ac.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(111481);
      return;
    }
    ac.d("MicroMsg.AlbumPreviewUI", "onQueryMediaFinished: %s %s %s.", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.sPl.sOJ.size()), Integer.valueOf(paramLinkedList.size()) });
    if ((paramBoolean) || (this.sPl.sOJ.size() > paramLinkedList.size()))
    {
      dR(paramLinkedList);
      paramLinkedList = new LinkedList(paramLinkedList);
      if (this.sPl != null) {
        break label338;
      }
    }
    label338:
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.AlbumPreviewUI", "[onQueryMediaFinished] adapter is null?:%s %s", new Object[] { Boolean.valueOf(bool), bs.eWi().toString() });
      if (this.sPl != null)
      {
        c localc = new c((byte)0);
        localc.sQo = new WeakReference(this.sPl);
        localc.sQp = new WeakReference(this.fts);
        localc.sQq = new WeakReference(this.sPn);
        localc.sQr = new WeakReference(this.sPh);
        localc.sQs = paramLinkedList;
        localc.sPK = this.sPK;
        localc.sQu = paramBoolean;
        if (AlbumPreviewUI.b.sQl == this.sPV) {
          this.sPV = AlbumPreviewUI.b.sQm;
        }
        com.tencent.mm.plugin.gallery.model.e.cMu().f(localc);
      }
      AppMethodBeat.o(111481);
      return;
      dR(paramLinkedList.subList(this.sPl.sOJ.size(), paramLinkedList.size()));
      break;
    }
  }
  
  public final boolean bk(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(198419);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(198419);
      return true;
    }
    cNF();
    paramString = paramString.trim();
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length()))
    {
      AppMethodBeat.o(198419);
      return true;
    }
    if ((paramBoolean) && (r.DP(paramString)))
    {
      AppMethodBeat.o(198419);
      return true;
    }
    if (!this.sPX.contains(paramString.substring(i).toLowerCase()))
    {
      AppMethodBeat.o(198419);
      return true;
    }
    AppMethodBeat.o(198419);
    return false;
  }
  
  protected boolean cBu()
  {
    int j = 0;
    AppMethodBeat.i(111475);
    ac.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.cMA()), Boolean.valueOf(this.sPw) });
    if (this.sPw) {}
    for (int i = 3;; i = 2)
    {
      com.tencent.mm.plugin.gallery.a.d.bi(11610, i + "," + com.tencent.mm.plugin.gallery.model.e.cMA());
      if (this.sPI < 0) {
        this.sPI = com.tencent.mm.plugin.gallery.a.d.ZH();
      }
      com.tencent.mm.plugin.gallery.model.e.cMz();
      if (this.sPl.cNv().size() != 0) {
        break;
      }
      ac.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
      setResult(-2);
      finish();
      AppMethodBeat.o(111475);
      return true;
    }
    Object localObject1 = new Intent();
    i = this.sPO;
    if (this.sPB) {
      i = 1;
    }
    Object localObject5;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    GalleryItem.MediaItem localMediaItem;
    boolean bool;
    if (22 == com.tencent.mm.plugin.gallery.model.e.cMt().kxr)
    {
      localObject5 = this.sPl.sOK;
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      localObject4 = new int[this.rXO];
      localObject5 = ((ArrayList)localObject5).iterator();
      i = j;
      while (((Iterator)localObject5).hasNext())
      {
        localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
        if (localMediaItem.getType() == 1)
        {
          if ((localMediaItem.mMimeType.equals("edit")) && (!bs.isNullOrNil(localMediaItem.sKj))) {
            ((ArrayList)localObject2).add(localMediaItem.sKj);
          }
          for (;;)
          {
            localObject4[i] = 1;
            i += 1;
            break;
            ((ArrayList)localObject2).add(localMediaItem.sKh);
          }
        }
        if (localMediaItem.getType() == 2)
        {
          ((ArrayList)localObject3).add(localMediaItem.sKh);
          localObject4[i] = 2;
          i += 1;
        }
      }
      bool = com.tencent.mm.plugin.gallery.a.d.cOc();
      if ((com.tencent.mm.plugin.recordvideo.activity.a.b.n((List)localObject2, (List)localObject3) == 4) && (bool))
      {
        localObject1 = VLogPreloadUI.sTO;
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
      if ((this.sPw) || (!this.opQ))
      {
        bool = true;
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
        localObject3 = this.sPl.sOK;
        localObject2 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label563;
        }
        localObject4 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
        if ((((GalleryItem.MediaItem)localObject4).mMimeType.equals("edit")) && (!bs.isNullOrNil(((GalleryItem.MediaItem)localObject4).sKj)))
        {
          ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).sKj);
          continue;
          bool = false;
          break;
        }
        ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).sKh);
      }
      label563:
      ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
      ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.sPH);
      this.sPH = 0L;
      setResult(-1, (Intent)localObject1);
      if ((!bs.isNullOrNil(this.sOM)) && (this.sOM.equals("album_business_bubble_media_by_coordinate"))) {
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
      }
      if (bs.Gn() - this.sPG < 1000L)
      {
        ac.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111475);
        return true;
      }
      ac.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE switch to SendImgProxyUI");
      this.sPG = bs.Gn();
      if ((!bs.isNullOrNil(this.dng)) && (!"medianote".equals(this.toUser)))
      {
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
        ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dng);
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
      ac.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
      if (getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false)) {}
      for (i = 0;; i = ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).bcE())
      {
        if (i != 0) {
          break label899;
        }
        ((Intent)localObject1).setData(m.a(getContext(), new com.tencent.mm.vfs.e((String)this.sPl.cNv().get(0))));
        ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", this.sPl.cNv());
        setResult(-1, (Intent)localObject1);
        finish();
        break;
        localObject2 = com.tencent.mm.plugin.gallery.ui.a.a.agH((String)this.sPl.cNv().get(0));
        ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).mSize = this.sPI;
      }
      label899:
      if (i == 2)
      {
        com.tencent.mm.ui.base.h.l(this, 2131764674, 2131759817);
        ac.w("MicroMsg.AlbumPreviewUI", "video is import error");
        AppMethodBeat.o(111475);
        return true;
      }
      com.tencent.mm.ui.base.h.l(this, 2131759816, 2131759817);
      ac.w("MicroMsg.AlbumPreviewUI", "video is over size");
      AppMethodBeat.o(111475);
      return true;
    }
    if (i == 3)
    {
      if ((!bs.isNullOrNil(this.sOM)) && (this.sOM.equals("album_business_bubble_media_by_coordinate")))
      {
        localObject4 = this.sPl.sOK;
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (GalleryItem.MediaItem)((Iterator)localObject4).next();
          if (((GalleryItem.MediaItem)localObject5).getType() == 1)
          {
            if ((((GalleryItem.MediaItem)localObject5).mMimeType.equals("edit")) && (!bs.isNullOrNil(((GalleryItem.MediaItem)localObject5).sKj))) {
              ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).sKj);
            } else {
              ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).sKh);
            }
          }
          else if (((GalleryItem.MediaItem)localObject5).getType() == 2) {
            ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject5).sKh);
          }
        }
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
        ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.sPH);
        ((Intent)localObject1).putExtra("longitude", this.longitude);
        ((Intent)localObject1).putExtra("latitude", this.latitude);
        this.sPH = 0L;
        setResult(-1, (Intent)localObject1);
        finish();
        AppMethodBeat.o(111475);
        return true;
      }
      if (bs.Gn() - this.sPG < 1000L)
      {
        ac.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111475);
        return true;
      }
      this.sPG = bs.Gn();
      localObject5 = this.sPl.sOK;
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      localObject4 = new int[this.rXO];
      localObject5 = ((ArrayList)localObject5).iterator();
      i = 0;
      label1308:
      if (((Iterator)localObject5).hasNext())
      {
        localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
        if (localMediaItem.getType() == 1)
        {
          if ((localMediaItem.mMimeType.equals("edit")) && (!bs.isNullOrNil(localMediaItem.sKj))) {
            ((ArrayList)localObject3).add(localMediaItem.sKj);
          }
          for (;;)
          {
            localObject4[i] = 1;
            i += 1;
            break;
            ((ArrayList)localObject3).add(localMediaItem.sKh);
          }
        }
        if (localMediaItem.getType() != 2) {
          break label1862;
        }
        ((ArrayList)localObject2).add(localMediaItem.sKh);
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
      if ((this.sPw) || (!this.opQ)) {}
      for (bool = true;; bool = false)
      {
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
        ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.sPH);
        if (!this.sPw) {
          break label1727;
        }
        if (((ArrayList)localObject2).size() != 0) {
          break;
        }
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.sPH);
        this.sPH = 0L;
        setResult(-1, (Intent)localObject1);
        finish();
        AppMethodBeat.o(111475);
        return true;
      }
      if (com.tencent.mm.plugin.recordvideo.activity.a.b.n((List)localObject3, (List)localObject2) == 4)
      {
        localObject1 = VLogPreloadUI.sTO;
        VLogPreloadUI.a.a(this, (ArrayList)localObject2, (ArrayList)localObject3, (int[])localObject4);
      }
      for (;;)
      {
        AppMethodBeat.o(111475);
        return true;
        localObject1 = RecordConfigProvider.ak((String)((ArrayList)localObject2).get(0), "", "");
        ((RecordConfigProvider)localObject1).wqC = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
        ((RecordConfigProvider)localObject1).scene = 2;
        localObject2 = new VideoCaptureReportInfo();
        ((VideoCaptureReportInfo)localObject2).qwN = 1;
        ((RecordConfigProvider)localObject1).wqK = ((VideoCaptureReportInfo)localObject2);
        localObject2 = new UICustomParam.a();
        ((UICustomParam.a)localObject2).YX();
        ((UICustomParam.a)localObject2).YW();
        ((UICustomParam.a)localObject2).cN(true);
        ((RecordConfigProvider)localObject1).wqu = ((UICustomParam.a)localObject2).fKH;
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772137, -1, (RecordConfigProvider)localObject1, 2, 0);
      }
      this.sPH = 0L;
      if (((ArrayList)localObject3).size() > 0)
      {
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
        ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dng);
        ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject1).putExtra("CropImage_limit_Img_Size", 26214400);
        ac.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE_AND_VIDEO switch to SendImgProxyUI");
        startActivityForResult((Intent)localObject1, 4373);
        break;
      }
      ac.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
      setResult(-1, (Intent)localObject1);
      finish();
      break;
      ac.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
      setResult(-2);
      finish();
      break;
    }
  }
  
  protected void f(final int paramInt, View paramView)
  {
    AppMethodBeat.i(164801);
    Object localObject1 = this.sPl.FX(paramInt);
    boolean bool1;
    if ((localObject1 == null) || (bs.isNullOrNil(((GalleryItem.MediaItem)localObject1).sKh)))
    {
      if (localObject1 == null) {}
      for (bool1 = true;; bool1 = false)
      {
        ac.w("MicroMsg.AlbumPreviewUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(164801);
        return;
      }
    }
    if ((com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 5) && (((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")))
    {
      com.tencent.mm.ui.base.h.cg(getContext(), getString(2131759804));
      AppMethodBeat.o(164801);
      return;
    }
    if (1 == this.sPO)
    {
      if (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("video"))
      {
        com.tencent.mm.ui.base.h.cg(getContext(), getString(2131759806));
        AppMethodBeat.o(164801);
      }
    }
    else if ((2 == this.sPO) && (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("image")))
    {
      com.tencent.mm.ui.base.h.cg(getContext(), getString(2131759805));
      AppMethodBeat.o(164801);
      return;
    }
    int i = paramInt - this.sPl.sON.size();
    ac.d("MicroMsg.AlbumPreviewUI", "onMediaClick, querySource %s item %s.", new Object[] { Integer.valueOf(this.sPN), localObject1 });
    if ((this.sPN == 0) || (this.sPN == 5) || (this.sPN == 10) || (this.sPN == 11))
    {
      if (this.sPO == 2)
      {
        com.tencent.mm.ui.base.h.a(this, true, getString(2131759818), "", getString(2131755884), getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(179459);
            ac.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.setData(Uri.parse("file://" + Uri.encode(this.sQg.sKh)));
            AlbumPreviewUI.this.setResult(-1, paramAnonymousDialogInterface);
            a.a.sIP.ae(this.sQg.sKh, AlbumPreviewUI.k(AlbumPreviewUI.this), paramInt);
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
        paramView.putExtra("video_full_path", ((GalleryItem.MediaItem)localObject1).sKh);
      }
      if (this.sPN == 10) {
        paramView.putExtra("CropImage_OutputPath", ((GalleryItem.MediaItem)localObject1).sKh);
      }
      paramView.setData(Uri.parse(Uri.encode(((GalleryItem.MediaItem)localObject1).sKh)));
      ac.i("MicroMsg.AlbumPreviewUI", "getItem ok");
      setResult(-1, paramView);
      a.a.sIP.ae(((GalleryItem.MediaItem)localObject1).sKh, this.iCp, paramInt);
      finish();
      AppMethodBeat.o(164801);
      return;
    }
    boolean bool2;
    if (this.sPN == 4)
    {
      bool2 = com.tencent.mm.plugin.gallery.a.d.cOb();
      if ((!bool2) && (((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.sPl.sOK.size() != 0))
      {
        com.tencent.mm.ui.base.h.cg(getContext(), com.tencent.mm.cc.a.aw(getContext(), 2131759774));
        AppMethodBeat.o(164801);
        return;
      }
      if ((bool2) && (com.tencent.mm.plugin.gallery.a.d.ag(this.sPl.sOK)))
      {
        bool1 = true;
        ac.i("MicroMsg.AlbumPreviewUI", "enableSnsVLog:%s skipEditVideo:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((((GalleryItem.MediaItem)localObject1).getType() != 2) || (bool1)) {
          break label1004;
        }
        paramView = getString(2131759795);
        if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
          break label853;
        }
        if ((!"video/hevc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).hTu)) || (!com.tencent.mm.plugin.o.f.dcU())) {
          break label752;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((bk(((GalleryItem.MediaItem)localObject1).sKh, true)) || (i == 0) || ((!bs.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).hTv)) && (!"audio/mp4a-latm".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).hTv))))
      {
        paramView = new f.a(getContext());
        paramView.av(com.tencent.mm.cc.a.aw(getContext(), 2131759790));
        paramView.aRU(com.tencent.mm.cc.a.aw(getContext(), 2131759769));
        paramView.b(new AlbumPreviewUI.13(this));
        paramView.show();
        AppMethodBeat.o(164801);
        return;
        bool1 = false;
        break;
        label752:
        if (!"video/avc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).hTu)) {
          break label2562;
        }
        i = 1;
        continue;
      }
      if (((GalleryItem.VideoMediaItem)localObject1).hTw >= 300000L)
      {
        localObject1 = new f.a(getContext());
        ((f.a)localObject1).av(paramView);
        ((f.a)localObject1).aRU(com.tencent.mm.cc.a.aw(getContext(), 2131759769));
        ((f.a)localObject1).b(new AlbumPreviewUI.14(this));
        ((f.a)localObject1).show();
        AppMethodBeat.o(164801);
        return;
      }
      label853:
      paramView = RecordConfigProvider.ak(((GalleryItem.MediaItem)localObject1).sKh, "", "");
      paramView.wqC = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
      paramView.scene = 2;
      Object localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).qwN = 1;
      paramView.wqK = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).YX();
      ((UICustomParam.a)localObject2).YW();
      ((UICustomParam.a)localObject2).cN(true);
      paramView.wqu = ((UICustomParam.a)localObject2).fKH;
      a.a.sIP.ae(((GalleryItem.MediaItem)localObject1).sKh, this.iCp, paramInt);
      this.sQb = ((GalleryItem.MediaItem)localObject1).sKh;
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772137, -1, paramView, 2, 0);
      AppMethodBeat.o(164801);
      return;
      label1004:
      ac.d("leextime", "jump from sns : " + bs.Gn());
      if (bool2) {}
      for (paramView = this.sPl.sOJ;; paramView = this.sPl.FW(((GalleryItem.MediaItem)localObject1).getType()))
      {
        com.tencent.mm.plugin.gallery.model.e.ab(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.sPl.cNv());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.sPl.sOK);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        aj(i, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.opQ);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.sPx);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.sPz);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.sPA);
        ((Intent)localObject2).putExtra("max_select_count", this.rXO);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dng);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.iCp);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
        return;
      }
      if (this.sPN == 14)
      {
        if ((((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.sPl.sOK.size() != 0))
        {
          com.tencent.mm.ui.base.h.cg(getContext(), com.tencent.mm.cc.a.aw(getContext(), 2131759774));
          AppMethodBeat.o(164801);
          return;
        }
        if (((GalleryItem.MediaItem)localObject1).getType() == 1)
        {
          paramView = this.sPl.FW(((GalleryItem.MediaItem)localObject1).getType());
          com.tencent.mm.plugin.gallery.model.e.ab(paramView);
          localObject2 = new Intent(this, ImagePreviewUI.class);
          ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
          ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
          ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.sPl.cNv());
          ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.sPl.sOK);
          ((Intent)localObject2).putExtra("preview_all", true);
          ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
          aj(i, true);
          ((Intent)localObject2).putExtra("send_raw_img", this.opQ);
          ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.sPx);
          ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.sPz);
          ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.sPA);
          ((Intent)localObject2).putExtra("max_select_count", this.rXO);
          ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dng);
          ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject2).putExtra("select_type_tag", this.iCp);
          startActivityForResult((Intent)localObject2, 0);
          AppMethodBeat.o(164801);
          return;
        }
        if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
          break label2550;
        }
        paramView = (GalleryItem.VideoMediaItem)localObject1;
        if (paramView.hTw <= 2000)
        {
          ac.i("MicroMsg.AlbumPreviewUI", "select story video, duration too long, duration:%s", new Object[] { Integer.valueOf(paramView.hTw) });
          com.tencent.mm.plugin.report.service.h.wUl.n(1005L, 53L, 1L);
          com.tencent.mm.ui.base.h.cg(getContext(), com.tencent.mm.cc.a.aw(getContext(), 2131759798));
          AppMethodBeat.o(164801);
          return;
        }
        if ((paramView.videoFrameRate <= 1) && (paramView.videoFrameRate >= 0))
        {
          ac.i("MicroMsg.AlbumPreviewUI", "select story video, videoFrameRate too small:%s, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.sKh });
          if (paramView.videoFrameRate > 1) {}
        }
      }
      try
      {
        localObject2 = SightVideoJNI.getSimpleMp4InfoVFS(paramView.sKh);
        if (!bs.isNullOrNil((String)localObject2))
        {
          double d = new JSONObject((String)localObject2).optDouble("videoFPS");
          ac.i("MicroMsg.AlbumPreviewUI", "update from getSimpleMp4Info videoFPS:%s", new Object[] { Double.valueOf(d) });
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
        ac.i("MicroMsg.AlbumPreviewUI", "final videoFrameRate:%s, too small, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.sKh });
        com.tencent.mm.plugin.report.service.h.wUl.n(1005L, 54L, 1L);
        com.tencent.mm.ui.base.h.cg(getContext(), com.tencent.mm.cc.a.aw(getContext(), 2131759790));
        AppMethodBeat.o(164801);
        return;
      }
      ac.i("MicroMsg.AlbumPreviewUI", "maxDuration=%s", new Object[] { Long.valueOf(getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000 + 500) });
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("K_SEGMENTVIDEOPATH", paramView.sKh);
      ((Intent)localObject2).putExtra("KSEGMENTVIDEOTHUMBPATH", paramView.qCJ);
      setResult(-1, (Intent)localObject2);
      a.a.sIP.ae(((GalleryItem.MediaItem)localObject1).sKh, this.iCp, paramInt);
      finish();
      AppMethodBeat.o(164801);
      return;
      if (this.sPB)
      {
        if ((((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.sPl.sOK.size() != 0))
        {
          com.tencent.mm.ui.base.h.cg(getContext(), com.tencent.mm.cc.a.aw(getContext(), 2131759774));
          AppMethodBeat.o(164801);
          return;
        }
        if ((this.sPN == 15) && (((GalleryItem.MediaItem)localObject1).getType() == 2))
        {
          agz(((GalleryItem.MediaItem)localObject1).sKh);
          AppMethodBeat.o(164801);
          return;
        }
        paramView = this.sPl.FW(((GalleryItem.MediaItem)localObject1).getType());
        com.tencent.mm.plugin.gallery.model.e.ab(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.sPl.cNv());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.sPl.sOK);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        aj(i, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.opQ);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.sPx);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.sPz);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.sPA);
        if (((GalleryItem.MediaItem)localObject1).getType() == 2) {}
        for (paramInt = 1;; paramInt = this.rXO)
        {
          ((Intent)localObject2).putExtra("max_select_count", paramInt);
          ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dng);
          ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject2).putExtra("select_type_tag", this.iCp);
          startActivityForResult((Intent)localObject2, 0);
          AppMethodBeat.o(164801);
          return;
        }
      }
      com.tencent.mm.plugin.gallery.model.e.ab(this.sPl.sOJ);
      paramView = new Intent(this, ImagePreviewUI.class);
      paramView.putStringArrayListExtra("preview_image_list", this.sPl.cNv());
      paramView.putParcelableArrayListExtra("preview_media_item_list", this.sPl.sOK);
      paramView.putExtra("preview_all", true);
      paramView.putExtra("preview_position", i);
      aj(i, true);
      paramView.putExtra("send_raw_img", this.opQ);
      paramView.putExtra("key_force_hide_edit_image_button", this.sPx);
      paramView.putExtra("key_force_show_raw_image_button", this.sPz);
      paramView.putExtra("key_is_raw_image_button_disable", this.sPA);
      paramView.putExtra("max_select_count", this.rXO);
      paramView.putExtra("GalleryUI_FromUser", this.dng);
      paramView.putExtra("GalleryUI_ToUser", this.toUser);
      paramView.putExtra("album_business_tag", this.sOM);
      paramView.putExtra("album_video_max_duration", this.jbG);
      paramView.putExtra("album_video_min_duration", this.sPJ);
      if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 14) {
        paramView.putExtra("key_edit_video_max_time_length", 300500);
      }
      paramView.putExtra("select_type_tag", this.iCp);
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
        ac.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", new Object[] { str, ((Bundle)localObject1).get(str) });
      }
    }
    ac.e("MicroMsg.AlbumPreviewUI", "initView, oops! no extras data!");
    this.sOM = getIntent().getStringExtra("album_business_tag");
    this.jbG = getIntent().getIntExtra("album_video_max_duration", 10);
    this.sPJ = getIntent().getIntExtra("album_video_min_duration", 0);
    this.dng = getIntent().getStringExtra("GalleryUI_FromUser");
    this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
    this.rXO = getIntent().getIntExtra("max_select_count", 9);
    boolean bool;
    if (this.sPN == 4)
    {
      bool = true;
      this.sPw = bool;
      this.sPs = getIntent().getStringExtra("folder_path");
      this.sPt = getIntent().getStringExtra("folder_name");
      if (bs.isNullOrNil(this.sPs))
      {
        ac.w("MicroMsg.AlbumPreviewUI", "folder path invalid, assign folderName: %s.", new Object[] { this.sPt });
        this.sPs = this.sPt;
      }
      if ((!getIntent().getBooleanExtra("key_send_raw_image", false)) && (!getIntent().getBooleanExtra("send_raw_img", false))) {
        break label1738;
      }
      bool = true;
      label294:
      this.opQ = bool;
      this.sPx = getIntent().getBooleanExtra("key_force_hide_edit_image_button", false);
      this.sPy = getIntent().getBooleanExtra("key_force_hide_edit_image_button_after_album_take_image", false);
      this.sPz = getIntent().getBooleanExtra("key_force_show_raw_image_button", false);
      this.sPA = getIntent().getBooleanExtra("key_is_raw_image_button_disable", false);
      this.sPB = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
      this.sPq = ((TextView)findViewById(2131303091));
      this.sPr = ((ImageButton)findViewById(2131303090));
      this.sPq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111434);
          AlbumPreviewUI.c(AlbumPreviewUI.this).performClick();
          AppMethodBeat.o(111434);
        }
      });
      if ((this.sPN != 3) && (!this.sPz)) {
        break label1744;
      }
      this.sPr.setVisibility(0);
      this.sPq.setVisibility(0);
      label449:
      if (!this.opQ) {
        break label1765;
      }
      this.sPr.setImageResource(2131691078);
      label466:
      if (this.sPA) {
        this.sPr.setImageResource(2131691075);
      }
      localObject1 = this.sPr;
      if (this.sPA) {
        break label1778;
      }
      bool = true;
      label499:
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.sPq;
      if (this.sPA) {
        break label1784;
      }
      bool = true;
      label522:
      ((TextView)localObject1).setEnabled(bool);
      this.sPr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111435);
          paramAnonymousView = AlbumPreviewUI.this;
          boolean bool;
          if (!AlbumPreviewUI.this.opQ)
          {
            bool = true;
            paramAnonymousView.opQ = bool;
            AlbumPreviewUI.d(AlbumPreviewUI.this);
            AlbumPreviewUI.e(AlbumPreviewUI.this).setText(AlbumPreviewUI.this.getContext().getString(2131759782).concat(AlbumPreviewUI.cNH()));
            if (!AlbumPreviewUI.this.opQ) {
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
      this.sPh = ((RecyclerView)findViewById(2131302210));
      this.sPm = ((TextView)findViewById(2131296624));
      this.sPn = ((TextView)findViewById(2131296625));
      this.sPo = ((TextView)findViewById(2131296597));
      this.sPi = ((TextView)findViewById(2131302218));
      if (1 != ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYv, 0)) {
        break label1790;
      }
      bool = true;
      label639:
      ac.i("MicroMsg.AlbumPreviewUI", "pennqin, smartGallerySwitch: %s.", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label1796;
      }
      bool = false;
      label667:
      ac.i("MicroMsg.AlbumPreviewUI", "pennqin, isFromSmartGallery: %s showSmartGallery: %s.", new Object[] { Boolean.valueOf(this.sPM), Boolean.valueOf(bool) });
      if ((!this.sPM) && ((bool) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)))
      {
        addTextOptionMenu(1, null, this.sPS, null, s.b.Hoz);
        if (this.sPP) {
          cNC();
        }
      }
      if ((this.sPN != 0) && (this.sPN != 5) && (this.sPN != 10) && (this.sPN != 11) && (this.sPN != 24)) {
        break label1892;
      }
      findViewById(2131296568).setVisibility(8);
      localObject1 = (FrameLayout.LayoutParams)this.sPh.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = 0;
      this.sPh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      label827:
      this.sPp = ((ImageFolderMgrView)findViewById(2131300928));
      this.sPp.setListener(new AlbumPreviewUI.18(this));
      this.sPp.setOnFolderStateChanged(new ImageFolderMgrView.b()
      {
        public final void my(boolean paramAnonymousBoolean)
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
              if (!bs.bG(AlbumPreviewUI.o(AlbumPreviewUI.this), "").equals(AlbumPreviewUI.n(AlbumPreviewUI.this).sJZ))
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
      localObject2 = this.sPp;
      bool = this.sPP;
      ac.i("MicroMsg.ImageFolderMgrView", "attach, %s.", new Object[] { localObject2 });
      com.tencent.mm.plugin.gallery.model.e.cMt().b((i.a)localObject2);
      com.tencent.mm.plugin.gallery.model.e.cMt().a((i.a)localObject2);
      com.tencent.mm.plugin.gallery.model.e.cMt().c(((ImageFolderMgrView)localObject2).sRp);
      localObject1 = com.tencent.mm.plugin.gallery.model.e.cMt();
      localObject2 = ((ImageFolderMgrView)localObject2).sRp;
      ((o)localObject1).sKv.add(localObject2);
      if (bool) {
        com.tencent.mm.plugin.gallery.model.e.cMt().cNb();
      }
      this.sPu = getIntent().getStringExtra("send_btn_string");
      this.sPv = getIntent().getBooleanExtra("is_hide_album_footer", false);
      if (this.sPv) {
        findViewById(2131296568).setVisibility(8);
      }
      enableOptionMenu(false);
      getContext();
      localObject1 = new GridLayoutManager(4);
      this.sPh.setLayoutManager((RecyclerView.i)localObject1);
      localObject2 = new c.a(getContext());
      ((c.a)localObject2).sQO = ((c.a)localObject2).mResources.getDimensionPixelSize(2131166400);
      ((c.a)localObject2).sQP = ((c.a)localObject2).mResources.getDimensionPixelSize(2131166400);
      ((c.a)localObject2).mColor = android.support.v4.content.b.n(((c.a)localObject2).mContext, 2131100399);
      ((c.a)localObject2).sQN = false;
      localObject2 = new c(((c.a)localObject2).sQO, ((c.a)localObject2).sQP, ((c.a)localObject2).mColor, ((c.a)localObject2).sQN, (byte)0);
      this.sPh.a((RecyclerView.h)localObject2);
      this.sPh.a(new RecyclerView.m()
      {
        private Runnable oqt;
        
        private String cNK()
        {
          AppMethodBeat.i(111442);
          String str = AlbumPreviewUI.this.sPl.FY(this.sQh.jW());
          if ((!bs.isNullOrNil(str)) && (str.equals("album_business_bubble_media_by_coordinate")))
          {
            str = AlbumPreviewUI.q(AlbumPreviewUI.this) + "附近的照片和视频";
            AppMethodBeat.o(111442);
            return str;
          }
          AppMethodBeat.o(111442);
          return str;
        }
        
        private void mz(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(111443);
          if (paramAnonymousBoolean)
          {
            AlbumPreviewUI.p(AlbumPreviewUI.this).removeCallbacks(this.oqt);
            if (AlbumPreviewUI.p(AlbumPreviewUI.this).getVisibility() != 0)
            {
              String str = cNK();
              AlbumPreviewUI.p(AlbumPreviewUI.this).setText(str);
              AlbumPreviewUI.p(AlbumPreviewUI.this).setVisibility(0);
              AlbumPreviewUI.p(AlbumPreviewUI.this).setAlpha(0.0F);
              AlbumPreviewUI.p(AlbumPreviewUI.this).animate().alpha(1.0F).setDuration(300L).start();
              AppMethodBeat.o(111443);
            }
          }
          else
          {
            AlbumPreviewUI.p(AlbumPreviewUI.this).removeCallbacks(this.oqt);
            AlbumPreviewUI.p(AlbumPreviewUI.this).postDelayed(this.oqt, 256L);
          }
          AppMethodBeat.o(111443);
        }
        
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(111445);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
          paramAnonymousRecyclerView = cNK();
          AlbumPreviewUI.p(AlbumPreviewUI.this).setText(paramAnonymousRecyclerView);
          paramAnonymousInt1 = this.sQh.jW();
          int i = this.sQh.jY();
          ac.d("MicroMsg.AlbumPreviewUI", "pennqin, onScrolled, %s %s %s %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(i), Integer.valueOf(AlbumPreviewUI.s(AlbumPreviewUI.this)), Integer.valueOf(AlbumPreviewUI.t(AlbumPreviewUI.this)) });
          if ((AlbumPreviewUI.s(AlbumPreviewUI.this) != paramAnonymousInt1) || (AlbumPreviewUI.t(AlbumPreviewUI.this) != i))
          {
            AlbumPreviewUI.a(AlbumPreviewUI.this, paramAnonymousInt1);
            AlbumPreviewUI.b(AlbumPreviewUI.this, i);
            paramAnonymousRecyclerView = new ArrayList();
            paramAnonymousInt1 = AlbumPreviewUI.s(AlbumPreviewUI.this);
            while (paramAnonymousInt1 <= AlbumPreviewUI.t(AlbumPreviewUI.this))
            {
              localObject = AlbumPreviewUI.this.sPl.FX(paramAnonymousInt1);
              if (localObject != null) {
                paramAnonymousRecyclerView.add(com.tencent.mm.plugin.gallery.a.d.a(((GalleryItem.MediaItem)localObject).auN(), null, -1));
              }
              paramAnonymousInt1 += 1;
            }
            ac.d("MicroMsg.AlbumPreviewUI", "cancelTask, legalPaths size: %s.", new Object[] { Integer.valueOf(paramAnonymousRecyclerView.size()) });
            com.tencent.mm.plugin.gallery.model.e.cMs().dN(paramAnonymousRecyclerView);
            if (paramAnonymousInt2 != 0)
            {
              if (paramAnonymousInt2 >= 0) {
                break label381;
              }
              AlbumPreviewUI.a(AlbumPreviewUI.this, p.c.sKL);
            }
          }
          for (;;)
          {
            ac.d("MicroMsg.AlbumPreviewUI", "onScrolled, dy: %s state: %s.", new Object[] { Integer.valueOf(paramAnonymousInt2), AlbumPreviewUI.v(AlbumPreviewUI.this) });
            paramAnonymousRecyclerView = com.tencent.mm.plugin.gallery.model.p.sKH;
            com.tencent.mm.plugin.gallery.model.p.cNd().a(AlbumPreviewUI.v(AlbumPreviewUI.this), AlbumPreviewUI.s(AlbumPreviewUI.this), AlbumPreviewUI.t(AlbumPreviewUI.this), AlbumPreviewUI.this.sPl.sOJ.size());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(111445);
            return;
            label381:
            AlbumPreviewUI.a(AlbumPreviewUI.this, p.c.sKM);
          }
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(111444);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bb(paramAnonymousRecyclerView);
          localb.lS(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
          ac.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (1 == paramAnonymousInt)
          {
            mz(true);
            AlbumPreviewUI.r(AlbumPreviewUI.this).setVisibility(8);
            com.tencent.mm.plugin.gallery.model.e.cMs().cMn();
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
              mz(false);
              AlbumPreviewUI.a(AlbumPreviewUI.this, this.sQh.jW());
              AlbumPreviewUI.b(AlbumPreviewUI.this, this.sQh.jY());
              ac.d("MicroMsg.AlbumPreviewUI", "cancelTask logic, firstVisibleItem: %s lastVisibleItem: %s.", new Object[] { Integer.valueOf(AlbumPreviewUI.s(AlbumPreviewUI.this)), Integer.valueOf(AlbumPreviewUI.t(AlbumPreviewUI.this)) });
              paramAnonymousRecyclerView = com.tencent.mm.plugin.gallery.model.p.sKH;
              com.tencent.mm.plugin.gallery.model.p.cNd().a(p.c.sKK, AlbumPreviewUI.s(AlbumPreviewUI.this), AlbumPreviewUI.t(AlbumPreviewUI.this), AlbumPreviewUI.this.sPl.sOJ.size());
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
      this.sPl = new a(getContext(), new a.e()
      {
        public final void ac(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(111446);
          Object localObject = AlbumPreviewUI.this.sPl.FX(paramAnonymousInt2);
          if (localObject == null)
          {
            AppMethodBeat.o(111446);
            return;
          }
          if (paramAnonymousInt3 == 0) {
            if (((GalleryItem.MediaItem)localObject).getType() == 1)
            {
              a.a.sIP.ae(((GalleryItem.MediaItem)localObject).sKh, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.a(AlbumPreviewUI.this, (GalleryItem.MediaItem)localObject);
              AlbumPreviewUI.this.FZ(paramAnonymousInt1);
              AlbumPreviewUI.this.aj(paramAnonymousInt2, true);
            }
          }
          while (bs.gY(AlbumPreviewUI.this.sPl.cNv()))
          {
            AppMethodBeat.o(111446);
            return;
            if (((GalleryItem.MediaItem)localObject).getType() == 2)
            {
              if (!AlbumPreviewUI.this.a((GalleryItem.MediaItem)localObject))
              {
                AlbumPreviewUI.this.sPl.h((GalleryItem.MediaItem)localObject);
              }
              else
              {
                a.a.sIP.ae(((GalleryItem.MediaItem)localObject).sKh, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
                AlbumPreviewUI.this.FZ(paramAnonymousInt1);
                AlbumPreviewUI.this.aj(paramAnonymousInt2, true);
              }
            }
            else
            {
              a.a.sIP.ae(((GalleryItem.MediaItem)localObject).sKh, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.FZ(paramAnonymousInt1);
              AlbumPreviewUI.this.aj(paramAnonymousInt2, true);
              continue;
              a.a.sIP.ae(((GalleryItem.MediaItem)localObject).sKh, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.FZ(paramAnonymousInt1);
              AlbumPreviewUI.this.aj(paramAnonymousInt2, false);
            }
          }
          localObject = AlbumPreviewUI.this.sPl.cNv().iterator();
          while (((Iterator)localObject).hasNext()) {
            if (!com.tencent.mm.sdk.platformtools.s.aKD((String)((Iterator)localObject).next()))
            {
              AppMethodBeat.o(111446);
              return;
            }
          }
          AlbumPreviewUI.this.opQ = true;
          AppMethodBeat.o(111446);
        }
      });
      this.sPl.sOR = this.sOR;
      if (!bs.isNullOrNil(this.sOM))
      {
        ac.d("MicroMsg.AlbumPreviewUI", "businessTag=%s", new Object[] { this.sOM });
        this.sPl.sOM = this.sOM;
        this.sPl.jbG = this.jbG;
        if (this.sOM.equals("album_business_bubble_media_by_coordinate"))
        {
          this.sPl.sOO = false;
          com.tencent.mm.plugin.gallery.model.e.cMt().sKy.cMf();
          this.sPK = getIntent().getStringExtra("album_business_bubble_media_by_coordinate_posname");
          final double d = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_distance", -1.0D);
          this.longitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 181.0D);
          this.latitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 91.0D);
          if ((d >= 0.0D) && (com.tencent.mm.modelgeo.a.l(this.longitude)) && (com.tencent.mm.modelgeo.a.m(this.latitude)))
          {
            this.sPL = new i.b()
            {
              public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong)
              {
                AppMethodBeat.i(111423);
                ac.d("MicroMsg.AlbumPreviewUI", "onQueryMediaBusinessDoing");
                if (paramAnonymousLong != AlbumPreviewUI.w(AlbumPreviewUI.this))
                {
                  ac.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(AlbumPreviewUI.w(AlbumPreviewUI.this)) });
                  ac.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
                  AppMethodBeat.o(111423);
                  return;
                }
                if ((paramAnonymousLinkedList == null) || (paramAnonymousLinkedList.isEmpty()))
                {
                  ac.d("MicroMsg.AlbumPreviewUI", "mediaItems is invalid.");
                  AppMethodBeat.o(111423);
                  return;
                }
                ArrayList localArrayList = new ArrayList();
                Iterator localIterator = paramAnonymousLinkedList.iterator();
                while (localIterator.hasNext())
                {
                  GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
                  if (TencentLocationUtils.distanceBetween(AlbumPreviewUI.x(AlbumPreviewUI.this), AlbumPreviewUI.y(AlbumPreviewUI.this), localMediaItem.bNq, localMediaItem.bNr) <= d)
                  {
                    localMediaItem.sKn = "album_business_bubble_media_by_coordinate";
                    localArrayList.add(localMediaItem);
                  }
                }
                paramAnonymousLinkedList.removeAll(localArrayList);
                ac.d("MicroMsg.AlbumPreviewUI", "target media size=%d", new Object[] { Integer.valueOf(localArrayList.size()) });
                localIterator = localArrayList.iterator();
                while (localIterator.hasNext()) {
                  ac.d("MicroMsg.AlbumPreviewUI", "target media item=%s", new Object[] { ((GalleryItem.MediaItem)localIterator.next()).toString() });
                }
                if ((!paramAnonymousLinkedList.isEmpty()) && (!localArrayList.isEmpty())) {
                  paramAnonymousLinkedList.addAll(0, localArrayList);
                }
                AppMethodBeat.o(111423);
              }
            };
            localObject1 = com.tencent.mm.plugin.gallery.model.e.cMt();
            localObject2 = this.sPL;
            if (localObject2 != null) {
              ((o)localObject1).sKx.add(localObject2);
            }
          }
        }
      }
      if (this.sPB) {
        this.sPl.sOO = true;
      }
      this.sPU = new a.b();
      if (getIntent().getBooleanExtra("show_header_view", true)) {
        this.sPl.a(this.sPU);
      }
      this.sPl.sKz = this.sPO;
      this.sPl.sOI = this.rXO;
      ac.i("MicroMsg.AlbumPreviewUI", "limit count = " + this.rXO);
      this.sPh.setAdapter(this.sPl);
      if (!this.sPM) {
        break label2115;
      }
      setActionbarColor(getResources().getColor(2131100399));
      setMMTitle(getIntent().getStringExtra("title_from_smart_gallery"));
      label1551:
      setNavigationbarColor(getResources().getColor(2131100399));
      setActionBarOperationAreaClickListener(new AlbumChooserView.a()
      {
        public final void cNJ()
        {
          AppMethodBeat.i(179457);
          ac.i("MicroMsg.AlbumPreviewUI", "onAlbumChooserViewClick.");
          AlbumPreviewUI.a(AlbumPreviewUI.this, null);
          a.a.sIP.sID = 1;
          ac.d("MicroMsg.AlbumPreviewUI", "click folder times: [%d].", new Object[] { Integer.valueOf(AlbumPreviewUI.B(AlbumPreviewUI.this)) });
          AlbumPreviewUI.C(AlbumPreviewUI.this);
          AlbumPreviewUI.this.playActionBarOperationAreaAnim();
          AlbumPreviewUI.m(AlbumPreviewUI.this).cNL();
          AppMethodBeat.o(179457);
        }
      });
      if (!this.sPM) {
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
          ac.i("MicroMsg.AlbumPreviewUI", "backBtn");
          AlbumPreviewUI.this.onBackBtnClick();
          AlbumPreviewUI.this.setResult(-2, AlbumPreviewUI.this.getIntent().putExtra("send_raw_img", AlbumPreviewUI.this.opQ));
          if ((AlbumPreviewUI.m(AlbumPreviewUI.this) != null) && (AlbumPreviewUI.m(AlbumPreviewUI.this).hW))
          {
            AlbumPreviewUI.m(AlbumPreviewUI.this).cNL();
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
        ((DrawedCallBackFrameLayout)localObject1).setListener(new AlbumPreviewUI.4(this));
      }
      this.sPQ = new e((byte)0);
      this.sPQ.sQo = new WeakReference(this.sPl);
      this.sPQ.sQp = new WeakReference(this.fts);
      this.sPQ.sQt = new WeakReference(this.sPp);
      this.sPQ.idList = this.idList;
      this.sPQ.type = this.sPO;
      AppMethodBeat.o(111474);
      return;
      bool = false;
      break;
      label1738:
      bool = false;
      break label294;
      label1744:
      this.sPr.setVisibility(8);
      this.sPq.setVisibility(8);
      break label449;
      label1765:
      this.sPr.setImageResource(2131691077);
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
      localObject1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYw, "");
      localObject2 = Build.MANUFACTURER.toLowerCase();
      str = Build.MODEL.toLowerCase();
      ac.i("MicroMsg.AlbumPreviewUI", "pennqin, manufacturer: %s, model: %s, smartGalleryBlackList: %s.", new Object[] { localObject2, str, localObject1 });
      if ((((String)localObject1).contains((CharSequence)localObject2)) || (((String)localObject1).contains(str)))
      {
        bool = false;
        break label667;
      }
      bool = true;
      break label667;
      label1892:
      this.sPi.setVisibility(0);
      this.sPi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164797);
          AlbumPreviewUI.g(AlbumPreviewUI.this);
          paramAnonymousView = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
          com.tencent.mm.plugin.gallery.model.e.ab(AlbumPreviewUI.this.sPl.sOJ);
          paramAnonymousView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.sPl.cNv());
          paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", AlbumPreviewUI.this.sPl.sOK);
          paramAnonymousView.putExtra("max_select_count", AlbumPreviewUI.this.rXO);
          paramAnonymousView.putExtra("send_raw_img", AlbumPreviewUI.this.opQ);
          paramAnonymousView.putExtra("key_force_hide_edit_image_button", AlbumPreviewUI.h(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("key_force_show_raw_image_button", AlbumPreviewUI.i(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("key_is_raw_image_button_disable", AlbumPreviewUI.j(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.dng);
          paramAnonymousView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
          paramAnonymousView.putExtra("select_type_tag", AlbumPreviewUI.k(AlbumPreviewUI.this));
          AlbumPreviewUI.this.startActivityForResult(paramAnonymousView, 0);
          AppMethodBeat.o(164797);
        }
      });
      if (((this.sPO != 1) && (this.sPO != 2) && (this.sPO != 3)) || (this.rXO <= 0)) {
        break label827;
      }
      if (!bs.isNullOrNil(this.sPu))
      {
        addTextOptionMenu(0, this.sPu, this.sPS);
        break label827;
      }
      if (this.sPN == 15)
      {
        i = this.sPN;
        j = this.rXO;
        localObject2 = this.sOM;
        if (this.sPl == null) {}
        for (localObject1 = null;; localObject1 = this.sPl.sOK)
        {
          addTextOptionMenu(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, 0, j, (String)localObject2, (ArrayList)localObject1), this.sPS, null, s.b.How);
          break;
        }
      }
      i = this.sPN;
      int j = this.rXO;
      localObject2 = this.sOM;
      if (this.sPl == null) {}
      for (localObject1 = null;; localObject1 = this.sPl.sOK)
      {
        addTextOptionMenu(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, 0, j, (String)localObject2, (ArrayList)localObject1), this.sPS, null, s.b.Hoy);
        break;
      }
      label2115:
      initActionBarOperationArea();
      setActionbarColor(getResources().getColor(2131100399));
      if (this.sPO == 3)
      {
        initActionBarOperationAreaTxt(getString(2131759758));
        break label1551;
      }
      if (this.sPO == 1)
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
    ac.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d] %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    Object localObject2;
    if (4369 == paramInt1)
    {
      if (-1 != paramInt2)
      {
        AppMethodBeat.o(111478);
        return;
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.tools.q.h(getContext().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.aps());
      if (bs.isNullOrNil((String)localObject1))
      {
        ac.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
        AppMethodBeat.o(111478);
        return;
      }
      ac.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[] { localObject1 });
      if ((this.sPN == 0) || (this.sPN == 5) || (this.sPN == 11) || (this.sPN == 24))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setData(Uri.parse("file://" + Uri.encode((String)localObject1)));
        ac.i("MicroMsg.AlbumPreviewUI", "take photo finish");
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
            this.sPo.setVisibility(0);
            this.sPo.setText(getString(2131761897));
            localObject1 = AnimationUtils.loadAnimation(getContext(), 2130772047);
            this.sPo.startAnimation((Animation)localObject1);
            ((Animation)localObject1).setAnimationListener(new Animation.AnimationListener()
            {
              private Runnable sQe;
              
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                AppMethodBeat.i(111428);
                AlbumPreviewUI.A(AlbumPreviewUI.this).setVisibility(0);
                AlbumPreviewUI.A(AlbumPreviewUI.this).postDelayed(this.sQe, 4000L);
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
        ((Intent)localObject1).putExtra("send_raw_img", this.opQ);
        if ((this.sPx) || (this.sPy)) {}
        for (bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("key_force_hide_edit_image_button", bool);
          ((Intent)localObject1).putExtra("key_force_show_raw_image_button", this.sPz);
          ((Intent)localObject1).putExtra("key_is_raw_image_button_disable", this.sPA);
          ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
          if (this.sPl != null) {
            ((Intent)localObject1).putParcelableArrayListExtra("preview_media_item_list", this.sPl.sOK);
          }
          ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dng);
          ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject1).putExtra("select_type_tag", this.iCp);
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
            ac.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
            setResult(-1, paramIntent);
            finish();
            AppMethodBeat.o(111478);
            return;
          }
          localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
          {
            ac.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
            AppMethodBeat.o(111478);
            return;
          }
          ac.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", new Object[] { localObject1 });
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
          ac.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", new Object[] { paramIntent });
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
          ac.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", new Object[] { localObject1 });
          paramIntent = new ArrayList();
          localObject2 = getIntent().getStringExtra("video_full_path");
          if (!bs.isNullOrNil((String)localObject2))
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
            ac.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
          }
          ac.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
          setResult(-1, paramIntent);
          this.sPD = true;
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
          ac.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[] { localObject1 });
          paramIntent = (CaptureDataManager.CaptureVideoNormalModel)((Intent)localObject1).getParcelableExtra("KSEGMENTMEDIAINFO");
          if (paramIntent == null)
          {
            ac.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
            setResult(1);
            finish();
            AppMethodBeat.o(111478);
            return;
          }
          localObject2 = new ArrayList();
          localObject3 = paramIntent.videoPath;
          if (!bs.isNullOrNil((String)localObject3))
          {
            ((ArrayList)localObject2).add(localObject3);
            ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
          }
          if ((paramIntent.wql.booleanValue()) && (!bs.isNullOrNil(paramIntent.thumbPath)))
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
          ac.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[] { localObject1 });
          paramIntent = (SightCaptureResult)((Intent)localObject1).getParcelableExtra("key_req_result");
          if (paramIntent == null)
          {
            ac.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
            setResult(1);
            finish();
            AppMethodBeat.o(111478);
            return;
          }
          localObject2 = new ArrayList();
          localObject3 = paramIntent.uJo;
          if (!bs.isNullOrNil((String)localObject3))
          {
            ((ArrayList)localObject2).add(localObject3);
            ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
          }
          if ((paramIntent.uJm) && (!bs.isNullOrNil(paramIntent.uJu)))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramIntent.uJu);
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
          }
          setResult(-1, (Intent)localObject1);
          finish();
        }
        else if (4376 == paramInt1)
        {
          if (-1 != paramInt2)
          {
            ac.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
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
              setMMTitle(bs.bG(((GalleryItem.AlbumItem)localObject1).sJZ, getString(2131759758)));
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
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).dvk().x("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
              this.sPk = true;
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
              if (bs.isNullOrNil(this.sQb)) {
                break;
              }
              localObject2 = a.a.sIP;
              localObject3 = this.sQb;
              ac.i("MicroMsg.GalleryReporter", "path: %s.", new Object[] { localObject3 });
              localObject1 = paramIntent;
              if (bs.isNullOrNil((String)localObject3)) {
                break;
              }
              ((com.tencent.mm.plugin.gallery.a)localObject2).sIJ.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).sIK.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).sIL.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).sIM.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).sIN.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).sIO.remove(localObject3);
              localObject1 = paramIntent;
              break;
              if (paramInt2 == -2) {
                finish();
              }
            }
          }
          if (4382 == paramInt1)
          {
            ac.i("MicroMsg.AlbumPreviewUI", "back from smart gallery.");
            if (paramIntent != null)
            {
              localObject1 = paramIntent.getExtras();
              this.opQ = paramIntent.getBooleanExtra("send_raw_img", this.opQ);
              if (this.opQ)
              {
                this.sPr.setImageResource(2131691078);
                if (this.sPA) {
                  this.sPr.setImageResource(2131691075);
                }
                localObject2 = this.sPr;
                if (this.sPA) {
                  break label1896;
                }
                bool = true;
                ((ImageButton)localObject2).setEnabled(bool);
                localObject2 = this.sPq;
                if (this.sPA) {
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
                  ac.i("MicroMsg.AlbumPreviewUI", "key: %s, value: %s.", new Object[] { localObject3, ((Bundle)localObject1).get((String)localObject3) });
                }
                this.sPr.setImageResource(2131691077);
                break;
                bool = false;
                break label1784;
              }
            }
            if ((-2 == paramInt2) || (paramInt2 == 0) || (SmartGalleryUI.sTn == paramInt2))
            {
              ac.i("MicroMsg.AlbumPreviewUI", "just back from SmartGalleryUI.");
              paramIntent = new android.support.v4.e.b();
              paramInt1 = i;
              while (paramInt1 < this.sPl.sOK.size())
              {
                localObject1 = (GalleryItem.MediaItem)this.sPl.sOK.get(paramInt1);
                i = this.sPl.sOJ.indexOf(localObject1);
                if (i != -1) {
                  paramIntent.add(Integer.valueOf(i));
                }
                paramInt1 += 1;
              }
              this.sPl.dQ(com.tencent.mm.plugin.gallery.model.s.cNf().sKT);
              if (SmartGalleryUI.sTn == paramInt2)
              {
                cBu();
                AppMethodBeat.o(111478);
                return;
              }
              FZ(this.sPl.sOK.size());
              this.sPl.a(paramIntent);
              AppMethodBeat.o(111478);
              return;
            }
            if (-1 == paramInt2) {
              this.sPk = true;
            }
            setResult(paramInt2, paramIntent);
            finish();
            localObject1 = paramIntent;
          }
          else if (paramInt1 == 4381)
          {
            if (paramInt2 == -1)
            {
              if (this.sPw)
              {
                paramIntent = RecordConfigProvider.iw("", "");
                paramIntent.wqC = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
                paramIntent.scene = 2;
                localObject1 = new VideoCaptureReportInfo();
                ((VideoCaptureReportInfo)localObject1).qwN = 1;
                paramIntent.wqK = ((VideoCaptureReportInfo)localObject1);
                localObject1 = new UICustomParam.a();
                ((UICustomParam.a)localObject1).YX();
                ((UICustomParam.a)localObject1).YW();
                ((UICustomParam.a)localObject1).cN(true);
                paramIntent.wqu = ((UICustomParam.a)localObject1).fKH;
                paramIntent.D(3, VLogPreviewPluginLayout.class.getName());
                paramIntent.D(4, VLogPreviewPluginLayout.class.getName());
                localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772137, -1, paramIntent, 4, 0);
                AppMethodBeat.o(111478);
                return;
              }
              localObject1 = paramIntent;
              if (22 == com.tencent.mm.plugin.gallery.model.e.cMt().kxr)
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
              ac.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
              finish();
              localObject1 = paramIntent;
              break;
            case -1: 
              localObject1 = paramIntent;
              if (paramIntent == null)
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("CropImage_Compress_Img", true);
                ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", this.sPl.cNv());
              }
              ((Intent)localObject1).putStringArrayListExtra("key_select_image_list", ((Intent)localObject1).getStringArrayListExtra("CropImage_OutputPath_List"));
              ac.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
              this.sPk = true;
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
      ac.i("MicroMsg.AlbumPreviewUI", "paths size: %d.", new Object[] { Integer.valueOf(paramInt1) });
      if ((localObject1 == null) || (this.sPl == null)) {
        break label2612;
      }
      localObject2 = new android.support.v4.e.b();
      paramInt1 = 0;
      while (paramInt1 < this.sPl.sOK.size())
      {
        localObject3 = (GalleryItem.MediaItem)this.sPl.sOK.get(paramInt1);
        paramInt2 = this.sPl.sOJ.indexOf(localObject3);
        if (paramInt2 != -1) {
          ((android.support.v4.e.b)localObject2).add(Integer.valueOf(paramInt2));
        }
        paramInt1 += 1;
      }
    }
    this.sPl.ad((ArrayList)localObject1);
    this.sPl.a((android.support.v4.e.b)localObject2);
    FZ(((ArrayList)localObject1).size());
    label2612:
    if (!paramIntent.getBooleanExtra("CropImage_Compress_Img", true))
    {
      bool = true;
      label2626:
      this.opQ = bool;
      if (!this.opQ) {
        break label2724;
      }
      this.sPr.setImageResource(2131691078);
      label2649:
      if (this.sPA) {
        this.sPr.setImageResource(2131691075);
      }
      localObject1 = this.sPr;
      if (this.sPA) {
        break label2737;
      }
      bool = true;
      label2682:
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.sPq;
      if (this.sPA) {
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
      this.sPr.setImageResource(2131691077);
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
    ac.i("MicroMsg.AlbumPreviewUI", "onCreate, %s.", new Object[] { this });
    setRequestedOrientation(1);
    String str1 = getString(2131761885);
    String str2 = getString(2131759773);
    this.sPP = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, str1, str2);
    ac.d("MicroMsg.AlbumPreviewUI", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(this.sPP) });
    this.sPH = System.currentTimeMillis();
    start = System.currentTimeMillis();
    this.fts = com.tencent.mm.ui.base.p.a(this, getString(2131755936), false);
    this.sPV = AlbumPreviewUI.b.sQl;
    if (paramBundle != null)
    {
      ac.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
      this.sPN = paramBundle.getInt("constants_key_query_source");
    }
    for (this.sPO = paramBundle.getInt("constants_key_query_type");; this.sPO = getIntent().getIntExtra("query_media_type", 1))
    {
      com.tencent.mm.plugin.gallery.model.e.cMt().kxr = this.sPN;
      com.tencent.mm.plugin.gallery.model.e.cMt().setQueryType(this.sPO);
      ac.i("MicroMsg.AlbumPreviewUI", "query source: " + this.sPN + ", queryType: " + this.sPO);
      this.iCp = getIntent().getIntExtra("select_type_tag", 3);
      this.oUy = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTO, true);
      this.sPM = getIntent().getBooleanExtra("is_from_smart_gallery", false);
      initView();
      if (this.sPP) {
        cND();
      }
      com.tencent.mm.plugin.gallery.model.e.cMB();
      AppMethodBeat.o(111464);
      return;
      this.sPN = getIntent().getIntExtra("query_source_type", 3);
    }
  }
  
  public void onDestroy()
  {
    boolean bool1 = false;
    AppMethodBeat.i(111469);
    super.onDestroy();
    ac.i("MicroMsg.AlbumPreviewUI", "onDestroy, %s.", new Object[] { this });
    if (com.tencent.mm.plugin.gallery.model.e.cMt() != null)
    {
      com.tencent.mm.plugin.gallery.model.e.cMt().sKw.remove(this);
      o localo = com.tencent.mm.plugin.gallery.model.e.cMt();
      i.b localb = this.sPL;
      if (localb != null) {
        localo.sKx.remove(localb);
      }
    }
    if ((this.sPE > 0) || (this.sPF > 0))
    {
      ac.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", new Object[] { Integer.valueOf(this.sPE), Integer.valueOf(this.sPF) });
      com.tencent.mm.plugin.gallery.a.d.bi(11187, this.sPE + "," + this.sPF);
    }
    for (;;)
    {
      if ((this.sPG > 0L) || (this.sPk)) {
        com.tencent.mm.plugin.gallery.model.e.a(this.sPu, ae(this.sPl.sOK), this.opQ, this.sPj);
      }
      int i = this.sPl.sOK.size();
      boolean bool2 = this.opQ;
      if ((this.sPG > 0L) || (this.sPk)) {
        bool1 = true;
      }
      com.tencent.mm.plugin.gallery.model.e.e(i, bool2, bool1);
      y.cGI.Ix().Iw();
      com.tencent.mm.plugin.gallery.model.e.cMw().clear();
      com.tencent.mm.plugin.gallery.model.e.cMx().clear();
      com.tencent.mm.plugin.gallery.model.e.cMy().clear();
      if (!this.sPM) {
        break;
      }
      com.tencent.mm.plugin.gallery.model.s.cNf().sKR = true;
      if (com.tencent.mm.plugin.gallery.model.e.cMC())
      {
        com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.heY).aew();
        a.g.cNz();
      }
      AppMethodBeat.o(111469);
      return;
      ac.d("MicroMsg.AlbumPreviewUI", "not click camera or folder.");
    }
    if (!this.iWQ) {
      a.a.sIP.report();
    }
    for (;;)
    {
      com.tencent.mm.plugin.gallery.model.s.cNf().sKS = true;
      com.tencent.mm.plugin.gallery.model.e.cMt().cNc();
      break;
      a.a.sIP.reset();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111477);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      ac.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
      setResult(-2);
      if ((this.sPp != null) && (this.sPp.hW))
      {
        this.sPp.cNL();
        playActionBarOperationAreaAnim();
        AppMethodBeat.o(111477);
        return true;
      }
      this.iWQ = true;
      finish();
      AppMethodBeat.o(111477);
      return true;
    }
    if (paramInt == 82)
    {
      this.sPF += 1;
      if (this.sPp != null) {
        this.sPp.cNL();
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
    ac.i("MicroMsg.AlbumPreviewUI", "on onPause, %s.", new Object[] { this });
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    this.sPC = true;
    ImageFolderMgrView localImageFolderMgrView;
    if ((!isFinishing()) && (!isDestroyed()) && (this.sPp != null) && (this.sPp.hW))
    {
      localImageFolderMgrView = this.sPp;
      if (localImageFolderMgrView.hW) {
        break label132;
      }
      ac.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
    }
    for (;;)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, this.fsu);
      this.fsu = 0;
      if (this.sPM) {
        com.tencent.mm.plugin.gallery.model.s.cNf().dP(this.sPl.sOK);
      }
      AppMethodBeat.o(111467);
      return;
      label132:
      if (localImageFolderMgrView.sRo)
      {
        ac.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
      }
      else
      {
        localImageFolderMgrView.sRk.setVisibility(8);
        localImageFolderMgrView.hW = false;
        if (localImageFolderMgrView.sRs != null) {
          localImageFolderMgrView.sRs.my(false);
        }
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(111483);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(111483);
      return;
    }
    ac.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111483);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cNE();
        AppMethodBeat.o(111483);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131759760), false, new AlbumPreviewUI.6(this), null);
      AppMethodBeat.o(111483);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cNC();
        com.tencent.mm.plugin.gallery.model.e.cMt().cNb();
        cND();
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
    ac.i("MicroMsg.AlbumPreviewUI", "onResume, %s.", new Object[] { this });
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    this.sPC = false;
    AppMethodBeat.o(111465);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(111470);
    super.onSaveInstanceState(paramBundle);
    ac.i("MicroMsg.AlbumPreviewUI", "onSaveInstanceState, %s.", new Object[] { this });
    paramBundle.putInt("constants_key_query_source", this.sPN);
    paramBundle.putInt("constants_key_query_type", this.sPO);
    AppMethodBeat.o(111470);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(111466);
    super.onStart();
    ac.i("MicroMsg.AlbumPreviewUI", "onStart, %s.", new Object[] { this });
    if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr != this.sPN) {
      com.tencent.mm.plugin.gallery.model.e.cMt().kxr = this.sPN;
    }
    if (com.tencent.mm.plugin.gallery.model.e.cMt().sKz != this.sPO) {
      com.tencent.mm.plugin.gallery.model.e.cMt().setQueryType(this.sPO);
    }
    AppMethodBeat.o(111466);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(111468);
    super.onStop();
    ac.i("MicroMsg.AlbumPreviewUI", "onStop, %s.", new Object[] { this });
    if (!this.sPM)
    {
      com.tencent.mm.plugin.gallery.model.c localc = com.tencent.mm.plugin.gallery.model.e.cMs();
      if ((localc.sJb != null) && (!localc.sJb.isEmpty()))
      {
        Iterator localIterator = localc.sJb.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.c localc1 = (c.c)((Map.Entry)localIterator.next()).getValue();
          if (localc1 != null) {
            localc1.mCancel = true;
          }
        }
        if (localc.sJa != null) {
          localc.sJa.clear();
        }
        if ((localc.sJb != null) && (!localc.sJb.isEmpty())) {
          localc.sJb.clear();
        }
        localc.sIY.cMo();
      }
      com.tencent.mm.plugin.gallery.model.e.cMs().cMn();
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
    WeakReference<AlbumPreviewUI> lpX;
    
    a(AlbumPreviewUI paramAlbumPreviewUI)
    {
      AppMethodBeat.i(111448);
      this.lpX = new WeakReference(paramAlbumPreviewUI);
      AppMethodBeat.o(111448);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111449);
      long l = System.currentTimeMillis();
      boolean bool = com.tencent.mm.plugin.gallery.model.s.cNf().cNh();
      l = System.currentTimeMillis() - l;
      ac.i("MicroMsg.AlbumPreviewUI", "smart gallery isValid: %s, dur: %s.", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.h.wUl.f(19165, new Object[] { Long.valueOf(l) });
      if (l <= 3000L) {
        com.tencent.mm.plugin.report.service.h.wUl.dB(1297, 0);
      }
      for (;;)
      {
        if (bool)
        {
          a.a.sIP.sIB = 1;
          com.tencent.mm.plugin.gallery.model.e.cMu().f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111447);
              if (AlbumPreviewUI.a.this.lpX != null)
              {
                AlbumPreviewUI localAlbumPreviewUI = (AlbumPreviewUI)AlbumPreviewUI.a.this.lpX.get();
                if (localAlbumPreviewUI != null)
                {
                  localAlbumPreviewUI.setSmartGalleryEntryVisibility(true);
                  localAlbumPreviewUI.sPY = true;
                }
              }
              AppMethodBeat.o(111447);
            }
          });
        }
        AppMethodBeat.o(111449);
        return;
        if (l <= 5000L) {
          com.tencent.mm.plugin.report.service.h.wUl.dB(1297, 1);
        } else if (l <= 10000L) {
          com.tencent.mm.plugin.report.service.h.wUl.dB(1297, 2);
        } else if (l <= 15000L) {
          com.tencent.mm.plugin.report.service.h.wUl.dB(1297, 3);
        } else {
          com.tencent.mm.plugin.report.service.h.wUl.dB(1297, 4);
        }
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    String sPK;
    WeakReference<a> sQo;
    WeakReference<ProgressDialog> sQp;
    WeakReference<TextView> sQq;
    WeakReference<RecyclerView> sQr;
    LinkedList<GalleryItem.MediaItem> sQs;
    WeakReference<ImageFolderMgrView> sQt;
    boolean sQu = false;
    
    public final void run()
    {
      AppMethodBeat.i(111455);
      if (this.sQs == null) {}
      for (int i = -1;; i = this.sQs.size())
      {
        ac.d("MicroMsg.AlbumPreviewUI", "on NotifyMediaItemsChanged, size %d", new Object[] { Integer.valueOf(i) });
        AlbumPreviewUI.ar(this.sQs);
        if (this.sQo != null) {
          break;
        }
        ac.w("MicroMsg.AlbumPreviewUI", "null == adapterRef");
        AppMethodBeat.o(111455);
        return;
      }
      Object localObject1 = (a)this.sQo.get();
      if (localObject1 == null)
      {
        ac.w("MicroMsg.AlbumPreviewUI", "null == adapter");
        AppMethodBeat.o(111455);
        return;
      }
      if (this.sQr == null)
      {
        AppMethodBeat.o(111455);
        return;
      }
      RecyclerView localRecyclerView = (RecyclerView)this.sQr.get();
      if (localRecyclerView == null)
      {
        AppMethodBeat.o(111455);
        return;
      }
      ac.d("MicroMsg.AlbumPreviewUI", "isSwitchAlbum: %s.", new Object[] { Boolean.valueOf(this.sQu) });
      Object localObject2 = com.tencent.mm.plugin.gallery.model.p.sKH;
      localObject2 = com.tencent.mm.plugin.gallery.model.p.cNd();
      Object localObject3 = this.sQs;
      k.h(localObject3, "mediaItems");
      ac.d("MicroMsg.PreLoadManager", "syncMediaItems, size: %s.", new Object[] { Integer.valueOf(((List)localObject3).size()) });
      ((com.tencent.mm.plugin.gallery.model.p)localObject2).sKE.clear();
      ((com.tencent.mm.plugin.gallery.model.p)localObject2).sKE.addAll((Collection)localObject3);
      if (this.sQu)
      {
        this.sQu = false;
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((a)localObject1).ap(this.sQs);
        localObject2 = com.tencent.mm.plugin.gallery.model.p.sKH;
        localObject2 = com.tencent.mm.plugin.gallery.model.p.cNd();
        localObject3 = p.c.sKK;
        if (this.sQs.size() > 32)
        {
          i = 32;
          ((com.tencent.mm.plugin.gallery.model.p)localObject2).a((p.c)localObject3, 0, i, ((a)localObject1).sOJ.size());
        }
      }
      for (;;)
      {
        if (this.sQp != null) {
          break label389;
        }
        AppMethodBeat.o(111455);
        return;
        i = this.sQs.size();
        break;
        ((a)localObject1).aq(this.sQs);
      }
      label389:
      localObject2 = (ProgressDialog)this.sQp.get();
      if ((localObject2 != null) && (((ProgressDialog)localObject2).isShowing()))
      {
        ((ProgressDialog)localObject2).dismiss();
        ac.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start) });
      }
      if (this.sQt != null)
      {
        localObject2 = (ImageFolderMgrView)this.sQt.get();
        if (localObject2 != null) {
          ((ImageFolderMgrView)localObject2).setFavItemCount(this.sQs.size());
        }
      }
      if ((this.sQq == null) || (bs.isNullOrNil(this.sPK)))
      {
        AppMethodBeat.o(111455);
        return;
      }
      localObject2 = (TextView)this.sQq.get();
      if (localObject2 != null)
      {
        localObject1 = ((a)localObject1).FY(((GridLayoutManager)localRecyclerView.getLayoutManager()).jW());
        if ((!bs.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("album_business_bubble_media_by_coordinate")))
        {
          ((TextView)localObject2).setVisibility(0);
          ((TextView)localObject2).setText(this.sPK.concat("附近的照片和视频"));
          ((TextView)localObject2).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111454);
              if (8 == this.sQv.getVisibility())
              {
                AppMethodBeat.o(111454);
                return;
              }
              this.sQv.animate().alpha(0.0F).setDuration(300L).withEndAction(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111453);
                  AlbumPreviewUI.c.1.this.sQv.setVisibility(8);
                  AlbumPreviewUI.c.1.this.sQv.setAlpha(1.0F);
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
  
  static final class d
    implements Runnable
  {
    private WeakReference<ProgressDialog> sQA;
    private WeakReference<RecyclerView> sQB;
    private String sQy;
    private WeakReference<a> sQz;
    
    d(String paramString, a parama, ProgressDialog paramProgressDialog, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(111458);
      this.sQy = paramString;
      this.sQz = new WeakReference(parama);
      this.sQA = new WeakReference(paramProgressDialog);
      this.sQB = new WeakReference(paramRecyclerView);
      AppMethodBeat.o(111458);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111459);
      if (bs.isNullOrNil(this.sQy))
      {
        AppMethodBeat.o(111459);
        return;
      }
      ac.i("QuerySmartGalleryAlbumMediaTask", "start query.");
      com.tencent.mm.plugin.gallery.model.s locals = com.tencent.mm.plugin.gallery.model.s.cNf();
      Object localObject1 = this.sQy;
      s.h local1 = new s.h()
      {
        public final void b(List<s.g> paramAnonymousList, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(161161);
          if (AlbumPreviewUI.d.a(AlbumPreviewUI.d.this) != null)
          {
            localObject = (a)AlbumPreviewUI.d.a(AlbumPreviewUI.d.this).get();
            if (localObject != null)
            {
              if ((!paramAnonymousBoolean) && (((a)localObject).sOJ.size() <= paramAnonymousList.size())) {
                break label148;
              }
              AlbumPreviewUI.d.dS(paramAnonymousList);
            }
          }
          Object localObject = new LinkedList();
          paramAnonymousList = paramAnonymousList.iterator();
          for (;;)
          {
            if (!paramAnonymousList.hasNext()) {
              break label229;
            }
            s.g localg = (s.g)paramAnonymousList.next();
            GalleryItem.MediaItem localMediaItem;
            if (localg.type.contains("image"))
            {
              localMediaItem = GalleryItem.MediaItem.a(1, localg.sLj, localg.data, "", localg.type);
              localMediaItem.sKl = localg.sLk;
              ((LinkedList)localObject).add(localMediaItem);
              continue;
              label148:
              AlbumPreviewUI.d.dS(paramAnonymousList.subList(((a)localObject).sOJ.size(), paramAnonymousList.size()));
              break;
            }
            if (localg.type.contains("video"))
            {
              localMediaItem = GalleryItem.MediaItem.a(2, localg.sLj, localg.data, "", localg.type);
              localMediaItem.sKl = localg.sLk;
              ((LinkedList)localObject).add(localMediaItem);
            }
          }
          label229:
          paramAnonymousList = new AlbumPreviewUI.c((byte)0);
          paramAnonymousList.sQo = AlbumPreviewUI.d.a(AlbumPreviewUI.d.this);
          paramAnonymousList.sQp = AlbumPreviewUI.d.b(AlbumPreviewUI.d.this);
          paramAnonymousList.sQs = ((LinkedList)localObject);
          paramAnonymousList.sQr = AlbumPreviewUI.d.c(AlbumPreviewUI.d.this);
          paramAnonymousList.sQu = paramAnonymousBoolean;
          com.tencent.mm.plugin.gallery.model.e.cMu().f(paramAnonymousList);
          ac.i("QuerySmartGalleryAlbumMediaTask", "finish page query.");
          AppMethodBeat.o(161161);
        }
      };
      locals.sKR = false;
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = com.tencent.mm.plugin.gallery.model.s.BASE_URI.buildUpon().appendEncodedPath("albumInfo").build();
      localObject1 = locals.gne.query((Uri)localObject2, new String[] { "_id", "_data", "mime_type", "date_modified", "datetaken", "latitude", "longitude" }, "albumID=?", new String[] { localObject1 }, null);
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
          if (locals.sKR) {
            break label384;
          }
          localObject2 = new s.g();
          ((s.g)localObject2).sLj = bs.aLz(((Cursor)localObject1).getString(i));
          ((s.g)localObject2).data = ((Cursor)localObject1).getString(j);
          ((s.g)localObject2).type = ((Cursor)localObject1).getString(k);
          ((s.g)localObject2).sLk = bs.aLz(((Cursor)localObject1).getString(m));
          ac.d("MicroMsg.SmartGalleryQueryUtil", "mediaID:%d data:%s type:%s.", new Object[] { Long.valueOf(((s.g)localObject2).sLj), ((s.g)localObject2).data, ((s.g)localObject2).type });
          localArrayList.add(localObject2);
          if (localArrayList.size() % locals.sKQ == 0)
          {
            local1.b(localArrayList, bool);
            if (bool) {
              bool = false;
            }
          }
        }
        ((Cursor)localObject1).close();
      }
      for (;;)
      {
        local1.b(localArrayList, bool);
        label384:
        AppMethodBeat.o(111459);
        return;
        bool = true;
      }
    }
  }
  
  static final class e
    implements Runnable
  {
    List<Long> idList;
    boolean sQD;
    WeakReference<a> sQo;
    WeakReference<ProgressDialog> sQp;
    WeakReference<ImageFolderMgrView> sQt;
    int type;
    
    public final void run()
    {
      AppMethodBeat.i(111462);
      com.tencent.mm.plugin.gallery.model.s locals = com.tencent.mm.plugin.gallery.model.s.cNf();
      i.c local1 = new i.c()
      {
        public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(111461);
          ac.i("MicroMsg.AlbumPreviewUI", "RetrieveFavMediaTask onQueryMediaFinished cancelUINotify: %s.", new Object[] { Boolean.valueOf(AlbumPreviewUI.e.this.sQD) });
          if (AlbumPreviewUI.e.this.sQD)
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
            ac.d("MicroMsg.AlbumPreviewUI", "type: %s path: %s", new Object[] { localMediaItem.mMimeType, localMediaItem.sKh });
          }
          paramAnonymousLinkedList = new AlbumPreviewUI.c((byte)0);
          paramAnonymousLinkedList.sQo = AlbumPreviewUI.e.this.sQo;
          paramAnonymousLinkedList.sQp = AlbumPreviewUI.e.this.sQp;
          paramAnonymousLinkedList.sQs = localLinkedList;
          paramAnonymousLinkedList.sQt = AlbumPreviewUI.e.this.sQt;
          com.tencent.mm.plugin.gallery.model.e.cMu().f(paramAnonymousLinkedList);
          AppMethodBeat.o(111461);
        }
      };
      Object localObject2 = this.idList;
      int i1 = this.type;
      locals.sKS = false;
      LinkedList localLinkedList = new LinkedList();
      Object localObject1 = localObject2;
      if (bs.gY((List)localObject2))
      {
        ac.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id list now.");
        ac.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id, type: %d.", new Object[] { Integer.valueOf(i1) });
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
          if (!bs.gY((List)localObject2))
          {
            ac.i("MicroMsg.SmartGalleryQueryUtil", "fav list contains img or video.");
            ((List)localObject1).addAll((Collection)localObject2);
          }
          if (!bs.gY((List)localObject1)) {
            break;
          }
          ac.i("MicroMsg.SmartGalleryQueryUtil", "fav list do not contain img or video.");
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
      ac.i("MicroMsg.SmartGalleryQueryUtil", "fav count: %d.", new Object[] { Integer.valueOf(m) });
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
        if (!locals.sKS)
        {
          ac.i("MicroMsg.SmartGalleryQueryUtil", "get fav, count: %d.", new Object[] { Integer.valueOf(k) });
          localLinkedList.addAll(com.tencent.mm.plugin.gallery.model.s.p(((List)localObject1).subList(j, i), i1));
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