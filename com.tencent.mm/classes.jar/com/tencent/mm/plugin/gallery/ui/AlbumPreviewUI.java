package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.b;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.gallery.a.a;
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
import com.tencent.mm.plugin.gallery.model.GalleryItem.PrivateAlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c.c;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.i.b;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.p.a;
import com.tencent.mm.plugin.gallery.model.p.c;
import com.tencent.mm.plugin.gallery.model.s.a;
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
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.AlbumChooserView.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
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
  protected int AYg;
  protected String BZJ;
  private a.f BZO;
  boolean CaA;
  private int CaB;
  private int CaC;
  private long CaD;
  private long CaE;
  private long CaF;
  protected int CaG;
  private String CaH;
  private i.b CaI;
  private boolean CaJ;
  private boolean CaK;
  private String CaL;
  protected int CaM;
  private boolean CaN;
  private AlbumPreviewUI.f CaO;
  private volatile long CaP;
  protected MenuItem.OnMenuItemClickListener CaQ;
  private GalleryItem.AlbumItem CaR;
  private a.d CaS;
  private volatile AlbumPreviewUI.b CaT;
  private HashMap<String, Integer> CaU;
  boolean CaV;
  GalleryItem.MediaItem CaW;
  private p.c CaX;
  private String CaY;
  protected RecyclerView Cae;
  private TextView Caf;
  private boolean Cag;
  private boolean Cah;
  protected a Cai;
  private TextView Caj;
  private TextView Cak;
  private TextView Cal;
  private ImageFolderMgrView Cam;
  private TextView Can;
  private ImageButton Cao;
  private String Cap;
  private String Caq;
  private String Car;
  private boolean Cas;
  private boolean Cat;
  private boolean Cau;
  private boolean Cav;
  private boolean Caw;
  private boolean Cax;
  private boolean Cay;
  private boolean Caz;
  protected String fLi;
  private int iWt;
  private ProgressDialog iXX;
  private List<Long> idList;
  protected int jQj;
  private double latitude;
  private double longitude;
  private boolean niT;
  protected int nrt;
  private int rFX;
  private int selectType;
  private int svC;
  public boolean tNu;
  protected String toUser;
  private boolean uwj;
  
  public AlbumPreviewUI()
  {
    AppMethodBeat.i(111463);
    this.Cat = false;
    this.tNu = false;
    this.Cay = false;
    this.Caz = false;
    this.CaA = false;
    this.CaB = 0;
    this.CaC = 0;
    this.CaD = 0L;
    this.CaF = -1L;
    this.uwj = true;
    this.idList = new ArrayList();
    this.selectType = 3;
    this.CaP = -1L;
    this.CaQ = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(164796);
        int i = paramAnonymousMenuItem.getItemId();
        Log.d("MicroMsg.AlbumPreviewUI", "mId: %d.", new Object[] { Integer.valueOf(i) });
        if (1 == i)
        {
          Log.i("MicroMsg.AlbumPreviewUI", "go smart gallery.");
          a.a.BTR.BTE = 1;
          com.tencent.mm.plugin.gallery.model.s.etX().fm(AlbumPreviewUI.this.Cai.BZH);
          paramAnonymousMenuItem = new Intent(AlbumPreviewUI.this, SmartGalleryUI.class);
          paramAnonymousMenuItem.putExtra("select_type_tag", 2);
          paramAnonymousMenuItem.putExtras(AlbumPreviewUI.this.getIntent());
          paramAnonymousMenuItem.putExtra("send_raw_img", AlbumPreviewUI.this.tNu);
          AlbumPreviewUI.this.startActivityForResult(paramAnonymousMenuItem, 4382);
          AppMethodBeat.o(164796);
          return true;
        }
        boolean bool = AlbumPreviewUI.this.dZI();
        AppMethodBeat.o(164796);
        return bool;
      }
    };
    this.CaU = new HashMap();
    this.BZO = new a.f()
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
          AlbumPreviewUI.this.h(paramAnonymousInt1, paramAnonymousView);
        }
      }
    };
    this.CaW = null;
    this.CaX = p.c.BVO;
    this.svC = -1;
    this.rFX = -1;
    this.niT = false;
    this.CaY = "";
    AppMethodBeat.o(111463);
  }
  
  private void a(int paramInt, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(243194);
    if (!k(paramMediaItem))
    {
      Log.i("MicroMsg.AlbumPreviewUI", "not support ratio");
      localObject = null;
      if ((paramMediaItem instanceof GalleryItem.ImageMediaItem)) {
        localObject = getResources().getString(b.i.gallery_select_pic_ratio_not_support);
      }
      if (localObject != null) {
        com.tencent.mm.ui.base.h.cO(getContext(), (String)localObject);
      }
      AppMethodBeat.o(243194);
      return;
    }
    Object localObject = new Intent();
    if (paramMediaItem.getType() == 2)
    {
      ((Intent)localObject).putExtra("is_video", true);
      ((Intent)localObject).putExtra("video_full_path", paramMediaItem.AAz);
    }
    if (this.jQj == 10) {
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramMediaItem.AAz);
    }
    ((Intent)localObject).setData(Uri.parse(Uri.encode(paramMediaItem.AAz)));
    Log.i("MicroMsg.AlbumPreviewUI", "getItem ok");
    setResult(-1, (Intent)localObject);
    a.a.BTR.an(paramMediaItem.AAz, this.selectType, paramInt);
    finish();
    AppMethodBeat.o(243194);
  }
  
  private void a(List<String> paramList1, List<String> paramList2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(243180);
    Iterator localIterator = this.Cai.BZH.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (localMediaItem.getType() == 1)
      {
        if ((localMediaItem.mMimeType.equals("edit")) && (!Util.isNullOrNil(localMediaItem.BVk))) {
          paramList1.add(localMediaItem.BVk);
        }
        for (;;)
        {
          paramArrayOfInt[i] = 1;
          i += 1;
          break;
          paramList1.add(localMediaItem.AAz);
        }
      }
      if (localMediaItem.getType() != 2) {
        break label164;
      }
      paramList2.add(localMediaItem.AAz);
      int j = i + 1;
      paramArrayOfInt[i] = 2;
      i = j;
    }
    label164:
    for (;;)
    {
      break;
      AppMethodBeat.o(243180);
      return;
    }
  }
  
  private void aIx(String paramString)
  {
    AppMethodBeat.i(173773);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
      AppMethodBeat.o(173773);
      return;
    }
    com.tencent.mm.plugin.gallery.model.e.etm().aw(new AlbumPreviewUI.e(paramString, this.Cai, this.iXX, this.Cae));
    AppMethodBeat.o(173773);
  }
  
  private boolean aIy(String paramString)
  {
    AppMethodBeat.i(243191);
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
          AppMethodBeat.o(243191);
          return false;
        }
        float f3 = i / j;
        if (((f1 >= 0.0F) && (f3 < f1)) || ((f2 >= 0.0F) && (f3 > f2)))
        {
          AppMethodBeat.o(243191);
          return false;
        }
        AppMethodBeat.o(243191);
        return true;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(243191);
        return true;
      }
    }
    AppMethodBeat.o(243191);
    return true;
  }
  
  private static int[] ax(ArrayList<GalleryItem.MediaItem> paramArrayList)
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
  
  private void b(GalleryItem.AlbumItem paramAlbumItem)
  {
    AppMethodBeat.i(111472);
    if (paramAlbumItem == null)
    {
      AppMethodBeat.o(111472);
      return;
    }
    if (paramAlbumItem.MtX) {}
    for (this.selectType = 3; Util.nullAs(this.Caq, "").equals(paramAlbumItem.albumName); this.selectType = 4)
    {
      Log.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
      AppMethodBeat.o(111472);
      return;
    }
    com.tencent.mm.plugin.gallery.model.e.etq().addAll(this.Cai.BZH);
    Log.i("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[] { paramAlbumItem.albumName, paramAlbumItem.aZe() });
    this.Cap = paramAlbumItem.aZe();
    this.Caq = paramAlbumItem.albumName;
    if (Util.isNullOrNil(this.Cap))
    {
      Log.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
      this.Cap = this.Caq;
    }
    Object localObject1;
    Object localObject2;
    label221:
    int i;
    if (!Util.isNullOrNil(this.Caq))
    {
      localObject1 = this.Cai;
      localObject2 = this.CaS;
      if (localObject2 == null)
      {
        Log.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
        localObject2 = paramAlbumItem.nickName;
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          if (this.CaM != 3) {
            break label439;
          }
          localObject1 = getString(b.i.gallery_all_pic_and_video);
        }
        updateActionBarOperationAreaTxt((String)localObject1);
        Ta(this.Cai.BZH.size());
        this.iXX.show();
        start = System.currentTimeMillis();
        localObject2 = this.Caq;
        i = this.CaM;
        localObject1 = localObject2;
        if (((String)localObject2).equals(getString(b.i.gallery_all_video)))
        {
          localObject1 = "";
          i = 2;
        }
        if (!(paramAlbumItem instanceof GalleryItem.PrivateAlbumItem)) {
          break label498;
        }
        com.tencent.mm.plugin.gallery.model.e.etl().etU();
        this.CaP = System.currentTimeMillis();
        com.tencent.mm.plugin.gallery.model.s.etX().BVV = true;
        localObject1 = ((GalleryItem.PrivateAlbumItem)paramAlbumItem).BVu.BVZ;
        if (!Util.isNullOrNil((String)localObject1)) {
          break label469;
        }
        Log.e("MicroMsg.AlbumPreviewUI", "album id is invalid.");
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
        com.tencent.mm.plugin.report.service.h.IzE.a(18269, new Object[] { URLEncoder.encode((String)localObject1, "utf-8"), URLEncoder.encode(paramAlbumItem.nickName, "utf-8") });
        AppMethodBeat.o(111472);
        return;
      }
      catch (Exception paramAlbumItem)
      {
        AppMethodBeat.o(111472);
      }
      ((a)localObject1).BZK.remove(localObject2);
      break;
      if (!getIntent().getBooleanExtra("show_header_view", true)) {
        break;
      }
      this.Cai.a(this.CaS);
      break;
      label439:
      if (this.CaM == 1)
      {
        localObject1 = getString(b.i.gallery_all_pic);
        break label221;
      }
      localObject1 = getString(b.i.gallery_all_video);
      break label221;
      label469:
      com.tencent.mm.plugin.gallery.model.e.etm().ax(new AlbumPreviewUI.e((String)localObject1, this.Cai, this.iXX, this.Cae));
      continue;
      label498:
      if (this.CaO != null) {
        this.CaO.CbB = true;
      }
      com.tencent.mm.plugin.gallery.model.s.etX().BVW = true;
      com.tencent.mm.plugin.gallery.model.s.etX().BVV = true;
      this.CaP = System.currentTimeMillis();
      com.tencent.mm.plugin.gallery.model.e.etl().E((String)localObject1, i, this.CaP);
    }
  }
  
  private void euw()
  {
    AppMethodBeat.i(173771);
    Object localObject = com.tencent.mm.plugin.gallery.model.e.etm();
    AlbumPreviewUI.a locala = new AlbumPreviewUI.a(this);
    localObject = ((g)localObject).etG();
    if (localObject != null)
    {
      ((MMHandler)localObject).post(locala);
      AppMethodBeat.o(173771);
      return;
    }
    Log.w("MicroMsg.GalleryHandlerThread", "other handler is null.");
    AppMethodBeat.o(173771);
  }
  
  private void eux()
  {
    AppMethodBeat.i(173772);
    if (this.CaJ)
    {
      this.Cai.fn(com.tencent.mm.plugin.gallery.model.s.etX().BVX);
      com.tencent.mm.plugin.gallery.model.e.etq().addAll(this.Cai.BZH);
      Ta(this.Cai.BZH.size());
      aIx(getIntent().getStringExtra("album_id_from_smart_gallery"));
      this.iXX.show();
      AppMethodBeat.o(173772);
      return;
    }
    com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.ljk).bbn();
    if (getIntent().hasExtra("gallery_report_tag")) {
      a.a.BTR.setScene(getIntent().getIntExtra("gallery_report_tag", 3));
    }
    for (;;)
    {
      Log.i("MicroMsg.AlbumPreviewUI", "start queryMediaInAlbums %s", new Object[] { this });
      com.tencent.mm.plugin.gallery.model.e.etl().a(this);
      this.CaP = System.currentTimeMillis();
      com.tencent.mm.plugin.gallery.model.e.etl().ax(this.Caq, this.CaP);
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111422);
          Log.d("MicroMsg.AlbumPreviewUI", "onCreate, post delay, dialog show.");
          if (AlbumPreviewUI.b.Cbj != AlbumPreviewUI.a(AlbumPreviewUI.this)) {
            AlbumPreviewUI.b(AlbumPreviewUI.this).show();
          }
          AppMethodBeat.o(111422);
        }
      }, 300L);
      p.a locala = com.tencent.mm.plugin.gallery.model.p.BVL;
      com.tencent.mm.plugin.gallery.model.p.etV().a(new l());
      locala = com.tencent.mm.plugin.gallery.model.p.BVL;
      com.tencent.mm.plugin.gallery.model.p.etV().a(new com.tencent.mm.plugin.gallery.model.q());
      AppMethodBeat.o(173772);
      return;
      a.a.BTR.setScene(this.jQj);
    }
  }
  
  private void euy()
  {
    AppMethodBeat.i(111476);
    if (!com.tencent.mm.pluginsdk.ui.tools.u.d(getContext(), com.tencent.mm.loader.j.b.aSX(), "microMsg." + System.currentTimeMillis() + ".jpg", 4369))
    {
      Toast.makeText(getContext(), getString(b.i.selectcameraapp_none), 1).show();
      AppMethodBeat.o(111476);
      return;
    }
    System.gc();
    AppMethodBeat.o(111476);
  }
  
  private void euz()
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
      if ((!com.tencent.mm.q.a.p(getContext(), true)) && (!com.tencent.mm.q.a.cw(getContext())) && (!com.tencent.mm.q.a.cB(getContext()))) {
        com.tencent.mm.compatible.i.b.v(getContext());
      }
      AppMethodBeat.o(111485);
    }
  }
  
  private static void fo(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111480);
    long l = System.currentTimeMillis();
    Log.d("MicroMsg.AlbumPreviewUI", "filterNonExistMedia size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (!com.tencent.mm.vfs.u.agG(localMediaItem.AAz))
      {
        Log.w("MicroMsg.AlbumPreviewUI", "filter non exist media: %s.", new Object[] { localMediaItem.AAz });
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
  
  private boolean k(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(243190);
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
      MMBitmapFactory.decodeFile(paramMediaItem.AAz, localOptions);
      j = localOptions.outWidth;
      i = localOptions.outHeight;
    }
    for (;;)
    {
      if ((j == 0) || (i == 0))
      {
        AppMethodBeat.o(243190);
        return false;
      }
      float f3 = j / i;
      if (((f1 >= 0.0F) && (f3 < f1)) || ((f2 >= 0.0F) && (f3 > f2)))
      {
        AppMethodBeat.o(243190);
        return false;
      }
      AppMethodBeat.o(243190);
      return true;
      AppMethodBeat.o(243190);
      return true;
      label169:
      i = 0;
      j = 0;
    }
  }
  
  protected final void Ta(int paramInt)
  {
    AppMethodBeat.i(111479);
    label37:
    int i;
    int j;
    String str;
    if (paramInt == 0)
    {
      this.Caf.setEnabled(false);
      enableOptionMenu(false);
      if (paramInt != 0) {
        break label102;
      }
      this.Caf.setText(b.i.gallery_pic_preview);
      i = this.jQj;
      j = this.AYg;
      str = this.BZJ;
      if (this.Cai != null) {
        break label148;
      }
    }
    label148:
    for (ArrayList localArrayList = null;; localArrayList = this.Cai.BZH)
    {
      updateOptionMenuText(0, com.tencent.mm.plugin.gallery.a.e.a(this, i, paramInt, j, str, localArrayList));
      AppMethodBeat.o(111479);
      return;
      this.Caf.setEnabled(true);
      enableOptionMenu(true);
      break;
      label102:
      this.Caf.setText(getString(b.i.gallery_pic_preview) + "(" + paramInt + ")");
      break label37;
    }
  }
  
  protected boolean a(GalleryItem.MediaItem paramMediaItem)
  {
    return true;
  }
  
  public final void aD(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111473);
    switch (this.CaM)
    {
    }
    Object localObject;
    do
    {
      do
      {
        AppMethodBeat.o(111473);
        return;
      } while ((Util.isNullOrNil(this.fLi)) || ("medianote".equals(this.toUser)));
      if (Util.currentTicks() - this.CaD < 1000L)
      {
        Log.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
        AppMethodBeat.o(111473);
        return;
      }
      Log.i("MicroMsg.AlbumPreviewUI", "notifyMM switch to SendImgProxyUI");
      localObject = (GalleryItem.MediaItem)this.Cai.BZG.get(paramInt);
    } while (((GalleryItem.MediaItem)localObject).getType() == 2);
    for (;;)
    {
      try
      {
        localObject = ((GalleryItem.MediaItem)localObject).AAz;
        String str = this.toUser;
        if (!this.Cat) {
          if (!this.tNu)
          {
            break label177;
            com.tencent.mm.plugin.gallery.a.e.b((String)localObject, str, bool, paramBoolean);
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
    if (paramLong != this.CaP)
    {
      Log.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.CaP) });
      Log.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(111481);
      return;
    }
    Log.d("MicroMsg.AlbumPreviewUI", "onQueryMediaFinished: %s %s %s.", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.Cai.BZG.size()), Integer.valueOf(paramLinkedList.size()) });
    boolean bool;
    label150:
    Object localObject;
    if ((paramBoolean) || (this.Cai.BZG.size() > paramLinkedList.size()))
    {
      fo(paramLinkedList);
      paramLinkedList = new LinkedList(paramLinkedList);
      if (this.Cai != null) {
        break label401;
      }
      bool = true;
      Log.i("MicroMsg.AlbumPreviewUI", "[onQueryMediaFinished] adapter is null?:%s %s", new Object[] { Boolean.valueOf(bool), Util.getStack().toString() });
      if (this.Cai != null)
      {
        localObject = new AlbumPreviewUI.d((byte)0);
        ((AlbumPreviewUI.d)localObject).Cbn = new WeakReference(this.Cai);
        ((AlbumPreviewUI.d)localObject).Cbo = new WeakReference(this.iXX);
        ((AlbumPreviewUI.d)localObject).Cbp = new WeakReference(this.Cak);
        ((AlbumPreviewUI.d)localObject).Cbq = new WeakReference(this.Cae);
        ((AlbumPreviewUI.d)localObject).Cbr = paramLinkedList;
        ((AlbumPreviewUI.d)localObject).CaH = this.CaH;
        ((AlbumPreviewUI.d)localObject).Cbs = paramBoolean;
        if (AlbumPreviewUI.b.Cbi == this.CaT) {
          this.CaT = AlbumPreviewUI.b.Cbj;
        }
        com.tencent.mm.plugin.gallery.model.e.etm().postToMainThread((Runnable)localObject);
        localObject = new c((byte)0);
        ((c)localObject).count = paramLinkedList.size();
        if (paramLinkedList.size() <= 0) {
          break label407;
        }
        ((c)localObject).Cbm = ((GalleryItem.MediaItem)paramLinkedList.get(0));
      }
    }
    for (;;)
    {
      ((c)localObject).Cbl = new WeakReference(this.Cam);
      com.tencent.mm.plugin.gallery.model.e.etm().postToMainThread((Runnable)localObject);
      AppMethodBeat.o(111481);
      return;
      fo(paramLinkedList.subList(this.Cai.BZG.size(), paramLinkedList.size()));
      break;
      label401:
      bool = false;
      break label150;
      label407:
      ((c)localObject).Cbm = null;
      Log.d("MicroMsg.AlbumPreviewUI", "onQueryMediaFinished, newMediaItems size = 0.");
    }
  }
  
  protected boolean b(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(243187);
    if (paramMediaItem == null)
    {
      Log.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
      AppMethodBeat.o(243187);
      return false;
    }
    if ((this.jQj == 3) && (!com.tencent.mm.plugin.gallery.a.a.CeX.b(this.jQj, paramMediaItem)))
    {
      com.tencent.mm.ui.base.h.cN(this, getString(b.i.gallery_pic_video_not_support_desc));
      AppMethodBeat.o(243187);
      return false;
    }
    if (!new com.tencent.mm.vfs.q(paramMediaItem.AAz).ifE())
    {
      com.tencent.mm.ui.base.h.cN(this, getString(b.i.gallery_select_video_not_exit));
      AppMethodBeat.o(243187);
      return false;
    }
    int i;
    if (this.jQj == 3)
    {
      i = com.tencent.mm.plugin.gallery.a.e.aIH(paramMediaItem.AAz);
      paramMediaItem = com.tencent.mm.n.a.jwk;
      if (i > com.tencent.mm.n.a.awa())
      {
        com.tencent.mm.ui.base.h.cN(this, getString(b.i.gallery_select_video_to_long));
        AppMethodBeat.o(243187);
        return false;
      }
    }
    else if (this.jQj == 4)
    {
      i = com.tencent.mm.plugin.gallery.a.e.aIH(paramMediaItem.AAz);
      paramMediaItem = com.tencent.mm.n.a.jwk;
      if (i > com.tencent.mm.n.a.awb())
      {
        com.tencent.mm.ui.base.h.cN(this, getString(b.i.gallery_select_video_to_long));
        AppMethodBeat.o(243187);
        return false;
      }
    }
    else if ((this.jQj == 14) || (this.jQj == 22))
    {
      if (com.tencent.mm.plugin.gallery.a.e.aIH(paramMediaItem.AAz) > 300)
      {
        com.tencent.mm.ui.base.h.cN(this, getString(b.i.gallery_select_video_to_long));
        AppMethodBeat.o(243187);
        return false;
      }
      AppMethodBeat.o(243187);
      return true;
    }
    AppMethodBeat.o(243187);
    return true;
  }
  
  protected boolean dZI()
  {
    AppMethodBeat.i(111475);
    Log.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.ets()), Boolean.valueOf(this.Cat) });
    if (this.Cat) {}
    for (int i = 3;; i = 2)
    {
      com.tencent.mm.plugin.gallery.a.e.bt(11610, i + "," + com.tencent.mm.plugin.gallery.model.e.ets());
      if (this.CaF < 0L) {
        this.CaF = com.tencent.mm.plugin.gallery.a.e.awJ();
      }
      com.tencent.mm.plugin.gallery.model.e.etr();
      if (this.Cai.eun().size() != 0) {
        break;
      }
      Log.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
      setResult(-2);
      finish();
      AppMethodBeat.o(111475);
      return true;
    }
    Object localObject1 = new Intent();
    i = this.CaM;
    Object localObject2;
    if (this.Cay)
    {
      if ((!this.Cay) || (this.jQj != 16)) {
        break label2026;
      }
      localObject2 = this.Cai.BZH.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label2026;
      }
      localObject2 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
      if (((GalleryItem.MediaItem)localObject2).getType() != 1) {
        break label439;
      }
      i = 1;
    }
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      label439:
      boolean bool;
      if (22 == com.tencent.mm.plugin.gallery.model.e.etl().pag)
      {
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        localObject4 = new int[this.AYg];
        a((List)localObject2, (List)localObject3, (int[])localObject4);
        if ((this.CaK) && (((ArrayList)localObject3).size() > 0))
        {
          localObject1 = RecordConfigProvider.ay((String)((ArrayList)localObject3).get(0), "", "");
          ((RecordConfigProvider)localObject1).HLb = 15000;
          ((RecordConfigProvider)localObject1).scene = 2;
          localObject2 = new UICustomParam.a();
          ((UICustomParam.a)localObject2).avX();
          ((UICustomParam.a)localObject2).avW();
          ((UICustomParam.a)localObject2).dZ(true);
          ((RecordConfigProvider)localObject1).HKT = ((UICustomParam.a)localObject2).jwj;
          ((RecordConfigProvider)localObject1).HLm = false;
          ((RecordConfigProvider)localObject1).HLn = false;
          ((RecordConfigProvider)localObject1).HLo = true;
          ((RecordConfigProvider)localObject1).HKW = Boolean.TRUE;
          ((RecordConfigProvider)localObject1).HKV = 4;
          if (!TextUtils.isEmpty(this.CaL)) {
            ((RecordConfigProvider)localObject1).G(2, this.CaL);
          }
          localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4383, com.tencent.mm.plugin.gallery.b.a.sight_slide_bottom_in, -1, (RecordConfigProvider)localObject1, 2, 0);
          AppMethodBeat.o(111475);
          return true;
          if (((GalleryItem.MediaItem)localObject2).getType() == 2) {
            i = 2;
          }
        }
        else
        {
          bool = com.tencent.mm.plugin.gallery.a.e.evb();
          if ((com.tencent.mm.plugin.recordvideo.activity.a.b.u((List)localObject2, (List)localObject3) == 4) && (bool))
          {
            localObject1 = VLogPreloadUI.CeT;
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
        if (this.jQj == 28)
        {
          localObject1 = this.Cai.BZH;
          if (((ArrayList)localObject1).size() > 0) {
            a(0, (GalleryItem.MediaItem)((ArrayList)localObject1).get(0));
          }
          AppMethodBeat.o(111475);
          return true;
        }
        if (i == 1)
        {
          if ((this.Cat) || (!this.tNu))
          {
            bool = true;
            ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
            localObject3 = this.Cai.BZH;
            localObject2 = new ArrayList();
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label720;
            }
            localObject4 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
            if ((((GalleryItem.MediaItem)localObject4).mMimeType.equals("edit")) && (!Util.isNullOrNil(((GalleryItem.MediaItem)localObject4).BVk)))
            {
              ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).BVk);
              continue;
              bool = false;
              break;
            }
            ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject4).AAz);
          }
          label720:
          ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject2);
          ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.CaE);
          this.CaE = 0L;
          setResult(-1, (Intent)localObject1);
          if ((!Util.isNullOrNil(this.BZJ)) && (this.BZJ.equals("album_business_bubble_media_by_coordinate"))) {
            ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
          }
          if (Util.currentTicks() - this.CaD < 1000L)
          {
            Log.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
            AppMethodBeat.o(111475);
            return true;
          }
          Log.i("MicroMsg.AlbumPreviewUI", "QUERY_TYPE_IMAGE switch to SendImgProxyUI");
          this.CaD = Util.currentTicks();
          if ((!Util.isNullOrNil(this.fLi)) && (!"medianote".equals(this.toUser)))
          {
            ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.fLi);
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
          for (i = 0;; i = ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).bNF())
          {
            if (i != 0) {
              break label1060;
            }
            ((Intent)localObject1).setData(FileProviderHelper.getUriForFile(getContext(), new com.tencent.mm.vfs.q((String)this.Cai.eun().get(0))));
            ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", this.Cai.eun());
            setResult(-1, (Intent)localObject1);
            finish();
            break;
            localObject2 = new com.tencent.mm.plugin.gallery.ui.a.a((String)this.Cai.eun().get(0));
            ((com.tencent.mm.plugin.gallery.ui.a.a)localObject2).aKk = this.CaF;
          }
          label1060:
          if (i == 2)
          {
            com.tencent.mm.ui.base.h.p(this, b.i.video_export_file_error, b.i.gallery_send_video_over_size_title);
            Log.w("MicroMsg.AlbumPreviewUI", "video is import error");
            AppMethodBeat.o(111475);
            return true;
          }
          com.tencent.mm.ui.base.h.p(this, b.i.gallery_send_video_over_size, b.i.gallery_send_video_over_size_title);
          Log.w("MicroMsg.AlbumPreviewUI", "video is over size");
          AppMethodBeat.o(111475);
          return true;
        }
        if (i == 3)
        {
          if ((!Util.isNullOrNil(this.BZJ)) && (this.BZJ.equals("album_business_bubble_media_by_coordinate")))
          {
            localObject4 = this.Cai.BZH;
            localObject2 = new ArrayList();
            localObject3 = new ArrayList();
            localObject4 = ((ArrayList)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (GalleryItem.MediaItem)((Iterator)localObject4).next();
              if (((GalleryItem.MediaItem)localObject5).getType() == 1)
              {
                if ((((GalleryItem.MediaItem)localObject5).mMimeType.equals("edit")) && (!Util.isNullOrNil(((GalleryItem.MediaItem)localObject5).BVk))) {
                  ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).BVk);
                } else {
                  ((ArrayList)localObject3).add(((GalleryItem.MediaItem)localObject5).AAz);
                }
              }
              else if (((GalleryItem.MediaItem)localObject5).getType() == 2) {
                ((ArrayList)localObject2).add(((GalleryItem.MediaItem)localObject5).AAz);
              }
            }
            ((Intent)localObject1).putExtra("CropImage_Compress_Img", false);
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
            ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
            ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.CaE);
            ((Intent)localObject1).putExtra("longitude", this.longitude);
            ((Intent)localObject1).putExtra("latitude", this.latitude);
            this.CaE = 0L;
            setResult(-1, (Intent)localObject1);
            finish();
            AppMethodBeat.o(111475);
            return true;
          }
          if (Util.currentTicks() - this.CaD < 1000L)
          {
            Log.w("MicroMsg.AlbumPreviewUI", "sendImg btn event frequency limit");
            AppMethodBeat.o(111475);
            return true;
          }
          this.CaD = Util.currentTicks();
          Object localObject5 = this.Cai.BZH;
          localObject2 = new ArrayList();
          localObject3 = new ArrayList();
          localObject4 = new int[this.AYg];
          localObject5 = ((ArrayList)localObject5).iterator();
          i = 0;
          label1469:
          if (((Iterator)localObject5).hasNext())
          {
            GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
            if (localMediaItem.getType() == 1)
            {
              if ((localMediaItem.mMimeType.equals("edit")) && (!Util.isNullOrNil(localMediaItem.BVk))) {
                ((ArrayList)localObject3).add(localMediaItem.BVk);
              }
              for (;;)
              {
                localObject4[i] = 1;
                i += 1;
                break;
                ((ArrayList)localObject3).add(localMediaItem.AAz);
              }
            }
            if (localMediaItem.getType() != 2) {
              break label2023;
            }
            ((ArrayList)localObject2).add(localMediaItem.AAz);
            int j = i + 1;
            localObject4[i] = 2;
            i = j;
          }
        }
        label1888:
        label2023:
        for (;;)
        {
          break label1469;
          if ((this.Cat) || (!this.tNu)) {}
          for (bool = true;; bool = false)
          {
            ((Intent)localObject1).putExtra("CropImage_Compress_Img", bool);
            ((Intent)localObject1).putStringArrayListExtra("key_select_video_list", (ArrayList)localObject2);
            ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.CaE);
            if (!this.Cat) {
              break label1888;
            }
            if (((ArrayList)localObject2).size() != 0) {
              break;
            }
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
            ((Intent)localObject1).putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.CaE);
            this.CaE = 0L;
            setResult(-1, (Intent)localObject1);
            finish();
            AppMethodBeat.o(111475);
            return true;
          }
          if (com.tencent.mm.plugin.recordvideo.activity.a.b.u((List)localObject3, (List)localObject2) == 4)
          {
            localObject1 = VLogPreloadUI.CeT;
            VLogPreloadUI.a.a(this, (ArrayList)localObject2, (ArrayList)localObject3, (int[])localObject4);
          }
          for (;;)
          {
            AppMethodBeat.o(111475);
            return true;
            localObject1 = RecordConfigProvider.ay((String)((ArrayList)localObject2).get(0), "", "");
            ((RecordConfigProvider)localObject1).HLb = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
            ((RecordConfigProvider)localObject1).scene = 2;
            localObject2 = new VideoCaptureReportInfo();
            ((VideoCaptureReportInfo)localObject2).wwk = 1;
            ((RecordConfigProvider)localObject1).HLk = ((VideoCaptureReportInfo)localObject2);
            localObject2 = new UICustomParam.a();
            ((UICustomParam.a)localObject2).avX();
            ((UICustomParam.a)localObject2).avW();
            ((UICustomParam.a)localObject2).dZ(true);
            ((RecordConfigProvider)localObject1).HKT = ((UICustomParam.a)localObject2).jwj;
            localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
            com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, com.tencent.mm.plugin.gallery.b.a.sight_slide_bottom_in, -1, (RecordConfigProvider)localObject1, 2, 0);
          }
          this.CaE = 0L;
          if (((ArrayList)localObject3).size() > 0)
          {
            ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
            ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.fLi);
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
      label2026:
      i = 1;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(111484);
    getIntent().putExtra("MMActivity.OverrideExitAnimation", com.tencent.mm.plugin.gallery.b.a.push_down_out);
    getIntent().putExtra("MMActivity.OverrideEnterAnimation", com.tencent.mm.plugin.gallery.b.a.anim_not_change);
    super.finish();
    overridePendingTransition(com.tencent.mm.plugin.gallery.b.a.anim_not_change, com.tencent.mm.plugin.gallery.b.a.push_down_out);
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
  
  protected void h(final int paramInt, View paramView)
  {
    AppMethodBeat.i(164801);
    Object localObject1 = this.Cai.SY(paramInt);
    boolean bool1;
    if ((localObject1 == null) || (Util.isNullOrNil(((GalleryItem.MediaItem)localObject1).AAz)))
    {
      if (localObject1 == null) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.w("MicroMsg.AlbumPreviewUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(164801);
        return;
      }
    }
    this.CaW = ((GalleryItem.MediaItem)localObject1);
    if ((com.tencent.mm.plugin.gallery.model.e.etl().pag == 5) && (((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")))
    {
      com.tencent.mm.ui.base.h.cO(getContext(), getString(b.i.gallery_select_media_type_not_gif));
      AppMethodBeat.o(164801);
      return;
    }
    if (1 == this.CaM)
    {
      if (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("video"))
      {
        com.tencent.mm.ui.base.h.cO(getContext(), getString(b.i.gallery_select_media_type_not_video));
        AppMethodBeat.o(164801);
      }
    }
    else if ((2 == this.CaM) && (((GalleryItem.MediaItem)localObject1).mMimeType.toLowerCase().contains("image")))
    {
      com.tencent.mm.ui.base.h.cO(getContext(), getString(b.i.gallery_select_media_type_not_img));
      AppMethodBeat.o(164801);
      return;
    }
    int j = paramInt - this.Cai.BZK.size();
    Log.d("MicroMsg.AlbumPreviewUI", "onMediaClick, querySource %s item %s.", new Object[] { Integer.valueOf(this.jQj), localObject1 });
    if ((this.jQj == 0) || (this.jQj == 5) || (this.jQj == 10) || (this.jQj == 11) || (this.jQj == 27))
    {
      if (this.CaM == 2)
      {
        com.tencent.mm.ui.base.h.a(this, true, getString(b.i.gallery_send_video_to_chat), "", getString(b.i.app_send), getString(b.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(179459);
            Log.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.setData(Uri.parse("file://" + Uri.encode(this.Cbd.AAz)));
            AlbumPreviewUI.this.setResult(-1, paramAnonymousDialogInterface);
            a.a.BTR.an(this.Cbd.AAz, AlbumPreviewUI.k(AlbumPreviewUI.this), paramInt);
            AlbumPreviewUI.this.finish();
            AppMethodBeat.o(179459);
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
    if (this.jQj == 4)
    {
      boolean bool2 = com.tencent.mm.plugin.gallery.a.e.eva();
      if ((!bool2) && (((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.Cai.BZH.size() != 0))
      {
        com.tencent.mm.ui.base.h.cO(getContext(), com.tencent.mm.ci.a.ba(getContext(), b.i.gallery_pic_can_not_choose_video));
        AppMethodBeat.o(164801);
        return;
      }
      if ((bool2) && (com.tencent.mm.plugin.gallery.a.e.az(this.Cai.BZH))) {}
      long l;
      for (bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.AlbumPreviewUI", "enableSnsVLog:%s skipEditVideo:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((((GalleryItem.MediaItem)localObject1).getType() != 2) || (bool1)) {
          break label923;
        }
        paramView = com.tencent.mm.n.a.jwk;
        l = com.tencent.mm.n.a.awb() * 1000;
        paramView = com.tencent.mm.n.a.jwk;
        i = com.tencent.mm.n.a.awb() / 60;
        paramView = getString(b.i.gallery_pic_video_too_long_custom_desc, new Object[] { Integer.valueOf(i) });
        if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
          break label749;
        }
        if ((com.tencent.mm.plugin.gallery.a.a.CeX.b(this.jQj, (GalleryItem.MediaItem)localObject1)) && ((Util.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).maS)) || ("audio/mp4a-latm".equalsIgnoreCase(((GalleryItem.VideoMediaItem)localObject1).maS)))) {
          break;
        }
        paramView = new f.a(getContext());
        paramView.aR(com.tencent.mm.ci.a.ba(getContext(), b.i.gallery_pic_video_not_support_desc));
        paramView.bBp(com.tencent.mm.ci.a.ba(getContext(), b.i.gallery_i_know));
        paramView.b(new f.c()
        {
          public final void g(boolean paramAnonymousBoolean, String paramAnonymousString) {}
        });
        paramView.show();
        AppMethodBeat.o(164801);
        return;
      }
      if (((GalleryItem.VideoMediaItem)localObject1).maT >= l)
      {
        localObject1 = new f.a(getContext());
        ((f.a)localObject1).aR(paramView);
        ((f.a)localObject1).bBp(com.tencent.mm.ci.a.ba(getContext(), b.i.gallery_i_know));
        ((f.a)localObject1).b(new f.c()
        {
          public final void g(boolean paramAnonymousBoolean, String paramAnonymousString) {}
        });
        ((f.a)localObject1).show();
        AppMethodBeat.o(164801);
        return;
      }
      label749:
      paramView = com.tencent.mm.plugin.sns.k.c.KfL;
      paramView = ((GalleryItem.MediaItem)localObject1).AAz;
      i = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
      kotlin.g.b.p.k(paramView, "inputPath");
      paramView = RecordConfigProvider.ay(paramView, "", "");
      paramView.HLb = (i * 1000);
      kotlin.g.b.p.j(paramView, "provider");
      com.tencent.mm.plugin.sns.k.c.m(paramView);
      localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).wwk = 1;
      paramView.HLk = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new UICustomParam.a();
      ((UICustomParam.a)localObject2).avX();
      ((UICustomParam.a)localObject2).avW();
      ((UICustomParam.a)localObject2).dZ(true);
      paramView.HKT = ((UICustomParam.a)localObject2).jwj;
      a.a.BTR.an(((GalleryItem.MediaItem)localObject1).AAz, this.selectType, paramInt);
      this.CaY = ((GalleryItem.MediaItem)localObject1).AAz;
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, com.tencent.mm.plugin.gallery.b.a.sight_slide_bottom_in, -1, paramView, 2, 0);
      AppMethodBeat.o(164801);
      return;
      label923:
      Log.d("leextime", "jump from sns : " + Util.currentTicks());
      if (bool2) {}
      for (paramView = this.Cai.BZG;; paramView = this.Cai.SX(((GalleryItem.MediaItem)localObject1).getType()))
      {
        com.tencent.mm.plugin.gallery.model.e.au(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.Cai.eun());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.Cai.BZH);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        aD(j, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.tNu);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.Cau);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.Caw);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.Cax);
        ((Intent)localObject2).putExtra("max_select_count", this.AYg);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.fLi);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.selectType);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
        return;
      }
    }
    if (this.jQj == 14)
    {
      if ((((GalleryItem.MediaItem)localObject1).getType() == 2) && (this.Cai.BZH.size() != 0))
      {
        com.tencent.mm.ui.base.h.cO(getContext(), com.tencent.mm.ci.a.ba(getContext(), b.i.gallery_pic_can_not_choose_video));
        AppMethodBeat.o(164801);
        return;
      }
      if (((GalleryItem.MediaItem)localObject1).getType() == 1)
      {
        paramView = this.Cai.SX(((GalleryItem.MediaItem)localObject1).getType());
        com.tencent.mm.plugin.gallery.model.e.au(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.Cai.eun());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.Cai.BZH);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        aD(j, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.tNu);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.Cau);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.Caw);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.Cax);
        ((Intent)localObject2).putExtra("max_select_count", this.AYg);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.fLi);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.selectType);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
        return;
      }
      if (!(localObject1 instanceof GalleryItem.VideoMediaItem)) {
        break label3152;
      }
      paramView = (GalleryItem.VideoMediaItem)localObject1;
      if (paramView.maT <= 2000)
      {
        Log.i("MicroMsg.AlbumPreviewUI", "select story video, duration too long, duration:%s", new Object[] { Integer.valueOf(paramView.maT) });
        com.tencent.mm.plugin.report.service.h.IzE.p(1005L, 53L, 1L);
        com.tencent.mm.ui.base.h.cO(getContext(), com.tencent.mm.ci.a.ba(getContext(), b.i.gallery_pic_video_too_short_title));
        AppMethodBeat.o(164801);
        return;
      }
      if ((paramView.videoFrameRate <= 1) && (paramView.videoFrameRate >= 0))
      {
        Log.i("MicroMsg.AlbumPreviewUI", "select story video, videoFrameRate too small:%s, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.AAz });
        if (paramView.videoFrameRate > 1) {}
      }
    }
    try
    {
      localObject2 = SightVideoJNI.getSimpleMp4InfoVFS(paramView.AAz);
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
      label1733:
      label3152:
      break label1733;
    }
    if (paramView.videoFrameRate <= 0)
    {
      Log.i("MicroMsg.AlbumPreviewUI", "final videoFrameRate:%s, too small, videoPath:%s", new Object[] { Integer.valueOf(paramView.videoFrameRate), paramView.AAz });
      com.tencent.mm.plugin.report.service.h.IzE.p(1005L, 54L, 1L);
      com.tencent.mm.ui.base.h.cO(getContext(), com.tencent.mm.ci.a.ba(getContext(), b.i.gallery_pic_video_not_support_desc));
      AppMethodBeat.o(164801);
      return;
    }
    Log.i("MicroMsg.AlbumPreviewUI", "maxDuration=%s", new Object[] { Long.valueOf(getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000 + 500) });
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("K_SEGMENTVIDEOPATH", paramView.AAz);
    ((Intent)localObject2).putExtra("KSEGMENTVIDEOTHUMBPATH", paramView.wAy);
    setResult(-1, (Intent)localObject2);
    a.a.BTR.an(((GalleryItem.MediaItem)localObject1).AAz, this.selectType, paramInt);
    finish();
    AppMethodBeat.o(164801);
    return;
    if (this.jQj == 29)
    {
      if (((GalleryItem.MediaItem)localObject1).getType() == 1)
      {
        paramView = this.Cai.SX(((GalleryItem.MediaItem)localObject1).getType());
        com.tencent.mm.plugin.gallery.model.e.au(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.Cai.eun());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.Cai.BZH);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        aD(j, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.tNu);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.Cau);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.Caw);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.Cax);
        ((Intent)localObject2).putExtra("max_select_count", this.AYg);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.fLi);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.selectType);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
      }
    }
    else if (this.jQj == 30)
    {
      if (((GalleryItem.MediaItem)localObject1).getType() == 1)
      {
        paramView = this.Cai.SX(((GalleryItem.MediaItem)localObject1).getType());
        com.tencent.mm.plugin.gallery.model.e.au(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putExtra("key_edit_video_max_time_length", getIntent().getIntExtra("key_edit_video_max_time_length", 10));
        ((Intent)localObject2).putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.Cai.eun());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.Cai.BZH);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        aD(j, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.tNu);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.Cau);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.Caw);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.Cax);
        ((Intent)localObject2).putExtra("max_select_count", this.AYg);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.fLi);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.selectType);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
      }
    }
    else
    {
      if (this.Cay)
      {
        if (((GalleryItem.MediaItem)localObject1).getType() == 2) {
          paramInt = 1;
        }
        while ((this.jQj == 16) && ((this.CaM == 2) || (this.CaM == 3))) {
          if ((this.Cai.BZH.size() > 0) && (((GalleryItem.MediaItem)this.Cai.BZH.get(0)).getType() != ((GalleryItem.MediaItem)localObject1).getType()))
          {
            com.tencent.mm.ui.base.h.cO(getContext(), com.tencent.mm.ci.a.ba(getContext(), b.i.gallery_pic_can_not_choose_video));
            AppMethodBeat.o(164801);
            return;
            paramInt = this.AYg;
          }
          else
          {
            i = this.AYg;
          }
        }
        while ((this.jQj == 15) && (((GalleryItem.MediaItem)localObject1).getType() == 2))
        {
          AppMethodBeat.o(164801);
          return;
          i = paramInt;
          if (((GalleryItem.MediaItem)localObject1).getType() == 2)
          {
            i = paramInt;
            if (this.Cai.BZH.size() != 0)
            {
              com.tencent.mm.ui.base.h.cO(getContext(), com.tencent.mm.ci.a.ba(getContext(), b.i.gallery_pic_can_not_choose_video));
              AppMethodBeat.o(164801);
              return;
            }
          }
        }
        paramView = this.Cai.SX(((GalleryItem.MediaItem)localObject1).getType());
        com.tencent.mm.plugin.gallery.model.e.au(paramView);
        localObject2 = new Intent(this, ImagePreviewUI.class);
        ((Intent)localObject2).putStringArrayListExtra("preview_image_list", this.Cai.eun());
        ((Intent)localObject2).putParcelableArrayListExtra("preview_media_item_list", this.Cai.BZH);
        ((Intent)localObject2).putExtra("preview_all", true);
        ((Intent)localObject2).putExtra("preview_position", paramView.indexOf(localObject1));
        aD(j, true);
        ((Intent)localObject2).putExtra("send_raw_img", this.tNu);
        ((Intent)localObject2).putExtra("key_force_hide_edit_image_button", this.Cau);
        ((Intent)localObject2).putExtra("key_force_show_raw_image_button", this.Caw);
        ((Intent)localObject2).putExtra("key_is_raw_image_button_disable", this.Cax);
        ((Intent)localObject2).putExtra("max_select_count", i);
        ((Intent)localObject2).putExtra("GalleryUI_FromUser", this.fLi);
        ((Intent)localObject2).putExtra("GalleryUI_ToUser", this.toUser);
        ((Intent)localObject2).putExtra("select_type_tag", this.selectType);
        ((Intent)localObject2).putExtra("album_business_tag", this.BZJ);
        ((Intent)localObject2).putExtra("album_video_max_duration", this.nrt);
        ((Intent)localObject2).putExtra("album_video_min_duration", this.CaG);
        startActivityForResult((Intent)localObject2, 0);
        AppMethodBeat.o(164801);
        return;
      }
      com.tencent.mm.plugin.gallery.model.e.au(this.Cai.BZG);
      paramView = new Intent(this, ImagePreviewUI.class);
      paramView.putExtra("query_source_type", this.jQj);
      paramView.putStringArrayListExtra("preview_image_list", this.Cai.eun());
      paramView.putParcelableArrayListExtra("preview_media_item_list", this.Cai.BZH);
      paramView.putExtra("preview_all", true);
      paramView.putExtra("preview_position", j);
      aD(j, true);
      paramView.putExtra("send_raw_img", this.tNu);
      paramView.putExtra("key_force_hide_edit_image_button", this.Cau);
      paramView.putExtra("key_force_show_raw_image_button", this.Caw);
      paramView.putExtra("key_is_raw_image_button_disable", this.Cax);
      paramView.putExtra("max_select_count", this.AYg);
      paramView.putExtra("GalleryUI_FromUser", this.fLi);
      paramView.putExtra("GalleryUI_ToUser", this.toUser);
      paramView.putExtra("album_business_tag", this.BZJ);
      paramView.putExtra("album_video_max_duration", this.nrt);
      paramView.putExtra("album_video_min_duration", this.CaG);
      if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 14) {
        paramView.putExtra("key_edit_video_max_time_length", 300500);
      }
      paramView.putExtra("select_type_tag", this.selectType);
      startActivityForResult(paramView, 0);
    }
    AppMethodBeat.o(164801);
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
    this.BZJ = getIntent().getStringExtra("album_business_tag");
    this.nrt = getIntent().getIntExtra("album_video_max_duration", 10);
    this.CaG = getIntent().getIntExtra("album_video_min_duration", 0);
    this.fLi = getIntent().getStringExtra("GalleryUI_FromUser");
    this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
    this.AYg = getIntent().getIntExtra("max_select_count", 9);
    boolean bool;
    if (this.jQj == 4)
    {
      bool = true;
      this.Cat = bool;
      this.Cap = getIntent().getStringExtra("folder_path");
      this.Caq = getIntent().getStringExtra("folder_name");
      if (Util.isNullOrNil(this.Cap))
      {
        Log.w("MicroMsg.AlbumPreviewUI", "folder path invalid, assign folderName: %s.", new Object[] { this.Caq });
        this.Cap = this.Caq;
      }
      if ((!getIntent().getBooleanExtra("key_send_raw_image", false)) && (!getIntent().getBooleanExtra("send_raw_img", false))) {
        break label1755;
      }
      bool = true;
      label294:
      this.tNu = bool;
      this.Cau = getIntent().getBooleanExtra("key_force_hide_edit_image_button", false);
      this.Cav = getIntent().getBooleanExtra("key_force_hide_edit_image_button_after_album_take_image", false);
      this.Caw = getIntent().getBooleanExtra("key_force_show_raw_image_button", false);
      this.Cax = getIntent().getBooleanExtra("key_is_raw_image_button_disable", false);
      this.Cay = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
      this.Can = ((TextView)findViewById(b.e.original_image_tip));
      this.Cao = ((ImageButton)findViewById(b.e.original_image));
      this.Can.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111434);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          AlbumPreviewUI.c(AlbumPreviewUI.this).performClick();
          if (AlbumPreviewUI.this.tNu) {
            AlbumPreviewUI.d(AlbumPreviewUI.this).setContentDescription(AlbumPreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_select_desc));
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111434);
            return;
            AlbumPreviewUI.d(AlbumPreviewUI.this).setContentDescription(AlbumPreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
          }
        }
      });
      if ((this.jQj != 3) && (!this.Caw)) {
        break label1761;
      }
      this.Cao.setVisibility(0);
      this.Can.setVisibility(0);
      label449:
      if (!this.tNu) {
        break label1782;
      }
      this.Cao.setImageResource(b.h.radio_on);
      this.Cao.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_select_desc));
      label483:
      if (this.Cax) {
        this.Cao.setImageResource(b.h.radio_default_on);
      }
      localObject1 = this.Cao;
      if (this.Cax) {
        break label1812;
      }
      bool = true;
      label516:
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.Can;
      if (this.Cax) {
        break label1818;
      }
      bool = true;
      label539:
      ((TextView)localObject1).setEnabled(bool);
      this.Cao.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111435);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = AlbumPreviewUI.this;
          boolean bool;
          if (!AlbumPreviewUI.this.tNu)
          {
            bool = true;
            paramAnonymousView.tNu = bool;
            AlbumPreviewUI.e(AlbumPreviewUI.this);
            AlbumPreviewUI.d(AlbumPreviewUI.this).setText(AlbumPreviewUI.this.getContext().getString(b.i.gallery_pic_original).concat(AlbumPreviewUI.euA()));
            if (!AlbumPreviewUI.this.tNu) {
              break label168;
            }
            AlbumPreviewUI.c(AlbumPreviewUI.this).setImageResource(b.h.radio_on);
            AlbumPreviewUI.c(AlbumPreviewUI.this).setContentDescription(AlbumPreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_select_desc));
          }
          for (;;)
          {
            AlbumPreviewUI.f(AlbumPreviewUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111435);
            return;
            bool = false;
            break;
            label168:
            AlbumPreviewUI.c(AlbumPreviewUI.this).setImageResource(b.h.radio_off);
            AlbumPreviewUI.c(AlbumPreviewUI.this).setContentDescription(AlbumPreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
          }
        }
      });
      this.Cae = ((RecyclerView)findViewById(b.e.media_in_folder_rv));
      this.Caj = ((TextView)findViewById(b.e.album_tips_bar));
      this.Cak = ((TextView)findViewById(b.e.album_tips_bar2));
      this.Cal = ((TextView)findViewById(b.e.album_photo_edit_tips_bar));
      this.Caf = ((TextView)findViewById(b.e.media_preview));
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vRz, 0)) {
        break label1824;
      }
      bool = true;
      label656:
      Log.i("MicroMsg.AlbumPreviewUI", "pennqin, smartGallerySwitch: %s.", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label1830;
      }
      bool = false;
      label684:
      Log.i("MicroMsg.AlbumPreviewUI", "pennqin, isFromSmartGallery: %s showSmartGallery: %s.", new Object[] { Boolean.valueOf(this.CaJ), Boolean.valueOf(bool) });
      if ((!this.CaJ) && ((bool) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)))
      {
        addTextOptionMenu(1, null, this.CaQ, null, w.b.WaB);
        if (this.CaN) {
          euw();
        }
      }
      if ((this.jQj != 0) && (this.jQj != 5) && (this.jQj != 10) && (this.jQj != 11) && (this.jQj != 24) && (this.jQj != 27)) {
        break label1958;
      }
      findViewById(b.e.album_footer_bar).setVisibility(8);
      localObject1 = (FrameLayout.LayoutParams)this.Cae.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = 0;
      this.Cae.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (getBounceView() != null)
      {
        localObject1 = (FrameLayout.LayoutParams)getBounceView().getView().getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = 0;
        getBounceView().getView().setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      label897:
      this.Cam = ((ImageFolderMgrView)findViewById(b.e.image_folder_mgr_view));
      this.Cam.setListener(new ImageFolderMgrView.a()
      {
        public final void c(GalleryItem.AlbumItem paramAnonymousAlbumItem)
        {
          AppMethodBeat.i(111437);
          AlbumPreviewUI.a(AlbumPreviewUI.this, paramAnonymousAlbumItem);
          AppMethodBeat.o(111437);
        }
      });
      this.Cam.setOnFolderStateChanged(new ImageFolderMgrView.b()
      {
        public final void rW(boolean paramAnonymousBoolean)
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
            if ((AlbumPreviewUI.l(AlbumPreviewUI.this)) && (!AlbumPreviewUI.m(AlbumPreviewUI.this).getSelectedAlbumName().equalsIgnoreCase(AlbumPreviewUI.this.getString(b.i.gallery_fav_pic_and_video)))) {
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
      localObject2 = this.Cam;
      bool = this.CaN;
      Log.i("MicroMsg.ImageFolderMgrView", "attach, %s.", new Object[] { localObject2 });
      com.tencent.mm.plugin.gallery.model.e.etl().b((i.a)localObject2);
      com.tencent.mm.plugin.gallery.model.e.etl().a((i.a)localObject2);
      com.tencent.mm.plugin.gallery.model.e.etl().c(((ImageFolderMgrView)localObject2).Ccs);
      localObject1 = com.tencent.mm.plugin.gallery.model.e.etl();
      localObject2 = ((ImageFolderMgrView)localObject2).Ccs;
      ((o)localObject1).BVz.add(localObject2);
      if (bool) {
        com.tencent.mm.plugin.gallery.model.e.etl().etT();
      }
      this.Car = getIntent().getStringExtra("send_btn_string");
      this.Cas = getIntent().getBooleanExtra("is_hide_album_footer", false);
      if (this.Cas) {
        findViewById(b.e.album_footer_bar).setVisibility(8);
      }
      enableOptionMenu(false);
      getContext();
      localObject1 = new GridLayoutManager(4);
      this.Cae.setLayoutManager((RecyclerView.LayoutManager)localObject1);
      localObject2 = new c.a(getContext()).Te(b.c.gallery_item_padding).Td(b.c.gallery_item_padding).Tc(b.b.gallery_dark_mode_color);
      ((c.a)localObject2).CbQ = false;
      localObject2 = ((c.a)localObject2).euG();
      this.Cae.a((RecyclerView.h)localObject2);
      this.Cae.a(new AlbumPreviewUI.20(this, (GridLayoutManager)localObject1));
      this.Cai = new a(getContext(), new a.e()
      {
        public final void ak(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(111446);
          Object localObject = AlbumPreviewUI.this.Cai.SY(paramAnonymousInt2);
          if (localObject == null)
          {
            AppMethodBeat.o(111446);
            return;
          }
          if (paramAnonymousInt3 == 0) {
            if (((GalleryItem.MediaItem)localObject).getType() == 1) {
              if (!AlbumPreviewUI.this.a((GalleryItem.MediaItem)localObject)) {
                AlbumPreviewUI.this.Cai.j((GalleryItem.MediaItem)localObject);
              }
            }
          }
          while (Util.isNullOrNil(AlbumPreviewUI.this.Cai.eun()))
          {
            AppMethodBeat.o(111446);
            return;
            a.a.BTR.an(((GalleryItem.MediaItem)localObject).AAz, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
            AlbumPreviewUI.a(AlbumPreviewUI.this, (GalleryItem.MediaItem)localObject);
            AlbumPreviewUI.this.Ta(paramAnonymousInt1);
            AlbumPreviewUI.this.aD(paramAnonymousInt2, true);
            continue;
            if (((GalleryItem.MediaItem)localObject).getType() == 2)
            {
              if (!AlbumPreviewUI.this.b((GalleryItem.MediaItem)localObject))
              {
                AlbumPreviewUI.this.Cai.j((GalleryItem.MediaItem)localObject);
              }
              else
              {
                a.a.BTR.an(((GalleryItem.MediaItem)localObject).AAz, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
                AlbumPreviewUI.this.Ta(paramAnonymousInt1);
                AlbumPreviewUI.this.aD(paramAnonymousInt2, true);
              }
            }
            else
            {
              a.a.BTR.an(((GalleryItem.MediaItem)localObject).AAz, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.Ta(paramAnonymousInt1);
              AlbumPreviewUI.this.aD(paramAnonymousInt2, true);
              continue;
              a.a.BTR.an(((GalleryItem.MediaItem)localObject).AAz, AlbumPreviewUI.k(AlbumPreviewUI.this), paramAnonymousInt2);
              AlbumPreviewUI.this.Ta(paramAnonymousInt1);
              AlbumPreviewUI.this.aD(paramAnonymousInt2, false);
            }
          }
          localObject = AlbumPreviewUI.this.Cai.eun().iterator();
          while (((Iterator)localObject).hasNext()) {
            if (!ImgUtil.isGif((String)((Iterator)localObject).next()))
            {
              AppMethodBeat.o(111446);
              return;
            }
          }
          AlbumPreviewUI.this.tNu = true;
          AppMethodBeat.o(111446);
        }
      });
      this.Cai.BZO = this.BZO;
      if (!Util.isNullOrNil(this.BZJ))
      {
        Log.d("MicroMsg.AlbumPreviewUI", "businessTag=%s", new Object[] { this.BZJ });
        this.Cai.BZJ = this.BZJ;
        this.Cai.nrt = this.nrt;
        if (this.BZJ.equals("album_business_bubble_media_by_coordinate"))
        {
          this.Cai.BZL = false;
          com.tencent.mm.plugin.gallery.model.e.etl().BVC.esX();
          this.CaH = getIntent().getStringExtra("album_business_bubble_media_by_coordinate_posname");
          final double d = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_distance", -1.0D);
          this.longitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 181.0D);
          this.latitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 91.0D);
          if ((d >= 0.0D) && (com.tencent.mm.modelgeo.a.m(this.longitude)) && (com.tencent.mm.modelgeo.a.n(this.latitude)))
          {
            this.CaI = new i.b()
            {
              public final void c(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong)
              {
                AppMethodBeat.i(111423);
                Log.d("MicroMsg.AlbumPreviewUI", "onQueryMediaBusinessDoing");
                if (paramAnonymousLong != AlbumPreviewUI.w(AlbumPreviewUI.this))
                {
                  Log.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(AlbumPreviewUI.w(AlbumPreviewUI.this)) });
                  Log.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
                  AppMethodBeat.o(111423);
                  return;
                }
                if ((paramAnonymousLinkedList == null) || (paramAnonymousLinkedList.isEmpty()))
                {
                  Log.d("MicroMsg.AlbumPreviewUI", "mediaItems is invalid.");
                  AppMethodBeat.o(111423);
                  return;
                }
                ArrayList localArrayList = new ArrayList();
                Iterator localIterator = paramAnonymousLinkedList.iterator();
                while (localIterator.hasNext())
                {
                  GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
                  if (TencentLocationUtils.distanceBetween(AlbumPreviewUI.x(AlbumPreviewUI.this), AlbumPreviewUI.y(AlbumPreviewUI.this), localMediaItem.BVq, localMediaItem.BVp) <= d)
                  {
                    localMediaItem.BVr = "album_business_bubble_media_by_coordinate";
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
                AppMethodBeat.o(111423);
              }
            };
            localObject1 = com.tencent.mm.plugin.gallery.model.e.etl();
            localObject2 = this.CaI;
            if (localObject2 != null) {
              ((o)localObject1).BVB.add(localObject2);
            }
          }
        }
      }
      if (this.Cay) {
        this.Cai.BZL = true;
      }
      this.CaS = new a.b();
      if (getIntent().getBooleanExtra("show_header_view", true)) {
        this.Cai.a(this.CaS);
      }
      this.Cai.BVD = this.CaM;
      this.Cai.BZF = this.AYg;
      Log.i("MicroMsg.AlbumPreviewUI", "limit count = " + this.AYg);
      this.Cae.setAdapter(this.Cai);
      if (!this.CaJ) {
        break label2174;
      }
      setActionbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
      setMMTitle(getIntent().getStringExtra("title_from_smart_gallery"));
      label1568:
      setNavigationbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
      setActionBarOperationAreaClickListener(new AlbumChooserView.a()
      {
        public final void euC()
        {
          AppMethodBeat.i(179457);
          Log.i("MicroMsg.AlbumPreviewUI", "onAlbumChooserViewClick.");
          AlbumPreviewUI.a(AlbumPreviewUI.this, null);
          a.a.BTR.BTF = 1;
          Log.d("MicroMsg.AlbumPreviewUI", "click folder times: [%d].", new Object[] { Integer.valueOf(AlbumPreviewUI.B(AlbumPreviewUI.this)) });
          AlbumPreviewUI.C(AlbumPreviewUI.this);
          AlbumPreviewUI.this.playActionBarOperationAreaAnim();
          AlbumPreviewUI.m(AlbumPreviewUI.this).euH();
          AppMethodBeat.o(179457);
        }
      });
      if (!this.CaJ) {
        break label2250;
      }
    }
    label1812:
    label1818:
    label1824:
    label1830:
    label2250:
    for (int i = b.d.actionbar_dark_back_selector;; i = b.h.actionbar_icon_close_black)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(111424);
          Log.i("MicroMsg.AlbumPreviewUI", "backBtn");
          AlbumPreviewUI.this.onBackBtnClick();
          AlbumPreviewUI.this.setResult(-2, AlbumPreviewUI.this.getIntent().putExtra("send_raw_img", AlbumPreviewUI.this.tNu));
          if ((AlbumPreviewUI.m(AlbumPreviewUI.this) != null) && (AlbumPreviewUI.m(AlbumPreviewUI.this).py))
          {
            AlbumPreviewUI.m(AlbumPreviewUI.this).euH();
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
      localObject1 = (ViewGroup)findViewById(b.e.root);
      if ((localObject1 instanceof DrawedCallBackFrameLayout)) {
        ((DrawedCallBackFrameLayout)localObject1).setListener(new AlbumPreviewUI.4(this));
      }
      this.CaO = new AlbumPreviewUI.f((byte)0);
      this.CaO.Cbn = new WeakReference(this.Cai);
      this.CaO.Cbo = new WeakReference(this.iXX);
      this.CaO.Cbl = new WeakReference(this.Cam);
      this.CaO.idList = this.idList;
      this.CaO.type = this.CaM;
      AppMethodBeat.o(111474);
      return;
      bool = false;
      break;
      label1755:
      bool = false;
      break label294;
      label1761:
      this.Cao.setVisibility(8);
      this.Can.setVisibility(8);
      break label449;
      label1782:
      this.Cao.setImageResource(b.h.radio_off);
      this.Cao.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
      break label483;
      bool = false;
      break label516;
      bool = false;
      break label539;
      bool = false;
      break label656;
      localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vRA, "");
      localObject2 = Build.MANUFACTURER.toLowerCase();
      str = Build.MODEL.toLowerCase();
      Log.i("MicroMsg.AlbumPreviewUI", "pennqin, manufacturer: %s, model: %s, smartGalleryBlackList: %s.", new Object[] { localObject2, str, localObject1 });
      if ((((String)localObject1).contains((CharSequence)localObject2)) || (((String)localObject1).contains(str)))
      {
        bool = false;
        break label684;
      }
      if (("album_business_bubble_media_by_jsapi_chooseimage".equals(this.BZJ)) || ("album_business_bubble_media_by_jsapi_choosevideo".equals(this.BZJ)))
      {
        bool = false;
        break label684;
      }
      bool = true;
      break label684;
      this.Caf.setVisibility(0);
      this.Caf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(164797);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          AlbumPreviewUI.g(AlbumPreviewUI.this);
          paramAnonymousView = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
          com.tencent.mm.plugin.gallery.model.e.au(AlbumPreviewUI.this.Cai.BZH);
          paramAnonymousView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.Cai.eun());
          paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", AlbumPreviewUI.this.Cai.BZH);
          paramAnonymousView.putExtra("max_select_count", AlbumPreviewUI.this.AYg);
          paramAnonymousView.putExtra("send_raw_img", AlbumPreviewUI.this.tNu);
          paramAnonymousView.putExtra("key_force_hide_edit_image_button", AlbumPreviewUI.h(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("key_force_show_raw_image_button", AlbumPreviewUI.i(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("key_is_raw_image_button_disable", AlbumPreviewUI.j(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.fLi);
          paramAnonymousView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
          paramAnonymousView.putExtra("select_type_tag", AlbumPreviewUI.k(AlbumPreviewUI.this));
          paramAnonymousView.putExtra("album_business_tag", AlbumPreviewUI.this.BZJ);
          paramAnonymousView.putExtra("album_video_max_duration", AlbumPreviewUI.this.nrt);
          paramAnonymousView.putExtra("album_video_min_duration", AlbumPreviewUI.this.CaG);
          AlbumPreviewUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164797);
        }
      });
      if (((this.CaM != 1) && (this.CaM != 2) && (this.CaM != 3)) || (this.AYg <= 0)) {
        break label897;
      }
      if (!Util.isNullOrNil(this.Car))
      {
        addTextOptionMenu(0, this.Car, this.CaQ);
        break label897;
      }
      i = this.jQj;
      int j = this.AYg;
      localObject2 = this.BZJ;
      if (this.Cai == null) {}
      for (localObject1 = null;; localObject1 = this.Cai.BZH)
      {
        localObject1 = com.tencent.mm.plugin.gallery.a.e.a(this, i, 0, j, (String)localObject2, (ArrayList)localObject1);
        switch (this.jQj)
        {
        default: 
          addTextOptionMenu(0, (String)localObject1, this.CaQ, null, w.b.WaA);
          break label897;
        }
      }
      addTextOptionMenu(0, (String)localObject1, this.CaQ, null, w.b.Way);
      break label897;
      addTextOptionMenu(0, (String)localObject1, this.CaQ, null, w.b.WaE);
      break label897;
      label2174:
      setActionbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
      initActionBarOperationArea();
      if (this.CaM == 3)
      {
        initActionBarOperationAreaTxt(getString(b.i.gallery_all_pic_and_video));
        break label1568;
      }
      if (this.CaM == 1)
      {
        initActionBarOperationAreaTxt(getString(b.i.gallery_all_pic));
        break label1568;
      }
      initActionBarOperationAreaTxt(getString(b.i.gallery_all_video));
      break label1568;
    }
  }
  
  public boolean isActionbarCenterLayoutMode()
  {
    return false;
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
      localObject1 = com.tencent.mm.pluginsdk.ui.tools.u.g(getContext().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.aSX());
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
        AppMethodBeat.o(111478);
        return;
      }
      Log.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[] { localObject1 });
      if ((this.jQj == 0) || (this.jQj == 5) || (this.jQj == 11) || (this.jQj == 24))
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
    label1881:
    label2010:
    label2016:
    label2022:
    do
    {
      for (;;)
      {
        if ((localObject1 != null) && (((Intent)localObject1).getBooleanExtra("show_photo_edit_tip", false)))
        {
          paramIntent = getSharedPreferences("photo_edit_pref", 0);
          if (!paramIntent.getBoolean("has_show_tip", false))
          {
            this.Cal.setVisibility(0);
            this.Cal.setText(getString(b.i.photo_edit_tips));
            localObject1 = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.gallery.b.a.fast_faded_in);
            this.Cal.startAnimation((Animation)localObject1);
            ((Animation)localObject1).setAnimationListener(new Animation.AnimationListener()
            {
              private Runnable Cbb;
              
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                AppMethodBeat.i(111428);
                AlbumPreviewUI.A(AlbumPreviewUI.this).setVisibility(0);
                AlbumPreviewUI.A(AlbumPreviewUI.this).postDelayed(this.Cbb, 4000L);
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
        ((Intent)localObject1).putExtra("send_raw_img", this.tNu);
        if ((this.Cau) || (this.Cav)) {}
        for (bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("key_force_hide_edit_image_button", bool);
          ((Intent)localObject1).putExtra("key_force_show_raw_image_button", this.Caw);
          ((Intent)localObject1).putExtra("key_is_raw_image_button_disable", this.Cax);
          ((Intent)localObject1).putStringArrayListExtra("preview_image_list", (ArrayList)localObject2);
          if (this.Cai != null) {
            ((Intent)localObject1).putParcelableArrayListExtra("preview_media_item_list", this.Cai.BZH);
          }
          ((Intent)localObject1).putExtra("GalleryUI_FromUser", this.fLi);
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
          this.CaA = true;
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
          if ((paramIntent.HKM.booleanValue()) && (!Util.isNullOrNil(paramIntent.thumbPath)))
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
          localObject3 = paramIntent.EYb;
          if (!Util.isNullOrNil((String)localObject3))
          {
            ((ArrayList)localObject2).add(localObject3);
            ((Intent)localObject1).putExtra("key_select_video_list", (Serializable)localObject2);
          }
          if ((paramIntent.EXZ) && (!Util.isNullOrNil(paramIntent.EYh)))
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramIntent.EYh);
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
              setMMTitle(Util.nullAs(((GalleryItem.AlbumItem)localObject1).albumName, getString(b.i.gallery_all_pic_and_video)));
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
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject1).fvU().x("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
              this.Cah = true;
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
              if (Util.isNullOrNil(this.CaY)) {
                break;
              }
              a.a.BTR.aIo(this.CaY);
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
              a((List)localObject1, (List)localObject2, new int[this.AYg]);
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
              if (Util.isNullOrNil(this.CaY)) {
                break;
              }
              a.a.BTR.aIo(this.CaY);
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
              this.tNu = paramIntent.getBooleanExtra("send_raw_img", this.tNu);
              if (this.tNu)
              {
                this.Cao.setImageResource(b.h.radio_on);
                this.Cao.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_select_desc));
                if (this.Cax) {
                  this.Cao.setImageResource(b.h.radio_default_on);
                }
                localObject2 = this.Cao;
                if (this.Cax) {
                  break label2010;
                }
                bool = true;
                ((ImageButton)localObject2).setEnabled(bool);
                localObject2 = this.Can;
                if (this.Cax) {
                  break label2016;
                }
              }
              for (bool = true;; bool = false)
              {
                ((TextView)localObject2).setEnabled(bool);
                if (localObject1 == null) {
                  break label2022;
                }
                localObject2 = ((Bundle)localObject1).keySet().iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject2).next();
                  Log.i("MicroMsg.AlbumPreviewUI", "key: %s, value: %s.", new Object[] { localObject3, ((Bundle)localObject1).get((String)localObject3) });
                }
                this.Cao.setImageResource(b.h.radio_off);
                this.Cao.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
                break;
                bool = false;
                break label1881;
              }
            }
            if ((-2 == paramInt2) || (paramInt2 == 0) || (SmartGalleryUI.Cer == paramInt2))
            {
              Log.i("MicroMsg.AlbumPreviewUI", "just back from SmartGalleryUI.");
              paramIntent = new androidx.b.b();
              paramInt1 = i;
              while (paramInt1 < this.Cai.BZH.size())
              {
                localObject1 = (GalleryItem.MediaItem)this.Cai.BZH.get(paramInt1);
                i = this.Cai.BZG.indexOf(localObject1);
                if (i != -1) {
                  paramIntent.add(Integer.valueOf(i));
                }
                paramInt1 += 1;
              }
              this.Cai.fn(com.tencent.mm.plugin.gallery.model.s.etX().BVX);
              if (SmartGalleryUI.Cer == paramInt2)
              {
                dZI();
                AppMethodBeat.o(111478);
                return;
              }
              Ta(this.Cai.BZH.size());
              this.Cai.a(paramIntent);
              AppMethodBeat.o(111478);
              return;
            }
            if (-1 == paramInt2) {
              this.Cah = true;
            }
            setResult(paramInt2, paramIntent);
            finish();
            localObject1 = paramIntent;
          }
          else if (paramInt1 == 4381)
          {
            if (paramInt2 == -1)
            {
              if (this.Cat)
              {
                paramIntent = RecordConfigProvider.jP("", "");
                paramIntent.HLb = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
                paramIntent.scene = 2;
                localObject1 = new VideoCaptureReportInfo();
                ((VideoCaptureReportInfo)localObject1).wwk = 1;
                paramIntent.HLk = ((VideoCaptureReportInfo)localObject1);
                localObject1 = new UICustomParam.a();
                ((UICustomParam.a)localObject1).avX();
                ((UICustomParam.a)localObject1).avW();
                ((UICustomParam.a)localObject1).dZ(true);
                paramIntent.HKT = ((UICustomParam.a)localObject1).jwj;
                localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4379, com.tencent.mm.plugin.gallery.b.a.sight_slide_bottom_in, -1, paramIntent, 4, 0);
                AppMethodBeat.o(111478);
                return;
              }
              localObject1 = paramIntent;
              if (22 == com.tencent.mm.plugin.gallery.model.e.etl().pag)
              {
                setResult(-1, paramIntent);
                finish();
                AppMethodBeat.o(111478);
              }
            }
            else
            {
              Toast.makeText(this, b.i.loading_failed, 1).show();
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
              localObject2 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
              if ((this.jQj != 28) || (((ArrayList)localObject2).size() <= 0)) {
                break label2610;
              }
              localObject1 = (String)((ArrayList)localObject2).get(0);
              if (!aIy((String)localObject1))
              {
                Log.i("MicroMsg.AlbumPreviewUI", "not support ratio");
                localObject2 = getResources().getString(b.i.gallery_select_pic_ratio_not_support);
                localObject1 = paramIntent;
                if (localObject2 != null)
                {
                  com.tencent.mm.ui.base.h.cO(getContext(), (String)localObject2);
                  localObject1 = paramIntent;
                }
              }
              else
              {
                localObject2 = new Intent();
                if (this.jQj == 10) {
                  ((Intent)localObject2).putExtra("CropImage_OutputPath", (String)localObject1);
                }
                ((Intent)localObject2).setData(Uri.parse(Uri.encode((String)localObject1)));
                Log.i("MicroMsg.AlbumPreviewUI", "getItem ok");
                setResult(-1, (Intent)localObject2);
                finish();
                localObject1 = paramIntent;
              }
              break;
            }
          }
        }
      }
      if ((this.jQj == 22) && (this.CaK))
      {
        localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
        if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0) || (this.CaW == null)) {
          break label2839;
        }
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(this.CaW);
        this.Cai.fn((List)localObject1);
        paramInt1 = this.Cai.BZG.indexOf(this.CaW);
        if (paramInt1 == -1) {
          break label2839;
        }
        localObject1 = new androidx.b.b();
        ((androidx.b.b)localObject1).add(Integer.valueOf(paramInt1));
        this.Cai.a((androidx.b.b)localObject1);
        Ta(this.Cai.BZH.size());
        dZI();
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
          ((Intent)localObject1).putStringArrayListExtra("CropImage_OutputPath_List", this.Cai.eun());
        }
        ((Intent)localObject1).putStringArrayListExtra("key_select_image_list", (ArrayList)localObject2);
        Log.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
        this.Cah = true;
        setResult(-1, (Intent)localObject1);
        finish();
        break;
      }
      localObject1 = paramIntent;
    } while (paramIntent == null);
    label2610:
    Object localObject1 = paramIntent.getStringArrayListExtra("preview_image_list");
    label2839:
    if (localObject1 == null) {}
    for (paramInt1 = 0;; paramInt1 = ((ArrayList)localObject1).size())
    {
      Log.i("MicroMsg.AlbumPreviewUI", "paths size: %d.", new Object[] { Integer.valueOf(paramInt1) });
      if ((localObject1 == null) || (this.Cai == null)) {
        break label3010;
      }
      localObject2 = new androidx.b.b();
      paramInt1 = 0;
      while (paramInt1 < this.Cai.BZH.size())
      {
        localObject3 = (GalleryItem.MediaItem)this.Cai.BZH.get(paramInt1);
        paramInt2 = this.Cai.BZG.indexOf(localObject3);
        if (paramInt2 != -1) {
          ((androidx.b.b)localObject2).add(Integer.valueOf(paramInt2));
        }
        paramInt1 += 1;
      }
    }
    this.Cai.aw((ArrayList)localObject1);
    this.Cai.a((androidx.b.b)localObject2);
    Ta(((ArrayList)localObject1).size());
    label3010:
    if (!paramIntent.getBooleanExtra("CropImage_Compress_Img", true))
    {
      bool = true;
      label3024:
      this.tNu = bool;
      if (!this.tNu) {
        break label3139;
      }
      this.Cao.setImageResource(b.h.radio_on);
      this.Cao.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_select_desc));
      label3064:
      if (this.Cax) {
        this.Cao.setImageResource(b.h.radio_default_on);
      }
      localObject1 = this.Cao;
      if (this.Cax) {
        break label3169;
      }
      bool = true;
      ((ImageButton)localObject1).setEnabled(bool);
      localObject1 = this.Can;
      if (this.Cax) {
        break label3175;
      }
    }
    label3097:
    label3139:
    label3169:
    label3175:
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject1).setEnabled(bool);
      localObject1 = paramIntent;
      break;
      bool = false;
      break label3024;
      this.Cao.setImageResource(b.h.radio_off);
      this.Cao.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
      break label3064;
      bool = false;
      break label3097;
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
    String str1 = getString(b.i.permission_tips_title);
    String str2 = getString(b.i.gallery_permission_msg);
    this.CaN = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, str1, str2);
    Log.d("MicroMsg.AlbumPreviewUI", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(this.CaN) });
    this.CaE = System.currentTimeMillis();
    start = System.currentTimeMillis();
    this.iXX = com.tencent.mm.ui.base.s.a(this, getString(b.i.app_waiting), false);
    this.CaT = AlbumPreviewUI.b.Cbi;
    if (paramBundle != null)
    {
      Log.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
      this.jQj = paramBundle.getInt("constants_key_query_source");
    }
    for (this.CaM = paramBundle.getInt("constants_key_query_type");; this.CaM = getIntent().getIntExtra("query_media_type", 1))
    {
      com.tencent.mm.plugin.gallery.model.e.etl().pag = this.jQj;
      com.tencent.mm.plugin.gallery.model.e.etl().setQueryType(this.CaM);
      Log.i("MicroMsg.AlbumPreviewUI", "query source: " + this.jQj + ", queryType: " + this.CaM);
      this.selectType = getIntent().getIntExtra("select_type_tag", 3);
      this.uwj = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFJ, true);
      this.CaJ = getIntent().getBooleanExtra("is_from_smart_gallery", false);
      this.CaK = getIntent().getBooleanExtra("album_is_from_text_status", false);
      this.CaL = getIntent().getStringExtra("edt_video_layout_from_text_status");
      initView();
      if (this.CaN) {
        eux();
      }
      com.tencent.mm.plugin.gallery.model.e.ett();
      AppMethodBeat.o(111464);
      return;
      this.jQj = getIntent().getIntExtra("query_source_type", 3);
    }
  }
  
  public void onDestroy()
  {
    boolean bool1 = false;
    AppMethodBeat.i(111469);
    super.onDestroy();
    Log.i("MicroMsg.AlbumPreviewUI", "onDestroy, %s.", new Object[] { this });
    if (com.tencent.mm.plugin.gallery.model.e.etl() != null)
    {
      com.tencent.mm.plugin.gallery.model.e.etl().b(this);
      o localo = com.tencent.mm.plugin.gallery.model.e.etl();
      i.b localb = this.CaI;
      if (localb != null) {
        localo.BVB.remove(localb);
      }
    }
    if ((this.CaB > 0) || (this.CaC > 0))
    {
      Log.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", new Object[] { Integer.valueOf(this.CaB), Integer.valueOf(this.CaC) });
      com.tencent.mm.plugin.gallery.a.e.bt(11187, this.CaB + "," + this.CaC);
    }
    for (;;)
    {
      if ((this.CaD > 0L) || (this.Cah)) {
        com.tencent.mm.plugin.gallery.model.e.a(this.Car, ax(this.Cai.BZH), this.tNu, this.Cag);
      }
      int i = this.Cai.BZH.size();
      boolean bool2 = this.tNu;
      if ((this.CaD > 0L) || (this.Cah)) {
        bool1 = true;
      }
      com.tencent.mm.plugin.gallery.model.e.i(i, bool2, bool1);
      ab.fax.YG().YF();
      com.tencent.mm.plugin.gallery.model.e.eto().clear();
      com.tencent.mm.plugin.gallery.model.e.etp().clear();
      com.tencent.mm.plugin.gallery.model.e.etq().clear();
      if (!this.CaJ) {
        break;
      }
      com.tencent.mm.plugin.gallery.model.s.etX().BVV = true;
      if (com.tencent.mm.plugin.gallery.model.e.etu())
      {
        com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.ljk).aFa();
        a.g.eut();
      }
      AppMethodBeat.o(111469);
      return;
      Log.d("MicroMsg.AlbumPreviewUI", "not click camera or folder.");
    }
    if (!this.niT) {
      a.a.BTR.report();
    }
    for (;;)
    {
      com.tencent.mm.plugin.gallery.model.s.etX().BVW = true;
      com.tencent.mm.plugin.gallery.model.e.etl().etU();
      break;
      a.a.BTR.reset();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111477);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      Log.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
      setResult(-2);
      if ((this.Cam != null) && (this.Cam.py))
      {
        this.Cam.euH();
        playActionBarOperationAreaAnim();
        AppMethodBeat.o(111477);
        return true;
      }
      this.niT = true;
      finish();
      AppMethodBeat.o(111477);
      return true;
    }
    if (paramInt == 82)
    {
      this.CaC += 1;
      if (this.Cam != null) {
        this.Cam.euH();
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
    f.d(false, true, true);
    this.Caz = true;
    ImageFolderMgrView localImageFolderMgrView;
    if ((!isFinishing()) && (!isDestroyed()) && (this.Cam != null) && (this.Cam.py))
    {
      localImageFolderMgrView = this.Cam;
      if (localImageFolderMgrView.py) {
        break label132;
      }
      Log.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
    }
    for (;;)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, this.iWt);
      this.iWt = 0;
      if (this.CaJ) {
        com.tencent.mm.plugin.gallery.model.s.etX().fm(this.Cai.BZH);
      }
      AppMethodBeat.o(111467);
      return;
      label132:
      if (localImageFolderMgrView.Ccr)
      {
        Log.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
      }
      else
      {
        localImageFolderMgrView.Ccn.setVisibility(8);
        localImageFolderMgrView.py = false;
        if (localImageFolderMgrView.Ccv != null) {
          localImageFolderMgrView.Ccv.rW(false);
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
        euy();
        AppMethodBeat.o(111483);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(b.i.permission_camera_request_again_msg), getString(b.i.permission_tips_title), getString(b.i.jump_to_settings), getString(b.i.gallery_cancel), false, new AlbumPreviewUI.6(this), null);
      AppMethodBeat.o(111483);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        euw();
        com.tencent.mm.plugin.gallery.model.e.etl().etT();
        eux();
        AppMethodBeat.o(111483);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(b.i.permission_gallery_request_again_msg), getString(b.i.permission_tips_title), getString(b.i.jump_to_settings), getString(b.i.gallery_cancel), false, new AlbumPreviewUI.7(this), new AlbumPreviewUI.8(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111465);
    super.onResume();
    Log.i("MicroMsg.AlbumPreviewUI", "onResume, %s.", new Object[] { this });
    f.d(true, true, true);
    this.Caz = false;
    AppMethodBeat.o(111465);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(111470);
    super.onSaveInstanceState(paramBundle);
    Log.i("MicroMsg.AlbumPreviewUI", "onSaveInstanceState, %s.", new Object[] { this });
    paramBundle.putInt("constants_key_query_source", this.jQj);
    paramBundle.putInt("constants_key_query_type", this.CaM);
    AppMethodBeat.o(111470);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(111466);
    super.onStart();
    Log.i("MicroMsg.AlbumPreviewUI", "onStart, %s.", new Object[] { this });
    if (com.tencent.mm.plugin.gallery.model.e.etl().pag != this.jQj) {
      com.tencent.mm.plugin.gallery.model.e.etl().pag = this.jQj;
    }
    if (com.tencent.mm.plugin.gallery.model.e.etl().BVD != this.CaM) {
      com.tencent.mm.plugin.gallery.model.e.etl().setQueryType(this.CaM);
    }
    AppMethodBeat.o(111466);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(111468);
    super.onStop();
    Log.i("MicroMsg.AlbumPreviewUI", "onStop, %s.", new Object[] { this });
    if (!this.CaJ)
    {
      com.tencent.mm.plugin.gallery.model.c localc = com.tencent.mm.plugin.gallery.model.e.etk();
      if ((localc.BUd != null) && (!localc.BUd.isEmpty()))
      {
        Iterator localIterator = localc.BUd.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.c localc1 = (c.c)((Map.Entry)localIterator.next()).getValue();
          if (localc1 != null) {
            localc1.mCancel = true;
          }
        }
        if (localc.BUc != null) {
          localc.BUc.clear();
        }
        if ((localc.BUd != null) && (!localc.BUd.isEmpty())) {
          localc.BUd.clear();
        }
        localc.BUa.etg();
      }
      com.tencent.mm.plugin.gallery.model.e.etk().etf();
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
    WeakReference<ImageFolderMgrView> Cbl;
    public GalleryItem.MediaItem Cbm;
    public int count;
    
    public final void run()
    {
      AppMethodBeat.i(242444);
      if ((this.Cbl != null) && (this.Cbl.get() != null))
      {
        Object localObject = (ImageFolderMgrView)this.Cbl.get();
        GalleryItem.MediaItem localMediaItem = this.Cbm;
        int j = this.count;
        localObject = ((ImageFolderMgrView)localObject).Ccq;
        if ((Util.isNullOrNil(((b)localObject).CbE)) || (((b)localObject).CbD == null) || (((b)localObject).CbD.size() == 0))
        {
          Log.d("MicroMsg.GalleryAdapter", "refresh album count: %s", new Object[] { ((b)localObject).CbE + ", mAlbumFolder = " + ((b)localObject).CbD });
          AppMethodBeat.o(242444);
          return;
        }
        int i = 0;
        while (i < ((b)localObject).CbD.size())
        {
          GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)((b)localObject).CbD.get(i);
          if ((localAlbumItem != null) && (!localAlbumItem.MtX) && (!localAlbumItem.NSW) && (((b)localObject).CbE.equals(localAlbumItem.albumName)))
          {
            if (j != localAlbumItem.fCa)
            {
              localAlbumItem.fCa = j;
              Log.d("MicroMsg.GalleryAdapter", "refresh album count: %s", new Object[] { Integer.valueOf(j) });
            }
            localAlbumItem.NSX = false;
            if ((localMediaItem != null) && (localAlbumItem.BVd != null) && (!Util.isNullOrNil(localMediaItem.aZe())) && (!localAlbumItem.aZe().equals(localMediaItem.aZe())))
            {
              localAlbumItem.BVd.wAy = localMediaItem.aZe();
              Log.d("MicroMsg.GalleryAdapter", "refresh album image.");
            }
            ((b)localObject).notifyDataSetChanged();
            AppMethodBeat.o(242444);
            return;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(242444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI
 * JD-Core Version:    0.7.0.1
 */