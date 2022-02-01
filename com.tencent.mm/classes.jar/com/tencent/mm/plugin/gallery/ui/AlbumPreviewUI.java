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
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.b;
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
import com.tencent.mm.plugin.gallery.model.p;
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
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout.a;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.t.b;
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
  protected String dRL;
  private int gsi;
  private ProgressDialog gtM;
  protected int het;
  private List<Long> idList;
  private int jVX;
  private boolean krh;
  protected int kyt;
  private double latitude;
  private double longitude;
  private int oEo;
  private boolean qUd;
  public boolean qoL;
  protected String toUser;
  protected int wnd;
  protected RecyclerView xnM;
  private TextView xnN;
  private boolean xnO;
  private boolean xnP;
  protected a xnQ;
  private TextView xnR;
  private TextView xnS;
  private TextView xnT;
  private ImageFolderMgrView xnU;
  private TextView xnV;
  private ImageButton xnW;
  private String xnX;
  private String xnY;
  private String xnZ;
  protected String xnr;
  private a.f xnw;
  private HashMap<String, Integer> xoA;
  private HashSet<String> xoB;
  boolean xoC;
  private p.c xoD;
  private int xoE;
  private String xoF;
  private boolean xoa;
  private boolean xob;
  private boolean xoc;
  private boolean xod;
  private boolean xoe;
  private boolean xof;
  private boolean xog;
  private boolean xoh;
  boolean xoi;
  private int xoj;
  private int xok;
  private long xol;
  private long xom;
  private int xon;
  protected int xoo;
  private String xop;
  private i.b xoq;
  private boolean xor;
  protected int xos;
  private boolean xot;
  private e xou;
  private volatile long xov;
  protected MenuItem.OnMenuItemClickListener xow;
  private GalleryItem.AlbumItem xox;
  private a.d xoy;
  private volatile AlbumPreviewUI.b xoz;
  
  public AlbumPreviewUI()
  {
    AppMethodBeat.i(111463);
    this.xob = false;
    this.qoL = false;
    this.xog = false;
    this.xoh = false;
    this.xoi = false;
    this.xoj = 0;
    this.xok = 0;
    this.xol = 0L;
    this.xon = -1;
    this.qUd = true;
    this.idList = new ArrayList();
    this.jVX = 3;
    this.xov = -1L;
    this.xow = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(164796);
        int i = paramAnonymousMenuItem.getItemId();
        Log.d("MicroMsg.AlbumPreviewUI", "mId: %d.", new Object[] { Integer.valueOf(i) });
        if (1 == i)
        {
          Log.i("MicroMsg.AlbumPreviewUI", "go smart gallery.");
          a.a.xhE.xhr = 1;
          com.tencent.mm.plugin.gallery.model.s.dRv().eW(AlbumPreviewUI.this.xnQ.xnp);
          paramAnonymousMenuItem = new Intent(AlbumPreviewUI.this, SmartGalleryUI.class);
          paramAnonymousMenuItem.putExtra("select_type_tag", 2);
          paramAnonymousMenuItem.putExtras(AlbumPreviewUI.this.getIntent());
          paramAnonymousMenuItem.putExtra("send_raw_img", AlbumPreviewUI.this.qoL);
          AlbumPreviewUI.this.startActivityForResult(paramAnonymousMenuItem, 4382);
          AppMethodBeat.o(164796);
          return true;
        }
        boolean bool = AlbumPreviewUI.this.dyR();
        AppMethodBeat.o(164796);
        return bool;
      }
    };
    this.xoA = new HashMap();
    this.xnw = new a.f()
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
          AlbumPreviewUI.this.g(paramAnonymousInt1, paramAnonymousView);
        }
      }
    };
    this.xoD = p.c.xjz;
    this.xoE = -1;
    this.oEo = -1;
    this.krh = false;
    this.xoF = "";
    AppMethodBeat.o(111463);
  }
  
  private static int[] ar(ArrayList<GalleryItem.MediaItem> paramArrayList)
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
  
  private void ayY(String paramString)
  {
    AppMethodBeat.i(173773);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
      AppMethodBeat.o(173773);
      return;
    }
    e.dQL().ar(new d(paramString, this.xnQ, this.gtM, this.xnM));
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
    if (paramAlbumItem.Uqa) {}
    for (this.jVX = 3; Util.nullAs(this.xnY, "").equals(paramAlbumItem.albumName); this.jVX = 4)
    {
      Log.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
      AppMethodBeat.o(111472);
      return;
    }
    e.dQP().addAll(this.xnQ.xnp);
    Log.i("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[] { paramAlbumItem.albumName, paramAlbumItem.aQn() });
    this.xnX = paramAlbumItem.aQn();
    this.xnY = paramAlbumItem.albumName;
    if (Util.isNullOrNil(this.xnX))
    {
      Log.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
      this.xnX = this.xnY;
    }
    Object localObject1;
    Object localObject2;
    label221:
    int i;
    if (!Util.isNullOrNil(this.xnY))
    {
      localObject1 = this.xnQ;
      localObject2 = this.xoy;
      if (localObject2 == null)
      {
        Log.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
        localObject2 = paramAlbumItem.nickName;
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          if (this.xos != 3) {
            break label428;
          }
          localObject1 = getString(2131761082);
        }
        updateActionBarOperationAreaTxt((String)localObject1);
        NM(this.xnQ.xnp.size());
        this.gtM.show();
        start = System.currentTimeMillis();
        localObject2 = this.xnY;
        i = this.xos;
        localObject1 = localObject2;
        if (((String)localObject2).equals(getString(2131761083)))
        {
          localObject1 = "";
          i = 2;
        }
        if (!this.xnY.equalsIgnoreCase(getString(2131761089))) {
          break label458;
        }
        if (this.xou != null) {
          this.xou.xph = false;
        }
        e.dQL().as(this.xou);
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
        com.tencent.mm.plugin.report.service.h.CyF.a(18269, new Object[] { URLEncoder.encode((String)localObject1, "utf-8"), URLEncoder.encode(paramAlbumItem.nickName, "utf-8") });
        AppMethodBeat.o(111472);
        return;
      }
      catch (Exception paramAlbumItem)
      {
        AppMethodBeat.o(111472);
      }
      ((a)localObject1).xns.remove(localObject2);
      break;
      if (!getIntent().getBooleanExtra("show_header_view", true)) {
        break;
      }
      this.xnQ.a(this.xoy);
      break;
      label428:
      if (this.xos == 1)
      {
        localObject1 = getString(2131761081);
        break label221;
      }
      localObject1 = getString(2131761083);
      break label221;
      label458:
      if ((paramAlbumItem instanceof GalleryItem.PrivateAlbumItem))
      {
        e.dQK().dRs();
        this.xov = System.currentTimeMillis();
        com.tencent.mm.plugin.gallery.model.s.dRv().xjF = true;
        localObject1 = ((GalleryItem.PrivateAlbumItem)paramAlbumItem).xjf.xjJ;
        if (Util.isNullOrNil((String)localObject1)) {
          Log.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
        } else {
          e.dQL().as(new d((String)localObject1, this.xnQ, this.gtM, this.xnM));
        }
      }
      else
      {
        if (this.xou != null) {
          this.xou.xph = true;
        }
        com.tencent.mm.plugin.gallery.model.s.dRv().xjG = true;
        com.tencent.mm.plugin.gallery.model.s.dRv().xjF = true;
        this.xov = System.currentTimeMillis();
        e.dQK().D((String)localObject1, i, this.xov);
      }
    }
  }
  
  private void dRU()
  {
    AppMethodBeat.i(173771);
    Object localObject = e.dQL();
    a locala = new a(this);
    localObject = ((com.tencent.mm.plugin.gallery.model.g)localObject).dRf();
    if (localObject != null)
    {
      ((MMHandler)localObject).post(locala);
      AppMethodBeat.o(173771);
      return;
    }
    Log.w("MicroMsg.GalleryHandlerThread", "other handler is null.");
    AppMethodBeat.o(173771);
  }
  
  private void dRV()
  {
    AppMethodBeat.i(173772);
    if (this.xor)
    {
      this.xnQ.eX(com.tencent.mm.plugin.gallery.model.s.dRv().xjH);
      e.dQP().addAll(this.xnQ.xnp);
      NM(this.xnQ.xnp.size());
      ayY(getIntent().getStringExtra("album_id_from_smart_gallery"));
      this.gtM.show();
      AppMethodBeat.o(173772);
      return;
    }
    com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.iub).aSq();
    if (getIntent().hasExtra("gallery_report_tag")) {
      a.a.xhE.setScene(getIntent().getIntExtra("gallery_report_tag", 3));
    }
    for (;;)
    {
      Log.i("MicroMsg.AlbumPreviewUI", "start queryMediaInAlbums %s", new Object[] { this });
      e.dQK().a(this);
      this.xov = System.currentTimeMillis();
      e.dQK().ax(this.xnY, this.xov);
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111422);
          Log.d("MicroMsg.AlbumPreviewUI", "onCreate, post delay, dialog show.");
          if (AlbumPreviewUI.b.xoQ != AlbumPreviewUI.a(AlbumPreviewUI.this)) {
            AlbumPreviewUI.b(AlbumPreviewUI.this).show();
          }
          AppMethodBeat.o(111422);
        }
      }, 300L);
      p.a locala = p.xjw;
      p.dRt().a(new l());
      locala = p.xjw;
      p.dRt().a(new com.tencent.mm.plugin.gallery.model.q());
      AppMethodBeat.o(173772);
      return;
      a.a.xhE.setScene(this.het);
    }
  }
  
  private void dRW()
  {
    AppMethodBeat.i(111476);
    if (!com.tencent.mm.pluginsdk.ui.tools.s.d(getContext(), com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 4369))
    {
      Toast.makeText(getContext(), getString(2131765171), 1).show();
      AppMethodBeat.o(111476);
      return;
    }
    System.gc();
    AppMethodBeat.o(111476);
  }
  
  private void dRX()
  {
    AppMethodBeat.i(257740);
    if (this.xoB == null)
    {
      this.xoB = new HashSet();
      this.xoB.add(".h264");
      this.xoB.add(".h26l");
      this.xoB.add(".264");
      this.xoB.add(".avc");
      this.xoB.add(".mov");
      this.xoB.add(".mp4");
      this.xoB.add(".m4a");
      this.xoB.add(".3gp");
      this.xoB.add(".3g2");
      this.xoB.add(".mj2");
      this.xoB.add(".m4v");
    }
    AppMethodBeat.o(257740);
  }
  
  private void dRY()
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
      if ((!com.tencent.mm.q.a.o(getContext(), true)) && (!com.tencent.mm.q.a.cA(getContext())) && (!com.tencent.mm.q.a.cE(getContext()))) {
        com.tencent.mm.compatible.i.b.w(getContext());
      }
      AppMethodBeat.o(111485);
    }
  }
  
  private static void eY(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111480);
    long l = System.currentTimeMillis();
    Log.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (!com.tencent.mm.vfs.s.YS(localMediaItem.xiW))
      {
        Log.w("MicroMsg.AlbumPreviewUI", "filter non exist media: %s.", new Object[] { localMediaItem.xiW });
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
  
  protected final void NM(int paramInt)
  {
    AppMethodBeat.i(111479);
    label37:
    int i;
    int j;
    String str;
    if (paramInt == 0)
    {
      this.xnN.setEnabled(false);
      enableOptionMenu(false);
      if (paramInt != 0) {
        break label102;
      }
      this.xnN.setText(2131761111);
      i = this.het;
      j = this.wnd;
      str = this.xnr;
      if (this.xnQ != null) {
        break label148;
      }
    }
    label148:
    for (ArrayList localArrayList = null;; localArrayList = this.xnQ.xnp)
    {
      updateOptionMenuText(0, com.tencent.mm.plugin.gallery.a.d.a(this, i, paramInt, j, str, localArrayList));
      AppMethodBeat.o(111479);
      return;
      this.xnN.setEnabled(true);
      enableOptionMenu(true);
      break;
      label102:
      this.xnN.setText(getString(2131761111) + "(" + paramInt + ")");
      break label37;
    }
  }
  
  protected boolean a(GalleryItem.MediaItem paramMediaItem)
  {
    return true;
  }
  
  public final void az(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111473);
    switch (this.xos)
    {
    }
    Object localObject;
    do
    {
      do
      {
        AppMethodBeat.o(111473);
        return;
      } while ((Util.isNullOrNil(this.dRL)) || ("medianote".equals(this.toUser)));
      if (Util.currentTicks() - this.xol < 1000L)
      {
        Log.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111473);
        return;
      }
      Log.i("MicroMsg.AlbumPreviewUI", "notifyMM switch to SendImgProxyUI");
      localObject = (GalleryItem.MediaItem)this.xnQ.xno.get(paramInt);
    } while (((GalleryItem.MediaItem)localObject).getType() == 2);
    for (;;)
    {
      try
      {
        localObject = ((GalleryItem.MediaItem)localObject).xiW;
        String str = this.toUser;
        if (!this.xob) {
          if (!this.qoL)
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
    if (paramLong != this.xov)
    {
      Log.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.xov) });
      Log.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(111481);
      return;
    }
    Log.d("MicroMsg.AlbumPreviewUI", "onQueryMediaFinished: %s %s %s.", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.xnQ.xno.size()), Integer.valueOf(paramLinkedList.size()) });
    if ((paramBoolean) || (this.xnQ.xno.size() > paramLinkedList.size()))
    {
      eY(paramLinkedList);
      paramLinkedList = new LinkedList(paramLinkedList);
      if (this.xnQ != null) {
        break label338;
      }
    }
    label338:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AlbumPreviewUI", "[onQueryMediaFinished] adapter is null?:%s %s", new Object[] { Boolean.valueOf(bool), Util.getStack().toString() });
      if (this.xnQ != null)
      {
        c localc = new c((byte)0);
        localc.xoS = new WeakReference(this.xnQ);
        localc.xoT = new WeakReference(this.gtM);
        localc.xoU = new WeakReference(this.xnS);
        localc.xoV = new WeakReference(this.xnM);
        localc.xoW = paramLinkedList;
        localc.xop = this.xop;
        localc.xoY = paramBoolean;
        if (AlbumPreviewUI.b.xoP == this.xoz) {
          this.xoz = AlbumPreviewUI.b.xoQ;
        }
        e.dQL().postToMainThread(localc);
      }
      AppMethodBeat.o(111481);
      return;
      eY(paramLinkedList.subList(this.xnQ.xno.size(), paramLinkedList.size()));
      break;
    }
  }
  
  protected boolean b(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(257739);
    if (paramMediaItem == null)
    {
      Log.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
      AppMethodBeat.o(257739);
      return false;
    }
    int i;
    if (this.het == 3) {
      if ((paramMediaItem instanceof GalleryItem.VideoMediaItem)) {
        if (("video/hevc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).jkQ)) && (com.tencent.mm.plugin.n.f.ejb())) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if ((bG(paramMediaItem.xiW, true)) || (i == 0) || ((!Util.isNullOrNil(((GalleryItem.VideoMediaItem)paramMediaItem).jkR)) && (!"audio/mp4a-latm".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).jkR)))) {}
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label161;
        }
        com.tencent.mm.ui.base.h.cC(this, getString(2131761117));
        AppMethodBeat.o(257739);
        return false;
        if (!"video/avc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)paramMediaItem).jkQ)) {
          break label355;
        }
        i = 1;
        break;
      }
      label161:
      if (!new com.tencent.mm.vfs.o(paramMediaItem.xiW).exists())
      {
        com.tencent.mm.ui.base.h.cC(this, getString(2131761137));
        AppMethodBeat.o(257739);
        return false;
      }
      if (this.het == 3)
      {
        i = com.tencent.mm.plugin.gallery.a.d.azh(paramMediaItem.xiW);
        paramMediaItem = com.tencent.mm.n.a.gLV;
        if (i > com.tencent.mm.n.a.apH())
        {
          com.tencent.mm.ui.base.h.cC(this, getString(2131761140));
          AppMethodBeat.o(257739);
          return false;
        }
      }
      else if (this.het == 4)
      {
        i = com.tencent.mm.plugin.gallery.a.d.azh(paramMediaItem.xiW);
        paramMediaItem = com.tencent.mm.n.a.gLV;
        if (i > com.tencent.mm.n.a.apI())
        {
          com.tencent.mm.ui.base.h.cC(this, getString(2131761140));
          AppMethodBeat.o(257739);
          return false;
        }
      }
      else if ((this.het == 14) || (this.het == 22))
      {
        if (com.tencent.mm.plugin.gallery.a.d.azh(paramMediaItem.xiW) > 300)
        {
          com.tencent.mm.ui.base.h.cC(this, getString(2131761140));
          AppMethodBeat.o(257739);
          return false;
        }
        AppMethodBeat.o(257739);
        return true;
      }
      AppMethodBeat.o(257739);
      return true;
      label355:
      i = 0;
    }
  }
  
  public final boolean bG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(257741);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(257741);
      return true;
    }
    dRX();
    paramString = paramString.trim();
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length()))
    {
      AppMethodBeat.o(257741);
      return true;
    }
    if ((paramBoolean) && (r.Ql(paramString)))
    {
      AppMethodBeat.o(257741);
      return true;
    }
    if (!this.xoB.contains(paramString.substring(i).toLowerCase()))
    {
      AppMethodBeat.o(257741);
      return true;
    }
    AppMethodBeat.o(257741);
    return false;
  }
  
  protected boolean dyR()
  {
    int j = 0;
    AppMethodBeat.i(111475);
    Log.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[] { Integer.valueOf(e.dQR()), Boolean.valueOf(this.xob) });
    if (this.xob) {}
    for (int i = 3;; i = 2)
    {
      com.tencent.mm.plugin.gallery.a.d.bw(11610, i + "," + e.dQR());
      if (this.xon < 0) {
        this.xon = com.tencent.mm.plugin.gallery.a.d.aqq();
      }
      e.dQQ();
      if (this.xnQ.dRL().size() != 0) {
        break;
      }
      Log.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
      setResult(-2);
      finish();
      AppMethodBeat.o(111475);
      return true;
    }
    Object localObject1 = new Intent();
    i = this.xos;
    Object localObject2;
    if (this.xog)
    {
      if ((!this.xog) || (this.het != 16)) {
        break label1938;
      }
      localObject2 = this.xnQ.xnp.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label1938;
      }
      localObject2 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
      if (((GalleryItem.MediaItem)localObject2).getType() != 1) {
        break label357;
      }
      i = 1;
    }
    for (;;)
    {
      Object localObject5;
      Object localObject3;
      Object localObject4;
      label278:
      GalleryItem.MediaItem localMediaItem;
      label357:
      boolean bool;
      if (22 == e.dQK().mcq)
      {
        localObject5 = this.xnQ.xnp;
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        localObject4 = new int[this.wnd];
        localObject5 = ((ArrayList)localObject5).iterator();
        i = j;
        for (;;)
        {
          if (!((Iterator)localObject5).hasNext()) {
            break label417;
          }
          localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
          if (localMediaItem.getType() == 1)
          {
            if ((localMediaItem.mMimeType.equals("edit")) && (!Util.isNullOrNil(localMediaItem.xiY))) {
              ((ArrayList)localObject2).add(localMediaItem.xiY);
            }
            for (;;)
            {
              localObject4[i] = 1;
              i += 1;
              break label278;
              if (((GalleryItem.MediaItem)localObject2).getType() != 2) {
                break label1938;
              }
              i = 2;
              break;
              ((ArrayList)localObject2).add(localMediaItem.xiW);
            }
          }
          if (localMediaItem.getType() == 2)
          {
            ((ArrayList)localObject3).add(localMediaItem.xiW);
            localObject4[i] = 2;
            i += 1;
          }
        }
        label417:
        bool = com.tencent.mm.plugin.gallery.a.d.dSz();
        if ((com.tencent.mm.plugin.recordvideo.activity.a.b.q((List)localObject2, (List)localObject3) == 4) && (bool))
        {
          localObject1 = VLogPreloadUI.xsx;
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
        if ((this.xob) || (!this.qoL))
        {
          bool = true;
          ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
          localObject3 = this.xnQ.xnp;
          localObject2 = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label636;
          }
          localObject4 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
          if ((((GalleryItem.MediaItem)localObject4).mMimeType.equals("edit")) && (!Util.isNullOrNil(((GalleryItem.MediaItem)localObject4).xiY)))
          {
            ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).xiY);
            continue;
            bool = false;
            break;
          }
          ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).xiW);
        }
        label636:
        ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
        ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.xom);
        this.xom = 0L;
        setResult(-1, (Intent)localObject1);
        if ((!Util.isNullOrNil(this.xnr)) && (this.xnr.equals("album_business_bubble_media_by_coordinate"))) {
          ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
        }
        if (Util.currentTicks() - this.xol < 1000L)
        {
          Log.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
          AppMethodBeat.o(111475);
          return true;
        }
        Log.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE switch to SendImgProxyUI");
        this.xol = Util.currentTicks();
        if ((!Util.isNullOrNil(this.dRL)) && (!"medianote".equals(this.toUser)))
        {
          ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
          ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dRL);
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
        for (i = 0;; i = ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).dSv())
        {
          if (i != 0) {
            break label972;
          }
          ((Intent)localObject1).setData(FileProviderHelper.getUriForFile(getContext(), new com.tencent.mm.vfs.o((String)this.xnQ.dRL().get(0))));
          ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", this.xnQ.dRL());
          setResult(-1, (Intent)localObject1);
          finish();
          break;
          localObject2 = com.tencent.mm.plugin.gallery.ui.a.a.azf((String)this.xnQ.dRL().get(0));
          ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).mSize = this.xon;
        }
        label972:
        if (i == 2)
        {
          com.tencent.mm.ui.base.h.n(this, 2131767067, 2131761147);
          Log.w("MicroMsg.AlbumPreviewUI", "video is import error");
          AppMethodBeat.o(111475);
          return true;
        }
        com.tencent.mm.ui.base.h.n(this, 2131761146, 2131761147);
        Log.w("MicroMsg.AlbumPreviewUI", "video is over size");
        AppMethodBeat.o(111475);
        return true;
      }
      if (i == 3)
      {
        if ((!Util.isNullOrNil(this.xnr)) && (this.xnr.equals("album_business_bubble_media_by_coordinate")))
        {
          localObject4 = this.xnQ.xnp;
          localObject2 = new ArrayList();
          localObject3 = new ArrayList();
          localObject4 = ((ArrayList)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (GalleryItem.MediaItem)((Iterator)localObject4).next();
            if (((GalleryItem.MediaItem)localObject5).getType() == 1)
            {
              if ((((GalleryItem.MediaItem)localObject5).mMimeType.equals("edit")) && (!Util.isNullOrNil(((GalleryItem.MediaItem)localObject5).xiY))) {
                ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).xiY);
              } else {
                ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).xiW);
              }
            }
            else if (((GalleryItem.MediaItem)localObject5).getType() == 2) {
              ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject5).xiW);
            }
          }
          ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
          ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
          ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
          ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.xom);
          ((Intent)localObject1).putExtra("longitude", this.longitude);
          ((Intent)localObject1).putExtra("latitude", this.latitude);
          this.xom = 0L;
          setResult(-1, (Intent)localObject1);
          finish();
          AppMethodBeat.o(111475);
          return true;
        }
        if (Util.currentTicks() - this.xol < 1000L)
        {
          Log.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
          AppMethodBeat.o(111475);
          return true;
        }
        this.xol = Util.currentTicks();
        localObject5 = this.xnQ.xnp;
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        localObject4 = new int[this.wnd];
        localObject5 = ((ArrayList)localObject5).iterator();
        i = 0;
        label1381:
        if (((Iterator)localObject5).hasNext())
        {
          localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
          if (localMediaItem.getType() == 1)
          {
            if ((localMediaItem.mMimeType.equals("edit")) && (!Util.isNullOrNil(localMediaItem.xiY))) {
              ((ArrayList)localObject3).add(localMediaItem.xiY);
            }
            for (;;)
            {
              localObject4[i] = 1;
              i += 1;
              break;
              ((ArrayList)localObject3).add(localMediaItem.xiW);
            }
          }
          if (localMediaItem.getType() != 2) {
            break label1935;
          }
          ((ArrayList)localObject2).add(localMediaItem.xiW);
          j = i + 1;
          localObject4[i] = 2;
          i = j;
        }
      }
      label1800:
      label1935:
      for (;;)
      {
        break label1381;
        if ((this.xob) || (!this.qoL)) {}
        for (bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
          ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
          ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.xom);
          if (!this.xob) {
            break label1800;
          }
          if (((ArrayList)localObject2).size() != 0) {
            break;
          }
          ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
          ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.xom);
          this.xom = 0L;
          setResult(-1, (Intent)localObject1);
          finish();
          AppMethodBeat.o(111475);
          return true;
        }
        if (com.tencent.mm.plugin.recordvideo.activity.a.b.q((List)localObject3, (List)localObject2) == 4)
        {
          localObject1 = VLogPreloadUI.xsx;
          VLogPreloadUI.a.a(this, (ArrayList)localObject2, (ArrayList)localObject3, (int[])localObject4);
        }
        for (;;)
        {
          AppMethodBeat.o(111475);
          return true;
          localObject1 = RecordConfigProvider.aD((String)((ArrayList)localObject2).get(0), "", "");
          ((RecordConfigProvider)localObject1).BOv = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
          ((RecordConfigProvider)localObject1).scene = 2;
          localObject2 = new VideoCaptureReportInfo();
          ((VideoCaptureReportInfo)localObject2).sQn = 1;
          ((RecordConfigProvider)localObject1).BOE = ((VideoCaptureReportInfo)localObject2);
          localObject2 = new UICustomParam.a();
          ((UICustomParam.a)localObject2).apE();
          ((UICustomParam.a)localObject2).apD();
          ((UICustomParam.a)localObject2).dz(true);
          ((RecordConfigProvider)localObject1).BOn = ((UICustomParam.a)localObject2).gLU;
          localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772161, -1, (RecordConfigProvider)localObject1, 2, 0);
        }
        this.xom = 0L;
        if (((ArrayList)localObject3).size() > 0)
        {
          ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
          ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
          ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dRL);
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
      label1938:
      i = 1;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(111484);
    getIntent().putExtra("MMActivity.OverrideExitAnimation", 2130772130);
    getIntent().putExtra("MMActivity.OverrideEnterAnimation", 2130771986);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(111484);
  }
  
  protected void g(final int paramInt, View paramView)
  {
    AppMethodBeat.i(164801);
    Object localObject1 = this.xnQ.NK(paramInt);
    boolean bool1;
    if ((localObject1 == null) || (Util.isNullOrNil(((GalleryItem.MediaItem)localObject1).xiW)))
    {
      if (localObject1 == null) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.w("MicroMsg.AlbumPreviewUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(164801);
        return;
      }
    }
    if ((e.dQK().mcq == 5) && (((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")))
    {
      com.tencent.mm.ui.base.h.cD(getContext(), getString(2131761132));
      AppMethodBeat.o(164801);
      return;
    }
    if (1 == this.xos)
    {
      if (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("video"))
      {
        com.tencent.mm.ui.base.h.cD(getContext(), getString(2131761134));
        AppMethodBeat.o(164801);
      }
    }
    else if ((2 == this.xos) && (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("image")))
    {
      com.tencent.mm.ui.base.h.cD(getContext(), getString(2131761133));
      AppMethodBeat.o(164801);
      return;
    }
    int j = paramInt - this.xnQ.xns.size();
    Log.d("MicroMsg.AlbumPreviewUI", "onMediaClick, querySource %s item %s.", new Object[] { Integer.valueOf(this.het), localObject1 });
    if ((this.het == 0) || (this.het == 5) || (this.het == 10) || (this.het == 11) || (this.het == 27))
    {
      if (this.xos == 2)
      {
        com.tencent.mm.ui.base.h.a(this, true, getString(2131761148), "", getString(2131755976), getString(2131755761), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(179459);
            Log.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.setData(Uri.parse("file://" + Uri.encode(this.xoK.xiW)));
            AlbumPreviewUI.this.setResult(-1, paramAnonymousDialogInterface);
            a.a.xhE.al(this.xoK.xiW, AlbumPreviewUI.k(AlbumPreviewUI.this), paramInt);
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
        paramView.putExtra("video_full_path", ((GalleryItem.MediaItem)localObject1).xiW);
      }
      if (this.het == 10) {
        paramView.putExtra("CropImage_OutputPath", ((GalleryItem.MediaItem)localObject1).xiW);
      }
      paramView.setData(Uri.parse(Uri.encode(((GalleryItem.MediaItem)localObject1).xiW)));
      Log.i("MicroMsg.AlbumPreviewUI", "getItem ok");
      setResult(-1, paramView);
      a.a.xhE.al(((GalleryItem.MediaItem)localObject1).xiW, this.jVX, paramInt);
      finish();
      AppMethodBeat.o(164801);
      return;
    }
    boolean bool2;
    long l;
    int i;
    if (this.het == 4)
    {
      bool2 = com.tencent.mm.plugin.gallery.a.d.dSy();
      if ((!bool2) && (((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.xnQ.xnp.size() != 0))
      {
        com.tencent.mm.ui.base.h.cD(getContext(), com.tencent.mm.cb.a.aI(getContext(), 2131761101));
        AppMethodBeat.o(164801);
        return;
      }
      if ((bool2) && (com.tencent.mm.plugin.gallery.a.d.at(this.xnQ.xnp)))
      {
        bool1 = true;
        Log.i("MicroMsg.AlbumPreviewUI", "enableSnsVLog:%s skipEditVideo:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((((GalleryItem.MediaItem)localObject1).getType() != 2) || (bool1)) {
          break label1046;
        }
        paramView = com.tencent.mm.n.a.gLV;
        l = com.tencent.mm.n.a.apI() * 1000;
        paramView = com.tencent.mm.n.a.gLV;
        paramView = getString(2131761122, new Object[] { Integer.valueOf(com.tencent.mm.n.a.apI() / 60) });
        if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
          break label895;
        }
        if ((!"video/hevc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).jkQ)) || (!com.tencent.mm.plugin.n.f.ejb())) {
          break label795;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((bG(((GalleryItem.MediaItem)localObject1).xiW, true)) || (i == 0) || ((!Util.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).jkR)) && (!"audio/mp4a-latm".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).jkR))))
      {
        paramView = new f.a(getContext());
        paramView.aC(com.tencent.mm.cb.a.aI(getContext(), 2131761117));
        paramView.boA(com.tencent.mm.cb.a.aI(getContext(), 2131761094));
        paramView.b(new f.c()
        {
          public final void e(boolean paramAnonymousBoolean, String paramAnonymousString) {}
        });
        paramView.show();
        AppMethodBeat.o(164801);
        return;
        bool1 = false;
        break;
        label795:
        if (!"video/avc".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).jkQ)) {
          break label2747;
        }
        i = 1;
        continue;
      }
      if (((GalleryItem.VideoMediaItem)localObject1).jkS >= l)
      {
        localObject1 = new f.a(getContext());
        ((f.a)localObject1).aC(paramView);
        ((f.a)localObject1).boA(com.tencent.mm.cb.a.aI(getContext(), 2131761094));
        ((f.a)localObject1).b(new f.c()
        {
          public final void e(boolean paramAnonymousBoolean, String paramAnonymousString) {}
        });
        ((f.a)localObject1).show();
        AppMethodBeat.o(164801);
        return;
      }
      label895:
      paramView = RecordConfigProvider.aD(((GalleryItem.MediaItem)localObject1).xiW, "", "");
      paramView.BOv = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
      paramView.scene = 2;
      Object localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).sQn = 1;
      paramView.BOE = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).apE();
      ((UICustomParam.a)localObject2).apD();
      ((UICustomParam.a)localObject2).dz(true);
      paramView.BOn = ((UICustomParam.a)localObject2).gLU;
      a.a.xhE.al(((GalleryItem.MediaItem)localObject1).xiW, this.jVX, paramInt);
      this.xoF = ((GalleryItem.MediaItem)localObject1).xiW;
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772161, -1, paramView, 2, 0);
      AppMethodBeat.o(164801);
      return;
      label1046:
      Log.d("leextime", "jump from sns : " + Util.currentTicks());
      if (bool2) {}
      for (paramView = this.xnQ.xno;; paramView = this.xnQ.NJ(((GalleryItem.MediaItem)localObject1).getType()))
      {
        e.ao(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.xnQ.dRL());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.xnQ.xnp);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        az(j, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.qoL);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.xoc);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.xoe);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.xof);
        ((Intent)localObject2).putExtra("max_select_count", this.wnd);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dRL);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.jVX);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
        return;
      }
      if (this.het == 14)
      {
        if ((((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.xnQ.xnp.size() != 0))
        {
          com.tencent.mm.ui.base.h.cD(getContext(), com.tencent.mm.cb.a.aI(getContext(), 2131761101));
          AppMethodBeat.o(164801);
          return;
        }
        if (((GalleryItem.MediaItem)localObject1).getType() == 1)
        {
          paramView = this.xnQ.NJ(((GalleryItem.MediaItem)localObject1).getType());
          e.ao(paramView);
          localObject2 = new Intent(this, ImagePreviewUI.class);
          ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
          ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
          ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.xnQ.dRL());
          ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.xnQ.xnp);
          ((Intent)localObject2).putExtra("preview_all", true);
          ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
          az(j, true);
          ((Intent)localObject2).putExtra("send_raw_img", this.qoL);
          ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.xoc);
          ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.xoe);
          ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.xof);
          ((Intent)localObject2).putExtra("max_select_count", this.wnd);
          ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dRL);
          ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject2).putExtra("select_type_tag", this.jVX);
          startActivityForResult((Intent)localObject2, 0);
          AppMethodBeat.o(164801);
          return;
        }
        if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
          break label2735;
        }
        paramView = (GalleryItem.VideoMediaItem)localObject1;
        if (paramView.jkS <= 2000)
        {
          Log.i("MicroMsg.AlbumPreviewUI", "select story video, duration too long, duration:%s", new Object[] { Integer.valueOf(paramView.jkS) });
          com.tencent.mm.plugin.report.service.h.CyF.n(1005L, 53L, 1L);
          com.tencent.mm.ui.base.h.cD(getContext(), com.tencent.mm.cb.a.aI(getContext(), 2131761126));
          AppMethodBeat.o(164801);
          return;
        }
        if ((paramView.videoFrameRate <= 1) && (paramView.videoFrameRate >= 0))
        {
          Log.i("MicroMsg.AlbumPreviewUI", "select story video, videoFrameRate too small:%s, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.xiW });
          if (paramView.videoFrameRate > 1) {}
        }
      }
      try
      {
        localObject2 = SightVideoJNI.getSimpleMp4InfoVFS(paramView.xiW);
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
        label1856:
        break label1856;
      }
      if (paramView.videoFrameRate <= 0)
      {
        Log.i("MicroMsg.AlbumPreviewUI", "final videoFrameRate:%s, too small, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.xiW });
        com.tencent.mm.plugin.report.service.h.CyF.n(1005L, 54L, 1L);
        com.tencent.mm.ui.base.h.cD(getContext(), com.tencent.mm.cb.a.aI(getContext(), 2131761117));
        AppMethodBeat.o(164801);
        return;
      }
      Log.i("MicroMsg.AlbumPreviewUI", "maxDuration=%s", new Object[] { Long.valueOf(getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000 + 500) });
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("K_SEGMENTVIDEOPATH", paramView.xiW);
      ((Intent)localObject2).putExtra("KSEGMENTVIDEOTHUMBPATH", paramView.sUB);
      setResult(-1, (Intent)localObject2);
      a.a.xhE.al(((GalleryItem.MediaItem)localObject1).xiW, this.jVX, paramInt);
      finish();
      AppMethodBeat.o(164801);
      return;
      if (this.xog)
      {
        if (((GalleryItem.MediaItem)localObject1).getType() == 2) {
          paramInt = 1;
        }
        while ((this.het == 16) && ((this.xos == 2) || (this.xos == 3))) {
          if ((this.xnQ.xnp.size() > 0) && (((GalleryItem.MediaItem)this.xnQ.xnp.get(0)).getType() != ((GalleryItem.MediaItem)localObject1).getType()))
          {
            com.tencent.mm.ui.base.h.cD(getContext(), com.tencent.mm.cb.a.aI(getContext(), 2131761101));
            AppMethodBeat.o(164801);
            return;
            paramInt = this.wnd;
          }
          else
          {
            i = this.wnd;
          }
        }
        while ((this.het == 15) && (((GalleryItem.MediaItem)localObject1).getType() == 2))
        {
          AppMethodBeat.o(164801);
          return;
          i = paramInt;
          if (((GalleryItem.MediaItem)localObject1).getType() == 2)
          {
            i = paramInt;
            if (this.xnQ.xnp.size() != 0)
            {
              com.tencent.mm.ui.base.h.cD(getContext(), com.tencent.mm.cb.a.aI(getContext(), 2131761101));
              AppMethodBeat.o(164801);
              return;
            }
          }
        }
        paramView = this.xnQ.NJ(((GalleryItem.MediaItem)localObject1).getType());
        e.ao(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.xnQ.dRL());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.xnQ.xnp);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        az(j, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.qoL);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.xoc);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.xoe);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.xof);
        ((Intent)localObject2).putExtra("max_select_count", i);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.dRL);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.jVX);
        ((Intent)localObject2).putExtra("album_business_tag", this.xnr);
        ((Intent)localObject2).putExtra("album_video_max_duration", this.kyt);
        ((Intent)localObject2).putExtra("album_video_min_duration", this.xoo);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
        return;
      }
      e.ao(this.xnQ.xno);
      paramView = new Intent(this, ImagePreviewUI.class);
      paramView.putExtra("query_source_type", this.het);
      paramView.putStringArrayListExtra("preview_image_list", this.xnQ.dRL());
      paramView.putParcelableArrayListExtra("preview_media_item_list", this.xnQ.xnp);
      paramView.putExtra("preview_all", true);
      paramView.putExtra("preview_position", j);
      az(j, true);
      paramView.putExtra("send_raw_img", this.qoL);
      paramView.putExtra("key_force_hide_edit_image_button", this.xoc);
      paramView.putExtra("key_force_show_raw_image_button", this.xoe);
      paramView.putExtra("key_is_raw_image_button_disable", this.xof);
      paramView.putExtra("max_select_count", this.wnd);
      paramView.putExtra("GalleryUI_FromUser", this.dRL);
      paramView.putExtra("GalleryUI_ToUser", this.toUser);
      paramView.putExtra("album_business_tag", this.xnr);
      paramView.putExtra("album_video_max_duration", this.kyt);
      paramView.putExtra("album_video_min_duration", this.xoo);
      if (e.dQK().mcq == 14) {
        paramView.putExtra("key_edit_video_max_time_length", 300500);
      }
      paramView.putExtra("select_type_tag", this.jVX);
      startActivityForResult(paramView, 0);
      label2735:
      AppMethodBeat.o(164801);
      return;
      label2747:
      i = 0;
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496167;
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
    this.xnr = getIntent().getStringExtra("album_business_tag");
    this.kyt = getIntent().getIntExtra("album_video_max_duration", 10);
    this.xoo = getIntent().getIntExtra("album_video_min_duration", 0);
    this.dRL = getIntent().getStringExtra("GalleryUI_FromUser");
    this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
    this.wnd = getIntent().getIntExtra("max_select_count", 9);
    boolean bool;
    if (this.het == 4)
    {
      bool = true;
      this.xob = bool;
      this.xnX = getIntent().getStringExtra("folder_path");
      this.xnY = getIntent().getStringExtra("folder_name");
      if (Util.isNullOrNil(this.xnX))
      {
        Log.w("MicroMsg.AlbumPreviewUI", "folder path invalid, assign folderName: %s.", new Object[] { this.xnY });
        this.xnX = this.xnY;
      }
      if ((!getIntent().getBooleanExtra("key_send_raw_image", false)) && (!getIntent().getBooleanExtra("send_raw_img", false))) {
        break label1691;
      }
      bool = true;
      label294:
      this.qoL = bool;
      this.xoc = getIntent().getBooleanExtra("key_force_hide_edit_image_button", false);
      this.xod = getIntent().getBooleanExtra("key_force_hide_edit_image_button_after_album_take_image", false);
      this.xoe = getIntent().getBooleanExtra("key_force_show_raw_image_button", false);
      this.xof = getIntent().getBooleanExtra("key_is_raw_image_button_disable", false);
      this.xog = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
      this.xnV = ((TextView)findViewById(2131305708));
      this.xnW = ((ImageButton)findViewById(2131305707));
      this.xnV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111434);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          AlbumPreviewUI.c(AlbumPreviewUI.this).performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111434);
        }
      });
      if ((this.het != 3) && (!this.xoe)) {
        break label1697;
      }
      this.xnW.setVisibility(0);
      this.xnV.setVisibility(0);
      label449:
      if (!this.qoL) {
        break label1718;
      }
      this.xnW.setImageResource(2131691380);
      label466:
      if (this.xof) {
        this.xnW.setImageResource(2131691377);
      }
      localObject1 = this.xnW;
      if (this.xof) {
        break label1731;
      }
      bool = true;
      label499:
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.xnV;
      if (this.xof) {
        break label1737;
      }
      bool = true;
      label522:
      ((TextView)localObject1).setEnabled(bool);
      this.xnW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111435);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = AlbumPreviewUI.this;
          boolean bool;
          if (!AlbumPreviewUI.this.qoL)
          {
            bool = true;
            paramAnonymousView.qoL = bool;
            AlbumPreviewUI.d(AlbumPreviewUI.this);
            AlbumPreviewUI.e(AlbumPreviewUI.this).setText(AlbumPreviewUI.this.getContext().getString(2131761109).concat(AlbumPreviewUI.dRZ()));
            if (!AlbumPreviewUI.this.qoL) {
              break label143;
            }
            AlbumPreviewUI.c(AlbumPreviewUI.this).setImageResource(2131691380);
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
            AlbumPreviewUI.c(AlbumPreviewUI.this).setImageResource(2131691379);
          }
        }
      });
      this.xnM = ((RecyclerView)findViewById(2131304561));
      this.xnR = ((TextView)findViewById(2131296701));
      this.xnS = ((TextView)findViewById(2131296702));
      this.xnT = ((TextView)findViewById(2131296674));
      this.xnN = ((TextView)findViewById(2131304570));
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shC, 0)) {
        break label1743;
      }
      bool = true;
      label639:
      Log.i("MicroMsg.AlbumPreviewUI", "pennqin, smartGallerySwitch: %s.", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label1749;
      }
      bool = false;
      label667:
      Log.i("MicroMsg.AlbumPreviewUI", "pennqin, isFromSmartGallery: %s showSmartGallery: %s.", new Object[] { Boolean.valueOf(this.xor), Boolean.valueOf(bool) });
      if ((!this.xor) && ((bool) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)))
      {
        addTextOptionMenu(1, null, this.xow, null, t.b.OHh);
        if (this.xot) {
          dRU();
        }
      }
      if ((this.het != 0) && (this.het != 5) && (this.het != 10) && (this.het != 11) && (this.het != 24) && (this.het != 27)) {
        break label1845;
      }
      findViewById(2131296645).setVisibility(8);
      localObject1 = (FrameLayout.LayoutParams)this.xnM.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = 0;
      this.xnM.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      label836:
      this.xnU = ((ImageFolderMgrView)findViewById(2131302558));
      this.xnU.setListener(new ImageFolderMgrView.a()
      {
        public final void c(GalleryItem.AlbumItem paramAnonymousAlbumItem)
        {
          AppMethodBeat.i(111437);
          AlbumPreviewUI.a(AlbumPreviewUI.this, paramAnonymousAlbumItem);
          AppMethodBeat.o(111437);
        }
      });
      this.xnU.setOnFolderStateChanged(new ImageFolderMgrView.b()
      {
        public final void pB(boolean paramAnonymousBoolean)
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
            if ((AlbumPreviewUI.l(AlbumPreviewUI.this)) && (!AlbumPreviewUI.m(AlbumPreviewUI.this).getSelectedAlbumName().equalsIgnoreCase(AlbumPreviewUI.this.getString(2131761089)))) {
              AlbumPreviewUI.this.setSmartGalleryEntryVisibility(true);
            }
            if (AlbumPreviewUI.n(AlbumPreviewUI.this) != null)
            {
              if (!Util.nullAs(AlbumPreviewUI.o(AlbumPreviewUI.this), "").equals(AlbumPreviewUI.n(AlbumPreviewUI.this).albumName))
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
      localObject2 = this.xnU;
      bool = this.xot;
      Log.i("MicroMsg.ImageFolderMgrView", "attach, %s.", new Object[] { localObject2 });
      e.dQK().b((i.a)localObject2);
      e.dQK().a((i.a)localObject2);
      e.dQK().c(((ImageFolderMgrView)localObject2).xpX);
      localObject1 = e.dQK();
      localObject2 = ((ImageFolderMgrView)localObject2).xpX;
      ((com.tencent.mm.plugin.gallery.model.o)localObject1).xjk.add(localObject2);
      if (bool) {
        e.dQK().dRr();
      }
      this.xnZ = getIntent().getStringExtra("send_btn_string");
      this.xoa = getIntent().getBooleanExtra("is_hide_album_footer", false);
      if (this.xoa) {
        findViewById(2131296645).setVisibility(8);
      }
      enableOptionMenu(false);
      getContext();
      localObject1 = new GridLayoutManager(4);
      this.xnM.setLayoutManager((RecyclerView.LayoutManager)localObject1);
      localObject2 = new c.a(getContext()).NP(2131166492).NO(2131166492).dSd();
      ((c.a)localObject2).xpw = false;
      localObject2 = ((c.a)localObject2).dSf();
      this.xnM.a((RecyclerView.h)localObject2);
      this.xnM.a(new RecyclerView.l()
      {
        private Runnable qpo;
        
        private String dSc()
        {
          AppMethodBeat.i(111442);
          String str = AlbumPreviewUI.this.xnQ.NL(this.xoL.ks());
          if ((!Util.isNullOrNil(str)) && (str.equals("album_business_bubble_media_by_coordinate")))
          {
            str = AlbumPreviewUI.q(AlbumPreviewUI.this) + "附近的照片和视频";
            AppMethodBeat.o(111442);
            return str;
          }
          AppMethodBeat.o(111442);
          return str;
        }
        
        private void pC(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(111443);
          if (paramAnonymousBoolean)
          {
            AlbumPreviewUI.p(AlbumPreviewUI.this).removeCallbacks(this.qpo);
            if (AlbumPreviewUI.p(AlbumPreviewUI.this).getVisibility() != 0)
            {
              String str = dSc();
              AlbumPreviewUI.p(AlbumPreviewUI.this).setText(str);
              AlbumPreviewUI.p(AlbumPreviewUI.this).setVisibility(0);
              AlbumPreviewUI.p(AlbumPreviewUI.this).setAlpha(0.0F);
              AlbumPreviewUI.p(AlbumPreviewUI.this).animate().alpha(1.0F).setDuration(300L).start();
              AppMethodBeat.o(111443);
            }
          }
          else
          {
            AlbumPreviewUI.p(AlbumPreviewUI.this).removeCallbacks(this.qpo);
            AlbumPreviewUI.p(AlbumPreviewUI.this).postDelayed(this.qpo, 256L);
          }
          AppMethodBeat.o(111443);
        }
        
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(111444);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
          Log.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (1 == paramAnonymousInt)
          {
            pC(true);
            AlbumPreviewUI.r(AlbumPreviewUI.this).setVisibility(8);
            e.dQJ().dQE();
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
              pC(false);
              AlbumPreviewUI.a(AlbumPreviewUI.this, this.xoL.ks());
              AlbumPreviewUI.b(AlbumPreviewUI.this, this.xoL.ku());
              Log.d("MicroMsg.AlbumPreviewUI", "cancelTask logic, firstVisibleItem: %s lastVisibleItem: %s.", new Object[] { Integer.valueOf(AlbumPreviewUI.s(AlbumPreviewUI.this)), Integer.valueOf(AlbumPreviewUI.t(AlbumPreviewUI.this)) });
              paramAnonymousRecyclerView = p.xjw;
              p.dRt().a(p.c.xjz, AlbumPreviewUI.s(AlbumPreviewUI.this), AlbumPreviewUI.t(AlbumPreviewUI.this), AlbumPreviewUI.this.xnQ.xno.size());
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
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(111445);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousRecyclerView = dSc();
          AlbumPreviewUI.p(AlbumPreviewUI.this).setText(paramAnonymousRecyclerView);
          paramAnonymousInt1 = this.xoL.ks();
          int i = this.xoL.ku();
          Log.d("MicroMsg.AlbumPreviewUI", "pennqin, onScrolled, %s %s %s %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(i), Integer.valueOf(AlbumPreviewUI.s(AlbumPreviewUI.this)), Integer.valueOf(AlbumPreviewUI.t(AlbumPreviewUI.this)) });
          if ((AlbumPreviewUI.s(AlbumPreviewUI.this) != paramAnonymousInt1) || (AlbumPreviewUI.t(AlbumPreviewUI.this) != i))
          {
            AlbumPreviewUI.a(AlbumPreviewUI.this, paramAnonymousInt1);
            AlbumPreviewUI.b(AlbumPreviewUI.this, i);
            paramAnonymousRecyclerView = new ArrayList();
            paramAnonymousInt1 = AlbumPreviewUI.s(AlbumPreviewUI.this);
            while (paramAnonymousInt1 <= AlbumPreviewUI.t(AlbumPreviewUI.this))
            {
              localObject = AlbumPreviewUI.this.xnQ.NK(paramAnonymousInt1);
              if (localObject != null) {
                paramAnonymousRecyclerView.add(com.tencent.mm.plugin.gallery.a.d.a(((GalleryItem.MediaItem)localObject).aQn(), null, -1));
              }
              paramAnonymousInt1 += 1;
            }
            Log.d("MicroMsg.AlbumPreviewUI", "cancelTask, legalPaths size: %s.", new Object[] { Integer.valueOf(paramAnonymousRecyclerView.size()) });
            e.dQJ().eT(paramAnonymousRecyclerView);
            if (paramAnonymousInt2 != 0)
            {
              if (paramAnonymousInt2 >= 0) {
                break label389;
              }
              AlbumPreviewUI.a(AlbumPreviewUI.this, p.c.xjA);
            }
          }
          for (;;)
          {
            Log.d("MicroMsg.AlbumPreviewUI", "onScrolled, dy: %s state: %s.", new Object[] { Integer.valueOf(paramAnonymousInt2), AlbumPreviewUI.v(AlbumPreviewUI.this) });
            paramAnonymousRecyclerView = p.xjw;
            p.dRt().a(AlbumPreviewUI.v(AlbumPreviewUI.this), AlbumPreviewUI.s(AlbumPreviewUI.this), AlbumPreviewUI.t(AlbumPreviewUI.this), AlbumPreviewUI.this.xnQ.xno.size());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(111445);
            return;
            label389:
            AlbumPreviewUI.a(AlbumPreviewUI.this, p.c.xjB);
          }
        }
      });
      this.xnQ = new a(getContext(), new a.e()
      {
        public final void ah(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(111446);
          Object localObject = AlbumPreviewUI.this.xnQ.NK(paramAnonymousInt2);
          if (localObject == null)
          {
            AppMethodBeat.o(111446);
            return;
          }
          if (paramAnonymousInt3 == 0) {
            if (((GalleryItem.MediaItem)localObject).getType() == 1) {
              if (!AlbumPreviewUI.this.a((GalleryItem.MediaItem)localObject)) {
                AlbumPreviewUI.this.xnQ.i((GalleryItem.MediaItem)localObject);
              }
            }
          }
          while (Util.isNullOrNil(AlbumPreviewUI.this.xnQ.dRL()))
          {
            AppMethodBeat.o(111446);
            return;
            a.a.xhE.al(((GalleryItem.MediaItem)localObject).xiW, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
            AlbumPreviewUI.a(AlbumPreviewUI.this, (GalleryItem.MediaItem)localObject);
            AlbumPreviewUI.this.NM(paramAnonymousInt1);
            AlbumPreviewUI.this.az(paramAnonymousInt2, true);
            continue;
            if (((GalleryItem.MediaItem)localObject).getType() == 2)
            {
              if (!AlbumPreviewUI.this.b((GalleryItem.MediaItem)localObject))
              {
                AlbumPreviewUI.this.xnQ.i((GalleryItem.MediaItem)localObject);
              }
              else
              {
                a.a.xhE.al(((GalleryItem.MediaItem)localObject).xiW, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
                AlbumPreviewUI.this.NM(paramAnonymousInt1);
                AlbumPreviewUI.this.az(paramAnonymousInt2, true);
              }
            }
            else
            {
              a.a.xhE.al(((GalleryItem.MediaItem)localObject).xiW, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.NM(paramAnonymousInt1);
              AlbumPreviewUI.this.az(paramAnonymousInt2, true);
              continue;
              a.a.xhE.al(((GalleryItem.MediaItem)localObject).xiW, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.NM(paramAnonymousInt1);
              AlbumPreviewUI.this.az(paramAnonymousInt2, false);
            }
          }
          localObject = AlbumPreviewUI.this.xnQ.dRL().iterator();
          while (((Iterator)localObject).hasNext()) {
            if (!ImgUtil.isGif((String)((Iterator)localObject).next()))
            {
              AppMethodBeat.o(111446);
              return;
            }
          }
          AlbumPreviewUI.this.qoL = true;
          AppMethodBeat.o(111446);
        }
      });
      this.xnQ.xnw = this.xnw;
      if (!Util.isNullOrNil(this.xnr))
      {
        Log.d("MicroMsg.AlbumPreviewUI", "businessTag=%s", new Object[] { this.xnr });
        this.xnQ.xnr = this.xnr;
        this.xnQ.kyt = this.kyt;
        if (this.xnr.equals("album_business_bubble_media_by_coordinate"))
        {
          this.xnQ.xnt = false;
          e.dQK().xjn.dQw();
          this.xop = getIntent().getStringExtra("album_business_bubble_media_by_coordinate_posname");
          double d = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_distance", -1.0D);
          this.longitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 181.0D);
          this.latitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 91.0D);
          if ((d >= 0.0D) && (com.tencent.mm.modelgeo.a.m(this.longitude)) && (com.tencent.mm.modelgeo.a.n(this.latitude)))
          {
            this.xoq = new AlbumPreviewUI.2(this, d);
            localObject1 = e.dQK();
            localObject2 = this.xoq;
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.gallery.model.o)localObject1).xjm.add(localObject2);
            }
          }
        }
      }
      if (this.xog) {
        this.xnQ.xnt = true;
      }
      this.xoy = new a.b();
      if (getIntent().getBooleanExtra("show_header_view", true)) {
        this.xnQ.a(this.xoy);
      }
      this.xnQ.xjo = this.xos;
      this.xnQ.xnn = this.wnd;
      Log.i("MicroMsg.AlbumPreviewUI", "limit count = " + this.wnd);
      this.xnM.setAdapter(this.xnQ);
      if (!this.xor) {
        break label2023;
      }
      setActionbarColor(getResources().getColor(2131100500));
      setMMTitle(getIntent().getStringExtra("title_from_smart_gallery"));
      label1504:
      setNavigationbarColor(getResources().getColor(2131100500));
      setActionBarOperationAreaClickListener(new AlbumChooserView.a()
      {
        public final void dSb()
        {
          AppMethodBeat.i(179457);
          Log.i("MicroMsg.AlbumPreviewUI", "onAlbumChooserViewClick.");
          AlbumPreviewUI.a(AlbumPreviewUI.this, null);
          a.a.xhE.xhs = 1;
          Log.d("MicroMsg.AlbumPreviewUI", "click folder times: [%d].", new Object[] { Integer.valueOf(AlbumPreviewUI.B(AlbumPreviewUI.this)) });
          AlbumPreviewUI.C(AlbumPreviewUI.this);
          AlbumPreviewUI.this.playActionBarOperationAreaAnim();
          AlbumPreviewUI.m(AlbumPreviewUI.this).dSg();
          AppMethodBeat.o(179457);
        }
      });
      if (!this.xor) {
        break label2117;
      }
    }
    label1691:
    label1697:
    label1718:
    label1731:
    label2117:
    for (int i = 2131230850;; i = 2131689490)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(111424);
          Log.i("MicroMsg.AlbumPreviewUI", "backBtn");
          AlbumPreviewUI.this.onBackBtnClick();
          AlbumPreviewUI.this.setResult(-2, AlbumPreviewUI.this.getIntent().putExtra("send_raw_img", AlbumPreviewUI.this.qoL));
          if ((AlbumPreviewUI.m(AlbumPreviewUI.this) != null) && (AlbumPreviewUI.m(AlbumPreviewUI.this).jT))
          {
            AlbumPreviewUI.m(AlbumPreviewUI.this).dSg();
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
      localObject1 = (ViewGroup)findViewById(2131307157);
      if ((localObject1 instanceof DrawedCallBackFrameLayout)) {
        ((DrawedCallBackFrameLayout)localObject1).setListener(new DrawedCallBackFrameLayout.a()
        {
          public final void dSa()
          {
            AppMethodBeat.i(111425);
            com.tencent.mm.plugin.gallery.a.d.dSa();
            if (AlbumPreviewUI.this.xoi) {
              AlbumPreviewUI.this.xoi = false;
            }
            AppMethodBeat.o(111425);
          }
        });
      }
      this.xou = new e((byte)0);
      this.xou.xoS = new WeakReference(this.xnQ);
      this.xou.xoT = new WeakReference(this.gtM);
      this.xou.xoX = new WeakReference(this.xnU);
      this.xou.idList = this.idList;
      this.xou.type = this.xos;
      AppMethodBeat.o(111474);
      return;
      bool = false;
      break;
      bool = false;
      break label294;
      this.xnW.setVisibility(8);
      this.xnV.setVisibility(8);
      break label449;
      this.xnW.setImageResource(2131691379);
      break label466;
      bool = false;
      break label499;
      label1737:
      bool = false;
      break label522;
      label1743:
      bool = false;
      break label639;
      label1749:
      localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shD, "");
      localObject2 = Build.MANUFACTURER.toLowerCase();
      str = Build.MODEL.toLowerCase();
      Log.i("MicroMsg.AlbumPreviewUI", "pennqin, manufacturer: %s, model: %s, smartGalleryBlackList: %s.", new Object[] { localObject2, str, localObject1 });
      if ((((String)localObject1).contains((CharSequence)localObject2)) || (((String)localObject1).contains(str)))
      {
        bool = false;
        break label667;
      }
      bool = true;
      break label667;
      this.xnN.setVisibility(0);
      this.xnN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164797);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          AlbumPreviewUI.g(AlbumPreviewUI.this);
          paramAnonymousView = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
          e.ao(AlbumPreviewUI.this.xnQ.xno);
          paramAnonymousView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.xnQ.dRL());
          paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", AlbumPreviewUI.this.xnQ.xnp);
          paramAnonymousView.putExtra("max_select_count", AlbumPreviewUI.this.wnd);
          paramAnonymousView.putExtra("send_raw_img", AlbumPreviewUI.this.qoL);
          paramAnonymousView.putExtra("key_force_hide_edit_image_button", AlbumPreviewUI.h(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("key_force_show_raw_image_button", AlbumPreviewUI.i(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("key_is_raw_image_button_disable", AlbumPreviewUI.j(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.dRL);
          paramAnonymousView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
          paramAnonymousView.putExtra("select_type_tag", AlbumPreviewUI.k(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("album_business_tag", AlbumPreviewUI.this.xnr);
          paramAnonymousView.putExtra("album_video_max_duration", AlbumPreviewUI.this.kyt);
          paramAnonymousView.putExtra("album_video_min_duration", AlbumPreviewUI.this.xoo);
          AlbumPreviewUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164797);
        }
      });
      if (((this.xos != 1) && (this.xos != 2) && (this.xos != 3)) || (this.wnd <= 0)) {
        break label836;
      }
      if (!Util.isNullOrNil(this.xnZ))
      {
        addTextOptionMenu(0, this.xnZ, this.xow);
        break label836;
      }
      i = this.het;
      int j = this.wnd;
      localObject2 = this.xnr;
      if (this.xnQ == null) {}
      for (localObject1 = null;; localObject1 = this.xnQ.xnp)
      {
        localObject1 = com.tencent.mm.plugin.gallery.a.d.a(this, i, 0, j, (String)localObject2, (ArrayList)localObject1);
        if (this.het != 15) {
          break label2005;
        }
        addTextOptionMenu(0, (String)localObject1, this.xow, null, t.b.OHe);
        break;
      }
      label2005:
      addTextOptionMenu(0, (String)localObject1, this.xow, null, t.b.OHg);
      break label836;
      label2023:
      setActionbarColor(getResources().getColor(2131100500));
      getController().OGy = 2131492945;
      getController().a(this);
      initActionBarOperationArea();
      if (this.xos == 3)
      {
        initActionBarOperationAreaTxt(getString(2131761082));
        break label1504;
      }
      if (this.xos == 1)
      {
        initActionBarOperationAreaTxt(getString(2131761081));
        break label1504;
      }
      initActionBarOperationAreaTxt(getString(2131761083));
      break label1504;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(111478);
    Log.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d] %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    Object localObject2;
    if (4369 == paramInt1)
    {
      if (-1 != paramInt2)
      {
        AppMethodBeat.o(111478);
        return;
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.tools.s.h(getContext().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.aKV());
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
        AppMethodBeat.o(111478);
        return;
      }
      Log.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[] { localObject1 });
      if ((this.het == 0) || (this.het == 5) || (this.het == 11) || (this.het == 24))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setData(Uri.parse("file://" + Uri.encode((String)localObject1)));
        Log.i("MicroMsg.AlbumPreviewUI", "take photo finish");
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
            this.xnT.setVisibility(0);
            this.xnT.setText(getString(2131763902));
            localObject1 = AnimationUtils.loadAnimation(getContext(), 2130772059);
            this.xnT.startAnimation((Animation)localObject1);
            ((Animation)localObject1).setAnimationListener(new Animation.AnimationListener()
            {
              private Runnable xoI;
              
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                AppMethodBeat.i(111428);
                AlbumPreviewUI.A(AlbumPreviewUI.this).setVisibility(0);
                AlbumPreviewUI.A(AlbumPreviewUI.this).postDelayed(this.xoI, 4000L);
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
        ((Intent)localObject1).putExtra("send_raw_img", this.qoL);
        if ((this.xoc) || (this.xod)) {}
        for (bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("key_force_hide_edit_image_button", bool);
          ((Intent)localObject1).putExtra("key_force_show_raw_image_button", this.xoe);
          ((Intent)localObject1).putExtra("key_is_raw_image_button_disable", this.xof);
          ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
          if (this.xnQ != null) {
            ((Intent)localObject1).putParcelableArrayListExtra("preview_media_item_list", this.xnQ.xnp);
          }
          ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.dRL);
          ((Intent)localObject1).putExtra("GalleryUI_ToUser", this.toUser);
          ((Intent)localObject1).putExtra("select_type_tag", this.jVX);
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
          Log.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", new Object[] { paramIntent });
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
        }
        else if (4373 == paramInt1)
        {
          if (paramIntent != null)
          {
            paramIntent.putExtra("GalleryUI_IsSendImgBackground", true);
            Log.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
          }
          Log.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
          setResult(-1, paramIntent);
          this.xoi = true;
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
          if ((paramIntent.BOe.booleanValue()) && (!Util.isNullOrNil(paramIntent.thumbPath)))
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
          localObject3 = paramIntent.zsA;
          if (!Util.isNullOrNil((String)localObject3))
          {
            ((ArrayList)localObject2).add(localObject3);
            ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
          }
          if ((paramIntent.zsy) && (!Util.isNullOrNil(paramIntent.zsG)))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramIntent.zsG);
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
          }
          setResult(-1, (Intent)localObject1);
          finish();
        }
        else if (4376 == paramInt1)
        {
          if (-1 != paramInt2)
          {
            Log.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
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
              setMMTitle(Util.nullAs(((GalleryItem.AlbumItem)localObject1).albumName, getString(2131761082)));
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
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).eJJ().y("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
              this.xnP = true;
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
              if (Util.isNullOrNil(this.xoF)) {
                break;
              }
              localObject2 = a.a.xhE;
              localObject3 = this.xoF;
              Log.i("MicroMsg.GalleryReporter", "path: %s.", new Object[] { localObject3 });
              localObject1 = paramIntent;
              if (Util.isNullOrNil((String)localObject3)) {
                break;
              }
              ((com.tencent.mm.plugin.gallery.a)localObject2).xhy.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).xhz.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).xhA.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).xhB.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).xhC.remove(localObject3);
              ((com.tencent.mm.plugin.gallery.a)localObject2).xhD.remove(localObject3);
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
              this.qoL = paramIntent.getBooleanExtra("send_raw_img", this.qoL);
              if (this.qoL)
              {
                this.xnW.setImageResource(2131691380);
                if (this.xof) {
                  this.xnW.setImageResource(2131691377);
                }
                localObject2 = this.xnW;
                if (this.xof) {
                  break label1896;
                }
                bool = true;
                ((ImageButton)localObject2).setEnabled(bool);
                localObject2 = this.xnV;
                if (this.xof) {
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
                  Log.i("MicroMsg.AlbumPreviewUI", "key: %s, value: %s.", new Object[] { localObject3, ((Bundle)localObject1).get((String)localObject3) });
                }
                this.xnW.setImageResource(2131691379);
                break;
                bool = false;
                break label1784;
              }
            }
            if ((-2 == paramInt2) || (paramInt2 == 0) || (SmartGalleryUI.xrW == paramInt2))
            {
              Log.i("MicroMsg.AlbumPreviewUI", "just back from SmartGalleryUI.");
              paramIntent = new android.support.v4.e.b();
              paramInt1 = i;
              while (paramInt1 < this.xnQ.xnp.size())
              {
                localObject1 = (GalleryItem.MediaItem)this.xnQ.xnp.get(paramInt1);
                i = this.xnQ.xno.indexOf(localObject1);
                if (i != -1) {
                  paramIntent.add(Integer.valueOf(i));
                }
                paramInt1 += 1;
              }
              this.xnQ.eX(com.tencent.mm.plugin.gallery.model.s.dRv().xjH);
              if (SmartGalleryUI.xrW == paramInt2)
              {
                dyR();
                AppMethodBeat.o(111478);
                return;
              }
              NM(this.xnQ.xnp.size());
              this.xnQ.a(paramIntent);
              AppMethodBeat.o(111478);
              return;
            }
            if (-1 == paramInt2) {
              this.xnP = true;
            }
            setResult(paramInt2, paramIntent);
            finish();
            localObject1 = paramIntent;
          }
          else if (paramInt1 == 4381)
          {
            if (paramInt2 == -1)
            {
              if (this.xob)
              {
                paramIntent = RecordConfigProvider.jB("", "");
                paramIntent.BOv = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
                paramIntent.scene = 2;
                localObject1 = new VideoCaptureReportInfo();
                ((VideoCaptureReportInfo)localObject1).sQn = 1;
                paramIntent.BOE = ((VideoCaptureReportInfo)localObject1);
                localObject1 = new UICustomParam.a();
                ((UICustomParam.a)localObject1).apE();
                ((UICustomParam.a)localObject1).apD();
                ((UICustomParam.a)localObject1).dz(true);
                paramIntent.BOn = ((UICustomParam.a)localObject1).gLU;
                localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, 2130772161, -1, paramIntent, 4, 0);
                AppMethodBeat.o(111478);
                return;
              }
              localObject1 = paramIntent;
              if (22 == e.dQK().mcq)
              {
                setResult(-1, paramIntent);
                finish();
                AppMethodBeat.o(111478);
              }
            }
            else
            {
              Toast.makeText(this, 2131762444, 1).show();
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
              Log.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
              finish();
              localObject1 = paramIntent;
              break;
            case -1: 
              localObject1 = paramIntent;
              if (paramIntent == null)
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("CropImage_Compress_Img", true);
                ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", this.xnQ.dRL());
              }
              ((Intent)localObject1).putStringArrayListExtra("key_select_image_list", ((Intent)localObject1).getStringArrayListExtra("CropImage_OutputPath_List"));
              Log.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
              this.xnP = true;
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
      Log.i("MicroMsg.AlbumPreviewUI", "paths size: %d.", new Object[] { Integer.valueOf(paramInt1) });
      if ((localObject1 == null) || (this.xnQ == null)) {
        break label2588;
      }
      localObject2 = new android.support.v4.e.b();
      paramInt1 = 0;
      while (paramInt1 < this.xnQ.xnp.size())
      {
        localObject3 = (GalleryItem.MediaItem)this.xnQ.xnp.get(paramInt1);
        paramInt2 = this.xnQ.xno.indexOf(localObject3);
        if (paramInt2 != -1) {
          ((android.support.v4.e.b)localObject2).add(Integer.valueOf(paramInt2));
        }
        paramInt1 += 1;
      }
    }
    this.xnQ.aq((ArrayList)localObject1);
    this.xnQ.a((android.support.v4.e.b)localObject2);
    NM(((ArrayList)localObject1).size());
    label2588:
    if (!paramIntent.getBooleanExtra("CropImage_Compress_Img", true))
    {
      bool = true;
      label2602:
      this.qoL = bool;
      if (!this.qoL) {
        break label2700;
      }
      this.xnW.setImageResource(2131691380);
      label2625:
      if (this.xof) {
        this.xnW.setImageResource(2131691377);
      }
      localObject1 = this.xnW;
      if (this.xof) {
        break label2713;
      }
      bool = true;
      label2658:
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.xnV;
      if (this.xof) {
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
      this.xnW.setImageResource(2131691379);
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
    Log.i("MicroMsg.AlbumPreviewUI", "onCreate, %s.", new Object[] { this });
    setRequestedOrientation(1);
    String str1 = getString(2131763890);
    String str2 = getString(2131761100);
    this.xot = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, str1, str2);
    Log.d("MicroMsg.AlbumPreviewUI", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(this.xot) });
    this.xom = System.currentTimeMillis();
    start = System.currentTimeMillis();
    this.gtM = com.tencent.mm.ui.base.q.a(this, getString(2131756029), false);
    this.xoz = AlbumPreviewUI.b.xoP;
    if (paramBundle != null)
    {
      Log.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
      this.het = paramBundle.getInt("constants_key_query_source");
    }
    for (this.xos = paramBundle.getInt("constants_key_query_type");; this.xos = getIntent().getIntExtra("query_media_type", 1))
    {
      e.dQK().mcq = this.het;
      e.dQK().setQueryType(this.xos);
      Log.i("MicroMsg.AlbumPreviewUI", "query source: " + this.het + ", queryType: " + this.xos);
      this.jVX = getIntent().getIntExtra("select_type_tag", 3);
      this.qUd = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYM, true);
      this.xor = getIntent().getBooleanExtra("is_from_smart_gallery", false);
      initView();
      if (this.xot) {
        dRV();
      }
      e.dQS();
      AppMethodBeat.o(111464);
      return;
      this.het = getIntent().getIntExtra("query_source_type", 3);
    }
  }
  
  public void onDestroy()
  {
    boolean bool1 = false;
    AppMethodBeat.i(111469);
    super.onDestroy();
    Log.i("MicroMsg.AlbumPreviewUI", "onDestroy, %s.", new Object[] { this });
    if (e.dQK() != null)
    {
      e.dQK().b(this);
      com.tencent.mm.plugin.gallery.model.o localo = e.dQK();
      i.b localb = this.xoq;
      if (localb != null) {
        localo.xjm.remove(localb);
      }
    }
    if ((this.xoj > 0) || (this.xok > 0))
    {
      Log.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", new Object[] { Integer.valueOf(this.xoj), Integer.valueOf(this.xok) });
      com.tencent.mm.plugin.gallery.a.d.bw(11187, this.xoj + "," + this.xok);
    }
    for (;;)
    {
      if ((this.xol > 0L) || (this.xnP)) {
        e.a(this.xnZ, ar(this.xnQ.xnp), this.qoL, this.xnO);
      }
      int i = this.xnQ.xnp.size();
      boolean bool2 = this.qoL;
      if ((this.xol > 0L) || (this.xnP)) {
        bool1 = true;
      }
      e.g(i, bool2, bool1);
      ab.diQ.Uo().Un();
      e.dQN().clear();
      e.dQO().clear();
      e.dQP().clear();
      if (!this.xor) {
        break;
      }
      com.tencent.mm.plugin.gallery.model.s.dRv().xjF = true;
      if (e.dQT())
      {
        com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.iub).axJ();
        a.g.dRR();
      }
      AppMethodBeat.o(111469);
      return;
      Log.d("MicroMsg.AlbumPreviewUI", "not click camera or folder.");
    }
    if (!this.krh) {
      a.a.xhE.report();
    }
    for (;;)
    {
      com.tencent.mm.plugin.gallery.model.s.dRv().xjG = true;
      e.dQK().dRs();
      break;
      a.a.xhE.reset();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111477);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      Log.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
      setResult(-2);
      if ((this.xnU != null) && (this.xnU.jT))
      {
        this.xnU.dSg();
        playActionBarOperationAreaAnim();
        AppMethodBeat.o(111477);
        return true;
      }
      this.krh = true;
      finish();
      AppMethodBeat.o(111477);
      return true;
    }
    if (paramInt == 82)
    {
      this.xok += 1;
      if (this.xnU != null) {
        this.xnU.dSg();
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
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    this.xoh = true;
    ImageFolderMgrView localImageFolderMgrView;
    if ((!isFinishing()) && (!isDestroyed()) && (this.xnU != null) && (this.xnU.jT))
    {
      localImageFolderMgrView = this.xnU;
      if (localImageFolderMgrView.jT) {
        break label132;
      }
      Log.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
    }
    for (;;)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, this.gsi);
      this.gsi = 0;
      if (this.xor) {
        com.tencent.mm.plugin.gallery.model.s.dRv().eW(this.xnQ.xnp);
      }
      AppMethodBeat.o(111467);
      return;
      label132:
      if (localImageFolderMgrView.xpW)
      {
        Log.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
      }
      else
      {
        localImageFolderMgrView.xpS.setVisibility(8);
        localImageFolderMgrView.jT = false;
        if (localImageFolderMgrView.xqa != null) {
          localImageFolderMgrView.xqa.pB(false);
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
        dRW();
        AppMethodBeat.o(111483);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763864), getString(2131763890), getString(2131762043), getString(2131761084), false, new AlbumPreviewUI.6(this), null);
      AppMethodBeat.o(111483);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        dRU();
        e.dQK().dRr();
        dRV();
        AppMethodBeat.o(111483);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763870), getString(2131763890), getString(2131762043), getString(2131761084), false, new AlbumPreviewUI.7(this), new AlbumPreviewUI.8(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111465);
    super.onResume();
    Log.i("MicroMsg.AlbumPreviewUI", "onResume, %s.", new Object[] { this });
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    this.xoh = false;
    AppMethodBeat.o(111465);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(111470);
    super.onSaveInstanceState(paramBundle);
    Log.i("MicroMsg.AlbumPreviewUI", "onSaveInstanceState, %s.", new Object[] { this });
    paramBundle.putInt("constants_key_query_source", this.het);
    paramBundle.putInt("constants_key_query_type", this.xos);
    AppMethodBeat.o(111470);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(111466);
    super.onStart();
    Log.i("MicroMsg.AlbumPreviewUI", "onStart, %s.", new Object[] { this });
    if (e.dQK().mcq != this.het) {
      e.dQK().mcq = this.het;
    }
    if (e.dQK().xjo != this.xos) {
      e.dQK().setQueryType(this.xos);
    }
    AppMethodBeat.o(111466);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(111468);
    super.onStop();
    Log.i("MicroMsg.AlbumPreviewUI", "onStop, %s.", new Object[] { this });
    if (!this.xor)
    {
      com.tencent.mm.plugin.gallery.model.c localc = e.dQJ();
      if ((localc.xhQ != null) && (!localc.xhQ.isEmpty()))
      {
        Iterator localIterator = localc.xhQ.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.c localc1 = (c.c)((Map.Entry)localIterator.next()).getValue();
          if (localc1 != null) {
            localc1.mCancel = true;
          }
        }
        if (localc.xhP != null) {
          localc.xhP.clear();
        }
        if ((localc.xhQ != null) && (!localc.xhQ.isEmpty())) {
          localc.xhQ.clear();
        }
        localc.xhN.dQF();
      }
      e.dQJ().dQE();
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
    WeakReference<AlbumPreviewUI> mZg;
    
    a(AlbumPreviewUI paramAlbumPreviewUI)
    {
      AppMethodBeat.i(111448);
      this.mZg = new WeakReference(paramAlbumPreviewUI);
      AppMethodBeat.o(111448);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111449);
      long l = System.currentTimeMillis();
      boolean bool = com.tencent.mm.plugin.gallery.model.s.dRv().dRx();
      l = System.currentTimeMillis() - l;
      Log.i("MicroMsg.AlbumPreviewUI", "smart gallery isValid: %s, dur: %s.", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.h.CyF.a(19165, new Object[] { Long.valueOf(l) });
      if (l <= 3000L) {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1297, 0);
      }
      for (;;)
      {
        if (bool)
        {
          a.a.xhE.xhq = 1;
          e.dQL().postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111447);
              if (AlbumPreviewUI.a.this.mZg != null)
              {
                AlbumPreviewUI localAlbumPreviewUI = (AlbumPreviewUI)AlbumPreviewUI.a.this.mZg.get();
                if (localAlbumPreviewUI != null)
                {
                  localAlbumPreviewUI.setSmartGalleryEntryVisibility(true);
                  localAlbumPreviewUI.xoC = true;
                }
              }
              AppMethodBeat.o(111447);
            }
          });
        }
        AppMethodBeat.o(111449);
        return;
        if (l <= 5000L) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1297, 1);
        } else if (l <= 10000L) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1297, 2);
        } else if (l <= 15000L) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1297, 3);
        } else {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1297, 4);
        }
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    WeakReference<a> xoS;
    WeakReference<ProgressDialog> xoT;
    WeakReference<TextView> xoU;
    WeakReference<RecyclerView> xoV;
    LinkedList<GalleryItem.MediaItem> xoW;
    WeakReference<ImageFolderMgrView> xoX;
    boolean xoY = false;
    String xop;
    
    public final void run()
    {
      AppMethodBeat.i(111455);
      if (this.xoW == null) {}
      for (int i = -1;; i = this.xoW.size())
      {
        Log.d("MicroMsg.AlbumPreviewUI", "on NotifyMediaItemsChanged, size %d", new Object[] { Integer.valueOf(i) });
        AlbumPreviewUI.aO(this.xoW);
        if (this.xoS != null) {
          break;
        }
        Log.w("MicroMsg.AlbumPreviewUI", "null == adapterRef");
        AppMethodBeat.o(111455);
        return;
      }
      Object localObject1 = (a)this.xoS.get();
      if (localObject1 == null)
      {
        Log.w("MicroMsg.AlbumPreviewUI", "null == adapter");
        AppMethodBeat.o(111455);
        return;
      }
      if (this.xoV == null)
      {
        AppMethodBeat.o(111455);
        return;
      }
      RecyclerView localRecyclerView = (RecyclerView)this.xoV.get();
      if (localRecyclerView == null)
      {
        AppMethodBeat.o(111455);
        return;
      }
      Log.d("MicroMsg.AlbumPreviewUI", "isSwitchAlbum: %s.", new Object[] { Boolean.valueOf(this.xoY) });
      Object localObject2 = p.xjw;
      p.dRt().eU(this.xoW);
      if (this.xoY)
      {
        this.xoY = false;
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        localRecyclerView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((a)localObject1).aM(this.xoW);
        localObject2 = p.xjw;
        localObject2 = p.dRt();
        p.c localc = p.c.xjz;
        if (this.xoW.size() > 32)
        {
          i = 32;
          ((p)localObject2).a(localc, 0, i, ((a)localObject1).xno.size());
        }
      }
      for (;;)
      {
        if (this.xoT != null) {
          break label335;
        }
        AppMethodBeat.o(111455);
        return;
        i = this.xoW.size();
        break;
        ((a)localObject1).aN(this.xoW);
      }
      label335:
      localObject2 = (ProgressDialog)this.xoT.get();
      if ((localObject2 != null) && (((ProgressDialog)localObject2).isShowing()))
      {
        ((ProgressDialog)localObject2).dismiss();
        Log.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start) });
      }
      if (this.xoX != null)
      {
        localObject2 = (ImageFolderMgrView)this.xoX.get();
        if (localObject2 != null) {
          ((ImageFolderMgrView)localObject2).setFavItemCount(this.xoW.size());
        }
      }
      if ((this.xoU == null) || (Util.isNullOrNil(this.xop)))
      {
        AppMethodBeat.o(111455);
        return;
      }
      localObject2 = (TextView)this.xoU.get();
      if (localObject2 != null)
      {
        localObject1 = ((a)localObject1).NL(((GridLayoutManager)localRecyclerView.getLayoutManager()).ks());
        if ((!Util.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("album_business_bubble_media_by_coordinate")))
        {
          ((TextView)localObject2).setVisibility(0);
          ((TextView)localObject2).setText(this.xop.concat("附近的照片和视频"));
          ((TextView)localObject2).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111454);
              if (8 == this.xoZ.getVisibility())
              {
                AppMethodBeat.o(111454);
                return;
              }
              this.xoZ.animate().alpha(0.0F).setDuration(300L).withEndAction(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(111453);
                  AlbumPreviewUI.c.1.this.xoZ.setVisibility(8);
                  AlbumPreviewUI.c.1.this.xoZ.setAlpha(1.0F);
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
    private String xpc;
    private WeakReference<a> xpd;
    private WeakReference<ProgressDialog> xpe;
    private WeakReference<RecyclerView> xpf;
    
    d(String paramString, a parama, ProgressDialog paramProgressDialog, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(111458);
      this.xpc = paramString;
      this.xpd = new WeakReference(parama);
      this.xpe = new WeakReference(paramProgressDialog);
      this.xpf = new WeakReference(paramRecyclerView);
      AppMethodBeat.o(111458);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111459);
      if (Util.isNullOrNil(this.xpc))
      {
        AppMethodBeat.o(111459);
        return;
      }
      Log.i("QuerySmartGalleryAlbumMediaTask", "start query.");
      com.tencent.mm.plugin.gallery.model.s locals = com.tencent.mm.plugin.gallery.model.s.dRv();
      Object localObject1 = this.xpc;
      s.h local1 = new s.h()
      {
        public final void f(List<s.g> paramAnonymousList, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(161161);
          if (AlbumPreviewUI.d.a(AlbumPreviewUI.d.this) != null)
          {
            localObject = (a)AlbumPreviewUI.d.a(AlbumPreviewUI.d.this).get();
            if (localObject != null)
            {
              if ((!paramAnonymousBoolean) && (((a)localObject).xno.size() <= paramAnonymousList.size())) {
                break label148;
              }
              AlbumPreviewUI.d.eZ(paramAnonymousList);
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
              localMediaItem = GalleryItem.MediaItem.a(1, localg.xjW, localg.data, "", localg.type);
              localMediaItem.xja = localg.xjX;
              ((LinkedList)localObject).add(localMediaItem);
              continue;
              label148:
              AlbumPreviewUI.d.eZ(paramAnonymousList.subList(((a)localObject).xno.size(), paramAnonymousList.size()));
              break;
            }
            if (localg.type.contains("video"))
            {
              localMediaItem = GalleryItem.MediaItem.a(2, localg.xjW, localg.data, "", localg.type);
              localMediaItem.xja = localg.xjX;
              ((LinkedList)localObject).add(localMediaItem);
            }
          }
          label229:
          paramAnonymousList = new AlbumPreviewUI.c((byte)0);
          paramAnonymousList.xoS = AlbumPreviewUI.d.a(AlbumPreviewUI.d.this);
          paramAnonymousList.xoT = AlbumPreviewUI.d.b(AlbumPreviewUI.d.this);
          paramAnonymousList.xoW = ((LinkedList)localObject);
          paramAnonymousList.xoV = AlbumPreviewUI.d.c(AlbumPreviewUI.d.this);
          paramAnonymousList.xoY = paramAnonymousBoolean;
          e.dQL().postToMainThread(paramAnonymousList);
          Log.i("QuerySmartGalleryAlbumMediaTask", "finish page query.");
          AppMethodBeat.o(161161);
        }
      };
      locals.xjF = false;
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = com.tencent.mm.plugin.gallery.model.s.BASE_URI.buildUpon().appendEncodedPath("albumInfo").build();
      localObject1 = locals.hwt.query((Uri)localObject2, new String[] { "_id", "_data", "mime_type", "date_modified", "datetaken", "latitude", "longitude" }, "albumID=?", new String[] { localObject1 }, null);
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
          if (locals.xjF) {
            break label384;
          }
          localObject2 = new s.g();
          ((s.g)localObject2).xjW = Util.safeParseLong(((Cursor)localObject1).getString(i));
          ((s.g)localObject2).data = ((Cursor)localObject1).getString(j);
          ((s.g)localObject2).type = ((Cursor)localObject1).getString(k);
          ((s.g)localObject2).xjX = Util.safeParseLong(((Cursor)localObject1).getString(m));
          Log.d("MicroMsg.SmartGalleryQueryUtil", "mediaID:%d data:%s type:%s.", new Object[] { Long.valueOf(((s.g)localObject2).xjW), ((s.g)localObject2).data, ((s.g)localObject2).type });
          localArrayList.add(localObject2);
          if (localArrayList.size() % locals.eT == 0)
          {
            local1.f(localArrayList, bool);
            if (bool) {
              bool = false;
            }
          }
        }
        ((Cursor)localObject1).close();
      }
      for (;;)
      {
        local1.f(localArrayList, bool);
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
    int type;
    WeakReference<a> xoS;
    WeakReference<ProgressDialog> xoT;
    WeakReference<ImageFolderMgrView> xoX;
    boolean xph;
    
    public final void run()
    {
      AppMethodBeat.i(111462);
      com.tencent.mm.plugin.gallery.model.s locals = com.tencent.mm.plugin.gallery.model.s.dRv();
      i.c local1 = new i.c()
      {
        public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(111461);
          Log.i("MicroMsg.AlbumPreviewUI", "RetrieveFavMediaTask onQueryMediaFinished cancelUINotify: %s.", new Object[] { Boolean.valueOf(AlbumPreviewUI.e.this.xph) });
          if (AlbumPreviewUI.e.this.xph)
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
            Log.d("MicroMsg.AlbumPreviewUI", "type: %s path: %s", new Object[] { localMediaItem.mMimeType, localMediaItem.xiW });
          }
          paramAnonymousLinkedList = new AlbumPreviewUI.c((byte)0);
          paramAnonymousLinkedList.xoS = AlbumPreviewUI.e.this.xoS;
          paramAnonymousLinkedList.xoT = AlbumPreviewUI.e.this.xoT;
          paramAnonymousLinkedList.xoW = localLinkedList;
          paramAnonymousLinkedList.xoX = AlbumPreviewUI.e.this.xoX;
          e.dQL().postToMainThread(paramAnonymousLinkedList);
          AppMethodBeat.o(111461);
        }
      };
      Object localObject2 = this.idList;
      int i1 = this.type;
      locals.xjG = false;
      LinkedList localLinkedList = new LinkedList();
      Object localObject1 = localObject2;
      if (Util.isNullOrNil((List)localObject2))
      {
        Log.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id list now.");
        Log.i("MicroMsg.SmartGalleryQueryUtil", "query fav media id, type: %d.", new Object[] { Integer.valueOf(i1) });
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        switch (i1)
        {
        default: 
          ((List)localObject2).add(Integer.valueOf(2));
        }
        for (;;)
        {
          localObject2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().b(null, null, (List)localObject2);
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
      int m = ((List)localObject1).size();
      Log.i("MicroMsg.SmartGalleryQueryUtil", "fav count: %d.", new Object[] { Integer.valueOf(m) });
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
        if (!locals.xjG)
        {
          Log.i("MicroMsg.SmartGalleryQueryUtil", "get fav, count: %d.", new Object[] { Integer.valueOf(k) });
          localLinkedList.addAll(com.tencent.mm.plugin.gallery.model.s.w(((List)localObject1).subList(j, i), i1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
 * JD-Core Version:    0.7.0.1
 */