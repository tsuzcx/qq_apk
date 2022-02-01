package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.y;
import com.tencent.mm.api.y.b;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.d.b;
import com.tencent.mm.plugin.gallery.model.t;
import com.tencent.mm.plugin.gallery.model.t.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.e;
import com.tencent.mm.ui.s.b;
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
  private int jxK;
  private int mediaType;
  private boolean oZN;
  private String path;
  private TextView tWL;
  private boolean tWR;
  private boolean tWS;
  private boolean tWU;
  private boolean tWV;
  private ArrayList<GalleryItem.MediaItem> tWe;
  private String tWh;
  private long tXb;
  private int tXe;
  private HashMap<String, Integer> tXr;
  private HashSet<String> tXs;
  private boolean tYm;
  private TextView tZA;
  private ProgressBar tZB;
  private boolean tZC;
  boolean tZD;
  private d.b tZE;
  private String tZF;
  private String tZG;
  private int tZH;
  private String tZI;
  private int tZJ;
  private String tZK;
  private d tZd;
  private MMViewPager tZe;
  private RecyclerView tZf;
  private ArrayList<String> tZg;
  private ArrayList<String> tZh;
  private ArrayList<GalleryItem.MediaItem> tZi;
  private Integer tZj;
  private ImageButton tZk;
  private TextView tZl;
  private aw tZm;
  private ImageButton tZn;
  private TextView tZo;
  private ViewGroup tZp;
  private ViewGroup tZq;
  private boolean tZr;
  private boolean tZs;
  private int tZt;
  private int tZu;
  private TextView tZv;
  private TextView tZw;
  private TextView tZx;
  private TextView tZy;
  private View tZz;
  private int tfW;
  
  public ImagePreviewUI()
  {
    AppMethodBeat.i(111592);
    this.tZr = true;
    this.tZs = true;
    this.tWR = true;
    this.tZt = 0;
    this.tXb = 0L;
    this.tZu = 10;
    this.tZC = false;
    this.mediaType = 0;
    this.tZD = false;
    this.tZE = null;
    this.tZG = "";
    this.tXr = new HashMap();
    this.tZH = 300000;
    this.tZJ = 1000;
    AppMethodBeat.o(111592);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111608);
    boolean bool;
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || ((com.tencent.mm.plugin.gallery.model.e.cXr().kXg != 4) && (com.tencent.mm.plugin.gallery.model.e.cXr().kXg != 14) && (com.tencent.mm.plugin.gallery.model.e.cXr().kXg != 13)))
    {
      this.tZr = true;
      this.tZp.setVisibility(0);
      this.tZq.setVisibility(8);
      this.tZB.setVisibility(8);
      a(paramString, paramMediaItem, false);
      ama(paramString);
      enableOptionMenu(true);
      this.tZl.setVisibility(8);
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
        this.tZv.setVisibility(0);
      }
      for (;;)
      {
        if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 15) {
          this.tZv.setVisibility(8);
        }
        if (this.tWS) {
          this.tZv.setVisibility(8);
        }
        alX(paramString);
        AppMethodBeat.o(111608);
        return;
        bool = getIntent().getBooleanExtra("preview_image", false);
        ae.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.cXr().kXg), Boolean.valueOf(bool), paramString });
        if ((paramMediaItem == null) && (!bu.isNullOrNil(paramString))) {
          this.tZv.setVisibility(0);
        } else {
          this.tZv.setVisibility(8);
        }
      }
    }
    if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
      this.tZv.setVisibility(0);
    }
    final GalleryItem.VideoMediaItem localVideoMediaItem;
    for (;;)
    {
      if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 25) {
        this.tZv.setVisibility(8);
      }
      alX(paramString);
      localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
      enableOptionMenu(false);
      this.tZr = false;
      this.tZp.setVisibility(8);
      this.tZq.setVisibility(0);
      this.tZA.setVisibility(8);
      if (!alY(paramString)) {
        break;
      }
      AppMethodBeat.o(111608);
      return;
      this.tZv.setVisibility(8);
    }
    if (!bu.isNullOrNil(localVideoMediaItem.ipJ))
    {
      ae.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.tRJ, Integer.valueOf(localVideoMediaItem.ipL), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
      bool = a(paramString, localVideoMediaItem, this.tZC);
      a(this.tZC, bool, localVideoMediaItem);
      AppMethodBeat.o(111608);
      return;
    }
    enableOptionMenu(false);
    this.tZr = true;
    this.tZp.setVisibility(0);
    this.tZq.setVisibility(8);
    this.tZl.setVisibility(8);
    a(paramString, paramMediaItem, false);
    ama(paramString);
    paramMediaItem = new t(paramString, this.tZj.intValue(), localVideoMediaItem, new t.a()
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
        boolean bool = ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymoust.path, paramAnonymoust.tSM, ImagePreviewUI.z(ImagePreviewUI.this));
        ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.z(ImagePreviewUI.this), bool, localVideoMediaItem);
        AppMethodBeat.o(111579);
      }
    });
    if (paramMediaItem.equals(this.tZB.getTag()))
    {
      ae.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { paramString });
      AppMethodBeat.o(111608);
      return;
    }
    this.tZB.setTag(paramMediaItem);
    com.tencent.e.h.MqF.aO(paramMediaItem);
    if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 15) {
      this.tZv.setVisibility(8);
    }
    if (this.tWS) {
      this.tZv.setVisibility(8);
    }
    AppMethodBeat.o(111608);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111619);
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || (com.tencent.mm.plugin.gallery.model.e.cXr().kXg != 4) || (paramBoolean))
    {
      if (this.tfW == 1)
      {
        this.tZn.setVisibility(8);
        this.tZo.setVisibility(8);
      }
      while (!this.tZh.contains(paramString))
      {
        this.tZn.setImageResource(2131691077);
        AppMethodBeat.o(111619);
        return;
        this.tZn.setVisibility(0);
        this.tZo.setVisibility(0);
      }
      this.tZn.setImageResource(cYQ());
      AppMethodBeat.o(111619);
      return;
    }
    this.tZn.setVisibility(8);
    this.tZo.setVisibility(8);
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
    if ((paramBoolean1) && (com.tencent.mm.plugin.gallery.a.d.af(this.tZi)))
    {
      this.tZA.setVisibility(8);
      this.tZl.setVisibility(8);
      this.tZq.setVisibility(8);
      enableOptionMenu(true);
      a(this.path, paramMediaItem, paramBoolean1);
    }
    AppMethodBeat.o(111609);
  }
  
  private boolean a(GalleryItem.VideoMediaItem paramVideoMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(186193);
    ae.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[] { paramVideoMediaItem });
    int i;
    if (paramVideoMediaItem != null) {
      if (("video/hevc".equalsIgnoreCase(paramVideoMediaItem.ipJ)) && (com.tencent.mm.plugin.o.f.dpm())) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((paramVideoMediaItem == null) || (bu.isNullOrNil(paramVideoMediaItem.tRJ)) || (alZ(paramVideoMediaItem.tRJ)) || (i == 0) || ((!bu.isNullOrNil(paramVideoMediaItem.ipK)) && (!"audio/mp4a-latm".equalsIgnoreCase(paramVideoMediaItem.ipK))) || ((paramBoolean) && (r.Hy(paramVideoMediaItem.tRJ))))
      {
        if (paramVideoMediaItem == null) {}
        for (paramVideoMediaItem = null;; paramVideoMediaItem = paramVideoMediaItem.ipJ)
        {
          ae.i("MicroMsg.ImagePreviewUI", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramVideoMediaItem });
          cYP();
          AppMethodBeat.o(186193);
          return true;
          if (!"video/avc".equalsIgnoreCase(paramVideoMediaItem.ipJ)) {
            break label182;
          }
          i = 1;
          break;
        }
      }
      AppMethodBeat.o(186193);
      return false;
      label182:
      i = 0;
    }
  }
  
  private boolean a(String paramString, GalleryItem.VideoMediaItem paramVideoMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111611);
    enableOptionMenu(false);
    this.tZr = false;
    this.tZp.setVisibility(8);
    this.tZq.setVisibility(0);
    this.tZA.setVisibility(8);
    if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 13)
    {
      this.tZq.setVisibility(8);
      this.tZp.setVisibility(8);
      this.tZw.setVisibility(8);
      this.tZx.setVisibility(8);
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
    this.tZr = true;
    this.tZp.setVisibility(0);
    this.tZq.setVisibility(8);
    this.tZl.setVisibility(0);
    this.tZB.setVisibility(8);
    a(paramString, paramVideoMediaItem, false);
    ama(paramString);
    AppMethodBeat.o(111611);
    return true;
  }
  
  private void alW(String paramString)
  {
    AppMethodBeat.i(111598);
    Object localObject1;
    Object localObject2;
    int i;
    label561:
    Object localObject3;
    if (!this.tZh.contains(paramString))
    {
      if (this.tZh.size() >= this.tfW)
      {
        if ((this.mediaType == 2) || ((!bu.isNullOrNil(this.tWh)) && (this.tWh.equals("album_business_bubble_media_by_coordinate")))) {
          paramString = getResources().getQuantityString(2131623951, this.tfW, new Object[] { Integer.valueOf(this.tfW) });
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.cm(getContext(), paramString);
          this.tZn.setImageResource(2131691077);
          if (!bu.ht(this.tZh)) {
            break;
          }
          AppMethodBeat.o(111598);
          return;
          if (this.mediaType == 1) {
            paramString = getResources().getQuantityString(2131623952, this.tfW, new Object[] { Integer.valueOf(this.tfW) });
          } else {
            paramString = getResources().getQuantityString(2131623950, this.tfW, new Object[] { Integer.valueOf(this.tfW) });
          }
        }
      }
      localObject1 = com.tencent.mm.plugin.gallery.model.e.alO(paramString);
      if (localObject1 != null)
      {
        if ((((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().acv(paramString)))
        {
          com.tencent.mm.ui.base.h.cm(this, getString(2131759800));
          AppMethodBeat.o(111598);
          return;
        }
        if ((((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")) && (!bu.isNullOrNil(this.tWh)) && (this.tWh.equals("album_business_byp")))
        {
          com.tencent.mm.ui.base.h.cm(this, getString(2131767086));
          AppMethodBeat.o(111598);
          return;
        }
        if ((localObject1 instanceof GalleryItem.VideoMediaItem)) {
          if ((!bu.isNullOrNil(this.tWh)) && (this.tWh.equals("album_business_bubble_media_by_coordinate")))
          {
            if (((GalleryItem.VideoMediaItem)localObject1).ipL >= this.jxK * 1000 + 500)
            {
              com.tencent.mm.ui.base.h.cm(getContext(), getContext().getResources().getString(2131759822, new Object[] { Integer.valueOf(this.jxK) }));
              AppMethodBeat.o(111598);
            }
          }
          else if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 25)
          {
            if (((GalleryItem.VideoMediaItem)localObject1).ipL > this.jxK * 1000)
            {
              com.tencent.mm.ui.base.h.cm(getContext(), getContext().getResources().getString(2131759822, new Object[] { Integer.valueOf(this.jxK) }));
              AppMethodBeat.o(111598);
              return;
            }
            if (((GalleryItem.VideoMediaItem)localObject1).ipL < this.tXe * 1000)
            {
              com.tencent.mm.ui.base.h.cm(getContext(), getContext().getResources().getString(2131759821, new Object[] { Integer.valueOf(this.tXe) }));
              AppMethodBeat.o(111598);
              return;
            }
          }
        }
        if (this.tZi != null)
        {
          localObject2 = this.tZi.iterator();
          i = 0;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
            if ((localObject3 == null) || (!((GalleryItem.MediaItem)localObject3).tRJ.equalsIgnoreCase(((GalleryItem.MediaItem)localObject1).tRJ))) {
              break label856;
            }
            i = 1;
          }
        }
      }
    }
    label702:
    label853:
    label856:
    for (;;)
    {
      break label561;
      if (i == 0) {
        this.tZi.add(localObject1);
      }
      this.tZh.add(paramString);
      this.tZn.setImageResource(cYQ());
      b(this.tZh.size(), this.tZj.intValue(), paramString, 0);
      break;
      this.tZn.setImageResource(2131691077);
      while (this.tZh.remove(paramString)) {}
      if (this.tZi != null)
      {
        localObject1 = null;
        localObject3 = this.tZi.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
          if ((localObject2 == null) || (!((GalleryItem.MediaItem)localObject2).tRJ.equalsIgnoreCase(paramString))) {
            break label853;
          }
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        break label702;
        if (localObject1 != null)
        {
          ae.i("MicroMsg.ImagePreviewUI", "unselect item: %s", new Object[] { ((GalleryItem.MediaItem)localObject1).tRJ });
          this.tZi.remove(localObject1);
        }
        b(this.tZh.size(), this.tZj.intValue(), paramString, 1);
        break;
        paramString = this.tZh.iterator();
        while (paramString.hasNext()) {
          if (!com.tencent.mm.sdk.platformtools.u.aRG((String)paramString.next()))
          {
            AppMethodBeat.o(111598);
            return;
          }
        }
        this.oZN = true;
        AppMethodBeat.o(111598);
        return;
      }
    }
  }
  
  private void alX(String paramString)
  {
    AppMethodBeat.i(111610);
    if ((this.tZh.size() >= 9) && (!this.tZh.contains(paramString)))
    {
      this.tZv.setTextColor(getContext().getResources().getColor(2131101183));
      this.tZv.setEnabled(false);
      AppMethodBeat.o(111610);
      return;
    }
    this.tZv.setEnabled(true);
    this.tZv.setTextColor(getContext().getResources().getColor(2131101182));
    AppMethodBeat.o(111610);
  }
  
  private boolean alY(String paramString)
  {
    AppMethodBeat.i(111613);
    if (com.tencent.mm.vfs.o.aZR(paramString) > 1073741824L)
    {
      this.tZw.setText(getString(2131759794));
      this.tZx.setText(getString(2131759793));
      AppMethodBeat.o(111613);
      return true;
    }
    AppMethodBeat.o(111613);
    return false;
  }
  
  private boolean alZ(String paramString)
  {
    AppMethodBeat.i(111618);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111618);
      return true;
    }
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
    paramString = paramString.trim();
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length()))
    {
      AppMethodBeat.o(111618);
      return true;
    }
    if (!this.tXs.contains(paramString.substring(i).toLowerCase()))
    {
      AppMethodBeat.o(111618);
      return true;
    }
    AppMethodBeat.o(111618);
    return false;
  }
  
  private void ama(String paramString)
  {
    AppMethodBeat.i(111620);
    Object localObject = Boolean.FALSE;
    Boolean localBoolean;
    GalleryItem.MediaItem localMediaItem;
    switch (com.tencent.mm.plugin.gallery.model.e.cXr().kXg)
    {
    default: 
      localBoolean = Boolean.FALSE;
      localMediaItem = com.tencent.mm.plugin.gallery.model.e.alO(paramString);
      localObject = localBoolean;
      if (localMediaItem != null)
      {
        localObject = localBoolean;
        if (localMediaItem.getType() == 2) {
          localObject = Boolean.TRUE;
        }
      }
      if ((localMediaItem == null) && (com.tencent.mm.sdk.platformtools.u.aRG(paramString))) {
        paramString = Boolean.TRUE;
      }
      break;
    }
    for (;;)
    {
      if ((!paramString.booleanValue()) || (this.tWU)) {
        break label192;
      }
      this.tZk.setVisibility(8);
      this.tWL.setVisibility(8);
      AppMethodBeat.o(111620);
      return;
      localBoolean = Boolean.TRUE;
      break;
      paramString = (String)localObject;
      if (localMediaItem != null)
      {
        paramString = (String)localObject;
        if (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
          paramString = Boolean.TRUE;
        }
      }
    }
    label192:
    this.tZk.setVisibility(0);
    this.tWL.setVisibility(0);
    AppMethodBeat.o(111620);
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(111621);
    ae.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((-1 != paramInt2) && (!this.tYm))
    {
      this.tZf.getAdapter().b(paramInt2, Integer.valueOf(paramInt2));
      if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg != 13) {
        break label356;
      }
      paramInt2 = 1;
      label72:
      paramString = this.tZd.HP(this.tZj.intValue());
      if ((paramInt1 != 0) && (((!this.tWR) || (this.tZC)) && ((paramInt2 == 0) || (this.tZd == null) || (paramString == null) || (paramString.getType() != 2)))) {
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
      this.tZf.setVisibility(8);
      AppMethodBeat.o(111621);
      return;
      if (-1 == paramInt2) {
        break;
      }
      if ((paramInt3 == 0) && (paramInt1 > 0))
      {
        ((g)this.tZf.getAdapter()).amb(paramString);
        ((g)this.tZf.getAdapter()).gk(paramInt1 - 1, this.tZj.intValue());
        this.tZf.getAdapter().ck(paramInt1 - 1);
        paramString = this.tZf;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt1 - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramString, locala.ahE(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramString.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        break;
      }
      if (paramInt3 != 1) {
        break;
      }
      paramInt2 = ((g)this.tZf.getAdapter()).indexOf(paramString);
      if (-1 == paramInt2) {
        break;
      }
      ((g)this.tZf.getAdapter()).remove(paramInt2);
      this.tZf.getAdapter().cl(paramInt2);
      break;
      paramInt2 = 0;
      break label72;
    }
    label366:
    this.tZf.setVisibility(0);
    AppMethodBeat.o(111621);
  }
  
  private boolean b(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111614);
    ae.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[] { Integer.valueOf(paramVideoMediaItem.ipL) });
    if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 13)
    {
      AppMethodBeat.o(111614);
      return false;
    }
    if (paramVideoMediaItem.ipL <= 1000)
    {
      this.tZw.setText(getString(2131759798));
      this.tZx.setText(getString(2131759797));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.ipL >= 300000)
    {
      this.tZw.setText(getString(2131759796));
      this.tZx.setText(getString(2131759795));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.ipL >= this.tZu * 1000 + 500)
    {
      this.tZw.setText(getString(2131759781));
      this.tZx.setText(getString(2131759780, new Object[] { Integer.valueOf(this.tZu) }));
      this.tZA.setVisibility(0);
      AppMethodBeat.o(111614);
      return true;
    }
    AppMethodBeat.o(111614);
    return false;
  }
  
  private boolean c(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111616);
    if ((paramVideoMediaItem == null) || (paramVideoMediaItem.videoWidth <= 0) || (paramVideoMediaItem.videoHeight <= 0) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight > 3.0F) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight < 0.3F))
    {
      if (paramVideoMediaItem != null) {
        ae.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramVideoMediaItem.videoWidth), Integer.valueOf(paramVideoMediaItem.videoHeight) });
      }
      this.tZw.setText(getString(2131759791));
      this.tZx.setText(getString(2131759792));
      AppMethodBeat.o(111616);
      return true;
    }
    AppMethodBeat.o(111616);
    return false;
  }
  
  private String cYN()
  {
    AppMethodBeat.i(111601);
    switch (com.tencent.mm.plugin.gallery.model.e.cXr().kXg)
    {
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 12: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 23: 
    default: 
      if ((this.tZh.size() == 0) || (this.tfW <= 1))
      {
        str = getString(2131755884);
        AppMethodBeat.o(111601);
        return str;
      }
      break;
    case 4: 
    case 8: 
    case 13: 
    case 14: 
    case 22: 
      if ((this.tZC) && (com.tencent.mm.plugin.gallery.a.d.af(this.tZi)))
      {
        str = getString(2131759788) + "(" + this.tZh.size() + "/" + this.tfW + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.tZh.size() == 0) || (this.tfW <= 1))
      {
        str = getString(2131759785);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(2131759785) + "(" + this.tZh.size() + "/" + this.tfW + ")";
      AppMethodBeat.o(111601);
      return str;
    case 11: 
    case 24: 
      str = getString(2131758387);
      AppMethodBeat.o(111601);
      return str;
    case 7: 
    case 15: 
    case 25: 
      if (((!bu.isNullOrNil(this.tWh)) && (this.tWh.equals("album_business_bubble_media_by_coordinate"))) || (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 25))
      {
        if ((this.tZh.size() == 0) || (this.tfW <= 1))
        {
          str = getString(2131755830);
          AppMethodBeat.o(111601);
          return str;
        }
        str = getString(2131755830) + "(" + this.tZh.size() + "/" + this.tfW + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.tZh.size() == 0) || (this.tfW <= 1))
      {
        str = getString(2131759785);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(2131759785) + "(" + this.tZh.size() + "/" + this.tfW + ")";
      AppMethodBeat.o(111601);
      return str;
    }
    String str = getString(2131759775, new Object[] { Integer.valueOf(this.tZh.size()), Integer.valueOf(this.tfW) });
    AppMethodBeat.o(111601);
    return str;
  }
  
  private ArrayList<String> cYO()
  {
    AppMethodBeat.i(111602);
    if (this.tYm)
    {
      localArrayList = this.tZh;
      AppMethodBeat.o(111602);
      return localArrayList;
    }
    if (this.tZh != null)
    {
      localArrayList = new ArrayList(this.tZh.size());
      Iterator localIterator = this.tZg.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.tZh.contains(str)) {
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
  
  private boolean cYP()
  {
    AppMethodBeat.i(111615);
    this.tZw.setText(getString(2131759789));
    this.tZx.setText(getString(2131759790));
    AppMethodBeat.o(111615);
    return true;
  }
  
  private static int cYQ()
  {
    AppMethodBeat.i(111622);
    if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 15)
    {
      AppMethodBeat.o(111622);
      return 2131689937;
    }
    if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 25)
    {
      AppMethodBeat.o(111622);
      return 2131691475;
    }
    AppMethodBeat.o(111622);
    return 2131689655;
  }
  
  private void e(int paramInt, final Intent paramIntent)
  {
    AppMethodBeat.i(111600);
    if ((paramInt == -1) && (paramIntent != null))
    {
      this.tZD = true;
      Object localObject2 = paramIntent.getStringExtra("raw_photo_path");
      Object localObject1 = com.tencent.mm.plugin.gallery.model.e.cXv().iterator();
      while ((localObject2 != null) && (((Iterator)localObject1).hasNext())) {
        if (((String)localObject2).equals(((Bundle)((Iterator)localObject1).next()).getString("raw_photo_path"))) {
          ((Iterator)localObject1).remove();
        }
      }
      com.tencent.mm.plugin.gallery.model.e.cXv().add(paramIntent.getBundleExtra("report_info"));
      localObject1 = paramIntent.getStringExtra("after_photo_edit");
      String str = paramIntent.getStringExtra("tmp_photo_edit");
      ae.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { localObject2, localObject1 });
      if (this.tZg != null)
      {
        this.tZg.clear();
        Object localObject3 = paramIntent.getStringArrayListExtra("preview_image_list");
        if (localObject3 != null) {
          this.tZg.addAll((Collection)localObject3);
        }
        localObject3 = this.tZd.HP(this.tZj.intValue());
        if (localObject3 == null)
        {
          ae.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { this.tZj, localObject2, localObject1 });
          AppMethodBeat.o(111600);
          return;
        }
        ((GalleryItem.MediaItem)localObject3).tRK = ((String)localObject2);
        ((GalleryItem.MediaItem)localObject3).tRJ = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).ruE = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).tRL = str;
        ((GalleryItem.MediaItem)localObject3).mMimeType = "edit";
        com.tencent.mm.plugin.gallery.model.e.cXu().add(localObject3);
        if (this.tZE != null) {
          com.tencent.mm.plugin.gallery.model.e.cXq().b(this.tZE);
        }
        localObject2 = com.tencent.mm.plugin.gallery.model.e.cXq();
        paramIntent = new d.b()
        {
          public final void alN(final String paramAnonymousString)
          {
            AppMethodBeat.i(111571);
            new aq(ImagePreviewUI.this.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111570);
                ImagePreviewUI.h(ImagePreviewUI.this).ae(ImagePreviewUI.s(ImagePreviewUI.this));
                Object localObject = (g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter();
                ArrayList localArrayList = ImagePreviewUI.s(ImagePreviewUI.this);
                ((g)localObject).tZY.clear();
                ((g)localObject).tZY.addAll(localArrayList);
                ((RecyclerView.a)localObject).asY.notifyChanged();
                localObject = ImagePreviewUI.10.this.val$data.getStringArrayListExtra("preview_select_image_list");
                ImagePreviewUI.d(ImagePreviewUI.this).clear();
                if (localObject != null) {
                  ImagePreviewUI.d(ImagePreviewUI.this).addAll((Collection)localObject);
                }
                ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
                ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131759782) + ImagePreviewUI.cYR());
                if (!ImagePreviewUI.d(ImagePreviewUI.this).contains(com.tencent.mm.plugin.gallery.a.d.amf(paramAnonymousString))) {
                  ImagePreviewUI.e(ImagePreviewUI.this).performClick();
                }
                AppMethodBeat.o(111570);
              }
            });
            com.tencent.mm.plugin.gallery.model.e.cXq().b(this);
            AppMethodBeat.o(111571);
          }
          
          public final String cXn()
          {
            AppMethodBeat.i(179472);
            String str = com.tencent.mm.plugin.gallery.a.d.a(this.tZN, null, -1);
            AppMethodBeat.o(179472);
            return str;
          }
          
          public final String toString()
          {
            AppMethodBeat.i(111572);
            String str = "fileKey:" + this.tZN + " this: " + super.toString();
            AppMethodBeat.o(111572);
            return str;
          }
        };
        this.tZE = paramIntent;
        ((com.tencent.mm.plugin.gallery.model.c)localObject2).a(paramIntent);
        com.tencent.mm.plugin.gallery.model.e.cXq().a((String)localObject1, ((GalleryItem.MediaItem)localObject3).getType(), (String)localObject1, ((GalleryItem.MediaItem)localObject3).tRM, ((GalleryItem.MediaItem)localObject3).tRN);
        ae.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
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
    if (!this.oZN)
    {
      bool1 = true;
      if (!this.tWR) {
        break label89;
      }
      bool1 = bool2;
    }
    label89:
    for (;;)
    {
      localIntent.putExtra("CropImage_Compress_Img", bool1);
      localIntent.putStringArrayListExtra("preview_image_list", cYO());
      localIntent.putExtra("show_photo_edit_tip", this.tZD);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(111605);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void i(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111612);
    if (paramMediaItem == null)
    {
      ae.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
      AppMethodBeat.o(111612);
      return;
    }
    Object localObject;
    if (paramMediaItem.getType() == 2)
    {
      GalleryItem.VideoMediaItem localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
      this.tZH = 300000;
      this.tZI = getString(2131759795);
      this.tZJ = 1000;
      this.tZK = getString(2131759797);
      if (((this.tWh != null) && ((this.tWh.equals("album_business_bubble_media_by_coordinate")) || (this.tWh.equals("album_business_bubble_media_by_jsapi_choosevideo")))) || (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 25))
      {
        this.tZH = (this.jxK * 1000 + 500);
        this.tZI = getString(2131759822, new Object[] { Integer.valueOf(this.jxK) });
        if (this.tXe != 0)
        {
          this.tZJ = (this.tXe * 1000);
          this.tZK = getString(2131759821, new Object[] { Integer.valueOf(this.tXe) });
        }
      }
      if (!bu.isNullOrNil(localVideoMediaItem.ipJ))
      {
        ae.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.tRJ, Integer.valueOf(localVideoMediaItem.ipL), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
        if ((localVideoMediaItem.ipL >= this.tZH) || ((localVideoMediaItem.ipL > 0) && (localVideoMediaItem.ipL < this.tZJ)))
        {
          this.tZz.setVisibility(0);
          localObject = this.tZy;
          if (localVideoMediaItem.ipL >= this.tZH) {}
          for (paramMediaItem = this.tZI;; paramMediaItem = this.tZK)
          {
            ((TextView)localObject).setText(paramMediaItem);
            this.tZo.setEnabled(false);
            this.tZn.setEnabled(false);
            this.tZo.setTextColor(getResources().getColor(2131101183));
            if (this.tZh.size() != 0) {
              break;
            }
            enableOptionMenu(false);
            AppMethodBeat.o(111612);
            return;
          }
        }
        if (a(localVideoMediaItem, true))
        {
          this.tZz.setVisibility(0);
          this.tZy.setText(getString(2131759790));
          this.tZo.setEnabled(false);
          this.tZn.setEnabled(false);
          this.tZo.setTextColor(getResources().getColor(2131101183));
          if (this.tZh.size() == 0)
          {
            enableOptionMenu(false);
            AppMethodBeat.o(111612);
          }
        }
        else
        {
          this.tZo.setEnabled(true);
          this.tZn.setEnabled(true);
          this.tZo.setTextColor(getResources().getColor(2131101182));
          this.tZz.setVisibility(8);
          AppMethodBeat.o(111612);
        }
      }
      else
      {
        paramMediaItem = new t(paramMediaItem.tRJ, this.tZj.intValue(), localVideoMediaItem, new t.a()
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
            if (TextUtils.isEmpty(paramAnonymoust.tSM.ipJ))
            {
              paramAnonymoust = ImagePreviewUI.this.getString(2131759790);
              ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
              ImagePreviewUI.A(ImagePreviewUI.this).setText(paramAnonymoust);
              ImagePreviewUI.B(ImagePreviewUI.this).setEnabled(false);
              ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(false);
              ImagePreviewUI.B(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(2131101183));
              if (ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) {
                ImagePreviewUI.this.enableOptionMenu(false);
              }
              AppMethodBeat.o(111580);
              return;
            }
            if ((paramAnonymoust.tSM.ipL >= ImagePreviewUI.C(ImagePreviewUI.this)) || ((paramAnonymoust.tSM.ipL > 0) && (paramAnonymoust.tSM.ipL < ImagePreviewUI.D(ImagePreviewUI.this))))
            {
              ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
              TextView localTextView = ImagePreviewUI.A(ImagePreviewUI.this);
              if (paramAnonymoust.tSM.ipL >= ImagePreviewUI.C(ImagePreviewUI.this)) {}
              for (paramAnonymoust = ImagePreviewUI.E(ImagePreviewUI.this);; paramAnonymoust = ImagePreviewUI.F(ImagePreviewUI.this))
              {
                localTextView.setText(paramAnonymoust);
                ImagePreviewUI.B(ImagePreviewUI.this).setEnabled(false);
                ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(false);
                ImagePreviewUI.B(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(2131101183));
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
            ImagePreviewUI.B(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(2131101182));
            ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(8);
            AppMethodBeat.o(111580);
          }
        });
        if (paramMediaItem.equals(this.tZB.getTag()))
        {
          ae.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { this.path });
          AppMethodBeat.o(111612);
          return;
        }
        this.tZB.setTag(paramMediaItem);
        com.tencent.e.h.MqF.aO(paramMediaItem);
      }
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      this.tZo.setEnabled(true);
      this.tZn.setEnabled(true);
      this.tZo.setTextColor(getResources().getColor(2131101182));
      if ((this.oZN) && (this.tZh.contains(paramMediaItem.tRJ)) && (com.tencent.mm.vfs.o.aZR(paramMediaItem.tRJ) > 26214400L))
      {
        this.tZz.setVisibility(0);
        this.tZy.setText(getString(2131759802));
        AppMethodBeat.o(111612);
        return;
      }
      this.tZz.setVisibility(8);
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      localObject = new com.tencent.mm.plugin.gif.f(paramMediaItem.tRJ);
      long l = com.tencent.mm.vfs.o.aZR(paramMediaItem.tRJ);
      try
      {
        if (((!this.tZh.contains(paramMediaItem.tRJ)) || (l == 0L) || (l <= com.tencent.mm.plugin.gallery.a.d.acq())) && (localObject.uLz[0] <= com.tencent.mm.plugin.gallery.a.d.acp()) && (localObject.uLz[1] <= com.tencent.mm.plugin.gallery.a.d.acp())) {
          break label917;
        }
        this.tZo.setTextColor(getResources().getColor(2131101183));
        this.tZo.setEnabled(false);
        this.tZn.setEnabled(false);
        AppMethodBeat.o(111612);
        return;
      }
      catch (Exception paramMediaItem)
      {
        ae.e("MicroMsg.ImagePreviewUI", bu.o(paramMediaItem));
      }
    }
    else
    {
      AppMethodBeat.o(111612);
      return;
    }
    label917:
    this.tZo.setTextColor(getResources().getColor(2131101182));
    this.tZo.setEnabled(true);
    this.tZn.setEnabled(true);
    AppMethodBeat.o(111612);
  }
  
  private void mX(boolean paramBoolean)
  {
    AppMethodBeat.i(111603);
    if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 4)
    {
      AppMethodBeat.o(111603);
      return;
    }
    if (this.tZd == null)
    {
      ae.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
      AppMethodBeat.o(111603);
      return;
    }
    final GalleryItem.MediaItem localMediaItem = this.tZd.HP(this.tZj.intValue());
    if ((paramBoolean) && (localMediaItem != null))
    {
      this.tZz.postDelayed(new Runnable()
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
    this.tZz.setVisibility(8);
    AppMethodBeat.o(111603);
  }
  
  private void mY(boolean paramBoolean)
  {
    AppMethodBeat.i(111604);
    ae.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + paramBoolean + "], selectedNormalFooter = " + this.tZr);
    if (this.tZr)
    {
      localObject = findViewById(2131298881);
      if (localObject != null) {
        break label134;
      }
      if (!this.tZr) {
        break label127;
      }
    }
    label127:
    for (Object localObject = "normal";; localObject = "edit_tips")
    {
      ae.w("MicroMsg.ImagePreviewUI", "set footer[%s] visibility[%B], but footerbar null", new Object[] { localObject, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(111604);
      return;
      localObject = findViewById(2131300337);
      if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg != 15) {
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
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, 2130772047));
    }
    while ((paramBoolean) && (this.tZf.getVisibility() == 8) && (this.tZh.size() > 0))
    {
      this.tZf.setVisibility(0);
      localObject = AnimationUtils.loadAnimation(this, 2130772047);
      this.tZf.startAnimation((Animation)localObject);
      AppMethodBeat.o(111604);
      return;
      ((View)localObject).setVisibility(8);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, 2130772048));
    }
    if ((!paramBoolean) && (this.tZf.getVisibility() == 0))
    {
      this.tZf.setVisibility(8);
      localObject = AnimationUtils.loadAnimation(this, 2130772048);
      this.tZf.startAnimation((Animation)localObject);
    }
    AppMethodBeat.o(111604);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(111596);
    if (com.tencent.mm.compatible.d.b.ca(this))
    {
      setContentView(paramView);
      AppMethodBeat.o(111596);
      return;
    }
    al.n(al.a(getWindow(), null), getBodyView());
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
    return 2131494473;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111597);
    setActionbarColor(getResources().getColor(2131100399));
    setNavigationbarColor(getResources().getColor(2131100399));
    this.tZw = ((TextView)findViewById(2131300338));
    this.tZx = ((TextView)findViewById(2131300340));
    this.tZy = ((TextView)findViewById(2131301163));
    this.tZz = findViewById(2131301164);
    this.tZz.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111575);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)ImagePreviewUI.a(ImagePreviewUI.this).getLayoutParams();
        localMarginLayoutParams.topMargin = ((int)(com.tencent.mm.compatible.util.i.aV(ImagePreviewUI.this) + ImagePreviewUI.this.getResources().getDimension(2131165252)));
        ImagePreviewUI.a(ImagePreviewUI.this).setLayoutParams(localMarginLayoutParams);
        AppMethodBeat.o(111575);
      }
    }, 100L);
    this.tZA = ((TextView)findViewById(2131300339));
    this.tZB = ((ProgressBar)findViewById(2131306335));
    this.tfW = getIntent().getIntExtra("max_select_count", 9);
    this.tZu = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
    Object localObject1;
    boolean bool2;
    if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 4)
    {
      bool1 = true;
      this.tWR = bool1;
      localObject1 = getIntent();
      this.tZg = ((Intent)localObject1).getStringArrayListExtra("preview_image_list");
      this.tZi = ((Intent)localObject1).getParcelableArrayListExtra("preview_media_item_list");
      this.mediaType = ((Intent)localObject1).getIntExtra("media_type", this.mediaType);
      this.tZh = new ArrayList();
      if (this.tZg != null) {
        this.tZh.addAll(this.tZg);
      }
      this.tWe = com.tencent.mm.plugin.gallery.model.e.cXt();
      bool2 = ((Intent)localObject1).getBooleanExtra("preview_all", false);
      if (this.tWe != null) {
        break label438;
      }
    }
    label438:
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.i("MicroMsg.ImagePreviewUI", "preview all[%B] mediaitems is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (this.tWe != null))
      {
        this.tYm = true;
        this.tZj = Integer.valueOf(((Intent)localObject1).getIntExtra("preview_position", 0));
        ae.i("MicroMsg.ImagePreviewUI", "start position=%d", new Object[] { this.tZj });
        if (this.tZj.intValue() >= 0) {}
      }
      else
      {
        this.tZj = Integer.valueOf(0);
      }
      com.tencent.mm.plugin.gallery.model.e.HA(this.tZj.intValue());
      if ((this.tYm) || ((this.tZh != null) && (this.tZh.size() != 0))) {
        break label443;
      }
      ae.e("MicroMsg.ImagePreviewUI", "not preview all items and image paths is null or empty");
      finish();
      AppMethodBeat.o(111597);
      return;
      bool1 = false;
      break;
    }
    label443:
    this.tZk = ((ImageButton)findViewById(2131303090));
    this.tWL = ((TextView)findViewById(2131303091));
    this.tZl = ((TextView)findViewById(2131306334));
    this.oZN = ((Intent)localObject1).getBooleanExtra("send_raw_img", false);
    this.tWS = ((Intent)localObject1).getBooleanExtra("key_force_hide_edit_image_button", false);
    this.tWU = ((Intent)localObject1).getBooleanExtra("key_force_show_raw_image_button", false);
    this.tWV = ((Intent)localObject1).getBooleanExtra("key_is_raw_image_button_disable", false);
    this.tZt = ((Intent)localObject1).getIntExtra("query_source_type", 0);
    this.tZC = com.tencent.mm.plugin.gallery.a.d.cZb();
    ae.i("MicroMsg.ImagePreviewUI", "initView, enableVLog:%s", new Object[] { Boolean.valueOf(this.tZC) });
    Object localObject2;
    label628:
    int i;
    if (this.oZN)
    {
      this.tZk.setImageResource(2131691078);
      if (this.tWV) {
        this.tZk.setImageResource(2131691075);
      }
      localObject2 = this.tZk;
      if (this.tWV) {
        break label1688;
      }
      bool1 = true;
      ((ImageButton)localObject2).setEnabled(bool1);
      localObject2 = this.tWL;
      if (this.tWV) {
        break label1693;
      }
      bool1 = true;
      label649:
      ((TextView)localObject2).setEnabled(bool1);
      if ((this.tZh != null) && (this.tZh.size() == 1))
      {
        localObject2 = (String)this.tZh.get(0);
        if (((String)localObject2).endsWith(".jpg")) {
          ar.f(new Runnable()
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
      this.tWL.setText(getContext().getString(2131759782));
      this.tZk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111583);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = ImagePreviewUI.this;
          boolean bool;
          if (!ImagePreviewUI.b(ImagePreviewUI.this))
          {
            bool = true;
            ImagePreviewUI.b(paramAnonymousView, bool);
            if (!ImagePreviewUI.b(ImagePreviewUI.this)) {
              break label184;
            }
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691078);
            if (ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) {
              ImagePreviewUI.e(ImagePreviewUI.this).performClick();
            }
          }
          for (;;)
          {
            ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131759782) + ImagePreviewUI.cYR());
            ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111583);
            return;
            bool = false;
            break;
            label184:
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691077);
          }
        }
      });
      this.tZl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111584);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bu.isNullOrNil(paramAnonymousView))
          {
            ae.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111584);
            return;
          }
          ae.i("MicroMsg.ImagePreviewUI", "editVideoMaxTimeLength : %d", new Object[] { Integer.valueOf(ImagePreviewUI.i(ImagePreviewUI.this)) });
          localObject = new StringBuilder();
          com.tencent.mm.modelvideo.o.aNg();
          localObject = com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
          StringBuilder localStringBuilder = new StringBuilder();
          com.tencent.mm.modelvideo.o.aNg();
          paramAnonymousView = RecordConfigProvider.as(paramAnonymousView, (String)localObject, com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg");
          paramAnonymousView.xOg = com.tencent.mm.modelcontrol.d.aHh().aHk();
          paramAnonymousView.xOp = (ImagePreviewUI.i(ImagePreviewUI.this) * 1000);
          paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.cXr().kXg;
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).abH();
          ((UICustomParam.a)localObject).abG();
          ((UICustomParam.a)localObject).cP(true);
          paramAnonymousView.xOh = ((UICustomParam.a)localObject).ggq;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, 2130772137, -1, paramAnonymousView, 2, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111584);
        }
      });
      this.tZA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111585);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bu.isNullOrNil(paramAnonymousView))
          {
            ae.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111585);
            return;
          }
          localObject = new StringBuilder();
          com.tencent.mm.modelvideo.o.aNg();
          localObject = com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
          StringBuilder localStringBuilder = new StringBuilder();
          com.tencent.mm.modelvideo.o.aNg();
          paramAnonymousView = RecordConfigProvider.as(paramAnonymousView, (String)localObject, com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg");
          paramAnonymousView.xOp = (ImagePreviewUI.i(ImagePreviewUI.this) * 1000);
          paramAnonymousView.xOg = com.tencent.mm.modelcontrol.d.aHh().aHk();
          paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.cXr().kXg;
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).abH();
          ((UICustomParam.a)localObject).abG();
          ((UICustomParam.a)localObject).cP(true);
          paramAnonymousView.xOh = ((UICustomParam.a)localObject).ggq;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, 2130772137, -1, paramAnonymousView, 2, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111585);
        }
      });
      this.tWL.setOnClickListener(new ImagePreviewUI.23(this));
      setBackBtn(new ImagePreviewUI.24(this));
      this.tWh = ((Intent)localObject1).getStringExtra("album_business_tag");
      this.jxK = ((Intent)localObject1).getIntExtra("album_video_max_duration", 10);
      this.tXe = ((Intent)localObject1).getIntExtra("album_video_min_duration", 0);
      localObject1 = s.b.JwM;
      if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg != 15) {
        break label1698;
      }
      localObject1 = s.b.JwK;
      label872:
      addTextOptionMenu(0, cYN(), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
        {
          int j = 0;
          AppMethodBeat.i(111590);
          if (ImagePreviewUI.k(ImagePreviewUI.this) == 6)
          {
            ImagePreviewUI.this.setResult(1);
            paramAnonymousMenuItem = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            if (!bu.isNullOrNil(paramAnonymousMenuItem)) {
              a.a.tQr.ai(paramAnonymousMenuItem, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            }
            ImagePreviewUI.this.finish();
          }
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("isPreviewPhoto", ImagePreviewUI.this.getIntent().getBooleanExtra("isPreviewPhoto", false));
          Object localObject = ImagePreviewUI.l(ImagePreviewUI.this);
          int i;
          if ((localObject != null) && (((ArrayList)localObject).size() == 0))
          {
            localObject = ImagePreviewUI.h(ImagePreviewUI.this).HP(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            if ((ImagePreviewUI.m(ImagePreviewUI.this)) && (ImagePreviewUI.h(ImagePreviewUI.this) != null) && (localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 2))
            {
              ImagePreviewUI.a(ImagePreviewUI.this, ((GalleryItem.MediaItem)localObject).tRJ);
              localObject = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              if (!bu.isNullOrNil((String)localObject)) {
                a.a.tQr.ai((String)localObject, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              }
              i = 0;
            }
          }
          for (;;)
          {
            if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 25)
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
            localObject = com.tencent.mm.plugin.gallery.model.e.cXs();
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
              ((com.tencent.mm.plugin.gallery.model.g)localObject).cXK().postDelayed(paramAnonymousMenuItem, i);
              AppMethodBeat.o(111590);
              return true;
            }
            i = 0;
          }
        }
      }, null, (s.b)localObject1);
      this.tZn = ((ImageButton)findViewById(2131303251));
      this.tZn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111591);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bu.isNullOrNil(paramAnonymousView))
          {
            ae.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111591);
            return;
          }
          ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousView);
          ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131759782) + ImagePreviewUI.cYR());
          ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
          a.a.tQr.ai(paramAnonymousView, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111591);
        }
      });
      this.tZo = ((TextView)findViewById(2131303253));
      this.tZo.setOnClickListener(new ImagePreviewUI.2(this));
      if (this.tfW == 1)
      {
        this.tZn.setVisibility(8);
        this.tZo.setVisibility(8);
      }
      this.tZp = ((ViewGroup)findViewById(2131298881));
      this.tZq = ((ViewGroup)findViewById(2131300337));
      if (this.tZp != null)
      {
        this.tZp.setVisibility(8);
        this.tZp.setOnClickListener(new ImagePreviewUI.3(this));
      }
      if (this.tZq != null)
      {
        this.tZq.setVisibility(8);
        this.tZq.setOnClickListener(new ImagePreviewUI.4(this));
      }
      this.tZv = ((TextView)findViewById(2131303244));
      this.tZv.setOnClickListener(new ImagePreviewUI.5(this));
      this.tZf = ((RecyclerView)findViewById(2131300956));
      this.tZf.getItemAnimator().ate = 66L;
      this.tZf.a(new RecyclerView.h()
      {
        public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.t paramAnonymoust)
        {
          AppMethodBeat.i(111564);
          int i = (int)ak.getContext().getResources().getDimension(2131165480);
          paramAnonymousRect.left = (i / 2);
          paramAnonymousRect.bottom = i;
          paramAnonymousRect.top = i;
          paramAnonymousRect.right = (i / 2);
          AppMethodBeat.o(111564);
        }
      });
      localObject1 = new SpeedyLinearLayoutManager();
      ((SpeedyLinearLayoutManager)localObject1).setOrientation(0);
      this.tZf.setLayoutManager((RecyclerView.i)localObject1);
      i = getResources().getDisplayMetrics().widthPixels / 7;
      localObject1 = new g(this, this.tZh, i, this.tYm);
      this.tZf.setAdapter((RecyclerView.a)localObject1);
      this.tZf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111565);
          int i = (int)ak.getContext().getResources().getDimension(2131165480);
          int j = ImagePreviewUI.this.getResources().getDisplayMetrics().widthPixels / 7;
          ImagePreviewUI.p(ImagePreviewUI.this).getLayoutParams().height = (i * 2 + j);
          RecyclerView localRecyclerView = ImagePreviewUI.p(ImagePreviewUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(ImagePreviewUI.g(ImagePreviewUI.this).intValue(), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahE(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$15", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          localRecyclerView.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$15", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(111565);
        }
      });
      if (this.tZh.size() <= 0) {
        break label1717;
      }
      this.tZf.setVisibility(0);
      label1237:
      this.tZf.setItemAnimator(new v());
      ((g)localObject1).uac.j(this.tZf);
      ((g)localObject1).tZZ = new g.b()
      {
        public final void HS(int paramAnonymousInt)
        {
          AppMethodBeat.i(111566);
          ae.i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(ImagePreviewUI.q(ImagePreviewUI.this)) });
          ((g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter()).gk(paramAnonymousInt, paramAnonymousInt);
          ImagePreviewUI.r(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt, false);
          if (!ImagePreviewUI.q(ImagePreviewUI.this))
          {
            com.tencent.mm.plugin.gallery.model.e.tRa = true;
            AppMethodBeat.o(111566);
            return;
          }
          com.tencent.mm.plugin.gallery.model.e.tQY = true;
          AppMethodBeat.o(111566);
        }
        
        public final void af(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(111568);
          ae.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), ImagePreviewUI.g(ImagePreviewUI.this) });
          if (!ImagePreviewUI.q(ImagePreviewUI.this))
          {
            com.tencent.mm.plugin.gallery.a.d.swap(ImagePreviewUI.s(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
            d locald = ImagePreviewUI.h(ImagePreviewUI.this);
            int i = ImagePreviewUI.g(ImagePreviewUI.this).intValue();
            ae.i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt3) });
            if (!locald.tYm)
            {
              com.tencent.mm.plugin.gallery.a.d.swap(locald.tYl, paramAnonymousInt1, paramAnonymousInt2);
              locald.dMM = paramAnonymousInt3;
              locald.tYo = ((View)locald.JJH.get(i));
              locald.JJF.remove(locald.tYo);
              locald.JJG.clear();
              locald.JJH.clear();
              locald.tYp = true;
              locald.notifyDataSetChanged();
            }
            ImagePreviewUI.r(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt3, false);
            ((g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter()).gk(paramAnonymousInt3, paramAnonymousInt3);
            com.tencent.mm.plugin.gallery.model.e.tQZ = true;
            AppMethodBeat.o(111568);
            return;
          }
          com.tencent.mm.plugin.gallery.a.d.swap(ImagePreviewUI.d(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.plugin.gallery.model.e.tQX = true;
          AppMethodBeat.o(111568);
        }
        
        public final void gj(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(111567);
          ae.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ImagePreviewUI.g(ImagePreviewUI.this) });
          AppMethodBeat.o(111567);
        }
      };
      this.tZe = ((MMViewPager)findViewById(2131300335));
      this.tZe.setVerticalFadingEdgeEnabled(false);
      this.tZe.setHorizontalFadingEdgeEnabled(false);
      this.tZe.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt)
        {
          AppMethodBeat.i(111574);
          if (ImagePreviewUI.h(ImagePreviewUI.this) != null) {
            ImagePreviewUI.h(ImagePreviewUI.this).tYt.onPageScrollStateChanged(paramAnonymousInt);
          }
          AppMethodBeat.o(111574);
        }
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          boolean bool2 = true;
          AppMethodBeat.i(111573);
          com.tencent.mm.plugin.gallery.model.e.HA(paramAnonymousInt);
          String str = ImagePreviewUI.h(ImagePreviewUI.this).getItem(paramAnonymousInt);
          ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousInt, str);
          boolean bool1 = ImagePreviewUI.d(ImagePreviewUI.this).contains(str);
          ImagePreviewUI.a(ImagePreviewUI.this, Integer.valueOf(paramAnonymousInt));
          Object localObject = ImagePreviewUI.e(ImagePreviewUI.this);
          int i;
          if (bool1)
          {
            i = ImagePreviewUI.cYS();
            ((ImageButton)localObject).setImageResource(i);
            if (!ImagePreviewUI.b(ImagePreviewUI.this)) {
              break label316;
            }
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691078);
            label105:
            if (ImagePreviewUI.t(ImagePreviewUI.this)) {
              ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691075);
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
            ImagePreviewUI.h(ImagePreviewUI.this).tYs.onPageSelected(paramAnonymousInt);
            ae.d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = ".concat(String.valueOf(paramAnonymousInt)));
            localObject = com.tencent.mm.plugin.gallery.model.e.alO(str);
            if ((ImagePreviewUI.u(ImagePreviewUI.this).getVisibility() == 0) || (ImagePreviewUI.v(ImagePreviewUI.this).getVisibility() == 0))
            {
              ImagePreviewUI.a(ImagePreviewUI.this, str, (GalleryItem.MediaItem)localObject);
              ImagePreviewUI.a(ImagePreviewUI.this, (GalleryItem.MediaItem)localObject);
            }
            AppMethodBeat.o(111573);
            return;
            i = 2131691077;
            break;
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691077);
            break label105;
            bool1 = false;
            break label148;
          }
        }
      });
      this.tZe.setSingleClickOverListener(new MMViewPager.e()
      {
        public final void aRO()
        {
          AppMethodBeat.i(111576);
          ImagePreviewUI.w(ImagePreviewUI.this);
          AppMethodBeat.o(111576);
        }
        
        public final void cYT() {}
      });
      this.tZd = new d(this);
      ((g)this.tZf.getAdapter()).tZW = this.tZd;
      if (this.tYm) {
        break label1729;
      }
      this.tZd.ae(this.tZg);
      this.tZd.tYm = false;
      if (this.tZg.size() <= 0) {
        break label1838;
      }
      localObject1 = (String)this.tZg.get(this.tZj.intValue());
    }
    for (;;)
    {
      this.tZe.setAdapter(this.tZd);
      this.tZe.setCurrentItem(this.tZj.intValue());
      this.tZd.dgI = this.tZj.intValue();
      i = cYO().indexOf(this.tZd.getItem(this.tZj.intValue()));
      ((g)this.tZf.getAdapter()).gk(i, this.tZj.intValue());
      localObject2 = com.tencent.mm.plugin.gallery.model.e.alO((String)localObject1);
      a((String)localObject1, (GalleryItem.MediaItem)localObject2);
      i((GalleryItem.MediaItem)localObject2);
      setMMTitle(this.tZj.intValue() + 1 + "/" + this.tZd.getCount());
      if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 25)
      {
        ((ViewGroup)this.tZf.getParent()).removeView(this.tZf);
        this.tZf.setVisibility(8);
        findViewById(2131303094).setVisibility(4);
        findViewById(2131300340).setVisibility(4);
        findViewById(2131303244).setVisibility(4);
        findViewById(2131300338).setVisibility(4);
        findViewById(2131306334).setVisibility(4);
        findViewById(2131300339).setVisibility(4);
      }
      AppMethodBeat.o(111597);
      return;
      this.tZk.setImageResource(2131691077);
      break;
      label1688:
      bool1 = false;
      break label628;
      label1693:
      bool1 = false;
      break label649;
      label1698:
      if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg != 25) {
        break label872;
      }
      localObject1 = s.b.JwL;
      break label872;
      label1717:
      this.tZf.setVisibility(8);
      break label1237;
      label1729:
      localObject1 = this.tZd;
      localObject2 = this.tWe;
      ((d)localObject1).tWe.clear();
      ((d)localObject1).tWe.addAll((Collection)localObject2);
      ((d)localObject1).reset();
      ((d)localObject1).notifyDataSetChanged();
      this.tZd.tYm = true;
      if (this.tZj.intValue() >= this.tWe.size()) {
        this.tZj = Integer.valueOf(0);
      }
      if (this.tWe.size() > 0) {
        localObject1 = ((GalleryItem.MediaItem)this.tWe.get(this.tZj.intValue())).tRJ;
      } else {
        label1838:
        localObject1 = "";
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    AppMethodBeat.i(111599);
    ae.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
    if (paramInt1 == 4371) {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    Object localObject;
    while (paramInt1 == 4372) {
      if ((paramIntent == null) || (this.tZf == null))
      {
        AppMethodBeat.o(111599);
        return;
        if (this.tZh.size() > 0)
        {
          alW((String)this.tZh.get(0));
        }
        else
        {
          ae.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[] { Integer.valueOf(this.tZh.size()) });
          continue;
          if (paramInt1 == 4370)
          {
            if (paramInt2 == -1)
            {
              localObject = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
              paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).videoPath);
              paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).thumbPath);
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject).dIW().v("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
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
        ArrayList localArrayList4 = ((g)this.tZf.getAdapter()).tZY;
        ArrayList localArrayList3 = this.tZh;
        this.tZG = (this.tZG + localCaptureVideoNormalModel.dIW().v("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)) + ";");
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
          if (!str.equalsIgnoreCase(bu.nullAsNil(this.path)))
          {
            localObject = str;
            if (!str.equalsIgnoreCase(bu.nullAsNil(this.tZF))) {}
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
          if (!str.equalsIgnoreCase(bu.nullAsNil(this.path)))
          {
            localObject = str;
            if (!str.equalsIgnoreCase(bu.nullAsNil(this.tZF))) {}
          }
          else
          {
            localObject = localCaptureVideoNormalModel.thumbPath;
          }
          localArrayList2.add(localObject);
          i += 1;
        }
        com.tencent.mm.vfs.o.deleteFile(this.tZF);
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
        if (this.tWR)
        {
          paramIntent = RecordConfigProvider.iP("", "");
          paramIntent.xOp = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
          paramIntent.scene = 2;
          localObject = new VideoCaptureReportInfo();
          ((VideoCaptureReportInfo)localObject).roH = 1;
          paramIntent.xOx = ((VideoCaptureReportInfo)localObject);
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).abH();
          ((UICustomParam.a)localObject).abG();
          ((UICustomParam.a)localObject).cP(true);
          paramIntent.xOh = ((UICustomParam.a)localObject).ggq;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4370, 2130772137, -1, paramIntent, 4, 0);
          AppMethodBeat.o(111599);
          return;
        }
        if (22 == com.tencent.mm.plugin.gallery.model.e.cXr().kXg)
        {
          setResult(-1, paramIntent);
          finish();
          AppMethodBeat.o(111599);
        }
      }
      else
      {
        Toast.makeText(this, 2131760707, 1).show();
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
    long l = bu.HQ();
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    new aq().post(new ImagePreviewUI.1(this, l));
    ae.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", new Object[] { Long.valueOf(bu.aO(l)) });
    initView();
    AppMethodBeat.o(111593);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111607);
    super.onDestroy();
    ae.i("MicroMsg.ImagePreviewUI", "onDestroy, %s.", new Object[] { this });
    if ((com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 3) && (getIntent().getBooleanExtra("preview_image", false)) && (getIntent().getIntExtra("max_select_count", 0) == 1))
    {
      ae.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
      com.tencent.mm.plugin.gallery.model.e.cXu().clear();
    }
    if (this.tZd != null) {
      this.tZd.release();
    }
    com.tencent.mm.plugin.gallery.model.e.aa(null);
    y.cSw.Kf().Ke();
    if (this.tZE != null) {
      com.tencent.mm.plugin.gallery.model.e.cXq().b(this.tZE);
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
    if (this.tZm != null) {
      this.tZm.stopTimer();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */