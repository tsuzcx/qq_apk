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
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.i.b;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.model.p.a;
import com.tencent.mm.plugin.gallery.model.p.c;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.plugin.gallery.model.s.a;
import com.tencent.mm.plugin.gallery.model.s.g;
import com.tencent.mm.plugin.gallery.model.s.h;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout.a;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.AlbumChooserView.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.k;
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
  protected String dzZ;
  private int fMX;
  private ProgressDialog fOC;
  private int iYs;
  private List<Long> idList;
  private boolean jsS;
  protected int jxK;
  private double latitude;
  private double longitude;
  private int nuk;
  public boolean oZN;
  private boolean pEM;
  protected RecyclerView tWC;
  private TextView tWD;
  private boolean tWE;
  private boolean tWF;
  protected a tWG;
  private TextView tWH;
  private TextView tWI;
  private TextView tWJ;
  private ImageFolderMgrView tWK;
  private TextView tWL;
  private ImageButton tWM;
  private String tWN;
  private String tWO;
  private String tWP;
  private boolean tWQ;
  private boolean tWR;
  private boolean tWS;
  private boolean tWT;
  private boolean tWU;
  private boolean tWV;
  private boolean tWW;
  private boolean tWX;
  boolean tWY;
  private int tWZ;
  protected String tWh;
  private a.f tWm;
  private int tXa;
  private long tXb;
  private long tXc;
  private int tXd;
  protected int tXe;
  private String tXf;
  private i.b tXg;
  private boolean tXh;
  protected int tXi;
  protected int tXj;
  private boolean tXk;
  private e tXl;
  private volatile long tXm;
  protected MenuItem.OnMenuItemClickListener tXn;
  private GalleryItem.AlbumItem tXo;
  private a.d tXp;
  private volatile AlbumPreviewUI.b tXq;
  private HashMap<String, Integer> tXr;
  private HashSet<String> tXs;
  boolean tXt;
  private p.c tXu;
  private int tXv;
  private String tXw;
  protected int tfW;
  protected String toUser;
  
  public AlbumPreviewUI()
  {
    AppMethodBeat.i(111463);
    this.tWR = false;
    this.oZN = false;
    this.tWW = false;
    this.tWX = false;
    this.tWY = false;
    this.tWZ = 0;
    this.tXa = 0;
    this.tXb = 0L;
    this.tXd = -1;
    this.pEM = true;
    this.idList = new ArrayList();
    this.iYs = 3;
    this.tXm = -1L;
    this.tXn = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(164796);
        int i = paramAnonymousMenuItem.getItemId();
        ae.d("MicroMsg.AlbumPreviewUI", "mId: %d.", new Object[] { Integer.valueOf(i) });
        if (1 == i)
        {
          ae.i("MicroMsg.AlbumPreviewUI", "go smart gallery.");
          a.a.tQr.tQe = 1;
          s.cYc().ed(AlbumPreviewUI.this.tWG.tWf);
          paramAnonymousMenuItem = new Intent(AlbumPreviewUI.this, SmartGalleryUI.class);
          paramAnonymousMenuItem.putExtra("select_type_tag", 2);
          paramAnonymousMenuItem.putExtras(AlbumPreviewUI.this.getIntent());
          paramAnonymousMenuItem.putExtra("send_raw_img", AlbumPreviewUI.this.oZN);
          AlbumPreviewUI.this.startActivityForResult(paramAnonymousMenuItem, 4382);
          AppMethodBeat.o(164796);
          return true;
        }
        boolean bool = AlbumPreviewUI.this.cLX();
        AppMethodBeat.o(164796);
        return bool;
      }
    };
    this.tXr = new HashMap();
    this.tWm = new a.f()
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
    this.tXu = p.c.tSm;
    this.tXv = -1;
    this.nuk = -1;
    this.jsS = false;
    this.tXw = "";
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
        if ((!bu.isNullOrNil(localMediaItem.mMimeType)) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
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
  
  private void alV(String paramString)
  {
    AppMethodBeat.i(173773);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
      AppMethodBeat.o(173773);
      return;
    }
    e.cXs().aj(new d(paramString, this.tWG, this.fOC, this.tWC));
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
    if (paramAlbumItem.DRp) {}
    for (this.iYs = 3; bu.bI(this.tWO, "").equals(paramAlbumItem.tRB); this.iYs = 4)
    {
      ae.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
      AppMethodBeat.o(111472);
      return;
    }
    e.cXw().addAll(this.tWG.tWf);
    ae.i("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[] { paramAlbumItem.tRB, paramAlbumItem.axP() });
    this.tWN = paramAlbumItem.axP();
    this.tWO = paramAlbumItem.tRB;
    if (bu.isNullOrNil(this.tWN))
    {
      ae.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
      this.tWN = this.tWO;
    }
    Object localObject1;
    Object localObject2;
    label221:
    int i;
    if (!bu.isNullOrNil(this.tWO))
    {
      localObject1 = this.tWG;
      localObject2 = this.tXp;
      if (localObject2 == null)
      {
        ae.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
        localObject2 = paramAlbumItem.bVF;
        localObject1 = localObject2;
        if (bu.isNullOrNil((String)localObject2))
        {
          if (this.tXj != 3) {
            break label428;
          }
          localObject1 = getString(2131759758);
        }
        updateActionBarOperationAreaTxt((String)localObject1);
        HL(this.tWG.tWf.size());
        this.fOC.show();
        start = System.currentTimeMillis();
        localObject2 = this.tWO;
        i = this.tXj;
        localObject1 = localObject2;
        if (((String)localObject2).equals(getString(2131759759)))
        {
          localObject1 = "";
          i = 2;
        }
        if (!this.tWO.equalsIgnoreCase(getString(2131759764))) {
          break label458;
        }
        if (this.tXl != null) {
          this.tXl.tXY = false;
        }
        e.cXs().ak(this.tXl);
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
        com.tencent.mm.plugin.report.service.g.yxI.f(18269, new Object[] { URLEncoder.encode((String)localObject1, "utf-8"), URLEncoder.encode(paramAlbumItem.bVF, "utf-8") });
        AppMethodBeat.o(111472);
        return;
      }
      catch (Exception paramAlbumItem)
      {
        AppMethodBeat.o(111472);
      }
      ((a)localObject1).tWi.remove(localObject2);
      break;
      if (!getIntent().getBooleanExtra("show_header_view", true)) {
        break;
      }
      this.tWG.a(this.tXp);
      break;
      label428:
      if (this.tXj == 1)
      {
        localObject1 = getString(2131759757);
        break label221;
      }
      localObject1 = getString(2131759759);
      break label221;
      label458:
      if ((paramAlbumItem instanceof GalleryItem.PrivateAlbumItem))
      {
        e.cXr().cXZ();
        this.tXm = System.currentTimeMillis();
        s.cYc().tSs = true;
        localObject1 = ((GalleryItem.PrivateAlbumItem)paramAlbumItem).tRS.tSw;
        if (bu.isNullOrNil((String)localObject1)) {
          ae.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
        } else {
          e.cXs().ak(new d((String)localObject1, this.tWG, this.fOC, this.tWC));
        }
      }
      else
      {
        if (this.tXl != null) {
          this.tXl.tXY = true;
        }
        s.cYc().tSt = true;
        s.cYc().tSs = true;
        this.tXm = System.currentTimeMillis();
        e.cXr().E((String)localObject1, i, this.tXm);
      }
    }
  }
  
  private void cYA()
  {
    AppMethodBeat.i(173772);
    if (this.tXh)
    {
      this.tWG.ee(s.cYc().tSu);
      e.cXw().addAll(this.tWG.tWf);
      HL(this.tWG.tWf.size());
      alV(getIntent().getStringExtra("album_id_from_smart_gallery"));
      this.fOC.show();
      AppMethodBeat.o(173772);
      return;
    }
    com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.hzU).azk();
    if (getIntent().hasExtra("gallery_report_tag")) {
      a.a.tQr.setScene(getIntent().getIntExtra("gallery_report_tag", 3));
    }
    for (;;)
    {
      ae.i("MicroMsg.AlbumPreviewUI", "start queryMediaInAlbums %s", new Object[] { this });
      e.cXr().a(this);
      this.tXm = System.currentTimeMillis();
      e.cXr().ax(this.tWO, this.tXm);
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111422);
          ae.d("MicroMsg.AlbumPreviewUI", "onCreate, post delay, dialog show.");
          if (AlbumPreviewUI.b.tXH != AlbumPreviewUI.a(AlbumPreviewUI.this)) {
            AlbumPreviewUI.b(AlbumPreviewUI.this).show();
          }
          AppMethodBeat.o(111422);
        }
      }, 300L);
      p.a locala = com.tencent.mm.plugin.gallery.model.p.tSj;
      com.tencent.mm.plugin.gallery.model.p.cYa().a(new l());
      locala = com.tencent.mm.plugin.gallery.model.p.tSj;
      com.tencent.mm.plugin.gallery.model.p.cYa().a(new com.tencent.mm.plugin.gallery.model.q());
      AppMethodBeat.o(173772);
      return;
      a.a.tQr.setScene(this.tXi);
    }
  }
  
  private void cYB()
  {
    AppMethodBeat.i(111476);
    if (!com.tencent.mm.pluginsdk.ui.tools.q.d(getContext(), com.tencent.mm.loader.j.b.asv(), "microMsg." + System.currentTimeMillis() + ".jpg", 4369))
    {
      Toast.makeText(getContext(), getString(2131763022), 1).show();
      AppMethodBeat.o(111476);
      return;
    }
    System.gc();
    AppMethodBeat.o(111476);
  }
  
  private void cYC()
  {
    AppMethodBeat.i(186185);
    if (this.tXs == null)
    {
      this.tXs = new HashSet();
      this.tXs.add(".h264");
      this.tXs.add(".h26l");
      this.tXs.add(".264");
      this.tXs.add(".avc");
      this.tXs.add(".mov");
      this.tXs.add(".mp4");
      this.tXs.add(".m4a");
      this.tXs.add(".3gp");
      this.tXs.add(".3g2");
      this.tXs.add(".mj2");
      this.tXs.add(".m4v");
    }
    AppMethodBeat.o(186185);
  }
  
  private void cYD()
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
      ae.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", new Object[] { localIntent });
      startActivityForResult(localIntent, 4371);
      AppMethodBeat.o(111485);
      return;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.AlbumPreviewUI", localException.toString());
      if ((!com.tencent.mm.r.a.n(getContext(), true)) && (!com.tencent.mm.r.a.cf(getContext())) && (!com.tencent.mm.r.a.cj(getContext()))) {
        com.tencent.mm.compatible.h.b.w(getContext());
      }
      AppMethodBeat.o(111485);
    }
  }
  
  private void cYz()
  {
    AppMethodBeat.i(173771);
    Object localObject = e.cXs();
    a locala = new a(this);
    localObject = ((com.tencent.mm.plugin.gallery.model.g)localObject).cXM();
    if (localObject != null)
    {
      ((aq)localObject).post(locala);
      AppMethodBeat.o(173771);
      return;
    }
    ae.w("MicroMsg.GalleryHandlerThread", "other handler is null.");
    AppMethodBeat.o(173771);
  }
  
  private static void ef(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111480);
    long l = System.currentTimeMillis();
    ae.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (!com.tencent.mm.vfs.o.fB(localMediaItem.tRJ))
      {
        ae.w("MicroMsg.AlbumPreviewUI", "filter non exist media: %s.", new Object[] { localMediaItem.tRJ });
        ((LinkedList)localObject).add(localMediaItem);
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.remove((GalleryItem.MediaItem)((Iterator)localObject).next());
    }
    ae.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia cost: %s.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(111480);
  }
  
  protected final void HL(int paramInt)
  {
    AppMethodBeat.i(111479);
    label37:
    int i;
    int j;
    String str;
    if (paramInt == 0)
    {
      this.tWD.setEnabled(false);
      enableOptionMenu(false);
      if (paramInt != 0) {
        break label102;
      }
      this.tWD.setText(2131759784);
      i = this.tXi;
      j = this.tfW;
      str = this.tWh;
      if (this.tWG != null) {
        break label148;
      }
    }
    label148:
    for (ArrayList localArrayList = null;; localArrayList = this.tWG.tWf)
    {
      updateOptionMenuText(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, paramInt, j, str, localArrayList));
      AppMethodBeat.o(111479);
      return;
      this.tWD.setEnabled(true);
      enableOptionMenu(true);
      break;
      label102:
      this.tWD.setText(getString(2131759784) + "(" + paramInt + ")");
      break label37;
    }
  }
  
  protected boolean a(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(186184);
    if (paramMediaItem == null)
    {
      ae.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
      AppMethodBeat.o(186184);
      return false;
    }
    int i;
    if (this.tXi == 3) {
      if ((paramMediaItem instanceof GalleryItem.VideoMediaItem)) {
        if (("video/hevc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).ipJ)) && (com.tencent.mm.plugin.o.f.dpm())) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if ((bs(paramMediaItem.tRJ, true)) || (i == 0) || ((!bu.isNullOrNil(((GalleryItem.VideoMediaItem)paramMediaItem).ipK)) && (!"audio/mp4a-latm".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).ipK)))) {}
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label161;
        }
        com.tencent.mm.ui.base.h.cl(this, getString(2131759790));
        AppMethodBeat.o(186184);
        return false;
        if (!"video/avc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).ipJ)) {
          break label279;
        }
        i = 1;
        break;
      }
      label161:
      if ((this.tXi == 3) || (this.tXi == 4) || (this.tXi == 14) || (this.tXi == 22))
      {
        if (!new k(paramMediaItem.tRJ).exists())
        {
          com.tencent.mm.ui.base.h.cl(this, getString(2131759808));
          AppMethodBeat.o(186184);
          return false;
        }
        if (com.tencent.mm.plugin.gallery.a.d.ame(paramMediaItem.tRJ) > 300)
        {
          com.tencent.mm.ui.base.h.cl(this, getString(2131759810));
          AppMethodBeat.o(186184);
          return false;
        }
        AppMethodBeat.o(186184);
        return true;
      }
      AppMethodBeat.o(186184);
      return true;
      label279:
      i = 0;
    }
  }
  
  protected void alU(String paramString) {}
  
  public final void aq(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111473);
    switch (this.tXj)
    {
    }
    Object localObject;
    do
    {
      do
      {
        AppMethodBeat.o(111473);
        return;
      } while ((bu.isNullOrNil(this.dzZ)) || ("medianote".equals(this.toUser)));
      if (bu.HQ() - this.tXb < 1000L)
      {
        ae.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111473);
        return;
      }
      ae.i("MicroMsg.AlbumPreviewUI", "notifyMM switch to SendImgProxyUI");
      localObject = (GalleryItem.MediaItem)this.tWG.tWe.get(paramInt);
    } while (((GalleryItem.MediaItem)localObject).getType() == 2);
    for (;;)
    {
      try
      {
        localObject = ((GalleryItem.MediaItem)localObject).tRJ;
        String str = this.toUser;
        if (!this.tWR) {
          if (!this.oZN)
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
    if (paramLong != this.tXm)
    {
      ae.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.tXm) });
      ae.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(111481);
      return;
    }
    ae.d("MicroMsg.AlbumPreviewUI", "onQueryMediaFinished: %s %s %s.", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.tWG.tWe.size()), Integer.valueOf(paramLinkedList.size()) });
    if ((paramBoolean) || (this.tWG.tWe.size() > paramLinkedList.size()))
    {
      ef(paramLinkedList);
      paramLinkedList = new LinkedList(paramLinkedList);
      if (this.tWG != null) {
        break label338;
      }
    }
    label338:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.AlbumPreviewUI", "[onQueryMediaFinished] adapter is null?:%s %s", new Object[] { Boolean.valueOf(bool), bu.fpN().toString() });
      if (this.tWG != null)
      {
        c localc = new c((byte)0);
        localc.tXJ = new WeakReference(this.tWG);
        localc.tXK = new WeakReference(this.fOC);
        localc.tXL = new WeakReference(this.tWI);
        localc.tXM = new WeakReference(this.tWC);
        localc.tXN = paramLinkedList;
        localc.tXf = this.tXf;
        localc.tXP = paramBoolean;
        if (AlbumPreviewUI.b.tXG == this.tXq) {
          this.tXq = AlbumPreviewUI.b.tXH;
        }
        e.cXs().f(localc);
      }
      AppMethodBeat.o(111481);
      return;
      ef(paramLinkedList.subList(this.tWG.tWe.size(), paramLinkedList.size()));
      break;
    }
  }
  
  public final boolean bs(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(186186);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(186186);
      return true;
    }
    cYC();
    paramString = paramString.trim();
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length()))
    {
      AppMethodBeat.o(186186);
      return true;
    }
    if ((paramBoolean) && (r.Hy(paramString)))
    {
      AppMethodBeat.o(186186);
      return true;
    }
    if (!this.tXs.contains(paramString.substring(i).toLowerCase()))
    {
      AppMethodBeat.o(186186);
      return true;
    }
    AppMethodBeat.o(186186);
    return false;
  }
  
  protected boolean cLX()
  {
    int j = 0;
    AppMethodBeat.i(111475);
    ae.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[] { Integer.valueOf(e.cXy()), Boolean.valueOf(this.tWR) });
    if (this.tWR) {}
    for (int i = 3;; i = 2)
    {
      com.tencent.mm.plugin.gallery.a.d.bk(11610, i + "," + e.cXy());
      if (this.tXd < 0) {
        this.tXd = com.tencent.mm.plugin.gallery.a.d.acr();
      }
      e.cXx();
      if (this.tWG.cYs().size() != 0) {
        break;
      }
      ae.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
      setResult(-2);
      finish();
      AppMethodBeat.o(111475);
      return true;
    }
    Object localObject1 = new Intent();
    i = this.tXj;
    if (this.tWW) {
      i = 1;
    }
    Object localObject5;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    GalleryItem.MediaItem localMediaItem;
    boolean bool;
    if (22 == e.cXr().kXg)
    {
      localObject5 = this.tWG.tWf;
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      localObject4 = new int[this.tfW];
      localObject5 = ((ArrayList)localObject5).iterator();
      i = j;
      while (((Iterator)localObject5).hasNext())
      {
        localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
        if (localMediaItem.getType() == 1)
        {
          if ((localMediaItem.mMimeType.equals("edit")) && (!bu.isNullOrNil(localMediaItem.tRL))) {
            ((ArrayList)localObject2).add(localMediaItem.tRL);
          }
          for (;;)
          {
            localObject4[i] = 1;
            i += 1;
            break;
            ((ArrayList)localObject2).add(localMediaItem.tRJ);
          }
        }
        if (localMediaItem.getType() == 2)
        {
          ((ArrayList)localObject3).add(localMediaItem.tRJ);
          localObject4[i] = 2;
          i += 1;
        }
      }
      bool = com.tencent.mm.plugin.gallery.a.d.cZa();
      if ((com.tencent.mm.plugin.recordvideo.activity.a.b.o((List)localObject2, (List)localObject3) == 4) && (bool))
      {
        localObject1 = VLogPreloadUI.ubj;
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
      if ((this.tWR) || (!this.oZN))
      {
        bool = true;
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
        localObject3 = this.tWG.tWf;
        localObject2 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label563;
        }
        localObject4 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
        if ((((GalleryItem.MediaItem)localObject4).mMimeType.equals("edit")) && (!bu.isNullOrNil(((GalleryItem.MediaItem)localObject4).tRL)))
        {
          ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).tRL);
          continue;
          bool = false;
          break;
        }
        ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).tRJ);
      }
      label563:
      ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
      ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.tXc);
      this.tXc = 0L;
      setResult(-1, (Intent)localObject1);
      if ((!bu.isNullOrNil(this.tWh)) && (this.tWh.equals("album_business_bubble_media_by_coordinate"))) {
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
      }
      if (bu.HQ() - this.tXb < 1000L)
      {
        ae.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111475);
        return true;
      }
      ae.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE switch to SendImgProxyUI");
      this.tXb = bu.HQ();
      if ((!bu.isNullOrNil(this.dzZ)) && (!"medianote".equals(this.toUser)))
      {
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
        ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dzZ);
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
      ae.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
      if (getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false)) {}
      for (i = 0;; i = ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).bgQ())
      {
        if (i != 0) {
          break label899;
        }
        ((Intent)localObject1).setData(com.tencent.mm.sdk.platformtools.o.a(getContext(), new k((String)this.tWG.cYs().get(0))));
        ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", this.tWG.cYs());
        setResult(-1, (Intent)localObject1);
        finish();
        break;
        localObject2 = com.tencent.mm.plugin.gallery.ui.a.a.amc((String)this.tWG.cYs().get(0));
        ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).mSize = this.tXd;
      }
      label899:
      if (i == 2)
      {
        com.tencent.mm.ui.base.h.l(this, 2131764674, 2131759817);
        ae.w("MicroMsg.AlbumPreviewUI", "video is import error");
        AppMethodBeat.o(111475);
        return true;
      }
      com.tencent.mm.ui.base.h.l(this, 2131759816, 2131759817);
      ae.w("MicroMsg.AlbumPreviewUI", "video is over size");
      AppMethodBeat.o(111475);
      return true;
    }
    if (i == 3)
    {
      if ((!bu.isNullOrNil(this.tWh)) && (this.tWh.equals("album_business_bubble_media_by_coordinate")))
      {
        localObject4 = this.tWG.tWf;
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (GalleryItem.MediaItem)((Iterator)localObject4).next();
          if (((GalleryItem.MediaItem)localObject5).getType() == 1)
          {
            if ((((GalleryItem.MediaItem)localObject5).mMimeType.equals("edit")) && (!bu.isNullOrNil(((GalleryItem.MediaItem)localObject5).tRL))) {
              ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).tRL);
            } else {
              ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).tRJ);
            }
          }
          else if (((GalleryItem.MediaItem)localObject5).getType() == 2) {
            ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject5).tRJ);
          }
        }
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
        ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.tXc);
        ((Intent)localObject1).putExtra("longitude", this.longitude);
        ((Intent)localObject1).putExtra("latitude", this.latitude);
        this.tXc = 0L;
        setResult(-1, (Intent)localObject1);
        finish();
        AppMethodBeat.o(111475);
        return true;
      }
      if (bu.HQ() - this.tXb < 1000L)
      {
        ae.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111475);
        return true;
      }
      this.tXb = bu.HQ();
      localObject5 = this.tWG.tWf;
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      localObject4 = new int[this.tfW];
      localObject5 = ((ArrayList)localObject5).iterator();
      i = 0;
      label1308:
      if (((Iterator)localObject5).hasNext())
      {
        localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
        if (localMediaItem.getType() == 1)
        {
          if ((localMediaItem.mMimeType.equals("edit")) && (!bu.isNullOrNil(localMediaItem.tRL))) {
            ((ArrayList)localObject3).add(localMediaItem.tRL);
          }
          for (;;)
          {
            localObject4[i] = 1;
            i += 1;
            break;
            ((ArrayList)localObject3).add(localMediaItem.tRJ);
          }
        }
        if (localMediaItem.getType() != 2) {
          break label1862;
        }
        ((ArrayList)localObject2).add(localMediaItem.tRJ);
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
      if ((this.tWR) || (!this.oZN)) {}
      for (bool = true;; bool = false)
      {
        ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
        ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.tXc);
        if (!this.tWR) {
          break label1727;
        }
        if (((ArrayList)localObject2).size() != 0) {
          break;
        }
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.tXc);
        this.tXc = 0L;
        setResult(-1, (Intent)localObject1);
        finish();
        AppMethodBeat.o(111475);
        return true;
      }
      if (com.tencent.mm.plugin.recordvideo.activity.a.b.o((List)localObject3, (List)localObject2) == 4)
      {
        localObject1 = VLogPreloadUI.ubj;
        VLogPreloadUI.a.a(this, (ArrayList)localObject2, (ArrayList)localObject3, (int[])localObject4);
      }
      for (;;)
      {
        AppMethodBeat.o(111475);
        return true;
        localObject1 = RecordConfigProvider.as((String)((ArrayList)localObject2).get(0), "", "");
        ((RecordConfigProvider)localObject1).xOp = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
        ((RecordConfigProvider)localObject1).scene = 2;
        localObject2 = new VideoCaptureReportInfo();
        ((VideoCaptureReportInfo)localObject2).roH = 1;
        ((RecordConfigProvider)localObject1).xOx = ((VideoCaptureReportInfo)localObject2);
        localObject2 = new UICustomParam.a();
        ((UICustomParam.a)localObject2).abH();
        ((UICustomParam.a)localObject2).abG();
        ((UICustomParam.a)localObject2).cP(true);
        ((RecordConfigProvider)localObject1).xOh = ((UICustomParam.a)localObject2).ggq;
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772137, -1, (RecordConfigProvider)localObject1, 2, 0);
      }
      this.tXc = 0L;
      if (((ArrayList)localObject3).size() > 0)
      {
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
        ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dzZ);
        ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject1).putExtra("CropImage_limit_Img_Size", 26214400);
        ae.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE_AND_VIDEO switch to SendImgProxyUI");
        startActivityForResult((Intent)localObject1, 4373);
        break;
      }
      ae.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
      setResult(-1, (Intent)localObject1);
      finish();
      break;
      ae.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
      setResult(-2);
      finish();
      break;
    }
  }
  
  protected void f(final int paramInt, View paramView)
  {
    AppMethodBeat.i(164801);
    Object localObject1 = this.tWG.HJ(paramInt);
    boolean bool1;
    if ((localObject1 == null) || (bu.isNullOrNil(((GalleryItem.MediaItem)localObject1).tRJ)))
    {
      if (localObject1 == null) {}
      for (bool1 = true;; bool1 = false)
      {
        ae.w("MicroMsg.AlbumPreviewUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(164801);
        return;
      }
    }
    if ((e.cXr().kXg == 5) && (((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")))
    {
      com.tencent.mm.ui.base.h.cm(getContext(), getString(2131759804));
      AppMethodBeat.o(164801);
      return;
    }
    if (1 == this.tXj)
    {
      if (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("video"))
      {
        com.tencent.mm.ui.base.h.cm(getContext(), getString(2131759806));
        AppMethodBeat.o(164801);
      }
    }
    else if ((2 == this.tXj) && (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("image")))
    {
      com.tencent.mm.ui.base.h.cm(getContext(), getString(2131759805));
      AppMethodBeat.o(164801);
      return;
    }
    int i = paramInt - this.tWG.tWi.size();
    ae.d("MicroMsg.AlbumPreviewUI", "onMediaClick, querySource %s item %s.", new Object[] { Integer.valueOf(this.tXi), localObject1 });
    if ((this.tXi == 0) || (this.tXi == 5) || (this.tXi == 10) || (this.tXi == 11))
    {
      if (this.tXj == 2)
      {
        com.tencent.mm.ui.base.h.a(this, true, getString(2131759818), "", getString(2131755884), getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(179459);
            ae.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.setData(Uri.parse("file://" + Uri.encode(this.tXB.tRJ)));
            AlbumPreviewUI.this.setResult(-1, paramAnonymousDialogInterface);
            a.a.tQr.ai(this.tXB.tRJ, AlbumPreviewUI.k(AlbumPreviewUI.this), paramInt);
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
        paramView.putExtra("video_full_path", ((GalleryItem.MediaItem)localObject1).tRJ);
      }
      if (this.tXi == 10) {
        paramView.putExtra("CropImage_OutputPath", ((GalleryItem.MediaItem)localObject1).tRJ);
      }
      paramView.setData(Uri.parse(Uri.encode(((GalleryItem.MediaItem)localObject1).tRJ)));
      ae.i("MicroMsg.AlbumPreviewUI", "getItem ok");
      setResult(-1, paramView);
      a.a.tQr.ai(((GalleryItem.MediaItem)localObject1).tRJ, this.iYs, paramInt);
      finish();
      AppMethodBeat.o(164801);
      return;
    }
    boolean bool2;
    if (this.tXi == 4)
    {
      bool2 = com.tencent.mm.plugin.gallery.a.d.cYZ();
      if ((!bool2) && (((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.tWG.tWf.size() != 0))
      {
        com.tencent.mm.ui.base.h.cm(getContext(), com.tencent.mm.cb.a.az(getContext(), 2131759774));
        AppMethodBeat.o(164801);
        return;
      }
      if ((bool2) && (com.tencent.mm.plugin.gallery.a.d.af(this.tWG.tWf)))
      {
        bool1 = true;
        ae.i("MicroMsg.AlbumPreviewUI", "enableSnsVLog:%s skipEditVideo:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((((GalleryItem.MediaItem)localObject1).getType() != 2) || (bool1)) {
          break label1004;
        }
        paramView = getString(2131759795);
        if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
          break label853;
        }
        if ((!"video/hevc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).ipJ)) || (!com.tencent.mm.plugin.o.f.dpm())) {
          break label752;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((bs(((GalleryItem.MediaItem)localObject1).tRJ, true)) || (i == 0) || ((!bu.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).ipK)) && (!"audio/mp4a-latm".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).ipK))))
      {
        paramView = new f.a(getContext());
        paramView.au(com.tencent.mm.cb.a.az(getContext(), 2131759790));
        paramView.aZu(com.tencent.mm.cb.a.az(getContext(), 2131759769));
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
        if (!"video/avc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).ipJ)) {
          break label2601;
        }
        i = 1;
        continue;
      }
      if (((GalleryItem.VideoMediaItem)localObject1).ipL >= 300000L)
      {
        localObject1 = new f.a(getContext());
        ((f.a)localObject1).au(paramView);
        ((f.a)localObject1).aZu(com.tencent.mm.cb.a.az(getContext(), 2131759769));
        ((f.a)localObject1).b(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
        });
        ((f.a)localObject1).show();
        AppMethodBeat.o(164801);
        return;
      }
      label853:
      paramView = RecordConfigProvider.as(((GalleryItem.MediaItem)localObject1).tRJ, "", "");
      paramView.xOp = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
      paramView.scene = 2;
      Object localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).roH = 1;
      paramView.xOx = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).abH();
      ((UICustomParam.a)localObject2).abG();
      ((UICustomParam.a)localObject2).cP(true);
      paramView.xOh = ((UICustomParam.a)localObject2).ggq;
      a.a.tQr.ai(((GalleryItem.MediaItem)localObject1).tRJ, this.iYs, paramInt);
      this.tXw = ((GalleryItem.MediaItem)localObject1).tRJ;
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772137, -1, paramView, 2, 0);
      AppMethodBeat.o(164801);
      return;
      label1004:
      ae.d("leextime", "jump from sns : " + bu.HQ());
      if (bool2) {}
      for (paramView = this.tWG.tWe;; paramView = this.tWG.HI(((GalleryItem.MediaItem)localObject1).getType()))
      {
        e.aa(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.tWG.cYs());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.tWG.tWf);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        aq(i, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.oZN);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.tWS);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.tWU);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.tWV);
        ((Intent)localObject2).putExtra("max_select_count", this.tfW);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dzZ);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.iYs);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
        return;
      }
      if (this.tXi == 14)
      {
        if ((((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.tWG.tWf.size() != 0))
        {
          com.tencent.mm.ui.base.h.cm(getContext(), com.tencent.mm.cb.a.az(getContext(), 2131759774));
          AppMethodBeat.o(164801);
          return;
        }
        if (((GalleryItem.MediaItem)localObject1).getType() == 1)
        {
          paramView = this.tWG.HI(((GalleryItem.MediaItem)localObject1).getType());
          e.aa(paramView);
          localObject2 = new Intent(this, ImagePreviewUI.class);
          ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
          ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
          ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.tWG.cYs());
          ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.tWG.tWf);
          ((Intent)localObject2).putExtra("preview_all", true);
          ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
          aq(i, true);
          ((Intent)localObject2).putExtra("send_raw_img", this.oZN);
          ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.tWS);
          ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.tWU);
          ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.tWV);
          ((Intent)localObject2).putExtra("max_select_count", this.tfW);
          ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dzZ);
          ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject2).putExtra("select_type_tag", this.iYs);
          startActivityForResult((Intent)localObject2, 0);
          AppMethodBeat.o(164801);
          return;
        }
        if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
          break label2589;
        }
        paramView = (GalleryItem.VideoMediaItem)localObject1;
        if (paramView.ipL <= 2000)
        {
          ae.i("MicroMsg.AlbumPreviewUI", "select story video, duration too long, duration:%s", new Object[] { Integer.valueOf(paramView.ipL) });
          com.tencent.mm.plugin.report.service.g.yxI.n(1005L, 53L, 1L);
          com.tencent.mm.ui.base.h.cm(getContext(), com.tencent.mm.cb.a.az(getContext(), 2131759798));
          AppMethodBeat.o(164801);
          return;
        }
        if ((paramView.videoFrameRate <= 1) && (paramView.videoFrameRate >= 0))
        {
          ae.i("MicroMsg.AlbumPreviewUI", "select story video, videoFrameRate too small:%s, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.tRJ });
          if (paramView.videoFrameRate > 1) {}
        }
      }
      try
      {
        localObject2 = SightVideoJNI.getSimpleMp4InfoVFS(paramView.tRJ);
        if (!bu.isNullOrNil((String)localObject2))
        {
          double d = new JSONObject((String)localObject2).optDouble("videoFPS");
          ae.i("MicroMsg.AlbumPreviewUI", "update from getSimpleMp4Info videoFPS:%s", new Object[] { Double.valueOf(d) });
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
        ae.i("MicroMsg.AlbumPreviewUI", "final videoFrameRate:%s, too small, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.tRJ });
        com.tencent.mm.plugin.report.service.g.yxI.n(1005L, 54L, 1L);
        com.tencent.mm.ui.base.h.cm(getContext(), com.tencent.mm.cb.a.az(getContext(), 2131759790));
        AppMethodBeat.o(164801);
        return;
      }
      ae.i("MicroMsg.AlbumPreviewUI", "maxDuration=%s", new Object[] { Long.valueOf(getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000 + 500) });
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("K_SEGMENTVIDEOPATH", paramView.tRJ);
      ((Intent)localObject2).putExtra("KSEGMENTVIDEOTHUMBPATH", paramView.ruE);
      setResult(-1, (Intent)localObject2);
      a.a.tQr.ai(((GalleryItem.MediaItem)localObject1).tRJ, this.iYs, paramInt);
      finish();
      AppMethodBeat.o(164801);
      return;
      if (this.tWW)
      {
        if ((((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.tWG.tWf.size() != 0))
        {
          com.tencent.mm.ui.base.h.cm(getContext(), com.tencent.mm.cb.a.az(getContext(), 2131759774));
          AppMethodBeat.o(164801);
          return;
        }
        if ((this.tXi == 15) && (((GalleryItem.MediaItem)localObject1).getType() == 2))
        {
          alU(((GalleryItem.MediaItem)localObject1).tRJ);
          AppMethodBeat.o(164801);
          return;
        }
        paramView = this.tWG.HI(((GalleryItem.MediaItem)localObject1).getType());
        e.aa(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.tWG.cYs());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.tWG.tWf);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        aq(i, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.oZN);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.tWS);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.tWU);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.tWV);
        if (((GalleryItem.MediaItem)localObject1).getType() == 2) {}
        for (paramInt = 1;; paramInt = this.tfW)
        {
          ((Intent)localObject2).putExtra("max_select_count", paramInt);
          ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dzZ);
          ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject2).putExtra("select_type_tag", this.iYs);
          ((Intent)localObject2).putExtra("album_business_tag", this.tWh);
          ((Intent)localObject2).putExtra("album_video_max_duration", this.jxK);
          ((Intent)localObject2).putExtra("album_video_min_duration", this.tXe);
          startActivityForResult((Intent)localObject2, 0);
          AppMethodBeat.o(164801);
          return;
        }
      }
      e.aa(this.tWG.tWe);
      paramView = new Intent(this, ImagePreviewUI.class);
      paramView.putStringArrayListExtra("preview_image_list", this.tWG.cYs());
      paramView.putParcelableArrayListExtra("preview_media_item_list", this.tWG.tWf);
      paramView.putExtra("preview_all", true);
      paramView.putExtra("preview_position", i);
      aq(i, true);
      paramView.putExtra("send_raw_img", this.oZN);
      paramView.putExtra("key_force_hide_edit_image_button", this.tWS);
      paramView.putExtra("key_force_show_raw_image_button", this.tWU);
      paramView.putExtra("key_is_raw_image_button_disable", this.tWV);
      paramView.putExtra("max_select_count", this.tfW);
      paramView.putExtra("GalleryUI_FromUser", this.dzZ);
      paramView.putExtra("GalleryUI_ToUser", this.toUser);
      paramView.putExtra("album_business_tag", this.tWh);
      paramView.putExtra("album_video_max_duration", this.jxK);
      paramView.putExtra("album_video_min_duration", this.tXe);
      if (e.cXr().kXg == 14) {
        paramView.putExtra("key_edit_video_max_time_length", 300500);
      }
      paramView.putExtra("select_type_tag", this.iYs);
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
        ae.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", new Object[] { str, ((Bundle)localObject1).get(str) });
      }
    }
    ae.e("MicroMsg.AlbumPreviewUI", "initView, oops! no extras data!");
    this.tWh = getIntent().getStringExtra("album_business_tag");
    this.jxK = getIntent().getIntExtra("album_video_max_duration", 10);
    this.tXe = getIntent().getIntExtra("album_video_min_duration", 0);
    this.dzZ = getIntent().getStringExtra("GalleryUI_FromUser");
    this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
    this.tfW = getIntent().getIntExtra("max_select_count", 9);
    boolean bool;
    if (this.tXi == 4)
    {
      bool = true;
      this.tWR = bool;
      this.tWN = getIntent().getStringExtra("folder_path");
      this.tWO = getIntent().getStringExtra("folder_name");
      if (bu.isNullOrNil(this.tWN))
      {
        ae.w("MicroMsg.AlbumPreviewUI", "folder path invalid, assign folderName: %s.", new Object[] { this.tWO });
        this.tWN = this.tWO;
      }
      if ((!getIntent().getBooleanExtra("key_send_raw_image", false)) && (!getIntent().getBooleanExtra("send_raw_img", false))) {
        break label1738;
      }
      bool = true;
      label294:
      this.oZN = bool;
      this.tWS = getIntent().getBooleanExtra("key_force_hide_edit_image_button", false);
      this.tWT = getIntent().getBooleanExtra("key_force_hide_edit_image_button_after_album_take_image", false);
      this.tWU = getIntent().getBooleanExtra("key_force_show_raw_image_button", false);
      this.tWV = getIntent().getBooleanExtra("key_is_raw_image_button_disable", false);
      this.tWW = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
      this.tWL = ((TextView)findViewById(2131303091));
      this.tWM = ((ImageButton)findViewById(2131303090));
      this.tWL.setOnClickListener(new AlbumPreviewUI.15(this));
      if ((this.tXi != 3) && (!this.tWU)) {
        break label1744;
      }
      this.tWM.setVisibility(0);
      this.tWL.setVisibility(0);
      label449:
      if (!this.oZN) {
        break label1765;
      }
      this.tWM.setImageResource(2131691078);
      label466:
      if (this.tWV) {
        this.tWM.setImageResource(2131691075);
      }
      localObject1 = this.tWM;
      if (this.tWV) {
        break label1778;
      }
      bool = true;
      label499:
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.tWL;
      if (this.tWV) {
        break label1784;
      }
      bool = true;
      label522:
      ((TextView)localObject1).setEnabled(bool);
      this.tWM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111435);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = AlbumPreviewUI.this;
          boolean bool;
          if (!AlbumPreviewUI.this.oZN)
          {
            bool = true;
            paramAnonymousView.oZN = bool;
            AlbumPreviewUI.d(AlbumPreviewUI.this);
            AlbumPreviewUI.e(AlbumPreviewUI.this).setText(AlbumPreviewUI.this.getContext().getString(2131759782).concat(AlbumPreviewUI.cYE()));
            if (!AlbumPreviewUI.this.oZN) {
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
      this.tWC = ((RecyclerView)findViewById(2131302210));
      this.tWH = ((TextView)findViewById(2131296624));
      this.tWI = ((TextView)findViewById(2131296625));
      this.tWJ = ((TextView)findViewById(2131296597));
      this.tWD = ((TextView)findViewById(2131302218));
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLl, 0)) {
        break label1790;
      }
      bool = true;
      label639:
      ae.i("MicroMsg.AlbumPreviewUI", "pennqin, smartGallerySwitch: %s.", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label1796;
      }
      bool = false;
      label667:
      ae.i("MicroMsg.AlbumPreviewUI", "pennqin, isFromSmartGallery: %s showSmartGallery: %s.", new Object[] { Boolean.valueOf(this.tXh), Boolean.valueOf(bool) });
      if ((!this.tXh) && ((bool) || (j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE)))
      {
        addTextOptionMenu(1, null, this.tXn, null, s.b.JwN);
        if (this.tXk) {
          cYz();
        }
      }
      if ((this.tXi != 0) && (this.tXi != 5) && (this.tXi != 10) && (this.tXi != 11) && (this.tXi != 24)) {
        break label1892;
      }
      findViewById(2131296568).setVisibility(8);
      localObject1 = (FrameLayout.LayoutParams)this.tWC.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = 0;
      this.tWC.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      label827:
      this.tWK = ((ImageFolderMgrView)findViewById(2131300928));
      this.tWK.setListener(new ImageFolderMgrView.a()
      {
        public final void c(GalleryItem.AlbumItem paramAnonymousAlbumItem)
        {
          AppMethodBeat.i(111437);
          AlbumPreviewUI.a(AlbumPreviewUI.this, paramAnonymousAlbumItem);
          AppMethodBeat.o(111437);
        }
      });
      this.tWK.setOnFolderStateChanged(new ImageFolderMgrView.b()
      {
        public final void mU(boolean paramAnonymousBoolean)
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
              if (!bu.bI(AlbumPreviewUI.o(AlbumPreviewUI.this), "").equals(AlbumPreviewUI.n(AlbumPreviewUI.this).tRB))
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
      localObject2 = this.tWK;
      bool = this.tXk;
      ae.i("MicroMsg.ImageFolderMgrView", "attach, %s.", new Object[] { localObject2 });
      e.cXr().b((i.a)localObject2);
      e.cXr().a((i.a)localObject2);
      e.cXr().c(((ImageFolderMgrView)localObject2).tYK);
      localObject1 = e.cXr();
      localObject2 = ((ImageFolderMgrView)localObject2).tYK;
      ((com.tencent.mm.plugin.gallery.model.o)localObject1).tRX.add(localObject2);
      if (bool) {
        e.cXr().cXY();
      }
      this.tWP = getIntent().getStringExtra("send_btn_string");
      this.tWQ = getIntent().getBooleanExtra("is_hide_album_footer", false);
      if (this.tWQ) {
        findViewById(2131296568).setVisibility(8);
      }
      enableOptionMenu(false);
      getContext();
      localObject1 = new GridLayoutManager(4);
      this.tWC.setLayoutManager((RecyclerView.i)localObject1);
      localObject2 = new c.a(getContext());
      ((c.a)localObject2).tYj = ((c.a)localObject2).mResources.getDimensionPixelSize(2131166400);
      ((c.a)localObject2).tYk = ((c.a)localObject2).mResources.getDimensionPixelSize(2131166400);
      ((c.a)localObject2).mColor = android.support.v4.content.b.n(((c.a)localObject2).mContext, 2131100399);
      ((c.a)localObject2).tYi = false;
      localObject2 = new c(((c.a)localObject2).tYj, ((c.a)localObject2).tYk, ((c.a)localObject2).mColor, ((c.a)localObject2).tYi, (byte)0);
      this.tWC.a((RecyclerView.h)localObject2);
      this.tWC.a(new RecyclerView.m()
      {
        private Runnable paq;
        
        private String cYH()
        {
          AppMethodBeat.i(111442);
          String str = AlbumPreviewUI.this.tWG.HK(this.tXC.km());
          if ((!bu.isNullOrNil(str)) && (str.equals("album_business_bubble_media_by_coordinate")))
          {
            str = AlbumPreviewUI.q(AlbumPreviewUI.this) + "附近的照片和视频";
            AppMethodBeat.o(111442);
            return str;
          }
          AppMethodBeat.o(111442);
          return str;
        }
        
        private void mV(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(111443);
          if (paramAnonymousBoolean)
          {
            AlbumPreviewUI.p(AlbumPreviewUI.this).removeCallbacks(this.paq);
            if (AlbumPreviewUI.p(AlbumPreviewUI.this).getVisibility() != 0)
            {
              String str = cYH();
              AlbumPreviewUI.p(AlbumPreviewUI.this).setText(str);
              AlbumPreviewUI.p(AlbumPreviewUI.this).setVisibility(0);
              AlbumPreviewUI.p(AlbumPreviewUI.this).setAlpha(0.0F);
              AlbumPreviewUI.p(AlbumPreviewUI.this).animate().alpha(1.0F).setDuration(300L).start();
              AppMethodBeat.o(111443);
            }
          }
          else
          {
            AlbumPreviewUI.p(AlbumPreviewUI.this).removeCallbacks(this.paq);
            AlbumPreviewUI.p(AlbumPreviewUI.this).postDelayed(this.paq, 256L);
          }
          AppMethodBeat.o(111443);
        }
        
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(111445);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousRecyclerView = cYH();
          AlbumPreviewUI.p(AlbumPreviewUI.this).setText(paramAnonymousRecyclerView);
          paramAnonymousInt1 = this.tXC.km();
          int i = this.tXC.ko();
          ae.d("MicroMsg.AlbumPreviewUI", "pennqin, onScrolled, %s %s %s %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(i), Integer.valueOf(AlbumPreviewUI.s(AlbumPreviewUI.this)), Integer.valueOf(AlbumPreviewUI.t(AlbumPreviewUI.this)) });
          if ((AlbumPreviewUI.s(AlbumPreviewUI.this) != paramAnonymousInt1) || (AlbumPreviewUI.t(AlbumPreviewUI.this) != i))
          {
            AlbumPreviewUI.a(AlbumPreviewUI.this, paramAnonymousInt1);
            AlbumPreviewUI.b(AlbumPreviewUI.this, i);
            paramAnonymousRecyclerView = new ArrayList();
            paramAnonymousInt1 = AlbumPreviewUI.s(AlbumPreviewUI.this);
            while (paramAnonymousInt1 <= AlbumPreviewUI.t(AlbumPreviewUI.this))
            {
              localObject = AlbumPreviewUI.this.tWG.HJ(paramAnonymousInt1);
              if (localObject != null) {
                paramAnonymousRecyclerView.add(com.tencent.mm.plugin.gallery.a.d.a(((GalleryItem.MediaItem)localObject).axP(), null, -1));
              }
              paramAnonymousInt1 += 1;
            }
            ae.d("MicroMsg.AlbumPreviewUI", "cancelTask, legalPaths size: %s.", new Object[] { Integer.valueOf(paramAnonymousRecyclerView.size()) });
            e.cXq().eb(paramAnonymousRecyclerView);
            if (paramAnonymousInt2 != 0)
            {
              if (paramAnonymousInt2 >= 0) {
                break label381;
              }
              AlbumPreviewUI.a(AlbumPreviewUI.this, p.c.tSn);
            }
          }
          for (;;)
          {
            ae.d("MicroMsg.AlbumPreviewUI", "onScrolled, dy: %s state: %s.", new Object[] { Integer.valueOf(paramAnonymousInt2), AlbumPreviewUI.v(AlbumPreviewUI.this) });
            paramAnonymousRecyclerView = com.tencent.mm.plugin.gallery.model.p.tSj;
            com.tencent.mm.plugin.gallery.model.p.cYa().a(AlbumPreviewUI.v(AlbumPreviewUI.this), AlbumPreviewUI.s(AlbumPreviewUI.this), AlbumPreviewUI.t(AlbumPreviewUI.this), AlbumPreviewUI.this.tWG.tWe.size());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(111445);
            return;
            label381:
            AlbumPreviewUI.a(AlbumPreviewUI.this, p.c.tSo);
          }
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(111444);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
          ae.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (1 == paramAnonymousInt)
          {
            mV(true);
            AlbumPreviewUI.r(AlbumPreviewUI.this).setVisibility(8);
            e.cXq().cXl();
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
              mV(false);
              AlbumPreviewUI.a(AlbumPreviewUI.this, this.tXC.km());
              AlbumPreviewUI.b(AlbumPreviewUI.this, this.tXC.ko());
              ae.d("MicroMsg.AlbumPreviewUI", "cancelTask logic, firstVisibleItem: %s lastVisibleItem: %s.", new Object[] { Integer.valueOf(AlbumPreviewUI.s(AlbumPreviewUI.this)), Integer.valueOf(AlbumPreviewUI.t(AlbumPreviewUI.this)) });
              paramAnonymousRecyclerView = com.tencent.mm.plugin.gallery.model.p.tSj;
              com.tencent.mm.plugin.gallery.model.p.cYa().a(p.c.tSm, AlbumPreviewUI.s(AlbumPreviewUI.this), AlbumPreviewUI.t(AlbumPreviewUI.this), AlbumPreviewUI.this.tWG.tWe.size());
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
      this.tWG = new a(getContext(), new a.e()
      {
        public final void ac(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(111446);
          Object localObject = AlbumPreviewUI.this.tWG.HJ(paramAnonymousInt2);
          if (localObject == null)
          {
            AppMethodBeat.o(111446);
            return;
          }
          if (paramAnonymousInt3 == 0) {
            if (((GalleryItem.MediaItem)localObject).getType() == 1)
            {
              a.a.tQr.ai(((GalleryItem.MediaItem)localObject).tRJ, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.a(AlbumPreviewUI.this, (GalleryItem.MediaItem)localObject);
              AlbumPreviewUI.this.HL(paramAnonymousInt1);
              AlbumPreviewUI.this.aq(paramAnonymousInt2, true);
            }
          }
          while (bu.ht(AlbumPreviewUI.this.tWG.cYs()))
          {
            AppMethodBeat.o(111446);
            return;
            if (((GalleryItem.MediaItem)localObject).getType() == 2)
            {
              if (!AlbumPreviewUI.this.a((GalleryItem.MediaItem)localObject))
              {
                AlbumPreviewUI.this.tWG.h((GalleryItem.MediaItem)localObject);
              }
              else
              {
                a.a.tQr.ai(((GalleryItem.MediaItem)localObject).tRJ, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
                AlbumPreviewUI.this.HL(paramAnonymousInt1);
                AlbumPreviewUI.this.aq(paramAnonymousInt2, true);
              }
            }
            else
            {
              a.a.tQr.ai(((GalleryItem.MediaItem)localObject).tRJ, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.HL(paramAnonymousInt1);
              AlbumPreviewUI.this.aq(paramAnonymousInt2, true);
              continue;
              a.a.tQr.ai(((GalleryItem.MediaItem)localObject).tRJ, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.HL(paramAnonymousInt1);
              AlbumPreviewUI.this.aq(paramAnonymousInt2, false);
            }
          }
          localObject = AlbumPreviewUI.this.tWG.cYs().iterator();
          while (((Iterator)localObject).hasNext()) {
            if (!u.aRG((String)((Iterator)localObject).next()))
            {
              AppMethodBeat.o(111446);
              return;
            }
          }
          AlbumPreviewUI.this.oZN = true;
          AppMethodBeat.o(111446);
        }
      });
      this.tWG.tWm = this.tWm;
      if (!bu.isNullOrNil(this.tWh))
      {
        ae.d("MicroMsg.AlbumPreviewUI", "businessTag=%s", new Object[] { this.tWh });
        this.tWG.tWh = this.tWh;
        this.tWG.jxK = this.jxK;
        if (this.tWh.equals("album_business_bubble_media_by_coordinate"))
        {
          this.tWG.tWj = false;
          e.cXr().tSa.cXd();
          this.tXf = getIntent().getStringExtra("album_business_bubble_media_by_coordinate_posname");
          final double d = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_distance", -1.0D);
          this.longitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 181.0D);
          this.latitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 91.0D);
          if ((d >= 0.0D) && (com.tencent.mm.modelgeo.a.l(this.longitude)) && (com.tencent.mm.modelgeo.a.m(this.latitude)))
          {
            this.tXg = new i.b()
            {
              public final void c(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong)
              {
                AppMethodBeat.i(111423);
                ae.d("MicroMsg.AlbumPreviewUI", "onQueryMediaBusinessDoing");
                if (paramAnonymousLong != AlbumPreviewUI.w(AlbumPreviewUI.this))
                {
                  ae.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(AlbumPreviewUI.w(AlbumPreviewUI.this)) });
                  ae.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
                  AppMethodBeat.o(111423);
                  return;
                }
                if ((paramAnonymousLinkedList == null) || (paramAnonymousLinkedList.isEmpty()))
                {
                  ae.d("MicroMsg.AlbumPreviewUI", "mediaItems is invalid.");
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
                    localMediaItem.tRP = "album_business_bubble_media_by_coordinate";
                    localArrayList.add(localMediaItem);
                  }
                }
                paramAnonymousLinkedList.removeAll(localArrayList);
                ae.d("MicroMsg.AlbumPreviewUI", "target media size=%d", new Object[] { Integer.valueOf(localArrayList.size()) });
                localIterator = localArrayList.iterator();
                while (localIterator.hasNext()) {
                  ae.d("MicroMsg.AlbumPreviewUI", "target media item=%s", new Object[] { ((GalleryItem.MediaItem)localIterator.next()).toString() });
                }
                if ((!paramAnonymousLinkedList.isEmpty()) && (!localArrayList.isEmpty())) {
                  paramAnonymousLinkedList.addAll(0, localArrayList);
                }
                AppMethodBeat.o(111423);
              }
            };
            localObject1 = e.cXr();
            localObject2 = this.tXg;
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.gallery.model.o)localObject1).tRZ.add(localObject2);
            }
          }
        }
      }
      if (this.tWW) {
        this.tWG.tWj = true;
      }
      this.tXp = new a.b();
      if (getIntent().getBooleanExtra("show_header_view", true)) {
        this.tWG.a(this.tXp);
      }
      this.tWG.tSb = this.tXj;
      this.tWG.tWd = this.tfW;
      ae.i("MicroMsg.AlbumPreviewUI", "limit count = " + this.tfW);
      this.tWC.setAdapter(this.tWG);
      if (!this.tXh) {
        break label2115;
      }
      setActionbarColor(getResources().getColor(2131100399));
      setMMTitle(getIntent().getStringExtra("title_from_smart_gallery"));
      label1551:
      setNavigationbarColor(getResources().getColor(2131100399));
      setActionBarOperationAreaClickListener(new AlbumChooserView.a()
      {
        public final void cYG()
        {
          AppMethodBeat.i(179457);
          ae.i("MicroMsg.AlbumPreviewUI", "onAlbumChooserViewClick.");
          AlbumPreviewUI.a(AlbumPreviewUI.this, null);
          a.a.tQr.tQf = 1;
          ae.d("MicroMsg.AlbumPreviewUI", "click folder times: [%d].", new Object[] { Integer.valueOf(AlbumPreviewUI.B(AlbumPreviewUI.this)) });
          AlbumPreviewUI.C(AlbumPreviewUI.this);
          AlbumPreviewUI.this.playActionBarOperationAreaAnim();
          AlbumPreviewUI.m(AlbumPreviewUI.this).cYI();
          AppMethodBeat.o(179457);
        }
      });
      if (!this.tXh) {
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
          ae.i("MicroMsg.AlbumPreviewUI", "backBtn");
          AlbumPreviewUI.this.onBackBtnClick();
          AlbumPreviewUI.this.setResult(-2, AlbumPreviewUI.this.getIntent().putExtra("send_raw_img", AlbumPreviewUI.this.oZN));
          if ((AlbumPreviewUI.m(AlbumPreviewUI.this) != null) && (AlbumPreviewUI.m(AlbumPreviewUI.this).jR))
          {
            AlbumPreviewUI.m(AlbumPreviewUI.this).cYI();
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
          public final void cYF()
          {
            AppMethodBeat.i(111425);
            com.tencent.mm.plugin.gallery.a.d.cYF();
            if (AlbumPreviewUI.this.tWY) {
              AlbumPreviewUI.this.tWY = false;
            }
            AppMethodBeat.o(111425);
          }
        });
      }
      this.tXl = new e((byte)0);
      this.tXl.tXJ = new WeakReference(this.tWG);
      this.tXl.tXK = new WeakReference(this.fOC);
      this.tXl.tXO = new WeakReference(this.tWK);
      this.tXl.idList = this.idList;
      this.tXl.type = this.tXj;
      AppMethodBeat.o(111474);
      return;
      bool = false;
      break;
      label1738:
      bool = false;
      break label294;
      label1744:
      this.tWM.setVisibility(8);
      this.tWL.setVisibility(8);
      break label449;
      label1765:
      this.tWM.setImageResource(2131691077);
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
      localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLm, "");
      localObject2 = Build.MANUFACTURER.toLowerCase();
      str = Build.MODEL.toLowerCase();
      ae.i("MicroMsg.AlbumPreviewUI", "pennqin, manufacturer: %s, model: %s, smartGalleryBlackList: %s.", new Object[] { localObject2, str, localObject1 });
      if ((((String)localObject1).contains((CharSequence)localObject2)) || (((String)localObject1).contains(str)))
      {
        bool = false;
        break label667;
      }
      bool = true;
      break label667;
      label1892:
      this.tWD.setVisibility(0);
      this.tWD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164797);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          AlbumPreviewUI.g(AlbumPreviewUI.this);
          paramAnonymousView = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
          e.aa(AlbumPreviewUI.this.tWG.tWe);
          paramAnonymousView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.tWG.cYs());
          paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", AlbumPreviewUI.this.tWG.tWf);
          paramAnonymousView.putExtra("max_select_count", AlbumPreviewUI.this.tfW);
          paramAnonymousView.putExtra("send_raw_img", AlbumPreviewUI.this.oZN);
          paramAnonymousView.putExtra("key_force_hide_edit_image_button", AlbumPreviewUI.h(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("key_force_show_raw_image_button", AlbumPreviewUI.i(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("key_is_raw_image_button_disable", AlbumPreviewUI.j(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.dzZ);
          paramAnonymousView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
          paramAnonymousView.putExtra("select_type_tag", AlbumPreviewUI.k(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("album_business_tag", AlbumPreviewUI.this.tWh);
          paramAnonymousView.putExtra("album_video_max_duration", AlbumPreviewUI.this.jxK);
          paramAnonymousView.putExtra("album_video_min_duration", AlbumPreviewUI.this.tXe);
          AlbumPreviewUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164797);
        }
      });
      if (((this.tXj != 1) && (this.tXj != 2) && (this.tXj != 3)) || (this.tfW <= 0)) {
        break label827;
      }
      if (!bu.isNullOrNil(this.tWP))
      {
        addTextOptionMenu(0, this.tWP, this.tXn);
        break label827;
      }
      if (this.tXi == 15)
      {
        i = this.tXi;
        j = this.tfW;
        localObject2 = this.tWh;
        if (this.tWG == null) {}
        for (localObject1 = null;; localObject1 = this.tWG.tWf)
        {
          addTextOptionMenu(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, 0, j, (String)localObject2, (ArrayList)localObject1), this.tXn, null, s.b.JwK);
          break;
        }
      }
      i = this.tXi;
      int j = this.tfW;
      localObject2 = this.tWh;
      if (this.tWG == null) {}
      for (localObject1 = null;; localObject1 = this.tWG.tWf)
      {
        addTextOptionMenu(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, 0, j, (String)localObject2, (ArrayList)localObject1), this.tXn, null, s.b.JwM);
        break;
      }
      label2115:
      initActionBarOperationArea();
      setActionbarColor(getResources().getColor(2131100399));
      if (this.tXj == 3)
      {
        initActionBarOperationAreaTxt(getString(2131759758));
        break label1551;
      }
      if (this.tXj == 1)
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
    ae.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d] %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    Object localObject2;
    if (4369 == paramInt1)
    {
      if (-1 != paramInt2)
      {
        AppMethodBeat.o(111478);
        return;
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.tools.q.i(getContext().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.asv());
      if (bu.isNullOrNil((String)localObject1))
      {
        ae.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
        AppMethodBeat.o(111478);
        return;
      }
      ae.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[] { localObject1 });
      if ((this.tXi == 0) || (this.tXi == 5) || (this.tXi == 11) || (this.tXi == 24))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setData(Uri.parse("file://" + Uri.encode((String)localObject1)));
        ae.i("MicroMsg.AlbumPreviewUI", "take photo finish");
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
            this.tWJ.setVisibility(0);
            this.tWJ.setText(getString(2131761897));
            localObject1 = AnimationUtils.loadAnimation(getContext(), 2130772047);
            this.tWJ.startAnimation((Animation)localObject1);
            ((Animation)localObject1).setAnimationListener(new Animation.AnimationListener()
            {
              private Runnable tXz;
              
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                AppMethodBeat.i(111428);
                AlbumPreviewUI.A(AlbumPreviewUI.this).setVisibility(0);
                AlbumPreviewUI.A(AlbumPreviewUI.this).postDelayed(this.tXz, 4000L);
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
        ((Intent)localObject1).putExtra("send_raw_img", this.oZN);
        if ((this.tWS) || (this.tWT)) {}
        for (bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("key_force_hide_edit_image_button", bool);
          ((Intent)localObject1).putExtra("key_force_show_raw_image_button", this.tWU);
          ((Intent)localObject1).putExtra("key_is_raw_image_button_disable", this.tWV);
          ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
          if (this.tWG != null) {
            ((Intent)localObject1).putParcelableArrayListExtra("preview_media_item_list", this.tWG.tWf);
          }
          ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dzZ);
          ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject1).putExtra("select_type_tag", this.iYs);
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
            ae.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
            setResult(-1, paramIntent);
            finish();
            AppMethodBeat.o(111478);
            return;
          }
          localObject1 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
          {
            ae.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
            AppMethodBeat.o(111478);
            return;
          }
          ae.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", new Object[] { localObject1 });
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
          ae.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", new Object[] { paramIntent });
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
          ae.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", new Object[] { localObject1 });
          paramIntent = new ArrayList();
          localObject2 = getIntent().getStringExtra("video_full_path");
          if (!bu.isNullOrNil((String)localObject2))
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
            ae.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
          }
          ae.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
          setResult(-1, paramIntent);
          this.tWY = true;
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
          ae.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[] { localObject1 });
          paramIntent = (CaptureDataManager.CaptureVideoNormalModel)((Intent)localObject1).getParcelableExtra("KSEGMENTMEDIAINFO");
          if (paramIntent == null)
          {
            ae.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
            setResult(1);
            finish();
            AppMethodBeat.o(111478);
            return;
          }
          localObject2 = new ArrayList();
          localObject3 = paramIntent.videoPath;
          if (!bu.isNullOrNil((String)localObject3))
          {
            ((ArrayList)localObject2).add(localObject3);
            ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
          }
          if ((paramIntent.xNY.booleanValue()) && (!bu.isNullOrNil(paramIntent.thumbPath)))
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
          ae.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[] { localObject1 });
          paramIntent = (SightCaptureResult)((Intent)localObject1).getParcelableExtra("key_req_result");
          if (paramIntent == null)
          {
            ae.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
            setResult(1);
            finish();
            AppMethodBeat.o(111478);
            return;
          }
          localObject2 = new ArrayList();
          localObject3 = paramIntent.vYy;
          if (!bu.isNullOrNil((String)localObject3))
          {
            ((ArrayList)localObject2).add(localObject3);
            ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
          }
          if ((paramIntent.vYw) && (!bu.isNullOrNil(paramIntent.vYE)))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramIntent.vYE);
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
          }
          setResult(-1, (Intent)localObject1);
          finish();
        }
        else if (4376 == paramInt1)
        {
          if (-1 != paramInt2)
          {
            ae.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
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
              setMMTitle(bu.bI(((GalleryItem.AlbumItem)localObject1).tRB, getString(2131759758)));
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
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).dIW().v("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
              this.tWF = true;
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
              if (bu.isNullOrNil(this.tXw)) {
                break;
              }
              localObject2 = a.a.tQr;
              localObject3 = this.tXw;
              ae.i("MicroMsg.GalleryReporter", "path: %s.", new Object[] { localObject3 });
              localObject1 = paramIntent;
              if (bu.isNullOrNil((String)localObject3)) {
                break;
              }
              ((com.tencent.mm.plugin.gallery.a)localObject2).tQl.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).tQm.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).tQn.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).tQo.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).tQp.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).tQq.remove(localObject3);
              localObject1 = paramIntent;
              break;
              if (paramInt2 == -2) {
                finish();
              }
            }
          }
          if (4382 == paramInt1)
          {
            ae.i("MicroMsg.AlbumPreviewUI", "back from smart gallery.");
            if (paramIntent != null)
            {
              localObject1 = paramIntent.getExtras();
              this.oZN = paramIntent.getBooleanExtra("send_raw_img", this.oZN);
              if (this.oZN)
              {
                this.tWM.setImageResource(2131691078);
                if (this.tWV) {
                  this.tWM.setImageResource(2131691075);
                }
                localObject2 = this.tWM;
                if (this.tWV) {
                  break label1896;
                }
                bool = true;
                ((ImageButton)localObject2).setEnabled(bool);
                localObject2 = this.tWL;
                if (this.tWV) {
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
                  ae.i("MicroMsg.AlbumPreviewUI", "key: %s, value: %s.", new Object[] { localObject3, ((Bundle)localObject1).get((String)localObject3) });
                }
                this.tWM.setImageResource(2131691077);
                break;
                bool = false;
                break label1784;
              }
            }
            if ((-2 == paramInt2) || (paramInt2 == 0) || (SmartGalleryUI.uaI == paramInt2))
            {
              ae.i("MicroMsg.AlbumPreviewUI", "just back from SmartGalleryUI.");
              paramIntent = new android.support.v4.e.b();
              paramInt1 = i;
              while (paramInt1 < this.tWG.tWf.size())
              {
                localObject1 = (GalleryItem.MediaItem)this.tWG.tWf.get(paramInt1);
                i = this.tWG.tWe.indexOf(localObject1);
                if (i != -1) {
                  paramIntent.add(Integer.valueOf(i));
                }
                paramInt1 += 1;
              }
              this.tWG.ee(s.cYc().tSu);
              if (SmartGalleryUI.uaI == paramInt2)
              {
                cLX();
                AppMethodBeat.o(111478);
                return;
              }
              HL(this.tWG.tWf.size());
              this.tWG.a(paramIntent);
              AppMethodBeat.o(111478);
              return;
            }
            if (-1 == paramInt2) {
              this.tWF = true;
            }
            setResult(paramInt2, paramIntent);
            finish();
            localObject1 = paramIntent;
          }
          else if (paramInt1 == 4381)
          {
            if (paramInt2 == -1)
            {
              if (this.tWR)
              {
                paramIntent = RecordConfigProvider.iP("", "");
                paramIntent.xOp = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
                paramIntent.scene = 2;
                localObject1 = new VideoCaptureReportInfo();
                ((VideoCaptureReportInfo)localObject1).roH = 1;
                paramIntent.xOx = ((VideoCaptureReportInfo)localObject1);
                localObject1 = new UICustomParam.a();
                ((UICustomParam.a)localObject1).abH();
                ((UICustomParam.a)localObject1).abG();
                ((UICustomParam.a)localObject1).cP(true);
                paramIntent.xOh = ((UICustomParam.a)localObject1).ggq;
                localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772137, -1, paramIntent, 4, 0);
                AppMethodBeat.o(111478);
                return;
              }
              localObject1 = paramIntent;
              if (22 == e.cXr().kXg)
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
              ae.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
              finish();
              localObject1 = paramIntent;
              break;
            case -1: 
              localObject1 = paramIntent;
              if (paramIntent == null)
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("CropImage_Compress_Img", true);
                ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", this.tWG.cYs());
              }
              ((Intent)localObject1).putStringArrayListExtra("key_select_image_list", ((Intent)localObject1).getStringArrayListExtra("CropImage_OutputPath_List"));
              ae.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
              this.tWF = true;
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
      ae.i("MicroMsg.AlbumPreviewUI", "paths size: %d.", new Object[] { Integer.valueOf(paramInt1) });
      if ((localObject1 == null) || (this.tWG == null)) {
        break label2588;
      }
      localObject2 = new android.support.v4.e.b();
      paramInt1 = 0;
      while (paramInt1 < this.tWG.tWf.size())
      {
        localObject3 = (GalleryItem.MediaItem)this.tWG.tWf.get(paramInt1);
        paramInt2 = this.tWG.tWe.indexOf(localObject3);
        if (paramInt2 != -1) {
          ((android.support.v4.e.b)localObject2).add(Integer.valueOf(paramInt2));
        }
        paramInt1 += 1;
      }
    }
    this.tWG.ac((ArrayList)localObject1);
    this.tWG.a((android.support.v4.e.b)localObject2);
    HL(((ArrayList)localObject1).size());
    label2588:
    if (!paramIntent.getBooleanExtra("CropImage_Compress_Img", true))
    {
      bool = true;
      label2602:
      this.oZN = bool;
      if (!this.oZN) {
        break label2700;
      }
      this.tWM.setImageResource(2131691078);
      label2625:
      if (this.tWV) {
        this.tWM.setImageResource(2131691075);
      }
      localObject1 = this.tWM;
      if (this.tWV) {
        break label2713;
      }
      bool = true;
      label2658:
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.tWL;
      if (this.tWV) {
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
      this.tWM.setImageResource(2131691077);
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
    ae.i("MicroMsg.AlbumPreviewUI", "onCreate, %s.", new Object[] { this });
    setRequestedOrientation(1);
    String str1 = getString(2131761885);
    String str2 = getString(2131759773);
    this.tXk = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, str1, str2);
    ae.d("MicroMsg.AlbumPreviewUI", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(this.tXk) });
    this.tXc = System.currentTimeMillis();
    start = System.currentTimeMillis();
    this.fOC = com.tencent.mm.ui.base.p.a(this, getString(2131755936), false);
    this.tXq = AlbumPreviewUI.b.tXG;
    if (paramBundle != null)
    {
      ae.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
      this.tXi = paramBundle.getInt("constants_key_query_source");
    }
    for (this.tXj = paramBundle.getInt("constants_key_query_type");; this.tXj = getIntent().getIntExtra("query_media_type", 1))
    {
      e.cXr().kXg = this.tXi;
      e.cXr().setQueryType(this.tXj);
      ae.i("MicroMsg.AlbumPreviewUI", "query source: " + this.tXi + ", queryType: " + this.tXj);
      this.iYs = getIntent().getIntExtra("select_type_tag", 3);
      this.pEM = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFA, true);
      this.tXh = getIntent().getBooleanExtra("is_from_smart_gallery", false);
      initView();
      if (this.tXk) {
        cYA();
      }
      e.cXz();
      AppMethodBeat.o(111464);
      return;
      this.tXi = getIntent().getIntExtra("query_source_type", 3);
    }
  }
  
  public void onDestroy()
  {
    boolean bool1 = false;
    AppMethodBeat.i(111469);
    super.onDestroy();
    ae.i("MicroMsg.AlbumPreviewUI", "onDestroy, %s.", new Object[] { this });
    if (e.cXr() != null)
    {
      e.cXr().tRY.remove(this);
      com.tencent.mm.plugin.gallery.model.o localo = e.cXr();
      i.b localb = this.tXg;
      if (localb != null) {
        localo.tRZ.remove(localb);
      }
    }
    if ((this.tWZ > 0) || (this.tXa > 0))
    {
      ae.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", new Object[] { Integer.valueOf(this.tWZ), Integer.valueOf(this.tXa) });
      com.tencent.mm.plugin.gallery.a.d.bk(11187, this.tWZ + "," + this.tXa);
    }
    for (;;)
    {
      if ((this.tXb > 0L) || (this.tWF)) {
        e.a(this.tWP, ad(this.tWG.tWf), this.oZN, this.tWE);
      }
      int i = this.tWG.tWf.size();
      boolean bool2 = this.oZN;
      if ((this.tXb > 0L) || (this.tWF)) {
        bool1 = true;
      }
      e.f(i, bool2, bool1);
      y.cSw.Kf().Ke();
      e.cXu().clear();
      e.cXv().clear();
      e.cXw().clear();
      if (!this.tXh) {
        break;
      }
      s.cYc().tSs = true;
      if (e.cXA())
      {
        com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.hzU).ahx();
        a.g.cYw();
      }
      AppMethodBeat.o(111469);
      return;
      ae.d("MicroMsg.AlbumPreviewUI", "not click camera or folder.");
    }
    if (!this.jsS) {
      a.a.tQr.report();
    }
    for (;;)
    {
      s.cYc().tSt = true;
      e.cXr().cXZ();
      break;
      a.a.tQr.reset();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111477);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      ae.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
      setResult(-2);
      if ((this.tWK != null) && (this.tWK.jR))
      {
        this.tWK.cYI();
        playActionBarOperationAreaAnim();
        AppMethodBeat.o(111477);
        return true;
      }
      this.jsS = true;
      finish();
      AppMethodBeat.o(111477);
      return true;
    }
    if (paramInt == 82)
    {
      this.tXa += 1;
      if (this.tWK != null) {
        this.tWK.cYI();
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
    ae.i("MicroMsg.AlbumPreviewUI", "on onPause, %s.", new Object[] { this });
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    this.tWX = true;
    ImageFolderMgrView localImageFolderMgrView;
    if ((!isFinishing()) && (!isDestroyed()) && (this.tWK != null) && (this.tWK.jR))
    {
      localImageFolderMgrView = this.tWK;
      if (localImageFolderMgrView.jR) {
        break label132;
      }
      ae.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
    }
    for (;;)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, this.fMX);
      this.fMX = 0;
      if (this.tXh) {
        s.cYc().ed(this.tWG.tWf);
      }
      AppMethodBeat.o(111467);
      return;
      label132:
      if (localImageFolderMgrView.tYJ)
      {
        ae.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
      }
      else
      {
        localImageFolderMgrView.tYF.setVisibility(8);
        localImageFolderMgrView.jR = false;
        if (localImageFolderMgrView.tYN != null) {
          localImageFolderMgrView.tYN.mU(false);
        }
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(111483);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(111483);
      return;
    }
    ae.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111483);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cYB();
        AppMethodBeat.o(111483);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131759760), false, new AlbumPreviewUI.6(this), null);
      AppMethodBeat.o(111483);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cYz();
        e.cXr().cXY();
        cYA();
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
    ae.i("MicroMsg.AlbumPreviewUI", "onResume, %s.", new Object[] { this });
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    this.tWX = false;
    AppMethodBeat.o(111465);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(111470);
    super.onSaveInstanceState(paramBundle);
    ae.i("MicroMsg.AlbumPreviewUI", "onSaveInstanceState, %s.", new Object[] { this });
    paramBundle.putInt("constants_key_query_source", this.tXi);
    paramBundle.putInt("constants_key_query_type", this.tXj);
    AppMethodBeat.o(111470);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(111466);
    super.onStart();
    ae.i("MicroMsg.AlbumPreviewUI", "onStart, %s.", new Object[] { this });
    if (e.cXr().kXg != this.tXi) {
      e.cXr().kXg = this.tXi;
    }
    if (e.cXr().tSb != this.tXj) {
      e.cXr().setQueryType(this.tXj);
    }
    AppMethodBeat.o(111466);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(111468);
    super.onStop();
    ae.i("MicroMsg.AlbumPreviewUI", "onStop, %s.", new Object[] { this });
    if (!this.tXh)
    {
      com.tencent.mm.plugin.gallery.model.c localc = e.cXq();
      if ((localc.tQD != null) && (!localc.tQD.isEmpty()))
      {
        Iterator localIterator = localc.tQD.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.c localc1 = (c.c)((Map.Entry)localIterator.next()).getValue();
          if (localc1 != null) {
            localc1.mCancel = true;
          }
        }
        if (localc.tQC != null) {
          localc.tQC.clear();
        }
        if ((localc.tQD != null) && (!localc.tQD.isEmpty())) {
          localc.tQD.clear();
        }
        localc.tQA.cXm();
      }
      e.cXq().cXl();
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
    WeakReference<AlbumPreviewUI> lRT;
    
    a(AlbumPreviewUI paramAlbumPreviewUI)
    {
      AppMethodBeat.i(111448);
      this.lRT = new WeakReference(paramAlbumPreviewUI);
      AppMethodBeat.o(111448);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111449);
      long l = System.currentTimeMillis();
      boolean bool = s.cYc().cYe();
      l = System.currentTimeMillis() - l;
      ae.i("MicroMsg.AlbumPreviewUI", "smart gallery isValid: %s, dur: %s.", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.g.yxI.f(19165, new Object[] { Long.valueOf(l) });
      if (l <= 3000L) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1297, 0);
      }
      for (;;)
      {
        if (bool)
        {
          a.a.tQr.tQd = 1;
          e.cXs().f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111447);
              if (AlbumPreviewUI.a.this.lRT != null)
              {
                AlbumPreviewUI localAlbumPreviewUI = (AlbumPreviewUI)AlbumPreviewUI.a.this.lRT.get();
                if (localAlbumPreviewUI != null)
                {
                  localAlbumPreviewUI.setSmartGalleryEntryVisibility(true);
                  localAlbumPreviewUI.tXt = true;
                }
              }
              AppMethodBeat.o(111447);
            }
          });
        }
        AppMethodBeat.o(111449);
        return;
        if (l <= 5000L) {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1297, 1);
        } else if (l <= 10000L) {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1297, 2);
        } else if (l <= 15000L) {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1297, 3);
        } else {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1297, 4);
        }
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    WeakReference<a> tXJ;
    WeakReference<ProgressDialog> tXK;
    WeakReference<TextView> tXL;
    WeakReference<RecyclerView> tXM;
    LinkedList<GalleryItem.MediaItem> tXN;
    WeakReference<ImageFolderMgrView> tXO;
    boolean tXP = false;
    String tXf;
    
    public final void run()
    {
      AppMethodBeat.i(111455);
      if (this.tXN == null) {}
      for (int i = -1;; i = this.tXN.size())
      {
        ae.d("MicroMsg.AlbumPreviewUI", "on NotifyMediaItemsChanged, size %d", new Object[] { Integer.valueOf(i) });
        AlbumPreviewUI.at(this.tXN);
        if (this.tXJ != null) {
          break;
        }
        ae.w("MicroMsg.AlbumPreviewUI", "null == adapterRef");
        AppMethodBeat.o(111455);
        return;
      }
      Object localObject1 = (a)this.tXJ.get();
      if (localObject1 == null)
      {
        ae.w("MicroMsg.AlbumPreviewUI", "null == adapter");
        AppMethodBeat.o(111455);
        return;
      }
      if (this.tXM == null)
      {
        AppMethodBeat.o(111455);
        return;
      }
      RecyclerView localRecyclerView = (RecyclerView)this.tXM.get();
      if (localRecyclerView == null)
      {
        AppMethodBeat.o(111455);
        return;
      }
      ae.d("MicroMsg.AlbumPreviewUI", "isSwitchAlbum: %s.", new Object[] { Boolean.valueOf(this.tXP) });
      Object localObject2 = com.tencent.mm.plugin.gallery.model.p.tSj;
      localObject2 = com.tencent.mm.plugin.gallery.model.p.cYa();
      Object localObject3 = this.tXN;
      d.g.b.p.h(localObject3, "mediaItems");
      ae.d("MicroMsg.PreLoadManager", "syncMediaItems, size: %s.", new Object[] { Integer.valueOf(((List)localObject3).size()) });
      ((com.tencent.mm.plugin.gallery.model.p)localObject2).tSg.clear();
      ((com.tencent.mm.plugin.gallery.model.p)localObject2).tSg.addAll((Collection)localObject3);
      if (this.tXP)
      {
        this.tXP = false;
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((a)localObject1).ar(this.tXN);
        localObject2 = com.tencent.mm.plugin.gallery.model.p.tSj;
        localObject2 = com.tencent.mm.plugin.gallery.model.p.cYa();
        localObject3 = p.c.tSm;
        if (this.tXN.size() > 32)
        {
          i = 32;
          ((com.tencent.mm.plugin.gallery.model.p)localObject2).a((p.c)localObject3, 0, i, ((a)localObject1).tWe.size());
        }
      }
      for (;;)
      {
        if (this.tXK != null) {
          break label389;
        }
        AppMethodBeat.o(111455);
        return;
        i = this.tXN.size();
        break;
        ((a)localObject1).as(this.tXN);
      }
      label389:
      localObject2 = (ProgressDialog)this.tXK.get();
      if ((localObject2 != null) && (((ProgressDialog)localObject2).isShowing()))
      {
        ((ProgressDialog)localObject2).dismiss();
        ae.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start) });
      }
      if (this.tXO != null)
      {
        localObject2 = (ImageFolderMgrView)this.tXO.get();
        if (localObject2 != null) {
          ((ImageFolderMgrView)localObject2).setFavItemCount(this.tXN.size());
        }
      }
      if ((this.tXL == null) || (bu.isNullOrNil(this.tXf)))
      {
        AppMethodBeat.o(111455);
        return;
      }
      localObject2 = (TextView)this.tXL.get();
      if (localObject2 != null)
      {
        localObject1 = ((a)localObject1).HK(((GridLayoutManager)localRecyclerView.getLayoutManager()).km());
        if ((!bu.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("album_business_bubble_media_by_coordinate")))
        {
          ((TextView)localObject2).setVisibility(0);
          ((TextView)localObject2).setText(this.tXf.concat("附近的照片和视频"));
          ((TextView)localObject2).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111454);
              if (8 == this.tXQ.getVisibility())
              {
                AppMethodBeat.o(111454);
                return;
              }
              this.tXQ.animate().alpha(0.0F).setDuration(300L).withEndAction(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111453);
                  AlbumPreviewUI.c.1.this.tXQ.setVisibility(8);
                  AlbumPreviewUI.c.1.this.tXQ.setAlpha(1.0F);
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
    private String tXT;
    private WeakReference<a> tXU;
    private WeakReference<ProgressDialog> tXV;
    private WeakReference<RecyclerView> tXW;
    
    d(String paramString, a parama, ProgressDialog paramProgressDialog, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(111458);
      this.tXT = paramString;
      this.tXU = new WeakReference(parama);
      this.tXV = new WeakReference(paramProgressDialog);
      this.tXW = new WeakReference(paramRecyclerView);
      AppMethodBeat.o(111458);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111459);
      if (bu.isNullOrNil(this.tXT))
      {
        AppMethodBeat.o(111459);
        return;
      }
      ae.i("QuerySmartGalleryAlbumMediaTask", "start query.");
      s locals = s.cYc();
      Object localObject1 = this.tXT;
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
              if ((!paramAnonymousBoolean) && (((a)localObject).tWe.size() <= paramAnonymousList.size())) {
                break label148;
              }
              AlbumPreviewUI.d.eg(paramAnonymousList);
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
              localMediaItem = GalleryItem.MediaItem.a(1, localg.tSJ, localg.data, "", localg.type);
              localMediaItem.tRN = localg.tSK;
              ((LinkedList)localObject).add(localMediaItem);
              continue;
              label148:
              AlbumPreviewUI.d.eg(paramAnonymousList.subList(((a)localObject).tWe.size(), paramAnonymousList.size()));
              break;
            }
            if (localg.type.contains("video"))
            {
              localMediaItem = GalleryItem.MediaItem.a(2, localg.tSJ, localg.data, "", localg.type);
              localMediaItem.tRN = localg.tSK;
              ((LinkedList)localObject).add(localMediaItem);
            }
          }
          label229:
          paramAnonymousList = new AlbumPreviewUI.c((byte)0);
          paramAnonymousList.tXJ = AlbumPreviewUI.d.a(AlbumPreviewUI.d.this);
          paramAnonymousList.tXK = AlbumPreviewUI.d.b(AlbumPreviewUI.d.this);
          paramAnonymousList.tXN = ((LinkedList)localObject);
          paramAnonymousList.tXM = AlbumPreviewUI.d.c(AlbumPreviewUI.d.this);
          paramAnonymousList.tXP = paramAnonymousBoolean;
          e.cXs().f(paramAnonymousList);
          ae.i("QuerySmartGalleryAlbumMediaTask", "finish page query.");
          AppMethodBeat.o(161161);
        }
      };
      locals.tSs = false;
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = s.BASE_URI.buildUpon().appendEncodedPath("albumInfo").build();
      localObject1 = locals.gJw.query((Uri)localObject2, new String[] { "_id", "_data", "mime_type", "date_modified", "datetaken", "latitude", "longitude" }, "albumID=?", new String[] { localObject1 }, null);
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
          if (locals.tSs) {
            break label384;
          }
          localObject2 = new s.g();
          ((s.g)localObject2).tSJ = bu.aSC(((Cursor)localObject1).getString(i));
          ((s.g)localObject2).data = ((Cursor)localObject1).getString(j);
          ((s.g)localObject2).type = ((Cursor)localObject1).getString(k);
          ((s.g)localObject2).tSK = bu.aSC(((Cursor)localObject1).getString(m));
          ae.d("MicroMsg.SmartGalleryQueryUtil", "mediaID:%d data:%s type:%s.", new Object[] { Long.valueOf(((s.g)localObject2).tSJ), ((s.g)localObject2).data, ((s.g)localObject2).type });
          localArrayList.add(localObject2);
          if (localArrayList.size() % locals.eU == 0)
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
    WeakReference<a> tXJ;
    WeakReference<ProgressDialog> tXK;
    WeakReference<ImageFolderMgrView> tXO;
    boolean tXY;
    int type;
    
    public final void run()
    {
      AppMethodBeat.i(111462);
      s locals = s.cYc();
      i.c local1 = new i.c()
      {
        public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(111461);
          ae.i("MicroMsg.AlbumPreviewUI", "RetrieveFavMediaTask onQueryMediaFinished cancelUINotify: %s.", new Object[] { Boolean.valueOf(AlbumPreviewUI.e.this.tXY) });
          if (AlbumPreviewUI.e.this.tXY)
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
            ae.d("MicroMsg.AlbumPreviewUI", "type: %s path: %s", new Object[] { localMediaItem.mMimeType, localMediaItem.tRJ });
          }
          paramAnonymousLinkedList = new AlbumPreviewUI.c((byte)0);
          paramAnonymousLinkedList.tXJ = AlbumPreviewUI.e.this.tXJ;
          paramAnonymousLinkedList.tXK = AlbumPreviewUI.e.this.tXK;
          paramAnonymousLinkedList.tXN = localLinkedList;
          paramAnonymousLinkedList.tXO = AlbumPreviewUI.e.this.tXO;
          e.cXs().f(paramAnonymousLinkedList);
          AppMethodBeat.o(111461);
        }
      };
      Object localObject2 = this.idList;
      int i1 = this.type;
      locals.tSt = false;
      LinkedList localLinkedList = new LinkedList();
      Object localObject1 = localObject2;
      if (bu.ht((List)localObject2))
      {
        ae.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id list now.");
        ae.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id, type: %d.", new Object[] { Integer.valueOf(i1) });
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
          if (!bu.ht((List)localObject2))
          {
            ae.i("MicroMsg.SmartGalleryQueryUtil", "fav list contains img or video.");
            ((List)localObject1).addAll((Collection)localObject2);
          }
          if (!bu.ht((List)localObject1)) {
            break;
          }
          ae.i("MicroMsg.SmartGalleryQueryUtil", "fav list do not contain img or video.");
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
      ae.i("MicroMsg.SmartGalleryQueryUtil", "fav count: %d.", new Object[] { Integer.valueOf(m) });
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
        if (!locals.tSt)
        {
          ae.i("MicroMsg.SmartGalleryQueryUtil", "get fav, count: %d.", new Object[] { Integer.valueOf(k) });
          localLinkedList.addAll(s.s(((List)localObject1).subList(j, i), i1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
 * JD-Core Version:    0.7.0.1
 */