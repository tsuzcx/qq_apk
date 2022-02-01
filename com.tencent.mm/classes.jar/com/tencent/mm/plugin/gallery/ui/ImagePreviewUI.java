package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.b;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.b.a;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.plugin.gallery.b.c;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.g;
import com.tencent.mm.plugin.gallery.b.h;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.d.b;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.plugin.gallery.model.u;
import com.tencent.mm.plugin.gallery.model.u.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.f;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

@com.tencent.mm.ui.base.a(19)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class ImagePreviewUI
  extends MMActivity
{
  public int GzH;
  private ArrayList<GalleryItem.MediaItem> HLA;
  private String HLD;
  private long HMF;
  private int HMI;
  private HashMap<String, Long> HMW;
  private TextView HMn;
  private TextView HMo;
  private boolean HMv;
  public boolean HMw;
  private boolean HMy;
  private boolean HMz;
  private boolean HNW;
  private d HOO;
  private MMViewPager HOP;
  private RecyclerView HOQ;
  private ArrayList<String> HOR;
  private ArrayList<String> HOS;
  private ArrayList<GalleryItem.MediaItem> HOT;
  private Integer HOU;
  private ImageButton HOV;
  private TextView HOW;
  private MTimerHandler HOX;
  public boolean HOY;
  private float HOZ;
  private ImageButton HPa;
  private boolean HPb;
  private TextView HPc;
  private ViewGroup HPd;
  private ViewGroup HPe;
  private boolean HPf;
  private boolean HPg;
  private int HPh;
  private int HPi;
  public TextView HPj;
  private TextView HPk;
  private TextView HPl;
  private TextView HPm;
  private View HPn;
  private TextView HPo;
  private ProgressBar HPp;
  private boolean HPq;
  boolean HPr;
  private d.b HPs;
  private String HPt;
  private String HPu;
  private int HPv;
  private String HPw;
  private int HPx;
  private String HPy;
  private int mediaType;
  private String path;
  private int qqa;
  private boolean wQK;
  private SimpleDateFormat xiR;
  
  public ImagePreviewUI()
  {
    AppMethodBeat.i(111592);
    this.HOZ = 0.0F;
    this.HPf = true;
    this.HPg = true;
    this.HMv = true;
    this.HPh = 0;
    this.HMF = 0L;
    this.HPi = 10;
    this.HPq = false;
    this.mediaType = 0;
    this.xiR = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.HPr = false;
    this.HPs = null;
    this.HPu = "";
    this.HMW = new HashMap();
    this.HPv = 300000;
    this.HPx = 1000;
    AppMethodBeat.o(111592);
  }
  
  private void a(Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(289594);
    if (paramBoolean1) {}
    Object localObject1;
    Object localObject3;
    ArrayList localArrayList;
    for (boolean bool = true;; bool = paramBoolean2)
    {
      paramIntent.putExtra("CropImage_Compress_Img", bool);
      localObject1 = fBI();
      localObject3 = new ArrayList();
      localArrayList = new ArrayList();
      paramIntent.putExtra("KSEGMENTMEDIAEDITID", this.HPu);
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
        break;
      }
      Log.i("MicroMsg.ImagePreviewUI", "no img selected. keep current ui.");
      AppMethodBeat.o(289594);
      return;
    }
    Object localObject4 = ((ArrayList)localObject1).iterator();
    Object localObject2;
    Object localObject5;
    while (((Iterator)localObject4).hasNext())
    {
      localObject2 = (String)((Iterator)localObject4).next();
      localObject5 = com.tencent.mm.plugin.gallery.model.e.aEQ((String)localObject2);
      if ((localObject5 != null) && (((GalleryItem.MediaItem)localObject5).getType() == 2))
      {
        localArrayList.add(localObject2);
      }
      else
      {
        localObject1 = localObject2;
        if (localObject5 != null)
        {
          localObject1 = localObject2;
          if (((GalleryItem.MediaItem)localObject5).getType() != 2)
          {
            localObject1 = localObject2;
            if (((GalleryItem.MediaItem)localObject5).mMimeType.equals("edit"))
            {
              localObject1 = localObject2;
              if (!Util.isNullOrNil(((GalleryItem.MediaItem)localObject5).HHI)) {
                localObject1 = ((GalleryItem.MediaItem)localObject5).HHI;
              }
            }
          }
        }
        ((ArrayList)localObject3).add(localObject1);
      }
    }
    Log.i("MicroMsg.ImagePreviewUI", "dealWithSend, enableVLog:%s, forTimeline:%s", new Object[] { Boolean.valueOf(this.HPq), Boolean.valueOf(paramBoolean1) });
    int i;
    if ((this.HPq) && (com.tencent.mm.plugin.gallery.b.h.aN(this.HOT)))
    {
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject4 = new int[this.GzH];
      localObject5 = this.HOT.iterator();
      i = 0;
      if (((Iterator)localObject5).hasNext())
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject5).next();
        if (localMediaItem.getType() == 1)
        {
          if ((localMediaItem.mMimeType.equals("edit")) && (!Util.isNullOrNil(localMediaItem.HHI))) {
            ((ArrayList)localObject1).add(localMediaItem.HHI);
          }
          for (;;)
          {
            localObject4[i] = 1;
            i += 1;
            break;
            ((ArrayList)localObject1).add(localMediaItem.Gcc);
          }
        }
        if (localMediaItem.getType() != 2) {
          break label1515;
        }
        ((ArrayList)localObject2).add(localMediaItem.Gcc);
        int j = i + 1;
        localObject4[i] = 2;
        i = j;
      }
    }
    label1515:
    for (;;)
    {
      break;
      Log.i("MicroMsg.ImagePreviewUI", "try send vlog, videoList:%s, imageList:%s", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()), Integer.valueOf(((ArrayList)localObject1).size()) });
      if (com.tencent.mm.plugin.recordvideo.activity.a.b.I((List)localObject1, (List)localObject2) == 4)
      {
        paramIntent = VLogPreloadUI.HQX;
        VLogPreloadUI.a.a(this, (ArrayList)localObject2, (ArrayList)localObject1, (int[])localObject4);
        AppMethodBeat.o(289594);
        return;
      }
      if (paramBoolean1)
      {
        localObject1 = com.tencent.mm.plugin.gallery.a.c.HFY;
        if (com.tencent.mm.plugin.gallery.a.c.a(this.HOT, new ImagePreviewUI..ExternalSyntheticLambda2(this, paramIntent, paramBoolean1, paramBoolean2)))
        {
          goBack();
          AppMethodBeat.o(289594);
          return;
        }
      }
      if (paramBoolean1)
      {
        localObject1 = com.tencent.mm.plugin.gallery.a.c.HFY;
        if (com.tencent.mm.plugin.gallery.a.c.a(this.HOT, new ImagePreviewUI..ExternalSyntheticLambda1(this, paramIntent, paramBoolean1, paramBoolean2)))
        {
          goBack();
          AppMethodBeat.o(289594);
          return;
        }
      }
      if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 14) {
        i = 1;
      }
      while (((paramBoolean1) || (i != 0)) && (((ArrayList)localObject3).size() == 0) && (localArrayList.size() == 1))
      {
        i = getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000 + 500;
        Log.i("MicroMsg.ImagePreviewUI", "maxDuration=%s", new Object[] { Integer.valueOf(i) });
        localObject1 = com.tencent.mm.plugin.gallery.model.e.aEQ((String)localArrayList.get(0));
        if ((localObject1 != null) && ((localObject1 instanceof GalleryItem.VideoMediaItem)) && (((GalleryItem.VideoMediaItem)localObject1).oTN != -1))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("K_SEGMENTVIDEOPATH", ((GalleryItem.MediaItem)localObject1).Gcc);
          ((Intent)localObject2).putExtra("KSEGMENTVIDEOTHUMBPATH", ((GalleryItem.MediaItem)localObject1).zWJ);
          if (paramBoolean1)
          {
            paramIntent = (GalleryItem.VideoMediaItem)localObject1;
            if ((i > 0) && (paramIntent.oTN > i))
            {
              Log.i("MicroMsg.ImagePreviewUI", "goto edit video path:%s", new Object[] { paramIntent.Gcc });
              localObject1 = new StringBuilder();
              v.bOg();
              localObject1 = v.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis() + ".mp4";
              localObject2 = new StringBuilder();
              v.bOg();
              localObject2 = v.getAccVideoPath() + "/vsg_thumb_" + System.currentTimeMillis() + ".jpg";
              paramIntent = RecordConfigProvider.aM(paramIntent.Gcc, (String)localObject1, (String)localObject2);
              paramIntent.NHZ = i;
              paramIntent.oXZ = com.tencent.mm.modelcontrol.e.bIg().bIk();
              paramIntent.scene = 2;
              localObject1 = new UICustomParam.a();
              ((UICustomParam.a)localObject1).aQw();
              ((UICustomParam.a)localObject1).aQv();
              ((UICustomParam.a)localObject1).eL(true);
              paramIntent.NHR = ((UICustomParam.a)localObject1).lZB;
              localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
              com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4370, b.a.sight_slide_bottom_in, -1, paramIntent, 2, 0);
              AppMethodBeat.o(289594);
              return;
              i = 0;
            }
            else
            {
              com.tencent.mm.br.c.b(this, "mmsight", ".segment.VideoCompressUI", (Intent)localObject2, 4371);
              AppMethodBeat.o(289594);
            }
          }
          else
          {
            setResult(-1, (Intent)localObject2);
            finish();
            AppMethodBeat.o(289594);
          }
        }
        else
        {
          Log.e("MicroMsg.ImagePreviewUI", "dealWithSend VideoMediaItem not found.");
        }
      }
      paramIntent.putStringArrayListExtra("CropImage_OutputPath_List", (ArrayList)localObject3);
      paramIntent.putStringArrayListExtra("key_select_video_list", localArrayList);
      bool = getIntent().getBooleanExtra("isTakePhoto", false);
      if ((bool) && (fBI().size() > 0))
      {
        localObject1 = (String)fBI().get(0);
        localObject2 = BackwardSupportUtil.ExifHelper.getExifLatLong((String)localObject1);
        localObject3 = new Intent(this, ImagePreviewUI.class);
        Log.d("MicroMsg.ImagePreviewUI", "findlatlng %s", new Object[] { localObject1 });
        if (localObject2 != null)
        {
          Log.d("MicroMsg.ImagePreviewUI", "findlatlng %f %f", new Object[] { Float.valueOf(((BackwardSupportUtil.ExifHelper.LatLongData)localObject2).latitude), Float.valueOf(((BackwardSupportUtil.ExifHelper.LatLongData)localObject2).longtitude) });
          ((Intent)localObject3).putExtra("KlatLng", (Parcelable)localObject2);
        }
      }
      Log.d("MicroMsg.ImagePreviewUI", "summersafecdn send image, previewImageCount:%d, chooseForTimeline:%b, forTimeline:%b, beCompress:%b", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.fAu()), Boolean.valueOf(this.HMv), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if (this.HMv) {}
      for (i = 3;; i = 2)
      {
        com.tencent.mm.plugin.gallery.b.h.bZ(11610, i + "," + com.tencent.mm.plugin.gallery.model.e.fAu());
        com.tencent.mm.plugin.gallery.model.e.fAt();
        Log.d("MicroMsg.ImagePreviewUI", "isTaskPhoto ? " + bool + " | isPreviewPhoto ? " + paramIntent.getBooleanExtra("isPreviewPhoto", false));
        paramIntent.putExtra("isTakePhoto", bool);
        localObject1 = getIntent().getStringExtra("GalleryUI_ToUser");
        if ((!Util.isNullOrNil(getIntent().getStringExtra("GalleryUI_FromUser"))) && (!"medianote".equals(localObject1))) {
          break;
        }
        setResult(-1, paramIntent);
        finish();
        AppMethodBeat.o(289594);
        return;
      }
      if (Util.currentTicks() - this.HMF < 1000L)
      {
        Log.w("MicroMsg.ImagePreviewUI", "sendimg btn event frequence limit");
        AppMethodBeat.o(289594);
        return;
      }
      this.HMF = Util.currentTicks();
      Log.i("MicroMsg.ImagePreviewUI", "switch to SendImgProxyUI");
      paramIntent.setClassName(this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
      paramIntent.putExtra("GalleryUI_FromUser", getIntent().getStringExtra("GalleryUI_FromUser"));
      paramIntent.putExtra("GalleryUI_ToUser", getIntent().getStringExtra("GalleryUI_ToUser"));
      paramIntent.putExtra("CropImage_limit_Img_Size", 26214400);
      startActivityForResult(paramIntent, 4369);
      AppMethodBeat.o(289594);
      return;
    }
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111608);
    boolean bool;
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || ((com.tencent.mm.plugin.gallery.model.e.fAn().sfB != 4) && (com.tencent.mm.plugin.gallery.model.e.fAn().sfB != 14) && (com.tencent.mm.plugin.gallery.model.e.fAn().sfB != 13)))
    {
      this.HPf = true;
      this.HPd.setVisibility(0);
      this.HPe.setVisibility(8);
      this.HPp.setVisibility(8);
      a(paramString, paramMediaItem, false);
      aFc(paramString);
      enableOptionMenu(true);
      this.HOW.setVisibility(8);
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
        this.HPj.setVisibility(0);
      }
      for (;;)
      {
        if ((com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 15) || (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 28)) {
          this.HPj.setVisibility(4);
        }
        if (this.HMw) {
          this.HPj.setVisibility(4);
        }
        aFa(paramString);
        AppMethodBeat.o(111608);
        return;
        bool = getIntent().getBooleanExtra("preview_image", false);
        Log.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.fAn().sfB), Boolean.valueOf(bool), paramString });
        if ((paramMediaItem == null) && (!Util.isNullOrNil(paramString))) {
          this.HPj.setVisibility(0);
        } else {
          this.HPj.setVisibility(4);
        }
      }
    }
    if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
      this.HPj.setVisibility(0);
    }
    final GalleryItem.VideoMediaItem localVideoMediaItem;
    for (;;)
    {
      if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 25) {
        this.HPj.setVisibility(4);
      }
      aFa(paramString);
      localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
      enableOptionMenu(false);
      this.HPf = false;
      this.HPd.setVisibility(8);
      this.HPe.setVisibility(0);
      this.HPo.setVisibility(8);
      if (!aFb(paramString)) {
        break;
      }
      AppMethodBeat.o(111608);
      return;
      this.HPj.setVisibility(4);
    }
    if (!Util.isNullOrNil(localVideoMediaItem.oTL))
    {
      Log.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.Gcc, Integer.valueOf(localVideoMediaItem.oTN), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
      bool = a(paramString, localVideoMediaItem, this.HPq);
      a(this.HPq, bool, localVideoMediaItem);
      fBJ();
      AppMethodBeat.o(111608);
      return;
    }
    enableOptionMenu(false);
    this.HPf = true;
    this.HPd.setVisibility(0);
    this.HPe.setVisibility(8);
    this.HOW.setVisibility(8);
    a(paramString, paramMediaItem, false);
    aFc(paramString);
    paramMediaItem = new u(paramString, this.HOU.intValue(), localVideoMediaItem, new u.a()
    {
      public final void a(u paramAnonymousu)
      {
        AppMethodBeat.i(111579);
        if (paramAnonymousu.equals(ImagePreviewUI.C(ImagePreviewUI.this).getTag())) {
          ImagePreviewUI.C(ImagePreviewUI.this).setTag(null);
        }
        if (paramAnonymousu.position != ImagePreviewUI.k(ImagePreviewUI.this).intValue())
        {
          AppMethodBeat.o(111579);
          return;
        }
        boolean bool = ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousu.path, paramAnonymousu.HIQ, ImagePreviewUI.D(ImagePreviewUI.this));
        ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.D(ImagePreviewUI.this), bool, localVideoMediaItem);
        ImagePreviewUI.E(ImagePreviewUI.this);
        AppMethodBeat.o(111579);
      }
    });
    if (paramMediaItem.equals(this.HPp.getTag()))
    {
      Log.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { paramString });
      AppMethodBeat.o(111608);
      return;
    }
    this.HPp.setTag(paramMediaItem);
    com.tencent.threadpool.h.ahAA.bm(paramMediaItem);
    if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 15) {
      this.HPj.setVisibility(4);
    }
    if (this.HMw) {
      this.HPj.setVisibility(4);
    }
    AppMethodBeat.o(111608);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111619);
    int i = com.tencent.mm.plugin.gallery.model.e.fAn().HIa;
    int j = com.tencent.mm.plugin.gallery.model.e.fAn().sfB;
    if ((j != 16) && ((i == 2) || (i == 3)))
    {
      i = 1;
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 2) && (j == 4) && (!paramBoolean) && (i == 0)) {
        break label201;
      }
      if (this.GzH != 1) {
        break label148;
      }
      this.HPa.setVisibility(8);
      this.HPc.setVisibility(8);
    }
    for (;;)
    {
      if (this.HOS.contains(paramString)) {
        break label167;
      }
      this.HPa.setImageResource(b.h.radio_off);
      this.HPa.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unchoosed_desc));
      AppMethodBeat.o(111619);
      return;
      i = 0;
      break;
      label148:
      this.HPa.setVisibility(0);
      this.HPc.setVisibility(0);
    }
    label167:
    this.HPa.setImageResource(fBL());
    this.HPa.setContentDescription(getResources().getString(b.i.gallery_album_btn_choosed_desc));
    AppMethodBeat.o(111619);
    return;
    label201:
    this.HPa.setVisibility(8);
    this.HPc.setVisibility(8);
    AppMethodBeat.o(111619);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111609);
    if (!paramBoolean2)
    {
      AppMethodBeat.o(111609);
      return;
    }
    if ((paramBoolean1) && (com.tencent.mm.plugin.gallery.b.h.aN(this.HOT)))
    {
      this.HPo.setVisibility(8);
      this.HOW.setVisibility(8);
      this.HPe.setVisibility(8);
      enableOptionMenu(true);
      a(this.path, paramMediaItem, paramBoolean1);
    }
    AppMethodBeat.o(111609);
  }
  
  private boolean a(String paramString, GalleryItem.VideoMediaItem paramVideoMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111611);
    enableOptionMenu(false);
    this.HPf = false;
    this.HPd.setVisibility(8);
    this.HPe.setVisibility(0);
    this.HPo.setVisibility(8);
    if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 13)
    {
      this.HPe.setVisibility(8);
      this.HPd.setVisibility(8);
      this.HPk.setVisibility(8);
      this.HPl.setVisibility(8);
      enableOptionMenu(true);
      AppMethodBeat.o(111611);
      return true;
    }
    if (c(paramVideoMediaItem))
    {
      AppMethodBeat.o(111611);
      return false;
    }
    if (d(paramVideoMediaItem))
    {
      AppMethodBeat.o(111611);
      return false;
    }
    if ((!paramBoolean) && (b(paramVideoMediaItem)))
    {
      AppMethodBeat.o(111611);
      return false;
    }
    enableOptionMenu(true);
    this.HPf = true;
    this.HPd.setVisibility(0);
    this.HPe.setVisibility(8);
    this.HOW.setVisibility(0);
    this.HPp.setVisibility(8);
    a(paramString, paramVideoMediaItem, false);
    aFc(paramString);
    AppMethodBeat.o(111611);
    return true;
  }
  
  private void aEV(String paramString)
  {
    AppMethodBeat.i(289589);
    g.a locala = new g.a(this);
    locala.bf(paramString);
    locala.bDI(getString(b.i.gallery_i_know));
    locala.b(ImagePreviewUI..ExternalSyntheticLambda0.INSTANCE);
    locala.show();
    AppMethodBeat.o(289589);
  }
  
  private void aEZ(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(111598);
    GalleryItem.MediaItem localMediaItem;
    Object localObject2;
    int i;
    int j;
    if (!this.HOS.contains(paramString))
    {
      localMediaItem = com.tencent.mm.plugin.gallery.model.e.aEQ(paramString);
      if (this.HOS.size() >= this.GzH)
      {
        if ((this.mediaType == 2) || ((!Util.isNullOrNil(this.HLD)) && (this.HLD.equals("album_business_bubble_media_by_coordinate")))) {
          paramString = getResources().getQuantityString(b.g.gallery_pic_or_video_limit, this.GzH, new Object[] { Integer.valueOf(this.GzH) });
        }
        for (;;)
        {
          com.tencent.mm.ui.base.k.cZ(getContext(), paramString);
          this.HPa.setImageResource(b.h.radio_off);
          this.HPa.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unchoosed_desc));
          this.HPb = false;
          if (!Util.isNullOrNil(this.HOS)) {
            break;
          }
          AppMethodBeat.o(111598);
          return;
          if (this.mediaType == 1) {
            paramString = getResources().getQuantityString(b.g.gallery_video_limit, this.GzH, new Object[] { Integer.valueOf(this.GzH) });
          } else {
            paramString = getResources().getQuantityString(b.g.gallery_pic_limit, this.GzH, new Object[] { Integer.valueOf(this.GzH) });
          }
        }
      }
      if (!(localMediaItem instanceof GalleryItem.ImageMediaItem)) {
        break label1210;
      }
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(localMediaItem.Gcc, (BitmapFactory.Options)localObject2);
      i = ((BitmapFactory.Options)localObject2).outWidth;
      j = ((BitmapFactory.Options)localObject2).outHeight;
    }
    for (;;)
    {
      if ((localMediaItem instanceof GalleryItem.VideoMediaItem))
      {
        localObject2 = (GalleryItem.VideoMediaItem)localMediaItem;
        i = ((GalleryItem.VideoMediaItem)localObject2).videoWidth;
        j = ((GalleryItem.VideoMediaItem)localObject2).videoHeight;
      }
      if (this.HOZ == 0.0F)
      {
        i = 1;
        label316:
        if (i != 0) {
          break label463;
        }
        if (!(localMediaItem instanceof GalleryItem.ImageMediaItem)) {
          break label438;
        }
        paramString = getResources().getString(b.i.gallery_select_pic_ratio_not_support);
      }
      for (;;)
      {
        if (paramString != null) {
          com.tencent.mm.ui.base.k.cZ(getContext(), paramString);
        }
        this.HPa.setImageResource(b.h.radio_off);
        this.HPa.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unchoosed_desc));
        this.HPb = false;
        break;
        if ((i == 0) || (j == 0))
        {
          i = 0;
          break label316;
        }
        float f = i / j;
        if ((f <= this.HOZ) && (f >= 1.0F / this.HOZ))
        {
          i = 1;
          break label316;
        }
        i = 0;
        break label316;
        label438:
        paramString = (String)localObject1;
        if ((localMediaItem instanceof GalleryItem.VideoMediaItem)) {
          paramString = getResources().getString(b.i.gallery_select_video_ratio_not_support);
        }
      }
      label463:
      if (localMediaItem != null)
      {
        if ((localMediaItem.mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aot(paramString)))
        {
          if ((com.tencent.mm.modelvideo.ab.bOG()) && (this.HPh == 3))
          {
            aEV(getString(b.i.gallery_album_can_not_send_too_large_gif, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(com.tencent.mm.plugin.gallery.b.h.aRi()) }));
            AppMethodBeat.o(111598);
            return;
          }
          com.tencent.mm.ui.base.k.cZ(this, getString(b.i.gallery_select_gif_to_big));
          AppMethodBeat.o(111598);
          return;
        }
        if ((localMediaItem.mMimeType.equalsIgnoreCase("image/gif")) && (!Util.isNullOrNil(this.HLD)) && (this.HLD.equals("album_business_byp")))
        {
          if (!((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aou(localMediaItem.Gcc))
          {
            com.tencent.mm.ui.base.k.cZ(this, getString(b.i.gallery_no_support_giant_gif_gamelife));
            AppMethodBeat.o(111598);
          }
        }
        else if ((localMediaItem instanceof GalleryItem.VideoMediaItem)) {
          if ((!Util.isNullOrNil(this.HLD)) && (this.HLD.equals("album_business_bubble_media_by_coordinate")))
          {
            if (((GalleryItem.VideoMediaItem)localMediaItem).oTN >= this.qqa * 1000 + 500)
            {
              com.tencent.mm.ui.base.k.cZ(getContext(), getContext().getResources().getString(b.i.gallery_video_duration_limit, new Object[] { Integer.valueOf(this.qqa) }));
              AppMethodBeat.o(111598);
            }
          }
          else if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 25)
          {
            if (((GalleryItem.VideoMediaItem)localMediaItem).oTN > this.qqa * 1000 + 500)
            {
              com.tencent.mm.ui.base.k.cZ(getContext(), getContext().getResources().getString(b.i.gallery_video_duration_limit, new Object[] { Integer.valueOf(this.qqa) }));
              AppMethodBeat.o(111598);
              return;
            }
            if (((GalleryItem.VideoMediaItem)localMediaItem).oTN < this.HMI * 1000)
            {
              com.tencent.mm.ui.base.k.cZ(getContext(), getContext().getResources().getString(b.i.gallery_video_duration_below, new Object[] { Integer.valueOf(this.HMI) }));
              AppMethodBeat.o(111598);
              return;
            }
          }
        }
        if (this.HOT != null)
        {
          localObject1 = this.HOT.iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (GalleryItem.MediaItem)((Iterator)localObject1).next();
            if ((localObject2 == null) || (!((GalleryItem.MediaItem)localObject2).Gcc.equalsIgnoreCase(localMediaItem.Gcc))) {
              break label1207;
            }
            i = 1;
          }
        }
      }
      label904:
      label1204:
      label1207:
      for (;;)
      {
        break label904;
        if (i == 0) {
          this.HOT.add(localMediaItem);
        }
        this.HOS.add(paramString);
        this.HPa.setImageResource(fBL());
        this.HPa.setContentDescription(getResources().getString(b.i.gallery_album_btn_choosed_desc));
        this.HPb = true;
        c(this.HOS.size(), this.HOU.intValue(), paramString, 0);
        break;
        this.HPa.setImageResource(b.h.radio_off);
        this.HPa.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unchoosed_desc));
        this.HPb = false;
        while (this.HOS.remove(paramString)) {}
        if (this.HOT != null)
        {
          localObject2 = this.HOT.iterator();
          localObject1 = null;
          label1092:
          if (((Iterator)localObject2).hasNext())
          {
            localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject2).next();
            if ((localMediaItem == null) || (!localMediaItem.Gcc.equalsIgnoreCase(paramString))) {
              break label1204;
            }
            localObject1 = localMediaItem;
          }
        }
        for (;;)
        {
          break label1092;
          if (localObject1 != null)
          {
            Log.i("MicroMsg.ImagePreviewUI", "unselect item: %s", new Object[] { ((GalleryItem.MediaItem)localObject1).Gcc });
            this.HOT.remove(localObject1);
          }
          c(this.HOS.size(), this.HOU.intValue(), paramString, 1);
          break;
          AppMethodBeat.o(111598);
          return;
        }
      }
      label1210:
      j = 0;
      i = 0;
    }
  }
  
  private void aFa(String paramString)
  {
    AppMethodBeat.i(111610);
    if ((this.HOS.size() >= 9) && (!this.HOS.contains(paramString)))
    {
      this.HPj.setTextColor(getContext().getResources().getColor(b.b.white_text_color_disabled));
      this.HPj.setEnabled(false);
      AppMethodBeat.o(111610);
      return;
    }
    this.HPj.setEnabled(true);
    this.HPj.setTextColor(getContext().getResources().getColor(b.b.white_text_color));
    AppMethodBeat.o(111610);
  }
  
  private boolean aFb(String paramString)
  {
    AppMethodBeat.i(111613);
    if (y.bEl(paramString) > 1073741824L)
    {
      this.HPk.setText(getString(b.i.gallery_pic_video_too_large_title));
      this.HPl.setText(getString(b.i.gallery_pic_video_too_large_desc));
      AppMethodBeat.o(111613);
      return true;
    }
    AppMethodBeat.o(111613);
    return false;
  }
  
  private void aFc(String paramString)
  {
    AppMethodBeat.i(111620);
    Object localObject = Boolean.FALSE;
    GalleryItem.MediaItem localMediaItem;
    int i;
    switch (com.tencent.mm.plugin.gallery.model.e.fAn().sfB)
    {
    default: 
      localObject = Boolean.FALSE;
      localMediaItem = com.tencent.mm.plugin.gallery.model.e.aEQ(paramString);
      if ((localMediaItem != null) && (localMediaItem.getType() == 2))
      {
        localObject = Boolean.TRUE;
        i = 0;
      }
      break;
    }
    for (;;)
    {
      label130:
      if ((localMediaItem == null) && (ImgUtil.isGif(paramString)))
      {
        paramString = Boolean.TRUE;
        label146:
        if (((this.HMy) && (i != 0)) || (!paramString.booleanValue())) {
          break label341;
        }
        this.HOV.setVisibility(8);
        this.HMn.setVisibility(8);
        label182:
        if ((!com.tencent.mm.modelvideo.ab.bOG()) || (this.HPh != 3) || (!this.wQK) || (paramString.booleanValue())) {
          break label365;
        }
        paramString = fBu();
        localObject = this.HMo;
        if (!Util.isNullOrNil(paramString)) {
          break label360;
        }
      }
      label341:
      label360:
      for (i = 8;; i = 0)
      {
        ((TextView)localObject).setVisibility(i);
        this.HMo.setText(getString(b.i.gallery_album_summary_item_size_tips, new Object[] { paramString }));
        AppMethodBeat.o(111620);
        return;
        localObject = Boolean.TRUE;
        break;
        if ((localMediaItem == null) || (localMediaItem.getType() != 1)) {
          break label381;
        }
        i = 1;
        break label130;
        if ((localMediaItem != null) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
        {
          paramString = Boolean.TRUE;
          break label146;
        }
        paramString = (String)localObject;
        if (!com.tencent.mm.modelvideo.ab.bOG()) {
          break label146;
        }
        paramString = (String)localObject;
        if (this.HPh != 3) {
          break label146;
        }
        paramString = Boolean.FALSE;
        break label146;
        this.HOV.setVisibility(0);
        this.HMn.setVisibility(0);
        break label182;
      }
      label365:
      this.HMo.setVisibility(8);
      AppMethodBeat.o(111620);
      return;
      label381:
      i = 0;
    }
  }
  
  private boolean b(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111614);
    Log.d("MicroMsg.ImagePreviewUI", "check duration %d, editVideoMaxTimeLength:%d", new Object[] { Integer.valueOf(paramVideoMediaItem.oTN), Integer.valueOf(this.HPi) });
    if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 13)
    {
      AppMethodBeat.o(111614);
      return false;
    }
    if (paramVideoMediaItem.oTN <= 1000)
    {
      this.HPk.setText(getString(b.i.gallery_pic_video_too_short_title));
      this.HPl.setText(getString(b.i.gallery_pic_video_too_short_desc));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.oTN >= 300000)
    {
      this.HPk.setText(getString(b.i.gallery_pic_video_too_long_title));
      this.HPl.setText(getString(b.i.gallery_pic_video_too_long_desc));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.oTN >= this.HPi * 1000 + 500)
    {
      this.HPk.setText(getString(b.i.gallery_pic_edit_video));
      this.HPl.setText(getString(b.i.gallery_pic_edit_des_config, new Object[] { Integer.valueOf(this.HPi) }));
      this.HPo.setVisibility(0);
      AppMethodBeat.o(111614);
      return true;
    }
    AppMethodBeat.o(111614);
    return false;
  }
  
  private void c(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(111621);
    Log.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((-1 != paramInt2) && (!this.HNW))
    {
      this.HOQ.getAdapter().t(paramInt2, Integer.valueOf(paramInt2));
      if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB != 13) {
        break label415;
      }
      paramInt2 = 1;
      label73:
      paramString = this.HOO.WP(this.HOU.intValue());
      if ((26 != com.tencent.mm.plugin.gallery.model.e.fAn().sfB) && (paramInt1 != 0) && (((!this.HMv) || (this.HPq)) && ((paramInt2 == 0) || (this.HOO == null) || (paramString == null) || (paramString.getType() != 2)))) {
        break label420;
      }
    }
    label415:
    label420:
    for (boolean bool = true;; bool = false)
    {
      paramString = com.tencent.mm.plugin.gallery.a.c.HFY;
      if (com.tencent.mm.plugin.gallery.a.c.isEnable())
      {
        bool = false;
        paramString = com.tencent.mm.plugin.gallery.a.c.HFY;
        com.tencent.mm.plugin.gallery.a.c.aI(this.HOT);
      }
      Log.i("MicroMsg.ImagePreviewUI", "gonePreview:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label426;
      }
      this.HOQ.setVisibility(8);
      AppMethodBeat.o(111621);
      return;
      if (-1 == paramInt2) {
        break;
      }
      if ((paramInt3 == 0) && (paramInt1 > 0))
      {
        ((g)this.HOQ.getAdapter()).aFd(paramString);
        ((g)this.HOQ.getAdapter()).jb(paramInt1 - 1, this.HOU.intValue());
        this.HOQ.getAdapter().fW(paramInt1 - 1);
        paramString = this.HOQ;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt1 - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramString, locala.aYi(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramString.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        break;
      }
      if (paramInt3 != 1) {
        break;
      }
      paramInt2 = ((g)this.HOQ.getAdapter()).cs(paramString);
      if (-1 == paramInt2) {
        break;
      }
      ((g)this.HOQ.getAdapter()).remove(paramInt2);
      this.HOQ.getAdapter().fX(paramInt2);
      break;
      paramInt2 = 0;
      break label73;
    }
    label426:
    this.HOQ.setVisibility(0);
    AppMethodBeat.o(111621);
  }
  
  private boolean c(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111616);
    if ((paramVideoMediaItem == null) || (paramVideoMediaItem.videoWidth <= 0) || (paramVideoMediaItem.videoHeight <= 0) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight > 3.0F) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight < 0.3F))
    {
      if (paramVideoMediaItem != null) {
        Log.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramVideoMediaItem.videoWidth), Integer.valueOf(paramVideoMediaItem.videoHeight) });
      }
      this.HPk.setText(getString(b.i.gallery_pic_video_special_ratio));
      this.HPl.setText(getString(b.i.gallery_pic_video_special_ratio_desc));
      AppMethodBeat.o(111616);
      return true;
    }
    AppMethodBeat.o(111616);
    return false;
  }
  
  private boolean d(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(289617);
    Log.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[] { paramVideoMediaItem });
    if ((paramVideoMediaItem == null) || (!com.tencent.mm.plugin.gallery.b.b.HQZ.b(com.tencent.mm.plugin.gallery.model.e.fAn().sfB, paramVideoMediaItem)))
    {
      if (paramVideoMediaItem == null) {}
      for (paramVideoMediaItem = null;; paramVideoMediaItem = paramVideoMediaItem.oTL)
      {
        Log.i("MicroMsg.ImagePreviewUI", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramVideoMediaItem });
        fBK();
        AppMethodBeat.o(289617);
        return true;
      }
    }
    AppMethodBeat.o(289617);
    return false;
  }
  
  private ArrayList<String> fBI()
  {
    AppMethodBeat.i(111602);
    if (this.HNW)
    {
      localArrayList = this.HOS;
      AppMethodBeat.o(111602);
      return localArrayList;
    }
    if (this.HOS != null)
    {
      localArrayList = new ArrayList(this.HOS.size());
      Iterator localIterator = this.HOR.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.HOS.contains(str)) {
          localArrayList.add(str);
        }
      }
      AppMethodBeat.o(111602);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList(1);
    AppMethodBeat.o(111602);
    return localArrayList;
  }
  
  private boolean fBK()
  {
    AppMethodBeat.i(111615);
    this.HPk.setText(getString(b.i.gallery_pic_video_not_support));
    this.HPl.setText(getString(b.i.gallery_pic_video_not_support_desc));
    AppMethodBeat.o(111615);
    return true;
  }
  
  private static int fBL()
  {
    AppMethodBeat.i(111622);
    if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 15)
    {
      i = b.h.checkbox_selected_game;
      AppMethodBeat.o(111622);
      return i;
    }
    if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 25)
    {
      i = b.h.checkbox_selected_orange;
      AppMethodBeat.o(111622);
      return i;
    }
    if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 28)
    {
      i = b.h.checkbox_selected_finder_live;
      AppMethodBeat.o(111622);
      return i;
    }
    int i = b.h.checkbox_selected_small;
    AppMethodBeat.o(111622);
    return i;
  }
  
  private String fBu()
  {
    AppMethodBeat.i(289607);
    Object localObject = this.HOS.iterator();
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
      AppMethodBeat.o(289607);
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
  
  private void goBack()
  {
    boolean bool2 = true;
    AppMethodBeat.i(111605);
    Intent localIntent = new Intent();
    boolean bool1;
    if (!this.wQK)
    {
      bool1 = true;
      if (!this.HMv) {
        break label89;
      }
      bool1 = bool2;
    }
    label89:
    for (;;)
    {
      localIntent.putExtra("CropImage_Compress_Img", bool1);
      localIntent.putStringArrayListExtra("preview_image_list", fBI());
      localIntent.putExtra("show_photo_edit_tip", this.HPr);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(111605);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void h(int paramInt, final Intent paramIntent)
  {
    AppMethodBeat.i(111600);
    if ((paramInt == -1) && (paramIntent != null))
    {
      this.HPr = true;
      Object localObject2 = paramIntent.getStringExtra("raw_photo_path");
      Object localObject1 = com.tencent.mm.plugin.gallery.model.e.fAr().iterator();
      while ((localObject2 != null) && (((Iterator)localObject1).hasNext())) {
        if (((String)localObject2).equals(((Bundle)((Iterator)localObject1).next()).getString("raw_photo_path"))) {
          ((Iterator)localObject1).remove();
        }
      }
      com.tencent.mm.plugin.gallery.model.e.fAr().add(paramIntent.getBundleExtra("report_info"));
      localObject1 = paramIntent.getStringExtra("after_photo_edit");
      String str = paramIntent.getStringExtra("tmp_photo_edit");
      Log.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { localObject2, localObject1 });
      if (this.HOR != null)
      {
        this.HOR.clear();
        Object localObject3 = paramIntent.getStringArrayListExtra("preview_image_list");
        if (localObject3 != null) {
          this.HOR.addAll((Collection)localObject3);
        }
        localObject3 = this.HOO.WP(this.HOU.intValue());
        if (localObject3 == null)
        {
          Log.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { this.HOU, localObject2, localObject1 });
          AppMethodBeat.o(111600);
          return;
        }
        ((GalleryItem.MediaItem)localObject3).HHH = ((String)localObject2);
        ((GalleryItem.MediaItem)localObject3).Gcc = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).zWJ = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).HHI = str;
        ((GalleryItem.MediaItem)localObject3).mMimeType = "edit";
        com.tencent.mm.plugin.gallery.model.e.fAq().add(localObject3);
        if (this.HPs != null) {
          com.tencent.mm.plugin.gallery.model.e.fAm().b(this.HPs);
        }
        localObject2 = com.tencent.mm.plugin.gallery.model.e.fAm();
        paramIntent = new d.b()
        {
          public final void aEP(final String paramAnonymousString)
          {
            AppMethodBeat.i(111571);
            new MMHandler(ImagePreviewUI.this.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111570);
                ImagePreviewUI.m(ImagePreviewUI.this).aM(ImagePreviewUI.w(ImagePreviewUI.this));
                Object localObject1 = (g)ImagePreviewUI.l(ImagePreviewUI.this).getAdapter();
                Object localObject2 = ImagePreviewUI.w(ImagePreviewUI.this);
                ((g)localObject1).HPM.clear();
                ((g)localObject1).HPM.addAll((Collection)localObject2);
                ((RecyclerView.a)localObject1).bZE.notifyChanged();
                localObject1 = ImagePreviewUI.10.this.vsF.getStringArrayListExtra("preview_select_image_list");
                ImagePreviewUI.d(ImagePreviewUI.this).clear();
                if (localObject1 != null) {
                  ImagePreviewUI.d(ImagePreviewUI.this).addAll((Collection)localObject1);
                }
                ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.g(ImagePreviewUI.this));
                ImagePreviewUI.j(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(b.i.gallery_pic_original));
                int i;
                if ((com.tencent.mm.modelvideo.ab.bOG()) && (ImagePreviewUI.f(ImagePreviewUI.this) == 3) && (ImagePreviewUI.b(ImagePreviewUI.this)))
                {
                  localObject1 = ImagePreviewUI.h(ImagePreviewUI.this);
                  localObject2 = ImagePreviewUI.i(ImagePreviewUI.this);
                  if (Util.isNullOrNil((String)localObject1))
                  {
                    i = 8;
                    ((TextView)localObject2).setVisibility(i);
                    ImagePreviewUI.i(ImagePreviewUI.this).setText(ImagePreviewUI.this.getString(b.i.gallery_album_summary_item_size_tips, new Object[] { localObject1 }));
                  }
                }
                for (;;)
                {
                  if (!ImagePreviewUI.d(ImagePreviewUI.this).contains(com.tencent.mm.plugin.gallery.b.h.aFi(paramAnonymousString))) {
                    ImagePreviewUI.e(ImagePreviewUI.this).performClick();
                  }
                  AppMethodBeat.o(111570);
                  return;
                  i = 0;
                  break;
                  ImagePreviewUI.i(ImagePreviewUI.this).setVisibility(8);
                }
              }
            });
            com.tencent.mm.plugin.gallery.model.e.fAm().b(this);
            AppMethodBeat.o(111571);
          }
          
          public final String fAj()
          {
            AppMethodBeat.i(179472);
            String str = com.tencent.mm.plugin.gallery.b.h.a(this.HPB, null, -1);
            AppMethodBeat.o(179472);
            return str;
          }
          
          public final String toString()
          {
            AppMethodBeat.i(111572);
            String str = "fileKey:" + this.HPB + " this: " + super.toString();
            AppMethodBeat.o(111572);
            return str;
          }
        };
        this.HPs = paramIntent;
        ((com.tencent.mm.plugin.gallery.model.c)localObject2).a(paramIntent);
        com.tencent.mm.plugin.gallery.model.e.fAm().a((String)localObject1, ((GalleryItem.MediaItem)localObject3).getType(), (String)localObject1, ((GalleryItem.MediaItem)localObject3).HHJ, ((GalleryItem.MediaItem)localObject3).HHK);
        Log.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
      }
    }
    AppMethodBeat.o(111600);
  }
  
  private void k(final GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111612);
    if (paramMediaItem == null)
    {
      Log.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
      AppMethodBeat.o(111612);
      return;
    }
    Object localObject1;
    int i;
    label391:
    label446:
    boolean bool;
    if (paramMediaItem.getType() == 2)
    {
      localObject1 = (GalleryItem.VideoMediaItem)paramMediaItem;
      this.HPv = 300000;
      this.HPw = getString(b.i.gallery_pic_video_too_long_desc);
      Object localObject2;
      if (this.HPh == 3)
      {
        localObject2 = com.tencent.mm.k.a.lZC;
        this.HPv = (com.tencent.mm.k.a.aQy() * 1000);
        localObject2 = com.tencent.mm.k.a.lZC;
        i = com.tencent.mm.k.a.aQy() / 60;
        this.HPw = getString(b.i.gallery_pic_video_too_long_custom_desc, new Object[] { Integer.valueOf(i) });
        this.HPx = 1000;
        this.HPy = getString(b.i.gallery_pic_video_too_short_desc);
        if (((this.HLD != null) && ((this.HLD.equals("album_business_bubble_media_by_coordinate")) || (this.HLD.equals("album_business_bubble_media_by_jsapi_choosevideo")))) || (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 25))
        {
          this.HPv = (this.qqa * 1000 + 500);
          this.HPw = getString(b.i.gallery_video_duration_limit, new Object[] { Integer.valueOf(this.qqa) });
          if (this.HMI != 0)
          {
            this.HPx = (this.HMI * 1000);
            this.HPy = getString(b.i.gallery_video_duration_below, new Object[] { Integer.valueOf(this.HMI) });
          }
        }
        if (Util.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).oTL)) {
          break label770;
        }
        Log.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { ((GalleryItem.VideoMediaItem)localObject1).Gcc, Integer.valueOf(((GalleryItem.VideoMediaItem)localObject1).oTN), Integer.valueOf(((GalleryItem.VideoMediaItem)localObject1).videoHeight), Integer.valueOf(((GalleryItem.VideoMediaItem)localObject1).videoWidth) });
        if ((((GalleryItem.VideoMediaItem)localObject1).oTN < this.HPv) && ((((GalleryItem.VideoMediaItem)localObject1).oTN <= 0) || (((GalleryItem.VideoMediaItem)localObject1).oTN >= this.HPx))) {
          break label636;
        }
        this.HPn.setVisibility(0);
        localObject2 = this.HPm;
        if (((GalleryItem.VideoMediaItem)localObject1).oTN < this.HPv) {
          break label627;
        }
        localObject1 = this.HPw;
        ((TextView)localObject2).setText((CharSequence)localObject1);
        this.HPc.setEnabled(false);
        this.HPa.setEnabled(false);
        this.HPc.setTextColor(getResources().getColor(b.b.white_text_color_disabled));
        if (this.HOS.size() == 0) {
          enableOptionMenu(false);
        }
        if ((!com.tencent.mm.modelvideo.ab.bOG()) || (this.HPh != 3) || (!this.wQK) || (y.bEl(paramMediaItem.Gcc) <= com.tencent.mm.plugin.gallery.b.h.aRj())) {
          break label859;
        }
        bool = this.HOT.contains(paramMediaItem);
        this.HPc.setEnabled(bool);
        this.HPa.setEnabled(bool);
        paramMediaItem = this.HPc;
        localObject1 = getResources();
        if (!bool) {
          break label763;
        }
      }
      label627:
      label763:
      for (i = b.b.white_text_color;; i = b.b.white_text_color_disabled)
      {
        paramMediaItem.setTextColor(((Resources)localObject1).getColor(i));
        this.HPn.setVisibility(8);
        if (this.HOS.size() == 0) {
          enableOptionMenu(false);
        }
        AppMethodBeat.o(111612);
        return;
        if (this.HPh != 4) {
          break;
        }
        localObject2 = com.tencent.mm.k.a.lZC;
        this.HPv = (com.tencent.mm.k.a.aQz() * 1000);
        i = this.HPv / 1000 / 60;
        this.HPw = getString(b.i.gallery_pic_video_too_long_custom_desc, new Object[] { Integer.valueOf(i) });
        break;
        localObject1 = this.HPy;
        break label391;
        label636:
        if (d((GalleryItem.VideoMediaItem)localObject1))
        {
          this.HPn.setVisibility(0);
          this.HPm.setText(getString(b.i.gallery_pic_video_not_support_desc));
          this.HPc.setEnabled(false);
          this.HPa.setEnabled(false);
          this.HPc.setTextColor(getResources().getColor(b.b.white_text_color_disabled));
          if (this.HOS.size() != 0) {
            break label446;
          }
          enableOptionMenu(false);
          break label446;
        }
        this.HPc.setEnabled(true);
        this.HPa.setEnabled(true);
        this.HPc.setTextColor(getResources().getColor(b.b.white_text_color));
        this.HPn.setVisibility(8);
        break label446;
      }
      label770:
      paramMediaItem = new u(paramMediaItem.Gcc, this.HOU.intValue(), (GalleryItem.VideoMediaItem)localObject1, new u.a()
      {
        public final void a(u paramAnonymousu)
        {
          AppMethodBeat.i(111580);
          if (paramAnonymousu.equals(ImagePreviewUI.C(ImagePreviewUI.this).getTag())) {
            ImagePreviewUI.C(ImagePreviewUI.this).setTag(null);
          }
          if (paramAnonymousu.position != ImagePreviewUI.k(ImagePreviewUI.this).intValue())
          {
            AppMethodBeat.o(111580);
            return;
          }
          if (TextUtils.isEmpty(paramAnonymousu.HIQ.oTL))
          {
            paramAnonymousu = ImagePreviewUI.this.getString(b.i.gallery_pic_video_not_support_desc);
            ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
            ImagePreviewUI.F(ImagePreviewUI.this).setText(paramAnonymousu);
            ImagePreviewUI.s(ImagePreviewUI.this).setEnabled(false);
            ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(false);
            ImagePreviewUI.s(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(b.b.white_text_color_disabled));
            if (ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) {
              ImagePreviewUI.this.enableOptionMenu(false);
            }
            AppMethodBeat.o(111580);
            return;
          }
          Object localObject;
          if ((paramAnonymousu.HIQ.oTN >= ImagePreviewUI.G(ImagePreviewUI.this)) || ((paramAnonymousu.HIQ.oTN > 0) && (paramAnonymousu.HIQ.oTN < ImagePreviewUI.H(ImagePreviewUI.this))))
          {
            ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
            localObject = ImagePreviewUI.F(ImagePreviewUI.this);
            if (paramAnonymousu.HIQ.oTN >= ImagePreviewUI.G(ImagePreviewUI.this))
            {
              paramAnonymousu = ImagePreviewUI.I(ImagePreviewUI.this);
              ((TextView)localObject).setText(paramAnonymousu);
              ImagePreviewUI.s(ImagePreviewUI.this).setEnabled(false);
              ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(false);
              ImagePreviewUI.s(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(b.b.white_text_color_disabled));
              if (ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) {
                ImagePreviewUI.this.enableOptionMenu(false);
              }
              label335:
              if ((com.tencent.mm.modelvideo.ab.bOG()) && (ImagePreviewUI.f(ImagePreviewUI.this) == 3) && (ImagePreviewUI.b(ImagePreviewUI.this)) && (y.bEl(paramMediaItem.Gcc) > com.tencent.mm.plugin.gallery.b.h.aRj()))
              {
                boolean bool = ImagePreviewUI.K(ImagePreviewUI.this).contains(paramMediaItem);
                ImagePreviewUI.s(ImagePreviewUI.this).setEnabled(bool);
                ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(bool);
                paramAnonymousu = ImagePreviewUI.s(ImagePreviewUI.this);
                localObject = ImagePreviewUI.this.getResources();
                if (!bool) {
                  break label561;
                }
              }
            }
          }
          label561:
          for (int i = b.b.white_text_color;; i = b.b.white_text_color_disabled)
          {
            paramAnonymousu.setTextColor(((Resources)localObject).getColor(i));
            ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(8);
            if (ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) {
              ImagePreviewUI.this.enableOptionMenu(false);
            }
            AppMethodBeat.o(111580);
            return;
            paramAnonymousu = ImagePreviewUI.J(ImagePreviewUI.this);
            break;
            ImagePreviewUI.s(ImagePreviewUI.this).setEnabled(true);
            ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(true);
            ImagePreviewUI.s(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(b.b.white_text_color));
            ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(8);
            break label335;
          }
        }
      });
      if (paramMediaItem.equals(this.HPp.getTag()))
      {
        Log.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { this.path });
        AppMethodBeat.o(111612);
        return;
      }
      this.HPp.setTag(paramMediaItem);
      com.tencent.threadpool.h.ahAA.bm(paramMediaItem);
      label859:
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      this.HPc.setEnabled(true);
      this.HPa.setEnabled(true);
      this.HPc.setTextColor(getResources().getColor(b.b.white_text_color));
      if ((this.wQK) && (this.HOS.contains(paramMediaItem.Gcc)) && (y.bEl(paramMediaItem.Gcc) > 26214400L))
      {
        this.HPn.setVisibility(0);
        this.HPm.setText(getString(b.i.gallery_select_image_to_big));
        if ((!com.tencent.mm.modelvideo.ab.bOG()) || (!this.wQK) || (this.HPh != 3)) {
          break label1303;
        }
        if (y.bEl(paramMediaItem.Gcc) <= 26214400L) {
          break label1116;
        }
        bool = this.HOT.contains(paramMediaItem);
        this.HPc.setEnabled(bool);
        this.HPa.setEnabled(bool);
        paramMediaItem = this.HPc;
        localObject1 = getResources();
        if (!bool) {
          break label1109;
        }
        i = b.b.white_text_color;
        label1056:
        paramMediaItem.setTextColor(((Resources)localObject1).getColor(i));
        if (this.HOS.size() == 0) {
          enableOptionMenu(false);
        }
      }
      for (;;)
      {
        this.HPn.setVisibility(8);
        AppMethodBeat.o(111612);
        return;
        this.HPn.setVisibility(8);
        break;
        label1109:
        i = b.b.white_text_color_disabled;
        break label1056;
        label1116:
        this.HPc.setEnabled(true);
        this.HPa.setEnabled(true);
        this.HPc.setTextColor(getResources().getColor(b.b.white_text_color));
      }
    }
    else if ((paramMediaItem.getType() == 1) && (paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      localObject1 = new com.tencent.mm.plugin.gif.f(paramMediaItem.Gcc);
      long l = y.bEl(paramMediaItem.Gcc);
      try
      {
        if (((!this.HOS.contains(paramMediaItem.Gcc)) || (l == 0L) || (l <= com.tencent.mm.plugin.gallery.b.h.aRi())) && (localObject1.JgK[0] <= com.tencent.mm.plugin.gallery.b.h.aRh()) && (localObject1.JgK[1] <= com.tencent.mm.plugin.gallery.b.h.aRh())) {
          break label1310;
        }
        this.HPc.setTextColor(getResources().getColor(b.b.white_text_color_disabled));
        this.HPc.setEnabled(false);
        this.HPa.setEnabled(false);
        AppMethodBeat.o(111612);
        return;
      }
      catch (Exception paramMediaItem)
      {
        Log.e("MicroMsg.ImagePreviewUI", Util.stackTraceToString(paramMediaItem));
      }
    }
    label1303:
    AppMethodBeat.o(111612);
    return;
    label1310:
    this.HPc.setTextColor(getResources().getColor(b.b.white_text_color));
    this.HPc.setEnabled(true);
    this.HPa.setEnabled(true);
    AppMethodBeat.o(111612);
  }
  
  private void l(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(289621);
    if (paramMediaItem == null)
    {
      AppMethodBeat.o(289621);
      return;
    }
    String str = this.xiR.format(new Date(paramMediaItem.HHK));
    if (2 == paramMediaItem.getType()) {}
    for (paramMediaItem = com.tencent.mm.cd.a.bt(this, b.i.gallery_select_video_postion) + str;; paramMediaItem = com.tencent.mm.cd.a.bt(this, b.i.gallery_select_pic_postion) + str)
    {
      this.HOP.setContentDescription(paramMediaItem);
      AppMethodBeat.o(289621);
      return;
    }
  }
  
  private void vY(boolean paramBoolean)
  {
    AppMethodBeat.i(289581);
    if ((this.HOT == null) || (!com.tencent.mm.modelvideo.ab.bOG()) || (this.HPh != 3) || (!this.wQK))
    {
      enableOptionMenu(true);
      AppMethodBeat.o(289581);
      return;
    }
    Iterator localIterator = this.HOT.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      long l = y.bEl(localMediaItem.Gcc);
      if ((localMediaItem.getType() == 2) && (l > com.tencent.mm.plugin.gallery.b.h.aRj()))
      {
        enableOptionMenu(false);
        if (paramBoolean) {
          aEV(getString(b.i.gallery_album_can_not_send_too_large_video, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(com.tencent.mm.plugin.gallery.b.h.aRj()) }));
        }
        AppMethodBeat.o(289581);
        return;
      }
      if ((localMediaItem.getType() == 1) && (l > 26214400L))
      {
        enableOptionMenu(false);
        if (paramBoolean) {
          aEV(getString(b.i.gallery_album_can_not_send_too_large_pic, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(26214400L) }));
        }
        AppMethodBeat.o(289581);
        return;
      }
    }
    AppMethodBeat.o(289581);
  }
  
  private void vZ(boolean paramBoolean)
  {
    AppMethodBeat.i(111603);
    if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 4)
    {
      AppMethodBeat.o(111603);
      return;
    }
    if (this.HOO == null)
    {
      Log.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
      AppMethodBeat.o(111603);
      return;
    }
    final GalleryItem.MediaItem localMediaItem = this.HOO.WP(this.HOU.intValue());
    if ((paramBoolean) && (localMediaItem != null))
    {
      this.HPn.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111578);
          ImagePreviewUI.a(ImagePreviewUI.this, localMediaItem);
          AppMethodBeat.o(111578);
        }
      }, 400L);
      AppMethodBeat.o(111603);
      return;
    }
    this.HPn.setVisibility(8);
    AppMethodBeat.o(111603);
  }
  
  private void wa(boolean paramBoolean)
  {
    AppMethodBeat.i(111604);
    Log.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + paramBoolean + "], selectedNormalFooter = " + this.HPf);
    if (this.HPf)
    {
      localObject = findViewById(b.e.cropimage_operator_ll);
      if (localObject != null) {
        break label136;
      }
      if (!this.HPf) {
        break label129;
      }
    }
    label129:
    for (Object localObject = "normal";; localObject = "edit_tips")
    {
      Log.w("MicroMsg.ImagePreviewUI", "set footer[%s] visibility[%B], but footerbar null", new Object[] { localObject, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(111604);
      return;
      localObject = findViewById(b.e.gallery_edit_layout);
      if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB != 15) {
        break;
      }
      AppMethodBeat.o(111604);
      return;
    }
    label136:
    if (((paramBoolean) && (((View)localObject).getVisibility() == 0)) || ((!paramBoolean) && (((View)localObject).getVisibility() == 8)))
    {
      AppMethodBeat.o(111604);
      return;
    }
    boolean bool = paramBoolean;
    if (this.HOY)
    {
      bool = paramBoolean;
      if (!this.HPf)
      {
        Log.i("MicroMsg.ImagePreviewUI", "setFooterVisibility hideVideoEditButton");
        bool = false;
      }
    }
    if (bool)
    {
      ((View)localObject).setVisibility(0);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, b.a.fast_faded_in));
    }
    while ((bool) && (this.HOQ.getVisibility() == 8) && (this.HOS.size() > 0) && (26 != com.tencent.mm.plugin.gallery.model.e.fAn().sfB))
    {
      this.HOQ.setVisibility(0);
      localObject = AnimationUtils.loadAnimation(this, b.a.fast_faded_in);
      this.HOQ.startAnimation((Animation)localObject);
      AppMethodBeat.o(111604);
      return;
      ((View)localObject).setVisibility(8);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, b.a.fast_faded_out));
    }
    if ((!bool) && (this.HOQ.getVisibility() == 0))
    {
      this.HOQ.setVisibility(8);
      localObject = AnimationUtils.loadAnimation(this, b.a.fast_faded_out);
      this.HOQ.startAnimation((Animation)localObject);
    }
    AppMethodBeat.o(111604);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(111596);
    if (com.tencent.mm.compatible.e.b.df(this))
    {
      setContentView(paramView);
      AppMethodBeat.o(111596);
      return;
    }
    aw.y(aw.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(111596);
  }
  
  public final String fBH()
  {
    AppMethodBeat.i(111601);
    switch (com.tencent.mm.plugin.gallery.model.e.fAn().sfB)
    {
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 12: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 23: 
    case 27: 
    case 30: 
    case 31: 
    case 32: 
    default: 
      if ((this.HOS.size() == 0) || (this.GzH <= 1))
      {
        str = getString(b.i.app_send);
        AppMethodBeat.o(111601);
        return str;
      }
      break;
    case 4: 
    case 8: 
    case 13: 
    case 14: 
    case 22: 
    case 29: 
      if ((this.HPq) && (com.tencent.mm.plugin.gallery.b.h.aN(this.HOT)))
      {
        str = getString(b.i.gallery_pic_video_generate_video) + "(" + this.HOS.size() + "/" + this.GzH + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.HOS.size() == 0) || (this.GzH <= 1))
      {
        str = getString(b.i.gallery_pic_timeline_send);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(b.i.gallery_pic_timeline_send) + "(" + this.HOS.size() + "/" + this.GzH + ")";
      AppMethodBeat.o(111601);
      return str;
    case 11: 
    case 24: 
      str = getString(b.i.emoji_store_use);
      AppMethodBeat.o(111601);
      return str;
    case 7: 
    case 15: 
    case 16: 
    case 25: 
    case 26: 
    case 28: 
      if (((!Util.isNullOrNil(this.HLD)) && (this.HLD.equals("album_business_bubble_media_by_coordinate"))) || (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 25))
      {
        if ((this.HOS.size() == 0) || (this.GzH <= 1))
        {
          str = getString(b.i.app_nextstep);
          AppMethodBeat.o(111601);
          return str;
        }
        str = getString(b.i.app_nextstep) + "(" + this.HOS.size() + "/" + this.GzH + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.HOS.size() == 0) || (this.GzH <= 1))
      {
        str = getString(b.i.gallery_pic_timeline_send);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(b.i.gallery_pic_timeline_send) + "(" + this.HOS.size() + "/" + this.GzH + ")";
      AppMethodBeat.o(111601);
      return str;
    case 33: 
      str = getString(b.i.gallery_pic_timeline_send);
      AppMethodBeat.o(111601);
      return str;
    }
    String str = getString(b.i.gallery_pic_chatting_send, new Object[] { Integer.valueOf(this.HOS.size()), Integer.valueOf(this.GzH) });
    AppMethodBeat.o(111601);
    return str;
  }
  
  public final void fBJ()
  {
    AppMethodBeat.i(289972);
    if (this.HOY)
    {
      Log.i("MicroMsg.ImagePreviewUI", "hideVideoEditUI");
      this.HPk.setVisibility(8);
      this.HPo.setVisibility(8);
      this.HPl.setVisibility(8);
      this.HOW.setVisibility(4);
      this.HPd.setVisibility(0);
      this.HOV.setVisibility(4);
      this.HMn.setVisibility(4);
      this.HMo.setVisibility(4);
    }
    AppMethodBeat.o(289972);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.f.image_gallery_plugin;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111597);
    setActionbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
    setNavigationbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
    this.HPk = ((TextView)findViewById(b.e.gallery_edit_tv));
    this.HPl = ((TextView)findViewById(b.e.gallery_edit_tv_des));
    this.HPm = ((TextView)findViewById(b.e.item_legal_tip));
    this.HPn = findViewById(b.e.item_legal_tip_layout);
    this.HPn.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111575);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)ImagePreviewUI.a(ImagePreviewUI.this).getLayoutParams();
        localMarginLayoutParams.topMargin = ((int)(j.getStatusHeight(ImagePreviewUI.this) + ImagePreviewUI.this.getResources().getDimension(b.c.DefaultActionbarHeightPort)));
        ImagePreviewUI.a(ImagePreviewUI.this).setLayoutParams(localMarginLayoutParams);
        AppMethodBeat.o(111575);
      }
    }, 100L);
    this.HPo = ((TextView)findViewById(b.e.gallery_edit_tv_btn));
    this.HPp = ((ProgressBar)findViewById(b.e.video_edit_progressbar));
    this.GzH = getIntent().getIntExtra("max_select_count", 9);
    this.HPi = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
    Object localObject1;
    boolean bool2;
    if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 4)
    {
      bool1 = true;
      this.HMv = bool1;
      localObject1 = getIntent();
      this.HOR = ((Intent)localObject1).getStringArrayListExtra("preview_image_list");
      this.HOT = ((Intent)localObject1).getParcelableArrayListExtra("preview_media_item_list");
      this.mediaType = ((Intent)localObject1).getIntExtra("media_type", this.mediaType);
      this.HOS = new ArrayList();
      this.HOZ = ((Intent)localObject1).getFloatExtra("key_support_max_ratio", 0.0F);
      if (this.HOR != null) {
        this.HOS.addAll(this.HOR);
      }
      this.HLA = com.tencent.mm.plugin.gallery.model.e.fAp();
      bool2 = ((Intent)localObject1).getBooleanExtra("preview_all", false);
      if (this.HLA != null) {
        break label454;
      }
    }
    label454:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.ImagePreviewUI", "preview all[%B] mediaitems is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (this.HLA != null))
      {
        this.HNW = true;
        this.HOU = Integer.valueOf(((Intent)localObject1).getIntExtra("preview_position", 0));
        Log.i("MicroMsg.ImagePreviewUI", "start position=%d", new Object[] { this.HOU });
        if (this.HOU.intValue() >= 0) {}
      }
      else
      {
        this.HOU = Integer.valueOf(0);
      }
      com.tencent.mm.plugin.gallery.model.e.Ww(this.HOU.intValue());
      if ((this.HNW) || ((this.HOS != null) && (this.HOS.size() != 0))) {
        break label459;
      }
      Log.e("MicroMsg.ImagePreviewUI", "not preview all items and image paths is null or empty");
      finish();
      AppMethodBeat.o(111597);
      return;
      bool1 = false;
      break;
    }
    label459:
    this.HOV = ((ImageButton)findViewById(b.e.original_image));
    this.HMn = ((TextView)findViewById(b.e.original_image_tip));
    this.HMo = ((TextView)findViewById(b.e.original_image_size));
    this.HOW = ((TextView)findViewById(b.e.video_edit_button));
    this.wQK = ((Intent)localObject1).getBooleanExtra("send_raw_img", false);
    this.HMw = ((Intent)localObject1).getBooleanExtra("key_force_hide_edit_image_button", false);
    this.HMy = ((Intent)localObject1).getBooleanExtra("key_force_show_raw_image_button", false);
    this.HMz = ((Intent)localObject1).getBooleanExtra("key_is_raw_image_button_disable", false);
    this.HPh = ((Intent)localObject1).getIntExtra("query_source_type", 0);
    this.HOY = ((Intent)localObject1).getBooleanExtra("key_force_hide_edit_video_button", false);
    this.HPq = com.tencent.mm.plugin.gallery.b.h.fBV();
    Log.i("MicroMsg.ImagePreviewUI", "initView, enableVLog:%s", new Object[] { Boolean.valueOf(this.HPq) });
    Object localObject2;
    int i;
    if (this.wQK)
    {
      this.HOV.setImageResource(b.h.radio_on);
      this.HOV.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_select_desc));
      if ((com.tencent.mm.modelvideo.ab.bOG()) && (this.HPh == 3) && (this.wQK))
      {
        localObject2 = fBu();
        TextView localTextView = this.HMo;
        if (Util.isNullOrNil((String)localObject2))
        {
          i = 8;
          localTextView.setVisibility(i);
          this.HMo.setText(getString(b.i.gallery_album_summary_item_size_tips, new Object[] { localObject2 }));
          label730:
          if (this.HMz) {
            this.HOV.setImageResource(b.h.radio_default_on);
          }
          localObject2 = this.HOV;
          if (this.HMz) {
            break label1927;
          }
          bool1 = true;
          label762:
          ((ImageButton)localObject2).setEnabled(bool1);
          localObject2 = this.HMn;
          if (this.HMz) {
            break label1932;
          }
          bool1 = true;
          label783:
          ((TextView)localObject2).setEnabled(bool1);
          if ((this.HOS != null) && (this.HOS.size() == 1))
          {
            localObject2 = (String)this.HOS.get(0);
            if (((String)localObject2).endsWith(".jpg")) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  boolean bool1 = true;
                  AppMethodBeat.i(111569);
                  try
                  {
                    String str1 = this.val$path;
                    String str2 = ImagePreviewUI.this.getIntent().getStringExtra("GalleryUI_ToUser");
                    if (ImagePreviewUI.o(ImagePreviewUI.this)) {}
                    for (;;)
                    {
                      com.tencent.mm.plugin.gallery.b.h.b(str1, str2, bool1, true);
                      AppMethodBeat.o(111569);
                      return;
                      boolean bool2 = ImagePreviewUI.b(ImagePreviewUI.this);
                      if (bool2) {
                        bool1 = false;
                      }
                    }
                    return;
                  }
                  catch (Exception localException)
                  {
                    AppMethodBeat.o(111569);
                  }
                }
              });
            }
          }
          this.HMn.setText(getContext().getString(b.i.gallery_pic_original));
          this.HOV.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(111583);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              paramAnonymousView = ImagePreviewUI.this;
              boolean bool;
              int i;
              if (!ImagePreviewUI.b(ImagePreviewUI.this))
              {
                bool = true;
                ImagePreviewUI.b(paramAnonymousView, bool);
                if (!ImagePreviewUI.b(ImagePreviewUI.this)) {
                  break label376;
                }
                ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(b.h.radio_on);
                ImagePreviewUI.c(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_select_desc));
                if ((ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) && (!com.tencent.mm.modelvideo.ab.bOG())) {
                  ImagePreviewUI.e(ImagePreviewUI.this).performClick();
                }
                if ((!com.tencent.mm.modelvideo.ab.bOG()) || (ImagePreviewUI.f(ImagePreviewUI.this) != 3) || (!ImagePreviewUI.b(ImagePreviewUI.this))) {
                  break label361;
                }
                ImagePreviewUI.c(ImagePreviewUI.this, true);
                ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.g(ImagePreviewUI.this));
                paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this);
                localObject = ImagePreviewUI.i(ImagePreviewUI.this);
                if (!Util.isNullOrNil(paramAnonymousView)) {
                  break label356;
                }
                i = 8;
                label213:
                ((TextView)localObject).setVisibility(i);
                ImagePreviewUI.i(ImagePreviewUI.this).setText(ImagePreviewUI.this.getString(b.i.gallery_album_summary_item_size_tips, new Object[] { paramAnonymousView }));
              }
              for (;;)
              {
                ImagePreviewUI.j(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(b.i.gallery_pic_original));
                ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.k(ImagePreviewUI.this).intValue());
                if ((com.tencent.mm.modelvideo.ab.bOG()) && (ImagePreviewUI.f(ImagePreviewUI.this) == 3))
                {
                  paramAnonymousView = (g)ImagePreviewUI.l(ImagePreviewUI.this).getAdapter();
                  if (paramAnonymousView != null) {
                    paramAnonymousView.wb(ImagePreviewUI.b(ImagePreviewUI.this));
                  }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111583);
                return;
                bool = false;
                break;
                label356:
                i = 0;
                break label213;
                label361:
                ImagePreviewUI.i(ImagePreviewUI.this).setVisibility(8);
                continue;
                label376:
                ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(b.h.radio_off);
                ImagePreviewUI.c(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
                ImagePreviewUI.i(ImagePreviewUI.this).setVisibility(8);
                ImagePreviewUI.this.enableOptionMenu(true);
              }
            }
          });
          this.HOW.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(111584);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              paramAnonymousView = ImagePreviewUI.m(ImagePreviewUI.this).getItem(ImagePreviewUI.k(ImagePreviewUI.this).intValue());
              if (Util.isNullOrNil(paramAnonymousView))
              {
                Log.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.k(ImagePreviewUI.this) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111584);
                return;
              }
              Log.i("MicroMsg.ImagePreviewUI", "editVideoMaxTimeLength : %d", new Object[] { Integer.valueOf(ImagePreviewUI.n(ImagePreviewUI.this)) });
              localObject = new StringBuilder();
              v.bOg();
              localObject = v.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis() + ".mp4";
              StringBuilder localStringBuilder = new StringBuilder();
              v.bOg();
              paramAnonymousView = RecordConfigProvider.aM(paramAnonymousView, (String)localObject, v.getAccVideoPath() + "/vsg_thumb_" + System.currentTimeMillis() + ".jpg");
              paramAnonymousView.oXZ = com.tencent.mm.modelcontrol.e.bIg().bIk();
              paramAnonymousView.NHZ = (ImagePreviewUI.n(ImagePreviewUI.this) * 1000);
              if (ImagePreviewUI.o(ImagePreviewUI.this)) {}
              for (paramAnonymousView.scene = 2;; paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.fAn().sfB)
              {
                localObject = new UICustomParam.a();
                ((UICustomParam.a)localObject).aQw();
                ((UICustomParam.a)localObject).aQv();
                ((UICustomParam.a)localObject).eL(true);
                paramAnonymousView.NHR = ((UICustomParam.a)localObject).lZB;
                localObject = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, b.a.sight_slide_bottom_in, -1, paramAnonymousView, 2, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111584);
                return;
              }
            }
          });
          this.HPo.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(111585);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              paramAnonymousView = ImagePreviewUI.m(ImagePreviewUI.this).getItem(ImagePreviewUI.k(ImagePreviewUI.this).intValue());
              if (Util.isNullOrNil(paramAnonymousView))
              {
                Log.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.k(ImagePreviewUI.this) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111585);
                return;
              }
              localObject = new StringBuilder();
              v.bOg();
              localObject = v.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis() + ".mp4";
              StringBuilder localStringBuilder = new StringBuilder();
              v.bOg();
              paramAnonymousView = RecordConfigProvider.aM(paramAnonymousView, (String)localObject, v.getAccVideoPath() + "/vsg_thumb_" + System.currentTimeMillis() + ".jpg");
              paramAnonymousView.NHZ = (ImagePreviewUI.n(ImagePreviewUI.this) * 1000);
              paramAnonymousView.oXZ = com.tencent.mm.modelcontrol.e.bIg().bIk();
              if (ImagePreviewUI.o(ImagePreviewUI.this)) {}
              for (paramAnonymousView.scene = 2;; paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.fAn().sfB)
              {
                localObject = new UICustomParam.a();
                ((UICustomParam.a)localObject).aQw();
                ((UICustomParam.a)localObject).aQv();
                ((UICustomParam.a)localObject).eL(true);
                paramAnonymousView.NHR = ((UICustomParam.a)localObject).lZB;
                localObject = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, b.a.sight_slide_bottom_in, -1, paramAnonymousView, 2, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111585);
                return;
              }
            }
          });
          this.HMn.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(111586);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              ImagePreviewUI.c(ImagePreviewUI.this).performClick();
              if (ImagePreviewUI.b(ImagePreviewUI.this)) {
                ImagePreviewUI.j(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_select_desc));
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111586);
                return;
                ImagePreviewUI.j(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
              }
            }
          });
          setBackBtn(new ImagePreviewUI.24(this));
          this.HLD = ((Intent)localObject1).getStringExtra("album_business_tag");
          this.qqa = ((Intent)localObject1).getIntExtra("album_video_max_duration", 10);
          this.HMI = ((Intent)localObject1).getIntExtra("album_video_min_duration", 0);
          localObject1 = y.b.adEV;
          switch (com.tencent.mm.plugin.gallery.model.e.fAn().sfB)
          {
          default: 
            label1016:
            addTextOptionMenu(0, fBH(), new MenuItem.OnMenuItemClickListener()
            {
              public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
              {
                int j = 0;
                AppMethodBeat.i(111590);
                if (ImagePreviewUI.f(ImagePreviewUI.this) == 6)
                {
                  ImagePreviewUI.this.setResult(1);
                  paramAnonymousMenuItem = ImagePreviewUI.m(ImagePreviewUI.this).getItem(ImagePreviewUI.k(ImagePreviewUI.this).intValue());
                  if (!Util.isNullOrNil(paramAnonymousMenuItem)) {
                    a.a.HFE.au(paramAnonymousMenuItem, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.k(ImagePreviewUI.this).intValue());
                  }
                  ImagePreviewUI.this.finish();
                }
                paramAnonymousMenuItem = new Intent();
                paramAnonymousMenuItem.putExtra("isPreviewPhoto", ImagePreviewUI.this.getIntent().getBooleanExtra("isPreviewPhoto", false));
                Object localObject = ImagePreviewUI.q(ImagePreviewUI.this);
                int i;
                if ((localObject != null) && (((ArrayList)localObject).size() == 0))
                {
                  localObject = ImagePreviewUI.m(ImagePreviewUI.this).WP(ImagePreviewUI.k(ImagePreviewUI.this).intValue());
                  if ((ImagePreviewUI.o(ImagePreviewUI.this)) && (ImagePreviewUI.m(ImagePreviewUI.this) != null) && (localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 2))
                  {
                    ImagePreviewUI.a(ImagePreviewUI.this, ((GalleryItem.MediaItem)localObject).Gcc);
                    localObject = ImagePreviewUI.m(ImagePreviewUI.this).getItem(ImagePreviewUI.k(ImagePreviewUI.this).intValue());
                    if (!Util.isNullOrNil((String)localObject)) {
                      a.a.HFE.au((String)localObject, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.k(ImagePreviewUI.this).intValue());
                    }
                    i = 0;
                  }
                }
                for (;;)
                {
                  if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 25)
                  {
                    paramAnonymousMenuItem.putStringArrayListExtra("preview_image_list", ImagePreviewUI.q(ImagePreviewUI.this));
                    ImagePreviewUI.this.setResult(25, paramAnonymousMenuItem);
                    ImagePreviewUI.this.finish();
                  }
                  if (!ImagePreviewUI.b(ImagePreviewUI.this)) {}
                  final boolean bool2;
                  for (final boolean bool1 = true;; bool1 = false)
                  {
                    bool2 = ImagePreviewUI.o(ImagePreviewUI.this);
                    if (i != 0) {
                      break label384;
                    }
                    ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousMenuItem, bool2, bool1);
                    AppMethodBeat.o(111590);
                    return true;
                    ImagePreviewUI.e(ImagePreviewUI.this).performClick();
                    i = 300;
                    break;
                  }
                  label384:
                  localObject = com.tencent.mm.plugin.gallery.model.e.fAo();
                  paramAnonymousMenuItem = new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(111588);
                      ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousMenuItem, bool2, bool1);
                      AppMethodBeat.o(111588);
                    }
                    
                    public final String toString()
                    {
                      AppMethodBeat.i(111589);
                      String str = super.toString() + "|addTextOptionMenu";
                      AppMethodBeat.o(111589);
                      return str;
                    }
                  };
                  if (i < 0) {
                    i = j;
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.gallery.model.g)localObject).fAG().postDelayed(paramAnonymousMenuItem, i);
                    AppMethodBeat.o(111590);
                    return true;
                  }
                  i = 0;
                }
              }
            }, null, (y.b)localObject1);
            if (26 == com.tencent.mm.plugin.gallery.model.e.fAn().sfB) {
              removeOptionMenu(0);
            }
            this.HPa = ((ImageButton)findViewById(b.e.photos_select_checkbox));
            this.HPa.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(111591);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                localObject = ImagePreviewUI.m(ImagePreviewUI.this).getItem(ImagePreviewUI.k(ImagePreviewUI.this).intValue());
                if ((Util.isNullOrNil((String)localObject)) || (!paramAnonymousView.isEnabled()))
                {
                  Log.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.k(ImagePreviewUI.this) });
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(111591);
                  return;
                }
                ImagePreviewUI.a(ImagePreviewUI.this, (String)localObject);
                ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.k(ImagePreviewUI.this).intValue());
                ImagePreviewUI.j(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(b.i.gallery_pic_original));
                ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.g(ImagePreviewUI.this));
                a.a.HFE.au((String)localObject, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.k(ImagePreviewUI.this).intValue());
                int i;
                if ((com.tencent.mm.modelvideo.ab.bOG()) && (ImagePreviewUI.f(ImagePreviewUI.this) == 3) && (ImagePreviewUI.b(ImagePreviewUI.this)))
                {
                  paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this);
                  localObject = ImagePreviewUI.i(ImagePreviewUI.this);
                  if (Util.isNullOrNil(paramAnonymousView))
                  {
                    i = 8;
                    ((TextView)localObject).setVisibility(i);
                    ImagePreviewUI.i(ImagePreviewUI.this).setText(ImagePreviewUI.this.getString(b.i.gallery_album_summary_item_size_tips, new Object[] { paramAnonymousView }));
                  }
                }
                for (;;)
                {
                  ImagePreviewUI.c(ImagePreviewUI.this, false);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(111591);
                  return;
                  i = 0;
                  break;
                  ImagePreviewUI.i(ImagePreviewUI.this).setVisibility(8);
                }
              }
            });
            this.HPc = ((TextView)findViewById(b.e.photos_select_tv));
            this.HPc.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(111560);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                ImagePreviewUI.e(ImagePreviewUI.this).performClick();
                if (ImagePreviewUI.r(ImagePreviewUI.this)) {
                  ImagePreviewUI.s(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_select_desc));
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(111560);
                  return;
                  ImagePreviewUI.s(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
                }
              }
            });
            if (this.GzH == 1)
            {
              this.HPa.setVisibility(8);
              this.HPc.setVisibility(8);
            }
            this.HPd = ((ViewGroup)findViewById(b.e.cropimage_operator_ll));
            this.HPe = ((ViewGroup)findViewById(b.e.gallery_edit_layout));
            if (this.HPd != null)
            {
              this.HPd.setVisibility(8);
              this.HPd.setOnClickListener(new ImagePreviewUI.3(this));
            }
            if (this.HPe != null)
            {
              this.HPe.setVisibility(8);
              this.HPe.setOnClickListener(new ImagePreviewUI.4(this));
            }
            this.HPj = ((TextView)findViewById(b.e.photo_edit_button));
            this.HPj.setOnClickListener(new ImagePreviewUI.5(this));
            this.HOQ = ((RecyclerView)findViewById(b.e.image_preview_recycler_view));
            this.HOQ.getItemAnimator().bZK = 66L;
            this.HOQ.a(new RecyclerView.h()
            {
              public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
              {
                AppMethodBeat.i(289491);
                int i = (int)MMApplicationContext.getContext().getResources().getDimension(b.c.LargePadding);
                paramAnonymousRect.left = (i / 2);
                paramAnonymousRect.bottom = i;
                paramAnonymousRect.top = i;
                paramAnonymousRect.right = (i / 2);
                AppMethodBeat.o(289491);
              }
            });
            localObject1 = new SpeedyLinearLayoutManager();
            ((SpeedyLinearLayoutManager)localObject1).setOrientation(0);
            this.HOQ.setLayoutManager((RecyclerView.LayoutManager)localObject1);
            i = getResources().getDisplayMetrics().widthPixels / 7;
            localObject1 = new g(this, this.HOS, i, this.HNW, this.HPh);
            ((g)localObject1).wb(this.wQK);
            this.HOQ.setAdapter((RecyclerView.a)localObject1);
            this.HOQ.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111565);
                int i = (int)MMApplicationContext.getContext().getResources().getDimension(b.c.LargePadding);
                int j = ImagePreviewUI.this.getResources().getDisplayMetrics().widthPixels / 7;
                ImagePreviewUI.l(ImagePreviewUI.this).getLayoutParams().height = (i * 2 + j);
                RecyclerView localRecyclerView = ImagePreviewUI.l(ImagePreviewUI.this);
                com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(ImagePreviewUI.k(ImagePreviewUI.this).intValue(), new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$15", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                localRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$15", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                AppMethodBeat.o(111565);
              }
            });
            if ((this.HOS.size() > 0) && (26 != com.tencent.mm.plugin.gallery.model.e.fAn().sfB))
            {
              this.HOQ.setVisibility(0);
              label1422:
              this.HOQ.setItemAnimator(new androidx.recyclerview.widget.f());
              ((g)localObject1).HPR.a(this.HOQ);
              ((g)localObject1).HPN = new g.b()
              {
                public final void WS(int paramAnonymousInt)
                {
                  AppMethodBeat.i(111566);
                  Log.i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(ImagePreviewUI.u(ImagePreviewUI.this)) });
                  ((g)ImagePreviewUI.l(ImagePreviewUI.this).getAdapter()).jb(paramAnonymousInt, paramAnonymousInt);
                  ImagePreviewUI.v(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt, false);
                  if (!ImagePreviewUI.u(ImagePreviewUI.this))
                  {
                    com.tencent.mm.plugin.gallery.model.e.HGV = true;
                    AppMethodBeat.o(111566);
                    return;
                  }
                  com.tencent.mm.plugin.gallery.model.e.HGT = true;
                  AppMethodBeat.o(111566);
                }
                
                public final void aJ(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
                {
                  AppMethodBeat.i(111568);
                  Log.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), ImagePreviewUI.k(ImagePreviewUI.this) });
                  if (!ImagePreviewUI.u(ImagePreviewUI.this))
                  {
                    com.tencent.mm.plugin.gallery.b.h.m(ImagePreviewUI.w(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
                    d locald = ImagePreviewUI.m(ImagePreviewUI.this);
                    int i = ImagePreviewUI.k(ImagePreviewUI.this).intValue();
                    Log.i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt3) });
                    if (!locald.HNW)
                    {
                      com.tencent.mm.plugin.gallery.b.h.m(locald.HNV, paramAnonymousInt1, paramAnonymousInt2);
                      locald.ieV = paramAnonymousInt3;
                      locald.HNY = ((View)locald.adVc.get(i));
                      locald.adVa.remove(locald.HNY);
                      locald.adVb.clear();
                      locald.adVc.clear();
                      locald.HNZ = true;
                      locald.notifyDataSetChanged();
                    }
                    ImagePreviewUI.v(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt3, false);
                    ((g)ImagePreviewUI.l(ImagePreviewUI.this).getAdapter()).jb(paramAnonymousInt3, paramAnonymousInt3);
                    com.tencent.mm.plugin.gallery.model.e.HGU = true;
                    AppMethodBeat.o(111568);
                    return;
                  }
                  com.tencent.mm.plugin.gallery.b.h.m(ImagePreviewUI.d(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
                  com.tencent.mm.plugin.gallery.model.e.HGS = true;
                  AppMethodBeat.o(111568);
                }
                
                public final void ja(int paramAnonymousInt1, int paramAnonymousInt2)
                {
                  AppMethodBeat.i(111567);
                  Log.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ImagePreviewUI.k(ImagePreviewUI.this) });
                  AppMethodBeat.o(111567);
                }
              };
              this.HOP = ((MMViewPager)findViewById(b.e.gallery));
              this.HOP.setVerticalFadingEdgeEnabled(false);
              this.HOP.setHorizontalFadingEdgeEnabled(false);
              this.HOP.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
              {
                public final void onPageScrollStateChanged(int paramAnonymousInt)
                {
                  AppMethodBeat.i(111574);
                  if (ImagePreviewUI.m(ImagePreviewUI.this) != null) {
                    ImagePreviewUI.m(ImagePreviewUI.this).HOc.onPageScrollStateChanged(paramAnonymousInt);
                  }
                  AppMethodBeat.o(111574);
                }
                
                public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
                
                public final void onPageSelected(int paramAnonymousInt)
                {
                  boolean bool2 = true;
                  AppMethodBeat.i(111573);
                  com.tencent.mm.plugin.gallery.model.e.Ww(paramAnonymousInt);
                  String str = ImagePreviewUI.m(ImagePreviewUI.this).getItem(paramAnonymousInt);
                  ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousInt, str);
                  boolean bool1 = ImagePreviewUI.d(ImagePreviewUI.this).contains(str);
                  ImagePreviewUI.a(ImagePreviewUI.this, Integer.valueOf(paramAnonymousInt));
                  Object localObject = ImagePreviewUI.e(ImagePreviewUI.this);
                  int i;
                  if (bool1)
                  {
                    i = ImagePreviewUI.fBM();
                    ((ImageButton)localObject).setImageResource(i);
                    ImageButton localImageButton = ImagePreviewUI.e(ImagePreviewUI.this);
                    if (!bool1) {
                      break label404;
                    }
                    localObject = ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_choosed_desc);
                    label111:
                    localImageButton.setContentDescription((CharSequence)localObject);
                    if (!ImagePreviewUI.b(ImagePreviewUI.this)) {
                      break label422;
                    }
                    ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(b.h.radio_on);
                    ImagePreviewUI.c(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_select_desc));
                    label164:
                    if (ImagePreviewUI.x(ImagePreviewUI.this)) {
                      ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(b.h.radio_default_on);
                    }
                    localObject = ImagePreviewUI.c(ImagePreviewUI.this);
                    if (ImagePreviewUI.x(ImagePreviewUI.this)) {
                      break label461;
                    }
                    bool1 = true;
                    label208:
                    ((ImageButton)localObject).setEnabled(bool1);
                    localObject = ImagePreviewUI.j(ImagePreviewUI.this);
                    if (ImagePreviewUI.x(ImagePreviewUI.this)) {
                      break label466;
                    }
                  }
                  label404:
                  label422:
                  label461:
                  label466:
                  for (bool1 = bool2;; bool1 = false)
                  {
                    ((TextView)localObject).setEnabled(bool1);
                    ImagePreviewUI.this.setMMTitle(paramAnonymousInt + 1 + "/" + ImagePreviewUI.m(ImagePreviewUI.this).getCount());
                    ImagePreviewUI.m(ImagePreviewUI.this).HOb.onPageSelected(paramAnonymousInt);
                    Log.d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = ".concat(String.valueOf(paramAnonymousInt)));
                    localObject = com.tencent.mm.plugin.gallery.model.e.aEQ(str);
                    if ((ImagePreviewUI.y(ImagePreviewUI.this).getVisibility() == 0) || (ImagePreviewUI.z(ImagePreviewUI.this).getVisibility() == 0))
                    {
                      ImagePreviewUI.a(ImagePreviewUI.this, str, (GalleryItem.MediaItem)localObject);
                      ImagePreviewUI.c(ImagePreviewUI.this, false);
                      ImagePreviewUI.a(ImagePreviewUI.this, (GalleryItem.MediaItem)localObject);
                    }
                    ImagePreviewUI.b(ImagePreviewUI.this, (GalleryItem.MediaItem)localObject);
                    ImagePreviewUI.m(ImagePreviewUI.this).stopAll();
                    AppMethodBeat.o(111573);
                    return;
                    i = b.h.radio_off;
                    break;
                    localObject = ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unchoosed_desc);
                    break label111;
                    ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(b.h.radio_off);
                    ImagePreviewUI.c(ImagePreviewUI.this).setContentDescription(ImagePreviewUI.this.getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
                    break label164;
                    bool1 = false;
                    break label208;
                  }
                }
              });
              this.HOP.setSingleClickOverListener(new MMViewPager.f()
              {
                public final void fBN() {}
                
                public final void singleClickOver()
                {
                  AppMethodBeat.i(111576);
                  ImagePreviewUI.A(ImagePreviewUI.this);
                  AppMethodBeat.o(111576);
                }
              });
              this.HOO = new d(this);
              ((g)this.HOQ.getAdapter()).HPK = this.HOO;
              if (this.HNW) {
                break label1973;
              }
              this.HOO.aM(this.HOR);
              this.HOO.HNW = false;
              if (this.HOR.size() <= 0) {
                break label2082;
              }
              localObject1 = (String)this.HOR.get(this.HOU.intValue());
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      this.HOP.setAdapter(this.HOO);
      this.HOP.setCurrentItem(this.HOU.intValue());
      this.HOO.dIY = this.HOU.intValue();
      i = fBI().indexOf(this.HOO.getItem(this.HOU.intValue()));
      ((g)this.HOQ.getAdapter()).jb(i, this.HOU.intValue());
      localObject2 = com.tencent.mm.plugin.gallery.model.e.aEQ((String)localObject1);
      a((String)localObject1, (GalleryItem.MediaItem)localObject2);
      k((GalleryItem.MediaItem)localObject2);
      l((GalleryItem.MediaItem)localObject2);
      setMMTitle(this.HOU.intValue() + 1 + "/" + this.HOO.getCount());
      if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 25)
      {
        ((ViewGroup)this.HOQ.getParent()).removeView(this.HOQ);
        this.HOQ.setVisibility(8);
        findViewById(b.e.orignal_image_layout).setVisibility(4);
        findViewById(b.e.gallery_edit_tv_des).setVisibility(4);
        findViewById(b.e.photo_edit_button).setVisibility(4);
        findViewById(b.e.gallery_edit_tv).setVisibility(4);
        findViewById(b.e.video_edit_button).setVisibility(4);
        findViewById(b.e.gallery_edit_tv_btn).setVisibility(4);
      }
      vY(false);
      AppMethodBeat.o(111597);
      return;
      i = 0;
      break;
      this.HMo.setVisibility(8);
      break label730;
      this.HOV.setImageResource(b.h.radio_off);
      this.HOV.setContentDescription(getResources().getString(b.i.gallery_album_btn_org_unselect_desc));
      this.HMo.setVisibility(8);
      break label730;
      label1927:
      bool1 = false;
      break label762;
      label1932:
      bool1 = false;
      break label783;
      localObject1 = y.b.adET;
      break label1016;
      localObject1 = y.b.adEU;
      break label1016;
      localObject1 = y.b.adEZ;
      break label1016;
      this.HOQ.setVisibility(8);
      break label1422;
      label1973:
      localObject1 = this.HOO;
      localObject2 = this.HLA;
      ((d)localObject1).HLA.clear();
      ((d)localObject1).HLA.addAll((Collection)localObject2);
      ((d)localObject1).reset();
      ((d)localObject1).notifyDataSetChanged();
      this.HOO.HNW = true;
      if (this.HOU.intValue() >= this.HLA.size()) {
        this.HOU = Integer.valueOf(0);
      }
      if (this.HLA.size() > 0) {
        localObject1 = ((GalleryItem.MediaItem)this.HLA.get(this.HOU.intValue())).Gcc;
      } else {
        label2082:
        localObject1 = "";
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    AppMethodBeat.i(111599);
    Log.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
    if (paramInt1 == 4371) {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    Object localObject;
    while (paramInt1 == 4372) {
      if ((paramIntent == null) || (this.HOQ == null))
      {
        AppMethodBeat.o(111599);
        return;
        if (this.HOS.size() > 0)
        {
          aEZ((String)this.HOS.get(0));
        }
        else
        {
          Log.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[] { Integer.valueOf(this.HOS.size()) });
          continue;
          if (paramInt1 == 4370)
          {
            if (paramInt2 == -1)
            {
              localObject = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
              paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).videoPath);
              paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).thumbPath);
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject).gHE().J("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
              setResult(-1, paramIntent);
            }
            if (paramIntent != null)
            {
              setResult(-1, paramIntent.putExtra("GalleryUI_IsSendImgBackground", true));
              finish();
            }
          }
        }
      }
      else
      {
        CaptureDataManager.CaptureVideoNormalModel localCaptureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList4 = ((g)this.HOQ.getAdapter()).HPM;
        ArrayList localArrayList3 = this.HOS;
        this.HPu = (this.HPu + localCaptureVideoNormalModel.gHE().J("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)) + ";");
        paramInt1 = 0;
        int i;
        String str;
        for (;;)
        {
          i = j;
          if (localArrayList4 == null) {
            break;
          }
          i = j;
          if (paramInt1 >= localArrayList4.size()) {
            break;
          }
          str = (String)localArrayList4.get(paramInt1);
          if (!str.equalsIgnoreCase(Util.nullAsNil(this.path)))
          {
            localObject = str;
            if (!str.equalsIgnoreCase(Util.nullAsNil(this.HPt))) {}
          }
          else
          {
            localObject = localCaptureVideoNormalModel.thumbPath;
          }
          localArrayList1.add(localObject);
          paramInt1 += 1;
        }
        while ((localArrayList3 != null) && (i < localArrayList3.size()))
        {
          str = (String)localArrayList3.get(i);
          if (!str.equalsIgnoreCase(Util.nullAsNil(this.path)))
          {
            localObject = str;
            if (!str.equalsIgnoreCase(Util.nullAsNil(this.HPt))) {}
          }
          else
          {
            localObject = localCaptureVideoNormalModel.thumbPath;
          }
          localArrayList2.add(localObject);
          i += 1;
        }
        y.deleteFile(this.HPt);
        paramIntent.putExtra("max_select_count", 9);
        paramIntent.putExtra("isPreviewPhoto", true);
        paramIntent.putExtra("raw_photo_path", this.path);
        paramIntent.putExtra("after_photo_edit", localCaptureVideoNormalModel.thumbPath);
        paramIntent.putStringArrayListExtra("preview_image_list", localArrayList1);
        paramIntent.putStringArrayListExtra("preview_select_image_list", localArrayList2);
        localObject = new Bundle();
        ((Bundle)localObject).putString("raw_photo_path", this.path);
        ((Bundle)localObject).putString("after_photo_edit", localCaptureVideoNormalModel.thumbPath);
        paramIntent.putExtra("report_info", (Bundle)localObject);
        h(paramInt2, paramIntent);
        AppMethodBeat.o(111599);
        return;
      }
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
          localObject = new VideoCaptureReportInfo();
          ((VideoCaptureReportInfo)localObject).ybL = 1;
          paramIntent.NIi = ((VideoCaptureReportInfo)localObject);
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).aQw();
          ((UICustomParam.a)localObject).aQv();
          ((UICustomParam.a)localObject).eL(true);
          paramIntent.NHR = ((UICustomParam.a)localObject).lZB;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4370, b.a.sight_slide_bottom_in, -1, paramIntent, 4, 0);
          AppMethodBeat.o(111599);
          return;
        }
        if (22 == com.tencent.mm.plugin.gallery.model.e.fAn().sfB)
        {
          setResult(-1, paramIntent);
          finish();
          AppMethodBeat.o(111599);
        }
      }
      else
      {
        Toast.makeText(this, b.i.loading_failed, 1).show();
        AppMethodBeat.o(111599);
      }
    }
    else if (paramIntent != null)
    {
      setResult(-1, paramIntent.putExtra("GalleryUI_IsSendImgBackground", true));
      finish();
    }
    AppMethodBeat.o(111599);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111593);
    final long l = Util.currentTicks();
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    aw.bW(this);
    new MMHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111559);
        ImagePreviewUI.a(ImagePreviewUI.this, true);
        Log.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(111559);
      }
    });
    Log.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    paramBundle = com.tencent.mm.plugin.gallery.a.c.HFY;
    if (com.tencent.mm.plugin.gallery.a.c.isEnable())
    {
      paramBundle = com.tencent.mm.plugin.gallery.a.c.HFY;
      Log.i("MicroMsg.MJTemplateHandle", "[" + paramBundle.hashCode() + " bindPreviewUI:" + Integer.valueOf(hashCode()) + ']');
      com.tencent.mm.plugin.gallery.a.c.HGc = new WeakReference(this);
      com.tencent.mm.plugin.gallery.a.c.HGa = new com.tencent.mm.plugin.gallery.a.d(com.tencent.mm.plugin.gallery.a.c.HGc);
    }
    initView();
    AppMethodBeat.o(111593);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111607);
    super.onDestroy();
    Log.i("MicroMsg.ImagePreviewUI", "onDestroy, %s.", new Object[] { this });
    if ((com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 3) && (getIntent().getBooleanExtra("preview_image", false)) && (getIntent().getIntExtra("max_select_count", 0) == 1))
    {
      Log.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
      com.tencent.mm.plugin.gallery.model.e.fAq().clear();
    }
    if (this.HOO != null) {
      this.HOO.release();
    }
    com.tencent.mm.plugin.gallery.model.e.aJ(null);
    ac.hdY.aAA().aAz();
    if (this.HPs != null) {
      com.tencent.mm.plugin.gallery.model.e.fAm().b(this.HPs);
    }
    com.tencent.mm.plugin.gallery.a.c localc = com.tencent.mm.plugin.gallery.a.c.HFY;
    com.tencent.mm.plugin.gallery.a.c.fzM();
    AppMethodBeat.o(111607);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111606);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(111606);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(111606);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(111595);
    if (this.HOX != null) {
      this.HOX.stopTimer();
    }
    this.HOO.stopAll();
    super.onPause();
    AppMethodBeat.o(111595);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111594);
    super.onResume();
    com.tencent.mm.plugin.comm.b.e.xfd.a("SnsPublishProcess", "mediaPreviewPagetimes", Integer.valueOf(1), com.tencent.mm.plugin.comm.b.c.xeT);
    AppMethodBeat.o(111594);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */