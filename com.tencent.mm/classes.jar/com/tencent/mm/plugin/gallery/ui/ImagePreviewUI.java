package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.v;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.model.m.a;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.q.b;
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
  private com.tencent.mm.remoteservice.d evl;
  private int gNT;
  private ServiceConnection kDI;
  private boolean kFQ;
  private com.tencent.mm.plugin.gallery.stub.a ndL;
  private ArrayList<GalleryItem.MediaItem> ndM;
  private String ndQ;
  private int neF;
  private long neK;
  private boolean neP;
  private HashMap<String, Integer> neT;
  private HashSet<String> neU;
  private TextView nes;
  private boolean nez;
  private c nfZ;
  private boolean nft;
  private int ngA;
  private String ngB;
  private MMViewPager nga;
  private RecyclerView ngb;
  private ArrayList<String> ngc;
  private ArrayList<String> ngd;
  private Integer nge;
  private ImageButton ngf;
  private TextView ngg;
  private ap ngh;
  private ImageButton ngi;
  private TextView ngj;
  private ViewGroup ngk;
  private ViewGroup ngl;
  private boolean ngm;
  private boolean ngn;
  private int ngo;
  private int ngp;
  private TextView ngq;
  private TextView ngr;
  private TextView ngs;
  private TextView ngt;
  private View ngu;
  private TextView ngv;
  private ProgressBar ngw;
  boolean ngx;
  private String ngy;
  private String ngz;
  private String path;
  
  public ImagePreviewUI()
  {
    AppMethodBeat.i(21529);
    this.ngm = true;
    this.ngn = true;
    this.nez = true;
    this.ngo = 0;
    this.neK = 0L;
    this.ngp = 10;
    this.ndL = null;
    this.evl = new com.tencent.mm.remoteservice.d(ah.getContext());
    this.neP = true;
    this.kDI = new ImagePreviewUI.1(this);
    this.ngx = false;
    this.ngz = "";
    this.neT = new HashMap();
    this.ngA = 300000;
    AppMethodBeat.o(21529);
  }
  
  private void PF(String paramString)
  {
    AppMethodBeat.i(21535);
    Object localObject;
    if (!this.ngd.contains(paramString)) {
      if (this.ngd.size() >= this.neF)
      {
        localObject = getResources().getQuantityString(2131361804, this.neF, new Object[] { Integer.valueOf(this.neF) });
        paramString = (String)localObject;
        if (!bo.isNullOrNil(this.ndQ))
        {
          paramString = (String)localObject;
          if (this.ndQ.equals("album_business_bubble_media_by_coordinate")) {
            paramString = getResources().getQuantityString(2131361805, this.neF, new Object[] { Integer.valueOf(this.neF) });
          }
        }
        h.bO(getContext(), paramString);
        this.ngi.setImageResource(2131231142);
      }
    }
    for (;;)
    {
      paramString = this.ngd.iterator();
      do
      {
        if (!paramString.hasNext()) {
          break;
        }
      } while (r.aoY((String)paramString.next()));
      AppMethodBeat.o(21535);
      return;
      localObject = com.tencent.mm.plugin.gallery.model.e.PB(paramString);
      if (localObject != null)
      {
        if ((((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().KG(paramString)))
        {
          h.bO(this, getString(2131300305));
          AppMethodBeat.o(21535);
          return;
        }
        if ((!bo.isNullOrNil(this.ndQ)) && (this.ndQ.equals("album_business_bubble_media_by_coordinate")) && ((localObject instanceof GalleryItem.VideoMediaItem)) && (((GalleryItem.VideoMediaItem)localObject).fQq >= this.gNT * 1000 + 500))
        {
          h.bO(getContext(), getContext().getResources().getString(2131300323));
          AppMethodBeat.o(21535);
          return;
        }
      }
      this.ngd.add(paramString);
      this.ngi.setImageResource(bED());
      b(this.ngd.size(), this.nge.intValue(), paramString, 0);
      continue;
      this.ngi.setImageResource(2131231142);
      while (this.ngd.remove(paramString)) {}
      b(this.ngd.size(), this.nge.intValue(), paramString, 1);
    }
    this.kFQ = true;
    AppMethodBeat.o(21535);
  }
  
  private void PG(String paramString)
  {
    AppMethodBeat.i(21545);
    if ((this.ngd.size() >= 9) && (!this.ngd.contains(paramString)))
    {
      this.ngq.setTextColor(getContext().getResources().getColor(2131690712));
      this.ngq.setEnabled(false);
      AppMethodBeat.o(21545);
      return;
    }
    this.ngq.setEnabled(true);
    this.ngq.setTextColor(getContext().getResources().getColor(2131690711));
    AppMethodBeat.o(21545);
  }
  
  private boolean PH(String paramString)
  {
    AppMethodBeat.i(21548);
    if (com.tencent.mm.vfs.e.avI(paramString) > 1073741824L)
    {
      this.ngr.setText(getString(2131300299));
      this.ngs.setText(getString(2131300298));
      AppMethodBeat.o(21548);
      return true;
    }
    AppMethodBeat.o(21548);
    return false;
  }
  
  private boolean PI(String paramString)
  {
    AppMethodBeat.i(21553);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21553);
      return true;
    }
    if (this.neU == null)
    {
      this.neU = new HashSet();
      this.neU.add(".h264");
      this.neU.add(".h26l");
      this.neU.add(".264");
      this.neU.add(".avc");
      this.neU.add(".mov");
      this.neU.add(".mp4");
      this.neU.add(".m4a");
      this.neU.add(".3gp");
      this.neU.add(".3g2");
      this.neU.add(".mj2");
      this.neU.add(".m4v");
    }
    paramString = paramString.trim();
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length()))
    {
      AppMethodBeat.o(21553);
      return true;
    }
    if (!this.neU.contains(paramString.substring(i).toLowerCase()))
    {
      AppMethodBeat.o(21553);
      return true;
    }
    AppMethodBeat.o(21553);
    return false;
  }
  
  private void PJ(String paramString)
  {
    AppMethodBeat.i(21555);
    Object localObject = Boolean.FALSE;
    Boolean localBoolean;
    GalleryItem.MediaItem localMediaItem;
    switch (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK)
    {
    default: 
      localBoolean = Boolean.FALSE;
      localMediaItem = com.tencent.mm.plugin.gallery.model.e.PB(paramString);
      localObject = localBoolean;
      if (localMediaItem != null)
      {
        localObject = localBoolean;
        if (localMediaItem.getType() == 2) {
          localObject = Boolean.TRUE;
        }
      }
      if ((localMediaItem == null) && (r.aoY(paramString))) {
        paramString = Boolean.TRUE;
      }
      break;
    }
    for (;;)
    {
      if (!paramString.booleanValue()) {
        break label185;
      }
      this.ngf.setVisibility(8);
      this.nes.setVisibility(8);
      AppMethodBeat.o(21555);
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
    label185:
    this.ngf.setVisibility(0);
    this.nes.setVisibility(0);
    AppMethodBeat.o(21555);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(21544);
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || ((com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 4) && (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 14) && (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 13)))
    {
      this.ngm = true;
      this.ngk.setVisibility(0);
      this.ngl.setVisibility(8);
      this.ngw.setVisibility(8);
      b(paramString, paramMediaItem);
      PJ(paramString);
      enableOptionMenu(true);
      this.ngg.setVisibility(8);
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
        this.ngq.setVisibility(0);
      }
      for (;;)
      {
        if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 15) {
          this.ngq.setVisibility(8);
        }
        PG(paramString);
        AppMethodBeat.o(21544);
        return;
        boolean bool = getIntent().getBooleanExtra("preview_image", false);
        ab.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.bDQ().hQK), Boolean.valueOf(bool), paramString });
        if ((paramMediaItem == null) && (!bo.isNullOrNil(paramString))) {
          this.ngq.setVisibility(0);
        } else {
          this.ngq.setVisibility(8);
        }
      }
    }
    if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
      this.ngq.setVisibility(0);
    }
    GalleryItem.VideoMediaItem localVideoMediaItem;
    for (;;)
    {
      PG(paramString);
      localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
      enableOptionMenu(false);
      this.ngm = false;
      this.ngk.setVisibility(8);
      this.ngl.setVisibility(0);
      this.ngv.setVisibility(8);
      if (!PH(paramString)) {
        break;
      }
      AppMethodBeat.o(21544);
      return;
      this.ngq.setVisibility(8);
    }
    if (!bo.isNullOrNil(localVideoMediaItem.fQo))
    {
      ab.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.fQn, Integer.valueOf(localVideoMediaItem.fQq), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
      a(paramString, localVideoMediaItem);
      AppMethodBeat.o(21544);
      return;
    }
    enableOptionMenu(false);
    this.ngm = true;
    this.ngk.setVisibility(0);
    this.ngl.setVisibility(8);
    this.ngg.setVisibility(8);
    b(paramString, paramMediaItem);
    PJ(paramString);
    paramMediaItem = new m(paramString, this.nge.intValue(), localVideoMediaItem, new ImagePreviewUI.18(this));
    if (com.tencent.mm.sdk.g.d.ysm.an(paramMediaItem))
    {
      ab.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { paramString });
      AppMethodBeat.o(21544);
      return;
    }
    com.tencent.mm.sdk.g.d.post(paramMediaItem, "video_analysis");
    if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 15) {
      this.ngq.setVisibility(8);
    }
    AppMethodBeat.o(21544);
  }
  
  private void a(String paramString, GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(21546);
    enableOptionMenu(false);
    this.ngm = false;
    this.ngk.setVisibility(8);
    this.ngl.setVisibility(0);
    this.ngv.setVisibility(8);
    if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 13)
    {
      this.ngl.setVisibility(8);
      this.ngk.setVisibility(8);
      this.ngr.setVisibility(8);
      this.ngs.setVisibility(8);
      enableOptionMenu(true);
      AppMethodBeat.o(21546);
      return;
    }
    if (b(paramVideoMediaItem))
    {
      AppMethodBeat.o(21546);
      return;
    }
    if (c(paramVideoMediaItem))
    {
      AppMethodBeat.o(21546);
      return;
    }
    if (a(paramVideoMediaItem))
    {
      AppMethodBeat.o(21546);
      return;
    }
    enableOptionMenu(true);
    this.ngm = true;
    this.ngk.setVisibility(0);
    this.ngl.setVisibility(8);
    this.ngg.setVisibility(0);
    this.ngw.setVisibility(8);
    b(paramString, paramVideoMediaItem);
    PJ(paramString);
    AppMethodBeat.o(21546);
  }
  
  private boolean a(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(21549);
    ab.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[] { Integer.valueOf(paramVideoMediaItem.fQq) });
    if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 13)
    {
      AppMethodBeat.o(21549);
      return false;
    }
    if (paramVideoMediaItem.fQq <= 1000)
    {
      this.ngr.setText(getString(2131300303));
      this.ngs.setText(getString(2131300302));
      AppMethodBeat.o(21549);
      return true;
    }
    if (paramVideoMediaItem.fQq >= 300000)
    {
      this.ngr.setText(getString(2131300301));
      this.ngs.setText(getString(2131300300));
      AppMethodBeat.o(21549);
      return true;
    }
    if (paramVideoMediaItem.fQq >= this.ngp * 1000 + 500)
    {
      this.ngr.setText(getString(2131300288));
      this.ngs.setText(getString(2131300287, new Object[] { Integer.valueOf(this.ngp) }));
      this.ngv.setVisibility(0);
      AppMethodBeat.o(21549);
      return true;
    }
    AppMethodBeat.o(21549);
    return false;
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(21556);
    ab.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((-1 != paramInt2) && (!this.nft))
    {
      this.ngb.getAdapter().c(paramInt2, Integer.valueOf(paramInt2));
      if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 13) {
        break label269;
      }
    }
    label269:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      paramString = this.nfZ.wV(this.nge.intValue());
      if ((paramInt1 != 0) && (((!this.nez) && (paramInt2 == 0)) || (this.nfZ == null) || (paramString == null) || (paramString.getType() != 2))) {
        break label274;
      }
      this.ngb.setVisibility(8);
      AppMethodBeat.o(21556);
      return;
      if (-1 == paramInt2) {
        break;
      }
      if ((paramInt3 == 0) && (paramInt1 > 0))
      {
        ((f)this.ngb.getAdapter()).addItem(paramString);
        ((f)this.ngb.getAdapter()).eu(paramInt1 - 1, this.nge.intValue());
        this.ngb.getAdapter().bS(paramInt1 - 1);
        this.ngb.smoothScrollToPosition(paramInt1 - 1);
        break;
      }
      if (paramInt3 != 1) {
        break;
      }
      paramInt2 = ((f)this.ngb.getAdapter()).indexOf(paramString);
      if (-1 == paramInt2) {
        break;
      }
      ((f)this.ngb.getAdapter()).remove(paramInt2);
      this.ngb.getAdapter().bT(paramInt2);
      break;
    }
    label274:
    this.ngb.setVisibility(0);
    AppMethodBeat.o(21556);
  }
  
  private void b(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(21547);
    if (paramMediaItem == null)
    {
      ab.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
      AppMethodBeat.o(21547);
      return;
    }
    Object localObject;
    if (paramMediaItem.getType() == 2)
    {
      GalleryItem.VideoMediaItem localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
      this.ngA = 300000;
      this.ngB = getString(2131300300);
      if ((this.ndQ != null) && (this.ndQ.equals("album_business_bubble_media_by_coordinate")))
      {
        this.ngA = (this.gNT * 1000 + 500);
        this.ngB = getString(2131300323, new Object[] { Integer.valueOf(this.gNT) });
      }
      if (!bo.isNullOrNil(localVideoMediaItem.fQo))
      {
        ab.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.fQn, Integer.valueOf(localVideoMediaItem.fQq), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
        if ((localVideoMediaItem.fQq >= this.ngA) || ((localVideoMediaItem.fQq > 0) && (localVideoMediaItem.fQq < 1000)))
        {
          this.ngu.setVisibility(0);
          localObject = this.ngt;
          if (localVideoMediaItem.fQq >= this.ngA) {}
          for (paramMediaItem = this.ngB;; paramMediaItem = getString(2131300302))
          {
            ((TextView)localObject).setText(paramMediaItem);
            this.ngj.setEnabled(false);
            this.ngi.setEnabled(false);
            this.ngj.setTextColor(getResources().getColor(2131690712));
            if (this.ngd.size() != 0) {
              break;
            }
            enableOptionMenu(false);
            AppMethodBeat.o(21547);
            return;
          }
        }
        this.ngj.setEnabled(true);
        this.ngi.setEnabled(true);
        this.ngj.setTextColor(getResources().getColor(2131690711));
        this.ngu.setVisibility(8);
        AppMethodBeat.o(21547);
        return;
      }
      localObject = new m(paramMediaItem.fQn, this.nge.intValue(), localVideoMediaItem, new m.a()
      {
        public final void a(m paramAnonymousm)
        {
          AppMethodBeat.i(150894);
          if (paramAnonymousm.position != ImagePreviewUI.g(ImagePreviewUI.this).intValue())
          {
            AppMethodBeat.o(150894);
            return;
          }
          if ((paramAnonymousm.ndF.fQq >= ImagePreviewUI.y(ImagePreviewUI.this)) || ((paramAnonymousm.ndF.fQq > 0) && (paramAnonymousm.ndF.fQq < 1000)))
          {
            ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
            TextView localTextView = ImagePreviewUI.A(ImagePreviewUI.this);
            if (paramAnonymousm.ndF.fQq >= ImagePreviewUI.y(ImagePreviewUI.this)) {}
            for (paramAnonymousm = ImagePreviewUI.z(ImagePreviewUI.this);; paramAnonymousm = ImagePreviewUI.this.getString(2131300302))
            {
              localTextView.setText(paramAnonymousm);
              ImagePreviewUI.B(ImagePreviewUI.this).setEnabled(false);
              ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(false);
              ImagePreviewUI.B(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(2131690712));
              if (ImagePreviewUI.d(ImagePreviewUI.this).size() != 0) {
                break;
              }
              ImagePreviewUI.this.enableOptionMenu(false);
              AppMethodBeat.o(150894);
              return;
            }
          }
          ImagePreviewUI.B(ImagePreviewUI.this).setEnabled(true);
          ImagePreviewUI.e(ImagePreviewUI.this).setEnabled(true);
          ImagePreviewUI.B(ImagePreviewUI.this).setTextColor(ImagePreviewUI.this.getResources().getColor(2131690711));
          ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(8);
          AppMethodBeat.o(150894);
        }
      });
      if (com.tencent.mm.sdk.g.d.ysm.an((Runnable)localObject))
      {
        ab.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { paramMediaItem.fQn });
        AppMethodBeat.o(21547);
        return;
      }
      com.tencent.mm.sdk.g.d.post((Runnable)localObject, "video_analysis");
      AppMethodBeat.o(21547);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      this.ngj.setEnabled(true);
      this.ngi.setEnabled(true);
      this.ngj.setTextColor(getResources().getColor(2131690711));
      if ((this.kFQ) && (this.ngd.contains(paramMediaItem.fQn)) && (com.tencent.mm.vfs.e.avI(paramMediaItem.fQn) > 26214400L))
      {
        this.ngu.setVisibility(0);
        this.ngt.setText(getString(2131300307));
        AppMethodBeat.o(21547);
        return;
      }
      this.ngu.setVisibility(8);
      AppMethodBeat.o(21547);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      localObject = new com.tencent.mm.plugin.gif.f(paramMediaItem.fQn);
      long l = com.tencent.mm.vfs.e.avI(paramMediaItem.fQn);
      try
      {
        if (((!this.ngd.contains(paramMediaItem.fQn)) || (l == 0L) || (l <= this.ndL.MW())) && (localObject.nFh[0] <= this.ndL.MV()) && (localObject.nFh[1] <= this.ndL.MV())) {
          break label757;
        }
        this.ngj.setTextColor(getResources().getColor(2131690712));
        this.ngj.setEnabled(false);
        this.ngi.setEnabled(false);
        AppMethodBeat.o(21547);
        return;
      }
      catch (Exception paramMediaItem)
      {
        ab.e("MicroMsg.ImagePreviewUI", bo.l(paramMediaItem));
      }
    }
    else
    {
      AppMethodBeat.o(21547);
      return;
    }
    label757:
    this.ngj.setTextColor(getResources().getColor(2131690711));
    this.ngj.setEnabled(true);
    this.ngi.setEnabled(true);
    AppMethodBeat.o(21547);
  }
  
  private void b(String paramString, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(21554);
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 4))
    {
      if (this.neF == 1)
      {
        this.ngi.setVisibility(8);
        this.ngj.setVisibility(8);
      }
      while (!this.ngd.contains(paramString))
      {
        this.ngi.setImageResource(2131231142);
        AppMethodBeat.o(21554);
        return;
        this.ngi.setVisibility(0);
        this.ngj.setVisibility(0);
      }
      this.ngi.setImageResource(bED());
      AppMethodBeat.o(21554);
      return;
    }
    this.ngi.setVisibility(8);
    this.ngj.setVisibility(8);
    AppMethodBeat.o(21554);
  }
  
  private boolean b(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(21551);
    if ((paramVideoMediaItem == null) || (paramVideoMediaItem.videoWidth <= 0) || (paramVideoMediaItem.videoHeight <= 0) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight > 3.0F) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight < 0.3F))
    {
      if (paramVideoMediaItem != null) {
        ab.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramVideoMediaItem.videoWidth), Integer.valueOf(paramVideoMediaItem.videoHeight) });
      }
      this.ngr.setText(getString(2131300296));
      this.ngs.setText(getString(2131300297));
      AppMethodBeat.o(21551);
      return true;
    }
    AppMethodBeat.o(21551);
    return false;
  }
  
  private String bEA()
  {
    AppMethodBeat.i(21537);
    switch (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK)
    {
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 12: 
    default: 
      if ((this.ngd.size() == 0) || (this.neF <= 1))
      {
        str = getString(2131297067);
        AppMethodBeat.o(21537);
        return str;
      }
      break;
    case 4: 
    case 8: 
    case 13: 
    case 14: 
      if ((this.ngd.size() == 0) || (this.neF <= 1))
      {
        str = getString(2131300291);
        AppMethodBeat.o(21537);
        return str;
      }
      str = getString(2131300291) + "(" + this.ngd.size() + "/" + this.neF + ")";
      AppMethodBeat.o(21537);
      return str;
    case 11: 
      str = getString(2131299261);
      AppMethodBeat.o(21537);
      return str;
    case 7: 
    case 15: 
      if ((!bo.isNullOrNil(this.ndQ)) && (this.ndQ.equals("album_business_bubble_media_by_coordinate")))
      {
        if ((this.ngd.size() == 0) || (this.neF <= 1))
        {
          str = getString(2131297013);
          AppMethodBeat.o(21537);
          return str;
        }
        str = getString(2131297013) + "(" + this.ngd.size() + "/" + this.neF + ")";
        AppMethodBeat.o(21537);
        return str;
      }
      if ((this.ngd.size() == 0) || (this.neF <= 1))
      {
        str = getString(2131300291);
        AppMethodBeat.o(21537);
        return str;
      }
      str = getString(2131300291) + "(" + this.ngd.size() + "/" + this.neF + ")";
      AppMethodBeat.o(21537);
      return str;
    }
    String str = getString(2131300283, new Object[] { Integer.valueOf(this.ngd.size()), Integer.valueOf(this.neF) });
    AppMethodBeat.o(21537);
    return str;
  }
  
  private ArrayList<String> bEB()
  {
    AppMethodBeat.i(21538);
    if (this.nft)
    {
      localArrayList = this.ngd;
      AppMethodBeat.o(21538);
      return localArrayList;
    }
    if (this.ngd != null)
    {
      localArrayList = new ArrayList(this.ngd.size());
      Iterator localIterator = this.ngc.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.ngd.contains(str)) {
          localArrayList.add(str);
        }
      }
      AppMethodBeat.o(21538);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList(1);
    AppMethodBeat.o(21538);
    return localArrayList;
  }
  
  private boolean bEC()
  {
    AppMethodBeat.i(21550);
    this.ngr.setText(getString(2131300294));
    this.ngs.setText(getString(2131300295));
    AppMethodBeat.o(21550);
    return true;
  }
  
  private static int bED()
  {
    AppMethodBeat.i(150899);
    if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 15)
    {
      AppMethodBeat.o(150899);
      return 2131231138;
    }
    AppMethodBeat.o(150899);
    return 2131231137;
  }
  
  private boolean c(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(21552);
    ab.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[] { paramVideoMediaItem });
    int i;
    if (paramVideoMediaItem != null) {
      if (("video/hevc".equalsIgnoreCase(paramVideoMediaItem.fQo)) && (com.tencent.mm.plugin.n.e.bQq())) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((paramVideoMediaItem == null) || (bo.isNullOrNil(paramVideoMediaItem.fQn)) || (PI(paramVideoMediaItem.fQn)) || (i == 0) || ((!bo.isNullOrNil(paramVideoMediaItem.fQp)) && (!"audio/mp4a-latm".equalsIgnoreCase(paramVideoMediaItem.fQp))))
      {
        if (paramVideoMediaItem == null) {}
        for (paramVideoMediaItem = null;; paramVideoMediaItem = paramVideoMediaItem.fQo)
        {
          ab.i("MicroMsg.ImagePreviewUI", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramVideoMediaItem });
          bEC();
          AppMethodBeat.o(21552);
          return true;
          if (!"video/avc".equalsIgnoreCase(paramVideoMediaItem.fQo)) {
            break label170;
          }
          i = 1;
          break;
        }
      }
      AppMethodBeat.o(21552);
      return false;
      label170:
      i = 0;
    }
  }
  
  private void d(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(150898);
    if ((paramInt == -1) && (paramIntent != null))
    {
      this.ngx = true;
      String str1 = paramIntent.getStringExtra("raw_photo_path");
      Object localObject1 = com.tencent.mm.plugin.gallery.model.e.bDU().iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (str1.equals(((Bundle)((Iterator)localObject1).next()).getString("raw_photo_path"))) {
          ((Iterator)localObject1).remove();
        }
      }
      com.tencent.mm.plugin.gallery.model.e.bDU().add(paramIntent.getBundleExtra("report_info"));
      localObject1 = paramIntent.getStringExtra("after_photo_edit");
      String str2 = paramIntent.getStringExtra("tmp_photo_edit");
      ab.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath;%s", new Object[] { str1, localObject1 });
      if (this.ngc != null)
      {
        this.ngc.clear();
        Object localObject2 = paramIntent.getStringArrayListExtra("preview_image_list");
        if (localObject2 != null) {
          this.ngc.addAll((Collection)localObject2);
        }
        localObject2 = this.nfZ.wV(this.nge.intValue());
        if (localObject2 == null)
        {
          ab.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { this.nge, str1, localObject1 });
          AppMethodBeat.o(150898);
          return;
        }
        ((GalleryItem.MediaItem)localObject2).ndn = str1;
        ((GalleryItem.MediaItem)localObject2).fQn = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject2).mnt = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject2).ndo = str2;
        ((GalleryItem.MediaItem)localObject2).mMimeType = "edit";
        com.tencent.mm.plugin.gallery.model.e.bDT().add(localObject2);
        com.tencent.mm.plugin.gallery.model.e.bDP().a(new ImagePreviewUI.13(this, paramIntent));
        com.tencent.mm.plugin.gallery.model.e.bDP().b((String)localObject1, ((GalleryItem.MediaItem)localObject2).getType(), (String)localObject1, ((GalleryItem.MediaItem)localObject2).ndp);
        ab.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
      }
    }
    AppMethodBeat.o(150898);
  }
  
  private void goBack()
  {
    boolean bool2 = true;
    AppMethodBeat.i(21541);
    Intent localIntent = new Intent();
    boolean bool1;
    if (!this.kFQ)
    {
      bool1 = true;
      if (!this.nez) {
        break label89;
      }
      bool1 = bool2;
    }
    label89:
    for (;;)
    {
      localIntent.putExtra("CropImage_Compress_Img", bool1);
      localIntent.putStringArrayListExtra("preview_image_list", bEB());
      localIntent.putExtra("show_photo_edit_tip", this.ngx);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(21541);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void hW(boolean paramBoolean)
  {
    AppMethodBeat.i(21539);
    if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 4)
    {
      AppMethodBeat.o(21539);
      return;
    }
    if (this.nfZ == null)
    {
      ab.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
      AppMethodBeat.o(21539);
      return;
    }
    GalleryItem.MediaItem localMediaItem = this.nfZ.wV(this.nge.intValue());
    if ((paramBoolean) && (localMediaItem != null))
    {
      this.ngu.postDelayed(new ImagePreviewUI.17(this, localMediaItem), 400L);
      AppMethodBeat.o(21539);
      return;
    }
    this.ngu.setVisibility(8);
    AppMethodBeat.o(21539);
  }
  
  private void hX(boolean paramBoolean)
  {
    AppMethodBeat.i(21540);
    ab.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + paramBoolean + "], selectedNormalFooter = " + this.ngm);
    if (this.ngm)
    {
      localObject = findViewById(2131823281);
      if (localObject != null) {
        break label136;
      }
      if (!this.ngm) {
        break label129;
      }
    }
    label129:
    for (Object localObject = "normal";; localObject = "edit_tips")
    {
      ab.w("MicroMsg.ImagePreviewUI", "set footer[%s] visibility[%B], but footerbar null", new Object[] { localObject, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(21540);
      return;
      localObject = findViewById(2131825133);
      if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 15) {
        break;
      }
      AppMethodBeat.o(21540);
      return;
    }
    label136:
    if (((paramBoolean) && (((View)localObject).getVisibility() == 0)) || ((!paramBoolean) && (((View)localObject).getVisibility() == 8)))
    {
      AppMethodBeat.o(21540);
      return;
    }
    if (paramBoolean)
    {
      ((View)localObject).setVisibility(0);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, 2131034181));
    }
    while ((paramBoolean) && (this.ngb.getVisibility() == 8) && (this.ngd.size() > 0))
    {
      this.ngb.setVisibility(0);
      localObject = AnimationUtils.loadAnimation(this, 2131034181);
      this.ngb.startAnimation((Animation)localObject);
      AppMethodBeat.o(21540);
      return;
      ((View)localObject).setVisibility(8);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, 2131034182));
    }
    if ((!paramBoolean) && (this.ngb.getVisibility() == 0))
    {
      this.ngb.setVisibility(8);
      localObject = AnimationUtils.loadAnimation(this, 2131034182);
      this.ngb.startAnimation((Animation)localObject);
    }
    AppMethodBeat.o(21540);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(21533);
    if (b.bI(this))
    {
      setContentView(paramView);
      AppMethodBeat.o(21533);
      return;
    }
    af.h(af.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(21533);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969896;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21534);
    this.ngr = ((TextView)findViewById(2131825134));
    this.ngs = ((TextView)findViewById(2131825136));
    this.ngt = ((TextView)findViewById(2131825126));
    this.ngu = findViewById(2131825125);
    this.ngu.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150896);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)ImagePreviewUI.a(ImagePreviewUI.this).getLayoutParams();
        localMarginLayoutParams.topMargin = ((int)(j.at(ImagePreviewUI.this) + ImagePreviewUI.this.getResources().getDimension(2131427559)));
        ImagePreviewUI.a(ImagePreviewUI.this).setLayoutParams(localMarginLayoutParams);
        AppMethodBeat.o(150896);
      }
    }, 100L);
    this.ngv = ((TextView)findViewById(2131825135));
    this.ngw = ((ProgressBar)findViewById(2131825129));
    this.neF = getIntent().getIntExtra("max_select_count", 9);
    this.ngp = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
    Object localObject1;
    boolean bool2;
    if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 4)
    {
      bool1 = true;
      this.nez = bool1;
      localObject1 = getIntent();
      this.ngc = ((Intent)localObject1).getStringArrayListExtra("preview_image_list");
      this.ngd = new ArrayList();
      if (this.ngc != null) {
        this.ngd.addAll(this.ngc);
      }
      this.ndM = com.tencent.mm.plugin.gallery.model.e.bDS();
      bool2 = ((Intent)localObject1).getBooleanExtra("preview_all", false);
      if (this.ndM != null) {
        break label385;
      }
    }
    label385:
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.i("MicroMsg.ImagePreviewUI", "preview all[%B] mediaitems is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (this.ndM != null))
      {
        this.nft = true;
        this.nge = Integer.valueOf(((Intent)localObject1).getIntExtra("preview_position", 0));
        ab.i("MicroMsg.ImagePreviewUI", "start position=%d", new Object[] { this.nge });
        if (this.nge.intValue() >= 0) {}
      }
      else
      {
        this.nge = Integer.valueOf(0);
      }
      com.tencent.mm.plugin.gallery.model.e.wG(this.nge.intValue());
      if ((this.nft) || ((this.ngd != null) && (this.ngd.size() != 0))) {
        break label390;
      }
      ab.e("MicroMsg.ImagePreviewUI", "not preview all items and imagepaths is null or empty");
      finish();
      AppMethodBeat.o(21534);
      return;
      bool1 = false;
      break;
    }
    label390:
    this.ngf = ((ImageButton)findViewById(2131822823));
    this.nes = ((TextView)findViewById(2131822824));
    this.ngg = ((TextView)findViewById(2131825128));
    this.kFQ = ((Intent)localObject1).getBooleanExtra("send_raw_img", false);
    this.ngo = ((Intent)localObject1).getIntExtra("query_source_type", 0);
    Object localObject2;
    int i;
    if (this.kFQ)
    {
      this.ngf.setImageResource(2131231906);
      if ((this.ngd != null) && (this.ngd.size() == 1))
      {
        localObject2 = (String)this.ngd.get(0);
        if (((String)localObject2).endsWith(".jpg")) {
          al.d(new ImagePreviewUI.11(this, (String)localObject2));
        }
      }
      this.nes.setText(getContext().getString(2131300289));
      this.ngf.setOnClickListener(new ImagePreviewUI.24(this));
      this.ngg.setOnClickListener(new ImagePreviewUI.25(this));
      this.ngv.setOnClickListener(new ImagePreviewUI.26(this));
      this.nes.setOnClickListener(new ImagePreviewUI.27(this));
      setBackBtn(new ImagePreviewUI.28(this));
      this.ndQ = ((Intent)localObject1).getStringExtra("album_business_tag");
      this.gNT = ((Intent)localObject1).getIntExtra("album_video_max_duration", 10);
      localObject1 = q.b.zby;
      if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 15) {
        localObject1 = q.b.zbI;
      }
      if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 14) {
        addTextOptionMenu(0, bEA(), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            int j = 0;
            AppMethodBeat.i(150878);
            if (ImagePreviewUI.k(ImagePreviewUI.this) == 6)
            {
              ImagePreviewUI.this.setResult(1);
              ImagePreviewUI.this.finish();
            }
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("isPreviewPhoto", ImagePreviewUI.this.getIntent().getBooleanExtra("isPreviewPhoto", false));
            Object localObject = ImagePreviewUI.l(ImagePreviewUI.this);
            int i;
            if ((localObject != null) && (((ArrayList)localObject).size() == 0))
            {
              localObject = ImagePreviewUI.h(ImagePreviewUI.this).wV(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              if ((ImagePreviewUI.m(ImagePreviewUI.this)) && (ImagePreviewUI.h(ImagePreviewUI.this) != null) && (localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 2))
              {
                ImagePreviewUI.a(ImagePreviewUI.this, ((GalleryItem.MediaItem)localObject).fQn);
                i = 0;
              }
            }
            for (;;)
            {
              if (!ImagePreviewUI.b(ImagePreviewUI.this)) {}
              boolean bool2;
              for (boolean bool1 = true;; bool1 = false)
              {
                bool2 = ImagePreviewUI.m(ImagePreviewUI.this);
                if (i != 0) {
                  break label223;
                }
                ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousMenuItem, bool2, bool1);
                AppMethodBeat.o(150878);
                return true;
                ImagePreviewUI.e(ImagePreviewUI.this).performClick();
                i = 300;
                break;
              }
              label223:
              localObject = com.tencent.mm.plugin.gallery.model.e.bDR();
              paramAnonymousMenuItem = new ImagePreviewUI.2.1(this, paramAnonymousMenuItem, bool2, bool1);
              if (i < 0) {
                i = j;
              }
              for (;;)
              {
                ((com.tencent.mm.plugin.gallery.model.g)localObject).bEf().postDelayed(paramAnonymousMenuItem, i);
                AppMethodBeat.o(150878);
                return true;
              }
              i = 0;
            }
          }
        }, null, (q.b)localObject1);
      }
      this.ngi = ((ImageButton)findViewById(2131825131));
      this.ngi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21500);
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bo.isNullOrNil(paramAnonymousView))
          {
            ab.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            AppMethodBeat.o(21500);
            return;
          }
          ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousView);
          ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131300289) + ImagePreviewUI.bEE());
          ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
          AppMethodBeat.o(21500);
        }
      });
      this.ngj = ((TextView)findViewById(2131825130));
      this.ngj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(150879);
          ImagePreviewUI.e(ImagePreviewUI.this).performClick();
          AppMethodBeat.o(150879);
        }
      });
      if (this.neF == 1)
      {
        this.ngi.setVisibility(8);
        this.ngj.setVisibility(8);
      }
      this.ngk = ((ViewGroup)findViewById(2131823281));
      this.ngl = ((ViewGroup)findViewById(2131825133));
      if (this.ngk != null)
      {
        this.ngk.setVisibility(8);
        this.ngk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView) {}
        });
      }
      if (this.ngl != null)
      {
        this.ngl.setVisibility(8);
        this.ngl.setOnClickListener(new ImagePreviewUI.6(this));
      }
      this.ngq = ((TextView)findViewById(2131825127));
      this.ngq.setOnClickListener(new ImagePreviewUI.7(this));
      this.ngb = ((RecyclerView)findViewById(2131825124));
      this.ngb.getItemAnimator().ajh = 66L;
      this.ngb.b(new ImagePreviewUI.8(this));
      localObject1 = new g();
      ((g)localObject1).setOrientation(0);
      this.ngb.setLayoutManager((RecyclerView.i)localObject1);
      i = getResources().getDisplayMetrics().widthPixels / 7;
      localObject1 = new f(this, this.ngd, i, this.nft);
      this.ngb.setAdapter((RecyclerView.a)localObject1);
      this.ngb.post(new ImagePreviewUI.9(this));
      if (this.ngd.size() <= 0) {
        break label1389;
      }
      this.ngb.setVisibility(0);
      label1055:
      this.ngb.setItemAnimator(new v());
      ((f)localObject1).ngT.i(this.ngb);
      ((f)localObject1).ngN = new f.b()
      {
        public final void W(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(150885);
          ab.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), ImagePreviewUI.g(ImagePreviewUI.this) });
          if (!ImagePreviewUI.q(ImagePreviewUI.this))
          {
            com.tencent.mm.plugin.gallery.a.a.swap(ImagePreviewUI.s(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
            c localc = ImagePreviewUI.h(ImagePreviewUI.this);
            int i = ImagePreviewUI.g(ImagePreviewUI.this).intValue();
            ab.i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt3) });
            if (!localc.nft)
            {
              com.tencent.mm.plugin.gallery.a.a.swap(localc.nfs, paramAnonymousInt1, paramAnonymousInt2);
              localc.nfv = paramAnonymousInt3;
              localc.nfw = ((View)localc.znN.get(i));
              localc.znL.remove(localc.nfw);
              localc.znM.clear();
              localc.znN.clear();
              localc.nfx = true;
              localc.notifyDataSetChanged();
            }
            ImagePreviewUI.r(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt3, false);
            ((f)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter()).eu(paramAnonymousInt3, paramAnonymousInt3);
            com.tencent.mm.plugin.gallery.model.e.ncW = true;
            AppMethodBeat.o(150885);
            return;
          }
          com.tencent.mm.plugin.gallery.a.a.swap(ImagePreviewUI.d(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.plugin.gallery.model.e.ncU = true;
          AppMethodBeat.o(150885);
        }
        
        public final void et(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(150884);
          ab.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ImagePreviewUI.g(ImagePreviewUI.this) });
          AppMethodBeat.o(150884);
        }
        
        public final void wY(int paramAnonymousInt)
        {
          AppMethodBeat.i(150883);
          ab.i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(ImagePreviewUI.q(ImagePreviewUI.this)) });
          ((f)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter()).eu(paramAnonymousInt, paramAnonymousInt);
          ImagePreviewUI.r(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt, false);
          if (!ImagePreviewUI.q(ImagePreviewUI.this))
          {
            com.tencent.mm.plugin.gallery.model.e.ncX = true;
            AppMethodBeat.o(150883);
            return;
          }
          com.tencent.mm.plugin.gallery.model.e.ncV = true;
          AppMethodBeat.o(150883);
        }
      };
      this.nga = ((MMViewPager)findViewById(2131822137));
      this.nga.setVerticalFadingEdgeEnabled(false);
      this.nga.setHorizontalFadingEdgeEnabled(false);
      this.nga.setOnPageChangeListener(new ImagePreviewUI.14(this));
      this.nga.setSingleClickOverListener(new ImagePreviewUI.15(this));
      this.nfZ = new c(this);
      ((f)this.ngb.getAdapter()).ngK = this.nfZ;
      if (this.nft) {
        break label1401;
      }
      this.nfZ.E(this.ngc);
      this.nfZ.nft = false;
      if (this.ngc.size() <= 0) {
        break label1510;
      }
      localObject1 = (String)this.ngc.get(this.nge.intValue());
    }
    for (;;)
    {
      this.nga.setAdapter(this.nfZ);
      this.nga.setCurrentItem(this.nge.intValue());
      i = bEB().indexOf(this.nfZ.getItem(this.nge.intValue()));
      ((f)this.ngb.getAdapter()).eu(i, this.nge.intValue());
      localObject2 = com.tencent.mm.plugin.gallery.model.e.PB((String)localObject1);
      a((String)localObject1, (GalleryItem.MediaItem)localObject2);
      b((GalleryItem.MediaItem)localObject2);
      setMMTitle(String.format("%d/%d", new Object[] { Integer.valueOf(this.nge.intValue() + 1), Integer.valueOf(this.nfZ.getCount()) }));
      AppMethodBeat.o(21534);
      return;
      this.ngf.setImageResource(2131231905);
      break;
      label1389:
      this.ngb.setVisibility(8);
      break label1055;
      label1401:
      localObject1 = this.nfZ;
      localObject2 = this.ndM;
      ((c)localObject1).ndM.clear();
      ((c)localObject1).ndM.addAll((Collection)localObject2);
      ((c)localObject1).reset();
      ((c)localObject1).notifyDataSetChanged();
      this.nfZ.nft = true;
      if (this.nge.intValue() >= this.ndM.size()) {
        this.nge = Integer.valueOf(0);
      }
      if (this.ndM.size() > 0) {
        localObject1 = ((GalleryItem.MediaItem)this.ndM.get(this.nge.intValue())).fQn;
      } else {
        label1510:
        localObject1 = "";
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    AppMethodBeat.i(21536);
    ab.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
    if (paramInt1 == 4371) {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    while (paramInt1 == 4372)
    {
      Object localObject;
      if ((paramIntent == null) || (this.ngb == null))
      {
        AppMethodBeat.o(21536);
        return;
        if (this.ngd.size() > 0)
        {
          PF((String)this.ngd.get(0));
        }
        else
        {
          ab.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[] { Integer.valueOf(this.ngd.size()) });
          continue;
          if (paramInt1 == 4370)
          {
            if (paramInt2 == -1)
            {
              localObject = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
              paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).videoPath);
              paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).thumbPath);
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject).qbl.q("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
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
        ArrayList localArrayList4 = ((f)this.ngb.getAdapter()).ngM;
        ArrayList localArrayList3 = this.ngd;
        this.ngz = (this.ngz + localCaptureVideoNormalModel.qbl.q("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)) + ";");
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
          if (!str.equalsIgnoreCase(bo.nullAsNil(this.path)))
          {
            localObject = str;
            if (!str.equalsIgnoreCase(bo.nullAsNil(this.ngy))) {}
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
          if (!str.equalsIgnoreCase(bo.nullAsNil(this.path)))
          {
            localObject = str;
            if (!str.equalsIgnoreCase(bo.nullAsNil(this.ngy))) {}
          }
          else
          {
            localObject = localCaptureVideoNormalModel.thumbPath;
          }
          localArrayList2.add(localObject);
          i += 1;
        }
        com.tencent.mm.vfs.e.deleteFile(this.ngy);
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
        d(paramInt2, paramIntent);
        AppMethodBeat.o(21536);
        return;
      }
    }
    if (paramIntent != null)
    {
      setResult(-1, paramIntent.putExtra("GalleryUI_IsSendImgBackground", true));
      finish();
    }
    AppMethodBeat.o(21536);
  }
  
  @TargetApi(16)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21530);
    long l = bo.yB();
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    new ak().post(new ImagePreviewUI.12(this, l));
    bindService(new Intent(getContext(), GalleryStubService.class), this.kDI, 1);
    ab.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", new Object[] { Long.valueOf(bo.av(l)) });
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.evl));
    this.evl.connect(new ImagePreviewUI.22(this));
    AppMethodBeat.o(21530);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21543);
    super.onDestroy();
    if ((com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 3) && (getIntent().getBooleanExtra("preview_image", false)) && (getIntent().getIntExtra("max_select_count", 0) == 1)) {
      ab.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
    }
    if (this.nfZ != null) {
      this.nfZ.release();
    }
    com.tencent.mm.plugin.gallery.model.e.B(null);
    unbindService(this.kDI);
    CaptureMMProxy.getInstance().clearArtistCache();
    this.evl.release();
    AppMethodBeat.o(21543);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21542);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(21542);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21542);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(21532);
    if (this.ngh != null) {
      this.ngh.stopTimer();
    }
    super.onPause();
    AppMethodBeat.o(21532);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21531);
    super.onResume();
    AppMethodBeat.o(21531);
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