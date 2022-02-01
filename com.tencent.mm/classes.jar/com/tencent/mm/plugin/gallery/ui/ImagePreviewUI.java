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
import android.support.v7.widget.RecyclerView.s;
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
import com.tencent.mm.compatible.d.b;
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
import com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.e;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.r.b;
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
  private int iBF;
  private boolean nMQ;
  private String path;
  private int qXm;
  private ArrayList<GalleryItem.MediaItem> rGU;
  private String rGX;
  private TextView rHB;
  private boolean rHH;
  private boolean rHI;
  private boolean rHK;
  private boolean rHL;
  private long rHR;
  private int rHU;
  private HashMap<String, Integer> rIh;
  private HashSet<String> rIi;
  private d rJT;
  private MMViewPager rJU;
  private RecyclerView rJV;
  private ArrayList<String> rJW;
  private ArrayList<String> rJX;
  private ArrayList<GalleryItem.MediaItem> rJY;
  private Integer rJZ;
  private boolean rJc;
  private String rKA;
  private ImageButton rKa;
  private TextView rKb;
  private av rKc;
  private ImageButton rKd;
  private TextView rKe;
  private ViewGroup rKf;
  private ViewGroup rKg;
  private boolean rKh;
  private boolean rKi;
  private int rKj;
  private int rKk;
  private TextView rKl;
  private TextView rKm;
  private TextView rKn;
  private TextView rKo;
  private View rKp;
  private TextView rKq;
  private ProgressBar rKr;
  private boolean rKs;
  boolean rKt;
  private d.b rKu;
  private String rKv;
  private String rKw;
  private int rKx;
  private String rKy;
  private int rKz;
  
  public ImagePreviewUI()
  {
    AppMethodBeat.i(111592);
    this.rKh = true;
    this.rKi = true;
    this.rHH = true;
    this.rKj = 0;
    this.rHR = 0L;
    this.rKk = 10;
    this.rKs = false;
    this.rKt = false;
    this.rKu = null;
    this.rKw = "";
    this.rIh = new HashMap();
    this.rKx = 300000;
    this.rKz = 1000;
    AppMethodBeat.o(111592);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111608);
    boolean bool;
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || ((com.tencent.mm.plugin.gallery.model.e.czh().jWF != 4) && (com.tencent.mm.plugin.gallery.model.e.czh().jWF != 14) && (com.tencent.mm.plugin.gallery.model.e.czh().jWF != 13)))
    {
      this.rKh = true;
      this.rKf.setVisibility(0);
      this.rKg.setVisibility(8);
      this.rKr.setVisibility(8);
      a(paramString, paramMediaItem, false);
      abN(paramString);
      enableOptionMenu(true);
      this.rKb.setVisibility(8);
      if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
        this.rKl.setVisibility(0);
      }
      for (;;)
      {
        if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 15) {
          this.rKl.setVisibility(8);
        }
        if (this.rHI) {
          this.rKl.setVisibility(8);
        }
        abL(paramString);
        AppMethodBeat.o(111608);
        return;
        bool = getIntent().getBooleanExtra("preview_image", false);
        ad.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.gallery.model.e.czh().jWF), Boolean.valueOf(bool), paramString });
        if ((paramMediaItem == null) && (!bt.isNullOrNil(paramString))) {
          this.rKl.setVisibility(0);
        } else {
          this.rKl.setVisibility(8);
        }
      }
    }
    if ((paramMediaItem != null) && (paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
      this.rKl.setVisibility(0);
    }
    final GalleryItem.VideoMediaItem localVideoMediaItem;
    for (;;)
    {
      if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 25) {
        this.rKl.setVisibility(8);
      }
      abL(paramString);
      localVideoMediaItem = (GalleryItem.VideoMediaItem)paramMediaItem;
      enableOptionMenu(false);
      this.rKh = false;
      this.rKf.setVisibility(8);
      this.rKg.setVisibility(0);
      this.rKq.setVisibility(8);
      if (!abM(paramString)) {
        break;
      }
      AppMethodBeat.o(111608);
      return;
      this.rKl.setVisibility(8);
    }
    if (!bt.isNullOrNil(localVideoMediaItem.hsS))
    {
      ad.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.rBp, Integer.valueOf(localVideoMediaItem.hsU), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
      bool = a(paramString, localVideoMediaItem, this.rKs);
      a(this.rKs, bool, localVideoMediaItem);
      AppMethodBeat.o(111608);
      return;
    }
    enableOptionMenu(false);
    this.rKh = true;
    this.rKf.setVisibility(0);
    this.rKg.setVisibility(8);
    this.rKb.setVisibility(8);
    a(paramString, paramMediaItem, false);
    abN(paramString);
    paramMediaItem = new com.tencent.mm.plugin.gallery.model.t(paramString, this.rJZ.intValue(), localVideoMediaItem, new t.a()
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
        boolean bool = ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymoust.path, paramAnonymoust.rCu, ImagePreviewUI.z(ImagePreviewUI.this));
        ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.z(ImagePreviewUI.this), bool, localVideoMediaItem);
        AppMethodBeat.o(111579);
      }
    });
    if (paramMediaItem.equals(this.rKr.getTag()))
    {
      ad.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { paramString });
      AppMethodBeat.o(111608);
      return;
    }
    this.rKr.setTag(paramMediaItem);
    com.tencent.e.h.Iye.aP(paramMediaItem);
    if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 15) {
      this.rKl.setVisibility(8);
    }
    if (this.rHI) {
      this.rKl.setVisibility(8);
    }
    AppMethodBeat.o(111608);
  }
  
  private void a(String paramString, GalleryItem.MediaItem paramMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111619);
    if ((paramMediaItem == null) || (paramMediaItem.getType() != 2) || (com.tencent.mm.plugin.gallery.model.e.czh().jWF != 4) || (paramBoolean))
    {
      if (this.qXm == 1)
      {
        this.rKd.setVisibility(8);
        this.rKe.setVisibility(8);
      }
      while (!this.rJX.contains(paramString))
      {
        this.rKd.setImageResource(2131691077);
        AppMethodBeat.o(111619);
        return;
        this.rKd.setVisibility(0);
        this.rKe.setVisibility(0);
      }
      this.rKd.setImageResource(cAJ());
      AppMethodBeat.o(111619);
      return;
    }
    this.rKd.setVisibility(8);
    this.rKe.setVisibility(8);
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
    if ((paramBoolean1) && (com.tencent.mm.plugin.gallery.a.d.V(this.rJY)))
    {
      this.rKq.setVisibility(8);
      this.rKb.setVisibility(8);
      this.rKg.setVisibility(8);
      enableOptionMenu(true);
      a(this.path, paramMediaItem, paramBoolean1);
    }
    AppMethodBeat.o(111609);
  }
  
  private boolean a(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111614);
    ad.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[] { Integer.valueOf(paramVideoMediaItem.hsU) });
    if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 13)
    {
      AppMethodBeat.o(111614);
      return false;
    }
    if (paramVideoMediaItem.hsU <= 1000)
    {
      this.rKm.setText(getString(2131759798));
      this.rKn.setText(getString(2131759797));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.hsU >= 300000)
    {
      this.rKm.setText(getString(2131759796));
      this.rKn.setText(getString(2131759795));
      AppMethodBeat.o(111614);
      return true;
    }
    if (paramVideoMediaItem.hsU >= this.rKk * 1000 + 500)
    {
      this.rKm.setText(getString(2131759781));
      this.rKn.setText(getString(2131759780, new Object[] { Integer.valueOf(this.rKk) }));
      this.rKq.setVisibility(0);
      AppMethodBeat.o(111614);
      return true;
    }
    AppMethodBeat.o(111614);
    return false;
  }
  
  private boolean a(String paramString, GalleryItem.VideoMediaItem paramVideoMediaItem, boolean paramBoolean)
  {
    AppMethodBeat.i(111611);
    enableOptionMenu(false);
    this.rKh = false;
    this.rKf.setVisibility(8);
    this.rKg.setVisibility(0);
    this.rKq.setVisibility(8);
    if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 13)
    {
      this.rKg.setVisibility(8);
      this.rKf.setVisibility(8);
      this.rKm.setVisibility(8);
      this.rKn.setVisibility(8);
      enableOptionMenu(true);
      AppMethodBeat.o(111611);
      return true;
    }
    if (b(paramVideoMediaItem))
    {
      AppMethodBeat.o(111611);
      return false;
    }
    if (c(paramVideoMediaItem))
    {
      AppMethodBeat.o(111611);
      return false;
    }
    if ((!paramBoolean) && (a(paramVideoMediaItem)))
    {
      AppMethodBeat.o(111611);
      return false;
    }
    enableOptionMenu(true);
    this.rKh = true;
    this.rKf.setVisibility(0);
    this.rKg.setVisibility(8);
    this.rKb.setVisibility(0);
    this.rKr.setVisibility(8);
    a(paramString, paramVideoMediaItem, false);
    abN(paramString);
    AppMethodBeat.o(111611);
    return true;
  }
  
  private boolean abI(String paramString)
  {
    AppMethodBeat.i(111618);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111618);
      return true;
    }
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
    paramString = paramString.trim();
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length()))
    {
      AppMethodBeat.o(111618);
      return true;
    }
    if (!this.rIi.contains(paramString.substring(i).toLowerCase()))
    {
      AppMethodBeat.o(111618);
      return true;
    }
    AppMethodBeat.o(111618);
    return false;
  }
  
  private void abK(String paramString)
  {
    AppMethodBeat.i(111598);
    Object localObject1;
    Object localObject2;
    int i;
    label459:
    Object localObject3;
    if (!this.rJX.contains(paramString))
    {
      if (this.rJX.size() >= this.qXm)
      {
        localObject1 = getResources().getQuantityString(2131623950, this.qXm, new Object[] { Integer.valueOf(this.qXm) });
        paramString = (String)localObject1;
        if (!bt.isNullOrNil(this.rGX))
        {
          paramString = (String)localObject1;
          if (this.rGX.equals("album_business_bubble_media_by_coordinate")) {
            paramString = getResources().getQuantityString(2131623951, this.qXm, new Object[] { Integer.valueOf(this.qXm) });
          }
        }
        com.tencent.mm.ui.base.h.cf(getContext(), paramString);
        this.rKd.setImageResource(2131691077);
        if (!bt.gL(this.rJX)) {
          break label700;
        }
        AppMethodBeat.o(111598);
        return;
      }
      localObject1 = com.tencent.mm.plugin.gallery.model.e.abA(paramString);
      if (localObject1 != null)
      {
        if ((((GalleryItem.MediaItem)localObject1).mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().TM(paramString)))
        {
          com.tencent.mm.ui.base.h.cf(this, getString(2131759800));
          AppMethodBeat.o(111598);
          return;
        }
        if ((localObject1 instanceof GalleryItem.VideoMediaItem)) {
          if ((!bt.isNullOrNil(this.rGX)) && (this.rGX.equals("album_business_bubble_media_by_coordinate")))
          {
            if (((GalleryItem.VideoMediaItem)localObject1).hsU >= this.iBF * 1000 + 500)
            {
              com.tencent.mm.ui.base.h.cf(getContext(), getContext().getResources().getString(2131759822, new Object[] { Integer.valueOf(this.iBF) }));
              AppMethodBeat.o(111598);
            }
          }
          else if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 25)
          {
            if (((GalleryItem.VideoMediaItem)localObject1).hsU > this.iBF * 1000)
            {
              com.tencent.mm.ui.base.h.cf(getContext(), getContext().getResources().getString(2131759822, new Object[] { Integer.valueOf(this.iBF) }));
              AppMethodBeat.o(111598);
              return;
            }
            if (((GalleryItem.VideoMediaItem)localObject1).hsU < this.rHU * 1000)
            {
              com.tencent.mm.ui.base.h.cf(getContext(), getContext().getResources().getString(2131759821, new Object[] { Integer.valueOf(this.rHU) }));
              AppMethodBeat.o(111598);
              return;
            }
          }
        }
        if (this.rJY != null)
        {
          localObject2 = this.rJY.iterator();
          i = 0;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
            if ((localObject3 == null) || (!((GalleryItem.MediaItem)localObject3).rBp.equalsIgnoreCase(((GalleryItem.MediaItem)localObject1).rBp))) {
              break label754;
            }
            i = 1;
          }
        }
      }
    }
    label600:
    label751:
    label754:
    for (;;)
    {
      break label459;
      if (i == 0) {
        this.rJY.add(localObject1);
      }
      this.rJX.add(paramString);
      this.rKd.setImageResource(cAJ());
      c(this.rJX.size(), this.rJZ.intValue(), paramString, 0);
      break;
      this.rKd.setImageResource(2131691077);
      while (this.rJX.remove(paramString)) {}
      if (this.rJY != null)
      {
        localObject1 = null;
        localObject3 = this.rJY.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
          if ((localObject2 == null) || (!((GalleryItem.MediaItem)localObject2).rBp.equalsIgnoreCase(paramString))) {
            break label751;
          }
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        break label600;
        if (localObject1 != null)
        {
          ad.i("MicroMsg.ImagePreviewUI", "unselect item: %s", new Object[] { ((GalleryItem.MediaItem)localObject1).rBp });
          this.rJY.remove(localObject1);
        }
        c(this.rJX.size(), this.rJZ.intValue(), paramString, 1);
        break;
        paramString = this.rJX.iterator();
        while (paramString.hasNext()) {
          if (!com.tencent.mm.sdk.platformtools.t.aFm((String)paramString.next()))
          {
            AppMethodBeat.o(111598);
            return;
          }
        }
        this.nMQ = true;
        AppMethodBeat.o(111598);
        return;
      }
    }
  }
  
  private void abL(String paramString)
  {
    AppMethodBeat.i(111610);
    if ((this.rJX.size() >= 9) && (!this.rJX.contains(paramString)))
    {
      this.rKl.setTextColor(getContext().getResources().getColor(2131101183));
      this.rKl.setEnabled(false);
      AppMethodBeat.o(111610);
      return;
    }
    this.rKl.setEnabled(true);
    this.rKl.setTextColor(getContext().getResources().getColor(2131101182));
    AppMethodBeat.o(111610);
  }
  
  private boolean abM(String paramString)
  {
    AppMethodBeat.i(111613);
    if (com.tencent.mm.vfs.i.aMN(paramString) > 1073741824L)
    {
      this.rKm.setText(getString(2131759794));
      this.rKn.setText(getString(2131759793));
      AppMethodBeat.o(111613);
      return true;
    }
    AppMethodBeat.o(111613);
    return false;
  }
  
  private void abN(String paramString)
  {
    AppMethodBeat.i(111620);
    Object localObject = Boolean.FALSE;
    Boolean localBoolean;
    GalleryItem.MediaItem localMediaItem;
    switch (com.tencent.mm.plugin.gallery.model.e.czh().jWF)
    {
    default: 
      localBoolean = Boolean.FALSE;
      localMediaItem = com.tencent.mm.plugin.gallery.model.e.abA(paramString);
      localObject = localBoolean;
      if (localMediaItem != null)
      {
        localObject = localBoolean;
        if (localMediaItem.getType() == 2) {
          localObject = Boolean.TRUE;
        }
      }
      if ((localMediaItem == null) && (com.tencent.mm.sdk.platformtools.t.aFm(paramString))) {
        paramString = Boolean.TRUE;
      }
      break;
    }
    for (;;)
    {
      if ((!paramString.booleanValue()) || (this.rHK)) {
        break label192;
      }
      this.rKa.setVisibility(8);
      this.rHB.setVisibility(8);
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
    this.rKa.setVisibility(0);
    this.rHB.setVisibility(0);
    AppMethodBeat.o(111620);
  }
  
  private boolean b(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111616);
    if ((paramVideoMediaItem == null) || (paramVideoMediaItem.videoWidth <= 0) || (paramVideoMediaItem.videoHeight <= 0) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight > 3.0F) || (paramVideoMediaItem.videoWidth / paramVideoMediaItem.videoHeight < 0.3F))
    {
      if (paramVideoMediaItem != null) {
        ad.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramVideoMediaItem.videoWidth), Integer.valueOf(paramVideoMediaItem.videoHeight) });
      }
      this.rKm.setText(getString(2131759791));
      this.rKn.setText(getString(2131759792));
      AppMethodBeat.o(111616);
      return true;
    }
    AppMethodBeat.o(111616);
    return false;
  }
  
  private void c(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(111621);
    ad.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((-1 != paramInt2) && (!this.rJc))
    {
      this.rJV.getAdapter().b(paramInt2, Integer.valueOf(paramInt2));
      if (com.tencent.mm.plugin.gallery.model.e.czh().jWF != 13) {
        break label356;
      }
      paramInt2 = 1;
      label72:
      paramString = this.rJT.Eh(this.rJZ.intValue());
      if ((paramInt1 != 0) && (((!this.rHH) || (this.rKs)) && ((paramInt2 == 0) || (this.rJT == null) || (paramString == null) || (paramString.getType() != 2)))) {
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
      this.rJV.setVisibility(8);
      AppMethodBeat.o(111621);
      return;
      if (-1 == paramInt2) {
        break;
      }
      if ((paramInt3 == 0) && (paramInt1 > 0))
      {
        ((g)this.rJV.getAdapter()).abO(paramString);
        ((g)this.rJV.getAdapter()).fN(paramInt1 - 1, this.rJZ.intValue());
        this.rJV.getAdapter().cl(paramInt1 - 1);
        paramString = this.rJV;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt1 - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramString, locala.adn(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramString.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        break;
      }
      if (paramInt3 != 1) {
        break;
      }
      paramInt2 = ((g)this.rJV.getAdapter()).indexOf(paramString);
      if (-1 == paramInt2) {
        break;
      }
      ((g)this.rJV.getAdapter()).remove(paramInt2);
      this.rJV.getAdapter().cm(paramInt2);
      break;
      paramInt2 = 0;
      break label72;
    }
    label366:
    this.rJV.setVisibility(0);
    AppMethodBeat.o(111621);
  }
  
  private boolean c(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(111617);
    ad.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[] { paramVideoMediaItem });
    int i;
    if (paramVideoMediaItem != null) {
      if (("video/hevc".equalsIgnoreCase(paramVideoMediaItem.hsS)) && (com.tencent.mm.plugin.o.f.cPl())) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((paramVideoMediaItem == null) || (bt.isNullOrNil(paramVideoMediaItem.rBp)) || (abI(paramVideoMediaItem.rBp)) || (i == 0) || ((!bt.isNullOrNil(paramVideoMediaItem.hsT)) && (!"audio/mp4a-latm".equalsIgnoreCase(paramVideoMediaItem.hsT))))
      {
        if (paramVideoMediaItem == null) {}
        for (paramVideoMediaItem = null;; paramVideoMediaItem = paramVideoMediaItem.hsS)
        {
          ad.i("MicroMsg.ImagePreviewUI", "check video format failed, dst format [video/avc], video format [%s]", new Object[] { paramVideoMediaItem });
          cAI();
          AppMethodBeat.o(111617);
          return true;
          if (!"video/avc".equalsIgnoreCase(paramVideoMediaItem.hsS)) {
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
  
  private String cAG()
  {
    AppMethodBeat.i(111601);
    switch (com.tencent.mm.plugin.gallery.model.e.czh().jWF)
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
      if ((this.rJX.size() == 0) || (this.qXm <= 1))
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
      if ((this.rKs) && (com.tencent.mm.plugin.gallery.a.d.V(this.rJY)))
      {
        str = getString(2131759788) + "(" + this.rJX.size() + "/" + this.qXm + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.rJX.size() == 0) || (this.qXm <= 1))
      {
        str = getString(2131759785);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(2131759785) + "(" + this.rJX.size() + "/" + this.qXm + ")";
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
      if (((!bt.isNullOrNil(this.rGX)) && (this.rGX.equals("album_business_bubble_media_by_coordinate"))) || (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 25))
      {
        if ((this.rJX.size() == 0) || (this.qXm <= 1))
        {
          str = getString(2131755830);
          AppMethodBeat.o(111601);
          return str;
        }
        str = getString(2131755830) + "(" + this.rJX.size() + "/" + this.qXm + ")";
        AppMethodBeat.o(111601);
        return str;
      }
      if ((this.rJX.size() == 0) || (this.qXm <= 1))
      {
        str = getString(2131759785);
        AppMethodBeat.o(111601);
        return str;
      }
      str = getString(2131759785) + "(" + this.rJX.size() + "/" + this.qXm + ")";
      AppMethodBeat.o(111601);
      return str;
    }
    String str = getString(2131759775, new Object[] { Integer.valueOf(this.rJX.size()), Integer.valueOf(this.qXm) });
    AppMethodBeat.o(111601);
    return str;
  }
  
  private ArrayList<String> cAH()
  {
    AppMethodBeat.i(111602);
    if (this.rJc)
    {
      localArrayList = this.rJX;
      AppMethodBeat.o(111602);
      return localArrayList;
    }
    if (this.rJX != null)
    {
      localArrayList = new ArrayList(this.rJX.size());
      Iterator localIterator = this.rJW.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.rJX.contains(str)) {
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
  
  private boolean cAI()
  {
    AppMethodBeat.i(111615);
    this.rKm.setText(getString(2131759789));
    this.rKn.setText(getString(2131759790));
    AppMethodBeat.o(111615);
    return true;
  }
  
  private static int cAJ()
  {
    AppMethodBeat.i(111622);
    if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 15)
    {
      AppMethodBeat.o(111622);
      return 2131689937;
    }
    AppMethodBeat.o(111622);
    return 2131689936;
  }
  
  private void d(int paramInt, final Intent paramIntent)
  {
    AppMethodBeat.i(111600);
    if ((paramInt == -1) && (paramIntent != null))
    {
      this.rKt = true;
      Object localObject2 = paramIntent.getStringExtra("raw_photo_path");
      Object localObject1 = com.tencent.mm.plugin.gallery.model.e.czl().iterator();
      while ((localObject2 != null) && (((Iterator)localObject1).hasNext())) {
        if (((String)localObject2).equals(((Bundle)((Iterator)localObject1).next()).getString("raw_photo_path"))) {
          ((Iterator)localObject1).remove();
        }
      }
      com.tencent.mm.plugin.gallery.model.e.czl().add(paramIntent.getBundleExtra("report_info"));
      localObject1 = paramIntent.getStringExtra("after_photo_edit");
      String str = paramIntent.getStringExtra("tmp_photo_edit");
      ad.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { localObject2, localObject1 });
      if (this.rJW != null)
      {
        this.rJW.clear();
        Object localObject3 = paramIntent.getStringArrayListExtra("preview_image_list");
        if (localObject3 != null) {
          this.rJW.addAll((Collection)localObject3);
        }
        localObject3 = this.rJT.Eh(this.rJZ.intValue());
        if (localObject3 == null)
        {
          ad.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[] { this.rJZ, localObject2, localObject1 });
          AppMethodBeat.o(111600);
          return;
        }
        ((GalleryItem.MediaItem)localObject3).rBq = ((String)localObject2);
        ((GalleryItem.MediaItem)localObject3).rBp = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).pUe = ((String)localObject1);
        ((GalleryItem.MediaItem)localObject3).rBr = str;
        ((GalleryItem.MediaItem)localObject3).mMimeType = "edit";
        com.tencent.mm.plugin.gallery.model.e.czk().add(localObject3);
        if (this.rKu != null) {
          com.tencent.mm.plugin.gallery.model.e.czg().b(this.rKu);
        }
        localObject2 = com.tencent.mm.plugin.gallery.model.e.czg();
        paramIntent = new d.b()
        {
          public final void abz(final String paramAnonymousString)
          {
            AppMethodBeat.i(111571);
            new ap(ImagePreviewUI.this.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111570);
                ImagePreviewUI.h(ImagePreviewUI.this).U(ImagePreviewUI.s(ImagePreviewUI.this));
                Object localObject = (g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter();
                ArrayList localArrayList = ImagePreviewUI.s(ImagePreviewUI.this);
                ((g)localObject).rKO.clear();
                ((g)localObject).rKO.addAll(localArrayList);
                ((RecyclerView.a)localObject).aql.notifyChanged();
                localObject = ImagePreviewUI.10.this.val$data.getStringArrayListExtra("preview_select_image_list");
                ImagePreviewUI.d(ImagePreviewUI.this).clear();
                if (localObject != null) {
                  ImagePreviewUI.d(ImagePreviewUI.this).addAll((Collection)localObject);
                }
                ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
                ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131759782) + ImagePreviewUI.cAK());
                if (!ImagePreviewUI.d(ImagePreviewUI.this).contains(com.tencent.mm.plugin.gallery.a.d.abS(paramAnonymousString))) {
                  ImagePreviewUI.e(ImagePreviewUI.this).performClick();
                }
                AppMethodBeat.o(111570);
              }
            });
            com.tencent.mm.plugin.gallery.model.e.czg().b(this);
            AppMethodBeat.o(111571);
          }
          
          public final String czd()
          {
            AppMethodBeat.i(179472);
            String str = com.tencent.mm.plugin.gallery.a.d.a(this.rKD, null, -1);
            AppMethodBeat.o(179472);
            return str;
          }
          
          public final String toString()
          {
            AppMethodBeat.i(111572);
            String str = "fileKey:" + this.rKD + " this: " + super.toString();
            AppMethodBeat.o(111572);
            return str;
          }
        };
        this.rKu = paramIntent;
        ((com.tencent.mm.plugin.gallery.model.c)localObject2).a(paramIntent);
        com.tencent.mm.plugin.gallery.model.e.czg().a((String)localObject1, ((GalleryItem.MediaItem)localObject3).getType(), (String)localObject1, ((GalleryItem.MediaItem)localObject3).rBs, ((GalleryItem.MediaItem)localObject3).rBt);
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
    if (!this.nMQ)
    {
      bool1 = true;
      if (!this.rHH) {
        break label89;
      }
      bool1 = bool2;
    }
    label89:
    for (;;)
    {
      localIntent.putExtra("CropImage_Compress_Img", bool1);
      localIntent.putStringArrayListExtra("preview_image_list", cAH());
      localIntent.putExtra("show_photo_edit_tip", this.rKt);
      setResult(0, localIntent);
      finish();
      AppMethodBeat.o(111605);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void h(GalleryItem.MediaItem paramMediaItem)
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
      this.rKx = 300000;
      this.rKy = getString(2131759795);
      this.rKz = 1000;
      this.rKA = getString(2131759797);
      if (((this.rGX != null) && ((this.rGX.equals("album_business_bubble_media_by_coordinate")) || (this.rGX.equals("album_business_bubble_media_by_jsapi_choosevideo")))) || (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 25))
      {
        this.rKx = (this.iBF * 1000 + 500);
        this.rKy = getString(2131759822, new Object[] { Integer.valueOf(this.iBF) });
        if (this.rHU != 0)
        {
          this.rKz = (this.rHU * 1000);
          this.rKA = getString(2131759821, new Object[] { Integer.valueOf(this.rHU) });
        }
      }
      if (!bt.isNullOrNil(localVideoMediaItem.hsS))
      {
        ad.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[] { localVideoMediaItem.rBp, Integer.valueOf(localVideoMediaItem.hsU), Integer.valueOf(localVideoMediaItem.videoHeight), Integer.valueOf(localVideoMediaItem.videoWidth) });
        if ((localVideoMediaItem.hsU >= this.rKx) || ((localVideoMediaItem.hsU > 0) && (localVideoMediaItem.hsU < this.rKz)))
        {
          this.rKp.setVisibility(0);
          localObject = this.rKo;
          if (localVideoMediaItem.hsU >= this.rKx) {}
          for (paramMediaItem = this.rKy;; paramMediaItem = this.rKA)
          {
            ((TextView)localObject).setText(paramMediaItem);
            this.rKe.setEnabled(false);
            this.rKd.setEnabled(false);
            this.rKe.setTextColor(getResources().getColor(2131101183));
            if (this.rJX.size() != 0) {
              break;
            }
            enableOptionMenu(false);
            AppMethodBeat.o(111612);
            return;
          }
        }
        this.rKe.setEnabled(true);
        this.rKd.setEnabled(true);
        this.rKe.setTextColor(getResources().getColor(2131101182));
        this.rKp.setVisibility(8);
        AppMethodBeat.o(111612);
        return;
      }
      paramMediaItem = new com.tencent.mm.plugin.gallery.model.t(paramMediaItem.rBp, this.rJZ.intValue(), localVideoMediaItem, new t.a()
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
          if (TextUtils.isEmpty(paramAnonymoust.rCu.hsS))
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
          if ((paramAnonymoust.rCu.hsU >= ImagePreviewUI.C(ImagePreviewUI.this)) || ((paramAnonymoust.rCu.hsU > 0) && (paramAnonymoust.rCu.hsU < ImagePreviewUI.D(ImagePreviewUI.this))))
          {
            ImagePreviewUI.a(ImagePreviewUI.this).setVisibility(0);
            TextView localTextView = ImagePreviewUI.A(ImagePreviewUI.this);
            if (paramAnonymoust.rCu.hsU >= ImagePreviewUI.C(ImagePreviewUI.this)) {}
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
      if (paramMediaItem.equals(this.rKr.getTag()))
      {
        ad.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[] { this.path });
        AppMethodBeat.o(111612);
        return;
      }
      this.rKr.setTag(paramMediaItem);
      com.tencent.e.h.Iye.aP(paramMediaItem);
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (!paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      this.rKe.setEnabled(true);
      this.rKd.setEnabled(true);
      this.rKe.setTextColor(getResources().getColor(2131101182));
      if ((this.nMQ) && (this.rJX.contains(paramMediaItem.rBp)) && (com.tencent.mm.vfs.i.aMN(paramMediaItem.rBp) > 26214400L))
      {
        this.rKp.setVisibility(0);
        this.rKo.setText(getString(2131759802));
        AppMethodBeat.o(111612);
        return;
      }
      this.rKp.setVisibility(8);
      AppMethodBeat.o(111612);
      return;
    }
    if ((paramMediaItem.getType() == 1) && (paramMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      localObject = new com.tencent.mm.plugin.gif.f(paramMediaItem.rBp);
      long l = com.tencent.mm.vfs.i.aMN(paramMediaItem.rBp);
      try
      {
        if (((!this.rJX.contains(paramMediaItem.rBp)) || (l == 0L) || (l <= com.tencent.mm.plugin.gallery.a.d.YJ())) && (localObject.spr[0] <= com.tencent.mm.plugin.gallery.a.d.YI()) && (localObject.spr[1] <= com.tencent.mm.plugin.gallery.a.d.YI())) {
          break label830;
        }
        this.rKe.setTextColor(getResources().getColor(2131101183));
        this.rKe.setEnabled(false);
        this.rKd.setEnabled(false);
        AppMethodBeat.o(111612);
        return;
      }
      catch (Exception paramMediaItem)
      {
        ad.e("MicroMsg.ImagePreviewUI", bt.m(paramMediaItem));
      }
    }
    else
    {
      AppMethodBeat.o(111612);
      return;
    }
    label830:
    this.rKe.setTextColor(getResources().getColor(2131101182));
    this.rKe.setEnabled(true);
    this.rKd.setEnabled(true);
    AppMethodBeat.o(111612);
  }
  
  private void lI(boolean paramBoolean)
  {
    AppMethodBeat.i(111603);
    if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 4)
    {
      AppMethodBeat.o(111603);
      return;
    }
    if (this.rJT == null)
    {
      ad.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
      AppMethodBeat.o(111603);
      return;
    }
    final GalleryItem.MediaItem localMediaItem = this.rJT.Eh(this.rJZ.intValue());
    if ((paramBoolean) && (localMediaItem != null))
    {
      this.rKp.postDelayed(new Runnable()
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
    this.rKp.setVisibility(8);
    AppMethodBeat.o(111603);
  }
  
  private void lJ(boolean paramBoolean)
  {
    AppMethodBeat.i(111604);
    ad.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + paramBoolean + "], selectedNormalFooter = " + this.rKh);
    if (this.rKh)
    {
      localObject = findViewById(2131298881);
      if (localObject != null) {
        break label134;
      }
      if (!this.rKh) {
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
      if (com.tencent.mm.plugin.gallery.model.e.czh().jWF != 15) {
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
    while ((paramBoolean) && (this.rJV.getVisibility() == 8) && (this.rJX.size() > 0))
    {
      this.rJV.setVisibility(0);
      localObject = AnimationUtils.loadAnimation(this, 2130772047);
      this.rJV.startAnimation((Animation)localObject);
      AppMethodBeat.o(111604);
      return;
      ((View)localObject).setVisibility(8);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(this, 2130772048));
    }
    if ((!paramBoolean) && (this.rJV.getVisibility() == 0))
    {
      this.rJV.setVisibility(8);
      localObject = AnimationUtils.loadAnimation(this, 2130772048);
      this.rJV.startAnimation((Animation)localObject);
    }
    AppMethodBeat.o(111604);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(111596);
    if (b.bX(this))
    {
      setContentView(paramView);
      AppMethodBeat.o(111596);
      return;
    }
    ai.l(ai.a(getWindow(), null), getBodyView());
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
    this.rKm = ((TextView)findViewById(2131300338));
    this.rKn = ((TextView)findViewById(2131300340));
    this.rKo = ((TextView)findViewById(2131301163));
    this.rKp = findViewById(2131301164);
    this.rKp.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111575);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)ImagePreviewUI.a(ImagePreviewUI.this).getLayoutParams();
        localMarginLayoutParams.topMargin = ((int)(com.tencent.mm.compatible.util.i.aQ(ImagePreviewUI.this) + ImagePreviewUI.this.getResources().getDimension(2131165252)));
        ImagePreviewUI.a(ImagePreviewUI.this).setLayoutParams(localMarginLayoutParams);
        AppMethodBeat.o(111575);
      }
    }, 100L);
    this.rKq = ((TextView)findViewById(2131300339));
    this.rKr = ((ProgressBar)findViewById(2131306335));
    this.qXm = getIntent().getIntExtra("max_select_count", 9);
    this.rKk = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
    Object localObject1;
    boolean bool2;
    if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 4)
    {
      bool1 = true;
      this.rHH = bool1;
      localObject1 = getIntent();
      this.rJW = ((Intent)localObject1).getStringArrayListExtra("preview_image_list");
      this.rJY = ((Intent)localObject1).getParcelableArrayListExtra("preview_media_item_list");
      this.rJX = new ArrayList();
      if (this.rJW != null) {
        this.rJX.addAll(this.rJW);
      }
      this.rGU = com.tencent.mm.plugin.gallery.model.e.czj();
      bool2 = ((Intent)localObject1).getBooleanExtra("preview_all", false);
      if (this.rGU != null) {
        break label422;
      }
    }
    label422:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.ImagePreviewUI", "preview all[%B] mediaitems is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((bool2) && (this.rGU != null))
      {
        this.rJc = true;
        this.rJZ = Integer.valueOf(((Intent)localObject1).getIntExtra("preview_position", 0));
        ad.i("MicroMsg.ImagePreviewUI", "start position=%d", new Object[] { this.rJZ });
        if (this.rJZ.intValue() >= 0) {}
      }
      else
      {
        this.rJZ = Integer.valueOf(0);
      }
      com.tencent.mm.plugin.gallery.model.e.DS(this.rJZ.intValue());
      if ((this.rJc) || ((this.rJX != null) && (this.rJX.size() != 0))) {
        break label427;
      }
      ad.e("MicroMsg.ImagePreviewUI", "not preview all items and image paths is null or empty");
      finish();
      AppMethodBeat.o(111597);
      return;
      bool1 = false;
      break;
    }
    label427:
    this.rKa = ((ImageButton)findViewById(2131303090));
    this.rHB = ((TextView)findViewById(2131303091));
    this.rKb = ((TextView)findViewById(2131306334));
    this.nMQ = ((Intent)localObject1).getBooleanExtra("send_raw_img", false);
    this.rHI = ((Intent)localObject1).getBooleanExtra("key_force_hide_edit_image_button", false);
    this.rHK = ((Intent)localObject1).getBooleanExtra("key_force_show_raw_image_button", false);
    this.rHL = ((Intent)localObject1).getBooleanExtra("key_is_raw_image_button_disable", false);
    this.rKj = ((Intent)localObject1).getIntExtra("query_source_type", 0);
    this.rKs = com.tencent.mm.plugin.gallery.a.d.cAU();
    ad.i("MicroMsg.ImagePreviewUI", "initView, enableVLog:%s", new Object[] { Boolean.valueOf(this.rKs) });
    Object localObject2;
    label612:
    label633:
    int i;
    if (this.nMQ)
    {
      this.rKa.setImageResource(2131691078);
      if (this.rHL) {
        this.rKa.setImageResource(2131691075);
      }
      localObject2 = this.rKa;
      if (this.rHL) {
        break label1672;
      }
      bool1 = true;
      ((ImageButton)localObject2).setEnabled(bool1);
      localObject2 = this.rHB;
      if (this.rHL) {
        break label1677;
      }
      bool1 = true;
      ((TextView)localObject2).setEnabled(bool1);
      if ((this.rJX != null) && (this.rJX.size() == 1))
      {
        localObject2 = (String)this.rJX.get(0);
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
      this.rHB.setText(getContext().getString(2131759782));
      this.rKa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111583);
          paramAnonymousView = ImagePreviewUI.this;
          boolean bool;
          if (!ImagePreviewUI.b(ImagePreviewUI.this))
          {
            bool = true;
            ImagePreviewUI.b(paramAnonymousView, bool);
            if (!ImagePreviewUI.b(ImagePreviewUI.this)) {
              break label143;
            }
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691078);
            if (ImagePreviewUI.d(ImagePreviewUI.this).size() == 0) {
              ImagePreviewUI.e(ImagePreviewUI.this).performClick();
            }
          }
          for (;;)
          {
            ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131759782) + ImagePreviewUI.cAK());
            ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            AppMethodBeat.o(111583);
            return;
            bool = false;
            break;
            label143:
            ImagePreviewUI.c(ImagePreviewUI.this).setImageResource(2131691077);
          }
        }
      });
      this.rKb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111584);
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bt.isNullOrNil(paramAnonymousView))
          {
            ad.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            AppMethodBeat.o(111584);
            return;
          }
          ad.i("MicroMsg.ImagePreviewUI", "editVideoMaxTimeLength : %d", new Object[] { Integer.valueOf(ImagePreviewUI.i(ImagePreviewUI.this)) });
          Object localObject = new StringBuilder();
          com.tencent.mm.modelvideo.o.aCH();
          localObject = com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
          StringBuilder localStringBuilder = new StringBuilder();
          com.tencent.mm.modelvideo.o.aCH();
          paramAnonymousView = RecordConfigProvider.aj(paramAnonymousView, (String)localObject, com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg");
          paramAnonymousView.vhH = com.tencent.mm.modelcontrol.d.awT().awW();
          paramAnonymousView.vhQ = (ImagePreviewUI.i(ImagePreviewUI.this) * 1000);
          paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.czh().jWF;
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).Ya();
          ((UICustomParam.a)localObject).XZ();
          ((UICustomParam.a)localObject).cO(true);
          paramAnonymousView.vhI = ((UICustomParam.a)localObject).fHa;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, 2130772137, -1, paramAnonymousView, 2, 0);
          AppMethodBeat.o(111584);
        }
      });
      this.rKq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111585);
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bt.isNullOrNil(paramAnonymousView))
          {
            ad.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            AppMethodBeat.o(111585);
            return;
          }
          Object localObject = new StringBuilder();
          com.tencent.mm.modelvideo.o.aCH();
          localObject = com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
          StringBuilder localStringBuilder = new StringBuilder();
          com.tencent.mm.modelvideo.o.aCH();
          paramAnonymousView = RecordConfigProvider.aj(paramAnonymousView, (String)localObject, com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg");
          paramAnonymousView.vhQ = (ImagePreviewUI.i(ImagePreviewUI.this) * 1000);
          paramAnonymousView.vhH = com.tencent.mm.modelcontrol.d.awT().awW();
          paramAnonymousView.scene = com.tencent.mm.plugin.gallery.model.e.czh().jWF;
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).Ya();
          ((UICustomParam.a)localObject).XZ();
          ((UICustomParam.a)localObject).cO(true);
          paramAnonymousView.vhI = ((UICustomParam.a)localObject).fHa;
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(ImagePreviewUI.this.getContext(), 4370, 2130772137, -1, paramAnonymousView, 2, 0);
          AppMethodBeat.o(111585);
        }
      });
      this.rHB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111586);
          ImagePreviewUI.c(ImagePreviewUI.this).performClick();
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
      this.rGX = ((Intent)localObject1).getStringExtra("album_business_tag");
      this.iBF = ((Intent)localObject1).getIntExtra("album_video_max_duration", 10);
      this.rHU = ((Intent)localObject1).getIntExtra("album_video_min_duration", 0);
      localObject1 = r.b.FON;
      if (com.tencent.mm.plugin.gallery.model.e.czh().jWF != 15) {
        break label1682;
      }
      localObject1 = r.b.FOL;
      label856:
      addTextOptionMenu(0, cAG(), new MenuItem.OnMenuItemClickListener()
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
              a.a.rzX.af(paramAnonymousMenuItem, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            }
            ImagePreviewUI.this.finish();
          }
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("isPreviewPhoto", ImagePreviewUI.this.getIntent().getBooleanExtra("isPreviewPhoto", false));
          Object localObject = ImagePreviewUI.l(ImagePreviewUI.this);
          int i;
          if ((localObject != null) && (((ArrayList)localObject).size() == 0))
          {
            localObject = ImagePreviewUI.h(ImagePreviewUI.this).Eh(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
            if ((ImagePreviewUI.m(ImagePreviewUI.this)) && (ImagePreviewUI.h(ImagePreviewUI.this) != null) && (localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 2))
            {
              ImagePreviewUI.a(ImagePreviewUI.this, ((GalleryItem.MediaItem)localObject).rBp);
              localObject = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              if (!bt.isNullOrNil((String)localObject)) {
                a.a.rzX.af((String)localObject, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
              }
              i = 0;
            }
          }
          for (;;)
          {
            if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 25)
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
            localObject = com.tencent.mm.plugin.gallery.model.e.czi();
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
              ((com.tencent.mm.plugin.gallery.model.g)localObject).czA().postDelayed(paramAnonymousMenuItem, i);
              AppMethodBeat.o(111590);
              return true;
            }
            i = 0;
          }
        }
      }, null, (r.b)localObject1);
      this.rKd = ((ImageButton)findViewById(2131303251));
      this.rKd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111591);
          paramAnonymousView = ImagePreviewUI.h(ImagePreviewUI.this).getItem(ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          if (bt.isNullOrNil(paramAnonymousView))
          {
            ad.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[] { ImagePreviewUI.g(ImagePreviewUI.this) });
            AppMethodBeat.o(111591);
            return;
          }
          ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousView);
          ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          ImagePreviewUI.f(ImagePreviewUI.this).setText(ImagePreviewUI.this.getContext().getString(2131759782) + ImagePreviewUI.cAK());
          ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
          a.a.rzX.af(paramAnonymousView, ImagePreviewUI.this.getIntent().getIntExtra("select_type_tag", 3), ImagePreviewUI.g(ImagePreviewUI.this).intValue());
          AppMethodBeat.o(111591);
        }
      });
      this.rKe = ((TextView)findViewById(2131303253));
      this.rKe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111560);
          ImagePreviewUI.e(ImagePreviewUI.this).performClick();
          AppMethodBeat.o(111560);
        }
      });
      if (this.qXm == 1)
      {
        this.rKd.setVisibility(8);
        this.rKe.setVisibility(8);
      }
      this.rKf = ((ViewGroup)findViewById(2131298881));
      this.rKg = ((ViewGroup)findViewById(2131300337));
      if (this.rKf != null)
      {
        this.rKf.setVisibility(8);
        this.rKf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(111561);
            AppMethodBeat.o(111561);
          }
        });
      }
      if (this.rKg != null)
      {
        this.rKg.setVisibility(8);
        this.rKg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(111562);
            AppMethodBeat.o(111562);
          }
        });
      }
      this.rKl = ((TextView)findViewById(2131303244));
      this.rKl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111563);
          ImagePreviewUI.o(ImagePreviewUI.this);
          AppMethodBeat.o(111563);
        }
      });
      this.rJV = ((RecyclerView)findViewById(2131300956));
      this.rJV.getItemAnimator().aqr = 66L;
      this.rJV.a(new RecyclerView.h()
      {
        public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
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
      this.rJV.setLayoutManager((RecyclerView.i)localObject1);
      i = getResources().getDisplayMetrics().widthPixels / 7;
      localObject1 = new g(this, this.rJX, i, this.rJc);
      this.rJV.setAdapter((RecyclerView.a)localObject1);
      this.rJV.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111565);
          int i = (int)aj.getContext().getResources().getDimension(2131165480);
          int j = ImagePreviewUI.this.getResources().getDisplayMetrics().widthPixels / 7;
          ImagePreviewUI.p(ImagePreviewUI.this).getLayoutParams().height = (i * 2 + j);
          RecyclerView localRecyclerView = ImagePreviewUI.p(ImagePreviewUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(ImagePreviewUI.g(ImagePreviewUI.this).intValue(), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$15", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          localRecyclerView.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$15", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(111565);
        }
      });
      if (this.rJX.size() <= 0) {
        break label1701;
      }
      this.rJV.setVisibility(0);
      label1221:
      this.rJV.setItemAnimator(new v());
      ((g)localObject1).rKS.j(this.rJV);
      ((g)localObject1).rKP = new g.b()
      {
        public final void Ek(int paramAnonymousInt)
        {
          AppMethodBeat.i(111566);
          ad.i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(ImagePreviewUI.q(ImagePreviewUI.this)) });
          ((g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter()).fN(paramAnonymousInt, paramAnonymousInt);
          ImagePreviewUI.r(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt, false);
          if (!ImagePreviewUI.q(ImagePreviewUI.this))
          {
            com.tencent.mm.plugin.gallery.model.e.rAG = true;
            AppMethodBeat.o(111566);
            return;
          }
          com.tencent.mm.plugin.gallery.model.e.rAE = true;
          AppMethodBeat.o(111566);
        }
        
        public final void ae(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(111568);
          ad.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), ImagePreviewUI.g(ImagePreviewUI.this) });
          if (!ImagePreviewUI.q(ImagePreviewUI.this))
          {
            com.tencent.mm.plugin.gallery.a.d.swap(ImagePreviewUI.s(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
            d locald = ImagePreviewUI.h(ImagePreviewUI.this);
            int i = ImagePreviewUI.g(ImagePreviewUI.this).intValue();
            ad.i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt3) });
            if (!locald.rJc)
            {
              com.tencent.mm.plugin.gallery.a.d.swap(locald.rJb, paramAnonymousInt1, paramAnonymousInt2);
              locald.dBx = paramAnonymousInt3;
              locald.rJe = ((View)locald.Gbm.get(i));
              locald.Gbk.remove(locald.rJe);
              locald.Gbl.clear();
              locald.Gbm.clear();
              locald.rJf = true;
              locald.notifyDataSetChanged();
            }
            ImagePreviewUI.r(ImagePreviewUI.this).setCurrentItem(paramAnonymousInt3, false);
            ((g)ImagePreviewUI.p(ImagePreviewUI.this).getAdapter()).fN(paramAnonymousInt3, paramAnonymousInt3);
            com.tencent.mm.plugin.gallery.model.e.rAF = true;
            AppMethodBeat.o(111568);
            return;
          }
          com.tencent.mm.plugin.gallery.a.d.swap(ImagePreviewUI.d(ImagePreviewUI.this), paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.plugin.gallery.model.e.rAD = true;
          AppMethodBeat.o(111568);
        }
        
        public final void fM(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(111567);
          ad.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ImagePreviewUI.g(ImagePreviewUI.this) });
          AppMethodBeat.o(111567);
        }
      };
      this.rJU = ((MMViewPager)findViewById(2131300335));
      this.rJU.setVerticalFadingEdgeEnabled(false);
      this.rJU.setHorizontalFadingEdgeEnabled(false);
      this.rJU.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt)
        {
          AppMethodBeat.i(111574);
          if (ImagePreviewUI.h(ImagePreviewUI.this) != null) {
            ImagePreviewUI.h(ImagePreviewUI.this).rJj.onPageScrollStateChanged(paramAnonymousInt);
          }
          AppMethodBeat.o(111574);
        }
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          boolean bool2 = true;
          AppMethodBeat.i(111573);
          com.tencent.mm.plugin.gallery.model.e.DS(paramAnonymousInt);
          String str = ImagePreviewUI.h(ImagePreviewUI.this).getItem(paramAnonymousInt);
          ImagePreviewUI.a(ImagePreviewUI.this, paramAnonymousInt, str);
          boolean bool1 = ImagePreviewUI.d(ImagePreviewUI.this).contains(str);
          ImagePreviewUI.a(ImagePreviewUI.this, Integer.valueOf(paramAnonymousInt));
          Object localObject = ImagePreviewUI.e(ImagePreviewUI.this);
          int i;
          if (bool1)
          {
            i = ImagePreviewUI.cAL();
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
            ImagePreviewUI.h(ImagePreviewUI.this).rJi.onPageSelected(paramAnonymousInt);
            ad.d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = ".concat(String.valueOf(paramAnonymousInt)));
            localObject = com.tencent.mm.plugin.gallery.model.e.abA(str);
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
      this.rJU.setSingleClickOverListener(new MMViewPager.e()
      {
        public final void aHo()
        {
          AppMethodBeat.i(111576);
          ImagePreviewUI.w(ImagePreviewUI.this);
          AppMethodBeat.o(111576);
        }
        
        public final void cAM() {}
      });
      this.rJT = new d(this);
      ((g)this.rJV.getAdapter()).rKM = this.rJT;
      if (this.rJc) {
        break label1713;
      }
      this.rJT.U(this.rJW);
      this.rJT.rJc = false;
      if (this.rJW.size() <= 0) {
        break label1822;
      }
      localObject1 = (String)this.rJW.get(this.rJZ.intValue());
    }
    for (;;)
    {
      this.rJU.setAdapter(this.rJT);
      this.rJU.setCurrentItem(this.rJZ.intValue());
      this.rJT.cWU = this.rJZ.intValue();
      i = cAH().indexOf(this.rJT.getItem(this.rJZ.intValue()));
      ((g)this.rJV.getAdapter()).fN(i, this.rJZ.intValue());
      localObject2 = com.tencent.mm.plugin.gallery.model.e.abA((String)localObject1);
      a((String)localObject1, (GalleryItem.MediaItem)localObject2);
      h((GalleryItem.MediaItem)localObject2);
      setMMTitle(this.rJZ.intValue() + 1 + "/" + this.rJT.getCount());
      if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 25)
      {
        ((ViewGroup)this.rJV.getParent()).removeView(this.rJV);
        this.rJV.setVisibility(8);
        findViewById(2131303094).setVisibility(4);
        findViewById(2131300340).setVisibility(4);
        findViewById(2131303244).setVisibility(4);
        findViewById(2131300338).setVisibility(4);
        findViewById(2131306334).setVisibility(4);
        findViewById(2131300339).setVisibility(4);
      }
      AppMethodBeat.o(111597);
      return;
      this.rKa.setImageResource(2131691077);
      break;
      label1672:
      bool1 = false;
      break label612;
      label1677:
      bool1 = false;
      break label633;
      label1682:
      if (com.tencent.mm.plugin.gallery.model.e.czh().jWF != 25) {
        break label856;
      }
      localObject1 = r.b.FOM;
      break label856;
      label1701:
      this.rJV.setVisibility(8);
      break label1221;
      label1713:
      localObject1 = this.rJT;
      localObject2 = this.rGU;
      ((d)localObject1).rGU.clear();
      ((d)localObject1).rGU.addAll((Collection)localObject2);
      ((d)localObject1).reset();
      ((d)localObject1).notifyDataSetChanged();
      this.rJT.rJc = true;
      if (this.rJZ.intValue() >= this.rGU.size()) {
        this.rJZ = Integer.valueOf(0);
      }
      if (this.rGU.size() > 0) {
        localObject1 = ((GalleryItem.MediaItem)this.rGU.get(this.rJZ.intValue())).rBp;
      } else {
        label1822:
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
      if ((paramIntent == null) || (this.rJV == null))
      {
        AppMethodBeat.o(111599);
        return;
        if (this.rJX.size() > 0)
        {
          abK((String)this.rJX.get(0));
        }
        else
        {
          ad.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[] { Integer.valueOf(this.rJX.size()) });
          continue;
          if (paramInt1 == 4370)
          {
            if (paramInt2 == -1)
            {
              localObject = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
              paramIntent.putExtra("K_SEGMENTVIDEOPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).videoPath);
              paramIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", ((CaptureDataManager.CaptureVideoNormalModel)localObject).thumbPath);
              paramIntent.putExtra("KSEGMENTMEDIAEDITID", ((CaptureDataManager.CaptureVideoNormalModel)localObject).dhD().w("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
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
        ArrayList localArrayList4 = ((g)this.rJV.getAdapter()).rKO;
        ArrayList localArrayList3 = this.rJX;
        this.rKw = (this.rKw + localCaptureVideoNormalModel.dhD().w("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)) + ";");
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
            if (!str.equalsIgnoreCase(bt.nullAsNil(this.rKv))) {}
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
            if (!str.equalsIgnoreCase(bt.nullAsNil(this.rKv))) {}
          }
          else
          {
            localObject = localCaptureVideoNormalModel.thumbPath;
          }
          localArrayList2.add(localObject);
          i += 1;
        }
        com.tencent.mm.vfs.i.deleteFile(this.rKv);
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
        AppMethodBeat.o(111599);
        return;
      }
    }
    if (paramInt1 == 4381)
    {
      if (paramInt2 == -1)
      {
        if (this.rHH)
        {
          paramIntent = RecordConfigProvider.id("", "");
          paramIntent.vhQ = (getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000);
          paramIntent.scene = 2;
          localObject = new VideoCaptureReportInfo();
          ((VideoCaptureReportInfo)localObject).pOf = 1;
          paramIntent.vhY = ((VideoCaptureReportInfo)localObject);
          localObject = new UICustomParam.a();
          ((UICustomParam.a)localObject).Ya();
          ((UICustomParam.a)localObject).XZ();
          ((UICustomParam.a)localObject).cO(true);
          paramIntent.vhI = ((UICustomParam.a)localObject).fHa;
          paramIntent.bx(3, VLogPreviewPluginLayout.class.getName());
          paramIntent.bx(4, VLogPreviewPluginLayout.class.getName());
          localObject = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
          com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4370, 2130772137, -1, paramIntent, 4, 0);
          AppMethodBeat.o(111599);
          return;
        }
        if (22 == com.tencent.mm.plugin.gallery.model.e.czh().jWF)
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
    final long l = bt.GC();
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    new ap().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111559);
        ImagePreviewUI.a(ImagePreviewUI.this, true);
        ad.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", new Object[] { Long.valueOf(bt.aS(l)) });
        AppMethodBeat.o(111559);
      }
    });
    ad.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", new Object[] { Long.valueOf(bt.aS(l)) });
    initView();
    AppMethodBeat.o(111593);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111607);
    super.onDestroy();
    ad.i("MicroMsg.ImagePreviewUI", "onDestroy, %s.", new Object[] { this });
    if ((com.tencent.mm.plugin.gallery.model.e.czh().jWF == 3) && (getIntent().getBooleanExtra("preview_image", false)) && (getIntent().getIntExtra("max_select_count", 0) == 1))
    {
      ad.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
      com.tencent.mm.plugin.gallery.model.e.czk().clear();
    }
    if (this.rJT != null) {
      this.rJT.release();
    }
    com.tencent.mm.plugin.gallery.model.e.Q(null);
    y.cJB.IO().IN();
    if (this.rKu != null) {
      com.tencent.mm.plugin.gallery.model.e.czg().b(this.rKu);
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
    if (this.rKc != null) {
      this.rKc.stopTimer();
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