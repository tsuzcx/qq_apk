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
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.d.b;
import com.tencent.mm.plugin.gallery.model.t.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.e;
import com.tencent.mm.ui.base.u;
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
  private int juP;
  private int mediaType;
  private boolean oTl;
  private String path;
  private int sUI;
  private TextView tLU;
  private ArrayList<GalleryItem.MediaItem> tLn;
  private String tLq;
  private HashMap<String, Integer> tMA;
  private HashSet<String> tMB;
  private boolean tMa;
  private boolean tMb;
  private boolean tMd;
  private boolean tMe;
  private long tMk;
  private int tMn;
  private boolean tNv;
  private boolean tOA;
  private boolean tOB;
  private int tOC;
  private int tOD;
  private TextView tOE;
  private TextView tOF;
  private TextView tOG;
  private TextView tOH;
  private View tOI;
  private TextView tOJ;
  private ProgressBar tOK;
  private boolean tOL;
  boolean tOM;
  private d.b tON;
  private String tOO;
  private String tOP;
  private int tOQ;
  private String tOR;
  private int tOS;
  private String tOT;
  private d tOm;
  private MMViewPager tOn;
  private RecyclerView tOo;
  private ArrayList<String> tOp;
  private ArrayList<String> tOq;
  private ArrayList<GalleryItem.MediaItem> tOr;
  private Integer tOs;
  private ImageButton tOt;
  private TextView tOu;
  private av tOv;
  private ImageButton tOw;
  private TextView tOx;
  private ViewGroup tOy;
  private ViewGroup tOz;
  
  public ImagePreviewUI()
  {
    AppMethodBeat.i(111592);
    this.tOA = true;
    this.tOB = true;
    this.tMa = true;
    this.tOC = 0;
    this.tMk = 0L;
    this.tOD = 10;
    this.tOL = false;
    this.mediaType = 0;
    this.tOM = false;
    this.tON = null;
    this.tOP = "";
    this.tMA = new HashMap();
    this.tOQ = 300000;
    this.tOS = 1000;
    AppMethodBeat.o(111592);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111608);
    boolean bool;
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || ((com.tencent.mm.plugin.gallery.model.e.cUM().kTx != 4) && (com.tencent.mm.plugin.gallery.model.e.cUM().kTx != 14) && (com.tencent.mm.plugin.gallery.model.e.cUM().kTx != 13)))
    {
      this.tOA = true;
      this.tOy.setVisibility(0);
      this.tOz.setVisibility(8);
      this.tOK.setVisibility(8);
      a(paramString, paramMediaItem, false);
      alc(paramString);
      enableOptionMenu(true);
      this.tOu.setVisibility(8);
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
        this.tOE.setVisibility(0);
      }
      for (;;)
      {
        if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 15) {
          this.tOE.setVisibility(8);
        }
        if (this.tMb) {
          this.tOE.setVisibility(8);
        }
        akZ(paramString);
        AppMethodBeat.o(111608);
        return;
        bool = getIntent().getBooleanExtra("preview_image", false);
        ad.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.cUM().kTx), Boolean.valueOf(bool), paramString });
        if ((paramMediaItem == null) && (!bt.isNullOrNil(paramString))) {
          this.tOE.setVisibility(0);
        } else {
          this.tOE.setVisibility(8);
        }
      }
    }
    if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
      this.tOE.setVisibility(0);
    }
    final GalleryItem.VideoMediaItem localVideoMediaItem;
    for (;;)
    {
      if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 25) {
        this.tOE.setVisibility(8);
      }
      akZ(paramString);
      localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
      enableOptionMenu(false);
      this.tOA = false;
      this.tOy.setVisibility(8);
      this.tOz.setVisibility(0);
      this.tOJ.setVisibility(8);
      if (!ala(paramString)) {
        break;
      }
      AppMethodBeat.o(111608);
      return;
      this.tOE.setVisibility(8);
    }
    if (!bt.isNullOrNil(localVideoMediaItem.imP))
    {
      ad.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.tGS, Integer.valueOf(localVideoMediaItem.imR), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
      bool = a(paramString, localVideoMediaItem, this.tOL);
      a(this.tOL, bool, localVideoMediaItem);
      AppMethodBeat.o(111608);
      return;
    }
    enableOptionMenu(false);
    this.tOA = true;
    this.tOy.setVisibility(0);
    this.tOz.setVisibility(8);
    this.tOu.setVisibility(8);
    a(paramString, paramMediaItem, false);
    alc(paramString);
    paramMediaItem = new com.tencent.mm.plugin.gallery.model.t(paramString, this.tOs.intValue(), localVideoMediaItem, new t.a()
    {
      public final void a(com.tencent.mm.plugin.gallery.model.t paramAnonymoust)
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
        boolean bool = ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymoust.path, paramAnonymoust.tHV, ImagePreviewUI.z(ImagePreviewUI.this));
        ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.z(ImagePreviewUI.this), bool, localVideoMediaItem);
        AppMethodBeat.o(111579);
      }
    });
    if (paramMediaItem.equals(this.tOK.getTag()))
    {
      ad.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { paramString });
      AppMethodBeat.o(111608);
      return;
    }
    this.tOK.setTag(paramMediaItem);
    com.tencent.e.h.LTJ.aR(paramMediaItem);
    if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 15) {
      this.tOE.setVisibility(8);
    }
    if (this.tMb) {
      this.tOE.setVisibility(8);
    }
    AppMethodBeat.o(111608);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111619);
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || (com.tencent.mm.plugin.gallery.model.e.cUM().kTx != 4) || (paramBoolean))
    {
      if (this.sUI == 1)
      {
        this.tOw.setVisibility(8);
        this.tOx.setVisibility(8);
      }
      while (!this.tOq.contains(paramString))
      {
        this.tOw.setImageResource(2131691077);
        AppMethodBeat.o(111619);
        return;
        this.tOw.setVisibility(0);
        this.tOx.setVisibility(0);
      }
      this.tOw.setImageResource(cWl());
      AppMethodBeat.o(111619);
      return;
    }
    this.tOw.setVisibility(8);
    this.tOx.setVisibility(8);
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
    if ((paramBoolean1) && (com.tencent.mm.plugin.gallery.a.d.af(this.tOr)))
    {
      this.tOJ.setVisibility(8);
      this.tOu.setVisibility(8);
      this.tOz.setVisibility(8);
      enableOptionMenu(true);
      a(this.path, paramMediaItem, paramBoolean1);
    }
    AppMethodBeat.o(111609);
  }
  
  private boolean a(String paramString, GalleryItem.VideoMediaItem paramVideoMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111611);
    enableOptionMenu(false);
    this.tOA = false;
    this.tOy.setVisibility(8);
    this.tOz.setVisibility(0);
    this.tOJ.setVisibility(8);
    if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 13)
    {
      this.tOz.setVisibility(8);
      this.tOy.setVisibility(8);
      this.tOF.setVisibility(8);
      this.tOG.setVisibility(8);
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
    this.tOA = true;
    this.tOy.setVisibility(0);
    this.tOz.setVisibility(8);
    this.tOu.setVisibility(0);
    this.tOK.setVisibility(8);
    a(paramString, paramVideoMediaItem, false);
    alc(paramString);
    AppMethodBeat.o(111611);
    return true;
  }
  
  private void akY(String paramString)
  {
    AppMethodBeat.i(111598);
    Object localObject1;
    Object localObject2;
    int i;
    label506:
    Object localObject3;
    if (!this.tOq.contains(paramString))
    {
      if (this.tOq.size() >= this.sUI)
      {
        if ((this.mediaType == 2) || ((!bt.isNullOrNil(this.tLq)) && (this.tLq.equals("album_business_bubble_media_by_coordinate")))) {
          paramString = getResources().getQuantityString(2131623951, this.sUI, new Object[] { Integer.valueOf(this.sUI) });
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.cl(getContext(), paramString);
          this.tOw.setImageResource(2131691077);
          if (!bt.hj(this.tOq)) {
            break;
          }
          AppMethodBeat.o(111598);
          return;
          if (this.mediaType == 1) {
            paramString = getResources().getQuantityString(2131623952, this.sUI, new Object[] { Integer.valueOf(this.sUI) });
          } else {
            paramString = getResources().getQuantityString(2131623950, this.sUI, new Object[] { Integer.valueOf(this.sUI) });
          }
        }
      }
      localObject1 = com.tencent.mm.plugin.gallery.model.e.akQ(paramString);
      if (localObject1 != null)
      {
        if ((((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().abE(paramString)))
        {
          com.tencent.mm.ui.base.h.cl(this, getString(2131759800));
          AppMethodBeat.o(111598);
          return;
        }
        if ((localObject1 instanceof GalleryItem.VideoMediaItem)) {
          if ((!bt.isNullOrNil(this.tLq)) && (this.tLq.equals("album_business_bubble_media_by_coordinate")))
          {
            if (((GalleryItem.VideoMediaItem)localObject1).imR >= this.juP * 1000 + 500)
            {
              com.tencent.mm.ui.base.h.cl(getContext(), getContext().getResources().getString(2131759822, new Object[] { Integer.valueOf(this.juP) }));
              AppMethodBeat.o(111598);
            }
          }
          else if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 25)
          {
            if (((GalleryItem.VideoMediaItem)localObject1).imR > this.juP * 1000)
            {
              com.tencent.mm.ui.base.h.cl(getContext(), getContext().getResources().getString(2131759822, new Object[] { Integer.valueOf(this.juP) }));
              AppMethodBeat.o(111598);
              return;
            }
            if (((GalleryItem.VideoMediaItem)localObject1).imR < this.tMn * 1000)
            {
              com.tencent.mm.ui.base.h.cl(getContext(), getContext().getResources().getString(2131759821, new Object[] { Integer.valueOf(this.tMn) }));
              AppMethodBeat.o(111598);
              return;
            }
          }
        }
        if (this.tOr != null)
        {
          localObject2 = this.tOr.iterator();
          i = 0;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
            if ((localObject3 == null) || (!((GalleryItem.MediaItem)localObject3).tGS.equalsIgnoreCase(((GalleryItem.MediaItem)localObject1).tGS))) {
              break label801;
            }
            i = 1;
          }
        }
      }
    }
    label647:
    label798:
    label801:
    for (;;)
    {
      break label506;
      if (i == 0) {
        this.tOr.add(localObject1);
      }
      this.tOq.add(paramString);
      this.tOw.setImageResource(cWl());
      b(this.tOq.size(), this.tOs.intValue(), paramString, 0);
      break;
      this.tOw.setImageResource(2131691077);
      while (this.tOq.remove(paramString)) {}
      if (this.tOr != null)
      {
        localObject1 = null;
        localObject3 = this.tOr.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
          if ((localObject2 == null) || (!((GalleryItem.MediaItem)localObject2).tGS.equalsIgnoreCase(paramString))) {
            break label798;
          }
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        break label647;
        if (localObject1 != null)
        {
          ad.i("MicroMsg.ImagePreviewUI", "unselect item: %s", new Object[] { ((GalleryItem.MediaItem)localObject1).tGS });
          this.tOr.remove(localObject1);
        }
        b(this.tOq.size(), this.tOs.intValue(), paramString, 1);
        break;
        paramString = this.tOq.iterator();
        while (paramString.hasNext()) {
          if (!com.tencent.mm.sdk.platformtools.t.aQj((String)paramString.next()))
          {
            AppMethodBeat.o(111598);
            return;
          }
        }
        this.oTl = true;
        AppMethodBeat.o(111598);
        return;
      }
    }
  }
  
  private void akZ(String paramString)
  {
    AppMethodBeat.i(111610);
    if ((this.tOq.size() >= 9) && (!this.tOq.contains(paramString)))
    {
      this.tOE.setTextColor(getContext().getResources().getColor(2131101183));
      this.tOE.setEnabled(false);
      AppMethodBeat.o(111610);
      return;
    }
    this.tOE.setEnabled(true);
    this.tOE.setTextColor(getContext().getResources().getColor(2131101182));
    AppMethodBeat.o(111610);
  }
  
  private boolean ala(String paramString)
  {
    AppMethodBeat.i(111613);
    if (com.tencent.mm.vfs.i.aYo(paramString) > 1073741824L)
    {
      this.tOF.setText(getString(2131759794));
      this.tOG.setText(getString(2131759793));
      AppMethodBeat.o(111613);
      return true;
    }
    AppMethodBeat.o(111613);
    return false;
  }
  
  private boolean alb(String paramString)
  {
    AppMethodBeat.i(111618);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111618);
      return true;
    }
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
    paramString = paramString.trim();
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length()))
    {
      AppMethodBeat.o(111618);
      return true;
    }
    if (!this.tMB.contains(paramString.substring(i).toLowerCase()))
    {
      AppMethodBeat.o(111618);
      return true;
    }
    AppMethodBeat.o(111618);
    return false;
  }
  
  private void alc(String paramString)
  {
    AppMethodBeat.i(111620);
    Object localObject = Boolean.FALSE;
    Boolean localBoolean;
    GalleryItem.MediaItem localMediaItem;
    switch (com.tencent.mm.plugin.gallery.model.e.cUM().kTx)
    {
    default: 
      localBoolean = Boolean.FALSE;
      localMediaItem = com.tencent.mm.plugin.gallery.model.e.akQ(paramString);
      localObject = localBoolean;
      if (localMediaItem != null)
      {
        localObject = localBoolean;
        if (localMediaItem.getType() == 2) {
          localObject = Boolean.TRUE;
        }
      }
      if ((localMediaItem == null) && (com.tencent.mm.sdk.platformtools.t.aQj(paramString))) {
        paramString = Boolean.TRUE;
      }
      break;
    }
    for (;;)
    {
      if ((!paramString.booleanValue()) || (this.tMd)) {
        break label192;
      }
      this.tOt.setVisibility(8);
      this.tLU.setVisibility(8);
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
    this.tOt.setVisibility(0);
    this.tLU.setVisibility(0);
    AppMethodBeat.o(111620);
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(111621);
    ad.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((-1 != paramInt2) && (!this.tNv))
    {
      this.tOo.getAdapter().b(paramInt2, Integer.valueOf(paramInt2));
      if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx != 13) {
        break label356;
      }
      paramInt2 = 1;
      label72:
      paramString = this.tOm.Hs(this.tOs.intValue());
      if ((paramInt1 != 0) && (((!this.tMa) || (this.tOL)) && ((paramInt2 == 0) || (this.tOm == null) || (paramString == null) || (paramString.getType() != 2)))) {
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
      this.tOo.setVisibility(8);
      AppMethodBeat.o(111621);
      return;
      if (-1 == paramInt2) {
        break;
      }
      if ((paramInt3 == 0) && (paramInt1 > 0))
      {
        ((g)this.tOo.getAdapter()).ald(paramString);
        ((g)this.tOo.getAdapter()).gk(paramInt1 - 1, this.tOs.intValue());
        this.tOo.getAdapter().ck(paramInt1 - 1);
        paramString = this.tOo;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt1 - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramString, locala.ahp(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramString.smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        break;
      }
      if (paramInt3 != 1) {
        break;
      }
      paramInt2 = ((g)this.tOo.getAdapter()).indexOf(paramString);
      if (-1 == paramInt2) {
        break;
      }
      ((g)this.tOo.getAdapter()).remove(paramInt2);
      this.tOo.getAdapter().cl(paramInt2);
      break;
      paramInt2 = 0;
      break label72;
    }
    label366:
    this.tOo.setVisibility(0);
    AppMethodBeat.o(111621);
  }
  
  private boolean b(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111614);
    ad.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[] { Integer.valueOf(paramVideoMediaItem.imR) });
    if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 13)
    {
      AppMethodBeat.o(111614);
      return false;
    }
    if (paramVideoMediaItem.imR <= 1000)
    {
      this.tOF.setText(getString(2131759798));
      this.tOG.setText(getString(2131759797));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.imR >= 300000)
    {
      this.tOF.setText(getString(2131759796));
      this.tOG.setText(getString(2131759795));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.imR >= this.tOD * 1000 + 500)
    {
      this.tOF.setText(getString(2131759781));
      this.tOG.setText(getString(2131759780, new Object[] { Integer.valueOf(this.tOD) }));
      this.tOJ.setVisibility(0);
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
        ad.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramVideoMediaItem.videoWidth), Integer.valueOf(paramVideoMediaItem.videoHeight) });
      }
      this.tOF.setText(getString(2131759791));
      this.tOG.setText(getString(2131759792));
      AppMethodBeat.o(111616);
      return true;
    }
    AppMethodBeat.o(111616);
    return false;
  }
  
  private String cWi()
  {
    AppMethodBeat.i(111601);
    switch (com.tencent.mm.plugin.gallery.model.e.cUM().kTx)
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
      if ((this.tOq.size() == 0) || (this.sUI <= 1))
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
      if ((this.tOL) && (com.tencent.mm.plugin.gallery.a.d.af(this.tOr)))
      {
        str = getString(2131759788) + "(" + this.tOq.size() + "/" + this.sUI + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.tOq.size() == 0) || (this.sUI <= 1))
      {
        str = getString(2131759785);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(2131759785) + "(" + this.tOq.size() + "/" + this.sUI + ")";
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
      if (((!bt.isNullOrNil(this.tLq)) && (this.tLq.equals("album_business_bubble_media_by_coordinate"))) || (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 25))
      {
        if ((this.tOq.size() == 0) || (this.sUI <= 1))
        {
          str = getString(2131755830);
          AppMethodBeat.o(111601);
          return str;
        }
        str = getString(2131755830) + "(" + this.tOq.size() + "/" + this.sUI + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.tOq.size() == 0) || (this.sUI <= 1))
      {
        str = getString(2131759785);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(2131759785) + "(" + this.tOq.size() + "/" + this.sUI + ")";
      AppMethodBeat.o(111601);
      return str;
    }
    String str = getString(2131759775, new Object[] { Integer.valueOf(this.tOq.size()), Integer.valueOf(this.sUI) });
    AppMethodBeat.o(111601);
    return str;
  }
  
  private ArrayList<String> cWj()
  {
    AppMethodBeat.i(111602);
    if (this.tNv)
    {
      localArrayList = this.tOq;
      AppMethodBeat.o(111602);
      return localArrayList;
    }
    if (this.tOq != null)
    {
      localArrayList = new ArrayList(this.tOq.size());
      Iterator localIterator = this.tOp.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.tOq.contains(str)) {
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
  
  private boolean cWk()
  {
    AppMethodBeat.i(111615);
    this.tOF.setText(getString(2131759789));
    this.tOG.setText(getString(2131759790));
    AppMethodBeat.o(111615);
    return true;
  }
  
  private static int cWl()
  {
    AppMethodBeat.i(111622);
    if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 15)
    {
      AppMethodBeat.o(111622);
      return 2131689937;
    }
    if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 25)
    {
      AppMethodBeat.o(111622);
      return 2131691475;
    }
    AppMethodBeat.o(111622);
    return 2131689655;
  }
  
  private boolean d(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111617);
    ad.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[] { paramVideoMediaItem });
    int i;
    if (paramVideoMediaItem != null) {
      if (("video/hevc".equalsIgnoreCase(paramVideoMediaItem.imP)) && (com.tencent.mm.plugin.o.f.dmo())) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((paramVideoMediaItem == null) || (bt.isNullOrNil(paramVideoMediaItem.tGS)) || (alb(paramVideoMediaItem.tGS)) || (i == 0) || ((!bt.isNullOrNil(paramVideoMediaItem.imQ)) && (!"audio/mp4a-latm".equalsIgnoreCase(paramVideoMediaItem.imQ))))
      {
        if (paramVideoMediaItem == null) {}
        for (paramVideoMediaItem = null;; paramVideoMediaItem = paramVideoMediaItem.imP)
        {
          ad.i("MicroMsg.ImagePreviewUI", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramVideoMediaItem });
          cWk();
          AppMethodBeat.o(111617);
          return true;
          if (!"video/avc".equalsIgnoreCase(paramVideoMediaItem.imP)) {
            break label168;
          }
          i = 1;
          break;
        }
      }
      AppMethodBeat.o(111617);
      return false;
      label168:
      i = 0;
    }
  }
  
  private void e(int paramInt, final Intent paramIntent)
  {
    AppMethodBeat.i(111600);
    if ((paramInt == -1) && (paramIntent != null))
    {
      this.tOM = true;
      Object localObject2 = paramIntent.getStringExtra("raw_photo_path");
      Object localObject1 = com.tencent.mm.plugin.gallery.model.e.cUQ().iterator();
      while ((localObject2 != null) && (((Iterator)localObject1).hasNext())) {
        if (((String)localObject2).equals(((Bundle)((Iterator)localObject1).next()).getString("raw_photo_path"))) {
          ((Iterator)localObject1).remove();
        }
      }
      com.tencent.mm.plugin.gallery.model.e.cUQ().add(paramIntent.getBundleExtra("report_info"));
      localObject1 = paramIntent.getStringExtra("after_photo_edit");
      String str = paramIntent.getStringExtra("tmp_photo_edit");
      ad.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { localObject2, localObject1 });
      if (this.tOp != null)
      {
        this.tOp.clear();
        Object localObject3 = paramIntent.getStringArrayListExtra("preview_image_list");
        if (localObject3 != null) {
          this.tOp.addAll((Collection)localObject3);
        }
        localObject3 = this.tOm.Hs(this.tOs.intValue());
        if (localObject3 == null)
        {
          ad.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { this.tOs, localObject2, localObject1 });
          AppMethodBeat.o(111600);
          return;
        }
        ((GalleryItem.MediaItem)localObject3).tGT = ((String)localObject2);
        ((GalleryItem.MediaItem)localObject3).tGS = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).rmz = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).tGU = str;
        ((GalleryItem.MediaItem)localObject3).mMimeType = "edit";
        com.tencent.mm.plugin.gallery.model.e.cUP().add(localObject3);
        if (this.tON != null) {
          com.tencent.mm.plugin.gallery.model.e.cUL().b(this.tON);
        }
        localObject2 = com.tencent.mm.plugin.gallery.model.e.cUL();
        paramIntent = new d.b()
        {
          public final void akP(final String paramAnonymousString)
          {
            AppMethodBeat.i(111571);
            new ap(ImagePreviewUI.this.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111570);
                ImagePreviewUI.h(ImagePreviewUI.this).ae(ImagePreviewUI.s(ImagePreviewUI.this));
                Object localObject = (g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter();
                ArrayList localArrayList = ImagePreviewUI.s(ImagePreviewUI.this);
                ((g)localObject).tPh.clear();
                ((g)localObject).tPh.addAll(localArrayList);
                ((RecyclerView.a)localObject).asY.notifyChanged();
                localObject = ImagePreviewUI.10.this.val$data.getStringArrayListExtra("preview_select_image_list");
                ImagePreviewUI.d(ImagePreviewUI.this).clear();
                if (localObject != null) {
                  ImagePreviewUI.d(ImagePreviewUI.this).addAll((Collection)localObject);
                }
                ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
                ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131759782) + ImagePreviewUI.cWm());
                if (!ImagePreviewUI.d(ImagePreviewUI.this).contains(com.tencent.mm.plugin.gallery.a.d.alh(paramAnonymousString))) {
                  ImagePreviewUI.e(ImagePreviewUI.this).performClick();
                }
                AppMethodBeat.o(111570);
              }
            });
            com.tencent.mm.plugin.gallery.model.e.cUL().b(this);
            AppMethodBeat.o(111571);
          }
          
          public final String cUI()
          {
            AppMethodBeat.i(179472);
            String str = com.tencent.mm.plugin.gallery.a.d.a(this.tOW, null, -1);
            AppMethodBeat.o(179472);
            return str;
          }
          
          public final String toString()
          {
            AppMethodBeat.i(111572);
            String str = "fileKey:" + this.tOW + " this: " + super.toString();
            AppMethodBeat.o(111572);
            return str;
          }
        };
        this.tON = paramIntent;
        ((com.tencent.mm.plugin.gallery.model.c)localObject2).a(paramIntent);
        com.tencent.mm.plugin.gallery.model.e.cUL().a((String)localObject1, ((GalleryItem.MediaItem)localObject3).getType(), (String)localObject1, ((GalleryItem.MediaItem)localObject3).tGV, ((GalleryItem.MediaItem)localObject3).tGW);
        ad.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
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
    if (!this.oTl)
    {
      bool1 = true;
      if (!this.tMa) {
        break label89;
      }
      bool1 = bool2;
    }
    label89:
    for (;;)
    {
      localIntent.putExtra("CropImage_Compress_Img", bool1);
      localIntent.putStringArrayListExtra("preview_image_list", cWj());
      localIntent.putExtra("show_photo_edit_tip", this.tOM);
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
      ad.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
      AppMethodBeat.o(111612);
      return;
    }
    Object localObject;
    if (paramMediaItem.getType() == 2)
    {
      GalleryItem.VideoMediaItem localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
      this.tOQ = 300000;
      this.tOR = getString(2131759795);
      this.tOS = 1000;
      this.tOT = getString(2131759797);
      if (((this.tLq != null) && ((this.tLq.equals("album_business_bubble_media_by_coordinate")) || (this.tLq.equals("album_business_bubble_media_by_jsapi_choosevideo")))) || (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 25))
      {
        this.tOQ = (this.juP * 1000 + 500);
        this.tOR = getString(2131759822, new Object[] { Integer.valueOf(this.juP) });
        if (this.tMn != 0)
        {
          this.tOS = (this.tMn * 1000);
          this.tOT = getString(2131759821, new Object[] { Integer.valueOf(this.tMn) });
        }
      }
      if (!bt.isNullOrNil(localVideoMediaItem.imP))
      {
        ad.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.tGS, Integer.valueOf(localVideoMediaItem.imR), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
        if ((localVideoMediaItem.imR >= this.tOQ) || ((localVideoMediaItem.imR > 0) && (localVideoMediaItem.imR < this.tOS)))
        {
          this.tOI.setVisibility(0);
          localObject = this.tOH;
          if (localVideoMediaItem.imR >= this.tOQ) {}
          for (paramMediaItem = this.tOR;; paramMediaItem = this.tOT)
          {
            ((TextView)localObject).setText(paramMediaItem);
            this.tOx.setEnabled(false);
            this.tOw.setEnabled(false);
            this.tOx.setTextColor(getResources().getColor(2131101183));
            if (this.tOq.size() != 0) {
              break;
            }
            enableOptionMenu(false);
            AppMethodBeat.o(111612);
            return;
          }
        }
        this.tOx.setEnabled(true);
        this.tOw.setEnabled(true);
        this.tOx.setTextColor(getResources().getColor(2131101182));
        this.tOI.setVisibility(8);
        AppMethodBeat.o(111612);
        return;
      }
      paramMediaItem = new com.tencent.mm.plugin.gallery.model.t(paramMediaItem.tGS, this.tOs.intValue(), localVideoMediaItem, new t.a()
      {
        public final void a(com.tencent.mm.plugin.gallery.model.t paramAnonymoust)
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
          if (TextUtils.isEmpty(paramAnonymoust.tHV.imP))
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
          if ((paramAnonymoust.tHV.imR >= ImagePreviewUI.C(ImagePreviewUI.this)) || ((paramAnonymoust.tHV.imR > 0) && (paramAnonymoust.tHV.imR < ImagePreviewUI.D(ImagePreviewUI.this))))
          {
            ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
            TextView localTextView = ImagePreviewUI.A(ImagePreviewUI.this);
            if (paramAnonymoust.tHV.imR >= ImagePreviewUI.C(ImagePreviewUI.this)) {}
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
      if (paramMediaItem.equals(this.tOK.getTag()))
      {
        ad.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { this.path });
        AppMethodBeat.o(111612);
        return;
      }
      this.tOK.setTag(paramMediaItem);
      com.tencent.e.h.LTJ.aR(paramMediaItem);
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      this.tOx.setEnabled(true);
      this.tOw.setEnabled(true);
      this.tOx.setTextColor(getResources().getColor(2131101182));
      if ((this.oTl) && (this.tOq.contains(paramMediaItem.tGS)) && (com.tencent.mm.vfs.i.aYo(paramMediaItem.tGS) > 26214400L))
      {
        this.tOI.setVisibility(0);
        this.tOH.setText(getString(2131759802));
        AppMethodBeat.o(111612);
        return;
      }
      this.tOI.setVisibility(8);
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      localObject = new com.tencent.mm.plugin.gif.f(paramMediaItem.tGS);
      long l = com.tencent.mm.vfs.i.aYo(paramMediaItem.tGS);
      try
      {
        if (((!this.tOq.contains(paramMediaItem.tGS)) || (l == 0L) || (l <= com.tencent.mm.plugin.gallery.a.d.acg())) && (localObject.uzU[0] <= com.tencent.mm.plugin.gallery.a.d.acf()) && (localObject.uzU[1] <= com.tencent.mm.plugin.gallery.a.d.acf())) {
          break label830;
        }
        this.tOx.setTextColor(getResources().getColor(2131101183));
        this.tOx.setEnabled(false);
        this.tOw.setEnabled(false);
        AppMethodBeat.o(111612);
        return;
      }
      catch (Exception paramMediaItem)
      {
        ad.e("MicroMsg.ImagePreviewUI", bt.n(paramMediaItem));
      }
    }
    else
    {
      AppMethodBeat.o(111612);
      return;
    }
    label830:
    this.tOx.setTextColor(getResources().getColor(2131101182));
    this.tOx.setEnabled(true);
    this.tOw.setEnabled(true);
    AppMethodBeat.o(111612);
  }
  
  private void mT(boolean paramBoolean)
  {
    AppMethodBeat.i(111603);
    if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 4)
    {
      AppMethodBeat.o(111603);
      return;
    }
    if (this.tOm == null)
    {
      ad.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
      AppMethodBeat.o(111603);
      return;
    }
    final GalleryItem.MediaItem localMediaItem = this.tOm.Hs(this.tOs.intValue());
    if ((paramBoolean) && (localMediaItem != null))
    {
      this.tOI.postDelayed(new Runnable()
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
    this.tOI.setVisibility(8);
    AppMethodBeat.o(111603);
  }
  
  private void mU(boolean paramBoolean)
  {
    AppMethodBeat.i(111604);
    ad.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + paramBoolean + "], selectedNormalFooter = " + this.tOA);
    if (this.tOA)
    {
      localObject = findViewById(2131298881);
      if (localObject != null) {
        break label134;
      }
      if (!this.tOA) {
        break label127;
      }
    }
    label127:
    for (Object localObject = "normal";; localObject = "edit_tips")
    {
      ad.w("MicroMsg.ImagePreviewUI", "set footer[%s] visibility[%B], but footerbar null", new Object[] { localObject, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(111604);
      return;
      localObject = findViewById(2131300337);
      if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx != 15) {
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
    while ((paramBoolean) && (this.tOo.getVisibility() == 8) && (this.tOq.size() > 0))
    {
      this.tOo.setVisibility(0);
      localObject = AnimationUtils.loadAnimation(this, 2130772047);
      this.tOo.startAnimation((Animation)localObject);
      AppMethodBeat.o(111604);
      return;
      ((View)localObject).setVisibility(8);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, 2130772048));
    }
    if ((!paramBoolean) && (this.tOo.getVisibility() == 0))
    {
      this.tOo.setVisibility(8);
      localObject = AnimationUtils.loadAnimation(this, 2130772048);
      this.tOo.startAnimation((Animation)localObject);
    }
    AppMethodBeat.o(111604);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(111596);
    if (com.tencent.mm.compatible.d.b.bY(this))
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
    this.tOF = ((TextView)findViewById(2131300338));
    this.tOG = ((TextView)findViewById(2131300340));
    this.tOH = ((TextView)findViewById(2131301163));
    this.tOI = findViewById(2131301164);
    this.tOI.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111575);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)ImagePreviewUI.a(ImagePreviewUI.this).getLayoutParams();
        localMarginLayoutParams.topMargin = ((int)(com.tencent.mm.compatible.util.i.aU(ImagePreviewUI.this) + ImagePreviewUI.this.getResources().getDimension(2131165252)));
        ImagePreviewUI.a(ImagePreviewUI.this).setLayoutParams(localMarginLayoutParams);
        AppMethodBeat.o(111575);
      }
    }, 100L);
    this.tOJ = ((TextView)findViewById(2131300339));
    this.tOK = ((ProgressBar)findViewById(2131306335));
    this.sUI = getIntent().getIntExtra("max_select_count", 9);
    this.tOD = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
    Object localObject1;
    boolean bool2;
    if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 4)
    {
      bool1 = true;
      this.tMa = bool1;
      localObject1 = getIntent();
      this.tOp = ((Intent)localObject1).getStringArrayListExtra("preview_image_list");
      this.tOr = ((Intent)localObject1).getParcelableArrayListExtra("preview_media_item_list");
      this.mediaType = ((Intent)localObject1).getIntExtra("media_type", this.mediaType);
      this.tOq = new ArrayList();
      if (this.tOp != null) {
        this.tOq.addAll(this.tOp);
      }
      this.tLn = com.tencent.mm.plugin.gallery.model.e.cUO();
      bool2 = ((Intent)localObject1).getBooleanExtra("preview_all", false);
      if (this.tLn != null) {
        break label438;
      }
    }
    label438:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.ImagePreviewUI", "preview all[%B] mediaitems is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (this.tLn != null))
      {
        this.tNv = true;
        this.tOs = Integer.valueOf(((Intent)localObject1).getIntExtra("preview_position", 0));
        ad.i("MicroMsg.ImagePreviewUI", "start position=%d", new Object[] { this.tOs });
        if (this.tOs.intValue() >= 0) {}
      }
      else
      {
        this.tOs = Integer.valueOf(0);
      }
      com.tencent.mm.plugin.gallery.model.e.Hd(this.tOs.intValue());
      if ((this.tNv) || ((this.tOq != null) && (this.tOq.size() != 0))) {
        break label443;
      }
      ad.e("MicroMsg.ImagePreviewUI", "not preview all items and image paths is null or empty");
      finish();
      AppMethodBeat.o(111597);
      return;
      bool1 = false;
      break;
    }
    label443:
    this.tOt = ((ImageButton)findViewById(2131303090));
    this.tLU = ((TextView)findViewById(2131303091));
    this.tOu = ((TextView)findViewById(2131306334));
    this.oTl = ((Intent)localObject1).getBooleanExtra("send_raw_img", false);
    this.tMb = ((Intent)localObject1).getBooleanExtra("key_force_hide_edit_image_button", false);
    this.tMd = ((Intent)localObject1).getBooleanExtra("key_force_show_raw_image_button", false);
    this.tMe = ((Intent)localObject1).getBooleanExtra("key_is_raw_image_button_disable", false);
    this.tOC = ((Intent)localObject1).getIntExtra("query_source_type", 0);
    this.tOL = com.tencent.mm.plugin.gallery.a.d.cWw();
    ad.i("MicroMsg.ImagePreviewUI", "initView, enableVLog:%s", new Object[] { Boolean.valueOf(this.tOL) });
    Object localObject2;
    label628:
    int i;
    if (this.oTl)
    {
      this.tOt.setImageResource(2131691078);
      if (this.tMe) {
        this.tOt.setImageResource(2131691075);
      }
      localObject2 = this.tOt;
      if (this.tMe) {
        break label1688;
      }
      bool1 = true;
      ((ImageButton)localObject2).setEnabled(bool1);
      localObject2 = this.tLU;
      if (this.tMe) {
        break label1693;
      }
      bool1 = true;
      label649:
      ((TextView)localObject2).setEnabled(bool1);
      if ((this.tOq != null) && (this.tOq.size() == 1))
      {
        localObject2 = (String)this.tOq.get(0);
        if (((String)localObject2).endsWith(".jpg")) {
          aq.f(new Runnable()
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
      this.tLU.setText(getContext().getString(2131759782));
      this.tOt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111583);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
            ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131759782) + ImagePreviewUI.cWm());
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
      this.tOu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111584);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bt.isNullOrNil(paramAnonymousView))
          {
            ad.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111584);
            return;
          }
          ad.i("MicroMsg.ImagePreviewUI", "editVideoMaxTimeLength : %d", new Object[] { Integer.valueOf(ImagePreviewUI.i(ImagePreviewUI.this)) });
          localObject = new StringBuilder();
          com.tencent.mm.modelvideo.o.aMI();
          localObject = com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
          StringBuilder localStringBuilder = new StringBuilder();
          com.tencent.mm.modelvideo.o.aMI();
          paramAnonymousView = RecordConfigProvider.as(paramAnonymousView, (String)localObject, com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg");
          paramAnonymousView.xyj = com.tencent.mm.modelcontrol.d.aGQ().aGT();
          paramAnonymousView.xyt = (ImagePreviewUI.i(ImagePreviewUI.this) * 1000);
          paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.cUM().kTx;
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).aby();
          ((UICustomParam.a)localObject).abx();
          ((UICustomParam.a)localObject).cP(true);
          paramAnonymousView.xyk = ((UICustomParam.a)localObject).gei;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, 2130772137, -1, paramAnonymousView, 2, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111584);
        }
      });
      this.tOJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111585);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bt.isNullOrNil(paramAnonymousView))
          {
            ad.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111585);
            return;
          }
          localObject = new StringBuilder();
          com.tencent.mm.modelvideo.o.aMI();
          localObject = com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
          StringBuilder localStringBuilder = new StringBuilder();
          com.tencent.mm.modelvideo.o.aMI();
          paramAnonymousView = RecordConfigProvider.as(paramAnonymousView, (String)localObject, com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg");
          paramAnonymousView.xyt = (ImagePreviewUI.i(ImagePreviewUI.this) * 1000);
          paramAnonymousView.xyj = com.tencent.mm.modelcontrol.d.aGQ().aGT();
          paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.cUM().kTx;
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).aby();
          ((UICustomParam.a)localObject).abx();
          ((UICustomParam.a)localObject).cP(true);
          paramAnonymousView.xyk = ((UICustomParam.a)localObject).gei;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, 2130772137, -1, paramAnonymousView, 2, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111585);
        }
      });
      this.tLU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111586);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ImagePreviewUI.c(ImagePreviewUI.this).performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111586);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(111587);
          ImagePreviewUI.j(ImagePreviewUI.this);
          AppMethodBeat.o(111587);
          return true;
        }
      });
      this.tLq = ((Intent)localObject1).getStringExtra("album_business_tag");
      this.juP = ((Intent)localObject1).getIntExtra("album_video_max_duration", 10);
      this.tMn = ((Intent)localObject1).getIntExtra("album_video_min_duration", 0);
      localObject1 = s.b.Jce;
      if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx != 15) {
        break label1698;
      }
      localObject1 = s.b.Jcc;
      label872:
      addTextOptionMenu(0, cWi(), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
        {
          int j = 0;
          AppMethodBeat.i(111590);
          if (ImagePreviewUI.k(ImagePreviewUI.this) == 6)
          {
            ImagePreviewUI.this.setResult(1);
            paramAnonymousMenuItem = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            if (!bt.isNullOrNil(paramAnonymousMenuItem)) {
              a.a.tFA.ai(paramAnonymousMenuItem, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            }
            ImagePreviewUI.this.finish();
          }
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("isPreviewPhoto", ImagePreviewUI.this.getIntent().getBooleanExtra("isPreviewPhoto", false));
          Object localObject = ImagePreviewUI.l(ImagePreviewUI.this);
          int i;
          if ((localObject != null) && (((ArrayList)localObject).size() == 0))
          {
            localObject = ImagePreviewUI.h(ImagePreviewUI.this).Hs(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            if ((ImagePreviewUI.m(ImagePreviewUI.this)) && (ImagePreviewUI.h(ImagePreviewUI.this) != null) && (localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 2))
            {
              ImagePreviewUI.a(ImagePreviewUI.this, ((GalleryItem.MediaItem)localObject).tGS);
              localObject = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              if (!bt.isNullOrNil((String)localObject)) {
                a.a.tFA.ai((String)localObject, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              }
              i = 0;
            }
          }
          for (;;)
          {
            if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 25)
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
            localObject = com.tencent.mm.plugin.gallery.model.e.cUN();
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
              ((com.tencent.mm.plugin.gallery.model.g)localObject).cVf().postDelayed(paramAnonymousMenuItem, i);
              AppMethodBeat.o(111590);
              return true;
            }
            i = 0;
          }
        }
      }, null, (s.b)localObject1);
      this.tOw = ((ImageButton)findViewById(2131303251));
      this.tOw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111591);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bt.isNullOrNil(paramAnonymousView))
          {
            ad.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111591);
            return;
          }
          ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousView);
          ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131759782) + ImagePreviewUI.cWm());
          ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
          a.a.tFA.ai(paramAnonymousView, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111591);
        }
      });
      this.tOx = ((TextView)findViewById(2131303253));
      this.tOx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111560);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ImagePreviewUI.e(ImagePreviewUI.this).performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111560);
        }
      });
      if (this.sUI == 1)
      {
        this.tOw.setVisibility(8);
        this.tOx.setVisibility(8);
      }
      this.tOy = ((ViewGroup)findViewById(2131298881));
      this.tOz = ((ViewGroup)findViewById(2131300337));
      if (this.tOy != null)
      {
        this.tOy.setVisibility(8);
        this.tOy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(111561);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111561);
          }
        });
      }
      if (this.tOz != null)
      {
        this.tOz.setVisibility(8);
        this.tOz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(111562);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111562);
          }
        });
      }
      this.tOE = ((TextView)findViewById(2131303244));
      this.tOE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111563);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ImagePreviewUI.o(ImagePreviewUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111563);
        }
      });
      this.tOo = ((RecyclerView)findViewById(2131300956));
      this.tOo.getItemAnimator().ate = 66L;
      this.tOo.a(new RecyclerView.h()
      {
        public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.t paramAnonymoust)
        {
          AppMethodBeat.i(111564);
          int i = (int)aj.getContext().getResources().getDimension(2131165480);
          paramAnonymousRect.left = (i / 2);
          paramAnonymousRect.bottom = i;
          paramAnonymousRect.top = i;
          paramAnonymousRect.right = (i / 2);
          AppMethodBeat.o(111564);
        }
      });
      localObject1 = new SpeedyLinearLayoutManager();
      ((SpeedyLinearLayoutManager)localObject1).setOrientation(0);
      this.tOo.setLayoutManager((RecyclerView.i)localObject1);
      i = getResources().getDisplayMetrics().widthPixels / 7;
      localObject1 = new g(this, this.tOq, i, this.tNv);
      this.tOo.setAdapter((RecyclerView.a)localObject1);
      this.tOo.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111565);
          int i = (int)aj.getContext().getResources().getDimension(2131165480);
          int j = ImagePreviewUI.this.getResources().getDisplayMetrics().widthPixels / 7;
          ImagePreviewUI.p(ImagePreviewUI.this).getLayoutParams().height = (i * 2 + j);
          RecyclerView localRecyclerView = ImagePreviewUI.p(ImagePreviewUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(ImagePreviewUI.g(ImagePreviewUI.this).intValue(), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.ahp(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$15", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          localRecyclerView.smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$15", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(111565);
        }
      });
      if (this.tOq.size() <= 0) {
        break label1717;
      }
      this.tOo.setVisibility(0);
      label1237:
      this.tOo.setItemAnimator(new v());
      ((g)localObject1).tPl.j(this.tOo);
      ((g)localObject1).tPi = new g.b()
      {
        public final void Hv(int paramAnonymousInt)
        {
          AppMethodBeat.i(111566);
          ad.i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(ImagePreviewUI.q(ImagePreviewUI.this)) });
          ((g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter()).gk(paramAnonymousInt, paramAnonymousInt);
          ImagePreviewUI.r(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt, false);
          if (!ImagePreviewUI.q(ImagePreviewUI.this))
          {
            com.tencent.mm.plugin.gallery.model.e.tGj = true;
            AppMethodBeat.o(111566);
            return;
          }
          com.tencent.mm.plugin.gallery.model.e.tGh = true;
          AppMethodBeat.o(111566);
        }
        
        public final void af(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(111568);
          ad.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), ImagePreviewUI.g(ImagePreviewUI.this) });
          if (!ImagePreviewUI.q(ImagePreviewUI.this))
          {
            com.tencent.mm.plugin.gallery.a.d.swap(ImagePreviewUI.s(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
            d locald = ImagePreviewUI.h(ImagePreviewUI.this);
            int i = ImagePreviewUI.g(ImagePreviewUI.this).intValue();
            ad.i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt3) });
            if (!locald.tNv)
            {
              com.tencent.mm.plugin.gallery.a.d.swap(locald.tNu, paramAnonymousInt1, paramAnonymousInt2);
              locald.dLx = paramAnonymousInt3;
              locald.tNx = ((View)locald.JoS.get(i));
              locald.JoQ.remove(locald.tNx);
              locald.JoR.clear();
              locald.JoS.clear();
              locald.tNy = true;
              locald.notifyDataSetChanged();
            }
            ImagePreviewUI.r(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt3, false);
            ((g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter()).gk(paramAnonymousInt3, paramAnonymousInt3);
            com.tencent.mm.plugin.gallery.model.e.tGi = true;
            AppMethodBeat.o(111568);
            return;
          }
          com.tencent.mm.plugin.gallery.a.d.swap(ImagePreviewUI.d(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.plugin.gallery.model.e.tGg = true;
          AppMethodBeat.o(111568);
        }
        
        public final void gj(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(111567);
          ad.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ImagePreviewUI.g(ImagePreviewUI.this) });
          AppMethodBeat.o(111567);
        }
      };
      this.tOn = ((MMViewPager)findViewById(2131300335));
      this.tOn.setVerticalFadingEdgeEnabled(false);
      this.tOn.setHorizontalFadingEdgeEnabled(false);
      this.tOn.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt)
        {
          AppMethodBeat.i(111574);
          if (ImagePreviewUI.h(ImagePreviewUI.this) != null) {
            ImagePreviewUI.h(ImagePreviewUI.this).tNC.onPageScrollStateChanged(paramAnonymousInt);
          }
          AppMethodBeat.o(111574);
        }
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          boolean bool2 = true;
          AppMethodBeat.i(111573);
          com.tencent.mm.plugin.gallery.model.e.Hd(paramAnonymousInt);
          String str = ImagePreviewUI.h(ImagePreviewUI.this).getItem(paramAnonymousInt);
          ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousInt, str);
          boolean bool1 = ImagePreviewUI.d(ImagePreviewUI.this).contains(str);
          ImagePreviewUI.a(ImagePreviewUI.this, Integer.valueOf(paramAnonymousInt));
          Object localObject = ImagePreviewUI.e(ImagePreviewUI.this);
          int i;
          if (bool1)
          {
            i = ImagePreviewUI.cWn();
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
            ImagePreviewUI.h(ImagePreviewUI.this).tNB.onPageSelected(paramAnonymousInt);
            ad.d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = ".concat(String.valueOf(paramAnonymousInt)));
            localObject = com.tencent.mm.plugin.gallery.model.e.akQ(str);
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
      this.tOn.setSingleClickOverListener(new MMViewPager.e()
      {
        public final void aRp()
        {
          AppMethodBeat.i(111576);
          ImagePreviewUI.w(ImagePreviewUI.this);
          AppMethodBeat.o(111576);
        }
        
        public final void cWo() {}
      });
      this.tOm = new d(this);
      ((g)this.tOo.getAdapter()).tPf = this.tOm;
      if (this.tNv) {
        break label1729;
      }
      this.tOm.ae(this.tOp);
      this.tOm.tNv = false;
      if (this.tOp.size() <= 0) {
        break label1838;
      }
      localObject1 = (String)this.tOp.get(this.tOs.intValue());
    }
    for (;;)
    {
      this.tOn.setAdapter(this.tOm);
      this.tOn.setCurrentItem(this.tOs.intValue());
      this.tOm.dfG = this.tOs.intValue();
      i = cWj().indexOf(this.tOm.getItem(this.tOs.intValue()));
      ((g)this.tOo.getAdapter()).gk(i, this.tOs.intValue());
      localObject2 = com.tencent.mm.plugin.gallery.model.e.akQ((String)localObject1);
      a((String)localObject1, (GalleryItem.MediaItem)localObject2);
      i((GalleryItem.MediaItem)localObject2);
      setMMTitle(this.tOs.intValue() + 1 + "/" + this.tOm.getCount());
      if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 25)
      {
        ((ViewGroup)this.tOo.getParent()).removeView(this.tOo);
        this.tOo.setVisibility(8);
        findViewById(2131303094).setVisibility(4);
        findViewById(2131300340).setVisibility(4);
        findViewById(2131303244).setVisibility(4);
        findViewById(2131300338).setVisibility(4);
        findViewById(2131306334).setVisibility(4);
        findViewById(2131300339).setVisibility(4);
      }
      AppMethodBeat.o(111597);
      return;
      this.tOt.setImageResource(2131691077);
      break;
      label1688:
      bool1 = false;
      break label628;
      label1693:
      bool1 = false;
      break label649;
      label1698:
      if (com.tencent.mm.plugin.gallery.model.e.cUM().kTx != 25) {
        break label872;
      }
      localObject1 = s.b.Jcd;
      break label872;
      label1717:
      this.tOo.setVisibility(8);
      break label1237;
      label1729:
      localObject1 = this.tOm;
      localObject2 = this.tLn;
      ((d)localObject1).tLn.clear();
      ((d)localObject1).tLn.addAll((Collection)localObject2);
      ((d)localObject1).reset();
      ((d)localObject1).notifyDataSetChanged();
      this.tOm.tNv = true;
      if (this.tOs.intValue() >= this.tLn.size()) {
        this.tOs = Integer.valueOf(0);
      }
      if (this.tLn.size() > 0) {
        localObject1 = ((GalleryItem.MediaItem)this.tLn.get(this.tOs.intValue())).tGS;
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
    ad.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
    if (paramInt1 == 4371) {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    Object localObject;
    while (paramInt1 == 4372) {
      if ((paramIntent == null) || (this.tOo == null))
      {
        AppMethodBeat.o(111599);
        return;
        if (this.tOq.size() > 0)
        {
          akY((String)this.tOq.get(0));
        }
        else
        {
          ad.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[] { Integer.valueOf(this.tOq.size()) });
          continue;
          if (paramInt1 == 4370)
          {
            if (paramInt2 == -1)
            {
              localObject = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
              paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).videoPath);
              paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).thumbPath);
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject).dFF().v("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
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
        ArrayList localArrayList4 = ((g)this.tOo.getAdapter()).tPh;
        ArrayList localArrayList3 = this.tOq;
        this.tOP = (this.tOP + localCaptureVideoNormalModel.dFF().v("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)) + ";");
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
          if (!str.equalsIgnoreCase(bt.nullAsNil(this.path)))
          {
            localObject = str;
            if (!str.equalsIgnoreCase(bt.nullAsNil(this.tOO))) {}
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
          if (!str.equalsIgnoreCase(bt.nullAsNil(this.path)))
          {
            localObject = str;
            if (!str.equalsIgnoreCase(bt.nullAsNil(this.tOO))) {}
          }
          else
          {
            localObject = localCaptureVideoNormalModel.thumbPath;
          }
          localArrayList2.add(localObject);
          i += 1;
        }
        com.tencent.mm.vfs.i.deleteFile(this.tOO);
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
        if (this.tMa)
        {
          paramIntent = RecordConfigProvider.iJ("", "");
          paramIntent.xyt = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
          paramIntent.scene = 2;
          localObject = new VideoCaptureReportInfo();
          ((VideoCaptureReportInfo)localObject).rgD = 1;
          paramIntent.xyB = ((VideoCaptureReportInfo)localObject);
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).aby();
          ((UICustomParam.a)localObject).abx();
          ((UICustomParam.a)localObject).cP(true);
          paramIntent.xyk = ((UICustomParam.a)localObject).gei;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4370, 2130772137, -1, paramIntent, 4, 0);
          AppMethodBeat.o(111599);
          return;
        }
        if (22 == com.tencent.mm.plugin.gallery.model.e.cUM().kTx)
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
    final long l = bt.HI();
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    new ap().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111559);
        ImagePreviewUI.a(ImagePreviewUI.this, true);
        ad.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", new Object[] { Long.valueOf(bt.aO(l)) });
        AppMethodBeat.o(111559);
      }
    });
    ad.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", new Object[] { Long.valueOf(bt.aO(l)) });
    initView();
    AppMethodBeat.o(111593);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111607);
    super.onDestroy();
    ad.i("MicroMsg.ImagePreviewUI", "onDestroy, %s.", new Object[] { this });
    if ((com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 3) && (getIntent().getBooleanExtra("preview_image", false)) && (getIntent().getIntExtra("max_select_count", 0) == 1))
    {
      ad.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
      com.tencent.mm.plugin.gallery.model.e.cUP().clear();
    }
    if (this.tOm != null) {
      this.tOm.release();
    }
    com.tencent.mm.plugin.gallery.model.e.aa(null);
    y.cRM.JX().JW();
    if (this.tON != null) {
      com.tencent.mm.plugin.gallery.model.e.cUL().b(this.tON);
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
    if (this.tOv != null) {
      this.tOv.stopTimer();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI
 * JD-Core Version:    0.7.0.1
 */