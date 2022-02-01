package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.b;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.d.b;
import com.tencent.mm.plugin.gallery.model.t;
import com.tencent.mm.plugin.gallery.model.t.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.f;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

@com.tencent.mm.ui.base.a(19)
@TargetApi(16)
public class ImagePreviewUI
  extends MMActivity
{
  private int kyt;
  private int mediaType;
  private String path;
  private boolean qoL;
  private int wnd;
  private TextView xnV;
  private ArrayList<GalleryItem.MediaItem> xno;
  private String xnr;
  private HashMap<String, Integer> xoA;
  private HashSet<String> xoB;
  private boolean xob;
  private boolean xoc;
  private boolean xoe;
  private boolean xof;
  private long xol;
  private int xoo;
  private boolean xpA;
  private MTimerHandler xqA;
  private float xqB;
  private ImageButton xqC;
  private TextView xqD;
  private ViewGroup xqE;
  private ViewGroup xqF;
  private boolean xqG;
  private boolean xqH;
  private int xqI;
  private int xqJ;
  private TextView xqK;
  private TextView xqL;
  private TextView xqM;
  private TextView xqN;
  private View xqO;
  private TextView xqP;
  private ProgressBar xqQ;
  private boolean xqR;
  boolean xqS;
  private d.b xqT;
  private String xqU;
  private String xqV;
  private int xqW;
  private String xqX;
  private int xqY;
  private String xqZ;
  private d xqr;
  private MMViewPager xqs;
  private RecyclerView xqt;
  private ArrayList<String> xqu;
  private ArrayList<String> xqv;
  private ArrayList<GalleryItem.MediaItem> xqw;
  private Integer xqx;
  private ImageButton xqy;
  private TextView xqz;
  
  public ImagePreviewUI()
  {
    AppMethodBeat.i(111592);
    this.xqB = 0.0F;
    this.xqG = true;
    this.xqH = true;
    this.xob = true;
    this.xqI = 0;
    this.xol = 0L;
    this.xqJ = 10;
    this.xqR = false;
    this.mediaType = 0;
    this.xqS = false;
    this.xqT = null;
    this.xqV = "";
    this.xoA = new HashMap();
    this.xqW = 300000;
    this.xqY = 1000;
    AppMethodBeat.o(111592);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111608);
    boolean bool;
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || ((com.tencent.mm.plugin.gallery.model.e.dQK().mcq != 4) && (com.tencent.mm.plugin.gallery.model.e.dQK().mcq != 14) && (com.tencent.mm.plugin.gallery.model.e.dQK().mcq != 13)))
    {
      this.xqG = true;
      this.xqE.setVisibility(0);
      this.xqF.setVisibility(8);
      this.xqQ.setVisibility(8);
      a(paramString, paramMediaItem, false);
      azd(paramString);
      enableOptionMenu(true);
      this.xqz.setVisibility(8);
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
        this.xqK.setVisibility(0);
      }
      for (;;)
      {
        if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 15) {
          this.xqK.setVisibility(8);
        }
        if (this.xoc) {
          this.xqK.setVisibility(8);
        }
        aza(paramString);
        AppMethodBeat.o(111608);
        return;
        bool = getIntent().getBooleanExtra("preview_image", false);
        Log.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.dQK().mcq), Boolean.valueOf(bool), paramString });
        if ((paramMediaItem == null) && (!Util.isNullOrNil(paramString))) {
          this.xqK.setVisibility(0);
        } else {
          this.xqK.setVisibility(8);
        }
      }
    }
    if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
      this.xqK.setVisibility(0);
    }
    final GalleryItem.VideoMediaItem localVideoMediaItem;
    for (;;)
    {
      if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 25) {
        this.xqK.setVisibility(8);
      }
      aza(paramString);
      localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
      enableOptionMenu(false);
      this.xqG = false;
      this.xqE.setVisibility(8);
      this.xqF.setVisibility(0);
      this.xqP.setVisibility(8);
      if (!azb(paramString)) {
        break;
      }
      AppMethodBeat.o(111608);
      return;
      this.xqK.setVisibility(8);
    }
    if (!Util.isNullOrNil(localVideoMediaItem.jkQ))
    {
      Log.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.xiW, Integer.valueOf(localVideoMediaItem.jkS), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
      bool = a(paramString, localVideoMediaItem, this.xqR);
      a(this.xqR, bool, localVideoMediaItem);
      AppMethodBeat.o(111608);
      return;
    }
    enableOptionMenu(false);
    this.xqG = true;
    this.xqE.setVisibility(0);
    this.xqF.setVisibility(8);
    this.xqz.setVisibility(8);
    a(paramString, paramMediaItem, false);
    azd(paramString);
    paramMediaItem = new t(paramString, this.xqx.intValue(), localVideoMediaItem, new t.a()
    {
      public final void a(t paramAnonymoust)
      {
        AppMethodBeat.i(111579);
        if (paramAnonymoust.equals(ImagePreviewUI.y(ImagePreviewUI.this).getTag())) {
          ImagePreviewUI.y(ImagePreviewUI.this).setTag(null);
        }
        if (paramAnonymoust.position != ImagePreviewUI.g(ImagePreviewUI.this).intValue())
        {
          AppMethodBeat.o(111579);
          return;
        }
        boolean bool = ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymoust.path, paramAnonymoust.xjZ, ImagePreviewUI.z(ImagePreviewUI.this));
        ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.z(ImagePreviewUI.this), bool, localVideoMediaItem);
        AppMethodBeat.o(111579);
      }
    });
    if (paramMediaItem.equals(this.xqQ.getTag()))
    {
      Log.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { paramString });
      AppMethodBeat.o(111608);
      return;
    }
    this.xqQ.setTag(paramMediaItem);
    com.tencent.f.h.RTc.aX(paramMediaItem);
    if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 15) {
      this.xqK.setVisibility(8);
    }
    if (this.xoc) {
      this.xqK.setVisibility(8);
    }
    AppMethodBeat.o(111608);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111619);
    int i = com.tencent.mm.plugin.gallery.model.e.dQK().xjo;
    int j = com.tencent.mm.plugin.gallery.model.e.dQK().mcq;
    if ((j != 16) && ((i == 2) || (i == 3)))
    {
      i = 1;
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 2) && (j == 4) && (!paramBoolean) && (i == 0)) {
        break label167;
      }
      if (this.wnd != 1) {
        break label131;
      }
      this.xqC.setVisibility(8);
      this.xqD.setVisibility(8);
    }
    for (;;)
    {
      if (this.xqv.contains(paramString)) {
        break label150;
      }
      this.xqC.setImageResource(2131691379);
      AppMethodBeat.o(111619);
      return;
      i = 0;
      break;
      label131:
      this.xqC.setVisibility(0);
      this.xqD.setVisibility(0);
    }
    label150:
    this.xqC.setImageResource(dSo());
    AppMethodBeat.o(111619);
    return;
    label167:
    this.xqC.setVisibility(8);
    this.xqD.setVisibility(8);
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
    if ((paramBoolean1) && (com.tencent.mm.plugin.gallery.a.d.at(this.xqw)))
    {
      this.xqP.setVisibility(8);
      this.xqz.setVisibility(8);
      this.xqF.setVisibility(8);
      enableOptionMenu(true);
      a(this.path, paramMediaItem, paramBoolean1);
    }
    AppMethodBeat.o(111609);
  }
  
  private boolean a(GalleryItem.VideoMediaItem paramVideoMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(257754);
    Log.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[] { paramVideoMediaItem });
    int i;
    if (paramVideoMediaItem != null) {
      if (("video/hevc".equalsIgnoreCase(paramVideoMediaItem.jkQ)) && (com.tencent.mm.plugin.n.f.ejb())) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((paramVideoMediaItem == null) || (Util.isNullOrNil(paramVideoMediaItem.xiW)) || (azc(paramVideoMediaItem.xiW)) || (i == 0) || ((!Util.isNullOrNil(paramVideoMediaItem.jkR)) && (!"audio/mp4a-latm".equalsIgnoreCase(paramVideoMediaItem.jkR))) || ((paramBoolean) && (r.Ql(paramVideoMediaItem.xiW))))
      {
        if (paramVideoMediaItem == null) {}
        for (paramVideoMediaItem = null;; paramVideoMediaItem = paramVideoMediaItem.jkQ)
        {
          Log.i("MicroMsg.ImagePreviewUI", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramVideoMediaItem });
          dSn();
          AppMethodBeat.o(257754);
          return true;
          if (!"video/avc".equalsIgnoreCase(paramVideoMediaItem.jkQ)) {
            break label182;
          }
          i = 1;
          break;
        }
      }
      AppMethodBeat.o(257754);
      return false;
      label182:
      i = 0;
    }
  }
  
  private boolean a(String paramString, GalleryItem.VideoMediaItem paramVideoMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111611);
    enableOptionMenu(false);
    this.xqG = false;
    this.xqE.setVisibility(8);
    this.xqF.setVisibility(0);
    this.xqP.setVisibility(8);
    if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 13)
    {
      this.xqF.setVisibility(8);
      this.xqE.setVisibility(8);
      this.xqL.setVisibility(8);
      this.xqM.setVisibility(8);
      enableOptionMenu(true);
      AppMethodBeat.o(111611);
      return true;
    }
    if (c(paramVideoMediaItem))
    {
      AppMethodBeat.o(111611);
      return false;
    }
    if (a(paramVideoMediaItem, false))
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
    this.xqG = true;
    this.xqE.setVisibility(0);
    this.xqF.setVisibility(8);
    this.xqz.setVisibility(0);
    this.xqQ.setVisibility(8);
    a(paramString, paramVideoMediaItem, false);
    azd(paramString);
    AppMethodBeat.o(111611);
    return true;
  }
  
  private void ayZ(String paramString)
  {
    AppMethodBeat.i(111598);
    Object localObject1;
    Object localObject2;
    int i;
    int j;
    if (!this.xqv.contains(paramString))
    {
      localObject1 = com.tencent.mm.plugin.gallery.model.e.ayS(paramString);
      if (this.xqv.size() >= this.wnd)
      {
        if ((this.mediaType == 2) || ((!Util.isNullOrNil(this.xnr)) && (this.xnr.equals("album_business_bubble_media_by_coordinate")))) {
          paramString = getResources().getQuantityString(2131623951, this.wnd, new Object[] { Integer.valueOf(this.wnd) });
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.cD(getContext(), paramString);
          this.xqC.setImageResource(2131691379);
          if (!Util.isNullOrNil(this.xqv)) {
            break;
          }
          AppMethodBeat.o(111598);
          return;
          if (this.mediaType == 1) {
            paramString = getResources().getQuantityString(2131623952, this.wnd, new Object[] { Integer.valueOf(this.wnd) });
          } else {
            paramString = getResources().getQuantityString(2131623950, this.wnd, new Object[] { Integer.valueOf(this.wnd) });
          }
        }
      }
      if (!(localObject1 instanceof GalleryItem.ImageMediaItem)) {
        break label1110;
      }
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(((GalleryItem.MediaItem)localObject1).xiW, (BitmapFactory.Options)localObject2);
      i = ((BitmapFactory.Options)localObject2).outWidth;
      j = ((BitmapFactory.Options)localObject2).outHeight;
    }
    for (;;)
    {
      if ((localObject1 instanceof GalleryItem.VideoMediaItem))
      {
        localObject2 = (GalleryItem.VideoMediaItem)localObject1;
        i = ((GalleryItem.VideoMediaItem)localObject2).videoWidth;
        j = ((GalleryItem.VideoMediaItem)localObject2).videoHeight;
      }
      if (this.xqB != 0.0F) {
        if ((i == 0) || (j == 0))
        {
          i = 0;
          label300:
          if (i != 0) {
            break label410;
          }
          paramString = null;
          if (!(localObject1 instanceof GalleryItem.ImageMediaItem)) {
            break label388;
          }
          paramString = getResources().getString(2131761135);
        }
      }
      for (;;)
      {
        if (paramString != null) {
          com.tencent.mm.ui.base.h.cD(getContext(), paramString);
        }
        this.xqC.setImageResource(2131691379);
        break;
        float f = i / j;
        if ((f > this.xqB) || (f < 1.0F / this.xqB))
        {
          i = 0;
          break label300;
        }
        i = 1;
        break label300;
        label388:
        if ((localObject1 instanceof GalleryItem.VideoMediaItem)) {
          paramString = getResources().getString(2131761138);
        }
      }
      label410:
      label805:
      Object localObject3;
      if (localObject1 != null)
      {
        if ((((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().amz(paramString)))
        {
          com.tencent.mm.ui.base.h.cD(this, getString(2131761128));
          AppMethodBeat.o(111598);
          return;
        }
        if ((((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")) && (!Util.isNullOrNil(this.xnr)) && (this.xnr.equals("album_business_byp")))
        {
          if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().amA(((GalleryItem.MediaItem)localObject1).xiW))
          {
            com.tencent.mm.ui.base.h.cD(this, getString(2131761097));
            AppMethodBeat.o(111598);
          }
        }
        else if ((localObject1 instanceof GalleryItem.VideoMediaItem)) {
          if ((!Util.isNullOrNil(this.xnr)) && (this.xnr.equals("album_business_bubble_media_by_coordinate")))
          {
            if (((GalleryItem.VideoMediaItem)localObject1).jkS >= this.kyt * 1000 + 500)
            {
              com.tencent.mm.ui.base.h.cD(getContext(), getContext().getResources().getString(2131761152, new Object[] { Integer.valueOf(this.kyt) }));
              AppMethodBeat.o(111598);
            }
          }
          else if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 25)
          {
            if (((GalleryItem.VideoMediaItem)localObject1).jkS > this.kyt * 1000 + 500)
            {
              com.tencent.mm.ui.base.h.cD(getContext(), getContext().getResources().getString(2131761152, new Object[] { Integer.valueOf(this.kyt) }));
              AppMethodBeat.o(111598);
              return;
            }
            if (((GalleryItem.VideoMediaItem)localObject1).jkS < this.xoo * 1000)
            {
              com.tencent.mm.ui.base.h.cD(getContext(), getContext().getResources().getString(2131761151, new Object[] { Integer.valueOf(this.xoo) }));
              AppMethodBeat.o(111598);
              return;
            }
          }
        }
        if (this.xqw != null)
        {
          localObject2 = this.xqw.iterator();
          i = 0;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
            if ((localObject3 == null) || (!((GalleryItem.MediaItem)localObject3).xiW.equalsIgnoreCase(((GalleryItem.MediaItem)localObject1).xiW))) {
              break label1107;
            }
            i = 1;
          }
        }
      }
      label949:
      label1104:
      label1107:
      for (;;)
      {
        break label805;
        if (i == 0) {
          this.xqw.add(localObject1);
        }
        this.xqv.add(paramString);
        this.xqC.setImageResource(dSo());
        c(this.xqv.size(), this.xqx.intValue(), paramString, 0);
        break;
        this.xqC.setImageResource(2131691379);
        while (this.xqv.remove(paramString)) {}
        if (this.xqw != null)
        {
          localObject1 = null;
          localObject3 = this.xqw.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject2 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
            if ((localObject2 == null) || (!((GalleryItem.MediaItem)localObject2).xiW.equalsIgnoreCase(paramString))) {
              break label1104;
            }
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          break label949;
          if (localObject1 != null)
          {
            Log.i("MicroMsg.ImagePreviewUI", "unselect item: %s", new Object[] { ((GalleryItem.MediaItem)localObject1).xiW });
            this.xqw.remove(localObject1);
          }
          c(this.xqv.size(), this.xqx.intValue(), paramString, 1);
          break;
          paramString = this.xqv.iterator();
          while (paramString.hasNext()) {
            if (!ImgUtil.isGif((String)paramString.next()))
            {
              AppMethodBeat.o(111598);
              return;
            }
          }
          this.qoL = true;
          AppMethodBeat.o(111598);
          return;
        }
      }
      label1110:
      j = 0;
      i = 0;
    }
  }
  
  private void aza(String paramString)
  {
    AppMethodBeat.i(111610);
    if ((this.xqv.size() >= 9) && (!this.xqv.contains(paramString)))
    {
      this.xqK.setTextColor(getContext().getResources().getColor(2131101428));
      this.xqK.setEnabled(false);
      AppMethodBeat.o(111610);
      return;
    }
    this.xqK.setEnabled(true);
    this.xqK.setTextColor(getContext().getResources().getColor(2131101427));
    AppMethodBeat.o(111610);
  }
  
  private boolean azb(String paramString)
  {
    AppMethodBeat.i(111613);
    if (s.boW(paramString) > 1073741824L)
    {
      this.xqL.setText(getString(2131761121));
      this.xqM.setText(getString(2131761120));
      AppMethodBeat.o(111613);
      return true;
    }
    AppMethodBeat.o(111613);
    return false;
  }
  
  private boolean azc(String paramString)
  {
    AppMethodBeat.i(111618);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111618);
      return true;
    }
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
    paramString = paramString.trim();
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length()))
    {
      AppMethodBeat.o(111618);
      return true;
    }
    if (!this.xoB.contains(paramString.substring(i).toLowerCase()))
    {
      AppMethodBeat.o(111618);
      return true;
    }
    AppMethodBeat.o(111618);
    return false;
  }
  
  private void azd(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(111620);
    Object localObject = Boolean.FALSE;
    Boolean localBoolean;
    GalleryItem.MediaItem localMediaItem;
    switch (com.tencent.mm.plugin.gallery.model.e.dQK().mcq)
    {
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      localBoolean = Boolean.FALSE;
      localMediaItem = com.tencent.mm.plugin.gallery.model.e.ayS(paramString);
      if ((localMediaItem != null) && (localMediaItem.getType() == 2))
      {
        localObject = Boolean.TRUE;
        i = 0;
        label115:
        if ((localMediaItem != null) || (!ImgUtil.isGif(paramString))) {
          break label207;
        }
        paramString = Boolean.TRUE;
      }
      break;
    }
    for (;;)
    {
      if (((this.xoe) && (i != 0)) || (!paramString.booleanValue())) {
        break label237;
      }
      this.xqy.setVisibility(8);
      this.xnV.setVisibility(8);
      AppMethodBeat.o(111620);
      return;
      localBoolean = Boolean.TRUE;
      break;
      if (localMediaItem != null)
      {
        localObject = localBoolean;
        if (localMediaItem.getType() == 1) {
          break label115;
        }
      }
      i = 0;
      localObject = localBoolean;
      break label115;
      label207:
      paramString = (String)localObject;
      if (localMediaItem != null)
      {
        paramString = (String)localObject;
        if (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
          paramString = Boolean.TRUE;
        }
      }
    }
    label237:
    this.xqy.setVisibility(0);
    this.xnV.setVisibility(0);
    AppMethodBeat.o(111620);
  }
  
  private boolean b(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111614);
    Log.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[] { Integer.valueOf(paramVideoMediaItem.jkS) });
    if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 13)
    {
      AppMethodBeat.o(111614);
      return false;
    }
    if (paramVideoMediaItem.jkS <= 1000)
    {
      this.xqL.setText(getString(2131761126));
      this.xqM.setText(getString(2131761125));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.jkS >= 300000)
    {
      this.xqL.setText(getString(2131761124));
      this.xqM.setText(getString(2131761123));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.jkS >= this.xqJ * 1000 + 500)
    {
      this.xqL.setText(getString(2131761108));
      this.xqM.setText(getString(2131761107, new Object[] { Integer.valueOf(this.xqJ) }));
      this.xqP.setVisibility(0);
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
    if ((-1 != paramInt2) && (!this.xpA))
    {
      this.xqt.getAdapter().b(paramInt2, Integer.valueOf(paramInt2));
      if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq != 13) {
        break label356;
      }
      paramInt2 = 1;
      label72:
      paramString = this.xqr.NS(this.xqx.intValue());
      if ((paramInt1 != 0) && (((!this.xob) || (this.xqR)) && ((paramInt2 == 0) || (this.xqr == null) || (paramString == null) || (paramString.getType() != 2)))) {
        break label361;
      }
    }
    label356:
    label361:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label366;
      }
      this.xqt.setVisibility(8);
      AppMethodBeat.o(111621);
      return;
      if (-1 == paramInt2) {
        break;
      }
      if ((paramInt3 == 0) && (paramInt1 > 0))
      {
        ((g)this.xqt.getAdapter()).aze(paramString);
        ((g)this.xqt.getAdapter()).gJ(paramInt1 - 1, this.xqx.intValue());
        this.xqt.getAdapter().cj(paramInt1 - 1);
        paramString = this.xqt;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt1 - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramString, locala.axQ(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramString.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        break;
      }
      if (paramInt3 != 1) {
        break;
      }
      paramInt2 = ((g)this.xqt.getAdapter()).indexOf(paramString);
      if (-1 == paramInt2) {
        break;
      }
      ((g)this.xqt.getAdapter()).remove(paramInt2);
      this.xqt.getAdapter().ck(paramInt2);
      break;
      paramInt2 = 0;
      break label72;
    }
    label366:
    this.xqt.setVisibility(0);
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
      this.xqL.setText(getString(2131761118));
      this.xqM.setText(getString(2131761119));
      AppMethodBeat.o(111616);
      return true;
    }
    AppMethodBeat.o(111616);
    return false;
  }
  
  private String dSl()
  {
    AppMethodBeat.i(111601);
    switch (com.tencent.mm.plugin.gallery.model.e.dQK().mcq)
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
    default: 
      if ((this.xqv.size() == 0) || (this.wnd <= 1))
      {
        str = getString(2131755976);
        AppMethodBeat.o(111601);
        return str;
      }
      break;
    case 4: 
    case 8: 
    case 13: 
    case 14: 
    case 22: 
      if ((this.xqR) && (com.tencent.mm.plugin.gallery.a.d.at(this.xqw)))
      {
        str = getString(2131761115) + "(" + this.xqv.size() + "/" + this.wnd + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.xqv.size() == 0) || (this.wnd <= 1))
      {
        str = getString(2131761112);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(2131761112) + "(" + this.xqv.size() + "/" + this.wnd + ")";
      AppMethodBeat.o(111601);
      return str;
    case 11: 
    case 24: 
      str = getString(2131758681);
      AppMethodBeat.o(111601);
      return str;
    case 7: 
    case 15: 
    case 16: 
    case 25: 
      if (((!Util.isNullOrNil(this.xnr)) && (this.xnr.equals("album_business_bubble_media_by_coordinate"))) || (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 25))
      {
        if ((this.xqv.size() == 0) || (this.wnd <= 1))
        {
          str = getString(2131755916);
          AppMethodBeat.o(111601);
          return str;
        }
        str = getString(2131755916) + "(" + this.xqv.size() + "/" + this.wnd + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.xqv.size() == 0) || (this.wnd <= 1))
      {
        str = getString(2131761112);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(2131761112) + "(" + this.xqv.size() + "/" + this.wnd + ")";
      AppMethodBeat.o(111601);
      return str;
    }
    String str = getString(2131761102, new Object[] { Integer.valueOf(this.xqv.size()), Integer.valueOf(this.wnd) });
    AppMethodBeat.o(111601);
    return str;
  }
  
  private ArrayList<String> dSm()
  {
    AppMethodBeat.i(111602);
    if (this.xpA)
    {
      localArrayList = this.xqv;
      AppMethodBeat.o(111602);
      return localArrayList;
    }
    if (this.xqv != null)
    {
      localArrayList = new ArrayList(this.xqv.size());
      Iterator localIterator = this.xqu.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.xqv.contains(str)) {
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
  
  private boolean dSn()
  {
    AppMethodBeat.i(111615);
    this.xqL.setText(getString(2131761116));
    this.xqM.setText(getString(2131761117));
    AppMethodBeat.o(111615);
    return true;
  }
  
  private static int dSo()
  {
    AppMethodBeat.i(111622);
    if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 15)
    {
      AppMethodBeat.o(111622);
      return 2131689953;
    }
    if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 25)
    {
      AppMethodBeat.o(111622);
      return 2131689958;
    }
    AppMethodBeat.o(111622);
    return 2131689962;
  }
  
  private void e(int paramInt, final Intent paramIntent)
  {
    AppMethodBeat.i(111600);
    if ((paramInt == -1) && (paramIntent != null))
    {
      this.xqS = true;
      Object localObject2 = paramIntent.getStringExtra("raw_photo_path");
      Object localObject1 = com.tencent.mm.plugin.gallery.model.e.dQO().iterator();
      while ((localObject2 != null) && (((Iterator)localObject1).hasNext())) {
        if (((String)localObject2).equals(((Bundle)((Iterator)localObject1).next()).getString("raw_photo_path"))) {
          ((Iterator)localObject1).remove();
        }
      }
      com.tencent.mm.plugin.gallery.model.e.dQO().add(paramIntent.getBundleExtra("report_info"));
      localObject1 = paramIntent.getStringExtra("after_photo_edit");
      String str = paramIntent.getStringExtra("tmp_photo_edit");
      Log.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { localObject2, localObject1 });
      if (this.xqu != null)
      {
        this.xqu.clear();
        Object localObject3 = paramIntent.getStringArrayListExtra("preview_image_list");
        if (localObject3 != null) {
          this.xqu.addAll((Collection)localObject3);
        }
        localObject3 = this.xqr.NS(this.xqx.intValue());
        if (localObject3 == null)
        {
          Log.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { this.xqx, localObject2, localObject1 });
          AppMethodBeat.o(111600);
          return;
        }
        ((GalleryItem.MediaItem)localObject3).xiX = ((String)localObject2);
        ((GalleryItem.MediaItem)localObject3).xiW = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).sUB = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).xiY = str;
        ((GalleryItem.MediaItem)localObject3).mMimeType = "edit";
        com.tencent.mm.plugin.gallery.model.e.dQN().add(localObject3);
        if (this.xqT != null) {
          com.tencent.mm.plugin.gallery.model.e.dQJ().b(this.xqT);
        }
        localObject2 = com.tencent.mm.plugin.gallery.model.e.dQJ();
        paramIntent = new d.b()
        {
          public final void ayR(final String paramAnonymousString)
          {
            AppMethodBeat.i(111571);
            new MMHandler(ImagePreviewUI.this.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111570);
                ImagePreviewUI.h(ImagePreviewUI.this).as(ImagePreviewUI.s(ImagePreviewUI.this));
                Object localObject = (g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter();
                ArrayList localArrayList = ImagePreviewUI.s(ImagePreviewUI.this);
                ((g)localObject).xrn.clear();
                ((g)localObject).xrn.addAll(localArrayList);
                ((RecyclerView.a)localObject).atj.notifyChanged();
                localObject = ImagePreviewUI.10.this.val$data.getStringArrayListExtra("preview_select_image_list");
                ImagePreviewUI.d(ImagePreviewUI.this).clear();
                if (localObject != null) {
                  ImagePreviewUI.d(ImagePreviewUI.this).addAll((Collection)localObject);
                }
                ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
                ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131761109) + ImagePreviewUI.dSp());
                if (!ImagePreviewUI.d(ImagePreviewUI.this).contains(com.tencent.mm.plugin.gallery.a.d.azi(paramAnonymousString))) {
                  ImagePreviewUI.e(ImagePreviewUI.this).performClick();
                }
                AppMethodBeat.o(111570);
              }
            });
            com.tencent.mm.plugin.gallery.model.e.dQJ().b(this);
            AppMethodBeat.o(111571);
          }
          
          public final String dQG()
          {
            AppMethodBeat.i(179472);
            String str = com.tencent.mm.plugin.gallery.a.d.a(this.xrc, null, -1);
            AppMethodBeat.o(179472);
            return str;
          }
          
          public final String toString()
          {
            AppMethodBeat.i(111572);
            String str = "fileKey:" + this.xrc + " this: " + super.toString();
            AppMethodBeat.o(111572);
            return str;
          }
        };
        this.xqT = paramIntent;
        ((com.tencent.mm.plugin.gallery.model.c)localObject2).a(paramIntent);
        com.tencent.mm.plugin.gallery.model.e.dQJ().a((String)localObject1, ((GalleryItem.MediaItem)localObject3).getType(), (String)localObject1, ((GalleryItem.MediaItem)localObject3).xiZ, ((GalleryItem.MediaItem)localObject3).xja);
        Log.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
      }
    }
    AppMethodBeat.o(111600);
  }
  
  private void goBack()
  {
    boolean bool2 = true;
    AppMethodBeat.i(111605);
    Intent localIntent = new Intent();
    boolean bool1;
    if (!this.qoL)
    {
      bool1 = true;
      if (!this.xob) {
        break label89;
      }
      bool1 = bool2;
    }
    label89:
    for (;;)
    {
      localIntent.putExtra("CropImage_Compress_Img", bool1);
      localIntent.putStringArrayListExtra("preview_image_list", dSm());
      localIntent.putExtra("show_photo_edit_tip", this.xqS);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(111605);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void j(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111612);
    if (paramMediaItem == null)
    {
      Log.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
      AppMethodBeat.o(111612);
      return;
    }
    Object localObject1;
    if (paramMediaItem.getType() == 2)
    {
      localObject1 = (GalleryItem.VideoMediaItem)paramMediaItem;
      this.xqW = 300000;
      this.xqX = getString(2131761123);
      Object localObject2;
      if (this.xqI == 3)
      {
        localObject2 = com.tencent.mm.n.a.gLV;
        this.xqW = (com.tencent.mm.n.a.apH() * 1000);
        localObject2 = com.tencent.mm.n.a.gLV;
        this.xqX = getString(2131761122, new Object[] { Integer.valueOf(com.tencent.mm.n.a.apH() / 60) });
        this.xqY = 1000;
        this.xqZ = getString(2131761125);
        if (((this.xnr != null) && ((this.xnr.equals("album_business_bubble_media_by_coordinate")) || (this.xnr.equals("album_business_bubble_media_by_jsapi_choosevideo")))) || (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 25))
        {
          this.xqW = (this.kyt * 1000 + 500);
          this.xqX = getString(2131761152, new Object[] { Integer.valueOf(this.kyt) });
          if (this.xoo != 0)
          {
            this.xqY = (this.xoo * 1000);
            this.xqZ = getString(2131761151, new Object[] { Integer.valueOf(this.xoo) });
          }
        }
        if (Util.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).jkQ)) {
          break label650;
        }
        Log.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { ((GalleryItem.VideoMediaItem)localObject1).xiW, Integer.valueOf(((GalleryItem.VideoMediaItem)localObject1).jkS), Integer.valueOf(((GalleryItem.VideoMediaItem)localObject1).videoHeight), Integer.valueOf(((GalleryItem.VideoMediaItem)localObject1).videoWidth) });
        if ((((GalleryItem.VideoMediaItem)localObject1).jkS < this.xqW) && ((((GalleryItem.VideoMediaItem)localObject1).jkS <= 0) || (((GalleryItem.VideoMediaItem)localObject1).jkS >= this.xqY))) {
          break label514;
        }
        this.xqO.setVisibility(0);
        localObject2 = this.xqN;
        if (((GalleryItem.VideoMediaItem)localObject1).jkS < this.xqW) {
          break label506;
        }
      }
      label506:
      for (paramMediaItem = this.xqX;; paramMediaItem = this.xqZ)
      {
        ((TextView)localObject2).setText(paramMediaItem);
        this.xqD.setEnabled(false);
        this.xqC.setEnabled(false);
        this.xqD.setTextColor(getResources().getColor(2131101428));
        if (this.xqv.size() != 0) {
          break label737;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(111612);
        return;
        if (this.xqI != 4) {
          break;
        }
        localObject2 = com.tencent.mm.n.a.gLV;
        this.xqW = (com.tencent.mm.n.a.apI() * 1000);
        localObject2 = com.tencent.mm.n.a.gLV;
        this.xqX = getString(2131761122, new Object[] { Integer.valueOf(com.tencent.mm.n.a.apI() / 60) });
        break;
      }
      label514:
      if (a((GalleryItem.VideoMediaItem)localObject1, true))
      {
        this.xqO.setVisibility(0);
        this.xqN.setText(getString(2131761117));
        this.xqD.setEnabled(false);
        this.xqC.setEnabled(false);
        this.xqD.setTextColor(getResources().getColor(2131101428));
        if (this.xqv.size() == 0)
        {
          enableOptionMenu(false);
          AppMethodBeat.o(111612);
        }
      }
      else
      {
        this.xqD.setEnabled(true);
        this.xqC.setEnabled(true);
        this.xqD.setTextColor(getResources().getColor(2131101427));
        this.xqO.setVisibility(8);
        AppMethodBeat.o(111612);
        return;
        label650:
        paramMediaItem = new t(paramMediaItem.xiW, this.xqx.intValue(), (GalleryItem.VideoMediaItem)localObject1, new t.a()
        {
          public final void a(t paramAnonymoust)
          {
            AppMethodBeat.i(111580);
            if (paramAnonymoust.equals(ImagePreviewUI.y(ImagePreviewUI.this).getTag())) {
              ImagePreviewUI.y(ImagePreviewUI.this).setTag(null);
            }
            if (paramAnonymoust.position != ImagePreviewUI.g(ImagePreviewUI.this).intValue())
            {
              AppMethodBeat.o(111580);
              return;
            }
            if (TextUtils.isEmpty(paramAnonymoust.xjZ.jkQ))
            {
              paramAnonymoust = ImagePreviewUI.this.getString(2131761117);
              ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
              ImagePreviewUI.A(ImagePreviewUI.this).setText(paramAnonymoust);
              ImagePreviewUI.B(ImagePreviewUI.this).setEnabled(false);
              ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(false);
              ImagePreviewUI.B(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(2131101428));
              if (ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) {
                ImagePreviewUI.this.enableOptionMenu(false);
              }
              AppMethodBeat.o(111580);
              return;
            }
            if ((paramAnonymoust.xjZ.jkS >= ImagePreviewUI.C(ImagePreviewUI.this)) || ((paramAnonymoust.xjZ.jkS > 0) && (paramAnonymoust.xjZ.jkS < ImagePreviewUI.D(ImagePreviewUI.this))))
            {
              ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
              TextView localTextView = ImagePreviewUI.A(ImagePreviewUI.this);
              if (paramAnonymoust.xjZ.jkS >= ImagePreviewUI.C(ImagePreviewUI.this)) {}
              for (paramAnonymoust = ImagePreviewUI.E(ImagePreviewUI.this);; paramAnonymoust = ImagePreviewUI.F(ImagePreviewUI.this))
              {
                localTextView.setText(paramAnonymoust);
                ImagePreviewUI.B(ImagePreviewUI.this).setEnabled(false);
                ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(false);
                ImagePreviewUI.B(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(2131101428));
                if (ImagePreviewUI.d(ImagePreviewUI.this).size() != 0) {
                  break;
                }
                ImagePreviewUI.this.enableOptionMenu(false);
                AppMethodBeat.o(111580);
                return;
              }
            }
            ImagePreviewUI.B(ImagePreviewUI.this).setEnabled(true);
            ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(true);
            ImagePreviewUI.B(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(2131101427));
            ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(8);
            AppMethodBeat.o(111580);
          }
        });
        if (paramMediaItem.equals(this.xqQ.getTag()))
        {
          Log.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { this.path });
          AppMethodBeat.o(111612);
          return;
        }
        this.xqQ.setTag(paramMediaItem);
        com.tencent.f.h.RTc.aX(paramMediaItem);
      }
      label737:
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      this.xqD.setEnabled(true);
      this.xqC.setEnabled(true);
      this.xqD.setTextColor(getResources().getColor(2131101427));
      if ((this.qoL) && (this.xqv.contains(paramMediaItem.xiW)) && (s.boW(paramMediaItem.xiW) > 26214400L))
      {
        this.xqO.setVisibility(0);
        this.xqN.setText(getString(2131761130));
        AppMethodBeat.o(111612);
        return;
      }
      this.xqO.setVisibility(8);
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      localObject1 = new com.tencent.mm.plugin.gif.f(paramMediaItem.xiW);
      long l = s.boW(paramMediaItem.xiW);
      try
      {
        if (((!this.xqv.contains(paramMediaItem.xiW)) || (l == 0L) || (l <= com.tencent.mm.plugin.gallery.a.d.aqp())) && (localObject1.ydT[0] <= com.tencent.mm.plugin.gallery.a.d.aqo()) && (localObject1.ydT[1] <= com.tencent.mm.plugin.gallery.a.d.aqo())) {
          break label1032;
        }
        this.xqD.setTextColor(getResources().getColor(2131101428));
        this.xqD.setEnabled(false);
        this.xqC.setEnabled(false);
        AppMethodBeat.o(111612);
        return;
      }
      catch (Exception paramMediaItem)
      {
        Log.e("MicroMsg.ImagePreviewUI", Util.stackTraceToString(paramMediaItem));
      }
    }
    else
    {
      AppMethodBeat.o(111612);
      return;
    }
    label1032:
    this.xqD.setTextColor(getResources().getColor(2131101427));
    this.xqD.setEnabled(true);
    this.xqC.setEnabled(true);
    AppMethodBeat.o(111612);
  }
  
  private void pE(boolean paramBoolean)
  {
    AppMethodBeat.i(111603);
    if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 4)
    {
      AppMethodBeat.o(111603);
      return;
    }
    if (this.xqr == null)
    {
      Log.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
      AppMethodBeat.o(111603);
      return;
    }
    final GalleryItem.MediaItem localMediaItem = this.xqr.NS(this.xqx.intValue());
    if ((paramBoolean) && (localMediaItem != null))
    {
      this.xqO.postDelayed(new Runnable()
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
    this.xqO.setVisibility(8);
    AppMethodBeat.o(111603);
  }
  
  private void pF(boolean paramBoolean)
  {
    AppMethodBeat.i(111604);
    Log.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + paramBoolean + "], selectedNormalFooter = " + this.xqG);
    if (this.xqG)
    {
      localObject = findViewById(2131299356);
      if (localObject != null) {
        break label134;
      }
      if (!this.xqG) {
        break label127;
      }
    }
    label127:
    for (Object localObject = "normal";; localObject = "edit_tips")
    {
      Log.w("MicroMsg.ImagePreviewUI", "set footer[%s] visibility[%B], but footerbar null", new Object[] { localObject, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(111604);
      return;
      localObject = findViewById(2131301856);
      if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq != 15) {
        break;
      }
      AppMethodBeat.o(111604);
      return;
    }
    label134:
    if (((paramBoolean) && (((View)localObject).getVisibility() == 0)) || ((!paramBoolean) && (((View)localObject).getVisibility() == 8)))
    {
      AppMethodBeat.o(111604);
      return;
    }
    if (paramBoolean)
    {
      ((View)localObject).setVisibility(0);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, 2130772059));
    }
    while ((paramBoolean) && (this.xqt.getVisibility() == 8) && (this.xqv.size() > 0))
    {
      this.xqt.setVisibility(0);
      localObject = AnimationUtils.loadAnimation(this, 2130772059);
      this.xqt.startAnimation((Animation)localObject);
      AppMethodBeat.o(111604);
      return;
      ((View)localObject).setVisibility(8);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, 2130772060));
    }
    if ((!paramBoolean) && (this.xqt.getVisibility() == 0))
    {
      this.xqt.setVisibility(8);
      localObject = AnimationUtils.loadAnimation(this, 2130772060);
      this.xqt.startAnimation((Animation)localObject);
    }
    AppMethodBeat.o(111604);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(111596);
    if (com.tencent.mm.compatible.e.b.cv(this))
    {
      setContentView(paramView);
      AppMethodBeat.o(111596);
      return;
    }
    ao.p(ao.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(111596);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495062;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111597);
    setActionbarColor(getResources().getColor(2131100500));
    setNavigationbarColor(getResources().getColor(2131100500));
    this.xqL = ((TextView)findViewById(2131301857));
    this.xqM = ((TextView)findViewById(2131301859));
    this.xqN = ((TextView)findViewById(2131302823));
    this.xqO = findViewById(2131302824);
    this.xqO.postDelayed(new ImagePreviewUI.12(this), 100L);
    this.xqP = ((TextView)findViewById(2131301858));
    this.xqQ = ((ProgressBar)findViewById(2131309758));
    this.wnd = getIntent().getIntExtra("max_select_count", 9);
    this.xqJ = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
    Object localObject1;
    boolean bool2;
    if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 4)
    {
      bool1 = true;
      this.xob = bool1;
      localObject1 = getIntent();
      this.xqu = ((Intent)localObject1).getStringArrayListExtra("preview_image_list");
      this.xqw = ((Intent)localObject1).getParcelableArrayListExtra("preview_media_item_list");
      this.mediaType = ((Intent)localObject1).getIntExtra("media_type", this.mediaType);
      this.xqv = new ArrayList();
      this.xqB = ((Intent)localObject1).getFloatExtra("key_support_max_ratio", 0.0F);
      if (this.xqu != null) {
        this.xqv.addAll(this.xqu);
      }
      this.xno = com.tencent.mm.plugin.gallery.model.e.dQM();
      bool2 = ((Intent)localObject1).getBooleanExtra("preview_all", false);
      if (this.xno != null) {
        break label451;
      }
    }
    label451:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.ImagePreviewUI", "preview all[%B] mediaitems is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (this.xno != null))
      {
        this.xpA = true;
        this.xqx = Integer.valueOf(((Intent)localObject1).getIntExtra("preview_position", 0));
        Log.i("MicroMsg.ImagePreviewUI", "start position=%d", new Object[] { this.xqx });
        if (this.xqx.intValue() >= 0) {}
      }
      else
      {
        this.xqx = Integer.valueOf(0);
      }
      com.tencent.mm.plugin.gallery.model.e.NA(this.xqx.intValue());
      if ((this.xpA) || ((this.xqv != null) && (this.xqv.size() != 0))) {
        break label456;
      }
      Log.e("MicroMsg.ImagePreviewUI", "not preview all items and image paths is null or empty");
      finish();
      AppMethodBeat.o(111597);
      return;
      bool1 = false;
      break;
    }
    label456:
    this.xqy = ((ImageButton)findViewById(2131305707));
    this.xnV = ((TextView)findViewById(2131305708));
    this.xqz = ((TextView)findViewById(2131309757));
    this.qoL = ((Intent)localObject1).getBooleanExtra("send_raw_img", false);
    this.xoc = ((Intent)localObject1).getBooleanExtra("key_force_hide_edit_image_button", false);
    this.xoe = ((Intent)localObject1).getBooleanExtra("key_force_show_raw_image_button", false);
    this.xof = ((Intent)localObject1).getBooleanExtra("key_is_raw_image_button_disable", false);
    this.xqI = ((Intent)localObject1).getIntExtra("query_source_type", 0);
    this.xqR = com.tencent.mm.plugin.gallery.a.d.dSA();
    Log.i("MicroMsg.ImagePreviewUI", "initView, enableVLog:%s", new Object[] { Boolean.valueOf(this.xqR) });
    Object localObject2;
    label641:
    label662:
    label885:
    int i;
    if (this.qoL)
    {
      this.xqy.setImageResource(2131691380);
      if (this.xof) {
        this.xqy.setImageResource(2131691377);
      }
      localObject2 = this.xqy;
      if (this.xof) {
        break label1701;
      }
      bool1 = true;
      ((ImageButton)localObject2).setEnabled(bool1);
      localObject2 = this.xnV;
      if (this.xof) {
        break label1706;
      }
      bool1 = true;
      ((TextView)localObject2).setEnabled(bool1);
      if ((this.xqv != null) && (this.xqv.size() == 1))
      {
        localObject2 = (String)this.xqv.get(0);
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
                if (ImagePreviewUI.m(ImagePreviewUI.this)) {}
                for (;;)
                {
                  com.tencent.mm.plugin.gallery.a.d.c(str1, str2, bool1, true);
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
      this.xnV.setText(getContext().getString(2131761109));
      this.xqy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111583);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = ImagePreviewUI.this;
          boolean bool;
          if (!ImagePreviewUI.b(ImagePreviewUI.this))
          {
            bool = true;
            ImagePreviewUI.b(paramAnonymousView, bool);
            if (!ImagePreviewUI.b(ImagePreviewUI.this)) {
              break label184;
            }
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691380);
            if (ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) {
              ImagePreviewUI.e(ImagePreviewUI.this).performClick();
            }
          }
          for (;;)
          {
            ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131761109) + ImagePreviewUI.dSp());
            ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111583);
            return;
            bool = false;
            break;
            label184:
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691379);
          }
        }
      });
      this.xqz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111584);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (Util.isNullOrNil(paramAnonymousView))
          {
            Log.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111584);
            return;
          }
          Log.i("MicroMsg.ImagePreviewUI", "editVideoMaxTimeLength : %d", new Object[] { Integer.valueOf(ImagePreviewUI.i(ImagePreviewUI.this)) });
          localObject = new StringBuilder();
          com.tencent.mm.modelvideo.o.bhi();
          localObject = com.tencent.mm.modelvideo.o.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis() + ".mp4";
          StringBuilder localStringBuilder = new StringBuilder();
          com.tencent.mm.modelvideo.o.bhi();
          paramAnonymousView = RecordConfigProvider.aD(paramAnonymousView, (String)localObject, com.tencent.mm.modelvideo.o.getAccVideoPath() + "/vsg_thumb_" + System.currentTimeMillis() + ".jpg");
          paramAnonymousView.BOm = com.tencent.mm.modelcontrol.e.baZ().bbc();
          paramAnonymousView.BOv = (ImagePreviewUI.i(ImagePreviewUI.this) * 1000);
          paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.dQK().mcq;
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).apE();
          ((UICustomParam.a)localObject).apD();
          ((UICustomParam.a)localObject).dz(true);
          paramAnonymousView.BOn = ((UICustomParam.a)localObject).gLU;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, 2130772161, -1, paramAnonymousView, 2, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111584);
        }
      });
      this.xqP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111585);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (Util.isNullOrNil(paramAnonymousView))
          {
            Log.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111585);
            return;
          }
          localObject = new StringBuilder();
          com.tencent.mm.modelvideo.o.bhi();
          localObject = com.tencent.mm.modelvideo.o.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis() + ".mp4";
          StringBuilder localStringBuilder = new StringBuilder();
          com.tencent.mm.modelvideo.o.bhi();
          paramAnonymousView = RecordConfigProvider.aD(paramAnonymousView, (String)localObject, com.tencent.mm.modelvideo.o.getAccVideoPath() + "/vsg_thumb_" + System.currentTimeMillis() + ".jpg");
          paramAnonymousView.BOv = (ImagePreviewUI.i(ImagePreviewUI.this) * 1000);
          paramAnonymousView.BOm = com.tencent.mm.modelcontrol.e.baZ().bbc();
          paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.dQK().mcq;
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).apE();
          ((UICustomParam.a)localObject).apD();
          ((UICustomParam.a)localObject).dz(true);
          paramAnonymousView.BOn = ((UICustomParam.a)localObject).gLU;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, 2130772161, -1, paramAnonymousView, 2, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111585);
        }
      });
      this.xnV.setOnClickListener(new ImagePreviewUI.23(this));
      setBackBtn(new ImagePreviewUI.24(this));
      this.xnr = ((Intent)localObject1).getStringExtra("album_business_tag");
      this.kyt = ((Intent)localObject1).getIntExtra("album_video_max_duration", 10);
      this.xoo = ((Intent)localObject1).getIntExtra("album_video_min_duration", 0);
      localObject1 = t.b.OHg;
      if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq != 15) {
        break label1711;
      }
      localObject1 = t.b.OHe;
      addTextOptionMenu(0, dSl(), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
        {
          int j = 0;
          AppMethodBeat.i(111590);
          if (ImagePreviewUI.k(ImagePreviewUI.this) == 6)
          {
            ImagePreviewUI.this.setResult(1);
            paramAnonymousMenuItem = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            if (!Util.isNullOrNil(paramAnonymousMenuItem)) {
              a.a.xhE.al(paramAnonymousMenuItem, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            }
            ImagePreviewUI.this.finish();
          }
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("isPreviewPhoto", ImagePreviewUI.this.getIntent().getBooleanExtra("isPreviewPhoto", false));
          Object localObject = ImagePreviewUI.l(ImagePreviewUI.this);
          int i;
          if ((localObject != null) && (((ArrayList)localObject).size() == 0))
          {
            localObject = ImagePreviewUI.h(ImagePreviewUI.this).NS(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            if ((ImagePreviewUI.m(ImagePreviewUI.this)) && (ImagePreviewUI.h(ImagePreviewUI.this) != null) && (localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 2))
            {
              ImagePreviewUI.a(ImagePreviewUI.this, ((GalleryItem.MediaItem)localObject).xiW);
              localObject = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              if (!Util.isNullOrNil((String)localObject)) {
                a.a.xhE.al((String)localObject, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              }
              i = 0;
            }
          }
          for (;;)
          {
            if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 25)
            {
              paramAnonymousMenuItem.putStringArrayListExtra("preview_image_list", ImagePreviewUI.l(ImagePreviewUI.this));
              ImagePreviewUI.this.setResult(25, paramAnonymousMenuItem);
              ImagePreviewUI.this.finish();
            }
            if (!ImagePreviewUI.b(ImagePreviewUI.this)) {}
            final boolean bool2;
            for (final boolean bool1 = true;; bool1 = false)
            {
              bool2 = ImagePreviewUI.m(ImagePreviewUI.this);
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
            localObject = com.tencent.mm.plugin.gallery.model.e.dQL();
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
              ((com.tencent.mm.plugin.gallery.model.g)localObject).dRd().postDelayed(paramAnonymousMenuItem, i);
              AppMethodBeat.o(111590);
              return true;
            }
            i = 0;
          }
        }
      }, null, (t.b)localObject1);
      this.xqC = ((ImageButton)findViewById(2131305922));
      this.xqC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111591);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (Util.isNullOrNil(paramAnonymousView))
          {
            Log.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111591);
            return;
          }
          ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousView);
          ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131761109) + ImagePreviewUI.dSp());
          ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
          a.a.xhE.al(paramAnonymousView, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111591);
        }
      });
      this.xqD = ((TextView)findViewById(2131305924));
      this.xqD.setOnClickListener(new ImagePreviewUI.2(this));
      if (this.wnd == 1)
      {
        this.xqC.setVisibility(8);
        this.xqD.setVisibility(8);
      }
      this.xqE = ((ViewGroup)findViewById(2131299356));
      this.xqF = ((ViewGroup)findViewById(2131301856));
      if (this.xqE != null)
      {
        this.xqE.setVisibility(8);
        this.xqE.setOnClickListener(new ImagePreviewUI.3(this));
      }
      if (this.xqF != null)
      {
        this.xqF.setVisibility(8);
        this.xqF.setOnClickListener(new ImagePreviewUI.4(this));
      }
      this.xqK = ((TextView)findViewById(2131305912));
      this.xqK.setOnClickListener(new ImagePreviewUI.5(this));
      this.xqt = ((RecyclerView)findViewById(2131302592));
      this.xqt.getItemAnimator().atp = 66L;
      this.xqt.a(new ImagePreviewUI.6(this));
      localObject1 = new SpeedyLinearLayoutManager();
      ((SpeedyLinearLayoutManager)localObject1).setOrientation(0);
      this.xqt.setLayoutManager((RecyclerView.LayoutManager)localObject1);
      i = getResources().getDisplayMetrics().widthPixels / 7;
      localObject1 = new g(this, this.xqv, i, this.xpA);
      this.xqt.setAdapter((RecyclerView.a)localObject1);
      this.xqt.post(new ImagePreviewUI.7(this));
      if (this.xqv.size() <= 0) {
        break label1730;
      }
      this.xqt.setVisibility(0);
      label1250:
      this.xqt.setItemAnimator(new android.support.v7.widget.v());
      ((g)localObject1).xrr.f(this.xqt);
      ((g)localObject1).xro = new g.b()
      {
        public final void NV(int paramAnonymousInt)
        {
          AppMethodBeat.i(111566);
          Log.i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(ImagePreviewUI.q(ImagePreviewUI.this)) });
          ((g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter()).gJ(paramAnonymousInt, paramAnonymousInt);
          ImagePreviewUI.r(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt, false);
          if (!ImagePreviewUI.q(ImagePreviewUI.this))
          {
            com.tencent.mm.plugin.gallery.model.e.xin = true;
            AppMethodBeat.o(111566);
            return;
          }
          com.tencent.mm.plugin.gallery.model.e.xil = true;
          AppMethodBeat.o(111566);
        }
        
        public final void ak(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(111568);
          Log.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), ImagePreviewUI.g(ImagePreviewUI.this) });
          if (!ImagePreviewUI.q(ImagePreviewUI.this))
          {
            com.tencent.mm.plugin.gallery.a.d.swap(ImagePreviewUI.s(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
            d locald = ImagePreviewUI.h(ImagePreviewUI.this);
            int i = ImagePreviewUI.g(ImagePreviewUI.this).intValue();
            Log.i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt3) });
            if (!locald.xpA)
            {
              com.tencent.mm.plugin.gallery.a.d.swap(locald.xpz, paramAnonymousInt1, paramAnonymousInt2);
              locald.eeE = paramAnonymousInt3;
              locald.xpC = ((View)locald.OUA.get(i));
              locald.OUy.remove(locald.xpC);
              locald.OUz.clear();
              locald.OUA.clear();
              locald.xpD = true;
              locald.notifyDataSetChanged();
            }
            ImagePreviewUI.r(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt3, false);
            ((g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter()).gJ(paramAnonymousInt3, paramAnonymousInt3);
            com.tencent.mm.plugin.gallery.model.e.xim = true;
            AppMethodBeat.o(111568);
            return;
          }
          com.tencent.mm.plugin.gallery.a.d.swap(ImagePreviewUI.d(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.plugin.gallery.model.e.xik = true;
          AppMethodBeat.o(111568);
        }
        
        public final void gI(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(111567);
          Log.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ImagePreviewUI.g(ImagePreviewUI.this) });
          AppMethodBeat.o(111567);
        }
      };
      this.xqs = ((MMViewPager)findViewById(2131301853));
      this.xqs.setVerticalFadingEdgeEnabled(false);
      this.xqs.setHorizontalFadingEdgeEnabled(false);
      this.xqs.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt)
        {
          AppMethodBeat.i(111574);
          if (ImagePreviewUI.h(ImagePreviewUI.this) != null) {
            ImagePreviewUI.h(ImagePreviewUI.this).xpG.onPageScrollStateChanged(paramAnonymousInt);
          }
          AppMethodBeat.o(111574);
        }
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          boolean bool2 = true;
          AppMethodBeat.i(111573);
          com.tencent.mm.plugin.gallery.model.e.NA(paramAnonymousInt);
          String str = ImagePreviewUI.h(ImagePreviewUI.this).getItem(paramAnonymousInt);
          ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousInt, str);
          boolean bool1 = ImagePreviewUI.d(ImagePreviewUI.this).contains(str);
          ImagePreviewUI.a(ImagePreviewUI.this, Integer.valueOf(paramAnonymousInt));
          Object localObject = ImagePreviewUI.e(ImagePreviewUI.this);
          int i;
          if (bool1)
          {
            i = ImagePreviewUI.dSq();
            ((ImageButton)localObject).setImageResource(i);
            if (!ImagePreviewUI.b(ImagePreviewUI.this)) {
              break label316;
            }
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691380);
            label105:
            if (ImagePreviewUI.t(ImagePreviewUI.this)) {
              ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691377);
            }
            localObject = ImagePreviewUI.c(ImagePreviewUI.this);
            if (ImagePreviewUI.t(ImagePreviewUI.this)) {
              break label331;
            }
            bool1 = true;
            label148:
            ((ImageButton)localObject).setEnabled(bool1);
            localObject = ImagePreviewUI.f(ImagePreviewUI.this);
            if (ImagePreviewUI.t(ImagePreviewUI.this)) {
              break label336;
            }
          }
          label316:
          label331:
          label336:
          for (bool1 = bool2;; bool1 = false)
          {
            ((TextView)localObject).setEnabled(bool1);
            ImagePreviewUI.this.setMMTitle(paramAnonymousInt + 1 + "/" + ImagePreviewUI.h(ImagePreviewUI.this).getCount());
            ImagePreviewUI.h(ImagePreviewUI.this).xpF.onPageSelected(paramAnonymousInt);
            Log.d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = ".concat(String.valueOf(paramAnonymousInt)));
            localObject = com.tencent.mm.plugin.gallery.model.e.ayS(str);
            if ((ImagePreviewUI.u(ImagePreviewUI.this).getVisibility() == 0) || (ImagePreviewUI.v(ImagePreviewUI.this).getVisibility() == 0))
            {
              ImagePreviewUI.a(ImagePreviewUI.this, str, (GalleryItem.MediaItem)localObject);
              ImagePreviewUI.a(ImagePreviewUI.this, (GalleryItem.MediaItem)localObject);
            }
            AppMethodBeat.o(111573);
            return;
            i = 2131691379;
            break;
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691379);
            break label105;
            bool1 = false;
            break label148;
          }
        }
      });
      this.xqs.setSingleClickOverListener(new MMViewPager.f()
      {
        public final void bmt()
        {
          AppMethodBeat.i(111576);
          ImagePreviewUI.w(ImagePreviewUI.this);
          AppMethodBeat.o(111576);
        }
        
        public final void dSr() {}
      });
      this.xqr = new d(this);
      ((g)this.xqt.getAdapter()).xrl = this.xqr;
      if (this.xpA) {
        break label1742;
      }
      this.xqr.as(this.xqu);
      this.xqr.xpA = false;
      if (this.xqu.size() <= 0) {
        break label1851;
      }
      localObject1 = (String)this.xqu.get(this.xqx.intValue());
    }
    for (;;)
    {
      this.xqs.setAdapter(this.xqr);
      this.xqs.setCurrentItem(this.xqx.intValue());
      this.xqr.bNu = this.xqx.intValue();
      i = dSm().indexOf(this.xqr.getItem(this.xqx.intValue()));
      ((g)this.xqt.getAdapter()).gJ(i, this.xqx.intValue());
      localObject2 = com.tencent.mm.plugin.gallery.model.e.ayS((String)localObject1);
      a((String)localObject1, (GalleryItem.MediaItem)localObject2);
      j((GalleryItem.MediaItem)localObject2);
      setMMTitle(this.xqx.intValue() + 1 + "/" + this.xqr.getCount());
      if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 25)
      {
        ((ViewGroup)this.xqt.getParent()).removeView(this.xqt);
        this.xqt.setVisibility(8);
        findViewById(2131305724).setVisibility(4);
        findViewById(2131301859).setVisibility(4);
        findViewById(2131305912).setVisibility(4);
        findViewById(2131301857).setVisibility(4);
        findViewById(2131309757).setVisibility(4);
        findViewById(2131301858).setVisibility(4);
      }
      AppMethodBeat.o(111597);
      return;
      this.xqy.setImageResource(2131691379);
      break;
      label1701:
      bool1 = false;
      break label641;
      label1706:
      bool1 = false;
      break label662;
      label1711:
      if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq != 25) {
        break label885;
      }
      localObject1 = t.b.OHf;
      break label885;
      label1730:
      this.xqt.setVisibility(8);
      break label1250;
      label1742:
      localObject1 = this.xqr;
      localObject2 = this.xno;
      ((d)localObject1).xno.clear();
      ((d)localObject1).xno.addAll((Collection)localObject2);
      ((d)localObject1).reset();
      ((d)localObject1).notifyDataSetChanged();
      this.xqr.xpA = true;
      if (this.xqx.intValue() >= this.xno.size()) {
        this.xqx = Integer.valueOf(0);
      }
      if (this.xno.size() > 0) {
        localObject1 = ((GalleryItem.MediaItem)this.xno.get(this.xqx.intValue())).xiW;
      } else {
        label1851:
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
      if ((paramIntent == null) || (this.xqt == null))
      {
        AppMethodBeat.o(111599);
        return;
        if (this.xqv.size() > 0)
        {
          ayZ((String)this.xqv.get(0));
        }
        else
        {
          Log.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[] { Integer.valueOf(this.xqv.size()) });
          continue;
          if (paramInt1 == 4370)
          {
            if (paramInt2 == -1)
            {
              localObject = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
              paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).videoPath);
              paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).thumbPath);
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject).eJJ().y("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
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
        ArrayList localArrayList4 = ((g)this.xqt.getAdapter()).xrn;
        ArrayList localArrayList3 = this.xqv;
        this.xqV = (this.xqV + localCaptureVideoNormalModel.eJJ().y("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)) + ";");
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
            if (!str.equalsIgnoreCase(Util.nullAsNil(this.xqU))) {}
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
            if (!str.equalsIgnoreCase(Util.nullAsNil(this.xqU))) {}
          }
          else
          {
            localObject = localCaptureVideoNormalModel.thumbPath;
          }
          localArrayList2.add(localObject);
          i += 1;
        }
        s.deleteFile(this.xqU);
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
        e(paramInt2, paramIntent);
        AppMethodBeat.o(111599);
        return;
      }
    }
    if (paramInt1 == 4381)
    {
      if (paramInt2 == -1)
      {
        if (this.xob)
        {
          paramIntent = RecordConfigProvider.jB("", "");
          paramIntent.BOv = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
          paramIntent.scene = 2;
          localObject = new VideoCaptureReportInfo();
          ((VideoCaptureReportInfo)localObject).sQn = 1;
          paramIntent.BOE = ((VideoCaptureReportInfo)localObject);
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).apE();
          ((UICustomParam.a)localObject).apD();
          ((UICustomParam.a)localObject).dz(true);
          paramIntent.BOn = ((UICustomParam.a)localObject).gLU;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4370, 2130772161, -1, paramIntent, 4, 0);
          AppMethodBeat.o(111599);
          return;
        }
        if (22 == com.tencent.mm.plugin.gallery.model.e.dQK().mcq)
        {
          setResult(-1, paramIntent);
          finish();
          AppMethodBeat.o(111599);
        }
      }
      else
      {
        Toast.makeText(this, 2131762444, 1).show();
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
  
  @TargetApi(16)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111593);
    final long l = Util.currentTicks();
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    ao.bm(this);
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
    initView();
    AppMethodBeat.o(111593);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111607);
    super.onDestroy();
    Log.i("MicroMsg.ImagePreviewUI", "onDestroy, %s.", new Object[] { this });
    if ((com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 3) && (getIntent().getBooleanExtra("preview_image", false)) && (getIntent().getIntExtra("max_select_count", 0) == 1))
    {
      Log.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
      com.tencent.mm.plugin.gallery.model.e.dQN().clear();
    }
    if (this.xqr != null) {
      this.xqr.release();
    }
    com.tencent.mm.plugin.gallery.model.e.ao(null);
    ab.diQ.Uo().Un();
    if (this.xqT != null) {
      com.tencent.mm.plugin.gallery.model.e.dQJ().b(this.xqT);
    }
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
    if (this.xqA != null) {
      this.xqA.stopTimer();
    }
    super.onPause();
    AppMethodBeat.o(111595);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111594);
    super.onResume();
    AppMethodBeat.o(111594);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */